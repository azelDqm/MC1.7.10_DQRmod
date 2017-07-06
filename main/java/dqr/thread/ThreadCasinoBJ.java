package dqr.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmCasinoBJOdds;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.api.enums.EnumDqmTrump;
import dqr.gui.casino.GuiCasinoBJGuiContainer;
import dqr.packetMessage.MessageServerFunction;

public class ThreadCasinoBJ extends Thread{

	private EntityPlayer ep;
	private GuiCasinoBJGuiContainer gui;
	private int phaseNum;
	private int buttonId;

	public ThreadCasinoBJ(EntityPlayer player, GuiCasinoBJGuiContainer gui, int phase, int button)
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
			gui.trumpSet = new LinkedHashMap<Integer, EnumDqmTrump>();
			gui.trumpSetDeal = new LinkedHashMap<Integer, EnumDqmTrump>();
			gui.trumpDeck = new ArrayList<EnumDqmTrump>();

			EnumDqmTrump[] data = EnumDqmTrump.values();
	    	for(int cnt = 0; cnt < data.length; cnt++)
	    	{
	    		if(14 > data[cnt].getValue()&& data[cnt].getValue() > 0)
	    		{
	    			gui.trumpDeck.add(data[cnt]);
	    		}
	    	}

			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			int val = rand.nextInt(gui.trumpDeck.size());
			gui.trumpSet.put(gui.trumpSet.size(), gui.trumpDeck.get(val));
			//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
			gui.soundPlay = 1;
			gui.trumpDeck.remove(val);
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			val = rand.nextInt(gui.trumpDeck.size());
			gui.trumpSet.put(gui.trumpSet.size(), gui.trumpDeck.get(val));
			//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
			gui.soundPlay = 1;
			gui.trumpDeck.remove(val);

			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			val = rand.nextInt(gui.trumpDeck.size());
			gui.trumpSetDeal.put(gui.trumpSetDeal.size(), gui.trumpDeck.get(val));
			//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
			gui.soundPlay = 1;
			gui.trumpDeck.remove(val);

			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.trumpSetDeal.put(gui.trumpSetDeal.size(), EnumDqmTrump.DEF);
			//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
			gui.soundPlay = 1;

			gui.gamePhase = 2;
		}else if(this.phaseNum == 2)
		{
			if(this.buttonId == 1 || this.buttonId == 3)
			{
				try {
					this.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				int val = rand.nextInt(gui.trumpDeck.size());
				gui.trumpSet.put(gui.trumpSet.size(), gui.trumpDeck.get(val));
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				gui.trumpDeck.remove(val);


				int trumpValTotal = 0;
				int dealAceBigCounter = 0;
	        	for(int cnt = 0; cnt < gui.trumpSet.size(); cnt++)
	        	{
	        		if(((EnumDqmTrump)gui.trumpSet.get(cnt)).getValue() == 1)
	        		{
	        			if(trumpValTotal + 11 > 21)
	        			{
	        				trumpValTotal = trumpValTotal + 1;
	        			}else
	        			{
	        				trumpValTotal = trumpValTotal + 11;
	        				dealAceBigCounter = dealAceBigCounter + 1;
	        			}
	        		}else
	        		{
	        			if(((EnumDqmTrump)gui.trumpSet.get(cnt)).getValue() > 10)
	        			{
	        				trumpValTotal = trumpValTotal +10;
	        			}else
	        			{
	        				trumpValTotal = trumpValTotal + ((EnumDqmTrump)gui.trumpSet.get(cnt)).getValue();
	        			}
	        			//trumpValTotal = trumpValTotal + ((EnumDqmTrump)gui.trumpSet.get(cnt)).getValue();
	        			if(trumpValTotal > 21 && dealAceBigCounter > 0)
	        			{
	        				dealAceBigCounter = dealAceBigCounter - 1;
	        				trumpValTotal = trumpValTotal - 10;
	        			}
	        		}
	        	}

	        	if(trumpValTotal > 21)
	        	{
					gui.gamePhase = 3;
					gui.playerStatus = 3;
	    			ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(this.ep, gui, 3, 2);
	        		threadBJ.start();
	        	}else if(this.buttonId == 3)
				{
					gui.gamePhase = 3;
	    			ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(this.ep, gui, 3, 2);
	        		threadBJ.start();
				}else
				{
					gui.gamePhase = 2;
				}

			}
		}else if(this.phaseNum == 3)
		{
			if(this.buttonId == 2)
			{


				int trumpValTotal = gui.trumpSetDeal.get(1).getValue();

	        	while(trumpValTotal < 17)
	        	{
	        		trumpValTotal = 0;
	        		int dealAceBigCounter = 0;

					if(gui.trumpSetDeal.get(1) == EnumDqmTrump.DEF)
					{
						try {
							this.sleep(1000);
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

						int val = rand.nextInt(gui.trumpDeck.size());
						gui.trumpSetDeal.put(1, gui.trumpDeck.get(val));
						//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
						gui.soundPlay = 1;
						gui.trumpDeck.remove(val);
					}else
					{
						try {
							this.sleep(1000);
						} catch (InterruptedException e) {
							// TODO 自動生成された catch ブロック
							e.printStackTrace();
						}

						int val = rand.nextInt(gui.trumpDeck.size());
						gui.trumpSetDeal.put(gui.trumpSetDeal.size(), gui.trumpDeck.get(val));
						//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
						gui.soundPlay = 1;
						gui.trumpDeck.remove(val);
					}

		        	for(int cnt = 0; cnt < gui.trumpSetDeal.size(); cnt++)
		        	{
		        		if(((EnumDqmTrump)gui.trumpSetDeal.get(cnt)).getValue() == 1)
		        		{
		        			if(trumpValTotal + 11 > 21)
		        			{
		        				trumpValTotal = trumpValTotal + 1;
		        			}else
		        			{
		        				trumpValTotal = trumpValTotal + 11;
		        				dealAceBigCounter = dealAceBigCounter + 1;
		        			}
		        		}else
		        		{
		        			if(((EnumDqmTrump)gui.trumpSetDeal.get(cnt)).getValue() > 10)
		        			{
		        				trumpValTotal = trumpValTotal +10;
		        			}else
		        			{
		        				trumpValTotal = trumpValTotal + ((EnumDqmTrump)gui.trumpSetDeal.get(cnt)).getValue();
		        			}
		        			//trumpValTotal = trumpValTotal + ((EnumDqmTrump)gui.trumpSetDeal.get(cnt)).getValue();
		        			if(trumpValTotal > 21 && dealAceBigCounter > 0)
		        			{
		        				dealAceBigCounter = dealAceBigCounter - 1;
		        				trumpValTotal = trumpValTotal - 10;
		        			}
		        		}
		        	}
	        	}


	        	if(trumpValTotal > 21)
	        	{
	        		gui.dealerStatus = 3;
	        	}

	        	//結果処理
	        	gui.gamePhase = 4;
	        	ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(this.ep, gui, 4, -1);
        		threadBJ.start();

			}
		}

		if(this.phaseNum == 4)
		{
			if(this.buttonId == 5)
			{
	    		PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, (Integer.parseInt(gui.commandTextField.getText()) / 2)));
	    		//myCoin = ExtendedPlayerProperties3.get(epa).getCoin();
	    		gui.myCoin = gui.myCoin + (Integer.parseInt(gui.commandTextField.getText()) / 2);
	    		gui.gameResult = EnumDqmCasinoBJOdds.OddsLose;
	    		//gui.gamePhase = 0;

			}else
			{
				gui.gameResult = null;
				if(gui.playerStatus != 3)
				{
					//ディーラーのBJチェック
					if(gui.dealerStatus != 3 && gui.trumpSetDeal.size() == 2)
					{
						ArrayList<Integer> tempDeck = new ArrayList<Integer>();
						for(int cnt = 0; cnt < gui.trumpSetDeal.size(); cnt++)
			        	{
							tempDeck.add(gui.trumpSetDeal.get(cnt).getValue());
			        	}

						Collections.sort(tempDeck);
						if(tempDeck.get(0) == 1 && tempDeck.get(1) == 11 &&
								gui.trumpSetDeal.get(0).getMark().equalsIgnoreCase("Spade") &&
								gui.trumpSetDeal.get(1).getMark().equalsIgnoreCase("Spade"))
						{
							gui.dealerStatus = 4;
						}else if(tempDeck.get(0) == 1 && tempDeck.get(1) >= 10)
						{
							gui.dealerStatus = 2;
						}
					}

					//プレイヤーの合計値
					int playerValTotal = 0;
					int playerAceBigCounter = 0;
					if(gui.trumpSet.size() > 0)
			        {
			        	for(int cnt = 0; cnt < gui.trumpSet.size(); cnt++)
			        	{
			        		if(((EnumDqmTrump)gui.trumpSet.get(cnt)).getValue() == 1)
			        		{
			        			if(playerValTotal + 11 > 21)
			        			{
			        				playerValTotal = playerValTotal + 1;
			        			}else
			        			{
			        				playerValTotal = playerValTotal + 11;
			        				playerAceBigCounter = playerAceBigCounter + 1;
			        			}
			        		}else
			        		{
			        			if(((EnumDqmTrump)gui.trumpSet.get(cnt)).getValue() > 10)
			        			{
			        				playerValTotal = playerValTotal +10;
			        			}else
			        			{
			        				playerValTotal = playerValTotal + ((EnumDqmTrump)gui.trumpSet.get(cnt)).getValue();
			        			}
			        			if(playerValTotal > 21 && playerAceBigCounter > 0)
			        			{
			        				playerAceBigCounter = playerAceBigCounter - 1;
			        				playerValTotal = playerValTotal - 10;
			        			}
			        		}
			        	}
			        }


					int dealerValTotal = 0;
					int dealerAceBigCounter = 0;
					if(gui.trumpSetDeal.size() > 0)
			        {
			        	for(int cnt = 0; cnt < gui.trumpSetDeal.size(); cnt++)
			        	{
			        		if(((EnumDqmTrump)gui.trumpSetDeal.get(cnt)).getValue() == 1)
			        		{
			        			if(dealerValTotal + 11 > 21)
			        			{
			        				dealerValTotal = dealerValTotal + 1;
			        			}else
			        			{
			        				dealerValTotal = dealerValTotal + 11;
			        				dealerAceBigCounter = dealerAceBigCounter + 1;
			        			}
			        		}else
			        		{
			        			if(((EnumDqmTrump)gui.trumpSetDeal.get(cnt)).getValue() > 10)
			        			{
			        				dealerValTotal = dealerValTotal +10;
			        			}else
			        			{
			        				dealerValTotal = dealerValTotal + ((EnumDqmTrump)gui.trumpSetDeal.get(cnt)).getValue();
			        			}
			        			if(dealerValTotal > 21 && dealerAceBigCounter > 0)
			        			{
			        				dealerAceBigCounter = dealerAceBigCounter - 1;
			        				dealerValTotal = dealerValTotal - 10;
			        			}
			        		}
			        	}
			        }



					//役チェック
					ArrayList<Integer> tempDeck = new ArrayList<Integer>();
					for(int cnt = 0; cnt < gui.trumpSet.size(); cnt++)
		        	{
						tempDeck.add(gui.trumpSet.get(cnt).getValue());
		        	}


					Collections.sort(tempDeck);

					if(tempDeck.size() == 6 &&  tempDeck.get(0) == 1 && tempDeck.get(1) == 2 && tempDeck.get(2) == 3 &&
					   tempDeck.get(3) == 4 && tempDeck.get(4) == 5 && tempDeck.get(5) == 6)
					{
						//1to6
						gui.gameResult = EnumDqmCasinoBJOdds.OddsAto6;
					}else if(tempDeck.size() == 7)
					{
						//7Cards
						gui.gameResult = EnumDqmCasinoBJOdds.Odds7Cards;
					}else if(tempDeck.size() == 3 && tempDeck.get(0) == 7  && tempDeck.get(1) == 7  && tempDeck.get(2) == 7)
					{
						//777
						gui.gameResult = EnumDqmCasinoBJOdds.Odds777;
					}else if(tempDeck.size() == 6)
					{
						//6Cards
						gui.gameResult = EnumDqmCasinoBJOdds.Odds6Cards;
					}if(tempDeck.size() == 2 && tempDeck.get(0) == 1 && tempDeck.get(1) == 11 &&
						gui.trumpSet.get(0).getMark().equalsIgnoreCase("Spade") &&
						gui.trumpSet.get(1).getMark().equalsIgnoreCase("Spade"))
					{
						//PureBJ
						gui.gameResult = EnumDqmCasinoBJOdds.OddsPureBJ;
					}else if(gui.dealerStatus == 4)
					{
						//ホームルール役以外の場合、デラがPBJなら敗北確定
						gui.gameResult = EnumDqmCasinoBJOdds.OddsLose;
					}else
					{
						if(tempDeck.size() == 2 && tempDeck.get(0) == 1 && tempDeck.get(1) >= 10)
						{
							//BlackJackの場合
							if(gui.dealerStatus == 2)
							{
								gui.gameResult = EnumDqmCasinoBJOdds.OddsDraw;
							}else
							{
								gui.gameResult = EnumDqmCasinoBJOdds.OddsBlackJack;
							}
						}else if(gui.dealerStatus == 3)
						{
							//ディーラーバースト時
							gui.gameResult = EnumDqmCasinoBJOdds.OddsWin;
						}else if(dealerValTotal == playerValTotal)
						{
							gui.gameResult = EnumDqmCasinoBJOdds.OddsDraw;
						}else if(dealerValTotal < playerValTotal)
						{
							gui.gameResult = EnumDqmCasinoBJOdds.OddsWin;
						}else
						{
							gui.gameResult = EnumDqmCasinoBJOdds.OddsLose;
						}
					}
					//if()

					/*
					System.out.println("Player : " + gui.playerStatus + " / " + playerValTotal);
					System.out.println("Dealer : " + gui.dealerStatus + " / " + dealerValTotal);
					System.out.println("Result : " + gui.gameResult);
					*/
				}else
				{
					//バーストの場合
					gui.gameResult = EnumDqmCasinoBJOdds.OddsLose;
				}


				if(gui.gameResult == EnumDqmCasinoBJOdds.OddsDraw)
				{
					//Drawの場合
		    		PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, (Integer.parseInt(gui.commandTextField.getText()))));
		    		//myCoin = ExtendedPlayerProperties3.get(epa).getCoin();
		    		gui.myCoin = gui.myCoin + (Integer.parseInt(gui.commandTextField.getText()));
		    		//this.ep.worldObj.playSoundAtEntity(this.ep, "dqr:player.miss", 1.0F, 1.0F);
		    		//this.ep.playSound("dqr:player.miss", 1.0F, 1.0F);
				}else if(gui.gameResult != EnumDqmCasinoBJOdds.OddsLose)
				{
					int val = Integer.parseInt(gui.commandTextField.getText());
					PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, (int)(val * gui.gameResult.getOdds())));
		    		//myCoin = ExtendedPlayerProperties3.get(epa).getCoin();
		    		gui.myCoin = gui.myCoin + (int)(val * gui.gameResult.getOdds());
		    		//this.ep.worldObj.playSoundAtEntity(this.ep, "dqr:player.casinowin", 1.0F, 1.0F);
		    		//this.ep.playSound("dqr:player.casinowin", 1.0F, 1.0F);
		    		gui.soundPlay = 2;
				}else
				{
					//this.ep.worldObj.playSoundAtEntity(this.ep, "dqr:player.casinolose", 1.0F, 1.0F);
					//this.ep.playSound("dqr:player.casinolose", 1.0F, 1.0F);
				}
			}

			try {
				this.sleep(4000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			if(gui.lastBet != -1)
			{
				gui.commandTextField.setText(String.valueOf(gui.lastBet));
			}
			gui.lastBet = -1;
			gui.gameResult = null;
			gui.gamePhase = 0;
		}

		/*
		val = rand.nextInt(gui.trumpDeck.size());
		gui.trumpSetDeal.put(gui.trumpSetDeal.size(), gui.trumpDeck.get(val));
		gui.trumpDeck.remove(val);
		*/

	}

}
