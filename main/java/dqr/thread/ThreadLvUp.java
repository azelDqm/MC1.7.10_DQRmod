package dqr.thread;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.MinecraftForge;
import scala.util.Random;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.event.DqmLvUpEvent;
import dqr.packetMessage.MessageClientSound;
import dqr.playerData.ExtendedPlayerProperties;

public class ThreadLvUp extends Thread{

	private EntityPlayer ep;

	public ThreadLvUp(EntityPlayer player)
	{
		this.ep = player;
	}

	public void run()
	{
		if(this.ep.worldObj.isRemote)
		{
			return;
		}

		boolean flg = true;
		int epLv = ExtendedPlayerProperties.get(this.ep).getJobLv(ExtendedPlayerProperties.get(this.ep).getJob());
		int epEXP = ExtendedPlayerProperties.get(this.ep).getJobExp(ExtendedPlayerProperties.get(this.ep).getJob());

		if(epLv >= 100 && DQR.conf.recalcLvStatus1 == 1)
		{
			epLv = 0;
			int epJob = ExtendedPlayerProperties.get(this.ep).getJob();
			ExtendedPlayerProperties.get(this.ep).setJobHP(epJob, 0);
			ExtendedPlayerProperties.get(this.ep).setJobMP(epJob, 0);
			ExtendedPlayerProperties.get(this.ep).setJobTikara(epJob, 0);
			ExtendedPlayerProperties.get(this.ep).setJobKasikosa(epJob, 0);
		}

		for (int i = 0; i < 100; i++)
		{
			flg = true;
			//System.out.println("DEBUG" + "/" + epLv + "/" + epEXP);
			if(epLv < 99 && epEXP >= DQR.exp.getNextExp(epLv))
			{
				epLv = epLv + 1;
				ExtendedPlayerProperties.get(this.ep).setJobLv(ExtendedPlayerProperties.get(this.ep).getJob(), epLv);
				ep.addChatMessage(new ChatComponentTranslation("msg.lvUp.txt",new Object[] {epLv}));
				lvUpProcess(epLv);
				lvUpRefresh();

				ep.worldObj.playSoundAtEntity(ep, "dqr:player.levelup", 1.0F, 1.0F);
				PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)0), (EntityPlayerMP)ep);

				flg = false;

				//外部からの干渉用
				DqmLvUpEvent event = new DqmLvUpEvent(this.ep,
													  ExtendedPlayerProperties.get(this.ep).getJob(),
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
		int epJob = ExtendedPlayerProperties.get(this.ep).getJob();

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
		ExtendedPlayerProperties.get(this.ep).setJobHP(epJob, ExtendedPlayerProperties.get(this.ep).getJobHP(epJob) + plusHpVal);
		ExtendedPlayerProperties.get(this.ep).setJobMP(epJob, ExtendedPlayerProperties.get(this.ep).getJobMP(epJob) + plusMpVal);
		ExtendedPlayerProperties.get(this.ep).setJobTikara(epJob, ExtendedPlayerProperties.get(this.ep).getJobTikara(epJob) + plusTikaraVal);
		ExtendedPlayerProperties.get(this.ep).setJobKasikosa(epJob, ExtendedPlayerProperties.get(this.ep).getJobKasikosa(epJob) + plusKasikosaVal);
		ExtendedPlayerProperties.get(this.ep).setMaxHP(DQR.calcPlayerStatus.calcHP(ep));
		ExtendedPlayerProperties.get(this.ep).setMaxMP(DQR.calcPlayerStatus.calcMP(ep));

		ep.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ExtendedPlayerProperties.get(this.ep).getMaxHP());
	}

	public void lvUpRefresh()
	{
		ExtendedPlayerProperties.get(this.ep).setHP(ExtendedPlayerProperties.get(this.ep).getMaxHP());
		ep.setHealth(ep.getMaxHealth());
		ExtendedPlayerProperties.get(this.ep).setMP(ExtendedPlayerProperties.get(this.ep).getMaxMP());
		//ep.getFoodStats().setFoodLevel(20);
		ep.getFoodStats().addStats(20, 0.6F);
	}
}
