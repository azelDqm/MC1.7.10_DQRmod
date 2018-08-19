package dqr.gui.petStatus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import dqr.DQR;

public class SlotPetInventory extends Slot
{
    public SlotPetInventory(IInventory p_i1824_1_, int p_i1824_2_, int p_i1824_3_, int p_i1824_4_)
    {
        super(p_i1824_1_, p_i1824_2_, p_i1824_3_, p_i1824_4_);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
    	DQR.func.debugString("TEST5");
    	return true;
    }

    /*
        このアイテムは動かせない、つかめないようにする。
     */
    @Override
    public boolean canTakeStack(EntityPlayer p_82869_1_)
    {
    	DQR.func.debugString("TEST6");
        return true;//!(getHasStack() && getStack().getItem() == InventoryItemCore.instance.inventoryItem);
    }

}