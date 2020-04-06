package dqr.functions;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityMeraB;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.petEntity.DqmPetBase;
import dqr.entity.throwingEntity.throwItem.ThrowJSkillEntityIshinage;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties5;
import dqr.playerData.MessagePlayerProperties5;

public class FuncSkillJobSP {

	public FuncSkillJobSP(){}

	/**
	 * 遊び人の職業特殊特技
	 */
	public void doSkillJobSP0(int jobId, int idx, EntityPlayer player, EnumDqmSkillJ skill)
	{
		/*
		float preDamage = ExtendedPlayerProperties.get(player).getKougeki();
		float preMagicDamage = ExtendedPlayerProperties.get(player).getMaryoku();

		Random rnd = new Random();
		float percent = 50 + rnd.nextInt(60);

		preDamage = preDamage * (percent / 100);
		preMagicDamage = preMagicDamage * (percent / 100);
		*/

		if(idx == EnumDqmJob.Asobinin.getId())
		{
			//石投げ
			DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill.use1.msg",new Object[] {DQR.func.getTransform("dqm.dqpotion.JSkill_" + jobId + "_" + idx + ".name")}));
    		ThrowJSkillEntityIshinage magic;
			magic = new ThrowJSkillEntityIshinage(player.worldObj, player, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic.setMaxTicksRange(2);

			int attackDam = 1;
			magic.setDamage(attackDam);
			DamageSource source = DQR.damageSource.getJSkillAbsoluteDamage(player, 1, 1);
			//source.setDamageBypassesArmor();
			//source.setDamageIsAbsolute();
			magic.setDamSource(source);
			magic.setShootingEntity(player);
			player.worldObj.spawnEntityInWorld(magic);
		}else if(idx == 1)
		{
			//コイントス
			DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill.use1.msg",new Object[] {DQR.func.getTransform("dqm.dqpotion.JSkill_" + jobId + "_" + idx + ".name")}));
			player.worldObj.playSoundAtEntity(player, "dqr:player.sl_hit", 0.6F, 1.5F);
			Random rand = new Random();
			if(rand.nextInt(1000) < skill.getSRate())
			{
				DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill_0_1.msg.0",new Object[] {}));
				long wTime = player.worldObj.getWorldTime();
				NBTTagCompound nbtSet = ExtendedPlayerProperties5.get(player).getDqrPotionEffectsSet();

				boolean remFlg = false;
			    Set nbtKeys = nbtSet.func_150296_c();
			    Iterator it = nbtKeys.iterator();
			    while(it.hasNext())
			    {
					Object obj = it.next();
					if(obj instanceof String)
					{
						NBTTagCompound dqrEffect = (NBTTagCompound)nbtSet.getTag((String)obj);
						if(dqrEffect != null && dqrEffect.hasKey("duration") && dqrEffect.hasKey("isDebuff"))
						{
							if(dqrEffect.getLong("duration") > wTime && dqrEffect.getInteger("isDebuff") == 1)
							{
								ExtendedPlayerProperties5.get(player).removeDqrPotionEffects((String)obj);
								remFlg = true;
								break;
							}
						}
					}
			    }

			    if(!remFlg)
			    {
		        	Collection potions = player.getActivePotionEffects();
	    			//ArrayList<PotionEffect> newPot = new ArrayList();

		    		for (Iterator it2 = potions.iterator(); it2.hasNext();)
		    		{
		    			//System.out.println("TEST???????????????");
		    			PotionEffect eff = (PotionEffect)(it2.next());
		    			Potion pot = Potion.potionTypes[eff.getPotionID()];
		    			try{
			    			if(DQR.potionFunc.isPotionMinus(pot))
	    					{
			    				player.removePotionEffect(eff.getPotionID());
			    				remFlg = true;
								break;
	    					}else if(DQR.potionFunc.isDQPotionMinus(pot))
	    					{
	    						player.removePotionEffect(eff.getPotionID());
	    						remFlg = true;
								break;
	    					}else if(player.worldObj.isRemote)
	    					{
	    						if(pot.isBadEffect())
	    						{
	    							player.removePotionEffect(eff.getPotionID());
	    							remFlg = true;
									break;
	    						}
	    					}
		    			}
			    		catch(Exception e)
		    			{

		    			}
		    		}
			    }

			    if(remFlg)
			    {
			    	ExtendedPlayerProperties5.get(player).refreshDqrPotionEffects(player.worldObj.getWorldTime());
                    PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties5((EntityPlayer)player), (EntityPlayerMP)player);
			    	DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill_0_1.msg.1",new Object[] {}));
			    }

			}else
			{
				DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill_0_1.msg.2",new Object[] {}));
			}
		}else if(idx == 2)
		{
			//ボケ
			List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player,
					player.boundingBox.addCoord(player.motionX, player.motionY, player.motionZ).expand(5.0D, 3.0D, 5.0D));
			DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill.use1.msg",new Object[] {DQR.func.getTransform("dqm.dqpotion.JSkill_" + jobId + "_" + idx + ".name")}));

            if (list != null && !list.isEmpty())
            {
            	for (int n = 0 ; n < list.size() ; n++)
            	{

            		Entity target = (Entity)list.get(n);

            		if (target instanceof DqmMobBase)
            		{
                		Random rand = new Random();
                		if(rand.nextInt(1000) < skill.getSRate())
                		{
	            			DqmMobBase elb = (DqmMobBase)target;

	                    	elb.setJobSPSkillDuration(EnumDqmJob.Asobinin.getId(), idx, player.worldObj.getWorldTime() + (skill.getDuration() * 20));
	                    	player.worldObj.playSoundAtEntity(player, "dqr:player.bubu2", 0.6F, 1.5F);
                		}
            		}
            	}
            }
		}else if(idx == 3)
		{
			//ツッコミ
			//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.up", 1.0F, 1.0F);
			List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player,
					player.boundingBox.addCoord(player.motionX, player.motionY, player.motionZ).expand(5.0D, 3.0D, 5.0D));
			DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill.use1.msg",new Object[] {DQR.func.getTransform("dqm.dqpotion.JSkill_" + jobId + "_" + idx + ".name")}));

            if (list != null && !list.isEmpty())
            {
            	for (int n = 0 ; n < list.size() ; n++)
            	{

            		Entity target = (Entity)list.get(n);
    				boolean remFlg = false;

            		if (target instanceof EntityPlayer)
            		{
                		Random rand = new Random();
                		EntityPlayer targetEP = (EntityPlayer)target;

            			long wTime = targetEP.worldObj.getWorldTime();
        				NBTTagCompound nbtSet = ExtendedPlayerProperties5.get(targetEP).getDqrPotionEffectsSet();


        			    Set nbtKeys = nbtSet.func_150296_c();
        			    Iterator it = nbtKeys.iterator();
        			    while(it.hasNext())
        			    {
        					Object obj = it.next();
        					if(obj instanceof String)
        					{
        						NBTTagCompound dqrEffect = (NBTTagCompound)nbtSet.getTag((String)obj);
        						if(dqrEffect != null && dqrEffect.hasKey("duration") && dqrEffect.hasKey("isDebuff"))
        						{
        							if(dqrEffect.getLong("duration") > wTime && dqrEffect.getInteger("isDebuff") == 1)
        							{
        								ExtendedPlayerProperties5.get(targetEP).removeDqrPotionEffects((String)obj);
        								remFlg = true;
        							}
        						}
        					}
        			    }

        			    if(!remFlg)
        			    {
        		        	Collection potions = targetEP.getActivePotionEffects();
        	    			//ArrayList<PotionEffect> newPot = new ArrayList();

        		    		for (Iterator it2 = potions.iterator(); it2.hasNext();)
        		    		{
        		    			//System.out.println("TEST???????????????");
        		    			PotionEffect eff = (PotionEffect)(it2.next());
        		    			Potion pot = Potion.potionTypes[eff.getPotionID()];
        		    			try{
        			    			if(DQR.potionFunc.isPotionMinus(pot))
        	    					{
        			    				targetEP.removePotionEffect(eff.getPotionID());
        			    				remFlg = true;
        	    					}else if(DQR.potionFunc.isDQPotionMinus(pot))
        	    					{
        	    						targetEP.removePotionEffect(eff.getPotionID());
        	    						remFlg = true;
        	    					}else if(targetEP.worldObj.isRemote)
        	    					{
        	    						if(pot.isBadEffect())
        	    						{
        	    							targetEP.removePotionEffect(eff.getPotionID());
        	    							remFlg = true;
        	    						}
        	    					}
        		    			}
        			    		catch(Exception e)
        		    			{

        		    			}
        		    		}
        			    }

        			    if(remFlg)
        			    {
        			    	ExtendedPlayerProperties5.get(targetEP).refreshDqrPotionEffects(targetEP.worldObj.getWorldTime());
                            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties5((EntityPlayer)targetEP), (EntityPlayerMP)targetEP);
        			    	//DQR.func.doAddChatMessageFix(targetEP, new ChatComponentTranslation("dqm.JSkill_0_1.msg.1",new Object[] {}));
        			    }

        			    targetEP.worldObj.playSoundAtEntity(targetEP, "dqr:player.up", 1.0F, 1.0F);
            		}

            		if(remFlg)
            		{
            			break;
            		}
            	}
            }
		}else if(idx == 7)
		{
			//ひふきげい
			DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill.use1.msg",new Object[] {DQR.func.getTransform("dqm.dqpotion.JSkill_" + jobId + "_" + idx + ".name")}));
			MagicEntity[] magic = null;
			magic = new MagicEntityMeraB[1];
			magic[0] = new MagicEntityMeraB(player.worldObj, player, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			((MagicEntityMeraB) magic[0]).setWorldFlg(player.isSneaking());



			int matk = ExtendedPlayerProperties.get(player).getMaryoku();
			int attackDam = matk + skill.getSValue();
			//attackDam = DQR.magicTable.getReasonableDamage(this, player, attackDam);


			//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
			//ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
    		for(int cnt = 0; cnt < magic.length; cnt++)
    		{
				magic[cnt].setDamage(attackDam);
	        	if (!player.worldObj.isRemote)
	        	{

	        		//((MagicEntityMeragaiaB) magic[cnt]).setWorldFlg(par3EntityPlayer.isSneaking());
	        		player.worldObj.spawnEntityInWorld(magic[cnt]);

	        	}
    		}
		}else if(idx == 8)
		{
			//キラージャグリング
			List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player,
					player.boundingBox.addCoord(player.motionX, player.motionY, player.motionZ).expand(6.0D, 3.0D, 6.0D));

			Random rand = new Random();
			int hitCnt = 0;
			int hitCntMax = 6 + rand.nextInt(3);
			int maxTry = 0;
			int[] attackDam = new int[2];
			attackDam = DQR.func.getMaxAttackFromInventory(player);
			//String edition = I18n.format("dqm.iteminfo.twilightForestDummy2", new Object[]{nbt.getString("dummy_edition")});

			if(player.inventory.mainInventory[attackDam[0]] != null)
			{
				DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill.use2.msg",new Object[] {player.inventory.mainInventory[attackDam[0]].getDisplayName(), DQR.func.getTransform("dqm.dqpotion.JSkill_0_8.name")}));
			}else
			{
				DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill.use1.msg",new Object[] {DQR.func.getTransform("dqm.dqpotion.JSkill_0_8.name")}));
			}

			for(hitCnt = 0; hitCnt <= hitCntMax || maxTry < 12; maxTry++)
			{
				Entity tag = (Entity)list.get(rand.nextInt(list.size()));
				if(tag instanceof EntityLivingBase)
				{
					EntityLivingBase target = (EntityLivingBase)tag;
					if(target != null && target instanceof EntityLivingBase && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
					{
						if(!target.isDead && target.getHealth() > 0.0f)
						{
							rand = new Random();
							float hitPer = 25.0F + rand.nextInt(26);
							target.hurtResistantTime = 0;
							target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(player), attackDam[1] * (hitPer / 100));
							hitCnt++;
						}
					}
				}
			}
		}else if(idx == 9)
		{
			//たたかいのうた
			DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill.use1.msg",new Object[] {DQR.func.getTransform("dqm.dqpotion.JSkill_" + jobId + "_" + idx + ".name")}));

			List list = player.worldObj.getEntitiesWithinAABBExcludingEntity(player,
					player.boundingBox.addCoord(player.motionX, player.motionY, player.motionZ).expand(4.0D, 3.0D, 4.0D));

			//DQR.dqEffect.setDQPotionEffect((EntityLivingBase)player, "JSkill" + "_" + EnumDqmJob.Asobinin.getId()  + "_" + idx, EnumDqmJob.Asobinin.getId(), idx, 0, skill.getDuration() * 20, 0, 0);
			PotionEffect pe = player.getActivePotionEffect(DQPotionPlus.buffBaikiruto);
			if(pe == null)
			{
				//elv.add
				DQR.func.addPotionEffect2(player, new PotionEffect(DQPotionPlus.buffBaikiruto.id, skill.getDuration() * 20, 0));
			}else
			{
				DQR.func.addPotionEffect2(player, new PotionEffect(DQPotionPlus.buffBaikiruto.id, skill.getDuration() * 20, 1));
			}

            if (list != null && !list.isEmpty())
            {
            	for (int n = 0 ; n < list.size() ; n++)
            	{

            		Entity target = (Entity)list.get(n);

            		if (target instanceof EntityPlayer || target instanceof DqmPetBase)
            		{
            			EntityLivingBase elv = (EntityLivingBase)target;
            			//DQR.dqEffect.setDQPotionEffect((EntityLivingBase)target, "JSkill" + "_" + EnumDqmJob.Asobinin.getId()  + "_" + idx, EnumDqmJob.Asobinin.getId(), idx, 0, skill.getDuration() * 20, 0, 0);
            			pe = elv.getActivePotionEffect(DQPotionPlus.buffBaikiruto);

            			if(pe == null)
            			{
            				//elv.add
            				DQR.func.addPotionEffect2(elv, new PotionEffect(DQPotionPlus.buffBaikiruto.id, skill.getDuration() * 20, 0));
            			}else
            			{
            				DQR.func.addPotionEffect2(elv, new PotionEffect(DQPotionPlus.buffBaikiruto.id, skill.getDuration() * 20, 1));
            			}
            		}
            	}
            }
			//DQR.func.getHBMaxAttack(player);
		}else if(idx == 11)
		{
			//くちぶえ
			//0:地上昼 1:地上夜 2:ネザー 3:エンド 4:転生 5:覚醒 6:魔王 7:ボツ 8:メタル
			int[] mobDay = new int[]{410, 820, 935, 979, 983, 984, 985, 995, 1000};
			int[] mobNight = new int[]{350, 800, 850, 920, 925, 928, 930, 990, 1000};
			int[] mobNether = new int[]{50, 150, 750, 900, 940, 955, 965, 985, 1000};
			int[] mobEnd = new int[]{100, 200, 300, 860, 910, 930, 960, 980, 1000};
			int[] mobOther = new int[]{120, 270, 470, 670, 820, 870, 920, 970, 1000};

			int[] checkData;
			Random rand = new Random();
			int result = rand.nextInt(1000);
			int categ = -1;

			if(player.dimension == 0)
			{
				if(player.worldObj.isDaytime())
				{
					checkData = mobDay;
				}else
				{
					checkData = mobNight;
				}
			}else if(player.dimension == -1)
			{
				checkData = mobNether;
			}else if(player.dimension == 1)
			{
				checkData = mobEnd;
			}else
			{
				checkData = mobOther;
			}


			for(int cnt = 0; cnt < checkData.length; cnt++)
			{
				if(checkData[cnt] > result)
				{
					categ = cnt;
					break;
				}
			}

			DqmMobBase spawnMob = null;
			switch(categ)
			{
				case 0: spawnMob = DQR.randomMob.getRandomDay(player.worldObj); break;
				case 1: spawnMob = DQR.randomMob.getRandomNight(player.worldObj); break;
				case 2: spawnMob = DQR.randomMob.getRandomNether(player.worldObj); break;
				case 3: spawnMob = DQR.randomMob.getRandomEnd(player.worldObj); break;
				case 4: spawnMob = DQR.randomMob.getRandomTENSEI(player.worldObj); break;
				case 5: spawnMob = DQR.randomMob.getRandomSP(player.worldObj); break;
				case 6: spawnMob = DQR.randomMob.getRandomBoss(player.worldObj); break;
				case 7: spawnMob = DQR.randomMob.getRandomETC(player.worldObj); break;
				case 8: spawnMob = DQR.randomMob.getRandomMetaru(player.worldObj); break;
			}

			int[] spawnPos = DQR.func.getSpaceLocationRandom(player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ, 4, 3);
			spawnMob.setLocationAndAngles((double)spawnPos[0], (double)spawnPos[1], (double)spawnPos[2], 0.0F, 0.0F);
			player.worldObj.spawnEntityInWorld(spawnMob);
    		spawnMob.spawnExplosionParticle();
    		player.worldObj.playSoundAtEntity(player, "dqr:player.whistle01", 0.5F, 1.0F);
    		DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill.use1.msg",new Object[] {DQR.func.getTransform("dqm.dqpotion.JSkill_0_11.name")}));
    		DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("dqm.JSkill_0_11.msg",new Object[] {DQR.func.getTransform(spawnMob.getCommandSenderName())}));

		}else if(idx == 12)
		{
			//イカサマ
		}else if(idx == 13)
		{
			//勇者鎧適正
		}

	}
}
