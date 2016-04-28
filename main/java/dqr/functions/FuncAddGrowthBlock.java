package dqr.functions;

import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import dqr.api.Blocks.DQPlants;

public class FuncAddGrowthBlock {
    public Hashtable plantGrowthBlockIDTb;
    public Hashtable plantPlantingBlock;

    public  FuncAddGrowthBlock()
    {
    	plantGrowthBlockIDTb = new Hashtable();
    	plantPlantingBlock = new Hashtable();

    	plantGrowthBlockIDTb.put(Blocks.farmland, true);
    	plantGrowthBlockIDTb.put(Blocks.grass, true);
    	plantGrowthBlockIDTb.put(Blocks.dirt, true);
    	plantGrowthBlockIDTb.put(DQPlants.BlockHoujyouDirt, true);
    	//plantGrowthBlockIDTb.put(DqmItemList2.DqmHoujyouDirt.blockID, true);

    	plantPlantingBlock.put(DQPlants.BlockHoujyouDirt, true);
    }

    public boolean canGrowthBlock(Block par1)
    {
    	if(plantGrowthBlockIDTb.containsKey(par1))
    	{
    		return true;
    	}
    	return false;
    }

    public void addGrowthBlock(int par1)
    {
    	plantGrowthBlockIDTb.put(par1, true);
    }




    public boolean canPlantingBlock(Block par1)
    {
    	if(plantPlantingBlock.containsKey(par1))
    	{
    		return true;
    	}
    	return false;
    }

    public void addPlantingBlock(int par1)
    {
    	plantPlantingBlock.put(par1, true);
    }


}
