package dqr.gui.petStatus;

import invtweaks.api.container.ChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import dqr.DQR;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.entity.petEntity.InventoryPetInventory;
import dqr.items.base.DqmItemAccessoryBase;
import dqr.items.base.DqmItemArmorBase;
import dqr.items.base.DqmItemWeaponBase;
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
    	///System.out.println("TEST!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + p_82846_2_);
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
            }else if (!this.mergeItemStack(itemstack1, 0, this.inventory.getSizeInventory(), false))
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



        //if(p_82846_2_ == 54 && itemstack.getItem() instanceof DqmItemWeaponBase){return null;}
        //シフトクリック時に、このアイテムだったら動かさない。
        //
        //else if(slot.getStack() != null && slot.getStack().getItem() == InventoryItemCore.instance.inventoryItem)
        //{
        //    return null;
        //}

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

    protected boolean mergeItemStack(ItemStack p_75135_1_, int p_75135_2_, int p_75135_3_, boolean p_75135_4_)
    {
    	DQR.func.debugString("TESTTEST : " + p_75135_2_ + "/ " + p_75135_3_);


        boolean flag1 = false;
        int k = p_75135_2_;

        if (p_75135_4_)
        {
            k = p_75135_3_ - 1;
        }

        Slot slot;
        ItemStack itemstack1;

        DQR.func.debugString("TESTTEST2 : " + k);
        if (p_75135_1_.isStackable())
        {
            while (p_75135_1_.stackSize > 0 && (!p_75135_4_ && k < p_75135_3_ || p_75135_4_ && k >= p_75135_2_))
            {
                slot = (Slot)this.inventorySlots.get(k);
                itemstack1 = slot.getStack();

                DQR.func.debugString("TESTTEST3 : " + k);
                if (itemstack1 != null && itemstack1.getItem() == p_75135_1_.getItem() && (!p_75135_1_.getHasSubtypes() || p_75135_1_.getItemDamage() == itemstack1.getItemDamage()) && ItemStack.areItemStackTagsEqual(p_75135_1_, itemstack1))
                {
                    int l = itemstack1.stackSize + p_75135_1_.stackSize;

                    if (l <= p_75135_1_.getMaxStackSize())
                    {
                        p_75135_1_.stackSize = 0;
                        itemstack1.stackSize = l;
                        slot.onSlotChanged();
                        flag1 = true;
                    }
                    else if (itemstack1.stackSize < p_75135_1_.getMaxStackSize())
                    {
                        p_75135_1_.stackSize -= p_75135_1_.getMaxStackSize() - itemstack1.stackSize;
                        itemstack1.stackSize = p_75135_1_.getMaxStackSize();
                        slot.onSlotChanged();
                        flag1 = true;
                    }
                }

                if (p_75135_4_)
                {
                    --k;
                }
                else
                {
                    ++k;
                }
            }
        }

        DQR.func.debugString("TESTTEST4 : " + k);

        if (p_75135_1_.stackSize > 0)
        {
            if (p_75135_4_)
            {
                k = p_75135_3_ - 1;
            }
            else
            {
                k = p_75135_2_;
            }

            while (!p_75135_4_ && k < p_75135_3_ || p_75135_4_ && k >= p_75135_2_)
            {
            	if((k == 54 && !(p_75135_1_.getItem() instanceof DqmItemWeaponBase)) ||
            	   (k == 55 && !(p_75135_1_.getItem() instanceof DqmItemArmorBase)) ||
            	   (k == 56 && !(p_75135_1_.getItem() instanceof DqmItemAccessoryBase)))
            	{

            	}else
            	{
            		if(
            			(k == 55 && ((DqmItemArmorBase)p_75135_1_.getItem()).armorType != 1)||
            		    (k == 56 && ((DqmItemAccessoryBase)p_75135_1_.getItem()).type != EnumDqmSubEquipType.Shield)
            		  )
            		{

            		}else
            		{
		            	DQR.func.debugString("TESTTEST5 : " + k);
		                slot = (Slot)this.inventorySlots.get(k);
		                itemstack1 = slot.getStack();

		                if (itemstack1 == null)
		                {
		                    slot.putStack(p_75135_1_.copy());
		                    slot.onSlotChanged();
		                    p_75135_1_.stackSize = 0;
		                    flag1 = true;
		                    break;
		                }
	            	}
            	}

                if (p_75135_4_)
                {
                    --k;
                }
                else
                {
                    ++k;
                }
            }
        }

        DQR.func.debugString("TESTTEST6 : " + k);
        return flag1;
    }
}