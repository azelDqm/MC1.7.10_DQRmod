package dqr.gui.dqrShop;

import java.text.NumberFormat;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.api.enums.EnumDqmNpcTalk;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiDqrShopGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr","textures/gui/ShopInv.png");
    public static EntityPlayer ept;
    public GuiDqrShopGuiContainer(EntityPlayer ep)
    {
        super(new GuiDqrShopContainer(ep));
        ept = ep;
        this.ySize = 87;
        this.xSize = 176;
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
    	int endX = (this.width - this.xSize) / 2 + this.xSize;
    	int endY = (this.height - this.ySize) / 2 + this.ySize;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        int guiPhase = ExtendedPlayerProperties3.get(this.ept).getGuiBukiyaPhase();
        int guiPrice = ExtendedPlayerProperties3.get(this.ept).getGuiBukiyaPrice();
        int flg = ExtendedPlayerProperties.get(this.ept).getNpcTalk(EnumDqmNpcTalk.BUKIYA.getId());
        if(flg < 0)
        {
        	flg = flg * -1;
        }

    	NumberFormat nfNum = NumberFormat.getNumberInstance();
    	String test = nfNum.format(ExtendedPlayerProperties.get(this.ept).getGold());
    	mc.fontRenderer.drawStringWithShadow(test, endX - 28 - mc.fontRenderer.getStringWidth(test), endY - 20, 0xffffffff);

    	//System.out.println("TEST : " + flg);
    	if(flg == 1)
    	{
    		String message1 = I18n.format("msg.Bukiya.messages.2.txt", new Object[]{});
    		//mc.fontRenderer.drawStringWithShadow(message1 + "/" + guiPhase, k + 14, l + 14, 0xffffffff);
    		mc.fontRenderer.drawStringWithShadow(message1, k + 14, l + 14, 0xffffffff);
    	}else if(flg == 2)
    	{
    		String message1 = I18n.format("msg.Bukiya.messages.3.txt", new Object[]{guiPrice});
    		String message2 = I18n.format("msg.Bukiya.messages.4.txt", new Object[]{});
    		//mc.fontRenderer.drawStringWithShadow(message1 + "/" + guiPhase, k + 14, l + 14, 0xffffffff);
    		mc.fontRenderer.drawStringWithShadow(message1, k + 14, l + 14, 0xffffffff);
    		mc.fontRenderer.drawStringWithShadow(message2, k + 14, l + 24, 0xffffffff);
    	}else if(flg == 6)
    	{
    		String message1 = I18n.format("msg.Bukiya.messages.6.txt", new Object[]{});
    		String message2 = I18n.format("msg.Bukiya.messages.4.txt", new Object[]{});
    		//mc.fontRenderer.drawStringWithShadow(message1 + "/" + guiPhase, k + 14, l + 14, 0xffffffff);
    		mc.fontRenderer.drawStringWithShadow(message1, k + 14, l + 14, 0xffffffff);
    		mc.fontRenderer.drawStringWithShadow(message2, k + 14, l + 24, 0xffffffff);
    	}else if(flg == 7)
    	{
    		String message1 = I18n.format("msg.Bukiya.messages.7.txt", new Object[]{});
    		//mc.fontRenderer.drawStringWithShadow(message1 + "/" + guiPhase, k + 14, l + 14, 0xffffffff);
    		mc.fontRenderer.drawStringWithShadow(message1, k + 14, l + 14, 0xffffffff);
    	}

    	//String message2 = I18n.format("msg.Bukiya.messages.2.txt", new Object[]{});
    	//mc.fontRenderer.drawStringWithShadow(message1, k + 14, l + 25, 0xffffffff);
    }
}

