package dqr.addons.twilightForest.coreHook;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import twilightforest.entity.EntityTFYeti;
import twilightforest.entity.boss.EntityTFIceBomb;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.entity.boss.EntityTFYetiAlpha;
import dqr.DQR;
import dqr.entity.magicEntity.magic.MagicEntity;

public class FuncTFMobHook {

	public FuncTFMobHook(){}

	public boolean hookTFLichAttackEntityFrom(EntityTFLich par0, DamageSource par1DamageSource, float damage)
	{

		if(DQR.addons.tasogareIsEnable == 1)
		{
			if(!par0.worldObj.isRemote)
			{
				if(par1DamageSource.getEntity() != null && par1DamageSource.getEntity() instanceof EntityPlayer)
				{
					if(par0.isShadowClone() && par1DamageSource.getEntity() != null)
					{
						par1DamageSource.getEntity().setFire(5);
					}

					if (par0.getShieldStrength() > 0)
					{
						if (par1DamageSource.isUnblockable() && damage > 2){}
						else
						{
							par1DamageSource.getEntity().attackEntityFrom(DamageSource.causeMobDamage(par0), (damage * 2));
						}

						return true;
					}
				}else if(par1DamageSource.getEntity() != null && par1DamageSource.getEntity() instanceof MagicEntity)
				{
					if (par0.getShieldStrength() > 0)
					{
						if (par1DamageSource.isUnblockable() && damage > 2){}
						else
						{
							DQR.func.forceCastMobMagic(par0, (MagicEntity)par1DamageSource.getEntity(), null, 2);

							((MagicEntity)par1DamageSource.getEntity()).setDead();
							return false;
						}
					}else
					{
						MagicEntity magic = (MagicEntity)par1DamageSource.getEntity();
						magic.setDamage(magic.getDamage() / 2);
						damage = (float)(magic.getDamage() / 2);
					}
				}
				//System.out.println("DEBUG : " + par1DamageSource.getEntity().getCommandSenderName() + " / " + damage);
			}
		}


		return true;
	}

	public boolean hookTFIceBombHitNearbyEntities(EntityTFIceBomb par0)
	{
		if(DQR.addons.tasogareIsEnable == 1)
		{
			ArrayList<Entity> nearby = new ArrayList<Entity>(par0.worldObj.getEntitiesWithinAABBExcludingEntity(par0, par0.boundingBox.expand(3, 2, 3)));

			for (Entity entity : nearby) {
				if (entity instanceof EntityLivingBase && entity != par0.getThrower()) {

					if (entity instanceof EntityTFYeti) {
						// TODO: make "frozen yeti" entity?
						entity.setDead();
						int ix = MathHelper.floor_double(entity.lastTickPosX);
						int iy = MathHelper.floor_double(entity.lastTickPosY);
						int iz = MathHelper.floor_double(entity.lastTickPosZ);

						par0.worldObj.setBlock(ix, iy, iz, Blocks.ice);
						par0.worldObj.setBlock(ix, iy + 1, iz, Blocks.ice);

					} else {
						entity.attackEntityFrom(DamageSource.magic, 75);
						int chillLevel = 2;
						DQR.func.addPotionEffect2(((EntityLivingBase)entity), new PotionEffect(Potion.moveSlowdown.id, 20 * 5, chillLevel, true));
					}

				}
			}

			return true;
		}
		return false;
	}

	public boolean hookTFYetiAlphaHitNearbyEntities(EntityTFYetiAlpha par0)
	{
		if(DQR.addons.tasogareIsEnable == 1)
		{
			ArrayList<Entity> nearby = new ArrayList<Entity>(par0.worldObj.getEntitiesWithinAABBExcludingEntity(par0, par0.boundingBox.expand(5, 0, 5)));

			for (Entity entity : nearby) {
				if (entity instanceof EntityLivingBase) {

					boolean hit = entity.attackEntityFrom(DamageSource.causeMobDamage(par0), 111F);

			        if (hit)
			        {
			        	entity.motionY += 0.4000000059604645D;
			        }
				}
			}

			return true;
		}
		return false;
	}
}
