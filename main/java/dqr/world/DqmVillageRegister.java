package dqr.world;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import cpw.mods.fml.common.registry.VillagerRegistry;
import dqr.world.genVillage.ComponentVillageBankHouse;
import dqr.world.genVillage.ComponentVillageBukiyaHouse;
import dqr.world.genVillage.ComponentVillageKaitoriyaHouse;
import dqr.world.genVillage.ComponentVillageSyuriyaHouse;
import dqr.world.genVillage.VillageCreationHandleBank;
import dqr.world.genVillage.VillageCreationHandleBukiya;
import dqr.world.genVillage.VillageCreationHandleKaitoriya;
import dqr.world.genVillage.VillageCreationHandleSyuriya;


public class DqmVillageRegister {


	public DqmVillageRegister()
	{
		//System.out.println("DEBUGLINE:++++++++");

		VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandleBukiya());
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandleKaitoriya());
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandleSyuriya());
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandleBank());

		MapGenStructureIO.registerStructure(ComponentVillageBukiyaHouse.class, "DQBukiyaHouse");
		MapGenStructureIO.func_143031_a(ComponentVillageBukiyaHouse.class, "DQBukiyaHouse");

		MapGenStructureIO.registerStructure(ComponentVillageSyuriyaHouse.class, "DQSyuriyaHouse");
		MapGenStructureIO.func_143031_a(ComponentVillageSyuriyaHouse.class, "DQSyuriyaHouse");

		MapGenStructureIO.registerStructure(ComponentVillageKaitoriyaHouse.class, "DQKaitoriyaHouse");
		MapGenStructureIO.func_143031_a(ComponentVillageKaitoriyaHouse.class, "DQKaitoriyaHouse");

		MapGenStructureIO.registerStructure(ComponentVillageBankHouse.class, "DQBankHouse");
		MapGenStructureIO.func_143031_a(ComponentVillageBankHouse.class, "DQBankHouse");

	}
}
