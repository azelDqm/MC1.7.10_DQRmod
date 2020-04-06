package dqr.gui.debug;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import dqr.PacketHandler;
import dqr.api.enums.EnumDqmCasinoPKOdds;
import dqr.api.enums.EnumDqmFuncPacketCode;
import dqr.api.enums.EnumDqmTrump;
import dqr.packetMessage.MessageServerFunction;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiDebugGuiContainer extends GuiContainer
{
    private static final ResourceLocation textureD = new ResourceLocation("dqr", "textures/gui/debug.png");
    private static final ResourceLocation texture2 = new ResourceLocation("dqr", "textures/casino/sl_background2.png");

    private static final ResourceLocation textureWin = new ResourceLocation("dqr", "textures/casino/Result_Win.png");
    private static final ResourceLocation textureLose = new ResourceLocation("dqr", "textures/casino/Result_Lose.png");
    private static final ResourceLocation textureDraw = new ResourceLocation("dqr", "textures/casino/Result_Draw.png");

    private static final ResourceLocation textureReal1 = new ResourceLocation("dqr", "textures/casino/sl_real_0.png");

    public GuiTextField commandTextField;
    public GuiTextField commandTextField2;
    public GuiTextField commandTextField3;
    public GuiTextField commandTextField4;
    public GuiTextField commandTextField5;
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

    public int realTick1 = 96;
    public int realSlide1 = 0;
    public int realTick2 = 48;
    public int realSlide2 = 0;
    public int realTick3 = 0;
    public int realSlide3 = 0;

    public float realSpeed = 4;
    public GuiDebugGuiContainer(EntityPlayer player)
    {

        super(new GuiDebugContainer(player));
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

    	//System.out.println("TEST : " + p_73869_1_ + " / " + p_73869_2_);
    	if(this.commandTextField2.isFocused())
    	{
	    	if(p_73869_2_ == 203)
	    	{
	    		this.commandTextField2.moveCursorBy(-1);
	    	}else if(p_73869_2_ == 205)
	    	{
	    		this.commandTextField2.moveCursorBy(1);
	    	}else if(p_73869_2_ == 211)
	    	{
	    		this.commandTextField2.deleteFromCursor(1);
	    	}else if(p_73869_2_ == 14)
	    	{
	    		this.commandTextField2.deleteFromCursor(-1);
	    	}

    		//System.out.println("Focus2");
        	if(isNumber1(String.valueOf(p_73869_1_)) || p_73869_1_ == '-')
        	{
        		String preValue = this.commandTextField2.getText();

        		this.commandTextField2.textboxKeyTyped(p_73869_1_, p_73869_2_);
        		String newValue = this.commandTextField2.getText();

        		if(isNumber1(newValue))
        		{
	        		int newIntValue = Integer.parseInt(newValue);

	        		if(newIntValue > 1000000)
	        		{
	        			newIntValue = 1000000;
	        			this.commandTextField2.setText("1000000");
	        		}
        		}

        		//this.commandTextField2.setText(preValue);
        	}
    	}

    	if(this.commandTextField3.isFocused())
    	{
	    	if(p_73869_2_ == 203)
	    	{
	    		this.commandTextField3.moveCursorBy(-1);
	    	}else if(p_73869_2_ == 205)
	    	{
	    		this.commandTextField3.moveCursorBy(1);
	    	}else if(p_73869_2_ == 211)
	    	{
	    		this.commandTextField3.deleteFromCursor(1);
	    	}else if(p_73869_2_ == 14)
	    	{
	    		this.commandTextField3.deleteFromCursor(-1);
	    	}


    		//System.out.println("Focus3");
        	if(isNumber1(String.valueOf(p_73869_1_)) || p_73869_1_ == '-')
        	{
        		String preValue = this.commandTextField3.getText();

        		this.commandTextField3.textboxKeyTyped(p_73869_1_, p_73869_2_);
        		String newValue = this.commandTextField3.getText();
        		if(isNumber1(newValue))
        		{
	        		int newIntValue = Integer.parseInt(newValue);

	        		if(newIntValue > 1000000)
	        		{
	        			newIntValue = 1000000;
	        			this.commandTextField3.setText("1000000");
	        		}
        		}

        		//this.commandTextField3.setText(preValue);
        	}
    	}

    	if(this.commandTextField4.isFocused())
    	{
	    	if(p_73869_2_ == 203)
	    	{
	    		this.commandTextField4.moveCursorBy(-1);
	    	}else if(p_73869_2_ == 205)
	    	{
	    		this.commandTextField4.moveCursorBy(1);
	    	}else if(p_73869_2_ == 211)
	    	{
	    		this.commandTextField4.deleteFromCursor(1);
	    	}else if(p_73869_2_ == 14)
	    	{
	    		this.commandTextField4.deleteFromCursor(-1);
	    	}

    		//System.out.println("Focus4");
        	if(isNumber1(String.valueOf(p_73869_1_)) || p_73869_1_ == '-')
        	{
        		String preValue = this.commandTextField4.getText();

        		this.commandTextField4.textboxKeyTyped(p_73869_1_, p_73869_2_);
        		String newValue = this.commandTextField4.getText();
        		if(isNumber1(newValue))
        		{
	        		int newIntValue = Integer.parseInt(newValue);

	        		if(newIntValue > 1000000)
	        		{
	        			newIntValue = 1000000;
	        			this.commandTextField4.setText("1000000");
	        		}
        		}

        		//this.commandTextField4.setText(preValue);
        	}
    	}

    	if(this.commandTextField5.isFocused() && p_73869_1_ != '9')
    	{
	    	if(p_73869_2_ == 203)
	    	{
	    		this.commandTextField5.moveCursorBy(-1);
	    	}else if(p_73869_2_ == 205)
	    	{
	    		this.commandTextField5.moveCursorBy(1);
	    	}else if(p_73869_2_ == 211)
	    	{
	    		this.commandTextField5.deleteFromCursor(1);
	    	}else if(p_73869_2_ == 14)
	    	{
	    		this.commandTextField5.deleteFromCursor(-1);
	    	}


    		//System.out.println("Focus3");

    		String preValue = this.commandTextField5.getText();

    		this.commandTextField5.textboxKeyTyped(p_73869_1_, p_73869_2_);

    	}


    	if(this.commandTextField5.isFocused())
    	{
    		if(p_73869_1_ == '9')
	    	{
	    		this.commandTextField2.setFocused(true);
	    		this.commandTextField3.setFocused(false);
	    		this.commandTextField4.setFocused(false);
	    		this.commandTextField5.setFocused(false);
	    	}
    	}else
    	{

	    	if(p_73869_1_ == 'a')
	    	{
	    		this.commandTextField2.setFocused(true);
	    		this.commandTextField3.setFocused(false);
	    		this.commandTextField4.setFocused(false);
	    		this.commandTextField5.setFocused(false);
	    	}else if(p_73869_1_ == 'b')
	    	{
	    		this.commandTextField2.setFocused(false);
	    		this.commandTextField3.setFocused(true);
	    		this.commandTextField4.setFocused(false);
	    		this.commandTextField5.setFocused(false);
	    	}else if(p_73869_1_ == 'c')
	    	{
	    		this.commandTextField2.setFocused(false);
	    		this.commandTextField3.setFocused(false);
	    		this.commandTextField4.setFocused(true);
	    		this.commandTextField5.setFocused(false);
	    	}else if(p_73869_1_ == 'd')
	    	{
	    		this.commandTextField2.setFocused(false);
	    		this.commandTextField3.setFocused(false);
	    		this.commandTextField4.setFocused(false);
	    		this.commandTextField5.setFocused(true);
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
    	if(p_73869_1_ != 'e')
    	{
    		super.keyTyped(p_73869_1_, p_73869_2_);
    	}
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
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(textureD);
        int k = this.guiLeft;
        int l = this.guiTop;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);


        if(this.commandTextField2 != null)
        {
        	this.commandTextField2.xPosition = 50;
        	this.commandTextField2.yPosition = 10;
        	this.commandTextField2.setTextColor(0xffffffff);
        	this.commandTextField2.drawTextBox();
        }else
        {
            //this.commandTextField = new GuiTextField(this.fontRendererObj, endX - 48 - 4 - 36, halfY - 20, 36, 20);
        	this.commandTextField2 = new GuiTextField(this.fontRendererObj, 50, 10, 36, 18);
            this.commandTextField2.setMaxStringLength(7);
            this.commandTextField2.setEnabled(true);
            this.commandTextField2.setFocused(true);
            this.commandTextField2.setText("0");

            this.commandTextField2.setTextColor(0xffffffff);
        	this.commandTextField2.drawTextBox();
        }
        if(this.commandTextField3 != null)
        {
        	this.commandTextField3.xPosition = 50;
        	this.commandTextField3.yPosition = 25;
        	this.commandTextField3.setTextColor(0xffffffff);
        	this.commandTextField3.drawTextBox();
        }else
        {
            //this.commandTextField = new GuiTextField(this.fontRendererObj, endX - 48 - 4 - 36, halfY - 20, 36, 20);
        	this.commandTextField3 = new GuiTextField(this.fontRendererObj, 50, 25, 36, 18);
            this.commandTextField3.setMaxStringLength(7);
            this.commandTextField3.setEnabled(true);
            //this.commandTextField3.setFocused(true);
            this.commandTextField3.setText("0");

            this.commandTextField3.setTextColor(0xffffffff);
        	this.commandTextField3.drawTextBox();
        }

        if(this.commandTextField4 != null)
        {
        	this.commandTextField4.xPosition = 50;
        	this.commandTextField4.yPosition = 40;
        	this.commandTextField4.setTextColor(0xffffffff);
        	this.commandTextField4.drawTextBox();
        }else
        {
            //this.commandTextField = new GuiTextField(this.fontRendererObj, endX - 48 - 4 - 36, halfY - 20, 36, 20);
        	this.commandTextField4 = new GuiTextField(this.fontRendererObj, 50, 40, 36, 18);
            this.commandTextField4.setMaxStringLength(7);
            this.commandTextField4.setEnabled(true);
            //this.commandTextField4.setFocused(true);
            this.commandTextField4.setText("0");

            this.commandTextField4.setTextColor(0xffffffff);
        	this.commandTextField4.drawTextBox();
        }

        if(this.commandTextField5 != null)
        {
        	this.commandTextField5.xPosition = 90;
        	this.commandTextField5.yPosition = 40;
        	this.commandTextField5.setTextColor(0xffffffff);
        	this.commandTextField5.drawTextBox();
        }else
        {
            //this.commandTextField = new GuiTextField(this.fontRendererObj, endX - 48 - 4 - 36, halfY - 20, 36, 20);
        	this.commandTextField5 = new GuiTextField(this.fontRendererObj, 50, 40, 64, 18);
            this.commandTextField5.setEnabled(true);
            //this.commandTextField4.setFocused(true);

            this.commandTextField5.setTextColor(0xffffffff);
        	this.commandTextField5.drawTextBox();
        }
        func_147046_a(k + 100, l + 180, 29, k + 51 - this.xSize, l + 75 - 50 - this.ySize, this.mc.thePlayer);
    }


    public void func_147046_a(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase p_147046_5_2) {

        EntityLivingBase p_147046_5_ = (EntityLivingBase)EntityList.createEntityByName("DQMIIINext." + this.commandTextField5.getText(), p_147046_5_2.worldObj);
        if(p_147046_5_ == null){return;}
        //entityPet.setLocationAndAngles((double)0 + 0.5D, (double)0 + 1.5D, (double)0 + 0.5D, 0.0F, 0.0F);
    	/*
			p_147046_5_ =
    	 */

        float num1 = 0.0F;
        if(isNumber1(this.commandTextField2.getText()))
        {
        	num1 = 0.01F * (Float.parseFloat(this.commandTextField2.getText()));
        }

        float num2 = 0.0F;
        if(isNumber1(this.commandTextField3.getText()))
        {
        	num2 = 0.01F * (Float.parseFloat(this.commandTextField3.getText()));
        }

        float num4 = 0.0F;
        if(isNumber1(this.commandTextField4.getText()))
        {
        	num4 = 0.01F * (Float.parseFloat(this.commandTextField4.getText()));
        }



        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef(p_147046_0_, p_147046_1_, 50.0F);
        GL11.glScalef((-p_147046_2_), p_147046_2_, p_147046_2_);
        //GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(180.0F, num1, num4, 1.0F);
        float f2 = p_147046_5_.renderYawOffset;
        float f3 = p_147046_5_.rotationYaw;
        float f4 = p_147046_5_.rotationPitch;
        float f5 = p_147046_5_.prevRotationYawHead;
        float f6 = p_147046_5_.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float) Math.atan(p_147046_4_ / 40.0F)) * 20.0F, 1.0F, 0.0F, 0.0F);
        p_147046_5_.renderYawOffset = (float) Math.atan(p_147046_3_ / 40.0F) * 20.0F;
        p_147046_5_.rotationYaw = (float) Math.atan(p_147046_3_ / 40.0F) * 40.0F;
        p_147046_5_.rotationPitch = -((float) Math.atan(p_147046_4_ / 40.0F)) * 20.0F;
        p_147046_5_.rotationYawHead = p_147046_5_.rotationYaw;
        p_147046_5_.prevRotationYawHead = p_147046_5_.rotationYaw;
        GL11.glTranslatef(0.0F, p_147046_5_.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;



        RenderManager.instance.renderEntityWithPosYaw(p_147046_5_, 0.0D, 0.0D, 0.0D, 0.0f, num2);
        p_147046_5_.renderYawOffset = f2;
        p_147046_5_.rotationYaw = f3;
        p_147046_5_.rotationPitch = f4;
        p_147046_5_.prevRotationYawHead = f5;
        p_147046_5_.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    protected void actionPerformed(GuiButton p_146284_1_)
    {
    	//this.epa.playSound("dqr:mob.fire", 1.0F, 1.0F);
    	//this.epa.worldObj.playSoundAtEntity(this.epa, "dqr:player.miss", 1.0F, 1.0F);

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
    	}else if(p_146284_1_.id >= 10 && 15 > p_146284_1_.id)
    	{
    		if(this.trumpDeckRev[p_146284_1_.id - 10] == 0)
    		{
    			this.trumpDeckRev[p_146284_1_.id - 10] = 1;
    		}else if(this.trumpDeckRev[p_146284_1_.id - 10] == 1)
    		{
    			this.trumpDeckRev[p_146284_1_.id - 10] = 0;
    		}
    	}else if(p_146284_1_.id == 20)
    	{
			this.gamePhase = 3;
			//ThreadCasinoPK threadBJ = new ThreadCasinoPK(epa, this, 3, p_146284_1_.id);
    		//threadBJ.start();
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


}
