package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.Blocks.DQBlocks;

public class DqmTabBlock extends CreativeTabs
{
	public DqmTabBlock(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return new ItemStack(DQBlocks.DqmBlockHako, 1, 0).getItem();
	}
}
