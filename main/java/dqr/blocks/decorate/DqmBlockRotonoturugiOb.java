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
import dqr.blocks.decorate.tileEntity.DqmTileEntityRotonoturugiF;
import dqr.blocks.decorate.tileEntity.DqmTileEntityRotonoturugiF2;
import dqr.blocks.decorate.tileEntity.DqmTileEntityRotonoturugiOb;
import dqr.blocks.decorate.tileEntity.DqmTileEntityRotonoturugiOb2;

public class DqmBlockRotonoturugiOb extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockRotonoturugiOb(Material var2)
    {
        super( var2);

        this.setBlockBounds(0.0F, 0.1F, 0.0F, 1.0F, 0.0F, 1.0F);
    }

    public DqmBlockRotonoturugiOb setmodel(String m)
    {
        model = m;
        return this;
    }
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    //光を通す
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:RotonoturugiB");
    }
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        if (model == "RotonoturugiOb")
        {
            return new DqmTileEntityRotonoturugiOb();
        }

        if (model == "RotonoturugiOb2")
        {
            return new DqmTileEntityRotonoturugiOb2();
        }

        if (model == "RotonoturugiF")
        {
            return new DqmTileEntityRotonoturugiF();
        }

        if (model == "RotonoturugiF2")
        {
            return new DqmTileEntityRotonoturugiF2();
        }

        return new DqmTileEntityRotonoturugiOb();
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public int getRenderType()
    {
        return -1;
    }

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
        return false;
    }
}
