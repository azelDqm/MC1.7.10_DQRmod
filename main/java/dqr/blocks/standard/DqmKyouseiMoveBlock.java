package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DqmKyouseiMoveBlock extends Block
{
    //クラス本体。Blockクラスを継承する
	private int point; //N=0 S =1 E=2 W=3

    public DqmKyouseiMoveBlock(int i) //ブロックの基本設定
    {
        super(Material.iron); //材質を土に
        point = i;
    }

    public int quantityDropped(Random random)
    {
        return 1; //idDropedでドロップする数を設定
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if (par5Entity instanceof EntityPlayer)
        {
            EntityPlayer ep = (EntityPlayer)par5Entity;

            switch(this.point)
            {
	            case 0: ep.motionZ = -0.7; break;
	            case 1: ep.motionZ = 0.7; break;
	            case 2: ep.motionX = 0.7;; break;
	            case 3: ep.motionX = -0.7; break;
            }

            /*

            ep.motionY = 3;
            DQR.func.addPotionEffect2(ep, new PotionEffect(Potion.Subayasa.id, 20*3, 0));*/
        }
    }

    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }
}
