package dqr.gui.medalKing;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties;

public class GuiMedalkingContainer extends Container
{
    private InventoryMedalking inventory;

    public GuiMedalkingContainer(InventoryPlayer inventoryPlayer, int guiId)
    {
        inventory = new InventoryMedalking(inventoryPlayer, inventoryPlayer.player, guiId);
        inventory.openInventory();

        int i = 2 * 18 + 1;

        for (int j = 0; j < 4; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new SlotMedalking(inventory, k + j * 9, 8 + k * 18, 15 + j * 18));
            }
        }

        for (int j = 0; j < 3; ++j)
        {
            for (int k = 0; k < 9; ++k)
            {
                this.addSlotToContainer(new Slot(inventoryPlayer, k + j * 9 + 9, 8 + k * 18, 54 + j * 18 + i));
            }
        }

        for (int j = 0; j < 9; ++j)
        {
            this.addSlotToContainer(new Slot(inventoryPlayer, j, 8 + j * 18, 112 + i));
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
        /*
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
            //シフトクリック時に、このアイテムだったら動かさない。
            //else if(slot.getStack() != null && slot.getStack().getItem() == InventoryItemCore.instance.inventoryItem)
            //{
            //    return null;
            //}
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
        */

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


        if(!p_75134_1_.worldObj.isRemote)
        {
        	//p_75134_1_.addChatMessage(new ChatComponentTranslation("msg.medalking.talk.5.txt" ,new Object[] {}));
        	//p_75134_1_.worldObj.playSoundAtEntity(p_75134_1_, "dqr:player.pi", 1.0F, 1.0F);
        }

    }

    @Override
    public ItemStack slotClick(int par1, int par2, int par3, EntityPlayer ep)
    {

    	//System.out.println(par1 + "/" + par2 + "/" + par3);
    	//System.out.println("0:" + ep.worldObj.isRemote + ":");
    	if(par1 >= 0 && par1 < 36)
    	{
	    	Slot slot = (Slot)this.inventorySlots.get(par1);
	    	if(slot != null && slot.getStack() != null)
	    	{
	    		int epMedal = ExtendedPlayerProperties.get(ep).getMedal();
	    		int needMedal = DQR.medalItem.getMedalValue(new ItemStack(slot.getStack().getItem() ,1));

	    		if(epMedal >= needMedal)
	    		{
	    				if(ep.inventory.addItemStackToInventory(new ItemStack(slot.getStack().getItem(), 1)))
	    				{
	    					ExtendedPlayerProperties.get(ep).setMedal(epMedal - needMedal);
	    					ep.worldObj.playSoundAtEntity(ep, "dqr:player.medal", 0.5F, 1.5F);
	    				}else
	    				{
	    					//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.medalking.talk.6.txt",new Object[] {}));
	    	    			if(ep.worldObj.isRemote)
	    	    			{
	    	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.medalking.talk.6.txt" ,new Object[] {}));
	    	    				Minecraft.getMinecraft().thePlayer.closeScreen();
	    	    				Minecraft.getMinecraft().setIngameFocus();
	    	    			}
	    				}
	    		}else
	    		{

	    			if(ep.worldObj.isRemote)
	    			{
	    				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.medalking.talk.4.txt" ,new Object[] {}));
	    				//ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	    				Minecraft.getMinecraft().thePlayer.closeScreen();
	    				Minecraft.getMinecraft().setIngameFocus();
	    			}

	    			//this.inventory.closeInventory();
	    			//this.onContainerClosed(ep);
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
