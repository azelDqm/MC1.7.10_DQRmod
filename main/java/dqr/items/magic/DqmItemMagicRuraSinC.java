package dqr.items.magic;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.enums.EnumDqmMagic;
import dqr.items.base.DqmItemMagicBase;

public class DqmItemMagicRuraSinC extends DqmItemMagicBase {

    public DqmItemMagicRuraSinC(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);

    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	p_77624_3_.add(I18n.format("dqm.magicinfo.noimplemented"));
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    }
}
