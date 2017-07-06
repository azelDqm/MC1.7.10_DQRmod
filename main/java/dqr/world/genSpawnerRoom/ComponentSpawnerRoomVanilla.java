package dqr.world.genSpawnerRoom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.DungeonHooks;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.blocks.mobSpawner.tileEntity.DqmTileEntityMobSpawner;

public class ComponentSpawnerRoomVanilla extends StructureComponent {

	private int xWidth;
	private int zWidth;

	private int xPos;
	private int zPos;
	private int yPos;

	private boolean setChest = false;
	// 構成パーツリストを記憶するためのリスト
	public List<StructureComponent> structureComponents = new ArrayList();

	public ComponentSpawnerRoomVanilla() {}

	public ComponentSpawnerRoomVanilla(int par1, Random par2Random2, int par3, int par4) {
		// 東西南北の方向をランダムに決める
		Random par2Random = new Random();
		this.coordBaseMode = par2Random.nextInt(4);
		int roomSize = par2Random.nextInt(3) * 2;
		this.xWidth = 6 + roomSize;
		this.zWidth = 6 + roomSize;

		xPos = par3;
		zPos = par4;
		yPos = par2Random.nextInt(127) + 6;
		switch(this.coordBaseMode) {
		case 0:
		case 1:
		case 2:
		case 3:
		default:
			// 占有範囲を設定(このサンプルではどの方角を向いてても同じ)
			// (x,y,z) = (par3, 64, par4)の地点から4x10x4ブロックが占有範囲
			this.boundingBox = new StructureBoundingBox(par3, yPos, par4, par3 + xWidth, yPos + 6, par4 + zWidth);
			break;



		}
	}

	@Override
	public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
		// 次のパーツはComponentSampleDungeon2を斜めに接続
		//StructureComponent structureComponent = new ComponentSampleDungeon2(0, par3Random, this.boundingBox.maxX + 1, this.boundingBox.maxZ + 1, 0);
		//((ComponentSampleDungeon1)par1StructureComponent).structureComponents.add(structureComponent);
		//par2List.add(structureComponent);
	}

	@Override
	protected void func_143012_a(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void func_143011_b(NBTTagCompound nbttagcompound) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean addComponentParts(World world, Random random2, StructureBoundingBox structureboundingbox) {
		// 建設予定範囲内に液体があった場合は建設中止
		Random random = new Random();

		if(this.xWidth < 2 || this.zWidth < 2)
		{
			return false;
		}

		if(this.yPos < 50)
		{
			int dam = 0;
			if(world.getBlock(this.xPos, this.yPos, this.zPos).getMaterial() == Material.water) dam++;
			if(world.getBlock(this.xPos + this.xWidth, this.yPos, this.zPos).getMaterial() == Material.water) dam++;
			if(world.getBlock(this.xPos, this.yPos, this.zPos + this.zWidth).getMaterial() == Material.water) dam++;
			if(world.getBlock(this.xPos + this.xWidth, this.yPos, this.zPos + this.zWidth).getMaterial() == Material.water) dam++;

			if(dam >= 3)
			{
				return false;
			}
		}else
		{
			int dam = 0;
			if(world.isAirBlock(this.xPos, this.yPos, this.zPos)) dam++;
			if(world.getBlock(this.xPos, this.yPos, this.zPos).getMaterial() == Material.water) dam++;
			if(world.isAirBlock(this.xPos + this.xWidth, this.yPos, this.zPos)) dam++;
			if(world.getBlock(this.xPos + this.xWidth, this.yPos, this.zPos).getMaterial() == Material.water) dam++;
			if(world.isAirBlock(this.xPos, this.yPos, this.zPos + this.zWidth)) dam++;
			if(world.getBlock(this.xPos, this.yPos, this.zPos + this.zWidth).getMaterial() == Material.water) dam++;
			if(world.isAirBlock(this.xPos + this.xWidth, this.yPos, this.zPos + this.zWidth)) dam++;
			if(world.getBlock(this.xPos + this.xWidth, this.yPos, this.zPos + this.zWidth).getMaterial() == Material.water) dam++;

			if(dam >= 3)
			{
				return false;
			}

			dam = 0;
			if(world.isAirBlock(this.xPos, this.yPos + 5, this.zPos)) dam++;
			if(world.getBlock(this.xPos, this.yPos + 5, this.zPos).getMaterial() == Material.water) dam++;
			if(world.isAirBlock(this.xPos + this.xWidth, this.yPos + 5, this.zPos)) dam++;
			if(world.getBlock(this.xPos + this.xWidth, this.yPos + 5, this.zPos).getMaterial() == Material.water) dam++;
			if(world.isAirBlock(this.xPos, this.yPos + 5, this.zPos + this.zWidth)) dam++;
			if(world.getBlock(this.xPos, this.yPos + 5, this.zPos + this.zWidth).getMaterial() == Material.water) dam++;
			if(world.isAirBlock(this.xPos + this.xWidth, this.yPos + 5, this.zPos + this.zWidth)) dam++;
			if(world.getBlock(this.xPos + this.xWidth, this.yPos + 5, this.zPos + this.zWidth).getMaterial() == Material.water) dam++;

			if(dam >= 3)
			{
				return false;
			}
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
		this.fillWithAir(world, structureboundingbox, 1, 1, 1, this.xWidth - 1, 4, this.zWidth - 1);

		//System.out.println("DEBUGLINE:" + this.xPos + "/" + this.yPos + "/"+ this.zPos);
		for(int cntY = 1; cntY <= 4; cntY++)
		{
			for(int cntX = 0; cntX <= this.xWidth; cntX ++)
			{
				int blockSet = random.nextInt(21);
				int metaSet = 0;
				Block blc = Blocks.stone;
				if(blockSet < 5)
				{
					metaSet = 0;
				}else if(blockSet < 10)
				{
					blc = Blocks.cobblestone;
					metaSet = 0;
				}else if(blockSet < 15)
				{
					blc = Blocks.cobblestone;
					metaSet = 0;
				}else if(blockSet < 20)
				{
					blc = Blocks.mossy_cobblestone;
					metaSet = 0;
				}else
				{
					switch(random.nextInt(3))
					{
						case 0: blc = DQBlocks.DqmBlockHako11; break;
						case 1: blc = DQBlocks.DqmBlockHako12; break;
						case 2: blc = DQBlocks.DqmBlockHako13; break;
					}
				}
				this.placeBlockAtCurrentPosition(world, blc, metaSet, cntX, cntY, 0, structureboundingbox);
				this.placeBlockAtCurrentPosition(world, blc, metaSet, cntX, cntY, this.zWidth, structureboundingbox);
			}

			for(int cntZ = 0; cntZ <= this.zWidth; cntZ ++)
			{
				int blockSet = random.nextInt(21);
				int metaSet = 0;
				Block blc = Blocks.stone;
				if(blockSet < 2)
				{
					metaSet = 0;
				}else if(blockSet < 10)
				{
					blc = Blocks.cobblestone;
					metaSet = 0;
				}else if(blockSet < 15)
				{
					blc = Blocks.cobblestone;
					metaSet = 0;
				}else if(blockSet < 20)
				{
					blc = Blocks.mossy_cobblestone;
					metaSet = 0;
				}else
				{
					switch(random.nextInt(3))
					{
						case 0: blc = DQBlocks.DqmBlockHako11; break;
						case 1: blc = DQBlocks.DqmBlockHako12; break;
						case 2: blc = DQBlocks.DqmBlockHako13; break;
					}
				}
				this.placeBlockAtCurrentPosition(world, blc, metaSet, 0, cntY, cntZ, structureboundingbox);
				this.placeBlockAtCurrentPosition(world, blc, metaSet, this.xWidth, cntY, cntZ, structureboundingbox);
			}
		}

		for(int cntZ = 0; cntZ <= this.zWidth; cntZ ++)
		{
			for(int cntX = 0; cntX <= this.xWidth; cntX ++)
			{
				int blockSet = random.nextInt(21);
				int metaSet = 0;
				Block blc = Blocks.stone;
				if(blockSet < 5)
				{
					blc = Blocks.cobblestone;
					metaSet = 0;
				}else if(blockSet < 10)
				{
					blc = Blocks.cobblestone;
					metaSet = 0;
				}else if(blockSet < 15)
				{
					blc = Blocks.cobblestone;
					metaSet = 0;
				}else if(blockSet < 20)
				{
					blc = Blocks.mossy_cobblestone;
					metaSet = 0;
				}else
				{
					switch(random.nextInt(3))
					{
						case 0: blc = DQBlocks.DqmBlockHako11; break;
						case 1: blc = DQBlocks.DqmBlockHako12; break;
						case 2: blc = DQBlocks.DqmBlockHako13; break;
					}
				}
				this.placeBlockAtCurrentPosition(world, blc, metaSet, cntX, 0, cntZ, structureboundingbox);
				this.placeBlockAtCurrentPosition(world, blc, metaSet, cntX, 5, cntZ, structureboundingbox);
			}
		}

		int offX = (this.xWidth / 2) + this.xPos;
		int offY = 1 + this.yPos;
		int offZ = (this.zWidth / 2) + this.zPos;
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


        	if(random.nextInt(3)==0)
        	{
        		tileentitymobspawner.func_145881_a().setEntityName("Enderman");
        	}else
        	{
        		tileentitymobspawner.func_145881_a().setEntityName("Creeper");
        	}

        	//tileentitymobspawner.func_145881_a().setEntityName("Creeper");
        }
        else
        {
            System.err.println("Failed to fetch mob spawner entity at (" + offX + ", " + offY + ", " + offZ + ")");
        }


        int chestCnt = random.nextInt(3) + 1;

        if(setChest == false)
        {
	    	for(int cnt = 0; cnt < chestCnt; cnt++)
	    	{
	        	int side = random.nextInt(4);

	        	if(this.zWidth > 1 && this.zWidth > 1)
	        	{
		        	if(side == 0)
		        	{
		        		offX = 1;
		        		offZ = random.nextInt(this.zWidth - 1) + 1;
		        	}else if(side == 1)
		        	{
		        		offX = this.xWidth - 1;
		        		offZ = random.nextInt(this.zWidth - 1) + 1;
		        	}else if(side == 2)
		        	{
		        		offX = random.nextInt(this.xWidth - 1) + 1;
		        		offZ = this.zWidth - 1;
		        	}else if(side == 3)
		        	{
		        		offX = random.nextInt(this.xWidth - 1) + 1;
		        		offZ = 1;
		        	}

		        	offX = offX + this.xPos;
		        	offY = 1 + this.yPos;
		        	offZ = offZ + this.zPos;

		        	if(world.getTileEntity(offX, offY, offZ) == null)
		        	{
			        	world.setBlock(offX, offY, offZ, Blocks.chest, 0, 2);
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

			            	setChest = true;
			            }
		        	}
	        	}
	    	}
        }

        //System.err.println("Failed to fetch mob spawner entity at (" + offX + ", " + offY + ", " + offZ + ")");

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

    private String pickMobSpawner(Random p_76543_1_)
    {
        return DungeonHooks.getRandomDungeonMob(p_76543_1_);
    }
}
