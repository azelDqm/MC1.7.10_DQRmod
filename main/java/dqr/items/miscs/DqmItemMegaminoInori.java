package dqr.items.miscs;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import dqr.items.base.DqmItemMiscBase;

public class DqmItemMegaminoInori extends DqmItemMiscBase{

	private int itemExp;
    public DqmItemMegaminoInori(int par1)
    {
        this.setMaxStackSize(64);
        this.itemExp = par1;
    }

    public int getItemExp()
    {
    	return this.itemExp;
    }

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("dqm.iteminfo.megaminoinori1", new Object[]{}));
    	p_77624_3_.add(I18n.format("dqm.iteminfo.megaminoinori2", new Object[]{this.itemExp}));
    }
}
