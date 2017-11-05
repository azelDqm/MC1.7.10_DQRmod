package dqr.gui.petStatus;

import invtweaks.api.container.ChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.entity.petEntity.InventoryPetInventory;
import dqr.playerData.ExtendedPlayerProperties3;

@ChestContainer
public class GuiPetInventoryContainer extends Container
{
    private InventoryPetInventory inventory;

    public GuiPetInventoryContainer(InventoryPlayer inventoryPlayer)
    {
    	//System.out.println("TESTAAA");
        inventory = new InventoryPetInventory(ExtendedPlayerProperties3.get(inventoryPlayer.player).getStatusPet());
        inventory.openInventory();

        //System.out.println("TESTCCC");

        //int i = 2 * 18 + 2;
        int i = 0;

        for (int j = 0; j < 2; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(inventory, k + j * 9, 8 + k * 18, 44 + j * 18));
            }
        }

        /*
        for (int k = 0; k < 3; ++k)
        {
            this.addSlotToContainer(new Slot(inventory, 18 + k, 8 + k * 18, 24 + 0 * 18));
        }
        */


        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotPetInventory(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotPetInventory(inventoryPlayer, j, 8 + j * 18, 142));
        }

        this.addSlotToContainer(new SlotPetEquipment(EnumDqmSubEquipType.PWEAPON, this.inventory, 18, 8, 24));
        this.addSlotToContainer(new SlotPetEquipment(EnumDqmSubEquipType.PARMOR, this.inventory, 19, 26, 24));
        this.addSlotToContainer(new SlotPetEquipment(EnumDqmSubEquipType.PSHIELD, this.inventory, 20, 44, 24));
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
    	//System.out.println("TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + p_82846_2_);
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
            //シフトクリック時に、このアイテムだったら動かさない。
            //
            //else if(slot.getStack() != null && slot.getStack().getItem() == InventoryItemCore.instance.inventoryItem)
            //{
            //    return null;
            //}

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
}