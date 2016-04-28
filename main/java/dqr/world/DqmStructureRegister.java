package dqr.world;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import dqr.world.genSpawnerRoom.ComponentSpawnerRoomEnd;
import dqr.world.genSpawnerRoom.ComponentSpawnerRoomNether;
import dqr.world.genSpawnerRoom.ComponentSpawnerRoomOver;
import dqr.world.genSpawnerRoom.ComponentSpawnerRoomVanilla;
import dqr.world.genSpawnerRoom.StructureSpawnerRoomEndStart;
import dqr.world.genSpawnerRoom.StructureSpawnerRoomNetherStart;
import dqr.world.genSpawnerRoom.StructureSpawnerRoomOverStart;
import dqr.world.genSpawnerRoom.StructureSpawnerRoomVanillaStart;



public class DqmStructureRegister {

	public DqmStructureRegister()
	{


		//グループ追加
		MapGenStructureIO.registerStructure(StructureSpawnerRoomOverStart.class, "SpawnerRoom");
		//パーツ追加
		MapGenStructureIO.func_143031_a(ComponentSpawnerRoomOver.class, "SR1");

		MapGenStructureIO.registerStructure(StructureSpawnerRoomVanillaStart.class, "SpawnerRoomV");
		MapGenStructureIO.func_143031_a(ComponentSpawnerRoomVanilla.class, "SRV1");

		MapGenStructureIO.registerStructure(StructureSpawnerRoomNetherStart.class, "SpawnerRoomN");
		MapGenStructureIO.func_143031_a(ComponentSpawnerRoomNether.class, "SRN1");

		MapGenStructureIO.registerStructure(StructureSpawnerRoomEndStart.class, "SpawnerRoomE");
		MapGenStructureIO.func_143031_a(ComponentSpawnerRoomEnd.class, "SRE1");


	}
}
