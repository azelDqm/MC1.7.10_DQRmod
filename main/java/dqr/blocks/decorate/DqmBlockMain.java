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
import dqr.blocks.decorate.tileEntity.DqmTileEntityTubo;
import dqr.blocks.decorate.tileEntity.DqmTileEntityTubokku;

public class DqmBlockMain extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockMain(Material var2)
    {
        super( var2);
        // this.setLightValue(0.9375F);
    }

    public DqmBlockMain setmodel(String m)
    {
        model = m;
        return this;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        if (model == "Tubo")
        {
            this.blockIcon = var1.registerIcon("dqr:Tubo");
        }

        if (model == "Tubokku")
        {
            this.blockIcon = var1.registerIcon("dqr:Tubokku");
        }

        if (model == "Akumanotubo")
        {
            this.blockIcon = var1.registerIcon("dqr:Akumanotubo");
        }

        //this.blockIcon = var1.registerIcon("dqr:Tubo");
    }
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        if (model == "Tubo")
        {
            return new DqmTileEntityTubo();
        }

        if (model == "Tubokku")
        {
            return new DqmTileEntityTubokku();
        }

        if (model == "Akumanotubo")
        {
            return new DqmTileEntityAkumanotubo();
        }

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

}
