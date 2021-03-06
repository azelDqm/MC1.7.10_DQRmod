package dqr.blocks.decorate;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.blocks.decorate.tileEntity.DqmTileEntityTubo;

public class DqmBlockTubo extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockTubo(Material var2)
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

        //if(x3>=-150 && x3<=-121){j=DqmItemList.Tubo2.blockID;}
        //else{j=0;}
        return j;
    }
    */

    public DqmBlockTubo setmodel(String m)
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
