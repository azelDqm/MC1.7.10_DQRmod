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
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaB;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaBG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaD;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaDG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaE;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaEG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaGG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaI;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaIG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaL;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaLG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaN;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaNG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaO;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaOG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaQ;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaQG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaR;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaRG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaS;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaSG;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaW;
import dqr.blocks.decorate.tileEntity.DqmTileEntityDaizaWG;

public class DqmBlockDaiza extends BlockContainer
{
    public static String setmodel;
    private String model;

    public DqmBlockDaiza(Material var2)
    {
        super(var2);
        //this.setLightValue(3.0F);
        //this.setLightValue(0.9375F);

        //this.setBlockBounds(0.0F, 0.1F, 0.0F, 1.0F, 0.0F, 1.0F);
    }
    /*
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	if(!par5EntityPlayer.isSneaking())
    	{
    		this.setLightValue(1.5F);
    	}
    	if(this.setLightValue(0.0F) != null)
        {
    		this.setLightValue(1.5F);
        }
    	else if(this.setLightValue(1.5F) != null)
        {
    		this.setLightValue(0.0F);
        }
    	return true;
    }*/
    public DqmBlockDaiza setmodel(String m)
    {
        model = m;
        return this;
    }
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    //光を通す1 通さない0
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:DaizaB");
    }
    public TileEntity createNewTileEntity(World var1, int par1)
    {
        if (model == "DaizaB")
        {
            return new DqmTileEntityDaizaB();
        }

        if (model == "DaizaBG")
        {
            return new DqmTileEntityDaizaBG();
        }

        if (model == "DaizaD")
        {
            return new DqmTileEntityDaizaD();
        }

        if (model == "DaizaDG")
        {
            return new DqmTileEntityDaizaDG();
        }

        if (model == "DaizaE")
        {
            return new DqmTileEntityDaizaE();
        }

        if (model == "DaizaEG")
        {
            return new DqmTileEntityDaizaEG();
        }

        if (model == "DaizaG")
        {
            return new DqmTileEntityDaizaG();
        }

        if (model == "DaizaGG")
        {
            return new DqmTileEntityDaizaGG();
        }

        if (model == "DaizaI")
        {
            return new DqmTileEntityDaizaI();
        }

        if (model == "DaizaIG")
        {
            return new DqmTileEntityDaizaIG();
        }

        if (model == "DaizaL")
        {
            return new DqmTileEntityDaizaL();
        }

        if (model == "DaizaLG")
        {
            return new DqmTileEntityDaizaLG();
        }

        if (model == "DaizaN")
        {
            return new DqmTileEntityDaizaN();
        }

        if (model == "DaizaNG")
        {
            return new DqmTileEntityDaizaNG();
        }

        if (model == "DaizaO")
        {
            return new DqmTileEntityDaizaO();
        }

        if (model == "DaizaOG")
        {
            return new DqmTileEntityDaizaOG();
        }

        if (model == "DaizaQ")
        {
            return new DqmTileEntityDaizaQ();
        }

        if (model == "DaizaQG")
        {
            return new DqmTileEntityDaizaQG();
        }

        if (model == "DaizaR")
        {
            return new DqmTileEntityDaizaR();
        }

        if (model == "DaizaRG")
        {
            return new DqmTileEntityDaizaRG();
        }

        if (model == "DaizaS")
        {
            return new DqmTileEntityDaizaS();
        }

        if (model == "DaizaSG")
        {
            return new DqmTileEntityDaizaSG();
        }

        if (model == "DaizaW")
        {
            return new DqmTileEntityDaizaW();
        }

        if (model == "DaizaWG")
        {
            return new DqmTileEntityDaizaWG();
        }

        return new DqmTileEntityDaizaQ();
    }

    //透けないfalse 透けるtrue
    public boolean isOpaqueCube()
    {
        return false;
    }
    /*
    public void setBlockBoundsForItemRender()
    {
        this.func_96478_d(0);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.func_96478_d(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }

    protected void func_96478_d(int par1)
    {
        int j = par1 & 7;
        float f = (float)(2 * (1 + j)) / 16.0F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }*/

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
