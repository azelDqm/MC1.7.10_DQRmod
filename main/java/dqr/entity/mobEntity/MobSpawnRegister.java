package dqr.entity.mobEntity;

import java.util.Hashtable;
import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import dqr.DQR;
import dqr.entity.mobEntity.monsterDay.DqmEntityAyasiikage;
import dqr.entity.mobEntity.monsterDay.DqmEntityBigCrow;
import dqr.entity.mobEntity.monsterDay.DqmEntityBigguhatto;
import dqr.entity.mobEntity.monsterDay.DqmEntityBubsura;
import dqr.entity.mobEntity.monsterDay.DqmEntityBurauni;
import dqr.entity.mobEntity.monsterDay.DqmEntityButisuraimu;
import dqr.entity.mobEntity.monsterDay.DqmEntityDokuroarai;
import dqr.entity.mobEntity.monsterDay.DqmEntityDoronuba;
import dqr.entity.mobEntity.monsterDay.DqmEntityDorozara;
import dqr.entity.mobEntity.monsterDay.DqmEntityDoruido;
import dqr.entity.mobEntity.monsterDay.DqmEntityDragosuraimu;
import dqr.entity.mobEntity.monsterDay.DqmEntityDucksbill;
import dqr.entity.mobEntity.monsterDay.DqmEntityEbiruapple;
import dqr.entity.mobEntity.monsterDay.DqmEntityFaratto;
import dqr.entity.mobEntity.monsterDay.DqmEntityGaikotu;
import dqr.entity.mobEntity.monsterDay.DqmEntityGizumoAZ;
import dqr.entity.mobEntity.monsterDay.DqmEntityGuntaigani;
import dqr.entity.mobEntity.monsterDay.DqmEntityHitokuisaberu;
import dqr.entity.mobEntity.monsterDay.DqmEntityHoimisura;
import dqr.entity.mobEntity.monsterDay.DqmEntityIkkakuusagi;
import dqr.entity.mobEntity.monsterDay.DqmEntityItamogu;
import dqr.entity.mobEntity.monsterDay.DqmEntityKimera;
import dqr.entity.mobEntity.monsterDay.DqmEntityKirapan;
import dqr.entity.mobEntity.monsterDay.DqmEntityKirikabuobake;
import dqr.entity.mobEntity.monsterDay.DqmEntityMadohando;
import dqr.entity.mobEntity.monsterDay.DqmEntityMomon;
import dqr.entity.mobEntity.monsterDay.DqmEntityMomonja;
import dqr.entity.mobEntity.monsterDay.DqmEntityObakekinoko;
import dqr.entity.mobEntity.monsterDay.DqmEntityObakeumiusi;
import dqr.entity.mobEntity.monsterDay.DqmEntityOnikozou;
import dqr.entity.mobEntity.monsterDay.DqmEntityOokiduti;
import dqr.entity.mobEntity.monsterDay.DqmEntityOokutibasi;
import dqr.entity.mobEntity.monsterDay.DqmEntityOomedama;
import dqr.entity.mobEntity.monsterDay.DqmEntityOonamekuji;
import dqr.entity.mobEntity.monsterDay.DqmEntityPapetkozou;
import dqr.entity.mobEntity.monsterDay.DqmEntityPurizunyan;
import dqr.entity.mobEntity.monsterDay.DqmEntityRemonsuraimu;
import dqr.entity.mobEntity.monsterDay.DqmEntityRippusu;
import dqr.entity.mobEntity.monsterDay.DqmEntityRiripat;
import dqr.entity.mobEntity.monsterDay.DqmEntitySabotenboru;
import dqr.entity.mobEntity.monsterDay.DqmEntitySibirekurage;
import dqr.entity.mobEntity.monsterDay.DqmEntitySimasimacat;
import dqr.entity.mobEntity.monsterDay.DqmEntitySirudokozou;
import dqr.entity.mobEntity.monsterDay.DqmEntitySukippaa;
import dqr.entity.mobEntity.monsterDay.DqmEntitySunomon;
import dqr.entity.mobEntity.monsterDay.DqmEntitySupini;
import dqr.entity.mobEntity.monsterDay.DqmEntitySura;
import dqr.entity.mobEntity.monsterDay.DqmEntitySuraimubesu;
import dqr.entity.mobEntity.monsterDay.DqmEntitySuraimunaito;
import dqr.entity.mobEntity.monsterDay.DqmEntitySuraimutawa;
import dqr.entity.mobEntity.monsterDay.DqmEntitySuraimutumuri;
import dqr.entity.mobEntity.monsterDay.DqmEntityTogebouzu;
import dqr.entity.mobEntity.monsterDay.DqmEntityTukaima;
import dqr.entity.mobEntity.monsterDay.DqmEntityUzusioking;
import dqr.entity.mobEntity.monsterDay.DqmEntityWaraibukuro;
import dqr.entity.mobEntity.monsterDay.DqmEntityZinmentyou;
import dqr.entity.mobEntity.monsterDay.DqmEntityZukkinya;
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
import dqr.entity.mobEntity.monsterMetaru.DqmEntityDaiyamondosuraimu;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityDragometaru;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityHagumeta;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityHaguremetaruking;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetaking;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetaruburazazu;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetasura;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityPuratinaking;
import dqr.entity.mobEntity.monsterNight.DqmEntityAkumanosyo;
import dqr.entity.mobEntity.monsterNight.DqmEntityAnimaruzonbi;
import dqr.entity.mobEntity.monsterNight.DqmEntityArumiraji;
import dqr.entity.mobEntity.monsterNight.DqmEntityAxedoragon;
import dqr.entity.mobEntity.monsterNight.DqmEntityBaburin;
import dqr.entity.mobEntity.monsterNight.DqmEntityBakudanbebi;
import dqr.entity.mobEntity.monsterNight.DqmEntityBakudaniwa;
import dqr.entity.mobEntity.monsterNight.DqmEntityBebisatan;
import dqr.entity.mobEntity.monsterNight.DqmEntityBehoimisuraimu;
import dqr.entity.mobEntity.monsterNight.DqmEntityBehoimusuraimu;
import dqr.entity.mobEntity.monsterNight.DqmEntityBerobero;
import dqr.entity.mobEntity.monsterNight.DqmEntityBeronyaago;
import dqr.entity.mobEntity.monsterNight.DqmEntityBesuking;
import dqr.entity.mobEntity.monsterNight.DqmEntityBuchunpa;
import dqr.entity.mobEntity.monsterNight.DqmEntityBuraddihando;
import dqr.entity.mobEntity.monsterNight.DqmEntityButtizukinya;
import dqr.entity.mobEntity.monsterNight.DqmEntityDansunidoru;
import dqr.entity.mobEntity.monsterNight.DqmEntityDesufuratta;
import dqr.entity.mobEntity.monsterNight.DqmEntityDokuyazukin;
import dqr.entity.mobEntity.monsterNight.DqmEntityDoraki;
import dqr.entity.mobEntity.monsterNight.DqmEntityDorakima;
import dqr.entity.mobEntity.monsterNight.DqmEntityDoroningyou;
import dqr.entity.mobEntity.monsterNight.DqmEntityEnzeruslime;
import dqr.entity.mobEntity.monsterNight.DqmEntityFgizumo;
import dqr.entity.mobEntity.monsterNight.DqmEntityGaikotukensi;
import dqr.entity.mobEntity.monsterNight.DqmEntityGappurin;
import dqr.entity.mobEntity.monsterNight.DqmEntityGenjutusi;
import dqr.entity.mobEntity.monsterNight.DqmEntityGhost;
import dqr.entity.mobEntity.monsterNight.DqmEntityGorotuki;
import dqr.entity.mobEntity.monsterNight.DqmEntityHerughost;
import dqr.entity.mobEntity.monsterNight.DqmEntityHgizumo;
import dqr.entity.mobEntity.monsterNight.DqmEntityHitokuiga;
import dqr.entity.mobEntity.monsterNight.DqmEntityHoroghost;
import dqr.entity.mobEntity.monsterNight.DqmEntityHyouganmajin;
import dqr.entity.mobEntity.monsterNight.DqmEntityJeriman;
import dqr.entity.mobEntity.monsterNight.DqmEntityKingsura;
import dqr.entity.mobEntity.monsterNight.DqmEntityKirapan2;
import dqr.entity.mobEntity.monsterNight.DqmEntityKirasuko;
import dqr.entity.mobEntity.monsterNight.DqmEntityMapetman;
import dqr.entity.mobEntity.monsterNight.DqmEntityMarinsuraimu;
import dqr.entity.mobEntity.monsterNight.DqmEntityMatango;
import dqr.entity.mobEntity.monsterNight.DqmEntityMeijidoraki;
import dqr.entity.mobEntity.monsterNight.DqmEntityMeijikimera;
import dqr.entity.mobEntity.monsterNight.DqmEntityMeragosuto;
import dqr.entity.mobEntity.monsterNight.DqmEntityMetaruhantaken;
import dqr.entity.mobEntity.monsterNight.DqmEntityMetaruraida;
import dqr.entity.mobEntity.monsterNight.DqmEntityMetoroghost;
import dqr.entity.mobEntity.monsterNight.DqmEntityMinidemon;
import dqr.entity.mobEntity.monsterNight.DqmEntityMokomokojuu;
import dqr.entity.mobEntity.monsterNight.DqmEntityMrippusu;
import dqr.entity.mobEntity.monsterNight.DqmEntityNightwalker;
import dqr.entity.mobEntity.monsterNight.DqmEntityObakekyandoru;
import dqr.entity.mobEntity.monsterNight.DqmEntityOdoruhouseki;
import dqr.entity.mobEntity.monsterNight.DqmEntityPinkmomon;
import dqr.entity.mobEntity.monsterNight.DqmEntityRaimusuraimu;
import dqr.entity.mobEntity.monsterNight.DqmEntitySamayoutamasii;
import dqr.entity.mobEntity.monsterNight.DqmEntitySamayouyoroi;
import dqr.entity.mobEntity.monsterNight.DqmEntitySibireageha;
import dqr.entity.mobEntity.monsterNight.DqmEntitySibiredanbira;
import dqr.entity.mobEntity.monsterNight.DqmEntitySkullgaroo;
import dqr.entity.mobEntity.monsterNight.DqmEntitySumairurokku;
import dqr.entity.mobEntity.monsterNight.DqmEntitySumoruguru;
import dqr.entity.mobEntity.monsterNight.DqmEntitySupekutetto;
import dqr.entity.mobEntity.monsterNight.DqmEntitySura2;
import dqr.entity.mobEntity.monsterNight.DqmEntitySuraimubogu;
import dqr.entity.mobEntity.monsterNight.DqmEntitySuraimuburesu;
import dqr.entity.mobEntity.monsterNight.DqmEntitySyado;
import dqr.entity.mobEntity.monsterNight.DqmEntityTahodoraki;
import dqr.entity.mobEntity.monsterNight.DqmEntityTomosibikozou;
import dqr.entity.mobEntity.monsterNight.DqmEntityTonburero;
import dqr.entity.mobEntity.monsterNight.DqmEntityTororu;
import dqr.entity.mobEntity.monsterNight.DqmEntityTutiwarasi;
import dqr.entity.mobEntity.monsterNight.DqmEntityUmiusi;
import dqr.entity.mobEntity.monsterNight.DqmEntityYouganmajin;

public class MobSpawnRegister {

	public static BiomeGenBase[] all;
	public static BiomeGenBase[] overworld;
	public static BiomeGenBase[] end;
	public static BiomeGenBase[] nether;
	public static BiomeGenBase[] desert;
	public static BiomeGenBase[] plains;
	public static BiomeGenBase[] ice;
	public static BiomeGenBase[] noNether;

    static BiomeGenBase[] metaru1 = { BiomeGenBase.forest, BiomeGenBase.swampland, BiomeGenBase.desert, BiomeGenBase.taiga, BiomeGenBase.icePlains, BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.jungle, BiomeGenBase.river, BiomeGenBase.beach, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore };
    static BiomeGenBase[] metaru2 = { BiomeGenBase.forest, BiomeGenBase.swampland, BiomeGenBase.desert, BiomeGenBase.taiga, BiomeGenBase.extremeHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore };
    static BiomeGenBase[] metaru3 = { BiomeGenBase.extremeHillsEdge, BiomeGenBase.forestHills, BiomeGenBase.taigaHills, BiomeGenBase.jungleHills, BiomeGenBase.desertHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore };
    static BiomeGenBase[] metaru4 = { BiomeGenBase.hell, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.taigaHills };
    static BiomeGenBase[] metaru5 = { BiomeGenBase.sky, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.jungleHills };

    public Hashtable notOverWorldHT;
    public Hashtable netherHT;
    public Hashtable endHT;

	public MobSpawnRegister()
	{
		all =  new BiomeGenBase[]{BiomeGenBase.plains,BiomeGenBase.desert};


		createBiomeGenBase();
		registerSpawn();

	}

	public void createBiomeGenBase()
	{
		int setCount = 0;
		int setCount2 = 0;
		int setCount3 = 0;
		int totalCount = 0;
		int netherCount = 0;
		BiomeGenBase[] wkBiome = new BiomeGenBase[BiomeGenBase.getBiomeGenArray().length];
		BiomeGenBase[] wkAllBiome = new BiomeGenBase[BiomeGenBase.getBiomeGenArray().length];
		BiomeGenBase tmpBiome;


		notOverWorldHT = new Hashtable();
		netherHT = new Hashtable();
		endHT = new Hashtable();


		//エンド
		setCount = 0;
		totalCount = BiomeDictionary.getBiomesForType(Type.MUSHROOM).length +
					 BiomeDictionary.getBiomesForType(Type.END).length;
		end = new BiomeGenBase[totalCount];
		for(int cnt = 0;cnt < BiomeDictionary.getBiomesForType(Type.MUSHROOM).length; cnt++)
		{
			notOverWorldHT.put(BiomeDictionary.getBiomesForType(Type.MUSHROOM)[cnt].biomeID, BiomeDictionary.getBiomesForType(Type.MUSHROOM)[cnt]);
			endHT.put(BiomeDictionary.getBiomesForType(Type.MUSHROOM)[cnt].biomeID, BiomeDictionary.getBiomesForType(Type.MUSHROOM)[cnt]);
			end[cnt] = BiomeDictionary.getBiomesForType(Type.MUSHROOM)[cnt];
			setCount++;
		}
		for(int cnt = 0;cnt < BiomeDictionary.getBiomesForType(Type.END).length; cnt++)
		{
			notOverWorldHT.put(BiomeDictionary.getBiomesForType(Type.END)[cnt].biomeID, BiomeDictionary.getBiomesForType(Type.END)[cnt]);
			endHT.put(BiomeDictionary.getBiomesForType(Type.END)[cnt].biomeID, BiomeDictionary.getBiomesForType(Type.END)[cnt]);
			end[setCount] = BiomeDictionary.getBiomesForType(Type.END)[cnt];
			setCount++;
		}

		nether = BiomeDictionary.getBiomesForType(Type.NETHER);
		for(int cnt = 0;cnt < BiomeDictionary.getBiomesForType(Type.NETHER).length; cnt++)
		{
			notOverWorldHT.put(BiomeDictionary.getBiomesForType(Type.NETHER)[cnt].biomeID, BiomeDictionary.getBiomesForType(Type.NETHER)[cnt]);
			netherHT.put(BiomeDictionary.getBiomesForType(Type.NETHER)[cnt].biomeID, BiomeDictionary.getBiomesForType(Type.NETHER)[cnt]);
			netherCount++;
		}

		desert =  BiomeDictionary.getBiomesForType(Type.SANDY);
		plains =  BiomeDictionary.getBiomesForType(Type.PLAINS);
		ice =  BiomeDictionary.getBiomesForType(Type.SNOWY);

		setCount = 0;
		setCount2 = 0;
		for(int cnt = 0; cnt < BiomeGenBase.getBiomeGenArray().length; cnt++)
		{
			tmpBiome = BiomeGenBase.getBiomeGenArray()[cnt];

			if(tmpBiome != null)
			{
				wkAllBiome[setCount] = tmpBiome;
				if(!notOverWorldHT.containsKey(tmpBiome.biomeID))
				{
					wkBiome[setCount2] = tmpBiome;
					setCount2++;
				}
				setCount++;
			}
		}

		overworld = new BiomeGenBase[setCount2];
		for(int cnt = 0; cnt < setCount2; cnt++)
		{
			overworld[cnt] = wkBiome[cnt];
		}

		all = new BiomeGenBase[setCount];
		for(int cnt = 0; cnt < setCount; cnt++)
		{
			all[cnt] = wkAllBiome[cnt];
		}

		noNether = new BiomeGenBase[setCount - netherCount];
		for(int cnt = 0; cnt < setCount; cnt++)
		{
			tmpBiome = wkAllBiome[cnt];
			if(!netherHT.containsKey(tmpBiome.biomeID))
			{
				noNether[setCount3] = tmpBiome;
				setCount3++;
			}
		}

		//for(int i = 0; i < end.length; i++)
		//{
		//	System.out.println("DEBUGLINE:" + end[i].biomeName);
		//}
	}


	public void registerSpawn()
	{

		//this.addSpawn(EntityMeleeSkeleton.class, 20, 1, 4, DQR.dqmCreatureType.DqmMonster, new BiomeGenBase[]{BiomeGenBase.plains});
		//this.addSpawn(DqmEntitySura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, new BiomeGenBase[]{BiomeGenBase.plains});
		//this.addSpawn(DqmEntityKingsura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
/*
		this.addSpawn(DqmEntityAyasiikage.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBigCrow.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBigguhatto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBubsura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBurauni.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityButisuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityDokuroarai.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityDoronuba.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityDorozara.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityDragosuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDucksbill.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityGizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGizumoAZ.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGuntaigani.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityHitokuikibako.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityHitokuisaberu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityHoimisura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityIkkakuusagi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityItamogu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKimera.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityKirapan.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityKirikabuobake.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityMadohando.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityMomon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMomonja.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityObakekinoko.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityObakeumiusi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityOnikozou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityOokiduti.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityOokutibasi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityOomedama.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityOonamekuji.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityPapetkozou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityPurizunyan.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityRippusu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityRiripat.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySibirekurage.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntitySimasimacat.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySirudokozou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntitySukippaa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySunomon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntitySupini.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySuraimubesu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySuraimunaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySuraimutawa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySuraimutumuri.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityTogebouzu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
//		this.addSpawn(DqmEntityTubo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTukaima.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityUzusioking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityWaraibukuro.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityZinmentyou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityZukkinya.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySuraimuking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);



		this.addSpawn(DqmEntityAkumanosyo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
//		this.addSpawn(DqmEntityAkumanotubo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityAnimaruzonbi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityArumiraji.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityBaburin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBakudanbebi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityBakudaniwa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityBebisatan.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityBehoimisuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityBehoimusuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityBerobero.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBeronyaago.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityBuchunpa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityBuraddihando.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityButtizukinya.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityDesufuratta.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityDokuyazukin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityDoraki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDorakima.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityEnzeruslime.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityFgizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityFurosutogizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityGaikotukensi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGhost.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityHerughost.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityHgizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityHiitogizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
//		this.addSpawn(DqmEntityHitokuibako.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityHitokuiga.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityHoroghost.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityHyouganmajin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityJeriman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityKingsura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKirapan2.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKirasuko.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityMapetman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMarinsuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityMatango.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityMeijidoraki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityMeijikimera.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityMeragosuto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMetaruraida.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityMetoroghost.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMimikku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
//		this.addSpawn(DqmEntityMimikkukibako.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMinidemon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityNightwalker.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityObakekyandoru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityOdoruhouseki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityPinkmomon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySamayoutamasii.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySibireageha.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySibiredanbira.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntitySkullgaroo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySumairurokku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntitySumoruguru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySupekutetto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySura2.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySuraimubogu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySuraimuburesu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySyado.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTahodoraki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityTomosibikozou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityTonburero.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityTutiwarasi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityUmiusi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		*/
		//this.addSpawn(DqmEntityYouganmajin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
/*
		this.addSpawn(DqmEntityGorudentotemu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityAnkokumajin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityAroinpu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBaburuking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBarakku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBariidodog.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBatorurex.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBehomasuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBiggufeisu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBoureikensi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBuraddosodo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityBurakkubejita.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDarkslime.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDeddopekka.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDgizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDollmaster.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDqmdragon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDragonnaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityDragonraida.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGamegon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGamegonload.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGanirasu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGoldman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityGoremu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityHotatewarabi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityJigokunohasami.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKemunkurusu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKirakurabu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKiramasin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKisudragon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityKuinsuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMagematango.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMagemomonja.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMagumaron.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMajikaruhatto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMaounokage.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMaporena.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMegazarurokku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMetaruhanta.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityMetaruhantaken.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityPandorabox.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
//		this.addSpawn(DqmEntityPandorakibako.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityPikusi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityPombom.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityPuyon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityRedsaikuron.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySaikuropusu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySirubadebiru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySiryounokisi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySodofantomu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityStarkimera.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityStonman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySuraimubehomazun.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySuraimuhaitawa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntitySuraimumadyura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
//		this.addSpawn(DqmEntityTubokku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		this.addSpawn(DqmEntityUmibouzu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);

		this.addSpawn(DqmEntityGorudensuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityAkairai.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityBiggumoai.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDakuhobitto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDakunaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDasudragon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDenga.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDesujakkaru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityDragondarknaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityGamegonrejendo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityGigantesu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityGodraida.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityKagenokisi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		this.addSpawn(DqmEntityRyuiso.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);

		this.addSpawn(DqmEntityDaiyamondosuraimu.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru4);
		this.addSpawn(DqmEntityDragometaru.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru3);
		this.addSpawn(DqmEntityHagumeta.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru2);
		this.addSpawn(DqmEntityHaguremetaruking.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru5);
		this.addSpawn(DqmEntityMetaking.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru3);
		this.addSpawn(DqmEntityMetaruburazazu.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru1);
		this.addSpawn(DqmEntityMetasura.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru1);
		this.addSpawn(DqmEntityPuratinaking.class, 1, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru4);


		this.addSpawn(DqmEntityAxedoragon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBassaimasin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBesuking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBighanma.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBosutororu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBurizado.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDansunidoru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDarktororu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDesunyago.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDoragonsoruja.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDoroningyou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDoruido.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityEbiruapple.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityFaratto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityFureimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGaikotu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGappurin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGenjutusi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGoldmanto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityHatonaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityJigokunoyoroi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKandatakobun.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKedamon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKimendousi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKiraama.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKiramasin2.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityManemane.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMasso.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMetaruhoimin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMokomokojuu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMomoirosansimai.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityNoroinoiwa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityPapettoman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityPinkbonbon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityPisaronaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityPuremiasuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityRaimusuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityRemonsuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySabotenboru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySabotengold.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);

		this.addSpawn(DqmEntitySamayouyoroi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySirudoaniki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySiryou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTattyan.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTororu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTororubakkosu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTororubonba.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTororuking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTumurinmama.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityUragirikozou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);

		this.addSpawn(DqmEntityMadrainbow.class, 20, 10, 20, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySweetbag.class, 20, 10, 20, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityShuvaluts.class, 20, 10, 20, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBebingosatan.class, 20, 10, 20, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDebirurodo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);

		//this.addSpawn(DqmEntityGoldenmetalslime.class, 70, 10, 20, DQR.dqmCreatureType.DqmMonster, overworld);
		//this.addSpawn(DqmEntityBurasu.class, 70, 10, 20, DQR.dqmCreatureType.DqmMonster, overworld);
*/
/*==============================================================*/


		this.addSpawn(DqmEntityGorotuki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);

		this.addSpawn(DqmEntityDokuroarai.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityDorozara.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityMadohando.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityObakeumiusi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntitySirudokozou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityUzusioking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityDucksbill.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityMomonja.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityPurizunyan.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntitySibirekurage.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntitySunomon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntitySuraimutumuri.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityAyasiikage.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBigCrow.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBigguhatto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBubsura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDoruido.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDragosuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);

		this.addSpawn(DqmEntityEbiruapple.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityFaratto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGaikotu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		//this.addSpawn(DqmEntityGizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGizumoAZ.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGuntaigani.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		//this.addSpawn(DqmEntityHitokuikibako.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityHitokuisaberu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityIkkakuusagi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityItamogu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		//this.addSpawn(DqmEntityKingbesu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMomon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityOnikozou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityOokiduti.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityOonamekuji.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityRemonsuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityRippusu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySabotenboru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySimasimacat.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySupini.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySuraimubesu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTogebouzu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		//this.addSpawn(DqmEntityTubo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTukaima.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityZinmentyou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityZukkinya.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBurauni.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);

		this.addSpawn(DqmEntityButisuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityDoronuba.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityHoimisura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityKimera.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityKirapan.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityKirikabuobake.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityObakekinoko.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityOokutibasi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityOomedama.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityPapetkozou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityRiripat.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySukippaa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		//this.addSpawn(DqmEntitySuraimuking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySuraimunaito.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySuraimutawa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityWaraibukuro.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityBakudaniwa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityBehoimusuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityBeronyaago.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityHgizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		//this.addSpawn(DqmEntityHiitogizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityMeijikimera.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityMetaruraida.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityOdoruhouseki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntitySibiredanbira.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityYouganmajin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
		this.addSpawn(DqmEntityAkumanosyo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityArumiraji.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityBuraddihando.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityFgizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		//this.addSpawn(DqmEntityFurosutogizumo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityHoroghost.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityHyouganmajin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityJeriman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityMarinsuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntitySumairurokku.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityTahodoraki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityTomosibikozou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
		this.addSpawn(DqmEntityMetaruhantaken.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		//this.addSpawn(DqmEntityAkumanotubo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityAxedoragon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBaburin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBerobero.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityBesuking.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDansunidoru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDoraki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityDoroningyou.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGaikotukensi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGappurin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGenjutusi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityGhost.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityHerughost.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		//this.addSpawn(DqmEntityHitokuibako.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKingsura.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityKirapan2.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMapetman.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMeragosuto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMetoroghost.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		//this.addSpawn(DqmEntityMimikkukibako.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMinidemon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMokomokojuu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityMrippusu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityObakekyandoru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityRaimusuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySamayoutamasii.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySamayouyoroi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySkullgaroo.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySumoruguru.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySuraimubogu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySuraimuburesu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntitySyado.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTororu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityTutiwarasi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
		this.addSpawn(DqmEntityAnimaruzonbi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityBakudanbebi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityBebisatan.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityBehoimisuraimu.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityBuchunpa.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityButtizukinya.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityDesufuratta.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityDokuyazukin.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityDorakima.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityEnzeruslime.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityHitokuiga.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityKirasuko.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityMatango.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityMeijidoraki.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityNightwalker.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityPinkmomon.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySibireageha.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySupekutetto.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntitySura2.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityTonburero.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		this.addSpawn(DqmEntityUmiusi.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, plains);


		this.addSpawn(DqmEntityMetaruburazazu.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru1);
		this.addSpawn(DqmEntityMetasura.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru1);
		this.addSpawn(DqmEntityHagumeta.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru2);
		this.addSpawn(DqmEntityDragometaru.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru3);
		this.addSpawn(DqmEntityMetaking.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru3);
		this.addSpawn(DqmEntityDaiyamondosuraimu.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru4);
		this.addSpawn(DqmEntityPuratinaking.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru4);
		//this.addSpawn(DqmEntityGoldenmetalslime.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru5);
		this.addSpawn(DqmEntityHaguremetaruking.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru5);

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

