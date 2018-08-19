package dqr.blocks.decorate;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
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
import dqr.blocks.decorate.tileEntity.DqmTileEntityAkumanotubo;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.mobEntity.monsterHell.DqmEntityTubokku;
import dqr.entity.mobEntity.monsterNight.DqmEntityAkumanotubo;

public class DqmBlockAkumanotubo2 extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockAkumanotubo2(Material var2)
    {
        super( var2);
        // this.setLightValue(0.9375F);
        this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.7F, 0.8F);
    }

    public DqmBlockAkumanotubo2 setmodel(String m)
    {
        model = m;
        return this;
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

        DQR.func.debugString("TEST : " + par1World.getBlock(par2, par3, par4).getUnlocalizedName() + " / " + par1World.getBlockMetadata(par2, par3, par4));
        Random rand = new Random();
        DqmMobBase spawnMob = null;
        ItemStack doropiItems = null;
        int rateMob = 0;
        int rateItem = 0;
        int dim = par1World.provider.dimensionId;

        rateItem = rand.nextInt(10);
        if(DQR.conf.cfg_gen_Tubo_Map.get(dim) != null && DQR.conf.cfg_gen_Tubo_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.OVERWORLD.getName()))
        {
	        if(rateItem == 0)
	        {
	        	if (!par1World.isRemote)
	        	{
		        	if(dim == 0)
		        	{
		        		par1World.setBlock(par2, par3, par4, Blocks.flowing_water, 0, 2);
		        	}else
		        	{
		        		par1World.setBlock(par2, par3, par4, Blocks.flowing_lava, 0, 2);
		        	}
	        	}
	        }else if(rateItem == 1)
	        {
	        	if (!par1World.isRemote)
	        	{
	        		par1World.setBlock(par2, par3, par4, Blocks.flowing_lava, 0, 2);
	        	}
	        }else
	        {
	        	if(dim == 0)
	        	{
	        		spawnMob = new DqmEntityAkumanotubo(par1World);

	            	rateItem = rand.nextInt(50);

	            	if(rateItem < 2)
	            	{
	            		doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	            	}else if(rateItem < 5)
	            	{
	            		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
	            	}else if(rateItem < 10)
	            	{
	            		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	            	}else if(rateItem < 20)
	            	{
	            		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	            	}else
	            	{
	            		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	            	}
	        	}else
	        	{
	        		if(rand.nextInt(5) != 0)
	        		{
	        			spawnMob = new DqmEntityAkumanotubo(par1World);

	                	rateItem = rand.nextInt(50);

	                	if(rateItem < 3)
	                	{
	                		if(rand.nextInt(4) == 0)
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
	                		}else
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	                		}
	                	}else if(rateItem < 20)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
	                	}else if(rateItem < 35)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	                	}else if(rateItem < 40)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	                	}else if(rateItem < 43)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
	                	}else
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	                	}
	        		}else
	        		{
	        			spawnMob = new DqmEntityTubokku(par1World);

	                	rateItem = rand.nextInt(50);

	                	if(rateItem < 5)
	                	{
	                		if(rand.nextInt(5) < 3)
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
	                		}else
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	                		}
	                	}else if(rateItem < 25)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
	                	}else if(rateItem < 40)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	                	}else if(rateItem < 45)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	                	}else if(rateItem < 48)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
	                	}else
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	                	}
	        		}

	        	}

	            if(rand.nextInt(8) == 0)
	            {
	            	spawnMob = null;
	            }

	            if(spawnMob == null && rand.nextInt(2) == 0)
	            {
	            	doropiItems = new ItemStack(DQDecorates.DqmBlockAkumanotubo, 1);
	            }
	        }
        }else if(DQR.conf.cfg_gen_Tubo_Map.get(dim) != null && DQR.conf.cfg_gen_Tubo_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.NETHER.getName()))
        {
            if(rateItem == 0)
	        {
	        	if (!par1World.isRemote)
	        	{
		        	if(dim == 0)
		        	{
		        		par1World.setBlock(par2, par3, par4, Blocks.flowing_water, 0, 2);
		        	}else
		        	{
		        		par1World.setBlock(par2, par3, par4, Blocks.flowing_lava, 0, 2);
		        	}
	        	}
	        }else if(rateItem == 1)
	        {
	        	if (!par1World.isRemote)
	        	{
	        		par1World.setBlock(par2, par3, par4, Blocks.flowing_lava, 0, 2);
	        	}
	        }else
	        {
	        	if(dim == 0)
	        	{
	        		spawnMob = new DqmEntityAkumanotubo(par1World);

	            	rateItem = rand.nextInt(50);

	            	if(rateItem < 2)
	            	{
	            		doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	            	}else if(rateItem < 5)
	            	{
	            		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
	            	}else if(rateItem < 10)
	            	{
	            		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	            	}else if(rateItem < 20)
	            	{
	            		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	            	}else
	            	{
	            		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	            	}
	        	}else
	        	{
	        		if(rand.nextInt(5) != 0)
	        		{
	        			spawnMob = new DqmEntityAkumanotubo(par1World);

	                	rateItem = rand.nextInt(50);

	                	if(rateItem < 3)
	                	{
	                		if(rand.nextInt(4) == 0)
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
	                		}else
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	                		}
	                	}else if(rateItem < 20)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
	                	}else if(rateItem < 35)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	                	}else if(rateItem < 40)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	                	}else if(rateItem < 43)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
	                	}else
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	                	}
	        		}else
	        		{
	        			spawnMob = new DqmEntityTubokku(par1World);

	                	rateItem = rand.nextInt(50);

	                	if(rateItem < 5)
	                	{
	                		if(rand.nextInt(5) < 3)
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
	                		}else
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	                		}
	                	}else if(rateItem < 25)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
	                	}else if(rateItem < 40)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	                	}else if(rateItem < 45)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	                	}else if(rateItem < 48)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
	                	}else
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	                	}
	        		}

	        	}

	            if(rand.nextInt(8) == 0)
	            {
	            	spawnMob = null;
	            }

	            if(spawnMob == null && rand.nextInt(2) == 0)
	            {
	            	doropiItems = new ItemStack(DQDecorates.DqmBlockAkumanotubo, 1);
	            }
	        }
        }else if(DQR.conf.cfg_gen_Tubo_Map.get(dim) != null && DQR.conf.cfg_gen_Tubo_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.THEEND.getName()))
        {
            if(rateItem == 0)
	        {
	        	if (!par1World.isRemote)
	        	{
		        	if(dim == 0)
		        	{
		        		par1World.setBlock(par2, par3, par4, Blocks.flowing_water, 0, 2);
		        	}else
		        	{
		        		par1World.setBlock(par2, par3, par4, Blocks.flowing_lava, 0, 2);
		        	}
	        	}
	        }else if(rateItem == 1)
	        {
	        	if (!par1World.isRemote)
	        	{
	        		par1World.setBlock(par2, par3, par4, Blocks.flowing_lava, 0, 2);
	        	}
	        }else
	        {
	        	if(dim == 0)
	        	{
	        		spawnMob = new DqmEntityAkumanotubo(par1World);

	            	rateItem = rand.nextInt(50);

	            	if(rateItem < 2)
	            	{
	            		doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	            	}else if(rateItem < 5)
	            	{
	            		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
	            	}else if(rateItem < 10)
	            	{
	            		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	            	}else if(rateItem < 20)
	            	{
	            		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	            	}else
	            	{
	            		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	            	}
	        	}else
	        	{
	        		if(rand.nextInt(5) != 0)
	        		{
	        			spawnMob = new DqmEntityAkumanotubo(par1World);

	                	rateItem = rand.nextInt(50);

	                	if(rateItem < 3)
	                	{
	                		if(rand.nextInt(4) == 0)
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
	                		}else
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	                		}
	                	}else if(rateItem < 20)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
	                	}else if(rateItem < 35)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	                	}else if(rateItem < 40)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	                	}else if(rateItem < 43)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
	                	}else
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	                	}
	        		}else
	        		{
	        			spawnMob = new DqmEntityTubokku(par1World);

	                	rateItem = rand.nextInt(50);

	                	if(rateItem < 5)
	                	{
	                		if(rand.nextInt(5) < 3)
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank2(1, 1);
	                		}else
	                		{
	                			doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	                		}
	                	}else if(rateItem < 25)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank2(1, 1);
	                	}else if(rateItem < 40)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	                	}else if(rateItem < 45)
	                	{
	                		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	                	}else if(rateItem < 48)
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank3(1, 1);
	                	}else
	                	{
	                		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	                	}
	        		}

	        	}

	            if(rand.nextInt(8) == 0)
	            {
	            	spawnMob = null;
	            }

	            if(spawnMob == null && rand.nextInt(2) == 0)
	            {
	            	doropiItems = new ItemStack(DQDecorates.DqmBlockAkumanotubo, 1);
	            }
	        }
        }


        if (!par1World.isRemote)
        {
        	DqmTileEntityAkumanotubo tile = (DqmTileEntityAkumanotubo)par1World.getTileEntity(par2, par3, par4);

        	if(spawnMob != null && tile.getFlgInpasu() == 0)
        	{
        		int[] locate = DQR.func.getSpaceLocationRandom(par1World, par2, par3, par4, 4, 4);
        		spawnMob.setLocationAndAngles((double)locate[0], (double)locate[1], (double)locate[2], 0.0F, 0.0F);
        		par1World.spawnEntityInWorld(spawnMob);
        		spawnMob.spawnExplosionParticle();
        		/*
        		spawnMob.setLocationAndAngles((double)par2 + 0.5D + x4, (double)par3 + x5, (double)par4 + 0.5D + x4, 0.0F, 0.0F);
        		par1World.spawnEntityInWorld(spawnMob);
        		spawnMob.spawnExplosionParticle();
        		*/
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
*/
        /*if(x3==79){j=DqmItemList.Sabitayoroi.itemID;}
        if(x3==78){j=DqmItemList.Sabitakote.itemID;}
        if(x3==77){j=DqmItemList.Sabitakabuto.itemID;}
        if(x3==76){j=DqmItemList.Sabitakutu.itemID;}*/
    /*
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

        //if(x3>=11 && x3<=30){j=DqmItemList.Akumanotubo.blockID;}
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

        //else{j=0;}
        return j;
    }
    */
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:Akumanotubo");
    }
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new DqmTileEntityAkumanotubo();
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
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
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return false;
    }

}
