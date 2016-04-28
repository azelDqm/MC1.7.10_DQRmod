package dqr.gui.dama;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import dqr.PacketHandler;
import dqr.items.base.DqmItemEmblemBase;
import dqr.packetMessage.MessageServerJobChange;

public class GuiJobChangeContainer extends Container
{
    private InventoryJobChange inventory;

    public GuiJobChangeContainer(InventoryPlayer inventoryPlayer)
    {
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	inventory = new InventoryJobChange();
        inventory.openInventory();

        int i = 2 * 18 + 1;

        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotJobChange(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        /*
        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotJobChange(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotJobChange(inventoryPlayer, j, 8 + j * 18, 161 + i));
        }
        */

    }

    /*
        Containerが開いてられるか
     */
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(p_82846_2_);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (p_82846_2_ < this.inventory.getSizeInventory())
            {
                if (!this.mergeItemStack(itemstack1, this.inventory.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            /*
            //シフトクリック時に、このアイテムだったら動かさない。
            else if(slot.getStack() != null && slot.getStack().getItem() == DQR.instance.InventoryItemJobChange)
            {
                return null;
            }
            */
            else if (!this.mergeItemStack(itemstack1, 0, this.inventory.getSizeInventory(), false))
            {
                return null;
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }

    /*
        Containerを閉じるときに呼ばれる
     */
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
        this.inventory.closeInventory();
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer ep)
    {
    	//System.out.println(par1 + "/" + par2 + "/" + par3);
    	//System.out.println("0:" + ep.worldObj.isRemote + ":");
    	if(par1 >= 0 && par1 < inventorySlots.size())
    	{
	    	Slot slot = (Slot)this.inventorySlots.get(par1);
	    	if(slot != null && slot.getStack() != null)
	    	{
	   			//System.out.println("1:" + ep.worldObj.isRemote + ":" + slot.getStack().getDisplayName());
	    		if(slot.getStack().getItem() instanceof DqmItemEmblemBase)
	    		{
	    			//System.out.println("2:" + ep.worldObj.isRemote + ":" + slot.getStack().getDisplayName());

	        		DqmItemEmblemBase emb = (DqmItemEmblemBase)slot.getStack().getItem();
	    			PacketHandler.INSTANCE.sendToServer(new MessageServerJobChange(emb.getJobEnum().getId()));
	        		//ExtendedPlayerProperties.get(ep).setJob(emb.getJobEnum().getId());
	        		//ep.worldObj.playSoundAtEntity(ep, "dqr:player.tensyoku", 1.0F, 1.0F);
	    		}

	    		//System.out.println(slot.getStack().getDisplayName());
	    		if(ep.worldObj.isRemote)
	    		{
	    			Minecraft.getMinecraft().thePlayer.closeScreen();
	    			Minecraft.getMinecraft().setIngameFocus();
	    		}



	    	}
    	}

    	return null;
    }
}
