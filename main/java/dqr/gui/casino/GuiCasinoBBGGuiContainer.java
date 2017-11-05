package dqr.gui.casino;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmCasinoBJOdds;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.packetMessage.MessageServerFunction;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.thread.ThreadCasinoBBG;

public class GuiCasinoBBGGuiContainer extends GuiContainer
{

	//num X138(23) Y 0/36 (35)
    private static final ResourceLocation texture = new ResourceLocation("dqr", "textures/casino/bbg_background.png");
    private static final ResourceLocation texture2 = new ResourceLocation("dqr", "textures/casino/bbg_background2.png");
    protected static final ResourceLocation buttonTextures = new ResourceLocation("dqr:textures/casino/widgets3.png");

    private static final ResourceLocation IMGmonster = new ResourceLocation("dqr", "textures/casino/bbg_monster.png");


    private static final ResourceLocation IMGcartain1 = new ResourceLocation("dqr", "textures/casino/bbg_cart.png");
    private static final ResourceLocation IMGcartain2 = new ResourceLocation("dqr", "textures/casino/bbg_cart2.png");
    private static final ResourceLocation IMGcartain3 = new ResourceLocation("dqr", "textures/casino/bbg_cart3.png");
    private static final ResourceLocation IMGcartain4 = new ResourceLocation("dqr", "textures/casino/bbg_cart4.png");
    private static final ResourceLocation IMGcartain5 = new ResourceLocation("dqr", "textures/casino/bbg_cart5.png");

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

    private static final ResourceLocation textureWin = new ResourceLocation("dqr", "textures/casino/Result_Win.png");
    private static final ResourceLocation textureLose = new ResourceLocation("dqr", "textures/casino/Result_Lose.png");
    private static final ResourceLocation textureDraw = new ResourceLocation("dqr", "textures/casino/Result_Draw.png");

    private static final ResourceLocation dialog = new ResourceLocation("dqr", "textures/casino/dialog.png");

    public int[] bgaRateLose = {100, 100, 105, 165, 165, 169, 184, 184, 185, 195, 195, 195, 200, 200, 200};
    public int[] bgaRateWin = {50, 53, 68, 113, 116, 126, 166, 169, 177, 212, 215, 221, 251, 254, 258};
    public int[] bgaRateNerae = {40, 42, 55, 95, 97, 109, 129, 131, 142, 162, 162, 172, 192, 192, 201};

    public int[] suraRateLose = {80, 19, 0, 1};
    public int[] suraRateWin = {70, 23, 2, 5};
    public int[] suraRateNerae = {60, 30, 0, 10};

    public int[] suraBox = new int[5];
    //public GuiTextField commandTextField;
    public EntityPlayer epa;

    public int myCoin = 0;
    public int lastBet = -1;


    //10:敗北 11:勝利 12:DRAW
    //public int gameResult = 0;
    public EnumDqmCasinoBJOdds gameResult = null;

    public int cartainCount = 0;
    public int betCoin = 1000;
    public String playerName = null;


    public int mode = 0;
    public int gamePhase = 0;


    public int bonusFlg = -1;
    public int bgFlg = -1;
    public int cartainFlg = -1;
    public int cartainColor = 1;
    public int patternFlg = -1;

    public int mobCode = -1;
    public int mobNumber = 0;

    public int buttonPattern = -1;
    public int msgPattern = -1;
    public int attackPattern = -1;
    public int life = 180;
    public int damage = 0;
    public int playerAct = -1;
    public int posMissFix = 0;
    public int comboCount = 0;

    public int getTotalCoin = 0;
    public int getCoin = 0;
    public boolean flgCoinGet = false;
    public int soundPlay = -1;

    public boolean closeFlg = false;

    public GuiCasinoBBGGuiContainer(EntityPlayer player)
    {

        super(new GuiCasinoBJContainer(player));
        this.epa = player;
    	NBTTagCompound playerPet = ExtendedPlayerProperties3.get(player).getNBTPlayerPetList();
    	Set tags = playerPet.func_150296_c();

    	myCoin = ExtendedPlayerProperties3.get(player).getCoin();

        this.ySize = 222;
        this.xSize = 393;

        playerName = player.getCommandSenderName();



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


    	System.out.println("TEST:" + p_73869_1_ + "/" + p_73869_2_);
    	if(p_73869_2_ == 1 || p_73869_2_ == this.mc.gameSettings.keyBindInventory.getKeyCode())
    	{
    		//epa.openGui(DQR.instance, DQR.conf.GuiID_CSSlot, epa.worldObj, (int)epa.posX, (int)epa.posY, (int)epa.posZ);
    		//System.out.println("TEST:" + p_73869_1_ + "/" + p_73869_2_);
    		if(gamePhase != 0)
    		{
    			closeFlg = true;
    			return;
    		}
    	}

    	if(DQR.debug != 0)
    	{
	    	if(p_73869_2_ == 79)
	    	{
	    		mode = 1;
	    		bonusFlg = 2;
	    		patternFlg = 0;
	    		//bonusFlg = 3;
	    		//patternFlg = 0;
	    	}else if(p_73869_2_ == 80)
	    	{
	    		mode = 1;
	    		bonusFlg = 2;
	    		patternFlg = 1;
	    	}else if(p_73869_2_ == 81)
	    	{
	    		mode = 1;
	    		bonusFlg = 2;
	    		patternFlg = 2;
	    	}else if(p_73869_2_ == 82)
	    	{
	    		//bonusFlg = 3;
	    		//patternFlg = 2;
	    	}

    	}

    	if(p_73869_2_ == 57)
    	{

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
    	/*
    	if(this.commandTextField != null)
    	{
    		this.commandTextField.updateCursorCounter();
    	}
    	*/
    }

    /*
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {

    	super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);

    }
    */
    /*
        ChestとかInventoryとか文字を描画する
     */

    /*
    protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_)
    {
        super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
        boolean flag = p_73864_3_ == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100;
        Slot slot = this.getSlotAtPosition(p_73864_1_, p_73864_2_);

        if(slot != null)
        {
        	System.out.println("TEST" + slot.getSlotIndex());
        }
    }

    private Slot getSlotAtPosition(int p_146975_1_, int p_146975_2_)
    {
        for (int k = 0; k < this.inventorySlots.inventorySlots.size(); ++k)
        {
            Slot slot = (Slot)this.inventorySlots.inventorySlots.get(k);

            if (this.isMouseOverSlot(slot, p_146975_1_, p_146975_2_))
            {
                return slot;
            }
        }

        return null;
    }

    private boolean isMouseOverSlot(Slot p_146981_1_, int p_146981_2_, int p_146981_3_)
    {
        return this.func_146978_c(p_146981_1_.xDisplayPosition, p_146981_1_.yDisplayPosition, 16, 16, p_146981_2_, p_146981_3_);
    }
	*/

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
    	//System.out.println("TESTTTTTTTTTTTTT");
		int x2 = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		//mc.fontRenderer.drawString(I18n.format("msg.FarmBook.seedPat.txt"), 15, 4, 4210752);
		//mc.fontRenderer.drawString(I18n.format("msg.FarmBook.plantPat.txt"), 82, 4, 4210752);
		//String message = I18n.format("gui.container.TamingPets.title", new Object[]{});
	    //this.fontRendererObj.drawString(message, 8, 6, 4210752);

		/*
    	this.buttonList.clear();

    	this.buttonList.add(new GuiOptionButton(1, x2 + 25, y + 129, 18, 20, "<"));
    	this.buttonList.add(new GuiOptionButton(2, x2 + 134, y + 129, 18, 20, ">"));
    	*/


        //描画する文字, X, Y, 色
        //this.fontRendererObj.drawString("Item Container", 8, 6, 4210752);
        //this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
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

    	int bg2StartX = mainX + 256;
    	buttonList = new ArrayList();

    	NumberFormat nfNum = NumberFormat.getNumberInstance();
    	String test = new String();

    	//this.buttonList.add(new GuiOptionButton(1, x + 7, y + 117, 10, 20, "<"));

    	/*
    	if(mode == 0)
    	{
    		this.buttonList.add(new GuiOptionButton(2, x + 159, y + 117, 10, 20, ">"));
    	}
    	*/

    	//EnumDqmTrump

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        //System.out.println("width:" + this.width + " / height:" + this.height + " / xSize:" + this.xSize + " / ySize:" + this.ySize);

        this.mc.getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(mainX, mainY, 0, 0, 256, this.ySize);

        this.mc.getTextureManager().bindTexture(buttonTextures);
        int fontColor = 0xffffff;
        if(life == 0)
        {
        	this.drawTexturedModalRect(mainX + 12, mainY + 11, 0, 218, 105, 29);
        	fontColor = 0xFF0066;
        }else if (life < 35)
        {
        	this.drawTexturedModalRect(mainX + 12, mainY + 11, 0, 187, 105, 29);
        	fontColor = 0xFFCC66;
        }else
        {
        	this.drawTexturedModalRect(mainX + 12, mainY + 11, 0, 156, 105, 29);
        	fontColor = 0xffffff;
        }

        mc.fontRenderer.drawStringWithShadow(playerName, mainX + 12 + 4, mainY + 11 + 4, fontColor);
        mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.life.txt", new Object[]{life}), mainX + 12 + 4, mainY + 11 + 14, fontColor);
        mc.fontRenderer.drawStringWithShadow("", mainX + 12 + 4, mainY + 11 + 4, 0xffffff);

        if(bgFlg == 2)
        {
        	this.mc.getTextureManager().bindTexture(BG1B);
        }else if(bgFlg == 3)
        {
        	this.mc.getTextureManager().bindTexture(BG1C);
        }else if(bgFlg == 4)
        {
        	this.mc.getTextureManager().bindTexture(BG2A);
        }else if(bgFlg == 5)
        {
        	this.mc.getTextureManager().bindTexture(BG2B);
        }else if(bgFlg == 6)
        {
        	this.mc.getTextureManager().bindTexture(BG2C);
        }else if(bgFlg == 7)
        {
        	this.mc.getTextureManager().bindTexture(BG3A);
        }else if(bgFlg == 8)
        {
        	this.mc.getTextureManager().bindTexture(BG3B);
        }else if(bgFlg == 9)
        {
        	this.mc.getTextureManager().bindTexture(BG3C);
        }else if(bgFlg == 10)
        {
        	this.mc.getTextureManager().bindTexture(BG4A);
        }else if(bgFlg == 11)
        {
        	this.mc.getTextureManager().bindTexture(BG4B);
        }else if(bgFlg == 12)
        {
        	this.mc.getTextureManager().bindTexture(BG4C);
        }else if(bgFlg == 13)
        {
        	this.mc.getTextureManager().bindTexture(BG5A);
        }else if(bgFlg == 14)
        {
        	this.mc.getTextureManager().bindTexture(BG5B);
        }else if(bgFlg == 15)
        {
        	this.mc.getTextureManager().bindTexture(BG5C);
        }else
        {
        	this.mc.getTextureManager().bindTexture(BG1A);
        }

        this.drawTexturedModalRect(mainX + 12, mainY + 42, 13, 71, 230, 115);

        this.mc.getTextureManager().bindTexture(texture2);
        this.drawTexturedModalRect(mainX + 256, mainY, 0, 0, 137, this.ySize);

        /*
        this.buttonList.add(new GuiButtonBBG(10, mainX + 13, endY - 30, 64, 18, I18n.format("msg.casino.slot.button.stop.txt", new Object[]{})));
        this.buttonList.add(new GuiButtonBBG(10, mainX + 13, endY - 46, 64, 18, I18n.format("msg.casino.slot.button.stop.txt", new Object[]{})));
        this.buttonList.add(new GuiButtonBBG(10, mainX + 13, endY - 62, 64, 18, I18n.format("msg.casino.slot.button.stop.txt", new Object[]{})));
		*/

        //コンボ数

        String comboString = (new Integer(comboCount)).toString();

        //30-25
        //31 54 77 102
        //System.out.println("TEST:" + comboString + " / " + comboString.length());
        for(int cnt = 0; comboString.length() > cnt; cnt++ )
        {
        	char c = comboString.charAt(comboString.length()-(cnt + 1));
        	int fixVal = Character.getNumericValue(c);
        	//System.out.println("TEST3:" + c + "/" + fixVal);
        	int fixX = 0;
        	int fixY = 0;

        	if(fixVal >= 5)
        	{
        		fixX = 138 + ((fixVal - 5) * 23);
        		fixY = 36;
        	}else
        	{
        		fixX = 138 + (fixVal * 23);
        		fixY = 0;
        	}

        	//System.out.println("TEST2:" + fixX + "/" + fixY);
        	this.drawTexturedModalRect(bg2StartX + (78 - (23 * cnt)), mainY + 23, fixX, fixY, 23, 36);

        }
       	String myComboTitle = I18n.format("msg.casino.bbg.info.comboCount.txt", new Object[]{});
    	mc.fontRenderer.drawStringWithShadow(myComboTitle, bg2StartX + (133 / 2) - (mc.fontRenderer.getStringWidth(myComboTitle) / 2), mainY + 13, 0xffffffff);

        //mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.attack.0.txt", new Object[]{playerName}), mainX + 84, mainY + 174, 0xffffffff);

    	if(getCoin > 0)
    	{
    		String getCoinStr = "§l+" + nfNum.format(getCoin);
    		mc.fontRenderer.drawStringWithShadow(getCoinStr, endX - 37 - mc.fontRenderer.getStringWidth(getCoinStr), mainY + 95, 0xffff00);
    	}
    	//mc.fontRenderer.drawStringWithShadow("", 74, 104, 0xffffffff);

    	test = nfNum.format(this.getTotalCoin);
    	mc.fontRenderer.drawStringWithShadow(test, endX - 40 - mc.fontRenderer.getStringWidth(test) , mainY + 80, 0xffffffff);

    	test = I18n.format("msg.casino.bbg.info.totalgetcoin.txt", new Object[]{});
    	mc.fontRenderer.drawStringWithShadow(test, endX - 60 - (mc.fontRenderer.getStringWidth(test) / 2), mainY + 64, 0xffffffff);


        if(buttonPattern == 1)
        {
        	//ザコ戦
        	this.buttonList.add(new GuiButtonBBG(20, mainX + 13, endY - 62, 64, 18, I18n.format("msg.casino.bbg.button.attack.txt", new Object[]{})));
        }else if(buttonPattern == 2)
        {
        	//メッセージNext
        	this.buttonList.add(new GuiButtonBBG(21, mainX + 13, endY - 62, 64, 18, I18n.format("msg.casino.bbg.button.next.txt", new Object[]{})));
        }else if(buttonPattern == 3)
        {
        	//ゾーマ自力継続
        	if(mode == 1 && patternFlg == 0)
        	{
        		this.buttonList.add(new GuiButtonBBG(30, mainX + 13, endY - 62, 64, 18, I18n.format("msg.casino.bbg.button.d_guard.txt", new Object[]{}), 2));
        	}else
        	{
        		this.buttonList.add(new GuiButtonBBG(30, mainX + 13, endY - 62, 64, 18, I18n.format("msg.casino.bbg.button.d_guard.txt", new Object[]{})));
        	}

        	if(mode == 1 && patternFlg == 1)
        	{
        		this.buttonList.add(new GuiButtonBBG(31, mainX + 13, endY - 46, 64, 18, I18n.format("msg.casino.bbg.button.d_breath.txt", new Object[]{}), 2));
        	}else
        	{
        		this.buttonList.add(new GuiButtonBBG(31, mainX + 13, endY - 46, 64, 18, I18n.format("msg.casino.bbg.button.d_breath.txt", new Object[]{})));
        	}

        	if(mode == 1 && patternFlg == 2)
        	{
        		this.buttonList.add(new GuiButtonBBG(32, mainX + 13, endY - 30, 64, 18, I18n.format("msg.casino.bbg.button.d_magic.txt", new Object[]{}), 2));
        	}else
        	{
        		this.buttonList.add(new GuiButtonBBG(32, mainX + 13, endY - 30, 64, 18, I18n.format("msg.casino.bbg.button.d_magic.txt", new Object[]{})));
        	}


        }else if(buttonPattern == 4)
        {
        	//メッセージNext 対ゾーマ
        	this.buttonList.add(new GuiButtonBBG(22, mainX + 13, endY - 62, 64, 18, I18n.format("msg.casino.bbg.button.next.txt", new Object[]{})));
        }else if(buttonPattern == 5)
        {
        	//ゾーマ攻撃
        	this.buttonList.add(new GuiButtonBBG(33, mainX + 13, endY - 62, 64, 18, I18n.format("msg.casino.bbg.button.attack.txt", new Object[]{})));
        }




        if(gamePhase == 0)
        {
        	this.buttonList.add(new GuiOptionButton(10, bg2StartX + 8, endY - 28, endX - bg2StartX - 18, 20, I18n.format("msg.casino.bbg.button.start.txt", new Object[]{})));
        	this.buttonList.add(new GuiOptionButton(90, bg2StartX + 35 - 14, endY - 28 - 24, 12, 20, I18n.format("<", new Object[]{})));
        	this.buttonList.add(new GuiOptionButton(91, endX  - 11 - 12 - 14, endY - 28 - 24, 12, 20, I18n.format(">", new Object[]{})));
        }

        test = nfNum.format(this.betCoin);
    	mc.fontRenderer.drawStringWithShadow(test, endX  - 11 - 12 - 8 - mc.fontRenderer.getStringWidth(test) - 14, endY - 28 - 24 + 5, 0xffffffff);

    	String myCoinTitle = I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{});

    	mc.fontRenderer.drawStringWithShadow(I18n.format(myCoinTitle, new Object[]{}), bg2StartX + (133 / 2) - (mc.fontRenderer.getStringWidth(myCoinTitle) / 2), endY - 28 - 24 - 4 - 6, 0xffffffff);

    	/*
    	int betTextStart = endX - 45;
    	int titleSize = mc.fontRenderer.getStringWidth(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}));
    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}), betTextStart - (titleSize / 2), mainY + 184, 0xffffffff);
		*/

    	test = nfNum.format(this.myCoin);
    	mc.fontRenderer.drawStringWithShadow(test, endX  - 11 - 12 - 8 - mc.fontRenderer.getStringWidth(test) - 14, endY - 28 - 24 + 5 - 35, 0xffffffff);

    	myCoinTitle = I18n.format("msg.casino.blackjack.info.mycoin.txt", new Object[]{});
    	mc.fontRenderer.drawStringWithShadow(myCoinTitle, bg2StartX + (133 / 2) - (mc.fontRenderer.getStringWidth(myCoinTitle) / 2), endY - 28 - 24 - 40 - 6, 0xffffffff);






        this.mc.getTextureManager().bindTexture(IMGmonster);

        if(mobCode != -1)
        {
        	if(mobCode == 1)
        	{
        		this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 0, 36, 36, 36);
        		if(attackPattern == 1)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 72, 144, 36, 36);
        		}else if(attackPattern == 2)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 72, 144, 36, 36);
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 108, 144, 36, 36);
        		}
        	}else if(mobCode == 2)
        	{
        		this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 0, 72, 36, 36);
        		if(attackPattern == 1)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 72, 144, 36, 36);
        		}else if(attackPattern == 2)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 72, 144, 36, 36);
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 108, 144, 36, 36);
        		}
        	}else if(mobCode == 3)
        	{
        		this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 48, 0, 108, 36, 72);
        		if(attackPattern == 1)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 12, 72, 144, 36, 36);
        		}else if(attackPattern == 2)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 12, 72, 144, 36, 36);
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 12, 108, 144, 36, 36);
        		}
        	}else if(mobCode == 5)
        	{
        		this.drawTexturedModalRect(mainX + 128 - 54 + posMissFix, mainY + 120 - 72, 36, 0, 108, 108);
        		if(attackPattern == 1)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 36, 72, 144, 36, 36);
        		}else if(attackPattern == 2)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 36, 72, 144, 36, 36);
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 36, 108, 144, 36, 36);
        		}
        	}else
        	{
        		this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 0, 0, 36, 36);
        		if(attackPattern == 1)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 72, 144, 36, 36);
        		}else if(attackPattern == 2)
        		{
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 72, 144, 36, 36);
        			this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 108, 144, 36, 36);
        		}
        	}

        	if(msgPattern != 5 && msgPattern != 6 && msgPattern != 7 && msgPattern != 10)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.monster." + mobCode + ".txt", new Object[]{}), mainX + 84, mainY + 164, 0xffffffff);
        	}
        	//this.drawTexturedModalRect(mainX + 128 - 18, mainY + 100, 0, 0, 36, 36);
        	//this.drawTexturedModalRect(mainX + 128 - 54, mainY + 120 - 72, 36, 0, 108, 108);
        	//this.drawTexturedModalRect(mainX + 128 - 18, mainY + 120 - 18, 0, 36, 36, 36);
        }

        if(msgPattern == 1)
        {
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.attack.0.txt", new Object[]{playerName}), mainX + 84, mainY + 174, 0xffffffff);
        }else if(msgPattern == 2)
        {
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.monster." + suraBox[mobNumber] + ".txt", new Object[]{}), mainX + 84, mainY + 164, 0xffffffff);
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.attack.0.txt", new Object[]{playerName}), mainX + 84, mainY + 174, 0xffffffff);
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.monsterD." + suraBox[mobNumber] + ".txt", new Object[]{}), mainX + 84, mainY + 184, 0xffffffff);
        }else if(msgPattern == 3)
        {
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.monster." + 5 + ".txt", new Object[]{}), mainX + 84, mainY + 164, 0xffffffff);
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.zoma2.0.txt", new Object[]{}), mainX + 84, mainY + 174, 0xffffffff);
        }else if(msgPattern == 4)
        {
        	//System.out.println("TEST:" + patternFlg);
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.monster." + 5 + ".txt", new Object[]{}), mainX + 84, mainY + 164, 0xffffffff);
        	if(patternFlg == 0 || patternFlg == 5)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_attack.txt", new Object[]{}), mainX + 84, mainY + 174, 0xffffffff);
        	}else if(patternFlg == 1 || patternFlg == 6)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_magic.txt", new Object[]{}), mainX + 84, mainY + 174, 0xffffffff);
        	}else if(patternFlg == 2 || patternFlg == 7)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_breath.txt", new Object[]{}), mainX + 84, mainY + 174, 0xffffffff);
        	}

        	if(damage != 0)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_damage.txt", new Object[]{playerName, damage}), mainX + 84, mainY + 184, 0xffffffff);
        	}

        	if(gamePhase == 7)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_dead.txt", new Object[]{playerName}), mainX + 84, mainY + 194, 0xffffffff);
        	}else if(gamePhase == 31)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.zoma2.1.txt", new Object[]{playerName}), mainX + 84, mainY + 194, 0xffffffff);
        	}else if(gamePhase == 39)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_dead.txt", new Object[]{playerName}), mainX + 84, mainY + 194, 0xffffffff);
        	}
        }else if(msgPattern == 5)
        {
        	//System.out.println("TEST:" + patternFlg);
        	if(playerAct == 0)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.d_guard.txt", new Object[]{playerName}), mainX + 84, mainY + 164, 0xffffffff);
        	}else if(playerAct == 1)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.d_magic.txt", new Object[]{playerName}), mainX + 84, mainY + 164, 0xffffffff);
        	}else if(playerAct == 2)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.d_breath.txt", new Object[]{playerName}), mainX + 84, mainY + 164, 0xffffffff);
        	}

        	if(patternFlg == 0)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_attack.txt", new Object[]{}), mainX + 84, mainY + 174, 0xffffffff);
        	}else if(patternFlg == 1)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_magic.txt", new Object[]{}), mainX + 84, mainY + 174, 0xffffffff);
        	}else if(patternFlg == 2)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_breath.txt", new Object[]{}), mainX + 84, mainY + 174, 0xffffffff);
        	}

        	if(damage != 0)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_damage.txt", new Object[]{playerName, damage}), mainX + 84, mainY + 184, 0xffffffff);
        	}

        	if(gamePhase == 7)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.button.z_dead.txt", new Object[]{playerName}), mainX + 84, mainY + 194, 0xffffffff);
        	}else if(gamePhase == 21)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.zoma2.1.txt", new Object[]{playerName}), mainX + 84, mainY + 194, 0xffffffff);
        	}
        }else if(msgPattern == 7)
        {
        	if(playerAct == 0)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.d_guard.txt", new Object[]{playerName}), mainX + 84, mainY + 164, 0xffffffff);
        	}else if(playerAct == 1)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.d_magic.txt", new Object[]{playerName}), mainX + 84, mainY + 164, 0xffffffff);
        	}else if(playerAct == 2)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.d_breath.txt", new Object[]{playerName}), mainX + 84, mainY + 164, 0xffffffff);
        	}
        }else if(msgPattern == 8)
        {
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.monster." + 5 + ".txt", new Object[]{}), mainX + 84, mainY + 164, 0xffffffff);
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.attack.0.txt", new Object[]{playerName}), mainX + 84, mainY + 174, 0xffffffff);
        	if(gamePhase == 35)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.zoma2.2.txt", new Object[]{}), mainX + 84, mainY + 184, 0xffffffff);
        	}
        }else if(msgPattern == 9)
        {
        	if(gamePhase == 41 || gamePhase == 42 || gamePhase == 43)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.reverse.0.txt", new Object[]{playerName}), mainX + 84, mainY + 164, 0xffffffff);
        	}

        	if(gamePhase == 42 || gamePhase == 43)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.reverse.1.txt", new Object[]{playerName}), mainX + 84, mainY + 174, 0xffffffff);
        	}

        	if(gamePhase == 43)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.reverse.2.txt", new Object[]{playerName}), mainX + 84, mainY + 184, 0xffffffff);
        	}

        }else if(msgPattern == 10)
        {
        	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.attack.0.txt", new Object[]{playerName}), mainX + 84, mainY + 164, 0xffffffff);
        	if(gamePhase == 51 || gamePhase == 52)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.attack.1.txt", new Object[]{}), mainX + 84, mainY + 174, 0xffffffff);
        	}
        	if(gamePhase == 52)
        	{
        		mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.bbg.info.monsterD.5.txt", new Object[]{}), mainX + 84, mainY + 184, 0xffffffff);
        	}
        }



        if(cartainColor == 1)
        {
        	this.mc.getTextureManager().bindTexture(IMGcartain1);
        }else if(cartainColor == 2)
        {
        	this.mc.getTextureManager().bindTexture(IMGcartain2);
        }else if(cartainColor == 3)
        {
        	this.mc.getTextureManager().bindTexture(IMGcartain3);
        }else if(cartainColor == 4)
        {
        	this.mc.getTextureManager().bindTexture(IMGcartain4);
        }else if(cartainColor == 5)
        {
        	this.mc.getTextureManager().bindTexture(IMGcartain5);
        }

        this.drawTexturedModalRect(mainX + 11, mainY + 10, 0, cartainCount, 256, 256 - cartainCount);

        if(cartainCount < 256 && gamePhase == 1)
        {
        	cartainCount = cartainCount + 2;
        }else if(gamePhase == 1)
        {
        	gamePhase = 2;
        	ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, -1);
    		threadBBG.start();
        }

        if(cartainFlg == 1)
        {
        	if(cartainCount > 0 && (gamePhase == 7 || gamePhase == 39 || gamePhase == 52))
            {
            	cartainCount = cartainCount - 2;
            }else if(gamePhase == 7 || gamePhase == 52)
            {
            	getCoin = 0;
            	gamePhase = 0;
            	cartainFlg = -1;
            }else if(gamePhase == 39)
            {
            	gamePhase = 40;
            	cartainFlg = -1;
            	ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, -1);
        		threadBBG.start();
            }
        }else if(cartainFlg == 2)
        {
        	if(cartainCount > 0)
            {
        		getCoin = 0;
        		if(cartainCount - 3 < 0)
        		{
        			cartainCount = 0;
        		}else
        		{
        			cartainCount = cartainCount - 3;
        		}
            }else
            {
            	if(gamePhase == 21 || gamePhase == 31 || gamePhase == 35 || gamePhase == 43)
            	{
            		gamePhase = 22;
            		ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, -1);
            		threadBBG.start();
            	}
            	//cartainFlg = 3;
            }
        }else if(cartainFlg == 3)
        {
        	if(cartainCount < 256)
            {
            	cartainCount = cartainCount + 3;
            }else
            {
            	cartainFlg = -1;
            }
        }else if(cartainFlg == 4)
        {
        	if(cartainCount < 256)
            {
            	cartainCount = cartainCount + 2;
            }else
            {
            	cartainFlg = -1;
            }
        }
        //k = (this.width - 40)/ 2;
        //l = ((this.height - this.ySize) / 2) + this.ySize - 80;

        /*
        trumpSet.put(0, EnumDqmTrump.C11);
        trumpSet.put(1, EnumDqmTrump.H3);
        trumpSet.put(2, EnumDqmTrump.S7);
        */

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
    	getCoin = 0;
    	//this.epa.playSound("dqr:mob.fire", 1.0F, 1.0F);
    	//this.epa.worldObj.playSoundAtEntity(this.epa, "dqr:player.miss", 1.0F, 1.0F);
    	//System.out.println("TESTphase: " + gamePhase + " / " + p_146284_1_.id);
    	Random rand = new Random();
    	if(p_146284_1_.id == 30)
    	{
    		playerAct = 0;
    	}else if(p_146284_1_.id == 31)
    	{
    		playerAct = 1;
    	}else if(p_146284_1_.id == 32)
    	{
    		playerAct = 2;
    	}

    	if(p_146284_1_.id == 1000)
    	{
    		this.mc.thePlayer.closeScreen();
    	}else if(p_146284_1_.id == 1001)
    	{
    		closeFlg = false;
    	}

    	if(p_146284_1_.id == 91)
    	{
    		switch(betCoin){
    			case 1000: betCoin = myCoin >= 5000? 5000 : 1000; break;
    			case 5000: betCoin = myCoin >= 10000? 10000 : 1000;break;
    			case 10000: betCoin = myCoin >= 50000? 50000 : 1000;break;
    			case 50000: betCoin = myCoin >= 100000? 100000 : 1000;break;
    			case 100000: betCoin = myCoin >= 500000? 500000 : 1000;break;
    			case 500000: betCoin = myCoin >= 1000000? 1000000 : 1000;break;
    			case 1000000: betCoin = 1000; break;
    		}


    	}else if(p_146284_1_.id == 90)
    	{
    		if(betCoin == 1000)
    		{
    			if(myCoin >= 1000000 || DQR.debug == 1)
    			{
    				betCoin = 1000000;
    			}else if(myCoin >= 500000)
    			{
    				betCoin = 500000;
    			}else if(myCoin >= 100000)
    			{
    				betCoin = 100000;
    			}else if(myCoin >= 50000)
    			{
    				betCoin = 50000;
    			}else if(myCoin >= 10000)
    			{
    				betCoin = 10000;
    			}else if(myCoin >= 5000)
    			{
    				betCoin = 5000;
    			}else
    			{
    				betCoin = 1000;
    			}
    		}else
    		{
	    		switch(betCoin){
					case 5000: betCoin = 1000;break;
					case 10000: betCoin = 5000;break;
					case 50000: betCoin = 10000;break;
					case 100000: betCoin = 50000;break;
					case 500000: betCoin = 100000;break;
					case 1000000: betCoin = 500000; break;
	    		}
    		}
    	}


    	if(p_146284_1_.id == 10)
    	{
    		if(myCoin >= this.betCoin || DQR.debug > 0)
    		{
    			PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinMinus, betCoin));
    			myCoin = myCoin - betCoin;

    			cartainCount = 0;
    		    mode = -1;

    		    bonusFlg = -1;
    		    bgFlg = -1;
    		    cartainFlg = -1;
    		    patternFlg = -1;

    		    mobCode = -1;
    		    mobNumber = 0;
    		    buttonPattern = -1;
    		    msgPattern = -1;
    		    attackPattern = -1;
    		    life = 180;
    		    damage = 0;
    		    playerAct = -1;
    		    comboCount = 1;
    		    getTotalCoin = 0;
    			this.primChusen();

    			gamePhase = 1;

    		}
    		/*
    		if(this.commandTextField.getText().length() > 0 && Integer.parseInt(this.commandTextField.getText()) > 0
    				&& Integer.parseInt(this.commandTextField.getText()) <= myCoin)
    		{
	    		this.gamePhase = 1;
	    		playerStatus = 0;
	    		dealerStatus = 0;

	    		PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinMinus, Integer.parseInt(this.commandTextField.getText())));
	    		//myCoin = ExtendedPlayerProperties3.get(epa).getCoin();
	    		myCoin = myCoin - Integer.parseInt(this.commandTextField.getText());

	    		//ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, this.gamePhase, p_146284_1_.id);
	    		//threadBJ.start();
    		}
    		*/
    	}else if(p_146284_1_.id == 20)
    	{
    		buttonPattern = -1;
    		gamePhase = 3;
        	ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
    		threadBBG.start();
    	}else if(p_146284_1_.id == 21)
    	{
    		buttonPattern = -1;
		    msgPattern = -1;
		    attackPattern = -1;
    		//patternFlg = -1;

    		gamePhase = 4;
    		//mode = -1;
        	ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
    		threadBBG.start();
    	}else if(p_146284_1_.id == 22)
    	{
    		//System.out.println("TESTphase222 " + gamePhase);
    		if(gamePhase == 6)
    		{
    			//System.out.println("TESTphase333");
    			buttonPattern = -1;
    			ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
    			threadBBG.start();
    		}else if(gamePhase == 9 || gamePhase == 10 || gamePhase == 8 || gamePhase == 20)
    		{
    			buttonPattern = -1;
    			ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
    			threadBBG.start();
    		}else if(gamePhase == 7)
    		{
    			buttonPattern = -1;

    			cartainCount = 256;
    			cartainColor = 2;
    			cartainFlg = 1;
    			soundPlay = 8;
    		}else if(gamePhase == 21 || gamePhase == 31 || gamePhase == 35 || gamePhase == 43)
    		{
    			buttonPattern = -1;

    			cartainCount = 256;
    			cartainColor = 3;
    			cartainFlg = 2;

    		}else if(gamePhase == 30 || gamePhase == 38)
    		{
    			buttonPattern = -1;
    			ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
    			threadBBG.start();
    		}else if(gamePhase == 39)
    		{
    			buttonPattern = -1;

    			cartainCount = 256;
    			if(rand.nextInt(5) == 0)
    			{
    				cartainColor = 3;
    			}else
    			{
    				cartainColor = 2;
    			}
    			cartainFlg = 1;
    			soundPlay = 8;
    		}else if(gamePhase == 52)
    		{
    			buttonPattern = -1;

    			cartainCount = 256;
    			cartainColor = 5;
    			cartainFlg = 1;
    			soundPlay = 12;
    		}else
    		{
    			buttonPattern = -1;
    			gamePhase = 5;
    			ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
    			threadBBG.start();
    		}
    	}else if((p_146284_1_.id == 30 && patternFlg == 0) ||(p_146284_1_.id == 31 && patternFlg == 1) || (p_146284_1_.id == 32 && patternFlg == 2))
    	{
    		//System.out.println("TEST111");
    		gamePhase = 8;
    		buttonPattern = -1;
    		ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
			threadBBG.start();
    	}else if(p_146284_1_.id == 30 || p_146284_1_.id == 31 || p_146284_1_.id == 32)
    	{
    		//System.out.println("TEST112");
    		if(comboCount > 20)
    		{
	    		gamePhase = 50;

    		}else
    		{
    			gamePhase = 9;
    		}

    		buttonPattern = -1;
    		ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
			threadBBG.start();
    	}else if(p_146284_1_.id == 33)
    	{
    		buttonPattern = -1;
    		gamePhase = 34;
        	ThreadCasinoBBG threadBBG = new ThreadCasinoBBG(epa, this, this.gamePhase, p_146284_1_.id);
    		threadBBG.start();
    	}


    	/*
    	else if(this.gamePhase == 2)
    	{
    		if(p_146284_1_.id == 1)
    		{
    			this.gamePhase = -1;
    			//ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, 2, p_146284_1_.id);
        		//threadBJ.start();
    		}else if(p_146284_1_.id == 2)
    		{
    			this.gamePhase = 3;
    			//ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, 3, p_146284_1_.id);
        		//threadBJ.start();
    		}else if(p_146284_1_.id == 5)
    		{
    			this.gamePhase = 4;
    			//ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, 4, p_146284_1_.id);
        		//threadBJ.start();
    		}else if(p_146284_1_.id == 3)
    		{

    		}
    	}
    	*/
    }


    public boolean isAllowKey(int s) {
        return s == 211 || s == 213 || s == 215 || s == 214;

    }

    public boolean isNumber1(String s) {
        return Pattern.compile("^-?[0-9]+$").matcher(s).find();
    }

    public void primChusen()
    {
    	//フラグ抽選
    	Random rand = new Random();

    	int flgVal = rand.nextInt(100);

    	if(flgVal < 80)
    	{
    		//確定勝利
    		bonusFlg = 1;
    		rand = new Random();
    		int[] bgaRate = bgaRateWin;
    		flgVal = rand.nextInt(bgaRate[14]);

    		if(flgVal < bgaRate[0]){
    			bgFlg = 1;
    		}else if(flgVal < bgaRate[1]){
    			bgFlg = 2;
    		}else if(flgVal < bgaRate[2]){
    			bgFlg = 3;
    		}else if(flgVal < bgaRate[3]){
    			bgFlg = 4;
    		}else if(flgVal < bgaRate[4]){
    			bgFlg = 5;
    		}else if(flgVal < bgaRate[5]){
    			bgFlg = 6;
    		}else if(flgVal < bgaRate[6]){
    			bgFlg = 7;
    		}else if(flgVal < bgaRate[7]){
    			bgFlg = 8;
    		}else if(flgVal < bgaRate[8]){
    			bgFlg = 9;
    		}else if(flgVal < bgaRate[9]){
    			bgFlg = 10;
    		}else if(flgVal < bgaRate[10]){
    			bgFlg = 11;
    		}else if(flgVal < bgaRate[11]){
    			bgFlg = 12;
    		}else if(flgVal < bgaRate[12]){
    			bgFlg = 13;
    		}else if(flgVal < bgaRate[13]){
    			bgFlg = 14;
    		}else if(flgVal < bgaRate[14]){
    			bgFlg = 15;
    		}

    		rand = new Random();
    		flgVal = rand.nextInt(105);

    		if(flgVal < 10)
    		{
    			patternFlg = 1;
    		}else if(flgVal < 60)
    		{
    			patternFlg = 0;
    		}else if(flgVal < 70)
    		{
    			patternFlg = 2;
    		}else if(flgVal < 90)
    		{
    			patternFlg = 4;
    		}else if(flgVal < 95)
    		{
    			patternFlg = 5;
    		}else if(flgVal < 100)
    		{
    			patternFlg = 6;
    		}else if(flgVal < 105)
    		{
    			patternFlg = 7;
    		}

    	}else if(flgVal < 95)
    	{
    		//自力引き戻し
    		int[] bgaRate = bgaRateNerae;
    		bonusFlg = 2;
    		rand = new Random();
    		flgVal = rand.nextInt(bgaRate[14]);

    		if(flgVal < bgaRate[0]){
    			bgFlg = 1;
    		}else if(flgVal < bgaRate[1]){
    			bgFlg = 2;
    		}else if(flgVal < bgaRate[2]){
    			bgFlg = 3;
    		}else if(flgVal < bgaRate[3]){
    			bgFlg = 4;
    		}else if(flgVal < bgaRate[4]){
    			bgFlg = 5;
    		}else if(flgVal < bgaRate[5]){
    			bgFlg = 6;
    		}else if(flgVal < bgaRate[6]){
    			bgFlg = 7;
    		}else if(flgVal < bgaRate[7]){
    			bgFlg = 8;
    		}else if(flgVal < bgaRate[8]){
    			bgFlg = 9;
    		}else if(flgVal < bgaRate[9]){
    			bgFlg = 10;
    		}else if(flgVal < bgaRate[10]){
    			bgFlg = 11;
    		}else if(flgVal < bgaRate[11]){
    			bgFlg = 12;
    		}else if(flgVal < bgaRate[12]){
    			bgFlg = 13;
    		}else if(flgVal < bgaRate[13]){
    			bgFlg = 14;
    		}else if(flgVal < bgaRate[14]){
    			bgFlg = 15;
    		}

    		rand = new Random();
    		patternFlg = rand.nextInt(3);


    		//g4ht42-9uy924do
    		rand = new Random();
    		if(rand.nextInt(4) == 0)
    		{
    			rand = new Random();
    			if(rand.nextInt(3) == 0)
    			{
    				mode = 1;
    			}else
    			{
    	    		//敗北
    	    		bonusFlg = 3;
    	    		bgaRate = new int[15];
    	    		bgaRate = bgaRateLose;
    	    		rand = new Random();
    	    		flgVal = rand.nextInt(bgaRate[14]);

    	    		if(flgVal < bgaRate[0]){
    	    			bgFlg = 1;
    	    		}else if(flgVal < bgaRate[1]){
    	    			bgFlg = 2;
    	    		}else if(flgVal < bgaRate[2]){
    	    			bgFlg = 3;
    	    		}else if(flgVal < bgaRate[3]){
    	    			bgFlg = 4;
    	    		}else if(flgVal < bgaRate[4]){
    	    			bgFlg = 5;
    	    		}else if(flgVal < bgaRate[5]){
    	    			bgFlg = 6;
    	    		}else if(flgVal < bgaRate[6]){
    	    			bgFlg = 7;
    	    		}else if(flgVal < bgaRate[7]){
    	    			bgFlg = 8;
    	    		}else if(flgVal < bgaRate[8]){
    	    			bgFlg = 9;
    	    		}else if(flgVal < bgaRate[9]){
    	    			bgFlg = 10;
    	    		}else if(flgVal < bgaRate[10]){
    	    			bgFlg = 11;
    	    		}else if(flgVal < bgaRate[11]){
    	    			bgFlg = 12;
    	    		}else if(flgVal < bgaRate[12]){
    	    			bgFlg = 13;
    	    		}else if(flgVal < bgaRate[13]){
    	    			bgFlg = 14;
    	    		}else if(flgVal < bgaRate[14]){
    	    			bgFlg = 15;
    	    		}

    	    		rand = new Random();
    	    		flgVal = rand.nextInt(100);

    	    		if(flgVal < 20)
    	    		{
    	    			patternFlg = 0;
    	    		}else if(flgVal < 60)
    	    		{
    	    			patternFlg = 1;
    	    		}else
    	    		{
    	    			patternFlg = 2;
    	    		}

    	    		//System.out.println("TEST2?" + patternFlg);
    			}
    		}else
    		{
    			mode = 2;
    		}

    	}else
    	{
    		//敗北
    		bonusFlg = 3;
    		int[] bgaRate = bgaRateLose;
    		rand = new Random();
    		flgVal = rand.nextInt(bgaRate[14]);

    		if(flgVal < bgaRate[0]){
    			bgFlg = 1;
    		}else if(flgVal < bgaRate[1]){
    			bgFlg = 2;
    		}else if(flgVal < bgaRate[2]){
    			bgFlg = 3;
    		}else if(flgVal < bgaRate[3]){
    			bgFlg = 4;
    		}else if(flgVal < bgaRate[4]){
    			bgFlg = 5;
    		}else if(flgVal < bgaRate[5]){
    			bgFlg = 6;
    		}else if(flgVal < bgaRate[6]){
    			bgFlg = 7;
    		}else if(flgVal < bgaRate[7]){
    			bgFlg = 8;
    		}else if(flgVal < bgaRate[8]){
    			bgFlg = 9;
    		}else if(flgVal < bgaRate[9]){
    			bgFlg = 10;
    		}else if(flgVal < bgaRate[10]){
    			bgFlg = 11;
    		}else if(flgVal < bgaRate[11]){
    			bgFlg = 12;
    		}else if(flgVal < bgaRate[12]){
    			bgFlg = 13;
    		}else if(flgVal < bgaRate[13]){
    			bgFlg = 14;
    		}else if(flgVal < bgaRate[14]){
    			bgFlg = 15;
    		}

    		rand = new Random();
    		flgVal = rand.nextInt(100);

    		if(flgVal < 20)
    		{
    			patternFlg = 0;
    		}else if(flgVal < 60)
    		{
    			patternFlg = 1;
    		}else
    		{
    			patternFlg = 2;
    		}

    		//System.out.println("TEST2?" + patternFlg);
    	}

    	for(int cnt = 0; cnt < 5; cnt++)
    	{
    		suraBox[cnt] = getSuraCode();
    	}
    }

    public int getSuraCode()
    {
    	int ret = 0;
    	Random rand = new Random();
    	int randVal = rand.nextInt(100);

    	if(bonusFlg == 1)
    	{
    		if(randVal < 70)
    		{
    			ret = 0;
    		}else if(randVal < 93)
    		{
    			ret = 1;
    		}else if(randVal < 95)
    		{
    			ret = 2;
    		}else
    		{
    			ret = 3;
    		}
    	}else if(bonusFlg == 2)
    	{
    		if(randVal < 60)
    		{
    			ret = 0;
    		}else if(randVal < 90)
    		{
    			ret = 1;
    		}else
    		{
    			ret = 3;
    		}
    	}else
    	{
    		if(randVal < 80)
    		{
    			ret = 0;
    		}else if(randVal < 99)
    		{
    			ret = 1;
    		}else
    		{
    			ret = 3;
    		}
    	}

    	return ret;
    }

    public void doSoundPlay()
    {
    	if(soundPlay == 1)
    	{
    		epa.playSound("dqr:mob.hit", 0.9F, 1.0F);
    	}else if (soundPlay == 2)
    	{
    		epa.playSound("dqr:player.sl_hit", 0.6F, 1.0F);
    	}else if (soundPlay == 3)
    	{
    		epa.playSound("dqr:player.sl_hit", 0.6F, 1.0F);
    	}else if (soundPlay == 4)
    	{
    		epa.playSound("dqr:player.kiseki", 0.8F, 1.0F);
    	}else if (soundPlay == 5)
    	{
    		epa.playSound("dqr:player.jumon", 0.8F, 1.0F);
    	}else if (soundPlay == 6)
    	{
    		epa.playSound("dqr:mob.fire", 0.8F, 1.0F);
    	}else if (soundPlay == 7)
    	{
    		epa.playSound("dqr:player.damage", 0.8F, 1.0F);
    	}else if (soundPlay == 8)
    	{
    		epa.playSound("dqr:player.bbg_over", 0.8F, 1.0F);
    	}else if (soundPlay == 9)
    	{
    		epa.playSound("dqr:player.kaisin", 0.8F, 1.0F);
    	}else if (soundPlay == 11)
    	{
    		epa.playSound("dqr:mob.death", 0.8F, 1.0F);
    	}else if (soundPlay == 12)
    	{
    		epa.playSound("dqr:player.bbg_clear", 0.8F, 1.0F);
    	}else if (soundPlay == 13)
    	{
    		epa.playSound("dqr:mob.boss", 0.9F, 1.0F);
    	}else if (soundPlay == 14)
    	{
    		epa.playSound("dqr:player.miss", 0.9F, 1.0F);
    	}

    	soundPlay = -1;
    }
}
