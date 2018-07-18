package dqr.entity.entityItem;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEntityUnbreak extends EntityItem{

	private boolean invulnerable = true;

	public ItemEntityUnbreak(World p_i1710_1_, double p_i1710_2_,
			double p_i1710_4_, double p_i1710_6_, ItemStack p_i1710_8_) {
		super(p_i1710_1_, p_i1710_2_, p_i1710_4_, p_i1710_6_, p_i1710_8_);
		// TODO 自動生成されたコンストラクター・スタブ
		this.isImmuneToFire = true;
	}

    public ItemEntityUnbreak(World p_i1711_1_)
    {
        super(p_i1711_1_);
        this.isImmuneToFire = true;
    }

    public ItemEntityUnbreak(World p_i1709_1_, double p_i1709_2_, double p_i1709_4_, double p_i1709_6_)
    {
        super(p_i1709_1_, p_i1709_2_, p_i1709_4_, p_i1709_6_);
        this.isImmuneToFire = true;
    }

    @Override
    public boolean isEntityInvulnerable()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean canRenderOnFire()
    {
        return false;
    }

    @Override
    public boolean isBurning()
    {
    	return false;
    }
    @Override
    public void setFire(int p_70015_1_)
    {

    }
}
