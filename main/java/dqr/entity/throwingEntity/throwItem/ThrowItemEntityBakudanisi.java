package dqr.entity.throwingEntity.throwItem;

import net.minecraft.block.BlockChest;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import dqr.DQR;

public class ThrowItemEntityBakudanisi extends ThrowItemEntity
{
    private static final String __OBFID = "CL_00001724";

    public ThrowItemEntityBakudanisi(World p_i1779_1_)
    {
        super(p_i1779_1_);
    }

    public ThrowItemEntityBakudanisi(World p_i1780_1_, EntityLivingBase p_i1780_2_)
    {
        super(p_i1780_1_, p_i1780_2_);
    }

    public ThrowItemEntityBakudanisi(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_)
    {
        super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null)
        {
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        /*
        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0)
        {
            byte b0 = 1;

            if (this.rand.nextInt(32) == 0)
            {
                b0 = 4;
            }

            for (int i = 0; i < b0; ++i)
            {
                EntityChicken entitychicken = new EntityChicken(this.worldObj);
                entitychicken.setGrowingAge(-24000);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entitychicken);
            }
        }

        for (int j = 0; j < 8; ++j)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
        */



        if (!this.worldObj.isRemote)
        {
        	if(DQR.conf.gurdBakudanisiChest > 0)
        	{
                //this.worldObj.playSoundAtEntity(this, "random.glass", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
                int sPosX = (int)this.posX;
                int sPosY = (int)this.posY;
                int sPosZ = (int)this.posZ;
                int range = DQR.conf.gurdBakudanisiChest;

                for (int l = sPosX - range; l <= sPosX + range; ++l)
                {
                    for (int i1 = sPosY - range; i1 <= sPosY + range; ++i1)
                    {
                        for (int j1 = sPosZ - range; j1 <= sPosZ + range; ++j1)
                        {
                            if (this.worldObj.getBlock(l, i1, j1) instanceof BlockChest)
                            {
                            	this.setDead();
                                return;
                            }
                        }
                    }
                }
        	}

        	this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 3.0F, true);
            this.setDead();
        }
    }
}