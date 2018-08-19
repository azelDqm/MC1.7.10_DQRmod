package dqr.blocks.decorate;

import java.util.Random;

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
import dqr.blocks.decorate.tileEntity.DqmTileEntitySwordMob;
import dqr.entity.mobEntity.DqmMobBase;
public class DqmBlockBlockSwordMob extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockBlockSwordMob(Material var2)
    {
        super( var2);
        this.setBlockBounds(0.45F, 0.0F, 0.45F, 0.55F, 1.93F, 0.55F);
        // this.setLightValue(0.9375F);
    }

    public DqmBlockBlockSwordMob setmodel(String m)
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

        Random rand = new Random();
        DqmMobBase spawnMob = null;
        ItemStack doropiItems = null;
        int rateMob = 0;
        int rateItem = 0;
        int dim = par1World.provider.dimensionId;


        if(DQR.conf.cfg_gen_Sword_Map.get(dim) != null && DQR.conf.cfg_gen_Sword_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.OVERWORLD.getName()))
        {
        	if(rand.nextInt(4) != 0)
        	{

        		spawnMob = DQR.randomMob.getRandomNight(par1World);
        		doropiItems = DQR.randomItem.getWeaponRank1(1, 1);
        	}else
        	{
        		if(rand.nextInt(4) == 0)
        		{
        			spawnMob = DQR.randomMob.getRandomNight(par1World);
        		}else
        		{
        			spawnMob = DQR.randomMob.getRandomNether(par1World);
        		}
        		doropiItems = DQR.randomItem.getWeaponRank2(1, 1);
        	}
        }else if(DQR.conf.cfg_gen_Sword_Map.get(dim) != null && DQR.conf.cfg_gen_Sword_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.NETHER.getName()))
        {
        	rateMob = rand.nextInt(10);
        	if(rateMob == 0)
        	{
        		spawnMob = DQR.randomMob.getRandomEnd(par1World);
        		doropiItems = DQR.randomItem.getWeaponRank4(1, 1);

        	}else if(rateMob < 4)
        	{
        		spawnMob = DQR.randomMob.getRandomNether(par1World);
        		doropiItems = DQR.randomItem.getWeaponRank3(1, 1);
        	}else
        	{
        		if(rand.nextInt(4) == 0)
        		{
        			spawnMob = DQR.randomMob.getRandomNight(par1World);
        		}else
        		{
        			spawnMob = DQR.randomMob.getRandomNether(par1World);
        		}
        		doropiItems = DQR.randomItem.getWeaponRank2(1, 1);
        	}
        }else if(DQR.conf.cfg_gen_Sword_Map.get(dim) != null && DQR.conf.cfg_gen_Sword_Map.get(dim).equalsIgnoreCase(EnumDqmWorldType.THEEND.getName()))
        {
        	rateMob = rand.nextInt(15);
        	if(rateMob == 0)
        	{
        		spawnMob = DQR.randomMob.getRandomTENSEI(par1World);
        		doropiItems = DQR.randomItem.getWeaponRank5(1, 1);

        	}else if(rateMob < 4)
        	{
        		if(rand.nextInt(4) == 0)
        		{
        			spawnMob = DQR.randomMob.getRandomEnd(par1World);
        		}else
        		{
        			spawnMob = DQR.randomMob.getRandomTENSEI(par1World);
        		}
        		doropiItems = DQR.randomItem.getWeaponRank5(1, 1);
        	}else
        	{
        		spawnMob = DQR.randomMob.getRandomEnd(par1World);
        		doropiItems = DQR.randomItem.getWeaponRank4(1, 1);;
        	}
        }

        if(rand.nextInt(8) == 0)
        {
        	spawnMob = null;
        }

        if(spawnMob == null && rand.nextInt(2) == 0)
        {
        	doropiItems = new ItemStack(DQDecorates.DqmBlockSword, 1);
        }

        if (!par1World.isRemote)
        {
        	DqmTileEntitySwordMob tile = (DqmTileEntitySwordMob)par1World.getTileEntity(par2, par3, par4);

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
    	/*
        int x = 0;
        int x3 = x + getRandom(100, 0);
        int x4 = x + getRandom(2, 0);
        int x5 = x + getRandom(4, 0);

        if (x3 >= 31)
        {
            if (!par1World.isRemote)
            {
                DqmEntityHitokuisaberu entitysilverfish = new DqmEntityHitokuisaberu(par1World);
                entitysilverfish.setLocationAndAngles((double)par2 + 0.5D + x4, (double)par3 + x5, (double)par4 + 0.5D + x4, 0.0F, 0.0F);
                par1World.spawnEntityInWorld(entitysilverfish);
                entitysilverfish.spawnExplosionParticle();
            }
        }

        if (x3 >= 11 && x3 <= 30)
        {
            if (!par1World.isRemote)
            {
                DqmEntitySibiredanbira entitysilverfish = new DqmEntitySibiredanbira(par1World);
                entitysilverfish.setLocationAndAngles((double)par2 + 0.5D + x4, (double)par3 + x5, (double)par4 + 0.5D + x4, 0.0F, 0.0F);
                par1World.spawnEntityInWorld(entitysilverfish);
                entitysilverfish.spawnExplosionParticle();
            }
        }

        if (x3 >= 1 && x3 <= 10)
        {
            if (!par1World.isRemote)
            {
                DqmEntityBoureikensi entitysilverfish = new DqmEntityBoureikensi(par1World);
                entitysilverfish.setLocationAndAngles((double)par2 + 0.5D + x4, (double)par3 + x5, (double)par4 + 0.5D + x4, 0.0F, 0.0F);
                par1World.spawnEntityInWorld(entitysilverfish);
                entitysilverfish.spawnExplosionParticle();
            }
        }

        if (x3 == 0)
        {
            if (!par1World.isRemote)
            {
                DqmEntitySirubamanto entitysilverfish = new DqmEntitySirubamanto(par1World);
                entitysilverfish.setLocationAndAngles((double)par2 + 0.5D + x4, (double)par3 + x5, (double)par4 + 0.5D + x4, 0.0F, 0.0F);
                par1World.spawnEntityInWorld(entitysilverfish);
                entitysilverfish.spawnExplosionParticle();
            }
        }
		*/
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
        int x3 = x + getRandom(25, 0);

        if (x3 == 0)
        {
            return DqmItemList.Dounoturugi.itemID;
        }

        if (x3 == 1)
        {
            return DqmItemList.Heisinoken.itemID;
        }

        if (x3 == 2)
        {
            return DqmItemList.Reipia.itemID;
        }

        if (x3 == 3)
        {
            return DqmItemList.Haganenoturugi.itemID;
        }

        if (x3 == 4)
        {
            return DqmItemList.Koorinoyaiba.itemID;
        }

        if (x3 == 5)
        {
            return DqmItemList.Tenbinbou.itemID;
        }

        if (x3 == 6)
        {
            return DqmItemList.Haganenokon.itemID;
        }

        if (x3 == 7)
        {
            return DqmItemList.Isinotume.itemID;
        }

        if (x3 == 8)
        {
            return DqmItemList.Majuunotume.itemID;
        }

        if (x3 == 9)
        {
            return DqmItemList.Konbou.itemID;
        }

        if (x3 == 10)
        {
            return DqmItemList.Jaiantokurabu.itemID;
        }

        if (x3 == 11)
        {
            return DqmItemList.Wohanma.itemID;
        }

        if (x3 == 12)
        {
            return DqmItemList.Haganenoono.itemID;
        }

        if (x3 == 13)
        {
            return DqmItemList.Kinoono.itemID;
        }

        if (x3 == 14)
        {
            return DqmItemList.Kawanomuti.itemID;
        }

        if (x3 == 15)
        {
            return DqmItemList.Ibaranomuti.itemID;
        }

        if (x3 == 16)
        {
            return DqmItemList.Batoruribon.itemID;
        }

        if (x3 == 17)
        {
            return DqmItemList.Doragonteiru.itemID;
        }

        if (x3 == 18)
        {
            return DqmItemList.Monosasizao.itemID;
        }

        if (x3 == 19)
        {
            return DqmItemList.Takenoyari.itemID;
        }

        if (x3 == 20)
        {
            return DqmItemList.Tetunoyari.itemID;
        }

        if (x3 == 21)
        {
            return DqmItemList.Toraidento.itemID;
        }

        if (x3 == 22)
        {
            return DqmItemList.Dokubari.itemID;
        }

        if (x3 == 23)
        {
            return DqmItemList.Kudamononaifu.itemID;
        }

        if (x3 == 24)
        {
            return DqmItemList.Seinarunaifu.itemID;
        }

        if (x3 == 25)
        {
            return DqmItemList.Dokuganonaifu.itemID;
        }

        return 0 ;
    }
    */
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:SwordsB");
    }
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new DqmTileEntitySwordMob();
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
