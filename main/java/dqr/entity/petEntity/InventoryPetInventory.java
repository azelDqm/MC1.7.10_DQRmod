package dqr.entity.petEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryPetInventory implements IInventory
{
    private DqmPetBase inventoryPlayer;
    private ItemStack currentItem;
    private ItemStack[] items;

    public InventoryPetInventory(DqmPetBase inventory)
    {
    	//System.out.println("LOG:" + (inventory == null));
        inventoryPlayer = inventory;
        currentItem = inventoryPlayer.getChestItem();

        if(currentItem == null)
        {
        	currentItem = new ItemStack(Items.wooden_sword, 1);
        	currentItem.setTagCompound(new NBTTagCompound());
        	currentItem.getTagCompound().setTag("Items", new NBTTagList());
        }
        //InventorySize
        items = new ItemStack[21];
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
        return "InventoryItem";
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
        return true;
    }

    /*
        Containerが開かれたタイミングでItemStackの持っているNBTからアイテムを読み込んでいる
     */
    @Override
    public void openInventory()
    {
        if(!currentItem.hasTagCompound())
        {
            currentItem.setTagCompound(new NBTTagCompound());
            //System.out.println("TEST1");

        }
        NBTTagList tags = (NBTTagList)currentItem.getTagCompound().getTag("Items");

        if(tags == null)
        {
            //this.sampleItemStack.setTagCompound(new NBTTagCompound());
        	currentItem.getTagCompound().setTag("Items", new NBTTagList());
        	//System.out.println("TEST2");
        }else
        {
            for(int i = 0; i < tags.tagCount(); i++)
            {
                NBTTagCompound tagCompound = tags.getCompoundTagAt(i);
                int slot = tagCompound.getByte("Slot");
                if(slot >= 0 && slot < items.length)
                {
                    items[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
                    //System.out.println("TEST3:" + items[slot].getDisplayName());
                }
            }
        }


    }

    /*
        Containerを閉じるときに保存
     */
    @Override
    public void closeInventory()
    {
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
        //inventoryPlayer.mainInventory[inventoryPlayer.currentItem] = result;
        inventoryPlayer.setChestItem(result);

        NBTTagCompound newData = inventoryPlayer.getEntityData();
        //inventoryPlayer.readEntityFromNBT(newData);
        inventoryPlayer.writeEntityToNBT(newData);

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }

}