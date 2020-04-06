package dqr.gui.casino;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.api.enums.EnumDqmTrump;
import dqr.packetMessage.MessageServerFunction;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.thread.ThreadCasinoPK;

public class GuiCasinoPKGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr", "textures/casino/pk_background.png");
    private static final ResourceLocation texture2 = new ResourceLocation("dqr", "textures/casino/pk_background2.png");

    private static final ResourceLocation textureWin = new ResourceLocation("dqr", "textures/casino/Result_Win.png");
    private static final ResourceLocation textureLose = new ResourceLocation("dqr", "textures/casino/Result_Lose.png");
    private static final ResourceLocation textureDraw = new ResourceLocation("dqr", "textures/casino/Result_Draw.png");

    private static final ResourceLocation dialog = new ResourceLocation("dqr", "textures/casino/dialog.png");

    public GuiTextField commandTextField;
    private EntityPlayer epa;
    private int mode = 0;
    public LinkedHashMap<Integer, EnumDqmTrump> trumpSet;
    //public int playerAceBigCounter = 0;
    //public LinkedHashMap<Integer, EnumDqmTrump> trumpSetDeal;
    public ArrayList<EnumDqmTrump> trumpDeck;
    public int[] trumpDeckRev;
    public int gamePhase = 0;
    public int myCoin = 0;

    //0:無し 1:通常 2:BlackJack 3:BURST 4:PureBJ
    public int playerStatus = 0;
    public int dealerStatus = 0;

    //10:敗北 11:勝利 12:DRAW
    //public int gameResult = 0;
    public EnumDqmCasinoPKOdds gameResult = null;
    public boolean closeFlg = false;

    public int soundPlay = -1;
    public GuiCasinoPKGuiContainer(EntityPlayer player)
    {

        super(new GuiCasinoBJContainer(player));
        this.epa = player;
    	//NBTTagCompound playerPet = ExtendedPlayerProperties3.get(player).getNBTPlayerPetList();
    	//Set tags = playerPet.func_150296_c();

    	myCoin = ExtendedPlayerProperties3.get(player).getCoin();

        this.ySize = 222;
        this.xSize = 384;

    	playerStatus = 0;
    	dealerStatus = 0;
    	trumpSet = new LinkedHashMap<Integer, EnumDqmTrump>();
    	trumpDeck = new ArrayList<EnumDqmTrump>();

    	EnumDqmTrump[] data = EnumDqmTrump.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(14 > data[cnt].getValue()&& data[cnt].getValue() > 0)
    		{
    			trumpDeck.add(data[cnt]);
    		}
    	}

    	trumpDeck.add(EnumDqmTrump.JK1);
    }

    public void initGui()
    {

    	super.initGui();


    }

    protected void keyTyped(char p_73869_1_, int p_73869_2_)
    {

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
    	//this.buttonList.add(new GuiOptionButton(1, x + 7, y + 117, 10, 20, "<"));




    	if(this.gamePhase == 2 && !closeFlg)
    	{
    		for(int cnt = 0; cnt < 5; cnt++)
    		if(trumpDeckRev[cnt] == 1)
    		{
    			this.buttonList.add(new GuiButtonPK(10 + cnt, halfX - 20 + (50 * (cnt - 2)), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
    		}else
    		{
    			this.buttonList.add(new GuiButtonPK(10 + cnt, halfX - 20 + (50 * (cnt - 2)), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.change.txt", new Object[]{})));
    		}

    		this.buttonList.add(new GuiButton(20, halfX - 45, halfY + 65, 90, 20, I18n.format("msg.casino.poker.button.next.txt", new Object[]{})));
    		/*
    		this.buttonList.add(new GuiButtonPK(11, halfX - 20 - (50 * 1), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
    		this.buttonList.add(new GuiButtonPK(12, halfX - 20 - (50 * 2), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
    		this.buttonList.add(new GuiButtonPK(13, halfX - 20 + (50 * 1), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.change.txt", new Object[]{})));
    		this.buttonList.add(new GuiButtonPK(14, halfX - 20 + (50 * 2), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
    		*/
    	}

    	if(this.gamePhase == 21 && !closeFlg)
    	{
    		for(int cnt = 0; cnt < 5; cnt++)
    		if(trumpDeckRev[cnt] == 1)
    		{
    			this.buttonList.add(new GuiButtonPK(10 + cnt, halfX - 20 + (50 * (cnt - 2)), halfY + 35, 40, 20, I18n.format("!?", new Object[]{})));
    		}else
    		{
    			this.buttonList.add(new GuiButtonPK(10 + cnt, halfX - 20 + (50 * (cnt - 2)), halfY + 35, 40, 20, I18n.format("?!", new Object[]{})));
    		}

    		this.buttonList.add(new GuiButton(30, halfX - 45, halfY + 65, 90, 20, I18n.format("msg.casino.poker.button.next.txt", new Object[]{})));
    		/*
    		this.buttonList.add(new GuiButtonPK(11, halfX - 20 - (50 * 1), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
    		this.buttonList.add(new GuiButtonPK(12, halfX - 20 - (50 * 2), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
    		this.buttonList.add(new GuiButtonPK(13, halfX - 20 + (50 * 1), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.change.txt", new Object[]{})));
    		this.buttonList.add(new GuiButtonPK(14, halfX - 20 + (50 * 2), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
    		*/
    	}
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

        this.mc.getTextureManager().bindTexture(texture2);
        this.drawTexturedModalRect(mainX + 251, mainY, 0, 0, 137, this.ySize);


        /*
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D10.getRc());
		this.drawTexturedModalRect(halfX - 20 - (50 * 0), halfY - 30, 0, 0, 40, 60);
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D11.getRc());
		this.drawTexturedModalRect(halfX - 20 - (50 * 1), halfY - 30, 0, 0, 40, 60);
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D1.getRc());
		this.drawTexturedModalRect(halfX - 20 - (50 * 2), halfY - 30, 0, 0, 40, 60);
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.JK1.getRc());
		this.drawTexturedModalRect(halfX - 20 + (50 * 1), halfY - 30, 0, 0, 40, 60);
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D13.getRc());
		this.drawTexturedModalRect(halfX - 20 + (50 * 2), halfY - 30, 0, 0, 40, 60);
		*/
        if(trumpSet.size() > 0)
        {
        	for(int cnt = 0; cnt < trumpSet.size(); cnt++)
        	{
        		if(trumpDeckRev[cnt] == 1)
        		{
        			this.mc.getTextureManager().bindTexture(((EnumDqmTrump)trumpSet.get(cnt)).getRc());
        			this.drawTexturedModalRect(halfX - 20 + (50 * (cnt - 2)), halfY - 30, 0, 0, 40, 60);
        		}else if(trumpDeckRev[cnt] == -1)
        		{
        			this.mc.getTextureManager().bindTexture(EnumDqmTrump.JK2.getRc());
        			this.drawTexturedModalRect(halfX - 20 + (50 * (cnt - 2)), halfY - 30, 0, 0, 40, 60);
        		}else
        		{
        			this.mc.getTextureManager().bindTexture(EnumDqmTrump.DEF.getRc());
        			this.drawTexturedModalRect(halfX - 20 + (50 * (cnt - 2)), halfY - 30, 0, 0, 40, 60);
        		}

        	}
        }



    	NumberFormat nfNum = NumberFormat.getNumberInstance();

        //RateInformation
        mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.blackjack.info.odds.txt", new Object[]{}), mainX + 8 + 3 , mainY + 8, 0xffffffff);
        for(int cnt = 0; cnt < 5; cnt++)
        {
        	EnumDqmCasinoPKOdds enumOdds = DQR.enumGetter.getCasinoPKOddsFromId(cnt);

        	String msg = I18n.format(enumOdds.getLangKey(), new Object[]{enumOdds.getOdds()});
    		if(gameResult != null && gameResult.getId() == cnt)
    		{
    			mc.fontRenderer.drawStringWithShadow(msg, mainX + 8 + 3 , mainY + 19 + (9 * cnt), 0xffffff00);
    		}else
    		{
    			mc.fontRenderer.drawStringWithShadow(msg, mainX + 8 + 3 , mainY + 19 + (9 * cnt), 0xffffffff);
    		}


        	if(this.commandTextField != null && this.commandTextField.getText().length() > 0)
        	{
        		int bedCoin = Integer.parseInt(this.commandTextField.getText());
        		String msg2 = nfNum.format(bedCoin * enumOdds.getOdds());
        		if(((float)bedCoin * enumOdds.getOdds()) < 1.0f)
        		{
        			msg2 = "0";
        		}
        		if(gameResult != null && gameResult.getId() == cnt)
        		{
        			mc.fontRenderer.drawStringWithShadow(msg2, mainX + 146 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * cnt), 0xffffff00);
        			mc.fontRenderer.drawStringWithShadow("", mainX + 146 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * cnt), 0xffffffff);
        		}else
        		{
        			mc.fontRenderer.drawStringWithShadow(msg2, mainX + 146 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * cnt), 0xffffffff);
        		}
        	}else
        	{

				String msg2 = nfNum.format(0);
				//System.out.println("TEST : " + msg + " : " + endX + " : " + mc.fontRenderer.getStringWidth(msg) + " : " + (endX - 8 - mc.fontRenderer.getStringWidth(msg)));
				mc.fontRenderer.drawStringWithShadow(msg2, mainX + 146 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * cnt), 0xffffffff);
        	}
        }


        for(int cnt = 5; cnt < 10; cnt++)
        {
        	EnumDqmCasinoPKOdds enumOdds = DQR.enumGetter.getCasinoPKOddsFromId(cnt);

        	String msg = I18n.format(enumOdds.getLangKey(), new Object[]{enumOdds.getOdds()});
    		if(gameResult != null && gameResult.getId() == cnt)
    		{
    			mc.fontRenderer.drawStringWithShadow(msg, mainX + 150 + 3 , mainY + 19 + (9 * (cnt - 5)), 0xffffff00);
    		}else
    		{
    			mc.fontRenderer.drawStringWithShadow(msg, mainX + 150 + 3 , mainY + 19 + (9 * (cnt - 5)), 0xffffffff);
    		}


        	if(this.commandTextField != null && this.commandTextField.getText().length() > 0)
        	{
        		int bedCoin = Integer.parseInt(this.commandTextField.getText());
        		String msg2 = nfNum.format(bedCoin * enumOdds.getOdds());
        		if(((float)bedCoin * enumOdds.getOdds()) < 1.0f)
        		{
        			msg2 = "0";
        		}
        		if(gameResult != null && gameResult.getId() == cnt)
        		{
        			mc.fontRenderer.drawStringWithShadow(msg2, mainX + 287 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * (cnt - 5)), 0xffffff00);
        			mc.fontRenderer.drawStringWithShadow("", mainX + 287 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * (cnt - 5)), 0xffffffff);
        		}else
        		{
        			mc.fontRenderer.drawStringWithShadow(msg2, mainX + 287 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * (cnt - 5)), 0xffffffff);
        		}
        	}else
        	{

				String msg2 = nfNum.format(0);
				//System.out.println("TEST : " + msg + " : " + endX + " : " + mc.fontRenderer.getStringWidth(msg) + " : " + (endX - 8 - mc.fontRenderer.getStringWidth(msg)));
				mc.fontRenderer.drawStringWithShadow(msg2, mainX + 287 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * (cnt - 5)), 0xffffffff);
        	}
        }

        /*
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D10.getRc());
		this.drawTexturedModalRect(halfX - 20 - (50 * 0), halfY - 30, 0, 0, 40, 60);
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D11.getRc());
		this.drawTexturedModalRect(halfX - 20 - (50 * 1), halfY - 30, 0, 0, 40, 60);
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D1.getRc());
		this.drawTexturedModalRect(halfX - 20 - (50 * 2), halfY - 30, 0, 0, 40, 60);
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.JK1.getRc());
		this.drawTexturedModalRect(halfX - 20 + (50 * 1), halfY - 30, 0, 0, 40, 60);
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D13.getRc());
		this.drawTexturedModalRect(halfX - 20 + (50 * 2), halfY - 30, 0, 0, 40, 60);
		*/

		/*
		this.buttonList.add(new GuiButtonPK(11, halfX - 20 - (50 * 0), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
		this.buttonList.add(new GuiButtonPK(12, halfX - 20 - (50 * 1), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
		this.buttonList.add(new GuiButtonPK(13, halfX - 20 - (50 * 2), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
		this.buttonList.add(new GuiButtonPK(14, halfX - 20 + (50 * 1), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.change.txt", new Object[]{})));
		this.buttonList.add(new GuiButtonPK(15, halfX - 20 + (50 * 2), halfY + 35, 40, 20, I18n.format("msg.casino.poker.button.hold.txt", new Object[]{})));
		*/


    	//this.commandTextField.setTextColor(0xffffffff);
    	//this.commandTextField.drawTextBox();
        if(this.commandTextField != null)
        {
        	this.commandTextField.xPosition = endX - 48 - 4 - 36;
        	this.commandTextField.yPosition = mainY + 48;
        	this.commandTextField.setTextColor(0xffffffff);
        	this.commandTextField.drawTextBox();
        }else
        {
            //this.commandTextField = new GuiTextField(this.fontRendererObj, endX - 48 - 4 - 36, halfY - 20, 36, 20);
        	this.commandTextField = new GuiTextField(this.fontRendererObj, endX - 48 - 3 - 36, mainY + 48, 36, 18);
            this.commandTextField.setMaxStringLength(7);
            this.commandTextField.setEnabled(true);
            this.commandTextField.setFocused(true);

            this.commandTextField.setTextColor(0xffffffff);
        	this.commandTextField.drawTextBox();
        }

    	if(this.gamePhase == 0)
    	{
    		this.buttonList.add(new GuiOptionButton(6, endX - 40 - 8, mainY + 47, 40, 20, I18n.format("msg.casino.blackjack.button.ready.txt", new Object[]{})));
    	}

    	int betTextStart = endX - 48 - 4 - 36;
    	int titleSize = mc.fontRenderer.getStringWidth(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}));


    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}), mainX + 297, mainY + 39, 0xffffffff);


    	String test = nfNum.format(this.myCoin);
    	mc.fontRenderer.drawStringWithShadow(test, mainX + 353 - mc.fontRenderer.getStringWidth(test), mainY + 21, 0xffffffff);


    	String myCoinTitle = I18n.format("msg.casino.blackjack.info.mycoin.txt", new Object[]{});
    	mc.fontRenderer.drawStringWithShadow(myCoinTitle, mainX + 297, mainY + 8, 0xffffffff);



    	if(gameResult != null)
    	{
    		if(gameResult == EnumDqmCasinoPKOdds.OddsLose)
    		{
    	        this.mc.getTextureManager().bindTexture(textureLose);
    	        this.drawTexturedModalRect(halfX - 72, halfY - 27, 0, 0, 145, 54);
    		}else
    		{
    	        this.mc.getTextureManager().bindTexture(textureWin);
    	        this.drawTexturedModalRect(halfX - 66, halfY - 27, 0, 0, 113, 54);
    		}
    	}
    	/*
    	String test1 = I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{});
    	String test2 = I18n.format("msg.casino.blackjack.info.bet2.txt", new Object[]{});
    	System.out.println("TEST1 : " + test1 + mc.fontRenderer.getStringWidth(test1) + test2 + mc.fontRenderer.getStringWidth(test2) + " / " + mc.fontRenderer.getStringWidth("Bet"));
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
    	//this.epa.playSound("dqr:mob.fire", 1.0F, 1.0F);
    	//this.epa.worldObj.playSoundAtEntity(this.epa, "dqr:player.miss", 1.0F, 1.0F);

    	if(p_146284_1_.id == 1000)
    	{
    		this.mc.thePlayer.closeScreen();
    	}else if(p_146284_1_.id == 1001)
    	{
    		closeFlg = false;
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

	    		ThreadCasinoPK threadBJ = new ThreadCasinoPK(epa, this, this.gamePhase, p_146284_1_.id);
	    		threadBJ.start();
    		}
    	}else if(p_146284_1_.id >= 10 && 15 > p_146284_1_.id)
    	{
    		if(this.gamePhase == 21 && !closeFlg)
    		{
    			int mp = ExtendedPlayerProperties.get(epa).getMP();
    			if(mp >= EnumDqmSkillJ.JSKILL_0_12.getNeedpt_Val())
    			{
		    		if(this.trumpDeckRev[p_146284_1_.id - 10] == 1)
		    		{
		    			this.trumpDeckRev[p_146284_1_.id - 10] = -1;
		    			for(int cnt = 0; cnt < 5; cnt++)
		    			{
		    				if(p_146284_1_.id - 10 != cnt)
		    				{
		    					this.trumpDeckRev[cnt] = 1;
		    				}
		    			}
		    		}else if(this.trumpDeckRev[p_146284_1_.id - 10] == -1)
		    		{
		    			this.trumpDeckRev[p_146284_1_.id - 10] = 1;
		    		}
    			}else
    			{
    				epa.playSound("dqr:player.pi", 1.0F, 1.0F);
    			}
    		}else
    		{
	    		if(this.trumpDeckRev[p_146284_1_.id - 10] == 0)
	    		{
	    			this.trumpDeckRev[p_146284_1_.id - 10] = 1;
	    		}else if(this.trumpDeckRev[p_146284_1_.id - 10] == 1)
	    		{
	    			this.trumpDeckRev[p_146284_1_.id - 10] = 0;
	    		}
    		}
    	}else if(p_146284_1_.id == 20)
    	{
			this.gamePhase = 3;
			ThreadCasinoPK threadBJ = new ThreadCasinoPK(epa, this, 3, p_146284_1_.id);
    		threadBJ.start();
    		//egbywyhbyrt
    	}else if(p_146284_1_.id == 30)
    	{
			this.gamePhase = 30;
			ThreadCasinoPK threadBJ = new ThreadCasinoPK(epa, this, 30, p_146284_1_.id);
    		threadBJ.start();
    		//egbywyhbyrt
    	}

    	/*else if(this.gamePhase == 2)
    	{
    		if(p_146284_1_.id == 1)
    		{
    			this.gamePhase = -1;
    			ThreadsCasinoBJ threadBJ = new ThreadsCasinoBJ(epa, this, 2, p_146284_1_.id);
        		threadBJ.start();
    		}else if(p_146284_1_.id == 2)
    		{
    			this.gamePhase = 3;
    			ThreadsCasinoBJ threadBJ = new ThreadsCasinoBJ(epa, this, 3, p_146284_1_.id);
        		threadBJ.start();
    		}else if(p_146284_1_.id == 5)
    		{
    			this.gamePhase = 4;
    			ThreadsCasinoBJ threadBJ = new ThreadsCasinoBJ(epa, this, 4, p_146284_1_.id);
        		threadBJ.start();
    		}else if(p_146284_1_.id == 3)
    		{
    			//DOUBLE
    			int bed = Integer.parseInt(this.commandTextField.getText());
    			if(myCoin >= bed)
    			{
    				this.commandTextField.setText(String.valueOf(bed * 2));
    	    		PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinMinus, Integer.parseInt(this.commandTextField.getText())));
    	    		//myCoin = ExtendedPlayerProperties3.get(epa).getCoin();
    	    		myCoin = myCoin - Integer.parseInt(this.commandTextField.getText());

	    			this.gamePhase = 2;
	    			ThreadsCasinoBJ threadBJ = new ThreadsCasinoBJ(epa, this, 2, p_146284_1_.id);
	        		threadBJ.start();
    			}
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
