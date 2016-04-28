package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DqmWakanai extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmWakanai(int j) //ブロックの基本設定
    {
        super( Material.wood); //材質を土に
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F);
    }

    public int quantityDropped(Random random)
    {
        return 1; //idDropedでドロップする数を設定
    }
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
