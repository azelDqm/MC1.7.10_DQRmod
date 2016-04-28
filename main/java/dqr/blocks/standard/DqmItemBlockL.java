package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class DqmItemBlockL extends Block
{
    public DqmItemBlockL() //ブロックの基本設定
    {
        super(Material.circuits); //材質を土に
    	//super(par2); //材質を土に
        // this.setLightValue(1.9375F);
        this.setBlockBounds(0.0F, 0.1F, 0.0F, 1.0F, 0.0F, 1.0F);
        //float f = 0.1F;
    }
    /*
    public int idDropped(int i, int j, Random random)
    {
        return this.blockID; //壊したときにこのブロックをドロップする
    }
    */
    public int quantityDropped(Random random)
    {
        return 0; //idDropedでドロップする数を設定
    }
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    public int getRenderType()
    {
        return 2;
    }
}
