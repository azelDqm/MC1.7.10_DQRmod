package dqr.items.miscs;

import net.minecraft.item.ItemEditableBook;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DqmItemFarmerDiary extends ItemEditableBook{

    public DqmItemFarmerDiary()
    {
        this.setMaxStackSize(1);
    }

    /*
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        p_77659_3_.displayGUIBook(p_77659_1_);
    	return p_77659_1_;
    }
    */

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack p_77636_1_)
    {
        return false;
    }

}
