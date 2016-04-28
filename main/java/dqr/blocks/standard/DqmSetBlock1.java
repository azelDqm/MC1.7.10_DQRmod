package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class DqmSetBlock1 extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmSetBlock1() //ブロックの基本設定
    {
        super(Material.wood); //材質を土に
    }

    public int quantityDropped(Random random)
    {
        return 1; //idDropedでドロップする数を設定
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if (par5Entity instanceof EntityPlayer)
        {
            if (par1World.isAirBlock(par2 + 1, par3, par4) && par1World.getBlock(par2 + 2, par3, par4) == this)
            {
                par1World.setBlock(par2 + 1, par3, par4, this, 0, 2);
            }

            if (par1World.isAirBlock(par2 - 1, par3, par4) && par1World.getBlock(par2 - 2, par3, par4) == this)
            {
                par1World.setBlock(par2 - 1, par3, par4, this, 0, 2);
            }

            if (par1World.isAirBlock(par2, par3, par4 + 1) && par1World.getBlock(par2, par3, par4 + 2) == this)
            {
                par1World.setBlock(par2, par3, par4 + 1, this, 0, 2);
            }

            if (par1World.isAirBlock(par2, par3, par4 - 1) && par1World.getBlock(par2, par3, par4 - 2) == this)
            {
                par1World.setBlock(par2, par3, par4 - 1, this, 0, 2);
            }

            if (par1World.isAirBlock(par2 + 1, par3, par4 + 1) && par1World.getBlock(par2 + 2, par3, par4 + 2) == this)
            {
                par1World.setBlock(par2 + 1, par3, par4 + 1, this, 0, 2);
            }

            if (par1World.isAirBlock(par2 - 1, par3, par4 + 1) && par1World.getBlock(par2 - 2, par3, par4 + 2) == this)
            {
                par1World.setBlock(par2 - 1, par3, par4 + 1, this, 0, 2);
            }

            if (par1World.isAirBlock(par2 + 1, par3, par4 - 1) && par1World.getBlock(par2 + 2, par3, par4 - 2) == this)
            {
                par1World.setBlock(par2 + 1, par3, par4 - 1, this, 0, 2);
            }

            if (par1World.isAirBlock(par2 - 1, par3, par4 - 1) && par1World.getBlock(par2 - 2, par3, par4 - 2) == this)
            {
                par1World.setBlock(par2 - 1, par3, par4 - 1, this, 0, 2);
            }

            for (int x = -2; x <= 2; ++x)
            {
                for (int z = -2; z <= 2; ++z)
                {
                    for (int y = 1; y <= 5; ++y)
                    {
                    	Block block = par1World.getBlock(par2 + x, par3 + y, par4 + z);
                    	int meta = par1World.getBlockMetadata(par2 + x, par3 + y, par4 + z);
                        this.breakBlock(par1World, par2 + x, par3 + y, par4 + z, block, meta);

                    }
                }
            }
        }
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }
}
