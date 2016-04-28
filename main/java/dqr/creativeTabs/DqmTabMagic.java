package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import dqr.api.Items.DQMagics;

public class DqmTabMagic extends CreativeTabs
{
	public DqmTabMagic(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return DQMagics.itemMerami;
	}
}
