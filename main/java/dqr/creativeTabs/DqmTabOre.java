package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.Blocks.DQOres;

public class DqmTabOre extends CreativeTabs
{
	public DqmTabOre(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return new ItemStack(DQOres.BlockOreTekkouseki, 1, 0).getItem();
		//return Items.arrow;
	}
}
