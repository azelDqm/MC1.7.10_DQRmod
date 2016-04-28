package dqr.functions;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import dqr.DQR;
import dqr.api.enums.EnumDqmMonster;
import dqr.api.enums.EnumDqmMonsterResist;
import dqr.api.enums.EnumDqmPet;
import dqr.entity.magicEntity.magic.MagicEntityBagi;
import dqr.entity.magicEntity.magic.MagicEntityBegiragon;
import dqr.entity.magicEntity.magic.MagicEntityBegirama;
import dqr.entity.magicEntity.magic.MagicEntityDoruma;
import dqr.entity.magicEntity.magic.MagicEntityGira;
import dqr.entity.magicEntity.magic.MagicEntityGiragureido;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.entity.magicEntity.magic.MagicEntityIo;
import dqr.entity.magicEntity.magic.MagicEntityMera;
import dqr.entity.magicEntity.magic.MagicEntityMeragaia;
import dqr.entity.magicEntity.magic.MagicEntityMerami;
import dqr.entity.magicEntity.magic.MagicEntityMerazoma;
import dqr.entity.magicEntity.magic.MagicEntityRaidein;
import dqr.entity.mobEntity.DqmMobBase;
<<<<<<< HEAD
import dqr.entity.mobEntity.monsterDay.DqmEntityBigCrow;
import dqr.entity.mobEntity.monsterDay.DqmEntityDucksbill;
import dqr.entity.mobEntity.monsterDay.DqmEntityEbiruapple;
import dqr.entity.mobEntity.monsterDay.DqmEntityGuntaigani;
import dqr.entity.mobEntity.monsterDay.DqmEntityKimera;
import dqr.entity.mobEntity.monsterDay.DqmEntityKirikabuobake;
import dqr.entity.mobEntity.monsterDay.DqmEntityMomonja;
import dqr.entity.mobEntity.monsterDay.DqmEntityObakekinoko;
import dqr.entity.mobEntity.monsterDay.DqmEntityObakeumiusi;
import dqr.entity.mobEntity.monsterDay.DqmEntityOokutibasi;
import dqr.entity.mobEntity.monsterDay.DqmEntitySabotenboru;
import dqr.entity.mobEntity.monsterDay.DqmEntitySibirekurage;
import dqr.entity.mobEntity.monsterDay.DqmEntityUzusioking;
import dqr.entity.mobEntity.monsterDay.DqmEntityZukkinya;
import dqr.entity.mobEntity.monsterEnd.DqmEntityAkairai;
import dqr.entity.mobEntity.monsterEnd.DqmEntityBassaimasin;
import dqr.entity.mobEntity.monsterEtc.DqmEntityGanseki;
import dqr.entity.mobEntity.monsterHell.DqmEntityBurakkubejita;
import dqr.entity.mobEntity.monsterHell.DqmEntityDeddopekka;
import dqr.entity.mobEntity.monsterHell.DqmEntityGanirasu;
import dqr.entity.mobEntity.monsterHell.DqmEntityJigokunohasami;
import dqr.entity.mobEntity.monsterHell.DqmEntityKirakurabu;
import dqr.entity.mobEntity.monsterHell.DqmEntityKiramasin;
import dqr.entity.mobEntity.monsterHell.DqmEntityKiramasin2;
import dqr.entity.mobEntity.monsterHell.DqmEntityMagematango;
import dqr.entity.mobEntity.monsterHell.DqmEntityMagemomonja;
import dqr.entity.mobEntity.monsterHell.DqmEntityMetaruhanta;
import dqr.entity.mobEntity.monsterHell.DqmEntityStarkimera;
import dqr.entity.mobEntity.monsterHell.DqmEntityUmibouzu;
import dqr.entity.mobEntity.monsterNight.DqmEntityButtizukinya;
import dqr.entity.mobEntity.monsterNight.DqmEntityDansunidoru;
import dqr.entity.mobEntity.monsterNight.DqmEntityDesufuratta;
import dqr.entity.mobEntity.monsterNight.DqmEntityGappurin;
import dqr.entity.mobEntity.monsterNight.DqmEntityMarinsuraimu;
import dqr.entity.mobEntity.monsterNight.DqmEntityMatango;
import dqr.entity.mobEntity.monsterNight.DqmEntityMetaruhantaken;
import dqr.entity.mobEntity.monsterNight.DqmEntityUmiusi;
import dqr.entity.mobEntity.monsterSP.DqmEntityKiramajinga;
import dqr.entity.mobEntity.monsterTensei.DqmEntityMoonkimera;
import dqr.entity.mobEntity.monsterTensei.DqmEntitySabotengold;
import dqr.entity.mobEntity.monsterTensei.DqmEntityTaipug;
import dqr.entity.npcEntity.npc.DqmEntityNPCGuntai;
=======
>>>>>>> parent of 2aede75... ver0.8.7.8
import dqr.entity.petEntity.DqmPetBase;

public class FuncCalcDamage {

	public FuncCalcDamage()
	{

	}

<<<<<<< HEAD
	public float applyDamageBoost(float par1, EntityLivingBase evb, DamageSource source, float preDamage)
	{
		float ret = par1;
		String mobName = null;
		Random rand = new Random();

		//System.out.println("test1");
		if(source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)source.getEntity();
			int weapon = ExtendedPlayerProperties.get(ep).getWeapon();
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

					if(weapon == EnumDqmWeapon.DqmSword.getId())
					{
						if(weaponSkill == 0)
						{
							//ドラゴン斬り
							if(monster != null && monster.MobRoot.getId() == EnumDqmMobRoot.DRAGON.getId())
							{
								ret = ret * 1.5F;
								hitFlg = true;
							}
						}else if(weaponSkill == 2)
						{
							//メタル斬り
							if(monster != null && monster.MobRoot.getId() == EnumDqmMobRoot.METARU.getId())
							{
								ret = 0.5F + (rand.nextFloat() * 2.0F);
								monster.dqmBypassArmor = true;
								hitFlg = true;
							}
						}else if(weaponSkill == 4)
						{
							//ミラクルソード
							ret = ret * 1.25F;
							//ep.heal(ret / 4);

	                    	if(ep.getHealth() + (ret / 4) > ep.getMaxHealth())
	                    	{
	                    		ep.setHealth(ep.getMaxHealth());
	                    	}else
	                    	{
	                    		ep.setHealth(ep.getHealth() + (ret / 4));
	                    	}

							hitFlg = true;
						}else if(weaponSkill == 6)
						{
							//はやぶさ斬り
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							evb.hurtResistantTime = 0;
							evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 0.75F));
							evb.hurtResistantTime = 0;
							ret = ret * 0.75F;
							hitFlg = false;
						}else if(weaponSkill == 8)
						{
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							//ギガスラッシュ
							//monster.damageEntity(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage *3.0F));
				            List list = evb.worldObj.getEntitiesWithinAABBExcludingEntity(evb,
				            		evb.boundingBox.addCoord(evb.motionX, evb.motionY, evb.motionZ).expand(4.0D, 2.0D, 4.0D));

				            //System.out.println("TEST1:" + list.size());

			            	for (int n = 0 ; n < list.size() ; n++)
			            	{
			            		Entity target = (Entity)list.get(n);

			            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
			            		{
			            			EntityLivingBase tagMob = (EntityLivingBase)target;
			            			//System.out.println("TEST2:" + tagMob.MobName);
			            			tagMob.hurtResistantTime = 0;
			            			tagMob.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 3.0F));
			            			tagMob.hurtResistantTime = 0;
			            		}
			            	}

							ret = ret * 3.0F;
							hitFlg = false;
						}

					}else if(weapon == EnumDqmWeapon.DqmBraveSword.getId())
					{
						if(weaponSkill == 0)
						{
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							//ストラッシュ
							//monster.damageEntity(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage *3.0F));
				            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(4.0D, 2.0D, 4.0D));

				            //System.out.println("TEST1:" + list.size());

			            	for (int n = 0 ; n < list.size() ; n++)
			            	{
			            		Entity target = (Entity)list.get(n);

			            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
			            		{
			            			EntityLivingBase tagMob = (EntityLivingBase)target;
			            			//System.out.println("TEST2:" + tagMob.MobName);
			            			tagMob.hurtResistantTime = 0;
			            			tagMob.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 1.2F));
			            			tagMob.hurtResistantTime = 0;
			            		}
			            	}

							ret = ret * 1.2F;
							hitFlg = false;
						}else if(weaponSkill == 6)
						{
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							//ギガソード
							//monster.damageEntity(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage *3.0F));
				            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(8.0D, 3.0D, 8.0D));

				            //System.out.println("TEST1:" + list.size());

			            	for (int n = 0 ; n < list.size() ; n++)
			            	{
			            		Entity target = (Entity)list.get(n);

			            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
			            		{
			            			EntityLivingBase tagMob = (EntityLivingBase)target;
			            			//System.out.println("TEST2:" + tagMob.MobName);
			            			tagMob.hurtResistantTime = 0;
			            			tagMob.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 1.5F));
			            			tagMob.hurtResistantTime = 0;

		                    		EntityLightningBolt lb = null;
		                    		lb = new EntityLightningBolt(tagMob.worldObj, tagMob.posX, tagMob.posY, tagMob.posZ);
		                    		tagMob.worldObj.addWeatherEffect(lb);
		                    		tagMob.worldObj.spawnEntityInWorld(lb);
			            		}
			            	}

							ret = ret * 1.5F;
							hitFlg = false;
						}
					}else if(weapon == EnumDqmWeapon.DqmFist.getId())
					{
						if(weaponSkill == 0)
						{
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							//石つぶて
							//monster.damageEntity(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage *3.0F));
				            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(8.0D, 3.0D, 8.0D));

				            //System.out.println("TEST1:" + list.size());

				            ThrowItemEntityIshitubute[] magic = new ThrowItemEntityIshitubute[16];
			    			for(int cnt = 0;cnt < 16; cnt++)
			    			{
			    				float attackDam = 10.0F;
			    				magic[cnt] = new ThrowItemEntityIshitubute(ep.worldObj, ep, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
			    				magic[cnt].setMaxTicksRange(2);

			    				attackDam = attackDam + (rand.nextFloat() * 13);
			    				magic[cnt].setDamage(attackDam);
			    				magic[cnt].setDamSource(DQR.damageSource.getPlayerSkillDamage(ep));
			    				ep.worldObj.spawnEntityInWorld(magic[cnt]);
			    			}

							ret = ret * 1.0F;
							hitFlg = false;
						}else if(weaponSkill == 2)
						{
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							//かまいたち
							//monster.damageEntity(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage *3.0F));

							MagicEntityBagi[] magic = new MagicEntityBagi[5];
			    			magic[0] = new MagicEntityBagi(ep.worldObj, ep, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			    			magic[1] = new MagicEntityBagi(ep.worldObj, ep, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			    			magic[2] = new MagicEntityBagi(ep.worldObj, ep, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			    			magic[3] = new MagicEntityBagi(ep.worldObj, ep, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, -22.5F, 0.0F);
			    			magic[4] = new MagicEntityBagi(ep.worldObj, ep, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 22.5F, 0.0F);
			    			for(int cnt = 0;cnt < 5; cnt++)
			    			{
			    				magic[cnt].setMaxTicksRange(5);

			    				magic[cnt].setDamage(ret);
			    				magic[cnt].setDamSource(DQR.damageSource.getPlayerSkillDamage(ep));
			    				ep.worldObj.spawnEntityInWorld(magic[cnt]);
			    			}


							ret = ret * 1.0F;
							hitFlg = false;
						}else if(weaponSkill == 4)
						{
							ret = ret * 1.5F;
							hitFlg = true;
						}else if(weaponSkill == 6)
						{
							//ばくれつ拳
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

							List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(6.0D, 3.0D, 6.0D));

							Entity target = (Entity)list.get(rand.nextInt(list.size()));
							if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
							{
								if(!target.isDead)
								{
									target.hurtResistantTime = 0;
									target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
								}
							}


							target = (Entity)list.get(rand.nextInt(list.size()));
							if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
							{
								if(!target.isDead)
								{
									target.hurtResistantTime = 0;
									target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
								}
							}


							target = (Entity)list.get(rand.nextInt(list.size()));
							if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
							{
								if(!target.isDead)
								{
									target.hurtResistantTime = 0;
									target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
								}
							}



						    target = (Entity)list.get(rand.nextInt(list.size()));
						    if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
						    {
						    	if(!target.isDead)
						    	{
						    		target.hurtResistantTime = 0;
						    		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
						    	}
						    }


							ret = -1.0F;

							hitFlg = false;
							/*
							evb.hurtResistantTime = 0;
							evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 0.5F));
							evb.hurtResistantTime = 0;
							evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 0.5F));
							evb.hurtResistantTime = 0;
							evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 0.5F));
							evb.hurtResistantTime = 0;
							ret = ret * 0.5F;
							*/
							//hitFlg = false;
						}else if(weaponSkill == 8)
						{
							//System.out.println("TESTTEST!!!!!!");
							//岩石落とし
							if(!ep.worldObj.isRemote)
							{
								ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

								for(int cntX = -2; cntX <= 2; cntX++)
								{
									for(int cntZ = -2; cntZ <= 2; cntZ++)
									{
										if(rand.nextInt(2) == 0 && ep.worldObj.isAirBlock((int)ep.posX + cntX, (int)ep.posY + 4, (int)ep.posZ + cntZ))
										{
											DqmEntityGanseki ganseki = new DqmEntityGanseki(ep.worldObj);
											ganseki.setSkillUser(ep);
											ganseki.setLocationAndAngles((int)ep.posX + cntX, (int)ep.posY + 4, (int)ep.posZ + cntZ, 0.0F, 0.0F);
											ep.worldObj.spawnEntityInWorld(ganseki);
										}

									}
								}
							}

							hitFlg = false;
						}
					}
					else if(weapon == EnumDqmWeapon.DqmClaw.getId())
					{
						if(weaponSkill == 0)
						{
							//ウィングブロウ
							ret = ret + 30.0F + (rand.nextFloat() * 15);
							hitFlg = true;
						}else if(weaponSkill == 2)
						{
							//裂鋼拳
							if(monster != null && isMachineMob(monster))
							{
								ret = ret * 1.5F;
								hitFlg = true;
							}
						}else if(weaponSkill == 4)
						{
							//ネイルスクラッチ
							evb.hurtResistantTime = 0;
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

							for(int cnt = 0; cnt < 4; cnt++)
							{
								//float fixDam = (1.0F + (rand.nextFloat() * 4)) * 0.1F;
								float fixDam = (1.0F+(rand.nextFloat() * 4)) * 0.1F;
								evb.hurtResistantTime = 0;
								evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * fixDam);
							}

							evb.hurtResistantTime = 0;

							ret = ret *  ((1.0F + (rand.nextFloat() * 4)) * 0.1F);
							hitFlg = false;
						}else if(weaponSkill == 6)
						{
							//タイガークロー
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							evb.hurtResistantTime = 0;
							evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 0.75F));
							evb.hurtResistantTime = 0;
							ret = ret * 0.75F;
							hitFlg = false;
						}else if(weaponSkill == 8)
						{
							//ゴールドフィンガー
							evb.curePotionEffects(new ItemStack(Items.milk_bucket, 1));
							hitFlg = true;
						}
					}
					else if(weapon == EnumDqmWeapon.DqmHammer0.getId())
					{
						if(weaponSkill == 0)
						{
							//ハートブレイク
							evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffStop.id, 40, 1));
							hitFlg = true;
						}else if(weaponSkill == 2)
						{
							//ゴールドハンマー
							if(monster != null)
							{
								if(preDamage < monster.getHealth())
								{
									int getGoldVal =  monster.DqmMobGOLD / 10;

						            getGoldVal = getGoldVal + ExtendedPlayerProperties.get(ep).getGold();
						            //DQR.func.debugString("doGold5:" + getGoldVal);
						            ExtendedPlayerProperties.get(ep).setGold(getGoldVal);
								}
								hitFlg = true;
							}
						}else if(weaponSkill == 4)
						{
							//ラストバッター
							ret = ret * 1.2F;
							ep.addPotionEffect(new PotionEffect(DQPotionMinus.debuffStop.id, 20, 1));
							DQR.func.setKnockBack(evb, 4, ep, true);

							hitFlg = true;
						}else if(weaponSkill == 6)
						{
							//ドラムクラッシュ
							if(monster != null && monster.MobRoot.getId() == EnumDqmMobRoot.BUSSITU.getId())
							{
								ret = ret * 1.5F;
								hitFlg = true;
							}
						}else if(weaponSkill == 8)
						{
							//ランドインパクト
							if(monster != null && monster.MobRoot.getId() == EnumDqmMobRoot.BUSSITU.getId())
							{
								ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
								//monster.damageEntity(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage *3.0F));
					            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
					            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(5.0D, 3.0D, 5.0D));

					            //System.out.println("TEST1:" + list.size());

				            	for (int n = 0 ; n < list.size() ; n++)
				            	{
				            		Entity target = (Entity)list.get(n);

				            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            		{
				            			EntityLivingBase tagMob = (EntityLivingBase)target;
				            			//System.out.println("TEST2:" + tagMob.MobName);
				            			tagMob.hurtResistantTime = 0;
				            			tagMob.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 1.3F));
				            			DQR.func.setKnockBack(tagMob, 4, ep, true);

				            			tagMob.hurtResistantTime = 0;
				            		}
				            	}

								ret = ret * 1.3F;
								hitFlg = false;
							}
						}
					}
					else if(weapon == EnumDqmWeapon.DqmAxe.getId())
					{
						if(weaponSkill == 0)
						{
							//たいぼく斬
							if(monster != null && isPlantMob(monster))
							{
								ret = ret * 1.5F;
								hitFlg = true;
							}
						}else if(weaponSkill == 2)
						{
							//蒼天魔斬
							if(rand.nextInt(2) == 0)
							{
								evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffStop.id, 200, 1));
							}
							ret = ret * 1.3F;
							hitFlg = true;
						}else if(weaponSkill == 4)
						{
							//かぶと割り
							evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffRukani.id, 300, 1));
							hitFlg = true;
						}else if(weaponSkill == 8)
						{
							//オノむそう

							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
				            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(4.0D, 3.0D, 4.0D));

				            //System.out.println("TEST1:" + list.size());

			            	for (int n = 0 ; n < list.size() ; n++)
			            	{
			            		Entity target = (Entity)list.get(n);

			            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
			            		{
			            			EntityLivingBase tagMob = (EntityLivingBase)target;
			            			//System.out.println("TEST2:" + tagMob.MobName);
			            			tagMob.hurtResistantTime = 0;
			            			float dam = preDamage * (1.0F - (0.9F / list.size() * n ));
			            			tagMob.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (dam));
			            			tagMob.hurtResistantTime = 0;
			            		}
			            	}

							ret = -1.0F;
							hitFlg = false;

						}
					}
					else if(weapon == EnumDqmWeapon.DqmWhip.getId())
					{
						if(weaponSkill == 0)
						{
							//らせん打ち
							evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffMedapani.id, 300, 1));
							hitFlg = true;
						}else if(weaponSkill == 1)
						{
							//愛のムチ
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
				            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(4.0D, 3.0D, 4.0D));

				            //System.out.println("TEST1:" + list.size());

			            	for (int n = 0 ; n < list.size() ; n++)
			            	{
			            		Entity target = (Entity)list.get(n);

			            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
			            		{
			            			EntityLivingBase tagMob = (EntityLivingBase)target;
			            			//System.out.println("TEST2:" + tagMob.MobName);
			            			tagMob.hurtResistantTime = 0;
			            			float dam = preDamage * (1.0F - (0.9F / list.size() * n ));
			            			tagMob.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (dam));
			            			tagMob.hurtResistantTime = 0;
			            		}
			            	}

							ret = -1.0F;
							hitFlg = false;
						}else if(weaponSkill == 3)
						{
							//しばり打ち
							evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffStop.id, 200, 1));
							hitFlg = true;
						}else if(weaponSkill == 5)
						{
							//ねむり打ち
							evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffRariho.id, 300, 1));
							hitFlg = true;
						}else if(weaponSkill == 7)
						{
							//ヒールウィップ
							float healPoint = 0.0F;
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
				            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(4.0D, 3.0D, 4.0D));

				            //System.out.println("TEST1:" + list.size());

			            	for (int n = 0 ; n < list.size() ; n++)
			            	{
			            		Entity target = (Entity)list.get(n);

			            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
			            		{
			            			EntityLivingBase tagMob = (EntityLivingBase)target;
			            			//System.out.println("TEST2:" + tagMob.MobName);
			            			tagMob.hurtResistantTime = 0;
			            			float dam = preDamage * (1.0F - (0.9F / list.size() * n ));
			            			tagMob.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (dam));
			            			tagMob.hurtResistantTime = 0;
			            			healPoint = healPoint + dam;
			            		}
			            	}

							ret = ret * 1.0F;
							healPoint = healPoint + ret;
							ep.heal(healPoint / 4);
							hitFlg = false;
						}else if(weaponSkill == 8)
						{
							//双竜打ち
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							evb.hurtResistantTime = 0;
							evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage * 1.25F));
							evb.hurtResistantTime = 0;
							ret = ret * 1.25F;
							hitFlg = false;
						}
					}
					else if(weapon == EnumDqmWeapon.DqmLance.getId())
					{
						if(weaponSkill == 2)
						{
							//けものづき
							if(monster != null && monster.MobRoot.getId() == EnumDqmMobRoot.BEAST.getId())
							{
								ret = ret * 1.5F;
								hitFlg = true;
							}
						}else if(weaponSkill == 3)
						{
							//きゅうしょづき
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

							if(rand.nextInt(5) == 0)
							{
								evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamageDeath(ep), evb.getMaxHealth() + 100.0F);
								ret = -1.0F;
							}else
							{
								ret = ret * 0.5F;
							}

							hitFlg = false;
						}else if(weaponSkill == 8)
						{
							//さみだれ突き
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

							/*
							evb.hurtResistantTime = 0;
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

							int roopMax = 3 + rand.nextInt(2);

							for(int cnt = 0; cnt < roopMax; cnt++)
							{
								//float fixDam = (1.0F + (rand.nextFloat() * 4)) * 0.1F;
								evb.hurtResistantTime = 0;
								evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
							}

							evb.hurtResistantTime = 0;

							ret = ret *  ((1.0F + (rand.nextFloat() * 4)) * 0.1F);
							*/


							 List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
					            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(6.0D, 3.0D, 6.0D));

				            Entity target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
				            	}
				            }


				            target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
				            	}
				            }


				            target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
				            	}
				            }


				            if(rand.nextInt(2) == 0)
				            {
					            target = (Entity)list.get(rand.nextInt(list.size()));
					            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
					            {
					            	if(!target.isDead)
					            	{
					            		target.hurtResistantTime = 0;
					            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
					            	}
					            }
				            }

				            ret = -1.0F;

							hitFlg = false;
						}
					}
					else if(weapon == EnumDqmWeapon.DqmKnife.getId())
					{
						if(weaponSkill == 0)
						{
							//ポイズンダガー
							if(rand.nextInt(5)==0)
							{
								evb.addPotionEffect(new PotionEffect(DQPotionMinus.potionPoisonX.id, 300, 1));
							}
							hitFlg = true;
						}else if(weaponSkill == 2)
						{
							//キラーブーン
							if(monster != null && monster.MobRoot.getId() == EnumDqmMobRoot.SIZEN.getId())
							{
								ret = ret * 1.5F;
								hitFlg = true;
							}
						}else if(weaponSkill == 4)
						{
							//タナトスハント
							if(evb.getActivePotionEffect(DQPotionMinus.potionPoison) != null ||
							   evb.getActivePotionEffect(DQPotionMinus.potionPoisonX) != null ||
							   evb.getActivePotionEffect(DQPotionMinus.debuffRariho) != null ||
							   evb.getActivePotionEffect(DQPotionMinus.debuffManusa) != null ||
							   evb.getActivePotionEffect(DQPotionMinus.debuffMedapani) != null ||
							   evb.getActivePotionEffect(DQPotionMinus.debuffStop) != null
							  )
							{
								ret = ret * 1.5F;
							}
							hitFlg = true;

						}else if(weaponSkill == 6)
						{
							//アサシンアタック
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

							if(rand.nextInt(5) == 0)
							{
								evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamageDeath(ep), evb.getMaxHealth() + 100.0F);
								ret = -1.0F;
							}else
							{
								ret = ret * 1.0F;
							}

							hitFlg = false;
						}else if(weaponSkill == 8)
						{
							//バンパイアエッジ
							ret = ret * 1.00F;
							//ep.heal(ret / 4);

	                    	if(ep.getHealth() + (ret / 4) > ep.getMaxHealth())
	                    	{
	                    		ep.setHealth(ep.getMaxHealth());
	                    	}else
	                    	{
	                    		ep.setHealth(ep.getHealth() + (ret / 4));
	                    	}

							hitFlg = true;
						}
					}
					else if(weapon == EnumDqmWeapon.DqmBow.getId())
					{

					}
					else if(weapon == EnumDqmWeapon.DqmThrow.getId())
					{

					}else if(weapon == EnumDqmWeapon.DqmRod.getId())
					{
						if(weaponSkill == 1)
						{
							//足ばらい
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							//monster.damageEntity(DQR.damageSource.getPlayerSkillDamage(ep), (preDamage *3.0F));
				            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(5.0D, 3.0D, 5.0D));

				            //System.out.println("TEST1:" + list.size());

			            	for (int n = 0 ; n < list.size() ; n++)
			            	{
			            		Entity target = (Entity)list.get(n);

			            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
			            		{
			            			EntityLivingBase tagMob = (EntityLivingBase)target;
			            			//System.out.println("TEST2:" + tagMob.MobName);
			            			tagMob.addPotionEffect(new PotionEffect(DQPotionMinus.debuffStop.id, 100, 1));
			            		}
			            	}

							ret = ret * 1.3F;
							hitFlg = false;
						}else if(weaponSkill == 3)
						{
							//黄泉送り
							if(monster != null && monster.MobRoot.getId() == EnumDqmMobRoot.UNDEAD.getId())
							{
								ret = ret * 1.5F;
							}
							hitFlg = true;
						}else if(weaponSkill == 5)
						{
							//なぎはらい
							//float healPoint = 0.0F;
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
				            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(4.0D, 3.0D, 4.0D));

				            //System.out.println("TEST1:" + list.size());

			            	for (int n = 0 ; n < list.size() ; n++)
			            	{
			            		Entity target = (Entity)list.get(n);

			            		if (!(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
			            		{
			            			EntityLivingBase tagMob = (EntityLivingBase)target;
			            			//System.out.println("TEST2:" + tagMob.MobName);
			            			tagMob.hurtResistantTime = 0;
			            			float dam = preDamage * (1.0F - (0.9F / list.size() * n ));
			            			tagMob.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), (dam));
			            			tagMob.hurtResistantTime = 0;
			            			//healPoint = healPoint + dam;
			            		}
			            	}

			            	ret = -1.0F;
							//ret = ret * 1.0F;
							//healPoint = healPoint + ret;
							//ep.heal(healPoint / 4);
							hitFlg = false;
						}else if(weaponSkill == 7)
						{
							//氷結らんげき
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
				            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
				            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(6.0D, 3.0D, 6.0D));

				            Entity target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.3F);
				            	}
				            }


				            target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.3F);
				            	}
				            }


				            target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.3F);
				            	}
				            }


				            target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.3F);
				            	}
				            }

				            ret = -1.0F;
				            hitFlg = false;
						}
					}else if(weapon == EnumDqmWeapon.DqmSoroban.getId())
					{
						if(weaponSkill == 1)
						{
							//審判打ち
							if(monster != null && monster.MobRoot.getId() == EnumDqmMobRoot.UNKNOWN.getId())
							{
								ret = ret * 1.5F;
							}
							hitFlg = true;
						}else if(weaponSkill == 3)
						{
							//つまづいて転ぶ
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

							if(!ep.worldObj.isRemote)
							{
								ItemStack ist = ep.inventory.getCurrentItem();
								ep.inventory.mainInventory[ep.inventory.currentItem] = null;
								ep.dropPlayerItemWithRandomChoice(ist, true);
							}

							evb.attackEntityFrom(DQR.damageSource.getPlayerSkillDamageCri(ep), ret * 2.0F);

				            ret = -1.0F;
				            hitFlg = false;
						}else if(weaponSkill == 5)
						{
				            int getGoldVal = ExtendedPlayerProperties.get(ep).getGold();

				            if(evb.getHealth() > (ret / 2))
				            {
				            	getGoldVal = getGoldVal + (int)(ret / 2);
				            }else
				            {
				            	getGoldVal = getGoldVal + (int)evb.getHealth();
				            }

				            //DQR.func.debugString("doGold5:" + getGoldVal);
				            ExtendedPlayerProperties.get(ep).setGold(getGoldVal);

							hitFlg = true;
						}else if(weaponSkill == 7)
						{
							//System.out.println("TEST!!!!!!!!!!!!!!!!!!!");
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
							//軍隊呼び
							if(ep.worldObj.isAirBlock((int)ep.posX + 1, (int)ep.posY, (int)ep.posZ) &&
							   ep.worldObj.isAirBlock((int)ep.posX + 1, (int)ep.posY + 1, (int)ep.posZ) &&
							   ep.worldObj.isAirBlock((int)ep.posX + 1, (int)ep.posY + 2, (int)ep.posZ))
							{
								DqmEntityNPCGuntai gun1 = new DqmEntityNPCGuntai(ep.worldObj);
								gun1.setOwnner(ep);
								gun1.setKougeki((int)(ret / 2));
								gun1.setLocationAndAngles((double)ep.posX + 1.0D, (double)ep.posY + 2.0D, (double)ep.posZ, 0.0F, 0.0F);
								if(!ep.worldObj.isRemote) ep.worldObj.spawnEntityInWorld(gun1);
							}

							if(ep.worldObj.isAirBlock((int)ep.posX - 1, (int)ep.posY, (int)ep.posZ) &&
							   ep.worldObj.isAirBlock((int)ep.posX - 1, (int)ep.posY + 1, (int)ep.posZ) &&
							   ep.worldObj.isAirBlock((int)ep.posX - 1, (int)ep.posY + 2, (int)ep.posZ))
							{
								DqmEntityNPCGuntai gun2 = new DqmEntityNPCGuntai(ep.worldObj);
								gun2.setOwnner(ep);
								gun2.setKougeki((int)(ret / 2));
								gun2.setLocationAndAngles((double)ep.posX - 1.0D, (double)ep.posY + 2.0D, (double)ep.posZ, 0.0F, 0.0F);
								if(!ep.worldObj.isRemote) ep.worldObj.spawnEntityInWorld(gun2);
							}

							if(ep.worldObj.isAirBlock((int)ep.posX, (int)ep.posY, (int)ep.posZ + 1) &&
							   ep.worldObj.isAirBlock((int)ep.posX, (int)ep.posY + 1, (int)ep.posZ + 1) &&
							   ep.worldObj.isAirBlock((int)ep.posX, (int)ep.posY + 2, (int)ep.posZ + 1))
							{
								DqmEntityNPCGuntai gun3 = new DqmEntityNPCGuntai(ep.worldObj);
								gun3.setOwnner(ep);
								gun3.setKougeki((int)(ret / 2));
								gun3.setLocationAndAngles((double)ep.posX, (double)ep.posY + 2.0D, (double)ep.posZ + 1.0D, 0.0F, 0.0F);
								if(!ep.worldObj.isRemote) ep.worldObj.spawnEntityInWorld(gun3);
							}

							hitFlg = false;
							/**/
							/**/
							/**/
							/**/
							/**/
							/**/
							/**/
							/**/

						}

					}else if(weapon == EnumDqmWeapon.DqmOugi.getId())
					{
						if(weaponSkill == 0)
						{
							//花ふぶき
							evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffManusa.id, 200, 1));

							ret = ret * 1.0F;
							hitFlg = true;
						}else if(weaponSkill == 2)
						{
							//といき返し
							/*ブレス反射バフを追加*/
							/*モンスターのスキル攻撃に射出主を指定するように*/
							/*モンスターのブレス攻撃を魔法とは切り分ける*/
							ep.addPotionEffect(new PotionEffect(DQPotionPlus.buffBreathReflect.id, 300, 1));
							hitFlg = true;

						}else if(weaponSkill == 4)
						{
							//波紋演舞
							if(monster != null && isWaterMob(monster))
							{
								ret = ret * 1.5F;
								hitFlg = true;
							}

						}else if(weaponSkill == 6)
						{
							//風姿花伝
							PotionEffect pe = ep.getActivePotionEffect(DQPotionPlus.buffKaihiUp);
							int ampli = 1;
							int dur = 100;

							if(pe != null)
							{
								if(pe.getAmplifier() > ampli)
								{
									ampli = pe.getAmplifier();
								}

								dur = dur + pe.getDuration();
							}

							ep.addPotionEffect(new PotionEffect(DQPotionPlus.buffKaihiUp.id, dur, ampli));

							hitFlg = true;
						}else if(weaponSkill == 8)
						{
							//おうぎのまい
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

							 List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
					            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(6.0D, 3.0D, 6.0D));

				            Entity target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
				            	}
				            }


				            target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
				            	}
				            }


				            target = (Entity)list.get(rand.nextInt(list.size()));
				            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
				            {
				            	if(!target.isDead)
				            	{
				            		target.hurtResistantTime = 0;
				            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
				            	}
				            }


				            if(rand.nextInt(2) == 0)
				            {
					            target = (Entity)list.get(rand.nextInt(list.size()));
					            if(target != null && !(target instanceof EntityPlayer) && !(target instanceof EntityTameable) &&  !(target instanceof EntityHorse) && target instanceof EntityLivingBase)
					            {
					            	if(!target.isDead)
					            	{
					            		target.hurtResistantTime = 0;
					            		target.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(ep), preDamage * 0.5F);
					            	}
					            }
				            }

				            ret = -1.0F;

							hitFlg = false;
						}
					}else if(weapon == EnumDqmWeapon.DqmMonsterWeapon.getId())
					{
						if(weaponSkill == 1)
						{
							//まふうじのつえ
							evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffMahoton.id, 200, 1));

							ret = ret * 1.0F;
							hitFlg = true;
						}else if(weaponSkill == 3)
						{
							//悪魔ばらい
							if(rand.nextInt(2) == 0)
							{
								evb.addPotionEffect(new PotionEffect(DQPotionMinus.debuffStop.id, 200, 1));
							}

							ret = ret * 1.0F;
							hitFlg = true;
						}else if(weaponSkill == 5)
						{
							//しゅくふくのつえ
							ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));

							List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
							    		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(6.0D, 3.0D, 6.0D));

							ArrayList<EntityPlayer> epList = new ArrayList<EntityPlayer>();

							for(int cnt = 0; cnt < list.size(); cnt++)
							{
								Entity entCnt = (Entity)list.get(cnt);
								if(entCnt instanceof EntityPlayer)
								{
									epList.add((EntityPlayer)entCnt);
								}
							}

							if(epList.size() > 0)
							{
								EntityPlayer targetEP = epList.get(rand.nextInt(epList.size()));
								targetEP.heal(ret);
								hitFlg = true;
							}

							//Entity target = (Entity)list.get(rand.nextInt(list.size()));
						}
					}else if(weapon == EnumDqmWeapon.DqmGlobe.getId())
					{

					}else if(weapon == EnumDqmWeapon.DqmScythe.getId())
					{

					}


					if(hitFlg)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
					}
				}
			}

			//System.out.println("test2");
			/*
			if(evb instanceof DqmMobBase)
			{
				DqmMobBase monster = (DqmMobBase)evb;
				//Dana
				//隼斬りの例
				monster.damageEntity(DQR.damageSource.getPlayerSkillDamage(ep), par1);
				//System.out.println("test3");
			}
			*/
		}



		return ret;
	}

=======
>>>>>>> parent of 2aede75... ver0.8.7.8
	public float applyDamageResist(float par1, EntityLivingBase evb, DamageSource source)
	{
		float ret = par1;
		String mobName = null;

		if(evb instanceof DqmMobBase)
		{
			DqmMobBase mob = (DqmMobBase)evb;
			EnumDqmMonster type = mob.monsterType;
			mobName = type.getMobName();

		}else if(evb instanceof DqmPetBase)
		{
			DqmPetBase mob = (DqmPetBase)evb;
			EnumDqmPet type = mob.type;
			mobName = type.PetName;
		}

		if(mobName != null)
		{
			EnumDqmMonsterResist resist = DQR.enumGetter.getMonsterResistFromMobname(mobName);

			if(resist != null)
			{
				System.out.println("TEST" + resist.getClassname());
				//System.out.println("TEST" + source.getEntity().getCommandSenderName());
				float resRate = 1.0F;
				Entity ent = source.getEntity();
				if(ent instanceof MagicEntityMera || ent instanceof MagicEntityMerami ||
				   ent instanceof MagicEntityMerazoma || ent instanceof MagicEntityMeragaia )
				{
					resRate =  resist.getMera();
					if(resRate > 1.0F)
					{
						evb.worldObj.playSoundAtEntity(evb, "dqr:player.kaisinMera", 0.5F, 1.0F);
					}
				}else if(ent instanceof MagicEntityGira || ent instanceof MagicEntityBegirama ||
						 ent instanceof MagicEntityBegiragon || ent instanceof MagicEntityGiragureido)
				{
					resRate = resist.getGira();
					if(resRate > 1.0F)
					{
						evb.worldObj.playSoundAtEntity(evb, "dqr:player.kaisinMera", 0.5F, 1.0F);
					}
				}else if(ent instanceof MagicEntityHyado)
				{
					resRate = resist.getHyado();
					if(resRate > 1.0F)
					{
						evb.worldObj.playSoundAtEntity(evb, "dqr:player.kaisinHyado", 0.5F, 1.0F);
					}
				}else if(ent instanceof MagicEntityIo)
				{
					resRate = resist.getIo();

				}else if(ent instanceof MagicEntityBagi)
				{
					resRate = resist.getBagi();
					if(resRate > 1.0F)
					{
						evb.worldObj.playSoundAtEntity(evb, "dqr:player.kaisinBagi", 0.5F, 1.0F);
					}
				}else if(ent instanceof MagicEntityRaidein)
				{
					resRate = resist.getRaidein();
				}
				else if(ent instanceof MagicEntityDoruma)
				{
					resRate = resist.getDoruma();
					if(resRate > 1.0F)
					{
						evb.worldObj.playSoundAtEntity(evb, "dqr:player.kaisinDoruma", 0.5F, 1.0F);
					}
				}

				if(resRate < 1.0F && resRate > 0.0F)
				{
					evb.worldObj.playSoundAtEntity(evb, "dqr:player.down", 0.5F, 1.0F);
				}

				ret = ret * resRate;
			}
		}


		//if(source.getEntity())
		return ret;
	}

	////////////ダミー計算/////////////
	public float getDummyDamage(float par1, EntityLivingBase evb, DamageSource source)
	{
		float dam = par1;

		if(evb instanceof EntityLiving)
		{
			EntityLiving ev = (EntityLiving)evb;
			dam = this.applyArmorCalculations(source, dam, ev);
			dam = this.applyPotionDamageCalculations(source, dam, ev);
		    float f1 = dam;
		    dam = Math.max(dam - ev.getAbsorptionAmount(), 0.0F);
		}
	    return dam;
	}

    protected float applyArmorCalculations(DamageSource p_70655_1_, float p_70655_2_, EntityLiving evr)
    {
        if (!p_70655_1_.isUnblockable())
        {
            int i = 25 - evr.getTotalArmorValue();
            float f1 = p_70655_2_ * (float)i;
            p_70655_2_ = f1 / 25.0F;
        }

        return p_70655_2_;
    }

    protected float applyPotionDamageCalculations(DamageSource p_70672_1_, float p_70672_2_, EntityLiving evr)
    {
        if (p_70672_1_.isDamageAbsolute())
        {
            return p_70672_2_;
        }
        else
        {
            if (evr instanceof EntityZombie)
            {
                //par2 = par2; // Forge: Noop Warning
            }

            int i;
            int j;
            float f1;

            if (evr.isPotionActive(Potion.resistance) && p_70672_1_ != DamageSource.outOfWorld)
            {
                i = (evr.getActivePotionEffect(Potion.resistance).getAmplifier() + 1) * 5;
                j = 25 - i;
                f1 = p_70672_2_ * (float)j;
                p_70672_2_ = f1 / 25.0F;
            }

            if (p_70672_2_ <= 0.0F)
            {
                return 0.0F;
            }
            else
            {
                i = EnchantmentHelper.getEnchantmentModifierDamage(evr.getLastActiveItems(), p_70672_1_);

                if (i > 20)
                {
                    i = 20;
                }

                if (i > 0 && i <= 20)
                {
                    j = 25 - i;
                    f1 = p_70672_2_ * (float)j;
                    p_70672_2_ = f1 / 25.0F;
                }

                return p_70672_2_;
            }
        }
    }
    //////ダミー計算ここまで////////////////////
<<<<<<< HEAD

    public boolean isWaterMob(Entity par1)
    {
    	//マシン系の場合
    	if(par1 instanceof DqmEntityGuntaigani ||
    	   par1 instanceof DqmEntitySibirekurage ||
    	   par1 instanceof DqmEntityObakeumiusi ||
    	   par1 instanceof DqmEntityUzusioking ||
    	   par1 instanceof DqmEntityUmibouzu ||
    	   par1 instanceof DqmEntityJigokunohasami ||
    	   par1 instanceof DqmEntityGanirasu ||
    	   par1 instanceof DqmEntityKirakurabu ||
    	   par1 instanceof DqmEntityUmiusi ||
    	   par1 instanceof DqmEntityMarinsuraimu)
    	{
    		return true;
    	}

    	return false;
    }

    public boolean isMachineMob(Entity par1)
    {
    	//マシン系の場合
    	if(par1 instanceof DqmEntityBassaimasin ||
    	   par1 instanceof DqmEntityMetaruhanta ||
    	   par1 instanceof DqmEntityKiramasin ||
    	   par1 instanceof DqmEntityKiramasin2 ||
    	   par1 instanceof DqmEntityMetaruhantaken ||
    	   par1 instanceof DqmEntityKiramajinga ||
    	   par1 instanceof DqmEntityTaipug)
    	{
    		return true;
    	}

    	return false;
    }

    public boolean isPlantMob(Entity par1)
    {
    	//植物系の場合
    	if(par1 instanceof DqmEntityZukkinya ||
    	   par1 instanceof DqmEntityObakekinoko ||
    	   par1 instanceof DqmEntityKirikabuobake ||
    	   par1 instanceof DqmEntityEbiruapple ||
    	   par1 instanceof DqmEntitySabotenboru ||
    	   par1 instanceof DqmEntityBurakkubejita ||
    	   par1 instanceof DqmEntityMagematango ||
    	   par1 instanceof DqmEntityMatango ||
    	   par1 instanceof DqmEntityButtizukinya ||
    	   par1 instanceof DqmEntityDansunidoru ||
    	   par1 instanceof DqmEntityGappurin ||
    	   par1 instanceof DqmEntitySabotengold)
    	{
    		return true;
    	}

    	return false;
    }

    public boolean isBirdMob(Entity par1)
    {
    	//植物系の場合
    	if(par1 instanceof DqmEntityKimera ||
    	   par1 instanceof DqmEntityStarkimera ||
    	   par1 instanceof DqmEntityStarkimera ||
    	   par1 instanceof DqmEntityMoonkimera ||
    	   par1 instanceof DqmEntityOokutibasi ||
    	   par1 instanceof DqmEntityAkairai ||
    	   par1 instanceof DqmEntityDeddopekka ||
    	   par1 instanceof DqmEntityBigCrow ||
    	   par1 instanceof DqmEntityDesufuratta ||
    	   par1 instanceof DqmEntityDucksbill ||
    	   par1 instanceof DqmEntityMomonja ||
    	   par1 instanceof DqmEntityMagemomonja)
    	{
    		return true;
    	}

    	return false;
    }
=======
>>>>>>> parent of 2aede75... ver0.8.7.8
}
