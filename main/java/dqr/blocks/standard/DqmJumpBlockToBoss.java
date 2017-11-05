package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class DqmJumpBlockToBoss extends Block
{
    //クラス本体。Blockクラスを継承する



    public DqmJumpBlockToBoss() //ブロックの基本設定
    {
        super(Material.wood); //材質を土に
    }


    public int quantityDropped(Random random)
    {
        return 1; //idDropedでドロップする数を設定
    }
    private double TeleportPosR[];
    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;		   //ランダムint
        return ret;
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {

        if (par5Entity instanceof EntityPlayer)
        {
            EntityPlayer ep = (EntityPlayer)par5Entity;
            ep.fallDistance = 0;
            for (int y = 1; y <= 15; ++y)
            {
                par1World.setBlockToAir(par2, par3 + y, par4);
            }

            ep.motionY = 1.7F;

            //if(!(ep.isPotionActive(Potion.Boss)))
            /*
            if (!par1World.isRemote && ep.bosswaki1 == 0)
            {
                ep.worldObj.playSoundAtEntity(ep, "DQM_Sound.Inoti", 1.0F, 1.0F);

                for (int x = 0; x <= 1; ++x)
                {
                    int ranboss = getRandom(23, 0);
                    int ranboss2 = getRandom(8, -8);

                    if (ranboss == 0)
                    {
                        DqmEntitySirubadebiru entitysilverfish = new DqmEntitySirubadebiru(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 1)
                    {
                        DqmEntitySaikuropusu entitysilverfish = new DqmEntitySaikuropusu(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 2)
                    {
                        DqmEntityMagematango entitysilverfish = new DqmEntityMagematango(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 3)
                    {
                        DqmEntityMagumaron entitysilverfish = new DqmEntityMagumaron(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 4)
                    {
                        DqmEntityBaburuking entitysilverfish = new DqmEntityBaburuking(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 5)
                    {
                        DqmEntityKuinsuraimu entitysilverfish = new DqmEntityKuinsuraimu(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 6)
                    {
                        DqmEntitySuraimumadyura entitysilverfish = new DqmEntitySuraimumadyura(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 7)
                    {
                        DqmEntityBoureikensi entitysilverfish = new DqmEntityBoureikensi(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 8)
                    {
                        DqmEntityPuyon entitysilverfish = new DqmEntityPuyon(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 9)
                    {
                        DqmEntityPombom entitysilverfish = new DqmEntityPombom(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 10)
                    {
                        DqmEntitySodofantomu entitysilverfish = new DqmEntitySodofantomu(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 11)
                    {
                        DqmEntityKisudragon entitysilverfish = new DqmEntityKisudragon(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 12)
                    {
                        DqmEntityBatorurex entitysilverfish = new DqmEntityBatorurex(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 13)
                    {
                        DqmEntityDasudragon entitysilverfish = new DqmEntityDasudragon(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 14)
                    {
                        DqmEntityDragonraida entitysilverfish = new DqmEntityDragonraida(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 15)
                    {
                        DqmEntityGoldman entitysilverfish = new DqmEntityGoldman(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 16)
                    {
                        DqmEntityDgizumo entitysilverfish = new DqmEntityDgizumo(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }


                    if (ranboss == 17)
                    {
                    	if(DQR.killKiramasin == 1)
                    	{
	                        DqmEntityKiramasin entitysilverfish = new DqmEntityKiramasin(par1World);
	                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
	                        par1World.spawnEntityInWorld(entitysilverfish);
                    	}else
                    	{
                            DqmEntitySuraimumadyura entitysilverfish = new DqmEntitySuraimumadyura(par1World);
                            entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                            par1World.spawnEntityInWorld(entitysilverfish);
                    	}
                    }

                    if (ranboss == 18)
                    {
                        DqmEntityAnkokumajin entitysilverfish = new DqmEntityAnkokumajin(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 19)
                    {
                        DqmEntityPandorabox entitysilverfish = new DqmEntityPandorabox(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 20)
                    {
                        DqmEntityMajikaruhatto entitysilverfish = new DqmEntityMajikaruhatto(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 21)
                    {
                        DqmEntityHotatewarabi entitysilverfish = new DqmEntityHotatewarabi(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 22)
                    {
                        DqmEntityKirapan2 entitysilverfish = new DqmEntityKirapan2(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }

                    if (ranboss == 23)
                    {
                        DqmEntityMagemomonja entitysilverfish = new DqmEntityMagemomonja(par1World);
                        entitysilverfish.setLocationAndAngles(par2 + ranboss2, par3 + 15, par4 + ranboss2, 0.0F, 0.0F);
                        par1World.spawnEntityInWorld(entitysilverfish);
                    }
                }

                ep.bosswaki1 = 1;

            }
                            */
        }
    }
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)p_149668_2_ + f), (double)p_149668_3_, (double)((float)p_149668_4_ + f), (double)((float)(p_149668_2_ + 1) - f), (double)((float)(p_149668_3_ + 1) - f), (double)((float)(p_149668_4_ + 1) - f));
    }
}
