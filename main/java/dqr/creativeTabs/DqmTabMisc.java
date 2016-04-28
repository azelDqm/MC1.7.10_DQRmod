package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import dqr.api.Items.DQMiscs;

public class DqmTabMisc extends CreativeTabs
{
	public DqmTabMisc(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return DQMiscs.itemSuraimuzeri;
	}
}
