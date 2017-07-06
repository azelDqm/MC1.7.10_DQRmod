package dqr.world.genFeature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.DungeonHooks;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.blocks.mobSpawner.tileEntity.DqmTileEntityMobSpawner;

public class DqmWorldGenDungeonOver extends WorldGenerator
{

    private static final String __OBFID = "CL_00000425";

    public boolean generate(World world, Random random2, int xPos, int yPos, int zPos)
    {
    	Random random = new Random();

		int xWidth = 6 + random.nextInt(3) * 2;
		int zWidth = 6 + random.nextInt(3) * 2;


    	if(world.isAirBlock(xPos, yPos, zPos) || world.isAirBlock(xPos + xWidth, yPos + 5, zPos + zWidth) ||
    		(world.getBlock(xPos, yPos, zPos).getMaterial() == Material.water && world.getBlock(xPos + xWidth, yPos + 5, zPos + zWidth).getMaterial() == Material.water))
		{
			return false;
		}
		//if(this.isLiquidInStructureBoundingBox(world, structureboundingbox)) {
		//	return false;
		//}
		//
		// 占有範囲(structureboundingbox)内の指定範囲を指定ブロック＆メタデータで埋める
		// 占有範囲内の指定範囲は占有範囲原点を基準として(0,0,0)-(4,10,4)の範囲
		//this.fillWithMetadataBlocks(world, structureboundingbox, 0, 0, 0, this.xWidth, 6, this.zWidth, Blocks.stonebrick, 0, Blocks.stone, 0, false);
		//this.fillWithMetadataBlocks(world, structureboundingbox, 5, 11, 5, 9, 21, 9, Blocks.stone, 0, Blocks.air, 0, false);

		// 占有範囲(structureboundingbox)内の指定範囲を空気ブロックで埋める
		// 占有範囲内の指定範囲は占有範囲原点を基準として(1,1,1)-(3,9,3)の範囲
		// 要するに中をくりぬいてるってことです

    	for(int cntY = 1; cntY <= 4; cntY++)
    	{
    		for(int cntX = 0; cntX <= xWidth; cntX ++)
    		{
    			for(int cntZ = 0; cntZ <= zWidth; cntZ++)
    			{
    				world.setBlock(xPos + cntX, yPos + cntY, zPos + cntZ, Blocks.air, 0, 2);
    			}
    		}
    	}

		for(int cntY = 1; cntY <= 4; cntY++)
		{
			for(int cntX = 0; cntX <= xWidth; cntX ++)
			{
				int blockSet = random.nextInt(21);
				int metaSet = 0;
				Block blc = Blocks.stonebrick;
				if(blockSet < 5)
				{
					metaSet = 0;
				}else if(blockSet < 10)
				{
					metaSet = 1;
				}else if(blockSet < 15)
				{
					metaSet = 2;
				}else if(blockSet < 20)
				{
					metaSet = 3;
				}else
				{
					switch(random.nextInt(3))
					{
						case 0: blc = DQBlocks.DqmBlockHako11; break;
						case 1: blc = DQBlocks.DqmBlockHako12; break;
						case 2: blc = DQBlocks.DqmBlockHako13; break;
					}
				}

				world.setBlock(xPos + cntX, yPos + cntY, zPos, blc, metaSet, 2);
				world.setBlock(xPos + cntX, yPos + cntY, zPos + zWidth, blc, metaSet, 2);

				//this.placeBlockAtCurrentPosition(world, blc, metaSet, cntX, cntY, 0, structureboundingbox);
				//this.placeBlockAtCurrentPosition(world, blc, metaSet, cntX, cntY, this.zWidth, structureboundingbox);
			}

			for(int cntZ = 0; cntZ <= zWidth; cntZ ++)
			{
				int blockSet = random.nextInt(21);
				int metaSet = 0;
				Block blc = Blocks.stonebrick;
				if(blockSet < 5)
				{
					metaSet = 0;
				}else if(blockSet < 10)
				{
					metaSet = 1;
				}else if(blockSet < 15)
				{
					metaSet = 2;
				}else if(blockSet < 20)
				{
					metaSet = 3;
				}else
				{
					switch(random.nextInt(3))
					{
						case 0: blc = DQBlocks.DqmBlockHako11; break;
						case 1: blc = DQBlocks.DqmBlockHako12; break;
						case 2: blc = DQBlocks.DqmBlockHako13; break;
					}
				}

				world.setBlock(xPos, yPos + cntY, zPos + cntZ, blc, metaSet, 2);
				world.setBlock(xPos + xWidth, yPos + cntY, zPos + cntZ, blc, metaSet, 2);
				//this.placeBlockAtCurrentPosition(world, blc, metaSet, 0, cntY, cntZ, structureboundingbox);
				//this.placeBlockAtCurrentPosition(world, blc, metaSet, this.xWidth, cntY, cntZ, structureboundingbox);
			}
		}

		for(int cntZ = 0; cntZ <= zWidth; cntZ ++)
		{
			for(int cntX = 0; cntX <= xWidth; cntX ++)
			{
				int blockSet = random.nextInt(21);
				int metaSet = 0;
				Block blc = Blocks.stonebrick;
				if(blockSet < 5)
				{
					metaSet = 0;
				}else if(blockSet < 10)
				{
					metaSet = 1;
				}else if(blockSet < 15)
				{
					metaSet = 2;
				}else if(blockSet < 20)
				{
					metaSet = 3;
				}else
				{
					switch(random.nextInt(3))
					{
						case 0: blc = DQBlocks.DqmBlockHako11; break;
						case 1: blc = DQBlocks.DqmBlockHako12; break;
						case 2: blc = DQBlocks.DqmBlockHako13; break;
					}
				}

				world.setBlock(xPos + xWidth, yPos, zPos + cntZ, blc, metaSet, 2);
				world.setBlock(xPos + xWidth, yPos + 5, zPos + cntZ, blc, metaSet, 2);
				//this.placeBlockAtCurrentPosition(world, blc, metaSet, cntX, 0, cntZ, structureboundingbox);
				//this.placeBlockAtCurrentPosition(world, blc, metaSet, cntX, 5, cntZ, structureboundingbox);
			}
		}

		int offX = (xWidth / 2) + xPos;
		int offY = 1 + yPos;
		int offZ = (zWidth / 2) + zPos;
		//this.placeBlockAtCurrentPosition(world, DQBlocks.DqmBlockMobSpawner, 0, this.xWidth / 2, 1, this.zWidth / 2, structureboundingbox);
		//System.out.println("DEBUG = " + offX + "/" + offY + "/" + offZ);
		world.setBlock(offX, offY, offZ, DQBlocks.DqmBlockMobSpawner);
		//world.setBlock(offX, 65, offZ, Blocks.mob_spawner);
		//TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(offX, 65, offZ);
		DqmTileEntityMobSpawner tileentitymobspawner = (DqmTileEntityMobSpawner)world.getTileEntity(offX, offY, offZ);
		//System.out.println(DQR.randomMob.getRandomDay(world).getCommandSenderName().replace("entity.",""));
        if (tileentitymobspawner != null)
        {
            //tileentitymobspawner.func_145881_a().setEntityName(this.pickMobSpawner(new Random()));
        	//tileentitymobspawner.func_145881_a().setEntityName("DQMIIINext.Obakekinoko");
        	//tileentitymobspawner.func_145881_a().setEntityName("Enderman");

        	if(offY > 40)
        	{
        		tileentitymobspawner.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomDayName());
        	}else if (offY > 30)
        	{
        		if(random.nextInt(2) == 0)
        		{
        			tileentitymobspawner.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomNightName());
        		}else
        		{
        			tileentitymobspawner.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomDayName());
        		}
        	}else
        	{
        		tileentitymobspawner.func_145881_a().setEntityName(DQR.modID + "." + DQR.randomMob.getRandomNightName());
        	}
        	//tileentitymobspawner.func_145881_a().setEntityName("Creeper");
        }
        else
        {
            System.err.println("Failed to fetch mob spawner entity at (" + offX + ", " + offY + ", " + offZ + ")");
        }
        //System.err.println("Failed to fetch mob spawner entity at (" + offX + ", " + offY + ", " + offZ + ")");

        int chestCnt = random.nextInt(3);

        for(int cnt = 0; cnt <= chestCnt; cnt++)
        {
        	int side = random.nextInt(4);

        	if(xWidth > 1 && zWidth > 1)
        	{
	        	if(side == 0)
	        	{
	        		offX = 1;
	        		offZ = random.nextInt(zWidth - 1) + 1;
	        	}else if(side == 1)
	        	{
	        		offX = xWidth - 1;
	        		offZ = random.nextInt(zWidth - 1) + 1;
	        	}else if(side == 2)
	        	{
	        		offX = random.nextInt(xWidth - 1) + 1;
	        		offZ = zWidth - 1;
	        	}else if(side == 3)
	        	{
	        		offX = random.nextInt(xWidth - 1) + 1;
	        		offZ = 1;
	        	}

	        	offX = offX + xPos;
	        	offY = 1 + yPos;
	        	offZ = offZ + zPos;

	        	//System.out.println("DEBUG:" + offX + "/" + offY + "/" + offZ);

	        	if(world.isAirBlock(offX, offY, offZ))
	        	{
		        	world.setBlock(offX, offY, offZ, Blocks.chest, 0, 2);
		        	if(world.getTileEntity(offX, offY, offZ) instanceof TileEntityChest)
		        	{
			            TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(offX, offY, offZ);

			            if (tileentitychest != null)
			            {
			            	if(offY > 40)
			            	{
			            		DQR.randomItem.generateChestContentsRank1(random, tileentitychest);
			            	}else
			            	{
			            		DQR.randomItem.generateChestContentsRank2(random, tileentitychest);
			            	}
			            }
		        	}
	        	}
        	}
        }
		/*
        if (tileentitymobspawner != null)
        {
        	Minecraft mc;
            //tileentitymobspawner.func_145881_a().setEntityName(this.pickMobSpawner("zombie"));
        	String entityModName = "DQMIII.Ayasiikage";
        	tileentitymobspawner.func_145881_a().setEntityName("pig");
        }
        else
        {
            System.err.println("Failed to fetch mob spawner entity at (" + ((this.xWidth / 2) + this.xPos) + ", " + (1 + this.yPos) + ", " + ((this.zWidth / 2) + this.zPos) + ")");
        }
        */
		// 占有範囲(structureboundingbox)内の指定範囲を置き換える
		// 占有範囲内の指定範囲は占有範囲原点を基準として(0,1,2), (0,2,2), (0,3,2)の位置を空気ブロックに置き換えている
		// 入り口っぽく壁に穴を空けている。coordBaseModeでランダムな方向になってることを確認できるようにするためです
		//this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 0, 1, 2, structureboundingbox);
		//this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 0, 2, 2, structureboundingbox);
		//this.placeBlockAtCurrentPosition(world, Blocks.air, 0, 0, 3, 2, structureboundingbox);

        return true;
    }

    /**
     * Randomly decides which spawner to use in a dungeon
     */
    private String pickMobSpawner(Random p_76543_1_)
    {
        return DungeonHooks.getRandomDungeonMob(p_76543_1_);
    }
}
