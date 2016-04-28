package dqr.items.fukuro;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.items.base.DqmItemFukuroBase;

public class DqmItemFukuro extends DqmItemFukuroBase{

    public DqmItemFukuro()
    {
        super();
        //スタックサイズは1コ
        this.setMaxStackSize(1);
    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	//p_77624_3_.add(I18n.format("dqm.magicinfo.noimplemented"));
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        /*
            GUIを開く。インスタンス, GUIのID, World, X, Y, Z
         */
        player.openGui(DQR.instance, DQR.conf.GuiID_ItemBag, world, (int)player.posX, (int)player.posY, (int)player.posZ);
        return itemStack;
    }
}
