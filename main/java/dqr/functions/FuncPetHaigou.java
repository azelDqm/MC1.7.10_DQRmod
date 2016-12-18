package dqr.functions;

import java.util.Random;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQMagics;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmMobCateg;
import dqr.api.enums.EnumDqmMobRoot;
import dqr.api.enums.EnumDqmMonster;
import dqr.api.enums.EnumDqmPet;
import dqr.api.enums.EnumDqmPetHaigouSP;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;


public class FuncPetHaigou {

	public FuncPetHaigou(){}
	private String soundName = null;
	public void doHaogou(EntityPlayer ep, World par3World, int par4, int par5, int par6, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		NBTTagCompound haigouPet1 = ExtendedPlayerProperties3.get(ep).getHaigouPet1();
		NBTTagCompound haigouPet2 = ExtendedPlayerProperties3.get(ep).getHaigouPet2();
		DqmPetBase entityPet1 = null;
		DqmPetBase entityPet2 = null;

    	int petCount = ExtendedPlayerProperties3.get(ep).getPetCount();
    	boolean flg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(ep.getGameProfile());

    	if(DQR.conf.petLimitPlayer == 0 || petCount < DQR.conf.petLimit || (flg && DQR.conf.petLimitPlayer == 1))
    	{

			if(((haigouPet1 != null && !haigouPet1.hasNoTags()) && (haigouPet2 != null  && !haigouPet2.hasNoTags())) || ep.isSneaking())
			{


				String mobBaseName = haigouPet1.getString("PetBaseName");
				haigouPet1.setString("OwnerUUID", ep.getUniqueID().toString());
				entityPet1 = (DqmPetBase)EntityList.createEntityByName(mobBaseName, par3World);
				entityPet1 = setNBT(haigouPet1, entityPet1, ep);

				String mobBaseName2 = haigouPet2.getString("PetBaseName");
				haigouPet2.setString("OwnerUUID", ep.getUniqueID().toString());
				entityPet2 = (DqmPetBase)EntityList.createEntityByName(mobBaseName2, par3World);
				entityPet2 = setNBT(haigouPet2, entityPet2, ep);

				if(entityPet1 != null && entityPet2 != null && !ep.worldObj.isRemote  && !ep.isSneaking())
				{

					PotionEffect pe;
					pe = ep.getActivePotionEffect(DQPotionMinus.debuffMahoton);
					if(pe != null && ep.worldObj.isRemote)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.magic.mahoton.txt",new Object[] {}));
						ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

						return;
					}

					if(DQR.func.isBind(ep) && ep.worldObj.isRemote)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
						ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

						return;
					}

					int epMP = ExtendedPlayerProperties.get(ep).getMP();
					if(epMP < EnumDqmMagic.Haigou.getMP() && DQR.debug == 0)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
						ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
						return;
					}else
					{
						ExtendedPlayerProperties.get(ep).setMP(epMP - EnumDqmMagic.Haigou.getMP());
					}

					ep.worldObj.playSoundAtEntity(ep, "dqr:player.jumon", 0.5F, 1.0F);

					//FuncPetHaigou func = new FuncPetHaigou();
					EnumDqmPet haigouResult = this.getHaigouMonster(entityPet1, entityPet2, ep);

					if(haigouResult != null)
					{
						float[] inheritHP = this.calcInheritHP(entityPet1, entityPet2);
						int[] inheritMP = this.calcInheritMP(entityPet1, entityPet2);
						int[] inheritTikara = this.calcInheritTikara(entityPet1, entityPet2);
						int[] inheritKasikosa = this.calcInheritKasikosa(entityPet1, entityPet2);

						//System.out.println("HaigouResult : " + haigouResult.PetName);
						entityPet1 = null;
						entityPet2 = null;
						EnumDqmMonster parentType =  DQR.enumGetter.getMonsterFromName(haigouResult.PetName);

						DqmPetBase newPet = (DqmPetBase)EntityList.createEntityByName(DQR.modID + "." + parentType.getPetClassName(), par3World);

						if(newPet != null)
						{

							if(DQR.magicTable.getMAptitude(DQMagics.itemHaigou, ep) > 0)
							{

								int getJukurenExp = 1 + ExtendedPlayerProperties.get(ep).getJukurenExp(ExtendedPlayerProperties.get(ep).getWeapon());
								ExtendedPlayerProperties.get(ep).setJukurenExp(ExtendedPlayerProperties.get(ep).getWeapon(), getJukurenExp);
							}

							newPet.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + 1.0D, (double)par6 + 0.5D, 0.0F, 0.0F);
							par3World.spawnEntityInWorld(newPet);

							newPet.setTamed(true);
		                    //System.out.println("TEST1" + ep.getCommandSenderName());
		                    //System.out.println("TEST2" + ep.getDisplayName());
							newPet.ownerName = ep.getCommandSenderName();
	//System.out.println("TEST1");
		                    String s = PreYggdrasilConverter.func_152719_a(newPet.ownerName);
		                    newPet.ownerUUID = s;
		                    //System.out.println("HP????" + type.HPDEF);
		                    newPet.setJobKasikosaA(inheritKasikosa);
		                    newPet.setJobTikaraA(inheritTikara);
		                    newPet.setJobMPA(inheritMP);
		                    newPet.setJobHPA(inheritHP);
		                    //newPet.setJobHP(EnumDqmJob.Asobinin.getId(), newPet.getJobHP(EnumDqmJob.Asobinin.getId()));
		                    //newPet.setJobMP(EnumDqmJob.Asobinin.getId(), newPet.getJobMP(EnumDqmJob.Asobinin.getId()));
		                    //newPet.setJobTikara(EnumDqmJob.Asobinin.getId(), newPet.getJobTikara(EnumDqmJob.Asobinin.getId()));
		                    //newPet.setJobKasikosa(EnumDqmJob.Asobinin.getId(), newPet.getJobKasikosa(EnumDqmJob.Asobinin.getId()));
		                    newPet.setMaxHP(DQR.calcPetStatus.calcHP(newPet));
		                    newPet.setMaxMP(DQR.calcPetStatus.calcMP(newPet));
		                    //newPet.setArrayTikaraA(inheritTikara);
		                    //newPet.setArrayKasikosaA(inheritKasikosa);
		                    //newPet.setMaxHP(haigouResult.HPDEF);
		                    newPet.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(newPet.getMaxHP());

		                    //newPet.setMaxMP(haigouResult.MPDEF);
		                    //newPet.setJobTikara(newPet.getJob(), haigouResult.TIKARADEF);
		                    //newPet.setJobKasikosa(newPet.getJob(), haigouResult.KASIKOSADEF);
		                    newPet.setHealth(newPet.getMaxHealth());
		                    newPet.setMP(newPet.getMaxMP());
		                    //System.out.println("TEST2");
		                    //this.func_110226_cD();
		                    newPet.setPathToEntity((PathEntity)null);
		                    newPet.setAttackTarget((EntityLivingBase)null);
		                    newPet.setSit(true);
		                    //this.setHealth(20.0F);
		                    newPet.func_152115_b(ep.getUniqueID().toString());
		                    //newPet.playTameEffect(true);
		                    if(soundName != null)
		                    {
		                    	Random rand2 = new Random();
		                    	//System.out.println("SOUND");
		                    	//newPet.worldObj.playSoundAtEntity(newPet, "dqr:player.pet", 1.0F, 1.0F);
		                    	newPet.playSound("ambient.weather.thunder", 1.0F, 1.2F / (rand2.nextFloat() * 0.2F + 0.9F));
		                    	//newPet.worldObj.playSoundAtEntity(newPet, soundName, 1.0F, 1.0F);
		                    }else
		                    {
		                    	newPet.worldObj.playSoundAtEntity(newPet, "dqr:mob.inoti", 0.5F, 2.0F);
		                    }
		                    newPet.worldObj.setEntityState(newPet, (byte)7);
		                    ExtendedPlayerProperties3.get(ep).plusPetCount(1);
		                    DQR.petFunc.setNewPetdata(newPet);

							petCount++;
						}else
						{
							DQR.func.debugString("Haigou Ret is null");
						}
					}else
					{
						//配合不可組み合わせ(戻す)
						//System.out.println("Haigour Error:3");
						//DQR.func.debugString("Haigour Error:3");
						ep.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petHaigou0",new Object[] {}));
					}


				}

				if(entityPet1 != null)
				{
					if(DQR.conf.petLimitPlayer == 0 || (petCount + 1) < DQR.conf.petLimit || (flg && DQR.conf.petLimitPlayer == 1))
			    	{
						entityPet1.setTamed(true);
						entityPet1.ownerName = ep.getCommandSenderName();
			            String s = null;
			            if(!ep.worldObj.isRemote)
			            {
			            	s = PreYggdrasilConverter.func_152719_a(ep.getCommandSenderName());
				            if(s == null || s.equalsIgnoreCase("") || s.length() == 0)
				            {
				            	entityPet1.ownerUUID = s;
				            }
			            }
			            if(!ep.worldObj.isRemote)
			            {
			            	entityPet1.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + 1.5D, (double)par6 + 0.5D, 0.0F, 0.0F);
			            	par3World.spawnEntityInWorld(entityPet1);
			                ExtendedPlayerProperties3.get(ep).plusPetCount(1);
			                DQR.petFunc.setNewPetdata(entityPet1);
			            }
			            entityPet1 = null;
			            petCount++;
			    	}
				}

				if(entityPet2 != null)
				{
					if(DQR.conf.petLimitPlayer == 0 || (petCount + 1) < DQR.conf.petLimit || (flg && DQR.conf.petLimitPlayer == 1))
			    	{
			            entityPet2.setTamed(true);
						entityPet2.ownerName = ep.getCommandSenderName();
			            String s = null;
			            if(!ep.worldObj.isRemote)
			            {
			            	s = PreYggdrasilConverter.func_152719_a(ep.getCommandSenderName());
				            if(s == null || s.equalsIgnoreCase("") || s.length() == 0)
				            {
				            	entityPet2.ownerUUID = s;
				            }
			            }
			            if(!ep.worldObj.isRemote)
			            {
			            	entityPet2.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + 1.5D, (double)par6 + 0.5D, 0.0F, 0.0F);
			            	par3World.spawnEntityInWorld(entityPet2);
			                ExtendedPlayerProperties3.get(ep).plusPetCount(1);
			                DQR.petFunc.setNewPetdata(entityPet2);
			            }
			            entityPet2 = null;
			            petCount++;
			    	}
				}

				if(entityPet1 == null)
				{
					ExtendedPlayerProperties3.get(ep).setHaigouPet1(new NBTTagCompound());
				}

				if(entityPet2 ==null)
				{
					ExtendedPlayerProperties3.get(ep).setHaigouPet2(new NBTTagCompound());
				}
			}else
			{
				System.out.println("Haigour Error:1");
			}
    	}
	}

	public float[] calcInheritHP(DqmPetBase pet1, DqmPetBase pet2)
	{
		//float[] ret = 0;
		Random rand1 = new Random();
		Random rand2 = new Random();
		float[] retArray = new float[pet1.getJobHPA().length];
		float[] HPArray = pet1.getJobHPA();
		float[] HPArray2 = pet2.getJobHPA();

		for(int cnt = 0; cnt < HPArray.length; cnt++)
		{
			retArray[cnt] = (HPArray[cnt] / (rand1.nextInt(7) + 6)) + (HPArray2[cnt] / (rand2.nextInt(7) + 6));
		}

		return retArray;
	}

	public int[] calcInheritMP(DqmPetBase pet1, DqmPetBase pet2)
	{
		//float[] ret = 0;
		Random rand1 = new Random();
		Random rand2 = new Random();
		int[] retArray = new int[pet1.getJobMPA().length];
		int[] MPArray = pet1.getJobMPA();
		int[] MPArray2 = pet2.getJobMPA();

		for(int cnt = 0; cnt < MPArray.length; cnt++)
		{
			retArray[cnt] = (MPArray[cnt] / (rand1.nextInt(7) + 6)) + (MPArray2[cnt] / (rand2.nextInt(7) + 6));
		}

		return retArray;
	}

	public int[] calcInheritTikara(DqmPetBase pet1, DqmPetBase pet2)
	{
		//float[] ret = 0;
		Random rand1 = new Random();
		Random rand2 = new Random();
		int[] retArray = new int[pet1.getJobTikaraA().length];
		int[] TikaraArray = pet1.getJobTikaraA();
		int[] TikaraArray2 = pet2.getJobTikaraA();

		for(int cnt = 0; cnt < TikaraArray.length; cnt++)
		{
			retArray[cnt] = (TikaraArray[cnt] / (rand1.nextInt(5) + 6)) + (TikaraArray2[cnt] / (rand2.nextInt(5) + 6));
		}

		return retArray;
	}

	public int[] calcInheritKasikosa(DqmPetBase pet1, DqmPetBase pet2)
	{
		//float[] ret = 0;
		Random rand1 = new Random();
		Random rand2 = new Random();
		int[] retArray = new int[pet1.getJobKasikosaA().length];
		int[] KasikosaArray = pet1.getJobKasikosaA();
		int[] KasikosaArray2 = pet2.getJobKasikosaA();

		for(int cnt = 0; cnt < KasikosaArray.length; cnt++)
		{
			retArray[cnt] = (KasikosaArray[cnt] / (rand1.nextInt(5) + 6)) + (KasikosaArray2[cnt] / (rand2.nextInt(5) + 6));
		}

		return retArray;
	}

	public EnumDqmPet getHaigouMonster(DqmPetBase par1, DqmPetBase par2, EntityPlayer ep)
	{
		Random rand = new Random();
		EnumDqmPet ret = null;

		//固定配合

		ret = this.getSpecialPet(par1, par2);
		if(ret != null)
		{
			//ep.worldObj.playSoundAtEntity(ep, "ambient.weather.thunder", 1.0F, 1.0F);
			//soundName = "ambient.weather.thunder";
			return ret;
		}

		//奇跡配合
		ret = this.getMiraclePet(par1);
		if(ret != null)
		{
			//ep.playSound("ambient.weather.thunder", 1.0F, 1.2F / (rand.nextFloat() * 0.2F + 0.9F));
			//ep.worldObj.playSoundAtEntity(ep, "ambient.weather.thunder", 1.0F, 1.0F);
			//soundName = "ambient.weather.thunder";
			return ret;
		}

		//配合後種族を取得
		EnumDqmMobRoot haigouRoot = this.calcNewHaigouRoot(par1, par2);
		EnumDqmMobCateg haigouCateg = this.calcNewMobCateg(par1, par2);
//System.out.println("PetName : " + par1.getCommandSenderName() + " / " + par2.getCommandSenderName());



		if(haigouRoot != null && haigouCateg != null)
		{
			DQR.func.debugString("Haigou Root / Categ :" + haigouRoot.getName() + " / " + haigouCateg.getName());

			EnumDqmPet[] haigouList = DQR.enumGetter.getHaigouPetList(haigouRoot, haigouCateg);

			if(haigouList == null || haigouList.length == 0)
			{
				return null;
			}
			return haigouList[rand.nextInt(haigouList.length)];
		}else
		{
			if(haigouRoot == null)
			{
				//System.out.println("Haigour Error:4");
			}
			if(haigouCateg == null)
			{
				//System.out.println("Haigour Error:5");
			}
		}

		return null;
	}

	//固定配合パターン
	public EnumDqmPet getSpecialPet(DqmPetBase par1, DqmPetBase par2)
	{
		Random rand;
		EnumDqmPetHaigouSP pattern = DQR.enumGetter.getEnumDqmPetHaigouSPFromName(par1.type.getPetname(), par2.type.getPetname());

		if(pattern != null)
		{
			rand = new Random();
			if(rand.nextInt(1000) < pattern.getSPRate())
			{
				soundName = "ambient.weather.thunder";
				return DQR.enumGetter.getEnumDqmPetFromName(pattern.getSPResult());
			}

			rand = new Random();
			if(rand.nextInt(1000) < pattern.getMissRate())
			{
				return DQR.enumGetter.getEnumDqmPetFromName(pattern.getMissResult());
			}
		}

		return null;
	}



	//奇跡配合パターン
	public EnumDqmPet getMiraclePet(DqmPetBase par1)
	{

		EnumDqmMonster parentType =  DQR.enumGetter.getMonsterFromName(par1.type.PetName);

		Random rand = new Random();

		if(parentType.getTenseiMob() != null)
		{
			if(rand.nextInt(10000) < 10 || DQR.debug > 0)
			{
				soundName = "ambient.weather.thunder";
				return DQR.enumGetter.getEnumDqmPetFromName(parentType.getTenseiMob());
			}
		}

		rand = new Random();
		if(parentType.getKakuseiMob() != null)
		{
			if(rand.nextInt(10000) < 5)
			{
				return DQR.enumGetter.getEnumDqmPetFromName(parentType.getKakuseiMob());
			}
		}
		return null;
	}

	//配合対象2匹から、新ペットの生息地を計算取得する
	public EnumDqmMobCateg calcNewMobCateg(DqmPetBase par1, DqmPetBase par2)
	{
		EnumDqmMobCateg ret = null;

		EnumDqmMobCateg mobCateg1 = null;
		EnumDqmMobCateg mobCateg2 = null;

		Random rand = new Random();
		int randVal = rand.nextInt(1000);

		mobCateg1 = DQR.enumGetter.getMobCategFromName(par1.type.PetCateg);
		mobCateg2 = DQR.enumGetter.getMobCategFromName(par2.type.PetCateg);

		if(mobCateg1 != null && mobCateg2 != null)
		{
			if(mobCateg1.getId() > mobCateg2.getId())
			{
				EnumDqmMobCateg mobCateg_tmp = mobCateg1;
				mobCateg1 = mobCateg2;
				mobCateg2 = mobCateg_tmp;
			}


			if(mobCateg1 == EnumDqmMobCateg.DAY)
			{
				if(mobCateg2 == EnumDqmMobCateg.DAY)
				{
					if(randVal < 50)
					{
						ret = EnumDqmMobCateg.HELL;
					}else if(randVal < 250)
					{
						ret = EnumDqmMobCateg.NIGHT;
					}else
					{
						ret = EnumDqmMobCateg.DAY;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.NIGHT)
				{
					if(randVal < 100)
					{
						ret = EnumDqmMobCateg.HELL;
					}else if(randVal < 800)
					{
						ret = EnumDqmMobCateg.NIGHT;
					}else
					{
						ret = EnumDqmMobCateg.DAY;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.HELL)
				{
					if(randVal < 50)
					{
						ret = EnumDqmMobCateg.END;
					}else if(randVal < 750)
					{
						ret = EnumDqmMobCateg.HELL;
					}else if(randVal < 900)
					{
						ret = EnumDqmMobCateg.NIGHT;
					}else
					{
						ret = EnumDqmMobCateg.DAY;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.END)
				{
					if(randVal < 500)
					{
						ret = EnumDqmMobCateg.END;
					}else if(randVal < 800)
					{
						ret = EnumDqmMobCateg.HELL;
					}else if(randVal < 950)
					{
						ret = EnumDqmMobCateg.NIGHT;
					}else
					{
						ret = EnumDqmMobCateg.DAY;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.METARU || mobCateg2 == EnumDqmMobCateg.SP || mobCateg2 == EnumDqmMobCateg.TENSEI)
				{
					if(randVal < 1)
					{
						ret = EnumDqmMobCateg.TENSEI;
					}else if(randVal < 2)
					{
						ret = EnumDqmMobCateg.SP;
					}else if(randVal < 203)
					{
						ret = EnumDqmMobCateg.END;
					}else if(randVal < 403)
					{
						ret = EnumDqmMobCateg.HELL;
					}else if(randVal < 903)
					{
						ret = EnumDqmMobCateg.NIGHT;
					}else
					{
						ret = EnumDqmMobCateg.DAY;
					}
				}
			}else if(mobCateg1 == EnumDqmMobCateg.NIGHT)
			{
				if(mobCateg2 == EnumDqmMobCateg.NIGHT)
				{
					if(randVal < 150)
					{
						ret = EnumDqmMobCateg.HELL;
					}else if(randVal < 850)
					{
						ret = EnumDqmMobCateg.NIGHT;
					}else
					{
						ret = EnumDqmMobCateg.DAY;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.HELL)
				{
					if(randVal < 100)
					{
						ret = EnumDqmMobCateg.END;
					}else if(randVal < 800)
					{
						ret = EnumDqmMobCateg.HELL;
					}else if(randVal < 950)
					{
						ret = EnumDqmMobCateg.NIGHT;
					}else
					{
						ret = EnumDqmMobCateg.DAY;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.END)
				{
					if(randVal < 500)
					{
						ret = EnumDqmMobCateg.END;
					}else if(randVal < 800)
					{
						ret = EnumDqmMobCateg.HELL;
					}else if(randVal < 950)
					{
						ret = EnumDqmMobCateg.NIGHT;
					}else
					{
						ret = EnumDqmMobCateg.DAY;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.METARU || mobCateg2 == EnumDqmMobCateg.SP || mobCateg2 == EnumDqmMobCateg.TENSEI)
				{
					if(randVal < 2)
					{
						ret = EnumDqmMobCateg.TENSEI;
					}else if(randVal < 4)
					{
						ret = EnumDqmMobCateg.SP;
					}else if(randVal < 304)
					{
						ret = EnumDqmMobCateg.END;
					}else if(randVal < 904)
					{
						ret = EnumDqmMobCateg.HELL;
					}else
					{
						ret = EnumDqmMobCateg.NIGHT;
					}
				}
			}else if(mobCateg1 == EnumDqmMobCateg.HELL)
			{
				if(mobCateg2 == EnumDqmMobCateg.HELL)
				{
					if(randVal < 100)
					{
						ret = EnumDqmMobCateg.END;
					}else if(randVal < 950)
					{
						ret = EnumDqmMobCateg.HELL;
					}else
					{
						ret = EnumDqmMobCateg.NIGHT;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.END)
				{
					if(randVal < 600)
					{
						ret = EnumDqmMobCateg.END;
					}else if(randVal < 950)
					{
						ret = EnumDqmMobCateg.HELL;
					}else
					{
						ret = EnumDqmMobCateg.NIGHT;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.METARU || mobCateg2 == EnumDqmMobCateg.SP || mobCateg2 == EnumDqmMobCateg.TENSEI)
				{
					if(randVal < 3)
					{
						ret = EnumDqmMobCateg.TENSEI;
					}else if(randVal < 6)
					{
						ret = EnumDqmMobCateg.SP;
					}else if(randVal < 906)
					{
						ret = EnumDqmMobCateg.END;
					}else
					{
						ret = EnumDqmMobCateg.HELL;
					}
				}
			}else if(mobCateg1 == EnumDqmMobCateg.END)
			{
				if(mobCateg2 == EnumDqmMobCateg.END)
				{
					if(randVal < 900)
					{
						ret = EnumDqmMobCateg.END;
					}else if(randVal < 950)
					{
						ret = EnumDqmMobCateg.HELL;
					}else
					{
						ret = EnumDqmMobCateg.NIGHT;
					}
				}else if(mobCateg2 == EnumDqmMobCateg.METARU || mobCateg2 == EnumDqmMobCateg.SP || mobCateg2 == EnumDqmMobCateg.TENSEI)
				{
					if(randVal < 5)
					{
						ret = EnumDqmMobCateg.TENSEI;
					}else if(randVal < 10)
					{
						ret = EnumDqmMobCateg.SP;
					}else
					{
						ret = EnumDqmMobCateg.END;
					}
				}
			}else if(mobCateg1 == EnumDqmMobCateg.METARU || mobCateg1 == EnumDqmMobCateg.SP || mobCateg1 == EnumDqmMobCateg.TENSEI)
			{
				if(randVal < 25)
				{
					ret = EnumDqmMobCateg.TENSEI;
				}else if(randVal < 50)
				{
					ret = EnumDqmMobCateg.SP;
				}else
				{
					ret = EnumDqmMobCateg.END;
				}
			}
		}

		return ret;
	}

	//配合対象2匹から、新ペットの種族を計算取得する
	public EnumDqmMobRoot calcNewHaigouRoot(DqmPetBase par1, DqmPetBase par2)
	{
		EnumDqmMobRoot ret = null;
		EnumDqmMobRoot mobRoot1 = null;
		EnumDqmMobRoot mobRoot2 = null;
		int resultID = -1;
		//par1.worldObj.getWorldInfo().getSeed()

		mobRoot1 = DQR.enumGetter.getMobRootFromName(par1.type.PetRoot);
		mobRoot2 = DQR.enumGetter.getMobRootFromName(par2.type.PetRoot);



		if(mobRoot1 != null && mobRoot2 != null)
		{
			DQR.func.debugString("pet1:" + mobRoot1.getHaigouId());
			DQR.func.debugString("pet2:" + mobRoot2.getHaigouId());

			if(mobRoot1.getHaigouId() == 1)
			{
				if(mobRoot2.getHaigouId() == 1)
				{
					resultID = 1;
				}else if(mobRoot2.getHaigouId() == 2)
				{
					resultID = 3;
				}else if(mobRoot2.getHaigouId() == 3)
				{
					resultID = 4;
				}else if(mobRoot2.getHaigouId() == 4)
				{
					resultID = 2;
				}
			}else if(mobRoot1.getHaigouId() == 2)
			{
				if(mobRoot2.getHaigouId() == 1)
				{
					resultID = 3;
				}else if(mobRoot2.getHaigouId() == 2)
				{
					resultID = 2;
				}else if(mobRoot2.getHaigouId() == 3)
				{
					resultID = 4;
				}else if(mobRoot2.getHaigouId() == 4)
				{
					resultID = 1;
				}
			}else if(mobRoot1.getHaigouId() == 3)
			{
				if(mobRoot2.getHaigouId() == 1)
				{
					resultID = 2;
				}else if(mobRoot2.getHaigouId() == 2)
				{
					resultID = 4;
				}else if(mobRoot2.getHaigouId() == 3)
				{
					resultID = 3;
				}else if(mobRoot2.getHaigouId() == 4)
				{
					resultID = 1;
				}
			}else if(mobRoot1.getHaigouId() == 4)
			{
				if(mobRoot2.getHaigouId() == 1)
				{
					resultID = 3;
				}else if(mobRoot2.getHaigouId() == 2)
				{
					resultID = 1;
				}else if(mobRoot2.getHaigouId() == 3)
				{
					resultID = 2;
				}else if(mobRoot2.getHaigouId() == 4)
				{
					resultID = 4;
				}
			}
		}
		return DQR.enumGetter.getMobRootFromHIdCateg(mobRoot1.getHaigouCateg(), resultID);
	}


	   public DqmPetBase setNBT(NBTTagCompound p_70037_1_, DqmPetBase pet, EntityPlayer ep)
	    {
	        //super.readEntityFromNBT(p_70037_1_);

		   if(p_70037_1_ == null || pet == null || ep == null)
		   {
			   return null;
		   }

		    pet.setJob(p_70037_1_.getInteger("Job"));
	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobLv(cnt, p_70037_1_.getInteger("JobLv_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobExp(cnt, p_70037_1_.getInteger("JobExp_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobSp(cnt, p_70037_1_.getInteger("JobSp_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobHP(cnt, p_70037_1_.getInteger("JobHP_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobMP(cnt, p_70037_1_.getInteger("JobMP_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobTikara(cnt, p_70037_1_.getInteger("JobTikara_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setJobKasikosa(cnt, p_70037_1_.getInteger("JobKasikosa_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayHP(cnt, p_70037_1_.getInteger("arrayHP_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayMP(cnt, p_70037_1_.getInteger("arrayMP_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayATK(cnt, p_70037_1_.getInteger("arrayATK_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayMAG(cnt, p_70037_1_.getInteger("arrayMAG_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayDEF(cnt, p_70037_1_.getInteger("arrayDEF_" + cnt));
	        }



	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayTikara(cnt, p_70037_1_.getInteger("arrayTikara_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayMamori(cnt, p_70037_1_.getInteger("arrayMamori_" + cnt));
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArraySubayasa(cnt, p_70037_1_.getInteger("arraySubayasa_" + cnt));
	        	//arraySubayasa[cnt] = p_70037_1_.getInteger("arraySubayasa_" + cnt);
	        }

	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	pet.setArrayKasikosa(cnt, p_70037_1_.getInteger("arrayKasikosa_" + cnt));
	        }

	        for(int cnt = 0; cnt < 64; cnt++)
	        {
	        	pet.setJukurenLv(cnt, p_70037_1_.getInteger("JukurenLv_" + cnt));
	        }

	        for(int cnt = 0; cnt < 64; cnt++)
	        {
	        	pet.setJukurenExp(cnt, p_70037_1_.getInteger("JukurenExp_" + cnt));
	        }

	        pet.setKougeki(p_70037_1_.getInteger("Kougeki"));
	        pet.setBougyo(p_70037_1_.getInteger("Bougyo"));
	        pet.setMaryoku(p_70037_1_.getInteger("Maryoku"));

	        pet.setTikara(p_70037_1_.getInteger("Tikara"));
	        pet.setMikawasi(p_70037_1_.getInteger("Mikawasi"));
	        pet.setKasikosa(p_70037_1_.getInteger("Kasikosa"));

	        pet.setKaisinritu(p_70037_1_.getInteger("Kaisinritu"));
	        pet.setKaisinMin(p_70037_1_.getInteger("KaisinMin"));
	        pet.setKaisinMax(p_70037_1_.getInteger("KaisinMax"));

	        pet.setGold(p_70037_1_.getInteger("Gold"));
	        pet.setMedal(p_70037_1_.getInteger("Medal"));
	        pet.setCoin(p_70037_1_.getInteger("Coin"));
	        pet.setKillCount(p_70037_1_.getInteger("KillCount"));
	        pet.setDeathCount(p_70037_1_.getInteger("DeathCount"));

	        pet.setHP(p_70037_1_.getFloat("HP"));
	        pet.setHealth(p_70037_1_.getFloat("HP"));
	        pet.setMaxHP(p_70037_1_.getFloat("MaxHP"));
	        pet.setMP(p_70037_1_.getInteger("MP"));
	        pet.setMaxMP(p_70037_1_.getInteger("MaxMP"));
	        pet.setWeapon(p_70037_1_.getInteger("weapon"));

	        for(int cnt = 0; cnt < 4; cnt++)
	        {
	        	//pet.setRarihoLoc(cnt, p_70037_1_.getDouble("rarihoLoc_" + cnt));
	        }

	        //super.readEntityFromNBT(p_70037_1_);
	        pet.ownerName = p_70037_1_.getString("OwnerName");

	        String s = "";

	        if (p_70037_1_.hasKey("OwnerUUID", 8))
	        {
	            s = p_70037_1_.getString("OwnerUUID");
	        }
	        else
	        {
	            //String s1 = p_70037_1_.getString("OwnerUUID");
	        	String s1 = null;

	        	s1 = p_70037_1_.getString("Owner");
	        	if(s1 != null)
	        	{
		            s = PreYggdrasilConverter.func_152719_a(s1);

		            if(s == null || s.equalsIgnoreCase("") || s.length() == 0)
		            {
		            	s1 = p_70037_1_.getString("OwnerName");
		            	s = PreYggdrasilConverter.func_152719_a(s1);
		            }
	        	}
	        }

	        pet.ownerUUID = s;

	        /*
	        if (s.length() > 0)
	        {
	            this.func_152115_b(s);
	            this.setTamed(true);
	        }
	        */

	        if(pet.chestOn)
	        {
	        	if(p_70037_1_.hasKey("sampleItemStack"))
	        	{
	        		pet.setChestItem(ItemStack.loadItemStackFromNBT(p_70037_1_.getCompoundTag("sampleItemStack")));
	        	}else
	        	{
	        		pet.setChestItem(null);
	        	}
	        }
	        /*
	        if(pet.chestOn)
	        {
	        	NBTTagCompound itemNBT = new NBTTagCompound();
	        	if(pet.sampleItemStack == null)
	        	{
	                this.sampleItemStack = new ItemStack(Items.wooden_sword, 1);
	                this.sampleItemStack.setTagCompound(new NBTTagCompound());
	                this.sampleItemStack.getTagCompound().setTag("Items", new NBTTagList());

	        	}
	        	this.sampleItemStack.writeToNBT(itemNBT);
	        	p_70014_1_.setTag("sampleItemStack", itemNBT);
	        }
	        */
	        pet.setSit(p_70037_1_.getBoolean("Sitting"));
	        //this.setSitting(p_70037_1_.getBoolean("Sitting"));
	        //this.setTamed(p_70037_1_.getBoolean("isTamed"));


	        pet.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(pet.getMaxHP());
	        pet.setPathToEntity((PathEntity)null);
	        pet.setAttackTarget((EntityLivingBase)null);
	        //pet.aiSit.setSitting(true);
      pet.func_152115_b(ep.getUniqueID().toString());
      ep.worldObj.setEntityState(pet, (byte)7);
      //ExtendedPlayerProperties3.get(ep).plusPetCount(1);
      DQR.petFunc.setNewPetdata(pet);

	        return pet;
	    }
}