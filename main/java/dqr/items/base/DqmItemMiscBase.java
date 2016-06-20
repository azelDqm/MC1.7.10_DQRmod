package dqr.items.base;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMagic;

public class DqmItemMiscBase extends Item{
    private EnumDqmMagic enumMagic;

	public DqmItemMiscBase()
	{
		super();
	}

    public DqmItemMiscBase(EnumDqmMagic par4)
    {
    	super();
        this.enumMagic = par4;
    }

    public EnumDqmMagic getEnumMagic()
    {
    	return this.enumMagic;
    }

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

		if(this == DQMiscs.ItemMahounoTutu01B)
		{
			p_77624_3_.add("");
			p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.mahounoTutu.1.txt", new Object[]{}));
			p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.mahounoTutu.2.txt", new Object[]{}));
		}

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