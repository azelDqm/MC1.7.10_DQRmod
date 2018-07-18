package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.api.enums.EnumDqmWorldType;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.mobEntity.monsterEnd.DqmEntityPandorabox;
import dqr.entity.mobEntity.monsterHell.DqmEntityMimikku;
public class DqmHakoBlock13 extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmHakoBlock13() //ブロックの基本設定
    {
        super(Material.wood); //材質を土に
    }

    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
    	int x = 0;
        int x3 = x + getRandom(100, 0);
        int x4 = x + getRandom(2, 0);
        int x5 = x + getRandom(4, 0);

        Random rand = new Random();
        DqmMobBase spawnMob = null;
        ItemStack doropiItems = null;
        int rateMob = 0;
        int rateItem = 0;
        int dim = par1World.provider.dimensionId;

        if(DQR.conf.cfg_gen_Hako_Map.get(dim) != null && DQR.conf.cfg_gen_Hako_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.OVERWORLD.getName()))
        {
        	//地上
        	if(rand.nextInt(10) != 0)
        	{
        		spawnMob = new DqmEntityMimikku(par1World);
        		rateItem = rand.nextInt(10);
        		if(rateItem == 0)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank1(1, 1);
        		}if(rateItem == 1)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank2(1, 1);
        		}else if(rateItem < 5)
        		{
        			doropiItems =DQR.randomItem.getFoodRank1(1, 1);
        		}else if(rateItem < 8)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank3(1, 1);
        		}else if(rateItem < 14)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank2(1, 1);
        		}else
        		{
        			doropiItems =DQR.randomItem.getMiscsRank1(1, 1);
        		}
        	}else
        	{
        		spawnMob = new DqmEntityPandorabox(par1World);
        		rateItem = rand.nextInt(10);
        		if(rateItem == 0)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank1(1, 1);
        		}if(rateItem == 1)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank2(1, 1);
        		}if(rateItem == 2)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank3(1, 1);
        		}else if(rateItem < 5)
        		{
        			doropiItems =DQR.randomItem.getFoodRank1(1, 1);
        		}else if(rateItem < 7)
        		{
        			doropiItems =DQR.randomItem.getFoodRank2(1, 1);
        		}else if(rateItem < 1)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank3(1, 1);
        		}else if(rateItem < 13)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank2(1, 1);
        		}else
        		{
        			doropiItems =DQR.randomItem.getMiscsRank1(1, 1);
        		}
        	}
        }else if(DQR.conf.cfg_gen_Hako_Map.get(dim) != null && DQR.conf.cfg_gen_Hako_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.NETHER.getName()))
        {
        	//ネザー
        	if(rand.nextInt(5) == 0)
        	{
        		spawnMob = new DqmEntityMimikku(par1World);
        		rateItem = rand.nextInt(10);
        		if(rateItem == 0)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank1(1, 1);
        		}if(rateItem == 1)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank2(1, 1);
        		}else if(rateItem < 5)
        		{
        			doropiItems =DQR.randomItem.getFoodRank1(1, 1);
        		}else if(rateItem < 8)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank3(1, 1);
        		}else if(rateItem < 14)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank2(1, 1);
        		}else
        		{
        			doropiItems =DQR.randomItem.getMiscsRank1(1, 1);
        		}
        	}else
        	{
        		spawnMob = new DqmEntityPandorabox(par1World);

        		rateItem = rand.nextInt(10);
        		if(rateItem == 0)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank1(1, 1);
        		}if(rateItem == 1)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank2(1, 1);
        		}if(rateItem == 2)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank3(1, 1);
        		}else if(rateItem < 5)
        		{
        			doropiItems =DQR.randomItem.getFoodRank1(1, 1);
        		}else if(rateItem < 7)
        		{
        			doropiItems =DQR.randomItem.getFoodRank2(1, 1);
        		}else if(rateItem < 9)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank4(1, 1);
        		}else if(rateItem < 1)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank3(1, 1);
        		}else if(rateItem < 13)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank2(1, 1);
        		}else
        		{
        			doropiItems =DQR.randomItem.getMiscsRank1(1, 1);
        		}
        	}
        }else if(DQR.conf.cfg_gen_Hako_Map.get(dim) != null && DQR.conf.cfg_gen_Hako_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.THEEND.getName()))
        {
    		spawnMob = new DqmEntityPandorabox(par1World);
    		rateItem = rand.nextInt(10);
    		if(rateItem == 0)
    		{
    			doropiItems =DQR.randomItem.getBuilderRank1(1, 1);
    		}if(rateItem == 1)
    		{
    			doropiItems =DQR.randomItem.getBuilderRank2(1, 1);
    		}if(rateItem == 2)
    		{
    			doropiItems =DQR.randomItem.getBuilderRank3(1, 1);
    		}else if(rateItem < 5)
    		{
    			doropiItems =DQR.randomItem.getFoodRank1(1, 1);
    		}else if(rateItem < 7)
    		{
    			doropiItems =DQR.randomItem.getFoodRank2(1, 1);
    		}else if(rateItem < 9)
    		{
    			doropiItems =DQR.randomItem.getMiscsRank4(1, 1);
    		}else if(rateItem < 1)
    		{
    			doropiItems =DQR.randomItem.getMiscsRank3(1, 1);
    		}else if(rateItem < 13)
    		{
    			doropiItems =DQR.randomItem.getMiscsRank2(1, 1);
    		}else
    		{
    			doropiItems =DQR.randomItem.getMiscsRank1(1, 1);
    		}
        }

        if(rand.nextInt(5) == 0)
        {
        	spawnMob = null;
        }

        if(spawnMob == null && rand.nextInt(4) == 0)
        {
        	doropiItems = new ItemStack(DQBlocks.DqmBlockHako3, 1);
        }

        if (!par1World.isRemote)
        {
        	if(spawnMob != null)
        	{
        		spawnMob.setLocationAndAngles((double)par2 + 0.5D + x4, (double)par3 + x5, (double)par4 + 0.5D + x4, 0.0F, 0.0F);
        		par1World.spawnEntityInWorld(spawnMob);
        		spawnMob.spawnExplosionParticle();
        	}

        	if(doropiItems != null)
        	{
        		this.dropBlockAsItem(par1World, par2, par3, par4, doropiItems);
        	}
        }

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
		return null;
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
