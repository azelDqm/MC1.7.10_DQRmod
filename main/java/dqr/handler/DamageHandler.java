package dqr.handler;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import scala.util.Random;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.enums.EnumDqmEndoraParam;
import dqr.api.enums.EnumDqmMessageConv;
import dqr.api.enums.EnumDqmMobRoot;
import dqr.api.enums.EnumDqmSkillW;
import dqr.api.enums.EnumDqmWeapon;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.throwingEntity.throwing.ThrowingEntity;
import dqr.items.base.DqmItemBowBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class DamageHandler {

	Random rand = new Random();

	@SubscribeEvent
	public void onLivingHurtEvent(LivingHurtEvent event) {

		int varDifficulty = DQR.conf.DqmEndoraDifficulty == -1 ? DQR.conf.DqmDifficulty : DQR.conf.DqmEndoraDifficulty;
		EnumDqmEndoraParam enumEndora = DQR.enumGetter.getEndoraParam(varDifficulty);

		//DQR.func.debugString("DAMTEST_A:" + event.ammount);

		if(event.source.getEntity() != null){


			//System.out.println("TEST:" + event.source.getSourceOfDamage().getCommandSenderName());
			//System.out.println("TEST:" + event.source.getEntity().getCommandSenderName());

			if(event.source.getEntity() instanceof EntityDragon)
			{

				if(varDifficulty > 6)
				{
					event.ammount = event.ammount * (enumEndora.getAttack() + (10 * (varDifficulty - 6)));
				}else
				{
					event.ammount = event.ammount * enumEndora.getAttack();
				}
			}else if(event.source.getEntity() instanceof EntityWither && !(event.entityLiving instanceof DqmMobBase))
			{
				event.ammount = event.ammount * 50;
			}else if(event.source.getEntity() instanceof EntityPlayer && !DQR.damageSource.isDqmSkillDamage(event.source))
			{
				event.ammount = ExtendedPlayerProperties.get((EntityPlayer)event.source.getEntity()).getKougeki();
			}
			/*
			else if(event.source.getEntity() instanceof EntityPlayer && !event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkill.getDamageType()))
			{
				event.ammount = ExtendedPlayerProperties.get((EntityPlayer)event.source.getEntity()).getKougeki();
			}
			*/

			if(!DQR.damageSource.isDqmSkillDamage(event.source) && (event.source.getSourceOfDamage() instanceof EntityArrow || event.source.getEntity() instanceof ThrowingEntity))
			{
				//System.out.println("TEST:矢！！！！！");

				EntityPlayer ep = null;
				int weapon = 0;

				if(event.source.getSourceOfDamage() instanceof EntityArrow && event.source.getEntity() instanceof EntityPlayer)
				{
					ep = (EntityPlayer)event.source.getEntity();
					weapon = EnumDqmWeapon.DqmBow.getId();
				}else if(event.source.getEntity() instanceof ThrowingEntity && event.source.getSourceOfDamage() instanceof EntityPlayer)
				{
					ep = (EntityPlayer)event.source.getSourceOfDamage();
					weapon = EnumDqmWeapon.DqmThrow.getId();
				}

				if(ep != null)
				{
					EntityLivingBase evb = event.entityLiving;
					//int weapon = ExtendedPlayerProperties.get(ep).getWeapon();
					int weaponSkill = ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(weapon);
					int skillPerm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(weapon, weaponSkill);

					if(skillPerm != 0)
					{
						DqmMobBase monster = null;
						if(evb instanceof DqmMobBase)
						{
							monster = (DqmMobBase)evb;
						}

						EnumDqmSkillW skillW = DQR.enumGetter.getSkillW(weapon, weaponSkill);

						//ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {}));

						if(skillW != null && skillW.getFunc() == 1 && skillW.getRATE() > rand.nextInt(100))
						{
							boolean hitFlg = false;
							//ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {}));
							//ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.MonsterName.getEndS()}));

							if(weapon == EnumDqmWeapon.DqmBow.getId())
							{
								if(weaponSkill == 0)
								{
									//マジックアロー
									evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffDivainsuperu.id, 300, 1));
									hitFlg = true;
								}else if(weaponSkill ==2)
								{
									//バードシュート
									if(monster != null && DQR.calcDamage.isBirdMob(monster))
									{
										event.ammount = event.ammount * 1.5F;
										hitFlg = true;
									}
								}else if(weaponSkill ==4)
								{
									//ニードルショット
									ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

									if(rand.nextInt(5) == 0)
									{
										evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamageDeath(ep), evb.getMaxHealth() + 100.0F);
										event.setCanceled(true);
										return;
									}else
									{
										event.ammount = 1.0F;
									}

									hitFlg = false;
								}else if(weaponSkill ==8)
								{
									//バードシュート
									int sMP = ExtendedPlayerProperties.get(ep).getMP();
									if(sMP + (event.ammount / 8) >= ExtendedPlayerProperties.get(ep).getMaxMP())
									{
										 ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
									}else
									{
										ExtendedPlayerProperties.get(ep).setMP(sMP + (int)(event.ammount / 8));
									}

									hitFlg = true;
								}
							}else if(weapon == EnumDqmWeapon.DqmThrow.getId())
							{
								if(weaponSkill == 0)
								{
									//クロスカッター
									ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

									List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(evb,
							            		evb.boundingBox.addCoord(evb.motionX, evb.motionY, evb.motionZ).expand(5.0D, 5.0D, 5.0D));

						            if (list != null && !list.isEmpty())
						            {
						            	for (int n = 0 ; n < list.size() ; n++)
						            	{
						            		Entity target = (Entity)list.get(n);

						            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) && !(target instanceof EntityHorse))
						            		{
						            			target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (event.ammount));
						            		}
						            	}
						            }

									hitFlg = false;
								}else if(weaponSkill == 1)
								{
					            	//パワフルスロー
									ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

									List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(evb,
							            		evb.boundingBox.addCoord(evb.motionX, evb.motionY, evb.motionZ).expand(10.0D, 5.0D, 10.0D));

									event.ammount = event.ammount * 0.8f;
						            if (list != null && !list.isEmpty())
						            {
						            	for (int n = 0 ; n < list.size() ; n++)
						            	{
						            		Entity target = (Entity)list.get(n);

						            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) && !(target instanceof EntityHorse))
						            		{
						            			target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (event.ammount));
						            		}
						            	}
						            }

									hitFlg = false;
								}else if(weaponSkill == 3)
								{
									//スライムブロウ
									if(monster != null && monster.MobRoot.getId() == EnumDqmMobRoot.SURAIMU.getId())
									{
										event.ammount = event.ammount * 1.5F;
										hitFlg = true;
									}
								}else if(weaponSkill == 5)
								{
									//シャインスコール
									ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

									event.ammount = 100.0F;
									List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(evb,
							            		evb.boundingBox.addCoord(evb.motionX, evb.motionY, evb.motionZ).expand(5.0D, 5.0D, 5.0D));

						            if (list != null && !list.isEmpty())
						            {
						            	for (int n = 0 ; n < list.size() ; n++)
						            	{
						            		Entity target = (Entity)list.get(n);

						            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) && !(target instanceof EntityHorse))
						            		{
						            			target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (event.ammount));
						            		}
						            	}
						            }

									hitFlg = false;
								}else if(weaponSkill == 6)
								{
									//バーニングバード
									ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

									List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(evb,
							            		evb.boundingBox.addCoord(evb.motionX, evb.motionY, evb.motionZ).expand(8.0D, 5.0D, 8.0D));

						            if (list != null && !list.isEmpty())
						            {
						            	for (int n = 0 ; n < list.size() ; n++)
						            	{
						            		Entity target = (Entity)list.get(n);

						            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) && !(target instanceof EntityHorse))
						            		{
						            			for(int cnt = 0; cnt < 7; cnt++)
						            			{
						            				target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (event.ammount * 0.3F));
						            			}
						            			target.setFire(80);
						            		}
						            	}
						            }
						            event.ammount = event.ammount * 0.3F;
									hitFlg = false;
								}else if(weaponSkill == 8)
								{
					            	//メタルウィング
									ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

									List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(evb,
							            		evb.boundingBox.addCoord(evb.motionX, evb.motionY, evb.motionZ).expand(10.0D, 5.0D, 10.0D));

									event.ammount = event.ammount * 0.8f;
						            if (list != null && !list.isEmpty())
						            {
						            	for (int n = 0 ; n < list.size() ; n++)
						            	{
						            		if(list.get(n) instanceof DqmMobBase)
						            		{
						            			DqmMobBase target = (DqmMobBase)list.get(n);
						            			
												if(target != null && monster.MobRoot.getId() == EnumDqmMobRoot.METARU.getId())
												{
													event.ammount = (float)(rand.nextInt(2)) + 1.0F;
													hitFlg = true;
												}
						            		}
						            		
						            		
						            		/*
						            		Entity target = (Entity)list.get(n);

						            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) && !(target instanceof EntityHorse))
						            		{
						            			target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (event.ammount));
						            		}
						            		*/
						            	}
						            }

									hitFlg = false;
								}
							}

							if(hitFlg)
							{
								ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							}
						}
					}
					//System.out.println("TEST:有効！！");
				}


			}
			/*
			else if(event.source.)
			{

			}
			*/
		}

		if(event.source.isExplosion() && !(event.source.getEntity() instanceof EntityWither))
		{
			event.ammount = event.ammount * 5;
		}

		//エンドラの理不尽な防御力
		if(event.entityLiving instanceof EntityDragon)
		{
			event.ammount = event.ammount / enumEndora.getDeffence();
 		}

		//DQR.func.debugString("DAMTEST_B:" + event.ammount);

		//エンドラの理不尽な防御力2
		if(event.entityLiving instanceof EntityDragon)
		{
			for(int damCnt = 0; damCnt < 10; damCnt++)
			{
				if(event.ammount > 500)
				{
					event.ammount = event.ammount / 10;
				}else
				{
					break;
				}
			}
 		}

		//ウィザーのちょっと嫌な防御力
		if(event.entityLiving instanceof EntityWither)
		{
			event.ammount = event.ammount / 5;
 		}

		//ダメージ乱数
		int randomDam = (int)(event.ammount / 2);
		if(randomDam > 0)
		{
			event.ammount = (event.ammount * 3 / 4) + (rand.nextInt(randomDam));
		}

		//DQR.func.debugString("DAMTEST_C:" + event.ammount);

		boolean criticalFlg = false;
		if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityLivingBase)
		{
			if(event.source.getEntity() instanceof DqmMobBase)
			{
				event.source.setDamageBypassesArmor();

				DqmMobBase mob = (DqmMobBase)event.source.getEntity();

				int criticalVal = mob.DqmMobKaisin;
				if(rand.nextInt(1000) < criticalVal + 1)
				{
					criticalFlg = true;
					event.ammount = event.ammount * (rand.nextInt(mob.DqmMobKaisinMax) + mob.DqmMobKaisinMin);
				}
			}else if(event.source.getEntity() instanceof EntityPlayer)
			{
				EntityPlayer epr = (EntityPlayer)event.source.getEntity();
				int criticalVal = ExtendedPlayerProperties.get(epr).getKaisinritu() + 5;

				if(event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillCri.getDamageType()) ||
					(rand.nextInt(1000) < criticalVal &&
					 (epr.getHeldItem() != null || (epr.getHeldItem() != null && (epr.getHeldItem().getItem() instanceof DqmItemWeaponBase || epr.getHeldItem().getItem() instanceof DqmItemBowBase)))
					)
				  )
				{
					event.source.setDamageBypassesArmor();
					event.ammount = event.ammount
									* (rand.nextInt(ExtendedPlayerProperties.get(epr).getKaisinMax())
							        + ExtendedPlayerProperties.get(epr).getKaisinMin());
					if(!epr.worldObj.isRemote && event.entityLiving != null)
					{
						epr.addChatMessage(new ChatComponentTranslation("msg.epCritical.txt",new Object[] { event.entityLiving.getCommandSenderName(), (int)event.ammount}));
					}
					epr.worldObj.playSoundAtEntity(epr, "dqr:player.kaisin", 0.3F, 1.0F);
					criticalFlg = true;
				}else
				{

				}

				//物理攻撃耐性計算
				if(!criticalFlg)
				{
					event.ammount = DQR.calcDamage.applyDamageResist(event.ammount, event.entityLiving, event.source);

				}

				//即死系攻撃の場合
				if(event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillDeath.getDamageType()) &&
					event.ammount > 1.0F)
				{
					event.ammount = event.entityLiving.getMaxHealth() + 100.0F;
				}

				//DQR.func.debugString("DAMTEST_E:" + event.ammount);

				if(!(event.entityLiving instanceof DqmMobBase))
				{
					if(!epr.worldObj.isRemote)
					{
						float dam = DQR.calcDamage.getDummyDamage(event.ammount, event.entityLiving, event.source);

						if (event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillDeath.getDamageType()) &&
							event.ammount > 1.0F)
						{
							epr.addChatMessage(new ChatComponentTranslation("msg.toDamage3.txt",new Object[] {event.entityLiving.getCommandSenderName()}));
						}
						else if (DQR.conf.damageDigits == 1)
						{
							epr.addChatMessage(new ChatComponentTranslation("msg.toDamage2.txt",new Object[] {event.entityLiving.getCommandSenderName(), dam}));
						}else
						{
							epr.addChatMessage(new ChatComponentTranslation("msg.toDamage.txt",new Object[] {event.entityLiving.getCommandSenderName(), (int)dam}));
						}
						//epr.addChatMessage(new ChatComponentTranslation("msg.toDamage.txt",new Object[] {event.entityLiving.getCommandSenderName(), dam}));
					}
				}

				//DQR.func.debugString("DAMTEST_F:" + event.ammount);
			}

			if(event.entityLiving instanceof EntityPlayer)
			{
				EntityPlayer ep = (EntityPlayer)event.entityLiving;

				ep.inventory.damageArmor(event.ammount);

				if(!ep.worldObj.isRemote && criticalFlg)
				{
					ep.addChatMessage(new ChatComponentTranslation("msg.mobCritical.txt",new Object[] { event.source.getEntity().getCommandSenderName(), (int)event.ammount}));
				}
				if (DQR.debug == 0)
				{
					event.source.setDamageBypassesArmor();
				}

				int bougyoryoku;
				if(criticalFlg)
				{
					bougyoryoku = 0;
				}else
				{
					bougyoryoku = ExtendedPlayerProperties.get(ep).getBougyo();
				}

				event.ammount = event.ammount - bougyoryoku;

				if(!ep.worldObj.isRemote && event.ammount <= 0.0F)
				{
					ep.worldObj.playSoundAtEntity(ep, "dqr:player.miss", 1.0F, 1.0F);
				}
			}else if(event.entityLiving instanceof DqmMobBase)
			{

			}

		}

		/*
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)event.entityLiving;

			if(event.source.getEntity() != null)
			{
				if(!ep.worldObj.isRemote)
				{
					ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] { event.source.getEntity().getCommandSenderName(), (int)event.ammount}));
				}
			}
		}
		*/
		//EntityPlayer thePlayer = event.entityPlayer;

		//DQR.func.debugString("DAMTEST_D:" + event.ammount);
	}


}
