package dqr.gui.itemBag;

import java.lang.reflect.Field;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import dqr.DQR;
import dqr.items.base.DqmItemFukuroBase;

public class GuiItemBagGuiContainer extends GuiContainer
{
    private static final ResourceLocation texture = new ResourceLocation("textures/gui/container/generic_54.png");
    private int openFlg = 1;

    public GuiItemBagGuiContainer(InventoryPlayer inventoryPlayer)
    {
        super(new GuiItemBagContainer(inventoryPlayer));
        this.ySize = 222;
        this.xSize = 352;
        openFlg = 1;
    }

    public GuiItemBagGuiContainer(InventoryPlayer inventoryPlayer, EntityPlayer ep)
    {
        super(new GuiItemBagContainer(inventoryPlayer, ep));
        this.ySize = 222;
        this.xSize = 352;
        openFlg = 2;
    }

    /*
        ChestとかInventoryとか文字を描画する
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int x, int p_146979_2_)
    {
        //描画する文字, X, Y, 色
        this.fontRendererObj.drawString("Item Container", 8, 6, 4210752);
        this.fontRendererObj.drawString("Inventory", 8, this.ySize - 96 + 2, 4210752);
    }

    /*
        背景の描画
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - (this.xSize)) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, (this.xSize / 2), this.ySize);



        k = ((this.width - (this.xSize)) / 2) + (this.xSize / 2);
        l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, (this.xSize / 2), this.ySize);



        k = ((this.width - (this.xSize)) / 2) + (this.xSize / 2);
        l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l + 107 , 0, 35, 176,  90);
    }


    @Override
    protected void keyTyped(char p_73869_1_, int p_73869_2_)
    {
    	//System.out.println("BagTest : " + p_73869_1_ + " / " + p_73869_2_);

    	if(!checkHotbarItems(p_73869_2_))
    	{
    		return;
    	}

    	super.keyTyped(p_73869_1_, p_73869_2_);

    	if(openFlg == 2)
    	{
	    	if (p_73869_2_ == 1 || p_73869_2_ == DQR.CLKeyBind.keyOokinaFukuro.getKeyCode())
	        {
	            this.mc.thePlayer.closeScreen();
	        }
    	}

    }


    protected boolean checkHotbarItems(int p_146983_1_)
    {
    	/*
    	if(this.mc.thePlayer.inventory.getItemStack() != null)
    	{
    		System.out.println("TEST_XX1 : " + this.mc.thePlayer.inventory.getItemStack().getDisplayName());
    	}else
    	{
    		System.out.println("TEST_XX1 : " + "null");
    	}
    	*/

		Class<GuiContainer> c = GuiContainer.class;
		GuiContainer hoge = this;

		try {
    		Field f1;
    		Slot m;
			f1 = c.getDeclaredField( "theSlot" );
			f1.setAccessible( true );
			m = (Slot) f1.get(hoge);

			if(m == null) return true;
			if(m.getStack() != null &&
			   m.getStack().getItem() instanceof DqmItemFukuroBase)
			{
				return false;
			}
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}catch (NoSuchFieldException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


        for (int j = 0; j < 9; ++j)
        {
            if (p_146983_1_ == this.mc.gameSettings.keyBindsHotbar[j].getKeyCode())
            {
            	if(this.mc.thePlayer.inventory.getStackInSlot(j) != null &&
            	   this.mc.thePlayer.inventory.getStackInSlot(j).getItem() instanceof DqmItemFukuroBase)
            	{
            		return false;
            	}
            	/*
            	System.out.println("TEST_XX3 : " + j);
            	if(this.mc.thePlayer.inventory.getStackInSlot(j) != null)
            	{
            		System.out.println("TEST_XX2 : " + this.mc.thePlayer.inventory.getStackInSlot(j) + " : " + j);
            	}else
            	{
            		System.out.println("TEST_XX2 : " + "null" + " : " + j);
            	}
            	*/

                //this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, j, 2);
                //return;
            }
        }

        return true;
    }
}