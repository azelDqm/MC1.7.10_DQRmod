package dqr.gui.skillBook;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiSkillbookGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr","textures/gui/guiSkillbook.png");
    private static final ResourceLocation texture3 = new ResourceLocation("dqr","textures/gui/widgets2.png");
    private int page = 0;

    private EntityPlayer player;
    public GuiSkillbookGuiContainer(EntityPlayer ep)
    {
        super(new GuiSkillbookContainer(ep));
       // this.weaponID = ExtendedPlayerProperties.get(ep).getWeapon();
        this.ySize = 117;
        this.xSize = 176;
        this.player = ep;
    }

    /*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {

        this.fontRendererObj.drawString("選択可能特技", 8, 7, 4210752);
        this.fontRendererObj.drawString("選択中特技", 43, 78, 4210752);
    }


    public void initGui()
    {
    	super.initGui();
    	//buttonList = new ArrayList();
		int x = (this.width  - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;

    	//this.buttonList.clear();
    	/*
    	this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 15, this.height / 2 + 100, 18, 18, "<"));
    	this.buttonList.add(new GuiOptionButton(2, this.width / 2 + 118, this.height / 2 + 100, 18, 18, ">"));
    	*/
    	//this.buttonList.add(new GuiOptionButton(1, x + 7, y + 69, 15, 20, "<"));
    	//this.buttonList.add(new GuiOptionButton(2, x + 154, y + 69, 15, 20, ">"));
    }


    /*
        背景の描画
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        /*
        int weaponID = ExtendedPlayerProperties.get(player).getWeapon();
        int wSetSkill = ExtendedPlayerProperties3.get(player).getWeaponSkillSet(weaponID);
        int perm = ExtendedPlayerProperties3.get(player).getWeaponSkillPermission(weaponID, wSetSkill);
        if(wSetSkill > -1 && perm > 0)
        {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        GL11.glEnable(GL11.GL_BLEND);
	        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
	        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			this.mc.getTextureManager().bindTexture(texture3);
			this.drawTexturedModalRect(k + 8 + (wSetSkill * 18), 18 + l, 0, 146, 16, 16);
        }
        */
    }


}
