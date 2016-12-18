package dqr.thread;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import scala.util.Random;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmPet;
import dqr.api.event.DqmJukurenUpEvent;
import dqr.api.event.DqmLvUpEvent;
import dqr.api.event.DqmPetLvUpEvent;
import dqr.entity.petEntity.DqmPetBase;
import dqr.packetMessage.MessageClientSound;
import dqr.playerData.ExtendedPlayerProperties;

public class NoThreadProcess {

	public NoThreadProcess(){}

	public void doLevelUp(EntityPlayer ep)
	{
		if(ep.worldObj.isRemote)
		{
			return;
		}

		boolean flg = true;
		int epLv = ExtendedPlayerProperties.get(ep).getJobLv(ExtendedPlayerProperties.get(ep).getJob());
		int epEXP = ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());

		if(epLv >= 100 && DQR.conf.recalcLvStatus1 == 1)
		{
			epLv = 0;
			int epJob = ExtendedPlayerProperties.get(ep).getJob();
			ExtendedPlayerProperties.get(ep).setJobHP(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobMP(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobTikara(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobKasikosa(epJob, 0);

		}

		for (int i = 0; i < 100; i++)
		{
			flg = true;
			//System.out.println("DEBUG" + "/" + epLv + "/" + epEXP);
			if(epLv < 99 && epEXP >= DQR.exp.getNextExp(epLv))
			{
				epLv = epLv + 1;
				ExtendedPlayerProperties.get(ep).setJobLv(ExtendedPlayerProperties.get(ep).getJob(), epLv);
				ep.addChatMessage(new ChatComponentTranslation("msg.lvUp.txt",new Object[] {epLv}));
				lvUpProcess(epLv, ep);
				lvUpRefresh(ep);

				ep.worldObj.playSoundAtEntity(ep, "dqr:player.levelup", 1.0F, 1.0F);
				PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)0), (EntityPlayerMP)ep);

				flg = false;

				//外部からの干渉用
				DqmLvUpEvent event = new DqmLvUpEvent(ep,
													  ExtendedPlayerProperties.get(ep).getJob(),
													  epLv);
				event.setCanceled(false);
				MinecraftForge.EVENT_BUS.post(event);

				if (event.isCanceled())
				{
					//System.out.println("STOP1");
					break;
				}
			}

			if(flg)
			{
				//System.out.println("STOP2");
				break;
			}
		}
	}

	public void lvUpProcess(int lv, EntityPlayer ep)
	{
		Random rand = new Random();
		int epJob = ExtendedPlayerProperties.get(ep).getJob();

		//HP
		float plusHpVal = 0.0F;
		int plusMpVal = 0;
		int plusTikaraVal = 0;
		int plusKasikosaVal = 0;

		//DQR.func.debugString("Job:" + epJob);
		switch (epJob)
		{
			case 0: plusHpVal = (float)(rand.nextInt(3) + 2); plusMpVal = rand.nextInt(3) + 1;
					plusTikaraVal = lv % 15 == 0? 1 : 0; plusKasikosaVal = lv % 49 == 0? 1 : 0; break;
			case 1: plusHpVal = (float)(rand.nextInt(3) + 3); plusMpVal = rand.nextInt(3) + 0;
					plusTikaraVal = lv % 8 == 0? 1 : 0; plusKasikosaVal = lv % 49 == 0? 1 : 0; break;
			case 2: plusHpVal = (float)(rand.nextInt(4) + 3); plusMpVal = rand.nextInt(2) + 0;
					plusTikaraVal = lv % 8 == 0? 1 : 0; plusKasikosaVal = lv % 49 == 0? 1 : 0; break;
			case 3: plusHpVal = (float)(rand.nextInt(4) + 4); plusMpVal = rand.nextInt(2) + 1;
					plusTikaraVal = lv % 5 == 0? 1 : 0; plusKasikosaVal = lv % 30 == 0? 1 : 0; break;
			case 4: plusHpVal = (float)(rand.nextInt(2) + 2); plusMpVal = rand.nextInt(3) + 3;
					plusTikaraVal = lv % 25 == 0? 1 : 0; plusKasikosaVal = lv % 15 == 0? 1 : 0; break;
			case 5: plusHpVal = (float)(rand.nextInt(3) + 2); plusMpVal = rand.nextInt(3) + 2;
					plusTikaraVal = lv % 25 == 0? 1 : 0; plusKasikosaVal = lv % 15 == 0? 1 : 0; break;
			case 6: plusHpVal = (float)(rand.nextInt(3) + 3); plusMpVal = rand.nextInt(3) + 3;
					plusTikaraVal = lv % 14 == 0? 1 : 0; plusKasikosaVal = lv % 10 == 0? 1 : 0; break;
			case 7: plusHpVal = (float)(rand.nextInt(4) + 3); plusMpVal = rand.nextInt(4) + 2;
					plusTikaraVal = lv % 4 == 0? 1 : 0; plusKasikosaVal = lv % 8 == 0? 1 : 0; break;
			case 8: plusHpVal = (float)(rand.nextInt(5) + 4); plusMpVal = rand.nextInt(2) + 2;
					plusTikaraVal = lv % 7 == 0? 1 : 0; plusKasikosaVal = lv % 25 == 0? 1 : 0; break;
			case 9: plusHpVal = (float)(rand.nextInt(4) + 3); plusMpVal = rand.nextInt(3) + 2;
					plusTikaraVal = lv % 9 == 0? 1 : 0; plusKasikosaVal = lv % 12 == 0? 1 : 0; break;
			case 10: plusHpVal = (float)(rand.nextInt(3) + 3); plusMpVal = rand.nextInt(2) + 3;
					 plusTikaraVal = lv % 15 == 0? 1 : 0; plusKasikosaVal = lv % 33 == 0? 1 : 0; break;
			case 11: plusHpVal = (float)(rand.nextInt(3) + 2); plusMpVal = rand.nextInt(2) + 0;
					 plusTikaraVal = lv % 20 == 0? 1 : 0;  plusKasikosaVal = lv % 20 == 0? 1 : 0;break;
			case 12: plusHpVal = (float)(rand.nextInt(4) + 3); plusMpVal = rand.nextInt(3) + 2;
					 plusTikaraVal = lv % 15 == 0? 1 : 0; plusKasikosaVal = lv % 15 == 0? 1 : 0; break;
			case 13: plusHpVal = (float)(rand.nextInt(2)); plusMpVal = rand.nextInt(4) + 3;
					 plusTikaraVal = lv % 15 == 0? 1 : 0; plusKasikosaVal = lv % 10 == 0? 1 : 0; break;
			case 14: plusHpVal = (float)(rand.nextInt(4) + 2); plusMpVal = rand.nextInt(3) + 0;
					 plusTikaraVal = lv % 15 == 0? 1 : 0; plusKasikosaVal = lv % 40 == 0? 1 : 0; break;
			case 15: plusHpVal = (float)(rand.nextInt(3) + 2); plusMpVal = rand.nextInt(3) + 0;
					 plusTikaraVal = lv % 15 == 0? 1 : 0; plusKasikosaVal = lv % 40 == 0? 1 : 0; break;
			case 16: plusHpVal = (float)(rand.nextInt(4) + 5); plusMpVal = rand.nextInt(2) + 1;
					 plusTikaraVal = lv % 6 == 0? 1 : 0; plusKasikosaVal = lv % 49 == 0? 1 : 0; break;
			case 17: plusHpVal = (float)(rand.nextInt(5)); plusMpVal = rand.nextInt(3) + 3;
					 plusTikaraVal = lv % 5 == 0? 1 : 0; plusKasikosaVal = lv % 10 == 0? 1 : 0; break;
			case 18: plusHpVal = 10.0F; plusMpVal = 5;
					 plusTikaraVal = lv % 2 == 0? 1 : 0; plusKasikosaVal = lv % 2 == 1? 1 : 0; break;
			case 19: plusHpVal = (float)(rand.nextInt(4) + 1); plusMpVal = rand.nextInt(4) + 2;
					 plusTikaraVal = lv % 15 == 0? 1 : 0; plusKasikosaVal = lv % 33 == 0? 1 : 0; break;
			case 20: plusHpVal = (float)(rand.nextInt(3) + 3); plusMpVal = rand.nextInt(3) + 2;
					 plusTikaraVal = lv % 8 == 0? 1 : 0; plusKasikosaVal = lv % 33 == 0? 1 : 0; break;
			case 21: plusHpVal = 8.0F; plusMpVal = 8;
			 		 plusTikaraVal = lv % 3 == 0? 1 : 0; plusKasikosaVal = lv % 3 == 2? 1 : 0; break;
		}
		//DQR.func.debugString("Job:" + plusHpVal + "/" + plusMpVal + "/" + plusTikaraVal + "/" + plusKasikosaVal);
		ExtendedPlayerProperties.get(ep).setJobHP(epJob, ExtendedPlayerProperties.get(ep).getJobHP(epJob) + plusHpVal);
		ExtendedPlayerProperties.get(ep).setJobMP(epJob, ExtendedPlayerProperties.get(ep).getJobMP(epJob) + plusMpVal);
		ExtendedPlayerProperties.get(ep).setJobTikara(epJob, ExtendedPlayerProperties.get(ep).getJobTikara(epJob) + plusTikaraVal);
		ExtendedPlayerProperties.get(ep).setJobKasikosa(epJob, ExtendedPlayerProperties.get(ep).getJobKasikosa(epJob) + plusKasikosaVal);
		ExtendedPlayerProperties.get(ep).setMaxHP(DQR.calcPlayerStatus.calcHP(ep));
		ExtendedPlayerProperties.get(ep).setMaxMP(DQR.calcPlayerStatus.calcMP(ep));

		ep.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ExtendedPlayerProperties.get(ep).getMaxHP());
	}

	public void lvUpRefresh(EntityPlayer ep)
	{
		ExtendedPlayerProperties.get(ep).setHP(ExtendedPlayerProperties.get(ep).getMaxHP());
		ep.setHealth(ep.getMaxHealth());
		ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
		//ep.getFoodStats().setFoodLevel(20);
		ep.getFoodStats().addStats(20, 0.6F);
	}



	public void doJukurenUp(EntityPlayer ep)
	{
		if(ep.worldObj.isRemote)
		{
			return;
		}
		boolean flg = true;
		int epLv = ExtendedPlayerProperties.get(ep).getJukurenLv(ExtendedPlayerProperties.get(ep).getWeapon());
		int epEXP = ExtendedPlayerProperties.get(ep).getJukurenExp(ExtendedPlayerProperties.get(ep).getWeapon());

		for (int i = 0; i < 20; i++)
		{
			flg = true;
			//System.out.println("DEBUG" + "/" + epLv + "/" + epEXP);
			if(epLv < 10 && epEXP >= DQR.exp.getJukurenNextExp(epLv))
			{
				//String weaponName = I18n.format("gui.weapon." + ExtendedPlayerProperties.get(this.ep).getWeapon());
				epLv = epLv + 1;
				ExtendedPlayerProperties.get(ep).setJukurenLv(ExtendedPlayerProperties.get(ep).getWeapon(), epLv);

				int jukurenWP = ExtendedPlayerProperties.get(ep).getJukurenWP(ExtendedPlayerProperties.get(ep).getWeapon());

				switch(epLv)
				{
					case 2: jukurenWP = jukurenWP + 15; break;
					case 3: jukurenWP = jukurenWP + 25; break;
					case 4: jukurenWP = jukurenWP + 35; break;
					case 5: jukurenWP = jukurenWP + 45;  break;
					case 6: jukurenWP = jukurenWP + 55; break;
					case 7: jukurenWP = jukurenWP + 65; break;
					case 8: jukurenWP = jukurenWP + 75; break;
					case 9: jukurenWP = jukurenWP + 85; break;
					case 10: jukurenWP = jukurenWP + 100; break;
				}

				ExtendedPlayerProperties.get(ep).setJukurenWP(ExtendedPlayerProperties.get(ep).getWeapon(), jukurenWP);
				//ep.addChatMessage(new ChatComponentTranslation("msg.jukurenUp.txt",new Object[] {weaponName, epLv}));
				ep.addChatMessage(new ChatComponentTranslation("msg.jukurenUp.txt",new Object[] {
						new ChatComponentTranslation("gui.weapon." + ExtendedPlayerProperties.get(ep).getWeapon()), epLv}));
				ep.worldObj.playSoundAtEntity(ep, "dqr:player.skillup", 1.0F, 1.0F);
				PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)1), (EntityPlayerMP)ep);
				flg = false;

				//外部からの干渉用
				DqmJukurenUpEvent event = new DqmJukurenUpEvent(ep, ExtendedPlayerProperties.get(ep).getWeapon(), epLv);
				event.setCanceled(false);
				MinecraftForge.EVENT_BUS.post(event);

				if (event.isCanceled())
				{
					break;
				}
			}

			if(flg)
			{
				break;
			}
		}
	}

	public void doLevelUpPet(DqmPetBase pet)
	{
		if(pet.worldObj.isRemote)
		{
			return;
		}
		//System.out.println("TEST!!!!!");
		if(pet.getOnLevelThread())
		{
			return;
		}else
		{
			pet.setOnLevelThread(true);
		}

		boolean flg = true;
		int epLv = pet.getJobLv(pet.getJob());
		int epEXP = pet.getJobExp(pet.getJob());

		EntityPlayer player = null;
		EnumDqmPet petType = pet.type;

		if(pet.getOwner() != null && pet.getOwner() instanceof EntityPlayer)
		{
			player = (EntityPlayer)pet.getOwner();
		}
		/*
		if(epLv >= 100 && DQR.conf.recalcLvStatus1 == 1)
		{
			epLv = 0;
			int epJob = pet.getJob();
			pet.setJobHP(epJob, 0);
			pet.setJobMP(epJob, 0);
			pet.setJobTikara(epJob, 0);
			pet.setJobKasikosa(epJob, 0);
		}
		*/

		for (int i = 0; i < 100; i++)
		{
			flg = true;
			//System.out.println("DEBUG" + "/" + DQR.exp.getNeedExpPet(epLv, pet) + "/" + DQR.exp.getNextExpPet(epLv, pet) + "/" + epEXP);
			if(epLv < 99 && epEXP >= DQR.exp.getNextExpPet(epLv, pet) && DQR.exp.getNextExpPet(epLv, pet) > 0)
			{
				epLv = epLv + 1;
				pet.setJobLv(pet.getJob(), epLv);
				if(player != null)
				{
					String petName;
					if(pet.getCustomNameTag() != null && !pet.getCustomNameTag().equalsIgnoreCase(""))
					{
						petName = pet.getCustomNameTag();
					}else
					{
						petName = pet.getCommandSenderName();
					}

					if(!player.worldObj.isRemote)
					{
						player.addChatMessage(new ChatComponentTranslation("msg.lvUpPet.txt",new Object[] {petName ,epLv}));
					}
				}

				lvUpProcessPet(epLv, pet);
				lvUpRefreshPet(pet);

				pet.worldObj.playSoundAtEntity(pet, "dqr:player.levelup", 1.0F, 1.0F);
				//PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)0), (EntityPlayerMP)ep);

				flg = false;

				//外部からの干渉用
				DqmPetLvUpEvent event = new DqmPetLvUpEvent(pet,
													  pet.getJob(),
													  epLv);
				event.setCanceled(false);
				MinecraftForge.EVENT_BUS.post(event);

				if (event.isCanceled())
				{
					//System.out.println("STOP1");
					break;
				}
			}

			if(flg)
			{
				//System.out.println("STOP2");
				break;
			}
		}

		pet.setOnLevelThread(false);
	}



	public void lvUpProcessPet(int lv, DqmPetBase pet)
	{
		Random rand = new Random();
		int epJob = pet.getJob();
		EnumDqmPet type = pet.type;

		DQR.func.debugString("DEBUG_HP1 : " + pet.getMaxHealth(), this.getClass());
		//HP
		float plusHpVal = (float)DQR.func.xRandom(type.HPUPMIN, type.HPUPMAX);

		int[] kasikosaA = pet.getArrayKasikosaA();
		int plusMpVal = type.KASIKOSADEF;
		for(int cnt = 0; cnt < kasikosaA.length; cnt++)
		{
			plusMpVal = plusMpVal + kasikosaA[cnt];
		}
		int plusTikaraVal = DQR.func.xRandom(type.TIKARAUPMIN, type.TIKARAUPMAX);
		int plusKasikosaVal = DQR.func.xRandom(type.KASIKOSAUPMIN, type.KASIKOSAUPMAX);

		DQR.func.debugString("DEBUG_HP2 : " + pet.getMaxHealth(), this.getClass());


		pet.setJobHP(epJob, pet.getJobHP(epJob) + plusHpVal);
		pet.setJobMP(epJob, pet.getJobMP(epJob) + plusMpVal);
		pet.setJobTikara(epJob, pet.getJobTikara(epJob) + plusTikaraVal);
		pet.setJobKasikosa(epJob, pet.getJobKasikosa(epJob) + plusKasikosaVal);
		pet.setMaxHP(DQR.calcPetStatus.calcHP(pet));
		pet.setMaxMP(DQR.calcPetStatus.calcMP(pet));

		DQR.func.debugString("DEBUG_HP3 : " + pet.getMaxHealth(), this.getClass());


		pet.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(pet.getMaxHP());

		DQR.func.debugString("DEBUG_HP4 : " + pet.getMaxHealth(), this.getClass());
	}

	public void lvUpRefreshPet(DqmPetBase pet)
	{
		pet.setHP(pet.getMaxHP());
		pet.setHealth(pet.getMaxHealth());
		pet.setMP(pet.getMaxMP());
		//ep.getFoodStats().setFoodLevel(20);
		//pet.getFoodStats().addStats(20, 0.6F);
	}
}
