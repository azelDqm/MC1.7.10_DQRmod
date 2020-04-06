package dqr.gui.casino;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmCasinoBJOdds;
import dqr.api.enums.EnumDqmCasinoCCROdds;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.packetMessage.MessageServerFunction;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.thread.ThreadCasinoCCR;

public class GuiCasinoCCRGuiContainer extends GuiContainer
{

	//num X138(23) Y 0/36 (35)
    private static final ResourceLocation texture = new ResourceLocation("dqr", "textures/casino/ccr_background.png");
    private static final ResourceLocation texture2 = new ResourceLocation("dqr", "textures/casino/ccr_background2.png");
    //protected static final ResourceLocation buttonTextures = new ResourceLocation("dqr:textures/casino/widgets3.png");

    private static final ResourceLocation IMGdice = new ResourceLocation("dqr", "textures/casino/dice.png");
    /*
    private static final ResourceLocation IMGcartain1 = new ResourceLocation("dqr", "textures/casino/bbg_cart.png");
    private static final ResourceLocation IMGcartain2 = new ResourceLocation("dqr", "textures/casino/bbg_cart2.png");
    private static final ResourceLocation IMGcartain3 = new ResourceLocation("dqr", "textures/casino/bbg_cart3.png");
    private static final ResourceLocation IMGcartain4 = new ResourceLocation("dqr", "textures/casino/bbg_cart4.png");
    private static final ResourceLocation IMGcartain5 = new ResourceLocation("dqr", "textures/casino/bbg_cart5.png");
    */

    /*
    private static final ResourceLocation BG1A = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0401.png");
    private static final ResourceLocation BG1B = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0402.png");
    private static final ResourceLocation BG1C = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0403.png");

    private static final ResourceLocation BG2A = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0201.png");
    private static final ResourceLocation BG2B = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0202.png");
    private static final ResourceLocation BG2C = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0203.png");

    private static final ResourceLocation BG3A = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0101.png");
    private static final ResourceLocation BG3B = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0102.png");
    private static final ResourceLocation BG3C = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0103.png");

    private static final ResourceLocation BG4A = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0301.png");
    private static final ResourceLocation BG4B = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0302.png");
    private static final ResourceLocation BG4C = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0303.png");

    private static final ResourceLocation BG5A = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0501.png");
    private static final ResourceLocation BG5B = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0502.png");
    private static final ResourceLocation BG5C = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0503.png");

    private static final ResourceLocation BG6 = new ResourceLocation("dqr", "textures/casino/BBG_BG/BG0901.png");
    //private static final ResourceLocation texture2 = new ResourceLocation("dqr", "textures/casino/bj_background2.png");
	*/
    private static final ResourceLocation textureWin = new ResourceLocation("dqr", "textures/casino/Result_Win.png");
    private static final ResourceLocation textureLose = new ResourceLocation("dqr", "textures/casino/Result_Lose.png");
    private static final ResourceLocation textureDraw = new ResourceLocation("dqr", "textures/casino/Result_Draw.png");
    //private static final ResourceLocation textureResult = new ResourceLocation("dqr", "textures/casino/ccr_effect.png");

    private static final ResourceLocation dialog = new ResourceLocation("dqr", "textures/casino/dialog.png");

    public int debugKey = -1;
    public GuiTextField commandTextField;
    public int[] suraBox = new int[5];
    //public GuiTextField commandTextField;
    public EntityPlayer epa;

    public int myCoin = 0;
    public int lastBet = -1;

    public int dice1 = -2;
    public int dice2 = -2;
    public int dice3 = -2;

    //10:敗北 11:勝利 12:DRAW
    //public int gameResult = 0;
    public EnumDqmCasinoBJOdds gameResult = null;

    public EnumDqmCasinoCCROdds playerResult;
    public int[] playerDiceSet = new int[3];
    public EnumDqmCasinoCCROdds cpuResult;
    public int[] cpuDiceSet = new int[3];

    public int gamePhase = 0;
    public int dealer = 0; //2:CPU 1:PC
    public int msgPattern = -1;
    public int playerHitCount = 0;
    public int winner = 0;
    public boolean result123 = false;
    public EnumDqmCasinoCCROdds resultBox = null;
    public boolean closeFlg = false;
    public boolean alartFlg = false;

    public int soundPlay = -1;

    public int ikasamaFlg = 0;
    public GuiCasinoCCRGuiContainer(EntityPlayer player)
    {

        super(new GuiCasinoBJContainer(player));
        this.epa = player;
    	//NBTTagCompound playerPet = ExtendedPlayerProperties3.get(player).getNBTPlayerPetList();
    	//Set tags = playerPet.func_150296_c();

    	myCoin = ExtendedPlayerProperties3.get(player).getCoin();

        this.ySize = 222;
        this.xSize = 256;

    	//trumpDeck

    	/*
    	int mainX = (this.width - this.xSize) / 2;
    	int mainY = (this.height - this.ySize) / 2;
    	int halfX = (this.width - this.xSize) / 2 + (this.xSize / 2);
    	int halfY = (this.height - this.ySize) / 2 + (this.ySize / 2);
    	int endX = (this.width - this.xSize) / 2 + this.xSize;
    	int endY = (this.height - this.ySize) / 2 + this.ySize;

    	int bg2StartX = mainX + 251;
    	*/


    }

    public void initGui()
    {

    	super.initGui();


    }



    protected void keyTyped(char p_73869_1_, int p_73869_2_)
    {

    	System.out.println("KEY : " +  p_73869_2_);
    	debugKey = p_73869_2_;
    	if(this.gamePhase == 0 || this.gamePhase == 99)
    	{
	    	if(p_73869_2_ == 203)
	    	{
	    		this.commandTextField.moveCursorBy(-1);
	    	}else if(p_73869_2_ == 205)
	    	{
	    		this.commandTextField.moveCursorBy(1);
	    	}else if(p_73869_2_ == 211)
	    	{
	    		this.commandTextField.deleteFromCursor(1);
	    	}else if(p_73869_2_ == 14)
	    	{
	    		this.commandTextField.deleteFromCursor(-1);
	    	}

	    	if(isNumber1(String.valueOf(p_73869_1_)))
	    	{
	    		String preValue = this.commandTextField.getText();

	    		this.commandTextField.textboxKeyTyped(p_73869_1_, p_73869_2_);
	    		String newValue = this.commandTextField.getText();
	    		int newIntValue = Integer.parseInt(newValue);

	    		if(newIntValue > 1000000)
	    		{
	    			newIntValue = 1000000;
	    			this.commandTextField.setText("1000000");
	    		}

	    		if(newIntValue > this.myCoin)
	    		{
	    			this.commandTextField.setText(preValue);
	    		}
	    	}
    	}else
    	{
        	if(p_73869_2_ == 1 || p_73869_2_ == this.mc.gameSettings.keyBindInventory.getKeyCode())
        	{
        		//epa.openGui(DQR.instance, DQR.conf.GuiID_CSSlot, epa.worldObj, (int)epa.posX, (int)epa.posY, (int)epa.posZ);
        		//System.out.println("TEST:" + p_73869_1_ + "/" + p_73869_2_);
    			closeFlg = true;
    			return;
        	}
    	}

        //System.out.println("TEST : " + p_73869_1_ + " / " + p_73869_2_);
        super.keyTyped(p_73869_1_, p_73869_2_);
    }

    public void updateScreen()
    {
    	if(this.commandTextField != null)
    	{
    		this.commandTextField.updateCursorCounter();
    	}
    }


    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
    	//System.out.println("TESTTTTTTTTTTTTT");
		int x2 = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;

    }

    /*
        背景の描画
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {

    	if(soundPlay != -1)
    	{
    		doSoundPlay();
    	}

    	//System.out.println("PHASE :" + this.gamePhase);
    	int mainX = (this.width - this.xSize) / 2;
    	int mainY = (this.height - this.ySize) / 2;
    	int halfX = (this.width - this.xSize) / 2 + (this.xSize / 2);
    	int halfY = (this.height - this.ySize) / 2 + (this.ySize / 2);
    	int endX = (this.width - this.xSize) / 2 + this.xSize;
    	int endY = (this.height - this.ySize) / 2 + this.ySize;

    	int bg2StartX = mainX + 251;
    	buttonList = new ArrayList();

    	NumberFormat nfNum = NumberFormat.getNumberInstance();
    	String test = new String();



        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(mainX, mainY, 0, 0, 256, this.ySize);

    	//リザルト
        if(gamePhase >= 98)
        {
        	if(resultBox != null && resultBox != EnumDqmCasinoCCROdds.RABC && resultBox != EnumDqmCasinoCCROdds.R123)
        	{
        		if(winner == 1)
        		{
        			this.drawTexturedModalRect(mainX + 140, mainY + resultBox.getRateListY(), 14, 222, 105, resultBox.getRateListHeight());
        		}else if(winner == 2)
        		{
        			this.drawTexturedModalRect(mainX + 140, mainY + resultBox.getRateListY(), 119, 222, 105, resultBox.getRateListHeight());
        		}
        	}

        	if(result123)
        	{
        		if(winner == 1)
        		{
        			this.drawTexturedModalRect(mainX + 140, mainY + EnumDqmCasinoCCROdds.R123.getRateListY(), 14, 222, 105, EnumDqmCasinoCCROdds.R123.getRateListHeight());
        		}else if(winner == 2)
        		{
        			this.drawTexturedModalRect(mainX + 140, mainY + EnumDqmCasinoCCROdds.R123.getRateListY(), 119, 222, 105, EnumDqmCasinoCCROdds.R123.getRateListHeight());
        		}
        	}
        }


        //RateList
        //ピンゾロ
        this.drawTexturedModalRect(mainX + 144, mainY + 11, 224, 222, 11, 11);
        this.drawTexturedModalRect(mainX + 156, mainY + 11, 224, 222, 11, 11);
        this.drawTexturedModalRect(mainX + 168, mainY + 11, 224, 222, 11, 11);

        for(int cnt = 0; cnt < 5; cnt++)
        {
        	int x;
        	int y;
        	if(cnt > 2)
        	{
        		x = 224;
        		y = 244 - ((cnt - 3) * 11);
        	}else
        	{
        		x = 235;
        		y = 244 - (cnt * 11);
        	}
            this.drawTexturedModalRect(mainX + 144, mainY + 26 + (14 * cnt), x, y, 11, 11);
            this.drawTexturedModalRect(mainX + 156, mainY + 26 + (14 * cnt), x, y, 11, 11);
            this.drawTexturedModalRect(mainX + 168, mainY + 26 + (14 * cnt), x, y, 11, 11);
        }

        //456
        this.drawTexturedModalRect(mainX + 144, mainY + 97, 235, 222, 11, 11);
        this.drawTexturedModalRect(mainX + 156, mainY + 97, 235, 233, 11, 11);
        this.drawTexturedModalRect(mainX + 168, mainY + 97, 235, 244, 11, 11);

        //??6
        this.drawTexturedModalRect(mainX + 144, mainY + 112, 0, 236, 11, 11);
        this.drawTexturedModalRect(mainX + 156, mainY + 112, 0, 236, 11, 11);
        this.drawTexturedModalRect(mainX + 168, mainY + 112, 235, 244, 11, 11);

        //??1
        this.drawTexturedModalRect(mainX + 155, mainY + 126, 0, 236, 11, 11);
        this.drawTexturedModalRect(mainX + 167, mainY + 126, 0, 236, 11, 11);
        this.drawTexturedModalRect(mainX + 179, mainY + 126, 224, 222, 11, 11);

        //123
        this.drawTexturedModalRect(mainX + 144, mainY + 146, 224, 222, 11, 11);
        this.drawTexturedModalRect(mainX + 156, mainY + 146, 224, 233, 11, 11);
        this.drawTexturedModalRect(mainX + 168, mainY + 146, 224, 244, 11, 11);


        //親バッヂ
        if(dealer == 2)
        {
        	this.drawTexturedModalRect(mainX + 14 , mainY + 8, 0, 222, 14, 14);
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.info.dealer.txt", new Object[]{}), mainX + 17, mainY + 11, 0xffffffff);
        }else if(dealer == 1)
        {
        	this.drawTexturedModalRect(mainX + 14 , mainY + 163, 0, 222, 14, 14);
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.info.dealer.txt", new Object[]{}), mainX + 17, mainY + 166, 0xffffffff);
        }

    	this.mc.getTextureManager().bindTexture(IMGdice);

    	if(gamePhase != 0)
    	{
    		if(dice1 != -2)
    		{
		    	if(dice1 == -1)
		    	{
			    	Random rand = new Random();

			    	this.drawTexturedModalRect(mainX + 13 + 19 , mainY + 80, 0 + (21 * rand.nextInt(6)), 42, 21, 21);
			    	this.drawTexturedModalRect(mainX + 13 + 46 , mainY + 80, 0 + (21 * rand.nextInt(6)), 42, 21, 21);
			    	this.drawTexturedModalRect(mainX + 13 + 73 , mainY + 80, 0 + (21 * rand.nextInt(6)), 42, 21, 21);
		    	}else
		    	{
			    	this.drawTexturedModalRect(mainX + 13 + 19 , mainY + 80, 0 + (21 * (dice1 - 1)), 42, 21, 21);
			    	this.drawTexturedModalRect(mainX + 13 + 46 , mainY + 80, 0 + (21 * (dice2 - 1)), 42, 21, 21);
			    	this.drawTexturedModalRect(mainX + 13 + 73 , mainY + 80, 0 + (21 * (dice3 - 1)), 42, 21, 21);
		    	}
    		}
    	}


    	if(cpuDiceSet[0] > -1 && gamePhase != 0)
    	{
        	this.drawTexturedModalRect(mainX + 14 + 16 , mainY + 25, 0 + (21 * cpuDiceSet[0]), 42, 21, 21);
        	this.drawTexturedModalRect(mainX + 14 + 46, mainY + 25, 0 + (21 * cpuDiceSet[1]), 42, 21, 21);
        	this.drawTexturedModalRect(mainX + 14 + 76, mainY + 25, 0 + (21 * cpuDiceSet[2]), 42, 21, 21);
    	}

    	if(playerDiceSet[0] > -1 && gamePhase != 0)
    	{
        	this.drawTexturedModalRect(mainX + 14 + 16 , mainY + 180, 0 + (21 * playerDiceSet[0]), 42, 21, 21);
        	this.drawTexturedModalRect(mainX + 14 + 46, mainY + 180, 0 + (21 * playerDiceSet[1]), 42, 21, 21);
        	this.drawTexturedModalRect(mainX + 14 + 76, mainY + 180, 0 + (21 * playerDiceSet[2]), 42, 21, 21);
    	}

    	//this.buttonList.add(new GuiOptionButton(11, mainX + 125, mainY + 102, 40, 20, I18n.format("msg.casino.chinchiro.button.stop.txt", new Object[]{})));
    	if((gamePhase == 2 || gamePhase == 4) && !closeFlg)
    	{
    		this.buttonList.add(new GuiOptionButton(11, mainX + 49, mainY + 117, 40, 20, I18n.format("msg.casino.chinchiro.button.stop.txt", new Object[]{})));
    	}

    	if((gamePhase == 40) && !closeFlg)
    	{
    		//this.buttonList.add(new GuiOptionButton(41, mainX + 49, mainY + 117, 40, 20, I18n.format("!?", new Object[]{})));
    		this.buttonList.add(new GuiOptionButton(41, mainX + 14, mainY + 117, 50, 20, I18n.format("dqm.JSkill_0_12.btn", new Object[]{})));
    		this.buttonList.add(new GuiOptionButton(42, mainX + 74, mainY + 117, 50, 20, I18n.format("dqm.JSkill_0_12.btn2", new Object[]{})));
    	}

    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.info.rateChil.txt", new Object[]{}), mainX + 145, mainY + 128, 0xffffffff);

    	if(winner == 1)
    	{
    		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.sysinfo.3.txt", new Object[]{}), mainX + 16, mainY + 146, 0xffffffff);
    	}else if(winner == 2)
    	{
    		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.sysinfo.4.txt", new Object[]{}), mainX + 16, mainY + 146, 0xffffffff);
    	}else if(winner == 3)
    	{
    		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.sysinfo.5.txt", new Object[]{}), mainX + 16, mainY + 146, 0xffffffff);
    	}else if(msgPattern == 1)
    	{
    		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.sysinfo.0.txt", new Object[]{}), mainX + 16, mainY + 146, 0xffffffff);
    	}else if(msgPattern == 2)
    	{
    		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.sysinfo.1.txt", new Object[]{}), mainX + 16, mainY + 146, 0xffffffff);
    	}else if(msgPattern == 3)
    	{
    		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.sysinfo.2.txt", new Object[]{}), mainX + 16, mainY + 146, 0xffffffff);
    	}


    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.rate.1.txt", new Object[]{}), endX - 72 , mainY + 12, 0xffffffff);
    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.rate.2.txt", new Object[]{}), endX - 72 , mainY + 56, 0xffffffff);
    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.rate.3.txt", new Object[]{}), endX - 72 , mainY + 98, 0xffffffff);
    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.rate.4.txt", new Object[]{}), endX - 72 , mainY + 113, 0xffffffff);
    	//mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.rate.4.txt", new Object[]{}), endX - 64 , mainY + 113, 0xffffffff);
    	test = I18n.format("msg.casino.chinchiro.rate.6.txt", new Object[]{});
    	mc.fontRenderer.drawStringWithShadow(test, endX - 72 + 30 - (mc.fontRenderer.getStringWidth(test) / 2) , mainY + 141, 0xffffffff);
    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.rate.5.txt", new Object[]{}), endX - 72 , mainY + 151, 0xffffffff);

    	if(this.commandTextField != null && this.commandTextField.getText().length() > 0)
    	{
    		int bedCoin = Integer.parseInt(this.commandTextField.getText());
    		String msg2 = nfNum.format(bedCoin * 5);
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 12, 0xffffffff);
			msg2 = nfNum.format(bedCoin * 3);
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 56, 0xffffffff);
			msg2 = nfNum.format(bedCoin * 2);
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 98, 0xffffffff);
			msg2 = nfNum.format(bedCoin);
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 125, 0xffffffff);
			msg2 = "§c" + nfNum.format(bedCoin * 2);
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 151, 0xffffffff);

    	}else
    	{
			String msg2 = nfNum.format(0);
			//System.out.println("TEST : " + msg + " : " + endX + " : " + mc.fontRenderer.getStringWidth(msg) + " : " + (endX - 8 - mc.fontRenderer.getStringWidth(msg)));
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 12, 0xffffffff);
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 56, 0xffffffff);
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 98, 0xffffffff);
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 125, 0xffffffff);
			mc.fontRenderer.drawStringWithShadow("§c0", endX - 15 - mc.fontRenderer.getStringWidth(msg2), mainY + 151, 0xffffffff);
    	}

    	if(this.gamePhase == 0 || this.gamePhase == 99)
    	{
    		this.buttonList.add(new GuiOptionButton(6, endX - 40 - 10, endY - 30, 40, 20, I18n.format("msg.casino.blackjack.button.ready.txt", new Object[]{})));
    	}

    	int betTextStart = endX - 48 - 4 - 38;
    	int titleSize = mc.fontRenderer.getStringWidth(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}));

    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}), betTextStart - 4 - titleSize, endY - 25, 0xffffffff);


    	test = nfNum.format(this.myCoin);
    	mc.fontRenderer.drawStringWithShadow(test, endX - 15 - mc.fontRenderer.getStringWidth(test), endY - 48, 0xffffffff);

    	String myCoinTitle = I18n.format("msg.casino.chinchiro.info.mycoin.txt", new Object[]{});
    	mc.fontRenderer.drawStringWithShadow(myCoinTitle, endX - 73 - mc.fontRenderer.getStringWidth(myCoinTitle), endY - 48, 0xffffffff);



        if(this.commandTextField != null)
        {
        	this.commandTextField.xPosition = endX - 48 - 4 - 38;
        	this.commandTextField.yPosition = endY - 28;
        	this.commandTextField.setTextColor(0xffffffff);
        	this.commandTextField.drawTextBox();
        }else
        {
            this.commandTextField = new GuiTextField(this.fontRendererObj, endX - 48 - 4 - 38, endY - 28, 36, 16);
            this.commandTextField.setMaxStringLength(7);
            this.commandTextField.setEnabled(true);
            this.commandTextField.setFocused(true);

            this.commandTextField.setTextColor(0xffffffff);
        	this.commandTextField.drawTextBox();
        }

        if(gamePhase >= 98)
        {
        	int x = 0;

        	if(winner == 1)
        	{
        		this.mc.getTextureManager().bindTexture(textureWin);
        		x = 113;
        	}else if(winner == 2)
        	{
        		this.mc.getTextureManager().bindTexture(textureLose);
        		x = 145;
        	}else if(winner == 3)
        	{
        		this.mc.getTextureManager().bindTexture(textureDraw);
        		x = 117;
        	}

        	this.drawTexturedModalRect(halfX - (x / 2), halfY - 27, 0, 0, x, 55);
        }

        if(closeFlg)
        {
        	this.mc.getTextureManager().bindTexture(dialog);
        	this.drawTexturedModalRect(halfX - 89, halfY - 40, 0, 0, 178, 81);

           	String dialogMsg = I18n.format("msg.casino.dialog.info.1.txt", new Object[]{});
        	mc.fontRenderer.drawStringWithShadow(dialogMsg, halfX - (mc.fontRenderer.getStringWidth(dialogMsg) / 2), halfY -20, 0xffffffff);
        	dialogMsg = I18n.format("msg.casino.dialog.info.2.txt", new Object[]{});
        	mc.fontRenderer.drawStringWithShadow(dialogMsg, halfX - (mc.fontRenderer.getStringWidth(dialogMsg) / 2), halfY -10, 0xffffffff);

        	this.buttonList.add(new GuiOptionButton(1000, halfX - 89 + 25, halfY + 10, 60, 20, I18n.format("msg.casino.dialog.yes.txt", new Object[]{})));
        	this.buttonList.add(new GuiOptionButton(1001, halfX + 89 - 25 - 60, halfY + 10, 60, 20, I18n.format("msg.casino.dialog.no.txt", new Object[]{})));
        	//this.buttonList.add(new GuiOptionButton(91, bg2StartX + 8, endY - 28, endX - bg2StartX - 18, 20, I18n.format("msg.casino.bbg.button.start.txt", new Object[]{})));
        }else if(alartFlg)
        {
        	this.mc.getTextureManager().bindTexture(dialog);
        	this.drawTexturedModalRect(halfX - 89, halfY - 40, 0, 0, 178, 81);

        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.alart.1txt", new Object[]{}), halfX - 89 + 14, halfY -30, 0xffffffff);
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.alart.2txt", new Object[]{}), halfX - 89 + 14, halfY -20, 0xffffffff);
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.chinchiro.alart.3txt", new Object[]{}), halfX - 89 + 14, halfY -10, 0xffffffff);

        	this.buttonList.add(new GuiOptionButton(1002, halfX - 30, halfY + 10, 60, 20, I18n.format("msg.casino.dialog.ok.txt", new Object[]{})));
        	//this.buttonList.add(new GuiOptionButton(91, bg2StartX + 8, endY - 28, endX - bg2StartX - 18, 20, I18n.format("msg.casino.bbg.button.start.txt", new Object[]{})));
        }
    }


    protected void actionPerformed(GuiButton p_146284_1_)
    {
    	Random rand = new Random();


    	if(p_146284_1_.id == 1000)
    	{
    		this.mc.thePlayer.closeScreen();
    	}else if(p_146284_1_.id == 1001)
    	{
    		closeFlg = false;
    	}else if(p_146284_1_.id == 1002)
    	{
    		alartFlg = false;
    	}

    	if(p_146284_1_.id == 6)
    	{

    		if(this.commandTextField.getText().length() > 0 && Integer.parseInt(this.commandTextField.getText()) > 0)
    		{
    			int betCoin = Integer.parseInt(this.commandTextField.getText());

        		if(myCoin >= betCoin || DQR.debug > 0)
        		{
        			if(myCoin >= betCoin * 5)
        			{
    	    			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinMinus, betCoin * 5));
    	    			myCoin = myCoin - (betCoin * 5);

    	    			//this.primChusen();

    	    			for(int cnt = 0; cnt < 3; cnt++)
    	    			{
    	    				cpuDiceSet[cnt] = -1;
    	    				playerDiceSet[cnt] = -1;
    	    			}
    	    			msgPattern = -1;

    	    			playerHitCount = 0;
    	    			playerResult = null;
    	    			cpuResult = null;
    	    			winner = 0;
    	    			result123 = false;
    	    			resultBox = null;
    	    			ikasamaFlg = 0;

    	    			if(dealer != 2)
    	    			{
    	    				dealer = 2;
    	    			}else
    	    			{
    	    				dealer = 1;
    	    			}

    	    			if(dealer == 2)
    	    			{
    	    				gamePhase = 1;
        		    		ThreadCasinoCCR threadCCR = new ThreadCasinoCCR(epa, this, this.gamePhase, p_146284_1_.id);
        		    		threadCCR.start();
    	    			}else
    	    			{
    	    				gamePhase = 2;
    	    				msgPattern = 2;

    	    				dice1 = -1;
    	    				dice2 = -1;
    	    				dice3 = -1;
    	    			}
        			}else
        			{
        				alartFlg = true;
        			}

        		}

	    		//ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, this.gamePhase, p_146284_1_.id);
	    		//threadBJ.start();
    		}
    	}else if(p_146284_1_.id == 11)
    	{
    		if(dice1 == -1)
    		{
    			gamePhase = 3;
    			dice1 = rand.nextInt(6) + 1;
    			dice2 = rand.nextInt(6) + 1;
    			dice3 = rand.nextInt(6) + 1;

    			if(DQR.debug == 1)
    			{
    				if(debugKey == 59)
    				{
    					dice1 = 5;
    					dice2 = 4;
    					dice3 = 6;
    				}else if(debugKey == 54)
    				{
    					dice1 = 1;
    					dice2 = 3;
    					dice3 = 6;
    				}else if(debugKey == 60)
    				{
    					dice1 = 3;
    					dice2 = 4;
    					dice3 = 5;
    				}else if(debugKey == 60)
    				{
    					dice1 = 1;
    					dice2 = 1;
    					dice3 = 1;
    				}else if(debugKey == 61)
    				{
    					dice1 = 1;
    					dice2 = 2;
    					dice3 = 3;
    				}else if(debugKey == 62)
    				{
    					dice1 = 4;
    					dice2 = 2;
    					dice3 = 4;
    				}
    			}
	    		ThreadCasinoCCR threadCCR = new ThreadCasinoCCR(epa, this, this.gamePhase, p_146284_1_.id);
	    		threadCCR.start();
    		}

        	//ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
    		//threadBBG.start();
    	}else if(p_146284_1_.id == 41)
    	{
    		int mp = ExtendedPlayerProperties.get(epa).getMP();
			if(mp >= EnumDqmSkillJ.JSKILL_0_12.getNeedpt_Val())
			{
				this.epa.playSound("dqr:player.ikasama", 1.0F, 1.0F);
				PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.MPchange, EnumDqmSkillJ.JSKILL_0_12.getNeedpt_Val() * -1));
				gamePhase = 50;
				dice1 = rand.nextInt(3) + 4;
				dice2 = rand.nextInt(3) + 4;
				dice3 = rand.nextInt(3) + 4;

				/*
				if(DQR.debug == 1)
				{
					if(debugKey == 59)
					{
						dice1 = 5;
						dice2 = 4;
						dice3 = 6;
					}else if(debugKey == 60)
					{
						dice1 = 1;
						dice2 = 1;
						dice3 = 1;
					}else if(debugKey == 60)
					{
						dice1 = 3;
						dice2 = 4;
						dice3 = 5;
					}else if(debugKey == 60)
					{
						dice1 = 1;
						dice2 = 1;
						dice3 = 1;
					}else if(debugKey == 61)
					{
						dice1 = 1;
						dice2 = 2;
						dice3 = 3;
					}else if(debugKey == 62)
					{
						dice1 = 4;
						dice2 = 2;
						dice3 = 4;
					}

				}
				*/
	    		ThreadCasinoCCR threadCCR = new ThreadCasinoCCR(epa, this, this.gamePhase, p_146284_1_.id);
	    		threadCCR.start();
			}
        	//ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
    		//threadBBG.start();
    	}else if(p_146284_1_.id == 42)
		{
			gamePhase = 50;
    		ThreadCasinoCCR threadCCR = new ThreadCasinoCCR(epa, this, this.gamePhase, p_146284_1_.id);
    		threadCCR.start();
		}else
		{

		}


    }


    public boolean isAllowKey(int s) {
        return s == 211 || s == 213 || s == 215 || s == 214;

    }

    public boolean isNumber1(String s) {
        return Pattern.compile("^-?[0-9]+$").matcher(s).find();
    }


    public void doSoundPlay()
    {
    	if(soundPlay == 1)
    	{
    		epa.playSound("gui.button.press", 0.9F, 1.0F);
    	}else if(soundPlay == 2)
    	{
    		epa.playSound("dqr:player.casinowin", 1.0F, 1.0F);
    	}

    	soundPlay = -1;
    }
}
