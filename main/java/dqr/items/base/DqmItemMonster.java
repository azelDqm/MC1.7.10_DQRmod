package dqr.items.base;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DqmItemMonster extends Item {

	public DqmItemMonster()
	{
		super();
	}

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
	 {
		NBTTagCompound nbt = p_77624_1_.getTagCompound();
		if(nbt != null)
		{
			p_77624_3_.add("");
    		String message = I18n.format("dqm.iteminfo.petLocation1", new Object[]{});
			p_77624_3_.add(message);

			int locX = nbt.getInteger("posX");
			int locY = nbt.getInteger("posY");
			int locZ = nbt.getInteger("posZ");
			int locDim = nbt.getInteger("dimension");
			//System.out.println("TEST:" + medalVal);
			if(locX == 0 && locY == 0 && locZ == 0 && locDim == 0)
			{
				message = I18n.format("dqm.iteminfo.petLocation0", new Object[]{});
				p_77624_3_.add(message);
			}else
			{
				message = I18n.format("dqm.iteminfo.petLocation2", new Object[]{locDim});
				p_77624_3_.add(message);
				message = I18n.format("dqm.iteminfo.petLocation3", new Object[]{locX, locY, locZ});
				p_77624_3_.add(message);
			}
		}
	 }
}
