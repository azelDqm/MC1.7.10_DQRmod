package dqr.items.base;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DqmItemIngotBase extends Item {
	/*
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
	EntityEnderCrystal eec = new EntityEnderCrystal(p_77648_3_);

	eec.posX = p_77648_2_.posX;
	eec.posY = p_77648_2_.posY;
	eec.posZ = p_77648_2_.posZ;

	if(!p_77648_3_.isRemote)
	{
		p_77648_3_.spawnEntityInWorld(eec);
		p_77648_2_.worldObj.setBlock((int)eec.posX, (int)eec.posY, (int)eec.posZ, Blocks.fire);
	}

	return true;
	}
	*/

	/*
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if (!p_77648_3_.isRemote)
		{
			EntityEnderCrystal crystal = new EntityEnderCrystal(p_77648_3_);
			crystal.setPosition(p_77648_4_ + 0.5D, p_77648_5_ + 2.0D, p_77648_6_ + 0.5D);

			p_77648_3_.spawnEntityInWorld(crystal);
		}

		return true;
	}
	*/

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
		NBTTagCompound nbt = p_77624_1_.getTagCompound();
		if(nbt != null)
		{
			int medalVal = nbt.getInteger("medalking");
			//System.out.println("TEST:" + medalVal);
			if(medalVal > 0)
			{

	    		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

				p_77624_3_.add(medalValue);
			}
		}
	 }
}
