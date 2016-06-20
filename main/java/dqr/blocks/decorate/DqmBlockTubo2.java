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
import dqr.blocks.decorate.tileEntity.DqmTileEntityTubo;
import dqr.entity.mobEntity.DqmMobBase;

public class DqmBlockTubo2 extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockTubo2(Material var2)
    {
        super( var2);
        // this.setLightValue(0.9375F);
        this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.7F, 0.8F);
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

        if(DQR.conf.cfg_gen_Tubo_Map.get(dim) != null && DQR.conf.cfg_gen_Tubo_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.OVERWORLD.getName()))
        {
	        if(rand.nextInt(5) == 0)
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
	        }else
	        {
	        	rateItem = rand.nextInt(50);

	        	if(rateItem == 0)
	        	{
	        		doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	        	}else if(rateItem < 10)
	        	{
	        		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	        	}else if(rateItem < 15)
	        	{
	        		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	        	}else
	        	{
	        		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	        	}
	        }
        }else if(DQR.conf.cfg_gen_Tubo_Map.get(dim) != null && DQR.conf.cfg_gen_Tubo_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.NETHER.getName()))
        {
	        if(rand.nextInt(5) == 0)
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
	        }else
	        {
	        	rateItem = rand.nextInt(50);

	        	if(rateItem == 0)
	        	{
	        		doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	        	}else if(rateItem < 10)
	        	{
	        		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	        	}else if(rateItem < 15)
	        	{
	        		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	        	}else
	        	{
	        		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	        	}
	        }
        }else if(DQR.conf.cfg_gen_Tubo_Map.get(dim) != null && DQR.conf.cfg_gen_Tubo_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.THEEND.getName()))
        {
	        if(rand.nextInt(5) == 0)
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
	        }else
	        {
	        	rateItem = rand.nextInt(50);

	        	if(rateItem == 0)
	        	{
	        		doropiItems = DQR.randomItem.getEmblemRank1(1, 1);
	        	}else if(rateItem < 10)
	        	{
	        		doropiItems = DQR.randomItem.getFoodRank1(1, 1);
	        	}else if(rateItem < 15)
	        	{
	        		doropiItems = DQR.randomItem.getMiscsRank2(1, 1);
	        	}else
	        	{
	        		doropiItems = DQR.randomItem.getMiscsRank1(1, 1);
	        	}
	        }
        }

        if(doropiItems != null && rand.nextInt(5) == 0)
        {
        	doropiItems = new ItemStack(DQDecorates.DqmBlockTuboK, 1);
        }


        if (!par1World.isRemote)
        {
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


    public DqmBlockTubo2 setmodel(String m)
    {
        model = m;
        return this;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:Tubo");
    }
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new DqmTileEntityTubo();
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
