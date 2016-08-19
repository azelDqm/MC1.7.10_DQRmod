package dqr.gui.itemBag;

import java.util.concurrent.Callable;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ReportedException;
import dqr.gui.subEquip.InventorySubEquip;

public class InventoryItemBag implements IInventory
{
    private InventoryPlayer inventoryPlayer;
    private ItemStack currentItem;
    private ItemStack[] items;

    public InventoryItemBag(InventoryPlayer inventory)
    {
        inventoryPlayer = inventory;
        currentItem = inventoryPlayer.getCurrentItem();

        //InventorySize
        items = new ItemStack[54 + 99];
    }

    public InventoryItemBag(InventoryPlayer inventory, ItemStack stack)
    {
        inventoryPlayer = inventory;
        currentItem = stack;

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

    /*
        Containerが開かれたタイミングでItemStackの持っているNBTからアイテムを読み込んでいる
     */
    @Override
    public void openInventory()
    {
    	//System.out.println("OPENINVENTORY");
        if(!currentItem.hasTagCompound())
        {
            currentItem.setTagCompound(new NBTTagCompound());
            currentItem.getTagCompound().setTag("Items", new NBTTagList());
        }
        NBTTagList tags = (NBTTagList)currentItem.getTagCompound().getTag("Items");

        if(tags == null)
        {
        	currentItem.getTagCompound().setTag("Items", new NBTTagList());
        	tags = (NBTTagList)currentItem.getTagCompound().getTag("Items");
        }

        for(int i = 0; i < tags.tagCount(); i++)
        {
            NBTTagCompound tagCompound = tags.getCompoundTagAt(i);
            int slot = tagCompound.getInteger("Slot");
            if(slot >= 0 && slot < items.length)
            {
                items[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
    }

    /*
        Containerを閉じるときに保存
     */
    @Override
    public void closeInventory()
    {
    	//System.out.println("CLOSEINVENTORY");
        NBTTagList tagList = new NBTTagList();
        for(int i = 0; i < items.length; i++)
        {
            if(items[i] != null)
            {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setInteger("Slot", i);
                items[i].writeToNBT(compound);
                tagList.appendTag(compound);
            }
        }
        ItemStack result = new ItemStack(currentItem.getItem(), 1);
        if(currentItem.hasTagCompound())
        {
        	result.setTagCompound(currentItem.getTagCompound());
        }else
        {
        	result.setTagCompound(new NBTTagCompound());
        }
        result.getTagCompound().setTag("Items", tagList);

        //ItemStackをセットする。NBTは右クリック等のタイミングでしか保存されないため再セットで保存している。
        inventoryPlayer.mainInventory[inventoryPlayer.currentItem] = result;
    }

    public void closeInventory2(InventorySubEquip subEquip)
    {
    	//System.out.println("CLOSEINVENTORY");
        NBTTagList tagList = new NBTTagList();
        for(int i = 0; i < items.length; i++)
        {
            if(items[i] != null)
            {
                NBTTagCompound compound = new NBTTagCompound();
                compound.setInteger("Slot", i);
                items[i].writeToNBT(compound);
                tagList.appendTag(compound);
            }
        }

        ItemStack result = new ItemStack(currentItem.getItem(), 1);
        if(currentItem.hasTagCompound())
        {
        	result.setTagCompound(currentItem.getTagCompound());
        }else
        {
        	result.setTagCompound(new NBTTagCompound());
        }
        result.getTagCompound().setTag("Items", tagList);

    	subEquip.setInventorySlotContents(12, result);
    	subEquip.closeInventory();
        //ItemStackをセットする。NBTは右クリック等のタイミングでしか保存されないため再セットで保存している。

    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }


    public boolean addItemStackToInventory(final ItemStack p_70441_1_)
    {
    	//System.out.println("TESTLINE");
        if (p_70441_1_ != null && p_70441_1_.stackSize != 0 && p_70441_1_.getItem() != null)
        {
            try
            {
                int i;

                if (p_70441_1_.isItemDamaged())
                {
                    i = this.getFirstEmptyStack();

                    if (i >= 0)
                    {
                        this.items[i] = ItemStack.copyItemStack(p_70441_1_);
                        this.items[i].animationsToGo = 5;
                        p_70441_1_.stackSize = 0;
                        return true;
                    }else
                    {
                        return false;
                    }
                }
                else
                {
                    do
                    {
                        i = p_70441_1_.stackSize;
                        p_70441_1_.stackSize = this.storePartialItemStack(p_70441_1_);
                    }
                    while (p_70441_1_.stackSize > 0 && p_70441_1_.stackSize < i);

                    return p_70441_1_.stackSize < i;
                }
            }
            catch (Throwable throwable)
            {
                CrashReport crashreport = CrashReport.makeCrashReport(throwable, "Adding item to inventory");
                CrashReportCategory crashreportcategory = crashreport.makeCategory("Item being added");
                crashreportcategory.addCrashSection("Item ID", Integer.valueOf(Item.getIdFromItem(p_70441_1_.getItem())));
                crashreportcategory.addCrashSection("Item data", Integer.valueOf(p_70441_1_.getItemDamage()));
                crashreportcategory.addCrashSectionCallable("Item name", new Callable()
                {
                    private static final String __OBFID = "CL_00001710";
                    public String call()
                    {
                        return p_70441_1_.getDisplayName();
                    }
                });
                throw new ReportedException(crashreport);
            }
        }
        else
        {
            return false;
        }
    }

    public int getFirstEmptyStack()
    {
        for (int i = 0; i < this.items.length; ++i)
        {
            if (this.items[i] == null)
            {
                return i;
            }
        }

        return -1;
    }


    private int storePartialItemStack(ItemStack p_70452_1_)
    {
        Item item = p_70452_1_.getItem();
        int i = p_70452_1_.stackSize;
        int j;

        if (p_70452_1_.getMaxStackSize() == 1)
        {
            j = this.getFirstEmptyStack();

            if (j < 0)
            {
                return i;
            }
            else
            {
                if (this.items[j] == null)
                {
                    this.items[j] = ItemStack.copyItemStack(p_70452_1_);
                }

                return 0;
            }
        }
        else
        {
            j = this.storeItemStack(p_70452_1_);

            if (j < 0)
            {
                j = this.getFirstEmptyStack();
            }

            if (j < 0)
            {
                return i;
            }
            else
            {
                if (this.items[j] == null)
                {
                    this.items[j] = new ItemStack(item, 0, p_70452_1_.getItemDamage());

                    if (p_70452_1_.hasTagCompound())
                    {
                        this.items[j].setTagCompound((NBTTagCompound)p_70452_1_.getTagCompound().copy());
                    }
                }

                int k = i;

                if (i > this.items[j].getMaxStackSize() - this.items[j].stackSize)
                {
                    k = this.items[j].getMaxStackSize() - this.items[j].stackSize;
                }

                if (k > this.getInventoryStackLimit() - this.items[j].stackSize)
                {
                    k = this.getInventoryStackLimit() - this.items[j].stackSize;
                }

                if (k == 0)
                {
                    return i;
                }
                else
                {
                    i -= k;
                    this.items[j].stackSize += k;
                    this.items[j].animationsToGo = 5;
                    return i;
                }
            }
        }
    }

    private int storeItemStack(ItemStack p_70432_1_)
    {
        for (int i = 0; i < this.items.length; ++i)
        {
            if (this.items[i] != null && this.items[i].getItem() == p_70432_1_.getItem() && this.items[i].isStackable() && this.items[i].stackSize < this.items[i].getMaxStackSize() && this.items[i].stackSize < this.getInventoryStackLimit() && (!this.items[i].getHasSubtypes() || this.items[i].getItemDamage() == p_70432_1_.getItemDamage()) && ItemStack.areItemStackTagsEqual(this.items[i], p_70432_1_))
            {
                return i;
            }
        }

        return -1;
    }
}