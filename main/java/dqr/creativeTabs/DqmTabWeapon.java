package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import dqr.api.Items.DQWeapons;

public class DqmTabWeapon extends CreativeTabs
{
	public DqmTabWeapon(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return DQWeapons.itemRotonoturugi;
	}
}
