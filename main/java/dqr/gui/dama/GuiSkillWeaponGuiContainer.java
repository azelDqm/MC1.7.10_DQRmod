package dqr.gui.dama;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiSkillWeaponGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr","textures/gui/guiSkillWeapon.png");

    public GuiSkillWeaponGuiContainer(EntityPlayer ep)
    {
        super(new GuiSkillWeaponContainer(ep));
        this.ySize = 42;
        this.xSize = 194;
    }

    /*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
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
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
