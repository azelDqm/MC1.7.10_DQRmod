package dqr.dataTable;

import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.util.RegistryNamespaced;
import dqr.DQR;

public class FuncBiomeBlockTable {

	Hashtable biomeBlock = new Hashtable();
	public FuncBiomeBlockTable()
	{
		RegistryNamespaced rn = Block.blockRegistry;

		String[] blocknames = DQR.conf.cfg_biomeBlock_blockName;
		int[] biomeIds = DQR.conf.cfg_biomeBlock_biomeId;

		for(int cnt = 0; cnt < biomeIds.length; cnt++)
		{
			if(blocknames.length > cnt && rn.getObject(blocknames[cnt]) != null)
			{
				Block block = (Block)rn.getObject(blocknames[cnt]);

				biomeBlock.put(biomeIds[cnt], block);
			}

		}

		/*
		biomeBlock.put(9, Blocks.end_stone);
		biomeBlock.put(113, Blocks.netherrack);
		biomeBlock.put(114, Blocks.netherrack);
		biomeBlock.put(115, Blocks.netherrack);
		biomeBlock.put(116, Blocks.netherrack);
		biomeBlock.put(117, Blocks.netherrack);
		*/
	}

	public IIcon getBiomeBaseIIcon(int biomeId, int side)
	{
		if(biomeBlock.containsKey(biomeId))
		{
			return ((Block)biomeBlock.get(biomeId)).getBlockTextureFromSide(side);
		}


		return Blocks.stone.getBlockTextureFromSide(side);
	}

	public Block getBiomeBlock(int biomeId)
	{
		if(biomeBlock.containsKey(biomeId))
		{
			return (Block)biomeBlock.get(biomeId);
		}

		return Blocks.stone;
	}
}
