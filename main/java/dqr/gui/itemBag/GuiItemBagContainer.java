package dqr.gui.itemBag;

import invtweaks.api.container.ChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.items.base.DqmItemFukuroBase;
import dqr.items.fukuro.DqmItemFukuro;
import dqr.playerData.ExtendedPlayerProperties2;

@ChestContainer
public class GuiItemBagContainer extends Container
{
    private InventoryItemBag inventory;
    private InventoryPlayer epInventory;
    private int openFlg = 1;
    private InventorySubEquip subEquip;

    public GuiItemBagContainer(InventoryPlayer inventoryPlayer)
    {
    	openFlg = 1;
    	epInventory = inventoryPlayer;
        inventory = new InventoryItemBag(inventoryPlayer);
        inventory.openInventory();

        int i = 2 * 18 + 1;

        for (int j = 0; j < 6; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }


        for (int j = 6; j < 17; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(inventory, k + j * 9, 8 + 14 + (18 * 9) + k * 18, 18 + (j - 6) * 18));
            }
        }



        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotItemBag(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotItemBag(inventoryPlayer, j, 8 + j * 18, 161 + i));
        }

    }

    public GuiItemBagContainer(InventoryPlayer inventoryPlayer, EntityPlayer ep)
    {
    	openFlg = 2;
    	subEquip = new InventorySubEquip(ep);
    	subEquip.openInventory();


    	ItemStack bag = subEquip.getStackInSlot(12);
    	inventory = new InventoryItemBag(ep.inventory, bag);
    	inventory.openInventory();


        //inventory = new InventoryItemBag(inventoryPlayer);
        //inventory.openInventory();

        int i = 2 * 18 + 1;

        for (int j = 0; j < 6; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }


        for (int j = 6; j < 17; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(inventory, k + j * 9, 8 + 14 + (18 * 9) + k * 18, 18 + (j - 6) * 18));
            }
        }



        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotItemBag(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotItemBag(inventoryPlayer, j, 8 + j * 18, 161 + i));
        }

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
//System.out.println("TEST:" + p_82846_2_);

        //System.out.println("TESTLINE222");
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
            //シフトクリック時に、このアイテムだったら動かさない。
            else if(slot.getStack() != null && slot.getStack().getItem() instanceof DqmItemFukuro)
            {
                return null;
            }
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

    public ItemStack slotClick(int p_75144_1_, int p_75144_2_, int p_75144_3_, EntityPlayer p_75144_4_)
    {
    	//System.out.println("TESTLINE222 : " + p_75144_1_ + "/" + p_75144_2_ + "/" + p_75144_3_);

    	if(p_75144_3_ == 2 && this.epInventory.getStackInSlot(p_75144_2_) != null && this.epInventory.getStackInSlot(p_75144_2_).getItem() instanceof DqmItemFukuroBase)
    	{
    		return null;
    	}

    	if(this.getInventory() != null && this.getInventory().size() < p_75144_1_ && p_75144_1_ >= 0)
    	{
	    	ItemStack sl = (ItemStack)(this.getInventory().get(p_75144_1_));
	    	//if(sl != null && sl.getStack() != null && sl.getStack().getItem() instanceof DqmItemFukuroBase)
	    	if(sl != null &&  sl.getItem() instanceof DqmItemFukuroBase)
	    	{
	    		return null;
	    	}
    	}
    	return super.slotClick(p_75144_1_, p_75144_2_, p_75144_3_, p_75144_4_);
    }


    /*
        Containerを閉じるときに呼ばれる
     */
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
    	ExtendedPlayerProperties2.get(p_75134_1_).setFukuroOpen(false);
        super.onContainerClosed(p_75134_1_);
        if(openFlg == 1)
        {
        	this.inventory.closeInventory();
        }else if(openFlg == 2)
        {
        	this.inventory.closeInventory2(subEquip );
        }else
        {
        	this.inventory.closeInventory();
        }
    }


}