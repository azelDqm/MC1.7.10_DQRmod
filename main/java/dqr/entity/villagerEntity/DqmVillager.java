package dqr.entity.villagerEntity;

import cpw.mods.fml.common.registry.VillagerRegistry;
import dqr.DQR;
import dqr.entity.villagerEntity.villager.DqmVillagerBukiya;

public class DqmVillager {

	public static DqmVillagerBukiya vlgBukiya;

	public static int vlgBukiyaID = DQR.conf.AddVillagerID + 0;
	/*
	public static DqmVillagerKaitori villager;
	public static DqmVillagerBank villager;
	public static DqmVillagerFixer villager;
	*/

	public DqmVillager()
	{
		vlgBukiya = new DqmVillagerBukiya();

		VillagerRegistry.instance().registerVillagerId(vlgBukiyaID);

		VillagerRegistry.instance().registerVillageTradeHandler(vlgBukiyaID, vlgBukiya);

		
	}
}
