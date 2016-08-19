package dqr.handler;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.potion.DQPotionEtc;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties;

public class MagicEventHandler {
	@SubscribeEvent
    public void onMagicLivingUpdate(LivingUpdateEvent event)
	{
		PotionEffect pe;

		//窒息ダメ
		pe = event.entityLiving.getActivePotionEffect(DQPotionMinus.debuffSuffocation);
		if(pe != null)
		{
			if(event.entityLiving.getActivePotionEffect(Potion.waterBreathing) == null)
			{
				if(event.entityLiving.worldObj.getWorldTime() % 20 == 0)
				{
					event.entityLiving.attackEntityFrom(DQR.damageSource.DqmSuffocation, (pe.getAmplifier() + 1));
				}
			}else
			{
				event.entityLiving.removePotionEffect(DQPotionMinus.debuffSuffocation.getId());
			}
		}

		pe = event.entityLiving.getActivePotionEffect(DQPotionMinus.debuffHeavyFire);
		if(pe != null)
		{
			if(event.entityLiving.worldObj.getWorldTime() % 5 == 0)
			{
				if(event.entityLiving.getHealth() - (pe.getAmplifier() + 1)  > 0)
				{
					event.entityLiving.attackEntityFrom(DQR.damageSource.DqmHeavyFire, (pe.getAmplifier() + 1));
					//ep.setHealth(ep.getHealth() - (pe.getAmplifier() + 1));
				}
			}
		}

		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)event.entityLiving;


			int baseX = (int)event.entityLiving.posX;
			int baseY = (int)event.entityLiving.posY;
			int baseZ = (int)event.entityLiving.posZ;

			//海鳴りの杖
			pe = ep.getActivePotionEffect(DQPotionEtc.buffUminarinotue);
			if(pe != null)
			{
				if(ep.worldObj.getWorldTime() % 5 == 0)
				{
					int mp = ExtendedPlayerProperties.get(ep).getMP();

					if(mp <= 0 && DQR.debug == 0)
					{
						ep.removePotionEffect(DQPotionEtc.buffUminarinotue.getId());
					}else
					{
						ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMP() - 1);
					}
				}

				 List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
						 ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(10.0D, 5.0D, 10.0D));

	            if (list != null && !list.isEmpty())
	            {
	            	for (int n = 0 ; n < list.size() ; n++)
	            	{
	            		if(list.get(n) instanceof EntityLivingBase)
	            		{
		            		EntityLivingBase target = (EntityLivingBase)list.get(n);

		            		if (target instanceof EntityPlayer)
		            		{
		            			EntityPlayer entityplayer = (EntityPlayer)target;

		                        if (entityplayer.capabilities.disableDamage || (ep instanceof EntityPlayer &&
			                               !(ep.canAttackPlayer(entityplayer))) ||  ep == target)
		                        {
		                        	;
		                        }else
		                        {
				            		if(target.getActivePotionEffect(DQPotionMinus.debuffSuffocation) == null)
				            		{
				            			target.addPotionEffect(new PotionEffect(DQPotionMinus.debuffSuffocation.getId(), 60, 0));
				            		}
		                        }
		            		}else
		            		{
			            		if(target.getActivePotionEffect(DQPotionMinus.debuffSuffocation) == null)
			            		{
			            			target.addPotionEffect(new PotionEffect(DQPotionMinus.debuffSuffocation.getId(), 60, 0));
			            		}
		            		}
	            		}
	            	}
	            }

				if(DQR.conf.magicEpUminari != 0)
				{
					for(int cntX = -1; cntX <= 1; cntX++)
					{
						for(int cntZ = -1; cntZ <= 1; cntZ++)
						{
							//boolean topBM = ep.worldObj.isAirBlock(baseX + cntX, baseY, baseZ + cntZ);
							Block overB = ep.worldObj.getBlock(baseX + cntX, baseY + 1, baseZ + cntZ);
							Block topB = ep.worldObj.getBlock(baseX + cntX, baseY, baseZ + cntZ);
							Block underB = ep.worldObj.getBlock(baseX + cntX, baseY - 1, baseZ + cntZ);
							//boolean overBM = ep.worldObj.isAirBlock(baseX + cntX, baseY + 1, baseZ + cntZ);

							if(underB != null && underB.getMaterial() == Material.lava
							  && (topB == null || topB == Blocks.air))
							{
								ep.worldObj.setBlock(baseX + cntX, baseY, baseZ + cntZ, Blocks.flowing_water, 0, 2);
								//ep.worldObj.playSoundAtEntity(ep, "random.fizz", 1.0F, 1.0F);
							}

							if(topB != null && topB.getMaterial() == Material.lava
							&& (overB == null || overB == Blocks.air))
							{
								ep.worldObj.setBlock(baseX + cntX, baseY + 1, baseZ + cntZ, Blocks.flowing_water, 0, 2);
								//ep.worldObj.playSoundAtEntity(ep, "random.fizz", 1.0F, 1.0F);
							}
						}
					}
				}
			}

			//マグマの杖
			pe = ep.getActivePotionEffect(DQPotionEtc.buffCallMagma);
			if(pe != null && DQR.conf.magicEpCallMagma != 0)
			{
				if(ep.worldObj.getWorldTime() % 5 == 0)
				{
					int mp = ExtendedPlayerProperties.get(ep).getMP();

					if(mp <= 0 && DQR.debug == 0)
					{
						ep.removePotionEffect(DQPotionEtc.buffCallMagma.getId());
					}else
					{
						ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMP() - 1);
					}
				}

				 List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
						 ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(10.0D, 5.0D, 10.0D));

	            if (list != null && !list.isEmpty())
	            {
	            	for (int n = 0 ; n < list.size() ; n++)
	            	{
	            		if(list.get(n) instanceof EntityLivingBase)
	            		{
		            		EntityLivingBase target = (EntityLivingBase)list.get(n);

		            		if (target instanceof EntityPlayer)
		            		{
		            			EntityPlayer entityplayer = (EntityPlayer)target;

		                        if (entityplayer.capabilities.disableDamage || (ep instanceof EntityPlayer &&
			                               !(ep.canAttackPlayer(entityplayer)))  || ep == target)
		                        {
		                        	;
		                        }else
		                        {
				            		if(target.getActivePotionEffect(DQPotionMinus.debuffHeavyFire) == null)
				            		{
				            			target.addPotionEffect(new PotionEffect(DQPotionMinus.debuffHeavyFire.getId(), 60, 0));
				            		}
		                        }
		            		}else
		            		{
		            			if(!(target instanceof DqmPetBase))
		            			{
				            		if(target.getActivePotionEffect(DQPotionMinus.debuffHeavyFire) == null)
				            		{
				            			target.addPotionEffect(new PotionEffect(DQPotionMinus.debuffHeavyFire.getId(), 60, 0));
				            		}
		            			}
		            		}
	            		}
	            	}
	            }

				if(DQR.conf.magicEpCallMagma != 0)
				{
					for(int cntX = -1; cntX <= 1; cntX++)
					{
						for(int cntZ = -1; cntZ <= 1; cntZ++)
						{
							//boolean topBM = ep.worldObj.isAirBlock(baseX + cntX, baseY, baseZ + cntZ);
							Block overB = ep.worldObj.getBlock(baseX + cntX, baseY + 1, baseZ + cntZ);
							Block topB = ep.worldObj.getBlock(baseX + cntX, baseY, baseZ + cntZ);
							Block underB = ep.worldObj.getBlock(baseX + cntX, baseY - 1, baseZ + cntZ);
							//boolean overBM = ep.worldObj.isAirBlock(baseX + cntX, baseY + 1, baseZ + cntZ);

							if(underB != null && underB.getMaterial() == Material.water
							  && (topB == null || topB == Blocks.air || topB.getMaterial() == Material.water))
							{
								ep.worldObj.setBlock(baseX + cntX, baseY - 1, baseZ + cntZ, Blocks.stone, 0, 2);
								ep.worldObj.playSoundAtEntity(ep, "random.fizz", 1.0F, 1.0F);
							}

							if(topB != null && topB.getMaterial() == Material.water
							&& (overB == null || overB == Blocks.air || overB.getMaterial() == Material.water))
							{
								if(!ep.worldObj.isRemote) ep.worldObj.setBlock(baseX + cntX, baseY - 1, baseZ + cntZ, Blocks.cobblestone, 0, 2);
								if(!ep.worldObj.isRemote) ep.worldObj.playSoundAtEntity(ep, "random.fizz", 1.0F, 1.0F);
							}


						}
					}
				}
			}
		}
	}
}
