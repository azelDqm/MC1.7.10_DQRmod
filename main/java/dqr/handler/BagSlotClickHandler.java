package dqr.handler;

import java.util.Iterator;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.RegistryNamespaced;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.event.DqmBagSlotClickEvent;

public class BagSlotClickHandler {

	@SubscribeEvent
	public void onEBagSlotClickEvent(DqmBagSlotClickEvent event)
	{
		//System.out.println("TEST????? : ");
    	if(event.slotNo >= 0)
    	{

    		ItemStack sl2 = null;
    		if(event.action == 2  && event.bag.epInventory.getStackInSlot(event.actionSubNo) != null
    				&& event.slotNo <= 153 && event.slotNo >= 0)
    		{
    			sl2 = event.bag.epInventory.getStackInSlot(event.actionSubNo);


    		}else if(153 < event.slotNo && event.slotNo >= 0)
    		{
    			sl2 = (ItemStack)(event.bag.getInventory().get(event.slotNo));
    		}

    		//if(sl != null && sl.getStack() != null && sl.getStack().getItem() instanceof DqmItemFukuroBase)
    		//System.out.println("LINT1");
    		//System.out.println("TEST?????1 : ");
    		if(sl2 != null)
    		{
    			//System.out.println("TEST?????3 : ");

    			if(sl2.getTagCompound() != null)
    			{
    				//System.out.println("TEST?????2 : ");
	    			NBTTagCompound nbt = sl2.getTagCompound();

        			Set set = nbt.func_150296_c();
        			for (Iterator itr = set.iterator(); itr.hasNext();)
        			{
        				Object obj = itr.next();
        				//System.out.println("TEST????? : " + (obj instanceof String));
        				if(obj instanceof String && ((String)obj).equalsIgnoreCase("Items"))
        				{
        					//System.out.println("TEST?????5 : ");
        					event.setCanceled(true);
        					return;
        				}
        			}
        			//System.out.println("TEST?????4 : ");
	    			if(nbt != null && nbt.func_150296_c().size() > DQR.conf.fukuroLimitTagCount && DQR.conf.fukuroLimitTagCount > 0)
	    			{
	    				//System.out.println("LINT1");
	    				event.setCanceled(true);
	    				return;
	    			}


    			}



    	    	RegistryNamespaced rnb = Block.blockRegistry;
    	    	RegistryNamespaced rni = Item.itemRegistry;

    	    	//System.out.println("LINT1" + rni.getNameForObject(sl2.getItem()));
    	    	for(int cnt = 0; cnt < DQR.conf.fukuroRejectItems.length; cnt++)
    	    	{
    	    		try
    	    		{
    	    			Block blc = (Block)rnb.getObject(DQR.conf.fukuroRejectItems[cnt].trim().replace(" ", ""));

    	    			if(blc != null)
    	    			{
    	    				if(sl2.getItem() == Item.getItemFromBlock(blc))
    	    				{
    	    					event.setCanceled(true);
    	    					return;
    	    				}
    	    			}
    	    		}catch (Exception e){}
    	    	}

    	    	for(int cnt = 0; cnt < DQR.conf.fukuroRejectItems.length; cnt++)
    	    	{
    	    		try
    	    		{
    	    			Item itm = (Item)rni.getObject(DQR.conf.fukuroRejectItems[cnt].trim().replace(" ", ""));
    	    			//System.out.println("LINT2");
    	    			if(itm != null)
    	    			{
    	    				if(sl2.getItem() == itm)
    	    				{
    	    					//System.out.println("LINT3");
    	    					event.setCanceled(true);
    	    					return;
    	    				}
    	    			}
    	    		}catch (Exception e){}
    	    	}
    			//System.out.println("TESTLINE = " + nbt.func_150296_c().size());
    		}
    	}

	}
}
