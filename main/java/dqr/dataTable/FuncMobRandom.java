package dqr.dataTable;

import java.util.Random;

import net.minecraft.world.World;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.mobEntity.monsterBoss.DqmEntityDesupisaro1;
import dqr.entity.mobEntity.monsterBoss.DqmEntityDesupisaro2;
import dqr.entity.mobEntity.monsterBoss.DqmEntityDesupisaro3;
import dqr.entity.mobEntity.monsterBoss.DqmEntityEsterk;
import dqr.entity.mobEntity.monsterBoss.DqmEntityGod;
import dqr.entity.mobEntity.monsterBoss.DqmEntityMasterdoragon;
import dqr.entity.mobEntity.monsterBoss.DqmEntityRyuuou;
import dqr.entity.mobEntity.monsterBoss.DqmEntityRyuuou2;
import dqr.entity.mobEntity.monsterBoss.DqmEntityZoma;
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
import dqr.entity.mobEntity.monsterDay.DqmEntityHitokuikibako;
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
import dqr.entity.mobEntity.monsterEnd.DqmEntityShadopan2;
import dqr.entity.mobEntity.monsterEnd.DqmEntityTororubonba;
import dqr.entity.mobEntity.monsterEtc.DqmEntityFurosutogizumo;
import dqr.entity.mobEntity.monsterEtc.DqmEntityGizumo;
import dqr.entity.mobEntity.monsterEtc.DqmEntityHiitogizumo;
import dqr.entity.mobEntity.monsterEtc.DqmEntityHitokuibako;
import dqr.entity.mobEntity.monsterEtc.DqmEntityKingbesu;
import dqr.entity.mobEntity.monsterEtc.DqmEntityMimikkukibako;
import dqr.entity.mobEntity.monsterEtc.DqmEntityNorowaretaturugi;
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
import dqr.entity.mobEntity.monsterHell.DqmEntityTubokku;
import dqr.entity.mobEntity.monsterHell.DqmEntityUmibouzu;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityDaiyamondosuraimu;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityDragometaru;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityGoldenmetalslime;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityHagumeta;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityHaguremetaruking;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetaking;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetaruburazazu;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityMetasura;
import dqr.entity.mobEntity.monsterMetaru.DqmEntityPuratinaking;
import dqr.entity.mobEntity.monsterNight.DqmEntityAkumanosyo;
import dqr.entity.mobEntity.monsterNight.DqmEntityAkumanotubo;
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
import dqr.entity.mobEntity.monsterSP.DqmEntityAtorasu;
import dqr.entity.mobEntity.monsterSP.DqmEntityBazuzu;
import dqr.entity.mobEntity.monsterSP.DqmEntityBlackchack;
import dqr.entity.mobEntity.monsterSP.DqmEntityBurasu;
import dqr.entity.mobEntity.monsterSP.DqmEntityDarkRamia;
import dqr.entity.mobEntity.monsterSP.DqmEntityFureizado;
import dqr.entity.mobEntity.monsterSP.DqmEntityGodonheddo;
import dqr.entity.mobEntity.monsterSP.DqmEntityKandata;
import dqr.entity.mobEntity.monsterSP.DqmEntityKandatakobun;
import dqr.entity.mobEntity.monsterSP.DqmEntityKinghidora;
import dqr.entity.mobEntity.monsterSP.DqmEntityKiramajinga;
import dqr.entity.mobEntity.monsterSP.DqmEntityKiratoti;
import dqr.entity.mobEntity.monsterSP.DqmEntityMashougumo;
import dqr.entity.mobEntity.monsterSP.DqmEntityMasso;
import dqr.entity.mobEntity.monsterSP.DqmEntityPisaronaito;
import dqr.entity.mobEntity.monsterSP.DqmEntityPuremiasuraimu;
import dqr.entity.mobEntity.monsterSP.DqmEntitySirubamanto;
import dqr.entity.mobEntity.monsterSP.DqmEntitySuraimuemperor;
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

public class FuncMobRandom {

	Random rand = new Random();

	public FuncMobRandom(){}

	public DqmMobBase getRandomETC(World par1)
	{
		int val = rand.nextInt(10);

		switch(val)
		{
			case 0: return new DqmEntityFurosutogizumo(par1);
			case 1: return new DqmEntityGizumo(par1);
			case 2: return new DqmEntityHiitogizumo(par1);
			case 3: return new DqmEntityHitokuibako(par1);
			case 4: return new DqmEntityKingbesu(par1);
			case 5: return new DqmEntityMimikkukibako(par1);
			case 6: return new DqmEntityNorowaretaturugi(par1);
			case 7: return new DqmEntityPandorakibako(par1);
			case 8: return new DqmEntitySuraimuking(par1);
			case 9: return new DqmEntityTubo(par1);
			default :return new DqmEntitySura(par1);
		}
	}

	public DqmMobBase getRandomBoss(World par1)
	{
		int val = rand.nextInt(9);

		switch(val)
		{
			case 0: return new DqmEntityZoma(par1);
			case 1: return new DqmEntityDesupisaro1(par1);
			case 2: return new DqmEntityDesupisaro2(par1);
			case 3: return new DqmEntityDesupisaro3(par1);
			case 4: return new DqmEntityEsterk(par1);
			case 5: return new DqmEntityGod(par1);
			case 6: return new DqmEntityMasterdoragon(par1);
			case 7: return new DqmEntityRyuuou(par1);
			case 8: return new DqmEntityRyuuou2(par1);
			default :return new DqmEntitySura(par1);
		}
	}

	public DqmMobBase getRandomEnd(World par1)
	{
		int val = rand.nextInt(25);

		switch(val)
		{
			case 0: return new DqmEntityAkairai(par1);
			case 1: return new DqmEntityBassaimasin(par1);
			case 2: return new DqmEntityBatorurex(par1);
			case 3: return new DqmEntityBiggumoai(par1);
			case 4: return new DqmEntityBurizado(par1);
			case 5: return new DqmEntityDakunaito(par1);
			case 6: return new DqmEntityDarktororu(par1);
			case 7: return new DqmEntityDasudragon(par1);
			case 8: return new DqmEntityDenga(par1);
			case 9: return new DqmEntityDesujakkaru(par1);
			case 10: return new DqmEntityDesunyago(par1);
			case 11: return new DqmEntityDragondarknaito(par1);
			case 12: return new DqmEntityGamegonrejendo(par1);
			case 13: return new DqmEntityGigantesu(par1);
			case 14: return new DqmEntityGodraida(par1);
			case 15: return new DqmEntityGorudensuraimu(par1);
			case 16: return new DqmEntityJigokunoyoroi(par1);
			case 17: return new DqmEntityKagenokisi(par1);
			case 18: return new DqmEntityManemane(par1);
			case 19: return new DqmEntityPandorabox(par1);
			case 20: return new DqmEntityRyuiso(par1);
			case 21: return new DqmEntityTororubonba(par1);
			case 22: return new DqmEntityDakuhobitto(par1);
			case 23: return new DqmEntityDesusutoka(par1);
			case 24: return new DqmEntityShadopan2(par1);
			default :return new DqmEntitySura(par1);
		}
	}

	public DqmMobBase getRandomNether(World par1)
	{
		int val = rand.nextInt(68);

		switch(val)
		{
			case 0: return new DqmEntityAnkokumajin(par1);
			case 1: return new DqmEntityAroinpu(par1);
			case 2: return new DqmEntityBaburuking(par1);
			case 3: return new DqmEntityBarakku(par1);
			case 4: return new DqmEntityBariidodog(par1);
			case 5: return new DqmEntityBehomasuraimu(par1);
			case 6: return new DqmEntityBiggufeisu(par1);
			case 7: return new DqmEntityBighanma(par1);
			case 8: return new DqmEntityBosutororu(par1);
			case 9: return new DqmEntityBoureikensi(par1);
			case 10: return new DqmEntityBuraddosodo(par1);
			case 11: return new DqmEntityBurakkubejita(par1);
			case 12: return new DqmEntityDarkslime(par1);
			case 13: return new DqmEntityDeddopekka(par1);
			case 14: return new DqmEntityDgizumo(par1);
			case 15: return new DqmEntityDollmaster(par1);
			case 16: return new DqmEntityDoragonsoruja(par1);
			case 17: return new DqmEntityDqmdragon(par1);
			case 18: return new DqmEntityDragonnaito(par1);
			case 19: return new DqmEntityDragonraida(par1);
			case 20: return new DqmEntityFureimu(par1);
			case 21: return new DqmEntityGamegon(par1);
			case 22: return new DqmEntityGamegonload(par1);
			case 23: return new DqmEntityGanirasu(par1);
			case 24: return new DqmEntityGoldman(par1);
			case 25: return new DqmEntityGoremu(par1);
			case 26: return new DqmEntityGorudentotemu(par1);
			case 27: return new DqmEntityHotatewarabi(par1);
			case 28: return new DqmEntityJigokunohasami(par1);
			case 29: return new DqmEntityKedamon(par1);
			case 30: return new DqmEntityKemunkurusu(par1);
			case 31: return new DqmEntityKimendousi(par1);
			case 32: return new DqmEntityKiraama(par1);
			case 33: return new DqmEntityKirakurabu(par1);
			case 34: return new DqmEntityKiramasin(par1);
			case 35: return new DqmEntityKiramasin2(par1);
			case 36: return new DqmEntityKisudragon(par1);
			case 37: return new DqmEntityKuinsuraimu(par1);
			case 38: return new DqmEntityMagematango(par1);
			case 39: return new DqmEntityMagemomonja(par1);
			case 40: return new DqmEntityMagumaron(par1);
			case 41: return new DqmEntityMajikaruhatto(par1);
			case 42: return new DqmEntityMaounokage(par1);
			case 43: return new DqmEntityMaporena(par1);
			case 44: return new DqmEntityMegazarurokku(par1);
			case 45: return new DqmEntityEriminator(par1);
			case 46: return new DqmEntityMimikku(par1);
			case 47: return new DqmEntityPapettoman(par1);
			case 48: return new DqmEntityPikusi(par1);
			case 49: return new DqmEntityPombom(par1);
			case 50: return new DqmEntityPuyon(par1);
			case 51: return new DqmEntityRedsaikuron(par1);
			case 52: return new DqmEntitySaikuropusu(par1);
			case 53: return new DqmEntitySirubadebiru(par1);
			case 54: return new DqmEntitySiryou(par1);
			case 55: return new DqmEntitySiryounokisi(par1);
			case 56: return new DqmEntitySodofantomu(par1);
			case 57: return new DqmEntityStarkimera(par1);
			case 58: return new DqmEntityStonman(par1);
			case 59: return new DqmEntitySuraimubehomazun(par1);
			case 60: return new DqmEntitySuraimuhaitawa(par1);
			case 61: return new DqmEntitySuraimumadyura(par1);
			case 62: return new DqmEntityTororuking(par1);
			case 63: return new DqmEntityTubokku(par1);
			case 64: return new DqmEntityUmibouzu(par1);
			case 65: return new DqmEntityEriminator(par1);
			case 66: return new DqmEntityShadopan(par1);
			case 67: return new DqmEntityDarkdoriado(par1);
			default :return new DqmEntitySura(par1);
		}
	}

	public DqmMobBase getRandomMetaru(World par1)
	{
		int val = rand.nextInt(9);

		switch(val)
		{
			case 0: return new DqmEntityDaiyamondosuraimu(par1);
			case 1: return new DqmEntityDragometaru(par1);
			case 2: return new DqmEntityGoldenmetalslime(par1);
			case 3: return new DqmEntityHagumeta(par1);
			case 4: return new DqmEntityHaguremetaruking(par1);
			case 5: return new DqmEntityMetaking(par1);
			case 6: return new DqmEntityMetaruburazazu(par1);
			case 7: return new DqmEntityMetasura(par1);
			case 8: return new DqmEntityPuratinaking(par1);
			default :return new DqmEntitySura(par1);
		}
	}

	public DqmMobBase getRandomNight(World par1)
	{
		int val = rand.nextInt(75);

		switch(val)
		{
			case 0: return new DqmEntityAkumanosyo(par1);
			case 1: return new DqmEntityAkumanotubo(par1);
			case 2: return new DqmEntityAnimaruzonbi(par1);
			case 3: return new DqmEntityArumiraji(par1);
			case 4: return new DqmEntityAxedoragon(par1);
			case 5: return new DqmEntityBaburin(par1);
			case 6: return new DqmEntityBakudanbebi(par1);
			case 7: return new DqmEntityBakudaniwa(par1);
			case 8: return new DqmEntityBebisatan(par1);
			case 9: return new DqmEntityBehoimisuraimu(par1);
			case 10: return new DqmEntityBehoimusuraimu(par1);
			case 11: return new DqmEntityBerobero(par1);
			case 12: return new DqmEntityBeronyaago(par1);
			case 13: return new DqmEntityBesuking(par1);
			case 14: return new DqmEntityBuchunpa(par1);
			case 15: return new DqmEntityBuraddihando(par1);
			case 16: return new DqmEntityButtizukinya(par1);
			case 17: return new DqmEntityDansunidoru(par1);
			case 18: return new DqmEntityDesufuratta(par1);
			case 19: return new DqmEntityDokuyazukin(par1);
			case 20: return new DqmEntityDoraki(par1);
			case 21: return new DqmEntityDorakima(par1);
			case 22: return new DqmEntityDoroningyou(par1);
			case 23: return new DqmEntityEnzeruslime(par1);
			case 24: return new DqmEntityFgizumo(par1);
			case 25: return new DqmEntityGaikotukensi(par1);
			case 26: return new DqmEntityGappurin(par1);
			case 27: return new DqmEntityGenjutusi(par1);
			case 28: return new DqmEntityGhost(par1);
			case 29: return new DqmEntityHerughost(par1);
			case 30: return new DqmEntityHgizumo(par1);
			case 31: return new DqmEntityHitokuiga(par1);
			case 32: return new DqmEntityHoroghost(par1);
			case 33: return new DqmEntityHyouganmajin(par1);
			case 34: return new DqmEntityJeriman(par1);
			case 35: return new DqmEntityKingsura(par1);
			case 36: return new DqmEntityKirapan2(par1);
			case 37: return new DqmEntityKirasuko(par1);
			case 38: return new DqmEntityMapetman(par1);
			case 39: return new DqmEntityMarinsuraimu(par1);
			case 40: return new DqmEntityMatango(par1);
			case 41: return new DqmEntityMeijidoraki(par1);
			case 42: return new DqmEntityMeijikimera(par1);
			case 43: return new DqmEntityMeragosuto(par1);
			case 44: return new DqmEntityMetaruhantaken(par1);
			case 45: return new DqmEntityMetaruraida(par1);
			case 46: return new DqmEntityMetoroghost(par1);
			case 47: return new DqmEntityMinidemon(par1);
			case 48: return new DqmEntityMokomokojuu(par1);
			case 49: return new DqmEntityMrippusu(par1);
			case 50: return new DqmEntityNightwalker(par1);
			case 51: return new DqmEntityObakekyandoru(par1);
			case 52: return new DqmEntityOdoruhouseki(par1);
			case 53: return new DqmEntityPinkmomon(par1);
			case 54: return new DqmEntityRaimusuraimu(par1);
			case 55: return new DqmEntitySamayoutamasii(par1);
			case 56: return new DqmEntitySamayouyoroi(par1);
			case 57: return new DqmEntitySibireageha(par1);
			case 58: return new DqmEntitySibiredanbira(par1);
			case 59: return new DqmEntitySkullgaroo(par1);
			case 60: return new DqmEntitySumairurokku(par1);
			case 61: return new DqmEntitySumoruguru(par1);
			case 62: return new DqmEntitySupekutetto(par1);
			case 63: return new DqmEntitySura2(par1);
			case 64: return new DqmEntitySuraimubogu(par1);
			case 65: return new DqmEntitySuraimuburesu(par1);
			case 66: return new DqmEntitySyado(par1);
			case 67: return new DqmEntityTahodoraki(par1);
			case 68: return new DqmEntityTomosibikozou(par1);
			case 69: return new DqmEntityTonburero(par1);
			case 70: return new DqmEntityTororu(par1);
			case 71: return new DqmEntityTutiwarasi(par1);
			case 72: return new DqmEntityUmiusi(par1);
			case 73: return new DqmEntityYouganmajin(par1);
			case 74: return new DqmEntityGorotuki(par1);
			default :return new DqmEntitySura(par1);
		}
	}

	public DqmMobBase getRandomSP(World par1)
	{
		int val = rand.nextInt(24);

		switch(val)
		{
			case 0: return new DqmEntityAtorasu(par1);
			case 1: return new DqmEntityBazuzu(par1);
			case 2: return new DqmEntityBurasu(par1);
			case 3: return new DqmEntityDarkRamia(par1);
			case 4: return new DqmEntityGodonheddo(par1);
			case 5: return new DqmEntityKandatakobun(par1);
			case 6: return new DqmEntityKinghidora(par1);
			case 7: return new DqmEntityKiramajinga(par1);
			case 8: return new DqmEntityKiratoti(par1);
			case 9: return new DqmEntityMashougumo(par1);
			case 10: return new DqmEntityMasso(par1);
			case 11: return new DqmEntityPisaronaito(par1);
			case 12: return new DqmEntityPuremiasuraimu(par1);
			case 13: return new DqmEntitySirubamanto(par1);
			case 14: return new DqmEntitySuraimujeneraru(par1);
			case 15: return new DqmEntityTattyan(par1);
			case 16: return new DqmEntityTororubakkosu(par1);
			case 17: return new DqmEntityUragirikozou(par1);
			case 18: return new DqmEntityWanpakusatan(par1);
			case 19: return new DqmEntityYamatanooroti(par1);
			case 20: return new DqmEntityFureizado(par1);
			case 21: return new DqmEntityKandata(par1);
			case 22: return new DqmEntityBlackchack(par1);
			case 23: return new DqmEntitySuraimuemperor(par1);
			default :return new DqmEntitySura(par1);
		}
	}

	public DqmMobBase getRandomTENSEI(World par1)
	{
		int val = rand.nextInt(25);

		switch(val)
		{
			case 0: return new DqmEntityArukemisuton(par1);
			case 1: return new DqmEntityBebingosatan(par1);
			case 2: return new DqmEntityDebirurodo(par1);
			case 3: return new DqmEntityGoldmanto(par1);
			case 4: return new DqmEntityGorudenkon(par1);
			case 5: return new DqmEntityHatonaito(par1);
			case 6: return new DqmEntityKirapike(par1);
			case 7: return new DqmEntityKuinmomon(par1);
			case 8: return new DqmEntityMaaburun(par1);
			case 9: return new DqmEntityMadrainbow(par1);
			case 10: return new DqmEntityMetaruhoimin(par1);
			case 11: return new DqmEntityMomoirosansimai(par1);
			case 12: return new DqmEntityMoonkimera(par1);
			case 13: return new DqmEntityNoroinoiwa(par1);
			case 14: return new DqmEntityPinkbonbon(par1);
			case 15: return new DqmEntityReddoatya(par1);
			case 16: return new DqmEntitySabotengold(par1);
			case 17: return new DqmEntitySeigin(par1);
			case 18: return new DqmEntityShuvaluts(par1);
			case 19: return new DqmEntitySirudoaniki(par1);
			case 20: return new DqmEntitySweetbag(par1);
			case 21: return new DqmEntityTaipug(par1);
			case 22: return new DqmEntityTogekonbou(par1);
			case 23: return new DqmEntityTumurinmama(par1);
			case 24: return new DqmEntityTyokonuba(par1);
			default :return new DqmEntitySura(par1);
		}
	}

	public DqmMobBase getRandomDay(World par1)
	{
		int val = rand.nextInt(58);

		switch(val)
		{
			case 0: return new DqmEntityAyasiikage(par1);
			case 1: return new DqmEntityBigCrow(par1);
			case 2: return new DqmEntityBigguhatto(par1);
			case 3: return new DqmEntityBubsura(par1);
			case 4: return new DqmEntityBurauni(par1);
			case 5: return new DqmEntityButisuraimu(par1);
			case 6: return new DqmEntityDokuroarai(par1);
			case 7: return new DqmEntityDoronuba(par1);
			case 8: return new DqmEntityDorozara(par1);
			case 9: return new DqmEntityDoruido(par1);
			case 10: return new DqmEntityDragosuraimu(par1);
			case 11: return new DqmEntityDucksbill(par1);
			case 12: return new DqmEntityEbiruapple(par1);
			case 13: return new DqmEntityFaratto(par1);
			case 14: return new DqmEntityGaikotu(par1);
			case 15: return new DqmEntityGizumoAZ(par1);
			case 16: return new DqmEntityGuntaigani(par1);
			case 17: return new DqmEntityHitokuikibako(par1);
			case 18: return new DqmEntityHitokuisaberu(par1);
			case 19: return new DqmEntityHoimisura(par1);
			case 20: return new DqmEntityIkkakuusagi(par1);
			case 21: return new DqmEntityItamogu(par1);
			case 22: return new DqmEntityKimera(par1);
			case 23: return new DqmEntityKirapan(par1);
			case 24: return new DqmEntityKirikabuobake(par1);
			case 25: return new DqmEntityMadohando(par1);
			case 26: return new DqmEntityMomon(par1);
			case 27: return new DqmEntityMomonja(par1);
			case 28: return new DqmEntityObakekinoko(par1);
			case 29: return new DqmEntityObakeumiusi(par1);
			case 30: return new DqmEntityOnikozou(par1);
			case 31: return new DqmEntityOokiduti(par1);
			case 32: return new DqmEntityOokutibasi(par1);
			case 33: return new DqmEntityOomedama(par1);
			case 34: return new DqmEntityOonamekuji(par1);
			case 35: return new DqmEntityPapetkozou(par1);
			case 36: return new DqmEntityPurizunyan(par1);
			case 37: return new DqmEntityRemonsuraimu(par1);
			case 38: return new DqmEntityRippusu(par1);
			case 39: return new DqmEntityRiripat(par1);
			case 40: return new DqmEntitySabotenboru(par1);
			case 41: return new DqmEntitySibirekurage(par1);
			case 42: return new DqmEntitySimasimacat(par1);
			case 43: return new DqmEntitySirudokozou(par1);
			case 44: return new DqmEntitySukippaa(par1);
			case 45: return new DqmEntitySunomon(par1);
			case 46: return new DqmEntitySupini(par1);
			case 47: return new DqmEntitySura(par1);
			case 48: return new DqmEntitySuraimubesu(par1);
			case 49: return new DqmEntitySuraimunaito(par1);
			case 50: return new DqmEntitySuraimutawa(par1);
			case 51: return new DqmEntitySuraimutumuri(par1);
			case 52: return new DqmEntityTogebouzu(par1);
			case 53: return new DqmEntityTukaima(par1);
			case 54: return new DqmEntityUzusioking(par1);
			case 55: return new DqmEntityWaraibukuro(par1);
			case 56: return new DqmEntityZinmentyou(par1);
			case 57: return new DqmEntityZukkinya(par1);
			default :return new DqmEntitySura(par1);
		}
	}


	public DqmMobBase getRandomSikabaneNether(World par1)
	{
		return null;
	}

	public DqmMobBase getRandomSikabaneEnd(World par1)
	{
		return null;
	}
/***************************************************************************************************/

	public String getRandomBossName()
	{
		int val = rand.nextInt(9);

		switch(val)
		{
			case 0: return "Zoma";
			case 1: return "Desupisaro1";
			case 2: return "Desupisaro2";
			case 3: return "Desupisaro3";
			case 4: return "Esterk";
			case 5: return "God";
			case 6: return "Masterdoragon";
			case 7: return "Ryuuou";
			case 8: return "Ryuuou2";
			default :return "Sura";
		}
	}

	public String getRandomEndName()
	{
		int val = rand.nextInt(25);

		switch(val)
		{
		    case 0: return "Desusutoka";
			case 1: return "Bassaimasin";
			case 2: return "Batorurex";
			case 3: return "Biggumoai";
			case 4: return "Burizado";
			case 5: return "Dakunaito";
			case 6: return "Darktororu";
			case 7: return "Dasudragon";
			case 8: return "Denga";
			case 9: return "Desujakkaru";
			case 10: return "Desunyago";
			case 11: return "Dragondarknaito";
			case 12: return "Gamegonrejendo";
			case 13: return "Gigantesu";
			case 14: return "Godraida";
			case 15: return "Gorudensuraimu";
			case 16: return "Jigokunoyoroi";
			case 17: return "Kagenokisi";
			case 18: return "Manemane";
			case 19: return "Pandorabox";
			case 20: return "Ryuiso";
			case 21: return "Tororubonba";
			case 22: return "Dakuhobitto";
			case 23: return "Akairai";
			case 24: return "Shadopan2";
			default :return "Sura";
		}
	}

	public String getRandomNetherName()
	{
		int val = rand.nextInt(68);

		switch(val)
		{
			case 0: return "Ankokumajin";
			case 1: return "Aroinpu";
			case 2: return "Baburuking";
			case 3: return "Barakku";
			case 4: return "Bariidodog";
			case 5: return "Behomasuraimu";
			case 6: return "Biggufeisu";
			case 7: return "Bighanma";
			case 8: return "Bosutororu";
			case 9: return "Boureikensi";
			case 10: return "Buraddosodo";
			case 11: return "Burakkubejita";
			case 12: return "Darkslime";
			case 13: return "Deddopekka";
			case 14: return "Dgizumo";
			case 15: return "Dollmaster";
			case 16: return "Doragonsoruja";
			case 17: return "Dqmdragon";
			case 18: return "Dragonnaito";
			case 19: return "Dragonraida";
			case 20: return "Fureimu";
			case 21: return "Gamegon";
			case 22: return "Gamegonload";
			case 23: return "Ganirasu";
			case 24: return "Goldman";
			case 25: return "Goremu";
			case 26: return "Gorudentotemu";
			case 27: return "Hotatewarabi";
			case 28: return "Jigokunohasami";
			case 29: return "Kedamon";
			case 30: return "Kemunkurusu";
			case 31: return "Kimendousi";
			case 32: return "Kiraama";
			case 33: return "Kirakurabu";
			case 34: return "Kiramasin";
			case 35: return "Kiramasin2";
			case 36: return "Kisudragon";
			case 37: return "Kuinsuraimu";
			case 38: return "Magematango";
			case 39: return "Magemomonja";
			case 40: return "Magumaron";
			case 41: return "Majikaruhatto";
			case 42: return "Maounokage";
			case 43: return "Maporena";
			case 44: return "Megazarurokku";
			case 45: return "Umibouzu";
			case 46: return "Mimikku";
			case 47: return "Papettoman";
			case 48: return "Pikusi";
			case 49: return "Pombom";
			case 50: return "Puyon";
			case 51: return "Redsaikuron";
			case 52: return "Saikuropusu";
			case 53: return "Sirubadebiru";
			case 54: return "Siryou";
			case 55: return "Siryounokisi";
			case 56: return "Sodofantomu";
			case 57: return "Starkimera";
			case 58: return "Stonman";
			case 59: return "Suraimubehomazun";
			case 60: return "Suraimuhaitawa";
			case 61: return "Suraimumadyura";
			case 62: return "Tororuking";
			case 63: return "Tubokku";
			case 64: return "Umibouzu";
			case 65: return "Eriminator";
			case 66: return "Darkdoriado";
			case 67: return "Shadopan";
			default :return "Sura";
		}
	}

	public String getRandomMetaruName()
	{
		int val = rand.nextInt(9);

		switch(val)
		{
			case 0: return "Daiyamondosuraimu";
			case 1: return "Dragometaru";
			case 2: return "Goldenmetalslime";
			case 3: return "Hagumeta";
			case 4: return "Haguremetaruking";
			case 5: return "Metaking";
			case 6: return "Metaruburazazu";
			case 7: return "Metasura";
			case 8: return "Puratinaking";
			default :return "Sura";
		}
	}

	public String getRandomNightName()
	{
		int val = rand.nextInt(75);

		switch(val)
		{
			case 0: return "Akumanosyo";
			case 1: return "Akumanotubo";
			case 2: return "Animaruzonbi";
			case 3: return "Arumiraji";
			case 4: return "Axedoragon";
			case 5: return "Baburin";
			case 6: return "Bakudanbebi";
			case 7: return "Bakudaniwa";
			case 8: return "Bebisatan";
			case 9: return "Behoimisuraimu";
			case 10: return "Behoimusuraimu";
			case 11: return "Berobero";
			case 12: return "Beronyaago";
			case 13: return "Besuking";
			case 14: return "Buchunpa";
			case 15: return "Buraddihando";
			case 16: return "Buttizukinya";
			case 17: return "Dansunidoru";
			case 18: return "Desufuratta";
			case 19: return "Dokuyazukin";
			case 20: return "Doraki";
			case 21: return "Dorakima";
			case 22: return "Doroningyou";
			case 23: return "Enzeruslime";
			case 24: return "Fgizumo";
			case 25: return "Gaikotukensi";
			case 26: return "Gappurin";
			case 27: return "Genjutusi";
			case 28: return "Ghost";
			case 29: return "Herughost";
			case 30: return "Hgizumo";
			case 31: return "Hitokuiga";
			case 32: return "Horoghost";
			case 33: return "Hyouganmajin";
			case 34: return "Jeriman";
			case 35: return "Kingsura";
			case 36: return "Kirapan2";
			case 37: return "Kirasuko";
			case 38: return "Mapetman";
			case 39: return "Marinsuraimu";
			case 40: return "Matango";
			case 41: return "Meijidoraki";
			case 42: return "Meijikimera";
			case 43: return "Meragosuto";
			case 44: return "Metaruhantaken";
			case 45: return "Metaruraida";
			case 46: return "Metoroghost";
			case 47: return "Minidemon";
			case 48: return "Mokomokojuu";
			case 49: return "Mrippusu";
			case 50: return "Nightwalker";
			case 51: return "Obakekyandoru";
			case 52: return "Odoruhouseki";
			case 53: return "Pinkmomon";
			case 54: return "Raimusuraimu";
			case 55: return "Samayoutamasii";
			case 56: return "Samayouyoroi";
			case 57: return "Sibireageha";
			case 58: return "Sibiredanbira";
			case 59: return "Skullgaroo";
			case 60: return "Sumairurokku";
			case 61: return "Sumoruguru";
			case 62: return "Supekutetto";
			case 63: return "Sura2";
			case 64: return "Suraimubogu";
			case 65: return "Suraimuburesu";
			case 66: return "Syado";
			case 67: return "Tahodoraki";
			case 68: return "Tomosibikozou";
			case 69: return "Tonburero";
			case 70: return "Tororu";
			case 71: return "Tutiwarasi";
			case 72: return "Umiusi";
			case 73: return "Youganmajin";
			case 74: return "Gorotuki";
			default :return "Sura";
		}
	}

	public String getRandomSPName()
	{
		int val = rand.nextInt(24);

		switch(val)
		{
			case 0: return "Atorasu";
			case 1: return "Bazuzu";
			case 2: return "Burasu";
			case 3: return "Akairai";
			case 4: return "Godonheddo";
			case 5: return "Kandatakobun";
			case 6: return "Kinghidora";
			case 7: return "Kiramajinga";
			case 8: return "Kiratoti";
			case 9: return "Mashougumo";
			case 10: return "Masso";
			case 11: return "Pisaronaito";
			case 12: return "Puremiasuraimu";
			case 13: return "Sirubamanto";
			case 14: return "Suraimujeneraru";
			case 15: return "Tattyan";
			case 16: return "Tororubakkosu";
			case 17: return "Uragirikozou";
			case 18: return "Wanpakusatan";
			case 19: return "Yamatanooroti";
			case 20: return "Fureizado";
			case 21: return "Kandata";
			case 22: return "Blackchack";
			case 23: return "Suraimuemperor";
			default :return "Sura";
		}
	}

	public String getRandomTENSEIName()
	{
		int val = rand.nextInt(25);

		switch(val)
		{
			case 0: return "Arukemisuton";
			case 1: return "Bebingosatan";
			case 2: return "Debirurodo";
			case 3: return "Goldmanto";
			case 4: return "Gorudenkon";
			case 5: return "Hatonaito";
			case 6: return "Kirapike";
			case 7: return "Kuinmomon";
			case 8: return "Maaburun";
			case 9: return "Madrainbow";
			case 10: return "Metaruhoimin";
			case 11: return "Momoirosansimai";
			case 12: return "Moonkimera";
			case 13: return "Noroinoiwa";
			case 14: return "Pinkbonbon";
			case 15: return "Reddoatya";
			case 16: return "Sabotengold";
			case 17: return "Seigin";
			case 18: return "Shuvaluts";
			case 19: return "Sirudoaniki";
			case 20: return "Sweetbag";
			case 21: return "Taipug";
			case 22: return "Togekonbou";
			case 23: return "Tumurinmama";
			case 24: return "Tyokonuba";
			default :return "Sura";
		}
	}

	public String getRandomDayName()
	{
		int val = rand.nextInt(58);

		switch(val)
		{
		case 0: return "Ayasiikage";
			case 1: return "BigCrow";
			case 2: return "Bigguhatto";
			case 3: return "Bubsura";
			case 4: return "Burauni";
			case 5: return "Butisuraimu";
			case 6: return "Dokuroarai";
			case 7: return "Doronuba";
			case 8: return "Dorozara";
			case 9: return "Doruido";
			case 10: return "Dragosuraimu";
			case 11: return "Ducksbill";
			case 12: return "Ebiruapple";
			case 13: return "Faratto";
			case 14: return "Gaikotu";
			case 15: return "GizumoAZ";
			case 16: return "Guntaigani";
			case 17: return "Hitokuikibako";
			case 18: return "Hitokuisaberu";
			case 19: return "Hoimisura";
			case 20: return "Ikkakuusagi";
			case 21: return "Itamogu";
			case 22: return "Kimera";
			case 23: return "Kirapan";
			case 24: return "Kirikabuobake";
			case 25: return "Madohando";
			case 26: return "Momon";
			case 27: return "Momonja";
			case 28: return "Obakekinoko";
			case 29: return "Obakeumiusi";
			case 30: return "Onikozou";
			case 31: return "Ookiduti";
			case 32: return "Ookutibasi";
			case 33: return "Oomedama";
			case 34: return "Oonamekuji";
			case 35: return "Papetkozou";
			case 36: return "Purizunyan";
			case 37: return "Remonsuraimu";
			case 38: return "Rippusu";
			case 39: return "Riripat";
			case 40: return "Sabotenboru";
			case 41: return "Sibirekurage";
			case 42: return "Simasimacat";
			case 43: return "Sirudokozou";
			case 44: return "Sukippaa";
			case 45: return "Sunomon";
			case 46: return "Supini";
			case 47: return "Sura";
			case 48: return "Suraimubesu";
			case 49: return "Suraimunaito";
			case 50: return "Suraimutawa";
			case 51: return "Suraimutumuri";
			case 52: return "Togebouzu";
			case 53: return "Tukaima";
			case 54: return "Uzusioking";
			case 55: return "Waraibukuro";
			case 56: return "Zinmentyou";
			case 57: return "Zukkinya";
			default :return "Sura";
		}
	}

}
