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
import dqr.api.enums.EnumDqmCasinoBJOdds;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.api.enums.EnumDqmTrump;
import dqr.packetMessage.MessageServerFunction;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.thread.ThreadCasinoBJ;

public class GuiCasinoBJGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr", "textures/casino/bj_background.png");
    private static final ResourceLocation texture2 = new ResourceLocation("dqr", "textures/casino/bj_background2.png");

    private static final ResourceLocation textureWin = new ResourceLocation("dqr", "textures/casino/Result_Win.png");
    private static final ResourceLocation textureLose = new ResourceLocation("dqr", "textures/casino/Result_Lose.png");
    private static final ResourceLocation textureDraw = new ResourceLocation("dqr", "textures/casino/Result_Draw.png");

    private static final ResourceLocation dialog = new ResourceLocation("dqr", "textures/casino/dialog.png");

    public GuiTextField commandTextField;
    private EntityPlayer epa;
    private int mode = 0;
    public LinkedHashMap<Integer, EnumDqmTrump> trumpSet;
    public int playerAceBigCounter = 0;
    public LinkedHashMap<Integer, EnumDqmTrump> trumpSetDeal;
    public ArrayList<EnumDqmTrump> trumpDeck;
    public int gamePhase = 0;
    public int myCoin = 0;
    public int lastBet = -1;

    //0:無し 1:通常 2:BlackJack 3:BURST 4:PureBJ
    public int playerStatus = 0;
    public int dealerStatus = 0;

    //10:敗北 11:勝利 12:DRAW
    //public int gameResult = 0;
    public EnumDqmCasinoBJOdds gameResult = null;
    public boolean closeFlg = false;

    public int soundPlay = -1;
    public GuiCasinoBJGuiContainer(EntityPlayer player)
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
    	trumpSetDeal = new LinkedHashMap<Integer, EnumDqmTrump>();
    	trumpDeck = new ArrayList<EnumDqmTrump>();

    	EnumDqmTrump[] data = EnumDqmTrump.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(14 > data[cnt].getValue()&& data[cnt].getValue() > 0)
    		{
    			trumpDeck.add(data[cnt]);
    		}
    	}

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
	    		/*
	            mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.blackjack.info.odds.txt", new Object[]{}), mainX + 222 + 3 , mainY + 9, 0xffffffff);
	            for(int cnt = 0; cnt < 7; cnt++)
	            {
	            	String msg = I18n.format("msg.casino.blackjack.info." + cnt + ".txt", new Object[]{});
	            	mc.fontRenderer.drawStringWithShadow(msg, mainX + 222 + 4 , mainY + 19 + (9 * cnt), 0xffffffff);
	            }
	            */
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

    	int bg2StartX = mainX + 251;
    	buttonList = new ArrayList();
    	//this.buttonList.add(new GuiOptionButton(1, x + 7, y + 117, 10, 20, "<"));
    	if(this.gamePhase == 2)
    	{
	    	this.buttonList.add(new GuiOptionButton(1, mainX + 8, endY - 28, 70, 20, I18n.format("msg.casino.blackjack.button.hit.txt", new Object[]{})));
	    	this.buttonList.add(new GuiOptionButton(2, mainX + 79, endY - 28, 70, 20, I18n.format("msg.casino.blackjack.button.stand.txt", new Object[]{})));

	    	if(trumpSet.size() == 2)
	    	{
	    		this.buttonList.add(new GuiOptionButton(3, mainX + 150, endY - 28, 70, 20, I18n.format("msg.casino.blackjack.button.double.txt", new Object[]{})));
	    	}

	    	if(trumpSet.size() == 2 && (trumpSet.get(0).getValue() == trumpSet.get(1).getValue()))
	    	{
	    		//this.buttonList.add(new GuiOptionButton(4, mainX + 221, endY - 28, 70, 20, I18n.format("msg.casino.blackjack.button.split.txt", new Object[]{})));
	    	}

	    	if(trumpSet.size() == 2)
	    	{
	    		this.buttonList.add(new GuiOptionButton(5, mainX + 292, endY - 28, 70, 20, I18n.format("msg.casino.blackjack.button.salender.txt", new Object[]{})));
	    	}

    	}else if(this.gamePhase == 20)
    	{
    		this.buttonList.add(new GuiOptionButton(21, mainX + 150, endY - 28, 70, 20, I18n.format("BURST", new Object[]{})));
    		this.buttonList.add(new GuiOptionButton(22, mainX + 292, endY - 28, 70, 20, I18n.format("!?", new Object[]{})));
    		//this.gamePhase = 21;
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




        //k = (this.width - 40)/ 2;
        //l = ((this.height - this.ySize) / 2) + this.ySize - 80;

        /*
        trumpSet.put(0, EnumDqmTrump.C11);
        trumpSet.put(1, EnumDqmTrump.H3);
        trumpSet.put(2, EnumDqmTrump.S7);
        */
        int trumpValTotal = 0;
        playerAceBigCounter = 0;

        //playerStatus = 0;
        //dealerStatus = 0;
        if(trumpSet.size() > 0)
        {
        	for(int cnt = 0; cnt < trumpSet.size(); cnt++)
        	{
        		this.mc.getTextureManager().bindTexture(((EnumDqmTrump)trumpSet.get(cnt)).getRc());
        		this.drawTexturedModalRect(halfX + (20 * cnt) - ((40 + (20 * (trumpSet.size() - 1))) / 2), endY - 95, 0, 0, 40, 60);

        		if(((EnumDqmTrump)trumpSet.get(cnt)).getValue() == 1)
        		{
        			if(trumpValTotal + 11 > 21)
        			{
        				trumpValTotal = trumpValTotal + 1;
        			}else
        			{
        				trumpValTotal = trumpValTotal + 11;
        				playerAceBigCounter = playerAceBigCounter + 1;
        			}
        		}else
        		{
        			if(((EnumDqmTrump)trumpSet.get(cnt)).getValue() > 10)
        			{
        				trumpValTotal = trumpValTotal +10;
        			}else
        			{
        				trumpValTotal = trumpValTotal + ((EnumDqmTrump)trumpSet.get(cnt)).getValue();
        			}
        			if(trumpValTotal > 21 && playerAceBigCounter > 0)
        			{
        				playerAceBigCounter = playerAceBigCounter - 1;
        				trumpValTotal = trumpValTotal - 10;
        			}
        		}
        	}
        }

        if(trumpValTotal > 0)
        {
        	String playerMessage = "";
        	if(trumpValTotal > 21)
        	{
        		playerMessage = I18n.format("msg.casino.blackjack.message.burst.txt", new Object[]{});

        	}else
        	{
        		if(trumpValTotal == 21)
        		{
        			if(trumpSet.size() == 2)
        			{
        				playerMessage = I18n.format("msg.casino.blackjack.message.blackjack.txt", new Object[]{});
        				playerStatus = 2;
        			}else
        			{
        				playerMessage = I18n.format("msg.casino.blackjack.message.nice21.txt", new Object[]{});
        			}
        		}else
        		{
        			playerMessage = I18n.format("msg.casino.blackjack.message.val.txt", new Object[]{trumpValTotal});
        		}
        	}

        	mc.fontRenderer.drawStringWithShadow(playerMessage, halfX - (mc.fontRenderer.getStringWidth(playerMessage) / 2) , endY - 107, 0xFFFFFFFF);
        }
        //mc.fontRenderer.drawStringWithShadow("You win!!", halfX - 10 , endY - 107, 0xFFCC6600);









    	NumberFormat nfNum = NumberFormat.getNumberInstance();

        //RateInformation
        mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.blackjack.info.odds.txt", new Object[]{}), mainX + 222 + 3 , mainY + 9, 0xffffffff);
        for(int cnt = 0; cnt < 7; cnt++)
        {
        	EnumDqmCasinoBJOdds enumOdds = DQR.enumGetter.getCasinoBJOddsFromId(cnt);

        	String msg = I18n.format(enumOdds.getLangKey(), new Object[]{enumOdds.getOdds()});
    		if(gameResult != null && gameResult.getId() == cnt)
    		{
    			mc.fontRenderer.drawStringWithShadow(msg, mainX + 222 + 4 , mainY + 19 + (9 * cnt), 0xffffff00);
    		}else
    		{
    			mc.fontRenderer.drawStringWithShadow(msg, mainX + 222 + 4 , mainY + 19 + (9 * cnt), 0xffffffff);
    		}


        	if(this.commandTextField != null && this.commandTextField.getText().length() > 0)
        	{
        		int bedCoin = Integer.parseInt(this.commandTextField.getText());
        		String msg2 = nfNum.format(bedCoin * enumOdds.getOdds());
        		if(gameResult != null && gameResult.getId() == cnt)
        		{
        			mc.fontRenderer.drawStringWithShadow(msg2, endX - 12 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * cnt), 0xffffff00);
        			mc.fontRenderer.drawStringWithShadow("", endX - 12 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * cnt), 0xffffffff);
        		}else
        		{
        			mc.fontRenderer.drawStringWithShadow(msg2, endX - 12 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * cnt), 0xffffffff);
        		}
        	}else
        	{
				String msg2 = nfNum.format(0);
				//System.out.println("TEST : " + msg + " : " + endX + " : " + mc.fontRenderer.getStringWidth(msg) + " : " + (endX - 8 - mc.fontRenderer.getStringWidth(msg)));
				mc.fontRenderer.drawStringWithShadow(msg2, endX - 12 - mc.fontRenderer.getStringWidth(msg2), mainY + 19 + (9 * cnt), 0xffffffff);
        	}
        }



        /*

    	if(this.commandTextField.getText().length() > 0)
    	{

    	}else
    	{
            for(int cnt = 0; cnt < 7; cnt++)
            {
            	String msg = nfNum.format(Math.pow(11, cnt + 1));
            	//System.out.println("TEST : " + msg + " : " + endX + " : " + mc.fontRenderer.getStringWidth(msg) + " : " + (endX - 8 - mc.fontRenderer.getStringWidth(msg)));
            	mc.fontRenderer.drawStringWithShadow(msg, endX - 12 - mc.fontRenderer.getStringWidth(msg), mainY + 19 + (9 * cnt), 0xffffffff);
            }
    	}
    	*/
        /*
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D10 .getRc());
		this.drawTexturedModalRect(mainX + 9 + (20 * 0), mainY + 10, 0, 0, 40, 60);
		this.mc.getTextureManager().bindTexture(EnumDqmTrump.D7 .getRc());
		this.drawTexturedModalRect(mainX + 9 + (20 * 1), mainY + 10, 0, 0, 40, 60);
		*/
        /*
        if(trumpSetDeal.size() > 0)
        {
        	for(int cnt = 0; cnt < trumpSetDeal.size(); cnt++)
        	{
        		this.mc.getTextureManager().bindTexture(((EnumDqmTrump)trumpSetDeal.get(cnt)).getRc());
        		this.drawTexturedModalRect(mainX + 9 + (20 * cnt),  mainY + 10, 0, 0, 40, 60);
        	}
        }
        */





        trumpValTotal = 0;
        playerAceBigCounter = 0;
        if(trumpSetDeal.size() > 0)
        {
        	for(int cnt = 0; cnt < trumpSetDeal.size(); cnt++)
        	{
        		this.mc.getTextureManager().bindTexture(((EnumDqmTrump)trumpSetDeal.get(cnt)).getRc());
        		this.drawTexturedModalRect(mainX + 9 + (20 * cnt),  mainY + 10, 0, 0, 40, 60);

        		if(((EnumDqmTrump)trumpSetDeal.get(cnt)).getValue() == 1)
        		{
        			if(trumpValTotal + 11 > 21)
        			{
        				trumpValTotal = trumpValTotal + 1;
        			}else
        			{
        				trumpValTotal = trumpValTotal + 11;
        				playerAceBigCounter = playerAceBigCounter + 1;
        			}
        		}else
        		{
        			if(((EnumDqmTrump)trumpSetDeal.get(cnt)).getValue() > 10)
        			{
        				trumpValTotal = trumpValTotal +10;
        			}else if(((EnumDqmTrump)trumpSetDeal.get(cnt)).getValue() < 0)
        			{
        			}else
        			{
        				trumpValTotal = trumpValTotal + ((EnumDqmTrump)trumpSetDeal.get(cnt)).getValue();
        			}
        			if(trumpValTotal > 21 && playerAceBigCounter > 0)
        			{
        				playerAceBigCounter = playerAceBigCounter - 1;
        				trumpValTotal = trumpValTotal - 10;
        			}
        		}
        	}
        }

        if(trumpValTotal > 0)
        {
        	String playerMessage = "";
        	if(trumpValTotal > 21)
        	{
        		playerMessage = I18n.format("msg.casino.blackjack.message.burst.txt", new Object[]{});
        	}else
        	{
        		if(trumpValTotal == 21)
        		{
        			if(trumpSetDeal.size() == 2)
        			{
        				playerMessage = I18n.format("msg.casino.blackjack.message.blackjack.txt", new Object[]{});
        			}else
        			{
        				playerMessage = I18n.format("msg.casino.blackjack.message.nice21.txt", new Object[]{});
        			}
        		}else
        		{
        			playerMessage = I18n.format("msg.casino.blackjack.message.val.txt", new Object[]{trumpValTotal});
        		}
        	}

        	mc.fontRenderer.drawStringWithShadow(playerMessage, mainX + 29 - (mc.fontRenderer.getStringWidth(playerMessage) / 2) , mainY + 74, 0xFFFFFFFF);
        }















        if(this.commandTextField != null)
        {
        	this.commandTextField.xPosition = endX - 48 - 4 - 36;
        	this.commandTextField.yPosition = halfY - 20;
        	this.commandTextField.setTextColor(0xffffffff);
        	this.commandTextField.drawTextBox();
        }else
        {
            this.commandTextField = new GuiTextField(this.fontRendererObj, endX - 48 - 4 - 36, halfY - 20, 36, 20);
            this.commandTextField.setMaxStringLength(7);
            this.commandTextField.setEnabled(true);
            this.commandTextField.setFocused(true);

            this.commandTextField.setTextColor(0xffffffff);
        	this.commandTextField.drawTextBox();
        }


    	if(this.gamePhase == 0)
    	{
    		this.buttonList.add(new GuiOptionButton(6, endX - 40 - 8, halfY - 20, 40, 20, I18n.format("msg.casino.blackjack.button.ready.txt", new Object[]{})));
    	}

    	int betTextStart = endX - 48 - 4 - 36;
    	int titleSize = mc.fontRenderer.getStringWidth(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}));


    	mc.fontRenderer.drawStringWithShadow(I18n.format("msg.casino.blackjack.info.bet.txt", new Object[]{}), betTextStart - 4 - titleSize, halfY - 14, 0xffffffff);


    	String test = nfNum.format(this.myCoin);
    	mc.fontRenderer.drawStringWithShadow(test, halfX + 30 - 4 - mc.fontRenderer.getStringWidth(test), halfY - 14, 0xffffffff);

    	String myCoinTitle = I18n.format("msg.casino.blackjack.info.mycoin.txt", new Object[]{});
    	mc.fontRenderer.drawStringWithShadow(myCoinTitle, halfX - 30 - 4 - mc.fontRenderer.getStringWidth(myCoinTitle), halfY - 14, 0xffffffff);



    	if(gameResult != null)
    	{
    		if(gameResult == EnumDqmCasinoBJOdds.OddsDraw)
    		{
    	        this.mc.getTextureManager().bindTexture(textureDraw);
    	        this.drawTexturedModalRect(halfX - 58, halfY - 27, 0, 0, 117, 54);
    		}else if(gameResult == EnumDqmCasinoBJOdds.OddsLose)
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

	    		ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, this.gamePhase, p_146284_1_.id);
	    		threadBJ.start();
    		}
    	}else if(this.gamePhase == 2)
    	{
    		if(p_146284_1_.id == 1)
    		{
    			this.gamePhase = -1;
    			ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, 2, p_146284_1_.id);
        		threadBJ.start();
    		}else if(p_146284_1_.id == 2)
    		{
    			this.gamePhase = 3;
    			ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, 3, p_146284_1_.id);
        		threadBJ.start();
    		}else if(p_146284_1_.id == 5)
    		{
    			this.gamePhase = 4;
    			ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, 4, p_146284_1_.id);
        		threadBJ.start();
    		}else if(p_146284_1_.id == 3)
    		{
    			//DOUBLE
    			int bed = Integer.parseInt(this.commandTextField.getText());
    			if(myCoin >= bed)
    			{
    				PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.CasinoCoinMinus, Integer.parseInt(this.commandTextField.getText())));
    				lastBet = bed;
    				myCoin = myCoin - bed;//
    				this.commandTextField.setText(String.valueOf(bed * 2));
    	    		//myCoin = ExtendedPlayerProperties3.get(epa).getCoin();


	    			this.gamePhase = 2;
	    			ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(epa, this, 2, p_146284_1_.id);
	        		threadBJ.start();
    			}
    		}
    	}else
    	{
    		if(p_146284_1_.id == 21)
    		{
    			this.gamePhase = 4;
				this.playerStatus = 3;
				this.gameResult = EnumDqmCasinoBJOdds.OddsLose;
    			ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(this.epa, this, 4, 2);
        		threadBJ.start();
    		}else if(p_146284_1_.id == 22)
    		{
    			int mp = ExtendedPlayerProperties.get(epa).getMP();
    			if(mp >= EnumDqmSkillJ.JSKILL_0_12.getNeedpt_Val())
    			{
    				this.epa.playSound("dqr:player.ikasama", 1.0F, 1.0F);
    				PacketHandler.INSTANCE.sendToServer(new MessageServerFunction(EnumDqmFuncPacketCode.MPchange, EnumDqmSkillJ.JSKILL_0_12.getNeedpt_Val() * -1));
    				//this.soundPlay = 15;
    				trumpSet.remove(trumpSet.size() - 1);

    				this.gameResult = null;
    				playerStatus = 1;
    				this.gamePhase = 2;
    				/*
	    			this.gamePhase = 4;
					this.playerStatus = 3;
					this.gameResult = EnumDqmCasinoBJOdds.OddsLose;
	    			ThreadCasinoBJ threadBJ = new ThreadCasinoBJ(this.epa, this, 4, 2);
	        		threadBJ.start();
	        		*/
    			}
    		}
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
