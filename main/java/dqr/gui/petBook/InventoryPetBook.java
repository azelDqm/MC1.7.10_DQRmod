package dqr.gui.petBook;

import java.util.Set;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import dqr.api.Items.DQMonsters;
import dqr.playerData.ExtendedPlayerProperties3;

public class InventoryPetBook implements IInventory
{
    //private InventoryPlayer inventoryPlayer;
    //private ItemStack currentItem;
    private ItemStack[] items;
    public int page = 0;

    public InventoryPetBook()
    {
        //inventoryPlayer = inventory;
        //currentItem = inventoryPlayer.getCurrentItem();

        //InventorySize
    	//System.out.println("test");

        items = new ItemStack[54];

    }

    public InventoryPetBook(EntityPlayer ep, int par1)
    {
        //inventoryPlayer = inventory;
        //currentItem = inventoryPlayer.getCurrentItem();

        //InventorySize
    	//System.out.println("test2" + ep.worldObj.isRemote);

    	NBTTagCompound playerPet = ExtendedPlayerProperties3.get(ep).getNBTPlayerPetList();

    	Set tags = playerPet.func_150296_c();
    	Object[] tagArray = tags.toArray();

    	int countMax = tags.size() > 54 + (54 * par1) ? 54 + (54 * par1) : tags.size();
    	//System.out.println("test2 : " + tags.size());
        items = new ItemStack[56];

        for(int cnt = 0; cnt < 54; cnt++)
        {
        	if(cnt + (54 * par1) < countMax)
        	{
        		try
        		{

        			NBTTagCompound petData = playerPet.getCompoundTag((String)tagArray[cnt + (54 * par1)]);

        			if(petData != null)
        			{
        				items[cnt] = new ItemStack(getMobTypeItem(petData.getString("petRoot")), 1);

        				items[cnt].setTagCompound(petData);
        				items[cnt].setStackDisplayName(petData.getString("PetName"));
        			}
        		}catch(Exception e)
        		{

        		}
        	}else
        	{
        		items[cnt] = null;
        	}

        	//items[cnt].
        }

        items[54] = null;
        items[55] = null;
        //items[54] = new ItemStack(Items.bone , 1);
        //items[55] = new ItemStack(Items.bone , 1);


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

    public Item getMobTypeItem(String par1)
    {

    	if(par1.equalsIgnoreCase("AKUMA"))
    	{
    		return DQMonsters.itemMonsterAkuma;
    	}else if(par1.equalsIgnoreCase("BEAST"))
    	{
    		return DQMonsters.itemMonsterBeast;
    	}else if(par1.equalsIgnoreCase("BUSSITU"))
    	{
    		return DQMonsters.itemMonsterBussitu;
    	}else if(par1.equalsIgnoreCase("DRAGON"))
    	{
    		return DQMonsters.itemMonsterDragon;
    	}else if(par1.equalsIgnoreCase("METARU"))
    	{
    		return DQMonsters.itemMonsterMetaru;
    	}else if(par1.equalsIgnoreCase("SIZEN"))
    	{
    		return DQMonsters.itemMonsterSizen;
    	}else if(par1.equalsIgnoreCase("SURAIMU"))
    	{
    		return DQMonsters.itemMonsterSuraimu;
    	}else if(par1.equalsIgnoreCase("TOKUSYU"))
    	{
    		return DQMonsters.itemMonsterTokusyu;
    	}else if(par1.equalsIgnoreCase("UNDEAD"))
    	{
    		return DQMonsters.itemMonsterUndead;
    	}else if(par1.equalsIgnoreCase("UNKNOWN"))
    	{
    		return DQMonsters.itemMonsterUnknown;
    	}

    	return DQMonsters.itemMonsterSuraimu;
    }

}
