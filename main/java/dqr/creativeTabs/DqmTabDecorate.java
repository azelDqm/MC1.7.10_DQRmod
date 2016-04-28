package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.Blocks.DQDecorates;

public class DqmTabDecorate extends CreativeTabs
{
	public DqmTabDecorate(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return new ItemStack(DQDecorates.DqmBlockHondana, 1, 0).getItem();
	}
}
