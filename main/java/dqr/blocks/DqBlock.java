package dqr.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.api.Blocks.DQChests;
import dqr.api.Blocks.DQDecorates;
import dqr.api.Blocks.DQOres;
import dqr.api.Blocks.DQPlants;
import dqr.blocks.base.DqmBlockBase;
import dqr.blocks.base.DqmBlockBase2;
import dqr.blocks.base.DqmBlockOreBase;
import dqr.blocks.base.DqmBlockOreBlockBase;
import dqr.blocks.base.DqmBlockSeedBase;
import dqr.blocks.chest.DqmBlockEnderChest;
import dqr.blocks.decorate.DqmBlockAkumanotubo;
import dqr.blocks.decorate.DqmBlockAkumanotubo2;
import dqr.blocks.decorate.DqmBlockBed1;
import dqr.blocks.decorate.DqmBlockBed2;
import dqr.blocks.decorate.DqmBlockBed3;
import dqr.blocks.decorate.DqmBlockBlockSword;
import dqr.blocks.decorate.DqmBlockBlockSword2;
import dqr.blocks.decorate.DqmBlockBlockSword2Mob;
import dqr.blocks.decorate.DqmBlockBlockSwordMob;
import dqr.blocks.decorate.DqmBlockBlockTue;
import dqr.blocks.decorate.DqmBlockBouguya;
import dqr.blocks.decorate.DqmBlockBukiya;
import dqr.blocks.decorate.DqmBlockDaiza;
import dqr.blocks.decorate.DqmBlockDouguya;
import dqr.blocks.decorate.DqmBlockEntotu;
import dqr.blocks.decorate.DqmBlockHasira;
import dqr.blocks.decorate.DqmBlockHasiranaka;
import dqr.blocks.decorate.DqmBlockHasiraue;
import dqr.blocks.decorate.DqmBlockHepaitosu;
import dqr.blocks.decorate.DqmBlockHondana;
import dqr.blocks.decorate.DqmBlockIdo;
import dqr.blocks.decorate.DqmBlockIdooke;
import dqr.blocks.decorate.DqmBlockIsu;
import dqr.blocks.decorate.DqmBlockJuujika;
import dqr.blocks.decorate.DqmBlockKagaribidai;
import dqr.blocks.decorate.DqmBlockKen;
import dqr.blocks.decorate.DqmBlockKen2;
import dqr.blocks.decorate.DqmBlockKinoisi;
import dqr.blocks.decorate.DqmBlockMainSikabane;
import dqr.blocks.decorate.DqmBlockMainSikabaneMob;
import dqr.blocks.decorate.DqmBlockMaki;
import dqr.blocks.decorate.DqmBlockMinidama;
import dqr.blocks.decorate.DqmBlockOke;
import dqr.blocks.decorate.DqmBlockOokiihasiranaka;
import dqr.blocks.decorate.DqmBlockOokiihasirasita;
import dqr.blocks.decorate.DqmBlockOokiihasiraue;
import dqr.blocks.decorate.DqmBlockOokiiisizukue;
import dqr.blocks.decorate.DqmBlockOokiitukue;
import dqr.blocks.decorate.DqmBlockRotomon;
import dqr.blocks.decorate.DqmBlockRotonoturugiOb;
import dqr.blocks.decorate.DqmBlockSBatorurex;
import dqr.blocks.decorate.DqmBlockSBoureikensi;
import dqr.blocks.decorate.DqmBlockSGoremu;
import dqr.blocks.decorate.DqmBlockSKirapan;
import dqr.blocks.decorate.DqmBlockSSura;
import dqr.blocks.decorate.DqmBlockSSuraimunaito;
import dqr.blocks.decorate.DqmBlockSZukkinya;
import dqr.blocks.decorate.DqmBlockSikabaneK;
import dqr.blocks.decorate.DqmBlockTaimatu;
import dqr.blocks.decorate.DqmBlockTaimatu2;
import dqr.blocks.decorate.DqmBlockTaru;
import dqr.blocks.decorate.DqmBlockTaruK;
import dqr.blocks.decorate.DqmBlockTaruMob;
import dqr.blocks.decorate.DqmBlockTiisaitukue;
import dqr.blocks.decorate.DqmBlockTokusyutaimatu;
import dqr.blocks.decorate.DqmBlockTubo;
import dqr.blocks.decorate.DqmBlockTubo2;
import dqr.blocks.decorate.DqmBlockTuboK;
import dqr.blocks.decorate.DqmBlockTubokku;
import dqr.blocks.decorate.DqmBlockTubokku2;
import dqr.blocks.decorate.DqmBlockTueK;
import dqr.blocks.decorate.DqmBlockWakanai;
import dqr.blocks.decorate.DqmBlockYadoya;
import dqr.blocks.decorate.DqmBlockYajirusi;
import dqr.blocks.decorate.DqmBlockYajirusiMG;
import dqr.blocks.decorate.DqmBlockYajirusibatu;
import dqr.blocks.decorate.DqmBlockYajirusimaru;
import dqr.blocks.decorate.DqmBlockYajirusinaname;
import dqr.blocks.decorate.DqmBlockYajirusisita;
import dqr.blocks.decorate.DqmBlockYajirusiue;
import dqr.blocks.decorate.DqmFarmBookshelf;
import dqr.blocks.mobSpawner.DqmBlockMobSpawner;
import dqr.blocks.standard.DQmBlockWaterBlock;
import dqr.blocks.standard.DqmBlockBuildFrame;
import dqr.blocks.standard.DqmGansekiBlock;
import dqr.blocks.standard.DqmGenkotuBlock;
import dqr.blocks.standard.DqmHakoBlock;
import dqr.blocks.standard.DqmHakoBlock11;
import dqr.blocks.standard.DqmHakoBlock12;
import dqr.blocks.standard.DqmHakoBlock13;
import dqr.blocks.standard.DqmHakoBlock2;
import dqr.blocks.standard.DqmHakoBlock3;
import dqr.blocks.standard.DqmHakoBlockK;
import dqr.blocks.standard.DqmHoujyouDirt;
import dqr.blocks.standard.DqmItemBlockL;
import dqr.blocks.standard.DqmJampBlockTerepo;
import dqr.blocks.standard.DqmJumpBlock;
import dqr.blocks.standard.DqmJumpBlock2;
import dqr.blocks.standard.DqmJumpBlockToBoss;
import dqr.blocks.standard.DqmKieruBlock;
import dqr.blocks.standard.DqmKyouseiMoveBlock;
import dqr.blocks.standard.DqmKyouseiMoveBlock2;
import dqr.blocks.standard.DqmOneBlock2;
import dqr.blocks.standard.DqmSetBlock1;
import dqr.blocks.standard.DqmSyoumetu;
import dqr.blocks.standard.DqmToramanaYuka;

public class DqBlock {

	public DqBlock()
	{
		DQDecorates.DqmBlockMinidama = new DqmBlockMinidama(Material.rock).setHardness(0.6F).setStepSound(Block.soundTypeStone).setBlockName("dqm.blockMinidama").setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:miniDama");

		DQDecorates.DqmBlockTubo = new DqmBlockTubo(Material.wood).setmodel("Tubo").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockTubo").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Tubo");
		DQDecorates.DqmBlockTubokku = new DqmBlockTubokku(Material.rock).setmodel("Tubokku").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockTubokku").setHardness(5.0f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Tubokku");
		DQDecorates.DqmBlockAkumanotubo = new DqmBlockAkumanotubo(Material.iron).setmodel("Akumanotubo").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockAkumanotubo").setHardness(3.0f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Akumanotubo");
		DQDecorates.DqmBlockTubo2 = new DqmBlockTubo2(Material.wood).setmodel("Tubo2").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockTubo2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Tubo");
		DQDecorates.DqmBlockTubokku2 = new DqmBlockTubokku2(Material.rock).setmodel("Tubokku2").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockTubokku2").setHardness(5.0f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Tubokku");
		DQDecorates.DqmBlockAkumanotubo2 = new DqmBlockAkumanotubo2(Material.iron).setmodel("Akumanotubo2").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockAkumanotubo2").setHardness(3.0f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Akumanotubo");
		DQDecorates.DqmBlockSword = new DqmBlockBlockSword(Material.wood).setmodel("Sword").setStepSound(Block.soundTypeStone).setBlockName("dqm.blockSword").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SwordsB");
		DQDecorates.DqmBlockSword2 = new DqmBlockBlockSword2(Material.wood).setmodel("Sword2").setStepSound(Block.soundTypeStone).setBlockName("dqm.blockSword2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SwordB");
		DQDecorates.DqmBlockDqmbed = new DqmBlockBed1(Material.wood).setStepSound(Block.soundTypeCloth).setBlockName("dqm.blockDqmbed").setHardness(20.0f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DqmbedB");
		DQDecorates.DqmBlockDqmbed2 = new DqmBlockBed2(Material.wood).setStepSound(Block.soundTypeCloth).setBlockName("dqm.blockDqmbed2").setHardness(20.0f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Dqmbed2B");
		DQDecorates.DqmBlockDqmbed3 = new DqmBlockBed3(Material.wood).setStepSound(Block.soundTypeCloth).setBlockName("dqm.blockDqmbed3").setHardness(20.0f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Dqmbed3B");
		DQDecorates.DqmBlockTue = new DqmBlockBlockTue(Material.wood).setStepSound(Block.soundTypeStone).setBlockName("dqm.blockTue").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:TueB");
		DQDecorates.DqmBlockSikabane = new DqmBlockMainSikabane(Material.wood).setStepSound(Block.soundTypeStone).setBlockName("dqm.blockSikabane").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Sikabane");
		//***********************************************************************スライム矢印******************************************************************************************
		DQDecorates.DqmBlockHikariB2 = new DqmBlockYajirusiMG(Material.wood).setmodel("HikariB2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockHikariB2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HikariB2");
		DQDecorates.DqmBlockYajirusidaidai = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusidaidai").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusidaidai").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusihai = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusihai").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusihai").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusisiro = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusisiro").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusisiro").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusiaka = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusiaka").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiaka").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusikuro = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusikuro").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusikuro").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusitya = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusitya").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusitya").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusikoimidori = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusikoimidori").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusikoimidori").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusimurasaki = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusimurasaki").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusimurasaki").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusiao = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusiao").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiao").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusikiiro = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusikiiro").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusikiiro").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusimidori = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusimidori").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusimidori").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusipink = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusipink").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusipink").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusiusuao = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusiusuao").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiusuao").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockYajirusikon = new DqmBlockYajirusi(Material.wood).setmodel("Yajirusikon").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusikon").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiB");
		DQDecorates.DqmBlockWakanai = new DqmBlockWakanai(Material.wood).setBlockName("dqm.blockWakanai").setStepSound(Block.soundTypeGlass).setResistance(2000.0F).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Wakanai");
		//斜め
		DQDecorates.DqmBlockYajirusidaidai2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusidaidai2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusidaidai2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusihai2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusihai2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusihai2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusisiro2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusisiro2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusisiro2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusiaka2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusiaka2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiaka2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusikuro2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusikuro2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusikuro2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusitya2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusitya2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusitya2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusikoimidori2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusikoimidori2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusikoimidori2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusimurasaki2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusimurasaki2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusimurasaki2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusiao2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusiao2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiao2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusikiiro2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusikiiro2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusikiiro2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusimidori2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusimidori2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusimidori2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusipink2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusipink2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusipink2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusiusuao2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusiusuao2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiusuao2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		DQDecorates.DqmBlockYajirusikon2 = new DqmBlockYajirusinaname(Material.wood).setmodel("Yajirusikon2").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusikon2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusinanameB");
		//上下
		DQDecorates.DqmBlockYajirusiUe = new DqmBlockYajirusiue(Material.wood).setmodel("YajirusiUe").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiUe").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusiueB");
		DQDecorates.DqmBlockYajirusiSita = new DqmBlockYajirusisita(Material.wood).setmodel("YajirusiSita").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiSita").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusisitaB");
		DQDecorates.DqmBlockYajirusiMaru = new DqmBlockYajirusimaru(Material.wood).setmodel("YajirusiMaru").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiMaru").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusimaruB");
		DQDecorates.DqmBlockYajirusiBatu = new DqmBlockYajirusibatu(Material.wood).setmodel("YajirusiBatu").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockYajirusiBatu").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YajirusibatuB");
		//台座
		DQDecorates.DqmBlockDaizaQ = new DqmBlockDaiza(Material.wood).setmodel("DaizaQ").setBlockName("dqm.blockDaizaQ").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaQG = new DqmBlockDaiza(Material.wood).setmodel("DaizaQG").setBlockName("dqm.blockDaizaQG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaB = new DqmBlockDaiza(Material.wood).setmodel("DaizaB").setBlockName("dqm.blockDaizaB").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaBG = new DqmBlockDaiza(Material.wood).setmodel("DaizaBG").setBlockName("dqm.blockDaizaBG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaD = new DqmBlockDaiza(Material.wood).setmodel("DaizaD").setBlockName("dqm.blockDaizaD").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaDG = new DqmBlockDaiza(Material.wood).setmodel("DaizaDG").setBlockName("dqm.blockDaizaDG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaE = new DqmBlockDaiza(Material.wood).setmodel("DaizaE").setBlockName("dqm.blockDaizaE").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaEG = new DqmBlockDaiza(Material.wood).setmodel("DaizaEG").setBlockName("dqm.blockDaizaEG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaG = new DqmBlockDaiza(Material.wood).setmodel("DaizaG").setBlockName("dqm.blockDaizaG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaGG = new DqmBlockDaiza(Material.wood).setmodel("DaizaGG").setBlockName("dqm.blockDaizaGG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaI = new DqmBlockDaiza(Material.wood).setmodel("DaizaI").setBlockName("dqm.blockDaizaI").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaIG = new DqmBlockDaiza(Material.wood).setmodel("DaizaIG").setBlockName("dqm.blockDaizaIG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaL = new DqmBlockDaiza(Material.wood).setmodel("DaizaL").setBlockName("dqm.blockDaizaL").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaLG = new DqmBlockDaiza(Material.wood).setmodel("DaizaLG").setBlockName("dqm.blockDaizaLG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaN = new DqmBlockDaiza(Material.wood).setmodel("DaizaN").setBlockName("dqm.blockDaizaN").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaNG = new DqmBlockDaiza(Material.wood).setmodel("DaizaNG").setBlockName("dqm.blockDaizaNG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaO = new DqmBlockDaiza(Material.wood).setmodel("DaizaO").setBlockName("dqm.blockDaizaO").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaOG = new DqmBlockDaiza(Material.wood).setmodel("DaizaOG").setBlockName("dqm.blockDaizaOG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaR = new DqmBlockDaiza(Material.wood).setmodel("DaizaR").setBlockName("dqm.blockDaizaR").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaRG = new DqmBlockDaiza(Material.wood).setmodel("DaizaRG").setBlockName("dqm.blockDaizaRG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaS = new DqmBlockDaiza(Material.wood).setmodel("DaizaS").setBlockName("dqm.blockDaizaS").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaSG = new DqmBlockDaiza(Material.wood).setmodel("DaizaSG").setBlockName("dqm.blockDaizaSG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaW = new DqmBlockDaiza(Material.wood).setmodel("DaizaW").setBlockName("dqm.blockDaizaW").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		DQDecorates.DqmBlockDaizaWG = new DqmBlockDaiza(Material.wood).setmodel("DaizaWG").setBlockName("dqm.blockDaizaWG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DaizaB");
		//その他
		DQDecorates.DqmBlockHepaitosu = new DqmBlockHepaitosu(Material.wood).setmodel("Hepaitosu").setStepSound(Block.soundTypeGlass).setLightLevel(1.0F).setBlockName("dqm.blockHepaitosu").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Hepaitosunohidane");
		DQDecorates.DqmBlockRotomon = new DqmBlockRotomon(Material.wood).setmodel("Rotomon").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockRotomon").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Rotonomonsyou");
		DQDecorates.DqmBlockRotonoturugiOb = new DqmBlockRotonoturugiOb(Material.wood).setmodel("RotonoturugiOb").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockRotonoturugiOb").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:RotonoturugiB");
		DQDecorates.DqmBlockRotonoturugiOb2 = new DqmBlockRotonoturugiOb(Material.wood).setmodel("RotonoturugiOb2").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockRotonoturugiOb2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:RotonoturugiB");
		DQDecorates.DqmBlockRotonoturugiF = new DqmBlockRotonoturugiOb(Material.wood).setmodel("RotonoturugiF").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockRotonoturugiF").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:RotonoturugiB");
		DQDecorates.DqmBlockRotonoturugiF2 = new DqmBlockRotonoturugiOb(Material.wood).setmodel("RotonoturugiF2").setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockRotonoturugiF2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:RotonoturugiB");
		//RotonoturugiMob = new DqmBlockRotonoturugiMob(Material.wood,true).setmodel("RotonoturugiMob").setBlockName("dqm.blockRotonoturugiMob").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:noturugiMob");
		DQDecorates.DqmBlockIsu = new DqmBlockIsu(Material.wood).setmodel("Isu").setBlockName("dqm.blockIsu").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:IsuB");
		DQDecorates.DqmBlockTaimatu = new DqmBlockTaimatu(Material.wood).setmodel("Taimatu").setLightLevel(1.0F).setStepSound(Block.soundTypeWood).setBlockName("dqm.blockTaimatu").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:TaimatuB");
		DQDecorates.DqmBlockTaimatu2 = new DqmBlockTaimatu2(Material.wood).setmodel("Taimatu2").setLightLevel(1.0F).setStepSound(Block.soundTypeWood).setBlockName("dqm.blockTaimatu2").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Taimatu2B");
		DQDecorates.DqmBlockTaru = new DqmBlockTaru(Material.wood).setmodel("Taru").setBlockName("dqm.blockTaru").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:TaruB");
		DQDecorates.DqmBlockHasira = new DqmBlockHasira(Material.wood).setmodel("Hasira").setBlockName("dqm.blockHasira").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HasiraB");

		DQDecorates.DqmBlockHasiraNB = new DqmBlockHasira(Material.wood).setmodel("HasiraNB").setBlockName("dqm.blockHasiraNB").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HasiraB");
		DQDecorates.DqmBlockHasiranakaNB = new DqmBlockHasiranaka(Material.wood).setmodel("HasiranakaNB").setBlockName("dqm.blockHasiranakaNB").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HasiranakaB");
		DQDecorates.DqmBlockHasiraueNB = new DqmBlockHasiraue(Material.wood).setmodel("HasiraueNB").setBlockName("dqm.blockHasiraueNB").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HasiraueB");

		DQDecorates.DqmBlockHasiraQ = new DqmBlockHasira(Material.wood).setmodel("HasiraQ").setBlockName("dqm.blockHasiraQ").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HasiraB");
		DQDecorates.DqmBlockHasiranaka = new DqmBlockHasiranaka(Material.wood).setmodel("Hasiranaka").setBlockName("dqm.blockHasiranaka").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HasiranakaB");
		DQDecorates.DqmBlockHasiranakaQ = new DqmBlockHasiranaka(Material.wood).setmodel("HasiranakaQ").setBlockName("dqm.blockHasiranakaQ").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HasiranakaB");
		DQDecorates.DqmBlockHasiraue = new DqmBlockHasiraue(Material.wood).setmodel("Hasiraue").setBlockName("dqm.blockHasiraue").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HasiraueB");
		DQDecorates.DqmBlockHasiraueQ = new DqmBlockHasiraue(Material.wood).setmodel("HasiraueQ").setBlockName("dqm.blockHasiraueQ").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HasiraueB");
		DQDecorates.DqmBlockSwordMob = new DqmBlockBlockSwordMob(Material.wood).setmodel("SwordMob").setBlockName("dqm.blockSwordMob").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SwordsB");
		DQDecorates.DqmBlockSword2Mob = new DqmBlockBlockSword2Mob(Material.wood).setmodel("Sword2Mob").setBlockName("dqm.blockSword2Mob").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SwordB");
		DQDecorates.DqmBlockKen2 = new DqmBlockKen2(Material.wood).setmodel("Ken2").setBlockName("dqm.blockKen2").setHardness(0.5f).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SwordB");
		DQDecorates.DqmBlockKen = new DqmBlockKen(Material.wood).setmodel("Ken").setBlockName("dqm.blockKen").setHardness(0.5f).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SwordsB");
		DQDecorates.DqmBlockTueK = new DqmBlockTueK(Material.wood).setmodel("TueK").setBlockName("dqm.blockTueK").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:TueB");
		DQDecorates.DqmBlockSikabaneK = new DqmBlockSikabaneK(Material.wood).setmodel("SikabaneK").setBlockName("dqm.blockSikabaneK").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Sikabane");
		DQDecorates.DqmBlockTaruMob = new DqmBlockTaruMob(Material.wood).setmodel("TaruMob").setBlockName("dqm.blockTaruMob").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:TaruB");
		DQDecorates.DqmBlockSikabaneMob = new DqmBlockMainSikabaneMob(Material.wood).setmodel("SikabaneMob").setBlockName("dqm.blockSikabaneMob").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Sikabane");
		DQDecorates.DqmBlockJuujika = new DqmBlockJuujika(Material.wood).setmodel("Juujika").setBlockName("dqm.blockJuujika").setStepSound(Block.soundTypeStone).setLightLevel(1.0F).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:JuujikaB");
		DQDecorates.DqmBlockJuujika2 = new DqmBlockJuujika(Material.wood).setmodel("Juujika2").setBlockName("dqm.blockJuujika2").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:JuujikaB");
		//New建材
		DQDecorates.DqmBlockKagaribidai = new DqmBlockKagaribidai(Material.wood).setmodel("Kagaribidai").setBlockName("dqm.blockKagaribidai").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:KagaribiB");
		DQDecorates.DqmBlockOokiiisizukue = new DqmBlockOokiiisizukue(Material.wood).setmodel("Ookiiisizukue").setBlockName("dqm.blockOokiiisizukue").setStepSound(Block.soundTypeStone).setHardness(0.1f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:IsinotukueB");
		DQDecorates.DqmBlockIdooke = new DqmBlockIdooke(Material.wood).setmodel("Idooke").setBlockName("dqm.blockIdooke").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:IdookeB");
		DQDecorates.DqmBlockOokiitukue = new DqmBlockOokiitukue(Material.wood).setmodel("Ookiitukue").setBlockName("dqm.blockOokiitukue").setStepSound(Block.soundTypeWood).setHardness(0.1f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiikinotukueB");
		DQDecorates.DqmBlockMaki = new DqmBlockMaki(Material.wood).setmodel("Maki").setBlockName("dqm.blockMaki").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:MakiB");
		DQDecorates.DqmBlockOke = new DqmBlockOke(Material.wood).setmodel("Oke").setBlockName("dqm.blockOke").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OkeB");
		DQDecorates.DqmBlockIdo = new DqmBlockIdo(Material.wood).setmodel("Ido").setBlockName("dqm.blockIdo").setHardness(0.5f).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:IdoB");
		DQDecorates.DqmBlockKinoisi = new DqmBlockKinoisi(Material.wood).setmodel("Kinoisi").setBlockName("dqm.blockKinoisi").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:KinoisuB");
		DQDecorates.DqmBlockTiisaitukue = new DqmBlockTiisaitukue(Material.wood).setmodel("Tiisaitukue").setBlockName("dqm.blockTiisaitukue").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:TiisaikinotukueB");
		DQDecorates.DqmBlockHondana = new DqmBlockHondana(Material.wood).setmodel("Hondana").setBlockName("dqm.blockHondana").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:HondanaB");
		DQDecorates.DqmBlockOokiihasiraue = new DqmBlockOokiihasiraue(Material.wood).setmodel("Ookiihasiraue").setBlockName("dqm.blockOokiihasiraue").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihaueB");
		DQDecorates.DqmBlockOokiihasirasita = new DqmBlockOokiihasirasita(Material.wood).setmodel("Ookiihasirasita").setBlockName("dqm.blockOokiihasirasita").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihasitaB");
		DQDecorates.DqmBlockOokiihasiranaka = new DqmBlockOokiihasiranaka(Material.wood).setmodel("Ookiihasiranaka").setBlockName("dqm.blockOokiihasiranaka").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihanakaB");
		DQDecorates.DqmBlockOokiihasiraueQ = new DqmBlockOokiihasiraue(Material.wood).setmodel("OokiihasiraueQ").setBlockName("dqm.blockOokiihasiraueQ").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihaueB");
		DQDecorates.DqmBlockOokiihasirasitaQ = new DqmBlockOokiihasirasita(Material.wood).setmodel("OokiihasirasitaQ").setBlockName("dqm.blockOokiihasirasitaQ").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihasitaB");
		DQDecorates.DqmBlockOokiihasiranakaQ = new DqmBlockOokiihasiranaka(Material.wood).setmodel("OokiihasiranakaQ").setBlockName("dqm.blockOokiihasiranakaQ").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihanakaB");
		DQDecorates.DqmBlockOokiihasiraueS = new DqmBlockOokiihasiraue(Material.wood).setmodel("OokiihasiraueS").setBlockName("dqm.blockOokiihasiraueS").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihaueB");
		DQDecorates.DqmBlockOokiihasirasitaS = new DqmBlockOokiihasirasita(Material.wood).setmodel("OokiihasirasitaS").setBlockName("dqm.blockOokiihasirasitaS").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihasitaB");
		DQDecorates.DqmBlockOokiihasiranakaS = new DqmBlockOokiihasiranaka(Material.wood).setmodel("OokiihasiranakaS").setBlockName("dqm.blockOokiihasiranakaS").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihanakaB");
		DQDecorates.DqmBlockOokiihasiraueNB = new DqmBlockOokiihasiraue(Material.wood).setmodel("OokiihasiraueNB").setBlockName("dqm.blockOokiihasiraueNB").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihaueB");
		DQDecorates.DqmBlockOokiihasirasitaNB = new DqmBlockOokiihasirasita(Material.wood).setmodel("OokiihasirasitaNB").setBlockName("dqm.blockOokiihasirasitaNB").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihasitaB");
		DQDecorates.DqmBlockOokiihasiranakaNB = new DqmBlockOokiihasiranaka(Material.wood).setmodel("OokiihasiranakaNB").setBlockName("dqm.blockOokiihasiranakaNB").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:OokiihanakaB");
		DQDecorates.DqmBlockTokusyutaimatu = new DqmBlockTokusyutaimatu(Material.wood).setmodel("Tokusyutaimatu").setLightLevel(1.0F).setStepSound(Block.soundTypeGlass).setBlockName("dqm.blockTokusyutaimatu").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:TokusyutaimatuB");
		DQDecorates.DqmBlockEntotu = new DqmBlockEntotu(Material.wood).setmodel("Entotu").setBlockName("dqm.blockEntotu").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:EntotuB");
		DQDecorates.DqmBlockEntotuS = new DqmBlockEntotu(Material.wood).setmodel("EntotuS").setBlockName("dqm.blockEntotuS").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:EntotuB");
		DQDecorates.DqmBlockEntotuN = new DqmBlockEntotu(Material.wood).setmodel("EntotuN").setBlockName("dqm.blockEntotuN").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:EntotuB");
		DQDecorates.DqmBlockEntotuG = new DqmBlockEntotu(Material.wood).setmodel("EntotuG").setBlockName("dqm.blockEntotuG").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:EntotuB");
		DQDecorates.DqmBlockEntotuO = new DqmBlockEntotu(Material.wood).setmodel("EntotuO").setBlockName("dqm.blockEntotuO").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:EntotuB");
		DQDecorates.DqmBlockYadoya = new DqmBlockYadoya(Material.wood).setmodel("Yadoya").setBlockName("dqm.blockYadoya").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:YadoyaB");
		DQDecorates.DqmBlockDouguya = new DqmBlockDouguya(Material.wood).setmodel("Douguya").setBlockName("dqm.blockDouguya").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:DouguyaB");
		DQDecorates.DqmBlockBouguya = new DqmBlockBouguya(Material.wood).setmodel("Bouguya").setBlockName("dqm.blockBouguya").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:BouguyaB");
		DQDecorates.DqmBlockBukiya = new DqmBlockBukiya(Material.wood).setmodel("Bukiya").setBlockName("dqm.blockBukiya").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:BukiyaB");
		DQDecorates.DqmBlockTaruK = new DqmBlockTaruK(Material.wood).setmodel("TaruK").setBlockName("dqm.blockTaruK").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:TaruB");
		DQDecorates.DqmBlockTuboK = new DqmBlockTuboK(Material.wood).setmodel("TuboK").setBlockName("dqm.blockTuboK").setStepSound(Block.soundTypeGlass).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:Tubo");
		DQDecorates.DqmBlockSBatorurex = new DqmBlockSBatorurex(Material.wood).setmodel("SBatorurex").setBlockName("dqm.blockSBatorurex").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SBatorurexB");
		DQDecorates.DqmBlockSBoureikensi = new DqmBlockSBoureikensi(Material.wood).setmodel("SBoureikensi").setBlockName("dqm.blockSBoureikensi").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SBoureikensiB");
		DQDecorates.DqmBlockSGoremu = new DqmBlockSGoremu(Material.wood).setmodel("SGoremu").setBlockName("dqm.blockSGoremu").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SGodraidaB");
		DQDecorates.DqmBlockSKirapan = new DqmBlockSKirapan(Material.wood).setmodel("SKirapan").setBlockName("dqm.blockSKirapan").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SKirapanB");
		DQDecorates.DqmBlockSSura = new DqmBlockSSura(Material.wood).setmodel("SSura").setBlockName("dqm.blockSSura").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SSuraB");
		DQDecorates.DqmBlockSSuraimunaito = new DqmBlockSSuraimunaito(Material.wood).setmodel("SSuraimunaito").setStepSound(Block.soundTypeStone).setBlockName("dqm.blockSSuraimunaito").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SSuraimunaitoB");
		DQDecorates.DqmBlockSZukkinya = new DqmBlockSZukkinya(Material.wood).setmodel("SZukkinya").setBlockName("dqm.blockSZukkinya").setStepSound(Block.soundTypeStone).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:SZukkinyaB");
		DQDecorates.DqmBlockFarmBookShelf = new DqmFarmBookshelf().setBlockName("dqm.blockFarmBookShelf").setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("bookshelf").setHardness(1.0f);


		//鉱石
		//DQOres.BlockOreBakudanisi = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreBakudanisi").setBlockTextureName("dqr:OreBakudanisi");
		DQOres.BlockOreBakudanisi = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(5.0F).setResistance(10.0F).setBlockName("dqm.blockOreBakudanisi").setBlockTextureName("dqr:OreBakudanisi");
		DQOres.BlockOreHikarinoisi = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreHikarinoisi").setBlockTextureName("dqr:OreHikarinoisi");
		DQOres.BlockOreHosinokakera = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreHosinokakera").setBlockTextureName("dqr:OreHosinokakera");
		DQOres.BlockOreInotinoisi = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreInotinoisi").setBlockTextureName("dqr:OreInotinoisi");
		DQOres.BlockOreKagaminoisi = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreKagaminoisi").setBlockTextureName("dqr:OreKagaminoisi");
		DQOres.BlockOreKoorinokessyou = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreKoorinokessyou").setBlockTextureName("dqr:OreKoorinokessyou");
		DQOres.BlockOreLittlemedal = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreLittlemedal").setBlockTextureName("dqr:OreLittlemedal");
		DQOres.BlockOreMetaru = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreMetaru").setBlockTextureName("dqr:OreMetaru");
		DQOres.BlockOreMigakizuna = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreMigakizuna").setBlockTextureName("dqr:OreMigakizuna");
		DQOres.BlockOreMisuriru = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreMisuriru").setBlockTextureName("dqr:OreMisuriru");
		DQOres.BlockOreMoon = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreMoon").setBlockTextureName("dqr:OreMoon");
		DQOres.BlockOrePuratina = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOrePuratina").setBlockTextureName("dqr:OrePuratina");
		DQOres.BlockOreRubi = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreRubi").setBlockTextureName("dqr:OreRubi");
		DQOres.BlockOreTaiyounoisi = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreTaiyounoisi").setBlockTextureName("dqr:OreTaiyounoisi");
		DQOres.BlockOreTekkouseki = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreTekkouseki").setBlockTextureName("dqr:OreTekkouseki");
		DQOres.BlockOreTokinosuisyou = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreTokinosuisyou").setBlockTextureName("dqr:OreTokinosuisyou");
		DQOres.BlockOreYougansekinokakera = new DqmBlockOreBase().setCreativeTab(DQR.tabs.DqmTabOre).setLightOpacity(0).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockName("dqm.blockOreYougansekinokakera").setBlockTextureName("dqr:OreYougansekinokakera");

		DQOres.DqmOreBlocks = new DqmBlockOreBlockBase(Material.rock).setCreativeTab(DQR.tabs.DqmTabOre).setStepSound(Block.soundTypePiston);


		//植物
		DQPlants.BlockYakusouSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockYakusouSeed1");
		DQPlants.BlockYakusouSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockYakusouSeed2");
		DQPlants.BlockYakusouSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockYakusouSeed3");
		DQPlants.BlockDokukesisouSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockDokukesisouSeed1");
		DQPlants.BlockDokukesisouSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockDokukesisouSeed2");
		DQPlants.BlockDokukesisouSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockDokukesisouSeed3");
		DQPlants.BlockTikaraSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockTikaraSeed1");
		DQPlants.BlockTikaraSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockTikaraSeed2");
		DQPlants.BlockTikaraSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockTikaraSeed3");
		DQPlants.BlockMamoriSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockMamoriSeed1");
		DQPlants.BlockMamoriSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockMamoriSeed2");
		DQPlants.BlockMamoriSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockMamoriSeed3");
		DQPlants.BlockSubayasaSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockSubayasaSeed1");
		DQPlants.BlockSubayasaSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockSubayasaSeed2");
		DQPlants.BlockSubayasaSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockSubayasaSeed3");
		DQPlants.BlockHonooSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockHonooSeed1");
		DQPlants.BlockHonooSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockHonooSeed2");
		DQPlants.BlockHonooSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockHonooSeed3");
		DQPlants.BlockIyasiSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockIyasiSeed1");
		DQPlants.BlockIyasiSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockIyasiSeed2");
		DQPlants.BlockIyasiSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockIyasiSeed3");
		DQPlants.BlockMahounomiSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockMahounomiSeed1");
		DQPlants.BlockMahounomiSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockMahounomiSeed2");
		DQPlants.BlockMahounomiSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockMahounomiSeed3");
		DQPlants.BlockMaryokunotaneSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockMaryokunotaneSeed1");
		DQPlants.BlockMaryokunotaneSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockMaryokunotaneSeed2");
		DQPlants.BlockMaryokunotaneSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockMaryokunotaneSeed3");
		DQPlants.BlockOugonSeed1 = new DqmBlockSeedBase(false).setBlockName("dqm.blockOugonSeed1");
		DQPlants.BlockOugonSeed2 = new DqmBlockSeedBase(false).setBlockName("dqm.blockOugonSeed2");
		DQPlants.BlockOugonSeed3 = new DqmBlockSeedBase(false).setBlockName("dqm.blockOugonSeed3");
		DQPlants.BlockOugonSeed4 = new DqmBlockSeedBase(false).setBlockName("dqm.blockOugonSeed4");

		DQPlants.BlockHoujyouDirt = new DqmHoujyouDirt().setBlockName("dqm.HoujyouDirt").setHardness(0.6F).setStepSound(Block.soundTypeGravel).setCreativeTab(DQR.tabs.DqmTabDecorate);



		//通常ブロック

    	DQBlocks.DqmBlockHako = new DqmHakoBlock().setBlockName("dqm.blockHakoBlock").setHardness(2.0f).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:DqmHakoBlock");
    	DQBlocks.DqmBlockHako2 = new DqmHakoBlock2().setBlockName("dqm.blockHakoBlock2").setHardness(5.0f).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:DqmHakoBlock2");
    	DQBlocks.DqmBlockHako3 = new DqmHakoBlock3().setBlockName("dqm.blockHakoBlock3").setHardness(10.0f).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:DqmHakoBlock3");
    	DQBlocks.DqmBlockHako11 = new DqmHakoBlock11().setBlockName("dqm.blockHakoBlock11").setHardness(2.0f).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:DqmHakoBlock11");
    	DQBlocks.DqmBlockHako12 = new DqmHakoBlock12().setBlockName("dqm.blockHakoBlock12").setHardness(5.0f).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:DqmHakoBlock12");
    	DQBlocks.DqmBlockHako13 = new DqmHakoBlock13().setBlockName("dqm.blockHakoBlock13").setHardness(10.0f).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:DqmHakoBlock13");
    	DQBlocks.DqmBlockHakoK = new DqmHakoBlockK().setBlockName("dqm.blockHakoHakoK").setHardness(0.5f).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:HakoK");
    	//ダメージ床
    	DQBlocks.DqmBlockToramanaYuka = new DqmToramanaYuka().setBlockName("dqm.blockToramanaYuka").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:ToramanaYuka");;
    	DQBlocks.DqmBlockN = new DqmKyouseiMoveBlock(0).setBlockName("dqm.blockN").setHardness(3.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:KyouseiMoveN");
    	DQBlocks.DqmBlockS = new DqmKyouseiMoveBlock(1).setBlockName("dqm.blockS").setHardness(3.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:KyouseiMoveS");
    	DQBlocks.DqmBlockW = new DqmKyouseiMoveBlock(3).setBlockName("dqm.blockW").setHardness(3.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:KyouseiMoveW");
    	DQBlocks.DqmBlockE = new DqmKyouseiMoveBlock(2).setBlockName("dqm.blockE").setHardness(3.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:KyouseiMoveE");

    	/*
    	DQBlock.DqmBlockKowarenaiDoor = new DqmBlockDoor1().setmodel("KowarenaiDoor").setBlockName("dqm.blockKowarenaiDoor").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:doorIron_lower1");
    	DQBlock.DqmBlockKowarenaiDoor2 = new DqmBlockDoor2().setmodel("KowarenaiDoor2").setBlockName("dqm.blockKowarenaiDoor2").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:doorIron_lower2");
    	DQBlock.DqmBlockKowarenaiDoor3 = new DqmBlockDoor3().setmodel("KowarenaiDoor3").setBlockName("dqm.blockKowarenaiDoor3").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeWood).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:doorIron_lower3");
    	*/

    	DQBlocks.DqmBlockJampBlock = new DqmJumpBlock().setBlockName("dqm.blockJumpBlock").setHardness(0.5f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:JumpBlock");
    	DQBlocks.DqmBlockJampBlock2 = new DqmJumpBlock2().setBlockName("dqm.blockJumpBlock2").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:JumpBlock2");

    	DQBlocks.DqmBlockJampBlockTerepo2 = new DqmJampBlockTerepo().setBlockName("dqm.blockJampBlockTerepo2").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:JampBlockTerepo");
    	//夜
    	DQBlocks.DqmBlockJampBlockTerepoBoss1 = new DqmJumpBlockToBoss().setBlockName("dqm.blockJumpBlockTerepoBoss1").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:JampBlockTerepo");
    	//ネザー
    	DQBlocks.DqmBlockJampBlockTerepoBoss2 = new DqmJumpBlockToBoss().setBlockName("dqm.blockJumpBlockTerepoBoss2").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:JampBlockTerepo");
    	//エンド
    	DQBlocks.DqmBlockJampBlockTerepoBoss3 = new DqmJumpBlockToBoss().setBlockName("dqm.blockJumpBlockTerepoBoss3").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:JampBlockTerepo");
    	//SP
    	DQBlocks.DqmBlockJampBlockTerepoBoss4 = new DqmJumpBlockToBoss().setBlockName("dqm.blockJumpBlockTerepoBoss4").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:JampBlockTerepo");
    	//転生
    	DQBlocks.DqmBlockJampBlockTerepoBoss5 = new DqmJumpBlockToBoss().setBlockName("dqm.blockJumpBlockTerepoBoss5").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:JampBlockTerepo");
    	//ボス
    	DQBlocks.DqmBlockJampBlockTerepoBoss6 = new DqmJumpBlockToBoss().setBlockName("dqm.blockJumpBlockTerepoBoss6").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:JampBlockTerepo");

    	DQBlocks.DqmBlockKieru = new DqmKieruBlock().setBlockName("dqm.blockKieru").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kieru");
    	DQBlocks.DqmBlockSet1 = new DqmSetBlock1().setBlockName("dqm.blockSet1").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Set1");
    	DQBlocks.DqmBlockShoumetu = new DqmSyoumetu().setBlockName("dqm.blockShoumetu").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Shoumetu");
    	DQBlocks.DqmBlockHikariB = new DqmItemBlockL().setLightLevel(1.0F).setBlockName("dqm.blockHikariB").setHardness(0.2f).setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:HikariB");

    	DQBlocks.DqmBlockStoneDama = new DqmBlockBase(Material.ground).setBlockName("dqm.blockStoneDama").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:StoneDama");
    	DQBlocks.DqmBlockKowarenai2 = new DqmBlockBase(Material.ground).setBlockName("dqm.blockKowarenai2").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowarenai2");
    	DQBlocks.DqmBlockKowarenai4 = new DqmBlockBase2(Material.ground).setBlockName("dqm.blockKowarenai4").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowarenai4");
    	DQBlocks.DqmBlockKowarenai5 = new DqmBlockBase(Material.ground).setBlockName("dqm.blockKowarenai5").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowarenai5");
    	DQBlocks.DqmBlockKowarenai6 = new DqmBlockBase(Material.ground).setBlockName("dqm.blockKowarenai6").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowarenai6");
    	DQBlocks.DqmBlockKowarenai7 = new DqmBlockBase(Material.ground).setBlockName("dqm.blockKowarenai7").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowarenai7");
    	DQBlocks.DqmBlockKowareru5 = new DqmBlockBase(Material.ground).setBlockName("dqm.blockKowareru5").setHardness(1.0f).setResistance(500.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowareru5");
    	DQBlocks.DqmBlockKowareru6 = new DqmBlockBase(Material.ground).setBlockName("dqm.blockKowareru6").setHardness(1.0f).setResistance(500.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowarenai6");
    	DQBlocks.DqmBlockKowareru7 = new DqmBlockBase(Material.ground).setBlockName("dqm.blockKowareru7").setHardness(1.0f).setResistance(500.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowarenai7");

    	DQBlocks.DqmBlockKowareru8 = new DqmBlockBase(Material.ground).setBlockName("dqm.blockKowareru8").setHardness(5.0f).setResistance(500.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowareru8");
    	DQBlocks.DqmBlockKowareru9 = new DqmBlockBase(Material.ground).setBlockName("dqm.blockKowareru9").setHardness(5.0f).setResistance(500.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Kowareru9");

    	DQBlocks.DqmBlockSandStoneBB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockSandStoneBB").setHardness(1.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:SandStoneBB");
    	DQBlocks.DqmBlockIronBB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockIronBB").setHardness(1.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:IronBB");
    	DQBlocks.DqmBlockStoneBB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockStoneBB").setHardness(1.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:StoneBB");
    	DQBlocks.DqmBlockObsibianBB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockObsibianBB").setHardness(1.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:ObsibianBB");
    	DQBlocks.DqmBlockBedrockBB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlocknetherrackBB").setHardness(1.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:BedrockBB");
    	DQBlocks.DqmBlocknetherrackBB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockIronBB").setHardness(1.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:netherrackBB");
    	DQBlocks.DqmBlockLavaBB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockLavaBB").setHardness(1.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:LavaBB");

    	DQBlocks.DqmBlockSandStoneB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockSandStoneB").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:SandStoneB");
    	DQBlocks.DqmBlockIronB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockIronB").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:IronB");
    	DQBlocks.DqmBlockStoneB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockStoneB").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:StoneB");
    	DQBlocks.DqmBlockObsibianB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockObsibianB").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:ObsibianB");
    	DQBlocks.DqmBlockBedrockB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockBedrockB").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:BedrockB");
    	DQBlocks.DqmBlocknetherrackB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlocknetherrackB").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:netherrackB");
    	DQBlocks.DqmBlockLavaB = new DqmBlockBase(Material.iron).setBlockName("dqm.blockBlockLavaB").setBlockUnbreakable().setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:LavaB");

    	DQBlocks.DqmBlockToumei = new DqmOneBlock2().setBlockName("dqm.blockToumei").setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:Toumei");
    	DQBlocks.DqmBlockMobSpawner = new DqmBlockMobSpawner().setBlockName("dqm.blockMobSpawner").setHardness(20.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("mob_spawner");

    	DQBlocks.DqmBlockBuilderFrame = new DqmBlockBuildFrame(Material.glass).setBlockName("dqm.blockBuilderFrame").setHardness(0.1F).setResistance(5000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:BuildFrame");
    	DQBlocks.DqmBlockGenkotu = new DqmGenkotuBlock().setBlockName("dqm.blockGenkotu").setHardness(0.5F).setResistance(2.0F).setStepSound(Block.soundTypeGrass).setCreativeTab(DQR.tabs.DqmTabPlant).setBlockTextureName("dqr:DqmGenkotuBlock");


    	DQBlocks.DqmBlockGanseki = new DqmGansekiBlock(Material.rock).setBlockName("dqm.blockGanseki").setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("stone");

    	DQChests.DqmEnderChest1 = new DqmBlockEnderChest(1).setBlockName("dqm.blockEnderChest1").setHardness(30.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setCreativeTab(DQR.tabs.DqmTabBackPack).setBlockTextureName("dqr:Ender1");
    	DQChests.DqmEnderChest2 = new DqmBlockEnderChest(2).setBlockName("dqm.blockEnderChest2").setHardness(30.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setCreativeTab(DQR.tabs.DqmTabBackPack).setBlockTextureName("dqr:Ender2");
    	DQChests.DqmEnderChest3 = new DqmBlockEnderChest(3).setBlockName("dqm.blockEnderChest3").setHardness(30.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setCreativeTab(DQR.tabs.DqmTabBackPack).setBlockTextureName("dqr:Ender3");
    	DQChests.DqmEnderChest4 = new DqmBlockEnderChest(4).setBlockName("dqm.blockEnderChest4").setHardness(30.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setCreativeTab(DQR.tabs.DqmTabBackPack).setBlockTextureName("dqr:Ender4");
    	DQChests.DqmEnderChest5 = new DqmBlockEnderChest(5).setBlockName("dqm.blockEnderChest5").setHardness(30.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setCreativeTab(DQR.tabs.DqmTabBackPack).setBlockTextureName("dqr:Ender5");


    	/*
    	GameRegistry.registerBlock(DqmBlockKowarenaiDoor, "DqmBlockKowarenaiDoor");
    	GameRegistry.registerBlock(DqmBlockKowarenaiDoor2, "DqmBlockKowarenaiDoor2");
    	GameRegistry.registerBlock(DqmBlockKowarenaiDoor3, "DqmBlockKowarenaiDoor3");

    	    	DQBlock.DqmBlockKajino = new DqmKajino(KajinoID, 128).setBlockName("dqm.blockKajino").setBlockUnbreakable().setResistance(2000.0F).setStepSound(soundWoodFootstep).setCreativeTab(DQR.tabs.DqmTabBlock);
    	DQBlock.DqmBlockKajino2 = new DqmKajino2(Kajino2ID, 128).setBlockName("dqm.blockKajino2").setBlockUnbreakable().setResistance(2000.0F).setStepSound(soundWoodFootstep).setCreativeTab(DQR.tabs.DqmTabBlock);
    	DQBlock.DqmBlockKajino3 = new DqmKajino3(Kajino3ID, 128).setBlockName("dqm.blockKajino3").setBlockUnbreakable().setResistance(2000.0F).setStepSound(soundWoodFootstep).setCreativeTab(DQR.tabs.DqmTabBlock);
    	DQBlock.DqmBlockKajinoB = new DqmKowarenaiBlockHikaru(KajinoBID, 128).setBlockName("dqm.blockKajinoB").setBlockUnbreakable().setResistance(2000.0F).setStepSound(soundWoodFootstep).setCreativeTab(DQR.tabs.DqmTabBlock);
    	DQBlock.DqmBlockKajino2B = new DqmKowarenaiBlockHikaru(Kajino2BID, 128).setBlockName("dqm.blockKajino2B").setBlockUnbreakable().setResistance(2000.0F).setStepSound(soundWoodFootstep).setCreativeTab(DQR.tabs.DqmTabBlock);
    	DQBlock.DqmBlockKajino3B = new DqmKowarenaiBlockHikaru(Kajino3BID, 128).setBlockName("dqm.blockKajino3B").setBlockUnbreakable().setResistance(2000.0F).setStepSound(soundWoodFootstep).setCreativeTab(DQR.tabs.DqmTabBlock);

    	*/
    	DQBlocks.DqmBlockN2 = new DqmKyouseiMoveBlock2(0).setBlockName("dqm.blockN2").setHardness(3.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:KyouseiMoveN");
    	DQBlocks.DqmBlockS2 = new DqmKyouseiMoveBlock2(1).setBlockName("dqm.blockS2").setHardness(3.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:KyouseiMoveS");
    	DQBlocks.DqmBlockW2 = new DqmKyouseiMoveBlock2(3).setBlockName("dqm.blockW2").setHardness(3.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:KyouseiMoveW");
    	DQBlocks.DqmBlockE2 = new DqmKyouseiMoveBlock2(2).setBlockName("dqm.blockE2").setHardness(3.0f).setResistance(2000.0F).setStepSound(Block.soundTypeStone).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:KyouseiMoveE");

    	DQPlants.BlockWaterBlock = new DQmBlockWaterBlock(Material.water).setBlockName("dqm.blockWaterBlock").setHardness(5.0f).setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:water_flow");
    	DQPlants.BlockWaterBlockLight = new DQmBlockWaterBlock(Material.water).setLightLevel(1.0F).setBlockName("dqm.blockWaterBlockLight").setHardness(5.0f).setResistance(2000.0F).setStepSound(Block.soundTypeGlass).setCreativeTab(DQR.tabs.DqmTabBlock).setBlockTextureName("dqr:water_flow");
	}
}
