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

public class DqmWorldGenSword2 implements IWorldGenerator
{
    public DqmWorldGenSword2(boolean b) {	}
    public DqmWorldGenSword2() {}
    public void setScale(int i, int j, int k) {	}

    @Override
    public void generate(Random rand, int par1, int par2, World par3World, IChunkProvider par4IChunkProvider, IChunkProvider par5IChunkProvider)
    {
        int xxx = par1 * 16 + rand.nextInt(16);
        int zzz = par2 * 16 + rand.nextInt(16);
        int yyy;

        if(!DQR.conf.cfg_gen_Sword2_Map.containsKey((int)par3World.provider.dimensionId))
        {
        	return;
        }

        if(par3World.provider.dimensionId == -1)
        {
        	if(rand.nextInt(2) == 0)
        	{
        		yyy = DQR.func.getHeightValue2(par3World, xxx, zzz, 20, 120);
            	//System.out.println("RUN:" + y + "/" + x + "/" + z);
        	}else
        	{
        		yyy = DQR.func.getHeightValue2(par3World, xxx, zzz, 120, 20);
        		//System.out.println("RUN:" + y + "/" + x + "/" + z);
        	}
        	if(yyy < 0)
        	{
        		return;
        	}
        }else
        {
        	yyy = par3World.getHeightValue(xxx, zzz);
        }
        int ran1 = rand.nextInt(10000);

        Block topBlock = par3World.getBiomeGenForCoords(xxx, zzz).topBlock;
        if(topBlock.getMaterial().isLiquid())
        {
        	topBlock = Blocks.air;
        }

        if (ran1 >= 9995 && (par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.grass ||
        					 par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.sand ||
        					 par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.netherrack ||
        					 par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.end_stone ||
          				     (topBlock != Blocks.air && par3World.getBlock(xxx, yyy - 1, zzz) == topBlock)))
        {

            for (int x = -2; x <= 2; ++x)
            {
                for (int z = -2; z <= 2; ++z)
                {
                    for (int y = 0; y <= 4; ++y)
                    {
                        par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                    }
                }
            }

            int dim = par3World.provider.dimensionId;
            Block baseBlock = Blocks.air;
            Block daizaBlock = Blocks.air;
            Block underBlock = par3World.getBlock(xxx, yyy - 1, zzz);
            if(dim == 0)
            {
            	baseBlock = Blocks.flowing_water;
            	daizaBlock = DQDecorates.DqmBlockDaizaI;
            }else if(dim == -1)
            {
            	baseBlock = Blocks.flowing_lava;
            	daizaBlock = DQDecorates.DqmBlockDaizaQ;
            }else
            {
            	baseBlock = DQBlocks.DqmBlockToramanaYuka;
            	if(dim == 1)
            	{
            		daizaBlock = DQDecorates.DqmBlockDaizaO;
            	}else
            	{
            		daizaBlock = DQDecorates.DqmBlockDaizaG;
            	}
            }

            for (int x = -2; x <= 2; ++x)
            {
                for (int z = -2; z <= 2; ++z)
                {
                    par3World.setBlock(xxx + x, yyy - 1, zzz + z, underBlock, 0, 2);
                }
            }

            for (int x = -1; x <= 1; ++x)
            {
                for (int z = -1; z <= 1; ++z)
                {
                    par3World.setBlock(xxx + x, yyy, zzz + z, baseBlock, 0, 2);
                }
            }


            for (int x = -2; x <= 2; ++x)
            {
                par3World.setBlock(xxx + x, yyy, zzz + 2, Blocks.quartz_stairs, 3, 2);
            }

            for (int x = -2; x <= 2; ++x)
            {
                par3World.setBlock(xxx + x, yyy, zzz - 2, Blocks.quartz_stairs, 2, 2);
            }

            for (int z = -2; z <= 2; ++z)
            {
                par3World.setBlock(xxx + 2, yyy, zzz + z, Blocks.quartz_stairs, 1, 2);
            }

            for (int z = -2; z <= 2; ++z)
            {
                par3World.setBlock(xxx - 2, yyy, zzz + z, Blocks.quartz_stairs, 0, 2);
            }

            par3World.setBlock(xxx, yyy, zzz, daizaBlock, 0, 2);
            par3World.setBlock(xxx, yyy + 1, zzz, DQDecorates.DqmBlockSword2Mob, 0, 2);

        }
    }
}
