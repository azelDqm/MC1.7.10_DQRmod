package dqr.gui.casino;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import dqr.api.enums.EnumDqmCasinoPKOdds;
import dqr.api.enums.EnumDqmCasinoSLOdds;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.api.enums.EnumDqmTrump;
import dqr.packetMessage.MessageServerFunction;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.ExtendedPlayerProperties5;

public class GuiCasinoSLGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr", "textures/casino/sl_background.png");
    private static final ResourceLocation texture2 = new ResourceLocation("dqr", "textures/casino/sl_background2.png");

    private static final ResourceLocation textureWin = new ResourceLocation("dqr", "textures/casino/Result_Win.png");
    private static final ResourceLocation textureLose = new ResourceLocation("dqr", "textures/casino/Result_Lose.png");
    private static final ResourceLocation textureDraw = new ResourceLocation("dqr", "textures/casino/Result_Draw.png");

    private static final ResourceLocation textureReal0 = new ResourceLocation("dqr", "textures/casino/sl_real_0.png");
    private static final ResourceLocation textureReal1 = new ResourceLocation("dqr", "textures/casino/sl_real_1.png");
    private static final ResourceLocation textureReal2 = new ResourceLocation("dqr", "textures/casino/sl_real_2.png");
    private static final ResourceLocation textureReal3 = new ResourceLocation("dqr", "textures/casino/sl_real_3.png");

    private static final ResourceLocation textureReal_back = new ResourceLocation("dqr", "textures/casino/sl_real_back.png");
    private static final ResourceLocation textureReal_temp = new ResourceLocation("dqr", "textures/casino/sl_real_X1.png");

    private static final ResourceLocation dialog = new ResourceLocation("dqr", "textures/casino/dialog.png");

    private static final int sBig7 = 1;
    private static final int sBigX = 2;
    private static final int sBar = 3;
    private static final int sCherry = 4;
    private static final int sReplay = 5;
    private static final int sBell = 6;
    private static final int sSuika = 7;


    public GuiTextField commandTextField;
    private EntityPlayer epa;
    private int mode = 0;
    public LinkedHashMap<Integer, EnumDqmTrump> trumpSet;
    //public int playerAceBigCounter = 0;
    //public LinkedHashMap<Integer, EnumDqmTrump> trumpSetDeal;
    //public ArrayList<EnumDqmTrump> trumpDeck;
    //public int[] trumpDeckRev;
    public int gamePhase = 0;
    public int myCoin = 0;
    public int myBet = 1;

    //0:無し 1:通常 2:BlackJack 3:BURST 4:PureBJ
    public int playerStatus = 0;
    public int dealerStatus = 0;

    //10:敗北 11:勝利 12:DRAW
    //public int gameResult = 0;
    public EnumDqmCasinoPKOdds gameResult = null;

    public int realTick1 = 96;
    public int realSlide1 = 0;
    public int realTick2 = 48;
    public int realSlide2 = 0;
    public int realTick3 = 0;
    public int realSlide3 = 0;

    public int realTick1B = 96;
    public int realSlide1B = 0;
    public int realTick2B = 48;
    public int realSlide2B = 0;
    public int realTick3B = 0;
    public int realSlide3B = 0;

    public int realTick1C = 96;
    public int realSlide1C = 0;
    public int realTick2C = 48;
    public int realSlide2C = 0;
    public int realTick3C = 0;
    public int realSlide3C = 0;

    public float realSpeed = 4;
    public int speedSetting = 2;
    public int realBasePosFix1 = 46;
    public int realBasePosFix2 = 99;
    public int realBasePosFix3 = 152;

    /*
    public int realBasePosFixY1 = 16;
    public int realBasePosFixY2 = 65;
    public int realBasePosFixY3 = 114;
    */
    public int realBasePosFixY1 = 40;
    public int realBasePosFixY2 = 89;
    public int realBasePosFixY3 = 138;

    public int buttonBasePosFixY = 28;

    public int realStop1 = 1;
    public int realStop2 = 1;
    public int realStop3 = 1;

    public int realSuberi1 = 0;
    public int realSuberi2 = 0;
    public int realSuberi3 = 0;

    public int[] real1 = new int[]{6, 5, 2, 4, 1, 5, 6, 7, 6, 3, 5, 6, 1, 4, 3, 6, 5, 6, 5, 7};
    public int[] real2 = new int[]{6, 5, 3, 2, 1, 6, 5, 6, 7, 5, 1, 3, 6, 5, 7, 6, 7, 5, 2, 4};
    public int[] real3 = new int[]{7, 5, 6, 5, 1, 4, 2, 6, 5, 7, 5, 6, 3, 5, 1, 6, 5, 6, 2, 3};

    public int koyakuFlg = -1;
    public int bonusFlg = -1;
    public int kokutiFlg = -1;
    public int hitKoyaku = -1;

    public int koyakuLine1 = 0;
    public int koyakuLine2 = 0;
    public int koyakuLine3 = 0;
    public int koyakuLine4 = 0;
    public int koyakuLine5 = 0;

    public int rotate = 0;
    public int totalRotate = 0;
    public boolean bonusKokutiSound = false;

    public boolean closeFlg = false;
    public GuiCasinoSLGuiContainer(EntityPlayer player)
    {

        super(new GuiCasinoSLContainer(player));
        this.epa = player;
    	//NBTTagCompound playerPet = ExtendedPlayerProperties3.get(player).getNBTPlayerPetList();
    	//Set tags = playerPet.func_150296_c();

    	myCoin = ExtendedPlayerProperties3.get(player).getCoin();

        this.ySize = 222;
        this.xSize = 384;

    	playerStatus = 0;
    	dealerStatus = 0;
    	//trumpSet = new LinkedHashMap<Integer, EnumDqmTrump>();
    	//trumpDeck = new ArrayList<EnumDqmTrump>();

    	/*
    	EnumDqmTrump[] data = EnumDqmTrump.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(14 > data[cnt].getValue()&& data[cnt].getValue() > 0)
    		{
    			trumpDeck.add(data[cnt]);
    		}
    	}

    	trumpDeck.add(EnumDqmTrump.JK1);
    	*/
    }

    public void initGui()
    {

    	super.initGui();
    }

    protected void keyTyped(char p_73869_1_, int p_73869_2_)
    {

    	//System.out.println("TEST" + p_73869_2_ + " / " + p_73869_1_);

    	if(DQR.debug != 0)
    	{
	    	if(p_73869_2_ == 79)
	    	{
	    		bonusFlg = 1;
	    	}else if(p_73869_2_ == 80)
	    	{
	    		bonusFlg = 2;
	    	}else if(p_73869_2_ == 81)
	    	{
	    		koyakuFlg = 4;
	    	}else if(p_73869_2_ == 75)
	    	{
	    		koyakuFlg = 5;
	    	}else if(p_73869_2_ == 76)
	    	{
	    		koyakuFlg = 6;
	    	}else if(p_73869_2_ == 77)
	    	{
	    		koyakuFlg = 7;
	    	}
    	}


    	if(realStop1 != 1 || realStop2 != 1 || realStop3 != 1)
    	{
        	if(p_73869_2_ == 1 || p_73869_2_ == this.mc.gameSettings.keyBindInventory.getKeyCode())
        	{
        		//epa.openGui(DQR.instance, DQR.conf.GuiID_CSSlot, epa.worldObj, (int)epa.posX, (int)epa.posY, (int)epa.posZ);
        		//System.out.println("TEST:" + p_73869_1_ + "/" + p_73869_2_);
    			closeFlg = true;
    			return;
        	}
    	}

    	if(p_73869_2_ == 200)
    	{
    		this.actionPerformed(new GuiOptionButton(9, 0, 0, 0, 0, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
    	}else if(p_73869_2_ == 203)
    	{
    		this.actionPerformed(new GuiOptionButton(10, 0, 0, 0, 0, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
    	}else if(p_73869_2_ == 208)
    	{
    		this.actionPerformed(new GuiOptionButton(11, 0, 0, 0, 0, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
    	}else if(p_73869_2_ == 205)
    	{
    		this.actionPerformed(new GuiOptionButton(12, 0, 0, 0, 0, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
    	}else if(p_73869_2_ == 57)
    	{
    		if(realStop1 == 1 && realStop2 == 1 && realStop3 == 1)
    		{
    			this.actionPerformed(new GuiOptionButton(9, 0, 0, 0, 0, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
    		}else
    		{
    			if(realStop1 == 0)
    			{
    				this.actionPerformed(new GuiOptionButton(10, 0, 0, 0, 0, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
    			}else if(realStop2 == 0)
    			{
    				this.actionPerformed(new GuiOptionButton(11, 0, 0, 0, 0, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
    			}else if(realStop3 == 0)
    			{
    				this.actionPerformed(new GuiOptionButton(12, 0, 0, 0, 0, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
    			}
    		}
    	}

    	/*
    	if(this.gamePhase == 0)
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
    	}
    	*/

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
    	NumberFormat nfNum = NumberFormat.getNumberInstance();

    	//System.out.println("PHASE :" + this.gamePhase);
    	int mainX = (this.width - this.xSize) / 2;
    	int mainY = (this.height - this.ySize) / 2;
    	int halfX = (this.width - this.xSize) / 2 + (this.xSize / 2);
    	int halfY = (this.height - this.ySize) / 2 + (this.ySize / 2);
    	int endX = (this.width - this.xSize) / 2 + this.xSize;
    	int endY = (this.height - this.ySize) / 2 + this.ySize;

    	int bg2StartX = mainX + 251;
    	buttonList = new ArrayList();
    	//this.buttonList.add(new GuiOptionButton(1, x + 7, y + 117, 10, 20, "<"));

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //System.out.println("width:" + this.width + " / height:" + this.height + " / xSize:" + this.xSize + " / ySize:" + this.ySize);

        this.mc.getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(mainX, mainY, 0, 0, 256, this.ySize);

        this.mc.getTextureManager().bindTexture(texture2);
        this.drawTexturedModalRect(mainX + 251, mainY, 0, 0, 137, this.ySize);

        //リール背景
        this.mc.getTextureManager().bindTexture(textureReal_back);
        this.drawTexturedModalRect(mainX + realBasePosFix1 - 2, mainY + realBasePosFixY1 - 1, 0, 0, 52, 148);
        this.drawTexturedModalRect(mainX + realBasePosFix2 - 2, mainY + realBasePosFixY1 - 1, 0, 0, 52, 148);
        this.drawTexturedModalRect(mainX + realBasePosFix3 - 2, mainY + realBasePosFixY1 - 1, 0, 0, 52, 148);

        //this.drawHorizontalLine(mainX + realBasePosFix1, mainY + realBasePosFixY1 + 24, mainX + realBasePosFix3 + 48, mainY + realBasePosFixY1 + 24);

        //this.mc.getTextureManager().bindTexture(textureReal_back);
        this.drawTexturedModalRect(mainX + 14, mainY + realBasePosFixY1 + 24 - 7 - 1, 97, 17, 23, 15);
        this.drawTexturedModalRect(mainX + 14, mainY + realBasePosFixY2 + 24 - 7 - 1, 97, 17, 23, 15);
        this.drawTexturedModalRect(mainX + 14, mainY + realBasePosFixY3 + 24 - 7 - 1, 97, 17, 23, 15);

        //this.drawTexturedModalRect(mainX + 14, mainY + realBasePosFixY1 + 24 - 7 - 1, 97, 17, 23, 15);

        this.drawTexturedModalRect(mainX + 20, mainY + realBasePosFixY1 - 7 - 1, 101, 32, 16, 16);
        this.drawTexturedModalRect(mainX + 20, mainY + realBasePosFixY3 + 48 + 7 - 16 - 1, 103, 0, 16, 16);

        //成立子役ライン
        //this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY1 , 68, 58, 154, 146);
        if(koyakuLine1 == 1)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY1 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY1 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY1 , 174, 5, 48, 48);
        }

        if(koyakuLine2 == 1)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY2 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY2 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY2 , 174, 5, 48, 48);
        }

        if(koyakuLine3 == 1)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY3 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY3 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY3 , 174, 5, 48, 48);
        }

        if(koyakuLine4 == 1)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY1 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY2 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY3 , 174, 5, 48, 48);
        }

        if(koyakuLine5 == 1)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY3 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY2 , 174, 5, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY1 , 174, 5, 48, 48);
        }


        //quvtujevuqepmq
        if(koyakuLine1 == 99)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY1 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY1 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY1 , 174, 58, 48, 48);
        }

        if(koyakuLine2 == 99)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY2 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY2 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY2 , 174, 58, 48, 48);
        }

        if(koyakuLine3 == 99)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY3 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY3 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY3 , 174, 58, 48, 48);
        }

        if(koyakuLine4 == 991)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY1 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY2 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY3 , 174, 58, 48, 48);
        }

        if(koyakuLine5 == 99)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY3 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY2 , 174, 58, 48, 48);
        	this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY1 , 174, 58, 48, 48);
        }


        //告知
        this.mc.getTextureManager().bindTexture(textureReal_temp);
        if(kokutiFlg == 1)
        {
        	this.drawTexturedModalRect(mainX + realBasePosFix2 + 11, mainY + 5, 144, 0, 24, 24);
        }else if(kokutiFlg == 3)
        {
            //はぐメタ
            this.drawTexturedModalRect(mainX + realBasePosFix2 + 11, mainY + 5, 144, 48, 24, 24);
        }else if(kokutiFlg == 7)
        {
            //ゴールデン
            this.drawTexturedModalRect(mainX + realBasePosFix2 + 11, mainY + 11, 144, 144, 24, 24);
        }else if(kokutiFlg == 6)
        {
            //ナイト
            this.drawTexturedModalRect(mainX + realBasePosFix2 + 11, mainY + 5, 144, 120, 24, 24);
        }else if(kokutiFlg == 5)
        {
            //ホイミスライム
            this.drawTexturedModalRect(mainX + realBasePosFix2 + 11, mainY + 5, 144, 96, 24, 24);
        }else if(kokutiFlg == 10 || kokutiFlg == 11)
        {
            //ベス
            this.drawTexturedModalRect(mainX + realBasePosFix2 + 11, mainY + 5, 144, 72, 24, 24);
        }

        this.drawTexturedModalRect(mainX + realBasePosFix2 + 8, mainY + 5, 194, 0, 32, 34);

        /*
        this.buttonList.add(new GuiOptionButton(1000, mainX + realBasePosFix1 - 36, endY - buttonBasePosFixY  -20, 32, 20, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
        this.buttonList.add(new GuiOptionButton(1001, mainX + realBasePosFix1 - 36, endY - buttonBasePosFixY  -40, 32, 20, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));
		*/

        this.buttonList.add(new GuiOptionButton(9, mainX + realBasePosFix1 - 36, endY - buttonBasePosFixY, 32, 20, I18n.format("msg.casino.slot.button.start.txt", new Object[]{})));

        if(realStop1 == 0)
        {
        	this.buttonList.add(new GuiOptionButton(10, mainX + realBasePosFix1, endY - buttonBasePosFixY, 48, 20, I18n.format("msg.casino.slot.button.stop.txt", new Object[]{})));
        }else
        {
        	this.buttonList.add(new GuiOptionButton(10, mainX + realBasePosFix1, endY - buttonBasePosFixY, 48, 20, I18n.format("msg.casino.slot.button.stop0.txt", new Object[]{})));
        }

        if(realStop1 == 0)
        {
        	this.buttonList.add(new GuiOptionButton(11, mainX + realBasePosFix2, endY - buttonBasePosFixY, 48, 20, I18n.format("msg.casino.slot.button.stop0.txt", new Object[]{})));
        	this.buttonList.add(new GuiOptionButton(12, mainX + realBasePosFix3, endY - buttonBasePosFixY, 48, 20, I18n.format("msg.casino.slot.button.stop0.txt", new Object[]{})));
        }else
        {
        	if((realStop3 == 0 || realStop3 == 1) && realStop2 == 0)
        	{
        		this.buttonList.add(new GuiOptionButton(11, mainX + realBasePosFix2, endY - buttonBasePosFixY, 48, 20, I18n.format("msg.casino.slot.button.stop.txt", new Object[]{})));
        	}else
        	{
        		this.buttonList.add(new GuiOptionButton(11, mainX + realBasePosFix2, endY - buttonBasePosFixY, 48, 20, I18n.format("msg.casino.slot.button.stop0.txt", new Object[]{})));
        	}

        	if((realStop2 == 0 || realStop2 == 1) && realStop3 == 0)
        	{
        		this.buttonList.add(new GuiOptionButton(12, mainX + realBasePosFix3, endY - buttonBasePosFixY, 48, 20, I18n.format("msg.casino.slot.button.stop.txt", new Object[]{})));
        	}else
        	{
        		this.buttonList.add(new GuiOptionButton(12, mainX + realBasePosFix3, endY - buttonBasePosFixY, 48, 20, I18n.format("msg.casino.slot.button.stop0.txt", new Object[]{})));
        	}
        }


    	int betTextStart = endX - 45;
    	int titleSize = mc.fontRenderer.getStringWidth(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}));
    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}), betTextStart - (titleSize / 2), mainY + 184, 0xffffffff);


    	betTextStart = endX - 124;
    	titleSize = mc.fontRenderer.getStringWidth(I18n.format("msg.casino.slot.info.speed.txt", new Object[]{}));

    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.slot.info.speed.txt", new Object[]{}), betTextStart - (titleSize / 2), mainY + 184, 0xffffffff);



    	String test = nfNum.format(this.myCoin);
    	mc.fontRenderer.drawStringWithShadow(test, bg2StartX + 118 - 4 - mc.fontRenderer.getStringWidth(test), mainY + 156, 0xffffffff);

    	String myCoinTitle = I18n.format("msg.casino.blackjack.info.mycoin.txt", new Object[]{});
    	mc.fontRenderer.drawStringWithShadow(myCoinTitle, bg2StartX + 58 - 4 - mc.fontRenderer.getStringWidth(myCoinTitle), mainY + 156, 0xffffffff);

    	test = nfNum.format(this.myBet);
    	mc.fontRenderer.drawStringWithShadow(test, bg2StartX + 103 - 4 - mc.fontRenderer.getStringWidth(test), mainY + 199, 0xffffffff);

    	test = nfNum.format((int)(this.speedSetting + 1));
    	mc.fontRenderer.drawStringWithShadow(test, bg2StartX + 16 - 4 - mc.fontRenderer.getStringWidth(test), mainY + 199, 0xffffffff);

    	test = nfNum.format(this.rotate);
    	mc.fontRenderer.drawStringWithShadow(test, mainX + 92 - mc.fontRenderer.getStringWidth(test), mainY + 23, 0xffffffff);

    	test = nfNum.format(this.totalRotate);
    	mc.fontRenderer.drawStringWithShadow(test, mainX + 198 - mc.fontRenderer.getStringWidth(test), mainY + 23, 0xffffffff);

    	betTextStart = mainX + 66;
    	titleSize = mc.fontRenderer.getStringWidth(I18n.format("msg.casino.slot.rotate.txt", new Object[]{}));
    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.slot.rotate.txt", new Object[]{}), betTextStart - (titleSize / 2), mainY + 10, 0xffffffff);

    	betTextStart = mainX + 172;
    	titleSize = mc.fontRenderer.getStringWidth(I18n.format("msg.casino.slot.totalrotate.txt", new Object[]{}));
    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.slot.totalrotate.txt", new Object[]{}), betTextStart - (titleSize / 2), mainY + 10, 0xffffffff);
//v,psjrv


		String msg2 = nfNum.format(this.myBet * EnumDqmCasinoSLOdds.BIG1.getOdds());
		if(hitKoyaku == 1 || hitKoyaku == 2)
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 0), 0xffffff00);
		}else
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 0), 0xffffffff);
		}

		msg2 = nfNum.format(this.myBet * EnumDqmCasinoSLOdds.REGULAR.getOdds());
		if(hitKoyaku == EnumDqmCasinoSLOdds.REGULAR.getId())
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 1), 0xffffff00);
		}else
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 1), 0xffffffff);
		}

		msg2 = nfNum.format(this.myBet * EnumDqmCasinoSLOdds.SUIKA.getOdds());
		if(hitKoyaku == EnumDqmCasinoSLOdds.SUIKA.getId())
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 2), 0xffffff00);
		}else
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 2), 0xffffffff);
		}

		msg2 = nfNum.format(this.myBet * EnumDqmCasinoSLOdds.BELL.getOdds());
		if(hitKoyaku == EnumDqmCasinoSLOdds.BELL.getId())
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 3), 0xffffff00);
		}else
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 3), 0xffffffff);
		}

		msg2 = nfNum.format(this.myBet * EnumDqmCasinoSLOdds.CHERRY2.getOdds());
		if(hitKoyaku == EnumDqmCasinoSLOdds.CHERRY.getId())
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 4), 0xffffff00);
		}else
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 4), 0xffffffff);
		}

		msg2 = nfNum.format(this.myBet * EnumDqmCasinoSLOdds.REPLAY.getOdds());
		if(hitKoyaku == EnumDqmCasinoSLOdds.REPLAY.getId())
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 5), 0xffffff00);
		}else
		{
			mc.fontRenderer.drawStringWithShadow(msg2, endX - 18 - mc.fontRenderer.getStringWidth(msg2), mainY + 54 + (16 * 5), 0xffffffff);
		}

        this.buttonList.add(new GuiOptionButton(90, mainX + 309, mainY + 194, 12, 20, I18n.format("<", new Object[]{})));
        this.buttonList.add(new GuiOptionButton(91, mainX + 359, mainY + 194, 12, 20, I18n.format(">", new Object[]{})));

        this.buttonList.add(new GuiOptionButton(92, mainX + 236, mainY + 194, 12, 20, I18n.format("<", new Object[]{})));
        this.buttonList.add(new GuiOptionButton(93, mainX + 271, mainY + 194, 12, 20, I18n.format(">", new Object[]{})));


        if(realStop1 == 0)
        {
	        realTick1 = (int)(realTick1 + realSpeed);
	        if(192 - realTick1 <= 0)
	        {
	        	realTick1 = 0;
	        	realSlide1 = realSlide1 + 1;
	        	if(realSlide1 > 4)
	        	{
	        		realSlide1 = 0;
	        	}
	        }
        }else
        {
        	if(realSuberi1 > 0)
        	{
	        	if(realSpeed < realSuberi1)
	        	{
			        realTick1 = (int)(realTick1 + realSpeed);
			        if(192 - realTick1 <= 0)
			        {
			        	realTick1 = 0;
			        	realSlide1 = realSlide1 + 1;
			        	if(realSlide1 > 4)
			        	{
			        		realSlide1 = 0;
			        	}
			        }
	        	}else
	        	{
	        		//realSuberi1 = 0;
			        realTick1 = (int)(realTick1 + realSuberi1);
			        if(192 - realTick1 <= 0)
			        {
			        	realTick1 = 0;
			        	realSlide1 = realSlide1 + 1;
			        	if(realSlide1 > 4)
			        	{
			        		realSlide1 = 0;
			        	}
			        }

			        //System.out.println("TEST" + realTick1);
	        	}
        	}
        }

        this.mc.getTextureManager().bindTexture(textureReal1);
        this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY1, realSlide1 * 48, 192 - realTick1, 48, 48);


        if(realStop1 == 0)
        {
	        realTick2 = (int)(realTick2 + realSpeed);
	        if(192 - realTick2 <= 0)
	        {
	        	realTick2 = 0;
	        	realSlide2 = realSlide2 + 1;
	        	if(realSlide2 > 4)
	        	{
	        		realSlide2 = 0;
	        	}
	        }
        }else
        {
        	if(realSuberi1 > 0)
        	{
	        	if(realSpeed < realSuberi1)
	        	{
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;
			        realTick2 = (int)(realTick2 + realSpeed);
			        if(192 - realTick2 <= 0)
			        {
			        	realTick2 = 0;
			        	realSlide2 = realSlide2 + 1;
			        	if(realSlide2 > 4)
			        	{
			        		realSlide2 = 0;
			        	}
			        }
	        	}else
	        	{
	        		//realSuberi1 = 0;
			        realTick2 = (int)(realTick2 + realSuberi1);
			        if(192 - realTick2 <= 0)
			        {
			        	realTick2 = 0;
			        	realSlide2 = realSlide2 + 1;
			        	if(realSlide2 > 4)
			        	{
			        		realSlide2 = 0;
			        	}
			        }
			        //System.out.println("TEST" + realTick2);
	        	}
        	}
        }

        this.mc.getTextureManager().bindTexture(textureReal1);
        this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY2, realSlide2 * 48, 192 - realTick2, 48, 48);


        if(realStop1 == 0)
        {
	        realTick3 = (int)(realTick3 + realSpeed);
	        if(192 - realTick3 <= 0)
	        {
	        	realTick3 = 0;
	        	realSlide3 = realSlide3 + 1;
	        	if(realSlide3 > 4)
	        	{
	        		realSlide3 = 0;
	        	}
	        }
        }else
        {
        	if(realSuberi1 > 0)
        	{
	        	if(realSpeed < realSuberi1)
	        	{
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;
			        realTick3 = (int)(realTick3 + realSpeed);
	        		realSuberi1 = realSuberi1 - (int)realSpeed;

			        if(192 - realTick3 <= 0)
			        {
			        	realTick3 = 0;
			        	realSlide3 = realSlide3 + 1;
			        	if(realSlide3 > 4)
			        	{
			        		realSlide3 = 0;
			        	}
			        }
	        	}else
	        	{
			        realTick3 = (int)(realTick3 + realSuberi1);
	        		realSuberi1 = 0;
	        		realStop1 = 1;
			        if(192 - realTick3 <= 0)
			        {
			        	realTick3 = 0;
			        	realSlide3 = realSlide3 + 1;
			        	if(realSlide3 > 4)
			        	{
			        		realSlide3 = 0;
			        	}
			        }
			        //System.out.println("TEST" + realTick3);
	        	}
        	}else
        	{
        		realStop1 = 1;
        	}
        }
        this.mc.getTextureManager().bindTexture(textureReal1);
        this.drawTexturedModalRect(mainX + realBasePosFix1, mainY + realBasePosFixY3, realSlide3 * 48, 192 - realTick3, 48, 48);






        if(realStop2 == 0)
        {
	        realTick1B = (int)(realTick1B + realSpeed);
	        if(192 - realTick1B <= 0)
	        {
	        	realTick1B = 0;
	        	realSlide1B = realSlide1B + 1;
	        	if(realSlide1B > 4)
	        	{
	        		realSlide1B = 0;
	        	}
	        }
        }else
        {
        	if(realSuberi2 > 0)
        	{
	        	if(realSpeed < realSuberi2)
	        	{
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;
			        realTick1B = (int)(realTick1B + realSpeed);
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;

			        if(192 - realTick1B <= 0)
			        {
			        	realTick1B = 0;
			        	realSlide1B = realSlide1B + 1;
			        	if(realSlide1B > 4)
			        	{
			        		realSlide1B = 0;
			        	}
			        }
	        	}else
	        	{
			        realTick1B = (int)(realTick1B + realSuberi2);
	        		//realSuberi1 = 0;
			        if(192 - realTick1B <= 0)
			        {
			        	realTick1B = 0;
			        	realSlide1B = realSlide1B + 1;
			        	if(realSlide1B > 4)
			        	{
			        		realSlide1B = 0;
			        	}
			        }
			        //System.out.println("TEST" + realTick3);
	        	}
        	}
        }
        this.mc.getTextureManager().bindTexture(textureReal2);
        this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY1, realSlide1B * 48, 192 - realTick1B, 48, 48);


        if(realStop2 == 0)
        {
	        realTick2B = (int)(realTick2B + realSpeed);
	        if(192 - realTick2B <= 0)
	        {
	        	realTick2B = 0;
	        	realSlide2B = realSlide2B + 1;
	        	if(realSlide2B > 4)
	        	{
	        		realSlide2B = 0;
	        	}
	        }
        }else
        {
        	if(realSuberi2 > 0)
        	{
	        	if(realSpeed < realSuberi2)
	        	{
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;
			        realTick2B = (int)(realTick2B + realSpeed);
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;

			        if(192 - realTick2B <= 0)
			        {
			        	realTick2B = 0;
			        	realSlide2B = realSlide2B + 1;
			        	if(realSlide2B > 4)
			        	{
			        		realSlide2B = 0;
			        	}
			        }
	        	}else
	        	{
			        realTick2B = (int)(realTick2B + realSuberi2);
	        		//realSuberi1 = 0;
			        if(192 - realTick2B <= 0)
			        {
			        	realTick2B = 0;
			        	realSlide2B = realSlide2B + 1;
			        	if(realSlide2B > 4)
			        	{
			        		realSlide2B = 0;
			        	}
			        }
			        //System.out.println("TEST" + realTick3);
	        	}
        	}
        }

        this.mc.getTextureManager().bindTexture(textureReal2);
        this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY2, realSlide2B * 48, 192 - realTick2B, 48, 48);


        if(realStop2 == 0)
        {
	        realTick3B = (int)(realTick3B + realSpeed);
	        if(192 - realTick3B <= 0)
	        {
	        	realTick3B = 0;
	        	realSlide3B = realSlide3B + 1;
	        	if(realSlide3B > 4)
	        	{
	        		realSlide3B = 0;
	        	}
	        }
        }else
        {
        	if(realSuberi2 > 0)
        	{
	        	if(realSpeed < realSuberi2)
	        	{
	        		//realSuberi1B = realSuberi1 - (int)realSpeed;
			        realTick3B = (int)(realTick3B + realSpeed);
	        		realSuberi2 = realSuberi2 - (int)realSpeed;

			        if(192 - realTick3B <= 0)
			        {
			        	realTick3B = 0;
			        	realSlide3B = realSlide3B + 1;
			        	if(realSlide3B > 4)
			        	{
			        		realSlide3B = 0;
			        	}
			        }
	        	}else
	        	{
			        realTick3B = (int)(realTick3B + realSuberi2);
	        		realSuberi2 = 0;
	        		realStop2 = 1;
			        if(192 - realTick3B <= 0)
			        {
			        	realTick3B = 0;
			        	realSlide3B = realSlide3B + 1;
			        	if(realSlide3B > 4)
			        	{
			        		realSlide3B = 0;
			        	}
			        }
			        //System.out.println("TEST" + realTick3);
	        	}
        	}else
        	{
        		realStop2 = 1;
        	}
        }
        this.mc.getTextureManager().bindTexture(textureReal2);
        this.drawTexturedModalRect(mainX + realBasePosFix2, mainY + realBasePosFixY3, realSlide3B * 48, 192 - realTick3B, 48, 48);


        /*
        this.mc.getTextureManager().bindTexture(textureReal0);
        this.drawTexturedModalRect(mainX + 68, mainY + 16, realSlide1 * 48, 0 + realTick1, 48, 48);

        realTick1 = (int)(realTick1 + realSpeed);
        if(realTick1 >= 192)
        {
        	realTick1 = 0;
        	realSlide1 = realSlide1 + 1;
        	if(realSlide1 > 4)
        	{
        		realSlide1 = 0;
        	}
        }


        this.mc.getTextureManager().bindTexture(textureReal0);
        this.drawTexturedModalRect(mainX + 68, mainY + 64, realSlide2 * 48, 0 + realTick2, 48, 48);

        realTick2 = (int)(realTick2 + realSpeed);
        if(realTick2 >= 192)
        {
        	realTick2 = 0;
        	realSlide2 = realSlide2 + 1;
        	if(realSlide2 > 4)
        	{
        		realSlide2 = 0;
        	}
        }

        this.mc.getTextureManager().bindTexture(textureReal0);
        this.drawTexturedModalRect(mainX + 68, mainY + 112, realSlide3 * 48, 0 + realTick3, 48, 48);

        realTick3 = (int)(realTick3 + realSpeed);
        if(realTick3 >= 192)
        {
        	realTick3 = 0;
        	realSlide3 = realSlide3 + 1;
        	if(realSlide3 > 4)
        	{
        		realSlide3 = 0;
        	}
        }
*/

        /*
        if(realStop3 == 0)
        {
	        realTick1C = (int)(realTick1C + realSpeed);
	        if(192 - realTick1C <= 0)
	        {
	        	realTick1C = 0;
	        	realSlide1C = realSlide1C + 1;
	        	if(realSlide1C > 4)
	        	{
	        		realSlide1C = 0;
	        	}
	        }
        }
        */
        if(realStop3 == 0)
        {
	        realTick1C = (int)(realTick1C + realSpeed);
	        if(192 - realTick1C <= 0)
	        {
	        	realTick1C = 0;
	        	realSlide1C = realSlide1C + 1;
	        	if(realSlide1C > 4)
	        	{
	        		realSlide1C = 0;
	        	}
	        }
        }else
        {
        	if(realSuberi3 > 0)
        	{
	        	if(realSpeed < realSuberi3)
	        	{
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;
			        realTick1C = (int)(realTick1C + realSpeed);
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;

			        if(192 - realTick1C <= 0)
			        {
			        	realTick1C = 0;
			        	realSlide1C = realSlide1C + 1;
			        	if(realSlide1C > 4)
			        	{
			        		realSlide1C = 0;
			        	}
			        }
	        	}else
	        	{
			        realTick1C = (int)(realTick1C + realSuberi3);
	        		//realSuberi1 = 0;
			        if(192 - realTick1C <= 0)
			        {
			        	realTick1C = 0;
			        	realSlide1C = realSlide1C + 1;
			        	if(realSlide1C > 4)
			        	{
			        		realSlide1C = 0;
			        	}
			        }
			        //System.out.println("TEST" + realTick3);
	        	}
        	}
        }
        this.mc.getTextureManager().bindTexture(textureReal3);
        this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY1, realSlide1C * 48, 192 - realTick1C, 48, 48);



        if(realStop3 == 0)
        {
	        realTick2C = (int)(realTick2C + realSpeed);
	        if(192 - realTick2C <= 0)
	        {
	        	realTick2C = 0;
	        	realSlide2C = realSlide2C + 1;
	        	if(realSlide2C > 4)
	        	{
	        		realSlide2C = 0;
	        	}
	        }
        }else
        {
        	if(realSuberi3 > 0)
        	{
	        	if(realSpeed < realSuberi3)
	        	{
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;
			        realTick2C = (int)(realTick2C + realSpeed);
	        		//realSuberi1 = realSuberi1 - (int)realSpeed;

			        if(192 - realTick2C <= 0)
			        {
			        	realTick2C = 0;
			        	realSlide2C = realSlide2C + 1;
			        	if(realSlide2C > 4)
			        	{
			        		realSlide2C = 0;
			        	}
			        }
	        	}else
	        	{
			        realTick2C = (int)(realTick2C + realSuberi3);
	        		//realSuberi1 = 0;
			        if(192 - realTick2C <= 0)
			        {
			        	realTick2C = 0;
			        	realSlide2C = realSlide2C + 1;
			        	if(realSlide2C > 4)
			        	{
			        		realSlide2C = 0;
			        	}
			        }
			        //System.out.println("TEST" + realTick3);
	        	}
        	}
        }
        this.mc.getTextureManager().bindTexture(textureReal3);
        this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY2, realSlide2C * 48, 192 - realTick2C, 48, 48);


        if(realStop3 == 0)
        {
	        realTick3C = (int)(realTick3C + realSpeed);
	        if(192 - realTick3C <= 0)
	        {
	        	realTick3C = 0;
	        	realSlide3C = realSlide3C + 1;
	        	if(realSlide3C > 4)
	        	{
	        		realSlide3C = 0;
	        	}
	        }
        }else
        {
        	if(realSuberi3 > 0)
        	{
	        	if(realSpeed < realSuberi3)
	        	{
	        		//realSuberi1B = realSuberi1 - (int)realSpeed;
			        realTick3C = (int)(realTick3C + realSpeed);
	        		realSuberi3 = realSuberi3 - (int)realSpeed;

			        if(192 - realTick3C <= 0)
			        {
			        	realTick3C = 0;
			        	realSlide3C = realSlide3C + 1;
			        	if(realSlide3C > 4)
			        	{
			        		realSlide3C = 0;
			        	}
			        }
	        	}else
	        	{
			        realTick3C = (int)(realTick3C + realSuberi3);
	        		realSuberi3 = 0;
	        		realStop3 = 1;
			        if(192 - realTick3C <= 0)
			        {
			        	realTick3C = 0;
			        	realSlide3C = realSlide3C + 1;
			        	if(realSlide3C > 4)
			        	{
			        		realSlide3C = 0;
			        	}
			        }
			        //System.out.println("TEST" + realTick3);
	        	}
        	}else
        	{
        		realStop3 = 1;
        	}
        }
        this.mc.getTextureManager().bindTexture(textureReal3);
        this.drawTexturedModalRect(mainX + realBasePosFix3, mainY + realBasePosFixY3, realSlide3C * 48, 192 - realTick3C, 48, 48);



        if(gamePhase == 1 && realStop3 == 1 && realStop2 == 1 && realStop1 == 1 )
        {
        	this.checkKoyakuAllLine();
        	gamePhase = 0;
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
        }
    }


    protected void actionPerformed(GuiButton p_146284_1_)
    {
    	//this.epa.playSound("dqr:mob.fire", 1.0F, 1.0F);
    	//this.epa.worldObj.playSoundAtEntity(this.epa, "dqr:player.miss", 1.0F, 1.0F);

    	/*
    	if(p_146284_1_.id == 1000)
    	{
    		bonusFlg = 1;
    	}
    	if(p_146284_1_.id == 1001)
    	{
    		bonusFlg = 2;
    	}
    	*/

    	if(p_146284_1_.id == 1000)
    	{
    		this.mc.thePlayer.closeScreen();
    	}else if(p_146284_1_.id == 1001)
    	{
    		closeFlg = false;
    	}

    	if(realStop1 == 1 && realStop2 ==1 && realStop3 == 1)
    	{
	    	if(p_146284_1_.id == 91)
	    	{
	    		this.myBet = this.myBet * 10;
	    		if(this.myBet > 10000)
	    		{
	    			this.myBet = 1;
	    		}

	    		kokutiFlg = -1;
	    		bonusFlg = -1;
	    	}else if(p_146284_1_.id == 90)
	    	{
	    		this.myBet = this.myBet / 10;
	    		if(this.myBet < 1)
	    		{
	    			this.myBet = 10000;
	    		}
	    		kokutiFlg = -1;
	    		bonusFlg = -1;
	    	}else if(p_146284_1_.id == 93)
	    	{
	    		this.speedSetting = this.speedSetting + 1;


	    		if(this.speedSetting > 4)
	    		{
	    			this.speedSetting = 0;
	    			this.realSpeed = 1;
	    		}else
	    		{
	    			this.realSpeed = this.speedSetting * 2;
	    		}
	    	}else if(p_146284_1_.id == 92)
	    	{
	    		this.speedSetting = this.speedSetting - 1;
	    		if(this.speedSetting < 0)
	    		{
	    			this.speedSetting = 4;
	    			this.realSpeed = this.speedSetting * 2;
	    		}else if(this.speedSetting == 0)
	    		{
	    			this.realSpeed = 1;
	    		}else
	    		{
	    			this.realSpeed = this.speedSetting * 2;
	    		}
	    	}
    	}


    	if(p_146284_1_.id == 6)
    	{

    		if(this.commandTextField.getText().length() > 0 && Integer.parseInt(this.commandTextField.getText()) > 0
    			&& Integer.parseInt(this.commandTextField.getText()) <= myCoin)
    		{
	    		this.gamePhase = 1;
	    		playerStatus = 0;
	    		dealerStatus = 0;

	    		PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinMinus, Integer.parseInt(this.commandTextField.getText())));
	    		//myCoin = ExtendedPlayerProperties3.get(epa).getCoin();
	    		myCoin = myCoin - Integer.parseInt(this.commandTextField.getText());

	    		//ThreadCasinoPK threadBJ = new ThreadCasinoPK(epa, this, this.gamePhase, p_146284_1_.id);
	    		//threadBJ.start();
    		}
    	}else if(p_146284_1_.id == 9)
    	{
    		if((gamePhase == 0 && myBet <= myCoin) || DQR.debug != 0)
    		{
    			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinMinus, myBet));
    			//this.myCoin = ExtendedPlayerProperties3.get(this.epa).getCoin();
    			this.myCoin = myCoin - myBet;

    			rotate = rotate + 1;
    			if(rotate > 1000000000)
    			{
    				rotate = 0;
    			}
    			totalRotate = totalRotate + 1;
    			if(totalRotate > 1000000000)
    			{
    				totalRotate = 0;
    			}

	    		realStop1 = 0;
	    		realStop2 = 0;
	    		realStop3 = 0;

	    		koyakuLine1 = 0;
	    		koyakuLine2 = 0;
	    		koyakuLine3 = 0;
	    		koyakuLine4 = 0;
	    		koyakuLine5 = 0;

	    		hitKoyaku = -1;
	    		gamePhase = 1;

	    		if(ExtendedPlayerProperties5.get(epa).getJobSPSkillSet(EnumDqmJob.Asobinin.getId(), 12) != 0)
	    		{
	    			if(this.bonusFlg == 2)
	    			{
	    				int mp = ExtendedPlayerProperties.get(epa).getMP();
	        			if(mp >= EnumDqmSkillJ.JSKILL_0_12.getNeedpt_Val())
	        			{
		    				this.epa.playSound("dqr:player.ikasama", 1.0F, 1.0F);
		    				PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.MPchange, EnumDqmSkillJ.JSKILL_0_12.getNeedpt_Val() * -1));
		    				this.bonusFlg = 1;

		    				Random rand = new Random();

		    	    		if(kokutiFlg == 3 || rand.nextInt(8) == 0)
		    	    		{
		    	    			//System.out.println("CASE1 : " + bonusFlg);
		    	    			kokutiFlg = 1;
		    	    		}
	        			}
	    			}
	    		}

	    		this.koyakuChusen();

	    		if(this.kokutiFlg != -1)
	    		{
	    			if(this.kokutiFlg == 1 || this.kokutiFlg == 3)
	    			{
	    				if(!bonusKokutiSound)
	    				{
	    					this.epa.playSound("dqr:player.sl_koyaku_bonus", 0.8F, 1.0F);
	    					bonusKokutiSound = true;
	    				}
	    			}else
	    			{
	    				this.epa.playSound("dqr:player.sl_koyaku", 0.8F, 1.0F);
	    			}
	    		}else
	    		{
	    			if(this.koyakuFlg != -1)
	    			{
	    				Random rand = new Random();
	    				if(rand.nextInt(3) == 0)
	    				{
	    					this.epa.playSound("dqr:player.sl_koyaku", 0.8F, 1.0F);
	    					return;
	    				}
	    			}

	    			this.epa.playSound("dqr:player.sl_start", 0.8F, 1.0F);
	    		}
    		}
    	}else if(p_146284_1_.id == 10)
    	{
    		this.real1Stop();
    	}else if(p_146284_1_.id == 11)
    	{
    		this.real2Stop();
     	}else if(p_146284_1_.id == 12)
    	{
     		this.real3Stop();
    	}


    }


    public boolean isAllowKey(int s) {
        return s == 211 || s == 213 || s == 215 || s == 214;

    }

    public boolean isNumber1(String s) {
        return Pattern.compile("^-?[0-9]+$").matcher(s).find();
    }

    public int checkKoyakuAllLine()
    {
    	int rateBig = 100;
    	int rateReg = 25;
    	int rateBell = 8;
    	int rateSuika = 15;
    	int rateReplay = 1;
    	int rate4Cherry = 4;
    	int rate2Cherry = 2;

    	int getPrice = 0;

    	int retKoyaku = 0;
    	int cherry = 0;
		int checkVal1 = real1[(realTick1 / 48) + (realSlide1  * 4)];
		int checkVal2 = real1[(realTick2 / 48) + (realSlide2  * 4)];
		int checkVal3 = real1[(realTick3 / 48) + (realSlide3  * 4)];

		int checkVal1B = real2[(realTick1B / 48) + (realSlide1B  * 4)];
		int checkVal2B = real2[(realTick2B / 48) + (realSlide2B  * 4)];
		int checkVal3B = real2[(realTick3B / 48) + (realSlide3B  * 4)];

		int checkVal1C = real3[(realTick1C / 48) + (realSlide1C  * 4)];
		int checkVal2C = real3[(realTick2C / 48) + (realSlide2C  * 4)];
		int checkVal3C = real3[(realTick3C / 48) + (realSlide3C  * 4)];

		if(checkVal1 == 4)
		{
			cherry = cherry + 1;
			koyakuLine1 = 1;
		}else if(checkVal1 == checkVal1B && checkVal1 == checkVal1C)
		{
			if(checkVal1 < 5 || checkVal1 > 7 || (checkVal1 == koyakuFlg))
			{
				retKoyaku = checkVal1;
				koyakuLine1 = 1;
			}

			if(bonusFlg != 1 && bonusFlg != 2 && (checkVal1 == 1 || checkVal1 == 2 || checkVal1 == 3))
			{
				koyakuLine1 = 99;
			}
		}

		if(checkVal2 == 4)
		{
			cherry = cherry + 1;
			koyakuLine2 = 1;
		}else if(checkVal2 == checkVal2B && checkVal2 == checkVal2C)
		{
			if(checkVal2 < 5 || checkVal2 > 7 || (checkVal2 == koyakuFlg))
			{
				retKoyaku = checkVal2;
				koyakuLine2 = 1;
			}

			if(bonusFlg != 1 && bonusFlg != 2 && (checkVal2 == 1 || checkVal2 == 2 || checkVal2 == 3))
			{
				koyakuLine2 = 99;
			}
		}

		if(checkVal3 == 4)
		{
			cherry = cherry + 1;
			koyakuLine3 = 1;
		}else if(checkVal3 == checkVal3B && checkVal3 == checkVal3C)
		{
			if(checkVal3 < 5 || checkVal3 > 7 || (checkVal3 == koyakuFlg))
			{
				retKoyaku = checkVal3;
				koyakuLine3 = 1;
			}

			if(bonusFlg != 1 && bonusFlg != 2 && (checkVal3 == 1 || checkVal3 == 2 || checkVal3 == 3))
			{
				koyakuLine3 = 99;
			}
		}

		if(checkVal1 == 4)
		{
			cherry = cherry + 1;
			koyakuLine4 = 1;
		}else if(checkVal1 == checkVal2B && checkVal1 == checkVal3C)
		{
			if(checkVal1 < 5 || checkVal1 > 7 || (checkVal1 == koyakuFlg))
			{
				retKoyaku = checkVal1;
				koyakuLine4 = 1;

				if(bonusFlg != 1 && bonusFlg != 2 && (checkVal1 == 1 || checkVal1 == 2 || checkVal1 == 3))
				{
					koyakuLine4 = 99;
				}
			}
		}

		if(checkVal3 == 4)
		{
			cherry = cherry + 1;
			koyakuLine5 = 1;
		}else if(checkVal3 == checkVal2B && checkVal3 == checkVal1C)
		{
			if(checkVal3 < 5 || checkVal3 > 7 || (checkVal3 == koyakuFlg))
			{
				retKoyaku = checkVal3;
				koyakuLine5 = 1;
			}

			if(bonusFlg != 1 && bonusFlg != 2 && (checkVal3 == 1 || checkVal3 == 2 || checkVal3 == 3))
			{
				koyakuLine5 = 99;
			}
		}

		if(cherry == 1)
		{
			retKoyaku = 10;
		}else if(cherry == 2)
		{
			retKoyaku = 11;
		}


		if(retKoyaku != 0)
		{

			if(retKoyaku == 1 || retKoyaku == 2)
			{
				this.epa.playSound("dqr:player.sl_hit_big", 0.8F, 1.0F);
				this.bonusFlg = -1;
				this.kokutiFlg = -1;
				bonusKokutiSound = false;
				getPrice = myBet * rateBig;
				hitKoyaku = 1;
				rotate = 0;
			}else if(retKoyaku == 3)
			{
				this.epa.playSound("dqr:player.sl_hit_reg", 0.8F, 1.0F);
				this.bonusFlg = -1;
				this.kokutiFlg = -1;
				bonusKokutiSound = false;
				getPrice = myBet * rateReg;
				hitKoyaku = 3;
				rotate = 0;
			}else
			{
				hitKoyaku = retKoyaku;
				if(retKoyaku == 5)
				{
					getPrice = myBet * rateReplay;
				}else if(retKoyaku == 6)
				{
					getPrice = myBet * rateBell;
				}else if(retKoyaku == 7)
				{
					getPrice = myBet * rateSuika;
				}else
				{
					getPrice = myBet * (cherry * 2);
					hitKoyaku = 4;
				}

				this.epa.playSound("dqr:player.sl_hit", 0.8F, 1.0F);
			}
		}

		PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinPlus, getPrice));
		//myCoin = ExtendedPlayerProperties3.get(epa).getCoin();
		myCoin = myCoin + getPrice;


    	return retKoyaku;
    }

    public int checkAllLine(int line, int suberi, int base1)
    {
    	//System.out.println("CASE : " + suberi);
    	int loopCnt = 0;
    	boolean loopFlg = true;
		int checkVal1 = real1[(realTick1 / 48) + (realSlide1  * 4)];
		int checkVal2 = real1[(realTick2 / 48) + (realSlide2  * 4)];
		int checkVal3 = real1[(realTick3 / 48) + (realSlide3  * 4)];

		int checkVal1B;
		int checkVal2B;
		int checkVal3B;

		int checkVal1C;
		int checkVal2C;
		int checkVal3C;

		int base2 = base1 + 1 >= 20 ? base1 + 1 - 20 : base1 + 1;
		int base3 = base2 + 1 >= 20 ? base2 + 1 - 20 : base2 + 1;


		while(loopFlg && loopCnt < 8)
		{
			int realTick1B_tmp = realTick1B;
			int realSlide1B_tmp = realSlide1B;
			int realTick2B_tmp = realTick2B;
			int realSlide2B_tmp = realSlide2B;
			int realTick3B_tmp = realTick3B;
			int realSlide3B_tmp = realSlide3B;
			if(line == 2)
			{
				checkVal1B = real2[base1 + suberi + loopCnt >= 20? base1 + suberi + loopCnt - 20 : base1 + suberi + loopCnt];
				checkVal2B = real2[base2 + suberi + loopCnt >= 20? base2 + suberi + loopCnt - 20 : base2 + suberi + loopCnt];
				checkVal3B = real2[base3 + suberi + loopCnt >= 20? base3 + suberi + loopCnt - 20 : base3 + suberi + loopCnt];

			}else
			{
				checkVal1B = real2[(realTick1B_tmp / 48) + (realSlide1B_tmp  * 4)];
				checkVal2B = real2[(realTick2B_tmp / 48) + (realSlide2B_tmp  * 4)];
				checkVal3B = real2[(realTick3B_tmp / 48) + (realSlide3B_tmp  * 4)];
			}



			int realTick1C_tmp = realTick1C;
			int realSlide1C_tmp = realSlide1C;
			int realTick2C_tmp = realTick2C;
			int realSlide2C_tmp = realSlide2C;
			int realTick3C_tmp = realTick3C;
			int realSlide3C_tmp = realSlide3C;


			if(line == 3)
			{
				/*
				System.out.println("TEMP1 : " + base1 + " / " + suberi  + " : " + loopCnt);
				System.out.println("TEMP2 : " + base2 + " / " + suberi  + " : " + loopCnt);
				System.out.println("TEMP3 : " + base3 + " / " + suberi  + " : " + loopCnt);
				*/
				checkVal1C = real3[base1 + suberi + loopCnt >= 20? base1 + suberi + loopCnt - 20 : base1 + suberi + loopCnt];
				checkVal2C = real3[base2 + suberi + loopCnt >= 20? base2 + suberi + loopCnt - 20 : base2 + suberi + loopCnt];
				checkVal3C = real3[base3 + suberi + loopCnt >= 20? base3 + suberi + loopCnt - 20 : base3 + suberi + loopCnt];
			}else
			{
				checkVal1C = real3[(realTick1C_tmp / 48) + (realSlide1C_tmp  * 4)];
				checkVal2C = real3[(realTick2C_tmp / 48) + (realSlide2C_tmp  * 4)];
				checkVal3C = real3[(realTick3C_tmp / 48) + (realSlide3C_tmp  * 4)];
			}

			/*
			checkVal1C = real3[(realTick1C_tmp / 48) + (realSlide1C_tmp  * 4)];
			checkVal2C = real3[(realTick2C_tmp / 48) + (realSlide2C_tmp  * 4)];
			checkVal3C = real3[(realTick3C_tmp / 48) + (realSlide3C_tmp  * 4)];
			*/
			//koyakuFlg = 0;


			/*
			System.out.println("TEST1 : " + checkVal1 + " / " + checkVal1B + " / " + checkVal3C + " : " + (checkVal1 == checkVal1B && checkVal1 == checkVal3C && checkVal1 != koyakuFlg));
			System.out.println("TEST2 : " + checkVal2 + " / " + checkVal2B + " / " + checkVal2C + " : " + (checkVal2 == checkVal2B && checkVal2 == checkVal2C && checkVal2 != koyakuFlg));
			System.out.println("TEST3 : " + checkVal3 + " / " + checkVal3B + " / " + checkVal1C + " : " + (checkVal3 == checkVal3B && checkVal3 == checkVal1C && checkVal3 != koyakuFlg));
			System.out.println("TEST4 : " + checkVal1+ " / " + checkVal2B + " / " + checkVal1C + " : " + (checkVal1 == checkVal2B && checkVal1 == checkVal1C && checkVal1 != koyakuFlg));
			System.out.println("TEST5 : " + checkVal3 + " / " +  checkVal2B + " / " + checkVal3C + " : " + (checkVal3 == checkVal2B && checkVal3 == checkVal3C && checkVal3 != koyakuFlg));
			*/


			if(line == 2)
			{
				if((checkVal1 == checkVal3B && checkVal1 == checkVal1C && checkVal1 != koyakuFlg && !(bonusFlg ==1 && checkVal1 == 1) && !(bonusFlg ==1 && checkVal1 == 2) && !(bonusFlg ==2 && checkVal1 == 3)) ||
					(checkVal2 == checkVal2B && checkVal2 == checkVal2C && checkVal2 != koyakuFlg && !(bonusFlg ==1 && checkVal2 == 1) && !(bonusFlg ==1 && checkVal2 == 2) && !(bonusFlg ==2 && checkVal2 == 3)) ||
					(checkVal3 == checkVal1B && checkVal3 == checkVal3C && checkVal3 != koyakuFlg && !(bonusFlg ==1 && checkVal3 == 1) && !(bonusFlg ==1 && checkVal3 == 2) && !(bonusFlg ==2 && checkVal3 == 3)) ||
					(checkVal1 == checkVal2B && checkVal1 == checkVal3C && checkVal1 != koyakuFlg && !(bonusFlg ==1 && checkVal1 == 1) && !(bonusFlg ==1 && checkVal1 == 2) && !(bonusFlg ==2 && checkVal1 == 3)) ||
					(checkVal3 == checkVal2B && checkVal3 == checkVal1C && checkVal3 != koyakuFlg && !(bonusFlg ==1 && checkVal3 == 1) && !(bonusFlg ==1 && checkVal3 == 2) && !(bonusFlg ==2 && checkVal3 == 3)))
				{
					//suberi = suberi + 1;
					//System.out.println("CASE2 : " + loopCnt + " _ " + suberi);
					loopCnt = loopCnt + 1;
				}else
				{
					loopFlg = false;
					//System.out.println("CASE3 : " + loopCnt + " _ " + suberi);
				}

				/*
				System.out.println("==================================================");
				System.out.println("CASE : " + suberi + " / " + loopCnt  + " / " + koyakuFlg + " / line2 / " + line);
				System.out.println("LINE1: " + checkVal1 + " " + checkVal3B + " " + checkVal1C);
				System.out.println("LINE2: " + checkVal2 + " " + checkVal2B + " " + checkVal2C);
				System.out.println("LINE3: " + checkVal3 + " " + checkVal1B + " " + checkVal3C);
				System.out.println("==================================================");
				*/
			}else if(line == 3)
			{

				if((checkVal1 == checkVal1B && checkVal1 == checkVal3C && checkVal1 != koyakuFlg && !(bonusFlg ==1 && checkVal1 == 1) && !(bonusFlg ==1 && checkVal1 == 2) && !(bonusFlg ==2 && checkVal1 == 3)) ||
						(checkVal2 == checkVal2B && checkVal2 == checkVal2C && checkVal2 != koyakuFlg && !(bonusFlg ==1 && checkVal2 == 1) && !(bonusFlg ==1 && checkVal2 == 2) && !(bonusFlg ==2 && checkVal2 == 3)) ||
						(checkVal3 == checkVal3B && checkVal3 == checkVal1C && checkVal3 != koyakuFlg && !(bonusFlg ==1 && checkVal3 == 1) && !(bonusFlg ==1 && checkVal3 == 2) && !(bonusFlg ==2 && checkVal3 == 3)) ||
						(checkVal1 == checkVal2B && checkVal1 == checkVal1C && checkVal1 != koyakuFlg && !(bonusFlg ==1 && checkVal1 == 1) && !(bonusFlg ==1 && checkVal1 == 2) && !(bonusFlg ==2 && checkVal1 == 3)) ||
						(checkVal3 == checkVal2B && checkVal3 == checkVal3C && checkVal3 != koyakuFlg && !(bonusFlg ==1 && checkVal3 == 1) && !(bonusFlg ==1 && checkVal3 == 2) && !(bonusFlg ==2 && checkVal3 == 3)))
				{
					//suberi = suberi + 1;
					//System.out.println("CASE2 : " + loopCnt + " _ " + suberi);
					loopCnt = loopCnt + 1;
				}else
				{
					loopFlg = false;
					//System.out.println("CASE3 : " + loopCnt + " _ " + suberi);
				}

				/*
				System.out.println("==================================================");
				System.out.println("CASE : " + suberi + " / " + loopCnt  + " / " + koyakuFlg + " / line3 / " + line);
				System.out.println("LINE1: " + checkVal1 + " " + checkVal1B + " " + checkVal3C);
				System.out.println("LINE2: " + checkVal2 + " " + checkVal2B + " " + checkVal2C);
				System.out.println("LINE3: " + checkVal3 + " " + checkVal3B + " " + checkVal1C);
				System.out.println("==================================================");
				*/
			}



		}


		//System.out.println("CASE3 : " + loopCnt + " _ " + suberi + " / " + suberi + loopCnt);
    	//return suberi + loopCnt;
		return suberi + loopCnt;
    }

    public void koyakuChusen()
    {
    	int rateBig = 286;
    	int rateReg = 417;
    	int rateBell = 5000;
    	int rateSuika = 1429;
    	int rateReplay = 6667;
    	int rate4Cherry = 5000;
    	int rate2Cherry = 1667;

    	Random rand = new Random();
    	Random rand2 = new Random();
    	int randVal = rand.nextInt(100000);

    	koyakuFlg = -1;
    	//System.out.println("case2 : " + kokutiFlg + "/" + bonusFlg);
    	if(bonusFlg == -1)
    	{
    		kokutiFlg = -1;
    	}else
    	{
    		if(kokutiFlg != 1 && kokutiFlg != 3)
    		{
    			kokutiFlg = -1;
    		}
    		//System.out.println("CASE3 : ");
    		if(kokutiFlg == -1 && rand.nextInt(8) == 0)
    		{
    			//System.out.println("CASE1 : " + bonusFlg);
    			if(bonusFlg == 1)
    			{
    				kokutiFlg = 1;
    			}else if(bonusFlg == 2)
    			{
    				kokutiFlg = 3;
    			}
    		}
    	}
    	//System.out.println("number : " + randVal + " / " + bonusFlg);

    	if(randVal >= 0 && randVal < 0 + rateBell)
    	{
    		koyakuFlg = 6;
    		if(rand.nextInt(4) == 0 && bonusFlg == -1)
    		{
    			kokutiFlg = 6;
    		}
    	}else if(randVal >= 15000 && randVal < 15000 + rateSuika)
    	{
    		koyakuFlg = 7;
    		if(rand.nextInt(4) != 0 && bonusFlg == -1)
    		{
    			kokutiFlg = 7;
    		}
    	}else if(randVal >= 25000 && randVal < 25000 + rateReplay)
    	{
    		koyakuFlg = 5;
    		if(rand.nextInt(10) != 0 && bonusFlg == -1)
    		{
    			kokutiFlg = 5;
    		}
    	}else if(randVal >= 35000 && randVal < 35000 + rate4Cherry)
    	{
    		koyakuFlg = 11;
    		if(rand.nextInt(2) == 0 && bonusFlg == -1)
    		{
    			kokutiFlg = 11;
    		}
    	}else if(randVal >= 50000 && randVal < 50000 + rate2Cherry)
    	{
    		koyakuFlg = 10;
    		if(rand.nextInt(2) == 0 && bonusFlg == -1)
    		{
    			kokutiFlg = 10;
    		}
    	}else if(randVal >= 60000 && randVal < 60000 + rateBig && bonusFlg == -1)
    	{
    		bonusFlg = 1;
    		if(rand.nextInt(10) == 0)
    		{
    			kokutiFlg = 1;
    		}
    	}else if(randVal >= 70000 && randVal < 70000 + rateReg && bonusFlg == -1)
    	{
    		bonusFlg = 2;
    		if(rand.nextInt(10) == 0)
    		{
    			kokutiFlg = 3;
    		}
    	}

    	/*
    	if(koyakuFlg != -1)
    	{
    		System.out.println("当たり！！" + koyakuFlg);
    	}
    	*/
    }


    public void real1Stop()
    {
		if(realStop1 == 0)
		{
			this.epa.playSound("dqr:player.sl_stop", 0.9F, 1.0F);
			realStop1 = 2;
			realSuberi1 = ((192 - realTick1) % 48);

			int reai1Index = (192 * realSlide3) + realTick3 + realSuberi1;
			//System.out.println("TEST1 : " + reai1Index / 48);
			int realCheckBase = -1;
			if(reai1Index / 48 >= 20)
			{
				realCheckBase = (reai1Index / 48) - 20;
			}else
			{
				realCheckBase = reai1Index / 48;
			}

			boolean bonusHitFlg = false;
			if(bonusFlg != -1)
			{
				int cnt = 0;
				int checkKoyaku1 = 0;
				int checkKoyaku2 = 0;


				if(bonusFlg == 1)
				{
					checkKoyaku1 = 1;
					checkKoyaku1 = 2;
				}else if(bonusFlg == 2)
				{
					checkKoyaku1 = 3;
					checkKoyaku1 = 3;
				}

				for(cnt = 0; cnt < 5; cnt++)
				{
    				int checkVal3 = realCheckBase + 2 + cnt < 20 ? realCheckBase + 2 + cnt : (realCheckBase + cnt + 2 - 20);
					int checkVal2 = realCheckBase + 1 + cnt < 20 ? realCheckBase + 1 + cnt : (realCheckBase + cnt + 1 - 20);
					int checkVal1 = realCheckBase + cnt < 20 ? realCheckBase + cnt : (realCheckBase + cnt - 20);

					if(real1[checkVal1] != 4 && real1[checkVal2] != 4 && real1[checkVal3] != 4 &&
						((real1[checkVal1] != checkKoyaku1 && real1[checkVal2] != checkKoyaku1 && real1[checkVal3] != checkKoyaku1) ||
						 (real1[checkVal1] != checkKoyaku2 && real1[checkVal2] != checkKoyaku2 && real1[checkVal3] != checkKoyaku2))
					  )
					{
						bonusHitFlg = true;
						break;
					}
				}

				if(bonusHitFlg)
				{
					realSuberi1 = realSuberi1 +  (48 * cnt);
				}
			}

			if(!bonusHitFlg)
			{
    			if(koyakuFlg == 10)
    			{
    				//2チェ
    				int cnt = 0;
	    			for(cnt = 0; cnt < 5; cnt++)
	    			{
	    				if(realCheckBase + cnt + 1 >= 20)
	    				{
	    					if(real1[realCheckBase + cnt + 1 - 20] == 4)
	    					{
	    						break;
	    					}
	    				}else
	    				{
	    					//System.out.println("Code : " + realCheckBase);
	    					if(real1[realCheckBase + cnt + 1] == 4)
	    					{
	    						break;
	    					}
	    				}
	    			}

	    			realSuberi1 = realSuberi1 +  (48 * cnt);
    			}else if(koyakuFlg == 11)
    			{
    				//4チェ
    				int cnt = 0;
	    			for(cnt = 0; cnt < 5; cnt++)
	    			{
						int realCheckBaseX = realCheckBase + cnt >= 20 ?  realCheckBase + cnt - 20 : realCheckBase + cnt;
						//int realCheckBaseX1 = realCheckBase + 1 + cnt >= 20 ?  realCheckBase + 1 + cnt - 20 : realCheckBase + 1 + cnt;
						int realCheckBaseX2 = realCheckBase + 2 + cnt >= 20 ?  realCheckBase + 2 + cnt - 20 : realCheckBase + 2 + cnt;

						if(real1[realCheckBaseX] == 4 || real1[realCheckBaseX2] == 4)
						{
							break;
						}
	    			}

	    			realSuberi1 = realSuberi1 +  (48 * cnt);

    			}else
    			{
	    			int cnt = 0;
	    			boolean cherryCheck = true;
    				if(koyakuFlg != -1)
    				{
		    			for(cnt = 0; cnt < 7; cnt++)
		    			{
		    				if(realCheckBase + cnt >= 20)
		    				{
		    					if(real1[realCheckBase + cnt - 20] == koyakuFlg)
		    					{
		    						break;
		    					}
		    				}else
		    				{
		    					//System.out.println("Code : " + realCheckBase);
		    					if(real1[realCheckBase + cnt] == koyakuFlg)
		    					{
		    						break;
		    					}
		    				}
		    			}



						if(cnt > 2)
						{
							//System.out.println("TEST3");
							realSuberi1 = realSuberi1 + (48 * (cnt - 2));
						}else if(cnt == 0 && (realCheckBase >= 11 && realCheckBase <= 13) && koyakuFlg == 6)
						{
							//System.out.println("TEST2");
							realSuberi1 = realSuberi1 + (48 * (15 - realCheckBase));
							cherryCheck = false;
						}else if(cnt == 1)
						{
							//System.out.println("TEST");
							if(!(realCheckBase + 1 == 11 &&  koyakuFlg == 6) && !(realCheckBase + 1 == 1 &&  koyakuFlg == 5))
							{
								realSuberi1 = realSuberi1 +  48;
								cherryCheck = false;
							}
						}
    				}

    				if(koyakuFlg != -1)
    				{
    					int checkValA = realCheckBase + cnt - 1 < 0 ? (realCheckBase + cnt - 1 + 20) : realCheckBase + cnt - 1 >= 20 ? realCheckBase + cnt - 1 - 20 : realCheckBase + cnt - 1;
    					if(real1[checkValA] == koyakuFlg)
    					{
    						cnt = cnt + 1;
    					}
    				}

    				if(cherryCheck)
    				{
	    				if(cnt < 3)
	    				{
	    					int checkVal2 = realCheckBase + 1 < 20 ? realCheckBase + 1 : (realCheckBase + 1 - 20);
	    					int checkVal3 = realCheckBase + 2 < 20 ? realCheckBase + 2 : (realCheckBase + 2 - 20);
	    					if(real1[realCheckBase] == sCherry)
	    					{
	    						realSuberi1 = realSuberi1 + 48;
	    					}else if(real1[checkVal2] == sCherry)
	    					{
	    						realSuberi1 = realSuberi1 + 96;
	    					}else if(real1[checkVal3] == sCherry)
	    					{
	    						realSuberi1 = realSuberi1 + 144;
	    					}
	    				}else
	    				{
	    					int checkVal1 = realCheckBase + cnt < 20 ? realCheckBase + cnt : (realCheckBase + cnt - 20);
	    					/*Latest4Fix
	    					int checkVal2 = realCheckBase + cnt - 1 < 20 ? realCheckBase + cnt - 1 : (realCheckBase + cnt - 1 - 20);
	    					int checkVal3 = realCheckBase + cnt - 2 < 20 ? realCheckBase + cnt - 2 : (realCheckBase + cnt - 2 - 20);*/
	    					int checkVal2 = realCheckBase + cnt - 1 < 0 ? realCheckBase + cnt - 1 + 20 : realCheckBase + cnt - 1 >= 20 ? realCheckBase + cnt - 1 - 20 : realCheckBase + cnt - 1;
	    					int checkVal3 = realCheckBase + cnt - 2 < 0 ? realCheckBase + cnt - 2 + 20 : realCheckBase + cnt - 2 >= 20 ? realCheckBase + cnt - 2 - 20 : realCheckBase + cnt - 2;
	    					if(real1[checkVal1] == sCherry)
	    					{
	    						realSuberi1 = realSuberi1 + 144;
	    					}else if(real1[checkVal2] == sCherry)
	    					{
	    						realSuberi1 = realSuberi1 + 96;
	    					}else if(real1[checkVal3] == sCherry)
	    					{
	    						realSuberi1 = realSuberi1 + 48;
	    					}
	    				}
    				}
    			}
			}


		}else
		{
			//realStop1 = 0;
		}
    }

    public void real2Stop()
    {
		//2リール目停止処理
		if(realStop2 == 0 && realStop1 == 1 && (realStop3 == 0 || realStop3 == 1))
		{
			this.epa.playSound("dqr:player.sl_stop", 0.9F, 1.0F);
			if(realStop1 == 1 && realStop3 == 0)
			{
				boolean bonusHitFlg = false;

				int checkVal1 = (realTick1 / 48) + (realSlide1  * 4);
				int checkVal2 = (realTick2 / 48) + (realSlide2  * 4);
				int checkVal3 = (realTick3 / 48) + (realSlide3  * 4);

				realStop2 = 2;
				realSuberi2 = ((192 - realTick1B) % 48);

    			int reaiBIndex = (192 * realSlide3B) + realTick3B + realSuberi2;
    			//System.out.println("TEST1 : " + reai1Index / 48);
    			int realCheckBase = -1;
    			if(reaiBIndex / 48 >= 20)
    			{
    				realCheckBase = (reaiBIndex / 48) - 20;
    			}else
    			{
    				realCheckBase = reaiBIndex / 48;
    			}

    			//System.out.println("TEST1" + reaiBIndex + " / " + realCheckBase);

    			if(bonusFlg != -1)
    			{
    				int cnt = 0;

        			if(bonusFlg == 1)
        			{
        				boolean checkLine1_1 = false;
        				boolean checkLine1_2 = false;
        				boolean checkLine1_3 = false;

        				boolean checkLine2_1 = false;
        				boolean checkLine2_2 = false;
        				boolean checkLine2_3 = false;
        				if(real1[checkVal1] == 1)
        				{
        					checkLine1_1 = true;
        					checkLine1_2 = true;
        				}else if(real1[checkVal2] == 1)
        				{
        					checkLine1_2 = true;
        				}else if(real1[checkVal3] == 1)
        				{
        					checkLine1_2 = true;
        					checkLine1_3 = true;
        				}

        				if(real1[checkVal1] == 2)
        				{
        					checkLine2_1 = true;
        					checkLine2_2 = true;
        				}else if(real1[checkVal2] == 2)
        				{
        					checkLine2_2 = true;
        				}else if(real1[checkVal3] == 2)
        				{
        					checkLine2_2 = true;
        					checkLine2_3 = true;
        				}

        				//System.out.println("CHECK : " + checkLine1_1 + " / " + checkLine1_2 + " / " + checkLine1_3 + " / " + checkLine2_1 + " / " + checkLine2_2 + " / " + checkLine2_3);
    					for(cnt = 0; cnt < 5; cnt++)
    					{
    	    				int checkVal3Y = realCheckBase + 2 + cnt < 20 ? realCheckBase + 2 + cnt : (realCheckBase + cnt + 2 - 20);
    						int checkVal2Y = realCheckBase + 1 + cnt < 20 ? realCheckBase + 1 + cnt : (realCheckBase + cnt + 1 - 20);
    						int checkVal1Y = realCheckBase + cnt < 20 ? realCheckBase + cnt : (realCheckBase + cnt - 20);

    						//System.out.println("COUNT" + cnt + " : " + real2[checkVal3Y] + " / " + real2[checkVal2Y] + " / " + real2[checkVal1Y]);
    						if((checkLine1_1 && real2[checkVal3Y] == 1) || (checkLine1_2 && real2[checkVal2Y] == 1) || (checkLine1_3 && real2[checkVal1Y] == 1) ||
    							(checkLine2_1 && real2[checkVal3Y] == 2) || (checkLine2_2 && real2[checkVal2Y] == 2) || (checkLine2_3 && real2[checkVal1Y] == 2))
    						{
    							bonusHitFlg = true;
    							break;
    						}
    					}
        				//if(real1[checkVal1] == 1)
        			}else if(bonusFlg == 2 && (real1[checkVal3] == 3 || real1[checkVal2] == 3 || real1[checkVal1] == 3))
        			{
        				boolean checkLine1 = false;
        				boolean checkLine2 = false;
        				boolean checkLine3 = false;

        				if(real1[checkVal1] == 3)
        				{
        					checkLine1 = true;
        					checkLine2 = true;
        				}else if(real1[checkVal2] == 3)
        				{
        					checkLine2 = true;
        				}else if(real1[checkVal3] == 3)
        				{
        					checkLine2 = true;
        					checkLine3 = true;
        				}

    					for(cnt = 0; cnt < 5; cnt++)
    					{
    	    				int checkVal3Y = realCheckBase + 2 + cnt < 20 ? realCheckBase + 2 + cnt : (realCheckBase + cnt + 2 - 20);
    						int checkVal2Y = realCheckBase + 1 + cnt < 20 ? realCheckBase + 1 + cnt : (realCheckBase + cnt + 1 - 20);
    						int checkVal1Y = realCheckBase + cnt < 20 ? realCheckBase + cnt : (realCheckBase + cnt - 20);

    						if((checkLine1 && real2[checkVal3Y] == 3) || (checkLine2 && real2[checkVal2Y] == 3) || (checkLine3 && real2[checkVal1Y] == 3))
    						{
    							bonusHitFlg = true;
    							break;
    						}
    					}
        			}

					if(bonusHitFlg)
					{
						//System.out.println("LOOP" + cnt + " / " + realSuberi2);
						realSuberi2 = realSuberi2 +  (48 * cnt);
					}
    			}

    			if(!bonusHitFlg)
    			{
    				if(koyakuFlg != -1 && koyakuFlg != 10 && koyakuFlg != 11)
    				{
    					int startNum = 0;
    					int endNum = 6;

    					if(real1[checkVal3] == koyakuFlg)
    					{
    						startNum = 1;
    					}else if(real1[checkVal2] == koyakuFlg)
    					{
    						startNum = 1;
    					}else if(real1[checkVal1] == koyakuFlg)
    					{
    						startNum = 1;
    						endNum = 7;
    					}

    					//System.out.println("TEST4" + startNum);

    					int cnt = 0;
    					int cnt2 = 0;
						//左リール下段にある場合
		    			for(cnt = startNum; cnt < endNum; cnt++)
		    			{
		    				if(realCheckBase + cnt >= 20)
		    				{
		    					if(real2[realCheckBase + cnt - 20] == koyakuFlg)
		    					{
		    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
		    						break;
		    					}
		    				}else
		    				{
		    					//System.out.println("Code : " + realCheckBase);
		    					if(real2[realCheckBase + cnt] == koyakuFlg)
		    					{
		    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt]);
		    						break;
		    					}
		    				}
		    			}

		    			//System.out.println("TEST2 : " + realCheckBase + " / " + cnt + "");

						if(cnt >= 2)
						{
							//System.out.println("TEST3");
							realSuberi2 = realSuberi2 + (48 * (cnt - 1));
						}
    				}else
    				{
						int addSuberi = -1;
    					if(koyakuFlg != -1 && (real1[checkVal1] == 4 || real1[checkVal2] == 4 || real1[checkVal3] == 4))
    					{
    						int realCheckBaseY = realCheckBase >= 20 ?  realCheckBase - 20 : realCheckBase;
    						int realCheckBaseY1 = realCheckBase + 1 >= 20 ?  realCheckBase + 1 - 20 : realCheckBase + 1;
    						int realCheckBaseY2 = realCheckBase + 2 >= 20 ?  realCheckBase + 2 - 20 : realCheckBase + 2;
    						int realCheckBaseY3 = realCheckBase + 3 >= 20 ?  realCheckBase + 3 - 20 : realCheckBase + 3;
    						int realCheckBaseY4 = realCheckBase + 4 >= 20 ?  realCheckBase + 4 - 20 : realCheckBase + 4;
    						int realCheckBaseY5 = realCheckBase + 5 >= 20 ?  realCheckBase + 5 - 20 : realCheckBase + 5;


    						if(real2[realCheckBaseY] == 4 || real2[realCheckBaseY1] == 4)
    						{
    							addSuberi = 0;
    						}else if(real2[realCheckBaseY2] == 4)
    						{
    							addSuberi = 1;
    						}else if(real2[realCheckBaseY3] == 4)
    						{
    							addSuberi = 2;
    						}else if(real2[realCheckBaseY4] == 4)
    						{
    							addSuberi = 3;
    						}else if(real2[realCheckBaseY5] == 4)
    						{
    							addSuberi = 4;
    						}

    						//System.out.println("TEST : " + addSuberi);
    					}

						int cnt = 0;
    					if(addSuberi == -1)
    					{
							//ハズレ 順押しの場合は、できるだけ子役ナナメテンパイ
							int setKoyaku = -1;
							if(real1[checkVal1] == 5 || real1[checkVal1] == 6)
							{
								setKoyaku = real1[checkVal1];
							}else if(real1[checkVal3] == 5 || real1[checkVal3] == 6)
							{
								setKoyaku = real1[checkVal3];
							}else if(real1[checkVal2] == 5)
							{
								setKoyaku = 6;
							}else if(real1[checkVal2] == 6)
							{
								setKoyaku = 5;
							}


							for(cnt = 0; cnt < 5; cnt++)
							{
	    						int realCheckBaseX = realCheckBase + cnt >= 20 ?  realCheckBase + cnt - 20 : realCheckBase + cnt;
	    						int realCheckBaseX1 = realCheckBase + 1 + cnt >= 20 ?  realCheckBase + 1 + cnt - 20 : realCheckBase + 1 + cnt;
	    						int realCheckBaseX2 = realCheckBase + 2 + cnt >= 20 ?  realCheckBase + 2 + cnt - 20 : realCheckBase + 2 + cnt;

	    						if(setKoyaku != -1)
	    						{
	    							if(real2[realCheckBaseX1] == setKoyaku)
	    							{
	    								break;
	    							}
	    						}else
	    						{
	    							if(real2[realCheckBaseX1] == 5 || real2[realCheckBaseX1] == 6)
	    							{
	    								break;
	    							}
	    						}
							}

							//System.out.println("TEST2 : " + cnt);
    					}else
    					{
    						cnt = addSuberi;
    					}

						realSuberi2 = realSuberi2 + (48 * (cnt));

    				}
    			}
			}else if(realStop1 == 1 && realStop3 == 1)
			{
				//はさみ打ち時中段
				//上段優先で判定する処理をいれる
				int checkVal1 = (realTick1 / 48) + (realSlide1  * 4);
				int checkVal2 = (realTick2 / 48) + (realSlide2  * 4);
				int checkVal3 = (realTick3 / 48) + (realSlide3  * 4);

				int checkVal1C = (realTick1C / 48) + (realSlide1C  * 4);
				int checkVal2C = (realTick2C / 48) + (realSlide2C  * 4);
				int checkVal3C = (realTick3C / 48) + (realSlide3C  * 4);

    			realStop2 = 2;
    			realSuberi2 = ((192 - realTick1B) % 48);

    			boolean lineFlg1 = false;
    			boolean lineFlg2 = false;
    			boolean lineFlg3 = false;
    			boolean crossFlg = false;
    			boolean hitFlg = false;
    			boolean doubleHitFlg = false;
    			boolean bonusHitFlg = false;


    			int reaiBIndex = (192 * realSlide3B) + realTick3B + realSuberi2;
    			//System.out.println("TEST1 : " + reai1Index / 48);
    			int realCheckBase = -1;
    			if(reaiBIndex / 48 >= 20)
    			{
    				realCheckBase = (reaiBIndex / 48) - 20;
    			}else
    			{
    				realCheckBase = reaiBIndex / 48;
    			}

				int cnt = 0;
				int realCheckBaseX = realCheckBase;
				int realCheckBaseX1 = realCheckBase + 1>= 20 ?  realCheckBase + 1 - 20 : realCheckBase + 1;
				int realCheckBaseX2 = realCheckBase + 2>= 20 ?  realCheckBase + 2 - 20 : realCheckBase + 2;

				if(bonusFlg == 1)
				{
	    			boolean lineFlg2_1 = false;
	    			boolean lineFlg2_2 = false;
	    			boolean lineFlg2_3 = false;

	    			if(real1[checkVal1] == 1 && real3[checkVal1C] == 1)
	    			{
	    				lineFlg1 = true;
	    			}
	    			if(real1[checkVal2] == 1 && real3[checkVal2C] == 1)
	    			{
	    				lineFlg2 = true;
	    			}
	    			if(real1[checkVal3] == 1 && real3[checkVal3C] == 1)
	    			{
	    				lineFlg3 = true;
	    			}
	    			if(real1[checkVal1] == 1 && real3[checkVal3C] == 1)
	    			{
	    				lineFlg2 = true;
	    			}
	    			if(real1[checkVal3] == 1 && real3[checkVal1C] == 1)
	    			{
	    				lineFlg2 = true;
	    			}

	    			if(real1[checkVal1] == 2 && real3[checkVal1C] == 2)
	    			{
	    				lineFlg2_1 = true;
	    			}
	    			if(real1[checkVal2] == 2 && real3[checkVal2C] == 2)
	    			{
	    				lineFlg2_2 = true;
	    			}
	    			if(real1[checkVal3] == 2 && real3[checkVal3C] == 2)
	    			{
	    				lineFlg2_3 = true;
	    			}

	    			if(real1[checkVal1] == 2 && real3[checkVal3C] == 2)
	    			{
	    				lineFlg2_2 = true;
	    			}
	    			if(real1[checkVal3] == 2 && real3[checkVal1C] == 2)
	    			{
	    				lineFlg2_2 = true;
	    			}

					for(cnt = 0; cnt < 5; cnt++)
					{
	    				int checkVal3Y = realCheckBase + 2 + cnt < 20 ? realCheckBase + 2 + cnt : (realCheckBase + cnt + 2 - 20);
						int checkVal2Y = realCheckBase + 1 + cnt < 20 ? realCheckBase + 1 + cnt : (realCheckBase + cnt + 1 - 20);
						int checkVal1Y = realCheckBase + cnt < 20 ? realCheckBase + cnt : (realCheckBase + cnt - 20);

						//System.out.println("COUNT" + cnt + " : " + real2[checkVal3Y] + " / " + real2[checkVal2Y] + " / " + real2[checkVal1Y]);
						if((lineFlg1 && real2[checkVal3Y] == 1) || (lineFlg2 && real2[checkVal2Y] == 1) || (lineFlg3 && real2[checkVal1Y] == 1) ||
							(lineFlg2_1 && real2[checkVal3Y] == 2) || (lineFlg2_2 && real2[checkVal2Y] == 2) || (lineFlg2_3 && real2[checkVal1Y] == 2))
						{
							bonusHitFlg = true;
							break;
						}
					}
				}else if(bonusFlg == 2)
				{
	    			if(real1[checkVal1] == 3 && real3[checkVal1C] == 3)
	    			{
	    				lineFlg1 = true;
	    			}
	    			if(real1[checkVal2] == 3 && real3[checkVal2C] == 3)
	    			{
	    				lineFlg2 = true;
	    			}
	    			if(real1[checkVal3] == 3 && real3[checkVal3C] == 3)
	    			{
	    				lineFlg3 = true;
	    			}

	    			if(real1[checkVal1] == 3 && real3[checkVal3C] == 3)
	    			{
	    				lineFlg2 = true;
	    			}
	    			if(real1[checkVal3] == 3 && real3[checkVal1C] == 3)
	    			{
	    				lineFlg2 = true;
	    			}

					for(cnt = 0; cnt < 5; cnt++)
					{
	    				int checkVal3Y = realCheckBase + 2 + cnt < 20 ? realCheckBase + 2 + cnt : (realCheckBase + cnt + 2 - 20);
						int checkVal2Y = realCheckBase + 1 + cnt < 20 ? realCheckBase + 1 + cnt : (realCheckBase + cnt + 1 - 20);
						int checkVal1Y = realCheckBase + cnt < 20 ? realCheckBase + cnt : (realCheckBase + cnt - 20);

						//System.out.println("COUNT" + cnt + " : " + real2[checkVal3Y] + " / " + real2[checkVal2Y] + " / " + real2[checkVal1Y]);
						if((lineFlg1 && real2[checkVal3Y] == 3) || (lineFlg2 && real2[checkVal2Y] == 3) || (lineFlg3 && real2[checkVal1Y] == 3))
						{
							bonusHitFlg = true;
							break;
						}
					}
				}

				if(!bonusHitFlg)
				{
	    			lineFlg1 = false;
	    			lineFlg2 = false;
	    			lineFlg3 = false;
	    			if(real1[checkVal1] == koyakuFlg && real3[checkVal1C] == koyakuFlg)
	    			{
	    				//System.out.println("TEST_A");
	    				lineFlg1 = true;
	    			}

	    			if(real1[checkVal1] == koyakuFlg && real3[checkVal3C] == koyakuFlg)
	    			{
	    				//System.out.println("TEST_B");
	    				lineFlg2 = true;
	    			}

	    			if(real1[checkVal2] == koyakuFlg && real3[checkVal2C] == koyakuFlg)
	    			{
	    				//System.out.println("TEST_C");
	    				lineFlg2 = true;
	    			}

	    			if(real1[checkVal3] == koyakuFlg && real3[checkVal3C] == koyakuFlg)
	    			{
	    				//System.out.println("TEST_D");
	    				lineFlg3 = true;
	    			}

	    			if(real1[checkVal3] == koyakuFlg && real3[checkVal1C] == koyakuFlg)
	    			{
	    				//System.out.println("TEST_E");
	    				lineFlg2 = true;
	    			}

	    			if(real1[checkVal1] == koyakuFlg && real3[checkVal1C] == koyakuFlg && real1[checkVal3] == koyakuFlg && real3[checkVal1C] == koyakuFlg)
	    			{
	    				//System.out.println("TEST_F");
	    				crossFlg = true;
	    			}

	    			/*
	    			System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/);
	    			System.out.println("TEST_A " + koyakuFlg + ": " + lineFlg1 + " | " + lineFlg2 + " | " + lineFlg3 + " | " + crossFlg);
 	    			System.out.println("TEST_A : " + real1[checkVal1] + " ? " + real3[checkVal1C]);
 	    			System.out.println("TEST_A : " + real1[checkVal2] + " ? " + real3[checkVal2C]);
 	    			System.out.println("TEST_A : " + real1[checkVal3] + " ? " + real3[checkVal3C]);
 	    			System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
 	    			*/

 	    			if(koyakuFlg != -1 && koyakuFlg != 10 && koyakuFlg != 11)
 	    			{
						for(cnt = 0; cnt < 5; cnt++)
		    			{
							doubleHitFlg = false;

							realCheckBaseX = realCheckBase + cnt >= 20 ?  realCheckBase + cnt - 20 : realCheckBase + cnt;
							realCheckBaseX1 = realCheckBase + 1 + cnt >= 20 ?  realCheckBase + 1 + cnt - 20 : realCheckBase + 1 + cnt;
							realCheckBaseX2 = realCheckBase + 2 + cnt >= 20 ?  realCheckBase + 2 + cnt - 20 : realCheckBase + 2 + cnt;

							if(lineFlg1)
							{
								//最初は上段からチェック
		    					if(real2[realCheckBaseX2] == koyakuFlg)
		    					{
		    						break;
		    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
		    						/*
		    						if(real2[realCheckBaseX] == koyakuFlg)
		    						{
		    							//System.out.println("TEST1");
		    							doubleHitFlg = true;
		    						}else
			    					{
		    							//System.out.println("TEST2");
		    							hitFlg = true;
		    							break;
			    					}
			    					*/
		    					}
							}

							if(lineFlg3)
							{
								if(real2[realCheckBaseX] == koyakuFlg)
		    					{
		    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
									//System.out.println("TEST4");
		    						hitFlg = true;
		    						break;
		    					}
							}

							if(lineFlg2 && !crossFlg)
							{
		    					if(real2[realCheckBaseX1] == koyakuFlg)
		    					{
		    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
		    						//System.out.println("TEST3");
		    						hitFlg = true;
		    						break;
		    					}
							}


		    			}
 	    			}else
 	    			{
 	    				cnt = 0;
 	    			}

					//realSuberi2 = realSuberi2 + (48 * (checkAllLine(2,cnt)));
					//realSuberi2 = realSuberi2 + ((checkAllLine(2,cnt, realCheckBase)) * 48);

					realSuberi2 = realSuberi2 + ((checkAllLine(2,cnt, realCheckBase)) * 48);
				}

			}
		}else
		{
			//realStop2 = 0;
		}
    }

    public void real3Stop()
    {
		//第3リール
		if(realStop3 == 0 && realStop1 == 1 && (realStop2 == 0 || realStop2 == 1))
		{
			this.epa.playSound("dqr:player.sl_stop", 0.9F, 1.0F);
			if(realStop1 == 1 && realStop2 == 1)
			{
    			realStop3 = 2;
    			realSuberi3 = ((192 - realTick1C) % 48);

    			int reaiBIndex = (192 * realSlide3C) + realTick3C + realSuberi3;
    			//System.out.println("TEST1 : " + reai1Index / 48);
    			int realCheckBase = -1;
    			if(reaiBIndex / 48 >= 20)
    			{
    				realCheckBase = (reaiBIndex / 48) - 20;
    			}else
    			{
    				realCheckBase = reaiBIndex / 48;
    			}

    			if(koyakuFlg != -1 && koyakuFlg != 10 && koyakuFlg != 11)
				{
    				int checkVal1 = (realTick1 / 48) + (realSlide1  * 4);
    				int checkVal2 = (realTick2 / 48) + (realSlide2  * 4);
    				int checkVal3 = (realTick3 / 48) + (realSlide3  * 4);

    				int checkVal1B = (realTick1B / 48) + (realSlide1B  * 4);
    				int checkVal2B = (realTick2B / 48) + (realSlide2B  * 4);
    				int checkVal3B = (realTick3B / 48) + (realSlide3B  * 4);

    				//System.out.println("TEST : " + checkVal1 + "/" + checkVal2 + "/" + checkVal3 + "/" + checkVal1B + "/" + checkVal2B + "/" + checkVal3B + "/");
    				boolean flgTop = false;
    				boolean flgMiddle = false;
    				boolean flgUnder = false;

					boolean bonusHitFlg = false;
					int suberiSet = -1;


					if(bonusFlg == 1)
					{
						boolean lineFlg1 = false;
						boolean lineFlg2 = false;
						boolean lineFlg3 = false;
		    			boolean lineFlg2_1 = false;
		    			boolean lineFlg2_2 = false;
		    			boolean lineFlg2_3 = false;

		    			if(real1[checkVal1] == 1 && real2[checkVal1B] == 1)
		    			{
		    				lineFlg1 = true;
		    				//lineFlg3 = true;
		    			}
		    			if(real1[checkVal2] == 1 && real2[checkVal2B] == 1)
		    			{
		    				lineFlg2 = true;
		    			}
		    			if(real1[checkVal3] == 1 && real2[checkVal3B] == 1)
		    			{
		    				//lineFlg1 = true;
		    				lineFlg3 = true;
		    			}
		    			if(real1[checkVal1] == 1 && real2[checkVal2B] == 1)
		    			{
		    				lineFlg3 = true;
		    			}
		    			if(real1[checkVal3] == 1 && real2[checkVal2B] == 1)
		    			{
		    				lineFlg1 = true;
		    			}

		    			if(real1[checkVal1] == 2 && real2[checkVal1B] == 2)
		    			{
		    				lineFlg2_1 = true;
		    				//lineFlg2_3 = true;
		    			}
		    			if(real1[checkVal2] == 2 && real2[checkVal2B] == 2)
		    			{
		    				lineFlg2_2 = true;
		    			}
		    			if(real1[checkVal3] == 2 && real2[checkVal3B] == 2)
		    			{
		    				//lineFlg2_1 = true;
		    				lineFlg2_3 = true;
		    			}
		    			if(real1[checkVal1] == 2 && real2[checkVal2B] == 2)
		    			{
		    				lineFlg2_3 = true;
		    			}
		    			if(real1[checkVal3] == 2 && real2[checkVal2B] == 2)
		    			{
		    				lineFlg2_1 = true;
		    			}

						for(suberiSet = 0; suberiSet < 5; suberiSet++)
						{
		    				int checkVal3Y = realCheckBase + 2 + suberiSet < 20 ? realCheckBase + 2 + suberiSet : (realCheckBase + suberiSet + 2 - 20);
							int checkVal2Y = realCheckBase + 1 + suberiSet < 20 ? realCheckBase + 1 + suberiSet : (realCheckBase + suberiSet + 1 - 20);
							int checkVal1Y = realCheckBase + suberiSet < 20 ? realCheckBase + suberiSet : (realCheckBase + suberiSet - 20);

							//System.out.println("COUNT" + suberiSet + " : " + real2[checkVal3Y] + " / " + real2[checkVal2Y] + " / " + real2[checkVal1Y]);
							if((lineFlg1 && real3[checkVal3Y] == 1) || (lineFlg2 && real3[checkVal2Y] == 1) || (lineFlg3 && real3[checkVal1Y] == 1) ||
								(lineFlg2_1 && real3[checkVal3Y] == 2) || (lineFlg2_2 && real3[checkVal2Y] == 2) || (lineFlg2_3 && real3[checkVal1Y] == 2))
							{
								bonusHitFlg = true;
								break;
							}
						}
					}else if(bonusFlg == 2)
					{
						boolean lineFlg1 = false;
						boolean lineFlg2 = false;
						boolean lineFlg3 = false;
						if(real1[checkVal1] == 3 && real2[checkVal1B] == 3)
		    			{
		    				lineFlg1 = true;
		    				//lineFlg3 = true;
		    			}
		    			if(real1[checkVal2] == 3 && real2[checkVal2B] == 3)
		    			{
		    				lineFlg2 = true;
		    			}
		    			if(real1[checkVal3] == 3 && real2[checkVal3B] == 3)
		    			{
		    				//lineFlg1 = true;
		    				lineFlg3 = true;
		    			}
		    			if(real1[checkVal1] == 3 && real2[checkVal2B] == 3)
		    			{
		    				lineFlg3 = true;
		    			}
		    			if(real1[checkVal3] == 3 && real2[checkVal2B] == 3)
		    			{
		    				lineFlg1 = true;
		    			}

		    			for(suberiSet = 0; suberiSet < 5; suberiSet++)
						{
		    				int checkVal3Y = realCheckBase + 2 + suberiSet < 20 ? realCheckBase + 2 + suberiSet : (realCheckBase + suberiSet + 2 - 20);
							int checkVal2Y = realCheckBase + 1 + suberiSet < 20 ? realCheckBase + 1 + suberiSet : (realCheckBase + suberiSet + 1 - 20);
							int checkVal1Y = realCheckBase + suberiSet < 20 ? realCheckBase + suberiSet : (realCheckBase + suberiSet - 20);

							/*
			    			System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
			    	    	System.out.println("TEST_A " + koyakuFlg + ": " + lineFlg1 + " | " + lineFlg2 + " | " + lineFlg3);
			     	    	System.out.println("TEST_A : " + real1[checkVal1] + " " + real2[checkVal1B] + " " + real3[checkVal3Y]);
			     	    	System.out.println("TEST_A : " + real1[checkVal2] + " " + real2[checkVal2B] + " " + real3[checkVal2Y]);
			     	    	System.out.println("TEST_A : " + real1[checkVal3] + " " + real2[checkVal3B] + " " + real3[checkVal1Y]);
			     	    	System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
							*/
							//System.out.println("COUNT" + suberiSet + " : " + real2[checkVal3Y] + " / " + real2[checkVal2Y] + " / " + real2[checkVal1Y]);
							if((lineFlg1 && real3[checkVal3Y] == 3) || (lineFlg2 && real3[checkVal2Y] == 3) || (lineFlg3 && real3[checkVal1Y] == 3))
							{
								bonusHitFlg = true;
								break;
							}
						}
					}


					if(!bonusHitFlg)
					{
	    				if(real1[checkVal3] == koyakuFlg && real1[checkVal3] == real2[checkVal3B])
	    				{
	    					//下段テンパイ
	    					flgUnder = true;
	    				}

	    				if(real1[checkVal3] == koyakuFlg && real1[checkVal3] == real2[checkVal2B])
	    				{
	    					//右上がり
	    					flgTop = true;
	    				}

	    				if(real1[checkVal2] == koyakuFlg && real1[checkVal2] == real2[checkVal2B])
	    				{
	    					//中段テンパイ
	    					flgMiddle = true;
	    				}

	    				if(real1[checkVal1] == koyakuFlg && real1[checkVal1] == real2[checkVal1B])
	    				{
	    					//上段テンパイ
	    					flgTop = true;
	    				}

	    				if(real1[checkVal1] == koyakuFlg && real1[checkVal1] == real2[checkVal2B])
	    				{
	    					//右下がり
	    					flgUnder = true;
	    				}

	    				if(flgTop && flgUnder)
	    				{
	    					int cnt = 0;
	    					for(cnt = 0; cnt < 5; cnt++)
			    			{
			    				if(realCheckBase + 2 + cnt >= 20)
			    				{
			    					if(real3[realCheckBase + 2 + cnt - 20] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
			    						break;
			    					}
			    				}else
			    				{
			    					//System.out.println("Code : " + realCheckBase);
			    					if(real3[realCheckBase + 2 + cnt] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt]);
			    						break;
			    					}
			    				}
			    			}

	    					if(realCheckBase + cnt >= 20)
	    					{
		    					if(real3[realCheckBase + cnt - 20] == koyakuFlg)
		    					{
		    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
		    						cnt = cnt + 2;;
		    					}
	    					}else
	    					{
	    						if(real3[realCheckBase + cnt] == koyakuFlg)
		    					{
	    							cnt = cnt + 2;
		    					}
	    					}

							realSuberi3 = realSuberi3 + (48 * (cnt));
	    				}else if(flgTop)
	    				{
	    					int cnt = 0;
	    					for(cnt = 0; cnt < 5; cnt++)
			    			{
			    				if(realCheckBase + 2 + cnt >= 20)
			    				{
			    					if(real3[realCheckBase + 2 + cnt - 20] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
			    						break;
			    					}
			    				}else
			    				{
			    					//System.out.println("Code : " + realCheckBase);
			    					if(real3[realCheckBase + 2 + cnt] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt]);
			    						break;
			    					}
			    				}
			    			}

							realSuberi3 = realSuberi3 + (48 * (cnt));
	    				}else if(flgMiddle)
	    				{
	    					int cnt = 0;
	    					for(cnt = 0; cnt < 5; cnt++)
			    			{
			    				if(realCheckBase + 1 + cnt >= 20)
			    				{
			    					if(real3[realCheckBase + 1 + cnt - 20] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
			    						break;
			    					}
			    				}else
			    				{
			    					//System.out.println("Code : " + realCheckBase);
			    					if(real3[realCheckBase + 1 + cnt] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt]);
			    						break;
			    					}
			    				}
			    			}

							realSuberi3 = realSuberi3 + (48 * (cnt));
	    				}else if(flgUnder)
	    				{
	    					int cnt = 0;
	    					for(cnt = 0; cnt < 5; cnt++)
			    			{
			    				if(realCheckBase + cnt >= 20)
			    				{
			    					if(real3[realCheckBase + cnt - 20] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
			    						break;
			    					}
			    				}else
			    				{
			    					//System.out.println("Code : " + realCheckBase);
			    					if(real3[realCheckBase + cnt] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt]);
			    						break;
			    					}
			    				}
			    			}

							realSuberi3 = realSuberi3 + (48 * (cnt));
	    				}
					}else
					{
						realSuberi3 = realSuberi3 + (48 * (suberiSet));
					}

				}else
				{
					//順押し ハズレorチェリー時

    				int checkVal1 = (realTick1 / 48) + (realSlide1  * 4);
    				int checkVal2 = (realTick2 / 48) + (realSlide2  * 4);
    				int checkVal3 = (realTick3 / 48) + (realSlide3  * 4);

    				int checkVal1B = (realTick1B / 48) + (realSlide1B  * 4);
    				int checkVal2B = (realTick2B / 48) + (realSlide2B  * 4);
    				int checkVal3B = (realTick3B / 48) + (realSlide3B  * 4);

					int realCheckBaseY = realCheckBase >= 20 ?  realCheckBase - 20 : realCheckBase;
					int realCheckBaseY1 = realCheckBase + 1 >= 20 ?  realCheckBase + 1 - 20 : realCheckBase + 1;
					int realCheckBaseY2 = realCheckBase + 2 >= 20 ?  realCheckBase + 2 - 20 : realCheckBase + 2;
					int realCheckBaseY3 = realCheckBase + 3 >= 20 ?  realCheckBase + 3 - 20 : realCheckBase + 3;
					int realCheckBaseY4 = realCheckBase + 4 >= 20 ?  realCheckBase + 4 - 20 : realCheckBase + 4;
					int realCheckBaseY5 = realCheckBase + 5 >= 20 ?  realCheckBase + 5 - 20 : realCheckBase + 5;
					int realCheckBaseY6 = realCheckBase + 6 >= 20 ?  realCheckBase + 6 - 20 : realCheckBase + 6;

					int suberiSet = -1;
					boolean bonusHitFlg = false;



					if(bonusFlg == 1)
					{
						boolean lineFlg1 = false;
						boolean lineFlg2 = false;
						boolean lineFlg3 = false;
		    			boolean lineFlg2_1 = false;
		    			boolean lineFlg2_2 = false;
		    			boolean lineFlg2_3 = false;

		    			if(real1[checkVal1] == 1 && real2[checkVal1B] == 1)
		    			{
		    				lineFlg1 = true;
		    				//lineFlg3 = true;
		    			}
		    			if(real1[checkVal2] == 1 && real2[checkVal2B] == 1)
		    			{
		    				lineFlg2 = true;
		    			}
		    			if(real1[checkVal3] == 1 && real2[checkVal3B] == 1)
		    			{
		    				//lineFlg1 = true;
		    				lineFlg3 = true;
		    			}
		    			if(real1[checkVal1] == 1 && real2[checkVal2B] == 1)
		    			{
		    				lineFlg3 = true;
		    			}
		    			if(real1[checkVal3] == 1 && real2[checkVal2B] == 1)
		    			{
		    				lineFlg1 = true;
		    			}

		    			if(real1[checkVal1] == 2 && real2[checkVal1B] == 2)
		    			{
		    				lineFlg2_1 = true;
		    				//lineFlg2_3 = true;
		    			}
		    			if(real1[checkVal2] == 2 && real2[checkVal2B] == 2)
		    			{
		    				lineFlg2_2 = true;
		    			}
		    			if(real1[checkVal3] == 2 && real2[checkVal3B] == 2)
		    			{
		    				//lineFlg2_1 = true;
		    				lineFlg2_3 = true;
		    			}
		    			if(real1[checkVal1] == 2 && real2[checkVal2B] == 2)
		    			{
		    				lineFlg2_3 = true;
		    			}
		    			if(real1[checkVal3] == 2 && real2[checkVal2B] == 2)
		    			{
		    				lineFlg2_1 = true;
		    			}

						for(suberiSet = 0; suberiSet < 5; suberiSet++)
						{
		    				int checkVal3Y = realCheckBase + 2 + suberiSet < 20 ? realCheckBase + 2 + suberiSet : (realCheckBase + suberiSet + 2 - 20);
							int checkVal2Y = realCheckBase + 1 + suberiSet < 20 ? realCheckBase + 1 + suberiSet : (realCheckBase + suberiSet + 1 - 20);
							int checkVal1Y = realCheckBase + suberiSet < 20 ? realCheckBase + suberiSet : (realCheckBase + suberiSet - 20);

							/*
			    			System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
			    	    	System.out.println("TEST_A " + koyakuFlg + ": " + lineFlg1 + " | " + lineFlg2 + " | " + lineFlg3);
			    	    	System.out.println("TEST_A " + koyakuFlg + ": " + lineFlg2_1 + " | " + lineFlg2_2 + " | " + lineFlg2_3);
			     	    	System.out.println("TEST_A : " + real1[checkVal1] + " " + real2[checkVal1B] + " " + real3[checkVal3Y]);
			     	    	System.out.println("TEST_A : " + real1[checkVal2] + " " + real2[checkVal2B] + " " + real3[checkVal2Y]);
			     	    	System.out.println("TEST_A : " + real1[checkVal3] + " " + real2[checkVal3B] + " " + real3[checkVal1Y]);
			     	    	System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
							*/

							//System.out.println("COUNT" + suberiSet + " : " + real2[checkVal3Y] + " / " + real2[checkVal2Y] + " / " + real2[checkVal1Y]);
							if((lineFlg1 && real3[checkVal3Y] == 1) || (lineFlg2 && real3[checkVal2Y] == 1) || (lineFlg3 && real3[checkVal1Y] == 1) ||
								(lineFlg2_1 && real3[checkVal3Y] == 2) || (lineFlg2_2 && real3[checkVal2Y] == 2) || (lineFlg2_3 && real3[checkVal1Y] == 2))
							{
								bonusHitFlg = true;
								break;
							}
						}
					}else if(bonusFlg == 2)
					{
						boolean lineFlg1 = false;
						boolean lineFlg2 = false;
						boolean lineFlg3 = false;
						if(real1[checkVal1] == 3 && real2[checkVal1B] == 3)
		    			{
		    				lineFlg1 = true;
		    				//lineFlg3 = true;
		    			}
		    			if(real1[checkVal2] == 3 && real2[checkVal2B] == 3)
		    			{
		    				lineFlg2 = true;
		    			}
		    			if(real1[checkVal3] == 3 && real2[checkVal3B] == 3)
		    			{
		    				//lineFlg1 = true;
		    				lineFlg3 = true;
		    			}
		    			if(real1[checkVal1] == 3 && real2[checkVal2B] == 3)
		    			{
		    				lineFlg3 = true;
		    			}
		    			if(real1[checkVal3] == 3 && real2[checkVal2B] == 3)
		    			{
		    				lineFlg1 = true;
		    			}

		    			for(suberiSet = 0; suberiSet < 5; suberiSet++)
						{
		    				int checkVal3Y = realCheckBase + 2 + suberiSet < 20 ? realCheckBase + 2 + suberiSet : (realCheckBase + suberiSet + 2 - 20);
							int checkVal2Y = realCheckBase + 1 + suberiSet < 20 ? realCheckBase + 1 + suberiSet : (realCheckBase + suberiSet + 1 - 20);
							int checkVal1Y = realCheckBase + suberiSet < 20 ? realCheckBase + suberiSet : (realCheckBase + suberiSet - 20);


							/*
			    			System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
			    	    	System.out.println("TEST_A " + koyakuFlg + ": " + lineFlg1 + " | " + lineFlg2 + " | " + lineFlg3);
			     	    	System.out.println("TEST_A : " + real1[checkVal1] + " " + real2[checkVal1B] + " " + real3[checkVal3Y]);
			     	    	System.out.println("TEST_A : " + real1[checkVal2] + " " + real2[checkVal2B] + " " + real3[checkVal2Y]);
			     	    	System.out.println("TEST_A : " + real1[checkVal3] + " " + real2[checkVal3B] + " " + real3[checkVal1Y]);
			     	    	System.out.println("/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/");
							*/

							//System.out.println("COUNT" + suberiSet + " : " + real2[checkVal3Y] + " / " + real2[checkVal2Y] + " / " + real2[checkVal1Y]);

							//System.out.println("COUNT" + suberiSet + " : " + real2[checkVal3Y] + " / " + real2[checkVal2Y] + " / " + real2[checkVal1Y]);
							if((lineFlg1 && real3[checkVal3Y] == 3) || (lineFlg2 && real3[checkVal2Y] == 3) || (lineFlg3 && real3[checkVal1Y] == 3))
							{
								bonusHitFlg = true;
								break;
							}
						}
					}


					if(!bonusHitFlg)
					{
						suberiSet = -1;
	    				if(koyakuFlg == 10 && real1[checkVal2] == 4)
	    				{
	    					if(real3[realCheckBaseY1] == 4)
	    					{
	    						suberiSet = 0;
	    					}else if(real3[realCheckBaseY2] == 4)
	    					{
	    						suberiSet = 1;
	    					}else if(real3[realCheckBaseY3] == 4)
	    					{
	    						suberiSet = 2;
	    					}else if(real3[realCheckBaseY4] == 4)
	    					{
	    						suberiSet = 3;
	    					}
	    				}else if(koyakuFlg == 10 && (real1[checkVal1] == 4 || real1[checkVal3] == 4))
	    				{
	    					if(real3[realCheckBaseY] == 4 || real3[realCheckBaseY2] == 4)
	    					{
	    						suberiSet = 0;
	    					}else if(real3[realCheckBaseY3] == 4 || real3[realCheckBaseY1] == 4)
	    					{
	    						suberiSet = 1;
	    					}else if(real3[realCheckBaseY4] == 4)
	    					{
	    						suberiSet = 2;
	    					}else if(real3[realCheckBaseY5] == 4)
	    					{
	    						suberiSet = 3;
	    					}
	    				}

						int realCheckBaseX = realCheckBase;
						int realCheckBaseX1 = realCheckBase + 1 >= 20 ?  realCheckBase + 1 - 20 : realCheckBase + 1;
						int realCheckBaseX2 = realCheckBase + 2 >= 20 ?  realCheckBase + 2 - 20 : realCheckBase + 2;

	    				if(suberiSet == -1)
	    				{
							for(suberiSet = 0; suberiSet < 4; suberiSet++)
							{
	    						realCheckBaseX = realCheckBase + suberiSet >= 20 ?  realCheckBase + suberiSet - 20 : realCheckBase + suberiSet;
	    						realCheckBaseX1 = realCheckBase + 1 + suberiSet >= 20 ?  realCheckBase + 1 + suberiSet - 20 : realCheckBase + 1 + suberiSet;
	    						realCheckBaseX2 = realCheckBase + 2 + suberiSet >= 20 ?  realCheckBase + 2 + suberiSet - 20 : realCheckBase + 2 + suberiSet;

	    						if(real2[checkVal2B] != 4)
	    						{
	    							if(real3[realCheckBaseX1] == real2[checkVal2B])
	    							{
	    								break;
	    							}
	    						}else
	    						{
	    							if(real3[realCheckBaseX1] == 5 || real3[realCheckBaseX1] == 6)
	    							{
	    								break;
	    							}
	    						}
							}
	    				}

	    				//realSuberi3 = realSuberi3 + ((checkAllLine(3,suberiSet, realCheckBase)) * 48);
					}

					realSuberi3 = realSuberi3 + ((checkAllLine(3,suberiSet, realCheckBase)) * 48);
    				//rgvjapeitguiraeuue
    				//realSuberi3 = realSuberi3 + (48 * (suberiSet));
    				//realSuberi3 = realSuberi3 + (48 * (checkAllLine(3, suberiSet)));
    				//realSuberi3 = realSuberi3 + (checkAllLine(3, suberiSet * 48));
    				//realSuberi3 = (checkAllLine(3, realSuberi3 + (suberiSet * 48)));
    				/*
    				while(!checkAllLine())
    				{
    					realSuberi3 = realSuberi3 + 48;
    				}
    				*/
				}
			}else if(realStop1 == 1 && realStop2 == 0)
			{
				//ハサミ打ち
				int checkVal1 = (realTick1 / 48) + (realSlide1  * 4);
				int checkVal2 = (realTick2 / 48) + (realSlide2  * 4);
				int checkVal3 = (realTick3 / 48) + (realSlide3  * 4);
				boolean bonusHitFlg = false;

				realStop3 = 2;
				realSuberi3 = ((192 - realTick1C) % 48);


    			int reaiCIndex = (192 * realSlide3C) + realTick3C + realSuberi3;
    			//System.out.println("TEST1 : " + reai1Index / 48);
    			int realCheckBase = -1;
    			if(reaiCIndex / 48 >= 20)
    			{
    				realCheckBase = (reaiCIndex / 48) - 20;
    			}else
    			{
    				realCheckBase = reaiCIndex / 48;
    			}



    			if(bonusFlg != -1)
    			{
    				int cnt = 0;

        			if(bonusFlg == 1)
        			{
        				boolean checkLine1_1 = false;
        				boolean checkLine1_2 = false;
        				boolean checkLine1_3 = false;

        				boolean checkLine2_1 = false;
        				boolean checkLine2_2 = false;
        				boolean checkLine2_3 = false;
        				if(real1[checkVal1] == 1)
        				{
        					checkLine1_1 = true;
        					checkLine1_3 = true;
        				}else if(real1[checkVal2] == 1)
        				{
        					checkLine1_2 = true;
        				}else if(real1[checkVal3] == 1)
        				{
        					checkLine1_1 = true;
        					checkLine1_3 = true;
        				}

        				if(real1[checkVal1] == 2)
        				{
        					checkLine2_1 = true;
        					checkLine2_3 = true;
        				}else if(real1[checkVal2] == 2)
        				{
        					checkLine2_2 = true;
        				}else if(real1[checkVal3] == 2)
        				{
        					checkLine2_1 = true;
        					checkLine2_3 = true;
        				}

        				//System.out.println("CHECK : " + checkLine1_1 + " / " + checkLine1_2 + " / " + checkLine1_3 + " / " + checkLine2_1 + " / " + checkLine2_2 + " / " + checkLine2_3);
    					for(cnt = 0; cnt < 5; cnt++)
    					{
    	    				int checkVal3Y = realCheckBase + 2 + cnt < 20 ? realCheckBase + 2 + cnt : (realCheckBase + cnt + 2 - 20);
    						int checkVal2Y = realCheckBase + 1 + cnt < 20 ? realCheckBase + 1 + cnt : (realCheckBase + cnt + 1 - 20);
    						int checkVal1Y = realCheckBase + cnt < 20 ? realCheckBase + cnt : (realCheckBase + cnt - 20);

    						//System.out.println("COUNT" + cnt + " : " + real2[checkVal3Y] + " / " + real2[checkVal2Y] + " / " + real2[checkVal1Y]);
    						if((checkLine1_1 && real3[checkVal3Y] == 1) || (checkLine1_2 && real3[checkVal2Y] == 1) || (checkLine1_3 && real3[checkVal1Y] == 1) ||
    							(checkLine2_1 && real3[checkVal3Y] == 2) || (checkLine2_2 && real3[checkVal2Y] == 2) || (checkLine2_3 && real3[checkVal1Y] == 2))
    						{
    							bonusHitFlg = true;
    							break;
    						}
    					}
        				//if(real1[checkVal1] == 1)
        			}else if(bonusFlg == 2 && (real1[checkVal3] == 3 || real1[checkVal2] == 3 || real1[checkVal1] == 3))
        			{
        				boolean checkLine1 = false;
        				boolean checkLine2 = false;
        				boolean checkLine3 = false;

        				if(real1[checkVal1] == 3)
        				{
        					checkLine1 = true;
        					checkLine3 = true;
        				}else if(real1[checkVal2] == 3)
        				{
        					checkLine2 = true;
        				}else if(real1[checkVal3] == 3)
        				{
        					checkLine1 = true;
        					checkLine3 = true;
        				}

    					for(cnt = 0; cnt < 5; cnt++)
    					{
    	    				int checkVal3Y = realCheckBase + 2 + cnt < 20 ? realCheckBase + 2 + cnt : (realCheckBase + cnt + 2 - 20);
    						int checkVal2Y = realCheckBase + 1 + cnt < 20 ? realCheckBase + 1 + cnt : (realCheckBase + cnt + 1 - 20);
    						int checkVal1Y = realCheckBase + cnt < 20 ? realCheckBase + cnt : (realCheckBase + cnt - 20);

    						if((checkLine1 && real3[checkVal3Y] == 3) || (checkLine2 && real3[checkVal2Y] == 3) || (checkLine3 && real3[checkVal1Y] == 3))
    						{
    							bonusHitFlg = true;
    							break;
    						}
    					}
        			}

					if(bonusHitFlg)
					{
						//System.out.println("LOOP" + cnt + " / " + realSuberi2);
						realSuberi3 = realSuberi3 +  (48 * cnt);
					}
    			}


    			if(!bonusHitFlg)
    			{
	    			if(koyakuFlg != -1 && koyakuFlg != 10 && koyakuFlg != 11)
					{


	        			//System.out.println("TEST1" + reaiBIndex + " / " + realCheckBase);

	    				if(koyakuFlg != -1 && koyakuFlg != 10 && koyakuFlg != 11)
	    				{
	    					int startNum = 0;
	    					int endNum = 6;
	    					int lineFlg = -1;

	    					if(real1[checkVal1] == koyakuFlg && real1[checkVal3] == koyakuFlg)
	    					{
	    						startNum = 0;
	    						endNum = 7;
	    						lineFlg = 0;
	    					}else if(real1[checkVal1] == koyakuFlg)
	    					{
	    						startNum = 0;
	    						endNum = 7;
	    						lineFlg = 1;
	    					}else if(real1[checkVal2] == koyakuFlg)
	    					{
	    						startNum = 1;
	    						endNum = 6;
	    						lineFlg = 2;
	    					}else if(real1[checkVal3] == koyakuFlg)
	    					{
	    						startNum = 0;
	    						endNum = 7;
	    						lineFlg = 3;
	    					}

	    					//System.out.println("TEST4" + startNum);

	    					int cnt = 0;
	    					for(cnt = 0; cnt < 4; cnt++)
	    					{
	    						int val1 = real3[realCheckBase + cnt >= 20 ? realCheckBase + cnt - 20 : realCheckBase + cnt];
	    						int val2 = real3[realCheckBase + 1 + cnt >= 20 ? realCheckBase + 1 + cnt - 20 : realCheckBase + cnt + 1];
	    						int val3 = real3[realCheckBase + 2 + cnt >= 20 ? realCheckBase + 2 + cnt - 20 : realCheckBase + cnt + 2];

		    					if(lineFlg == 0 && ((val1 == koyakuFlg && val3 != koyakuFlg) || (val1 != koyakuFlg && val3 == koyakuFlg)))
    							{
		    						break;
    							}else if(lineFlg == 1 && (val1 == koyakuFlg || val3 == koyakuFlg))
		    					{
    								break;
		    					}else if(lineFlg == 2 && val2 == koyakuFlg)
		    					{
		    						break;
		    					}else if(lineFlg == 3 && (val1 == koyakuFlg || val3 == koyakuFlg))
		    					{
		    						break;
		    					}
	    					}


	    					/*
	    					int cnt = 0;
	    					int cnt2 = 0;
							//左リール下段にある場合
			    			for(cnt = startNum; cnt < endNum; cnt++)
			    			{
			    				cnt2++;
			    				if(realCheckBase + cnt >= 20)
			    				{
			    					if(real3[realCheckBase + cnt - 20] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt - 20]);
			    						break;
			    					}
			    				}else
			    				{
			    					//System.out.println("Code : " + realCheckBase);
			    					if(real3[realCheckBase + cnt] == koyakuFlg)
			    					{
			    						//System.out.println("TEST2 : " + real2[realCheckBase + cnt]);
			    						break;
			    					}
			    				}
			    			}

			    			if(lineFlg == 0 || lineFlg == 1 || lineFlg == 3)
			    			{
			    				if(cnt2 == 1)
			    				{
			    					cnt2 = cnt2 + 1;
			    				}
			    			}
			    			*/
			    			//System.out.println("TEST2 : " + realCheckBase + " / " + cnt + "");

							//System.out.println("TEST3");
							realSuberi3 = realSuberi3 + (48 * cnt);

	    				}
					}else
					{
						//ハズレ はさみ打ちの場合は、子役を中段ではずす。
	    				realStop3 = 2;
	    				realSuberi3 = ((192 - realTick1C) % 48);

						int setKoyaku = -1;
						if(real1[checkVal1] == 5 || real1[checkVal1] == 6)
						{
							setKoyaku = real1[checkVal1];
						}else if(real1[checkVal3] == 5 || real1[checkVal3] == 6)
						{
							setKoyaku = real1[checkVal3];
						}else if(real1[checkVal2] == 5)
						{
							setKoyaku = 6;
						}else if(real1[checkVal2] == 6)
						{
							setKoyaku = 5;
						}

						/*
	        			int reaiCIndex = (192 * realSlide3C) + realTick3C + realSuberi3;
	        			//System.out.println("TEST1 : " + reai1Index / 48);
	        			int realCheckBase = -1;

	        			if(reaiCIndex / 48 >= 20)
	        			{
	        				realCheckBase = (reaiCIndex / 48) - 20;
	        			}else
	        			{
	        				realCheckBase = reaiCIndex / 48;
	        			}
	        			*/

						int cnt = 0;
						for(cnt = 0; cnt < 5; cnt++)
						{
    						int realCheckBaseX1 = realCheckBase + 1 + cnt >= 20 ?  realCheckBase + 1 + cnt - 20 : realCheckBase + 1 + cnt;

    						if(setKoyaku != -1)
    						{
    							if(real3[realCheckBaseX1] == setKoyaku)
    							{
    								break;
    							}
    						}else
    						{
    							if(real3[realCheckBaseX1] == 5 || real3[realCheckBaseX1] == 6)
    							{
    								break;
    							}
    						}
						}

						realSuberi3 = realSuberi3 + (48 * (cnt));
					}
    			}
			}

		}else
		{
			//realStop3 = 0;
		}
    }
}
