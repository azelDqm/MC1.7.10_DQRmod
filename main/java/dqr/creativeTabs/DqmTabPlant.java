package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import dqr.api.Items.DQSeeds;

public class DqmTabPlant extends CreativeTabs
{
	public DqmTabPlant(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return DQSeeds.itemYakusou;
	}
}
