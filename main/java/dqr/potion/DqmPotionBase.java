package dqr.potion;

import net.minecraft.potion.Potion;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DqmPotionBase extends Potion {

	public int icon_x;
	public int icon_y;
	public int statusIconIndex = -1;

	public DqmPotionBase(int p_i1573_1_, boolean p_i1573_2_, int p_i1573_3_) {
		super(p_i1573_1_, p_i1573_2_, p_i1573_3_);
	}

	@Override
    @SideOnly(Side.CLIENT)
    public boolean hasStatusIcon()
    {
        return this.statusIconIndex >= 0;
    }

	@Override
    @SideOnly(Side.CLIENT)
    public int getStatusIconIndex()
    {
        return this.statusIconIndex;
    }


	@Override
    protected DqmPotionBase setIconIndex(int p_76399_1_, int p_76399_2_)
    {
        this.statusIconIndex = p_76399_1_ + p_76399_2_ * 8;
        return this;
    }


	public DqmPotionBase setIconIndex2(int par1, int par2)
	{
		icon_x = par1 * 18;
		icon_y = par2 * 18;

		return this;
	}

}
