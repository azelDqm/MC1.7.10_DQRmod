package dqr.functions;

import java.util.ArrayList;
import java.util.Hashtable;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.DQR;
import dqr.api.Blocks.DQOres;
import dqr.api.Blocks.DQPlants;
import dqr.api.Items.DQSeeds;

public class FuncCheckMutation {

	public Hashtable mutationSeeds;
	public Hashtable mutationSeedBlocks;
	public Hashtable mutationBlocks;
	public Hashtable mutationBlockMetas;
	public Hashtable mutationResults;
	public Hashtable mutationResultBlocks;

	public Item[] cropArray = {DQSeeds.itemYakusou2, DQSeeds.itemYakusou3,
							   DQSeeds.itemDokukesisou2, DQSeeds.itemDokukesisou3,
							   DQSeeds.itemTikaranotane2, DQSeeds.itemTikaranotane3,
							   DQSeeds.itemMamorinotane2, DQSeeds.itemMamorinotane3,
							   DQSeeds.itemSubayasanotane2, DQSeeds.itemSubayasanotane3,

							   DQSeeds.itemIyasinomi,
							   DQSeeds.itemIyasinomi2, DQSeeds.itemIyasinomi3,

							   DQSeeds.itemHonoonomi,
							   DQSeeds.itemHonoonomi2, DQSeeds.itemHonoonomi3,

							   DQSeeds.itemMahounomiI,
							   DQSeeds.itemMahounomiI2, DQSeeds.itemMahounomiI3,

							   DQSeeds.itemMaryokunotaneI,
							   DQSeeds.itemMaryokunotaneI2, DQSeeds.itemMaryokunotaneI3,

							   DQSeeds.itemOugon,

							   DQSeeds.itemOugon2, DQSeeds.itemOugon3, DQSeeds.itemOugon4
							  };

	public Block[] cropBlockArray = {DQPlants.BlockYakusouSeed2, DQPlants.BlockYakusouSeed3,
									 DQPlants.BlockDokukesisouSeed2, DQPlants.BlockDokukesisouSeed3,
									 DQPlants.BlockTikaraSeed2, DQPlants.BlockTikaraSeed3,
									 DQPlants.BlockMamoriSeed2, DQPlants.BlockMamoriSeed3,
									 DQPlants.BlockSubayasaSeed2, DQPlants.BlockSubayasaSeed3,

									 DQPlants.BlockIyasiSeed1,
									 DQPlants.BlockIyasiSeed2, DQPlants.BlockIyasiSeed3,
									 DQPlants.BlockHonooSeed1,
									 DQPlants.BlockHonooSeed2, DQPlants.BlockHonooSeed3,

									 DQPlants.BlockMahounomiSeed1,
									 DQPlants.BlockMahounomiSeed2, DQPlants.BlockMahounomiSeed3,
									 DQPlants.BlockMaryokunotaneSeed1,
									 DQPlants.BlockMaryokunotaneSeed2, DQPlants.BlockMaryokunotaneSeed3,

									 DQPlants.BlockOugonSeed1,

									 DQPlants.BlockOugonSeed2, DQPlants.BlockOugonSeed3, DQPlants.BlockOugonSeed4
								  };

	public Item[][] itemArray = {{DQSeeds.itemYakusouSeed}, {DQSeeds.itemYakusouSeed2},
								 {DQSeeds.itemDokukesisouSeed}, {DQSeeds.itemDokukesisouSeed2},
								 {DQSeeds.itemTikaraSeed}, {DQSeeds.itemTikaraSeed2},
								 {DQSeeds.itemMamoriSeed}, {DQSeeds.itemMamoriSeed2},
								 {DQSeeds.itemSubayasaSeed}, {DQSeeds.itemSubayasaSeed2},

								 {DQSeeds.itemYakusouSeed3, DQSeeds.itemMamoriSeed3},
								 {DQSeeds.itemIyasiSeed}, {DQSeeds.itemIyasiSeed2},
								 {DQSeeds.itemTikaraSeed3, DQSeeds.itemSubayasaSeed3},
								 {DQSeeds.itemHonooSeed}, {DQSeeds.itemHonooSeed2},

								 {DQSeeds.itemIyasiSeed3, DQSeeds.itemDokukesisouSeed3},
								 {DQSeeds.itemMahounomiseed}, {DQSeeds.itemMahounomiseed2},
								 {DQSeeds.itemHonooSeed3, DQSeeds.itemDokukesisouSeed3},
								 {DQSeeds.itemMaryokunotaneseed}, {DQSeeds.itemMaryokunotaneseed2},

								 {DQSeeds.itemMaryokunotaneseed3, DQSeeds.itemMahounomiseed3},

								 {DQSeeds.itemOugonSeed}, {DQSeeds.itemOugonSeed2}, {DQSeeds.itemOugonSeed3}
								};

	public Block[][] seedBlockArray = {{DQPlants.BlockYakusouSeed1}, {DQPlants.BlockYakusouSeed2},
									   {DQPlants.BlockDokukesisouSeed1}, {DQPlants.BlockDokukesisouSeed2},
									   {DQPlants.BlockTikaraSeed1}, {DQPlants.BlockTikaraSeed2},
									   {DQPlants.BlockMamoriSeed1}, {DQPlants.BlockMamoriSeed2},
									   {DQPlants.BlockSubayasaSeed1}, {DQPlants.BlockSubayasaSeed2},

									   {DQPlants.BlockYakusouSeed3, DQPlants.BlockMamoriSeed3},
									   {DQPlants.BlockIyasiSeed1}, {DQPlants.BlockIyasiSeed2},
									   {DQPlants.BlockTikaraSeed3, DQPlants.BlockSubayasaSeed3},
									   {DQPlants.BlockHonooSeed1}, {DQPlants.BlockHonooSeed2},


									   {DQPlants.BlockIyasiSeed3, DQPlants.BlockDokukesisouSeed3},
									   {DQPlants.BlockMahounomiSeed1}, {DQPlants.BlockMahounomiSeed2},
									   {DQPlants.BlockHonooSeed3, DQPlants.BlockDokukesisouSeed3},
									   {DQPlants.BlockMaryokunotaneSeed1}, {DQPlants.BlockMaryokunotaneSeed2},


									   {DQPlants.BlockMaryokunotaneSeed3, DQPlants.BlockMahounomiSeed3},

									   {DQPlants.BlockOugonSeed1}, {DQPlants.BlockOugonSeed2}, {DQPlants.BlockOugonSeed3}
									};

	public Block[][] blockArray = {{Blocks.coal_block}, {DQOres.DqmOreBlocks},
								  {Blocks.iron_block}, {DQOres.DqmOreBlocks},
								  {Blocks.gold_block}, {DQOres.DqmOreBlocks},
								  {Blocks.lapis_block}, {DQOres.DqmOreBlocks},
								  {Blocks.redstone_block}, {DQOres.DqmOreBlocks},

								  {DQOres.DqmOreBlocks},
								  {DQOres.DqmOreBlocks}, {DQOres.DqmOreBlocks},
								  {DQOres.DqmOreBlocks},
								  {DQOres.DqmOreBlocks}, {DQOres.DqmOreBlocks},

								  {DQOres.DqmOreBlocks},
								  {Blocks.quartz_block}, {Blocks.diamond_block},
								  {DQOres.DqmOreBlocks},
								  {Blocks.netherrack}, {Blocks.emerald_block},

								  {Blocks.end_stone},

								  {DQOres.DqmOreBlocks}, {DQOres.DqmOreBlocks}, {DQOres.DqmOreBlocks}
								 };
	public int[][] metaArray = {{0}, {13},
								{0}, {6},
								{0}, {11},
								{0}, {4},
								{0}, {5},
								{3},
								{10}, {14},
								{15},
								{0}, {12},
								{8},
								{0}, {0},
								{2},
								{0}, {0},
								{0},
								{7}, {1}, {9}
							   };

	public FuncCheckMutation()
	{

		mutationSeeds = new Hashtable();
		mutationBlocks = new Hashtable();
		mutationBlockMetas = new Hashtable();
		mutationResults = new Hashtable();
		mutationSeedBlocks = new Hashtable();
		mutationResultBlocks = new Hashtable();

		setSeedPattern();
		setFarmBlockPattern();
		setMutationRsult();
		setFarmMetaPattern();
		setSeedBlocksPattern();
		setMutationBlockRsult();
	}

	public void setSeedPattern()
	{
		//int cnt = 0;
		ItemStack[] setPattern;

		for(int cnt = 0; cnt < itemArray.length; cnt++)
		{
			if(itemArray[cnt].length == 1)
			{
				setPattern = new ItemStack[]{null , new ItemStack(itemArray[cnt][0], 1, 0), null,
							 				 new ItemStack(itemArray[cnt][0], 1, 0), null, new ItemStack(itemArray[cnt][0], 1, 0),
							 				 null, new ItemStack(itemArray[cnt][0], 1, 0), null};
			}else
			{
				setPattern = new ItemStack[]{null , new ItemStack(itemArray[cnt][0], 1, 0), null,
							 new ItemStack(itemArray[cnt][1], 1, 0), null, new ItemStack(itemArray[cnt][1], 1, 0),
							 null, new ItemStack(itemArray[cnt][0], 1, 0), null};
			}
			mutationSeeds.put(cnt, setPattern);
		}
	}

	public void setSeedBlocksPattern()
	{
		//int cnt = 0;
		Block[] setPattern;

		for(int cnt = 0; cnt < seedBlockArray.length; cnt++)
		{
			if(seedBlockArray[cnt].length == 1)
			{
				setPattern = new Block[]{null , seedBlockArray[cnt][0], null,
										 seedBlockArray[cnt][0], null, seedBlockArray[cnt][0],
							 			 null, seedBlockArray[cnt][0], null};
			}else
			{
				setPattern = new Block[]{null , seedBlockArray[cnt][0], null,
						 				 seedBlockArray[cnt][1], null, seedBlockArray[cnt][1],
						 				 null, seedBlockArray[cnt][0], null};
			}
			mutationSeedBlocks.put(cnt, setPattern);
		}
	}

	public void setFarmBlockPattern()
	{
		Block[] setPattern;

		for(int cnt = 0; cnt < blockArray.length; cnt++)
		{
			if(blockArray[cnt].length == 1)
			{
				setPattern = new Block[]{blockArray[cnt][0] , Blocks.farmland, blockArray[cnt][0],
							 			 Blocks.farmland, DQPlants.BlockHoujyouDirt, Blocks.farmland,
							 			 blockArray[cnt][0], Blocks.farmland, blockArray[cnt][0]};
			}else
			{
				setPattern = new Block[]{blockArray[cnt][0] , Blocks.farmland, blockArray[cnt][1],
			 			 				 Blocks.farmland, DQPlants.BlockHoujyouDirt, Blocks.farmland,
			 			 				 blockArray[cnt][1], Blocks.farmland, blockArray[cnt][0]};
			}

			mutationBlocks.put(cnt, setPattern);
		}
	}

	public void setFarmMetaPattern()
	{
		int[] setPattern;

		for(int cnt = 0; cnt < metaArray.length; cnt++)
		{
			if(metaArray[cnt].length == 1)
			{
				setPattern = new int[]{metaArray[cnt][0], 0, metaArray[cnt][0],
							 			 0, 0, 0,
							 			 metaArray[cnt][0], 0, metaArray[cnt][0]
										};
			}else
			{
				setPattern = new int[]{metaArray[cnt][0], 0, metaArray[cnt][1],
			 			 			   0, 0, 0,
			 			 			   metaArray[cnt][1], 0, metaArray[cnt][0]
									  };
			}

			mutationBlockMetas.put(cnt, setPattern);
		}
	}

	public void setMutationRsult()
	{

		for(int cnt = 0; cnt < cropArray.length; cnt++)
		{
			mutationResults.put(cnt, cropArray[cnt]);
		}
	}

	public void setMutationBlockRsult()
	{

		for(int cnt = 0; cnt < cropBlockArray.length; cnt++)
		{
			mutationResultBlocks.put(cnt, cropBlockArray[cnt]);
		}
	}

	public ArrayList<Integer> getMutationSeedBlocksKey(Block[] par1)
	{
		ArrayList<Integer> retKey = new ArrayList();


		for(Object key: mutationSeedBlocks.keySet())
		{
			Block[] checkTable = (Block[])mutationSeedBlocks.get(key);


			if(DQR.func.equalBlockArray(par1,checkTable))
			{
				//DQR.func.debugString("DEBUG_AAA");
				retKey.add((int)key);
			}
		}
		return retKey;
	}
}
