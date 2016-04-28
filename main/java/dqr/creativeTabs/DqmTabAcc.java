package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import dqr.api.Items.DQAccessories;

public class DqmTabAcc extends CreativeTabs
{
	public DqmTabAcc(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return DQAccessories.itemGoldring;
	}
}
