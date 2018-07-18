package dqr.gui.dqrShop;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import dqr.entity.npcEntity.npc.DqmEntityNPCBukiya;

public class InventoryDqrShop implements IInventory
{
    //private InventoryPlayer inventoryPlayer;
    //private ItemStack currentItem;
    private DqmEntityNPCBukiya inventoryNPC;
    private ItemStack currentItem;
    private ItemStack[] items;

    public InventoryDqrShop(DqmEntityNPCBukiya inventory)
    {
    	//System.out.println("LOG:" + (inventory == null));
    	inventoryNPC = inventory;
        currentItem = inventoryNPC.getChestItem();

        if(currentItem == null)
        {
        	currentItem = new ItemStack(Items.wooden_sword, 1);
        	currentItem.setTagCompound(new NBTTagCompound());
        	currentItem.getTagCompound().setTag("Items", new NBTTagList());
        }
        //InventorySize
        items = new ItemStack[7];
        //items[1] = new ItemStack(Items.apple, 1);
        //items[3] = new ItemStack(Items.stick, 2);
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
    	/*
        if(!currentItem.hasTagCompound())
        {
            currentItem.setTagCompound(new NBTTagCompound());
            currentItem.getTagCompound().setTag("Items", new NBTTagList());
        }
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
        inventoryNPC.setChestItem(result);

        NBTTagCompound newData = inventoryNPC.getEntityData();
        //inventoryPlayer.readEntityFromNBT(newData);
        inventoryNPC.writeEntityToNBT(newData);
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
        */
        //ItemStack result = new ItemStack(currentItem.getItem(), 1);
        //result.setTagCompound(new NBTTagCompound());
        //result.getTagCompound().setTag("Items", tagList);

        //ItemStackをセットする。NBTは右クリック等のタイミングでしか保存されないため再セットで保存している。
        //inventoryPlayer.mainInventory[inventoryPlayer.currentItem] = result;
    }

    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_)
    {
        return true;
    }

    /*
    public Item getSkillItemFromWeaponId(int par1)
    {
    	switch(par1)
    	{
    		case 2: return DQSkillWs.itemSkillW_20;
    		case 3: return DQSkillWs.itemSkillW_30;
    		case 4: return DQSkillWs.itemSkillW_40;
    		case 5: return DQSkillWs.itemSkillW_50;
    		case 6: return DQSkillWs.itemSkillW_60;
    		case 7: return DQSkillWs.itemSkillW_70;
    		case 8: return DQSkillWs.itemSkillW_80;
    		case 9: return DQSkillWs.itemSkillW_90;
    		case 10: return DQSkillWs.itemSkillW_100;
    		case 11: return DQSkillWs.itemSkillW_110;
    		case 12: return DQSkillWs.itemSkillW_120;
    		case 13: return DQSkillWs.itemSkillW_130;
    		case 24: return DQSkillWs.itemSkillW_240;
    		case 25: return DQSkillWs.itemSkillW_250;

    	}

    	return null;
    }
    */
}
