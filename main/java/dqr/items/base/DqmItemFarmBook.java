package dqr.items.base;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.playerData.MessagePlayerProperties2;

public class DqmItemFarmBook extends Item {
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

    	if(!player.worldObj.isRemote)
    	{
    		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties2(player), (EntityPlayerMP)player);
    	}

    	if(player.worldObj.isRemote)
    	{
    		player.openGui(DQR.instance, DQR.conf.GuiID_FarmBook, world, MathHelper.ceiling_double_int(player.posX), MathHelper.ceiling_double_int(player.posY), MathHelper.ceiling_double_int(player.posZ));
    	}
        return itemStack;
    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

    	String categ = "";

    	categ = I18n.format("msg.FarmBook.author", new Object[]{});
    	p_77624_3_.add(categ);
    }
}
