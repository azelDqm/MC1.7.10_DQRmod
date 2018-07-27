package dqr.gui.dama;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.PacketHandler;
import dqr.dataTable.FuncJobSkillData;
import dqr.packetMessage.MessageServerDataSend;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiSkillJobContainer extends Container
{
    private InventorySkillJob inventory;
    private EntityPlayer player;

    public GuiSkillJobContainer(EntityPlayer ep)
    {
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	this.player = ep;
    	inventory = new InventorySkillJob(ep , -1);
        inventory.openInventory();

        int i = 2 * 18 + 1;

        //for (int j = 0; j < 3; ++j)
        //{
        /*
        for (int k = 0; k < inventory.getSizeInventory(); ++k)
        {
            this.addSlotToContainer(new SlotSkillJob(inventory, k + 0 * 9, 8 + 93 + k * 18, 49 + 0 * 18));
        }
        */
        //}

        /*
        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotJobChange(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new SlotJobChange(inventoryPlayer, j, 8 + j * 18, 161 + i));
        }
        */

    }

    public void refreshInventory(int par1)
    {
    	this.inventorySlots = new ArrayList();
    	inventory = new InventorySkillJob(player , par1);
        inventory.openInventory();

        int i = 2 * 18 + 1;

        for (int k = 0; k < 9; ++k)
        {
        	ItemStack stack = inventory.getStackInSlot(k);
        	if(stack != null && stack.stackSize > 0)
        	{
        		this.addSlotToContainer(new SlotSkillJob(inventory, k + 0 * 9, 8 + 93 + k * 18, 49));
        	}
        }

        for (int k = 9; k < 18; ++k)
        {
        	ItemStack stack = inventory.getStackInSlot(k);
        	if(stack != null && stack.stackSize > 0)
        	{
        		this.addSlotToContainer(new SlotSkillJob(inventory, k, 8 + 93 + (k - 9) * 18, 49 + 0 + 36));
        	}
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
    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
		if(p_75134_1_.worldObj.isRemote)
    	{
			NBTTagCompound data = new NBTTagCompound();
			ExtendedPlayerProperties3.get(p_75134_1_).saveNBTData(data);
    		PacketHandler.INSTANCE.sendToServer(new MessageServerDataSend(data, 3));
    	}

		ExtendedPlayerProperties.get(p_75134_1_).setJobSkillCalcFlg(true);
		//FuncJobSkillData.calcPlayerStatus(p_75134_1_);
		//FuncJobSkillData.calcPlayerStatus2(p_75134_1_);

        this.inventory.closeInventory();
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer ep)
    {
    	//System.out.println(par1 + "/" + par2 + "/" + par3);
    	//System.out.println("0:" + ep.worldObj.isRemote + ":");
    	if(par1 >= 0 && par1 < inventorySlots.size())
    	{
	    	Slot slot = (Slot)this.inventorySlots.get(par1);
	    	if(slot != null && slot.getStack() != null)
	    	{
	    		NBTTagCompound nbt = slot.getStack().getTagCompound();
	    		if(nbt != null)
	    		{
	    			int jobId = nbt.getInteger("jobId");
	    			int categNum = nbt.getInteger("categNum");
	    			int needSP = nbt.getInteger("needSP");
	    			int jobLv = ExtendedPlayerProperties.get(ep).getJobLv(jobId);
	    			int maxSP = FuncJobSkillData.getMaxSP(jobLv);
	    			int jobSP = ExtendedPlayerProperties3.get(ep).getJobSp(jobId);

	    			if(categNum > 8)
	    			{
	    				if(ExtendedPlayerProperties3.get(ep).getJobSkillSet2(jobId, categNum - 9) == 0)
	    				{
	    					if(maxSP >= jobSP + needSP)
	    					{
	    						ExtendedPlayerProperties3.get(ep).setJobSkillSet2(jobId, categNum - 9, 1);
	    						ExtendedPlayerProperties3.get(ep).incJobSp(jobId, needSP);
	    					}
	    				}else
	    				{
	    					ExtendedPlayerProperties3.get(ep).setJobSkillSet2(jobId, categNum - 9, 0);
	    					ExtendedPlayerProperties3.get(ep).decJobSp(jobId, needSP);
	    				}
	    			}else
	    			{
	    				if(ExtendedPlayerProperties3.get(ep).getJobSkillSet(jobId, categNum) == 0)
	    				{
	    					if(maxSP >= jobSP + needSP)
	    					{
	    						ExtendedPlayerProperties3.get(ep).setJobSkillSet(jobId, categNum, 1);
	    						ExtendedPlayerProperties3.get(ep).incJobSp(jobId, needSP);
	    					}
	    				}else
	    				{
	    					ExtendedPlayerProperties3.get(ep).setJobSkillSet(jobId, categNum, 0);
	    					ExtendedPlayerProperties3.get(ep).decJobSp(jobId, needSP);
	    				}
	    			}

	    			/*
	    			if(ep.worldObj.isRemote)
	    	    	{
	    				NBTTagCompound data = new NBTTagCompound();
	    				ExtendedPlayerProperties3.get(ep).saveNBTData(data);
	    	    		PacketHandler.INSTANCE.sendToServer(new MessageServerDataSend(data, 3));
	    	    	}
	    	    	*/
	    		}

	    		/*
	    		if(ep.worldObj.isRemote)
	    		{
	    			Minecraft.getMinecraft().thePlayer.closeScreen();
	    			Minecraft.getMinecraft().setIngameFocus();
	    		}
	    		*/
	   			//System.out.println("1:" + ep.worldObj.isRemote + ":" + slot.getStack().getDisplayName());
	    		/*
	    		if(slot.getStack().getItem() instanceof DqmItemEmblemBase)
	    		{
	    			//System.out.println("2:" + ep.worldObj.isRemote + ":" + slot.getStack().getDisplayName());

	        		DqmItemEmblemBase emb = (DqmItemEmblemBase)slot.getStack().getItem();
	    			PacketHandler.INSTANCE.sendToServer(new MessageServerJobChange(emb.getJobEnum().getId()));
	        		//ExtendedPlayerProperties.get(ep).setJob(emb.getJobEnum().getId());
	        		//ep.worldObj.playSoundAtEntity(ep, "dqr:player.tensyoku", 1.0F, 1.0F);
	    		}

	    		//System.out.println(slot.getStack().getDisplayName());
	    		if(ep.worldObj.isRemote)
	    		{
	    			Minecraft.getMinecraft().thePlayer.closeScreen();
	    			Minecraft.getMinecraft().setIngameFocus();
	    		}
	    		*/



	    	}
    	}

    	return null;
    }
}
