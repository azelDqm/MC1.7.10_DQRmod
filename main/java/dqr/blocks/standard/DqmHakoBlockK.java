package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
public class DqmHakoBlockK extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmHakoBlockK() //ブロックの基本設定
    {
        super(Material.wood); //材質を土に
    	//super(par2); //材質を土に
    }

    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    public int quantityDropped(Random random)
    {
        return 1; //idDropedでドロップする数を設定
    }
    public String getTextureFile()
    {
        return "/DQMII/Textures/DqmOre.png";
    }
}
