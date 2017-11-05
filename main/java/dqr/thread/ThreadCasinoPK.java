package dqr.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmCasinoPKOdds;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.api.enums.EnumDqmTrump;
import dqr.gui.casino.GuiCasinoPKGuiContainer;
import dqr.packetMessage.MessageServerFunction;

public class ThreadCasinoPK extends Thread{

	private EntityPlayer ep;
	private GuiCasinoPKGuiContainer gui;
	private int phaseNum;
	private int buttonId;

	public ThreadCasinoPK(EntityPlayer player, GuiCasinoPKGuiContainer gui, int phase, int button)
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
			try
			{
				ArrayList<EnumDqmTrump> trumpDeckCopy = new ArrayList<EnumDqmTrump>();

				gui.trumpSet = new LinkedHashMap<Integer, EnumDqmTrump>();
				gui.trumpDeck = new ArrayList<EnumDqmTrump>();

				EnumDqmTrump[] data = EnumDqmTrump.values();
				gui.trumpDeckRev = new int[5];
		    	for(int cnt = 0; cnt < data.length; cnt++)
		    	{
		    		if(14 > data[cnt].getValue()&& data[cnt].getValue() > 0)
		    		{
		    			gui.trumpDeck.add(data[cnt]);
		    		}
		    	}
		    	gui.trumpDeck.add(EnumDqmTrump.JK1);


				this.sleep(DQR.conf.PK_firstHand_wait);



				trumpDeckCopy.addAll(gui.trumpDeck);

				int val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[gui.trumpSet.size()] = 1;
				if(DQR.debug == 1)
				{
					//gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
					gui.trumpSet.put(gui.trumpSet.size(), EnumDqmTrump.D3);
				}else
				{
					gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
				}
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				trumpDeckCopy.remove(val);

				this.sleep(DQR.conf.PK_firstHand_wait);




				val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[gui.trumpSet.size()] = 1;
				//gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
				if(DQR.debug == 1)
				{
					gui.trumpSet.put(gui.trumpSet.size(), EnumDqmTrump.D1);
				}else
				{
					gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
				}
				this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				trumpDeckCopy.remove(val);

				this.sleep(DQR.conf.PK_firstHand_wait);



				val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[gui.trumpSet.size()] = 1;
				//gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
				if(DQR.debug == 1)
				{
					//gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
					gui.trumpSet.put(gui.trumpSet.size(), EnumDqmTrump.JK1);
				}else
				{
					gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
				}
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				trumpDeckCopy.remove(val);

				this.sleep(DQR.conf.PK_firstHand_wait);


				val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[gui.trumpSet.size()] = 1;
				//gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
				if(DQR.debug == 1)
				{
					//gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
					gui.trumpSet.put(gui.trumpSet.size(), EnumDqmTrump.H5);
				}else
				{
					gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
				}
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				trumpDeckCopy.remove(val);

				this.sleep(DQR.conf.PK_firstHand_wait);


				val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[gui.trumpSet.size()] = 1;
				//gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
				if(DQR.debug == 1)
				{
					//gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
					gui.trumpSet.put(gui.trumpSet.size(), EnumDqmTrump.C2);
				}else
				{
					gui.trumpSet.put(gui.trumpSet.size(), trumpDeckCopy.get(val));
				}
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				trumpDeckCopy.remove(val);

				this.sleep(DQR.conf.PK_firstHand_wait);


				gui.trumpDeck.clear();
				gui.trumpDeck.addAll(trumpDeckCopy);

				gui.gamePhase = 2;
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}else if(this.phaseNum == 3)
		{
			ArrayList<EnumDqmTrump> trumpDeckCopy = new ArrayList<EnumDqmTrump>();
			trumpDeckCopy.addAll(gui.trumpDeck);


			if(gui.trumpDeckRev[0] == 0)
			{
				try {
					this.sleep(DQR.conf.PK_change);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//gui.trumpSet.put(cnt, value);
				int val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[0] = 1;
				gui.trumpSet.put(0, trumpDeckCopy.get(val));
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				trumpDeckCopy.remove(val);

			}

			if(gui.trumpDeckRev[1] == 0)
			{
				try {
					this.sleep(DQR.conf.PK_change);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//gui.trumpSet.put(cnt, value);
				int val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[1] = 1;
				gui.trumpSet.put(1, trumpDeckCopy.get(val));
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				trumpDeckCopy.remove(val);

			}
			if(gui.trumpDeckRev[2] == 0)
			{
				try {
					this.sleep(DQR.conf.PK_change);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//gui.trumpSet.put(cnt, value);
				int val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[2] = 1;
				gui.trumpSet.put(2, trumpDeckCopy.get(val));
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				trumpDeckCopy.remove(val);

			}
			if(gui.trumpDeckRev[3] == 0)
			{
				try {
					this.sleep(DQR.conf.PK_change);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//gui.trumpSet.put(cnt, value);
				int val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[3] = 1;
				gui.trumpSet.put(3, trumpDeckCopy.get(val));
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				trumpDeckCopy.remove(val);

			}
			if(gui.trumpDeckRev[4] == 0)
			{
				try {
					this.sleep(DQR.conf.PK_change);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//gui.trumpSet.put(cnt, value);
				int val = rand.nextInt(trumpDeckCopy.size());
				gui.trumpDeckRev[4] = 1;
				gui.trumpSet.put(4, trumpDeckCopy.get(val));
				//this.ep.playSound("gui.button.press", 0.9F, 1.0F);
				gui.soundPlay = 1;
				trumpDeckCopy.remove(val);
			}

			gui.gamePhase = 4;
		}

		if(this.gui.gamePhase == 4)
		{


			//役チェック
			gui.gameResult = null;
			ArrayList<Integer> tempDeck = new ArrayList<Integer>();
			boolean flgJoker = false;
			boolean flgJokerPre = false;
			boolean flgFlush = true;
			boolean flgStraight = false;
			boolean flg4cardA = true;
			boolean flg4cardB = true;

			int flgHighStraight = 0;

			for(int cnt = 0; cnt < gui.trumpSet.size(); cnt++)
        	{
				tempDeck.add(gui.trumpSet.get(cnt).getValue());
        	}

			Collections.sort(tempDeck);

			//Jokerチェック
			if(tempDeck.get(0) == 0)
			{
				flgJoker = true;
			}

			//4cardチェック
			int check4c = tempDeck.get(0);
			for(int cnt = 0; cnt < 4; cnt++)
			{
				if(tempDeck.get(cnt) != check4c)
				{
					flg4cardA = false;
				}
			}
			check4c = tempDeck.get(1);
			for(int cnt = 1; cnt < 5; cnt++)
			{
				if(tempDeck.get(cnt) != check4c)
				{
					flg4cardB = false;
				}
			}

			if(!flg4cardB && !flg4cardA)
			{
				if(flgJoker &&
				   ((tempDeck.get(0) == tempDeck.get(1) && tempDeck.get(1) == tempDeck.get(2)) ||
				   (tempDeck.get(1) == tempDeck.get(2) && tempDeck.get(2) == tempDeck.get(3)) ||
				   (tempDeck.get(2) == tempDeck.get(3) && tempDeck.get(3) == tempDeck.get(4))))
				{
					flg4cardA = true;
					flgJoker = false;
				}
			}


			//Flushチェック
			String marks = null;
			if(gui.trumpSet.get(0).getMark().equalsIgnoreCase("Joker"))
        	{
				marks = gui.trumpSet.get(1).getMark();
        	}else
        	{
        		marks = gui.trumpSet.get(0).getMark();
        	}
			for(int cnt = 0; cnt < 5; cnt++)
			{
				if(!gui.trumpSet.get(cnt).getMark().equalsIgnoreCase("Joker") &&
				   !gui.trumpSet.get(cnt).getMark().equalsIgnoreCase(marks))
				{
					flgFlush = false;
				}
			}

			//ハイストレートチェック
			int[] highStraightBox = new int[6];
			for(int cnt = 0; cnt < 5; cnt++)
			{
				if(tempDeck.get(cnt) == 0)
				{
					highStraightBox[0] = 1;
				}else if(tempDeck.get(cnt) == 10)
				{
					highStraightBox[1] = 1;
				}else if(tempDeck.get(cnt) == 11)
				{
					highStraightBox[2] = 1;
				}else if(tempDeck.get(cnt) == 12)
				{
					highStraightBox[3] = 1;
				}else if(tempDeck.get(cnt) == 13)
				{
					highStraightBox[4] = 1;
				}else if(tempDeck.get(cnt) == 1)
				{
					highStraightBox[5] = 1;
				}
			}
			for(int cnt = 0; cnt < 6; cnt++)
			{
				flgHighStraight = flgHighStraight + highStraightBox[cnt];
			}

			//Straightチェック
			flgJokerPre = flgJoker;
			int straightBase = -1;
			int straightVal = 0;
			if(tempDeck.get(0) == 0)
			{
				straightBase = tempDeck.get(1);
			}else
			{
				straightBase = tempDeck.get(0);
			}
			int[] straightBox = new int[5];


			for(int cnt = 0; cnt < 5; cnt++)
			{
				if(tempDeck.get(cnt) == 0)
				{
					//System.out.println("TEST" + cnt + " : " + tempDeck.get(cnt));
					straightBox[0] = 1;
				}else if(tempDeck.get(cnt) == straightBase + 1)
				{
					//System.out.println("TEST" + cnt + " : " + tempDeck.get(cnt));
					straightBox[1] = 1;
				}else if(tempDeck.get(cnt) == straightBase + 2)
				{
					//System.out.println("TEST" + cnt + " : " + tempDeck.get(cnt));
					straightBox[2] = 1;
				}else if(tempDeck.get(cnt) == straightBase + 3)
				{
					//System.out.println("TEST" + cnt + " : " + tempDeck.get(cnt));
					straightBox[3] = 1;
				}else if(tempDeck.get(cnt) == straightBase + 4)
				{
					//System.out.println("TEST" + cnt + " : " + tempDeck.get(cnt));
					straightBox[4] = 1;
				}
			}
			for(int cnt = 0; cnt < 5; cnt++)
			{
				straightVal = straightVal + straightBox[cnt];
			}

			//System.out.println("TEST99 : " + straightVal);
			if(straightVal >= 4)
			{
				flgStraight = true;
			}
			/*
			for(int cnt = 0; cnt < 4; cnt++)
			{
				if(cnt == 0 && tempDeck.get(cnt) == 0)
				{
				}else
				{
					System.out.println("TEST : " + tempDeck.get(cnt) + 1 + " / " + tempDeck.get(cnt + 1));


					if(tempDeck.get(cnt) + 1 != tempDeck.get(cnt + 1))
					{
						if(flgJokerPre && tempDeck.get(cnt) + 2 != tempDeck.get(cnt + 1))
						{
							flgJokerPre = false;
						}else
						{
							flgStraight = false;
						}
					}
				}
			}
			*/

			//RSF
			if(flgHighStraight >= 5 && flgFlush)
			{
				gui.gameResult = EnumDqmCasinoPKOdds.OddsRSF;
			}

			//5cards
			if(gui.gameResult == null)
			{
				if((flg4cardA || flg4cardB) && flgJoker)
				{
					gui.gameResult = EnumDqmCasinoPKOdds.Odds5Cards;
				}
			}

			//StraightFlash
			if(gui.gameResult == null)
			{
				if(flgStraight && flgFlush)
				{
					gui.gameResult = EnumDqmCasinoPKOdds.OddsSFlash;
				}
			}

			//4cards
			if(gui.gameResult == null)
			{
				if(flg4cardA || flg4cardB)
				{
					gui.gameResult = EnumDqmCasinoPKOdds.Odds4Cards;
				}
			}

			//フルハウス
			if(gui.gameResult == null)
			{
				if((tempDeck.get(0) == tempDeck.get(1) && tempDeck.get(1) == tempDeck.get(2) &&
					tempDeck.get(3) == tempDeck.get(4)) ||
					(tempDeck.get(0) == tempDeck.get(1) && tempDeck.get(2) == tempDeck.get(3) &&
					 tempDeck.get(3) == tempDeck.get(4)))
				{
					gui.gameResult = EnumDqmCasinoPKOdds.OddsFullHouse;
				}else if(flgJoker &&
						 ((tempDeck.get(0) == tempDeck.get(1) && tempDeck.get(2) == tempDeck.get(3)) ||
						  (tempDeck.get(0) == tempDeck.get(1) && tempDeck.get(3) == tempDeck.get(4)) ||
						  (tempDeck.get(1) == tempDeck.get(2) && tempDeck.get(3) == tempDeck.get(4))
						 )
						)
				{
					gui.gameResult = EnumDqmCasinoPKOdds.OddsFullHouse;
				}
			}

			//フラッシュ
			if(gui.gameResult == null)
			{
				if(flgFlush)
				{
					gui.gameResult = EnumDqmCasinoPKOdds.OddsFlush;
				}
			}

			//ストレート
			if(gui.gameResult == null)
			{
				if(flgStraight || (flgHighStraight >= 5))
				{
					gui.gameResult = EnumDqmCasinoPKOdds.OddsStraight;
				}
			}

			//3カード
			if(gui.gameResult == null)
			{
				if((tempDeck.get(0) == tempDeck.get(1) && tempDeck.get(1) == tempDeck.get(2)) ||
				   (tempDeck.get(1) == tempDeck.get(2) && tempDeck.get(2) == tempDeck.get(3)) ||
				   (tempDeck.get(2) == tempDeck.get(3) && tempDeck.get(3) == tempDeck.get(4)))
				{
					gui.gameResult = EnumDqmCasinoPKOdds.Odds3Cards;
				}else if(flgJoker &&
						(tempDeck.get(0) == tempDeck.get(1) || tempDeck.get(1) == tempDeck.get(2) ||
						 tempDeck.get(2) == tempDeck.get(3) || tempDeck.get(3) == tempDeck.get(4))
						)
				{
					gui.gameResult = EnumDqmCasinoPKOdds.Odds3Cards;
				}
			}

			//2ペア
			if(gui.gameResult == null)
			{
				if((tempDeck.get(0) == tempDeck.get(1) && tempDeck.get(2) == tempDeck.get(3)) ||
				   (tempDeck.get(0) == tempDeck.get(1) && tempDeck.get(3) == tempDeck.get(4)) ||
				   (tempDeck.get(1) == tempDeck.get(2) && tempDeck.get(3) == tempDeck.get(4))
				   )
				{
					gui.gameResult = EnumDqmCasinoPKOdds.OddsTwoPair;
				}
			}

			//1ペア
			if(gui.gameResult == null)
			{
				if(tempDeck.get(0) == tempDeck.get(1) || tempDeck.get(1) == tempDeck.get(2) ||
				   tempDeck.get(2) == tempDeck.get(3) || tempDeck.get(3) == tempDeck.get(4) ||
				   flgJoker)
				{
					gui.gameResult = EnumDqmCasinoPKOdds.OddsOnePair;
				}
			}

			//ブタ
			if(gui.gameResult == null)
			{
				gui.gameResult = EnumDqmCasinoPKOdds.OddsLose;
			}



			if(gui.gameResult != EnumDqmCasinoPKOdds.OddsLose)
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

			try {
				this.sleep(DQR.conf.PK_end_wait);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

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
