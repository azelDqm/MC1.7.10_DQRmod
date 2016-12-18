package dqr.blocks.standard;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DQmBlockWaterBlock extends Block
{

	public DQmBlockWaterBlock(Material par2Material)
	{
		super(par2Material);
	}



    @SideOnly(Side.CLIENT)
    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    public boolean isOpaqueCube()
    {
        //return !this.graphicsLevel;
    	return false;
    }
}
