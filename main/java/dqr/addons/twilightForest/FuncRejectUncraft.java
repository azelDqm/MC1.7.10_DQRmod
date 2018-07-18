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
    				//if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST A1" + blc.getUnlocalizedName());
    				tableRejectUncraft.put(Item.getItemFromBlock(blc), true);
    			}
    		}catch (Exception e){if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST A1");}
    	}

    	for(int cnt = 0; cnt < DQR.addons.rejectUncraft.length; cnt++)
    	{
    		try
    		{
    			Item itm = (Item)rni.getObject(DQR.addons.rejectUncraft[cnt].trim().replace(" ", ""));

    			if(itm != null)
    			{
    				//if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST A2" + itm.getUnlocalizedName());
    				tableRejectUncraft.put(itm, true);
    			}
    		}catch (Exception e){if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST A2");}
    	}
    }

    public boolean isRejectUncraftItem(Item par1)
    {
    	return tableRejectUncraft.containsKey(par1);

    }

}
