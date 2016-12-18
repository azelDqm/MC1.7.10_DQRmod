package dqr.handler;

import java.util.List;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import scala.util.Random;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.Items.DQAccessories;
import dqr.api.enums.EnumDqmElement;
import dqr.api.enums.EnumDqmEndoraParam;
import dqr.api.enums.EnumDqmMessageConv;
import dqr.api.enums.EnumDqmMobRoot;
import dqr.api.enums.EnumDqmSkillW;
import dqr.api.enums.EnumDqmWeapon;
import dqr.api.potion.DQPotionEtc;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.throwingEntity.throwing.ThrowingEntity;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.items.base.DqmItemBowBase;
import dqr.items.base.DqmItemThrowBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.items.interfaceBase.ISubEquip;
import dqr.items.weapon.DqmItemThrowing;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;


public class DamageHandler {

	Random rand = new Random();

	@SubscribeEvent(priority=EventPriority.HIGH)
	public void onSpecialBoostDamageEvent(LivingHurtEvent event) {
		//特攻等のダメージ調整
		EntityLivingBase damager = event.entityLiving;
		EntityPlayer ep = null;
		DqmMobBase monster = null;

		if(event.source.getEntity() instanceof EntityPlayer)
		{
			ep = (EntityPlayer)event.source.getEntity();
		}else if(event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			ep = (EntityPlayer)event.source.getSourceOfDamage();
		}

		if(damager instanceof DqmMobBase)
		{
			monster = (DqmMobBase)damager;
		}

		if(ep != null)
		{
			//System.out.println("TEST!!!!!!!!!1");
			PotionEffect pe = ep.getActivePotionEffect(DQPotionEtc.buffMahouken);

			if(pe != null)
			{
				if(pe.getAmplifier() == 20)
				{
					//毒
					if(rand.nextInt(5) == 0)
					{
						damager.addPotionEffect(new PotionEffect(DQPotionMinus.potionPoison.id, 300, 1));
					}
				}else if(pe.getAmplifier() == 21)
				{
					//毒2
					if(rand.nextInt(5) == 0)
					{
						damager.addPotionEffect(new PotionEffect(DQPotionMinus.potionPoisonX.id, 300, 1));
					}
				}else if(pe.getAmplifier() == 22)
				{
					//毒3
					if(rand.nextInt(5) == 0)
					{
						damager.addPotionEffect(new PotionEffect(DQPotionMinus.potionPoisonX.id, 600, 2));
					}
				}else if(pe.getAmplifier() == 23)
				{
					//遅
					if(rand.nextInt(5) == 0)
					{
						damager.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 300, 2));
					}
				}else if(pe.getAmplifier() == 24)
				{
					//炎
					if(rand.nextInt(5) == 0)
					{
						damager.setFire(200);
					}
				}else if(pe.getAmplifier() == 25)
				{
					//MP吸収

					if(rand.nextInt(4) == 0)
					{
						if(monster != null)
						{
							int getMP = (int)(event.ammount / 10) + 1;
							int maxMP = ExtendedPlayerProperties.get(ep).getMaxMP();
							int nowMP = ExtendedPlayerProperties.get(ep).getMP();

							if(monster.DqmMobMP >= getMP)
							{
								if(nowMP + getMP > maxMP)
								{
									ExtendedPlayerProperties.get(ep).setMP(maxMP);
									monster.DqmMobMP = monster.DqmMobMP - (maxMP - nowMP);
								}else
								{
									ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMP() + getMP);
									monster.DqmMobMP = monster.DqmMobMP - getMP;
								}
							}else
							{
								if(nowMP + monster.DqmMobMP > maxMP)
								{
									ExtendedPlayerProperties.get(ep).setMP(maxMP);
									monster.DqmMobMP = monster.DqmMobMP - (maxMP - nowMP);
								}else
								{
									ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMP() + monster.DqmMobMP);
									monster.DqmMobMP = 0;
								}

								//ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMP() + monster.DqmMobMP);
							}
						}
					}
				}else if(pe.getAmplifier() == 26)
				{
					if(rand.nextInt(4) == 0)
					{
						int getHP = (int)(event.ammount / 4) + 1;

						if((int)damager.getHealth() > getHP)
						{
							ep.heal(getHP);
						}else
						{
							ep.heal(damager.getHealth());
						}
						if(ep.getHealth() > ep.getMaxHealth())
						{
							ep.setHealth(ep.getMaxHealth());
						}
					}
				}
			}
		}

		if(damager != null && ep != null && ep.getHeldItem() != null)
		{
			ItemStack handStack = ep.getHeldItem();
			Item handItem = handStack.getItem();

			NBTTagList tag = ep.getCurrentEquippedItem().getEnchantmentTagList();
			if(tag != null)
			{
				//DQR.func.debugString("DEBUG3:" + cnt);
		    	for(int cnt2 = 0; cnt2 < tag.tagCount(); cnt2++)
		    	{
		    		//DQR.func.debugString("DEBUG4:" + cnt2);

		    		NBTTagCompound nbt = tag.getCompoundTagAt(cnt2);
		    		if(nbt != null && nbt.getShort("id") == Enchantment.smite.effectId)
		    		{
		    			//ゾンビ特攻
		    			if(damager instanceof EntityZombie ||
		    			   damager instanceof EntitySkeleton ||
		    			   damager instanceof EntityPigZombie ||
		    			   damager instanceof EntityWither ||
		    			   (monster != null && monster.MobRoot == EnumDqmMobRoot.UNDEAD))
		    			{
		    				event.ammount = event.ammount * (1.0F + (nbt.getShort("lvl") * 0.2F));
		    			}
		    		}

		    		if(nbt != null && nbt.getShort("id") == Enchantment.baneOfArthropods.effectId)
		    		{
		    			//虫特攻
		    			if(damager instanceof EntitySpider ||
				    	   damager instanceof EntitySilverfish ||
				    	   (monster != null && DQR.calcDamage.isInsectMob(monster)))
				    	{
				    		event.ammount = event.ammount * (1.0F + (nbt.getShort("lvl") * 0.2F));
				    	}
		    		}
		    	}
			}


			Map<Integer, Float> retMap = DQR.weaponBooster.getBooster(handItem);

			if(retMap.containsKey(DQR.weaponBooster.DRAGON))
			{
				if(damager instanceof EntityDragon ||
					(monster != null && monster.MobRoot == EnumDqmMobRoot.DRAGON))
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.DRAGON);
				}
			}

			if(retMap.containsKey(DQR.weaponBooster.WATER))
			{
				if(DQR.calcDamage.isWaterMob(monster))
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.WATER);
				}
			}

			if(retMap.containsKey(DQR.weaponBooster.UNDEAD))
			{
				if(monster != null && monster.MobRoot == EnumDqmMobRoot.UNDEAD)
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.UNDEAD);
				}
			}

			if(retMap.containsKey(DQR.weaponBooster.MACHINE))
			{
				if(DQR.calcDamage.isMachineMob(monster))
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.MACHINE);
				}
			}

			if(retMap.containsKey(DQR.weaponBooster.ELEMENT))
			{
				if(DQR.calcDamage.isElementMob(monster))
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.ELEMENT);
				}
			}

			if(retMap.containsKey(DQR.weaponBooster.SLIME))
			{
				if(monster != null && monster.MobRoot == EnumDqmMobRoot.SURAIMU)
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.SLIME);
				}
			}

			if(retMap.containsKey(DQR.weaponBooster.BUSSHITU))
			{
				if(monster != null && monster.MobRoot == EnumDqmMobRoot.BUSSITU)
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.BUSSHITU);
				}
			}

			if(retMap.containsKey(DQR.weaponBooster.PLANT))
			{
				if(DQR.calcDamage.isPlantMob(monster))
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.PLANT);
				}
			}

			if(retMap.containsKey(DQR.weaponBooster.BIRD))
			{
				if(DQR.calcDamage.isBirdMob(monster))
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.BIRD);
				}
			}

			if(retMap.containsKey(DQR.weaponBooster.AKUMA))
			{
				if(monster != null && monster.MobRoot == EnumDqmMobRoot.AKUMA)
				{
					event.ammount = event.ammount * retMap.get(DQR.weaponBooster.AKUMA);
				}
			}

		}

	}

	@SubscribeEvent(priority=EventPriority.LOWEST)
	public void onLivingHurtEvent(LivingHurtEvent event) {

		int varDifficulty = DQR.conf.DqmEndoraDifficulty == -1 ? DQR.conf.DqmDifficulty : DQR.conf.DqmEndoraDifficulty;
		EnumDqmEndoraParam enumEndora = DQR.enumGetter.getEndoraParam(varDifficulty);

		if(event.source instanceof EntityDamageSource)
		{
			//System.out.println("TEST!!!!!!!!!!!");
			//System.out.println(event.source.getDamageType());
		}else
		{
			//System.out.println("NOOOOOOOOOOOOOOOOO!!");
		}
		//DQR.func.debugString("DAMTEST_A:" + event.ammount);

		if(event.entityLiving != null)
		{

			//System.out.println("TEST:" + event.source.getSourceOfDamage().getCommandSenderName());
			//System.out.println("TEST:" + event.source.getEntity().getCommandSenderName());
			EntityLivingBase elv = event.entityLiving;
			//System.out.println("TEST:" + event.source.getDamageType());
			//ルカニのダメージ加算
			//System.out.println("TEST1:" + event.source.getDamageType());
			//System.out.println("TEST2:" + DamageSource.causeThornsDamage(elv).getDamageType());
			if(event.source.getDamageType().equalsIgnoreCase(DamageSource.causeThornsDamage(elv).getDamageType()))
			{
				try
				{
					double damThorn = elv.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
					//System.out.println("TEST2:" + damThorn);
					event.ammount = (float)(damThorn / (2 + rand.nextInt(3)));
				}catch (Exception e)
				{
					System.out.println("Thorn damage calculate Error.");
				}
			}

			//盾情報取得
			Item shield = null;
			if(event.entityLiving instanceof EntityPlayer)
			{
				EntityPlayer pl = (EntityPlayer)event.entityLiving;

	        	InventorySubEquip subEquip = new InventorySubEquip(pl);
	        	subEquip.openInventory();

		    	if(subEquip != null && subEquip.getStackInSlot(11) != null)
		    	{
		    		shield = subEquip.getStackInSlot(11).getItem();

		    	}

			}

			//EntityLivingBase elv = (EntityLivingBase)event.source.getEntity();
			if(event.source.getDamageType().equalsIgnoreCase("player") ||
			   event.source.getDamageType().equalsIgnoreCase("mob") ||
			   event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkill.getDamageType()) ||
			   event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSpecial.getDamageType()))
			{
				PotionEffect pe = elv.getActivePotionEffect(DQPotionMinus.debuffRukani);
				if(pe != null)
				{
					event.ammount = event.ammount +  (event.ammount / (2 - pe.getAmplifier()));
				}
			}

			//スカラのダメージ計算
			//if(!(event.source.getEntity() instanceof EntityPlayer) && event.source.getEntity() instanceof EntityLivingBase)
			//{
			//EntityLivingBase elv = (EntityLivingBase)event.source.getEntity();
			if(event.source.getDamageType().equalsIgnoreCase("player") ||
			   event.source.getDamageType().equalsIgnoreCase("mob") ||
			   event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkill.getDamageType()) ||
			   event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSpecial.getDamageType()))
			{
				PotionEffect pe = elv.getActivePotionEffect(DQPotionPlus.buffSukara);
				if(pe != null)
				{
					event.ammount = event.ammount -  (event.ammount / (4 - (pe.getAmplifier() * 2)));
				}
			}
			//}


			//ディバインスペル
			//if(event.source.getEntity() instanceof EntityLivingBase)
			//{
			//EntityLivingBase elv = (EntityLivingBase)event.source.getEntity();
			PotionEffect pe = elv.getActivePotionEffect(DQPotionMinus.debuffDivainsuperu);

			if(DQR.damageSource.isDqmMagicDamage(event.source))
			{

				if(pe != null)
				{
					event.ammount = event.ammount +  (event.ammount / (2 - pe.getAmplifier()));
				}
			}
			//}

			//マジックバリアのダメージ計算
			//if(event.source.getEntity() instanceof EntityLivingBase)
			//{
			//EntityLivingBase elv = (EntityLivingBase)event.source.getEntity();
			pe = elv.getActivePotionEffect(DQPotionPlus.buffMagicBaria);

			if(DQR.damageSource.isDqmMagicDamage(event.source))
			{

				if(pe != null)
				{
					event.ammount = event.ammount -  (event.ammount / (4 - (pe.getAmplifier() * 2)));
				}
			}
			//}



			//バーハのダメージ計算
			//if(event.source.getEntity() instanceof EntityLivingBase)
			//{
			//EntityLivingBase elv = (EntityLivingBase)event.source.getEntity();
			pe = elv.getActivePotionEffect(DQPotionPlus.buffBaha);

			if(pe != null)
			{
				if(event.source.getDamageType().equalsIgnoreCase(DamageSource.onFire.getDamageType()) ||
				   event.source.getDamageType().equalsIgnoreCase(DamageSource.inFire.getDamageType()) ||
				   event.source.getDamageType().equalsIgnoreCase(DamageSource.lava.getDamageType()) ||
				   event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmHeavyFire.getDamageType()))
				{
					event.ammount = 0;
					event.setCanceled(true);
					if(elv.isBurning())
					{

					}
					elv.extinguish();

					return;
				}else if(DQR.damageSource.isDqmBreathDamage(event.source))
				{
					event.ammount = event.ammount -  (event.ammount / (4 - (pe.getAmplifier() * 2)));
				}
			}
			//}

			//火草
			//if(event.source.getEntity() instanceof EntityLivingBase)
			//{
			//EntityLivingBase elv = (EntityLivingBase)event.source.getEntity();
			pe = elv.getActivePotionEffect(DQPotionPlus.potionHonoonomi);

			if(pe != null)
			{
				if(event.source.getDamageType().equalsIgnoreCase(DamageSource.onFire.getDamageType()) ||
				   event.source.getDamageType().equalsIgnoreCase(DamageSource.inFire.getDamageType()) ||
				   event.source.getDamageType().equalsIgnoreCase(DamageSource.lava.getDamageType()) ||
				   event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmHeavyFire.getDamageType()))
				{
					event.ammount = 0;
					event.setCanceled(true);
					if(elv.isBurning())
					{

					}
					elv.extinguish();

					return;
				}else if(DQR.damageSource.isDqmFireDamage(event.source))
				{
					event.ammount = event.ammount -  (event.ammount / (4 - (pe.getAmplifier() * 2)));
				}
			}

			//}
			//盾の耐性計算
			if(shield != null)
			{
				if(shield == DQAccessories.itemHonoonotate)
				{
					if(DQR.damageSource.isDqmFireDamage(event.source))
					{
						event.ammount = event.ammount / 4 * 3;
					}
				}else if(shield == DQAccessories.itemKoorinotate)
				{
					if(DQR.damageSource.isDqmIceDamage(event.source))
					{
						event.ammount = event.ammount / 4 * 3;
					}
				}else if(shield == DQAccessories.itemMahounotate)
				{
					if(DQR.damageSource.isDqmMagicDamage(event.source))
					{
						event.ammount = event.ammount / 4 * 3;
					}
				}else if(shield == DQAccessories.itemMegaminotate)
				{
					if(DQR.damageSource.isDqmMagicDamage(event.source))
					{
						event.ammount = event.ammount / 2;
					}
				}
			}
		}


//System.out.println("TEST1:" + event.ammount);
		if(event.source.getEntity() != null && !(event.source.getDamageType().equalsIgnoreCase(DamageSource.causeThornsDamage(event.entityLiving).getDamageType()))){

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
					EnumDqmElement element = null;
					Item handItem = null;

					if(ep.getHeldItem() != null)
					{
						handItem = ep.getHeldItem().getItem();
					}

					if(handItem instanceof DqmItemBowBase)
					{
						element = ((DqmItemBowBase)handItem).getElement();
					}else if(handItem instanceof DqmItemThrowBase)
					{
						element = ((DqmItemThrowing)handItem).getElement();
					}

					if(element != null)
					{
						float dam = event.ammount;
						//event.ammount = event.ammount * DQR.calcDamage.applyDamageResistElement(dam, dam, event.entityLiving, element);
						event.ammount = DQR.calcDamage.applyDamageResistElement(dam, dam, event.entityLiving, element);
					}


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

//System.out.println("TEST2:" + event.ammount);
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

				if(!event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillDeath.getDamageType()) &&
				   !event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSpecialDeath.getDamageType()) &&
				   !criticalFlg)
				{
					if(event.source.getDamageType().equalsIgnoreCase(DamageSource.generic.getDamageType()) ||
					   DQR.damageSource.isDqmSkillDamage(event.source))
					{
						if(rand.nextInt(1000) < DQR.func.getMikawasi(event.entityLiving))
						{
							if(!event.entityLiving.worldObj.isRemote)
							{
								event.entityLiving.worldObj.playSoundAtEntity(event.entityLiving, "dqr:player.miss", 1.0F, 1.0F);
							}

							event.ammount = -1;
							event.setCanceled(true);
							return;
						}
					}
				}
			}else if(event.source.getEntity() instanceof EntityPlayer)
			{
				EntityPlayer epr = (EntityPlayer)event.source.getEntity();
				int criticalVal = ExtendedPlayerProperties.get(epr).getKaisinritu() + 5;

				if(event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillCri.getDamageType()) ||
				   event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSpecialCri.getDamageType()) ||
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
				if((event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillDeath.getDamageType()) ||
					event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSpecialDeath.getDamageType())) &&
					event.ammount > 1.0F)
				{
					event.ammount = event.entityLiving.getMaxHealth() + 100.0F;
				}

				//DQR.func.debugString("DAMTEST_E:" + event.ammount);


				//回避チェック
				if(!event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillDeath.getDamageType()) &&
				   !event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSpecialDeath.getDamageType()) &&
				   !criticalFlg)
				{
					if(event.source.getDamageType().equalsIgnoreCase(DamageSource.generic.getDamageType()) ||
					   DQR.damageSource.isDqmSkillDamage(event.source))
					{
						if(rand.nextInt(1000) < DQR.func.getMikawasi(event.entityLiving))
						{
							if(!event.entityLiving.worldObj.isRemote)
							{
								event.entityLiving.worldObj.playSoundAtEntity(event.entityLiving, "dqr:player.miss", 1.0F, 1.0F);
							}
							event.ammount = -1;
							event.setCanceled(true);
							return;
						}
					}
				}


				if(!(event.entityLiving instanceof DqmMobBase))
				{
					if(!epr.worldObj.isRemote)
					{
						float dam = DQR.calcDamage.getDummyDamage(event.ammount, event.entityLiving, event.source);

						if ((event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillDeath.getDamageType()) ||
							 event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSpecialDeath.getDamageType())) &&
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
			}else
			{
				//回避チェック
				if(!event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSkillDeath.getDamageType()) &&
				   !event.source.getDamageType().equalsIgnoreCase(DQR.damageSource.DqmPlayerSpecialDeath.getDamageType()) &&
				   !criticalFlg)
				{
					if(event.source.getDamageType().equalsIgnoreCase(DamageSource.generic.getDamageType()) ||
					   DQR.damageSource.isDqmSkillDamage(event.source))
					{
						if(rand.nextInt(1000) < DQR.func.getMikawasi(event.entityLiving))
						{
							if(!event.entityLiving.worldObj.isRemote)
							{
								event.entityLiving.worldObj.playSoundAtEntity(event.entityLiving, "dqr:player.miss", 1.0F, 1.0F);
							}
							event.ammount = -1;
							event.setCanceled(true);
							return;
						}
					}
				}
			}

			if(event.entityLiving instanceof EntityPlayer)
			{
				EntityPlayer ep = (EntityPlayer)event.entityLiving;

				ep.inventory.damageArmor(event.ammount);

		    	InventorySubEquip equipment = new InventorySubEquip(ep);
		        equipment.openInventory();

		        for(int cnt = 0; cnt < equipment.getSizeInventory(); cnt++)
		        {
		        	if(!ep.worldObj.isRemote && equipment.getStackInSlot(cnt) != null && (equipment.getStackInSlot(cnt).getItem() instanceof ISubEquip) && ((ISubEquip)equipment.getStackInSlot(cnt).getItem()).isDamageable2())
		        	{
		        		//EnumDqmAccessory accParam = DQR.enumGetter.getAccessoryParam(equipment.getStackInSlot(cnt).getItem());
		        		ItemStack stack = equipment.getStackInSlot(cnt);
		        		if(equipment.getItemDamgePercent(stack) < 95)
		        		{
		        			stack.damageItem(1, ep);
		        		}

		        		equipment.setInventorySlotContents(cnt, stack);
		        		//System.out.println("TEST");
		        	}
		        }
		        equipment.closeInventory();

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
//System.out.println("TEST3:" + event.ammount);
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
