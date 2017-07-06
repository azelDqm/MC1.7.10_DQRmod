package dqr.gui.casinoExchange;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.achievement.GuiAchievements;
/*
public class GuiMedalkingGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("textures/gui/container/generic_54.png");

    public GuiMedalkingGuiContainer(InventoryPlayer inventoryPlayer)
    {
        super(new GuiMedalkingContainer(inventoryPlayer));
        this.ySize = 222;
    }

    //ChestとかInventoryとか文字を描画する
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
        //描画する文字, X, Y, 色
        this.fontRendererObj.drawString("Item Container", 8, 6, 4210752);
        this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    //背景の描画
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
*/
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.DQR;
import dqr.gui.casinoExchange.tab.CasinoExchangeTabs;
import dqr.gui.casinoExchange.tab.TabManager;

public class GuiCasinoExchangeGuiMisc extends InventoryEffectRenderer
{

	//protected static final ResourceLocation field_147001_a = new ResourceLocation("sextiarysector:textures/guis/inventory_next.png");
	protected static final ResourceLocation field_147001_a = new ResourceLocation("dqr:textures/gui/gui_Medalking.png");

    /** x size of the inventory window in pixels. Defined as  float, passed as int */
    private float xSizeFloat;
    /** y size of the inventory window in pixels. Defined as  float, passed as int. */
    private float ySizeFloat;
    private static final String __OBFID = "CL_00000761";

    public GuiCasinoExchangeGuiMisc(EntityPlayer p_i1094_1_)
    {
        //super(new ContainerPlayerNext(p_i1094_1_.inventory, p_i1094_1_));
    	super(new GuiCasinoExchangeContainer(p_i1094_1_.inventory, DQR.conf.GuiID_CEMisc));
    	this.ySize = 173;
        this.allowUserInput = true;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        if (this.mc.playerController.isInCreativeMode())
        {
            //this.mc.displayGuiScreen(new GuiContainerCreative(this.mc.thePlayer));
        }
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.buttonList.clear();

        super.initGui();

        int cornerX = this.guiLeft;

        int cornerY = this.guiTop;

        if (TabManager.hasPotion()) //!mc.thePlayer.getActivePotionEffects().isEmpty())
        {
            cornerX = 160 + (this.width - this.xSize - 200) / 2;
        } else {
            cornerX = (this.width - this.xSize) / 2;
        }
        //TabManager.updateTabValues(cornerX, cornerY,this.buttonList, PlayerTabs.ss,false);
        TabManager.updateTabValues(cornerX, cornerY,this.buttonList, CasinoExchangeTabs.tabCasinoMisc,false);

    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        //this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 86, 16, 4210752);
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_)
    {
        super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
        this.xSizeFloat = (float)p_73863_1_;
        this.ySizeFloat = (float)p_73863_2_;
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(this.field_147001_a);
        int k = this.guiLeft;
        int l = this.guiTop;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        func_147046_a(k + 51, l + 86, 30, (float)(k + 51) - this.xSizeFloat, (float)(l + 75 - 50) - this.ySizeFloat, this.mc.thePlayer);
    }

    public static void func_147046_a(int p_147046_0_, int p_147046_1_, int p_147046_2_, float p_147046_3_, float p_147046_4_, EntityLivingBase p_147046_5_)
    {
    	/*
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)p_147046_0_, (float)p_147046_1_, 50.0F);
        GL11.glScalef((float)(-p_147046_2_), (float)p_147046_2_, (float)p_147046_2_);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        EntityLiving elv = (EntityLiving) new DqmEntityBigCrow(p_147046_5_.worldObj);
        float f2 = elv.renderYawOffset;
        float f3 = elv.rotationYaw;
        float f4 = elv.rotationPitch;
        float f5 = elv.prevRotationYawHead;
        float f6 = elv.rotationYawHead;
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        elv.renderYawOffset = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 20.0F;
        elv.rotationYaw = (float)Math.atan((double)(p_147046_3_ / 40.0F)) * 40.0F;
        elv.rotationPitch = -((float)Math.atan((double)(p_147046_4_ / 40.0F))) * 20.0F;
        elv.rotationYawHead = elv.rotationYaw;
        elv.prevRotationYawHead = elv.rotationYaw;
        GL11.glTranslatef(0.0F, elv.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        RenderManager.instance.renderEntityWithPosYaw(elv, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        elv.renderYawOffset = f2;
        elv.rotationYaw = f3;
        elv.rotationPitch = f4;
        elv.prevRotationYawHead = f5;
        elv.rotationYawHead = f6;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
        */
    }

    protected void actionPerformed(GuiButton p_146284_1_)
    {
        if (p_146284_1_.id == 0)
        {
            this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
        }

        if (p_146284_1_.id == 1)
        {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
        }
    }
}
