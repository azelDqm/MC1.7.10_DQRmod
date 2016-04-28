package dqr.items.magicTool;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmMagic;
import dqr.items.base.DqmItemMagicToolBase;

public class DqmItemPetSuisyou extends DqmItemMagicToolBase{
    private EnumDqmMagic enumMagic;

	public DqmItemPetSuisyou()
	{
		super();
	}

    public DqmItemPetSuisyou(EnumDqmMagic par4)
    {
    	super();
        this.enumMagic = par4;
    }

    public EnumDqmMagic getEnumMagic()
    {
    	return this.enumMagic;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {

        player.openGui(DQR.instance, DQR.conf.GuiID_PetBook, world, (int)player.posX, (int)player.posY, (int)player.posZ);

        return itemStack;


    }

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("dqm.iteminfo.PetSuisyou.1.txt", new Object[]{}));
    	p_77624_3_.add(I18n.format("dqm.iteminfo.PetSuisyou.2.txt", new Object[]{}));

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
