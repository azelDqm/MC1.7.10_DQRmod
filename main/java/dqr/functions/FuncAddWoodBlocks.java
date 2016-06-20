package dqr.functions;

import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.util.RegistryNamespaced;
import dqr.DQR;

public class FuncAddWoodBlocks {
    public Hashtable cuttingWoodBlockId;
    public Hashtable cuttingLeaveBlockId;

    public  FuncAddWoodBlocks()
    {
    	RegistryNamespaced rn = Block.blockRegistry;

    	cuttingWoodBlockId = new Hashtable();
    	cuttingLeaveBlockId = new Hashtable();

    	cuttingWoodBlockId.put(rn.getObject("minecraft:log"), true);
    	cuttingWoodBlockId.put(rn.getObject("minecraft:log2"), true);

    	for(int cnt = 0; cnt < DQR.conf.CuttingWood.length; cnt++)
    	{
    		try
    		{
    			cuttingWoodBlockId.put(rn.getObject(DQR.conf.CuttingWood[cnt].trim().replace(" ", "")), true);
    		}catch (Exception e){}
    	}

    	cuttingLeaveBlockId.put(rn.getObject("minecraft:leaves"), true);
    	cuttingLeaveBlockId.put(rn.getObject("minecraft:leaves2"), true);

    	for(int cnt = 0; cnt < DQR.conf.CuttingLeave.length; cnt++)
    	{
    		try
    		{
    			cuttingLeaveBlockId.put(rn.getObject(DQR.conf.CuttingLeave[cnt].trim().replace(" ", "")), true);
    		}catch (Exception e){}
    	}
    }

    public boolean isCuttingWood(Block par1)
    {

    	if(cuttingWoodBlockId.containsKey(par1))
    	{
    		return true;
    	}
    	return false;
    }

    public void addCuttingWoodBlock(Block par1)
    {
    	cuttingWoodBlockId.put(par1, true);
    }

    public boolean isCuttingLeave(Block par1)
    {

    	if(cuttingLeaveBlockId.get(par1) != null && (boolean)cuttingLeaveBlockId.get(par1))
    	{
    		//System.out.println("TEST" + ((Block)par1).getUnlocalizedName());
    		return true;
    	}
    	return false;
    }

    public void addCuttingLeaveBlock(Block par1)
    {
    	cuttingLeaveBlockId.put(par1, true);
    }
}
