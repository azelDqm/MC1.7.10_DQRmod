package dqr.thread;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.gui.casino.GuiCasinoBBGGuiContainer;
import dqr.packetMessage.MessageServerFunction;

public class ThreadCasinoBBG extends Thread{

	private EntityPlayer ep;
	private GuiCasinoBBGGuiContainer gui;
	private int phaseNum;
	private int buttonId;

	public ThreadCasinoBBG(EntityPlayer player, GuiCasinoBBGGuiContainer gui, int phase, int button)
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
		//System.out.println("TEST123:" + gui.gamePhase + "/" + buttonId);
		if(gui.gamePhase == 2)
		{
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.mobCode = gui.suraBox[gui.mobNumber];

			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.buttonPattern = 1;

		}else if(gui.gamePhase == 3)
		{
			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.msgPattern = 1;

			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.soundPlay = 1;
			gui.attackPattern = 1;

			try {
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}

			gui.attackPattern = 2;

			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}

			gui.attackPattern = 0;
			gui.mobCode = -1;

			gui.msgPattern = 2;

			//コイン増減
			int base = gui.betCoin / 5 / 20;
			int getCoinVal = (int)((base * 0.7) + rand.nextInt((int)(base * 0.6)));
			gui.getCoin = getCoinVal;
			gui.getTotalCoin = gui.getTotalCoin + getCoinVal;
			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, getCoinVal));

			gui.soundPlay = 2;
			gui.myCoin = gui.myCoin + getCoinVal;
			//gui.getTotalCoin = gui.getTotalCoin + getCoinVal;
			try {
				this.sleep(250);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}

			gui.buttonPattern = 2;


		}else if(gui.gamePhase == 4)
		{
			gui.mobNumber = gui.mobNumber + 1;
			//if(gui.mobNumber < 5)
			if(gui.mobNumber < 5)
			{
				try {
					this.sleep(400);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				gui.mobCode = gui.suraBox[gui.mobNumber];

				try {
					this.sleep(300);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				gui.buttonPattern = 1;
			}else
			{
				//ゾーマ戦
				try {
					this.sleep(400);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				//gui.epa.playSound("dqr:mob.boss", 0.9F, 1.0F);
				gui.soundPlay = 13;
				gui.mobCode = 5;
				//gui.gamePhase = 0;

				gui.buttonPattern = 4;
			}
		}else if(gui.gamePhase == 5 && buttonId == 22)
		{
			//System.out.println("TEST125:" + gui.bonusFlg);
			if(gui.bonusFlg == 1)
			{
				//System.out.println("TEST:B");
				try {
					this.sleep(300);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				if(gui.patternFlg <= 3)
				{
					gui.msgPattern = 4;
					if(gui.patternFlg == 0 || gui.patternFlg == 5)
					{
						//攻撃
					}else if(gui.patternFlg == 1 || gui.patternFlg == 6)
					{
						//魔法
						gui.soundPlay = 5;
					}else if(gui.patternFlg == 2 || gui.patternFlg == 7)
					{
						//灼熱
						gui.soundPlay = 6;
					}
					gui.buttonPattern = 4;
					gui.gamePhase = 30;
				}else if(gui.patternFlg == 4)
				{
					//System.out.println("TEST:A");
					gui.buttonPattern = 5;
					gui.gamePhase = 32;
				}else if(gui.patternFlg >= 5)
				{
					gui.msgPattern = 4;
					if(gui.patternFlg == 0 || gui.patternFlg == 5)
					{
						//攻撃
					}else if(gui.patternFlg == 1 || gui.patternFlg == 6)
					{
						//魔法
						gui.soundPlay = 5;
					}else if(gui.patternFlg == 2 || gui.patternFlg == 7)
					{
						//灼熱
						gui.soundPlay = 6;
					}
					gui.buttonPattern = 4;
					gui.gamePhase = 38;
				}
				//System.out.println("TEST:A");
			}else if(gui.bonusFlg == 2)
			{
				//System.out.println("TEST:B");
				try {
					this.sleep(300);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
				}
				gui.msgPattern = 3;
				gui.buttonPattern = 3;
			}else if(gui.bonusFlg == 3)
			{
				//System.out.println("TEST:C");
				try {
					this.sleep(300);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				//System.out.println("TEST1");
				if(gui.comboCount > 20)
				{
					//System.out.println("TEST2");
					gui.msgPattern = 10;
					gui.gamePhase = 50;
					try {
						this.sleep(300);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

					//gui.msgPattern = 8;

					try {
						this.sleep(500);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}

					gui.attackPattern = 1;
					gui.soundPlay = 9;
					gui.gamePhase = 51;
					try {
						this.sleep(100);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
					}

					gui.attackPattern = 2;

					try {
						this.sleep(200);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
					}

					gui.attackPattern = 0;

					try {
						this.sleep(250);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
					}
					gui.gamePhase = 52;
					gui.soundPlay = 11;
					gui.mobCode = -1;

					try {
						this.sleep(300);
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
					}
					//コイン増減
					//System.out.println
					int base = (int)(gui.betCoin / 5 * 0.75);
					int getCoinVal = (int)((base * 0.7) + rand.nextInt((int)(base * 0.6)));
					gui.getCoin = getCoinVal;
					gui.getTotalCoin = gui.getTotalCoin + getCoinVal;
					playHitSound();

					PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, getCoinVal));
					gui.myCoin = gui.myCoin + getCoinVal;
					//gui.getTotalCoin = gui.getTotalCoin + getCoinVal;

					gui.buttonPattern = 4;
				}else
				{
					gui.msgPattern = 4;
					if(gui.patternFlg == 0 || gui.patternFlg == 5)
					{
						//攻撃
					}else if(gui.patternFlg == 1 || gui.patternFlg == 6)
					{
						//魔法
						gui.soundPlay = 5;
					}else if(gui.patternFlg == 2 || gui.patternFlg == 7)
					{
						//灼熱
						gui.soundPlay = 6;
					}
					gui.buttonPattern = 4;
					gui.gamePhase = 6;
				}

			}
			//System.out.println("TEST12:" + gui.bonusFlg + "/"+ gui.gamePhase);
			//gui.gamePhase = 0;
		}else if(gui.gamePhase == 6)
		{
			//System.out.println("TEST999");

			gui.buttonPattern = -1;
			//プレイヤダメージ
			try {
				this.sleep(400);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.damage = 180 + rand.nextInt(41);
			gui.soundPlay = 7;
			gui.life = 0;

			try {
				this.sleep(1500);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.buttonPattern = 4;

			gui.gamePhase = 7;
			//gui.soundPlay = 8;
		}else if(gui.gamePhase == 30)
		{
			//System.out.println("TEST999");

			gui.buttonPattern = -1;
			//プレイヤダメージ
			try {
				this.sleep(400);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.damage = 179 - rand.nextInt(40);
			gui.soundPlay = 7;
			gui.life = 180 - gui.damage;

			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.buttonPattern = 4;

			gui.gamePhase = 31;

			int base = (int)(gui.betCoin / 5 * 0.75);
			int getCoinVal = (int)((base * 0.7) + rand.nextInt((int)(base * 0.6)));
			gui.getCoin = getCoinVal;
			gui.getTotalCoin = gui.getTotalCoin + getCoinVal;

			playHitSound();
			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, getCoinVal));
			gui.myCoin = gui.myCoin + getCoinVal;
			//gui.getTotalCoin = gui.getTotalCoin + getCoinVal;

		}else if(gui.gamePhase == 38)
		{
			gui.buttonPattern = -1;
			//プレイヤダメージ
			try {
				this.sleep(400);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.damage = 180 + rand.nextInt(41);
			gui.soundPlay = 7;
			gui.life = 0;

			try {
				this.sleep(1500);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.buttonPattern = 4;

			gui.gamePhase = 39;
			//gui.soundPlay = 8;
			/*
			int base = (int)(gui.betCoin / 5 * 0.75);
			int getCoinVal = (int)((base * 0.7) + rand.nextInt((int)(base * 0.6)));
			gui.getCoin = getCoinVal;
			gui.getTotalCoin = gui.getTotalCoin + getCoinVal;
			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, getCoinVal));
			gui.myCoin = gui.myCoin + getCoinVal;
			*/

		}else if(gui.gamePhase == 8)
		{
			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			if(buttonId == 30 || buttonId == 31 || buttonId == 31)
			{
				gui.msgPattern = 7;
			}else
			{
				gui.msgPattern = 5;
				if(gui.patternFlg == 0 || gui.patternFlg == 5)
				{
					//攻撃
				}else if(gui.patternFlg == 1 || gui.patternFlg == 6)
				{
					//魔法
					gui.soundPlay = 5;
				}else if(gui.patternFlg == 2 || gui.patternFlg == 7)
				{
					//灼熱
					gui.soundPlay = 6;
				}
				gui.gamePhase = 20;
			}
			gui.buttonPattern = 4;

		}else if(gui.gamePhase == 20)
		{
			//System.out.println("TEST999");


			gui.buttonPattern = -1;
			//プレイヤダメージ
			try {
				this.sleep(400);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			int randVal = (180 + rand.nextInt(41)) / 2;
			gui.damage =randVal ;
			gui.soundPlay = 7;
			gui.life = 180 - gui.damage;

			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.buttonPattern = 4;

			gui.gamePhase = 21;
			int base = (int)(gui.betCoin / 5 * 0.75);
			int getCoinVal = (int)((base * 0.7) + rand.nextInt((int)(base * 0.6)));
			gui.getCoin = getCoinVal;
			gui.getTotalCoin = gui.getTotalCoin + getCoinVal;
			playHitSound();
			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, getCoinVal));
			gui.myCoin = gui.myCoin + getCoinVal;
			//gui.getTotalCoin = gui.getTotalCoin + getCoinVal;

		}else if(gui.gamePhase == 9)
		{
			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			if(buttonId == 30 || buttonId == 31 || buttonId == 31)
			{
				gui.msgPattern = 7;
			}else
			{
				gui.msgPattern = 5;
				if(gui.patternFlg == 0 || gui.patternFlg == 5)
				{
					//攻撃
				}else if(gui.patternFlg == 1 || gui.patternFlg == 6)
				{
					//魔法
					gui.soundPlay = 5;
				}else if(gui.patternFlg == 2 || gui.patternFlg == 7)
				{
					//灼熱
					gui.soundPlay = 6;
				}
				gui.gamePhase = 10;
			}
			gui.buttonPattern = 4;

		}else if(gui.gamePhase == 10)
		{
			gui.buttonPattern = -1;
			//プレイヤダメージ
			try {
				this.sleep(400);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.damage = 180 + rand.nextInt(41);
			gui.soundPlay = 7;
			gui.life = 0;

			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.buttonPattern = 4;

			gui.gamePhase = 7;
			//gui.soundPlay = 8;
		}else if(gui.gamePhase == 40)
		{
			//死亡からの復活勝利
			try {
				this.sleep(1800);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.msgPattern = 9;
			gui.mobCode = -1;
			gui.cartainFlg = 4;

			try {
				this.sleep(1800);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.gamePhase = 41;

			try {
				this.sleep(1800);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.gamePhase = 42;
			gui.soundPlay = 4;
			try {
				this.sleep(1800);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.life = 180;
			gui.gamePhase = 43;

			//コイン増減
			//System.out.println
			int base = (int)(gui.betCoin / 5 * 0.75);
			int getCoinVal = (int)((base * 0.7) + rand.nextInt((int)(base * 0.6)));
			gui.getCoin = getCoinVal;
			gui.getTotalCoin = gui.getTotalCoin + getCoinVal;
			playHitSound();
			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, getCoinVal));
			gui.myCoin = gui.myCoin + getCoinVal;
			//gui.getTotalCoin = gui.getTotalCoin + getCoinVal;

			try {
				this.sleep(1200);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.buttonPattern = 4;
		}else if(gui.gamePhase == 22)
		{

			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.cartainCount = 0;
			gui.mode = -1;

			gui.bonusFlg = -1;
			gui.bgFlg = -1;
			gui.cartainFlg = -1;
			gui.patternFlg = -1;

			gui.mobCode = -1;
			gui.mobNumber = 0;
			gui.buttonPattern = -1;
			gui.msgPattern = -1;
			gui.attackPattern = -1;
			gui.life = 180;
			gui.damage = 0;
			gui.primChusen();

			gui.gamePhase = 1;
			gui.cartainFlg = 3;
			gui.playerAct = -1;
			gui.comboCount = gui.comboCount + 1;
		}else if(gui.gamePhase == 34)
		{
			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//gui.msgPattern = 8;

			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			gui.posMissFix = -48;
			gui.attackPattern = 1;
			gui.soundPlay = 14;
			//gui.epa.playSound("dqr:player.miss", 0.9F, 1.0F);

			try {
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}

			gui.attackPattern = 2;

			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}

			gui.attackPattern = 0;
			gui.posMissFix = 0;

			try {
				this.sleep(250);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}
			gui.gamePhase = 35;

			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}
			//コイン増減
			//System.out.println
			int base = (int)(gui.betCoin / 5 * 0.75);
			int getCoinVal = (int)((base * 0.7) + rand.nextInt((int)(base * 0.6)));
			gui.getCoin = getCoinVal;
			gui.getTotalCoin = gui.getTotalCoin + getCoinVal;
			playHitSound();

			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, getCoinVal));
			gui.myCoin = gui.myCoin + getCoinVal;
			//gui.getTotalCoin = gui.getTotalCoin + getCoinVal;

			gui.buttonPattern = 4;
			//gui.buttonPattern = 2;


		}else if(gui.gamePhase == 50)
		{
			gui.msgPattern = 10;
			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			//gui.msgPattern = 8;

			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			gui.attackPattern = 1;
			gui.soundPlay = 9;
			gui.gamePhase = 51;
			try {
				this.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}

			gui.attackPattern = 2;

			try {
				this.sleep(200);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}

			gui.attackPattern = 0;

			try {
				this.sleep(250);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}
			gui.gamePhase = 52;
			gui.soundPlay = 11;
			gui.mobCode = -1;

			try {
				this.sleep(300);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
			}
			//コイン増減
			//System.out.println
			int base = (int)(gui.betCoin / 5 * 0.75);
			int getCoinVal = (int)((base * 0.7) + rand.nextInt((int)(base * 0.6)));
			gui.getCoin = getCoinVal;
			gui.getTotalCoin = gui.getTotalCoin + getCoinVal;
			playHitSound();

			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, getCoinVal));
			gui.myCoin = gui.myCoin + getCoinVal;
			//gui.getTotalCoin = gui.getTotalCoin + getCoinVal;

			gui.buttonPattern = 4;
			//gui.buttonPattern = 2;


		}

		/*
		val = rand.nextInt(gui.trumpDeck.size());
		gui.trumpSetDeal.put(gui.trumpSetDeal.size(), gui.trumpDeck.get(val));
		gui.trumpDeck.remove(val);
		*/

	}

	public void playHitSound()
	{
		gui.soundPlay = 3;
		try {
			this.sleep(100);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
		}
		gui.soundPlay = 3;
		try {
			this.sleep(100);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
		}
		gui.soundPlay = 3;
	}
}
