package dqr.gui.subEquip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.blocks.chest.tileEntity.DqmTileEntityEnderChest;
import dqr.items.interfaceBase.ISubEquip;
import dqr.playerData.ExtendedPlayerProperties2;
import dqr.playerData.MessagePlayerProperties2;

//public class InventoryDqmEnderChest extends InventoryBasic
public class InventorySubEquip implements IInventory
{
    private DqmTileEntityEnderChest associatedChest;
    private static final String __OBFID = "CL_00001759";

    private EntityPlayer ep;
    //private ItemStack currentItem;
    private ItemStack[] items;

    public InventorySubEquip(EntityPlayer ep)
    {
    	//System.out.println("isRemote:" + ep.worldObj.isRemote);
        this.ep = ep;
        //this.selectChestId = ExtendedPlayerProperties2.get(ep).getSetlectEnderChestID();
        //currentItem = inventoryPlayer.getCurrentItem();

        //InventorySize
        items = new ItemStack[20];
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
    	/*
    	if(this.ep != null)
    	{
    		System.out.println("CODE1");
    		ExtendedPlayerProperties2.get(ep).setFukuroOpen(true);
    	}
    	*/
    	//System.out.println("===============" + ExtendedPlayerProperties2.get(ep).getFukuroOpen());


    	/*
    	if (this.associatedChest != null)
        {
            this.associatedChest.func_145969_a();
        }
        */


        /*
        if(!currentItem.hasTagCompound())
        {
            currentItem.setTagCompound(new NBTTagCompound());
            currentItem.getTagCompound().setTag("Items", new NBTTagList());
        }
        */

        //NBTTagList tags = (NBTTagList)currentItem.getTagCompound().getTag("Items");
	        NBTTagList tags = ExtendedPlayerProperties2.get(ep).getSubEquips();

	        if(tags != null)
	        {
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
           //super.openInventory();
    }

    public void closeInventory()
    {

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

        /*
    	if(this.ep != null)
    	{
    		System.out.println("CODE2");
    		ExtendedPlayerProperties2.get(ep).setFukuroOpen(false);
    	}
    	*/
        ExtendedPlayerProperties2.get(ep).setSubEquips(tagList);
        if(!ep.worldObj.isRemote)
        {
        	PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties2(ep), (EntityPlayerMP)ep);
        }
        /*
        ItemStack result = new ItemStack(currentItem.getItem(), 1);
        result.setTagCompound(new NBTTagCompound());
        result.getTagCompound().setTag("Items", tagList);
        */

        //ItemStackをセットする。NBTは右クリック等のタイミングでしか保存されないため再セットで保存している。
        //inventoryPlayer.mainInventory[inventoryPlayer.currentItem] = result;

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

    public void dropAllItems(EntityPlayer player) {
        int i;

        for (i = 0; i < this.getSizeInventory(); ++i) {

            ItemStack item = this.getStackInSlot(i);

            if (item == null) continue;

            if (item.getItem() instanceof ISubEquip) {

                if (!((ISubEquip) item.getItem()).canDrop(EnumDqmSubEquipType.getEquipmentTypeFromSlot(i), item, player)) continue;
                player.func_146097_a(item, true, false);
                this.setInventorySlotContents(i, null);

            } else {
                player.func_146097_a(item, true, false);
                this.setInventorySlotContents(i, null);
            }

        }
    }

    //NBT
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        this.writeToNBT(nbt);
        ;
        return nbt;
    }

    public void readFromNBT(NBTTagCompound nbt) {
        this.readFromNBT(nbt);
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

    public int hasPiasu(Item par1)
    {
    	if(this.items[0] != null && this.items[0].getItem() == par1)
    	{
    		return 0;
    	}else if(this.items[1] != null && this.items[1].getItem() == par1)
    	{
    		return 1;
    	}
    	return -1;
    }

    public int hasPiasu2(Item par1)
    {
    	if(this.items[0] != null && this.items[0].getItem() == par1 && getItemDamgePercent(this.items[0]) < 90)
    	{
    		return 0;
    	}else if(this.items[1] != null && this.items[1].getItem() == par1 && getItemDamgePercent(this.items[1]) < 90)
    	{
    		return 1;
    	}
    	return -1;
    }

    public int hasSonota(Item par1)
    {
    	if(this.items[9] != null && this.items[9].getItem() == par1)
    	{
    		return 9;
    	}else if(this.items[10] != null && this.items[10].getItem() == par1)
    	{
    		return 10;
    	}
    	return -1;
    }

    public int hasUdewa(Item par1)
    {
    	if(this.items[3] != null && this.items[3].getItem() == par1)
    	{
    		return 3;
    	}else if(this.items[4] != null && this.items[4].getItem() == par1)
    	{
    		return 4;
    	}
    	return -1;
    }

    public int hasUdewa2(Item par1)
    {
    	if(this.items[3] != null && this.items[3].getItem() == par1 && getItemDamgePercent(this.items[3]) < 90)
    	{
    		return 3;
    	}else if(this.items[4] != null && this.items[4].getItem() == par1 && getItemDamgePercent(this.items[4]) < 90)
    	{
    		return 4;
    	}
    	return -1;
    }

    public int hasYubiwa(Item par1)
    {
    	if(this.items[5] != null && this.items[5].getItem() == par1)
    	{
    		return 5;
    	}else if(this.items[6] != null && this.items[6].getItem() == par1)
    	{
    		return 6;
    	}else if(this.items[7] != null && this.items[7].getItem() == par1)
    	{
    		return 7;
    	}else if(this.items[8] != null && this.items[8].getItem() == par1)
    	{
    		return 8;
    	}
    	return -1;
    }

    public int hasYubiwa2(Item par1)
    {
    	if(this.items[5] != null && this.items[5].getItem() == par1 && getItemDamgePercent(this.items[5]) < 90)
    	{
    		return 5;
    	}else if(this.items[6] != null && this.items[6].getItem() == par1 && getItemDamgePercent(this.items[6]) < 90)
    	{
    		return 6;
    	}else if(this.items[7] != null && this.items[7].getItem() == par1 && getItemDamgePercent(this.items[7]) < 90)
    	{
    		return 7;
    	}else if(this.items[8] != null && this.items[8].getItem() == par1 && getItemDamgePercent(this.items[8]) < 90)
    	{
    		return 8;
    	}
    	return -1;
    }

    public int hasKubikazari(Item par1)
    {
    	if(this.items[2] != null && this.items[2].getItem() == par1)
    	{
    		return 2;
    	}
    	return -1;
    }

    public int hasShield(Item par1)
    {
    	if(this.items[11] != null && this.items[11].getItem() == par1)
    	{
    		return 11;
    	}
    	return -1;
    }

    public int getItemDamgePercent(ItemStack par1)
    {
     	int ret = 0;

    	ret = par1.getItemDamage() * 100 / par1.getMaxDamage();

    	return ret;
    }
}
