package dqr.functions;

import net.minecraft.entity.player.EntityPlayer;
import scala.util.Random;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class FuncBugFix {

	public FuncBugFix(){}

	public void doPetListReconstruct(EntityPlayer ep)
	{
		DQR.petFunc.clearPetdata(ep);
		ExtendedPlayerProperties3.get(ep).setPetCount(0);
	}

	public void doMpRecalc(EntityPlayer ep)
	{
		Random rand = new Random();
		//int epJob = ExtendedPlayerProperties.get(ep).getJob();

		//HP
		float plusHpVal = 0.0F;
		int plusMpVal = 0;
		int plusTikaraVal = 0;
		int plusKasikosaVal = 0;

		for(int jobLvCnt = 0; jobLvCnt <= 21; jobLvCnt++)
		{
			int epJobLv = ExtendedPlayerProperties.get(ep).getJobLv(jobLvCnt);
			ExtendedPlayerProperties.get(ep).setJobMP(jobLvCnt, 0);
			for(int lv = 1; lv <= epJobLv; lv++)
			{
				//DQR.func.debugString("Job:" + epJob);
				switch (jobLvCnt)
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
				ExtendedPlayerProperties.get(ep).setJobMP(jobLvCnt, ExtendedPlayerProperties.get(ep).getJobMP(jobLvCnt) + plusMpVal);
				ExtendedPlayerProperties.get(ep).setMaxMP(DQR.calcPlayerStatus.calcMP(ep));
			}
		}
	}
}
