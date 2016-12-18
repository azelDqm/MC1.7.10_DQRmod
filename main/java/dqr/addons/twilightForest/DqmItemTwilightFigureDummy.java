package dqr.addons.twilightForest;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DqmItemTwilightFigureDummy extends Item{
	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
		NBTTagCompound nbt = p_77624_1_.getTagCompound();
		if(nbt != null)
		{

			if(nbt.hasKey("dummy_name"))
			{
				String name = I18n.format("dqm.iteminfo.twilightForestDummy1", new Object[]{nbt.getString("dummy_name")});
				p_77624_3_.add(name);
			}

			if(nbt.hasKey("dummy_edition"))
			{
				String edition = I18n.format("dqm.iteminfo.twilightForestDummy2", new Object[]{nbt.getString("dummy_edition")});
				p_77624_3_.add(edition);
			}

		}
	}
}
