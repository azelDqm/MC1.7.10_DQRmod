package dqr.items.miscs;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.api.enums.EnumColor;
import dqr.items.base.DqmItemMiscBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemAccessoryStopper extends DqmItemMiscBase{

	public DqmItemAccessoryStopper()
	{
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{

		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
		int flg = ExtendedPlayerProperties.get(par3EntityPlayer).getAccBuffStop();

		if(flg == 1)
		{
			 ExtendedPlayerProperties.get(par3EntityPlayer).setAccBuffStop(0);
			 if(!par3EntityPlayer.worldObj.isRemote)par3EntityPlayer.addChatMessage(new ChatComponentTranslation("dqm.AccessoryStopper.0.txt",new Object[] {}));
		}else
		{
			ExtendedPlayerProperties.get(par3EntityPlayer).setAccBuffStop(1);
			if(!par3EntityPlayer.worldObj.isRemote)par3EntityPlayer.addChatMessage(new ChatComponentTranslation("dqm.AccessoryStopper.1.txt",new Object[] {}));
		}
    	return par1ItemStack;

    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	for(int cnt = 0; cnt < 2; cnt++)
    	{
    		p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.accessory.AccessoryStopper." + cnt + ".txt", new Object[]{}));
    	}

    	//String message = I18n.format("dqm.iteminfo.accessory.AccessoryCanceler.5.txt", new Object[]{});
    	//p_77624_3_.add(EnumColor.Aqua.getChatColor() + message);
    }
}
