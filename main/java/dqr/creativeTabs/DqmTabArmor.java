package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import dqr.api.Items.DQArmors;

public class DqmTabArmor extends CreativeTabs
{
	public DqmTabArmor(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return DQArmors.itemRotonoyoroi;
	}
}
