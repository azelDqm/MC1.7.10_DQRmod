package dqr.entity.throwingEntity.throwing;

import io.netty.buffer.Unpooled;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.stats.StatList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomFishable;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.items.magicTool.DqmItemFishingRod;
import dqr.network.PacketHandlerClient;
import dqr.network.SToCMessage;

public class ThrowingEntityFishHook extends EntityFishHook {

	private int blockInX;
	private int blockInY;
	private int blockInZ;
	private Block blockIn;
	private boolean isInBlock;
	private int inBlockAge;
	private int inAirAge;
	private int field_146045_ax;
	private int field_146040_ay;
	private int field_146038_az;
	private float field_146054_aA;
	private int timeUntilReset;
	private double thisPosX;
	private double thisPosY;
	private double thisPosZ;
	private double thisYaw;
	private double thisPitch;
	@SideOnly(Side.CLIENT)
	private double clientMotionX;
	@SideOnly(Side.CLIENT)
	private double clientMotionY;
	@SideOnly(Side.CLIENT)
	private double clientMotionZ;
	private boolean field_146051_au;

	public int strain = 0;
	public ItemStack bait;
	public Item rodType = null;

	public ThrowingEntityFishHook(World world)
	{
		super(world);
		this.blockInX = -1;
		this.blockInY = -1;
		this.blockInZ = -1;
		this.setSize(0.25F, 0.25F);
		this.ignoreFrustumCheck = true;
		this.isImmuneToFire = true;
	}

	@SideOnly(Side.CLIENT)
	public ThrowingEntityFishHook(World world, double x, double y, double z, EntityPlayer player)
	{
		this(world);
		this.setPosition(x, y, z);
		this.ignoreFrustumCheck = true;
		this.field_146042_b = player;
		player.fishEntity = this;
	}

	public ThrowingEntityFishHook(World world, EntityPlayer player)
	{
		super(world, player);
		this.blockInX = -1;
		this.blockInY = -1;
		this.blockInZ = -1;
		this.isImmuneToFire = true;
	}

	protected void entityInit() {}

	public void func_146035_c(double x, double y, double z, float yaw, float pitch)
	{
		float f2 = MathHelper.sqrt_double(x * x + y * y + z * z);
		x /= (double)f2;
		y /= (double)f2;
		z /= (double)f2;
		x += this.rand.nextGaussian() * 0.007499999832361937D * (double)pitch;
		y += this.rand.nextGaussian() * 0.007499999832361937D * (double)pitch;
		z += this.rand.nextGaussian() * 0.007499999832361937D * (double)pitch;
		x *= (double)yaw;
		y *= (double)yaw;
		z *= (double)yaw;
		this.motionX = x;
		this.motionY = y;
		this.motionZ = z;
		float f3 = MathHelper.sqrt_double(x * x + z * z);
		this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(x, z) * 180.0D / Math.PI);
		this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(y, (double)f3) * 180.0D / Math.PI);
		this.inBlockAge = 0;
	}

	/**
	 * Checks if the entity is in range to render by using the past in distance and comparing it to its average edge
	 * length * 64 * renderDistanceWeight Args: distance
	 */
	@SideOnly(Side.CLIENT)
	public boolean isInRangeToRenderDist(double distance)
	{
		double d1 = this.boundingBox.getAverageEdgeLength() * 4.0D;
		d1 *= 64.0D;
		return distance < d1 * d1;
	}

	/**
	 * Sets the position and rotation. Only difference from the other one is no bounding on the rotation. Args: posX,
	 * posY, posZ, yaw, pitch
	 */
	@SideOnly(Side.CLIENT)
	public void setPositionAndRotation2(double x, double y, double z, float yaw, float pitch, int updates)
	{
		this.thisPosX = x;
		this.thisPosY = y;
		this.thisPosZ = z;
		this.thisYaw = (double)yaw;
		this.thisPitch = (double)pitch;
		this.timeUntilReset = updates;
		this.motionX = this.clientMotionX;
		this.motionY = this.clientMotionY;
		this.motionZ = this.clientMotionZ;
	}

	/**
	 * Sets the velocity to the args. Args: x, y, z
	 */
	@SideOnly(Side.CLIENT)
	public void setVelocity(double velocityX, double velocityY, double velocityZ)
	{
		this.clientMotionX = this.motionX = velocityX;
		this.clientMotionY = this.motionY = velocityY;
		this.clientMotionZ = this.motionZ = velocityZ;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate()
	{
		this.onEntityUpdate();

		if(this.field_146043_c != null) {
			if(this.strain > -80) {
				this.strain--;
			}
			else if(!this.worldObj.isRemote) {
				//Lost the fish! It was on the hook for too long.
				//System.out.println("hogehoge1");
				this.setDead();
				if(this.field_146042_b != null) {
					this.field_146042_b.fishEntity = null;
				}
			}
		}

		if (this.timeUntilReset > 0)
		{
			double d7 = this.posX + (this.thisPosX - this.posX) / (double)this.timeUntilReset;
			double d8 = this.posY + (this.thisPosY - this.posY) / (double)this.timeUntilReset;
			double d9 = this.posZ + (this.thisPosZ - this.posZ) / (double)this.timeUntilReset;
			double d1 = MathHelper.wrapAngleTo180_double(this.thisYaw - (double)this.rotationYaw);
			this.rotationYaw = (float)((double)this.rotationYaw + d1 / (double)this.timeUntilReset);
			this.rotationPitch = (float)((double)this.rotationPitch + (this.thisPitch - (double)this.rotationPitch) / (double)this.timeUntilReset);
			--this.timeUntilReset;
			this.setPosition(d7, d8, d9);
			this.setRotation(this.rotationYaw, this.rotationPitch);
		}
		else
		{
			if (!this.worldObj.isRemote) {

				if(this.field_146042_b == null) {
					//System.out.println("hogehoge2");
					this.setDead();
					return;
				}

				ItemStack itemstack = this.field_146042_b.getCurrentEquippedItem();

				if (this.field_146042_b.isDead || !this.field_146042_b.isEntityAlive() || itemstack == null || !(itemstack.getItem() instanceof DqmItemFishingRod) || this.getDistanceSqToEntity(this.field_146042_b) > 1024.0D)
				{
					//System.out.println("hogehoge3");
					this.setDead();
					this.field_146042_b.fishEntity = null;
					return;
				}

				if (this.field_146043_c != null)
				{
					if (!this.field_146043_c.isDead)
					{
						this.posX = this.field_146043_c.posX;
						this.posY = this.field_146043_c.posY + (double)this.field_146043_c.height * 0.5D;
						this.posZ = this.field_146043_c.posZ;
						return;
					}

					this.field_146043_c = null;
					this.strain = 0;

					PacketBuffer out = new PacketBuffer(Unpooled.buffer());

					out.writeInt(PacketHandlerClient.HOOK_FISH);
					out.writeInt(-1);
					out.writeInt(this.getEntityId());

					SToCMessage packet = new SToCMessage(out);
					PacketHandler.INSTANCE.sendToDimension(packet, this.dimension);
				}
			}

			if (this.isInBlock)
			{
				if (this.worldObj.getBlock(this.blockInX, this.blockInY, this.blockInZ) == this.blockIn)
				{
					++this.inBlockAge;

					if (this.inBlockAge == 1200)
					{
						//System.out.println("hogehoge4");
						this.setDead();
					}

					return;
				}

				this.isInBlock = false;
				this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
				this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
				this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
				this.inBlockAge = 0;
				this.inAirAge = 0;
			}
			else
			{
				++this.inAirAge;
			}

			Vec3 position = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			Vec3 nextPosition = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
			MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(position, nextPosition);
			position = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
			nextPosition = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

			if (movingobjectposition != null)
			{
				nextPosition = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
			}

			Entity entity = null;
			List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
			double d0 = 0.0D;
			double d2;

			for (int i = 0; i < list.size(); ++i)
			{
				Entity collidingEntity = (Entity)list.get(i);

				if (collidingEntity.canBeCollidedWith() && (collidingEntity != this.field_146042_b || this.inAirAge >= 5))
				{
					double f = 0.3D;
					AxisAlignedBB axisalignedbb = collidingEntity.boundingBox.expand(f, f, f);
					MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(position, nextPosition);

					if (movingobjectposition1 != null)
					{
						d2 = position.distanceTo(movingobjectposition1.hitVec);

						if (d2 < d0 || d0 == 0.0D)
						{
							entity = collidingEntity;
							d0 = d2;
						}
					}
				}
			}

			if (entity != null)
			{
				movingobjectposition = new MovingObjectPosition(entity);
			}

			if (movingobjectposition != null)
			{
				if (movingobjectposition.entityHit != null)
				{
					if (movingobjectposition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.field_146042_b), 0.3F))
					{
						hookEntity(movingobjectposition.entityHit);
					}
				}
				else
				{
					this.isInBlock = true;
				}
			}

			if (!this.isInBlock)
			{
				this.moveEntity(this.motionX, this.motionY, this.motionZ);
				float f5 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
				this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

				for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f5) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
				{
					;
				}

				while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
				{
					this.prevRotationPitch += 360.0F;
				}

				while (this.rotationYaw - this.prevRotationYaw < -180.0F)
				{
					this.prevRotationYaw -= 360.0F;
				}

				while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
				{
					this.prevRotationYaw += 360.0F;
				}

				this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
				this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
				float f6 = 0.92F;

				if (this.onGround || this.isCollidedHorizontally)
				{
					f6 = 0.5F;
				}

				byte b0 = 5;
				double d10 = 0.0D;
				boolean inWater = false;

				for (int j = 0; j < b0; ++j)
				{
					double d3 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(j + 0) / (double)b0 - 0.125D + 0.125D;
					double d4 = this.boundingBox.minY + (this.boundingBox.maxY - this.boundingBox.minY) * (double)(j + 1) / (double)b0 - 0.125D + 0.125D;
					AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getBoundingBox(this.boundingBox.minX, d3, this.boundingBox.minZ, this.boundingBox.maxX, d4, this.boundingBox.maxZ);

					inWater = inWater || this.worldObj.isAABBInMaterial(axisalignedbb1, Material.water);

					if (this.worldObj.isAABBInMaterial(axisalignedbb1, Material.water) || this.worldObj.isAABBInMaterial(axisalignedbb1, Material.lava))
					{
						d10 += 1.0D / (double)b0;
					}
				}

				if (!this.worldObj.isRemote && inWater)
				{
					WorldServer worldserver = (WorldServer)this.worldObj;
					int k = 1;

					if (this.rand.nextFloat() < 0.25F && this.worldObj.canLightningStrikeAt(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) + 1, MathHelper.floor_double(this.posZ)))
					{
						k = 2;
					}

					if (this.rand.nextFloat() < 0.5F && !this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) + 1, MathHelper.floor_double(this.posZ)))
					{
						--k;
					}

					if (this.field_146045_ax > 0)
					{
						--this.field_146045_ax;

						if (this.field_146045_ax <= 0)
						{
							this.field_146040_ay = 0;
							this.field_146038_az = 0;
						}
					}
					else
					{
						float f1;
						float f2;
						double d5;
						double d6;
						float f7;
						double d11;

						if (this.field_146038_az > 0)
						{
							this.field_146038_az -= k;

							if (this.field_146038_az <= 0)
							{
								this.motionY -= 0.20000000298023224D;
								this.playSound("random.splash", 0.25F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F);
								f1 = (float)MathHelper.floor_double(this.boundingBox.minY);
								worldserver.func_147487_a("bubble", this.posX, (double)(f1 + 1.0F), this.posZ, (int)(1.0F + this.width * 20.0F), (double)this.width, 0.0D, (double)this.width, 0.20000000298023224D);
								worldserver.func_147487_a("wake", this.posX, (double)(f1 + 1.0F), this.posZ, (int)(1.0F + this.width * 20.0F), (double)this.width, 0.0D, (double)this.width, 0.20000000298023224D);
								this.field_146045_ax = MathHelper.getRandomIntegerInRange(this.rand, 10, 30);
							}
							else
							{
								this.field_146054_aA = (float)((double)this.field_146054_aA + this.rand.nextGaussian() * 4.0D);
								f1 = this.field_146054_aA * 0.017453292F;
								f7 = MathHelper.sin(f1);
								f2 = MathHelper.cos(f1);
								d11 = this.posX + (double)(f7 * (float)this.field_146038_az * 0.1F);
								d5 = (double)((float)MathHelper.floor_double(this.boundingBox.minY) + 1.0F);
								d6 = this.posZ + (double)(f2 * (float)this.field_146038_az * 0.1F);

								if (this.rand.nextFloat() < 0.15F)
								{
									worldserver.func_147487_a("bubble", d11, d5 - 0.10000000149011612D, d6, 1, (double)f7, 0.1D, (double)f2, 0.0D);
								}

								float f3 = f7 * 0.04F;
								float f4 = f2 * 0.04F;
								worldserver.func_147487_a("wake", d11, d5, d6, 0, (double)f4, 0.01D, (double)(-f3), 1.0D);
								worldserver.func_147487_a("wake", d11, d5, d6, 0, (double)(-f4), 0.01D, (double)f3, 1.0D);
							}
						}
						else if (this.field_146040_ay > 0)
						{
							this.field_146040_ay -= k;
							f1 = 0.15F;

							if (this.field_146040_ay < 20)
							{
								f1 = (float)((double)f1 + (double)(20 - this.field_146040_ay) * 0.05D);
							}
							else if (this.field_146040_ay < 40)
							{
								f1 = (float)((double)f1 + (double)(40 - this.field_146040_ay) * 0.02D);
							}
							else if (this.field_146040_ay < 60)
							{
								f1 = (float)((double)f1 + (double)(60 - this.field_146040_ay) * 0.01D);
							}

							if (this.rand.nextFloat() < f1)
							{
								f7 = MathHelper.randomFloatClamp(this.rand, 0.0F, 360.0F) * 0.017453292F;
								f2 = MathHelper.randomFloatClamp(this.rand, 25.0F, 60.0F);
								d11 = this.posX + (double)(MathHelper.sin(f7) * f2 * 0.1F);
								d5 = (double)((float)MathHelper.floor_double(this.boundingBox.minY) + 1.0F);
								d6 = this.posZ + (double)(MathHelper.cos(f7) * f2 * 0.1F);
								worldserver.func_147487_a("splash", d11, d5, d6, 2 + this.rand.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D);
							}

							if (this.field_146040_ay <= 0)
							{
								this.field_146054_aA = MathHelper.randomFloatClamp(this.rand, 0.0F, 360.0F);
								this.field_146038_az = MathHelper.getRandomIntegerInRange(this.rand, 20, 80);
							}
						}
						else
						{
							this.field_146040_ay = MathHelper.getRandomIntegerInRange(this.rand, 100, 900);
							this.field_146040_ay -= EnchantmentHelper.func_151387_h(this.field_146042_b) * 20 * 5;
						}
					}

					if (this.field_146045_ax > 0)
					{
						this.motionY -= (double)(this.rand.nextFloat() * this.rand.nextFloat() * this.rand.nextFloat()) * 0.2D;
					}
				}

				d2 = d10 * 2.0D - 1.0D;
				this.motionY += 0.03999999910593033D * d2;

				if (d10 > 0.0D)
				{
					f6 = (float)((double)f6 * 0.9D);
					this.motionY *= 0.8D;
				}

				this.motionX *= (double)f6;
				this.motionY *= (double)f6;
				this.motionZ *= (double)f6;
				this.setPosition(this.posX, this.posY, this.posZ);
			}
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound p_70014_1_)
	{
		p_70014_1_.setShort("xTile", (short)this.blockInX);
		p_70014_1_.setShort("yTile", (short)this.blockInY);
		p_70014_1_.setShort("zTile", (short)this.blockInZ);
		p_70014_1_.setByte("inTile", (byte)Block.getIdFromBlock(this.blockIn));
		p_70014_1_.setByte("inGround", (byte)(this.isInBlock ? 1 : 0));
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound p_70037_1_)
	{
		this.blockInX = p_70037_1_.getShort("xTile");
		this.blockInY = p_70037_1_.getShort("yTile");
		this.blockInZ = p_70037_1_.getShort("zTile");
		this.blockIn = Block.getBlockById(p_70037_1_.getByte("inTile") & 255);
		this.isInBlock = p_70037_1_.getByte("inGround") == 1;
	}

	@SideOnly(Side.CLIENT)
	public float getShadowSize()
	{
		return 0.0F;
	}







    public int func_146034_e()
    {
        if (this.worldObj.isRemote)
        {
            return 0;
        }
        else
        {
            byte b0 = 0;

            if (this.field_146043_c != null)
            {
                double d0 = this.field_146042_b.posX - this.posX;
                double d2 = this.field_146042_b.posY - this.posY;
                double d4 = this.field_146042_b.posZ - this.posZ;
                double d6 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2 + d4 * d4);
                double d8 = 0.1D;
                this.field_146043_c.motionX += d0 * d8;
                this.field_146043_c.motionY += d2 * d8 + (double)MathHelper.sqrt_double(d6) * 0.08D;
                this.field_146043_c.motionZ += d4 * d8;
                b0 = 3;
            }
            else if (this.field_146045_ax > 0)
            {
                EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.func_146033_f());
                double d1 = this.field_146042_b.posX - this.posX;
                double d3 = this.field_146042_b.posY - this.posY;
                double d5 = this.field_146042_b.posZ - this.posZ;
                double d7 = (double)MathHelper.sqrt_double(d1 * d1 + d3 * d3 + d5 * d5);
                double d9 = 0.1D;
                entityitem.motionX = d1 * d9;
                entityitem.motionY = d3 * d9 + (double)MathHelper.sqrt_double(d7) * 0.08D;
                entityitem.motionZ = d5 * d9;
                this.worldObj.spawnEntityInWorld(entityitem);
                this.field_146042_b.worldObj.spawnEntityInWorld(new EntityXPOrb(this.field_146042_b.worldObj, this.field_146042_b.posX, this.field_146042_b.posY + 0.5D, this.field_146042_b.posZ + 0.5D, this.rand.nextInt(6) + 1));
                b0 = 1;
            }

            if (this.field_146051_au)
            {
                b0 = 2;
            }

            //System.out.println("hogehoge5");
            this.setDead();
            this.field_146042_b.fishEntity = null;
            return b0;
        }
    }

    private ItemStack func_146033_f()
    {
    	ItemStack item = DQR.fishingHookHook.hookDqrFunc_146033_f(this.worldObj, this.field_146042_b, this.field_146042_b.getHeldItem().getItem());
    	//System.out.println("Fishing!!!!!!!!!");
    	if(item != null)
    	{
    		return item;
    	}

        float f = this.worldObj.rand.nextFloat();
        int i = EnchantmentHelper.func_151386_g(this.field_146042_b);
        int j = EnchantmentHelper.func_151387_h(this.field_146042_b);

        /*
        if (true)
        {
            this.field_146042_b.addStat(net.minecraftforge.common.FishingHooks.getFishableCategory(f, i, j).stat, 1);
            return net.minecraftforge.common.FishingHooks.getRandomFishable(this.rand, f, i, j);
        }
        */

        float f1 = 0.1F - (float)i * 0.025F - (float)j * 0.01F;
        float f2 = 0.05F + (float)i * 0.01F - (float)j * 0.01F;
        f1 = MathHelper.clamp_float(f1, 0.0F, 1.0F);
        f2 = MathHelper.clamp_float(f2, 0.0F, 1.0F);

        if (f < f1)
        {
            this.field_146042_b.addStat(StatList.field_151183_A, 1);
            return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, field_146039_d)).func_150708_a(this.rand);
        }
        else
        {
            f -= f1;

            if (f < f2)
            {
                this.field_146042_b.addStat(StatList.field_151184_B, 1);
                return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, field_146041_e)).func_150708_a(this.rand);
            }
            else
            {
                float f3 = f - f2;
                this.field_146042_b.addStat(StatList.fishCaughtStat, 1);
                return ((WeightedRandomFishable)WeightedRandom.getRandomItem(this.rand, field_146036_f)).func_150708_a(this.rand);
            }
        }
    }




	//On right click, happens when the player right clicks the fishing rod item
    /*
	public int func_146034_e()
	{
		if (this.worldObj.isRemote)
		{
			if(this.field_146043_c instanceof EntityFish)
			{
				if(this.strain < 0) {
					this.strain = 0;
				}
				this.strain += ((EntityFish) this.field_146043_c).getStrain();
			}

			return 0;
		}
		else
		{
			byte toReturn = 0;

			if (this.field_146043_c != null && this.field_146043_c instanceof EntityFish)
			{

				double d0 = this.field_146042_b.posX - this.posX;
				double d2 = this.field_146042_b.posY - this.posY;
				double d4 = this.field_146042_b.posZ - this.posZ;
				double d6 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2 + d4 * d4);
				double d8 = 0.1D;
				if(this.field_146042_b.getHeldItem() != null && this.field_146042_b.getHeldItem().getItem() instanceof ItemHookedFishingRod) {
					d8 = ((ItemHookedFishingRod)this.field_146042_b.getHeldItem().getItem()).strength;
				}

				Vec3 pullVector = Vec3.createVectorHelper(d0, d2, d4);
				//pullVector.normalize();

				this.field_146043_c.addVelocity(pullVector.xCoord*d8,
												pullVector.yCoord*d8 + (double)MathHelper.sqrt_double(d6)*0.08D,
												pullVector.zCoord*d8);

				if(this.strain < 0) {
					this.strain = 0;
				}
				this.strain += ((EntityFish) this.field_146043_c).getStrain();

				if(ConfigOptions.simpleFishing || Vec3.createVectorHelper(this.field_146042_b.posX, this.field_146042_b.posY, this.field_146042_b.posZ).distanceTo(Vec3.createVectorHelper(this.field_146043_c.posX, this.field_146043_c.posY, this.field_146043_c.posZ)) < 3.0D) {
					this.field_146042_b.addStat(FishableCategory.FISH.stat, 1);
					this.catchFish((EntityFish) this.field_146043_c);

					toReturn = 1;
				}
				else {
					return 0;
				}
			}
			else {

				if (this.field_146043_c != null)
				{
					double d0 = this.field_146042_b.posX - this.posX;
					double d2 = this.field_146042_b.posY - this.posY;
					double d4 = this.field_146042_b.posZ - this.posZ;
					double d6 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2 + d4 * d4);
					double d8 = 0.1D;
					if(this.field_146042_b.getHeldItem() != null && this.field_146042_b.getHeldItem().getItem() instanceof ItemHookedFishingRod) {
						d8 = ((ItemHookedFishingRod)this.field_146042_b.getHeldItem().getItem()).strength;
					}
					this.field_146043_c.motionX += d0 * d8;
					this.field_146043_c.motionY += d2 * d8 + (double)MathHelper.sqrt_double(d6) * 0.08D;
					this.field_146043_c.motionZ += d4 * d8;
					toReturn = 3;
				}
				else if (this.field_146045_ax > 0)
				{
					EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, this.func_146033_f());
					double d1 = this.field_146042_b.posX - this.posX;
					double d3 = this.field_146042_b.posY - this.posY;
					double d5 = this.field_146042_b.posZ - this.posZ;
					double d7 = (double)MathHelper.sqrt_double(d1 * d1 + d3 * d3 + d5 * d5);
					double d9 = 0.1D;
					entityitem.motionX = d1 * d9;
					entityitem.motionY = d3 * d9 + (double)MathHelper.sqrt_double(d7) * 0.08D;
					entityitem.motionZ = d5 * d9;
					this.worldObj.spawnEntityInWorld(entityitem);
					this.field_146042_b.worldObj.spawnEntityInWorld(new EntityXPOrb(this.field_146042_b.worldObj, this.field_146042_b.posX, this.field_146042_b.posY + 0.5D, this.field_146042_b.posZ + 0.5D, this.rand.nextInt(6) + 1));
					toReturn = 1;
				}

				if (this.isInBlock)
				{
					toReturn = 2;
				}
			}

			this.setDead();
			this.field_146042_b.fishEntity = null;
			return toReturn;
		}
	}
	*/

    /*
	private ItemStack func_146033_f() {
		float chance = this.worldObj.rand.nextFloat();
		int luck = EnchantmentHelper.func_151386_g(this.field_146042_b);
		int speed = EnchantmentHelper.func_151387_h(this.field_146042_b);

		this.field_146042_b.addStat(net.minecraftforge.common.FishingHooks.getFishableCategory(chance, luck, speed).stat, 1);
		return net.minecraftforge.common.FishingHooks.getRandomFishable(this.rand, chance, luck*3 - 10, -30);

	}
	*/

	/*
	//Catch the fish on the rod. Try to place it in a bucket before giving the drop item.
	private void catchFish(EntityFish fish) {
		int bucketIndex = -1;
		Item pickupItem = fish.lavaFish() ? Items.lava_bucket : Items.water_bucket;

		for(int i = 0; i < 9 && bucketIndex == -1; i++) {
			if(this.field_146042_b.inventory.mainInventory[i] != null && this.field_146042_b.inventory.mainInventory[i].getItem() == pickupItem) {
				bucketIndex = i;
			}
		}

		if(bucketIndex != -1) {
			ItemStack fishBucket = JAFFMod.fishBucket.createFromFish(fish);
			this.field_146042_b.inventory.setInventorySlotContents(bucketIndex, fishBucket);

			PacketBuffer out = new PacketBuffer(Unpooled.buffer());

			out.writeInt(PacketHandlerClient.SET_INVENTORY_ITEM);
			out.writeInt(bucketIndex);
			try {
				out.writeItemStackToBuffer(fishBucket);
			}
			catch (IOException e) {
				System.out.println("[JAFF] Caught IOException! Uh oh!");
				e.printStackTrace();
			}

			SToCMessage packet = new SToCMessage(out);
			JAFFMod.networkWrapper.sendTo(packet, (EntityPlayerMP) this.field_146042_b);

			fish.setDead();
			return;
		}

		//If the fishing rod is enchanted with roasting, set the fish on fire.
		if(EnchantmentHelper.getEnchantmentLevel(JAFFMod.rodFireAspectID, this.field_146042_b.getHeldItem()) > 0) {
			fish.setFire(15);
		}

		ItemStack dropItem = fish.getDropItemStack();

		if(!fish.isChild()) {
			EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, dropItem);
			double d1 = this.field_146042_b.posX - this.posX;
			double d3 = this.field_146042_b.posY - this.posY;
			double d5 = this.field_146042_b.posZ - this.posZ;
			double d7 = (double)MathHelper.sqrt_double(d1 * d1 + d3 * d3 + d5 * d5);
			double d9 = 0.1D;
			entityitem.motionX = d1 * d9;
			entityitem.motionY = d3 * d9 + (double)MathHelper.sqrt_double(d7) * 0.08D;
			entityitem.motionZ = d5 * d9;
			this.worldObj.spawnEntityInWorld(entityitem);
			this.field_146042_b.worldObj.spawnEntityInWorld(new EntityXPOrb(this.field_146042_b.worldObj, this.field_146042_b.posX, this.field_146042_b.posY + 0.5D, this.field_146042_b.posZ + 0.5D, this.rand.nextInt(6) + 1));
		}

		fish.setDead();
	}
	*/
	private void removeBaitFromRod() {
		/*
		if(!(this.field_146043_c instanceof EntityFish)) {
			return;
		}

		ItemStack rod = this.field_146042_b.getHeldItem();

		if(rod.hasTagCompound()) {
			NBTTagCompound tag = rod.getTagCompound();

			NBTTagList baitList = tag.getTagList("Bait", 10);

			for(int i = 0; i < baitList.tagCount(); i++) {
				NBTTagCompound baitTag = baitList.getCompoundTagAt(i);

				String type = baitTag.getString("Type");

				if(((EntityFish)this.field_146043_c).isBreedingItem(type)) {
					baitTag.setInteger("Count", baitTag.getInteger("Count") - 1);

					if(baitTag.getInteger("Count") <= 0) {
						baitList.removeTag(i);
					}

					return;
				}

			}
		}
		*/
		return;
	}


	public void hookEntity(Entity entity) {
		this.field_146043_c = entity;
		this.removeBaitFromRod();

		PacketBuffer out = new PacketBuffer(Unpooled.buffer());

		out.writeInt(PacketHandlerClient.HOOK_FISH);
		out.writeInt(this.field_146043_c.getEntityId());
		out.writeInt(this.getEntityId());

		SToCMessage packet = new SToCMessage(out);
		PacketHandler.INSTANCE.sendToDimension(packet, this.dimension);
	}


	/**
	 * Will get destroyed next tick.
	 */
	 public void setDead()
	{
		super.setDead();

		if (this.field_146042_b != null)
		{
			this.field_146042_b.fishEntity = null;
		}
	}

	 public void setRodType(Item par1)
	 {
		 this.rodType = par1;
	 }

}
