package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class DqmTabShield extends CreativeTabs
{
	public DqmTabShield(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return Items.emerald;
	}
}
