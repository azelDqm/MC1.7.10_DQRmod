package dqr.gui.dqrShop;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import dqr.DQR;
import dqr.api.Items.DQBuilders;
import dqr.api.enums.EnumDqmNpcTalk;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class GuiDqrShopContainer extends Container
{
    private InventoryDqrShop inventory;

    public GuiDqrShopContainer(EntityPlayer ep)
    {
        //inventory = new InventoryItemJobChange(inventoryPlayer);
    	ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BUKIYA.getId(), 1);
    	ExtendedPlayerProperties3.get(ep).setGuiBukiyaPrice(0);
    	if(ExtendedPlayerProperties3.get(ep).getGuiNPCBukiya() == null)
    	{
    		//System.out.println("TEST TEST TEST");
    		return;
    	}
    	inventory = new InventoryDqrShop(ExtendedPlayerProperties3.get(ep).getGuiNPCBukiya());
        inventory.openInventory();

        int i = 2 * 18 + 1;

        //for (int j = 0; j < 3; ++j)
        //{
        for (int k = 0; k < 7; ++k)
        {
            //this.addSlotToContainer(new SlotDqrShop(inventory, k + 0 * 9, 8 + k * 18, 18 + 0 * 18));
        	this.addSlotToContainer(new SlotDqrShop(inventory, k + 0 * 9, 26 + k * 18, 44));
        }
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
        this.inventory.closeInventory();

        int guiPrice = ExtendedPlayerProperties3.get(p_75134_1_).getGuiBukiyaPrice();
        int shopGrade = ExtendedPlayerProperties.get(p_75134_1_).getShopTalkingGrade();
        if(!p_75134_1_.worldObj.isRemote)
        {
        	System.out.println("TYEST : " + shopGrade + " / " +  ExtendedPlayerProperties.get(p_75134_1_).getShopPaymentGold());
        	if(shopGrade == 0 && ExtendedPlayerProperties.get(p_75134_1_).getShopPaymentGold() > 30000 &&
        			p_75134_1_.inventory.addItemStackToInventory(new ItemStack(DQBuilders.itemBuilderShopBukiyaW3, 1)))
        	{
        		DQR.func.doAddChatMessageFix(p_75134_1_, new ChatComponentTranslation("msg.Bukiya.messages.30.txt" ,new Object[] {}));
        		ExtendedPlayerProperties.get(p_75134_1_).setShopPaymentGold(0);
        	}else if(shopGrade == 3 && ExtendedPlayerProperties.get(p_75134_1_).getShopPaymentGold3() > 300000 &&
        			p_75134_1_.inventory.addItemStackToInventory(new ItemStack(DQBuilders.itemBuilderShopBukiyaW4, 1)))
        	{
        		DQR.func.doAddChatMessageFix(p_75134_1_, new ChatComponentTranslation("msg.Bukiya.messages.30.txt" ,new Object[] {}));
        		ExtendedPlayerProperties.get(p_75134_1_).setShopPaymentGold3(0);
        	}else if(shopGrade == 4 && ExtendedPlayerProperties.get(p_75134_1_).getShopPaymentGold4() > 3000000 &&
        			p_75134_1_.inventory.addItemStackToInventory(new ItemStack(DQBuilders.itemBuilderShopBukiyaW6, 1)))
        	{
        		DQR.func.doAddChatMessageFix(p_75134_1_, new ChatComponentTranslation("msg.Bukiya.messages.30.txt" ,new Object[] {}));
        		ExtendedPlayerProperties.get(p_75134_1_).setShopPaymentGold4(0);
        	}else if(shopGrade == 6 && ExtendedPlayerProperties.get(p_75134_1_).getShopPaymentGold6() > 10000000 &&
        			p_75134_1_.inventory.addItemStackToInventory(new ItemStack(DQBuilders.itemBuilderShopBukiyaW5, 1)))
        	{
        		DQR.func.doAddChatMessageFix(p_75134_1_, new ChatComponentTranslation("msg.Bukiya.messages.30.txt" ,new Object[] {}));
        		ExtendedPlayerProperties.get(p_75134_1_).setShopPaymentGold6(0);
        	}else if(guiPrice > 0)
	        {
	        	DQR.func.doAddChatMessageFix(p_75134_1_, new ChatComponentTranslation("msg.Bukiya.messages.11.txt" ,new Object[] {}));
	        }else
	        {
	        	DQR.func.doAddChatMessageFix(p_75134_1_, new ChatComponentTranslation("msg.Bukiya.messages.12.txt" ,new Object[] {}));
	        }
        }

        //System.out.println("TEST_XXX : " + ExtendedPlayerProperties.get(p_75134_1_).getShopTalkingGrade());

        p_75134_1_.worldObj.playSoundAtEntity(p_75134_1_, "dqr:player.pi", 1.0F, 1.0F);
        ExtendedPlayerProperties.get(p_75134_1_).setNpcTalk(EnumDqmNpcTalk.BUKIYA.getId(), 0);
    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer ep)
    {

    	ExtendedPlayerProperties3.get(ep).setGuiBukiyaPhase(par1);
    	//System.out.println(par1 + "/" + par2 + "/" + par3);
    	//System.out.println("0:" + ep.worldObj.isRemote + ":");
    	if(par1 >= 0 && par1 < 7)
    	{
	    	Slot slot = (Slot)this.inventorySlots.get(par1);
	    	if(slot != null && slot.getStack() != null)
	    	{
	    		int epGold = ExtendedPlayerProperties.get(ep).getGold();
	    		NBTTagCompound itemNbt = slot.getStack().getTagCompound();

	    		if(itemNbt != null)
	    		{
		    		int needGold = itemNbt.getInteger("ItemPrice");
		    		needGold = DQR.calcPlayerStatus.calcShoninGold(needGold, ep);

		    		if(epGold >= needGold)
		    		{
		    				if(ep.inventory.addItemStackToInventory(new ItemStack(slot.getStack().getItem(), 1)))
		    				{
		    					ExtendedPlayerProperties.get(ep).addShopPaymentGold(itemNbt.getInteger("ItemPrice"), ExtendedPlayerProperties.get(ep).getShopTalkingGrade());
		    					ExtendedPlayerProperties.get(ep).setGold(epGold - needGold);
		    					ep.worldObj.playSoundAtEntity(ep, "dqr:player.okane", 0.5F, 1.5F);
		    					this.inventory.setInventorySlotContents(par1, null);
		    					ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BUKIYA.getId(), 2);
		    					ExtendedPlayerProperties3.get(ep).setGuiBukiyaPrice(needGold);
		    				}else
		    				{
		    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.medalking.talk.6.txt",new Object[] {}));
		    	    			if(ep.worldObj.isRemote)
		    	    			{
		    	    				/*
		    	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bukiya.messages.7.txt" ,new Object[] {}));
		    	    				Minecraft.getMinecraft().thePlayer.closeScreen();
		    	    				Minecraft.getMinecraft().setIngameFocus();
		    	    				*/
		    	    				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BUKIYA.getId(), 7);
		    	    			}
		    				}
		    		}else
		    		{

		    			if(ep.worldObj.isRemote)
		    			{
		    				/*
		    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.Bukiya.messages.6.txt" ,new Object[] {}));
		    				//ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		    				Minecraft.getMinecraft().thePlayer.closeScreen();
		    				Minecraft.getMinecraft().setIngameFocus();
		    				*/
		    				ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.BUKIYA.getId(), 6);
		    			}

		    			//this.inventory.closeInventory();
		    			//this.onContainerClosed(ep);
		    		}
	    		}else
	    		{
	    			this.inventory.setInventorySlotContents(par1, null);
    				Minecraft.getMinecraft().thePlayer.closeScreen();
    				Minecraft.getMinecraft().setIngameFocus();
	    		}

	    		//System.out.println("1" + epMedal + "/" + needMedal);
	   			//System.out.println("1:" + ep.worldObj.isRemote + ":" + slot.getStack().getDisplayName());
	    	}

	    	return null;
    	}

    	//System.out.println("TEST:" + par1);

    	return super.slotClick(par1, par2, par3, ep);
    }
}
