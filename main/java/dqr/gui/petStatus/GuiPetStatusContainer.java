package dqr.gui.petStatus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class GuiPetStatusContainer extends Container
{
    //private IntentoryPetStatus inventory;
    private InventoryPlayer inventoryPlayer;
    private EntityPlayer ep;
    private int pageNo = 0;

    public GuiPetStatusContainer(EntityPlayer player)
    {
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	//inventory = new InventoryPetBook();
    	inventoryPlayer = player.inventory;
    	//inventory = new IntentoryPetStatus(player, 0);
        //inventory.openInventory();

        this.ep = player;


        int i = 2 * 18 + 1;

        /*
        for (int j = 0; j < 6; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotPetStatus(inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }

        this.addSlotToContainer(new SlotPetStatus(inventory, 54, 8 + 1 * 18, 22 + 6 * 18));
        this.addSlotToContainer(new SlotPetStatus(inventory, 55, 8 + 7 * 18, 22 + 6 * 18));
        */

        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                //this.addSlotToContainer(new Slot(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 54 + j * 18 + i));
            	this.addSlotToContainer(new Slot(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 84 + j * 18));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            //this.addSlotToContainer(new Slot(inventoryPlayer, j, 8 + j * 18, 112 + i));
        	this.addSlotToContainer(new Slot(inventoryPlayer, j, 8 + j * 18, 142));
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

            /*
            if (p_82846_2_ < this.inventory.getSizeInventory())
            {
                if (!this.mergeItemStack(itemstack1, this.inventory.getSizeInventory(), this.inventorySlots.size(), true))
                {
                    return null;
                }
            }

            //シフトクリック時に、このアイテムだったら動かさない。
            //else if(slot.getStack() != null && slot.getStack().getItem() == DQR.instance.InventoryItemJobChange)
            //{
            //    return null;
            //}
            else if (!this.mergeItemStack(itemstack1, 0, this.inventory.getSizeInventory(), false))
            {
                return null;
            }
            */


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
        //ExtendedPlayerProperties3.get(ep).setPetStatudData(null);
        //ExtendedPlayerProperties3.get(ep).setStatusPet(null);
        //this.inventory.closeInventory();
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer ep)
    {

    	//System.out.println(par1 + "/" + par2 + "/" + par3);
    	//System.out.println("0:" + ep.worldObj.isRemote + ":");


    	//System.out.println("TEST:" + par1);

    	return super.slotClick(par1, par2, par3, ep);
    }
}
