package dqr.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQAccessories;
import dqr.api.enums.EnumDqmEndoraParam;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmMessageConv;
import dqr.api.enums.EnumDqmMonster;
import dqr.api.enums.EnumDqmSkillW;
import dqr.api.enums.EnumDqmWeapon;
import dqr.api.event.DqrMobPrizeEvent;
import dqr.api.potion.DQPotionEtc;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.dataTable.FuncJobSkillData;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.petEntity.DqmPetBase;
import dqr.entity.throwingEntity.throwing.ThrowingEntity;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.items.base.DqmItemBowBase;
import dqr.items.base.DqmItemMagicBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties2;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.ExtendedPlayerProperties4;
import dqr.playerData.ExtendedPlayerProperties5;
import dqr.playerData.ExtendedPlayerProperties6;
import dqr.playerData.MessagePlayerProperties;
import dqr.thread.NoThreadProcess;
import dqr.thread.ThreadJukurenUp;

public class LivingEventHandler {

	@SubscribeEvent
	public void onLivingAttackRarihoCheck(LivingAttackEvent event)
	{
		if(event.source != null && event.entityLiving != null)
		{
			if(event.entityLiving.isPotionActive(DQPotionMinus.debuffRariho))
			{
				Random rand = new Random();
				if(rand.nextInt(2) == 0)
				{
					event.entityLiving.removePotionEffect(DQPotionMinus.debuffRariho.id);
				}
			}
		}
	}


	@SubscribeEvent
	public void onLivingSetAttackTarge(LivingSetAttackTargetEvent event)
	{
		if(event.entity instanceof DqmMobBase)
		{
			DqmMobBase mob = (DqmMobBase)event.entity;

			if(mob.mobAI.getHeavyFire() > 0)
			{
				if(event.target instanceof EntityPlayer)
				{
					DQR.func.addPotionEffect2(event.target, new PotionEffect(DQPotionMinus.debuffHeavyFire.id, 60, mob.mobAI.getHeavyFire()));
				}
			}

			//武器特技
			if(event.target instanceof EntityPlayer)
			{
				Random rand = new Random();
				EntityPlayer ep = (EntityPlayer)event.target;
    			int weapon = ExtendedPlayerProperties.get(ep).getWeapon();
    			int weaponSkill = ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(weapon);
    			int skillPerm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(weapon, weaponSkill);
    			float damDummy = (float)ExtendedPlayerProperties.get(ep).getKougeki();

    			EnumDqmSkillW skillW = DQR.enumGetter.getSkillW(weapon, weaponSkill);
				if(skillW != null && skillW.getFunc() == 1 && skillW.getRATE() > rand.nextInt(100))
				{
	    			if(mob.isFirstAttack && weapon == EnumDqmWeapon.DqmLance.getId() && weaponSkill == 0 && skillPerm != 0)
	    			{
	    				//しっぷう突き
						DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
						event.entity.hurtResistantTime = 0;
						event.entity.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (damDummy * 0.75F));
						event.entity.hurtResistantTime = 0;
	    			}
				}
			}


			mob.isFirstAttack = false;
		}
	}

	/*
	@SubscribeEvent
	public void onJumping(LivingEvent.LivingJumpEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)event.entityLiving;
			int ampli = 0;
			float xzFix = 0.0F;

	        if (ep.isPotionActive(Potion.jump))
	        {
	        	ampli = ampli + ep.getActivePotionEffect(Potion.jump).getAmplifier() + 1;
	            //this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
	        }
	        if (ep.isPotionActive(DQPotionPlus.potionSubayasanotane))
	        {
	        	ampli = ampli + ep.getActivePotionEffect(DQPotionPlus.potionSubayasanotane).getAmplifier() + 1;
	        }
	        if (ep.isPotionActive(DQPotionPlus.potionOugonnomi))
	        {
	        	ampli = ampli + ep.getActivePotionEffect(DQPotionPlus.potionOugonnomi).getAmplifier() + 1;
	        }

	        xzFix += xzFix + (float)ampli * 0.2F;
            //this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);

	        ep.motionY = 0.41999998688697815D;
	        ep.motionY += (double)((float)ampli * 0.1F);

            float var1 = ep.rotationYaw * 0.017453292F;
            ep.motionX -= (double)(MathHelper.sin(var1) * (double)xzFix);
            ep.motionZ += (double)(MathHelper.cos(var1) * (double)xzFix);
		}
	}
	*/
	@SubscribeEvent
	public void onJumping(LivingEvent.LivingJumpEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)event.entityLiving;
			int ampli = 0;
			float xzFix = 0.0F;

	        if (ep.isPotionActive(Potion.jump))
	        {
	        	ampli = ampli + ep.getActivePotionEffect(Potion.jump).getAmplifier() + 1;
	            //this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
	        }
	        if (ep.isPotionActive(DQPotionPlus.potionSubayasanotane))
	        {
	        	ampli = ampli + ep.getActivePotionEffect(DQPotionPlus.potionSubayasanotane).getAmplifier() + 1;
	        }
	        if (ep.isPotionActive(DQPotionPlus.potionOugonnomi))
	        {
	        	ampli = ampli + ep.getActivePotionEffect(DQPotionPlus.potionOugonnomi).getAmplifier() + 1;
	        }

	        if (ep.isPotionActive(DQPotionPlus.buffHoshihuru))
	        {
	        	ampli = ampli + ep.getActivePotionEffect(DQPotionPlus.buffHoshihuru).getAmplifier() + 1;
	        }

	        xzFix += xzFix + (float)ampli * 0.2F;
            //this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);

	        ep.motionY = 0.41999998688697815D;
	        ep.motionY += (double)((float)ampli * 0.1F);

            float var1 = ep.rotationYaw * 0.017453292F;

            double tmp1 = ep.motionX;
            double tmp2 = ep.motionZ;

            if(!ep.isSneaking())
            {
            	ep.motionX -= (double)(MathHelper.sin(var1) * (double)xzFix);
            	ep.motionZ += (double)(MathHelper.cos(var1) * (double)xzFix);
            }
		}
	}


	@SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event) {

		Random rand = new Random();

		/*
		if(event.source != null && event.source.getEntity() != null)
		{
			//System.out.println("XXX:" + event.source.getEntity().getCommandSenderName());
		}
		*/

		if(event.source != null && event.source.getEntity() instanceof ThrowingEntity)
		{
			if( event.source.getSourceOfDamage() instanceof EntityPlayer)
			{
				//DQR.func.debugString("Line2");
				EntityPlayer killer = (EntityPlayer)event.source.getSourceOfDamage();

				if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(killer).getJob(),
						EnumDqmWeapon.DqmThrow.getId(), killer) > -1)
				{
					int prevJukurenExp = ExtendedPlayerProperties.get(killer).getJukurenExp(EnumDqmWeapon.DqmThrow.getId());
					int getJukurenExp = 1 + ExtendedPlayerProperties.get(killer).getJukurenExp(EnumDqmWeapon.DqmThrow.getId());
					ExtendedPlayerProperties.get(killer).setJukurenExp(EnumDqmWeapon.DqmThrow.getId(), getJukurenExp);

					if((prevJukurenExp%100) > (getJukurenExp%100))
					{
						int jukurenWP = ExtendedPlayerProperties.get(killer).getJukurenWP(EnumDqmWeapon.DqmThrow.getId());
						if(jukurenWP < 500)
						{
							ExtendedPlayerProperties.get(killer).setJukurenWP(EnumDqmWeapon.DqmThrow.getId(), jukurenWP + 1);
						}
					}

		            //ThreadJukurenUp jukurenUp = new ThreadJukurenUp(killer);
		            //jukurenUp.start();
		            if(DQR.conf.cfg_NoThreadUse == 1)
		            {
		            	//ThreadLvUp lvup = new ThreadLvUp(ep);
		            	//lvup.start();
			            ThreadJukurenUp jukurenUp = new ThreadJukurenUp(killer);
			            jukurenUp.start();
		            }else
		            {
		            	NoThreadProcess proc = new NoThreadProcess();
		            	proc.doJukurenUp(killer);
		            	//proc.doLevelUp(ep);
		            }


				}
			}
		}else
		{
			EntityPlayer killer = null;
			//System.out.println("TESTX");
			if( event.source.getSourceOfDamage() instanceof EntityPlayer)
			{
				killer = (EntityPlayer)event.source.getSourceOfDamage();
			}else if( event.source.getEntity() instanceof EntityPlayer)
			{
				killer = (EntityPlayer)event.source.getEntity();
			}

			if(killer != null)
			{
				//DQR.func.debugString("Line2");
	        	int getJukurenLv;
	        	int getJukurenExp = 0;
	        	int prevJukurenExp = ExtendedPlayerProperties.get(killer).getJukurenExp(EnumDqmWeapon.DqmThrow.getId());
	            ItemStack handItem = null;

	            if(killer.inventory.getCurrentItem() != null)
	            {
	            	handItem = killer.inventory.getCurrentItem();
	            }

	        	if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(killer).getJob(),
						  ExtendedPlayerProperties.get(killer).getWeapon(), killer) > -1)
				{
					getJukurenExp = 1 + ExtendedPlayerProperties.get(killer).getJukurenExp(ExtendedPlayerProperties.get(killer).getWeapon());
					ExtendedPlayerProperties.get(killer).setJukurenExp(ExtendedPlayerProperties.get(killer).getWeapon(), getJukurenExp);
				}else if((handItem != null && (handItem.getItem() instanceof ItemSword || handItem.getItem() instanceof ItemBow)) &&
					 DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(killer).getJob(),
					 EnumDqmWeapon.DqmVanillaS.getId(), killer) > -1)
				{
					getJukurenExp = 1 + ExtendedPlayerProperties.get(killer).getJukurenExp(EnumDqmWeapon.DqmVanillaS.getId());
					ExtendedPlayerProperties.get(killer).setJukurenExp(EnumDqmWeapon.DqmVanillaS.getId(), getJukurenExp);
				}else if(handItem != null && handItem.getItem() instanceof DqmItemMagicBase)
				{
					//int[] magicTable = DQR.magicTable.getMagicLvTable(handItem.getItem());
					if(DQR.magicTable.getMAptitude(handItem.getItem(), killer) > 0)
					{
						getJukurenExp = 1 + ExtendedPlayerProperties.get(killer).getJukurenExp(ExtendedPlayerProperties.get(killer).getWeapon());
						ExtendedPlayerProperties.get(killer).setJukurenExp(ExtendedPlayerProperties.get(killer).getWeapon(), getJukurenExp);
					}
				}else
				{
					if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(killer).getJob(),
							EnumDqmWeapon.DqmNoHand.getId(), killer) > -1)
					{
						getJukurenExp = 1 + ExtendedPlayerProperties.get(killer).getJukurenExp(EnumDqmWeapon.DqmNoHand.getId());
						ExtendedPlayerProperties.get(killer).setJukurenExp(EnumDqmWeapon.DqmNoHand.getId(), getJukurenExp);
					}
				}

				if((prevJukurenExp%100) > (getJukurenExp%100) && getJukurenExp != 0)
				{
					int jukurenWP = ExtendedPlayerProperties.get(killer).getJukurenWP(EnumDqmWeapon.DqmThrow.getId());
					if(jukurenWP < 500)
					{
						ExtendedPlayerProperties.get(killer).setJukurenWP(EnumDqmWeapon.DqmThrow.getId(), jukurenWP + 1);
					}
				}

	            //ThreadJukurenUp jukurenUp = new ThreadJukurenUp(killer);
	            //jukurenUp.start();
	            if(DQR.conf.cfg_NoThreadUse == 1)
	            {
	            	//ThreadLvUp lvup = new ThreadLvUp(ep);
	            	//lvup.start();
		            ThreadJukurenUp jukurenUp = new ThreadJukurenUp(killer);
		            jukurenUp.start();
	            }else
	            {
	            	NoThreadProcess proc = new NoThreadProcess();
	            	proc.doJukurenUp(killer);
	            	//proc.doLevelUp(ep);
	            }
			}

		}

		if(event.entityLiving instanceof DqmMobBase)
		{
			DqmMobBase mb = (DqmMobBase)event.entityLiving;
			//DQR.func.debugString("LivingEvent:" + mb.DqmMobEXP);
			mb.doGoldGet();
			mb.doExpGet();

			boolean petFlg = false;

			//ペット化判定
			if(mb instanceof DqmMobBase)
			{
				int petChance = mb.CPET;
				int fixChance = 0;

				EntityPlayer killer = null;

				int chanceFix = (int)(DQR.conf.petChanceFix * 10);

				if(chanceFix > 0 && rand.nextInt(chanceFix) < 10 && ((DqmMobBase)mb).petRefuseFlg != 2)
				{

					//肉使用確認
					PotionEffect pe = mb.getActivePotionEffect(DQPotionEtc.buffMonsterNiku);
					if(pe != null)
					{
						petChance = petChance / ((pe.getAmplifier() + 1) *  2);
					}

					//職業補正
					if(event.source.getSourceOfDamage() instanceof EntityPlayer)
					{
						killer = (EntityPlayer)event.source.getSourceOfDamage();

						int killerJob = ExtendedPlayerProperties.get(killer).getJob();

						if(killerJob == EnumDqmJob.Densetsu.getId() || killerJob == EnumDqmJob.MASTERDRAGON.getId())
						{
							petChance = petChance / 2;
							fixChance = fixChance + 1;
						}else if(killerJob == EnumDqmJob.Yuusha.getId())
						{
							fixChance = fixChance + 1;
						}else if(killerJob == EnumDqmJob.Mamonotukai.getId())
						{
							petChance = petChance / 2;
						}else if(killerJob == EnumDqmJob.Dragon.getId() || killerJob == EnumDqmJob.Haguremetal.getId())
						{
							fixChance = fixChance + 1;
						}
					}


					//実際にペットになる処理
					petChance = petChance <= 1 ? 1 : petChance;
					fixChance = fixChance >= petChance ? petChance - 1 : fixChance;

					//System.out.println("TEST" + fixChance + " / " + petChance);

					//System.out.println("PET: " + petChance + " / " + fixChance );
					if(rand.nextInt(petChance) <= fixChance || DQR.debug == 3)
					{
						mb.worldObj.playSoundAtEntity(mb, "dqr:mob.petmob", 1.0F, 1.5F);
						if(!mb.worldObj.isRemote)
						{
							EnumDqmMonster monsterType = mb.monsterType;

							if(killer != null)
							{
								DQR.func.doAddChatMessageFix(killer, new ChatComponentTranslation("msg.pet.taming1.txt",new Object[] { event.entityLiving.getCommandSenderName()}));
								DQR.func.doAddChatMessageFix(killer, new ChatComponentTranslation("msg.pet.taming2.txt",new Object[] {}));
								DQR.func.doAddChatMessageFix(killer, new ChatComponentTranslation("msg.pet.taming3.txt",new Object[] {}));
								DQR.func.doAddChatMessageFix(killer, new ChatComponentTranslation("msg.pet.taming4.txt",new Object[] {}));
							}

							petFlg = true;

							String petName = monsterType.getPetClassName();
							//SystemOutPrint
							Entity entity = EntityList.createEntityByName(DQR.modID + "." + petName, mb.worldObj);
							if(entity != null)
							{
								double[] spawnLocation = DQR.func.serchAirLocation(mb, mb.posX, mb.posY, mb.posZ);
								//entity.setLocationAndAngles((double)mb.posX + 0.5D, (double)mb.posY + 1.0D, (double)mb.posZ + 0.5D, 0.0F, 0.0F);
								entity.setLocationAndAngles(spawnLocation[0], spawnLocation[1], spawnLocation[2], 0.0F, 0.0F);
								mb.worldObj.spawnEntityInWorld(entity);
							}else
							{
								System.out.println("Taming process Error: " + mb.getCommandSenderName() + " / " + DQR.modID + "." + petName);
							}
						}
					}
				}
			}

			//転生判定(ペット判定後)
			if(mb.TenseiMob != null && !petFlg)
			{
				//System.out.println("TEST1");
				if(rand.nextInt(mb.CTENSEI) == 0 || (mb.isPotionActive(DQPotionEtc.buffShinkanoHiseki) && rand.nextInt(2) == 0) || DQR.debug == 2)
				{
					int looper = 1;
					if(mb.TenseiMax> 1)
					{
						looper = mb.TenseiMin + rand.nextInt((mb.TenseiMax + 1 - mb.TenseiMin));
					}
					//System.out.println("TEST3" + mb.TenseiMob);

					switch(mb.CTENSEIsp)
					{
						case 1: if(!mb.worldObj.isRemote)mb.worldObj.playSoundAtEntity(mb, "dqr:mob.inoti", 1.0F, 1.0F); break;
						case 2: if(!mb.worldObj.isRemote)mb.worldObj.playSoundAtEntity(mb, "dqr:mob.poyo", 1.0F, 1.0F); break;
					}

					for(int cnt = 0; cnt < looper; cnt++)
					{
						DqmMobBase tenseiMonster = (DqmMobBase)EntityList.createEntityByName(DQR.modID + "." + mb.TenseiMob, mb.worldObj);
						if(tenseiMonster != null)
						{
							//System.out.println("TEST4");
							double posX = mb.posX;
							double posZ = mb.posZ;

							if(cnt != 0)
							{
								posX = posX + rand.nextInt(3);
								posZ = posZ + rand.nextInt(3);
							}

							tenseiMonster.setPosition(posX, mb.posY + 1, posZ);

							if(!mb.worldObj.isRemote)
							{
								mb.worldObj.spawnEntityInWorld(tenseiMonster);
							}
						}
					}
				}
			}
		}else
		{
			if(!(event.entityLiving instanceof EntityPlayer))
			{
				EntityLivingBase elb = event.entityLiving;

				//DQR.func.debugString("Line1");
				if(event.source != null &&
				   event.source.getSourceOfDamage() instanceof EntityPlayer)
				{
					//DQR.func.debugString("Line2");
					EntityPlayer killer = (EntityPlayer)event.source.getSourceOfDamage();
					float maxHP = elb.getMaxHealth();
					int calcEXP = 0;
					int calcGold = 0;
					if(elb instanceof EntityDragon)
					{
						int varDifficulty = DQR.conf.DqmEndoraDifficulty == -1 ? DQR.conf.DqmDifficulty : DQR.conf.DqmEndoraDifficulty;
						EnumDqmEndoraParam enumEndora = DQR.enumGetter.getEndoraParam(varDifficulty);

						calcEXP = enumEndora.getExpi();
						calcGold = 88888;
					}else
					{

						DqrMobPrizeEvent eventX = new DqrMobPrizeEvent(elb, killer, event);
						eventX.setCanceled(false);
						MinecraftForge.EVENT_BUS.post(eventX);
						if(!eventX.isCanceled())
						{

							if(maxHP < 25.0F)
							{
								calcEXP = (int)maxHP / 4;
								calcGold = (int)maxHP / 8;
							}else if(maxHP < 100.0F)
							{
								calcEXP = (int)maxHP / 2;
								calcGold = (int)maxHP / 4;
							}else if(maxHP < 500.0F)
							{
								calcEXP = (int)maxHP;
								calcGold = (int)maxHP/2;
							}else if(maxHP < 1000.0F)
							{
								calcEXP = (int)(maxHP * 1.5);
								calcGold = (int)maxHP;
							}else
							{
								calcEXP = (int)(maxHP * 2);
								calcGold = (int)maxHP;
							}
						}else
						{
							calcEXP = eventX.getExp();
							calcGold = eventX.getGold();
						}
					}
					calcGold = calcGold + ExtendedPlayerProperties.get(killer).getGold();
		            ExtendedPlayerProperties.get(killer).setGold(calcGold);
		            DQR.partyManager.doExpShare(killer, calcEXP);
		            /*
					calcEXP = calcEXP + ExtendedPlayerProperties.get(killer).getJobExp(ExtendedPlayerProperties.get(killer).getJob());
		            ExtendedPlayerProperties.get(killer).setJobExp(ExtendedPlayerProperties.get(killer).getJob(), calcEXP);

		            //ThreadLvUp lvup = new ThreadLvUp(killer);
		            //lvup.start();
		            if(DQR.conf.cfg_NoThreadUse != 1)
		            {
		            	ThreadLvUp lvup = new ThreadLvUp(killer);
		            	lvup.start();
		            }else
		            {
		            	NoThreadProcess proc = new NoThreadProcess();
		            	proc.doLevelUp(killer);
		            }
					*/
		            /*
	            	int getJukurenLv;
	            	int getJukurenExp;
	                ItemStack handItem = null;

	                if(killer.inventory.getCurrentItem() != null)
	                {
	                	handItem = killer.inventory.getCurrentItem();
	                }

	            	if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(killer).getJob(),
							  ExtendedPlayerProperties.get(killer).getWeapon()) > 0)
					{
						getJukurenExp = 1 + ExtendedPlayerProperties.get(killer).getJukurenExp(ExtendedPlayerProperties.get(killer).getWeapon());
						ExtendedPlayerProperties.get(killer).setJukurenExp(ExtendedPlayerProperties.get(killer).getWeapon(), getJukurenExp);
					}else if((handItem != null && (handItem.getItem() instanceof ItemSword || handItem.getItem() instanceof ItemBow)) &&
						 DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(killer).getJob(),
						 EnumDqmWeapon.DqmVanillaS.getId()) > 0)
					{
						getJukurenExp = 1 + ExtendedPlayerProperties.get(killer).getJukurenExp(EnumDqmWeapon.DqmVanillaS.getId());
						ExtendedPlayerProperties.get(killer).setJukurenExp(EnumDqmWeapon.DqmVanillaS.getId(), getJukurenExp);
					}else if(handItem != null && handItem.getItem() instanceof DqmItemMagicBase)
					{
						int[] magicTable = DQR.magicTable.getMagicLvTable(handItem.getItem());
						if(magicTable != null && magicTable[ExtendedPlayerProperties.get(killer).getJob()] > 0)
						{
							getJukurenExp = 1 + ExtendedPlayerProperties.get(killer).getJukurenExp(ExtendedPlayerProperties.get(killer).getWeapon());
							ExtendedPlayerProperties.get(killer).setJukurenExp(ExtendedPlayerProperties.get(killer).getWeapon(), getJukurenExp);
						}
					}else
					{
						if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(killer).getJob(),
								EnumDqmWeapon.DqmNoHand.getId()) > 0)
						{
							getJukurenExp = 1 + ExtendedPlayerProperties.get(killer).getJukurenExp(EnumDqmWeapon.DqmNoHand.getId());
							ExtendedPlayerProperties.get(killer).setJukurenExp(EnumDqmWeapon.DqmNoHand.getId(), getJukurenExp);
						}
					}

	                ThreadJukurenUp jukurenUp = new ThreadJukurenUp(killer);
	                jukurenUp.start();
	                */

				}
			}
		}

		if(event.source.getSourceOfDamage() != null && event.source.getSourceOfDamage() instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)event.source.getSourceOfDamage();
			if(event.entityLiving instanceof DqmMobBase)
			{
				DqmMobBase mob = (DqmMobBase)event.entityLiving;
				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.defeatMob.txt",new Object[] { EnumDqmMessageConv.MonsterName.getStartS() + mob.getEntityStringForce() + EnumDqmMessageConv.MonsterName.getEndS()}));
			}else
			{
				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.defeatMob.txt",new Object[] { event.entityLiving.getCommandSenderName()}));
			}

			if(!ep.worldObj.isRemote)ep.worldObj.playSoundAtEntity(ep, "dqr:mob.death", 1.0F, 1.0F);

		}
	}

	@SubscribeEvent
    public void onLivingUpdate(LivingUpdateEvent event) {


    	if(event.entityLiving instanceof EntityPlayer)
    	{
    		//System.out.println("TIME" + event.entityLiving.ticksExisted);
    		EntityPlayer ep = (EntityPlayer)event.entityLiving;

    		if(ExtendedPlayerProperties.get(ep).getJobSkillCalcFlg())
    		{
    			FuncJobSkillData.calcPlayerStatus(ep);
    			FuncJobSkillData.calcPlayerStatus2(ep);
    			ExtendedPlayerProperties.get(ep).setJobSkillCalcFlg(false);
    		}
			//if(!ep.isPotionActive(Potion.confusion.id))
			//{
			//	DQR.func.addPotionEffect2(ep, new PotionEffect(Potion.confusion.id, 101, 4));
			//}
    		//if(ep.isPotionActive(DQPotionMinus.debuffManusa))
    		//{
    		/*
    			if(ep.worldObj.isRemote)
    			{
    				if(DQR.proxy.getMinecraft() != null)
    				{
    					if(!ep.isPotionActive(Potion.confusion.id))
    					{
    						DQR.func.addPotionEffect2(ep, new PotionEffect(Potion.confusion.id, 61, 4));
    					}

    					EntityPlayerSP epm = (EntityPlayerSP) DQR.proxy.getMinecraft().renderViewEntity;
    					epm.timeInPortal += 0.006666667F;
    					if(epm.timeInPortal >= 1.0F)
    					{
    						epm.timeInPortal = 0.1F;
    					}
    					//epm.timeInPortal = 1.0F;
    				}

    			}
    			*/
    		//}

    		//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("test"));
    		if(!ep.worldObj.isRemote)
    		{
        		int Mp = ExtendedPlayerProperties.get(ep).getMP();

    			//毎tick処理
        		int maxMp = ExtendedPlayerProperties.get(ep).getMaxMP();

        		if(Mp > maxMp)
        		{
        			ExtendedPlayerProperties.get(ep).setMP(maxMp);
        		}


        		if (ep.isPotionActive(DQPotionPlus.potionOugonnomi) ||
            			ep.isPotionActive(DQPotionPlus.potionSubayasanotane) ||
            			ep.isPotionActive(DQPotionPlus.buffHoshihuru) ||
            			ep.isPotionActive(Potion.jump))
        		{
        			ep.fallDistance = 0.0F;
        		}

    			//0.5秒処理
        		if(event.entityLiving.ticksExisted % 11 == 0)
        		{

        		}

    			//1秒処理
        		if(event.entityLiving.ticksExisted % 12 == 0)
        		{
	        		//アクセサリチェック
	        		DQR.calcPlayerStatus.calcAccessory(ep);
        		}

        		int buffFlg = ExtendedPlayerProperties.get(ep).getAccBuffStop();
    			//1秒処理
        		if(event.entityLiving.ticksExisted % 4 == 0 && buffFlg == 0)
        		{
        			PotionEffect pe = event.entityLiving.getActivePotionEffect(DQPotionPlus.potionHonoonomi);
        			if(pe != null)
        			{
        				DQR.func.addPotionEffect2(event.entityLiving, new PotionEffect(Potion.fireResistance.id, 80, 0));
        			}

	        		if(ExtendedPlayerProperties.get(ep).getJob() == 15)
	        		{
	        			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.skillTouzokuSpeed.id, 80, 0));
	        		}

        		}

    			//2秒処理
        		if(event.entityLiving.ticksExisted % 41 == 0)
        		{
        			ExtendedPlayerProperties.get(ep).setPlayerName(ep.getCommandSenderName());
        			ExtendedPlayerProperties.get(ep).setPlayerUUID(ep.getUniqueID().toString());
        			ExtendedPlayerProperties2.get(ep).setPlayerName(ep.getCommandSenderName());
        			ExtendedPlayerProperties2.get(ep).setPlayerUUID(ep.getUniqueID().toString());
        			ExtendedPlayerProperties3.get(ep).setPlayerName(ep.getCommandSenderName());
        			ExtendedPlayerProperties3.get(ep).setPlayerUUID(ep.getUniqueID().toString());
        			ExtendedPlayerProperties4.get(ep).setPlayerName(ep.getCommandSenderName());
        			ExtendedPlayerProperties4.get(ep).setPlayerUUID(ep.getUniqueID().toString());
        			ExtendedPlayerProperties5.get(ep).setPlayerName(ep.getCommandSenderName());
        			ExtendedPlayerProperties5.get(ep).setPlayerUUID(ep.getUniqueID().toString());
        			ExtendedPlayerProperties6.get(ep).setPlayerName(ep.getCommandSenderName());
        			ExtendedPlayerProperties6.get(ep).setPlayerUUID(ep.getUniqueID().toString());
        		}


    			//ExtendedPlayerProperties.get(ep).setMaxHP(ep.getMaxHealth());
        		if(event.entityLiving.ticksExisted % 3 == 0)
        		{
	    			ExtendedPlayerProperties.get(ep).setHP(ep.getHealth());
	    			ExtendedPlayerProperties.get(ep).setTikara(DQR.calcPlayerStatus.calcTikara(ep));
	    			ExtendedPlayerProperties.get(ep).setKasikosa(DQR.calcPlayerStatus.calcKasikosa(ep));
	    			DQR.calcPlayerStatus.calcSubayasa(ep);
	    			ExtendedPlayerProperties.get(ep).setBougyo(DQR.calcPlayerStatus.calcDeffence(ep));
	    			ExtendedPlayerProperties.get(ep).setKougeki(DQR.calcPlayerStatus.calcAttack(ep));
	    			ExtendedPlayerProperties.get(ep).setMaryoku(DQR.calcPlayerStatus.calcMaryoku(ep));
	    			ExtendedPlayerProperties.get(ep).setMaxHP(DQR.calcPlayerStatus.calcHP(ep));
	    			ExtendedPlayerProperties.get(ep).setMaxMP(DQR.calcPlayerStatus.calcMP(ep));
	    			ExtendedPlayerProperties.get(ep).setKaisinritu(DQR.calcPlayerStatus.calcKaisin(ep));
	    			ExtendedPlayerProperties.get(ep).setMikawasi(DQR.calcPlayerStatus.calcMikawasi(ep));

	    			//ExtendedPlayerProperties.get(ep).setMedal(ExtendedPlayerProperties.get(ep).getMedal());
	    			ep.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ExtendedPlayerProperties.get(ep).getMaxHP());
	    			if(ep.getCurrentEquippedItem()!= null)
	    			{
	    				if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemWeaponBase)
						{
		    				DqmItemWeaponBase itm = (DqmItemWeaponBase)ep.getCurrentEquippedItem().getItem();

		    				EnumDqmWeapon enumWeapon = EnumDqmWeapon.valueOf(itm.getMaterial().name());

		    				ExtendedPlayerProperties.get(ep).setWeapon(enumWeapon.getId());
						}else if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemBowBase)
						{
							DqmItemBowBase itm = (DqmItemBowBase)ep.getCurrentEquippedItem().getItem();

		    				ExtendedPlayerProperties.get(ep).setWeapon(EnumDqmWeapon.DqmBow.getId());
						}else if(ep.getCurrentEquippedItem().getItem() instanceof ItemSword ||
		    			   ep.getCurrentEquippedItem().getItem() instanceof ItemBow)
		    			{
		    				ExtendedPlayerProperties.get(ep).setWeapon(1);
		    			}else if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemMagicBase)
						{
		    				DqmItemMagicBase itm = (DqmItemMagicBase)ep.getCurrentEquippedItem().getItem();

		    				EnumDqmWeapon enumWeapon = EnumDqmWeapon.valueOf(itm.getMaterial().name());

		    				ExtendedPlayerProperties.get(ep).setWeapon(enumWeapon.getId());

						}else
		    			{
		    				ExtendedPlayerProperties.get(ep).setWeapon(0);
		    			}

	    			}else
	    			{
	    				ExtendedPlayerProperties.get(ep).setWeapon(0);
	    			}
	    			//System.out.println("LOG:" + ExtendedPlayerProperties.get(ep).getMaxHP());
	    			//System.out.println("LOG2:" + ExtendedPlayerProperties.get(ep).getHP());
	    			PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(ep), (EntityPlayerMP)ep);

	        		if(ep.getMaxHealth() > 0 && ep.getHealth() > ep.getMaxHealth())
	        		{
	        			ep.setHealth(ep.getMaxHealth());
	        		}
        		}
    		}


    	}else if(event.entityLiving instanceof DqmPetBase)
    	{

    		DqmPetBase pet = (DqmPetBase)event.entityLiving;


    		//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("test"));
    		if(!pet.worldObj.isRemote)
    		{

    			/*
        		if(event.entityLiving.ticksExisted % 20 == 0 && pet.getHealth() > 0.01f)
        		{
        			PotionEffect pe = pet.getActivePotionEffect(DQPotionPlus.potionMahounomi);
    	    		if(pe != null && pet.getHealth() > 0 && !pet.isDead)
    	    		{
    		    			int mp = pet.getMP();
    		    			if(pet.getMaxMP() < mp + (1 + (pe.getAmplifier() * 2)))
    		    			{
    		    				pet.setMP(pet.getMaxMP());
    		    			}else
    		    			{

    		    				pet.setMP(mp + (1 + (pe.getAmplifier() * 2)));
    		    			}
    	    			//ep.setHealth(1.0F + (pe.getAmplifier() * 2));
    	    		}

    	    		pe = pet.getActivePotionEffect(DQPotionPlus.buffMPRegeneration);
    	    		if(pe != null && pet.getHealth() > 0 && !pet.isDead)
    	    		{
    		    			int mp = pet.getMP();
    		    			if(pet.getMaxMP() < mp + (1 + (pe.getAmplifier() * 2)))
    		    			{
    		    				pet.setMP(pet.getMaxMP());
    		    			}else
    		    			{
    		    				pet.setMP(mp + (1 + (pe.getAmplifier() * 2)));
    		    			}
    	    			//ep.setHealth(1.0F + (pe.getAmplifier() * 2));
    	    		}
        		}
        		*/


    			/*
        		if(event.entityLiving.ticksExisted % 10 == 0 && pet.getHealth() > 0.01f)
        		{
        			PotionEffect pe = pet.getActivePotionEffect(DQPotionMinus.potionPoisonX);
    	    		if(pe != null)
    	    		{
    	    			//if(ep.worldObj.getWorldTime() % 10 == 0)

        				//if((ep.getHealth() - ((pe.getAmplifier() + 1) * 2)) > 1)
        				//{
        				//	ep.attackEntityFrom(DQR.damageSource.DqmPoisonX, ((pe.getAmplifier() + 1) * 2));
        				//	//ep.setHealth(ep.getHealth() - ((pe.getAmplifier() + 1) * 2));
        				//}


        				if(pet.getHealth() > 0)
        				{
        					pet.attackEntityFrom(DQR.damageSource.DqmPoisonX, ((pe.getAmplifier() + 1) * 2));
        					//ep.setHealth(ep.getHealth() - ((pe.getAmplifier() + 1) * 2));
        				}
    	    		}

    	    		pe = pet.getActivePotionEffect(DQPotionPlus.potionIyasinomi);
    	    		if(pe != null && pet.getHealth() > 0 && !pet.isDead)
    	    		{
        				if(pet.getMaxHealth() < pet.getHealth() + 1.0F + (pe.getAmplifier() * 2))
        				{
        					pet.setHealth(pet.getMaxHealth());
        				}else
        				{
        					//ep.setHealth(ep.getHealth() + 1.0F + (pe.getAmplifier() * 2));
        					pet.heal(1.0F + (pe.getAmplifier() * 2));
        				}
    	    		}


    	    		pe = pet.getActivePotionEffect(DQPotionPlus.buffHPRegeneration);
    	    		if(pe != null && pet.getHealth() > 0 && !pet.isDead)
    	    		{
        				if(pet.getMaxHealth() < pet.getHealth() + 1.0F + (pe.getAmplifier() * 2))
        				{
        					pet.setHealth(pet.getMaxHealth());
        				}else
        				{
        					//ep.setHealth(ep.getHealth() + 1.0F + (pe.getAmplifier() * 2));
        					pet.heal(1.0F + (pe.getAmplifier() * 2));
        				}
    	    		}
        		}
        		*/
    			//1秒処理
        		if(event.entityLiving.ticksExisted % 21 == 0)
        		{
        			PotionEffect pe = event.entityLiving.getActivePotionEffect(DQPotionPlus.potionHonoonomi);
	    			if(pe != null)
	    			{
	    				DQR.func.addPotionEffect2(event.entityLiving, new PotionEffect(Potion.fireResistance.id, 80, 0));
	    			}


	        		if(pet.getJob() == 15)
	        		{
	        			DQR.func.addPotionEffect2(pet, new PotionEffect(DQPotionPlus.skillTouzokuSpeed.id, 80, 0));
	        		}
        		}

    			//1秒処理
        		if(event.entityLiving.ticksExisted % 12 == 0)
        		{
	        		//アクセサリチェック
	        		DQR.calcPetStatus.calcAccessory(pet);
        		}

        		int Mp = pet.getMP();
        		int maxMp = pet.getMaxMP();

        		if(Mp > maxMp)
        		{
        			pet.setMP(maxMp);
        		}

        		if (pet.isPotionActive(DQPotionPlus.potionOugonnomi) ||
        			pet.isPotionActive(DQPotionPlus.potionSubayasanotane) ||
        			pet.isPotionActive(Potion.jump))
        		{
        			pet.fallDistance = 0.0F;
        		}

        		if(event.entityLiving.ticksExisted % 3 == 0)
        		{
	    			//System.out.println("TESTTEST");
	    			//ExtendedPlayerProperties.get(ep).setMaxHP(ep.getMaxHealth());
	    			pet.setHP(pet.getHealth());
	    			pet.setTikara(DQR.calcPetStatus.calcTikara(pet));
	    			pet.setKasikosa(DQR.calcPetStatus.calcKasikosa(pet));
	    			DQR.calcPetStatus.calcSubayasa(pet);
	    			pet.setBougyo(DQR.calcPetStatus.calcDeffence(pet));
	    			pet.setKougeki(DQR.calcPetStatus.calcAttack(pet));
	    			pet.setMaryoku(DQR.calcPetStatus.calcMaryoku(pet));
	    			pet.setMaxHP(DQR.calcPetStatus.calcHP(pet));
	    			pet.setMaxMP(DQR.calcPetStatus.calcMP(pet));
	    			//ExtendedPlayerProperties.get(ep).setMedal(ExtendedPlayerProperties.get(ep).getMedal());
	    			if(pet.getMaxHP() < pet.type.HPDEF && pet.isTamed())
	    			{
	    				pet.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(pet.type.HPDEF);
	    			}else
	    			{
	    				pet.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(pet.getMaxHP());
	    			}
        		}
    			/*
    			if(ep.getCurrentEquippedItem()!= null)
    			{
    				if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemWeaponBase)
					{
	    				DqmItemWeaponBase itm = (DqmItemWeaponBase)ep.getCurrentEquippedItem().getItem();

	    				EnumDqmWeapon enumWeapon = EnumDqmWeapon.valueOf(itm.getMaterial().name());

	    				ExtendedPlayerProperties.get(ep).setWeapon(enumWeapon.getId());
					}else if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemBowBase)
					{
						DqmItemBowBase itm = (DqmItemBowBase)ep.getCurrentEquippedItem().getItem();

	    				ExtendedPlayerProperties.get(ep).setWeapon(EnumDqmWeapon.DqmBow.getId());
					}else if(ep.getCurrentEquippedItem().getItem() instanceof ItemSword ||
	    			   ep.getCurrentEquippedItem().getItem() instanceof ItemBow)
	    			{
	    				ExtendedPlayerProperties.get(ep).setWeapon(1);
	    			}else if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemMagicBase)
					{
	    				DqmItemMagicBase itm = (DqmItemMagicBase)ep.getCurrentEquippedItem().getItem();

	    				EnumDqmWeapon enumWeapon = EnumDqmWeapon.valueOf(itm.getMaterial().name());

	    				ExtendedPlayerProperties.get(ep).setWeapon(enumWeapon.getId());

					}else
	    			{
	    				ExtendedPlayerProperties.get(ep).setWeapon(0);
	    			}

    			}else
    			{
    				ExtendedPlayerProperties.get(ep).setWeapon(0);
    			}
    			*/

    			pet.setWeapon(0);

    			//System.out.println("LOG:" + ExtendedPlayerProperties.get(ep).getMaxHP());
    			//System.out.println("LOG2:" + ExtendedPlayerProperties.get(ep).getHP());
    			//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(ep), (EntityPlayerMP)ep);
    		}

    		if(pet.getMaxHealth() > 0 && pet.getHealth() > pet.getMaxHealth())
    		{
    			pet.setHealth(pet.getMaxHealth());
    		}
    	}
    }

	@SubscribeEvent
    public void onPotionCalc(LivingUpdateEvent event) {
    	if(event.entityLiving instanceof EntityPlayer)
    	{
    		doPotionEffectPlayer((EntityPlayer)event.entityLiving, event);
    		doDqrEffectPlayer((EntityPlayer)event.entityLiving, event);
    	}else if(event.entityLiving instanceof DqmPetBase)
    	{
    		doPotionEffectPet((DqmPetBase)event.entityLiving, event);

    	}else if(event.entityLiving instanceof DqmMobBase)
    	{
    		doPotionEffectMob((DqmMobBase)event.entityLiving, event);

    	}

	}

	public void doPotionEffectPlayer(EntityPlayer ep, LivingUpdateEvent event)
	{
		//炎の実と黄金4 設定まだ
		PotionEffect pe;
		//EntityPlayer ep = (EntityPlayer)event.entityLiving;
		Random rand = new Random();

		if(event.entityLiving instanceof EntityPlayer && !event.entityLiving.worldObj.isRemote)
		{
			EntityPlayer pl = (EntityPlayer)event.entityLiving;

        	InventorySubEquip subEquip = new InventorySubEquip(pl);
        	subEquip.openInventory();

			if(event.entityLiving.ticksExisted % 17 == 0)
			{
		    	if(subEquip != null && subEquip.getStackInSlot(11) != null)
		    	{
		    		if(subEquip.getStackInSlot(11).getItem() == DQAccessories.itemUrokonotate)
		    		{

		    			pe = ep.getActivePotionEffect(DQPotionMinus.potionPoison);
		    			if(pe != null && pe.getDuration() > 40)
		    			{
		    				ep.removePotionEffect(pe.getPotionID());
		    				DQR.func.addPotionEffect2(ep, new PotionEffect(pe.getPotionID(), (pe.getDuration() - 30), pe.getAmplifier(), false));
		    			}

		    			pe = ep.getActivePotionEffect(DQPotionMinus.potionPoisonX);
		    			if(pe != null && pe.getDuration() > 40)
		    			{
		    				ep.removePotionEffect(pe.getPotionID());
		    				DQR.func.addPotionEffect2(ep, new PotionEffect(pe.getPotionID(), (pe.getDuration() - 30), pe.getAmplifier(), false));
		    			}

		    			pe = ep.getActivePotionEffect(Potion.poison);
		    			if(pe != null && pe.getDuration() > 40)
		    			{
		    				ep.removePotionEffect(pe.getPotionID());
		    				DQR.func.addPotionEffect2(ep, new PotionEffect(pe.getPotionID(), (pe.getDuration() - 30), pe.getAmplifier(), false));
		    			}

		    			pe = ep.getActivePotionEffect(Potion.wither);
		    			if(pe != null && pe.getDuration() > 40)
		    			{
		    				ep.removePotionEffect(pe.getPotionID());
		    				DQR.func.addPotionEffect2(ep, new PotionEffect(pe.getPotionID(), (pe.getDuration() - 30), pe.getAmplifier(), false));
		    			}
		    		}else if(subEquip.getStackInSlot(11).getItem() == DQAccessories.itemMetarukingnotate)
		    		{
		    			Collection potions = ep.getActivePotionEffects();
		    			ArrayList<PotionEffect> newPot = new ArrayList();

		    			if(rand.nextInt(2) == 0){
				    		for (Iterator it = potions.iterator(); it.hasNext();)
				    		{
				    			//System.out.println("TEST???????????????");
				    			PotionEffect eff = (PotionEffect)(it.next());
				    			Potion pot = Potion.potionTypes[eff.getPotionID()];
				    			try{
					    			if(DQR.potionFunc.isPotionMinus(pot))
			    					{
					    				newPot.add(eff);
			    					}else if(DQR.potionFunc.isDQPotionMinus(pot))
			    					{
			    						newPot.add(eff);
			    					}else if(ep.worldObj.isRemote)
			    					{
			    						if(pot.isBadEffect())
			    						{
			    							newPot.add(eff);
			    						}
			    					}
				    			}
					    		catch(Exception e)
				    			{

				    			}
				    		}

				    		for(int cnt = 0; cnt < newPot.size(); cnt++)
				    		{
				    			if(newPot.get(cnt).getDuration() > 40)
				    			{
				    				ep.removePotionEffect(newPot.get(cnt).getPotionID());
				    				DQR.func.addPotionEffect2(ep, new PotionEffect(newPot.get(cnt).getPotionID(), (newPot.get(cnt).getDuration() - 30), newPot.get(cnt).getAmplifier(), false));
				    			}
				    		}

				    		/**********************************************************
				    		 *
				    		 * ここに、DQR独自実装バフ/デバフへの処理を入れるべきでは？
				    		 *
				    		 ***********************************************************/
		    			}
		    		}

		    	}

		    	//職業特技 デバフ無効処理
		    	if(ExtendedPlayerProperties5.get(ep).getJobSPSkillSet(EnumDqmJob.Asobinin.getId(), 5) != 0)
		    	{
		    		DQR.func.removeBadEffectAll(ep);
		    	}

		    	//命の指輪回復処理
		    	if(subEquip.hasYubiwa2(DQAccessories.itemInotinoyubiwa) != -1)
		    	{
    				if(ep.getHealth() < ep.getMaxHealth())
    				{
    					ep.heal(1);

		        		ItemStack stack = subEquip.getStackInSlot(subEquip.hasYubiwa(DQAccessories.itemInotinoyubiwa));
		        		stack.damageItem(2, ep);
    					subEquip.setInventorySlotContents(subEquip.hasYubiwa(DQAccessories.itemInotinoyubiwa), stack);
    				}
		    	}

		    	//祈りの指輪回復処理
		    	if(subEquip.hasYubiwa2(DQAccessories.itemInorinoyubiwa) != -1)
		    	{
	    			int mp = ExtendedPlayerProperties.get(ep).getMP();
	    			if(ExtendedPlayerProperties.get(ep).getMaxMP() > mp)
	    			{
		    			ExtendedPlayerProperties.get(ep).setMP(mp + 1);
		        		ItemStack stack = subEquip.getStackInSlot(subEquip.hasYubiwa(DQAccessories.itemInorinoyubiwa));
		        		stack.damageItem(2, ep);
    					subEquip.setInventorySlotContents(subEquip.hasYubiwa(DQAccessories.itemInorinoyubiwa), stack);

	    			}
		    	}

		    	//癒しの腕輪
		    	if(subEquip.hasUdewa2(DQAccessories.itemIyasinoudewa) != -1)
		    	{
    				if(ep.getHealth() < ep.getMaxHealth())
    				{
    					ep.heal(1);

		        		ItemStack stack = subEquip.getStackInSlot(subEquip.hasUdewa(DQAccessories.itemIyasinoudewa));
		        		stack.damageItem(2, ep);
    					subEquip.setInventorySlotContents(subEquip.hasUdewa(DQAccessories.itemIyasinoudewa), stack);
    				}
		    	}
			}
			subEquip.markDirty();
	    	subEquip.closeInventory();
		}

		/*
		pe = ep.getActivePotionEffect(DQPotionMinus.debuffRariho);
		if(pe != null && pe.getDuration() > DQR.conf.rarihoFreeDuration)
		{
			double[] loc = new double[4];

			loc[0] = ep.posX;
			loc[1] = ep.posY;
			loc[2] = ep.posZ;
			loc[3] = 1;
			ExtendedPlayerProperties.get(ep).setRarihoLoc(loc);
		}else
		{
			double[] loc = new double[4];

			loc[0] = -1;
			loc[1] = -1;
			loc[2] = -1;
			loc[3] = 0;
			ExtendedPlayerProperties.get(ep).setRarihoLoc(loc);
		}
		*/

		/*
		pe = ep.getActivePotionEffect(DQPotionPlus.potionDokukesisou);
		if(pe != null)
		{
			switch(pe.getAmplifier())
			{
				case 0: ep.removePotionEffect(DQPotionMinus.potionPoison.id); ep.removePotionEffect(Potion.poison.id); break;
				case 1: ep.removePotionEffect(DQPotionMinus.potionPoison.id); ep.removePotionEffect(Potion.wither.id); ep.removePotionEffect(Potion.poison.id); break;
				case 2: ep.removePotionEffect(DQPotionMinus.potionPoison.id);ep.removePotionEffect(DQPotionMinus.potionPoisonX.id); break;
				default: ep.removePotionEffect(DQPotionMinus.potionPoison.id);ep.removePotionEffect(DQPotionMinus.potionPoisonX.id);
			}
		}
		*/

		/*
		if(event.entityLiving.ticksExisted % 20 == 0)
		{
    		pe = ep.getActivePotionEffect(DQPotionPlus.potionMahounomi);
    		if(pe != null && ep.getHealth() > 0 && !ep.isDead)
    		{
	    			int mp = ExtendedPlayerProperties.get(ep).getMP();
	    			if(ExtendedPlayerProperties.get(ep).getMaxMP() < mp + (1 + (pe.getAmplifier() * 2)))
	    			{
	    				ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
	    			}else
	    			{

	    				ExtendedPlayerProperties.get(ep).setMP(mp + (1 + (pe.getAmplifier() * 2)));
	    			}
    			//ep.setHealth(1.0F + (pe.getAmplifier() * 2));
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.buffMPRegeneration);
    		if(pe != null && ep.getHealth() > 0 && !ep.isDead)
    		{
	    			int mp = ExtendedPlayerProperties.get(ep).getMP();
	    			if(ExtendedPlayerProperties.get(ep).getMaxMP() < mp + (1 + (pe.getAmplifier() * 2)))
	    			{
	    				ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
	    			}else
	    			{

	    				ExtendedPlayerProperties.get(ep).setMP(mp + (1 + (pe.getAmplifier() * 2)));
	    			}
    			//ep.setHealth(1.0F + (pe.getAmplifier() * 2));
    		}

    		pe = ep.getActivePotionEffect(DQPotionMinus.potionPoison);
    		if(pe != null)
    		{
    				if((ep.getHealth() - ((pe.getAmplifier() + 1) * 2)) > 1)
    				{
    					ep.attackEntityFrom(DQR.damageSource.DqmPoison, ((pe.getAmplifier() + 1) * 2));
    					//ep.setHealth(ep.getHealth() - ((pe.getAmplifier() + 1) * 2));
    				}else if(ep.getHealth() != 1)
    				{
    					ep.attackEntityFrom(DQR.damageSource.DqmPoison, (ep.getHealth() - 1));
    				}
    		}
		}
		*/

		/*
		//0.5秒ごと
		if(event.entityLiving.ticksExisted % 10 == 0)
		{
    		pe = ep.getActivePotionEffect(DQPotionMinus.potionPoisonX);
    		if(pe != null)
    		{

				if(ep.getHealth() > 0)
				{
					ep.attackEntityFrom(DQR.damageSource.DqmPoisonX, ((pe.getAmplifier() + 1) * 2));
					//ep.setHealth(ep.getHealth() - ((pe.getAmplifier() + 1) * 2));
				}
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.potionIyasinomi);
    		if(pe != null && ep.getHealth() > 0 && !ep.isDead)
    		{
				if(ep.getMaxHealth() < ep.getHealth() + 1.0F + (pe.getAmplifier() * 2))
				{
					ep.setHealth(ep.getMaxHealth());
				}else
				{
					//ep.setHealth(ep.getHealth() + 1.0F + (pe.getAmplifier() * 2));
					ep.heal(1.0F + (pe.getAmplifier() * 2));
				}
    		}


    		pe = ep.getActivePotionEffect(DQPotionPlus.buffHPRegeneration);
    		if(pe != null && ep.getHealth() > 0 && !ep.isDead)
    		{
				if(ep.getMaxHealth() < ep.getHealth() + 1.0F + (pe.getAmplifier() * 2))
				{
					ep.setHealth(ep.getMaxHealth());
				}else
				{
					//ep.setHealth(ep.getHealth() + 1.0F + (pe.getAmplifier() * 2));
					ep.heal(1.0F + (pe.getAmplifier() * 2));
				}
    		}
		}
		*/

		//8tickごと
		/*
		if(event.entityLiving.ticksExisted % 13 == 0)
		{
    		pe = ep.getActivePotionEffect(DQPotionPlus.potionMamorinotane);
    		if(pe != null)
			{
    			ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.seed.getId(), (pe.getAmplifier() + 1) * 5);
			}else
			{
				ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.seed.getId(), 0);
			}

    		pe = ep.getActivePotionEffect(DQPotionPlus.potionTikaranotane);
    		if(pe != null){
    			ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.seed.getId(), (pe.getAmplifier() + 1) * 5);
    		}else
    		{
    			ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.seed.getId(), 0);
    		}


    		pe = ep.getActivePotionEffect(DQPotionPlus.potionSubayasanotane);
    		if(pe != null){
    			ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.seed.getId(), pe.getAmplifier() + 1);
    		}else
    		{
    			ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.seed.getId(),0);
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.buffPiora);
    		if(pe != null){
    			ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.buffPiora.getId(), pe.getAmplifier() + 1);
    		}else
    		{
    			ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.buffPiora.getId(),0);
    		}

    		pe = ep.getActivePotionEffect(DQPotionMinus.debuffBomie);
    		if(pe != null){
    			ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.debuffBomie.getId(), (pe.getAmplifier() + 1) * - 1);
    		}else
    		{
    			ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.debuffBomie.getId(),0);
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.potionMaryokunotane);
    		if(pe != null){
    			ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.seed.getId(), (pe.getAmplifier() + 1) * 5);
    		}else
    		{
    			ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.seed.getId(), 0);
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.potionOugonnomi);
    		if(pe != null)
			{
    			if(pe.getAmplifier() < 3)
    			{
    				ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				//ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStatTikara.ougon.getId(), pe.getAmplifier());
    			}else
    			{
    				ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				//ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStatTikara.ougon.getId(), pe.getAmplifier());

    	    		if(ep.getHealth() > 0 && !ep.isDead)
    	    		{
    	    			if(ep.getHealth() > 0 && !ep.isDead)
    	    			{
    	    				if(ep.getMaxHealth() < ep.getHealth() + (pe.getAmplifier() * 10))
    	    				{
    	    					ep.setHealth(ep.getMaxHealth());
    	    				}else
    	    				{
    	    					//ep.setHealth(ep.getHealth() + (pe.getAmplifier() * 10));
    	    					ep.heal(pe.getAmplifier() * 10);
    	    				}
    	    			}
    	    		}

        			int mp = ExtendedPlayerProperties.get(ep).getMP();
        			if(ep.getHealth() > 0 && !ep.isDead)
        			{
	        			if(ExtendedPlayerProperties.get(ep).getMaxMP() < mp + (1 + (pe.getAmplifier() * 5)))
	        			{
	        				ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
	        			}else
	        			{

	        				ExtendedPlayerProperties.get(ep).setMP(mp + (1 + (pe.getAmplifier() * 5)));
	        			}
        			}
    			}
			}else
			{
				ExtendedPlayerProperties.get(ep).setArrayMamori(EnumStat.ougon.getId(), 0);
				ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.ougon.getId(), 0);
				ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.ougon.getId(), 0);
				ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.ougon.getId(), 0);
			}
		}
		*/
	}

	public void doPotionEffectPet(DqmPetBase ep, LivingUpdateEvent event)
	{


		//PotionEffect pe = ep.getActivePotionEffect(DQPotionPlus.potionDokukesisou);
		/*
		if(pe != null)
		{
			switch(pe.getAmplifier())
			{
				case 0: ep.removePotionEffect(DQPotionMinus.potionPoison.id); ep.removePotionEffect(Potion.poison.id); break;
				case 1: ep.removePotionEffect(DQPotionMinus.potionPoison.id); ep.removePotionEffect(Potion.wither.id); ep.removePotionEffect(Potion.poison.id); break;
				case 2: ep.removePotionEffect(DQPotionMinus.potionPoison.id);ep.removePotionEffect(DQPotionMinus.potionPoisonX.id); break;
				default: ep.removePotionEffect(DQPotionMinus.potionPoison.id);ep.removePotionEffect(DQPotionMinus.potionPoisonX.id);
			}
		}

		if(event.entityLiving.ticksExisted % 20 == 0)
		{
    		pe = ep.getActivePotionEffect(DQPotionPlus.potionMahounomi);
    		if(pe != null && ep.getHealth() > 0 && !ep.isDead)
    		{
    			int mp = ep.getMP();
    			if(ep.getMaxMP() < mp + (1 + (pe.getAmplifier() * 2)))
    			{
    				ep.setMP(ep.getMaxMP());
    			}else
    			{

    				ep.setMP(mp + (1 + (pe.getAmplifier() * 2)));
    			}
    			//ep.setHealth(1.0F + (pe.getAmplifier() * 2));
    		}

    		pe = ep.getActivePotionEffect(DQPotionMinus.potionPoison);
    		if(pe != null)
    		{
				if((ep.getHealth() - ((pe.getAmplifier() + 1) * 2)) > 1)
				{
					ep.attackEntityFrom(DQR.damageSource.DqmPoison, ((pe.getAmplifier() + 1) * 2));
					//ep.setHealth(ep.getHealth() - ((pe.getAmplifier() + 1) * 2));
				}else if(ep.getHealth() !=  1)
				{
					ep.attackEntityFrom(DQR.damageSource.DqmPoison, ep.getHealth() - 1);
					//ep.setHealth(ep.getHealth() - ((pe.getAmplifier() + 1) * 2));
				}
    		}
		}
		*/
		/*
		if(event.entityLiving.ticksExisted % 10 == 0)
		{
    		pe = ep.getActivePotionEffect(DQPotionMinus.potionPoisonX);
    		if(pe != null)
    		{
    				//if((ep.getHealth() - ((pe.getAmplifier() + 1) * 2)) > 0)
    				if(ep.getHealth()  > 0)
    				{
    					ep.attackEntityFrom(DQR.damageSource.DqmPoisonX, ((pe.getAmplifier() + 1) * 2));
    					//ep.setHealth(ep.getHealth() - ((pe.getAmplifier() + 1) * 2));
    				}
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.potionIyasinomi);
    		if(pe != null && ep.getHealth() > 0 && !ep.isDead)
    		{
				if(ep.getMaxHealth() < ep.getHealth() + 1.0F + (pe.getAmplifier() * 2))
				{
					ep.setHealth(ep.getMaxHealth());
				}else
				{
					ep.setHealth(ep.getHealth() + 1.0F + (pe.getAmplifier() * 2));
				}
    		}
		}
		*/
		/*
		if(event.entityLiving.ticksExisted % 11 == 0)
		{
    		pe = ep.getActivePotionEffect(DQPotionPlus.potionMamorinotane);
    		if(pe != null)
			{
    			ep.setArrayMamori(EnumStat.seed.getId(), (pe.getAmplifier() + 1) * 5);
			}else
			{
				ep.setArrayMamori(EnumStat.seed.getId(), 0);
			}

    		pe = ep.getActivePotionEffect(DQPotionPlus.potionTikaranotane);
    		if(pe != null){
    			ep.setArrayTikara(EnumStat.seed.getId(), (pe.getAmplifier() + 1) * 5);
    		}else
    		{
    			ep.setArrayTikara(EnumStat.seed.getId(), 0);
    		}


    		pe = ep.getActivePotionEffect(DQPotionPlus.potionSubayasanotane);
    		if(pe != null){
    			ep.setArraySubayasa(EnumStat.seed.getId(), pe.getAmplifier() + 1);
    		}else
    		{
    			ep.setArraySubayasa(EnumStat.seed.getId(),0);
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.buffPiora);
    		if(pe != null){
    			ep.setArraySubayasa(EnumStat.buffPiora.getId(), pe.getAmplifier() + 1);
    		}else
    		{
    			ep.setArraySubayasa(EnumStat.buffPiora.getId(),0);
    		}



    		pe = ep.getActivePotionEffect(DQPotionMinus.debuffBomie);
    		if(pe != null){
    			ep.setArraySubayasa(EnumStat.debuffBomie.getId(), (pe.getAmplifier() + 1) * - 1);
    		}else
    		{
    			ep.setArraySubayasa(EnumStat.debuffBomie.getId(),0);
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.potionMaryokunotane);
    		if(pe != null){
    			ep.setArrayKasikosa(EnumStat.seed.getId(), (pe.getAmplifier() + 1) * 5);
    		}else
    		{
    			ep.setArrayKasikosa(EnumStat.seed.getId(), 0);
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.potionOugonnomi);
    		if(pe != null)
			{
    			if(pe.getAmplifier() < 3)
    			{
    				ep.setArrayMamori(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				ep.setArrayTikara(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				ep.setArrayKasikosa(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				//ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStatTikara.ougon.getId(), pe.getAmplifier());
    			}else
    			{
    				ep.setArrayMamori(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				ep.setArrayTikara(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				ep.setArrayKasikosa(EnumStat.ougon.getId(), (pe.getAmplifier() + 1) * 3);
    				//ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStatTikara.ougon.getId(), pe.getAmplifier());

    	    		if(ep.getHealth() > 0 && !ep.isDead)
    	    		{
    	    			if(ep.getHealth() > 0 && !ep.isDead)
    	    			{
    	    				if(ep.getMaxHealth() < ep.getHealth() + (pe.getAmplifier() * 10))
    	    				{
    	    					ep.setHealth(ep.getMaxHealth());
    	    				}else
    	    				{
    	    					ep.setHealth(ep.getHealth() + (pe.getAmplifier() * 10));
    	    				}
    	    			}
    	    		}

        			int mp = ep.getMP();
        			if(ep.getHealth() > 0 && !ep.isDead)
        			{
	        			if(ep.getMaxMP() < mp + (1 + (pe.getAmplifier() * 5)))
	        			{
	        				ep.setMP(ep.getMaxMP());
	        			}else
	        			{

	        				ep.setMP(mp + (1 + (pe.getAmplifier() * 5)));
	        			}
        			}
    			}
			}else
			{
				ep.setArrayMamori(EnumStat.ougon.getId(), 0);
				ep.setArrayTikara(EnumStat.ougon.getId(), 0);
				ep.setArrayKasikosa(EnumStat.ougon.getId(), 0);
				ep.setArrayTikara(EnumStat.ougon.getId(), 0);
			}
		}
		*/
	}

	public void doPotionEffectMob(DqmMobBase ep, LivingUpdateEvent event)
	{
		/*
		PotionEffect pe = ep.getActivePotionEffect(DQPotionPlus.potionDokukesisou);
		if(pe != null)
		{
			switch(pe.getAmplifier())
			{
				case 0: ep.removePotionEffect(DQPotionMinus.potionPoison.id); ep.removePotionEffect(Potion.poison.id); break;
				case 1: ep.removePotionEffect(DQPotionMinus.potionPoison.id); ep.removePotionEffect(Potion.wither.id); ep.removePotionEffect(Potion.poison.id); break;
				case 2: ep.removePotionEffect(DQPotionMinus.potionPoison.id);ep.removePotionEffect(DQPotionMinus.potionPoisonX.id); break;
				default: ep.removePotionEffect(DQPotionMinus.potionPoison.id);ep.removePotionEffect(DQPotionMinus.potionPoisonX.id);
			}
		}

		pe = ep.getActivePotionEffect(DQPotionPlus.potionMahounomi);
		if(pe != null && ep.getHealth() > 0 && !ep.isDead)
		{
			int mp = ep.DqmMobMP;
			ep.DqmMobMP = (mp + (1 + (pe.getAmplifier() * 2)));

			//ep.setHealth(1.0F + (pe.getAmplifier() * 2));
		}

		if(event.entityLiving.ticksExisted % 20 == 0)
		{
    		pe = ep.getActivePotionEffect(DQPotionMinus.potionPoison);
    		if(pe != null)
    		{
				if((ep.getHealth() - ((pe.getAmplifier() + 1) * 2)) > 0)
				{
					ep.attackEntityFrom(DQR.damageSource.DqmPoison, ((pe.getAmplifier() + 1) * 2));
					//ep.setHealth(ep.getHealth() - ((pe.getAmplifier() + 1) * 2));
				}
    		}
		}

		if(event.entityLiving.ticksExisted % 10 == 0)
		{
    		pe = ep.getActivePotionEffect(DQPotionMinus.potionPoisonX);
    		if(pe != null)
    		{
				if((ep.getHealth() - ((pe.getAmplifier() + 1) * 2)) > 0)
				{
					ep.attackEntityFrom(DQR.damageSource.DqmPoisonX, ((pe.getAmplifier() + 1) * 2));
					//ep.setHealth(ep.getHealth() - ((pe.getAmplifier() + 1) * 2));
				}
    		}

    		pe = ep.getActivePotionEffect(DQPotionPlus.potionIyasinomi);
    		if(pe != null && ep.getHealth() > 0 && !ep.isDead)
    		{
				if(ep.getMaxHealth() < ep.getHealth() + 1.0F + (pe.getAmplifier() * 2))
				{
					ep.setHealth(ep.getMaxHealth());
				}else
				{
					ep.setHealth(ep.getHealth() + 1.0F + (pe.getAmplifier() * 2));
				}
    		}
		}
		*/
	}

	public void doDqrEffectPlayer(EntityPlayer ep, LivingUpdateEvent event)
	{
		if(ep.isDead) return;


	}
}
