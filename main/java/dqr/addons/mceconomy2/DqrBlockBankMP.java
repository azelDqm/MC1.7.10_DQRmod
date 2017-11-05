package dqr.addons.mceconomy2;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DqrBlockBankMP extends BlockContainer
{
    public static String setmodel;
    private String model;
    private float rotationYaw;

    public DqrBlockBankMP(Material var2)
    {
        super(var2);
        //光源
        //this.setLightValue(3.0F);
        //キューブサイズ
        //this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }
    //1で光を通す 0で通さない
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 0;
    }
    //trueで地面が透ける
    public boolean isOpaqueCube()
    {
        return false;
    }
    //trueでサイズ変更時もキューブサイズを維持する(炎が置ける) falseでサイズに合わせる
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    //フラワー系ののようにアイコンをレンダー -1は透明 10で階段
    public int getRenderType()
    {
        return -1;
    }
    //アイコン
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister var1)
    {
        this.blockIcon = var1.registerIcon("dqr:BankMPB");
    }
    //モデル
    public DqrBlockBankMP setmodel(String m)
    {
        model = m;
        return this;
    }
    //TileEntityの指定
    public TileEntity createNewTileEntity(World var1, int par2)
    {
        //if(model == "000000000"){return new DqmTileEntity000000000();}
        return new DqrTileEntityBankMP();
    }
    //ランダム
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    //方角で角度を変更
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        //int l = par1World.getBlockMetadata(par2, par3, par4);
        if (l == 0)//南
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 0, 2);
        }

        if (l == 1)//東
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
        }

        if (l == 2)//北
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 3)//西
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }
    }

    //方角でサイズを変更
    public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3)
    {
        int l = par1World.getBlockMetadata(par2, par3, par4) & 7;
        float f = 0.15F;

        if (l == 0)//南
        {
            this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
        }
        else if (l == 1)//東
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
        }
        else if (l == 2)//北
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
        }
        else if (l == 3)//西
        {
            this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
        }

        return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
    }

}
