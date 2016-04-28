package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DqmHakoBlock extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmHakoBlock() //ブロックの基本設定
    {
        super(Material.wood); //材質を土に
    	//super(par2); //材質を土に
    }

    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    /*
    @Override
    public int idDropped(int i, Random random, int j)
    {
        int x = 0;
        int x3 = x + getRandom(150, -150);

        if (x3 >= 149 && x3 <= 150)
        {
            j = DqmItemList.Littlemedal5;
        }

        if (x3 >= 97 && x3 <= 130)
        {
            j = DqmItemList.Littlemedal;
        }

        if (x3 >= 95 && x3 <= 96)
        {
            j = DqmItemList.Dokubari;
        }

        if (x3 >= 92 && x3 <= 94)
        {
            j = DqmItemList.Metaru;
        }

        if (x3 == 90)
        {
            j = DqmItemList.Majinnokanaduti;
        }

        if (x3 == 88)
        {
            j = DqmItemList.Sinkanohiseki;
        }

        if (x3 == 87)
        {
            j = DqmItemList.Rubinogenseki;
        }

        if (x3 == 86)
        {
            j = DqmItemList.Moon;
        }

        if (x3 >= 80 && x3 <= 82)
        {
            j = DqmItemList.Urokonoyoroi;
        }

        if(x3==79){j=DqmItemList.Sabitayoroi;}
        if(x3==78){j=DqmItemList.Sabitakote;}
        if(x3==77){j=DqmItemList.Sabitakabuto;}
        if(x3==76){j=DqmItemList.Sabitakutu;}
        if (x3 >= 70 && x3 <= 73)
        {
            j = DqmItemList.Seinarunaifu;
        }

        if (x3 >= 66 && x3 <= 69)
        {
            j = DqmItemList.Kawanoyoroi;
        }

        if (x3 >= 63 && x3 <= 65)
        {
            j = DqmItemList.Kawanobousi;
        }

        if (x3 >= 60 && x3 <= 62)
        {
            j = DqmItemList.Kawanokote;
        }

        if (x3 >= 57 && x3 <= 59)
        {
            j = DqmItemList.Kawanokutu;
        }

        //if(x3>=11 && x3<=30){j=DqmItemList.DqmBlockHako.blockID;}
        if (x3 >= 1 && x3 <= 10)
        {
            j = DqmItemList.Konbou;
        }

        if (x3 >= -20 && x3 <= 0)
        {
            j = DqmItemList.Yakusou;
        }

        if (x3 >= -40 && x3 <= -21)
        {
            j = DqmItemList.Dokukesisou;
        }

        if (x3 >= -60 && x3 <= -41)
        {
            j = DqmItemList.Tikaranotane;
        }

        if (x3 >= -80 && x3 <= -61)
        {
            j = DqmItemList.Subayasanotane;
        }

        if (x3 >= -100 && x3 <= -81)
        {
            j = DqmItemList.Mamorinotane;
        }

        if (x3 >= -120 && x3 <= -101)
        {
            j = DqmItemList.Kinkai;
        }

        if (x3 >= -150 && x3 <= -121)
        {
            j = DqmItemList.DqmBlockHako11.blockID;
        }
        else
        {
            j = 0;
        }

        return j;
    }
*/
    public int quantityDropped(Random random)
    {
        return 1;
    }


    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return false;
    }
}
