package dqr.creativeTabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.Blocks.DQMobObjects;

public class DqmTabMobObj extends CreativeTabs
{
	public DqmTabMobObj(String var1)
	{
		super(var1);
	}

	@Override
	public Item getTabIconItem()
	{
		return new ItemStack(DQMobObjects.BlockObjKingsura, 1, 0).getItem();
		//return Items.arrow;
	}
}
