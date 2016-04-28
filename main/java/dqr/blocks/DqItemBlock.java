package dqr.blocks;

import dqr.api.Blocks.DQDecorates;
import dqr.api.Items.DQItemBlocks;
import dqr.blocks.itemBlock.ItemBlockDqmBed;

public class DqItemBlock {

	public DqItemBlock()
	{
		DQItemBlocks.itemBlockDqmBed = new ItemBlockDqmBed(DQDecorates.DqmBlockDqmbed);
	}

}
