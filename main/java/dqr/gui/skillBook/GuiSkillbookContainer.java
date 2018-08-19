package dqr.gui.skillBook;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.DQR;
import dqr.items.base.DqmItemSkillBookBase;

public class GuiSkillbookContainer extends Container
{
    private InventorySkillbook inventory;
    private EntityPlayer ep;
    public int page = 0;

    public Slot modoru;
    public Slot susumu;
    ItemStack skillBook = null;

    public GuiSkillbookContainer(EntityPlayer ep)
    {
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	this.ep = ep;

    	if(ep.getHeldItem().getItem() instanceof DqmItemSkillBookBase)
    	{
    		skillBook = ep.getHeldItem();
    	}

    	inventory = new InventorySkillbook(ep, skillBook);
        inventory.openInventory();



        //int i = 2 * 18 + 1;

        //for (int j = 0; j < 3; ++j)
        //{
        /*
        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new SlotSkillbook(inventory, k + 5 + 0 * 9, 8 + k * 18, 18 + 0 * 18));
        }
        */
        //}
        DQR.func.debugString("TESTTEST 001 : " + ep.worldObj.isRemote);
        for (int k = 0; k < 5; ++k)
        {
        	this.addSlotToContainer(new SlotSkillbook(inventory, k, 44 + k * 18, 91));
        }

        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
            	if(inventory.getSizeInventory() - 2 < 5 + k + j * 9)
            	{
            		break;
            	}
            	//DQR.func.debugString("TEST : " + j + " / " + k);
                this.addSlotToContainer(new SlotSkillbook(inventory, 5 + k + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }


        modoru = this.addSlotToContainer(new SlotSkillbook(inventory, inventory.getSizeInventory() - 2, 8, 91));
        susumu = this.addSlotToContainer(new SlotSkillbook(inventory, inventory.getSizeInventory() - 1, 152, 91));
        /*
        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotJobChange(inventoryPlayer, j, 8 + j * 18, 161 + i));
        }
        */

    }

    /*
        Containerが開いてられるか
     */
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return true;
    }

    public void refreshInventory()
    {
    	DQR.func.debugString("TESTTEST 001 : " + ep.worldObj.isRemote);
    	this.inventorySlots = new ArrayList();
    	/*
    	//inventory = new InventorySkillbook(ep);
        inventory.openInventory();
        */

        for (int k = 0; k < 5; ++k)
        {
        	this.addSlotToContainer(new SlotSkillbook(inventory, k, 44 + k * 18, 91));
        }

        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
            	if(inventory.getSizeInventory() - 2 < 5 + (27 * page) + k + j * 9)
            	{
            		break;
            	}
            	//DQR.func.debugString("TEST : " + j + " / " + k);
                this.addSlotToContainer(new SlotSkillbook(inventory, 5 + k + (27 * page) + j * 9, 8 + k * 18, 18 + j * 18));
            }
        }


        modoru = this.addSlotToContainer(new SlotSkillbook(inventory, inventory.getSizeInventory() - 2, 8, 91));
        susumu = this.addSlotToContainer(new SlotSkillbook(inventory, inventory.getSizeInventory() - 1, 152, 91));

    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_)
    {
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
            /*
            //シフトクリック時に、このアイテムだったら動かさない。
            else if(slot.getStack() != null && slot.getStack().getItem() == DQR.instance.InventoryItemJobChange)
            {
                return null;
            }
            */
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

    /*
        Containerを閉じるときに呼ばれる
     */
    /*
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
        this.inventory.closeInventory();
    }
    */

    public void writeSkillBook()
    {
    	if(!ep.worldObj.isRemote)
    	{
	    	if(skillBook != null)
	    	{
				NBTTagCompound data = skillBook.getTagCompound();

				if(data == null)
				{
					data = new NBTTagCompound();
				}


				for(int cnt = 0; cnt < 5; cnt++)
				{
					if(inventory.getStackInSlot(cnt) != null)
					{
						ItemStack stack = inventory.getStackInSlot(cnt);
						NBTTagCompound nbt2 = stack.getTagCompound();


						data.setInteger("skill" + cnt + "_job", nbt2.getInteger("jobId"));
						data.setInteger("skill" + cnt + "_idx", nbt2.getInteger("skillIdx"));
					}else
					{
						data.setInteger("skill" + cnt + "_job",-1);
						data.setInteger("skill" + cnt + "_idx",-1);
					}

					DQR.func.debugString("TEST 10 : " + data.getInteger("skill" + cnt + "_job") + " / " + data.getInteger("skill" + cnt + "_idx"));
				}

				skillBook.setTagCompound(data);
				ep.inventory.setInventorySlotContents(ep.inventory.currentItem, skillBook);
	    	}
    	}
    }

    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
        writeSkillBook();
		if(p_75134_1_.worldObj.isRemote)
		{
			//ExtendedPlayerProperties3.get(p_75134_1_).saveNBTData(data);
    		//PacketHandler.INSTANCE.sendToServer(new MessageServerDataSend(data, 3));
    	}

		//FuncJobSkillData.calcPlayerStatus(p_75134_1_);
		//FuncJobSkillData.calcPlayerStatus2(p_75134_1_);

        this.inventory.closeInventory();
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer ep)
    {
    	DQR.func.debugString("CLICK !! : " + par1 + " / " + par2 + " / " + par3 + " : " + this.susumu.slotNumber + " / " + this.modoru.slotNumber);
    	if(par1 == this.susumu.slotNumber)
    	{
    		if(inventory.getSizeInventory() / 27 < this.page + 1)
    		{
    			this.page = 0;
    		}else
    		{
    			this.page = this.page + 1;
    		}
    		ep.worldObj.playSoundAtEntity(ep, "gui.button.press", 1.0F, 1.0F);
    		this.refreshInventory();
    	}else if(par1 == this.modoru.slotNumber)
    	{
    		if(this.page - 1 < 0)
    		{
    			this.page = inventory.getSizeInventory() / 27;
    		}else
    		{
    			this.page = this.page - 1;
    		}
    		ep.worldObj.playSoundAtEntity(ep, "gui.button.press", 1.0F, 1.0F);
    		this.refreshInventory();
    	}else if(par1 < inventory.getSizeInventory() && par1 > 4)
    	{
    		if(inventory.getStackInSlot(par1 + page * 27) != null)
    		{
    			for(int cnt = 0; cnt < 5; cnt++)
    			{
    				if(inventory.getStackInSlot(cnt) == null)
    				{
    					this.inventory.setInventorySlotContents(cnt, inventory.getStackInSlot(par1 + page * 27));
    					writeSkillBook();
    					break;
    				}
    			}
    		}
    	}else if(par1 < 5)
    	{
    		this.inventory.setInventorySlotContents(par1, null);
    		writeSkillBook();
    	}
    	//this.refreshInventory();
    	return null;
    }

}
