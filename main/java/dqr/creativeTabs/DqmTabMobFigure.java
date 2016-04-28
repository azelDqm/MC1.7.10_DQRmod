package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.Blocks.DQMobFigures;

public class DqmTabMobFigure extends CreativeTabs
{
	public DqmTabMobFigure(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return new ItemStack(DQMobFigures.BlockFigureKingsura, 1, 0).getItem();
		//return Items.arrow;
	}
}
