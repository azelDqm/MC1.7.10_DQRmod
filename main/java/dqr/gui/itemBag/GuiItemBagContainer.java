package dqr.gui.itemBag;

import invtweaks.api.container.ChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.MinecraftForge;
import dqr.DQR;
import dqr.api.event.DqmBagSlotClickEvent;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.items.base.DqmItemFukuroBase;
import dqr.items.fukuro.DqmItemFukuro;
import dqr.playerData.ExtendedPlayerProperties2;

@ChestContainer
public class GuiItemBagContainer extends Container
{
    private InventoryItemBag inventory;
    public InventoryPlayer epInventory;
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
            	//System.out.println("TESTLINE222");
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

    	//p_75144_3_ == 1 : Shiftクリック 6:ダブルクリック
    	//System.out.println("TEST_XXX : " + p_75144_1_ + " / " + p_75144_2_ + " / " + p_75144_3_);


    	DqmBagSlotClickEvent event = new DqmBagSlotClickEvent(this, p_75144_1_, p_75144_2_, p_75144_3_, p_75144_4_);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled()) {
			return null;
		}


    	if(p_75144_3_ == 2 && this.epInventory != null && this.epInventory.getStackInSlot(p_75144_2_) != null)
    	{
    		if(p_75144_1_ <= 153 && p_75144_1_ >= 0)
    		{
	    		ItemStack sl1 = (ItemStack)(this.epInventory.getStackInSlot(p_75144_2_));
	    		if(sl1.getItem() instanceof DqmItemFukuroBase)
	    		{
	    			//System.out.println("TESTLIN_AAA");
	    			return null;
	    		}

	    		if(sl1.getTagCompound() != null)
	    		{
	    			NBTTagCompound nbt = sl1.getTagCompound();

	    			if(nbt != null && nbt.func_150296_c().size() > DQR.conf.fukuroLimitTagCount && DQR.conf.fukuroLimitTagCount > 0)
	    			{
	    				//System.out.println("TESTLIN_BBB");
	    				return null;
	    			}
	    			//System.out.println("TESTLINE = " + nbt.func_150296_c().size());
	    		}
    		}
    	}

    	//System.out.println("TESTLINE222 : " + p_75144_1_ + " / " + this.getInventory().size() + " / " + (this.getInventory() != null)  + "/ " +  (this.getInventory().size() < p_75144_1_) + "/" + (p_75144_1_ >= 0));
    	//System.out.println("LINT1B : " + p_75144_1_);
    	if(this.getInventory() != null && 153 < p_75144_1_ && p_75144_1_ >= 0)
    	{
    		ItemStack sl2 = (ItemStack)(this.getInventory().get(p_75144_1_));
    		//if(sl != null && sl.getStack() != null && sl.getStack().getItem() instanceof DqmItemFukuroBase)
    		if(sl2 != null && sl2.getTagCompound() != null)
    		{
    			NBTTagCompound nbt = sl2.getTagCompound();
    			//System.out.println("LINT1:" + nbt.func_150296_c().size());
    			if(nbt != null && nbt.func_150296_c().size() > DQR.conf.fukuroLimitTagCount && DQR.conf.fukuroLimitTagCount > 0)
    			{
    				//System.out.println("LINT1");
    				return null;
    			}

    	    	if(sl2 != null &&  sl2.getItem() instanceof DqmItemFukuroBase)
    	    	{
    	    		//System.out.println("TESTLIN444");
    	    		return null;
    	    	}
    			//System.out.println("TESTLINE = " + nbt.func_150296_c().size());
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