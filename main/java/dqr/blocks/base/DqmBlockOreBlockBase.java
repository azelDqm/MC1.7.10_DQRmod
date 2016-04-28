 package dqr.blocks.base;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;

public class DqmBlockOreBlockBase extends Block
{
    private IIcon[] blockIcon;
    public DqmBlockOreBlockBase(Material par2Material)
    {
        super(par2Material);
        this.setLightLevel(1.0F);
        this.setHardness(5F);
        this.setResistance(300);
        this.setStepSound(Block.soundTypeGrass);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        //return super.getIcon(par1, par2);
        return this.blockIcon[par2];
    }

    @Override
    public int damageDropped(int par1)
    {
        return par1;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        // メタデータでブロックを追加する
        // par3List.add(new ItemStack(par1, 1, <メタデータ>));
        for (int i = 0; i < 16; i++)
        {
            par3List.add(new ItemStack(par1, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)

    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        //テクスチャのパス指定。
        //メタデータは0から2でつまり3未満
        //src/minecraft/assets/samplemod/items/itemsample_(メタデータ).png
        this.blockIcon = new IIcon[16];

        for (int i = 0; i < this.blockIcon.length; ++i)
        {
            this.blockIcon[i] = par1IconRegister.registerIcon("dqr:dqm_block_" + i);
            this.setBlockName("dqm.blockOreBlock" + i);
            //this.setCreativeTab(CreativeTabs.tabBlock);
            this.setCreativeTab(DQR.tabs.DqmTabOre);
        }
    }

    @Override
    public int quantityDropped(Random rand)
    {
        //ブロックを壊した時にドロップする量
        return 1;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float disX, float disY, float disZ)
    {
        //ブロックが右クリックされた時
        return false;
    }

    @Override
    public int getRenderType()
    {
        return 0;
    }
}
