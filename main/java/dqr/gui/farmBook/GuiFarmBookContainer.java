package dqr.gui.farmBook;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import dqr.DQR;

public class GuiFarmBookContainer extends Container
{
    private InventoryFarmBook inventory;
    private EntityPlayer ep;
    public int pageNo = 0;

    public GuiFarmBookContainer(EntityPlayer player)
    {
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	//inventory = new InventoryPetBook();
    	inventory = new InventoryFarmBook(player, 0);
        inventory.openInventory();

        this.ep = player;

        int i = 2 * 18 + 1;

        if(pageNo != 0)
        {
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
        }

        /*
        this.addSlotToContainer(new SlotFarmBook(inventory, 19, 33, 101));
        this.addSlotToContainer(new SlotFarmBook(inventory, 20, 101, 101));
        */

    }


    public void refreshInventory(int par1)
    {
    	this.inventorySlots = new ArrayList();
    	inventory = new InventoryFarmBook(this.ep , par1);
        inventory.openInventory();

        int i = 2 * 18 + 1;

        if(pageNo != 0)
        {
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
    	DQR.func.debugString("TEST Click" + par1 + "/" + par2 + "/" + par3);

    	if(par1 != 19 && par1 != 20)
    	{
    		return null;
    	}
    	DQR.func.debugString("TEST 2");
    	//NBTTagCompound playerPet = ExtendedPlayerProperties3.get(this.ep).getNBTPlayerPetList();
    	//Set tags = playerPet.func_150296_c();

    	boolean flg = false;

    	/*
        if (par1 == 19)
        {
        	DQR.func.debugString("TEST 3");
        	for(int cnt = this.pageNo - 1; cnt >= this.pageNo - DQR.mutationTable.mutationSeeds.size(); cnt--)
        	{
        		int checkPage = cnt - 1;
        		if(checkPage < -1)
    			{
        			checkPage = checkPage + DQR.mutationTable.mutationSeeds.size() + 1;
    			}

        		if(checkPage == -1)
        		{
        			//checkPage = 0;
        			this.pageNo = 0;
        			break;
        			//flg = true;;
        		}

        		//System.out.println("DEBUG_" + cnt + "/" + checkPage);
        		if(ExtendedPlayerProperties2.get(ep).getFarmRecipe(checkPage) == 1 ||
        		   ExtendedPlayerProperties2.get(ep).getFarmRecipe(checkPage) >= 12)
        		{
        			this.pageNo = checkPage + 1;
        			 break;
        			//return;
        		}
        	}
        }

        if (par1 == 20)
        {
        	DQR.func.debugString("TEST 4");
        	for(int cnt = this.pageNo + 1; cnt <= this.pageNo + DQR.mutationTable.mutationSeeds.size(); cnt++)
        	{
        		int checkPage = cnt - 1;
        		if(checkPage >= DQR.mutationTable.mutationSeeds.size())
    			{
        			checkPage = checkPage - DQR.mutationTable.mutationSeeds.size() - 1;
    			}

        		if(checkPage == -1)
        		{
        			//checkPage = 0;
        			this.pageNo = 0;
        			//return;
        			break;
        		}

        		if(checkPage >= 0 && (ExtendedPlayerProperties2.get(ep).getFarmRecipe(checkPage) == 1 ||
        		   ExtendedPlayerProperties2.get(ep).getFarmRecipe(checkPage) >= 12))
        		{
        			this.pageNo = checkPage + 1;
        			break;
        			//return;
        		}

        	}

        }
        */

        this.inventory.refreshInventory(this.pageNo);
        //System.out.println("TEST PAGE:" + this.pageNo);

    	//if(tags.size() > 54 * (this.pageNo + 1))
        //System.out.println("TESTTTTTTTT!!!!!!!!!!!!");
    	return null;
    }

}
