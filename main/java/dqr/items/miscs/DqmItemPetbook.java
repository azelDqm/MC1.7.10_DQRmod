package dqr.items.miscs;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import dqr.items.base.DqmItemMiscBase;

public class DqmItemPetbook extends DqmItemMiscBase{


    public DqmItemPetbook()
    {
        this.setMaxStackSize(64);
    }

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("skill.petbook.info.0.txt",new Object[] {}));
    	p_77624_3_.add(I18n.format("skill.petbook.info.1.txt",new Object[] {}));
    	p_77624_3_.add("");
    	p_77624_3_.add(I18n.format("skill.petbook.info.2.txt",new Object[] {}));
    	p_77624_3_.add(I18n.format("skill.petbook.info.3.txt",new Object[] {}));
    }
}
