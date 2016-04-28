package dqr.thread;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import scala.util.Random;
import dqr.DQR;
import dqr.api.enums.EnumDqmPet;
import dqr.api.event.DqmPetLvUpEvent;
import dqr.entity.petEntity.DqmPetBase;

public class ThreadLvUpPet extends Thread{

	private DqmPetBase pet;

	public ThreadLvUpPet(DqmPetBase pet)
	{
		this.pet = pet;
	}

	public void run()
	{
		boolean flg = true;
		int epLv = pet.getJobLv(pet.getJob());
		int epEXP = pet.getJobExp(pet.getJob());

		EntityPlayer player = null;
		EnumDqmPet petType = pet.type;

		if(this.pet.getOwner() != null && this.pet.getOwner() instanceof EntityPlayer)
		{
			player = (EntityPlayer)this.pet.getOwner();
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
			//System.out.println("DEBUG" + "/" + epLv + "/" + epEXP);
			if(epLv < 99 && epEXP >= DQR.exp.getNextExp(epLv))
			{
				epLv = epLv + 1;
				pet.setJobLv(pet.getJob(), epLv);
				if(player != null)
				{
					String petName;
					if(this.pet.getCustomNameTag() != null && !this.pet.getCustomNameTag().equalsIgnoreCase(""))
					{
						petName = this.pet.getCustomNameTag();
					}else
					{
						petName = this.pet.getCommandSenderName();
					}
					player.addChatMessage(new ChatComponentTranslation("msg.lvUpPet.txt",new Object[] {petName ,epLv}));
				}

				lvUpProcess(epLv);
				lvUpRefresh();

				pet.worldObj.playSoundAtEntity(pet, "dqr:player.levelup", 1.0F, 1.0F);
				//PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)0), (EntityPlayerMP)ep);

				flg = false;

				//外部からの干渉用
				DqmPetLvUpEvent event = new DqmPetLvUpEvent(this.pet,
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
	}

	public void lvUpProcess(int lv)
	{
		Random rand = new Random();
		int epJob = pet.getJob();
		EnumDqmPet type = pet.type;

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

		//DQR.func.debugString("Job:" + epJob);
		/*
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
		*/
		//DQR.func.debugString("Job:" + plusHpVal + "/" + plusMpVal + "/" + plusTikaraVal + "/" + plusKasikosaVal);
		pet.setJobHP(epJob, pet.getJobHP(epJob) + plusHpVal);
		pet.setJobMP(epJob, pet.getJobMP(epJob) + plusMpVal);
		pet.setJobTikara(epJob, pet.getJobTikara(epJob) + plusTikaraVal);
		pet.setJobKasikosa(epJob, pet.getJobKasikosa(epJob) + plusKasikosaVal);
		pet.setMaxHP(DQR.calcPetStatus.calcHP(this.pet));
		pet.setMaxMP(DQR.calcPetStatus.calcMP(this.pet));

		pet.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(pet.getMaxHP());
	}

	public void lvUpRefresh()
	{
		pet.setHP(pet.getMaxHP());
		pet.setHealth(pet.getMaxHealth());
		pet.setMP(pet.getMaxMP());
		//ep.getFoodStats().setFoodLevel(20);
		//pet.getFoodStats().addStats(20, 0.6F);
	}
}
