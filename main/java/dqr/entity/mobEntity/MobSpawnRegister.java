package dqr.entity.mobEntity;

import java.lang.reflect.Field;
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
import dqr.entity.mobEntity.monsterDay.DqmMobBaseDay;
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
import dqr.entity.mobEntity.monsterEnd.DqmEntityShadopan2;
import dqr.entity.mobEntity.monsterEnd.DqmEntityTororubonba;
import dqr.entity.mobEntity.monsterEnd.DqmMobBaseEnd;
import dqr.entity.mobEntity.monsterEtc.DqmEntityFurosutogizumo;
import dqr.entity.mobEntity.monsterEtc.DqmEntityGizumo;
import dqr.entity.mobEntity.monsterEtc.DqmEntityHiitogizumo;
import dqr.entity.mobEntity.monsterEtc.DqmEntityKingbesu;
import dqr.entity.mobEntity.monsterEtc.DqmEntityMimikkukibako;
import dqr.entity.mobEntity.monsterEtc.DqmEntityPandorakibako;
import dqr.entity.mobEntity.monsterEtc.DqmEntitySuraimuking;
import dqr.entity.mobEntity.monsterEtc.DqmEntityTubo;
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
import dqr.entity.mobEntity.monsterHell.DqmEntityDarkdoriado;
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
import dqr.entity.mobEntity.monsterHell.DqmEntityShadopan;
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
import dqr.entity.mobEntity.monsterHell.DqmEntityWhitepan2;
import dqr.entity.mobEntity.monsterHell.DqmMobBaseHell;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityDaiyamondosuraimu;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityDragometaru;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityHagumeta;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityHaguremetaruking;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetaking;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetaruburazazu;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetasura;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityPuratinaking;
import dqr.entity.mobEntity.monsterMetaru.DqmMobBaseMetaru;
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
import dqr.entity.mobEntity.monsterNight.DqmMobBaseNight;

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


		/*
		if(DQR.conf.spawn_resist_overworld == 0)
		{
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
		}


		if(DQR.conf.spawn_resist_metal == 0)
		{
			this.addSpawn(DqmEntityMetaruburazazu.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru1);
			this.addSpawn(DqmEntityMetasura.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru1);
			this.addSpawn(DqmEntityHagumeta.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru2);
			this.addSpawn(DqmEntityDragometaru.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru3);
			this.addSpawn(DqmEntityMetaking.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru3);
			this.addSpawn(DqmEntityDaiyamondosuraimu.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru4);
			this.addSpawn(DqmEntityPuratinaking.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru4);
			//this.addSpawn(DqmEntityGoldenmetalslime.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru5);
			this.addSpawn(DqmEntityHaguremetaruking.class, 4, 1, 1, DQR.dqmCreatureType.DqmMonster, metaru5);
		}

		if(DQR.conf.spawn_resist_nether == 0)
		{
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
			this.addSpawn(DqmEntityDarkdoriado.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityShadopan.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityWhitepan2.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		}

		if(DQR.conf.spawn_resist_end == 0)
		{
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
			this.addSpawn(DqmEntityShadopan2.class, 20, 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		}
		*/

		if(DQR.conf2.spawn_resist_overworld_day == 0)
		{
			this.addSpawn(DqmEntityGorotuki.class, this.getMobSpawnWeight(DqmEntityGorotuki.class, "DqmEntityGorotuki" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);

			this.addSpawn(DqmEntityDokuroarai.class, this.getMobSpawnWeight(DqmEntityDokuroarai.class, "DqmEntityDokuroarai" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityDorozara.class, this.getMobSpawnWeight(DqmEntityDorozara.class, "DqmEntityDorozara" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityMadohando.class, this.getMobSpawnWeight(DqmEntityMadohando.class, "DqmEntityMadohando" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityObakeumiusi.class, this.getMobSpawnWeight(DqmEntityObakeumiusi.class, "DqmEntityObakeumiusi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntitySirudokozou.class, this.getMobSpawnWeight(DqmEntitySirudokozou.class, "DqmEntitySirudokozou" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityUzusioking.class, this.getMobSpawnWeight(DqmEntityUzusioking.class, "DqmEntityUzusioking" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityDucksbill.class, this.getMobSpawnWeight(DqmEntityDucksbill.class, "DqmEntityDucksbill" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityMomonja.class, this.getMobSpawnWeight(DqmEntityMomonja.class, "DqmEntityMomonja" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityPurizunyan.class, this.getMobSpawnWeight(DqmEntityPurizunyan.class, "DqmEntityPurizunyan" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntitySibirekurage.class, this.getMobSpawnWeight(DqmEntitySibirekurage.class, "DqmEntitySibirekurage" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntitySunomon.class, this.getMobSpawnWeight(DqmEntitySunomon.class, "DqmEntitySunomon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntitySuraimutumuri.class, this.getMobSpawnWeight(DqmEntitySuraimutumuri.class, "DqmEntitySuraimutumuri" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityAyasiikage.class, this.getMobSpawnWeight(DqmEntityAyasiikage.class, "DqmEntityAyasiikage" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityBigCrow.class, this.getMobSpawnWeight(DqmEntityBigCrow.class, "DqmEntityBigCrow" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityBigguhatto.class, this.getMobSpawnWeight(DqmEntityBigguhatto.class, "DqmEntityBigguhatto" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityBubsura.class, this.getMobSpawnWeight(DqmEntityBubsura.class, "DqmEntityBubsura" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityDoruido.class, this.getMobSpawnWeight(DqmEntityDoruido.class, "DqmEntityDoruido" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityDragosuraimu.class, this.getMobSpawnWeight(DqmEntityDragosuraimu.class, "DqmEntityDragosuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);

			this.addSpawn(DqmEntityEbiruapple.class, this.getMobSpawnWeight(DqmEntityEbiruapple.class, "DqmEntityEbiruapple" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityFaratto.class, this.getMobSpawnWeight(DqmEntityFaratto.class, "DqmEntityFaratto" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityGaikotu.class, this.getMobSpawnWeight(DqmEntityGaikotu.class, "DqmEntityGaikotu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			//this.addSpawn(DqmEntityGizumo.class, this.getMobSpawnWeight(//DqmEntityGizumo.class, "//DqmEntityGizumo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityGizumoAZ.class, this.getMobSpawnWeight(DqmEntityGizumoAZ.class, "DqmEntityGizumoAZ" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityGuntaigani.class, this.getMobSpawnWeight(DqmEntityGuntaigani.class, "DqmEntityGuntaigani" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			//this.addSpawn(DqmEntityHitokuikibako.class, this.getMobSpawnWeight(//DqmEntityHitokuikibako.class, "//DqmEntityHitokuikibako" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityHitokuisaberu.class, this.getMobSpawnWeight(DqmEntityHitokuisaberu.class, "DqmEntityHitokuisaberu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityIkkakuusagi.class, this.getMobSpawnWeight(DqmEntityIkkakuusagi.class, "DqmEntityIkkakuusagi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityItamogu.class, this.getMobSpawnWeight(DqmEntityItamogu.class, "DqmEntityItamogu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			//this.addSpawn(DqmEntityKingbesu.class, this.getMobSpawnWeight(//DqmEntityKingbesu.class, "//DqmEntityKingbesu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityMomon.class, this.getMobSpawnWeight(DqmEntityMomon.class, "DqmEntityMomon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityOnikozou.class, this.getMobSpawnWeight(DqmEntityOnikozou.class, "DqmEntityOnikozou" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityOokiduti.class, this.getMobSpawnWeight(DqmEntityOokiduti.class, "DqmEntityOokiduti" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityOonamekuji.class, this.getMobSpawnWeight(DqmEntityOonamekuji.class, "DqmEntityOonamekuji" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityRemonsuraimu.class, this.getMobSpawnWeight(DqmEntityRemonsuraimu.class, "DqmEntityRemonsuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityRippusu.class, this.getMobSpawnWeight(DqmEntityRippusu.class, "DqmEntityRippusu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySabotenboru.class, this.getMobSpawnWeight(DqmEntitySabotenboru.class, "DqmEntitySabotenboru" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySimasimacat.class, this.getMobSpawnWeight(DqmEntitySimasimacat.class, "DqmEntitySimasimacat" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySupini.class, this.getMobSpawnWeight(DqmEntitySupini.class, "DqmEntitySupini" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySura.class, this.getMobSpawnWeight(DqmEntitySura.class, "DqmEntitySura" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySuraimubesu.class, this.getMobSpawnWeight(DqmEntitySuraimubesu.class, "DqmEntitySuraimubesu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityTogebouzu.class, this.getMobSpawnWeight(DqmEntityTogebouzu.class, "DqmEntityTogebouzu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			//this.addSpawn(DqmEntityTubo.class, this.getMobSpawnWeight(//DqmEntityTubo.class, "//DqmEntityTubo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityTukaima.class, this.getMobSpawnWeight(DqmEntityTukaima.class, "DqmEntityTukaima" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityZinmentyou.class, this.getMobSpawnWeight(DqmEntityZinmentyou.class, "DqmEntityZinmentyou" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityZukkinya.class, this.getMobSpawnWeight(DqmEntityZukkinya.class, "DqmEntityZukkinya" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityBurauni.class, this.getMobSpawnWeight(DqmEntityBurauni.class, "DqmEntityBurauni" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);

			this.addSpawn(DqmEntityButisuraimu.class, this.getMobSpawnWeight(DqmEntityButisuraimu.class, "DqmEntityButisuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityDoronuba.class, this.getMobSpawnWeight(DqmEntityDoronuba.class, "DqmEntityDoronuba" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityHoimisura.class, this.getMobSpawnWeight(DqmEntityHoimisura.class, "DqmEntityHoimisura" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityKimera.class, this.getMobSpawnWeight(DqmEntityKimera.class, "DqmEntityKimera" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityKirapan.class, this.getMobSpawnWeight(DqmEntityKirapan.class, "DqmEntityKirapan" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityKirikabuobake.class, this.getMobSpawnWeight(DqmEntityKirikabuobake.class, "DqmEntityKirikabuobake" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityObakekinoko.class, this.getMobSpawnWeight(DqmEntityObakekinoko.class, "DqmEntityObakekinoko" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityOokutibasi.class, this.getMobSpawnWeight(DqmEntityOokutibasi.class, "DqmEntityOokutibasi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityOomedama.class, this.getMobSpawnWeight(DqmEntityOomedama.class, "DqmEntityOomedama" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityPapetkozou.class, this.getMobSpawnWeight(DqmEntityPapetkozou.class, "DqmEntityPapetkozou" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityRiripat.class, this.getMobSpawnWeight(DqmEntityRiripat.class, "DqmEntityRiripat" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntitySukippaa.class, this.getMobSpawnWeight(DqmEntitySukippaa.class, "DqmEntitySukippaa" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			//this.addSpawn(DqmEntitySuraimuking.class, this.getMobSpawnWeight(//DqmEntitySuraimuking.class, "//DqmEntitySuraimuking" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntitySuraimunaito.class, this.getMobSpawnWeight(DqmEntitySuraimunaito.class, "DqmEntitySuraimunaito" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntitySuraimutawa.class, this.getMobSpawnWeight(DqmEntitySuraimutawa.class, "DqmEntitySuraimutawa" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityWaraibukuro.class, this.getMobSpawnWeight(DqmEntityWaraibukuro.class, "DqmEntityWaraibukuro" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		}


		if(DQR.conf2.spawn_resist_overworld_night == 0)
		{
			this.addSpawn(DqmEntityBakudaniwa.class, this.getMobSpawnWeight(DqmEntityBakudaniwa.class, "DqmEntityBakudaniwa" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityBehoimusuraimu.class, this.getMobSpawnWeight(DqmEntityBehoimusuraimu.class, "DqmEntityBehoimusuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityBeronyaago.class, this.getMobSpawnWeight(DqmEntityBeronyaago.class, "DqmEntityBeronyaago" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityHgizumo.class, this.getMobSpawnWeight(DqmEntityHgizumo.class, "DqmEntityHgizumo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			//this.addSpawn(DqmEntityHiitogizumo.class, this.getMobSpawnWeight(//DqmEntityHiitogizumo.class, "//DqmEntityHiitogizumo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityMeijikimera.class, this.getMobSpawnWeight(DqmEntityMeijikimera.class, "DqmEntityMeijikimera" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityMetaruraida.class, this.getMobSpawnWeight(DqmEntityMetaruraida.class, "DqmEntityMetaruraida" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityOdoruhouseki.class, this.getMobSpawnWeight(DqmEntityOdoruhouseki.class, "DqmEntityOdoruhouseki" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntitySibiredanbira.class, this.getMobSpawnWeight(DqmEntitySibiredanbira.class, "DqmEntitySibiredanbira" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityYouganmajin.class, this.getMobSpawnWeight(DqmEntityYouganmajin.class, "DqmEntityYouganmajin" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityAkumanosyo.class, this.getMobSpawnWeight(DqmEntityAkumanosyo.class, "DqmEntityAkumanosyo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityArumiraji.class, this.getMobSpawnWeight(DqmEntityArumiraji.class, "DqmEntityArumiraji" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityBuraddihando.class, this.getMobSpawnWeight(DqmEntityBuraddihando.class, "DqmEntityBuraddihando" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityFgizumo.class, this.getMobSpawnWeight(DqmEntityFgizumo.class, "DqmEntityFgizumo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			//this.addSpawn(DqmEntityFurosutogizumo.class, this.getMobSpawnWeight(//DqmEntityFurosutogizumo.class, "//DqmEntityFurosutogizumo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityHoroghost.class, this.getMobSpawnWeight(DqmEntityHoroghost.class, "DqmEntityHoroghost" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityHyouganmajin.class, this.getMobSpawnWeight(DqmEntityHyouganmajin.class, "DqmEntityHyouganmajin" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityJeriman.class, this.getMobSpawnWeight(DqmEntityJeriman.class, "DqmEntityJeriman" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityMarinsuraimu.class, this.getMobSpawnWeight(DqmEntityMarinsuraimu.class, "DqmEntityMarinsuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntitySumairurokku.class, this.getMobSpawnWeight(DqmEntitySumairurokku.class, "DqmEntitySumairurokku" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityTahodoraki.class, this.getMobSpawnWeight(DqmEntityTahodoraki.class, "DqmEntityTahodoraki" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityTomosibikozou.class, this.getMobSpawnWeight(DqmEntityTomosibikozou.class, "DqmEntityTomosibikozou" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntityMetaruhantaken.class, this.getMobSpawnWeight(DqmEntityMetaruhantaken.class, "DqmEntityMetaruhantaken" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			//this.addSpawn(DqmEntityAkumanotubo.class, this.getMobSpawnWeight(//DqmEntityAkumanotubo.class, "//DqmEntityAkumanotubo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);

			this.addSpawn(DqmEntityAxedoragon.class, this.getMobSpawnWeight(DqmEntityAxedoragon.class, "DqmEntityAxedoragon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityBaburin.class, this.getMobSpawnWeight(DqmEntityBaburin.class, "DqmEntityBaburin" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityBerobero.class, this.getMobSpawnWeight(DqmEntityBerobero.class, "DqmEntityBerobero" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityBesuking.class, this.getMobSpawnWeight(DqmEntityBesuking.class, "DqmEntityBesuking" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityDansunidoru.class, this.getMobSpawnWeight(DqmEntityDansunidoru.class, "DqmEntityDansunidoru" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityDoraki.class, this.getMobSpawnWeight(DqmEntityDoraki.class, "DqmEntityDoraki" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityDoroningyou.class, this.getMobSpawnWeight(DqmEntityDoroningyou.class, "DqmEntityDoroningyou" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityGaikotukensi.class, this.getMobSpawnWeight(DqmEntityGaikotukensi.class, "DqmEntityGaikotukensi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityGappurin.class, this.getMobSpawnWeight(DqmEntityGappurin.class, "DqmEntityGappurin" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityGenjutusi.class, this.getMobSpawnWeight(DqmEntityGenjutusi.class, "DqmEntityGenjutusi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityGhost.class, this.getMobSpawnWeight(DqmEntityGhost.class, "DqmEntityGhost" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityHerughost.class, this.getMobSpawnWeight(DqmEntityHerughost.class, "DqmEntityHerughost" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			//this.addSpawn(DqmEntityHitokuibako.class, this.getMobSpawnWeight(DqmEntityHitokuibako.class, "DqmEntityHitokuibako" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityKingsura.class, this.getMobSpawnWeight(DqmEntityKingsura.class, "DqmEntityKingsura" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityKirapan2.class, this.getMobSpawnWeight(DqmEntityKirapan2.class, "DqmEntityKirapan2" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityMapetman.class, this.getMobSpawnWeight(DqmEntityMapetman.class, "DqmEntityMapetman" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityMeragosuto.class, this.getMobSpawnWeight(DqmEntityMeragosuto.class, "DqmEntityMeragosuto" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityMetoroghost.class, this.getMobSpawnWeight(DqmEntityMetoroghost.class, "DqmEntityMetoroghost" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			//this.addSpawn(DqmEntityMimikkukibako.class, this.getMobSpawnWeight(//DqmEntityMimikkukibako.class, "//DqmEntityMimikkukibako" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityMinidemon.class, this.getMobSpawnWeight(DqmEntityMinidemon.class, "DqmEntityMinidemon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityMokomokojuu.class, this.getMobSpawnWeight(DqmEntityMokomokojuu.class, "DqmEntityMokomokojuu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityMrippusu.class, this.getMobSpawnWeight(DqmEntityMrippusu.class, "DqmEntityMrippusu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityObakekyandoru.class, this.getMobSpawnWeight(DqmEntityObakekyandoru.class, "DqmEntityObakekyandoru" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityRaimusuraimu.class, this.getMobSpawnWeight(DqmEntityRaimusuraimu.class, "DqmEntityRaimusuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySamayoutamasii.class, this.getMobSpawnWeight(DqmEntitySamayoutamasii.class, "DqmEntitySamayoutamasii" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySamayouyoroi.class, this.getMobSpawnWeight(DqmEntitySamayouyoroi.class, "DqmEntitySamayouyoroi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySkullgaroo.class, this.getMobSpawnWeight(DqmEntitySkullgaroo.class, "DqmEntitySkullgaroo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySumoruguru.class, this.getMobSpawnWeight(DqmEntitySumoruguru.class, "DqmEntitySumoruguru" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySuraimubogu.class, this.getMobSpawnWeight(DqmEntitySuraimubogu.class, "DqmEntitySuraimubogu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySuraimuburesu.class, this.getMobSpawnWeight(DqmEntitySuraimuburesu.class, "DqmEntitySuraimuburesu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntitySyado.class, this.getMobSpawnWeight(DqmEntitySyado.class, "DqmEntitySyado" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityTororu.class, this.getMobSpawnWeight(DqmEntityTororu.class, "DqmEntityTororu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityTutiwarasi.class, this.getMobSpawnWeight(DqmEntityTutiwarasi.class, "DqmEntityTutiwarasi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityAnimaruzonbi.class, this.getMobSpawnWeight(DqmEntityAnimaruzonbi.class, "DqmEntityAnimaruzonbi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityBakudanbebi.class, this.getMobSpawnWeight(DqmEntityBakudanbebi.class, "DqmEntityBakudanbebi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityBebisatan.class, this.getMobSpawnWeight(DqmEntityBebisatan.class, "DqmEntityBebisatan" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityBehoimisuraimu.class, this.getMobSpawnWeight(DqmEntityBehoimisuraimu.class, "DqmEntityBehoimisuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityBuchunpa.class, this.getMobSpawnWeight(DqmEntityBuchunpa.class, "DqmEntityBuchunpa" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityButtizukinya.class, this.getMobSpawnWeight(DqmEntityButtizukinya.class, "DqmEntityButtizukinya" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityDesufuratta.class, this.getMobSpawnWeight(DqmEntityDesufuratta.class, "DqmEntityDesufuratta" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityDokuyazukin.class, this.getMobSpawnWeight(DqmEntityDokuyazukin.class, "DqmEntityDokuyazukin" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityDorakima.class, this.getMobSpawnWeight(DqmEntityDorakima.class, "DqmEntityDorakima" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityEnzeruslime.class, this.getMobSpawnWeight(DqmEntityEnzeruslime.class, "DqmEntityEnzeruslime" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityHitokuiga.class, this.getMobSpawnWeight(DqmEntityHitokuiga.class, "DqmEntityHitokuiga" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityKirasuko.class, this.getMobSpawnWeight(DqmEntityKirasuko.class, "DqmEntityKirasuko" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityMatango.class, this.getMobSpawnWeight(DqmEntityMatango.class, "DqmEntityMatango" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityMeijidoraki.class, this.getMobSpawnWeight(DqmEntityMeijidoraki.class, "DqmEntityMeijidoraki" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityNightwalker.class, this.getMobSpawnWeight(DqmEntityNightwalker.class, "DqmEntityNightwalker" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityPinkmomon.class, this.getMobSpawnWeight(DqmEntityPinkmomon.class, "DqmEntityPinkmomon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntitySibireageha.class, this.getMobSpawnWeight(DqmEntitySibireageha.class, "DqmEntitySibireageha" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntitySupekutetto.class, this.getMobSpawnWeight(DqmEntitySupekutetto.class, "DqmEntitySupekutetto" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntitySura2.class, this.getMobSpawnWeight(DqmEntitySura2.class, "DqmEntitySura2" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityTonburero.class, this.getMobSpawnWeight(DqmEntityTonburero.class, "DqmEntityTonburero" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
			this.addSpawn(DqmEntityUmiusi.class, this.getMobSpawnWeight(DqmEntityUmiusi.class, "DqmEntityUmiusi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		}


		if(DQR.conf2.spawn_resist_metal == 0)
		{
			this.addSpawn(DqmEntityMetaruburazazu.class,  this.getMobSpawnWeight(DqmEntityMetaruburazazu .class, "DqmEntityMetaruburazazu" , 4), 1, 1, DQR.dqmCreatureType.DqmMonster, metaru1);
			this.addSpawn(DqmEntityMetasura.class,  this.getMobSpawnWeight(DqmEntityMetasura .class, "DqmEntityMetasura" , 4), 1, 1, DQR.dqmCreatureType.DqmMonster, metaru1);
			this.addSpawn(DqmEntityHagumeta.class,  this.getMobSpawnWeight(DqmEntityHagumeta .class, "DqmEntityHagumeta" , 4), 1, 1, DQR.dqmCreatureType.DqmMonster, metaru2);
			this.addSpawn(DqmEntityDragometaru.class,  this.getMobSpawnWeight(DqmEntityDragometaru .class, "DqmEntityDragometaru" , 4), 1, 1, DQR.dqmCreatureType.DqmMonster, metaru3);
			this.addSpawn(DqmEntityMetaking.class,  this.getMobSpawnWeight(DqmEntityMetaking .class, "DqmEntityMetaking" , 4), 1, 1, DQR.dqmCreatureType.DqmMonster, metaru3);
			this.addSpawn(DqmEntityDaiyamondosuraimu.class,  this.getMobSpawnWeight(DqmEntityDaiyamondosuraimu .class, "DqmEntityDaiyamondosuraimu" , 4), 1, 1, DQR.dqmCreatureType.DqmMonster, metaru4);
			this.addSpawn(DqmEntityPuratinaking.class,  this.getMobSpawnWeight(DqmEntityPuratinaking .class, "DqmEntityPuratinaking" , 4), 1, 1, DQR.dqmCreatureType.DqmMonster, metaru4);
			//this.addSpawn(DqmEntityGoldenmetalslime.class,  this.getMobSpawnWeight(//DqmEntityGoldenmetalslime .class, "//DqmEntityGoldenmetalslime " , 4), 1, 1, DQR.dqmCreatureType.DqmMonster, metaru5);
			this.addSpawn(DqmEntityHaguremetaruking.class,  this.getMobSpawnWeight(DqmEntityHaguremetaruking .class, "DqmEntityHaguremetaruking" , 4), 1, 1, DQR.dqmCreatureType.DqmMonster, metaru5);
		}

		if(DQR.conf2.spawn_resist_nether == 0)
		{
			this.addSpawn(DqmEntityAnkokumajin.class, this.getMobSpawnWeight(DqmEntityAnkokumajin.class, "DqmEntityAnkokumajin" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityAroinpu.class, this.getMobSpawnWeight(DqmEntityAroinpu.class, "DqmEntityAroinpu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBaburuking.class, this.getMobSpawnWeight(DqmEntityBaburuking.class, "DqmEntityBaburuking" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBarakku.class, this.getMobSpawnWeight(DqmEntityBarakku.class, "DqmEntityBarakku" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBariidodog.class, this.getMobSpawnWeight(DqmEntityBariidodog.class, "DqmEntityBariidodog" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBehomasuraimu.class, this.getMobSpawnWeight(DqmEntityBehomasuraimu.class, "DqmEntityBehomasuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBiggufeisu.class, this.getMobSpawnWeight(DqmEntityBiggufeisu.class, "DqmEntityBiggufeisu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBighanma.class, this.getMobSpawnWeight(DqmEntityBighanma.class, "DqmEntityBighanma" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBosutororu.class, this.getMobSpawnWeight(DqmEntityBosutororu.class, "DqmEntityBosutororu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBoureikensi.class, this.getMobSpawnWeight(DqmEntityBoureikensi.class, "DqmEntityBoureikensi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBuraddosodo.class, this.getMobSpawnWeight(DqmEntityBuraddosodo.class, "DqmEntityBuraddosodo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityBurakkubejita.class, this.getMobSpawnWeight(DqmEntityBurakkubejita.class, "DqmEntityBurakkubejita" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityDarkslime.class, this.getMobSpawnWeight(DqmEntityDarkslime.class, "DqmEntityDarkslime" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityDeddopekka.class, this.getMobSpawnWeight(DqmEntityDeddopekka.class, "DqmEntityDeddopekka" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityDgizumo.class, this.getMobSpawnWeight(DqmEntityDgizumo.class, "DqmEntityDgizumo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityDollmaster.class, this.getMobSpawnWeight(DqmEntityDollmaster.class, "DqmEntityDollmaster" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityDoragonsoruja.class, this.getMobSpawnWeight(DqmEntityDoragonsoruja.class, "DqmEntityDoragonsoruja" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityDqmdragon.class, this.getMobSpawnWeight(DqmEntityDqmdragon.class, "DqmEntityDqmdragon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityDragonnaito.class, this.getMobSpawnWeight(DqmEntityDragonnaito.class, "DqmEntityDragonnaito" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityDragonraida.class, this.getMobSpawnWeight(DqmEntityDragonraida.class, "DqmEntityDragonraida" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityFureimu.class, this.getMobSpawnWeight(DqmEntityFureimu.class, "DqmEntityFureimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityGamegon.class, this.getMobSpawnWeight(DqmEntityGamegon.class, "DqmEntityGamegon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityGamegonload.class, this.getMobSpawnWeight(DqmEntityGamegonload.class, "DqmEntityGamegonload" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityGanirasu.class, this.getMobSpawnWeight(DqmEntityGanirasu.class, "DqmEntityGanirasu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityGoldman.class, this.getMobSpawnWeight(DqmEntityGoldman.class, "DqmEntityGoldman" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityGoremu.class, this.getMobSpawnWeight(DqmEntityGoremu.class, "DqmEntityGoremu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityGorudentotemu.class, this.getMobSpawnWeight(DqmEntityGorudentotemu.class, "DqmEntityGorudentotemu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityHotatewarabi.class, this.getMobSpawnWeight(DqmEntityHotatewarabi.class, "DqmEntityHotatewarabi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityJigokunohasami.class, this.getMobSpawnWeight(DqmEntityJigokunohasami.class, "DqmEntityJigokunohasami" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKedamon.class, this.getMobSpawnWeight(DqmEntityKedamon.class, "DqmEntityKedamon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKemunkurusu.class, this.getMobSpawnWeight(DqmEntityKemunkurusu.class, "DqmEntityKemunkurusu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKimendousi.class, this.getMobSpawnWeight(DqmEntityKimendousi.class, "DqmEntityKimendousi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKiraama.class, this.getMobSpawnWeight(DqmEntityKiraama.class, "DqmEntityKiraama" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKirakurabu.class, this.getMobSpawnWeight(DqmEntityKirakurabu.class, "DqmEntityKirakurabu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKiramasin.class, this.getMobSpawnWeight(DqmEntityKiramasin.class, "DqmEntityKiramasin" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKiramasin2.class, this.getMobSpawnWeight(DqmEntityKiramasin2.class, "DqmEntityKiramasin2" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKisudragon.class, this.getMobSpawnWeight(DqmEntityKisudragon.class, "DqmEntityKisudragon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKuinsuraimu.class, this.getMobSpawnWeight(DqmEntityKuinsuraimu.class, "DqmEntityKuinsuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityMagematango.class, this.getMobSpawnWeight(DqmEntityMagematango.class, "DqmEntityMagematango" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityMagemomonja.class, this.getMobSpawnWeight(DqmEntityMagemomonja.class, "DqmEntityMagemomonja" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityMagumaron.class, this.getMobSpawnWeight(DqmEntityMagumaron.class, "DqmEntityMagumaron" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityMajikaruhatto.class, this.getMobSpawnWeight(DqmEntityMajikaruhatto.class, "DqmEntityMajikaruhatto" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityMaounokage.class, this.getMobSpawnWeight(DqmEntityMaounokage.class, "DqmEntityMaounokage" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityMaporena.class, this.getMobSpawnWeight(DqmEntityMaporena.class, "DqmEntityMaporena" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityMegazarurokku.class, this.getMobSpawnWeight(DqmEntityMegazarurokku.class, "DqmEntityMegazarurokku" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			//this.addSpawn(DqmEntityMetaruhanta.class, this.getMobSpawnWeight(//DqmEntityMetaruhanta.class, "//DqmEntityMetaruhanta" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityMimikku.class, this.getMobSpawnWeight(DqmEntityMimikku.class, "DqmEntityMimikku" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			//this.addSpawn(DqmEntityPandorakibako.class, this.getMobSpawnWeight(//DqmEntityPandorakibako.class, "//DqmEntityPandorakibako" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityPapettoman.class, this.getMobSpawnWeight(DqmEntityPapettoman.class, "DqmEntityPapettoman" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityPikusi.class, this.getMobSpawnWeight(DqmEntityPikusi.class, "DqmEntityPikusi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityPombom.class, this.getMobSpawnWeight(DqmEntityPombom.class, "DqmEntityPombom" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityPuyon.class, this.getMobSpawnWeight(DqmEntityPuyon.class, "DqmEntityPuyon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityRedsaikuron.class, this.getMobSpawnWeight(DqmEntityRedsaikuron.class, "DqmEntityRedsaikuron" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntitySaikuropusu.class, this.getMobSpawnWeight(DqmEntitySaikuropusu.class, "DqmEntitySaikuropusu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntitySirubadebiru.class, this.getMobSpawnWeight(DqmEntitySirubadebiru.class, "DqmEntitySirubadebiru" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntitySiryou.class, this.getMobSpawnWeight(DqmEntitySiryou.class, "DqmEntitySiryou" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntitySiryounokisi.class, this.getMobSpawnWeight(DqmEntitySiryounokisi.class, "DqmEntitySiryounokisi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntitySodofantomu.class, this.getMobSpawnWeight(DqmEntitySodofantomu.class, "DqmEntitySodofantomu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityStarkimera.class, this.getMobSpawnWeight(DqmEntityStarkimera.class, "DqmEntityStarkimera" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityStonman.class, this.getMobSpawnWeight(DqmEntityStonman.class, "DqmEntityStonman" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntitySuraimubehomazun.class, this.getMobSpawnWeight(DqmEntitySuraimubehomazun.class, "DqmEntitySuraimubehomazun" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntitySuraimuhaitawa.class, this.getMobSpawnWeight(DqmEntitySuraimuhaitawa.class, "DqmEntitySuraimuhaitawa" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntitySuraimumadyura.class, this.getMobSpawnWeight(DqmEntitySuraimumadyura.class, "DqmEntitySuraimumadyura" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityTororuking.class, this.getMobSpawnWeight(DqmEntityTororuking.class, "DqmEntityTororuking" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			//this.addSpawn(DqmEntityTubokku.class, this.getMobSpawnWeight(//DqmEntityTubokku.class, "//DqmEntityTubokku" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityUmibouzu.class, this.getMobSpawnWeight(DqmEntityUmibouzu.class, "DqmEntityUmibouzu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityEriminator.class, this.getMobSpawnWeight(DqmEntityEriminator.class, "DqmEntityEriminator" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityDarkdoriado.class, this.getMobSpawnWeight(DqmEntityDarkdoriado.class, "DqmEntityDarkdoriado" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityShadopan.class, this.getMobSpawnWeight(DqmEntityShadopan.class, "DqmEntityShadopan" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityWhitepan2.class, this.getMobSpawnWeight(DqmEntityWhitepan2.class, "DqmEntityWhitepan2" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
		}

		if(DQR.conf2.spawn_resist_end == 0)
		{
			this.addSpawn(DqmEntityAkairai.class, this.getMobSpawnWeight(DqmEntityAkairai.class, "DqmEntityAkairai" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityBassaimasin.class, this.getMobSpawnWeight(DqmEntityBassaimasin.class, "DqmEntityBassaimasin" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityBatorurex.class, this.getMobSpawnWeight(DqmEntityBatorurex.class, "DqmEntityBatorurex" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityBiggumoai.class, this.getMobSpawnWeight(DqmEntityBiggumoai.class, "DqmEntityBiggumoai" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityBurizado.class, this.getMobSpawnWeight(DqmEntityBurizado.class, "DqmEntityBurizado" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityDakunaito.class, this.getMobSpawnWeight(DqmEntityDakunaito.class, "DqmEntityDakunaito" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityDarktororu.class, this.getMobSpawnWeight(DqmEntityDarktororu.class, "DqmEntityDarktororu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);

			this.addSpawn(DqmEntityDasudragon.class, this.getMobSpawnWeight(DqmEntityDasudragon.class, "DqmEntityDasudragon" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityDenga.class, this.getMobSpawnWeight(DqmEntityDenga.class, "DqmEntityDenga" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityDesujakkaru.class, this.getMobSpawnWeight(DqmEntityDesujakkaru.class, "DqmEntityDesujakkaru" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityDesunyago.class, this.getMobSpawnWeight(DqmEntityDesunyago.class, "DqmEntityDesunyago" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityDragondarknaito.class, this.getMobSpawnWeight(DqmEntityDragondarknaito.class, "DqmEntityDragondarknaito" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityGamegonrejendo.class, this.getMobSpawnWeight(DqmEntityGamegonrejendo.class, "DqmEntityGamegonrejendo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityGigantesu.class, this.getMobSpawnWeight(DqmEntityGigantesu.class, "DqmEntityGigantesu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityGodraida.class, this.getMobSpawnWeight(DqmEntityGodraida.class, "DqmEntityGodraida" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityGorudensuraimu.class, this.getMobSpawnWeight(DqmEntityGorudensuraimu.class, "DqmEntityGorudensuraimu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityJigokunoyoroi.class, this.getMobSpawnWeight(DqmEntityJigokunoyoroi.class, "DqmEntityJigokunoyoroi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityKagenokisi.class, this.getMobSpawnWeight(DqmEntityKagenokisi.class, "DqmEntityKagenokisi" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityManemane.class, this.getMobSpawnWeight(DqmEntityManemane.class, "DqmEntityManemane" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityPandorabox.class, this.getMobSpawnWeight(DqmEntityPandorabox.class, "DqmEntityPandorabox" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityRyuiso.class, this.getMobSpawnWeight(DqmEntityRyuiso.class, "DqmEntityRyuiso" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityTororubonba.class, this.getMobSpawnWeight(DqmEntityTororubonba.class, "DqmEntityTororubonba" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityDesusutoka.class, this.getMobSpawnWeight(DqmEntityDesusutoka.class, "DqmEntityDesusutoka" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
			this.addSpawn(DqmEntityShadopan2.class, this.getMobSpawnWeight(DqmEntityShadopan2.class, "DqmEntityShadopan2" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, end);
		}

		if(DQR.conf2.spawn_resist_etc == 0)
		{
			this.addSpawn(DqmEntityGizumo.class, this.getMobSpawnWeight(DqmEntityGizumo.class, "DqmEntityGizumo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityTubo.class, this.getMobSpawnWeight(DqmEntityTubo.class, "DqmEntityTubo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityHiitogizumo.class, this.getMobSpawnWeight(DqmEntityHiitogizumo.class, "DqmEntityHiitogizumo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, desert);
			this.addSpawn(DqmEntityFurosutogizumo.class, this.getMobSpawnWeight(DqmEntityFurosutogizumo.class, "DqmEntityFurosutogizumo" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, ice);
			this.addSpawn(DqmEntitySuraimuking.class, this.getMobSpawnWeight(DqmEntitySuraimuking.class, "DqmEntitySuraimuking" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);

			this.addSpawn(DqmEntityMimikkukibako.class, this.getMobSpawnWeight(DqmEntityMimikkukibako.class, "DqmEntityMimikkukibako" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, overworld);
			this.addSpawn(DqmEntityPandorakibako.class, this.getMobSpawnWeight(DqmEntityPandorakibako.class, "DqmEntityPandorakibako" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, nether);
			this.addSpawn(DqmEntityKingbesu.class, this.getMobSpawnWeight(DqmEntityKingbesu.class, "DqmEntityKingbesu" , 20), 1, 2, DQR.dqmCreatureType.DqmMonster, plains);
		}

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

	public int getMobSpawnWeight(Class cls, String name, int def)
	{
		int ret = def;

		//System.out.println("TEST1 : " + name);
		try
		{
			if(cls == DqmEntityGizumo.class || cls == DqmEntityTubo.class || cls == DqmEntityHiitogizumo.class ||
			   cls == DqmEntityFurosutogizumo.class || cls == DqmEntitySuraimuking.class || cls == DqmEntityMimikkukibako.class ||
			   cls == DqmEntityPandorakibako.class| cls == DqmEntityKingbesu.class)
			{
				//System.out.println("TEST3 : " + name);
				if(DQR.conf2.weightSetModeETC == 1)
				{
					ret = DQR.conf2.groupSpawnWeightETC;
				}else if(DQR.conf2.weightSetModeETC == 2)
				{
					//System.out.println("TEST2 : " + name);
					Field targetField1;

					targetField1 = DQR.conf2.getClass().getDeclaredField(name);
					targetField1.setAccessible(true);

					ret = (int)targetField1.get(DQR.conf2);

					//System.out.println("TEST : " + name + " / " + ret + " / ");
					//targetField1.set(null, DQR.funcMob.getCalcPW(130));
				}
			}else
			{
				if((DqmMobBaseDay.class.isAssignableFrom(cls)))
				{
					if(DQR.conf2.weightSetModeDay == 1)
					{
						ret = DQR.conf2.groupSpawnWeightDay;
					}else if(DQR.conf2.weightSetModeDay == 2)
					{
						//System.out.println("TEST2 : " + name);
						Field targetField1;

						targetField1 = DQR.conf2.getClass().getDeclaredField(name);
						targetField1.setAccessible(true);

						ret = (int)targetField1.get(DQR.conf2);
					}
				}else if((DqmMobBaseNight.class.isAssignableFrom(cls)))
				{
					if(DQR.conf2.weightSetModeNight == 1)
					{
						ret = DQR.conf2.groupSpawnWeightNight;
					}else if(DQR.conf2.weightSetModeNight == 2)
					{
						//System.out.println("TEST2 : " + name);
						Field targetField1;

						targetField1 = DQR.conf2.getClass().getDeclaredField(name);
						targetField1.setAccessible(true);

						ret = (int)targetField1.get(DQR.conf2);
					}
				}else if((DqmMobBaseHell.class.isAssignableFrom(cls)))
				{
					if(DQR.conf2.weightSetModeNether == 1)
					{
						ret = DQR.conf2.groupSpawnWeightNether;
					}else if(DQR.conf2.weightSetModeNether == 2)
					{
						//System.out.println("TEST2 : " + name);
						Field targetField1;

						targetField1 = DQR.conf2.getClass().getDeclaredField(name);
						targetField1.setAccessible(true);

						ret = (int)targetField1.get(DQR.conf2);
					}
				}else if((DqmMobBaseEnd.class.isAssignableFrom(cls)))
				{
					if(DQR.conf2.weightSetModeEnd == 1)
					{
						ret = DQR.conf2.groupSpawnWeightEnd;
					}else if(DQR.conf2.weightSetModeEnd == 2)
					{
						//System.out.println("TEST2 : " + name);
						Field targetField1;

						targetField1 = DQR.conf2.getClass().getDeclaredField(name);
						targetField1.setAccessible(true);

						ret = (int)targetField1.get(DQR.conf2);
					}
				}else if((DqmMobBaseMetaru.class.isAssignableFrom(cls)))
				{
					if(DQR.conf2.weightSetModeMetal == 1)
					{
						ret = DQR.conf2.groupSpawnWeightMetal;
					}else if(DQR.conf2.weightSetModeMetal == 2)
					{
						//System.out.println("TEST2 : " + name);
						Field targetField1;

						targetField1 = DQR.conf2.getClass().getDeclaredField(name);
						targetField1.setAccessible(true);

						ret = (int)targetField1.get(DQR.conf2);
					}
				}
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return ret;
	}
}

