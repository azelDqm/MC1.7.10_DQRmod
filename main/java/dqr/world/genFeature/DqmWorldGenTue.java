package dqr.world.genFeature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import dqr.DQR;
import dqr.api.Blocks.DQDecorates;

public class DqmWorldGenTue implements IWorldGenerator
{
    public DqmWorldGenTue(boolean b) {}
    public DqmWorldGenTue() {}
    public void setScale(int i, int j, int k) {}
    public void generate(World par1World, Random rand, int xPos, int yPos, int zPos) {}

    @Override
    public void generate(Random rand2, int par1, int par2, World par3World, IChunkProvider par4IChunkProvider, IChunkProvider par5IChunkProvider)
    {
    	Random rand = new Random();
        int x = par1 * 16 + rand.nextInt(16);
        int z = par2 * 16 + rand.nextInt(16);
        int y;

        if(!DQR.conf.cfg_gen_Tue_Map.containsKey((int)par3World.provider.dimensionId))
        {
        	return;
        }

        if(par3World.provider.dimensionId == -1)
        {
        	if(rand.nextInt(2) == 0)
        	{
        		y = DQR.func.getHeightValue2(par3World, x, z, 20, 120);
            	//System.out.println("RUN:" + y + "/" + x + "/" + z);
        	}else
        	{
        		y = DQR.func.getHeightValue2(par3World, x, z, 120, 20);
        		//System.out.println("RUN:" + y + "/" + x + "/" + z);
        	}
        	if(y < 0)
        	{
        		return;
        	}
        }else
        {
        	y = par3World.getHeightValue(x, z);
        }
        int ran = rand.nextInt(1000);

        Block topBlock = par3World.getBiomeGenForCoords(x, z).topBlock;
        if(topBlock.getMaterial().isLiquid())
        {
        	topBlock = Blocks.air;
        }


        if (ran >= 980  && (par3World.getBlock(x, y - 1, z) == Blocks.grass ||
        					par3World.getBlock(x, y - 1, z) == Blocks.sand ||
        					par3World.getBlock(x, y - 1, z) == Blocks.netherrack ||
        					par3World.getBlock(x, y - 1, z) == Blocks.end_stone ||
        					(topBlock != Blocks.air && par3World.getBlock(x, y - 1, z) == topBlock)))
        {
            par3World.setBlock(x, y, z, DQDecorates.DqmBlockTue, rand.nextInt(4), 2);
        }
    }
}
