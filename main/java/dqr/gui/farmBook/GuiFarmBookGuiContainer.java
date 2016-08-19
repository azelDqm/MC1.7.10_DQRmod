package dqr.gui.farmBook;

import java.util.Set;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.playerData.ExtendedPlayerProperties3;

public class GuiFarmBookGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("dqr", "textures/gui/guiFarmBook.png");
    private int page = 0;

    public GuiFarmBookGuiContainer(EntityPlayer player)
    {

        super(new GuiFarmBookContainer(player));

    	NBTTagCompound playerPet = ExtendedPlayerProperties3.get(player).getNBTPlayerPetList();
    	Set tags = playerPet.func_150296_c();

		this.xSize = 154;
		this.ySize = 134;


    }

    public void initGui()
    {
    	super.initGui();
    }
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
		mc.fontRenderer.drawString(I18n.format("msg.FarmBook.seedPat.txt"), 15, 4, 4210752);
		mc.fontRenderer.drawString(I18n.format("msg.FarmBook.plantPat.txt"), 82, 4, 4210752);
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
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }


    protected void actionPerformed(GuiButton p_146284_1_)
    {

    }
}
