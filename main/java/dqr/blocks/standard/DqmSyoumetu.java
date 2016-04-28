package dqr.blocks.standard;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DqmSyoumetu extends Block
{
    //クラス本体。Blockクラスを継承する

    public static int mmm = 0;
    public DqmSyoumetu() //ブロックの基本設定
    {
        super(Material.iron); //材質を土に
        this.setTickRandomly(true);
        //this.setBlockBounds(0.0F, 0.1F, 0.0F, 1.0F, 0.0F, 1.0F);
        //タイマー**************************************************
        Timer t = new Timer();
        t.schedule(new TimerLabelTask(), 0L, 1000L); //1000で1秒に1回TimerLabelTaskを読み込む
    }
    private int xxx = 0;
    class TimerLabelTask extends TimerTask
    {
        public void run()
        {
            if (xxx >= 15)
            {
                xxx = 0;
            }

            if (xxx < 15)
            {
                xxx = xxx + 1;
            }
        }
    }
    //タイマー**************************************************
    public static int yyy = 0;
    //常時読み込む早い
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (xxx == 1 && yyy == 0)
        {
            yyy = 1;
        }

        if (xxx == 15 && yyy == 1)
        {
            yyy = 2;
        }
    }
    //常時読み込むが遅い
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        setmmm(1);

        if (mmm > 2100)
        {
        	par1World.setBlockToAir(par2, par3, par4);
        	/*
            for (int x = -80; x <= 80; ++x)
            {
                for (int z = -80; z <= 80; ++z)
                {
                    for (int y = -10; y <= 80; ++y)
                    {
                        if (par1World.getBlockId(par2 + x, par3 + y, par4 + z) == DqmItemList.Shoumetu.blockID)
                        {
                            //par1World.destroyBlock(par2+x, par3+y, par4+z, true);
                            par1World.setBlock(par2 + x, par3 + y, par4 + z, 0, 0, 2);
                        }
                    }
                }
            }
            */

            yyy = 0;
        }

        if (yyy == 2)
        {
            for (int x = -80; x <= 80; ++x)
            {
                for (int z = -80; z <= 80; ++z)
                {
                    for (int y = -10; y <= 80; ++y)
                    {
                        if (par1World.getBlock(par2 + x, par3 + y, par4 + z) == this)
                        {
                            //par1World.destroyBlock(par2+x, par3+y, par4+z, true);
                            par1World.setBlockToAir(par2 + x, par3 + y, par4 + z);
                        }
                    }
                }
            }

            yyy = 0;
        }

        //par1World.destroyBlock(par2, par3, par4, true);
        //par1World.destroyBlock(par2, par3, par4, true);
        /*if(par5Random.nextInt(100) == 0)
        {
           par1World.destroyBlock(par2, par3, par4, true);
        }*/
        /*if(par5Random.nextInt(10000) == 0)
        {
        	for (int x = -80; x <= 80; ++x)
           	{
               	for (int z = -80; z <= 80; ++z)
               	{
               		for (int y = -10; y <= 40; ++y)
               		{
               			if(par1World.getBlockId(par2+x, par3+y, par4+z)==DqmItemList.Shoumetu.blockID)
               			{
               				//par1World.destroyBlock(par2+x, par3+y, par4+z, true);
               				par1World.setBlock(par2+x, par3+y, par4+z, 0, 0, 2);
               			}
               		}
               	}
           	}
        }*/
        //par1World.destroyBlock(par2, par3, par4, true);
        //par1World.setBlock(par2, par3, par4, 0);
    }
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }

    //ブロックを壊したら
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
/*
    	for (int x = -80; x <= 80; ++x)
        {
            for (int z = -80; z <= 80; ++z)
            {
                for (int y = -10; y <= 40; ++y)
                {
                    if (par1World.getBlockId(par2 + x, par3 + y, par4 + z) == DqmItemList.Shoumetu.blockID)
                    {
                        par1World.setBlock(par2 + x, par3 + y, par4 + z, 0, 0, 2);
                        //par1World.destroyBlock(par2+x, par3+y, par4+z, true);
                    }
                }
            }
        }
*/
        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }
    //アイテム消滅*******************************
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	/*
    	if (!(par5Entity instanceof EntityPlayer || par5Entity instanceof DqmEntityTameable))
        {

        	if(par5Entity instanceof DqmEntityAMobBoss || par5Entity instanceof DqmEntityARareMob)
        	{
        		par5Entity.setDead();
        	}else
        	{
        		par5Entity.attackEntityFrom(DamageSource.outOfWorld, 1);
        	}
        }
*/
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }
    //******************************************

    public int quantityDropped(Random random)
    {
        return 0; //idDropedでドロップする数を設定
    }
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
    public boolean isOpaqueCube()
    {
        return false;
    }
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return !super.canPlaceBlockAt(par1World, par2, par3, par4) ? false : this.canBlockStay(par1World, par2, par3, par4);
    }
    public void setmmm(int par1)
    {
        this.mmm = this.mmm + par1;
    }
    /*public int getRenderType()
    {
        return -1;
    }*/

}
