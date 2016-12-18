package dqr.addons.twilightForest;

import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.RegistryNamespaced;
import dqr.DQR;

public class FuncRejectUncraft {
    public Hashtable tableRejectUncraft;

    public  FuncRejectUncraft()
    {
    	RegistryNamespaced rnb = Block.blockRegistry;
    	RegistryNamespaced rni = Item.itemRegistry;

    	tableRejectUncraft = new Hashtable();

    	for(int cnt = 0; cnt < DQR.addons.rejectUncraft.length; cnt++)
    	{
    		try
    		{
    			Block blc = (Block)rnb.getObject(DQR.addons.rejectUncraft[cnt].trim().replace(" ", ""));

    			if(blc != null)
    			{
    				tableRejectUncraft.put(Item.getItemFromBlock(blc), true);
    			}
    		}catch (Exception e){}
    	}

    	for(int cnt = 0; cnt < DQR.addons.rejectUncraft.length; cnt++)
    	{
    		try
    		{
    			Item itm = (Item)rni.getObject(DQR.addons.rejectUncraft[cnt].trim().replace(" ", ""));

    			if(itm != null)
    			{
    				tableRejectUncraft.put(itm, true);
    			}
    		}catch (Exception e){}
    	}
    }

    public boolean isRejectUncraftItem(Item par1)
    {
    	return tableRejectUncraft.containsKey(par1);

    }

}
