package dqr.blocks.decorate;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Blocks.DQDecorates;
import dqr.api.enums.EnumDqmWorldType;
import dqr.blocks.decorate.tileEntity.DqmTileEntityTaruMob;
import dqr.entity.mobEntity.DqmMobBase;

public class DqmBlockTaruMob extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockTaruMob(Material var2)
    {
        super( var2);
        // this.setLightValue(0.9375F);
        //this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
    }
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    public void breakBlock(World par1World, int par2, int par3, int par4, Block p_149749_5_, int par5)
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

        rateItem = rand.nextInt(10);


        if(DQR.conf.cfg_gen_Taru_Map.get(dim) != null && DQR.conf.cfg_gen_Taru_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.OVERWORLD.getName()))
        {
    		if(rand.nextInt(5) != 0)
    		{
    			spawnMob = DQR.randomMob.getRandomNight(par1World);

    			rateItem = rand.nextInt(20);
    			if(rateItem < 10)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
    			}else if(rateItem < 16)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
    			}else if(rateItem < 19)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
    			}else
    			{
    				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
    			}
    		}else
    		{
    			spawnMob = DQR.randomMob.getRandomNether(par1World);

    			rateItem = rand.nextInt(25);
    			if(rateItem < 10)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
    			}else if(rateItem < 20)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
    			}else if(rateItem < 24)
    			{
    				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
    			}else
    			{
    				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
    			}
    		}
        }else if(DQR.conf.cfg_gen_Taru_Map.get(dim) != null && DQR.conf.cfg_gen_Taru_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.NETHER.getName()))
        {
        	if(rand.nextInt(4) == 0)
        	{
        		if(!par1World.isRemote)
        		{
        			par1World.createExplosion(null, par2, par3, par4, 5.0F, true);
        		}
        	}else
        	{
        		if(rand.nextInt(5) == 0)
        		{
        			spawnMob = DQR.randomMob.getRandomEnd(par1World);

        			rateItem = rand.nextInt(20);
        			if(rateItem < 10)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
        			}else if(rateItem < 15)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
        			}else if(rateItem < 18)
        			{
        				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
        			}else
        			{
        				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
        			}
        		}else
        		{
        			spawnMob = DQR.randomMob.getRandomNether(par1World);

        			rateItem = rand.nextInt(25);
        			if(rateItem < 10)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
        			}else if(rateItem < 20)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
        			}else if(rateItem < 24)
        			{
        				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
        			}else
        			{
        				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
        			}
        		}

        	}

            if(rand.nextInt(5) == 0)
            {
            	spawnMob = null;
            }

            if(spawnMob == null && rand.nextInt(2) == 0)
            {
            	doropiItems = new ItemStack(DQDecorates.DqmBlockTaruK, 1);
            }
        }else if(DQR.conf.cfg_gen_Taru_Map.get(dim) != null && DQR.conf.cfg_gen_Taru_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.THEEND.getName()))
        {
        	if(rand.nextInt(4) == 0)
        	{
        		if(!par1World.isRemote)
        		{
        			par1World.createExplosion(null, par2, par3, par4, 5.0F, true);
        		}
        	}else
        	{
        		if(rand.nextInt(5) == 0)
        		{
        			spawnMob = DQR.randomMob.getRandomEnd(par1World);

        			rateItem = rand.nextInt(20);
        			if(rateItem < 10)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
        			}else if(rateItem < 15)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
        			}else if(rateItem < 18)
        			{
        				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
        			}else
        			{
        				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
        			}
        		}else
        		{
        			spawnMob = DQR.randomMob.getRandomNether(par1World);

        			rateItem = rand.nextInt(25);
        			if(rateItem < 10)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
        			}else if(rateItem < 20)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
        			}else if(rateItem < 24)
        			{
        				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
        			}else
        			{
        				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
        			}
        		}

        	}

            if(rand.nextInt(5) == 0)
            {
            	spawnMob = null;
            }

            if(spawnMob == null && rand.nextInt(2) == 0)
            {
            	doropiItems = new ItemStack(DQDecorates.DqmBlockTaruK, 1);
            }
        }



        if (!par1World.isRemote)
        {
        	DqmTileEntityTaruMob tile = (DqmTileEntityTaruMob)par1World.getTileEntity(par2, par3, par4);
        	DQR.func.debugString("TEST : " + tile.getFlgInpasu());
        	if(spawnMob != null && tile.getFlgInpasu() == 0)
        	{
        		int[] locate = DQR.func.getSpaceLocationRandom(par1World, par2, par3, par4, 4, 4);
        		spawnMob.setLocationAndAngles((double)locate[0], (double)locate[1], (double)locate[2], 0.0F, 0.0F);
        		par1World.spawnEntityInWorld(spawnMob);
        		spawnMob.spawnExplosionParticle();
        	}

        	if(doropiItems != null)
        	{
        		this.dropBlockAsItem(par1World, par2, par3, par4, doropiItems);
        	}
        }

        super.breakBlock(par1World, par2, par3, par4, p_149749_5_, par5);
    }

    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
    	//Block block = par1World.getBlock(par2, par3, par4);

    	//DQR.func.debugString("SYSTEM : " + par2 + " / " + par3  + " / " + par4 + " : " + this.);
    	/*
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

        rateItem = rand.nextInt(10);


        if(DQR.conf.cfg_gen_Taru_Map.get(dim) != null && DQR.conf.cfg_gen_Taru_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.OVERWORLD.getName()))
        {
    		if(rand.nextInt(5) != 0)
    		{
    			spawnMob = DQR.randomMob.getRandomNight(par1World);

    			rateItem = rand.nextInt(20);
    			if(rateItem < 10)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
    			}else if(rateItem < 16)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
    			}else if(rateItem < 19)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
    			}else
    			{
    				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
    			}
    		}else
    		{
    			spawnMob = DQR.randomMob.getRandomNether(par1World);

    			rateItem = rand.nextInt(25);
    			if(rateItem < 10)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
    			}else if(rateItem < 20)
    			{
    				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
    			}else if(rateItem < 24)
    			{
    				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
    			}else
    			{
    				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
    			}
    		}
        }else if(DQR.conf.cfg_gen_Taru_Map.get(dim) != null && DQR.conf.cfg_gen_Taru_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.NETHER.getName()))
        {
        	if(rand.nextInt(4) == 0)
        	{
        		if(!par1World.isRemote)
        		{
        			par1World.createExplosion(null, par2, par3, par4, 5.0F, true);
        		}
        	}else
        	{
        		if(rand.nextInt(5) == 0)
        		{
        			spawnMob = DQR.randomMob.getRandomEnd(par1World);

        			rateItem = rand.nextInt(20);
        			if(rateItem < 10)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
        			}else if(rateItem < 15)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
        			}else if(rateItem < 18)
        			{
        				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
        			}else
        			{
        				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
        			}
        		}else
        		{
        			spawnMob = DQR.randomMob.getRandomNether(par1World);

        			rateItem = rand.nextInt(25);
        			if(rateItem < 10)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
        			}else if(rateItem < 20)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
        			}else if(rateItem < 24)
        			{
        				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
        			}else
        			{
        				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
        			}
        		}

        	}

            if(rand.nextInt(5) == 0)
            {
            	spawnMob = null;
            }

            if(spawnMob == null && rand.nextInt(2) == 0)
            {
            	doropiItems = new ItemStack(DQDecorates.DqmBlockTaruK, 1);
            }
        }else if(DQR.conf.cfg_gen_Taru_Map.get(dim) != null && DQR.conf.cfg_gen_Taru_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.THEEND.getName()))
        {
        	if(rand.nextInt(4) == 0)
        	{
        		if(!par1World.isRemote)
        		{
        			par1World.createExplosion(null, par2, par3, par4, 5.0F, true);
        		}
        	}else
        	{
        		if(rand.nextInt(5) == 0)
        		{
        			spawnMob = DQR.randomMob.getRandomEnd(par1World);

        			rateItem = rand.nextInt(20);
        			if(rateItem < 10)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
        			}else if(rateItem < 15)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
        			}else if(rateItem < 18)
        			{
        				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
        			}else
        			{
        				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
        			}
        		}else
        		{
        			spawnMob = DQR.randomMob.getRandomNether(par1World);

        			rateItem = rand.nextInt(25);
        			if(rateItem < 10)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank4(1, 1);
        			}else if(rateItem < 20)
        			{
        				doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
        			}else if(rateItem < 24)
        			{
        				doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
        			}else
        			{
        				doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
        			}
        		}

        	}

            if(rand.nextInt(5) == 0)
            {
            	spawnMob = null;
            }

            if(spawnMob == null && rand.nextInt(2) == 0)
            {
            	doropiItems = new ItemStack(DQDecorates.DqmBlockTaruK, 1);
            }
        }



        if (!par1World.isRemote)
        {
        	DqmTileEntityTaruMob tile = (DqmTileEntityTaruMob)par1World.getTileEntity(par2, par3, par4);

        	if(spawnMob != null && tile.getFlgInpasu() == 0)
        	{
        		int[] locate = DQR.func.getSpaceLocationRandom(par1World, par2, par3, par4, 4, 4);
        		spawnMob.setLocationAndAngles((double)locate[0], (double)locate[1], (double)locate[2], 0.0F, 0.0F);
        		par1World.spawnEntityInWorld(spawnMob);
        		spawnMob.spawnExplosionParticle();
        	}

        	if(doropiItems != null)
        	{
        		this.dropBlockAsItem(par1World, par2, par3, par4, doropiItems);
        	}
        }
        */

        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
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

        //if(x3>=11 && x3<=30){j=DqmItemList.Tubo.blockID;}
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

        //if(x3>=0 && x3<=10){j=DqmItemList.Taru.blockID;}
        //if(x3>=11 && x3<=30){j=DqmItemList.TaruMob.blockID;}
        //else{j=0;}
        return j;
    }
    */

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
		return null;
    }

    public DqmBlockTaruMob setmodel(String m)
    {
        model = m;
        return this;
    }
    //光を通す
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
        return -1;
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:TaruB");
    }
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new DqmTileEntityTaruMob();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }
    }


    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return false;
    }
}
