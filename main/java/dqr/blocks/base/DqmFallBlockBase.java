package dqr.blocks.base;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;

public class DqmFallBlockBase extends BlockFalling{

    public DqmFallBlockBase()
    {
        super(Material.rock);
        //this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public DqmFallBlockBase(Material p_i45405_1_)
    {
        super(p_i45405_1_);
    }

}
