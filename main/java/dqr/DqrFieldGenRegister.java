package dqr;

import cpw.mods.fml.common.registry.GameRegistry;
import dqr.world.genFeature.DqmGenerateSurfaceOre;
import dqr.world.genFeature.DqmWorldGenGenkotu;
import dqr.world.genFeature.DqmWorldGenHako;
import dqr.world.genFeature.DqmWorldGenIdo;
import dqr.world.genFeature.DqmWorldGenIdo2;
import dqr.world.genFeature.DqmWorldGenPlants;
import dqr.world.genFeature.DqmWorldGenSword;
import dqr.world.genFeature.DqmWorldGenSword2;
import dqr.world.genFeature.DqmWorldGenTaru;
import dqr.world.genFeature.DqmWorldGenTubo;
import dqr.world.genFeature.DqmWorldGenTue;
import dqr.world.genFeature.DqmWorldSikabane;

public class DqrFieldGenRegister {

	public DqrFieldGenRegister()
	{
		GameRegistry.registerWorldGenerator(new DqmGenerateSurfaceOre(), 5);
		GameRegistry.registerWorldGenerator(new DqmWorldGenPlants(), 5);

		if(DQR.conf.cfg_gen_Ido == 1) GameRegistry.registerWorldGenerator(new DqmWorldGenIdo(), 4);
		if(DQR.conf.cfg_gen_Ido2 == 1) GameRegistry.registerWorldGenerator(new DqmWorldGenIdo2(), 6);

		if(DQR.conf.cfg_gen_Genkotu == 1) GameRegistry.registerWorldGenerator(new DqmWorldGenGenkotu(), 7);

		if(DQR.conf.cfg_gen_Tubo == 1) GameRegistry.registerWorldGenerator(new DqmWorldGenTubo(), 8);
		if(DQR.conf.cfg_gen_Hako == 1) GameRegistry.registerWorldGenerator(new DqmWorldGenHako(), 9);
		if(DQR.conf.cfg_gen_Taru == 1) GameRegistry.registerWorldGenerator(new DqmWorldGenTaru(), 10);
		if(DQR.conf.cfg_gen_Sikabane == 1) GameRegistry.registerWorldGenerator(new DqmWorldSikabane(), 11);

		if(DQR.conf.cfg_gen_Tue == 1) GameRegistry.registerWorldGenerator(new DqmWorldGenTue(), 12);
		if(DQR.conf.cfg_gen_Sword == 1) GameRegistry.registerWorldGenerator(new DqmWorldGenSword(), 13);
		if(DQR.conf.cfg_gen_Sword2 == 1) GameRegistry.registerWorldGenerator(new DqmWorldGenSword2(), 14);

	}
}
