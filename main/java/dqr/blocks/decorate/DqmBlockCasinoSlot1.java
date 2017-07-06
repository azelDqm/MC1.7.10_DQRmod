package dqr.blocks.decorate;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;

public class DqmBlockCasinoSlot1 extends Block{

	IIcon field_149936_O;
	IIcon field_149935_N;
	public DqmBlockCasinoSlot1(Material arg0)
	{
		super(arg0);
		// TODO 自動生成されたコンストラクター・スタブ
	}

    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
        }

        if (l == 1)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
        }

        if (l == 2)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
        }

        if (l == 3)
        {
            p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
        }

    }
    @Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer ep, int par6, float par7, float par8, float par9)
    {
    	ep.openGui(DQR.instance, DQR.conf.GuiID_CSSlot, par1World, (int)ep.posX, (int)ep.posY, (int)ep.posZ);
    	return true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
    	/*
    	IIcon ret = null;
    	//p_149691_2_ メタ値
    	if(p_149691_2_ == 0)
    	{
    		if(p_149691_1_ == 1)
    		{
    			ret= field_149935_N;
    		}else
    		{
    			ret= field_149936_O;
    		}
    	}else if(p_149691_2_ == 1)
    	{
    		if(p_149691_1_ == 1)
    		{
    			ret= field_149935_N;
    		}else
    		{
    			ret= field_149936_O;
    		}
    	}else if(p_149691_2_ == 2)
    	{
    		if(p_149691_1_ == 2)
    		{
    			ret= field_149935_N;
    		}else
    		{
    			ret= field_149936_O;
    		}
    	}else if(p_149691_2_ == 3)
    	{
    		if(p_149691_1_ == 3)
    		{
    			ret= field_149935_N;
    		}else
    		{
    			ret= field_149936_O;
    		}
    	}

    	return ret;
    	*/
    	return p_149691_1_ == 1 ? this.field_149935_N : (p_149691_1_ == 0 ? this.field_149935_N : (p_149691_1_ != p_149691_2_ ? this.blockIcon : this.field_149936_O));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("dqr:KajinoA2");
        this.field_149936_O = p_149651_1_.registerIcon("dqr:KajinoA");
        this.field_149935_N = p_149651_1_.registerIcon("dqr:KajinoA2");
    }

    public String getItemIconName()
	{
    	return this.textureName;
	}
}
