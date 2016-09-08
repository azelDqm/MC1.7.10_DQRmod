package dqr.handler;

import java.util.Random;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.api.Blocks.DQDecorates;
import dqr.api.Blocks.DQMobFigures;
import dqr.api.Blocks.DQMobObjects;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQEmblems;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmMobRoot;
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
import dqr.entity.mobEntity.monsterBoss.DqmMobBaseBoss;
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
import dqr.entity.mobEntity.monsterDay.DqmMobBaseDay;
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
import dqr.entity.mobEntity.monsterEnd.DqmMobBaseEnd;
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
import dqr.entity.mobEntity.monsterHell.DqmEntityMetaruhanta;
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
import dqr.entity.mobEntity.monsterHell.DqmEntityTubokku;
import dqr.entity.mobEntity.monsterHell.DqmEntityUmibouzu;
import dqr.entity.mobEntity.monsterHell.DqmMobBaseHell;
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
import dqr.entity.mobEntity.monsterNight.DqmMobBaseNight;
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
import dqr.entity.mobEntity.monsterSP.DqmMobBaseSP;
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
import dqr.entity.mobEntity.monsterTensei.DqmMobBaseTensei;

public class LivingDropHandler {

	@SubscribeEvent
	public void onDeathDropHookEvent(LivingDeathEvent event)
	{
		Random rand = new Random();
		if(event.entityLiving.worldObj.isRemote) {
			return;
		}

		//牛のフン・馬のフン
		if(event.entityLiving instanceof EntityCow) {
			if (event.entityLiving.worldObj.rand.nextInt(3) == 0)
			{
				event.entityLiving.dropItem(DQMiscs.itemUsinofun, 1);
			}
		}else if(event.entityLiving instanceof EntityHorse) {
			if (event.entityLiving.worldObj.rand.nextInt(3) == 0)
			{
				event.entityLiving.dropItem(DQMiscs.itemUmanofun, 1);
			}
		}

		//悪魔のピアス
		if(event.entityLiving instanceof DqmMobBase)
		{
			DqmMobBase mob = (DqmMobBase)event.entityLiving;
			if(mob.MobRoot.getId() == EnumDqmMobRoot.AKUMA.getId())
			{
				int rate = 0;
				if(event.entityLiving instanceof DqmMobBaseDay || event.entityLiving instanceof DqmMobBaseNight)
				{
					rate = 3000;
				}else if(event.entityLiving instanceof DqmMobBaseHell)
				{
					rate = 1000;
				}else if(event.entityLiving instanceof DqmMobBaseEnd)
				{
					rate = 500;
				}else if(event.entityLiving instanceof DqmMobBaseSP)
				{
					rate = 100;
				}else if(event.entityLiving instanceof DqmMobBaseTensei)
				{
					rate = 100;
				}

				if(rate > 0 && rand.nextInt(rate) == 0)
				{
					event.entityLiving.dropItem(DQAccessories.itemAkumanopiasu, 1);
				}


			}
		}



		//ドラゴン転職証
		if(event.entityLiving instanceof DqmMobBase && rand.nextInt(1000) == 0)
		{
			DqmMobBase mob = (DqmMobBase)event.entityLiving;
			if(mob.MobRoot.getId() == EnumDqmMobRoot.DRAGON.getId())
			{
				event.entityLiving.dropItem(DQEmblems.itemEmbDragon, 1);
			}
		}

		if(event.entityLiving instanceof DqmMobBase && rand.nextInt(3000) == 0)
		{
			DqmMobBase mob = (DqmMobBase)event.entityLiving;
			if(mob.MobRoot.getId() == EnumDqmMobRoot.DRAGON.getId())
			{
				event.entityLiving.dropItem(DQMiscs.itemDragonObuB, 1);
			}
		}

		//転生からのアクセサリ
		if(event.entityLiving instanceof DqmMobBaseTensei && rand.nextInt(500) == 0)
		{
			if(event.entityLiving instanceof DqmEntitySeigin){
				event.entityLiving.dropItem(DQAccessories.itemMangetunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityDebirurodo){
				event.entityLiving.dropItem(DQAccessories.itemHagennoring, 1);
			}else if(event.entityLiving instanceof DqmEntityMaaburun){
				event.entityLiving.dropItem(DQAccessories.itemRiseinoring, 1);
			}else if(event.entityLiving instanceof DqmEntityArukemisuton){
				event.entityLiving.dropItem(DQAccessories.itemRiseinoring, 1);
			}else if(event.entityLiving instanceof DqmEntityGorudenkon){
				event.entityLiving.dropItem(DQAccessories.itemMangetunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityKuinmomon){
				event.entityLiving.dropItem(DQAccessories.itemRiseinoring, 1);
			}else if(event.entityLiving instanceof DqmEntityMoonkimera){
				event.entityLiving.dropItem(DQAccessories.itemMangetunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityTyokonuba){
				event.entityLiving.dropItem(DQAccessories.itemHadokunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityReddoatya){
				event.entityLiving.dropItem(DQAccessories.itemHadokunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityKirapike){
				event.entityLiving.dropItem(DQAccessories.itemHadokunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityTogekonbou){
				event.entityLiving.dropItem(DQAccessories.itemHadokunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityTaipug){
				event.entityLiving.dropItem(DQAccessories.itemMangetunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityBebingosatan){
				event.entityLiving.dropItem(DQAccessories.itemHagennoring, 1);
			}else if(event.entityLiving instanceof DqmEntityGoldmanto){
				event.entityLiving.dropItem(DQAccessories.itemRiseinoring, 1);
			}else if(event.entityLiving instanceof DqmEntityHatonaito){
				event.entityLiving.dropItem(DQAccessories.itemHagennoring, 1);
			}else if(event.entityLiving instanceof DqmEntityMadrainbow){
				event.entityLiving.dropItem(DQAccessories.itemRiseinoring, 1);
			}else if(event.entityLiving instanceof DqmEntityMetaruhoimin){
				event.entityLiving.dropItem(DQAccessories.itemMangetunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityMomoirosansimai){
				event.entityLiving.dropItem(DQAccessories.itemHagennoring, 1);
			}else if(event.entityLiving instanceof DqmEntityNoroinoiwa){
				event.entityLiving.dropItem(DQAccessories.itemHadokunoring, 1);
			}else if(event.entityLiving instanceof DqmEntityPinkbonbon){
				event.entityLiving.dropItem(DQAccessories.itemHagennoring, 1);
			}else if(event.entityLiving instanceof DqmEntitySabotengold){
				event.entityLiving.dropItem(DQAccessories.itemHagennoring, 1);
			}else if(event.entityLiving instanceof DqmEntityShuvaluts){
				event.entityLiving.dropItem(DQAccessories.itemRiseinoring, 1);
			}else if(event.entityLiving instanceof DqmEntitySirudoaniki){
				event.entityLiving.dropItem(DQAccessories.itemHadokunoring, 1);
			}
		}

		if(event.entityLiving instanceof DqmEntitySweetbag && rand.nextInt(999) == 0)
		{
			int val = rand.nextInt(4);
			if(val == 0)
			{
				event.entityLiving.dropItem(DQAccessories.itemHadokunoring, 1);
			}else if(val == 1)
			{
				event.entityLiving.dropItem(DQAccessories.itemHagennoring, 1);
			}else if(val == 2)
			{
				event.entityLiving.dropItem(DQAccessories.itemRiseinoring, 1);
			}else if(val == 3)
			{
				event.entityLiving.dropItem(DQAccessories.itemMangetunoring, 1);
			}
		}

		//転生からの転職証1
		if(event.entityLiving instanceof DqmMobBaseTensei && rand.nextInt(10) == 0)
		{
			if(event.entityLiving instanceof DqmEntitySeigin){
				event.entityLiving.dropItem(DQEmblems.itemEmbFighter, 1);
			}else if(event.entityLiving instanceof DqmEntityDebirurodo){
				event.entityLiving.dropItem(DQEmblems.itemEmbMagician, 1);
			}else if(event.entityLiving instanceof DqmEntityMaaburun){
				event.entityLiving.dropItem(DQEmblems.itemEmbCivilian, 1);
			}else if(event.entityLiving instanceof DqmEntityArukemisuton){
				event.entityLiving.dropItem(DQEmblems.itemEmbMagician, 1);
			}else if(event.entityLiving instanceof DqmEntityGorudenkon){
				event.entityLiving.dropItem(DQEmblems.itemEmbCivilian, 1);
			}else if(event.entityLiving instanceof DqmEntityKuinmomon){
				event.entityLiving.dropItem(DQEmblems.itemEmbPriest, 1);
			}else if(event.entityLiving instanceof DqmEntityMoonkimera){
				event.entityLiving.dropItem(DQEmblems.itemEmbMagician, 1);
			}else if(event.entityLiving instanceof DqmEntityTyokonuba){
				event.entityLiving.dropItem(DQEmblems.itemEmbFighter, 1);
			}else if(event.entityLiving instanceof DqmEntityReddoatya){
				event.entityLiving.dropItem(DQEmblems.itemEmbThief, 1);
			}else if(event.entityLiving instanceof DqmEntityKirapike){
				event.entityLiving.dropItem(DQEmblems.itemEmbWarrior, 1);
			}else if(event.entityLiving instanceof DqmEntityTogekonbou){
				event.entityLiving.dropItem(DQEmblems.itemEmbFighter, 1);
			}else if(event.entityLiving instanceof DqmEntityTaipug){
				event.entityLiving.dropItem(DQEmblems.itemEmbWarrior, 1);
			}else if(event.entityLiving instanceof DqmEntityBebingosatan){
				event.entityLiving.dropItem(DQEmblems.itemEmbThief, 1);
			}else if(event.entityLiving instanceof DqmEntityGoldmanto){
				event.entityLiving.dropItem(DQEmblems.itemEmbMerchant, 1);
			}else if(event.entityLiving instanceof DqmEntityHatonaito){
				event.entityLiving.dropItem(DQEmblems.itemEmbWarrior, 1);
			}else if(event.entityLiving instanceof DqmEntityMadrainbow){
				event.entityLiving.dropItem(DQEmblems.itemEmbMagician, 1);
			}else if(event.entityLiving instanceof DqmEntityMetaruhoimin){
				event.entityLiving.dropItem(DQEmblems.itemEmbPriest, 1);
			}else if(event.entityLiving instanceof DqmEntityMomoirosansimai){
				event.entityLiving.dropItem(DQEmblems.itemEmbFighter, 1);
			}else if(event.entityLiving instanceof DqmEntityNoroinoiwa){
				event.entityLiving.dropItem(DQEmblems.itemEmbMerchant, 1);
			}else if(event.entityLiving instanceof DqmEntityPinkbonbon){
				event.entityLiving.dropItem(DQEmblems.itemEmbCivilian, 1);
			}else if(event.entityLiving instanceof DqmEntitySabotengold){
				event.entityLiving.dropItem(DQEmblems.itemEmbMerchant, 1);
			}else if(event.entityLiving instanceof DqmEntityShuvaluts){
				event.entityLiving.dropItem(DQEmblems.itemEmbWarrior, 1);
			}else if(event.entityLiving instanceof DqmEntitySirudoaniki){
				event.entityLiving.dropItem(DQEmblems.itemEmbThief, 1);
			}else if(event.entityLiving instanceof DqmEntitySweetbag){
				event.entityLiving.dropItem(DQEmblems.itemEmbMerchant, 1);
			}else if(event.entityLiving instanceof DqmEntityTumurinmama){
				event.entityLiving.dropItem(DQEmblems.itemEmbPriest, 1);
			}
		}

		//転生からの転職証2
		if(event.entityLiving instanceof DqmMobBaseTensei && rand.nextInt(100) == 0)
		{
			if(event.entityLiving instanceof DqmEntitySeigin){
				event.entityLiving.dropItem(DQEmblems.itemEmbSage, 1);
			}else if(event.entityLiving instanceof DqmEntityDebirurodo){
				event.entityLiving.dropItem(DQEmblems.itemEmbSage, 1);
			}else if(event.entityLiving instanceof DqmEntityMaaburun){
				event.entityLiving.dropItem(DQEmblems.itemEmbMonsterTamer, 1);
			}else if(event.entityLiving instanceof DqmEntityArukemisuton){
				event.entityLiving.dropItem(DQEmblems.itemEmbSage, 1);
			}else if(event.entityLiving instanceof DqmEntityGorudenkon){
				event.entityLiving.dropItem(DQEmblems.itemEmbRanger, 1);
			}else if(event.entityLiving instanceof DqmEntityKuinmomon){
				event.entityLiving.dropItem(DQEmblems.itemEmbPaladin, 1);
			}else if(event.entityLiving instanceof DqmEntityMoonkimera){
				event.entityLiving.dropItem(DQEmblems.itemEmbSage, 1);
			}else if(event.entityLiving instanceof DqmEntityTyokonuba){
				event.entityLiving.dropItem(DQEmblems.itemEmbRanger, 1);
			}else if(event.entityLiving instanceof DqmEntityReddoatya){
				event.entityLiving.dropItem(DQEmblems.itemEmbRanger, 1);
			}else if(event.entityLiving instanceof DqmEntityKirapike){
				event.entityLiving.dropItem(DQEmblems.itemEmbBattleMaster, 1);
			}else if(event.entityLiving instanceof DqmEntityTogekonbou){
				event.entityLiving.dropItem(DQEmblems.itemEmbBattleMaster, 1);
			}else if(event.entityLiving instanceof DqmEntityTaipug){
				event.entityLiving.dropItem(DQEmblems.itemEmbPaladin, 1);
			}else if(event.entityLiving instanceof DqmEntityBebingosatan){
				event.entityLiving.dropItem(DQEmblems.itemEmbPirate, 1);
			}else if(event.entityLiving instanceof DqmEntityGoldmanto){
				event.entityLiving.dropItem(DQEmblems.itemEmbMagickKnight, 1);
			}else if(event.entityLiving instanceof DqmEntityHatonaito){
				event.entityLiving.dropItem(DQEmblems.itemEmbPaladin, 1);
			}else if(event.entityLiving instanceof DqmEntityMadrainbow){
				event.entityLiving.dropItem(DQEmblems.itemEmbDancer, 1);
			}else if(event.entityLiving instanceof DqmEntityMetaruhoimin){
				event.entityLiving.dropItem(DQEmblems.itemEmbMagickKnight, 1);
			}else if(event.entityLiving instanceof DqmEntityMomoirosansimai){
				event.entityLiving.dropItem(DQEmblems.itemEmbDancer, 1);
			}else if(event.entityLiving instanceof DqmEntityNoroinoiwa){
				event.entityLiving.dropItem(DQEmblems.itemEmbPirate, 1);
			}else if(event.entityLiving instanceof DqmEntityPinkbonbon){
				event.entityLiving.dropItem(DQEmblems.itemEmbMonsterTamer, 1);
			}else if(event.entityLiving instanceof DqmEntitySabotengold){
				event.entityLiving.dropItem(DQEmblems.itemEmbPirate, 1);
			}else if(event.entityLiving instanceof DqmEntityShuvaluts){
				event.entityLiving.dropItem(DQEmblems.itemEmbMagickKnight, 1);
			}else if(event.entityLiving instanceof DqmEntitySirudoaniki){
				event.entityLiving.dropItem(DQEmblems.itemEmbBattleMaster, 1);
			}else if(event.entityLiving instanceof DqmEntitySweetbag){
				event.entityLiving.dropItem(DQEmblems.itemEmbDancer, 1);
			}else if(event.entityLiving instanceof DqmEntityTumurinmama){
				event.entityLiving.dropItem(DQEmblems.itemEmbMonsterTamer, 1);
			}
		}

		//転生からの転職証3
		if(event.entityLiving instanceof DqmMobBaseTensei && rand.nextInt(500) == 0)
		{
			if(event.entityLiving instanceof DqmEntitySeigin){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityDebirurodo){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityMaaburun){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityArukemisuton){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityGorudenkon){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityKuinmomon){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityMoonkimera){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityTyokonuba){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityReddoatya){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityKirapike){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityTogekonbou){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityTaipug){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityBebingosatan){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityGoldmanto){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityHatonaito){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityMadrainbow){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityMetaruhoimin){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityMomoirosansimai){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityNoroinoiwa){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityPinkbonbon){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntitySabotengold){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntityShuvaluts){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntitySirudoaniki){
				event.entityLiving.dropItem(DQEmblems.itemEmbGodHnad, 1);
			}else if(event.entityLiving instanceof DqmEntitySweetbag){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}else if(event.entityLiving instanceof DqmEntityTumurinmama){
				event.entityLiving.dropItem(DQEmblems.itemEmbSuperStar, 1);
			}
		}


		//ロトの紋章
		if((event.entityLiving instanceof DqmMobBaseTensei || event.entityLiving instanceof DqmMobBaseSP)&& rand.nextInt(500) == 0)
		{
			event.entityLiving.dropItem(Item.getItemFromBlock(DQDecorates.DqmBlockRotomon), 1);
		}else if(event.entityLiving instanceof DqmMobBaseBoss && rand.nextInt(100) == 0)
		{
			event.entityLiving.dropItem(Item.getItemFromBlock(DQDecorates.DqmBlockRotomon), 1);
		}

		//オブジェ・フィギュア
		if(event.entityLiving instanceof DqmMobBase && rand.nextInt(60) == 0)
		{
			if(event.entityLiving instanceof DqmEntityAkairai){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureAkairai), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAkumanosyo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureAkumanosyo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAkumanotubo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureAkumanotubo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAnimaruzonbi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureAnimaruzonbi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAnkokumajin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureAnkokumajin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAroinpu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureAroinpu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityArukemisuton){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureArukemisuton), 1);
			}
			else if(event.entityLiving instanceof DqmEntityArumiraji){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureArumiraji), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAtorasu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureAtorasu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAxedoragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureAxedoragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAyasiikage){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureAyasiikage), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBaburin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBaburin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBaburuking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBaburuking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBakudanbebi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBakudanbebi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBakudaniwa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBakudaniwa), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBarakku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBarakku), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBariidodog){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBariidodog), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBassaimasin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBassaimasin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBatorurex){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBatorurex), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBazuzu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBazuzu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBebingosatan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBebingosatan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBebisatan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBebisatan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBehoimisuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBehoimisuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBehoimusuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBehoimusuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBehomasuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBehomasuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBerobero){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBerobero), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBeronyaago){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBeronyaago), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBesuking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBesuking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBigCrow){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBigCrow), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBiggufeisu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBiggufeisu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBigguhatto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBigguhatto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBiggumoai){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBiggumoai), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBighanma){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBighanma), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBosutororu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBosutororu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBoureikensi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBoureikensi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBubsura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBubsura), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBuchunpa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBuchunpa), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBuraddihando){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBuraddihando), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBuraddosodo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBuraddosodo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBurakkubejita){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBurakkubejita), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBurasu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBurasu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBurauni){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBurauni), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBurizado){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureBurizado), 1);
			}
			else if(event.entityLiving instanceof DqmEntityButisuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureButisuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityButtizukinya){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureButtizukinya), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDaiyamondosuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDaiyamondosuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDakuhobitto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDakuhobitto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDakunaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDakunaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDansunidoru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDansunidoru), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDarkRamia){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDarkRamia), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDarkslime){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDarkslime), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDarktororu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDarktororu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDasudragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDasudragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDebirurodo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDebirurodo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDeddopekka){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDeddopekka), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDenga){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDenga), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesufuratta){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDesufuratta), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesujakkaru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDesujakkaru), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesunyago){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDesunyago), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesupisaro1){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDesupisaro1), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesupisaro2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDesupisaro2), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesupisaro3){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDesupisaro3), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesusutoka){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDesusutoka), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDgizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDgizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDokuroarai){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDokuroarai), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDokuyazukin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDokuyazukin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDollmaster){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDollmaster), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoragonsoruja){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDoragonsoruja), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoraki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDoraki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDorakima){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDorakima), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoroningyou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDoroningyou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoronuba){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDoronuba), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDorozara){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDorozara), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoruido){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDoruido), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDqmdragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDqmdragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragometaru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDragometaru), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragondarknaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDragondarknaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragonnaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDragonnaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragonraida){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDragonraida), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragosuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDragosuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDucksbill){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureDucksbill), 1);
			}
			else if(event.entityLiving instanceof DqmEntityEbiruapple){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureEbiruapple), 1);
			}
			else if(event.entityLiving instanceof DqmEntityEnzeruslime){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureEnzeruslime), 1);
			}
			else if(event.entityLiving instanceof DqmEntityEriminator){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureEriminator), 1);
			}
			else if(event.entityLiving instanceof DqmEntityEsterk){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureEsterk), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFaratto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureFaratto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFgizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureFgizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFureimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureFureimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFureizado){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureFureizado), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFurosutogizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureFurosutogizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGaikotu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGaikotu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGaikotukensi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGaikotukensi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGamegon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGamegon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGamegonload){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGamegonload), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGamegonrejendo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGamegonrejendo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGanirasu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGanirasu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGappurin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGappurin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGenjutusi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGenjutusi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGhost){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGhost), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGigantesu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGigantesu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGizumoAZ){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGizumoAZ), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGod){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGod), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGodonheddo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGodonheddo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGodraida){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGodraida), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGoldenmetalslime){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGoldenmetalslime), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGoldman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGoldman), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGoldmanto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGoldmanto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGoremu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGoremu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGorotuki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGorotuki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGorudenkon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGorudenkon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGorudensuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGorudensuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGorudentotemu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGorudentotemu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGuntaigani){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureGuntaigani), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHagumeta){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHagumeta), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHaguremetaruking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHaguremetaruking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHatonaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHatonaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHerughost){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHerughost), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHgizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHgizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHiitogizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHiitogizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHitokuibako){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHitokuibako), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHitokuiga){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHitokuiga), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHitokuikibako){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHitokuikibako), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHitokuisaberu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHitokuisaberu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHoimisura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHoimisura), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHoroghost){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHoroghost), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHotatewarabi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHotatewarabi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHyouganmajin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureHyouganmajin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityIkkakuusagi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureIkkakuusagi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityItamogu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureItamogu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityJeriman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureJeriman), 1);
			}
			else if(event.entityLiving instanceof DqmEntityJigokunohasami){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureJigokunohasami), 1);
			}
			else if(event.entityLiving instanceof DqmEntityJigokunoyoroi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureJigokunoyoroi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKagenokisi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKagenokisi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKandatakobun){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKandatakobun), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKedamon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKedamon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKemunkurusu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKemunkurusu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKimendousi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKimendousi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKimera){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKimera), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKingbesu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKingbesu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKinghidora){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKinghidora), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKingsura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKingsura), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiraama){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKiraama), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirakurabu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKirakurabu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiramajinga){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKiramajinga), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiramasin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKiramasin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiramasin2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKiramasin2), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirapan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKirapan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirapan2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKirapan2), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirapike){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKirapike), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirasuko){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKirasuko), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiratoti){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKiratoti), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirikabuobake){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKirikabuobake), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKisudragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKisudragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKuinmomon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKuinmomon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKuinsuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureKuinsuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMaaburun){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMaaburun), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMadohando){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMadohando), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMadrainbow){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMadrainbow), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMagematango){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMagematango), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMagemomonja){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMagemomonja), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMagumaron){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMagumaron), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMajikaruhatto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMajikaruhatto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityManemane){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureManemane), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMaounokage){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMaounokage), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMapetman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMapetman), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMaporena){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMaporena), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMarinsuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMarinsuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMashougumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMashougumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMasso){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMasso), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMasterdoragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMasterdoragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMatango){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMatango), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMegazarurokku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMegazarurokku), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMeijidoraki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMeijidoraki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMeijikimera){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMeijikimera), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMeragosuto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMeragosuto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMetaking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruburazazu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMetaruburazazu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruhanta){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMetaruhanta), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruhantaken){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMetaruhantaken), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruhoimin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMetaruhoimin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruraida){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMetaruraida), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetasura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMetasura), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetoroghost){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMetoroghost), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMimikku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMimikku), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMimikkukibako){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMimikkukibako), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMinidemon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMinidemon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMokomokojuu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMokomokojuu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMomoirosansimai){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMomoirosansimai), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMomon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMomon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMomonja){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMomonja), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMoonkimera){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMoonkimera), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMrippusu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureMrippusu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityNightwalker){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureNightwalker), 1);
			}
			else if(event.entityLiving instanceof DqmEntityNoroinoiwa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureNoroinoiwa), 1);
			}
			else if(event.entityLiving instanceof DqmEntityNorowaretaturugi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureNorowaretaturugi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityObakekinoko){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureObakekinoko), 1);
			}
			else if(event.entityLiving instanceof DqmEntityObakekyandoru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureObakekyandoru), 1);
			}
			else if(event.entityLiving instanceof DqmEntityObakeumiusi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureObakeumiusi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOdoruhouseki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureOdoruhouseki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOnikozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureOnikozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOokiduti){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureOokiduti), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOokutibasi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureOokutibasi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOomedama){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureOomedama), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOonamekuji){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureOonamekuji), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPandorabox){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePandorabox), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPandorakibako){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePandorakibako), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPapetkozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePapetkozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPapettoman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePapettoman), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPikusi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePikusi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPinkbonbon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePinkbonbon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPinkmomon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePinkmomon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPisaronaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePisaronaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPombom){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePombom), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPuratinaking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePuratinaking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPuremiasuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePuremiasuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPurizunyan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePurizunyan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPuyon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigurePuyon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRaimusuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureRaimusuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityReddoatya){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureReddoatya), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRedsaikuron){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureRedsaikuron), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRemonsuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureRemonsuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRippusu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureRippusu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRiripat){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureRiripat), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRyuiso){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureRyuiso), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRyuuou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureRyuuou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRyuuou2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureRyuuou2), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySabotenboru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSabotenboru), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySabotengold){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSabotengold), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySaikuropusu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSaikuropusu), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySamayoutamasii){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSamayoutamasii), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySamayouyoroi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSamayouyoroi), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySeigin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSeigin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityShuvaluts){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureShuvaluts), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySibireageha){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSibireageha), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySibiredanbira){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSibiredanbira), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySibirekurage){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSibirekurage), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySimasimacat){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSimasimacat), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySirubadebiru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSirubadebiru), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySirubamanto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSirubamanto), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySirudoaniki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSirudoaniki), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySirudokozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSirudokozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySiryou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSiryou), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySiryounokisi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSiryounokisi), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySkullgaroo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSkullgaroo), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySodofantomu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSodofantomu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityStarkimera){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureStarkimera), 1);
			}
			else if(event.entityLiving instanceof DqmEntityStonman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureStonman), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySukippaa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSukippaa), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySumairurokku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSumairurokku), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySumoruguru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSumoruguru), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySunomon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSunomon), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySupekutetto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSupekutetto), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySupini){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSupini), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSura), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySura2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSura2), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimubehomazun){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimubehomazun), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimubesu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimubesu), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimubogu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimubogu), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimuburesu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimuburesu), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimuhaitawa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimuhaitawa), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimujeneraru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimujeneraru), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimuking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimuking), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimumadyura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimumadyura), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimunaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimunaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimutawa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimutawa), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimutumuri){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSuraimutumuri), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySweetbag){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSweetbag), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySyado){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureSyado), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTahodoraki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTahodoraki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTaipug){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTaipug), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTattyan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTattyan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTogebouzu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTogebouzu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTogekonbou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTogekonbou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTomosibikozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTomosibikozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTonburero){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTonburero), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTororu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTororu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTororubakkosu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTororubakkosu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTororubonba){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTororubonba), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTororuking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTororuking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTubo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTubo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTubokku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTubokku), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTukaima){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTukaima), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTumurinmama){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTumurinmama), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTutiwarasi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTutiwarasi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTyokonuba){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureTyokonuba), 1);
			}
			else if(event.entityLiving instanceof DqmEntityUmibouzu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureUmibouzu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityUmiusi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureUmiusi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityUragirikozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureUragirikozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityUzusioking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureUzusioking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityWanpakusatan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureWanpakusatan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityWaraibukuro){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureWaraibukuro), 1);
			}
			else if(event.entityLiving instanceof DqmEntityYamatanooroti){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureYamatanooroti), 1);
			}
			else if(event.entityLiving instanceof DqmEntityYouganmajin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureYouganmajin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityZinmentyou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureZinmentyou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityZoma){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureZoma), 1);
			}
			else if(event.entityLiving instanceof DqmEntityZukkinya){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobFigures.BlockFigureZukkinya), 1);
			}
		}

		if(event.entityLiving instanceof DqmMobBase && rand.nextInt(60) == 0)
		{
			if(event.entityLiving instanceof DqmEntityAkairai){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjAkairai), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAkumanosyo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjAkumanosyo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAkumanotubo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjAkumanotubo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAnimaruzonbi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjAnimaruzonbi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAnkokumajin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjAnkokumajin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAroinpu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjAroinpu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityArukemisuton){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjArukemisuton), 1);
			}
			else if(event.entityLiving instanceof DqmEntityArumiraji){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjArumiraji), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAtorasu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjAtorasu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAxedoragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjAxedoragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityAyasiikage){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjAyasiikage), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBaburin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBaburin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBaburuking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBaburuking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBakudanbebi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBakudanbebi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBakudaniwa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBakudaniwa), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBarakku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBarakku), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBariidodog){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBariidodog), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBassaimasin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBassaimasin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBatorurex){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBatorurex), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBazuzu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBazuzu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBebingosatan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBebingosatan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBebisatan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBebisatan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBehoimisuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBehoimisuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBehoimusuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBehoimusuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBehomasuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBehomasuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBerobero){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBerobero), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBeronyaago){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBeronyaago), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBesuking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBesuking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBigCrow){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBigCrow), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBiggufeisu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBiggufeisu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBigguhatto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBigguhatto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBiggumoai){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBiggumoai), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBighanma){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBighanma), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBosutororu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBosutororu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBoureikensi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBoureikensi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBubsura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBubsura), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBuchunpa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBuchunpa), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBuraddihando){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBuraddihando), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBuraddosodo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBuraddosodo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBurakkubejita){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBurakkubejita), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBurasu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBurasu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBurauni){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBurauni), 1);
			}
			else if(event.entityLiving instanceof DqmEntityBurizado){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjBurizado), 1);
			}
			else if(event.entityLiving instanceof DqmEntityButisuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjButisuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityButtizukinya){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjButtizukinya), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDaiyamondosuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDaiyamondosuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDakuhobitto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDakuhobitto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDakunaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDakunaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDansunidoru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDansunidoru), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDarkRamia){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDarkRamia), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDarkslime){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDarkslime), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDarktororu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDarktororu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDasudragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDasudragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDebirurodo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDebirurodo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDeddopekka){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDeddopekka), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDenga){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDenga), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesufuratta){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDesufuratta), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesujakkaru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDesujakkaru), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesunyago){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDesunyago), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesupisaro1){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDesupisaro1), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesupisaro2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDesupisaro2), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesupisaro3){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDesupisaro3), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDesusutoka){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDesusutoka), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDgizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDgizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDokuroarai){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDokuroarai), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDokuyazukin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDokuyazukin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDollmaster){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDollmaster), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoragonsoruja){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDoragonsoruja), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoraki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDoraki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDorakima){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDorakima), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoroningyou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDoroningyou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoronuba){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDoronuba), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDorozara){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDorozara), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDoruido){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDoruido), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDqmdragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDqmdragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragometaru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDragometaru), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragondarknaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDragondarknaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragonnaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDragonnaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragonraida){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDragonraida), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDragosuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDragosuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityDucksbill){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjDucksbill), 1);
			}
			else if(event.entityLiving instanceof DqmEntityEbiruapple){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjEbiruapple), 1);
			}
			else if(event.entityLiving instanceof DqmEntityEnzeruslime){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjEnzeruslime), 1);
			}
			else if(event.entityLiving instanceof DqmEntityEriminator){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjEriminator), 1);
			}
			else if(event.entityLiving instanceof DqmEntityEsterk){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjEsterk), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFaratto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjFaratto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFgizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjFgizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFureimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjFureimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFureizado){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjFureizado), 1);
			}
			else if(event.entityLiving instanceof DqmEntityFurosutogizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjFurosutogizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGaikotu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGaikotu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGaikotukensi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGaikotukensi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGamegon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGamegon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGamegonload){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGamegonload), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGamegonrejendo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGamegonrejendo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGanirasu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGanirasu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGappurin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGappurin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGenjutusi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGenjutusi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGhost){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGhost), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGigantesu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGigantesu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGizumoAZ){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGizumoAZ), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGod){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGod), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGodonheddo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGodonheddo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGodraida){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGodraida), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGoldenmetalslime){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGoldenmetalslime), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGoldman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGoldman), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGoldmanto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGoldmanto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGoremu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGoremu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGorotuki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGorotuki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGorudenkon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGorudenkon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGorudensuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGorudensuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGorudentotemu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGorudentotemu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityGuntaigani){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjGuntaigani), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHagumeta){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHagumeta), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHaguremetaruking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHaguremetaruking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHatonaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHatonaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHerughost){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHerughost), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHgizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHgizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHiitogizumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHiitogizumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHitokuibako){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHitokuibako), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHitokuiga){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHitokuiga), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHitokuikibako){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHitokuikibako), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHitokuisaberu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHitokuisaberu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHoimisura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHoimisura), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHoroghost){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHoroghost), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHotatewarabi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHotatewarabi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityHyouganmajin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjHyouganmajin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityIkkakuusagi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjIkkakuusagi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityItamogu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjItamogu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityJeriman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjJeriman), 1);
			}
			else if(event.entityLiving instanceof DqmEntityJigokunohasami){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjJigokunohasami), 1);
			}
			else if(event.entityLiving instanceof DqmEntityJigokunoyoroi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjJigokunoyoroi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKagenokisi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKagenokisi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKandatakobun){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKandatakobun), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKedamon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKedamon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKemunkurusu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKemunkurusu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKimendousi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKimendousi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKimera){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKimera), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKingbesu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKingbesu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKinghidora){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKinghidora), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKingsura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKingsura), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiraama){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKiraama), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirakurabu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKirakurabu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiramajinga){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKiramajinga), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiramasin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKiramasin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiramasin2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKiramasin2), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirapan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKirapan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirapan2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKirapan2), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirapike){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKirapike), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirasuko){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKirasuko), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKiratoti){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKiratoti), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKirikabuobake){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKirikabuobake), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKisudragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKisudragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKuinmomon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKuinmomon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityKuinsuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjKuinsuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMaaburun){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMaaburun), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMadohando){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMadohando), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMadrainbow){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMadrainbow), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMagematango){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMagematango), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMagemomonja){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMagemomonja), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMagumaron){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMagumaron), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMajikaruhatto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMajikaruhatto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityManemane){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjManemane), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMaounokage){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMaounokage), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMapetman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMapetman), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMaporena){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMaporena), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMarinsuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMarinsuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMashougumo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMashougumo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMasso){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMasso), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMasterdoragon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMasterdoragon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMatango){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMatango), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMegazarurokku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMegazarurokku), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMeijidoraki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMeijidoraki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMeijikimera){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMeijikimera), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMeragosuto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMeragosuto), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMetaking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruburazazu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMetaruburazazu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruhanta){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMetaruhanta), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruhantaken){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMetaruhantaken), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruhoimin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMetaruhoimin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetaruraida){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMetaruraida), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetasura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMetasura), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMetoroghost){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMetoroghost), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMimikku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMimikku), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMimikkukibako){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMimikkukibako), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMinidemon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMinidemon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMokomokojuu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMokomokojuu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMomoirosansimai){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMomoirosansimai), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMomon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMomon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMomonja){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMomonja), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMoonkimera){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMoonkimera), 1);
			}
			else if(event.entityLiving instanceof DqmEntityMrippusu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjMrippusu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityNightwalker){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjNightwalker), 1);
			}
			else if(event.entityLiving instanceof DqmEntityNoroinoiwa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjNoroinoiwa), 1);
			}
			else if(event.entityLiving instanceof DqmEntityNorowaretaturugi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjNorowaretaturugi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityObakekinoko){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjObakekinoko), 1);
			}
			else if(event.entityLiving instanceof DqmEntityObakekyandoru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjObakekyandoru), 1);
			}
			else if(event.entityLiving instanceof DqmEntityObakeumiusi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjObakeumiusi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOdoruhouseki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjOdoruhouseki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOnikozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjOnikozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOokiduti){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjOokiduti), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOokutibasi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjOokutibasi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOomedama){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjOomedama), 1);
			}
			else if(event.entityLiving instanceof DqmEntityOonamekuji){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjOonamekuji), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPandorabox){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPandorabox), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPandorakibako){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPandorakibako), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPapetkozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPapetkozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPapettoman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPapettoman), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPikusi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPikusi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPinkbonbon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPinkbonbon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPinkmomon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPinkmomon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPisaronaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPisaronaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPombom){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPombom), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPuratinaking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPuratinaking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPuremiasuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPuremiasuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPurizunyan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPurizunyan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityPuyon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjPuyon), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRaimusuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjRaimusuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityReddoatya){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjReddoatya), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRedsaikuron){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjRedsaikuron), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRemonsuraimu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjRemonsuraimu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRippusu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjRippusu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRiripat){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjRiripat), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRyuiso){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjRyuiso), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRyuuou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjRyuuou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityRyuuou2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjRyuuou2), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySabotenboru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSabotenboru), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySabotengold){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSabotengold), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySaikuropusu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSaikuropusu), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySamayoutamasii){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSamayoutamasii), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySamayouyoroi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSamayouyoroi), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySeigin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSeigin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityShuvaluts){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjShuvaluts), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySibireageha){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSibireageha), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySibiredanbira){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSibiredanbira), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySibirekurage){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSibirekurage), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySimasimacat){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSimasimacat), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySirubadebiru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSirubadebiru), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySirubamanto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSirubamanto), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySirudoaniki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSirudoaniki), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySirudokozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSirudokozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySiryou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSiryou), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySiryounokisi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSiryounokisi), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySkullgaroo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSkullgaroo), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySodofantomu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSodofantomu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityStarkimera){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjStarkimera), 1);
			}
			else if(event.entityLiving instanceof DqmEntityStonman){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjStonman), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySukippaa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSukippaa), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySumairurokku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSumairurokku), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySumoruguru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSumoruguru), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySunomon){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSunomon), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySupekutetto){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSupekutetto), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySupini){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSupini), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSura), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySura2){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSura2), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimubehomazun){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimubehomazun), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimubesu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimubesu), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimubogu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimubogu), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimuburesu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimuburesu), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimuhaitawa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimuhaitawa), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimujeneraru){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimujeneraru), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimuking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimuking), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimumadyura){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimumadyura), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimunaito){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimunaito), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimutawa){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimutawa), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySuraimutumuri){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSuraimutumuri), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySweetbag){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSweetbag), 1);
			}
			else if(event.entityLiving instanceof DqmEntitySyado){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjSyado), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTahodoraki){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTahodoraki), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTaipug){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTaipug), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTattyan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTattyan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTogebouzu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTogebouzu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTogekonbou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTogekonbou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTomosibikozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTomosibikozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTonburero){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTonburero), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTororu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTororu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTororubakkosu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTororubakkosu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTororubonba){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTororubonba), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTororuking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTororuking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTubo){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTubo), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTubokku){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTubokku), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTukaima){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTukaima), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTumurinmama){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTumurinmama), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTutiwarasi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTutiwarasi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityTyokonuba){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjTyokonuba), 1);
			}
			else if(event.entityLiving instanceof DqmEntityUmibouzu){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjUmibouzu), 1);
			}
			else if(event.entityLiving instanceof DqmEntityUmiusi){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjUmiusi), 1);
			}
			else if(event.entityLiving instanceof DqmEntityUragirikozou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjUragirikozou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityUzusioking){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjUzusioking), 1);
			}
			else if(event.entityLiving instanceof DqmEntityWanpakusatan){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjWanpakusatan), 1);
			}
			else if(event.entityLiving instanceof DqmEntityWaraibukuro){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjWaraibukuro), 1);
			}
			else if(event.entityLiving instanceof DqmEntityYamatanooroti){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjYamatanooroti), 1);
			}
			else if(event.entityLiving instanceof DqmEntityYouganmajin){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjYouganmajin), 1);
			}
			else if(event.entityLiving instanceof DqmEntityZinmentyou){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjZinmentyou), 1);
			}
			else if(event.entityLiving instanceof DqmEntityZoma){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjZoma), 1);
			}
			else if(event.entityLiving instanceof DqmEntityZukkinya){
				event.entityLiving.dropItem(Item.getItemFromBlock(DQMobObjects.BlockObjZukkinya), 1);
			}

		}
	}




}
