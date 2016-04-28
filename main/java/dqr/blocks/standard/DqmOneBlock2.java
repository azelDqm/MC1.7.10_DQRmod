package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DqmOneBlock2 extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmOneBlock2() //ブロックの基本設定
    {
        super(Material.grass); //材質を土に
    }

    public int quantityDropped(Random random)
    {
        return 1; //idDropedでドロップする数を設定
    }
    //光を通す
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    //透けない
    public boolean isOpaqueCube()
    {
        return false;
    }
}
