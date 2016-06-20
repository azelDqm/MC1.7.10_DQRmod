package dqr.addons;

import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import biomesoplenty.api.content.BOPCBiomes;
import dqr.DQR;
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
import dqr.entity.mobEntity.monsterHell.DqmEntityAnkokumajin;
import dqr.entity.mobEntity.monsterHell.DqmEntityAroinpu;
import dqr.entity.mobEntity.monsterHell.DqmEntityBaburuking;
import dqr.entity.mobEntity.monsterHell.DqmEntityBarakku;
import dqr.entity.mobEntity.monsterHell.DqmEntityBariidodog;
import dqr.entity.mobEntity.monsterHell.DqmEntityBehomasuraimu;
import dqr.entity.mobEntity.monsterHell.DqmEntityBiggufeisu;
import dqr.entity.mobEntity.monsterHell.DqmEntityBighanma;
import dqr.entity.mobEntity.monsterHell.DqmEntityBosutororu;
import dqr.entity.mobEntity.monsterHell.DqmEntityBoureikensi;
import dqr.entity.mobEntity.monsterHell.DqmEntityBuraddosodo;
import dqr.entity.mobEntity.monsterHell.DqmEntityBurakkubejita;
import dqr.entity.mobEntity.monsterHell.DqmEntityDarkslime;
import dqr.entity.mobEntity.monsterHell.DqmEntityDeddopekka;
import dqr.entity.mobEntity.monsterHell.DqmEntityDgizumo;
import dqr.entity.mobEntity.monsterHell.DqmEntityDollmaster;
import dqr.entity.mobEntity.monsterHell.DqmEntityDoragonsoruja;
import dqr.entity.mobEntity.monsterHell.DqmEntityDqmdragon;
import dqr.entity.mobEntity.monsterHell.DqmEntityDragonnaito;
import dqr.entity.mobEntity.monsterHell.DqmEntityDragonraida;
import dqr.entity.mobEntity.monsterHell.DqmEntityEriminator;
import dqr.entity.mobEntity.monsterHell.DqmEntityFureimu;
import dqr.entity.mobEntity.monsterHell.DqmEntityGamegon;
import dqr.entity.mobEntity.monsterHell.DqmEntityGamegonload;
import dqr.entity.mobEntity.monsterHell.DqmEntityGanirasu;
import dqr.entity.mobEntity.monsterHell.DqmEntityGoldman;
import dqr.entity.mobEntity.monsterHell.DqmEntityGoremu;
import dqr.entity.mobEntity.monsterHell.DqmEntityGorudentotemu;
import dqr.entity.mobEntity.monsterHell.DqmEntityHotatewarabi;
import dqr.entity.mobEntity.monsterHell.DqmEntityJigokunohasami;
import dqr.entity.mobEntity.monsterHell.DqmEntityKedamon;
import dqr.entity.mobEntity.monsterHell.DqmEntityKemunkurusu;
import dqr.entity.mobEntity.monsterHell.DqmEntityKimendousi;
import dqr.entity.mobEntity.monsterHell.DqmEntityKiraama;
import dqr.entity.mobEntity.monsterHell.DqmEntityKirakurabu;
import dqr.entity.mobEntity.monsterHell.DqmEntityKiramasin;
import dqr.entity.mobEntity.monsterHell.DqmEntityKiramasin2;
import dqr.entity.mobEntity.monsterHell.DqmEntityKisudragon;
import dqr.entity.mobEntity.monsterHell.DqmEntityKuinsuraimu;
import dqr.entity.mobEntity.monsterHell.DqmEntityMagematango;
import dqr.entity.mobEntity.monsterHell.DqmEntityMagemomonja;
import dqr.entity.mobEntity.monsterHell.DqmEntityMagumaron;
import dqr.entity.mobEntity.monsterHell.DqmEntityMajikaruhatto;
import dqr.entity.mobEntity.monsterHell.DqmEntityMaounokage;
import dqr.entity.mobEntity.monsterHell.DqmEntityMaporena;
import dqr.entity.mobEntity.monsterHell.DqmEntityMegazarurokku;
import dqr.entity.mobEntity.monsterHell.DqmEntityMimikku;
import dqr.entity.mobEntity.monsterHell.DqmEntityPapettoman;
import dqr.entity.mobEntity.monsterHell.DqmEntityPikusi;
import dqr.entity.mobEntity.monsterHell.DqmEntityPombom;
import dqr.entity.mobEntity.monsterHell.DqmEntityPuyon;
import dqr.entity.mobEntity.monsterHell.DqmEntityRedsaikuron;
import dqr.entity.mobEntity.monsterHell.DqmEntitySaikuropusu;
import dqr.entity.mobEntity.monsterHell.DqmEntitySirubadebiru;
import dqr.entity.mobEntity.monsterHell.DqmEntitySiryou;
import dqr.entity.mobEntity.monsterHell.DqmEntitySiryounokisi;
import dqr.entity.mobEntity.monsterHell.DqmEntitySodofantomu;
import dqr.entity.mobEntity.monsterHell.DqmEntityStarkimera;
import dqr.entity.mobEntity.monsterHell.DqmEntityStonman;
import dqr.entity.mobEntity.monsterHell.DqmEntitySuraimubehomazun;
import dqr.entity.mobEntity.monsterHell.DqmEntitySuraimuhaitawa;
import dqr.entity.mobEntity.monsterHell.DqmEntitySuraimumadyura;
import dqr.entity.mobEntity.monsterHell.DqmEntityTororuking;
import dqr.entity.mobEntity.monsterHell.DqmEntityUmibouzu;
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

public class DqrAddonBiomesOPlenty {

	public DqrAddonBiomesOPlenty()
	{

		BiomeGenBase[] nether = {BOPCBiomes.deadForest, BOPCBiomes.deadSwamp, BOPCBiomes.quagmire,
								 BOPCBiomes.silkglades, BOPCBiomes.wasteland, BOPCBiomes.garden, BOPCBiomes.ominousWoods};
		BiomeGenBase[] end = {BOPCBiomes.fungiForest, BOPCBiomes.wasteland, BOPCBiomes.garden, BOPCBiomes.volcano};
		BiomeGenBase[] ALL = {BOPCBiomes.volcano, BOPCBiomes.mysticGrove};

		BiomeGenBase[] end1 = {BOPCBiomes.ominousWoods};


		this.addSpawn(DqmEntityAnkokumajin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityAroinpu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBaburuking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBarakku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBariidodog.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBehomasuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBiggufeisu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBighanma.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBosutororu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBoureikensi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBuraddosodo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBurakkubejita.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDarkslime.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDeddopekka.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDgizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDollmaster.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDoragonsoruja.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDqmdragon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDragonnaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDragonraida.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityFureimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGamegon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGamegonload.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGanirasu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGoldman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGoremu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGorudentotemu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityHotatewarabi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityJigokunohasami.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKedamon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKemunkurusu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKimendousi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKiraama.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKirakurabu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKiramasin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKiramasin2.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKisudragon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKuinsuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMagematango.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMagemomonja.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMagumaron.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMajikaruhatto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMaounokage.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMaporena.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMegazarurokku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		//this.addSpawn(DqmEntityMetaruhanta.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMimikku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		//this.addSpawn(DqmEntityPandorakibako.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityPapettoman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityPikusi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityPombom.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityPuyon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityRedsaikuron.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySaikuropusu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySirubadebiru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySiryou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySiryounokisi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySodofantomu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityStarkimera.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityStonman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySuraimubehomazun.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySuraimuhaitawa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySuraimumadyura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityTororuking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		//this.addSpawn(DqmEntityTubokku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityUmibouzu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityEriminator.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);



		this.addSpawn(DqmEntityAkairai.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityBassaimasin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityBatorurex.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityBiggumoai.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityBurizado.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDakunaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDarktororu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDasudragon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDenga.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDesujakkaru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDesunyago.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDragondarknaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityGamegonrejendo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityGigantesu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityGodraida.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityGorudensuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityJigokunoyoroi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityKagenokisi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityManemane.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityPandorabox.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityRyuiso.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityTororubonba.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDesusutoka.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);

		this.addSpawn(DqmEntityAkairai.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityBassaimasin.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityBatorurex.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityBiggumoai.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityBurizado.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityDakunaito.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityDarktororu.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityDasudragon.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityDenga.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityDesujakkaru.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityDesunyago.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityDragondarknaito.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityGamegonrejendo.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityGigantesu.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityGodraida.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityGorudensuraimu.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityJigokunoyoroi.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityKagenokisi.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityManemane.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityPandorabox.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityRyuiso.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityTororubonba.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);
		this.addSpawn(DqmEntityDesusutoka.class, 1, 1, 2, DQR.dqmCreatureType.DqmMonster, end1);

		this.addSpawn(DqmEntityWanpakusatan.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityKiratoti.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityMashougumo.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntitySirubamanto.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityDarkRamia.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityGodonheddo.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityAtorasu.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityYamatanooroti.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityBazuzu.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityKiramajinga.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntitySuraimujeneraru.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityBurasu.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityKandatakobun.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityKinghidora.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityMasso.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityPisaronaito.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityPuremiasuraimu.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityTattyan.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityTororubakkosu.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityUragirikozou.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityFureizado.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntitySeigin.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityDebirurodo.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityMaaburun.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityArukemisuton.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityGorudenkon.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityKuinmomon.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityMoonkimera.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityTyokonuba.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityReddoatya.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityKirapike.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityTogekonbou.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityTaipug.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityBebingosatan.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityGoldmanto.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityHatonaito.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityMadrainbow.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityMetaruhoimin.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityMomoirosansimai.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityNoroinoiwa.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityPinkbonbon.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntitySabotengold.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityShuvaluts.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntitySirudoaniki.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntitySweetbag.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityTumurinmama.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);

		this.addSpawn(DqmEntityDesupisaro1.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityRyuuou.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityZoma.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityMasterdoragon.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);
		this.addSpawn(DqmEntityEsterk.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, ALL);


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
}
