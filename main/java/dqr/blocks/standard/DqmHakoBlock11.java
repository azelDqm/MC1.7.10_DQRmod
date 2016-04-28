package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.mobEntity.monsterEnd.DqmEntityPandorabox;
import dqr.entity.mobEntity.monsterEtc.DqmEntityHitokuibako;
import dqr.entity.mobEntity.monsterHell.DqmEntityMimikku;

public class DqmHakoBlock11 extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmHakoBlock11() //ブロックの基本設定
    {
        super(Material.wood); //材質を土に
    }

    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }
    /*public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.125F;
        return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
    }
    private int HOIMI;
    private Class a;
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	DqmEntitySura sura = new DqmEntitySura(par1World);
    	if (par5Entity != sura && HOIMI <= 10)
        {
    		DqmPetDesufuratta entitysilverfish = new DqmPetDesufuratta(par1World);
            entitysilverfish.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(entitysilverfish);
            entitysilverfish.spawnExplosionParticle();
            HOIMI=HOIMI+1;
        }
    }*/

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

        if(dim == 0)
        {
        	if(rand.nextInt(15) == 0)
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
        		spawnMob = new DqmEntityHitokuibako(par1World);

        		rateItem = rand.nextInt(10);
        		if(rateItem == 0)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank1(1, 1);
        		}else if(rateItem < 5)
        		{
        			doropiItems =DQR.randomItem.getFoodRank1(1, 1);
        		}else if(rateItem < 10)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank2(1, 1);
        		}else
        		{
        			doropiItems =DQR.randomItem.getMiscsRank1(1, 1);
        		}
        	}
        }else if(dim == -1)
        {
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
        		spawnMob = new DqmEntityHitokuibako(par1World);

        		rateItem = rand.nextInt(10);
        		if(rateItem == 0)
        		{
        			doropiItems =DQR.randomItem.getBuilderRank1(1, 1);
        		}else if(rateItem < 5)
        		{
        			doropiItems =DQR.randomItem.getFoodRank1(1, 1);
        		}else if(rateItem < 10)
        		{
        			doropiItems =DQR.randomItem.getMiscsRank2(1, 1);
        		}else
        		{
        			doropiItems =DQR.randomItem.getMiscsRank1(1, 1);
        		}
        	}
        }else
        {
        	if(rand.nextInt(5) == 0)
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
        	}else
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
        	}
        }

        if(rand.nextInt(5) == 0)
        {
        	spawnMob = null;
        }

        if(spawnMob == null && rand.nextInt(4) == 0)
        {
        	doropiItems = new ItemStack(DQBlocks.DqmBlockHakoK, 1);
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
    @Override
    public int idDropped(int i, Random random, int j)
    {
        int x = 0;
        int x3 = x + getRandom(150, -150);

        if (x3 >= 149 && x3 <= 150)
        {
            j = DqmItemList.Littlemedal5.itemID;
        }

        if (x3 >= 97 && x3 <= 130)
        {
            j = DqmItemList.Littlemedal.itemID;
        }

        if (x3 >= 95 && x3 <= 96)
        {
            j = DqmItemList.Dokubari.itemID;
        }

        if (x3 >= 92 && x3 <= 94)
        {
            j = DqmItemList.Metaru.itemID;
        }

        if (x3 == 90)
        {
            j = DqmItemList.Majinnokanaduti.itemID;
        }

        if (x3 == 88)
        {
            j = DqmItemList.Sinkanohiseki.itemID;
        }

        if (x3 == 87)
        {
            j = DqmItemList.Rubinogenseki.itemID;
        }

        if (x3 == 86)
        {
            j = DqmItemList.Moon.itemID;
        }

        if (x3 >= 80 && x3 <= 82)
        {
            j = DqmItemList.Urokonoyoroi.itemID;
        }

        if(x3==79){j=DqmItemList.Sabitayoroi.itemID;}
        if(x3==78){j=DqmItemList.Sabitakote.itemID;}
        if(x3==77){j=DqmItemList.Sabitakabuto.itemID;}
        if(x3==76){j=DqmItemList.Sabitakutu.itemID;}
        if (x3 >= 70 && x3 <= 73)
        {
            j = DqmItemList.Seinarunaifu.itemID;
        }

        if (x3 >= 66 && x3 <= 69)
        {
            j = DqmItemList.Kawanoyoroi.itemID;
        }

        if (x3 >= 63 && x3 <= 65)
        {
            j = DqmItemList.Kawanobousi.itemID;
        }

        if (x3 >= 60 && x3 <= 62)
        {
            j = DqmItemList.Kawanokote.itemID;
        }

        if (x3 >= 57 && x3 <= 59)
        {
            j = DqmItemList.Kawanokutu.itemID;
        }

        //if(x3>=11 && x3<=30){j=DqmItemList.DqmBlockHako.blockID;}
        if (x3 >= 1 && x3 <= 10)
        {
            j = DqmItemList.Konbou.itemID;
        }

        if (x3 >= -20 && x3 <= 0)
        {
            j = DqmItemList.Yakusou.itemID;
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
        return 1;
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
