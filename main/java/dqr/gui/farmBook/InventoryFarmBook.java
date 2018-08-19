package dqr.gui.farmBook;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.DQR;

public class InventoryFarmBook implements IInventory
{
    //private InventoryPlayer inventoryPlayer;
    private ItemStack[] items;

    public InventoryFarmBook(EntityPlayer ep, int page)
    {
        //inventoryPlayer = inventory;
        //currentItem = inventoryPlayer.getCurrentItem();

        //InventorySize
        items = new ItemStack[21];
        //System.out.println(guiId);

        /*
		ItemStack[] seeds = new ItemStack[9];
		ItemStack[] farmBlock = new ItemStack[9];
		Item resultCrop;
		*/

		for(int cnt = 0; cnt < 21; cnt++ )
		{
			items[cnt] = null;
		}


		if (page > 0)
		{
			ItemStack[] seeds = (ItemStack[])DQR.mutationTable.mutationSeeds.get(page - 1);
			for(int cnt = 0; cnt < seeds.length; cnt++)
			{
				items[cnt] = seeds[cnt];
			}

			Block[] blocks =(Block[])DQR.mutationTable.mutationBlocks.get(page - 1);
			int[] meta = (int[])DQR.mutationTable.mutationBlockMetas.get(page - 1);
			for(int cnt = 0; cnt < 9; cnt++)
			{
				items[cnt + 9] = new ItemStack(blocks[cnt], 1, meta[cnt]);

			}

			items[18] = new ItemStack((Item)DQR.mutationTable.mutationResults.get(page - 1) , 1);
		}

    }

    public void refreshInventory(int page)
    {
        items = new ItemStack[21];
        //System.out.println(guiId);

        /*
		ItemStack[] seeds = new ItemStack[9];
		ItemStack[] farmBlock = new ItemStack[9];
		Item resultCrop;
		*/

		for(int cnt = 0; cnt < 21; cnt++ )
		{
			items[cnt] = null;
		}


		if (page > 0)
		{
			ItemStack[] seeds = (ItemStack[])DQR.mutationTable.mutationSeeds.get(page - 1);
			for(int cnt = 0; cnt < seeds.length; cnt++)
			{
				items[cnt] = seeds[cnt];
			}

			Block[] blocks =(Block[])DQR.mutationTable.mutationBlocks.get(page - 1);
			int[] meta = (int[])DQR.mutationTable.mutationBlockMetas.get(page - 1);
			for(int cnt = 0; cnt < 9; cnt++)
			{
				items[cnt + 9] = new ItemStack(blocks[cnt], 1, meta[cnt]);

			}

			items[18] = new ItemStack((Item)DQR.mutationTable.mutationResults.get(page - 1) , 1);
		}
    }

    @Override
    public int getSizeInventory()
    {
        return items.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return items[slot];
    }

    @Override
    public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
    {
        if (this.items[p_70298_1_] != null)
        {
            ItemStack itemstack;

            if (this.items[p_70298_1_].stackSize <= p_70298_2_)
            {
                itemstack = this.items[p_70298_1_];
                this.items[p_70298_1_] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.items[p_70298_1_].splitStack(p_70298_2_);

                if (this.items[p_70298_1_].stackSize == 0)
                {
                    this.items[p_70298_1_] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int p_70304_1_)
    {
        if (this.items[p_70304_1_] != null)
        {
            ItemStack itemstack = this.items[p_70304_1_];
            this.items[p_70304_1_] = null;
            return itemstack;
        }
        return null;
    }

    @Override
    public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
    {
        this.items[p_70299_1_] = p_70299_2_;

        if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit())
        {
            p_70299_2_.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public String getInventoryName()
    {
        return "FarmingPattern";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty() {}

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        //return true;
    	return true;
    }

    /*
        Containerが開かれたタイミングでItemStackの持っているNBTからアイテムを読み込んでいる
     */
    @Override
    public void openInventory()
    {
        //if(!currentItem.hasTagCompound())
        //{
            //currentItem.setTagCompound(new NBTTagCompound());
            //currentItem.getTagCompound().setTag("Items", new NBTTagList());
        //}
    	/*
        NBTTagList tags = (NBTTagList)currentItem.getTagCompound().getTag("Items");

        for(int i = 0; i < tags.tagCount(); i++)
        {
            NBTTagCompound tagCompound = tags.getCompoundTagAt(i);
            int slot = tagCompound.getByte("Slot");
            if(slot >= 0 && slot < items.length)
            {
                items[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
        */
    }

    /*
        Containerを閉じるときに保存
     */
    @Override
    public void closeInventory()
    {
    	/*
        NBTTagList tagList = new NBTTagList();
        for(int i = 0; i < items.length; i++)
        {
            if(items[i] != null)
            {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setByte("Slot", (byte)i);
                items[i].writeToNBT(compound);
                tagList.appendTag(compound);
            }
        }
        ItemStack result = new ItemStack(currentItem.getItem(), 1);
        result.setTagCompound(new NBTTagCompound());
        result.getTagCompound().setTag("Items", tagList);

        //ItemStackをセットする。NBTは右クリック等のタイミングでしか保存されないため再セットで保存している。
        inventoryPlayer.mainInventory[inventoryPlayer.currentItem] = result;
        */
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }

}
