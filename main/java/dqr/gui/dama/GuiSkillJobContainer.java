package dqr.gui.dama;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.dataTable.FuncJobSkillData;
import dqr.packetMessage.MessageServerDataSend;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties5;

public class GuiSkillJobContainer extends Container
{
    private InventorySkillJob inventory;
    private EntityPlayer player;
    public boolean systemEnable = true;
    private int playerJob = -1;

    public GuiSkillJobContainer(EntityPlayer ep)
    {
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	this.player = ep;
    	inventory = new InventorySkillJob(ep , -1);
        inventory.openInventory();
        playerJob = ExtendedPlayerProperties.get(ep).getJob();

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
        		this.addSlotToContainer(new SlotSkillJob(inventory, k + 0 * 9, 8 + 93 + k * 18, 42));
        	}
        }

        for (int k = 9; k < 18; ++k)
        {
        	ItemStack stack = inventory.getStackInSlot(k);
        	if(stack != null && stack.stackSize > 0)
        	{
        		this.addSlotToContainer(new SlotSkillJob(inventory, k, 8 + 93 + (k - 9) * 18, 42 + 0 + 32));
        	}
        }

        //DQR.func.debugString("TEST4 : " + DQR.enumGetter.getJobSPSkillCounterJ(inventory.getJobId()));

        //if(systemEnable)
        if(inventory.getJobId() == EnumDqmJob.Asobinin.getId())
        {
	        int lastY = 0;
	        for (int k = 18; k < DQR.enumGetter.getJobSPSkillCounterJ2(inventory.getJobId()) + 18; ++k)
	        {
	        	ItemStack stack = inventory.getStackInSlot(k);
	        	if(stack != null && stack.stackSize > 0)
	        	{
	        		this.addSlotToContainer(new SlotSkillJob(inventory, k, 8 + 93 + ((k - 18) % 9) * 18, 108 + 18 * ((k - 18) / 9)));
	        		lastY = 108 + 18 * ((k - 18) / 9);
	        	}
	        }

	        int resX = 0;
	        for (int k = 18 + DQR.enumGetter.getJobSPSkillCounterJ2(inventory.getJobId()); k < DQR.enumGetter.getJobSPSkillCounterJ2(inventory.getJobId())
	        		+ 18 + DQR.enumGetter.getJobSPSkillCounterAllJ(inventory.getJobId()); ++k)
	        {
	        	ItemStack stack = inventory.getStackInSlot(k);
	        	if(stack != null && stack.stackSize > 0)
	        	{
	        		this.addSlotToContainer(new SlotSkillJob(inventory, k, 8 + 93 + (resX % 9) * 18, lastY + 32 + 18 * (resX / 9)));
	        		resX = resX + 1;
	        	}
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
        DQR.func.debugString("JobSkillDebug : 1");
		if(p_75134_1_.worldObj.isRemote)
    	{
			DQR.func.debugString("JobSkillDebug : 2");
			NBTTagCompound data = new NBTTagCompound();
			ExtendedPlayerProperties5.get(p_75134_1_).setPlayerName(p_75134_1_.getCommandSenderName());
			ExtendedPlayerProperties5.get(p_75134_1_).setPlayerUUID(p_75134_1_.getUniqueID().toString());
			ExtendedPlayerProperties5.get(p_75134_1_).saveNBTData(data);
    		PacketHandler.INSTANCE.sendToServer(new MessageServerDataSend(data, 5));
    	}

		DQR.func.debugString("JobSkillDebug : 3");
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
	    			int jobSP = ExtendedPlayerProperties5.get(ep).getJobSp(jobId);

	    			if(categNum >= 18)
	    			{
	    				int jobIdx = nbt.getInteger("skillIdx");
	    				int isJobFlg = nbt.getInteger("isJobSkill");
	    				EnumDqmSkillJ skill = DQR.enumGetter.getSkillJ(jobId, jobIdx);
	    				int skillPerms = ExtendedPlayerProperties5.get(ep).getJobSPSkillSet(jobId, jobIdx);

	    				//DQR.func.debugString("TEST4 : " + jobId + " / "

	    				if(isJobFlg == 2 && skill != null)
	    				{
	    					DQR.func.debugString("TEST4 : " + maxSP + " / " +  jobSP + " / " + skill.getNeedsp() + " / " + skill.getNeedsp_All());
	    					DQR.func.debugString("TEST5 : " + skillPerms + " / " + (jobSP - skill.getNeedsp() + skill.getNeedsp_All()));
	    					//全職でを指定した場合
	    					if(skillPerms == 1)
	    					{
	    						//既に「その職のみ」が指定されている場合
	    						if(maxSP >= jobSP - skill.getNeedsp() + skill.getNeedsp_All())
	    						{
		    						ExtendedPlayerProperties5.get(ep).setJobSPSkillSet(jobId, jobIdx, 2);
		    						ExtendedPlayerProperties5.get(ep).setJobSp(jobId, jobSP - skill.getNeedsp() + skill.getNeedsp_All());
	    						}
	    					}else if(skillPerms == 2)
	    					{
	    						ExtendedPlayerProperties5.get(ep).setJobSPSkillSet(jobId, jobIdx, 0);
	    						ExtendedPlayerProperties5.get(ep).decJobSp(jobId, skill.getNeedsp_All());
	    					}else
	    					{
	    						if(maxSP >= jobSP + skill.getNeedsp_All())
	    						{
	    							ExtendedPlayerProperties5.get(ep).setJobSPSkillSet(jobId, jobIdx, 2);
	    							ExtendedPlayerProperties5.get(ep).incJobSp(jobId, skill.getNeedsp_All());
	    						}
	    					}
	    				}else if(isJobFlg == 1 && skill != null)
	    				{
	    					DQR.func.debugString("TEST14 : " + maxSP + " / " +  jobSP + " / " + skill.getNeedsp() + " / " + skill.getNeedsp_All());
	    					DQR.func.debugString("TEST15 : "  + skillPerms + " / " + (jobSP - skill.getNeedsp() + skill.getNeedsp_All()));
	    					//その職のみを指定した場合
	    					if(skillPerms == 1)
	    					{
	    						ExtendedPlayerProperties5.get(ep).setJobSPSkillSet(jobId, jobIdx, 0);
	    						ExtendedPlayerProperties5.get(ep).decJobSp(jobId, skill.getNeedsp());
	    					}else if(skillPerms == 2)
	    					{
	    						if(maxSP >= jobSP - skill.getNeedsp_All() + skill.getNeedsp())
	    						{
		    						ExtendedPlayerProperties5.get(ep).setJobSPSkillSet(jobId, jobIdx, 1);
		    						ExtendedPlayerProperties5.get(ep).setJobSp(jobId, jobSP - skill.getNeedsp_All() + skill.getNeedsp());
	    						}
	    					}else
	    					{
	    						if(maxSP >= jobSP + skill.getNeedsp())
	    						{
	    							ExtendedPlayerProperties5.get(ep).setJobSPSkillSet(jobId, jobIdx, 1);
	    							ExtendedPlayerProperties5.get(ep).incJobSp(jobId, skill.getNeedsp());
	    						}
	    					}
	    				}
	    			}else
	    			{
		    			if(categNum > 8)
		    			{
		    				if(ExtendedPlayerProperties5.get(ep).getJobSkillSet2(jobId, categNum - 9) == 0)
		    				{
		    					if(maxSP >= jobSP + needSP)
		    					{
		    						ExtendedPlayerProperties5.get(ep).setJobSkillSet2(jobId, categNum - 9, 1);
		    						ExtendedPlayerProperties5.get(ep).incJobSp(jobId, needSP);
		    					}
		    				}else
		    				{
		    					ExtendedPlayerProperties5.get(ep).setJobSkillSet2(jobId, categNum - 9, 0);
		    					ExtendedPlayerProperties5.get(ep).decJobSp(jobId, needSP);
		    				}
		    			}else
		    			{
		    				if(ExtendedPlayerProperties5.get(ep).getJobSkillSet(jobId, categNum) == 0)
		    				{
		    					if(maxSP >= jobSP + needSP)
		    					{
		    						ExtendedPlayerProperties5.get(ep).setJobSkillSet(jobId, categNum, 1);
		    						ExtendedPlayerProperties5.get(ep).incJobSp(jobId, needSP);
		    					}
		    				}else
		    				{
		    					ExtendedPlayerProperties5.get(ep).setJobSkillSet(jobId, categNum, 0);
		    					ExtendedPlayerProperties5.get(ep).decJobSp(jobId, needSP);
		    				}
		    			}
	    			}

	    		}
	    	}
    	}

    	return null;
    }
}
