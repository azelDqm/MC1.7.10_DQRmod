package dqr.addons;

import java.util.Random;

import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import dqr.DQR;
import dqr.api.Blocks.DQOres;

public class DqrAddonGalacticraftOre  implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
		IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		int dim = world.provider.dimensionId;


		if(dim == DQR.addons.addonGalacticraft.dimIdMoon)
		{
			generateSurfaceMoonOre(world, random, chunkX * 16, chunkZ * 16 ,GCBlocks.blockMoon);
		}else if(dim == DQR.addons.addonGalacticraft.dimIdMars)
		{
			generateSurfaceMarsOre(world, random, chunkX * 16, chunkZ * 16 ,MarsBlocks.marsBlock);
		}else if(dim == DQR.addons.addonGalacticraft.dimIdAsteroid)
		{
			generateSurfaceMarsOre(world, random, chunkX * 16, chunkZ * 16 ,AsteroidBlocks.blockBasic);
		}
	}


    public void generateSurfaceMoonOre(World var1, Random var2, int var3, int var4, Block baseBlock)
    {

    	//Block baseBlock = Block.getBlockFromName(DQR.conf.cfg_generateOre2.get(dimId));

    	if(baseBlock == null)
    	{
    		//System.out.println("BLOCKNAME:");
    		return;
    	}

        int k = var3 * 16;
        int l = var4 * 16;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;

        WorldGenMinable OreMoon = new WorldGenMinable(DQOres.BlockOreMoon, 12, baseBlock);

        for (k1 = 0; k1 < 6; ++k1)
        {
            l1 = k + var2.nextInt(16);
            i2 = var2.nextInt(108) + 10;
            j2 = l + var2.nextInt(16);
            OreMoon.generate(var1, var2, l1, i2, j2);
        }
    }

    public void generateSurfaceMarsOre(World var1, Random var2, int var3, int var4, Block baseBlock)
    {

    	//Block baseBlock = Block.getBlockFromName(DQR.conf.cfg_generateOre2.get(dimId));

    	if(baseBlock == null)
    	{
    		//System.out.println("BLOCKNAME:");
    		return;
    	}

        int k = var3 * 16;
        int l = var4 * 16;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;

        WorldGenMinable OreYougansekinokakera = new WorldGenMinable(DQOres.BlockOreYougansekinokakera, 12, baseBlock);

        for (k1 = 0; k1 < 6; ++k1)
        {
            l1 = k + var2.nextInt(16);
            i2 = var2.nextInt(108) + 10;
            j2 = l + var2.nextInt(16);
            OreYougansekinokakera.generate(var1, var2, l1, i2, j2);
        }



        for (k1 = 0; k1 < 6; ++k1)//鉄鉱の原石
        {
            l1 = var3 + var2.nextInt(16);
            i2 = var2.nextInt(25) + 20;
            j2 = var4 + var2.nextInt(16);
            //(new DqmWorldGenOre(DQOres.BlockOreTekkouseki, 8, 0)).generate(var1, var2, var6, var7, var8);
            new WorldGenMinable(DQOres.BlockOreHosinokakera, 12, baseBlock).generate(var1, var2, l1, i2, j2);
        }
    }

    public void generateSurfaceAsteroidOre(World var1, Random var2, int var3, int var4, Block baseBlock)
    {

    	//Block baseBlock = Block.getBlockFromName(DQR.conf.cfg_generateOre2.get(dimId));

    	if(baseBlock == null)
    	{
    		//System.out.println("BLOCKNAME:");
    		return;
    	}

        int k = var3 * 16;
        int l = var4 * 16;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;

        for (k1 = 0; k1 < 6; ++k1)//鉄鉱の原石
        {
            l1 = var3 + var2.nextInt(16);
            i2 = var2.nextInt(25) + 20;
            j2 = var4 + var2.nextInt(16);
            //(new DqmWorldGenOre(DQOres.BlockOreTekkouseki, 8, 0)).generate(var1, var2, var6, var7, var8);
            new WorldGenMinable(DQOres.BlockOreTekkouseki, 12, baseBlock).generate(var1, var2, l1, i2, j2);
        }
    }
}
