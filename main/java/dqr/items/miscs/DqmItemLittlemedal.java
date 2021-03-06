package dqr.items.miscs;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumColor;
import dqr.items.base.DqmItemMiscBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemLittlemedal extends DqmItemMiscBase{


	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(!par3EntityPlayer.isSneaking())
		{
			int plusMedal = 0;

			if(this == DQMiscs.itemLittlemedal)
			{
				plusMedal = 1;
			}else if(this == DQMiscs.itemLittlemedal5)
			{
				plusMedal = 5;
			}else if(this == DQMiscs.itemLittlemedal10)
			{
				plusMedal = 10;
			}else if(this == DQMiscs.itemLittlemedal50)
			{
				plusMedal = 50;
			}else if(this == DQMiscs.itemLittlemedal100)
			{
				plusMedal = 100;
			}else if(this == DQMiscs.itemLittlemedal500)
			{
				plusMedal = 500;
			}else if(this == DQMiscs.itemLittlemedal1000)
			{
				plusMedal = 1000;
			}

			if(!par3EntityPlayer.worldObj.isRemote) par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.medal", 0.5F, 1.0F);

			ExtendedPlayerProperties.get(par3EntityPlayer).setMedal(ExtendedPlayerProperties.get(par3EntityPlayer).getMedal() + plusMedal);

			par1ItemStack.stackSize--;
		}

		return  par1ItemStack;
	}

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	p_77624_3_.add("");

    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.littleMedal.0.txt", new Object[]{}));
    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.littleMedal.1.txt", new Object[]{}));
    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.littleMedal.2.txt", new Object[]{}));
    }
}
