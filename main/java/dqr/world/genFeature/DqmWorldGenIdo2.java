package dqr.world.genFeature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.api.Blocks.DQDecorates;
import dqr.entity.npcEntity.npc.DqmEntityNPCMedalking;

public class DqmWorldGenIdo2 implements IWorldGenerator
{
    public DqmWorldGenIdo2(boolean b) {	}
    public DqmWorldGenIdo2() {}
    public void setScale(int i, int j, int k) {	}

    @Override
    public void generate(Random rand, int par1, int par2, World par3World, IChunkProvider par4IChunkProvider, IChunkProvider par5IChunkProvider)
    {
        int xxx = par1 * 16 + rand.nextInt(16);
        int zzz = par2 * 16 + rand.nextInt(16);
        int yyy = par3World.getHeightValue(xxx, zzz);
        int ran1 = rand.nextInt(10000);
        int ran2 = rand.nextInt(2);
        //int ran3 = rand.nextInt(2);
        //int ran4 = rand.nextInt(2);
        //int ran5 = rand.nextInt(3);
        //int ran6 = rand.nextInt(3);
        //int ran7 = rand.nextInt(2);
        //int ran8 = rand.nextInt(3);
        //int ran9 = rand.nextInt(4);
        //int ran10 = rand.nextInt(5);
        //int ran11 = rand.nextInt(3);
        //int ran12 = rand.nextInt(50);

        /*
        if(par3World.provider.dimensionId != 0)
        {
        	return;
        }
        */
        if(!DQR.conf.cfg_gen_Ido2_a.contains((int)par3World.provider.dimensionId))
        {
        	return;
        }

        Block topBlock = par3World.getBiomeGenForCoords(xxx, zzz).topBlock;
        if(topBlock.getMaterial().isLiquid())
        {
        	topBlock = Blocks.air;
        }

        //if (ran1 >= 9950 && (par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.grass || par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.sand))
        if (ran1 >= 9970 && (par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.grass ||
        					 par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.sand  ||
                			 par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.netherrack ||
                			 par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.end_stone||
        					 (topBlock != Blocks.air && par3World.getBlock(xxx, yyy - 1, zzz) == topBlock)))
        {
        	//System.out.println("X" + xxx +  "/Y" + yyy +  "/Z" + zzz);

            for (int x = -1; x <= 1; ++x)
            {
                for (int z = -1; z <= 1; ++z)
                {
                    for (int y = 0; y <= 2; ++y)
                    {
                        par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                    }
                }
            }

            if (ran2 == 0)
            {
                par3World.setBlock(xxx - 1, yyy, zzz, DQDecorates.DqmBlockIdo, 0, 2);
            }

            if (ran2 == 1)
            {
                par3World.setBlock(xxx - 1, yyy, zzz, DQDecorates.DqmBlockIdooke, 0, 2);
            }

            for (int y = -32; y <= -1; ++y)
            {
                par3World.setBlock(xxx, yyy + y, zzz, Blocks.air, 0, 2);
            }

            for (int x = -5; x <= 5; ++x)
            {
                for (int z = -5; z <= 5; ++z)
                {
                	if(x != 0 && z != 0)
                	{
                		par3World.setBlock(xxx + x, yyy - 30, zzz + z, DQBlocks.DqmBlockKowareru6, 0, 2);
                	}
                }
            }

            for (int x = -5; x <= 5; ++x)
            {
                for (int z = -5; z <= 5; ++z)
                {
                    for (int y = -35; y <= -31; ++y)
                    {
                    	if(y % 2 == 0)
                    	{
                    		par3World.setBlock(xxx + x, yyy + y, zzz + z, DQBlocks.DqmBlockKowareru6, 0, 2);
                    	}else
                    	{
                    		par3World.setBlock(xxx + x, yyy + y, zzz + z, DQBlocks.DqmBlockKowareru7, 0, 2);
                    	}
                    }
                }
            }


            for (int x = -5; x <= 5; ++x)
            {
                for (int z = -5; z <= 5; ++z)
                {
                	par3World.setBlock(xxx + x, yyy - 36, zzz + z, DQBlocks.DqmBlockKowareru9, 0, 2);
                }
            }

            for (int x = -1; x <= 1; ++x)
            {
                for (int y = -36; y <= -33; ++y)
                {
                	if(y == -36)
                	{
                		if(x == 0)
                		{
                			par3World.setBlock(xxx + x, yyy + y, zzz + 5, Blocks.glowstone, 0, 2);
                		}else
                		{
                			par3World.setBlock(xxx + x, yyy + y, zzz + 5, DQBlocks.DqmBlockKowareru9, 0, 2);
                		}
                	}else
                	{
                		par3World.setBlock(xxx + x, yyy + y, zzz + 5, Blocks.air, 0, 2);
                    	if(y % 2 == 0)
                    	{
                    		par3World.setBlock(xxx + x, yyy + y, zzz + 6, DQBlocks.DqmBlockKowareru6, 0, 2);
                    	}else
                    	{
                    		par3World.setBlock(xxx + x, yyy + y, zzz + 6, DQBlocks.DqmBlockKowareru7, 0, 2);
                    	}
                	}
                }
            }

            for (int x = -2; x <= 2; ++x)
            {
                for (int z = -2; z <= 2; ++z)
                {
                    for (int y = -36; y <= -35; ++y)
                    {
                        par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                    }
                }
            }
            for (int x = -5; x <= 5; ++x)
            {
                for (int z = -5; z <= 5; ++z)
                {
                    for (int y = -37; y <= -37; ++y)
                    {
                        par3World.setBlock(xxx + x, yyy + y, zzz + z, DQBlocks.DqmBlockKowareru5, 0, 2);
                    }
                }
            }


            for (int x = -4; x <= 4; ++x)
            {
                for (int z = -4; z <= 4; ++z)
                {
                    for (int y = -35; y <= -31; ++y)
                    {
                        par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                    }
                }
            }

            //par3World.setBlock(xxx + 5, yyy + y, zzz + 5, Blocks.air, 0, 2);

            par3World.setBlock(xxx + 4, yyy - 35, zzz + 4, DQDecorates.DqmBlockTaimatu2, 0, 2);
            par3World.setBlock(xxx - 4, yyy - 35, zzz + 4, DQDecorates.DqmBlockTaimatu2, 0, 2);
            par3World.setBlock(xxx + 4, yyy - 35, zzz - 4, DQDecorates.DqmBlockTaimatu2, 0, 2);
            par3World.setBlock(xxx - 4, yyy - 35, zzz - 4, DQDecorates.DqmBlockTaimatu2, 0, 2);

            par3World.setBlock(xxx - 1, yyy - 35, zzz + 5, DQDecorates.DqmBlockTaimatu2, 0, 2);
            par3World.setBlock(xxx + 1, yyy - 35, zzz + 5, DQDecorates.DqmBlockTaimatu2, 0, 2);

            par3World.setBlock(xxx + 1, yyy - 36, zzz, Blocks.flowing_water, 0, 2);
            par3World.setBlock(xxx - 1, yyy - 36, zzz, Blocks.flowing_water, 0, 2);
            par3World.setBlock(xxx, yyy - 36, zzz + 1, Blocks.flowing_water, 0, 2);
            par3World.setBlock(xxx, yyy - 36, zzz - 1, Blocks.flowing_water, 0, 2);
            par3World.setBlock(xxx, yyy - 35, zzz - 3, DQBlocks.DqmBlockJampBlock, 0, 2);

	        DqmEntityNPCMedalking entitysilverfish = new DqmEntityNPCMedalking(par3World);
	        entitysilverfish.setLocationAndAngles(xxx , yyy -34, zzz + 5, 0.0F, 0.0F);
	        par3World.spawnEntityInWorld(entitysilverfish);
        }
    }

}
