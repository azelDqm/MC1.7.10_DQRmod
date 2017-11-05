package dqr.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmCasinoCCROdds;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.gui.casino.GuiCasinoCCRGuiContainer;
import dqr.packetMessage.MessageServerFunction;

public class ThreadCasinoCCR extends Thread{

	private EntityPlayer ep;
	private GuiCasinoCCRGuiContainer gui;
	private int phaseNum;
	private int buttonId;

	public ThreadCasinoCCR(EntityPlayer player, GuiCasinoCCRGuiContainer gui, int phase, int button)
	{
		this.ep = player;
		this.gui = gui;
		this.phaseNum = phase;
		this.buttonId = button;
	}

	public void run()
	{
		Random rand = new Random();
		if(!this.ep.worldObj.isRemote)
		{
			return;
		}

		if(gui.gamePhase == 1)
		{
			gui.msgPattern = 1;
			try {
				this.sleep(DQR.conf.CCR_turnStart_wait);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			this.doCPU();

			try {
				this.sleep(DQR.conf.CCR_turnChange_wait);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			if(gui.dealer == 1 || gui.cpuResult.getCateg() == 1 || gui.cpuResult.getCateg() == 3 || gui.cpuResult.getCateg() == 5 || gui.cpuResult.getCateg() == 6)
			{
				gui.gamePhase = 30;
				gui.msgPattern = -1;
			}else
			{
				gui.gamePhase = 2;
				gui.msgPattern = 2;

				gui.dice1 = -1;
				gui.dice2 = -1;
				gui.dice3 = -1;

			}
		}else if(gui.gamePhase == 3)
		{


			try {
				this.sleep(DQR.conf.CCR_turnStart_wait);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			/*
			gui.dice1 = rand.nextInt(6) + 1;
			gui.dice2 = rand.nextInt(6) + 1;
			gui.dice3 = rand.nextInt(6) + 1;
			*/
			gui.playerHitCount = gui.playerHitCount + 1;

			gui.playerResult = checkYaku();
			if(gui.playerResult != EnumDqmCasinoCCROdds.RABC || gui.playerHitCount >= 3)
			{
				gui.playerDiceSet[0] = gui.dice1 - 1;
				gui.playerDiceSet[1] = gui.dice2 - 1;
				gui.playerDiceSet[2] = gui.dice3 - 1;

				gui.dice1 = -2;
				gui.dice2 = -2;
				gui.dice3 = -2;

				gui.msgPattern = -1;

				if(gui.dealer == 2 || gui.playerResult.getCateg() == 1 || gui.playerResult.getCateg() == 3 || gui.playerResult.getCateg() == 5 || gui.playerResult.getCateg() == 6)
				{
					gui.gamePhase = 30;
				}else
				{
    				gui.gamePhase = 1;
    				gui.msgPattern = 1;
    				try {
    					this.sleep(DQR.conf.CCR_turnChange_wait);
    				} catch (InterruptedException e) {
    					// TODO 自動生成された catch ブロック
    					e.printStackTrace();
    				}

					this.doCPU();

					gui.gamePhase = 30;
					gui.msgPattern = -1;
				}
			}else{
				gui.msgPattern = 3;
				gui.gamePhase = 4;
				gui.dice1 = -1;
				gui.dice2 = -1;
				gui.dice3 = -1;
			}

		}


		if(gui.gamePhase == 30)
		{
			//gui.gamePhase = 4;
			try {
				this.sleep(DQR.conf.CCR_result_wait);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			int betCoin = Integer.parseInt(gui.commandTextField.getText());
			int inCoin = betCoin * 5;

			if(gui.playerResult == null)
			{
				if(gui.cpuResult == EnumDqmCasinoCCROdds.R111)
				{
					inCoin = 0;
					gui.winner = 2;
				}else if(gui.cpuResult == EnumDqmCasinoCCROdds.R456)
				{
					inCoin = inCoin - (betCoin * 3);
					gui.winner = 2;
				}else if(gui.cpuResult == EnumDqmCasinoCCROdds.RABC)
				{
					inCoin = inCoin + betCoin;
					gui.winner = 1;
				}else if(gui.cpuResult == EnumDqmCasinoCCROdds.R123)
				{
					inCoin = inCoin + (betCoin * 2);
					gui.result123 = true;
					gui.winner = 1;
				}

				gui.resultBox = gui.cpuResult;
			}else if(gui.cpuResult == null)
			{
				if(gui.playerResult == EnumDqmCasinoCCROdds.R111)
				{
					inCoin = inCoin + (betCoin * 5);
					gui.winner = 1;
				}else if(gui.playerResult == EnumDqmCasinoCCROdds.R456)
				{
					inCoin = betCoin * 3;
					gui.winner = 1;
				}else if(gui.playerResult == EnumDqmCasinoCCROdds.RABC)
				{
					inCoin = inCoin - betCoin;
					gui.winner = 2;
				}else if(gui.playerResult == EnumDqmCasinoCCROdds.R123)
				{
					inCoin = inCoin - (betCoin * 2);
					gui.result123 = true;
					gui.winner = 2;
				}

				gui.resultBox = gui.playerResult;
			}else if(gui.playerResult.getVal() == gui.cpuResult.getVal())
			{
				//DRAW
				gui.winner = 3;
    			//PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, gui.betCoin * 5));
    			//gui.myCoin = myCoin - (betCoin * 5);
			}else if(gui.playerResult.getVal() > gui.cpuResult.getVal())
			{
				//CPU勝ち
				gui.winner = 2;
				gui.resultBox = gui.cpuResult;
				if(gui.cpuResult.getCateg() == 2)
				{
					//ゾロ目
					inCoin = inCoin - (betCoin * 3);
				}else if(gui.cpuResult.getCateg() == 1)
				{
					//ピンゾロ
					inCoin = inCoin - (betCoin * 5);
				}else if(gui.cpuResult.getCateg() == 3)
				{
					//456
					inCoin = inCoin - (betCoin * 2);
				}else if(gui.cpuResult.getCateg() == 4)
				{
					//XX?
					inCoin = inCoin - (betCoin * 1);
				}

				if(gui.playerResult.getCateg() == 5)
				{
					//123
					inCoin = inCoin - (betCoin * 2);
					gui.result123 = true;
				}
			}else
			{
				//プレイヤー勝ち
				gui.winner = 1;
				gui.resultBox = gui.playerResult;
				if(gui.playerResult.getCateg() == 2)
				{
					//ゾロ目
					inCoin = inCoin + (betCoin * 3);
				}else if(gui.playerResult.getCateg() == 1)
				{
					//ピンゾロ
					inCoin = inCoin + (betCoin * 5);
				}else if(gui.playerResult.getCateg() == 3)
				{
					//456
					inCoin = inCoin + (betCoin * 2);
				}else if(gui.playerResult.getCateg() == 4)
				{
					//XXA
					inCoin = inCoin + (betCoin * 1);
				}

				if(gui.cpuResult.getCateg() == 5)
				{
					//123
					inCoin = inCoin + (betCoin * 2);
					gui.result123 = true;
				}
			}

			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, inCoin));
			gui.myCoin = gui.myCoin + inCoin;

			gui.gamePhase = 98;
			if(gui.winner == 1)
			{
				gui.soundPlay = 2;
			}
			try {
				this.sleep(DQR.conf.CCR_end_wait);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			//System.out.println(inCoin);
			gui.gamePhase = 99;
		}
		/*
		val = rand.nextInt(gui.trumpDeck.size());
		gui.trumpSetDeal.put(gui.trumpSetDeal.size(), gui.trumpDeck.get(val));
		gui.trumpDeck.remove(val);
		*/

	}

	public EnumDqmCasinoCCROdds checkYaku()
	{
		EnumDqmCasinoCCROdds ret = EnumDqmCasinoCCROdds.RABC;

		ArrayList<Integer> tempDice = new ArrayList<Integer>();
		tempDice.add(gui.dice1);
		tempDice.add(gui.dice2);
		tempDice.add(gui.dice3);
		Collections.sort(tempDice);

		//System.out.println("TEST4:" + tempDice.get(0) + "/" + tempDice.get(1) + "/" + tempDice.get(2));
		//1ゾロ
		if(tempDice.get(0) == tempDice.get(1) && tempDice.get(0) == tempDice.get(2))
		{
			if(tempDice.get(0) == 1)
			{
				ret = EnumDqmCasinoCCROdds.R111;
			}else if(tempDice.get(0) == 6)
			{
				ret = EnumDqmCasinoCCROdds.R666;
			}else if(tempDice.get(0) == 5)
			{
				ret = EnumDqmCasinoCCROdds.R555;
			}else if(tempDice.get(0) == 4)
			{
				ret = EnumDqmCasinoCCROdds.R444;
			}else if(tempDice.get(0) == 3)
			{
				ret = EnumDqmCasinoCCROdds.R333;
			}else if(tempDice.get(0) == 2)
			{
				ret = EnumDqmCasinoCCROdds.R222;
			}
		}else if(tempDice.get(0) == 4 && tempDice.get(1) == 5 && tempDice.get(2) == 6)
		{
			ret = EnumDqmCasinoCCROdds.R456;
		}else if(tempDice.get(0) == tempDice.get(1) || tempDice.get(0) == tempDice.get(2) || tempDice.get(1) == tempDice.get(2))
		{
			int checkVal = 0;
			if(tempDice.get(0) == tempDice.get(1))
			{
				checkVal = tempDice.get(2);
			}else if(tempDice.get(0) == tempDice.get(2))
			{
				checkVal = tempDice.get(1);
			}else if(tempDice.get(1) == tempDice.get(2))
			{
				checkVal = tempDice.get(0);
			}

			if(checkVal == 6)
			{
				ret = EnumDqmCasinoCCROdds.RAA6;
			}else if(checkVal == 5)
			{
				ret = EnumDqmCasinoCCROdds.RAA5;
			}else if(checkVal == 4)
			{
				ret = EnumDqmCasinoCCROdds.RAA4;
			}else if(checkVal == 3)
			{
				ret = EnumDqmCasinoCCROdds.RAA3;
			}else if(checkVal == 2)
			{
				ret = EnumDqmCasinoCCROdds.RAA2;
			}else if(checkVal == 1)
			{
				ret = EnumDqmCasinoCCROdds.RAA1;
			}
		}else if(tempDice.get(0) == 1 && tempDice.get(1) == 2 && tempDice.get(2) == 3)
		{
			ret = EnumDqmCasinoCCROdds.R123;
		}

		return ret;
	}

	public void doPlayer()
	{

	}

	public void doCPU()
	{
		Random rand = new Random();
		for(int cnt = 0; cnt < 3; cnt++)
		{
			gui.dice1 = -1;
			gui.dice2 = -1;
			gui.dice3 = -1;

			try {
				this.sleep(DQR.conf.CCR_cpuDice_wait);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			gui.dice1 = rand.nextInt(6) + 1;
			gui.dice2 = rand.nextInt(6) + 1;
			gui.dice3 = rand.nextInt(6) + 1;
			gui.soundPlay = 1;

			try {
				this.sleep(DQR.conf.CCR_cpuCheck_wait);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			//System.out.println("TEST1");
			gui.cpuResult = checkYaku();
			if(gui.cpuResult != EnumDqmCasinoCCROdds.RABC)
			{
				//System.out.println("TEST2");
				break;
			}
		}

		gui.cpuDiceSet[0] = gui.dice1 - 1;
		gui.cpuDiceSet[1] = gui.dice2 - 1;
		gui.cpuDiceSet[2] = gui.dice3 - 1;

		gui.dice1 = -2;
		gui.dice2 = -2;
		gui.dice3 = -2;
	}
}
