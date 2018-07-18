package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
public class DqmHakoBlock2 extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmHakoBlock2() //ブロックの基本設定
    {
        //super(i, Material.rock); //材質を土に
    	super(Material.wood); //材質を土に
    }

    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    /*
    public int idDropped(int i, int j,Random random)
    {
        int x = 0;
    	int x3 = x+getRandom(100, -100);

    	if(x3==0){j=DqmItemList.Littlemedal.itemID;}
    	if(x3>=1){j=DqmItemList.Yakusou.itemID;}
    	if(x3<=-1){j=DqmItemList.Dokukesisou.itemID;}
    	//if(x3==0){i=DqmItemList.Littlemedal.itemID;}
    	//if(x3==0){i=DqmItemList.Littlemedal.itemID;}
    	//if(x3==0){i=DqmItemList.Littlemedal.itemID;}

      return wood.blockID;
    }*/
/*
    public int idDropped(int i, Random random, int j)
    {
        int x = 0;
        int x3 = x + getRandom(250, -150);

        if (x3 >= 245 && x3 <= 250)
        {
            j = DqmItemList.Littlemedal5.itemID;
        }

        if (x3 >= 190 && x3 <= 230)
        {
            j = DqmItemList.Littlemedal.itemID;
        }

        if (x3 >= 175 && x3 <= 180)
        {
            j = DqmItemList.Haganenoturugi.itemID;
        }

        if (x3 >= 165 && x3 <= 170)
        {
            j = DqmItemList.Haganenoono.itemID;
        }

        if (x3 >= 157 && x3 <= 160)
        {
            j = DqmItemList.Majinnokanaduti.itemID;
        }

        if (x3 >= 149 && x3 <= 150)
        {
            j = DqmItemList.Sinkanohiseki.itemID;
        }

        if (x3 >= 138 && x3 <= 140)
        {
            j = DqmItemList.Rubinogenseki.itemID;
        }

        if (x3 >= 138 && x3 <= 130)
        {
            j = DqmItemList.Moon.itemID;
        }

        if (x3 >= 132 && x3 <= 137)
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

        if (x3 >= 66 && x3 <= 69)
        {
            j = DqmItemList.Haganenoyoroi.itemID;
        }

        if (x3 >= 63 && x3 <= 65)
        {
            j = DqmItemList.Haganenokabuto.itemID;
        }

        if (x3 >= 60 && x3 <= 62)
        {
            j = DqmItemList.Haganenokote.itemID;
        }

        if (x3 >= 57 && x3 <= 59)
        {
            j = DqmItemList.Haganenokutu.itemID;
        }

        //if(x3>=21 && x3<=50){j=DqmItemList.DqmBlockHako2.blockID;}
        if (x3 >= 1 && x3 <= 20)
        {
            j = DqmItemList.Konbou.itemID;
        }

        if (x3 >= -20 && x3 <= 0)
        {
            j = DqmItemList.Jouyakusou.itemID;
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
            j = DqmItemList.DqmBlockHako12.blockID;
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
