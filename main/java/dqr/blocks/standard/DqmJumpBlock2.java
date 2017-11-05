package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import dqr.api.potion.DQPotionPlus;

public class DqmJumpBlock2 extends Block
{
    //クラス本体。Blockクラスを継承する

    public DqmJumpBlock2() //ブロックの基本設定
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
            EntityPlayer ep = (EntityPlayer)par5Entity;
            ep.fallDistance = 0;
            ep.motionY = 1.3;
            ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 20 * 5, 0));
        }
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }
}
