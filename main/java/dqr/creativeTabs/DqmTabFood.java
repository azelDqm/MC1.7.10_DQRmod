package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class DqmTabFood extends CreativeTabs
{
	public DqmTabFood(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return Items.diamond;
	}
}
