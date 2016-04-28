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
import dqr.blocks.decorate.tileEntity.DqmTileEntityAkumanotubo;

public class DqmBlockAkumanotubo extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockAkumanotubo(Material var2)
    {
        super( var2);
        // this.setLightValue(0.9375F);
        this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 0.7F, 0.8F);
    }

    public DqmBlockAkumanotubo setmodel(String m)
    {
        model = m;
        return this;
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
