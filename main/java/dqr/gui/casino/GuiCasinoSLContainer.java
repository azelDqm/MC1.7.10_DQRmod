package dqr.gui.casino;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;

public class GuiCasinoSLContainer extends Container
{
    //private InventoryFarmBook inventory;
    private EntityPlayer ep;
    private int pageNo = 0;

    public GuiCasinoSLContainer(EntityPlayer player)
    {
    	/*
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	//inventory = new InventoryPetBook();
    	inventory = new InventoryFarmBook(player, 0);
        inventory.openInventory();

        this.ep = player;

        int i = 2 * 18 + 1;


        for (int y1 = 0; y1 < 3; ++y1)
        {
        	for (int x1 = 0; x1 < 3; ++x1)
        	{
        		this.addSlotToContainer(new SlotFarmBook(inventory, x1 + y1 * 3, 16 + x1 * 18, 16 + y1 * 18));
        		//this.addSlotToContainer(new SlotFarmBook(inventory, x1 + y1 * 3, 15 + x1 * 18, 15 + y1 * 18));
        	}
        }

        //System.out.println("TEST2=================");
        for (int y2 = 0; y2 < 3; ++y2)
        {
        	for (int x2 = 0; x2 < 3; ++x2)
        	{
        		this.addSlotToContainer(new SlotFarmBook(inventory, x2 + y2 * 3 + 9, 83 + x2 * 18, 16 + y2 * 18));
        	}
        }
        //System.out.println("TEST3=================");
        this.addSlotToContainer(new SlotFarmBook(inventory, 18, 67, 101));

        this.addSlotToContainer(new SlotFarmBook(inventory, 19, 33, 101));
        this.addSlotToContainer(new SlotFarmBook(inventory, 20, 101, 101));
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

    	/*
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
        */
    	return null;
    }

    /*
        Containerを閉じるときに呼ばれる
     */
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer ep)
    {

    	return null;
    }

}
