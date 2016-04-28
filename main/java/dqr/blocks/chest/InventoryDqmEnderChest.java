package dqr.blocks.chest;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import dqr.blocks.chest.tileEntity.DqmTileEntityEnderChest;
import dqr.playerData.ExtendedPlayerProperties2;

//public class InventoryDqmEnderChest extends InventoryBasic
public class InventoryDqmEnderChest implements IInventory
{
    private DqmTileEntityEnderChest associatedChest;
    private static final String __OBFID = "CL_00001759";

    private EntityPlayer ep;
    private int selectChestId = 0;
    //private ItemStack currentItem;
    private ItemStack[] items;

    public InventoryDqmEnderChest(EntityPlayer ep)
    {
    	//System.out.println("isRemote:" + ep.worldObj.isRemote);
        this.ep = ep;
        this.selectChestId = ExtendedPlayerProperties2.get(ep).getSetlectEnderChestID();
        //currentItem = inventoryPlayer.getCurrentItem();

        //InventorySize
        items = new ItemStack[54 + 99];
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

    public void openInventory()
    {
        if (this.associatedChest != null)
        {
            this.associatedChest.func_145969_a();
        }


        /*
        if(!currentItem.hasTagCompound())
        {
            currentItem.setTagCompound(new NBTTagCompound());
            currentItem.getTagCompound().setTag("Items", new NBTTagList());
        }
        */

        //NBTTagList tags = (NBTTagList)currentItem.getTagCompound().getTag("Items");
        if(selectChestId != 0)
        {
	        NBTTagList tags = ExtendedPlayerProperties2.get(ep).getEnderChestTagList(this.selectChestId);

	        if(tags != null)
	        {
		        for(int i = 0; i < tags.tagCount(); i++)
		        {
		            NBTTagCompound tagCompound = tags.getCompoundTagAt(i);
		            int slot = tagCompound.getByte("Slot");
		            if(slot >= 0 && slot < items.length)
		            {
		                items[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
		            }
		        }
	        }
        }
        //super.openInventory();
    }

    public void closeInventory()
    {
        if (this.associatedChest != null)
        {
            this.associatedChest.func_145970_b();
        }

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

        ExtendedPlayerProperties2.get(ep).setEnderChestTagList(tagList, this.selectChestId);
        /*
        ItemStack result = new ItemStack(currentItem.getItem(), 1);
        result.setTagCompound(new NBTTagCompound());
        result.getTagCompound().setTag("Items", tagList);
        */

        //ItemStackをセットする。NBTは右クリック等のタイミングでしか保存されないため再セットで保存している。
        //inventoryPlayer.mainInventory[inventoryPlayer.currentItem] = result;


        //super.closeInventory();
        this.associatedChest = null;
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }

    public void func_146031_a(DqmTileEntityEnderChest p_146031_1_)
    {
        this.associatedChest = p_146031_1_;
    }



    /*
    public InventoryDqmEnderChest()
    {
        super("container.dqm_enderchest", false, 54);
    }



    public void loadInventoryFromNBT(NBTTagList p_70486_1_)
    {
        int i;

        for (i = 0; i < this.getSizeInventory(); ++i)
        {
            this.setInventorySlotContents(i, (ItemStack)null);
        }

        for (i = 0; i < p_70486_1_.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = p_70486_1_.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot") & 255;

            if (j >= 0 && j < this.getSizeInventory())
            {
                this.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound));
            }
        }
    }

    public NBTTagList saveInventoryToNBT()
    {
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.getSizeInventory(); ++i)
        {
            ItemStack itemstack = this.getStackInSlot(i);

            if (itemstack != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                itemstack.writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }

        return nbttaglist;
    }
	*/

    //
    // Do not make give this method the name canInteractWith because it clashes with Container
    //
    /*
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
    {
        return this.associatedChest != null && !this.associatedChest.func_145971_a(p_70300_1_) ? false : super.isUseableByPlayer(p_70300_1_);
    }
    */
}
