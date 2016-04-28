package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.Items.DQMiscs;

public class DqmTabBackPack extends CreativeTabs
{
	public DqmTabBackPack(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return new ItemStack(DQMiscs.itemOokinaFukuro, 1, 0).getItem();
		//return Items.arrow;
	}
}
