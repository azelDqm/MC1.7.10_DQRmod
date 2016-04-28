package dqr.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DqmBlockBase2 extends Block{

	public DqmBlockBase2(Material par1)
	{
		super(par1);
	}

	@SideOnly(Side.CLIENT)
    private IIcon Kowarenai4t;
    @SideOnly(Side.CLIENT)
    private IIcon Kowarenai4s;
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.Kowarenai4t : (par1 == 0 ? this.Kowarenai4t : (par1 != par2 ? this.blockIcon : this.Kowarenai4s));
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(this.getTextureName() + "s");
        this.Kowarenai4t = par1IconRegister.registerIcon(this.getTextureName() + "t");
    }
}
