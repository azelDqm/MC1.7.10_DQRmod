package dqr.dataTable;

import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryNamespaced;
import dqr.DQR;

public class FuncMGFarmSeedTable {

	public Map<String, Integer> MGSeedALL = new LinkedHashMap();
	public Map<String, Integer> MGSeedLv1 = new LinkedHashMap();
	public Map<String, Integer> MGSeedLv2 = new LinkedHashMap();
	public Map<String, Integer> MGSeedLv3 = new LinkedHashMap();
	public Map<String, Integer> MGSeedLvETC = new LinkedHashMap();

	public Map<String, Integer> MGPlantMaxMeta = new LinkedHashMap();

	public FuncMGFarmSeedTable()
	{
		MGSeedALL.put("DQMIIINext:ItemYakusouSeed", 7);
		MGSeedALL.put("DQMIIINext:ItemYakusouSeed2", 7);
		MGSeedALL.put("DQMIIINext:ItemYakusouSeed3", 7);
		MGSeedALL.put("DQMIIINext:ItemDokukesisouSeed", 7);
		MGSeedALL.put("DQMIIINext:ItemDokukesisouSeed2", 7);
		MGSeedALL.put("DQMIIINext:ItemDokukesisouSeed3", 7);
		MGSeedALL.put("DQMIIINext:ItemTikaraSeed", 7);
		MGSeedALL.put("DQMIIINext:ItemTikaraSeed2", 7);
		MGSeedALL.put("DQMIIINext:ItemTikaraSeed3", 7);
		MGSeedALL.put("DQMIIINext:ItemMamoriSeed", 7);
		MGSeedALL.put("DQMIIINext:ItemMamoriSeed2", 7);
		MGSeedALL.put("DQMIIINext:ItemMamoriSeed3", 7);
		MGSeedALL.put("DQMIIINext:ItemSubayasaSeed", 7);
		MGSeedALL.put("DQMIIINext:ItemSubayasaSeed2", 7);
		MGSeedALL.put("DQMIIINext:ItemSubayasaSeed3", 7);
		MGSeedALL.put("DQMIIINext:ItemHonooSeed", 7);
		MGSeedALL.put("DQMIIINext:ItemHonooSeed2", 7);
		MGSeedALL.put("DQMIIINext:ItemHonooSeed3", 7);
		MGSeedALL.put("DQMIIINext:ItemIyasiSeed", 7);
		MGSeedALL.put("DQMIIINext:ItemIyasiSeed2", 7);
		MGSeedALL.put("DQMIIINext:ItemIyasiSeed3", 7);
		MGSeedALL.put("DQMIIINext:ItemMahounomiseed", 7);
		MGSeedALL.put("DQMIIINext:ItemMahounomiseed2", 7);
		MGSeedALL.put("DQMIIINext:ItemMahounomiseed3", 7);
		MGSeedALL.put("DQMIIINext:ItemMaryokunotaneseed", 7);
		MGSeedALL.put("DQMIIINext:ItemMaryokunotaneseed2", 7);
		MGSeedALL.put("DQMIIINext:ItemMaryokunotaneseed3", 7);
		MGSeedALL.put("DQMIIINext:ItemOugonSeed", 7);
		MGSeedALL.put("DQMIIINext:ItemOugonSeed2", 7);
		MGSeedALL.put("DQMIIINext:ItemOugonSeed3", 7);
		MGSeedALL.put("DQMIIINext:ItemOugonSeed4", 7);
		MGSeedALL.put("minecraft:wheat_seeds", 7);
		MGSeedALL.put("minecraft:pumpkin_seeds", 7);
		MGSeedALL.put("minecraft:melon_seeds", 7);
		MGSeedALL.put("minecraft:nether_wart", 7);
		MGSeedALL.put("minecraft:potato", 7);
		MGSeedALL.put("minecraft:carrot", 7);

		MGSeedLv1.put("DQMIIINext:ItemYakusouSeed", 7);
		MGSeedLv1.put("DQMIIINext:ItemDokukesisouSeed", 7);
		MGSeedLv1.put("DQMIIINext:ItemTikaraSeed", 7);
		MGSeedLv1.put("DQMIIINext:ItemMamoriSeed", 7);
		MGSeedLv1.put("DQMIIINext:ItemSubayasaSeed", 7);
		MGSeedLv1.put("DQMIIINext:ItemHonooSeed", 7);
		MGSeedLv1.put("DQMIIINext:ItemIyasiSeed", 7);
		MGSeedLv1.put("DQMIIINext:ItemMahounomiseed", 7);
		MGSeedLv1.put("DQMIIINext:ItemMaryokunotaneseed", 7);
		MGSeedLv1.put("DQMIIINext:ItemOugonSeed", 7);

		MGSeedLv2.put("DQMIIINext:ItemYakusouSeed2", 7);
		MGSeedLv2.put("DQMIIINext:ItemDokukesisouSeed2", 7);
		MGSeedLv2.put("DQMIIINext:ItemTikaraSeed2", 7);
		MGSeedLv2.put("DQMIIINext:ItemMamoriSeed2", 7);
		MGSeedLv2.put("DQMIIINext:ItemSubayasaSeed2", 7);
		MGSeedLv2.put("DQMIIINext:ItemHonooSeed2", 7);
		MGSeedLv2.put("DQMIIINext:ItemIyasiSeed2", 7);
		MGSeedLv2.put("DQMIIINext:ItemMahounomiseed2", 7);
		MGSeedLv2.put("DQMIIINext:ItemMaryokunotaneseed2", 7);
		MGSeedLv2.put("DQMIIINext:ItemOugonSeed2", 7);

		MGSeedLv3.put("DQMIIINext:ItemYakusouSeed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemDokukesisouSeed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemTikaraSeed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemMamoriSeed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemSubayasaSeed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemHonooSeed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemIyasiSeed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemMahounomiseed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemMaryokunotaneseed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemOugonSeed3", 7);
		MGSeedLv3.put("DQMIIINext:ItemOugonSeed4", 7);

		MGSeedLvETC.put("minecraft:wheat_seeds", 7);
		MGSeedLvETC.put("minecraft:pumpkin_seeds", 7);
		MGSeedLvETC.put("minecraft:melon_seeds", 7);
		MGSeedLvETC.put("minecraft:nether_wart", 7);
		MGSeedLvETC.put("minecraft:potato", 7);
		MGSeedLvETC.put("minecraft:carrot", 7);

		if(DQR.conf.MGFarm_addSeeds.length > 0)
		{
			RegistryNamespaced rnI = Item.itemRegistry;
			RegistryNamespaced rnB = Block.blockRegistry;
			for(int cnt = 0; cnt < DQR.conf.MGFarm_addSeeds.length; cnt++)
			{
				if(!DQR.conf.MGFarm_addSeeds[cnt].trim().equalsIgnoreCase(""))
				{
					if((Item)rnI.getObject(DQR.conf.MGFarm_addSeeds[cnt].trim()) != null)
					{
						System.out.println("A:" + DQR.conf.MGFarm_addSeeds[cnt].trim());
						MGSeedALL.put(DQR.conf.MGFarm_addSeeds[cnt].trim(), 7);
						MGSeedLvETC.put(DQR.conf.MGFarm_addSeeds[cnt].trim(), 7);
					}else if((Block)rnB.getObject(DQR.conf.MGFarm_addSeeds[cnt].trim()) != null)
					{
						//System.out.println("B:" + DQR.conf.MGFarm_addSeeds[cnt].trim());
						ItemStack its = new ItemStack((Block)rnB.getObject(DQR.conf.MGFarm_addSeeds[cnt].trim()), 1);
						try
						{
							if(its != null && its.getDisplayName() != null)
							{
								MGSeedALL.put(DQR.conf.MGFarm_addSeeds[cnt].trim(), 7);
								MGSeedLvETC.put(DQR.conf.MGFarm_addSeeds[cnt].trim(), 7);
							}
						}catch (Exception e)
						{

						}
					}
				}
			}
		}


		MGPlantMaxMeta.put("DQMIIINext:blockYakusouSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockYakusouSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockYakusouSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockDokukesisouSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockDokukesisouSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockDokukesisouSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockTikaraSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockTikaraSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockTikaraSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockMamoriSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockMamoriSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockMamoriSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockSubayasaSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockSubayasaSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockSubayasaSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockHonooSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockHonooSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockHonooSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockIyasiSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockIyasiSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockIyasiSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockMahounomiSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockMahounomiSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockMahounomiSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockMaryokunotaneSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockMaryokunotaneSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockMaryokunotaneSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockOugonSeed1", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockOugonSeed2", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockOugonSeed3", 7);
		MGPlantMaxMeta.put("DQMIIINext:blockOugonSeed4", 7);

		RegistryNamespaced rn = Block.blockRegistry;

		MGPlantMaxMeta.put(rn.getNameForObject(Blocks.wheat), 7);
		MGPlantMaxMeta.put(rn.getNameForObject(Blocks.nether_wart), 7);
		MGPlantMaxMeta.put(rn.getNameForObject(Blocks.potatoes), 7);
		MGPlantMaxMeta.put(rn.getNameForObject(Blocks.carrots), 7);

		if(DQR.conf.MGFarm_addPlantMeta.length > 0)
		{
			for(int cnt = 0; cnt < DQR.conf.MGFarm_addPlantMeta.length; cnt++)
			{
				if(!DQR.conf.MGFarm_addPlantMeta[cnt].trim().equalsIgnoreCase(""))
				{
					String[] divString = DQR.conf.MGFarm_addPlantMeta[cnt].trim().split("/");
					String plantName = divString[0];
					int maxMeta = 0;

					if(divString.length > 0)
					{
						maxMeta = Integer.parseInt(divString[1]);
					}

					if((Block)rn.getObject(plantName) != null)
					{
						MGPlantMaxMeta.put(plantName, maxMeta);

					}
				}
			}
		}
	}

	public boolean containsKey(String par1)
	{
		return MGSeedALL.containsKey(par1);
	}

	public boolean containsKey2(String par1 , int par2)
	{
		switch(par2)
		{
			case 1: return MGSeedLv1.containsKey(par1);
			case 2: return MGSeedLv2.containsKey(par1);
			case 3: return MGSeedLv3.containsKey(par1);
			case 4: return MGSeedLvETC.containsKey(par1);
		}

		return false;
	}

	public int getPlantMaxMeta(String name)
	{
		if(MGPlantMaxMeta.containsKey(name))
		{
			return (int)(MGPlantMaxMeta.get(name));
		}else
		{
			return 0;
		}
	}
}
