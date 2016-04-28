package dqr.world.genFeature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.api.Blocks.DQDecorates;
import dqr.blocks.mobSpawner.tileEntity.DqmTileEntityMobSpawner;

public class DqmWorldGenIdo implements IWorldGenerator
{
    public DqmWorldGenIdo(boolean b) {	}
    public DqmWorldGenIdo() {}
    public void setScale(int i, int j, int k) {	}

    @Override
    public void generate(Random rand, int par1, int par2, World par3World, IChunkProvider par4IChunkProvider, IChunkProvider par5IChunkProvider)
    {
        int xxx = par1 * 16 + rand.nextInt(16);
        int zzz = par2 * 16 + rand.nextInt(16);
        int yyy = par3World.getHeightValue(xxx, zzz);
        int ran1 = rand.nextInt(10000);
        int ran2 = rand.nextInt(2);
        int ran3 = rand.nextInt(2);
        int ran4 = rand.nextInt(2);
        int ran5 = rand.nextInt(3);
        int ran6 = rand.nextInt(3);
        int ran7 = rand.nextInt(2);
        int ran8 = rand.nextInt(3);
        int ran9 = rand.nextInt(4);
        int ran10 = rand.nextInt(5);
        int ran11 = rand.nextInt(3);
        int ran12 = rand.nextInt(50);

        if(par3World.provider.dimensionId != 0)
        {
        	return;
        }

        Block topBlock = par3World.getBiomeGenForCoords(xxx, zzz).topBlock;
        if(topBlock.getMaterial().isLiquid())
        {
        	topBlock = Blocks.air;
        }

        if (ran1 >= 9950 && (par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.grass ||
        					 par3World.getBlock(xxx, yyy - 1, zzz) == Blocks.sand  ||
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

            for (int x = -2; x <= 2; ++x)
            {
                for (int z = -4; z <= 4; ++z)
                {
                    for (int y = -35; y <= -32; ++y)
                    {
                        par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                    }
                }
            }

            for (int x = -4; x <= 4; ++x)
            {
                for (int z = -2; z <= 2; ++z)
                {
                    for (int y = -35; y <= -32; ++y)
                    {
                        par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                    }
                }
            }

            for (int x = -3; x <= 3; ++x)
            {
                for (int z = -3; z <= 3; ++z)
                {
                    for (int y = -35; y <= -32; ++y)
                    {
                        par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
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

            if (ran12 >= 45)
            {
                if (ran11 == 0)
                {
                    par3World.setBlock(xxx, yyy - 35, zzz + 3, DQDecorates.DqmBlockSword, 0, 2);
                }

                if (ran11 == 1)
                {
                    par3World.setBlock(xxx, yyy - 35, zzz + 3, DQDecorates.DqmBlockSwordMob, 0, 2);
                }

                if (ran11 == 2)
                {
                    par3World.setBlock(xxx, yyy - 35, zzz + 3, DQDecorates.DqmBlockTue, 0, 2);
                }
            }

            if (ran12 <= 1)
            {
                if (ran11 == 0)
                {
                    par3World.setBlock(xxx, yyy - 35, zzz + 3, DQDecorates.DqmBlockSword2, 0, 2);
                }

                if (ran11 == 1)
                {
                    par3World.setBlock(xxx, yyy - 35, zzz + 3, DQDecorates.DqmBlockSword2Mob, 0, 2);
                }
            }

            par3World.setBlock(xxx + 1, yyy - 36, zzz, Blocks.flowing_water, 0, 2);
            par3World.setBlock(xxx - 1, yyy - 36, zzz, Blocks.flowing_water, 0, 2);
            par3World.setBlock(xxx, yyy - 36, zzz + 1, Blocks.flowing_water, 0, 2);
            par3World.setBlock(xxx, yyy - 36, zzz - 1, Blocks.flowing_water, 0, 2);
            par3World.setBlock(xxx, yyy - 35, zzz - 3, DQBlocks.DqmBlockJampBlock, 0, 2);

            if (ran3 == 0)
            {
                par3World.setBlock(xxx + 4, yyy - 35, zzz + 4, DQBlocks.DqmBlockMobSpawner, 0, 2);
                //DqmTileEntityMobSpawner tileentitymobspawner1 = (DqmTileEntityMobSpawner)par3World.getBlockTileEntity(xxx + 4, yyy - 35, zzz + 4);
                DqmTileEntityMobSpawner tileentitymobspawner1 = (DqmTileEntityMobSpawner)par3World.getTileEntity(xxx + 4, yyy - 35, zzz + 4);

                if (tileentitymobspawner1 != null)
                {
                	//tileentitymobspawner1.func_98049_a().setMobID(this.pickMobSpawner(rand));
            		if(rand.nextInt(2) == 0)
            		{
            			tileentitymobspawner1.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomNightName());
            		}else
            		{
            			tileentitymobspawner1.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomDayName());
            		}
                }
                else
                {
                    System.err.println("Failed to fetch mob spawner entity at (" + xxx + ", " + yyy + ", " + zzz + ")");
                }
            }

            if (ran4 == 0)
            {
                par3World.setBlock(xxx + 4, yyy - 35, zzz - 4, DQBlocks.DqmBlockMobSpawner, 0, 2);
                //TileEntityMobSpawner tileentitymobspawner2 = (TileEntityMobSpawner)par3World.getBlockTileEntity(xxx + 4, yyy - 35, zzz - 4);
                DqmTileEntityMobSpawner tileentitymobspawner2 = (DqmTileEntityMobSpawner)par3World.getTileEntity(xxx + 4, yyy - 35, zzz - 4);

                if (tileentitymobspawner2 != null)
                {
                    //tileentitymobspawner2.func_98049_a().setMobID(this.pickMobSpawner(rand));
            		if(rand.nextInt(2) == 0)
            		{
            			tileentitymobspawner2.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomNightName());
            		}else
            		{
            			tileentitymobspawner2.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomDayName());
            		}
                }
                else
                {
                    System.err.println("Failed to fetch mob spawner entity at (" + xxx + ", " + yyy + ", " + zzz + ")");
                }
            }

            if (ran5 == 0)
            {
                par3World.setBlock(xxx - 4, yyy - 35, zzz + 4, DQBlocks.DqmBlockMobSpawner, 0, 2);
                //TileEntityMobSpawner tileentitymobspawner3 = (TileEntityMobSpawner)par3World.getBlockTileEntity(xxx - 4, yyy - 35, zzz + 4);
                DqmTileEntityMobSpawner tileentitymobspawner3 = (DqmTileEntityMobSpawner)par3World.getTileEntity(xxx - 4, yyy - 35, zzz + 4);

                if (tileentitymobspawner3 != null)
                {
                    //tileentitymobspawner3.func_98049_a().setMobID(this.pickMobSpawner(rand));
            		if(rand.nextInt(2) == 0)
            		{
            			tileentitymobspawner3.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomNightName());
            		}else
            		{
            			tileentitymobspawner3.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomDayName());
            		}
                }
                else
                {
                    System.err.println("Failed to fetch mob spawner entity at (" + xxx + ", " + yyy + ", " + zzz + ")");
                }
            }

            if (ran6 == 0)
            {
                par3World.setBlock(xxx - 4, yyy - 35, zzz - 4, DQBlocks.DqmBlockMobSpawner, 0, 2);
                //TileEntityMobSpawner tileentitymobspawner4 = (TileEntityMobSpawner)par3World.getBlockTileEntity(xxx - 4, yyy - 35, zzz - 4);
                DqmTileEntityMobSpawner tileentitymobspawner4 = (DqmTileEntityMobSpawner)par3World.getTileEntity(xxx - 4, yyy - 35, zzz - 4);

                if (tileentitymobspawner4 != null)
                {
            		if(rand.nextInt(2) == 0)
            		{
            			tileentitymobspawner4.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomNightName());
            		}else
            		{
            			tileentitymobspawner4.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomDayName());
            		}
                }
                else
                {
                    System.err.println("Failed to fetch mob spawner entity at (" + xxx + ", " + yyy + ", " + zzz + ")");
                }
            }

            //チェスト
            TileEntityChest chest = null;
            TileEntityChest chest2 = null;
            TileEntityChest chest3 = null;
            TileEntityChest chest4 = null;
            if (ran7 == 0)
            {
                par3World.setBlock(xxx - 3, yyy - 35, zzz - 3, Blocks.chest, 0, 2);
                chest = (TileEntityChest)par3World.getTileEntity(xxx - 3, yyy - 35, zzz - 3);
            }

            if (ran8 == 0)
            {
                par3World.setBlock(xxx - 3, yyy - 35, zzz + 3, Blocks.chest, 0, 2);
                chest2 = (TileEntityChest)par3World.getTileEntity(xxx - 3, yyy - 35, zzz + 3);
            }

            if (ran9 == 0)
            {
                par3World.setBlock(xxx + 3, yyy - 35, zzz - 3, Blocks.chest, 0, 2);
                chest3 = (TileEntityChest)par3World.getTileEntity(xxx + 3, yyy - 35, zzz - 3);
            }

            if (ran10 == 0)
            {
                par3World.setBlock(xxx + 3, yyy - 35, zzz + 3, Blocks.chest, 0, 2);
                chest4 = (TileEntityChest)par3World.getTileEntity(xxx + 3, yyy - 35, zzz + 3);
            }

            if (chest != null)
            {
            	if(rand.nextInt(3) != 0)
            	{
            		DQR.randomItem.generateChestContentsRank1(rand, chest);
            	}else
            	{
            		DQR.randomItem.generateChestContentsRank2(rand, chest);
            	}
            }

            if (chest2 != null)
            {
            	if(rand.nextInt(3) != 0)
            	{
            		DQR.randomItem.generateChestContentsRank1(rand, chest2);
            	}else
            	{
            		DQR.randomItem.generateChestContentsRank2(rand, chest2);
            	}
            }

            if (chest3 != null)
            {
            	if(rand.nextInt(3) != 0)
            	{
            		DQR.randomItem.generateChestContentsRank1(rand, chest3);
            	}else
            	{
            		DQR.randomItem.generateChestContentsRank2(rand, chest3);
            	}
            }

            if (chest4 != null)
            {
            	if(rand.nextInt(3) != 0)
            	{
            		DQR.randomItem.generateChestContentsRank1(rand, chest4);
            	}else
            	{
            		DQR.randomItem.generateChestContentsRank2(rand, chest4);
            	}
            }
        }
    }

}
