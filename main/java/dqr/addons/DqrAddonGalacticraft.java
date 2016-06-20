package dqr.addons;

import java.io.File;
import java.util.List;

import micdoodle8.mods.galacticraft.api.event.oxygen.GCCoreOxygenSuffocationEvent;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedCreeper;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSkeleton;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedSpider;
import micdoodle8.mods.galacticraft.core.entities.EntityEvolvedZombie;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.world.WorldEvent.PotentialSpawns;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dqr.DQR;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.mobEntity.monsterBoss.DqmEntityDesupisaro1;
import dqr.entity.mobEntity.monsterBoss.DqmEntityEsterk;
import dqr.entity.mobEntity.monsterBoss.DqmEntityMasterdoragon;
import dqr.entity.mobEntity.monsterBoss.DqmEntityRyuuou;
import dqr.entity.mobEntity.monsterBoss.DqmEntityZoma;
import dqr.entity.mobEntity.monsterEnd.DqmEntityAkairai;
import dqr.entity.mobEntity.monsterEnd.DqmEntityBassaimasin;
import dqr.entity.mobEntity.monsterEnd.DqmEntityBatorurex;
import dqr.entity.mobEntity.monsterEnd.DqmEntityBiggumoai;
import dqr.entity.mobEntity.monsterEnd.DqmEntityBurizado;
import dqr.entity.mobEntity.monsterEnd.DqmEntityDakuhobitto;
import dqr.entity.mobEntity.monsterEnd.DqmEntityDakunaito;
import dqr.entity.mobEntity.monsterEnd.DqmEntityDarktororu;
import dqr.entity.mobEntity.monsterEnd.DqmEntityDasudragon;
import dqr.entity.mobEntity.monsterEnd.DqmEntityDenga;
import dqr.entity.mobEntity.monsterEnd.DqmEntityDesujakkaru;
import dqr.entity.mobEntity.monsterEnd.DqmEntityDesunyago;
import dqr.entity.mobEntity.monsterEnd.DqmEntityDesusutoka;
import dqr.entity.mobEntity.monsterEnd.DqmEntityDragondarknaito;
import dqr.entity.mobEntity.monsterEnd.DqmEntityGamegonrejendo;
import dqr.entity.mobEntity.monsterEnd.DqmEntityGigantesu;
import dqr.entity.mobEntity.monsterEnd.DqmEntityGodraida;
import dqr.entity.mobEntity.monsterEnd.DqmEntityGorudensuraimu;
import dqr.entity.mobEntity.monsterEnd.DqmEntityJigokunoyoroi;
import dqr.entity.mobEntity.monsterEnd.DqmEntityKagenokisi;
import dqr.entity.mobEntity.monsterEnd.DqmEntityManemane;
import dqr.entity.mobEntity.monsterEnd.DqmEntityPandorabox;
import dqr.entity.mobEntity.monsterEnd.DqmEntityRyuiso;
import dqr.entity.mobEntity.monsterEnd.DqmEntityTororubonba;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityDaiyamondosuraimu;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityDragometaru;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityGoldenmetalslime;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityHagumeta;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityHaguremetaruking;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetaking;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetaruburazazu;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetasura;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityPuratinaking;
import dqr.entity.mobEntity.monsterSP.DqmEntityAtorasu;
import dqr.entity.mobEntity.monsterSP.DqmEntityBazuzu;
import dqr.entity.mobEntity.monsterSP.DqmEntityBurasu;
import dqr.entity.mobEntity.monsterSP.DqmEntityDarkRamia;
import dqr.entity.mobEntity.monsterSP.DqmEntityFureizado;
import dqr.entity.mobEntity.monsterSP.DqmEntityGodonheddo;
import dqr.entity.mobEntity.monsterSP.DqmEntityKandatakobun;
import dqr.entity.mobEntity.monsterSP.DqmEntityKinghidora;
import dqr.entity.mobEntity.monsterSP.DqmEntityKiramajinga;
import dqr.entity.mobEntity.monsterSP.DqmEntityKiratoti;
import dqr.entity.mobEntity.monsterSP.DqmEntityMashougumo;
import dqr.entity.mobEntity.monsterSP.DqmEntityMasso;
import dqr.entity.mobEntity.monsterSP.DqmEntityPisaronaito;
import dqr.entity.mobEntity.monsterSP.DqmEntityPuremiasuraimu;
import dqr.entity.mobEntity.monsterSP.DqmEntitySirubamanto;
import dqr.entity.mobEntity.monsterSP.DqmEntitySuraimujeneraru;
import dqr.entity.mobEntity.monsterSP.DqmEntityTattyan;
import dqr.entity.mobEntity.monsterSP.DqmEntityTororubakkosu;
import dqr.entity.mobEntity.monsterSP.DqmEntityUragirikozou;
import dqr.entity.mobEntity.monsterSP.DqmEntityWanpakusatan;
import dqr.entity.mobEntity.monsterSP.DqmEntityYamatanooroti;
import dqr.entity.mobEntity.monsterTensei.DqmEntityArukemisuton;
import dqr.entity.mobEntity.monsterTensei.DqmEntityBebingosatan;
import dqr.entity.mobEntity.monsterTensei.DqmEntityDebirurodo;
import dqr.entity.mobEntity.monsterTensei.DqmEntityGoldmanto;
import dqr.entity.mobEntity.monsterTensei.DqmEntityGorudenkon;
import dqr.entity.mobEntity.monsterTensei.DqmEntityHatonaito;
import dqr.entity.mobEntity.monsterTensei.DqmEntityKirapike;
import dqr.entity.mobEntity.monsterTensei.DqmEntityKuinmomon;
import dqr.entity.mobEntity.monsterTensei.DqmEntityMaaburun;
import dqr.entity.mobEntity.monsterTensei.DqmEntityMadrainbow;
import dqr.entity.mobEntity.monsterTensei.DqmEntityMetaruhoimin;
import dqr.entity.mobEntity.monsterTensei.DqmEntityMomoirosansimai;
import dqr.entity.mobEntity.monsterTensei.DqmEntityMoonkimera;
import dqr.entity.mobEntity.monsterTensei.DqmEntityNoroinoiwa;
import dqr.entity.mobEntity.monsterTensei.DqmEntityPinkbonbon;
import dqr.entity.mobEntity.monsterTensei.DqmEntityReddoatya;
import dqr.entity.mobEntity.monsterTensei.DqmEntitySabotengold;
import dqr.entity.mobEntity.monsterTensei.DqmEntitySeigin;
import dqr.entity.mobEntity.monsterTensei.DqmEntityShuvaluts;
import dqr.entity.mobEntity.monsterTensei.DqmEntitySirudoaniki;
import dqr.entity.mobEntity.monsterTensei.DqmEntitySweetbag;
import dqr.entity.mobEntity.monsterTensei.DqmEntityTaipug;
import dqr.entity.mobEntity.monsterTensei.DqmEntityTogekonbou;
import dqr.entity.mobEntity.monsterTensei.DqmEntityTumurinmama;
import dqr.entity.mobEntity.monsterTensei.DqmEntityTyokonuba;

public class DqrAddonGalacticraft {

	public static int dimIdMoon = -28;
	public static int dimIdMars = -29;
	public static int dimIdAsteroid = -30;

	public DqrAddonGalacticraft()
	{

		//configからDimensionID取得
		Configuration confCore = new Configuration(new File(DQR.proxy.getDir(), "config/Galacticraft/core.conf"));
		Configuration confMars = new Configuration(new File(DQR.proxy.getDir(), "config/Galacticraft/mars.conf"));
		Configuration confAstero = new Configuration(new File(DQR.proxy.getDir(), "config/Galacticraft/asteroids.conf"));

		dimIdMoon = confCore.get("dimensions", "idDimensionMoon", dimIdMoon, "Dimension ID for the Moon").getInt();
		dimIdMars = confMars.get("dimensions", "dimensionIDMars", dimIdMars, "Dimension ID for Mars").getInt();
		dimIdAsteroid = confAstero.get("dimensions", "dimensionIDAsteroids", dimIdAsteroid, "Dimension ID for Asteroids").getInt();

		GameRegistry.registerWorldGenerator(new DqrAddonGalacticraftOre(), 5);
	}


	public static void addSpawn(Class <? extends EntityLiving > entityClass, int weightedProb, int min, int max, EnumCreatureType typeOfCreature, BiomeGenBase... biomes)
    {
        for (BiomeGenBase biome : biomes)
        {
            @SuppressWarnings("unchecked")
            List<SpawnListEntry> spawns = biome.getSpawnableList(EnumCreatureType.monster);

            for (SpawnListEntry entry : spawns)
            {
                //Adjusting an existing spawn entry
                if (entry.entityClass == entityClass)
                {
                    entry.itemWeight = weightedProb;
                    entry.minGroupCount = min;
                    entry.maxGroupCount = max;
                    break;
                }
            }

            spawns.add(new SpawnListEntry(entityClass, weightedProb, min, max));
        }
    }


	@SubscribeEvent
	public void onGCCoreOxygenSuffocationEvent(GCCoreOxygenSuffocationEvent.Pre event)
	{
		if(event.entityLiving instanceof DqmMobBase)
		{
			event.setCanceled(true);
		}
	}

	@SubscribeEvent
	public void onPotentialSpawns(PotentialSpawns event)
	{
		//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!TEST");
		//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!" + event.world.provider.getDimensionName());

		//List monsters = new ArrayList();
		//event.list.clear();
		if(event.type == EnumCreatureType.monster)
		{
			if(event.world.provider.dimensionId == DQR.addons.addonGalacticraft.dimIdMoon)
			{

				event.list.add(new SpawnListEntry(DqmEntityGorudensuraimu.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPandorabox.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBatorurex.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityAkairai.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDasudragon.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDesujakkaru.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityRyuiso.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKagenokisi.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDakunaito.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGamegonrejendo.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDenga.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDragondarknaito.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBiggumoai.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGodraida.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGigantesu.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBassaimasin.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBurizado.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDarktororu.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDesunyago.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityJigokunoyoroi.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityManemane.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTororubonba.class, 20, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDakuhobitto.class, 20, 1, 2));

				event.list.add(new SpawnListEntry(DqmEntityMetasura.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMetaruburazazu.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityHagumeta.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDragometaru.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMetaking.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDaiyamondosuraimu.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPuratinaking.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityHaguremetaruking.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGoldenmetalslime.class, 1, 1, 2));

				event.list.add(new SpawnListEntry(DqmEntitySeigin.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDebirurodo.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMaaburun.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityArukemisuton.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGorudenkon.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKuinmomon.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMoonkimera.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTyokonuba.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityReddoatya.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKirapike.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTogekonbou.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTaipug.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBebingosatan.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGoldmanto.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityHatonaito.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMadrainbow.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMetaruhoimin.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMomoirosansimai.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityNoroinoiwa.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPinkbonbon.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySabotengold.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityShuvaluts.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySirudoaniki.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySweetbag.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTumurinmama.class, 10, 1, 2));

				event.list.add(new SpawnListEntry(DqmEntityDesusutoka.class, 20, 1, 2));

	            event.list.add(new SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
	            event.list.add(new SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
	            event.list.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
	            event.list.add(new SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));

			}else if(event.world.provider.dimensionId == DQR.addons.addonGalacticraft.dimIdMars)
			{
				event.list.add(new SpawnListEntry(DqmEntityDesupisaro1.class, 1, 1, 1));
				event.list.add(new SpawnListEntry(DqmEntityRyuuou.class, 1, 1, 1));
				event.list.add(new SpawnListEntry(DqmEntityZoma.class, 1, 1, 1));
				event.list.add(new SpawnListEntry(DqmEntityMasterdoragon.class, 1, 1, 1));
				event.list.add(new SpawnListEntry(DqmEntityEsterk.class, 1, 1, 1));
				//event.list.add(new SpawnListEntry(DqmEntityGod.class, 1, 1, 1));

				event.list.add(new SpawnListEntry(DqmEntityMetasura.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMetaruburazazu.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityHagumeta.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDragometaru.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMetaking.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDaiyamondosuraimu.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPuratinaking.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityHaguremetaruking.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGoldenmetalslime.class, 1, 1, 2));

				event.list.add(new SpawnListEntry(DqmEntityWanpakusatan.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKiratoti.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMashougumo.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySirubamanto.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDarkRamia.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGodonheddo.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityAtorasu.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityYamatanooroti.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBazuzu.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKiramajinga.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySuraimujeneraru.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBurasu.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKandatakobun.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKinghidora.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMasso.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPisaronaito.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPuremiasuraimu.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTattyan.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTororubakkosu.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityUragirikozou.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityFureizado.class, 10, 1, 2));

				event.list.add(new SpawnListEntry(DqmEntitySeigin.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDebirurodo.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMaaburun.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityArukemisuton.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGorudenkon.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKuinmomon.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMoonkimera.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTyokonuba.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityReddoatya.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKirapike.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTogekonbou.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTaipug.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBebingosatan.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGoldmanto.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityHatonaito.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMadrainbow.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMetaruhoimin.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMomoirosansimai.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityNoroinoiwa.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPinkbonbon.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySabotengold.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityShuvaluts.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySirudoaniki.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySweetbag.class, 10, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTumurinmama.class, 10, 1, 2));

		        event.list.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedZombie.class, 8, 2, 3));
		        event.list.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSpider.class, 8, 2, 3));
		        event.list.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedSkeleton.class, 8, 2, 3));
		        event.list.add(new BiomeGenBase.SpawnListEntry(EntityEvolvedCreeper.class, 8, 2, 3));

			}else if(event.world.provider.dimensionId == DQR.addons.addonGalacticraft.dimIdAsteroid)
			{
				event.list.add(new SpawnListEntry(DqmEntityDesupisaro1.class, 1, 1, 1));
				event.list.add(new SpawnListEntry(DqmEntityRyuuou.class, 1, 1, 1));
				event.list.add(new SpawnListEntry(DqmEntityZoma.class, 1, 1, 1));
				event.list.add(new SpawnListEntry(DqmEntityMasterdoragon.class, 1, 1, 1));
				event.list.add(new SpawnListEntry(DqmEntityEsterk.class, 1, 1, 1));
				//event.list.add(new SpawnListEntry(DqmEntityGod.class, 1, 1, 1));

				event.list.add(new SpawnListEntry(DqmEntityMetasura.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMetaruburazazu.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityHagumeta.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDragometaru.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMetaking.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDaiyamondosuraimu.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPuratinaking.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityHaguremetaruking.class, 1, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGoldenmetalslime.class, 1, 1, 2));


				event.list.add(new SpawnListEntry(DqmEntityWanpakusatan.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKiratoti.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMashougumo.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySirubamanto.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDarkRamia.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGodonheddo.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityAtorasu.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityYamatanooroti.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBazuzu.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKiramajinga.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySuraimujeneraru.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBurasu.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKandatakobun.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKinghidora.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMasso.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPisaronaito.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPuremiasuraimu.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTattyan.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTororubakkosu.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityUragirikozou.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityFureizado.class, 1500, 1, 2));

				event.list.add(new SpawnListEntry(DqmEntitySeigin.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityDebirurodo.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMaaburun.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityArukemisuton.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGorudenkon.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKuinmomon.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMoonkimera.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTyokonuba.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityReddoatya.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityKirapike.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTogekonbou.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTaipug.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityBebingosatan.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityGoldmanto.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityHatonaito.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMadrainbow.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMetaruhoimin.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityMomoirosansimai.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityNoroinoiwa.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityPinkbonbon.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySabotengold.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityShuvaluts.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySirudoaniki.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntitySweetbag.class, 1500, 1, 2));
				event.list.add(new SpawnListEntry(DqmEntityTumurinmama.class, 1500, 1, 2));

				event.list.add(new SpawnListEntry(DqmEntityDesusutoka.class, 3000, 1, 2));



	            event.list.add(new SpawnListEntry(EntityEvolvedZombie.class, 3000, 1, 3));
	            event.list.add(new SpawnListEntry(EntityEvolvedSpider.class, 2000, 1, 2));
	            event.list.add(new SpawnListEntry(EntityEvolvedSkeleton.class, 1500, 1, 1));
	            event.list.add(new SpawnListEntry(EntityEvolvedCreeper.class, 2000, 1, 1));

	            event.list.add(new SpawnListEntry(EntityEnderman.class, 250, 1, 1));
			}
		}

	}
}
