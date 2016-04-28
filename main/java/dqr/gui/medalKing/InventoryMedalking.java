package dqr.gui.medalKing;

import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.DQR;

public class InventoryMedalking implements IInventory
{
    private InventoryPlayer inventoryPlayer;
    private ItemStack currentItem;
    private ItemStack[] items;

    public InventoryMedalking(InventoryPlayer inventory, EntityPlayer ep, int guiId)
    {
        inventoryPlayer = inventory;
        currentItem = inventoryPlayer.getCurrentItem();

        //InventorySize
        items = new ItemStack[36];
        int cnt = 0;
        //System.out.println(guiId);

        Map<Item, Integer> itemMap = new LinkedHashMap();
        if(guiId == DQR.conf.GuiID_MKWeapon)
        {
        	itemMap = DQR.medalItem.medalWeapon;
        }else if(guiId == DQR.conf.GuiID_MKArmor)
        {
        	itemMap = DQR.medalItem.medalArmor;
        }else if(guiId == DQR.conf.GuiID_MKMagic)
        {
        	itemMap = DQR.medalItem.medalMagic;
        }else if(guiId == DQR.conf.GuiID_MKMagic2)
        {
        	itemMap = DQR.medalItem.medalMagic2;
        }else if(guiId == DQR.conf.GuiID_MKJob)
        {
        	itemMap = DQR.medalItem.medalJobchange;
        }else if(guiId == DQR.conf.GuiID_MKMisc)
        {
        	//itemMap = DQR.medalItem.medalItem;
        	itemMap = DQR.medalItem.medalItem;
        }else if(guiId == DQR.conf.GuiID_MKMedal)
        {
        	//itemMap = DQR.medalItem.medalItem;
        	itemMap = DQR.medalItem.medalMedal;
        }



        for (Item key : itemMap.keySet()) {
        	items[cnt] = new ItemStack(key, 1);
        	//System.out.println("cnt = " + cnt);

        	/*
        	if(ep.worldObj.isRemote)
        	{
	        	try
	        	{

	        		ItemStack dummyIts = new ItemStack(key, 1);
	        		NBTTagCompound tag = dummyIts.getTagCompound();

	        		if(tag != null)
	        		{
	        			Set test = tag.func_150296_c();
	        			Object[] test2 = test.toArray();

	        			for(int cntE=0; cntE < test2.length; cntE++)
	        			{
	        				System.out.println("TEST:" + (String)test2[cntE]);
	        			}
	        		}

	        		ItemStack dummyIts = new ItemStack(key, 1);

	        		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{itemMap.get(key)});
	        		String message = I18n.format(dummyIts.getDisplayName(), new Object[]{});
	        		//System.out.println(medalValue + "/" + message);
	        		items[cnt].setStackDisplayName(message + medalValue);
	        	}catch (Exception e)
	        	{
	        		;
	        	}
        	}
			*/
    		//List a = items[cnt].getToo99ltip(ep, true);
    		//a.add("TEST");

        	NBTTagCompound nbt = items[cnt].getTagCompound();
        	if(nbt == null)
        	{
        		nbt = new NBTTagCompound();
        	}

        	nbt.setInteger("medalking", itemMap.get(key));
        	items[cnt].setTagCompound(nbt);

        	//nbttaglist1.tagCount();

        	//System.out.println();

        	cnt++;
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
