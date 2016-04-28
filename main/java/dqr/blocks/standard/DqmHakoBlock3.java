package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
public class DqmHakoBlock3 extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmHakoBlock3() //ブロックの基本設定
    {
        //super(i, Material.iron); //材質を土に
    	super(Material.iron); //材質を土に
    }

    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }
/*
    public int idDropped(int i, Random random, int j)
    {
        int x = 0;
        int x3 = x + getRandom(250, -150);

        if (x3 >= 243 && x3 <= 250)
        {
            j = DqmItemList.Littlemedal5.itemID;
        }

        if (x3 >= 190 && x3 <= 240)
        {
            j = DqmItemList.Littlemedal.itemID;
        }

        if (x3 >= 175 && x3 <= 180)
        {
            j = DqmItemList.Doragonkira.itemID;
        }

        if (x3 >= 165 && x3 <= 170)
        {
            j = DqmItemList.Gureitoakusu.itemID;
        }

        if (x3 >= 157 && x3 <= 162)
        {
            j = DqmItemList.Majinnokanaduti.itemID;
        }

        if (x3 >= 155 && x3 <= 156)
        {
            j = DqmItemList.Sinpinoyoroi.itemID;
        }

        if (x3 >= 147 && x3 <= 150)
        {
            j = DqmItemList.Sinkanohiseki.itemID;
        }

        if (x3 >= 136 && x3 <= 140)
        {
            j = DqmItemList.Rubinogenseki.itemID;
        }

        if (x3 >= 136 && x3 <= 130)
        {
            j = DqmItemList.Moon.itemID;
        }

        if (x3 >= 130 && x3 <= 137)
        {
            j = DqmItemList.Urokonoyoroi.itemID;
        }

        if(x3==79){j=DqmItemList.Sabitayoroi.itemID;}
        if(x3==78){j=DqmItemList.Sabitakote.itemID;}
        if(x3==77){j=DqmItemList.Sabitakabuto.itemID;}
        if(x3==76){j=DqmItemList.Sabitakutu.itemID;}
        if (x3 >= 70 && x3 <= 75)
        {
            j = DqmItemList.Seinarunaifu.itemID;
        }

        if (x3 >= 63 && x3 <= 69)
        {
            j = DqmItemList.Haganenoyoroi.itemID;
        }

        if (x3 >= 60 && x3 <= 62)
        {
            j = DqmItemList.Haganenokabuto.itemID;
        }

        if (x3 >= 55 && x3 <= 59)
        {
            j = DqmItemList.Haganenokote.itemID;
        }

        if (x3 >= 50 && x3 <= 54)
        {
            j = DqmItemList.Haganenokutu.itemID;
        }

        //if(x3>=31 && x3<=49){j=DqmItemList.DqmBlockHako3.blockID;}
        if (x3 >= 1 && x3 <= 30)
        {
            j = DqmItemList.Konbou.itemID;
        }

        if (x3 >= -20 && x3 <= 0)
        {
            j = DqmItemList.Tokuyakusou.itemID;
        }

        if (x3 >= -40 && x3 <= -21)
        {
            j = DqmItemList.Dokukesisou.itemID;
        }

        if (x3 >= -60 && x3 <= -41)
        {
            j = DqmItemList.Tikaranotane.itemID;
        }

        if (x3 >= -80 && x3 <= -61)
        {
            j = DqmItemList.Subayasanotane.itemID;
        }

        if (x3 >= -100 && x3 <= -81)
        {
            j = DqmItemList.Mamorinotane.itemID;
        }

        if (x3 >= -120 && x3 <= -101)
        {
            j = DqmItemList.Kinkai.itemID;
        }

        if (x3 >= -150 && x3 <= -121)
        {
            j = DqmItemList.DqmBlockHako13.blockID;
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
        return 1; //idDropedでドロップする数を設定
    }
    public String getTextureFile()
    {
        return "/DQMII/Textures/DqmOre.png";
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return false;
    }
}
