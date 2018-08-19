package dqr.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.registry.GameRegistry;
import dqr.DQR;
import dqr.api.Blocks.DQPlants;
import dqr.api.Blocks.DQSekizous;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQArmors;
import dqr.api.Items.DQBuilders;
import dqr.api.Items.DQEmblems;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQInventorySlots;
import dqr.api.Items.DQMagicTools;
import dqr.api.Items.DQMagics;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQMonsters;
import dqr.api.Items.DQSeeds;
import dqr.api.Items.DQSkills;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumDqmBuilder;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.api.potion.DQPotionEtc;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.items.Subequip.DqmItemBuffShield;
import dqr.items.Subequip.DqmItemFuujinnnotate;
import dqr.items.Subequip.DqmItemSeijukunokubikazari;
import dqr.items.Subequip.DqmItemTikaranotate;
import dqr.items.Subequip.DqmItemUsingAccessories;
import dqr.items.base.DqmItemAccessoryBase;
import dqr.items.base.DqmItemArmorBase;
import dqr.items.base.DqmItemBowBase;
import dqr.items.base.DqmItemDebugBase;
import dqr.items.base.DqmItemEmblemBase;
import dqr.items.base.DqmItemFarmBook;
import dqr.items.base.DqmItemFoodMiscBase;
import dqr.items.base.DqmItemFoodSeedBase;
import dqr.items.base.DqmItemIngotBase;
import dqr.items.base.DqmItemMiscBase;
import dqr.items.base.DqmItemMonster;
import dqr.items.base.DqmItemSeedBase;
import dqr.items.base.DqmItemSkillBookBase;
import dqr.items.base.DqmItemSkillJBase;
import dqr.items.base.DqmItemSkillWBase;
import dqr.items.base.DqmItemThrowBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.items.builder.DqmItemBuilderCasino;
import dqr.items.builder.DqmItemBuilderDama;
import dqr.items.builder.DqmItemBuilderDamaS;
import dqr.items.builder.DqmItemBuilderDamaW;
import dqr.items.builder.DqmItemBuilderIdoMedal;
import dqr.items.builder.DqmItemBuilderNPC;
import dqr.items.builder.DqmItemBuilderSekizou;
import dqr.items.builder.DqmItemBuilderShop;
import dqr.items.fukuro.DqmItemFukuro;
import dqr.items.magic.DqmItemMagicBagi;
import dqr.items.magic.DqmItemMagicBasiRura;
import dqr.items.magic.DqmItemMagicBasiRura2;
import dqr.items.magic.DqmItemMagicBasiRuraC;
import dqr.items.magic.DqmItemMagicBehomara;
import dqr.items.magic.DqmItemMagicBuff;
import dqr.items.magic.DqmItemMagicDebuff;
import dqr.items.magic.DqmItemMagicDoruma;
import dqr.items.magic.DqmItemMagicDragonF;
import dqr.items.magic.DqmItemMagicDragonS;
import dqr.items.magic.DqmItemMagicGira;
import dqr.items.magic.DqmItemMagicHaigou;
import dqr.items.magic.DqmItemMagicHoimi;
import dqr.items.magic.DqmItemMagicHyado;
import dqr.items.magic.DqmItemMagicIo;
import dqr.items.magic.DqmItemMagicKiari;
import dqr.items.magic.DqmItemMagicMahoimi;
import dqr.items.magic.DqmItemMagicMahouken;
import dqr.items.magic.DqmItemMagicMera;
import dqr.items.magic.DqmItemMagicNotImplemented;
import dqr.items.magic.DqmItemMagicRaidein;
import dqr.items.magic.DqmItemMagicRura;
import dqr.items.magic.DqmItemMagicRura2;
import dqr.items.magic.DqmItemMagicRuraC;
import dqr.items.magic.DqmItemMagicRuraSin;
import dqr.items.magic.DqmItemMagicRuraSin2;
import dqr.items.magic.DqmItemMagicRuraSinC;
import dqr.items.magic.DqmItemMagicWorld;
import dqr.items.magic.DqmItemMagicZaki;
import dqr.items.magic.DqmItemMagicZaoriku;
import dqr.items.magicTool.DqmItemFishingRod;
import dqr.items.magicTool.DqmItemMGTBreak1;
import dqr.items.magicTool.DqmItemMGTBreak2;
import dqr.items.magicTool.DqmItemMGTFarm1;
import dqr.items.magicTool.DqmItemMGTFarm2;
import dqr.items.magicTool.DqmItemMGTSet;
import dqr.items.magicTool.DqmItemPetSuisyou;
import dqr.items.miscs.DqmItemAccessoryCanceler;
import dqr.items.miscs.DqmItemAccessoryStopper;
import dqr.items.miscs.DqmItemDyeWhite2;
import dqr.items.miscs.DqmItemFarmerDiary;
import dqr.items.miscs.DqmItemKenjanoisi;
import dqr.items.miscs.DqmItemKimera;
import dqr.items.miscs.DqmItemKimera2;
import dqr.items.miscs.DqmItemKimeraC;
import dqr.items.miscs.DqmItemLittlemedal;
import dqr.items.miscs.DqmItemMahounoTutu;
import dqr.items.miscs.DqmItemMegaminoInori;
import dqr.items.miscs.DqmItemPetbook;
import dqr.items.miscs.DqmItemShinjirukokoro;
import dqr.items.weapon.DqmItemThrowing;

public class DqItem {

	public static final int HELMET   = 0;
	public static final int PLATE    = 1;
	public static final int LEGGINGS = 2;
	public static final int BOOTS    = 3;

	public DqItem()
	{
        if(DQR.debug != 0)
        {
        	DQMiscs.itemDebugItem = new DqmItemDebugBase().setCreativeTab(DQR.tabs.DqmTabMisc).setTextureName("dqr:Ganannomonsyou");;
        	GameRegistry.registerItem(DQMiscs.itemDebugItem, "ItemDebugItem");
        }

		//アクセサリー
		DQAccessories.itemSuraimupiasu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSuraimupiasu").setTextureName("dqr:Suraimupiasu");
		DQAccessories.itemKinnopiasu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemKinnopiasu").setTextureName("dqr:Kinnopiasu");
		DQAccessories.itemBerupiasu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemBerupiasu").setTextureName("dqr:Berupiasu");
		DQAccessories.itemHosinopiasu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHosinopiasu").setTextureName("dqr:Hosinopiasu");
		DQAccessories.itemKirapiasu2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemKirapiasu2").setTextureName("dqr:Kirapiasu2");
		DQAccessories.itemAkumanopiasu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemAkumanopiasu").setTextureName("dqr:Akumanopiasu");
		DQAccessories.itemMahounopiasu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMahounopiasu").setTextureName("dqr:Mahounopiasu");
		DQAccessories.itemTensinopiasu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemTensinopiasu").setTextureName("dqr:Tensinopiasu");
		DQAccessories.itemHosifurupiasu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHosifurupiasu").setTextureName("dqr:Hosifurupiasu");
		DQAccessories.itemHosifurupiasu2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Piasu).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHosifurupiasu2").setTextureName("dqr:Hosifurupiasu2");

		DQAccessories.itemHosinokubikazari = new DqmItemAccessoryBase(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHosinokubikazari").setTextureName("dqr:Hosinokubikazari");
		DQAccessories.itemRakkipendanto = new DqmItemAccessoryBase(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemRakkipendanto").setTextureName("dqr:Rakkipendanto");
		DQAccessories.itemKataminokubikazari = new DqmItemAccessoryBase(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemKataminokubikazari").setTextureName("dqr:Kataminokubikazari");
		DQAccessories.itemSingonnojuzu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSingonnojuzu").setTextureName("dqr:Singonnojuzu");
		DQAccessories.itemSinigaminokubikazari = new DqmItemAccessoryBase(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSinigaminokubikazari").setTextureName("dqr:Sinigaminokubikazari");
		DQAccessories.itemSeijukunokubikazari = new DqmItemSeijukunokubikazari(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSeijukunokubikazari").setTextureName("dqr:Seijukunokubikazari");
		DQAccessories.itemHosizoranokubikazari = new DqmItemAccessoryBase(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHosizoranokubikazari").setTextureName("dqr:Hosizoranokubikazari");
		DQAccessories.itemHosizoranokubikazari2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHosizoranokubikazari2").setTextureName("dqr:Hosizoranokubikazari2");
		DQAccessories.itemHosizoranokubikazari3 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHosizoranokubikazari3").setTextureName("dqr:Hosizoranokubikazari3");
		DQAccessories.itemHosizoranokubikazari4 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Kubikazari).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHosizoranokubikazari4").setTextureName("dqr:Hosizoranokubikazari4");

		DQAccessories.itemGoldburesuretto = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemGoldburesuretto").setTextureName("dqr:Goldburesuretto");
		DQAccessories.itemHosifuru = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHosifuru").setTextureName("dqr:Hosifuru");
		DQAccessories.itemIyasinoudewa = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemIyasinoudewa").setTextureName("dqr:Iyasinoudewa");
		DQAccessories.itemMamorinoudewa = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMamorinoudewa").setTextureName("dqr:Mamorinoudewa");
		DQAccessories.itemMamorinoudewa2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMamorinoudewa2").setTextureName("dqr:Mamorinoudewa2");
		DQAccessories.itemMamorinoudewa3 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMamorinoudewa3").setTextureName("dqr:Mamorinoudewa3");
		DQAccessories.itemMamorinoudewa4 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMamorinoudewa4").setTextureName("dqr:Mamorinoudewa4");
		DQAccessories.itemGouketunoudewa = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemGouketunoudewa").setTextureName("dqr:Gouketunoudewa");
		DQAccessories.itemGouketunoudewa2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemGouketunoudewa2").setTextureName("dqr:Gouketunoudewa2");
		DQAccessories.itemGouketunoudewa3 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemGouketunoudewa3").setTextureName("dqr:Gouketunoudewa3");
		DQAccessories.itemGouketunoudewa4 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Udewa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemGouketunoudewa4").setTextureName("dqr:Gouketunoudewa4");

		DQAccessories.itemGoldring = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemGoldring").setTextureName("dqr:Goldring");
		DQAccessories.itemHaramotiYubiwa = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHaramotiYubiwa").setTextureName("dqr:HaramotiYubiwa");
		DQAccessories.itemHaraherazuYubiwa = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHaraherazuYubiwa").setTextureName("dqr:HaraherazuYubiwa");
		DQAccessories.itemHayatenoring = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHayatenoring").setTextureName("dqr:Hayatenoring");
		DQAccessories.itemGinnoyubiwa = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemGinnoyubiwa").setTextureName("dqr:Ginnoyubiwa");
		DQAccessories.itemInotinoyubiwa = new DqmItemUsingAccessories(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemInotinoyubiwa").setTextureName("dqr:Inotinoyubiwa");
		DQAccessories.itemTikaranoyubiwa = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemTikaranoyubiwa").setTextureName("dqr:Tikaranoyubiwa");
		DQAccessories.itemFurubitaring = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemFurubitaring").setTextureName("dqr:Furubitaring");
		DQAccessories.itemMegaminoyubiwa = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMegaminoyubiwa").setTextureName("dqr:Megaminoyubiwa");
		DQAccessories.itemInorinoyubiwa = new DqmItemUsingAccessories(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemInorinoyubiwa").setTextureName("dqr:Inorinoyubiwa");
		DQAccessories.itemSuparing = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSuparing").setTextureName("dqr:Suparing");
		DQAccessories.itemSosararing = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSosararing").setTextureName("dqr:Sosararing");
		DQAccessories.itemHagennoring = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHagennoring").setTextureName("dqr:Hagennoring");
		DQAccessories.itemHagennoring2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHagennoring2").setTextureName("dqr:Hagennoring2");
		DQAccessories.itemHadokunoring = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHadokunoring").setTextureName("dqr:Hadokunoring");
		DQAccessories.itemHadokunoring2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHadokunoring2").setTextureName("dqr:Hadokunoring2");
		DQAccessories.itemMangetunoring = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMangetunoring").setTextureName("dqr:Mangetunoring");
		DQAccessories.itemMangetunoring2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMangetunoring2").setTextureName("dqr:Mangetunoring2");
		DQAccessories.itemRiseinoring = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemRiseinoring").setTextureName("dqr:Riseinoring");
		DQAccessories.itemRiseinoring2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Yubiwa).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemRiseinoring2").setTextureName("dqr:Riseinoring2");

		DQAccessories.itemMayokenoseiin = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMayokenoseiin").setTextureName("dqr:Mayokenoseiin");
		DQAccessories.itemMamorinorubi = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMamorinorubi").setTextureName("dqr:Mamorinorubi");
		DQAccessories.itemTikaranorubi = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemTikaranorubi").setTextureName("dqr:Tikaranorubi");
		DQAccessories.itemAkumanotatu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemAkumanotatu").setTextureName("dqr:Akumanotatu");
		DQAccessories.itemRyuunouroko = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemRyuunouroko").setTextureName("dqr:Ryuunouroko");
		DQAccessories.itemRoiyarubajjji = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemRoiyarubajjji").setTextureName("dqr:Roiyarubajjji");
		DQAccessories.itemIkarinotatu = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemIkarinotatu").setTextureName("dqr:Ikarinotatu");
		DQAccessories.itemIkarinotatu2 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemIkarinotatu2").setTextureName("dqr:Ikarinotatu2");
		DQAccessories.itemIkarinotatu3 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemIkarinotatu3").setTextureName("dqr:Ikarinotatu3");
		DQAccessories.itemIkarinotatu4 = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemIkarinotatu4").setTextureName("dqr:Ikarinotatu4");
		DQAccessories.itemSaikyounoakasi = new DqmItemAccessoryBase(EnumDqmSubEquipType.Sonota).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSaikyounoakasi").setTextureName("dqr:Saikyounoakasi");

		DQAccessories.itemKawanotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemKawanotate").setTextureName("dqr:Kawanotate");
		DQAccessories.itemUrokonotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemUrokonotate").setTextureName("dqr:Urokonotate");
		DQAccessories.itemSuraimutorei = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSuraimutorei").setTextureName("dqr:Suraimutorei");
		DQAccessories.itemSeidounotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSeidounotate").setTextureName("dqr:Seidounotate");
		DQAccessories.itemHaganenotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHaganenotate").setTextureName("dqr:Haganenotate");
		DQAccessories.itemHowaitosirudo = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHowaitosirudo").setTextureName("dqr:Howaitosirudo");
		DQAccessories.itemHonoonotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHonoonotate").setTextureName("dqr:Honoonotate");
		DQAccessories.itemKoorinotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemKoorinotate").setTextureName("dqr:Koorinotate");
		DQAccessories.itemMahounotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMahounotate").setTextureName("dqr:Mahounotate");
		DQAccessories.itemOogasirudo = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemOogasirudo").setTextureName("dqr:Oogasirudo");
		DQAccessories.itemPuratinasirudo = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemPuratinasirudo").setTextureName("dqr:Puratinasirudo");
		DQAccessories.itemFuujinnnotate = new DqmItemFuujinnnotate(EnumDqmSubEquipType.Shield, 1).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemFuujinnnotate").setTextureName("dqr:Fuujinnnotate");
		DQAccessories.itemFuujinnnotate2 = new DqmItemFuujinnnotate(EnumDqmSubEquipType.Shield, 2).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemFuujinnnotate2").setTextureName("dqr:Fuujinnnotate2");
		DQAccessories.itemFuujinnnotate3 = new DqmItemFuujinnnotate(EnumDqmSubEquipType.Shield, 3).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemFuujinnnotate3").setTextureName("dqr:Fuujinnnotate3");
		DQAccessories.itemMikagaminotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMikagaminotate").setTextureName("dqr:Mikagaminotate");
		DQAccessories.itemTikaranotate = new DqmItemTikaranotate(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemTikaranotate").setTextureName("dqr:Tikaranotate");
		DQAccessories.itemMetarukingnotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMetarukingnotate").setTextureName("dqr:Metarukingnotate");

		DQAccessories.itemTenkuunotate = new DqmItemBuffShield(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemTenkuunotate").setTextureName("dqr:Tenkuunotate");
		DQAccessories.itemRotonotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemRotonotate").setTextureName("dqr:Rotonotate");
		DQAccessories.itemSabitatate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemSabitatate").setTextureName("dqr:Sabitatate");
		DQAccessories.itemMegaminotate = new DqmItemAccessoryBase(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMegaminotate").setTextureName("dqr:Megaminotate");
		DQAccessories.itemUroborosunotate = new DqmItemBuffShield(EnumDqmSubEquipType.Shield).setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemUroborosunotate").setTextureName("dqr:Uroborosunotate");

		DQAccessories.itemAccCanceler =  new DqmItemAccessoryCanceler().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemAccCanceler").setTextureName("dqr:Torihazusi");
		DQAccessories.itemAccStopper =  new DqmItemAccessoryStopper().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemAccStopper").setTextureName("dqr:Stopper");
		//防具

		DQArmors.itemDansanohanekazaribando = new DqmItemArmorBase(DQR.dqmMaterial.armorDansa, HELMET, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDansanohanekazaribando").setTextureName("dqr:Dansanohanekazaribando");
		DQArmors.itemDansanosyatu = new DqmItemArmorBase(DQR.dqmMaterial.armorDansa, PLATE, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDansanosyatu").setTextureName("dqr:Dansanosyatu");
		DQArmors.itemDansanozubon = new DqmItemArmorBase(DQR.dqmMaterial.armorDansa, LEGGINGS, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDansanozubon").setTextureName("dqr:Dansanozubon");
		DQArmors.itemDansanobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorDansa, BOOTS, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDansanobutu").setTextureName("dqr:Dansanobutu");
		DQArmors.itemOdorikonokamikazari = new DqmItemArmorBase(DQR.dqmMaterial.armorOdoriko, HELMET, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemOdorikonokamikazari").setTextureName("dqr:Odorikonokamikazari");
		DQArmors.itemOdorikonofuku = new DqmItemArmorBase(DQR.dqmMaterial.armorOdoriko, PLATE, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemOdorikonofuku").setTextureName("dqr:Odorikonofuku");
		DQArmors.itemOdorikononisokkusu = new DqmItemArmorBase(DQR.dqmMaterial.armorOdoriko, LEGGINGS, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemOdorikononisokkusu").setTextureName("dqr:Odorikononisokkusu");
		DQArmors.itemOdorikonomyuru = new DqmItemArmorBase(DQR.dqmMaterial.armorOdoriko, BOOTS, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemOdorikonomyuru").setTextureName("dqr:Odorikonomyuru");
		DQArmors.itemPurinsesutexiara = new DqmItemArmorBase(DQR.dqmMaterial.armorPurinsesu, HELMET, 6).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemPurinsesutexiara").setTextureName("dqr:Purinsesutexiara");
		DQArmors.itemPurinsesurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorPurinsesu, PLATE, 6).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemPurinsesurobu").setTextureName("dqr:Purinsesurobu");
		DQArmors.itemPurinsesugurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorPurinsesu, LEGGINGS, 6).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemPurinsesugurobu").setTextureName("dqr:Purinsesugurobu");
		DQArmors.itemPurinsesuhiru = new DqmItemArmorBase(DQR.dqmMaterial.armorPurinsesu, BOOTS, 6).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemPurinsesuhiru").setTextureName("dqr:Purinsesuhiru");
		DQArmors.itemSeijanokakarotto = new DqmItemArmorBase(DQR.dqmMaterial.armorSeija, HELMET, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSeijanokakarotto").setTextureName("dqr:Seijanokakarotto");
		DQArmors.itemSeijanohoui = new DqmItemArmorBase(DQR.dqmMaterial.armorSeija, PLATE, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSeijanohoui").setTextureName("dqr:Seijanohoui");
		DQArmors.itemSeijanotaitu = new DqmItemArmorBase(DQR.dqmMaterial.armorSeija, LEGGINGS, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSeijanotaitu").setTextureName("dqr:Seijanotaitu");
		DQArmors.itemSeijanobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorSeija, BOOTS, 4).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSeijanobutu").setTextureName("dqr:Seijanobutu");
		DQArmors.itemStarhatto = new DqmItemArmorBase(DQR.dqmMaterial.armorStar, HELMET, 5).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemStarhatto").setTextureName("dqr:Starhatto");
		DQArmors.itemStarnasutu = new DqmItemArmorBase(DQR.dqmMaterial.armorStar, PLATE, 5).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemStarnasutu").setTextureName("dqr:Starnasutu");
		DQArmors.itemStarzubon = new DqmItemArmorBase(DQR.dqmMaterial.armorStar, LEGGINGS, 5).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemStarzubon").setTextureName("dqr:Starzubon");
		DQArmors.itemStarbutu = new DqmItemArmorBase(DQR.dqmMaterial.armorStar, BOOTS, 5).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemStarbutu").setTextureName("dqr:Starbutu");
		DQArmors.itemSinpannokabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorSinwa, HELMET, 14).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSinpannokabuto").setTextureName("dqr:Sinpannokabuto");
		DQArmors.itemSinwanoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorSinwa, PLATE, 14).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSinwanoyoroi").setTextureName("dqr:Sinwanoyoroi");
		DQArmors.itemAmaterasunokote = new DqmItemArmorBase(DQR.dqmMaterial.armorSinwa, LEGGINGS, 14).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemAmaterasunokote").setTextureName("dqr:Amaterasunokote");
		DQArmors.itemTenteinobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorSinwa, BOOTS, 14).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemTenteinobutu").setTextureName("dqr:Tenteinobutu");
		DQArmors.itemKeikoginokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorKeikogi, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKeikoginokutu").setTextureName("dqr:Keikoginokutu");
		DQArmors.itemKeikoginobandana = new DqmItemArmorBase(DQR.dqmMaterial.armorKeikogi, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKeikoginobandana").setTextureName("dqr:Keikoginobandana");
		DQArmors.itemKeikogisita = new DqmItemArmorBase(DQR.dqmMaterial.armorKeikogi, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKeikogisita").setTextureName("dqr:Keikogisita");
		DQArmors.itemKeikogi = new DqmItemArmorBase(DQR.dqmMaterial.armorKeikogi, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKeikogi").setTextureName("dqr:Keikogi");
		DQArmors.itemKenpouginobando = new DqmItemArmorBase(DQR.dqmMaterial.armorKenpou, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKenpouginobando").setTextureName("dqr:Kenpouginobando");
		DQArmors.itemKenpouginokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorKenpou, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKenpouginokutu").setTextureName("dqr:Kenpouginokutu");
		DQArmors.itemKenpougiue = new DqmItemArmorBase(DQR.dqmMaterial.armorKenpou, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKenpougiue").setTextureName("dqr:Kenpougiue");
		DQArmors.itemKenpougirisuto = new DqmItemArmorBase(DQR.dqmMaterial.armorKenpou, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKenpougirisuto").setTextureName("dqr:Kenpougirisuto");
		DQArmors.itemBuounokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorBuou, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBuounokutu").setTextureName("dqr:Buounokutu");
		DQArmors.itemBuounohatigane = new DqmItemArmorBase(DQR.dqmMaterial.armorBuou, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBuounohatigane").setTextureName("dqr:Buounohatigane");
		DQArmors.itemBudougirisuto = new DqmItemArmorBase(DQR.dqmMaterial.armorBudou, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBudougirisuto").setTextureName("dqr:Budougirisuto");
		DQArmors.itemBusinnobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorBusin, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBusinnobutu").setTextureName("dqr:Businnobutu");
		DQArmors.itemSinkannobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorSinkan, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSinkannobutu").setTextureName("dqr:Sinkannobutu");
		DQArmors.itemDaimadougurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorDaimadou, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDaimadougurobu").setTextureName("dqr:Daimadougurobu");
		DQArmors.itemSatorinokanmuri = new DqmItemArmorBase(DQR.dqmMaterial.armorSatori, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSatorinokanmuri").setTextureName("dqr:Satorinokanmuri");
		DQArmors.itemSatorinokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorSatori, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSatorinokutu").setTextureName("dqr:Satorinokutu");
		DQArmors.itemBudougi = new DqmItemArmorBase(DQR.dqmMaterial.armorBudou, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBudougi").setTextureName("dqr:Budougi");
		DQArmors.itemBusinnobudougi = new DqmItemArmorBase(DQR.dqmMaterial.armorBusin, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBusinnobudougi").setTextureName("dqr:Businnobudougi");
		DQArmors.itemDaimadounobousi = new DqmItemArmorBase(DQR.dqmMaterial.armorDaimadou, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDaimadounobousi").setTextureName("dqr:Daimadounobousi");
		DQArmors.itemDaimadounorobu = new DqmItemArmorBase(DQR.dqmMaterial.armorDaimadou, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDaimadounorobu").setTextureName("dqr:Daimadounorobu");
		DQArmors.itemDaimadounosyuzu = new DqmItemArmorBase(DQR.dqmMaterial.armorDaimadou, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDaimadounosyuzu").setTextureName("dqr:Daimadounosyuzu");
		DQArmors.itemDoragonrobu = new DqmItemArmorBase(DQR.dqmMaterial.armorDoragonrobu, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDoragonrobu").setTextureName("dqr:Doragonrobu");
		DQArmors.itemFusiginaborero = new DqmItemArmorBase(DQR.dqmMaterial.armorFusiginaborero, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemFusiginaborero").setTextureName("dqr:Fusiginaborero");
		DQArmors.itemKinobousi = new DqmItemArmorBase(DQR.dqmMaterial.armorKinobousi, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKinobousi").setTextureName("dqr:Kinobousi");
		DQArmors.itemMadousinosandaru = new DqmItemArmorBase(DQR.dqmMaterial.armorMadousi, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMadousinosandaru").setTextureName("dqr:Madousinosandaru");
		DQArmors.itemMikawasinofuku = new DqmItemArmorBase(DQR.dqmMaterial.armorMikawasinofuku, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMikawasinofuku").setTextureName("dqr:Mikawasinofuku");
		DQArmors.itemMizunohagoromo = new DqmItemArmorBase(DQR.dqmMaterial.armorMizunohagoromo, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMizunohagoromo").setTextureName("dqr:Mizunohagoromo");
		DQArmors.itemOberonnokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorOberonnokutu, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemOberonnokutu").setTextureName("dqr:Oberonnokutu");
		DQArmors.itemBudoubandana = new DqmItemArmorBase(DQR.dqmMaterial.armorBudou, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBudoubandana").setTextureName("dqr:Budoubandana");
		DQArmors.itemRezamanto = new DqmItemArmorBase(DQR.dqmMaterial.armorRezamanto, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRezamanto").setTextureName("dqr:Rezamanto");
		DQArmors.itemSatorinotebukuro = new DqmItemArmorBase(DQR.dqmMaterial.armorSatori, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSatorinotebukuro").setTextureName("dqr:Satorinotebukuro");
		DQArmors.itemSatorinowanpisu = new DqmItemArmorBase(DQR.dqmMaterial.armorSatori, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSatorinowanpisu").setTextureName("dqr:Satorinowanpisu");
		DQArmors.itemSefiramurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorSefiramurobu, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSefiramurobu").setTextureName("dqr:Sefiramurobu");
		//itemSeijanohoui = new DqmItemArmorBase(DQR.dqmMaterial.armorSeija, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSeijanohoui").setTextureName("dqr:Seijanohoui");
		DQArmors.itemSinkannobousi = new DqmItemArmorBase(DQR.dqmMaterial.armorSinkan, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSinkannobousi").setTextureName("dqr:Sinkannobousi");
		DQArmors.itemSinkannoepuron = new DqmItemArmorBase(DQR.dqmMaterial.armorSinkan, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSinkannoepuron").setTextureName("dqr:Sinkannoepuron");
		DQArmors.itemSinkannogurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorSinkan, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSinkannogurobu").setTextureName("dqr:Sinkannogurobu");
		DQArmors.itemSutekinasabo = new DqmItemArmorBase(DQR.dqmMaterial.armorSutekinasabo, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSutekinasabo").setTextureName("dqr:Sutekinasabo");
		DQArmors.itemTabibitonofuku = new DqmItemArmorBase(DQR.dqmMaterial.armorTabibito, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemTabibitonofuku").setTextureName("dqr:Tabibitonofuku");
		DQArmors.itemTabibitonotebukuro = new DqmItemArmorBase(DQR.dqmMaterial.armorTabibito, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemTabibitonotebukuro").setTextureName("dqr:Tabibitonotebukuro");
		DQArmors.itemBudounokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorBudou, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBudounokutu").setTextureName("dqr:Budounokutu");
		DQArmors.itemBuounoudeate = new DqmItemArmorBase(DQR.dqmMaterial.armorBuou, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBuounoudeate").setTextureName("dqr:Buounoudeate");
		DQArmors.itemBusinrisuto = new DqmItemArmorBase(DQR.dqmMaterial.armorBusin, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBusinrisuto").setTextureName("dqr:Businrisuto");
		DQArmors.itemBuounosutu = new DqmItemArmorBase(DQR.dqmMaterial.armorBuou, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBuounosutu").setTextureName("dqr:Buounosutu");
		DQArmors.itemBusinnobandana = new DqmItemArmorBase(DQR.dqmMaterial.armorBusin, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBusinnobandana").setTextureName("dqr:Businnobandana");

		DQArmors.itemRotonokabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorRoto, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRotonokabuto").setTextureName("dqr:Rotonokabuto");
		DQArmors.itemRotonoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorRoto, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRotonoyoroi").setTextureName("dqr:Rotonoyoroi");
		DQArmors.itemRotonokote = new DqmItemArmorBase(DQR.dqmMaterial.armorRoto, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRotonokote").setTextureName("dqr:Rotonokote");
		DQArmors.itemRotonokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorRoto, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRotonokutu").setTextureName("dqr:Rotonokutu");

		DQArmors.itemMetarukingnokabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorMetal, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMetarukingnokabuto").setTextureName("dqr:Metarukingnokabuto");
		DQArmors.itemMetarukingnoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorMetal, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMetarukingnoyoroi").setTextureName("dqr:Metarukingnoyoroi");
		DQArmors.itemMetarukingnokote = new DqmItemArmorBase(DQR.dqmMaterial.armorMetal, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMetarukingnokote").setTextureName("dqr:Metarukingnokote");
		DQArmors.itemMetarukingnokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorMetal, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMetarukingnokutu").setTextureName("dqr:Metarukingnokutu");

		DQArmors.itemSabitakabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorOld, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSabitakabuto").setTextureName("dqr:Sabitakabuto");
		DQArmors.itemSabitayoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorOld, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSabitayoroi").setTextureName("dqr:Sabitayoroi");
		DQArmors.itemSabitakote = new DqmItemArmorBase(DQR.dqmMaterial.armorOld, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSabitakote").setTextureName("dqr:Sabitakote");
		DQArmors.itemSabitakutu = new DqmItemArmorBase(DQR.dqmMaterial.armorOld, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSabitakutu").setTextureName("dqr:Sabitakutu");

		DQArmors.itemHaganenokabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorHagane, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemHaganenokabuto").setTextureName("dqr:Haganenokabuto");
		DQArmors.itemHaganenoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorHagane, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemHaganenoyoroi").setTextureName("dqr:Haganenoyoroi");
		DQArmors.itemHaganenokote = new DqmItemArmorBase(DQR.dqmMaterial.armorHagane, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemHaganenokote").setTextureName("dqr:Haganenokote");
		DQArmors.itemHaganenokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorHagane, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemHaganenokutu").setTextureName("dqr:Haganenokutu");

		DQArmors.itemKawanobousi = new DqmItemArmorBase(DQR.dqmMaterial.armorKawa, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKawanobousi").setTextureName("dqr:Kawanobousi");
		DQArmors.itemKawanoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorKawa, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKawanoyoroi").setTextureName("dqr:Kawanoyoroi");
		DQArmors.itemKawanokote = new DqmItemArmorBase(DQR.dqmMaterial.armorKawa, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKawanokote").setTextureName("dqr:Kawanokote");
		DQArmors.itemKawanokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorKawa, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKawanokutu").setTextureName("dqr:Kawanokutu");

		DQArmors.itemUrokonoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorUroko, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemUrokonoyoroi").setTextureName("dqr:Urokonoyoroi");

		DQArmors.itemHonoonoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorHonoo, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemHonoonoyoroi").setTextureName("dqr:Honoonoyoroi");

		DQArmors.itemMirayoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorMira, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMirayoroi").setTextureName("dqr:Mirayoroi");

		DQArmors.itemYaibanoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorYaiba, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemYaibanoyoroi").setTextureName("dqr:Yaibanoyoroi");

		DQArmors.itemSinpinoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorSinpi, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSinpinoyoroi").setTextureName("dqr:Sinpinoyoroi");

		DQArmors.itemSuraimuhead = new DqmItemArmorBase(DQR.dqmMaterial.armorSlime, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSuraimuhead").setTextureName("dqr:Suraimuhead");
		DQArmors.itemSuraimunofuku = new DqmItemArmorBase(DQR.dqmMaterial.armorSlime, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSuraimunofuku").setTextureName("dqr:Suraimunofuku");

		DQArmors.itemDoragonmeiru = new DqmItemArmorBase(DQR.dqmMaterial.armorDragon, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemDoragonmeiru").setTextureName("dqr:Doragonmeiru");

		DQArmors.itemKenjanobousi = new DqmItemArmorBase(DQR.dqmMaterial.armorKenja, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKenjanobousi").setTextureName("dqr:Kenjanobousi");
		DQArmors.itemKenjanoroubu = new DqmItemArmorBase(DQR.dqmMaterial.armorKenja, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKenjanoroubu").setTextureName("dqr:Kenjanoroubu");
		DQArmors.itemKenjanotebukuro = new DqmItemArmorBase(DQR.dqmMaterial.armorKenja, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKenjanotebukuro").setTextureName("dqr:Kenjanotebukuro");
		DQArmors.itemKenjanokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorKenja, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKenjanokutu").setTextureName("dqr:Kenjanokutu");

		DQArmors.itemSakuretto = new DqmItemArmorBase(DQR.dqmMaterial.armorKinu, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSakuretto").setTextureName("dqr:Sakuretto");
		DQArmors.itemKinunoroubu = new DqmItemArmorBase(DQR.dqmMaterial.armorKinu, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKinunoroubu").setTextureName("dqr:Kinunoroubu");
		DQArmors.itemKinunotebukuro = new DqmItemArmorBase(DQR.dqmMaterial.armorKinu, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemKinunotebukuro").setTextureName("dqr:Kinunotebukuro");
		DQArmors.itemSandaru = new DqmItemArmorBase(DQR.dqmMaterial.armorKinu, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSandaru").setTextureName("dqr:Sandaru");

		DQArmors.itemMahounobousi = new DqmItemArmorBase(DQR.dqmMaterial.armorMahou, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMahounobousi").setTextureName("dqr:Mahounobousi");
		DQArmors.itemMahounohoui = new DqmItemArmorBase(DQR.dqmMaterial.armorMahou, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMahounohoui").setTextureName("dqr:Mahounohoui");
		DQArmors.itemMahounotebukuro = new DqmItemArmorBase(DQR.dqmMaterial.armorMahou, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMahounotebukuro").setTextureName("dqr:Mahounotebukuro");
		DQArmors.itemMahounokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorMahou, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMahounokutu").setTextureName("dqr:Mahounokutu");

		DQArmors.itemRadatomukabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorRadadomu, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRadatomukabuto").setTextureName("dqr:Radatomukabuto");
		DQArmors.itemRadatomunoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorRadadomu, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRadatomunoyoroi").setTextureName("dqr:Radatomunoyoroi");
		DQArmors.itemRadatomugurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorRadadomu, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRadatomugurobu").setTextureName("dqr:Radatomugurobu");
		DQArmors.itemRadatomubutu = new DqmItemArmorBase(DQR.dqmMaterial.armorRadadomu, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRadatomubutu").setTextureName("dqr:Radatomubutu");

		DQArmors.itemRoresiametto = new DqmItemArmorBase(DQR.dqmMaterial.armorRoresia, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRoresiametto").setTextureName("dqr:Roresiametto");
		DQArmors.itemRoresianofuku = new DqmItemArmorBase(DQR.dqmMaterial.armorRoresia, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRoresianofuku").setTextureName("dqr:Roresianofuku");
		DQArmors.itemRoresiagurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorRoresia, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRoresiagurobu").setTextureName("dqr:Roresiagurobu");
		DQArmors.itemRoresiabutu = new DqmItemArmorBase(DQR.dqmMaterial.armorRoresia, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRoresiabutu").setTextureName("dqr:Roresiabutu");

		DQArmors.itemYuusyanokanmuri = new DqmItemArmorBase(DQR.dqmMaterial.armorYuusya, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemYuusyanokanmuri").setTextureName("dqr:Yuusyanokanmuri");
		DQArmors.itemYuusyanofuku = new DqmItemArmorBase(DQR.dqmMaterial.armorYuusya, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemYuusyanofuku").setTextureName("dqr:Yuusyanofuku");
		DQArmors.itemYusyanogurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorYuusya, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemYusyanogurobu").setTextureName("dqr:Yusyanogurobu");
		DQArmors.itemYuusyanobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorYuusya, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemYuusyanobutu").setTextureName("dqr:Yuusyanobutu");

		DQArmors.itemTenkuunokabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorTenkuu, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemTenkuunokabuto").setTextureName("dqr:Tenkuunokabuto");
		DQArmors.itemTenkuunofuku = new DqmItemArmorBase(DQR.dqmMaterial.armorTenkuu, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemTenkuunofuku").setTextureName("dqr:Tenkuunofuku");
		DQArmors.itemTenkuunogurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorTenkuu, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemTenkuunogurobu").setTextureName("dqr:Tenkuunogurobu");
		DQArmors.itemTenkuunobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorTenkuu, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemTenkuunobutu").setTextureName("dqr:Tenkuunobutu");

		DQArmors.itemGurantaban = new DqmItemArmorBase(DQR.dqmMaterial.armorGuran, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemGurantaban").setTextureName("dqr:Gurantaban");
		DQArmors.itemGuranbaniarobu = new DqmItemArmorBase(DQR.dqmMaterial.armorGuran, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemGuranbaniarobu").setTextureName("dqr:Guranbaniarobu");
		DQArmors.itemGuranbaniarisuto = new DqmItemArmorBase(DQR.dqmMaterial.armorGuran, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemGuranbaniarisuto").setTextureName("dqr:Guranbaniarisuto");
		DQArmors.itemGuranbanianokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorGuran, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemGuranbanianokutu").setTextureName("dqr:Guranbanianokutu");

		DQArmors.itemRaiannokabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorRaian, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRaiannokabuto").setTextureName("dqr:Raiannokabuto");
		DQArmors.itemRaiannoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorRaian, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRaiannoyoroi").setTextureName("dqr:Raiannoyoroi");
		DQArmors.itemRaiannogurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorRaian, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRaiannogurobu").setTextureName("dqr:Raiannogurobu");
		DQArmors.itemRaiannobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorRaian, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRaiannobutu").setTextureName("dqr:Raiannobutu");

		DQArmors.itemTenkuunoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorTenkuu, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemTenkuunoyoroi").setTextureName("dqr:Tenkuunoyoroi");

		DQArmors.itemNekomimibando = new DqmItemArmorBase(DQR.dqmMaterial.armorNeko, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemNekomimibando").setTextureName("dqr:Nekomimibando");

		DQArmors.itemSuraimunokanmuriK = new DqmItemArmorBase(DQR.dqmMaterial.armorKing, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSuraimunokanmuriK").setTextureName("dqr:SuraimunokanmuriK");

		DQArmors.itemFantomumasuku = new DqmItemArmorBase(DQR.dqmMaterial.armorFantomu, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemFantomumasuku").setTextureName("dqr:Fantomumasuku");

		DQArmors.itemArakuremasuku = new DqmItemArmorBase(DQR.dqmMaterial.armorArakure, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemArakuremasuku").setTextureName("dqr:Arakuremasuku");

		DQArmors.itemSiawasenobousi = new DqmItemArmorBase(DQR.dqmMaterial.armorSiawase, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSiawasenobousi").setTextureName("dqr:Siawasenobousi");
		DQArmors.itemSiawasenokutu = new DqmItemArmorBase(DQR.dqmMaterial.armorSiawase, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSiawasenokutu").setTextureName("dqr:Siawasenokutu");

		DQArmors.itemAbunaimizugiue = new DqmItemArmorBase(DQR.dqmMaterial.armorAbunai, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemAbunaimizugiue").setTextureName("dqr:Abunaimizugiue");
		DQArmors.itemAbunaimizugisita = new DqmItemArmorBase(DQR.dqmMaterial.armorAbunai, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemAbunaimizugisita").setTextureName("dqr:Abunaimizugisita");

		DQArmors.itemUsamimibando = new DqmItemArmorBase(DQR.dqmMaterial.armorBani, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemUsamimibando").setTextureName("dqr:Usamimibando");
		DQArmors.itemBanisutu = new DqmItemArmorBase(DQR.dqmMaterial.armorBani, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemBanisutu").setTextureName("dqr:Banisutu");
		DQArmors.itemAmitaitu = new DqmItemArmorBase(DQR.dqmMaterial.armorBani, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemAmitaitu").setTextureName("dqr:Amitaitu");
		DQArmors.itemHaihiru = new DqmItemArmorBase(DQR.dqmMaterial.armorBani, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemHaihiru").setTextureName("dqr:Haihiru");

		DQArmors.itemSensinokabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorSensi, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSensinokabuto").setTextureName("dqr:Sensinokabuto");
		DQArmors.itemSensinoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorSensi, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSensinoyoroi").setTextureName("dqr:Sensinoyoroi");
		DQArmors.itemSensinogurobu = new DqmItemArmorBase(DQR.dqmMaterial.armorSensi, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSensinogurobu").setTextureName("dqr:Sensinogurobu");
		DQArmors.itemSensinobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorSensi, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemSensinobutu").setTextureName("dqr:Sensinobutu");

		DQArmors.itemPuratinaheddo = new DqmItemArmorBase(DQR.dqmMaterial.armorPlatina, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemPuratinaheddo").setTextureName("dqr:Puratinaheddo");
		DQArmors.itemPuratinameiru = new DqmItemArmorBase(DQR.dqmMaterial.armorPlatina, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemPuratinameiru").setTextureName("dqr:Puratinameiru");
		DQArmors.itemPuratinagantoretto = new DqmItemArmorBase(DQR.dqmMaterial.armorPlatina, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemPuratinagantoretto").setTextureName("dqr:Puratinagantoretto");
		DQArmors.itemPuratinaguribu = new DqmItemArmorBase(DQR.dqmMaterial.armorPlatina, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemPuratinaguribu").setTextureName("dqr:Puratinaguribu");

		DQArmors.itemMisuriruherumu = new DqmItemArmorBase(DQR.dqmMaterial.armorMisuriru, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMisuriruherumu").setTextureName("dqr:Misuriruherumu");
		DQArmors.itemMisurirumeiru = new DqmItemArmorBase(DQR.dqmMaterial.armorMisuriru, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMisurirumeiru").setTextureName("dqr:Misurirumeiru");
		DQArmors.itemMisuritugantoretto = new DqmItemArmorBase(DQR.dqmMaterial.armorMisuriru, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMisuritugantoretto").setTextureName("dqr:Misuritugantoretto");
		DQArmors.itemMisuriruguribu = new DqmItemArmorBase(DQR.dqmMaterial.armorMisuriru, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemMisuriruguribu").setTextureName("dqr:Misuriruguribu");

		DQArmors.itemRyuukisinokabuto = new DqmItemArmorBase(DQR.dqmMaterial.armorRyuukisi, HELMET, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRyuukisinokabuto").setTextureName("dqr:Ryuukisinokabuto");
		DQArmors.itemRyuukisinoyoroi = new DqmItemArmorBase(DQR.dqmMaterial.armorRyuukisi, PLATE, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRyuukisinoyoroi").setTextureName("dqr:Ryuukisinoyoroi");
		DQArmors.itemRyuukisinokote = new DqmItemArmorBase(DQR.dqmMaterial.armorRyuukisi, LEGGINGS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRyuukisinokote").setTextureName("dqr:Ryuukisinokote");
		DQArmors.itemRyuukisinobutu = new DqmItemArmorBase(DQR.dqmMaterial.armorRyuukisi, BOOTS, 1).setCreativeTab(DQR.tabs.DqmTabArmor).setUnlocalizedName("dqm.itemRyuukisinobutu").setTextureName("dqr:Ryuukisinobutu");



		//設計書
		DQBuilders.itemBuilderDama = new DqmItemBuilderDama(EnumDqmBuilder.DAMA).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama").setMaxStackSize(1).setTextureName("dqr:BuilderDama");
		DQBuilders.itemBuilderDama1 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama1").setTextureName("dqr:BuilderDama1");
		DQBuilders.itemBuilderDama2 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama2").setTextureName("dqr:BuilderDama2");
		DQBuilders.itemBuilderDama3 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama3").setTextureName("dqr:BuilderDama3");
		DQBuilders.itemBuilderDama4 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama4").setTextureName("dqr:BuilderDama4");
		DQBuilders.itemBuilderDama5 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama5").setTextureName("dqr:BuilderDama5");
		DQBuilders.itemBuilderDama6 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama6").setTextureName("dqr:BuilderDama6");
		DQBuilders.itemBuilderDama7 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama7").setTextureName("dqr:BuilderDama7");
		DQBuilders.itemBuilderDama8 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama8").setTextureName("dqr:BuilderDama8");
		DQBuilders.itemBuilderDama9 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDama9").setTextureName("dqr:BuilderDama9");

		DQBuilders.itemBuilderDamaS = new DqmItemBuilderDamaS(EnumDqmBuilder.DAMAS).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS").setMaxStackSize(1).setTextureName("dqr:BuilderDama20");
		DQBuilders.itemBuilderDamaS1 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS1").setTextureName("dqr:BuilderDama21");
		DQBuilders.itemBuilderDamaS2 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS2").setTextureName("dqr:BuilderDama22");
		DQBuilders.itemBuilderDamaS3 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS3").setTextureName("dqr:BuilderDama23");
		DQBuilders.itemBuilderDamaS4 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS4").setTextureName("dqr:BuilderDama24");
		DQBuilders.itemBuilderDamaS5 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS5").setTextureName("dqr:BuilderDama25");
		DQBuilders.itemBuilderDamaS6 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS6").setTextureName("dqr:BuilderDama26");
		DQBuilders.itemBuilderDamaS7 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS7").setTextureName("dqr:BuilderDama27");
		DQBuilders.itemBuilderDamaS8 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS8").setTextureName("dqr:BuilderDama28");
		DQBuilders.itemBuilderDamaS9 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaS9").setTextureName("dqr:BuilderDama29");

		DQBuilders.itemBuilderDamaW = new DqmItemBuilderDamaW(EnumDqmBuilder.DAMAW).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW").setMaxStackSize(1).setTextureName("dqr:BuilderDama30");
		DQBuilders.itemBuilderDamaW1 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW1").setTextureName("dqr:BuilderDama31");
		DQBuilders.itemBuilderDamaW2 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW2").setTextureName("dqr:BuilderDama32");
		DQBuilders.itemBuilderDamaW3 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW3").setTextureName("dqr:BuilderDama33");
		DQBuilders.itemBuilderDamaW4 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW4").setTextureName("dqr:BuilderDama34");
		DQBuilders.itemBuilderDamaW5 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW5").setTextureName("dqr:BuilderDama35");
		DQBuilders.itemBuilderDamaW6 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW6").setTextureName("dqr:BuilderDama36");
		DQBuilders.itemBuilderDamaW7 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW7").setTextureName("dqr:BuilderDama37");
		DQBuilders.itemBuilderDamaW8 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW8").setTextureName("dqr:BuilderDama38");
		DQBuilders.itemBuilderDamaW9 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaW9").setTextureName("dqr:BuilderDama39");

		DQBuilders.itemBuilderIdoMedal = new DqmItemBuilderIdoMedal(EnumDqmBuilder.IDOMEDAL).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderIdoMedal").setMaxStackSize(1).setTextureName("dqr:BuilderIdoMedal");
		DQBuilders.itemBuilderSekizouZoma = new DqmItemBuilderSekizou(EnumDqmBuilder.SEKIZOU, DQSekizous.BlockSekizouZoma).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderSekizouZoma").setMaxStackSize(1).setTextureName("dqr:Builder_Sekizou_Zoma");
		DQBuilders.itemBuilderSekizouRyuuou = new DqmItemBuilderSekizou(EnumDqmBuilder.SEKIZOU, DQSekizous.BlockSekizouRyuuou).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderSekizouRyuuou").setMaxStackSize(1).setTextureName("dqr:Builder_Sekizou_Ryuuou");
		DQBuilders.itemBuilderSekizouDesupisaro1 = new DqmItemBuilderSekizou(EnumDqmBuilder.SEKIZOU, DQSekizous.BlockSekizouDesupisaro1).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderSekizouDesupisaro").setMaxStackSize(1).setTextureName("dqr:Builder_Sekizou_Desupisaro");
		DQBuilders.itemBuilderSekizouEsterk = new DqmItemBuilderSekizou(EnumDqmBuilder.SEKIZOU, DQSekizous.BlockSekizouEsterk).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderSekizouEsterk").setMaxStackSize(1).setTextureName("dqr:Builder_Sekizou_Esterk");
		DQBuilders.itemBuilderSekizouDarkRamia = new DqmItemBuilderSekizou(EnumDqmBuilder.SEKIZOU, DQSekizous.BlockSekizouDarkRamia).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderSekizouDarkRamia").setMaxStackSize(1).setTextureName("dqr:Builder_Sekizou_DarkRamia");
		DQBuilders.itemBuilderSekizouMasterdoragon = new DqmItemBuilderSekizou(EnumDqmBuilder.SEKIZOU, DQSekizous.BlockSekizouMasterdoragon).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderSekizouMasterdoragon").setMaxStackSize(1).setTextureName("dqr:Builder_Sekizou_Masterdoragon");

		DQBuilders.itemBuilderShopBukiya = new DqmItemBuilderShop(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBukiya").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_Bukiya");
		DQBuilders.itemBuilderShopBank = new DqmItemBuilderShop(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBank").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_Bank");
		DQBuilders.itemBuilderShopSyuuriya = new DqmItemBuilderShop(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopSyuuriya").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_Syuuriya");
		DQBuilders.itemBuilderShopKaitoriya = new DqmItemBuilderShop(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopKaitoriya").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_Kaitoriya");

		DQBuilders.itemBuilderShopBankW = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBankW").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_BankW");
		DQBuilders.itemBuilderShopBukiyaW = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBukiW").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_BukiyaW");
		DQBuilders.itemBuilderShopSyuuriyaW = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopSyuuriW").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_SyuuriyaW");
		DQBuilders.itemBuilderShopKaitoriyaW = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopKaitoriW").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_KaitoriyaW");

		DQBuilders.itemBuilderIdoMedalW = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderIdoMedalW").setMaxStackSize(1).setTextureName("dqr:BuilderIdoMedalW");

		DQBuilders.itemBuilderDamaTW = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaTW").setMaxStackSize(1).setTextureName("dqr:BuilderDamaW");
		DQBuilders.itemBuilderDamaSW = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaSW").setMaxStackSize(1).setTextureName("dqr:BuilderDama20W");
		DQBuilders.itemBuilderDamaWW = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderDamaWW").setMaxStackSize(1).setTextureName("dqr:BuilderDama30W");

		DQBuilders.itemBuilderShopBukiyaW3 = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBukiW3").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_BukiyaW");
		DQBuilders.itemBuilderShopBukiyaW4 = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBukiW4").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_BukiyaW");
		DQBuilders.itemBuilderShopBukiyaW5 = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBukiW5").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_BukiyaW");
		DQBuilders.itemBuilderShopBukiyaW6 = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBukiW6").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_BukiyaW");
		//転職証
		DQEmblems.itemEmbCivilian = new DqmItemEmblemBase(EnumDqmJob.Asobinin).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbCivilian").setTextureName("dqr:EmbCivilian");
		DQEmblems.itemEmbWarrior = new DqmItemEmblemBase(EnumDqmJob.Senshi).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbWarrior").setTextureName("dqr:EmbWarrior");
		DQEmblems.itemEmbFighter = new DqmItemEmblemBase(EnumDqmJob.Budouka).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbFighter").setTextureName("dqr:EmbFighter");
		DQEmblems.itemEmbBattleMaster = new DqmItemEmblemBase(EnumDqmJob.BattleMaster).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbBattleMaster").setTextureName("dqr:EmbBattleMaster");
		DQEmblems.itemEmbMagician = new DqmItemEmblemBase(EnumDqmJob.Mahoutukai).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbMagician").setTextureName("dqr:EmbMagician");
		DQEmblems.itemEmbPriest = new DqmItemEmblemBase(EnumDqmJob.Souryo).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbPriest").setTextureName("dqr:EmbPriest");
		DQEmblems.itemEmbSage = new DqmItemEmblemBase(EnumDqmJob.Kenja).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbSage").setTextureName("dqr:EmbSage");
		DQEmblems.itemEmbHero = new DqmItemEmblemBase(EnumDqmJob.Yuusha).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbHero").setTextureName("dqr:EmbHero");
		DQEmblems.itemEmbPaladin = new DqmItemEmblemBase(EnumDqmJob.Paladin).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbPaladin").setTextureName("dqr:EmbPaladin");
		DQEmblems.itemEmbMagickKnight = new DqmItemEmblemBase(EnumDqmJob.MahouSenshi).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbMagickKnight").setTextureName("dqr:EmbMagickKnight");
		DQEmblems.itemEmbRanger = new DqmItemEmblemBase(EnumDqmJob.Ranger).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbRanger").setTextureName("dqr:EmbRanger");
		DQEmblems.itemEmbMonsterTamer = new DqmItemEmblemBase(EnumDqmJob.Mamonotukai).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbMonsterTamer").setTextureName("dqr:EmbMonsterTamer");
		DQEmblems.itemEmbSuperStar = new DqmItemEmblemBase(EnumDqmJob.SuperStar).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbSuperStar").setTextureName("dqr:EmbSuperStar");
		DQEmblems.itemEmbHaguremetal = new DqmItemEmblemBase(EnumDqmJob.Haguremetal).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbHaguremetal").setTextureName("dqr:EmbHaguremetal");
		DQEmblems.itemEmbMerchant = new DqmItemEmblemBase(EnumDqmJob.Syounin).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbMerchant").setTextureName("dqr:EmbMerchant");
		DQEmblems.itemEmbThief = new DqmItemEmblemBase(EnumDqmJob.Touzoku).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbThief").setTextureName("dqr:EmbThief");
		DQEmblems.itemEmbGodHnad = new DqmItemEmblemBase(EnumDqmJob.GodHand).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbGodHnad").setTextureName("dqr:EmbGodHnad");
		DQEmblems.itemEmbDragon = new DqmItemEmblemBase(EnumDqmJob.Dragon).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbDragon").setTextureName("dqr:EmbDragon");
		DQEmblems.itemEmbLegend = new DqmItemEmblemBase(EnumDqmJob.Densetsu).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbLegend").setTextureName("dqr:EmbLegend");
		DQEmblems.itemEmbDancer = new DqmItemEmblemBase(EnumDqmJob.Odoriko).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbDancer").setTextureName("dqr:EmbDancer");
		DQEmblems.itemEmbPirate = new DqmItemEmblemBase(EnumDqmJob.Kaizoku).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbPirate").setTextureName("dqr:EmbPirate");
		DQEmblems.itemEmbMasterDragon = new DqmItemEmblemBase(EnumDqmJob.MASTERDRAGON).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbMasterDragon").setTextureName("dqr:EmbMasterDragon");

		DQEmblems.itemEmbHituzikai = new DqmItemEmblemBase(EnumDqmJob.Hituzikai).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbHituzikai").setTextureName("dqr:EmbHituzikai");
		DQEmblems.itemEmbFunanori = new DqmItemEmblemBase(EnumDqmJob.Funanori).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbFunanori").setTextureName("dqr:EmbFunanori");
		DQEmblems.itemEmbDougutukai = new DqmItemEmblemBase(EnumDqmJob.Dougutukai).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbDougutukai").setTextureName("dqr:EmbDougutukai");
		DQEmblems.itemEmbTentiraimeishi = new DqmItemEmblemBase(EnumDqmJob.Tentiraimeishi).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEmbTentiraimeishi").setTextureName("dqr:EmbTentiraimeishi");


		DQEmblems.itemDamaCivilian = new DqmItemEmblemBase(EnumDqmJob.Asobinin).setUnlocalizedName("dqm.itemDamaCivilian").setTextureName("dqr:DamaCivilian");
		DQEmblems.itemDamaWarrior = new DqmItemEmblemBase(EnumDqmJob.Senshi).setUnlocalizedName("dqm.itemDamaWarrior").setTextureName("dqr:DamaWarrior");
		DQEmblems.itemDamaFighter = new DqmItemEmblemBase(EnumDqmJob.Budouka).setUnlocalizedName("dqm.itemDamaFighter").setTextureName("dqr:DamaFighter");
		DQEmblems.itemDamaBattleMaster = new DqmItemEmblemBase(EnumDqmJob.BattleMaster).setUnlocalizedName("dqm.itemDamaBattleMaster").setTextureName("dqr:DamaBattleMaster");
		DQEmblems.itemDamaMagician = new DqmItemEmblemBase(EnumDqmJob.Mahoutukai).setUnlocalizedName("dqm.itemDamaMagician").setTextureName("dqr:DamaMagician");
		DQEmblems.itemDamaPriest = new DqmItemEmblemBase(EnumDqmJob.Souryo).setUnlocalizedName("dqm.itemDamaPriest").setTextureName("dqr:DamaPriest");
		DQEmblems.itemDamaSage = new DqmItemEmblemBase(EnumDqmJob.Kenja).setUnlocalizedName("dqm.itemDamaSage").setTextureName("dqr:DamaSage");
		DQEmblems.itemDamaHero = new DqmItemEmblemBase(EnumDqmJob.Yuusha).setUnlocalizedName("dqm.itemDamaHero").setTextureName("dqr:DamaHero");
		DQEmblems.itemDamaPaladin = new DqmItemEmblemBase(EnumDqmJob.Paladin).setUnlocalizedName("dqm.itemDamaPaladin").setTextureName("dqr:DamaPaladin");
		DQEmblems.itemDamaMagickKnight = new DqmItemEmblemBase(EnumDqmJob.MahouSenshi).setUnlocalizedName("dqm.itemDamaMagickKnight").setTextureName("dqr:DamaMagickKnight");
		DQEmblems.itemDamaRanger = new DqmItemEmblemBase(EnumDqmJob.Ranger).setUnlocalizedName("dqm.itemDamaRanger").setTextureName("dqr:DamaRanger");
		DQEmblems.itemDamaMonsterTamer = new DqmItemEmblemBase(EnumDqmJob.Mamonotukai).setUnlocalizedName("dqm.itemDamaMonsterTamer").setTextureName("dqr:DamaMonsterTamer");
		DQEmblems.itemDamaSuperStar = new DqmItemEmblemBase(EnumDqmJob.SuperStar).setUnlocalizedName("dqm.itemDamaSuperStar").setTextureName("dqr:DamaSuperStar");
		DQEmblems.itemDamaHaguremetal = new DqmItemEmblemBase(EnumDqmJob.Haguremetal).setUnlocalizedName("dqm.itemDamaHaguremetal").setTextureName("dqr:DamaHaguremetal");
		DQEmblems.itemDamaMerchant = new DqmItemEmblemBase(EnumDqmJob.Syounin).setUnlocalizedName("dqm.itemDamaMerchant").setTextureName("dqr:DamaMerchant");
		DQEmblems.itemDamaThief = new DqmItemEmblemBase(EnumDqmJob.Touzoku).setUnlocalizedName("dqm.itemDamaThief").setTextureName("dqr:DamaThief");
		DQEmblems.itemDamaGodHnad = new DqmItemEmblemBase(EnumDqmJob.GodHand).setUnlocalizedName("dqm.itemDamaGodHnad").setTextureName("dqr:DamaGodHnad");
		DQEmblems.itemDamaDragon = new DqmItemEmblemBase(EnumDqmJob.Dragon).setUnlocalizedName("dqm.itemDamaDragon").setTextureName("dqr:DamaDragon");
		DQEmblems.itemDamaLegend = new DqmItemEmblemBase(EnumDqmJob.Densetsu).setUnlocalizedName("dqm.itemDamaLegend").setTextureName("dqr:DamaLegend");
		DQEmblems.itemDamaDancer = new DqmItemEmblemBase(EnumDqmJob.Odoriko).setUnlocalizedName("dqm.itemDamaDancer").setTextureName("dqr:DamaDancer");
		DQEmblems.itemDamaPirate = new DqmItemEmblemBase(EnumDqmJob.Kaizoku).setUnlocalizedName("dqm.itemDamaPirate").setTextureName("dqr:DamaPirate");
		DQEmblems.itemDamaMasterDragon = new DqmItemEmblemBase(EnumDqmJob.MASTERDRAGON).setUnlocalizedName("dqm.itemDamaMasterDragon").setTextureName("dqr:DamaMasterDragon");

		DQEmblems.itemDamaHituzikai = new DqmItemEmblemBase(EnumDqmJob.Hituzikai).setUnlocalizedName("dqm.itemDamaHituzikai").setTextureName("dqr:DamaHituzikai");
		DQEmblems.itemDamaFunanori = new DqmItemEmblemBase(EnumDqmJob.Funanori).setUnlocalizedName("dqm.itemDamaFunanori").setTextureName("dqr:DamaFunanori");
		DQEmblems.itemDamaDougutukai = new DqmItemEmblemBase(EnumDqmJob.Dougutukai).setUnlocalizedName("dqm.itemDamaDougutukai").setTextureName("dqr:DamaDougutukai");
		DQEmblems.itemDamaTentiraimeishi = new DqmItemEmblemBase(EnumDqmJob.Tentiraimeishi).setUnlocalizedName("dqm.itemDamaTentiraimeishi").setTextureName("dqr:DamaTentiraimeishi");


		//鉱石
		DQIngots.itemBakudanisi = new DqmItemThrowBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemBakudanisi").setTextureName("dqr:Bakudanisi");
		DQIngots.itemHikarinoisi = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemHikarinoisi").setTextureName("dqr:Hikarinoisi");
		DQIngots.itemHosinokakera = new DqmItemFoodMiscBase(2, 0.1F, false).setHealPoint(-1, -1, 20, 10).setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemHosinokakera").setTextureName("dqr:Hosinokakera");
		DQIngots.itemInotinoisi = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemInotinoisi").setTextureName("dqr:Inotinoisi");
		DQIngots.itemKagaminoisi = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemKagaminoisi").setTextureName("dqr:Kagaminoisi");
		DQIngots.itemKoorinokessyou = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemKoorinokessyou").setTextureName("dqr:Koorinokessyou");
		DQIngots.itemMigakizuna = new DqmItemFoodMiscBase(1, 0.2F, false).setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemMigakizuna").setTextureName("dqr:Migakizuna");
		DQIngots.itemMisriru = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemMisriru").setTextureName("dqr:Misriru");
		DQIngots.itemMoon = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemMoon").setTextureName("dqr:Moon");
		DQIngots.itemOriharukon = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemOriharukon").setTextureName("dqr:Oriharukon");
		DQIngots.itemPuratina = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemPuratina").setTextureName("dqr:Puratina");
		DQIngots.itemRubinogenseki = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemRubinogenseki").setTextureName("dqr:Rubinogenseki");
		DQIngots.itemTaiyounoisi = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemTaiyounoisi").setTextureName("dqr:Taiyounoisi");
		DQIngots.itemTekkouseki = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemTekkouseki").setTextureName("dqr:Tekkouseki");
		DQIngots.itemTokinosuisyou = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemTokinosuisyou").setTextureName("dqr:Tokinosuisyou");
		DQIngots.itemYougansekinokakera = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemYougansekinokakera").setTextureName("dqr:Yougansekinokakera");

		DQIngots.itemTaiyounoisi2 = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemTaiyounoisi2").setTextureName("dqr:Taiyounoisi2");
		DQIngots.itemPuratina2 = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemPuratina2").setTextureName("dqr:Puratina2");
		DQIngots.itemMisriru2 = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemMisriru2").setTextureName("dqr:Misriru2");
		DQIngots.itemOriharukon2 = new DqmItemIngotBase().setCreativeTab(DQR.tabs.DqmTabOre).setUnlocalizedName("dqm.itemOriharukon2").setTextureName("dqr:Oriharukon2");



		//魔法
		/*
		DQMagics.bulletSource = new ItemVForce(Item.ToolMaterial.EMERALD)
		DQMagics..setUnlocalizedName("villagerCannon.bulletSource")
		DQMagics..setCreativeTab(CreativeTabs.tabCombat);

		DQMagics.materials = new ItemMaterials()
		DQMagics..setUnlocalizedName("villagerCannon.materials")
		DQMagics..setCreativeTab(CreativeTabs.tabMaterials);

		DQMagics.GameRegistry.registerItem(bulletSource, "villagerCannon.bulletSource");
		DQMagics.GameRegistry.registerItem(materials, "villagerCannon.materials");
		DQMagics.*/

		DQMagics.itemMera = new DqmItemMagicMera((DQR.dqmMaterial.DqmMagicMahouTukai) , 1.0F, 1000, EnumDqmMagic.Mera).setUnlocalizedName("dqm.itemMera").setTextureName("dqr:Mera").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMerami = new DqmItemMagicMera((DQR.dqmMaterial.DqmMagicMahouTukai) , 3.0F, 1000, EnumDqmMagic.Merami).setUnlocalizedName("dqm.itemMerami").setTextureName("dqr:Merami").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMerazoma = new DqmItemMagicMera((DQR.dqmMaterial.DqmMagicMahouTukai) , 5.0F, 1000, EnumDqmMagic.Merazoma).setUnlocalizedName("dqm.itemMerazoma").setTextureName("dqr:Merazoma").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMeragaia = new DqmItemMagicMera((DQR.dqmMaterial.DqmMagicMahouTukai) , 10.0F, 1000, EnumDqmMagic.Meragaia).setUnlocalizedName("dqm.itemMeragaia").setTextureName("dqr:Meragaia").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemGira = new DqmItemMagicGira((DQR.dqmMaterial.DqmMagicMahouTukai) , 1.0F, 1000, EnumDqmMagic.Gira).setUnlocalizedName("dqm.itemGira").setTextureName("dqr:Gira").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBegirama = new DqmItemMagicGira((DQR.dqmMaterial.DqmMagicMahouTukai) , 3.0F, 1000, EnumDqmMagic.Begirama).setUnlocalizedName("dqm.itemBegirama").setTextureName("dqr:Begirama").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBegiragon = new DqmItemMagicGira((DQR.dqmMaterial.DqmMagicMahouTukai) , 5.0F, 1000, EnumDqmMagic.Begiragon).setUnlocalizedName("dqm.itemBegiragon").setTextureName("dqr:Begiragon").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemGiragureido = new DqmItemMagicGira((DQR.dqmMaterial.DqmMagicMahouTukai) , 10.0F, 1000, EnumDqmMagic.Giragureido).setUnlocalizedName("dqm.itemGiragureido").setTextureName("dqr:Giragureido").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemHyado = new DqmItemMagicHyado((DQR.dqmMaterial.DqmMagicMahouTukai) , 1.0F, 1000, EnumDqmMagic.Hyado).setUnlocalizedName("dqm.itemHyado").setTextureName("dqr:Hyado").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemHyadaruko = new DqmItemMagicHyado((DQR.dqmMaterial.DqmMagicMahouTukai) , 3.0F, 1000, EnumDqmMagic.Hyadaruko).setUnlocalizedName("dqm.itemHyadaruko").setTextureName("dqr:Hyadaruko").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahyado = new DqmItemMagicHyado((DQR.dqmMaterial.DqmMagicMahouTukai) , 5.0F, 1000, EnumDqmMagic.Mahyado).setUnlocalizedName("dqm.itemMahyado").setTextureName("dqr:Mahyado").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahyadodesu = new DqmItemMagicHyado((DQR.dqmMaterial.DqmMagicMahouTukai) , 10.0F, 1000, EnumDqmMagic.Mahyadodesu).setUnlocalizedName("dqm.itemMahyadodesu").setTextureName("dqr:Mahyadodesu").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemIo = new DqmItemMagicIo((DQR.dqmMaterial.DqmMagicMahouTukai) , 1.0F, 1000, EnumDqmMagic.Io).setUnlocalizedName("dqm.itemIo").setTextureName("dqr:Io").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemIora = new DqmItemMagicIo((DQR.dqmMaterial.DqmMagicMahouTukai) , 3.0F, 1000, EnumDqmMagic.Iora).setUnlocalizedName("dqm.itemIora").setTextureName("dqr:Iora").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemIonazun = new DqmItemMagicIo((DQR.dqmMaterial.DqmMagicMahouTukai) , 5.0F, 1000, EnumDqmMagic.Ionazun).setUnlocalizedName("dqm.itemIonazun").setTextureName("dqr:Ionazun").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemIogurande = new DqmItemMagicIo((DQR.dqmMaterial.DqmMagicMahouTukai) , 10.0F, 1000, EnumDqmMagic.Iogurande).setUnlocalizedName("dqm.itemIogurande").setTextureName("dqr:Iogurande").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemBagi = new DqmItemMagicBagi((DQR.dqmMaterial.DqmMagicSouryo) , 1.0F, 1000, EnumDqmMagic.Bagi).setUnlocalizedName("dqm.itemBagi").setTextureName("dqr:Bagi").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBagima = new DqmItemMagicBagi((DQR.dqmMaterial.DqmMagicSouryo) , 3.0F, 1000, EnumDqmMagic.Bagima).setUnlocalizedName("dqm.itemBagima").setTextureName("dqr:Bagima").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBagikurosu = new DqmItemMagicBagi((DQR.dqmMaterial.DqmMagicSouryo) , 5.0F, 1000, EnumDqmMagic.Bagikurosu).setUnlocalizedName("dqm.itemBagikurosu").setTextureName("dqr:Bagikurosu").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBagimutyo = new DqmItemMagicBagi((DQR.dqmMaterial.DqmMagicSouryo) , 10.0F, 1000, EnumDqmMagic.Bagimutyo).setUnlocalizedName("dqm.itemBagimutyo").setTextureName("dqr:Bagimutyo").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemHoimi = new DqmItemMagicHoimi((DQR.dqmMaterial.DqmMagicSouryo) , 1.0F, 1000, EnumDqmMagic.Hoimi).setUnlocalizedName("dqm.itemHoimi").setTextureName("dqr:Hoimi").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBehoimi = new DqmItemMagicHoimi((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 1000, EnumDqmMagic.Behoimi).setUnlocalizedName("dqm.itemBehoimi").setTextureName("dqr:Behoimi").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBehoma = new DqmItemMagicHoimi((DQR.dqmMaterial.DqmMagicSouryo) , 3.0F, 1000, EnumDqmMagic.Behoma).setUnlocalizedName("dqm.itemBehoma").setTextureName("dqr:Behoma").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemRura = new DqmItemMagicRura((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.Rura).setUnlocalizedName("dqm.itemRura").setTextureName("dqr:Rura").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraR = new DqmItemMagicRura((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraR).setUnlocalizedName("dqm.itemRuraR").setTextureName("dqr:RuraR").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraG = new DqmItemMagicRura((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraG).setUnlocalizedName("dqm.itemRuraG").setTextureName("dqr:RuraG").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraB = new DqmItemMagicRura((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraB).setUnlocalizedName("dqm.itemRuraB").setTextureName("dqr:RuraB").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraY = new DqmItemMagicRura((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraY).setUnlocalizedName("dqm.itemRuraY").setTextureName("dqr:RuraY").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemRuraC = new DqmItemMagicRuraC((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraC).setUnlocalizedName("dqm.itemRuraC").setTextureName("dqr:RuraC").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraRC = new DqmItemMagicRuraC((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraRC).setUnlocalizedName("dqm.itemRuraRC").setTextureName("dqr:RuraRC").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraGC = new DqmItemMagicRuraC((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraGC).setUnlocalizedName("dqm.itemRuraGC").setTextureName("dqr:RuraGC").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraBC = new DqmItemMagicRuraC((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraBC).setUnlocalizedName("dqm.itemRuraBC").setTextureName("dqr:RuraBC").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraYC = new DqmItemMagicRuraC((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraYC).setUnlocalizedName("dqm.itemRuraYC").setTextureName("dqr:RuraYC").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemRura2 = new DqmItemMagicRura2((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.Rura).setUnlocalizedName("dqm.itemRura2").setTextureName("dqr:Rura").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraR2 = new DqmItemMagicRura2((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraR).setUnlocalizedName("dqm.itemRuraR2").setTextureName("dqr:RuraR").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraG2 = new DqmItemMagicRura2((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraG).setUnlocalizedName("dqm.itemRuraG2").setTextureName("dqr:RuraG").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraB2 = new DqmItemMagicRura2((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraB).setUnlocalizedName("dqm.itemRuraB2").setTextureName("dqr:RuraB").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRuraY2 = new DqmItemMagicRura2((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 1000, EnumDqmMagic.RuraY).setUnlocalizedName("dqm.itemRuraY2").setTextureName("dqr:RuraY").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemBaikiruto = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Baikiruto, DQPotionPlus.buffBaikiruto).setUnlocalizedName("dqm.itemBaikiruto").setTextureName("dqr:Baikiruto").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemSukara = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Sukara, DQPotionPlus.buffSukara).setUnlocalizedName("dqm.itemSukara").setTextureName("dqr:Sukara").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBaha = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Baha, DQPotionPlus.buffBaha).setUnlocalizedName("dqm.itemBaha").setTextureName("dqr:Baha").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemPiora = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Piora, DQPotionPlus.buffPiora).setUnlocalizedName("dqm.itemPiora").setTextureName("dqr:Piora").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMagicbaria = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicParadin) , 2.0F, 2000, EnumDqmMagic.Magicbaria, DQPotionPlus.buffMagicBaria).setUnlocalizedName("dqm.itemMagicbaria").setTextureName("dqr:Magicbaria").setCreativeTab(DQR.tabs.DqmTabMagic);
		//DQMagics.itemMagicbaria = new DqmItemMagicNotImplemented(DQR.dqmMaterial.DqmMagicParadin , 2.0F, 2000, EnumDqmMagic.Magicbaria).setUnlocalizedName("dqm.itemMagicbaria").setTextureName("dqr:Magicbaria").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahokanta = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Mahokanta, DQPotionPlus.buffMahokanta).setUnlocalizedName("dqm.itemMahokanta").setTextureName("dqr:Mahokanta").setCreativeTab(DQR.tabs.DqmTabMagic);
		//itemMahokanta = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Mahokanta).setUnlocalizedName("dqm.itemMahokanta").setTextureName("dqr:Mahokanta").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemRemira = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Remirama, Potion.nightVision).setUnlocalizedName("dqm.itemRemira").setTextureName("dqr:Remira").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemSukuruto = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Sukuruto, DQPotionPlus.buffSukara).setUnlocalizedName("dqm.itemSukuruto").setTextureName("dqr:Sukara").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemFubaha = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Fubaha, DQPotionPlus.buffBaha).setUnlocalizedName("dqm.itemFubaha").setTextureName("dqr:Baha").setCreativeTab(DQR.tabs.DqmTabMagic);
		//DQMagics.itemFubaha = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Fubaha).setUnlocalizedName("dqm.itemFubaha").setTextureName("dqr:Baha").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemPiorimu = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Piorimu, DQPotionPlus.buffPiora).setUnlocalizedName("dqm.itemPiorimu").setTextureName("dqr:Piora").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemBomie = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Bomie, DQPotionMinus.debuffBomie).setUnlocalizedName("dqm.itemBomie").setTextureName("dqr:Bomie").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRariho = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Rariho, DQPotionMinus.debuffRariho).setUnlocalizedName("dqm.itemRariho").setTextureName("dqr:Rariho").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemManusa = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Manusa, DQPotionMinus.debuffManusa).setUnlocalizedName("dqm.itemManusa").setTextureName("dqr:Manusa").setCreativeTab(DQR.tabs.DqmTabMagic);
		//DQMagics.itemManusa = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Manusa).setUnlocalizedName("dqm.itemManusa").setTextureName("dqr:Manusa").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahoton = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Mahoton, DQPotionMinus.debuffMahoton).setUnlocalizedName("dqm.itemMahoton").setTextureName("dqr:Mahoton").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRukani = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Rukani, DQPotionMinus.debuffRukani).setUnlocalizedName("dqm.itemRukani").setTextureName("dqr:Rukani").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMedapani = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Medapani, DQPotionMinus.debuffMedapani).setUnlocalizedName("dqm.itemMedapani").setTextureName("dqr:Medapani").setCreativeTab(DQR.tabs.DqmTabMagic);
		//DQMagics.itemMedapani = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Medapani).setUnlocalizedName("dqm.itemMedapani").setTextureName("dqr:Medapani").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemHenatosu = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Henatosu, DQPotionMinus.debuffHenatosu).setUnlocalizedName("dqm.itemHenatosu").setTextureName("dqr:Henatosu").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemDivainsuperu = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicKenja) , 2.0F, 2000, EnumDqmMagic.Divainsuperu, DQPotionMinus.debuffDivainsuperu).setUnlocalizedName("dqm.itemDivainsuperu").setTextureName("dqr:Divainsuperu").setCreativeTab(DQR.tabs.DqmTabMagic);
		//DQMagics.itemDivainsuperu = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicKenja) , 2.0F, 2000, EnumDqmMagic.Divainsuperu).setUnlocalizedName("dqm.itemDivainsuperu").setTextureName("dqr:Divainsuperu").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemRukanan = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Rukanan, DQPotionMinus.debuffRukani).setUnlocalizedName("dqm.itemRukanan").setTextureName("dqr:Rukani").setCreativeTab(DQR.tabs.DqmTabMagic);
		//DQMagics.itemRukanan = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Rukanan).setUnlocalizedName("dqm.itemRukanan").setTextureName("dqr:Rukani").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRarihoma = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Rarihoma, DQPotionMinus.debuffRariho).setUnlocalizedName("dqm.itemRarihoma").setTextureName("dqr:Rariho").setCreativeTab(DQR.tabs.DqmTabMagic);
		//DQMagics.itemRarihoma = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Rarihoma).setUnlocalizedName("dqm.itemRarihoma").setTextureName("dqr:Rariho").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBomiosu = new DqmItemMagicDebuff((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Bomiosu, DQPotionMinus.debuffBomie).setUnlocalizedName("dqm.itemBomiosu").setTextureName("dqr:Bomie").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemUminarinotue = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Uminarinotue, DQPotionEtc.buffUminarinotue).setUnlocalizedName("dqm.itemUminarinotue").setTextureName("dqr:Uminarinotue").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemCallCloud = new DqmItemMagicWorld((DQR.dqmMaterial.DqmMagicKenja) , 2.0F, 2000, EnumDqmMagic.CallCloud).setUnlocalizedName("dqm.itemCallCloud").setTextureName("dqr:CallCloud").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemCallMagma = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.CallMagma, DQPotionEtc.buffCallMagma).setUnlocalizedName("dqm.itemCallMagma").setTextureName("dqr:CallMagma").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemHikarinotue = new DqmItemMagicWorld((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Hikarinotue).setUnlocalizedName("dqm.itemHikarinotue").setTextureName("dqr:Hikarinotue").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemBehomara = new DqmItemMagicBehomara((DQR.dqmMaterial.DqmMagicParadin) , 2.0F, 2000, EnumDqmMagic.Behomara).setUnlocalizedName("dqm.itemBehomara").setTextureName("dqr:Behomara").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBehomazun = new DqmItemMagicBehomara((DQR.dqmMaterial.DqmMagicYuusha) , 2.0F, 2000, EnumDqmMagic.Behomazun).setUnlocalizedName("dqm.itemBehomazun").setTextureName("dqr:Behomazun").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemMahoimi = new DqmItemMagicMahoimi((DQR.dqmMaterial.DqmMagicParadin) , 2.0F, 2000, EnumDqmMagic.Mahoimi).setUnlocalizedName("dqm.itemMahoimi").setTextureName("dqr:Mahoimi").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahoriku = new DqmItemMagicMahoimi((DQR.dqmMaterial.DqmMagicParadin) , 2.0F, 2000, EnumDqmMagic.Mahoriku).setUnlocalizedName("dqm.itemMahoriku").setTextureName("dqr:Mahoriku").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahoizun = new DqmItemMagicMahoimi((DQR.dqmMaterial.DqmMagicParadin) , 2.0F, 2000, EnumDqmMagic.Mahoizun).setUnlocalizedName("dqm.itemMahoizun").setTextureName("dqr:Mahoizun").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemZaoraru = new DqmItemMagicZaoriku((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Zaoraru).setUnlocalizedName("dqm.itemZaoraru").setTextureName("dqr:Zaoraru").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemZaoriku = new DqmItemMagicZaoriku((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Zaoriku).setUnlocalizedName("dqm.itemZaoriku").setTextureName("dqr:Zaoriku").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemHaigou = new DqmItemMagicHaigou((DQR.dqmMaterial.DqmMagicMamonotukai) , 2.0F, 2000, EnumDqmMagic.Haigou).setUnlocalizedName("dqm.itemHaigou").setTextureName("dqr:Haigou").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemHaigou2 = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicMamonotukai) , 2.0F, 2000, EnumDqmMagic.Haigou2).setUnlocalizedName("dqm.itemHaigou2").setTextureName("dqr:Haigou2").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemParupunte = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicAsobinin) , 2.0F, 2000, EnumDqmMagic.Parupunte).setUnlocalizedName("dqm.itemParupunte").setTextureName("dqr:Parupunte").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemRurasin = new DqmItemMagicRuraSin((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Rurasin).setUnlocalizedName("dqm.itemRurasin").setTextureName("dqr:Rurasin").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRurasin2 = new DqmItemMagicRuraSin2((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Rurasin2).setUnlocalizedName("dqm.itemRurasin2").setTextureName("dqr:Rurasin2").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemRurasinC = new DqmItemMagicRuraSinC((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.RurasinC).setUnlocalizedName("dqm.itemRurasinC").setTextureName("dqr:RurasinC").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemRaidein = new DqmItemMagicRaidein((DQR.dqmMaterial.DqmMagicYuusha) , 2.0F, 2000, EnumDqmMagic.Raidein).setUnlocalizedName("dqm.itemRaidein").setTextureName("dqr:Raidein").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemGigadein = new DqmItemMagicRaidein((DQR.dqmMaterial.DqmMagicYuusha) , 2.0F, 2000, EnumDqmMagic.Gigadein).setUnlocalizedName("dqm.itemGigadein").setTextureName("dqr:Gigadein").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMinadein = new DqmItemMagicRaidein((DQR.dqmMaterial.DqmMagicYuusha) , 2.0F, 2000, EnumDqmMagic.Minadein).setUnlocalizedName("dqm.itemMinadein").setTextureName("dqr:Minadein").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemZaki = new DqmItemMagicZaki((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Zaki).setUnlocalizedName("dqm.itemZaki").setTextureName("dqr:Zaki").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemZaraki = new DqmItemMagicZaki((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Zaraki).setUnlocalizedName("dqm.itemZaraki").setTextureName("dqr:Zaraki").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemZarakima = new DqmItemMagicZaki((DQR.dqmMaterial.DqmMagicKenja) , 2.0F, 2000, EnumDqmMagic.Zarakima).setUnlocalizedName("dqm.itemZarakima").setTextureName("dqr:Zarakima").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemDoruma = new DqmItemMagicDoruma((DQR.dqmMaterial.DqmMagicKenja) , 1.0F, 1000, EnumDqmMagic.Doruma).setUnlocalizedName("dqm.itemDoruma").setTextureName("dqr:Doruma").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemDorukuma = new DqmItemMagicDoruma((DQR.dqmMaterial.DqmMagicKenja) , 3.0F, 1000, EnumDqmMagic.Dorukuma).setUnlocalizedName("dqm.itemDorukuma").setTextureName("dqr:Dorukuma").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemDorumoa = new DqmItemMagicDoruma((DQR.dqmMaterial.DqmMagicKenja) , 5.0F, 1000, EnumDqmMagic.Dorumoa).setUnlocalizedName("dqm.itemDorumoa").setTextureName("dqr:Dorumoa").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemDorumadon = new DqmItemMagicDoruma((DQR.dqmMaterial.DqmMagicKenja) , 10.0F, 1000, EnumDqmMagic.Dorumadon).setUnlocalizedName("dqm.itemDorumadon").setTextureName("dqr:Dorumadon").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemMadante = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicKenja) , 2.0F, 2000, EnumDqmMagic.Madante).setUnlocalizedName("dqm.itemMadante").setTextureName("dqr:Madante").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBigban = new DqmItemMagicNotImplemented((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Bigban).setUnlocalizedName("dqm.itemBigban").setTextureName("dqr:Bigban").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemKiari = new DqmItemMagicKiari((DQR.dqmMaterial.DqmMagicSouryo) , 2.0F, 2000, EnumDqmMagic.Kiari).setUnlocalizedName("dqm.itemKiari").setTextureName("dqr:Kiari").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemMahouken1 = new DqmItemMagicMahouken((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Mahouken1, DQPotionEtc.buffMahouken, 0).setUnlocalizedName("dqm.itemMahouken1").setTextureName("dqr:Mahouken1").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahouken2 = new DqmItemMagicMahouken((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Mahouken2, DQPotionEtc.buffMahouken, 1).setUnlocalizedName("dqm.itemMahouken2").setTextureName("dqr:Mahouken2").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahouken3 = new DqmItemMagicMahouken((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Mahouken3, DQPotionEtc.buffMahouken, 2).setUnlocalizedName("dqm.itemMahouken3").setTextureName("dqr:Mahouken3").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahouken4 = new DqmItemMagicMahouken((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Mahouken4, DQPotionEtc.buffMahouken, 3).setUnlocalizedName("dqm.itemMahouken4").setTextureName("dqr:Mahouken4").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahouken5 = new DqmItemMagicMahouken((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Mahouken5, DQPotionEtc.buffMahouken, 4).setUnlocalizedName("dqm.itemMahouken5").setTextureName("dqr:Mahouken5").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahouken6 = new DqmItemMagicMahouken((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Mahouken6, DQPotionEtc.buffMahouken, 5).setUnlocalizedName("dqm.itemMahouken6").setTextureName("dqr:Mahouken6").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemMahouken7 = new DqmItemMagicMahouken((DQR.dqmMaterial.DqmMagicMahouSensi) , 2.0F, 2000, EnumDqmMagic.Mahouken7, DQPotionEtc.buffMahouken, 6).setUnlocalizedName("dqm.itemMahouken7").setTextureName("dqr:Mahouken7").setCreativeTab(DQR.tabs.DqmTabMagic);
		//itemCallCloud = new DqmItemMagicWorld((DQR.dqmMaterial.DqmMagicKenja) , 2.0F, 2000, EnumDqmMagic.CallCloud).setUnlocalizedName("dqm.itemCallCloud").setTextureName("dqr:CallCloud").setCreativeTab(DQR.tabs.DqmTabMagic);
		//itemCallMagma = new DqmItemMagicBuff((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.CallMagma, DQPotionPlus.buffCallMagma).setUnlocalizedName("dqm.itemCallMagma").setTextureName("dqr:CallMagma").setCreativeTab(DQR.tabs.DqmTabMagic);
		//itemHikarinotue = new DqmItemMagicWorld((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Hikarinotue).setUnlocalizedName("dqm.itemHikarinotue").setTextureName("dqr:Hikarinotue").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemBasirura = new DqmItemMagicBasiRura((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.Basirura).setUnlocalizedName("dqm.itemBasirura").setTextureName("dqr:BRura").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBasiruraC = new DqmItemMagicBasiRuraC((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.BasiruraC).setUnlocalizedName("dqm.itembasirurac").setTextureName("dqr:BRuraC").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBasiruraC2 = new DqmItemMagicBasiRura2((DQR.dqmMaterial.DqmMagicMahouTukai) , 2.0F, 2000, EnumDqmMagic.BasiruraC2).setUnlocalizedName("dqm.itemBasirura2").setTextureName("dqr:BRura2").setCreativeTab(DQR.tabs.DqmTabMagic);

		//素材
		DQMiscs.itemLittlemedal = new DqmItemLittlemedal().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemLittlemedal").setTextureName("dqr:Littlemedal");
		DQMiscs.itemLittlemedal5 = new DqmItemLittlemedal().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemLittlemedal5").setTextureName("dqr:Littlemedal5");
		DQMiscs.itemLittlemedal10 = new DqmItemLittlemedal().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemLittlemedal10").setTextureName("dqr:Littlemedal10");
		DQMiscs.itemLittlemedal50 = new DqmItemLittlemedal().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemLittlemedal50").setTextureName("dqr:Littlemedal50");
		DQMiscs.itemLittlemedal100 = new DqmItemLittlemedal().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemLittlemedal100").setTextureName("dqr:Littlemedal100");
		DQMiscs.itemLittlemedal500 = new DqmItemLittlemedal().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemLittlemedal500").setTextureName("dqr:Littlemedal500");
		DQMiscs.itemLittlemedal1000 = new DqmItemLittlemedal().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemLittlemedal1000").setTextureName("dqr:Littlemedal1000");

		DQMiscs.itemOkane = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemOkane").setTextureName("dqr:Okane");
		DQMiscs.itemOkane10000 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemOkane10000").setTextureName("dqr:Okane10000");
		DQMiscs.itemOkane100000 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemOkane100000").setTextureName("dqr:Okane100000");
		DQMiscs.itemOkane1000000 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemOkane1000000").setTextureName("dqr:Okane1000000");

		DQMiscs.itemKinka = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKinka").setTextureName("dqr:Kinka");
		DQMiscs.itemGinka = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemGinka").setTextureName("dqr:Ginka");
		DQMiscs.itemDouka = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDouka").setTextureName("dqr:Douka");

		DQMiscs.itemMegaminoinori0 = new DqmItemMegaminoInori(100).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori0").setTextureName("dqr:Megaminoinori0");
		DQMiscs.itemMegaminoinori1 = new DqmItemMegaminoInori(300).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori1").setTextureName("dqr:Megaminoinori1");
		DQMiscs.itemMegaminoinori2 = new DqmItemMegaminoInori(700).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori2").setTextureName("dqr:Megaminoinori2");
		DQMiscs.itemMegaminoinori3 = new DqmItemMegaminoInori(1200).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori3").setTextureName("dqr:Megaminoinori3");
		DQMiscs.itemMegaminoinori4 = new DqmItemMegaminoInori(2000).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori4").setTextureName("dqr:Megaminoinori4");
		DQMiscs.itemMegaminoinori5 = new DqmItemMegaminoInori(3500).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori5").setTextureName("dqr:Megaminoinori5");
		DQMiscs.itemMegaminoinori6 = new DqmItemMegaminoInori(6000).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori6").setTextureName("dqr:Megaminoinori6");
		DQMiscs.itemMegaminoinori7 = new DqmItemMegaminoInori(10000).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori7").setTextureName("dqr:Megaminoinori7");
		DQMiscs.itemMegaminoinori8 = new DqmItemMegaminoInori(15000).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori8").setTextureName("dqr:Megaminoinori8");
		DQMiscs.itemMegaminoinori9 = new DqmItemMegaminoInori(20000).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori9").setTextureName("dqr:Megaminoinori9");
		DQMiscs.itemMegaminoinori10 = new DqmItemMegaminoInori(30000).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMegaminoinori10").setTextureName("dqr:Megaminoinori10");


		DQMiscs.itemAkaisango = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemAkaisango").setTextureName("dqr:Akaisango");
		DQMiscs.itemSuraimunokanmuri = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSuraimunokanmuri").setTextureName("dqr:Suraimunokanmuri");
		DQMiscs.itemDokudokuhedoro = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDokudokuhedoro").setTextureName("dqr:Dokudokuhedoro");
		DQMiscs.itemGamanoabura = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemGamanoabura").setTextureName("dqr:Gamanoabura");
		DQMiscs.itemHananomitu = new DqmItemFoodMiscBase(2, 0.2F, false).setHealPoint(-1, -1, 5, 10).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemHananomitu").setTextureName("dqr:Hananomitu");
		DQMiscs.itemHebinonukegara = new DqmItemFoodMiscBase(2, 0.2F, false).setHealPoint(-1, -1, 15, 10).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemHebinonukegara").setTextureName("dqr:Hebinonukegara");
		DQMiscs.itemHonehone = new DqmItemFoodMiscBase(2, 0.0F, true).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemHonehone").setTextureName("dqr:Honehone");
		DQMiscs.itemKoumorinohane = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKoumorinohane").setTextureName("dqr:Koumorinohane");
		DQMiscs.itemMadarakumonoito = new DqmItemFoodMiscBase(1, 0.0F, false).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMadarakumonoito").setTextureName("dqr:Madarakumonoito");
		DQMiscs.itemMajuunokawa = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMajuunokawa").setTextureName("dqr:Majuunokawa");
		DQMiscs.itemMajuunotuno = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMajuunotuno").setTextureName("dqr:Majuunotuno");
		DQMiscs.itemMidorinokoke = new DqmItemFoodMiscBase(1, 0.2F, false).setHealPoint(1.0F, 3, -1, -1).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMidorinokoke").setTextureName("dqr:Midorinokoke");
		DQMiscs.itemNebanebazeri = new DqmItemFoodMiscBase(2, 0.2F, false).setHealPoint(3.0F, 5, -1, -1).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemNebanebazeri").setTextureName("dqr:Nebanebazeri");
		DQMiscs.itemNekozuna = new DqmItemFoodMiscBase(1, 0.1F, false).setHealPoint(-1, -1, 1, 5).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemNekozuna").setTextureName("dqr:Nekozuna");
		DQMiscs.itemTiisaitamasii = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTiisaitamasii").setTextureName("dqr:Tiisaitamasii");
		DQMiscs.itemSiroikaigara = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSiroikaigara").setTextureName("dqr:Siroikaigara");
		DQMiscs.itemSuraimuosyarebana = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSuraimuosyarebana").setTextureName("dqr:Suraimuosyarebana");
		DQMiscs.itemSuraimuzeri = new DqmItemFoodMiscBase(2, 0.2F, false).setHealPoint(1.0F, 3, -1, -1).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSuraimuzeri").setTextureName("dqr:Suraimuzeri");
		DQMiscs.itemTetunokugi = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTetunokugi").setTextureName("dqr:Tetunokugi");
		DQMiscs.itemTukemonoisi = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTukemonoisi").setTextureName("dqr:Tukemonoisi");
		DQMiscs.itemTyounohane = new DqmItemFoodMiscBase(2, 0.1F, false).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTyounohane").setTextureName("dqr:Tyounohane");
		DQMiscs.itemUmanofun = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemUmanofun").setTextureName("dqr:Umanofun");
		DQMiscs.itemUsaginosippo = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemUsaginosippo").setTextureName("dqr:Usaginosippo");
		DQMiscs.itemUsinofun = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemUsinofun").setTextureName("dqr:Usinofun");
		DQMiscs.itemYawarakauru = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemYawarakauru").setTextureName("dqr:Yawarakauru");
		DQMiscs.itemDokuganokona = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDokuganokona").setTextureName("dqr:Dokuganokona");
		DQMiscs.itemSeisui = new DqmItemThrowBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSeisui").setTextureName("dqr:Seisui");
		DQMiscs.itemBudouekisu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemBudouekisu").setTextureName("dqr:Budouekisu");
		DQMiscs.itemHaganenoobane = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemHaganenoobane").setTextureName("dqr:Haganenoobane");
		DQMiscs.itemHyoutyounohane = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemHyoutyounohane").setTextureName("dqr:Hyoutyounohane");
		DQMiscs.itemJuryokunomoto = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemJuryokunomoto").setTextureName("dqr:Juryokunomoto");
		DQMiscs.itemKazekirinohane = new DqmItemFoodMiscBase(0, 0.0F, false).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKazekirinohane").setTextureName("dqr:Kazekirinohane");
		DQMiscs.itemKimeranotubasa = new DqmItemKimera(EnumDqmMagic.Rura).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasa").setTextureName("dqr:Kimeranotubasa");
		DQMiscs.itemKimeranotubasaB = new DqmItemKimera(EnumDqmMagic.RuraB).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasaB").setTextureName("dqr:KimeranotubasaB");
		DQMiscs.itemKimeranotubasaG = new DqmItemKimera(EnumDqmMagic.RuraG).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasaG").setTextureName("dqr:KimeranotubasaG");
		DQMiscs.itemKimeranotubasaR = new DqmItemKimera(EnumDqmMagic.RuraR).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasaR").setTextureName("dqr:KimeranotubasaR");
		DQMiscs.itemKimeranotubasaY = new DqmItemKimera(EnumDqmMagic.RuraY).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasaY").setTextureName("dqr:KimeranotubasaY");

		DQMiscs.itemKimeranotubasa2 = new DqmItemKimera2(EnumDqmMagic.Rura2).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasa2").setTextureName("dqr:Kimeranotubasa");
		DQMiscs.itemKimeranotubasa2B = new DqmItemKimera2(EnumDqmMagic.RuraB2).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasa2B").setTextureName("dqr:KimeranotubasaB");
		DQMiscs.itemKimeranotubasa2G = new DqmItemKimera2(EnumDqmMagic.RuraG2).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasa2G").setTextureName("dqr:KimeranotubasaG");
		DQMiscs.itemKimeranotubasa2R = new DqmItemKimera2(EnumDqmMagic.RuraR2).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasa2R").setTextureName("dqr:KimeranotubasaR");
		DQMiscs.itemKimeranotubasa2Y = new DqmItemKimera2(EnumDqmMagic.RuraY2).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasa2Y").setTextureName("dqr:KimeranotubasaY");

		DQMiscs.itemKimeranotubasaC = new DqmItemKimeraC(EnumDqmMagic.RuraC).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasaC").setTextureName("dqr:Kimeranotubasa2");
		DQMiscs.itemKimeranotubasaCB = new DqmItemKimeraC(EnumDqmMagic.RuraBC).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasaCB").setTextureName("dqr:Kimeranotubasa2B");
		DQMiscs.itemKimeranotubasaCG = new DqmItemKimeraC(EnumDqmMagic.RuraGC).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasaCG").setTextureName("dqr:Kimeranotubasa2G");
		DQMiscs.itemKimeranotubasaCR = new DqmItemKimeraC(EnumDqmMagic.RuraRC).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasaCR").setTextureName("dqr:Kimeranotubasa2R");
		DQMiscs.itemKimeranotubasaCY = new DqmItemKimeraC(EnumDqmMagic.RuraYC).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasaCY").setTextureName("dqr:Kimeranotubasa2Y");
		//itemKimeranotubasaC = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKimeranotubasa2").setTextureName("dqr:Kimeranotubasa2");

		DQMiscs.itemKiyomenomizu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKiyomenomizu").setTextureName("dqr:Kiyomenomizu");
		DQMiscs.itemKyodaihigetokage = new DqmItemFoodMiscBase(3, 0.2F, false).setHealPoint(-1, -1, 18, 10).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKyodaihigetokage").setTextureName("dqr:Kyodaihigetokage");
		DQMiscs.itemKyodainakiba = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKyodainakiba").setTextureName("dqr:Kyodainakiba");
		DQMiscs.itemMeijikimeranohane = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMeijikimeranohane").setTextureName("dqr:Meijikimeranohane");
		DQMiscs.itemRengokunohane = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemRengokunohane").setTextureName("dqr:Rengokunohane");
		DQMiscs.itemRisaikurusuton = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemRisaikurusuton").setTextureName("dqr:Risaikurusuton");
		DQMiscs.itemTensinohane = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTensinohane").setTextureName("dqr:Tensinohane");
		DQMiscs.itemTogetogenokiba = new DqmItemFoodMiscBase(2, 0.1F, false).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTogetogenokiba").setTextureName("dqr:Togetogenokiba");
		DQMiscs.itemUruwasikinoko = new DqmItemFoodMiscBase(4, 0.4F, false).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemUruwasikinoko").setTextureName("dqr:Uruwasikinoko");
		DQMiscs.itemYogoretahoutai = new DqmItemFoodMiscBase(1, 0.0F, false).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemYogoretahoutai").setTextureName("dqr:Yogoretahoutai");
		DQMiscs.itemYorunotobari = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemYorunotobari").setTextureName("dqr:Yorunotobari");
		DQMiscs.itemAyakasisou = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemAyakasisou").setTextureName("dqr:Ayakasisou");
		DQMiscs.itemAyasiikobin = new DqmItemFoodMiscBase(4, 0.1F, false).setHealPoint(-1, -1, 70, 20).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemAyasiikobin").setTextureName("dqr:Ayasiikobin");
		DQMiscs.itemBekkou = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemBekkou").setTextureName("dqr:Bekkou");
		DQMiscs.itemIkazutinotama = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemIkazutinotama").setTextureName("dqr:Ikazutinotama");
		DQMiscs.itemKingdaiya = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKingdaiya").setTextureName("dqr:Kingdaiya");
		DQMiscs.itemKinkai = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKinkai").setTextureName("dqr:Kinkai");
		DQMiscs.itemMaryokunotuti = new DqmItemFoodMiscBase(1, 0.2F, false).setHealPoint(-1, -1, 10, 10).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMaryokunotuti").setTextureName("dqr:Maryokunotuti");
		DQMiscs.itemMetaru = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMetaru").setTextureName("dqr:Metaru");
		DQMiscs.itemPisaronotamasii = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemPisaronotamasii").setTextureName("dqr:Pisaronotamasii");
		DQMiscs.itemSaezurinomitu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSaezurinomitu").setTextureName("dqr:Saezurinomitu");
		DQMiscs.itemSeijanohai = new DqmItemFoodMiscBase(2, 0.1F, false).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSeijanohai").setTextureName("dqr:Seijanohai");
		DQMiscs.itemSeinarusizuku = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSeinarusizuku").setTextureName("dqr:Seinarusizuku");
		DQMiscs.itemTukinomegumi = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTukinomegumi").setTextureName("dqr:Tukinomegumi");
		DQMiscs.itemAmatuyunoito = new DqmItemFoodMiscBase(10, 1.0F, false).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemAmatuyunoito").setTextureName("dqr:Amatuyunoito");
		DQMiscs.itemTensinosoma = new DqmItemFoodMiscBase(4, 0.1F, false).setHealPoint(-1, -1, 100, 50).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTensinosoma").setTextureName("dqr:Tensinosoma");
		DQMiscs.itemDoragonnonamida = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDoragonnonamida").setTextureName("dqr:Doragonnonamida");
		DQMiscs.itemGenmaseki = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemGenmaseki").setTextureName("dqr:Genmaseki");
		DQMiscs.itemKenjanoisi = new DqmItemKenjanoisi().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKenjanoisi").setTextureName("dqr:Kenjanoisi");
		DQMiscs.itemNijiirononunokire = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemNijiirononunokire").setTextureName("dqr:Nijiirononunokire");
		DQMiscs.itemRyuunohizake = new DqmItemFoodMiscBase(3, 0.3F, false).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemRyuunohizake").setTextureName("dqr:Ryuunohizake");
		DQMiscs.itemRyuunonamida = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemRyuunonamida").setTextureName("dqr:Ryuunonamida");
		DQMiscs.itemSeireiseki = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSeireiseki").setTextureName("dqr:Seireiseki");
		DQMiscs.itemSinkanohiseki = new DqmItemThrowBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSinkanohiseki").setTextureName("dqr:Sinkanohiseki");
		DQMiscs.itemToukonekisu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemToukonekisu").setTextureName("dqr:Toukonekisu");
		DQMiscs.itemUraminohouju = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemUraminohouju").setTextureName("dqr:Uraminohouju");
		DQMiscs.itemDragonwing = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDragonwing").setTextureName("dqr:Dragonwing");
		DQMiscs.itemPapasunokatami = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemPapasunokatami").setTextureName("dqr:Papasunokatami");
		DQMiscs.itemSekaijunoha = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSekaijunoha").setTextureName("dqr:Sekaijunoha");
		DQMiscs.itemBuruoubu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemBuruoubu").setTextureName("dqr:Buruoubu");
		DQMiscs.itemGenmasekiB = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemGenmasekiB").setTextureName("dqr:GenmasekiB");
		DQMiscs.itemGenmasekiG = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemGenmasekiG").setTextureName("dqr:GenmasekiG");
		DQMiscs.itemGurinoubu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemGurinoubu").setTextureName("dqr:Gurinoubu");
		DQMiscs.itemHepaitosunohidane = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemHepaitosunohidane").setTextureName("dqr:Hepaitosunohidane");
		DQMiscs.itemHokoranokagi = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemHokoranokagi").setTextureName("dqr:Hokoranokagi");
		DQMiscs.itemIerooubu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemIerooubu").setTextureName("dqr:Ierooubu");
		DQMiscs.itemMetaloubu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMetaloubu").setTextureName("dqr:Metaloubu");
		DQMiscs.itemMysteryEgg = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMysteryEgg").setTextureName("dqr:MysteryEgg");
		DQMiscs.itemPaapuruoubu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemPaapuruoubu").setTextureName("dqr:Paapuruoubu");
		DQMiscs.itemRamia = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemRamia").setTextureName("dqr:Ramia");
		DQMiscs.itemRedoubu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemRedoubu").setTextureName("dqr:Redoubu");
		DQMiscs.itemRozarinonamida = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemRozarinonamida").setTextureName("dqr:Rozarinonamida");
		DQMiscs.itemSaigonokagi = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSaigonokagi").setTextureName("dqr:Saigonokagi");
		DQMiscs.itemTouzokunokagi = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTouzokunokagi").setTextureName("dqr:Touzokunokagi");
		DQMiscs.itemMahounokagi = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMahounokagi").setTextureName("dqr:Mahounokagi");
		DQMiscs.itemKenjanoseisui = new DqmItemFoodMiscBase(4, 0.1F, false).setHealPoint(-1, -1,  40, 20).setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKenjanoseisui").setTextureName("dqr:Kenjanoseisui");

		DQMiscs.itemBougu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemBougu").setTextureName("dqr:Bougu");
		DQMiscs.itemDensetu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDensetu").setTextureName("dqr:Densetu");
		DQMiscs.itemHakai = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemHakai").setTextureName("dqr:Hakai");
		DQMiscs.itemHonooRyuu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemHonooRyuu").setTextureName("dqr:HonooRyuu");
		DQMiscs.itemKenTanken = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKenTanken").setTextureName("dqr:KenTanken");
		DQMiscs.itemTanken = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTanken").setTextureName("dqr:Tanken");
		DQMiscs.itemKooriMetaru = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKooriMetaru").setTextureName("dqr:KooriMetaru");
		//DQMiscs.itemMetaruR = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKooriMetaruR").setTextureName("dqr:MetaruR");
		DQMiscs.itemMahou = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMahou").setTextureName("dqr:Mahou");
		DQMiscs.itemMaJu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMaJu").setTextureName("dqr:MaJu");
		//DQMiscs.itemJu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemJu").setTextureName("dqr:Ju");
		DQMiscs.itemOnoTutiKon = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemOnoTutiKon").setTextureName("dqr:OnoTutiKon");
		DQMiscs.itemTuti = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTuti").setTextureName("dqr:Tuti");
		DQMiscs.itemKon = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKon").setTextureName("dqr:Kon");
		DQMiscs.itemTenkuu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTenkuu").setTextureName("dqr:Tenkuu");
		DQMiscs.itemYariMutiTume = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemYariMutiTume").setTextureName("dqr:YariMutiTume");
		DQMiscs.itemMuti = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMuti").setTextureName("dqr:Muti");
		DQMiscs.itemTume = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemTume").setTextureName("dqr:Tume");
		DQMiscs.itemYumiNage = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemYumiNage").setTextureName("dqr:YumiNage");
		DQMiscs.itemNage = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemNage").setTextureName("dqr:Nage");

		DQMiscs.itemOugiR = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemOugiR").setTextureName("dqr:OugiR");
		DQMiscs.itemSorobanR = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSorobanR").setTextureName("dqr:SorobanR");

		DQMiscs.itemYamatanooroti = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemYamatanooroti").setTextureName("dqr:Yamatanooroti");
		DQMiscs.itemRyuuou = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemRyuuou").setTextureName("dqr:Ryuuou");
		DQMiscs.itemKiramajinga = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemKiramajinga").setTextureName("dqr:Kiramajinga");
		DQMiscs.itemNorowaretaturugi = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemNorowaretaturugi").setTextureName("dqr:Norowaretaturugi");
		DQMiscs.itemBazuzu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemBazuzu").setTextureName("dqr:Bazuzu");
		DQMiscs.itemSuraimujeneraru = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSuraimujeneraru").setTextureName("dqr:Suraimujeneraru");
		DQMiscs.itemDarkRamia = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDarkRamia").setTextureName("dqr:DarkRamia");
		DQMiscs.itemZoma = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemZoma").setTextureName("dqr:Zoma");
		DQMiscs.itemDesupisaro = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDesupisaro").setTextureName("dqr:Desupisaro");
		DQMiscs.itemMasterdoragon = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMasterdoragon").setTextureName("dqr:Masterdoragon");
		DQMiscs.itemEsterk = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemEsterk").setTextureName("dqr:Esterk");

		//itemMe = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemMe").setTextureName("dqr:Me");
		DQMiscs.itemHissatuAs = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuAs").setTextureName("dqr:HissatuAs");
		DQMiscs.itemHissatuSe = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuSe").setTextureName("dqr:HissatuSe");
		DQMiscs.itemHissatuBu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuBu").setTextureName("dqr:HissatuBu");
		DQMiscs.itemHissatuBa = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuBa").setTextureName("dqr:HissatuBa");
		DQMiscs.itemHissatuMa = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuMa").setTextureName("dqr:HissatuMa");
		DQMiscs.itemHissatuSo = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuSo").setTextureName("dqr:HissatuSo");
		DQMiscs.itemHissatuKe = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuKe").setTextureName("dqr:HissatuKe");
		DQMiscs.itemHissatuYu = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuYu").setTextureName("dqr:HissatuYu");
		DQMiscs.itemHissatuPa = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuPa").setTextureName("dqr:HissatuPa");
		DQMiscs.itemHissatuMk = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuMk").setTextureName("dqr:HissatuMk");
		DQMiscs.itemHissatuRe = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabAcc).setUnlocalizedName("dqm.itemHissatuRe").setTextureName("dqr:HissatuRe");

		DQMiscs.itemMagicbook = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMagicbook").setTextureName("dqr:Magicbook");
		DQMiscs.itemMagicbook2 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMagicbook2").setTextureName("dqr:Magicbook2");
		DQMiscs.itemMagicbook3 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemMagicbook3").setTextureName("dqr:Magicbook3");
		DQMiscs.itemSkillbook = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemSkillbook").setTextureName("dqr:Skillbook");


		DQMiscs.itemFarmBook = new DqmItemFarmBook().setTextureName("dqr:FarmBook").setUnlocalizedName("dqm.itemFarmBook").setCreativeTab(CreativeTabs.tabMisc);
		DQMiscs.itemShinjirukokoro = new DqmItemShinjirukokoro().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemShinjirukokoro").setTextureName("dqr:Shinjirukokoro");
		DQMiscs.itemPetbook = new DqmItemPetbook().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemPetbook").setTextureName("dqr:PetSkillbook");

		//植物
		DQSeeds.itemYakusouSeed = new DqmItemSeedBase(DQPlants.BlockYakusouSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemYakusouSeed").setTextureName("dqr:YakusouSeed");
		DQSeeds.itemYakusouSeed2 = new DqmItemSeedBase(DQPlants.BlockYakusouSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemYakusouSeed2").setTextureName("dqr:YakusouSeed2");
		DQSeeds.itemYakusouSeed3 = new DqmItemSeedBase(DQPlants.BlockYakusouSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemYakusouSeed3").setTextureName("dqr:YakusouSeed3");
		DQSeeds.itemDokukesisouSeed = new DqmItemSeedBase(DQPlants.BlockDokukesisouSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemDokukesisouSeed").setTextureName("dqr:DokukesisouSeed");
		DQSeeds.itemDokukesisouSeed2 = new DqmItemSeedBase(DQPlants.BlockDokukesisouSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemDokukesisouSeed2").setTextureName("dqr:DokukesisouSeed2");
		DQSeeds.itemDokukesisouSeed3 = new DqmItemSeedBase(DQPlants.BlockDokukesisouSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemDokukesisouSeed3").setTextureName("dqr:DokukesisouSeed3");
		DQSeeds.itemTikaraSeed = new DqmItemSeedBase(DQPlants.BlockTikaraSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemTikaraSeed").setTextureName("dqr:TikaraSeed");
		DQSeeds.itemTikaraSeed2 = new DqmItemSeedBase(DQPlants.BlockTikaraSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemTikaraSeed2").setTextureName("dqr:TikaraSeed2");
		DQSeeds.itemTikaraSeed3 = new DqmItemSeedBase(DQPlants.BlockTikaraSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemTikaraSeed3").setTextureName("dqr:TikaraSeed3");
		DQSeeds.itemMamoriSeed = new DqmItemSeedBase(DQPlants.BlockMamoriSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMamoriSeed").setTextureName("dqr:MamoriSeed");
		DQSeeds.itemMamoriSeed2 = new DqmItemSeedBase(DQPlants.BlockMamoriSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMamoriSeed2").setTextureName("dqr:MamoriSeed2");
		DQSeeds.itemMamoriSeed3 = new DqmItemSeedBase(DQPlants.BlockMamoriSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMamoriSeed3").setTextureName("dqr:MamoriSeed3");
		DQSeeds.itemSubayasaSeed = new DqmItemSeedBase(DQPlants.BlockSubayasaSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemSubayasaSeed").setTextureName("dqr:SubayasaSeed");
		DQSeeds.itemSubayasaSeed2 = new DqmItemSeedBase(DQPlants.BlockSubayasaSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemSubayasaSeed2").setTextureName("dqr:SubayasaSeed2");
		DQSeeds.itemSubayasaSeed3 = new DqmItemSeedBase(DQPlants.BlockSubayasaSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemSubayasaSeed3").setTextureName("dqr:SubayasaSeed3");
		DQSeeds.itemHonooSeed = new DqmItemSeedBase(DQPlants.BlockHonooSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemHonooSeed").setTextureName("dqr:HonooSeed");
		DQSeeds.itemHonooSeed2 = new DqmItemSeedBase(DQPlants.BlockHonooSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemHonooSeed2").setTextureName("dqr:HonooSeed2");
		DQSeeds.itemHonooSeed3 = new DqmItemSeedBase(DQPlants.BlockHonooSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemHonooSeed3").setTextureName("dqr:HonooSeed3");
		DQSeeds.itemIyasiSeed = new DqmItemSeedBase(DQPlants.BlockIyasiSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemIyasiSeed").setTextureName("dqr:IyasiSeed");
		DQSeeds.itemIyasiSeed2 = new DqmItemSeedBase(DQPlants.BlockIyasiSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemIyasiSeed2").setTextureName("dqr:IyasiSeed2");
		DQSeeds.itemIyasiSeed3 = new DqmItemSeedBase(DQPlants.BlockIyasiSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemIyasiSeed3").setTextureName("dqr:IyasiSeed3");
		DQSeeds.itemMahounomiseed = new DqmItemSeedBase(DQPlants.BlockMahounomiSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMahounomiseed").setTextureName("dqr:Mahounomiseed");
		DQSeeds.itemMahounomiseed2 = new DqmItemSeedBase(DQPlants.BlockMahounomiSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMahounomiseed2").setTextureName("dqr:Mahounomiseed2");
		DQSeeds.itemMahounomiseed3 = new DqmItemSeedBase(DQPlants.BlockMahounomiSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMahounomiseed3").setTextureName("dqr:Mahounomiseed3");
		DQSeeds.itemMaryokunotaneseed = new DqmItemSeedBase(DQPlants.BlockMaryokunotaneSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMaryokunotaneseed").setTextureName("dqr:Maryokunotaneseed");
		DQSeeds.itemMaryokunotaneseed2 = new DqmItemSeedBase(DQPlants.BlockMaryokunotaneSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMaryokunotaneseed2").setTextureName("dqr:Maryokunotaneseed2");
		DQSeeds.itemMaryokunotaneseed3 = new DqmItemSeedBase(DQPlants.BlockMaryokunotaneSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMaryokunotaneseed3").setTextureName("dqr:Maryokunotaneseed3");
		DQSeeds.itemOugonSeed = new DqmItemSeedBase(DQPlants.BlockOugonSeed1, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemOugonSeed").setTextureName("dqr:OugonSeed");
		DQSeeds.itemOugonSeed2 = new DqmItemSeedBase(DQPlants.BlockOugonSeed2, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemOugonSeed2").setTextureName("dqr:OugonSeed2");
		DQSeeds.itemOugonSeed3 = new DqmItemSeedBase(DQPlants.BlockOugonSeed3, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemOugonSeed3").setTextureName("dqr:OugonSeed3");
		DQSeeds.itemOugonSeed4 = new DqmItemSeedBase(DQPlants.BlockOugonSeed4, Blocks.farmland).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemOugonSeed4").setTextureName("dqr:OugonSeed4");

		DQSeeds.itemBannouyaku = new DqmItemFoodSeedBase(2, 0.3F, false).setHealPoint(30.0F, 10, -1, -1).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemBannouyaku").setTextureName("dqr:Bannouyaku");
		DQSeeds.itemJouyakusou = new DqmItemFoodSeedBase(4, 0.3F, false).setHealPoint(40.0F, 10, -1, -1).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemJouyakusou").setTextureName("dqr:Jouyakusou");
		DQSeeds.itemTokuyakusou = new DqmItemFoodSeedBase(8, 0.3F,false).setHealPoint(70.0F, 20, -1, -1).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemTokuyakusou").setTextureName("dqr:Tokuyakusou");
		DQSeeds.itemYakusou = new DqmItemFoodSeedBase(4, 0.4F, false).setHealPoint(8.0F, 5, -1, -1).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemYakusou").setTextureName("dqr:Yakusou");
		DQSeeds.itemYakusou2 = new DqmItemFoodSeedBase(6, 0.3F, false).setHealPoint(35.0F, 20, -1, -1).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemYakusou2").setTextureName("dqr:Yakusou2");
		DQSeeds.itemYakusou3 = new DqmItemFoodSeedBase(8, 0.2F, false).setHealPoint(60.0F, 40, -1, -1).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemYakusou3").setTextureName("dqr:Yakusou3");
		DQSeeds.itemDokukesisou = new DqmItemFoodSeedBase(4, 0.4F, false).setHealPoint(0.0F, 5, -1, -1).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemDokukesisou").setTextureName("dqr:Dokukesisou");
		DQSeeds.itemDokukesisou2 = new DqmItemFoodSeedBase(6, 0.3F, false).setHealPoint(10.0F, 10, -1, -1).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemDokukesisou2").setTextureName("dqr:Dokukesisou2");
		DQSeeds.itemDokukesisou3 = new DqmItemFoodSeedBase(8, 0.2F, false).setHealPoint(20.0F, 10, -1, -1).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemDokukesisou3").setTextureName("dqr:Dokukesisou3");
		DQSeeds.itemTikaranotane = new DqmItemFoodSeedBase(2, 0.3F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemTikaranotane").setTextureName("dqr:Tikaranotane");
		DQSeeds.itemTikaranotane2 = new DqmItemFoodSeedBase(3, 0.2F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemTikaranotane2").setTextureName("dqr:Tikaranotane2");
		DQSeeds.itemTikaranotane3 = new DqmItemFoodSeedBase(4, 0.1F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemTikaranotane3").setTextureName("dqr:Tikaranotane3");
		DQSeeds.itemMamorinotane = new DqmItemFoodSeedBase(2, 0.3F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMamorinotane").setTextureName("dqr:Mamorinotane");
		DQSeeds.itemMamorinotane2 = new DqmItemFoodSeedBase(3, 0.2F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMamorinotane2").setTextureName("dqr:Mamorinotane2");
		DQSeeds.itemMamorinotane3 = new DqmItemFoodSeedBase(4, 0.1F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMamorinotane3").setTextureName("dqr:Mamorinotane3");
		DQSeeds.itemSubayasanotane = new DqmItemFoodSeedBase(2, 0.3F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemSubayasanotane").setTextureName("dqr:Subayasanotane");
		DQSeeds.itemSubayasanotane2 = new DqmItemFoodSeedBase(3, 0.2F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemSubayasanotane2").setTextureName("dqr:Subayasanotane2");
		DQSeeds.itemSubayasanotane3 = new DqmItemFoodSeedBase(4, 0.1F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemSubayasanotane3").setTextureName("dqr:Subayasanotane3");
		DQSeeds.itemHonoonomi = new DqmItemFoodSeedBase(4, 0.6F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemHonoonomi").setTextureName("dqr:Honoonomi");
		DQSeeds.itemHonoonomi2 = new DqmItemFoodSeedBase(6, 0.5F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemHonoonomi2").setTextureName("dqr:Honoonomi2");
		DQSeeds.itemHonoonomi3 = new DqmItemFoodSeedBase(10, 0.4F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemHonoonomi3").setTextureName("dqr:Honoonomi3");
		DQSeeds.itemIyasinomi = new DqmItemFoodSeedBase(6, 0.7F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemIyasinomi").setTextureName("dqr:Iyasinomi");
		DQSeeds.itemIyasinomi2 = new DqmItemFoodSeedBase(8, 0.6F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemIyasinomi2").setTextureName("dqr:Iyasinomi2");
		DQSeeds.itemIyasinomi3 = new DqmItemFoodSeedBase(10, 0.5F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemIyasinomi3").setTextureName("dqr:Iyasinomi3");
		DQSeeds.itemMahounomiI = new DqmItemFoodSeedBase(4, 0.6F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMahounomiI").setTextureName("dqr:MahounomiI");
		DQSeeds.itemMahounomiI2 = new DqmItemFoodSeedBase(6, 0.5F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMahounomiI2").setTextureName("dqr:MahounomiI2");
		DQSeeds.itemMahounomiI3 = new DqmItemFoodSeedBase(8, 0.5F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMahounomiI3").setTextureName("dqr:MahounomiI3");
		DQSeeds.itemMaryokunotaneI = new DqmItemFoodSeedBase(2, 0.3F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMaryokunotaneI").setTextureName("dqr:MaryokunotaneI");
		DQSeeds.itemMaryokunotaneI2 = new DqmItemFoodSeedBase(3, 0.2F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMaryokunotaneI2").setTextureName("dqr:MaryokunotaneI2");
		DQSeeds.itemMaryokunotaneI3 = new DqmItemFoodSeedBase(4, 0.1F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemMaryokunotaneI3").setTextureName("dqr:MaryokunotaneI3");
		DQSeeds.itemOugon = new DqmItemFoodSeedBase(4, 0.8F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemOugon").setTextureName("dqr:Ougon");
		DQSeeds.itemOugon2 = new DqmItemFoodSeedBase(6, 0.6F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemOugon2").setTextureName("dqr:Ougon2");
		DQSeeds.itemOugon3 = new DqmItemFoodSeedBase(8, 0.5F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemOugon3").setTextureName("dqr:Ougon3");
		DQSeeds.itemOugon4 = new DqmItemFoodSeedBase(14, 0.1F, false).setCreativeTab(DQR.tabs.DqmTabPlant).setUnlocalizedName("dqm.itemOugon4").setTextureName("dqr:Ougon4");



		//武器

		DQWeapons.itemDebugsword = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 100.0F, 110).setUnlocalizedName("dqm.itemDebugsword").setTextureName("dqr:Debugsword").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemBsword1 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmVanillaS) , 3.0F, 180).setUnlocalizedName("dqm.itemBsword1").setTextureName("dqr:Bsword1").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemBsword2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmVanillaS) , 4.0F, 400).setUnlocalizedName("dqm.itemBsword2").setTextureName("dqr:Bsword2").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemBsword3 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmVanillaS) , 5.0F, 800).setUnlocalizedName("dqm.itemBsword3").setTextureName("dqr:Bsword3").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemBsword4 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmVanillaS) , 12.0F, 200).setUnlocalizedName("dqm.itemBsword4").setTextureName("dqr:Bsword4").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemBsword5 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmVanillaS) , 7.0F, 4500).setUnlocalizedName("dqm.itemBsword5").setTextureName("dqr:Bsword5").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemSabitarotonoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmBraveSword) , 6.0F, 250).setUnlocalizedName("dqm.itemSabitarotonoturugi").setTextureName("dqr:Sabitarotonoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemPapasunoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmBraveSword) , 25.0F, 1600).setUnlocalizedName("dqm.itemPapasunoturugi").setTextureName("dqr:Papasunoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemPapasunoturuginew = new DqmItemWeaponBase((DQR.dqmMaterial.DqmBraveSword) , 27.0F, 3000).setUnlocalizedName("dqm.itemPapasunoturuginew").setTextureName("dqr:Papasunoturuginew").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemOujanoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmBraveSword) , 30.0F, 2000).setUnlocalizedName("dqm.itemOujanoturugi").setTextureName("dqr:Oujanoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemRotonoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmBraveSword) , 38.0F, 5000).setUnlocalizedName("dqm.itemRotonoturugi").setTextureName("dqr:Rotonoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTenkuunoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmBraveSword) , 40.0F, 7500).setUnlocalizedName("dqm.itemTenkuunoturugi").setTextureName("dqr:Tenkuunoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSinken = new DqmItemWeaponBase((DQR.dqmMaterial.DqmBraveSword) , 42.0F, 10000).setUnlocalizedName("dqm.itemSinken").setTextureName("dqr:Sinken").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSinken2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmBraveSword) , 42.0F, 10000).setUnlocalizedName("dqm.itemSinken2").setTextureName("dqr:Sinken2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemHayabusanoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 1.0F, 2500).setUnlocalizedName("dqm.itemHayabusanoturugi").setTextureName("dqr:Hayabusanoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDounoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 2.0F, 250).setUnlocalizedName("dqm.itemDounoturugi").setTextureName("dqr:Dounoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHeisinoken = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 3.0F, 350).setUnlocalizedName("dqm.itemHeisinoken").setTextureName("dqr:Heisinoken").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHaganenoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 6.0F, 750).setUnlocalizedName("dqm.itemHaganenoturugi").setTextureName("dqr:Haganenoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKoorinoyaiba = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 8.0F, 1000).setUnlocalizedName("dqm.itemKoorinoyaiba").setTextureName("dqr:Koorinoyaiba").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHajanoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 9.0F, 1500).setUnlocalizedName("dqm.itemHajanoturugi").setTextureName("dqr:Hajanoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDoragonkira = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 10.0F, 1300).setUnlocalizedName("dqm.itemDoragonkira").setTextureName("dqr:Doragonkira").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemInferunosword = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 12.0F, 2500).setUnlocalizedName("dqm.itemInferunosword").setTextureName("dqr:Inferunosword").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKisekinoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 16.0F, 5000).setUnlocalizedName("dqm.itemKisekinoturugi").setTextureName("dqr:Kisekinoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMinagorosinoken = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 18.0F, 1000).setUnlocalizedName("dqm.itemMinagorosinoken").setTextureName("dqr:Minagorosinoken").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMorohanoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 25.0F, 1500).setUnlocalizedName("dqm.itemMorohanoturugi").setTextureName("dqr:Morohanoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMakainoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 25.0F, 6000).setUnlocalizedName("dqm.itemMakainoturugi").setTextureName("dqr:Makainoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMetarukingnoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 28.0F, 15000).setUnlocalizedName("dqm.itemMetarukingnoturugi").setTextureName("dqr:Metarukingnoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSuiseinoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 31.0F, 7500).setUnlocalizedName("dqm.itemSuiseinoturugi").setTextureName("dqr:Suiseinoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemGinganoturugi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 35.0F, 9000).setUnlocalizedName("dqm.itemGinganoturugi").setTextureName("dqr:Ginganoturugi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMakenreipia = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 14.0F, 4000).setUnlocalizedName("dqm.itemMakenreipia").setTextureName("dqr:Makenreipia").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemReipia = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 5.0F, 500).setUnlocalizedName("dqm.itemReipia").setTextureName("dqr:Reipia").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSanzokusaberu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 11.0F, 1500).setUnlocalizedName("dqm.itemSanzokusaberu").setTextureName("dqr:Sanzokusaberu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemGinganoturugi2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSword) , 35.0F, 10000).setUnlocalizedName("dqm.itemGinganoturugi2").setTextureName("dqr:Ginganoturugi2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemToraidento = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 7.0F, 1000).setUnlocalizedName("dqm.itemToraidento").setTextureName("dqr:Toraidento").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemInazumanoyari = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 13.0F, 2500).setUnlocalizedName("dqm.itemInazumanoyari").setTextureName("dqr:Inazumanoyari").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDemonsupia = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 17.0F, 5000).setUnlocalizedName("dqm.itemDemonsupia").setTextureName("dqr:Demonsupia").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemJigokumasou = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 22.0F, 7500).setUnlocalizedName("dqm.itemJigokumasou").setTextureName("dqr:Jigokumasou").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemEiyuunoyari = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 26.0F, 10000).setUnlocalizedName("dqm.itemEiyuunoyari").setTextureName("dqr:Eiyuunoyari").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMetarukingnoyari = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 31.0F, 12000).setUnlocalizedName("dqm.itemMetarukingnoyari").setTextureName("dqr:Metarukingnoyari").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemGurakosunoyari = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 20.0F, 6000).setUnlocalizedName("dqm.itemGurakosunoyari").setTextureName("dqr:Gurakosunoyari").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHaganenoyari = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 9.0F, 1250).setUnlocalizedName("dqm.itemHaganenoyari").setTextureName("dqr:Haganenoyari").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHaruberuto = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 11.0F, 1500).setUnlocalizedName("dqm.itemHaruberuto").setTextureName("dqr:Haruberuto").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHoriransu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 15.0F, 4000).setUnlocalizedName("dqm.itemHoriransu").setTextureName("dqr:Horiransu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMonosasizao = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 3.0F, 150).setUnlocalizedName("dqm.itemMonosasizao").setTextureName("dqr:Monosasizao").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTakenoyari = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 5.0F, 250).setUnlocalizedName("dqm.itemTakenoyari").setTextureName("dqr:Takenoyari").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTetunoyari = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 6.0F, 500).setUnlocalizedName("dqm.itemTetunoyari").setTextureName("dqr:Tetunoyari").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMetarukingnoyari2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmLance) , 31.0F, 10000).setUnlocalizedName("dqm.itemMetarukingnoyari2").setTextureName("dqr:Metarukingnoyari2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemDokubari = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 1.0F, 1000).setUnlocalizedName("dqm.itemDokubari").setTextureName("dqr:Dokubari").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSeinarunaifu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 5.0F, 500).setUnlocalizedName("dqm.itemSeinarunaifu").setTextureName("dqr:Seinarunaifu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemAsasindaga = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 12.0F, 2000).setUnlocalizedName("dqm.itemAsasindaga").setTextureName("dqr:Asasindaga").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSodobureika = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 15.0F, 3500).setUnlocalizedName("dqm.itemSodobureika").setTextureName("dqr:Sodobureika").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSaramanda = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 23.0F, 7500).setUnlocalizedName("dqm.itemSaramanda").setTextureName("dqr:Saramanda").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemToririondaga = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 26.0F, 9000).setUnlocalizedName("dqm.itemToririondaga").setTextureName("dqr:Toririondaga").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDokuganonaifu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 8.0F, 1250).setUnlocalizedName("dqm.itemDokuganonaifu").setTextureName("dqr:Dokuganonaifu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemGuradiusu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 18.0F, 5000).setUnlocalizedName("dqm.itemGuradiusu").setTextureName("dqr:Guradiusu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKudamononaifu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 3.0F, 250).setUnlocalizedName("dqm.itemKudamononaifu").setTextureName("dqr:Kudamononaifu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKirapiasu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 2.0F, 5000).setUnlocalizedName("dqm.itemKirapiasu").setTextureName("dqr:Kirapiasu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemToririondaga2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmKnife) , 26.0F, 10000).setUnlocalizedName("dqm.itemToririondaga2").setTextureName("dqr:Toririondaga2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemHaganenokon = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 4.0F, 500).setUnlocalizedName("dqm.itemHaganenokon").setTextureName("dqr:Haganenokon").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemReiniroddo = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 9.0F, 1000).setUnlocalizedName("dqm.itemReiniroddo").setTextureName("dqr:Reiniroddo").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemOriharukonbou = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 18.0F, 2500).setUnlocalizedName("dqm.itemOriharukonbou").setTextureName("dqr:Oriharukonbou").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDoragonroddo = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 21.0F, 5000).setUnlocalizedName("dqm.itemDoragonroddo").setTextureName("dqr:Doragonroddo").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemNyoraikon = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 27.0F, 7500).setUnlocalizedName("dqm.itemNyoraikon").setTextureName("dqr:Nyoraikon").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemBusinnokon = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 13.0F, 1500).setUnlocalizedName("dqm.itemBusinnokon").setTextureName("dqr:Businnokon").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDaikokubasira = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 16.0F, 4000).setUnlocalizedName("dqm.itemDaikokubasira").setTextureName("dqr:Daikokubasira").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemRougabou = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 24.0F, 6000).setUnlocalizedName("dqm.itemRougabou").setTextureName("dqr:Rougabou").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTenbinbou = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 3.0F, 250).setUnlocalizedName("dqm.itemTenbinbou").setTextureName("dqr:Tenbinbou").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemNyoraikon2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmRod) , 27.0F, 10000).setUnlocalizedName("dqm.itemNyoraikon2").setTextureName("dqr:Nyoraikon2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemIsinotume = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 4.0F, 250).setEfficiencyOnProper(2.0F).setUnlocalizedName("dqm.itemIsinotume").setTextureName("dqr:Isinotume").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMajuunotume = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 5.0F, 500).setEfficiencyOnProper(3.5F).setUnlocalizedName("dqm.itemMajuunotume").setTextureName("dqr:Majuunotume").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTekkoukagi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 7.0F, 750).setEfficiencyOnProper(5.0F).setUnlocalizedName("dqm.itemTekkoukagi").setTextureName("dqr:Tekkoukagi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemAkumanotume = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 9.0F, 1000).setEfficiencyOnProper(6.5F).setUnlocalizedName("dqm.itemAkumanotume").setTextureName("dqr:Akumanotume").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDorirunakkuru = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 11.0F, 1500).setEfficiencyOnProper(8.0F).setUnlocalizedName("dqm.itemDorirunakkuru").setTextureName("dqr:Dorirunakkuru").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMayokenotume = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 13.0F, 2500).setEfficiencyOnProper(9.5F).setUnlocalizedName("dqm.itemMayokenotume").setTextureName("dqr:Mayokenotume").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHonoonotume = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 15.0F, 4000).setEfficiencyOnProper(11.0F).setUnlocalizedName("dqm.itemHonoonotume").setTextureName("dqr:Honoonotume").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKoorinotume = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 18.0F, 5000).setEfficiencyOnProper(12.5F).setUnlocalizedName("dqm.itemKoorinotume").setTextureName("dqr:Koorinotume").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemOowasinotume = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 24.0F, 6000).setEfficiencyOnProper(14.0F).setUnlocalizedName("dqm.itemOowasinotume").setTextureName("dqr:Oowasinotume").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDoragonkuro = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 28.0F, 6500).setEfficiencyOnProper(15.5F).setUnlocalizedName("dqm.itemDoragonkuro").setTextureName("dqr:Doragonkuro").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSinryuunotume = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 33.0F, 9000).setEfficiencyOnProper(17.0F).setUnlocalizedName("dqm.itemSinryuunotume").setTextureName("dqr:Sinryuunotume").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSinryuunotume2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmClaw) , 33.0F, 10000).setEfficiencyOnProper(18.0F).setUnlocalizedName("dqm.itemSinryuunotume2").setTextureName("dqr:Sinryuunotume2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemKobusi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmFist) , 10.0F, 5000).setUnlocalizedName("dqm.itemKobusi").setTextureName("dqr:Kobusi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKobusi2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmFist) , 15.0F, 5000).setUnlocalizedName("dqm.itemKobusi2").setTextureName("dqr:Kobusi2").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKobusi3 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmFist) , 20.0F, 5000).setUnlocalizedName("dqm.itemKobusi3").setTextureName("dqr:Kobusi3").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKobusi32 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmFist) , 25.0F, 2500).setUnlocalizedName("dqm.itemKobusi32").setTextureName("dqr:Kobusi32").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemKonbou = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer0) , 3.0F, 150).setEfficiencyOnProper(2.0F).setUnlocalizedName("dqm.itemKonbou").setTextureName("dqr:Konbou").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemJaiantokurabu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer0) , 5.0F, 250).setEfficiencyOnProper(3.5F).setUnlocalizedName("dqm.itemJaiantokurabu").setTextureName("dqr:Jaiantokurabu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemWohanma = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer1) , 7.0F, 500).setEfficiencyOnProper(5.0F).setUnlocalizedName("dqm.itemWohanma").setTextureName("dqr:Wohanma").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemOokanaduti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer1) , 9.0F, 1000).setEfficiencyOnProper(6.5F).setUnlocalizedName("dqm.itemOokanaduti").setTextureName("dqr:Ookanaduti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMajinnokanaduti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer1) , 21.0F, 1000).setEfficiencyOnProper(8.0F).setUnlocalizedName("dqm.itemMajinnokanaduti").setTextureName("dqr:Majinnokanaduti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDaitinokanaduti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer1) , 11.0F, 1500).setEfficiencyOnProper(9.5F).setUnlocalizedName("dqm.itemDaitinokanaduti").setTextureName("dqr:Daitinokanaduti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemWohanmakai = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer2) , 13.0F, 2500).setEfficiencyOnProper(11.0F).setUnlocalizedName("dqm.itemWohanmakai").setTextureName("dqr:Wohanmakai").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemOninokanabou = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer2) , 15.0F, 4000).setEfficiencyOnProper(12.5F).setUnlocalizedName("dqm.itemOninokanabou").setTextureName("dqr:Oninokanabou").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemGigakurassya = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer2) , 17.0F, 5000).setEfficiencyOnProper(14.0F).setUnlocalizedName("dqm.itemGigakurassya").setTextureName("dqr:Gigakurassya").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemAtorasunokanaduti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer2) , 17.0F, 7500).setEfficiencyOnProper(15.5F).setUnlocalizedName("dqm.itemAtorasunokanaduti").setTextureName("dqr:Atorasunokanaduti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDaitikudaki = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer3) , 24.0F, 9000).setEfficiencyOnProper(17.0F).setUnlocalizedName("dqm.itemDaitikudaki").setTextureName("dqr:Daitikudaki").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHosikudaki = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer3) , 27.0F, 10000).setEfficiencyOnProper(18.5F).setUnlocalizedName("dqm.itemHosikudaki").setTextureName("dqr:Hosikudaki").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHakainotekkyuu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer3) , 30.0F, 10000).setEfficiencyOnProper(20.0F).setUnlocalizedName("dqm.itemHakainotekkyuu").setTextureName("dqr:Hakainotekkyuu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHakainotekkyuu2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmHammer3) , 30.0F, 10000).setEfficiencyOnProper(21.0F).setUnlocalizedName("dqm.itemHakainotekkyuu2").setTextureName("dqr:Hakainotekkyuu2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemHaganenoono = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 4.0F, 500).setEfficiencyOnProper(2.0F).setUnlocalizedName("dqm.itemHaganenoono").setTextureName("dqr:Haganenoono").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKinoono = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 6.0F, 300).setEfficiencyOnProper(16.0F).setUnlocalizedName("dqm.itemKinoono").setTextureName("dqr:Kinoono").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTatujinnoono = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 8.0F, 750).setEfficiencyOnProper(3.5F).setUnlocalizedName("dqm.itemTatujinnoono").setTextureName("dqr:Tatujinnoono").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMoonakkusu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 11.0F, 1250).setEfficiencyOnProper(5.0F).setUnlocalizedName("dqm.itemMoonakkusu").setTextureName("dqr:Moonakkusu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKingakkusu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 13.0F, 1500).setEfficiencyOnProper(6.5F).setUnlocalizedName("dqm.itemKingakkusu").setTextureName("dqr:Kingakkusu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHaounoono = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 16.0F, 2500).setEfficiencyOnProper(8.0F).setUnlocalizedName("dqm.itemHaounoono").setTextureName("dqr:Haounoono").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemFubukinoono = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 20.0F, 4000).setEfficiencyOnProper(9.5F).setUnlocalizedName("dqm.itemFubukinoono").setTextureName("dqr:Fubukinoono").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemGureitoakusu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 24.0F, 5000).setEfficiencyOnProper(11.0F).setUnlocalizedName("dqm.itemGureitoakusu").setTextureName("dqr:Gureitoakusu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemFunsainooonata = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 27.0F, 7500).setEfficiencyOnProper(12.5F).setUnlocalizedName("dqm.itemFunsainooonata").setTextureName("dqr:Funsainooonata").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemGodakkusu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 31.0F, 10000).setEfficiencyOnProper(14.0F).setUnlocalizedName("dqm.itemGodakkusu").setTextureName("dqr:Godakkusu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemGodakkusu2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmAxe) , 31.0F, 10000).setEfficiencyOnProper(15.0F).setUnlocalizedName("dqm.itemGodakkusu2").setTextureName("dqr:Godakkusu2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemIbaranomuti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 5.0F, 500).setUnlocalizedName("dqm.itemIbaranomuti").setTextureName("dqr:Ibaranomuti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDoragonteiru = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 11.0F, 1500).setUnlocalizedName("dqm.itemDoragonteiru").setTextureName("dqr:Doragonteiru").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMegaminomuti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 15.0F, 4000).setUnlocalizedName("dqm.itemMegaminomuti").setTextureName("dqr:Megaminomuti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemGuringamunomuti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 24.0F, 10000).setUnlocalizedName("dqm.itemGuringamunomuti").setTextureName("dqr:Guringamunomuti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTyouguringamunomuti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 28.0F, 15000).setUnlocalizedName("dqm.itemTyouguringamunomuti").setTextureName("dqr:Tyouguringamunomuti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemAkumanomuti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 17.0F, 5000).setUnlocalizedName("dqm.itemAkumanomuti").setTextureName("dqr:Akumanomuti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemBasutawipu = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 13.0F, 2500).setUnlocalizedName("dqm.itemBasutawipu").setTextureName("dqr:Basutawipu").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemBatoruribon = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 8.0F, 1000).setUnlocalizedName("dqm.itemBatoruribon").setTextureName("dqr:Batoruribon").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKarubebuto = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 20.0F, 6000).setUnlocalizedName("dqm.itemKarubebuto").setTextureName("dqr:Karubebuto").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKawanomuti = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 3.0F, 250).setUnlocalizedName("dqm.itemKawanomuti").setTextureName("dqr:Kawanomuti").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTyouguringamunomuti2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmWhip) , 28.0F, 10000).setUnlocalizedName("dqm.itemTyouguringamunomuti2").setTextureName("dqr:Tyouguringamunomuti2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemSyotobou = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 4.0F, 250).setUnlocalizedName("dqm.itemSyotobou").setTextureName("dqr:Syotobou").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKaryuudonoyumi = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 6.0F, 400).setUnlocalizedName("dqm.itemKaryuudonoyumi").setTextureName("dqr:Karyuudonoyumi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKazekirinoyumi = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 8.0F, 500).setUnlocalizedName("dqm.itemKazekirinoyumi").setTextureName("dqr:Kazekirinoyumi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemYuuwakunoyumi = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 10.0F, 650).setUnlocalizedName("dqm.itemYuuwakunoyumi").setTextureName("dqr:Yuuwakunoyumi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKeironnoyumi = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 12.0F, 800).setUnlocalizedName("dqm.itemKeironnoyumi").setTextureName("dqr:Keironnoyumi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMugennoyumi = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 14.0F, 600).setUnlocalizedName("dqm.itemMugennoyumi").setTextureName("dqr:Mugennoyumi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemJigokunoyumi = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 16.0F, 1250).setUnlocalizedName("dqm.itemJigokunoyumi").setTextureName("dqr:Jigokunoyumi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemBigbougan = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 18.0F, 1500).setUnlocalizedName("dqm.itemBigbougan").setTextureName("dqr:Bigbougan").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemOdinbou = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 20.0F, 2000).setUnlocalizedName("dqm.itemOdinbou").setTextureName("dqr:Odinbou").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemDaitensinoyumi = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 22.0F, 4000).setUnlocalizedName("dqm.itemDaitensinoyumi").setTextureName("dqr:Daitensinoyumi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSefiramunoyumi = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 25.0F, 6000).setUnlocalizedName("dqm.itemSefiramunoyumi").setTextureName("dqr:Sefiramunoyumi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSefiramunoyumi2 = new DqmItemBowBase((DQR.dqmMaterial.DqmBow) , 25.0F, 6000).setUnlocalizedName("dqm.itemSefiramunoyumi2").setTextureName("dqr:Sefiramunoyumi2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemBumeran = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 2.0F, 200).setUnlocalizedName("dqm.itemBumeran").setTextureName("dqr:Bumeran").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemYaibanobumeran = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 4.0F, 400).setUnlocalizedName("dqm.itemYaibanobumeran").setTextureName("dqr:Yaibanobumeran").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKurosubumeran = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 6.0F, 500).setUnlocalizedName("dqm.itemKurosubumeran").setTextureName("dqr:Kurosubumeran").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemIgurufeza = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 8.0F, 650).setUnlocalizedName("dqm.itemIgurufeza").setTextureName("dqr:Igurufeza").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKazenobumeran = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 11.0F, 700).setUnlocalizedName("dqm.itemKazenobumeran").setTextureName("dqr:Kazenobumeran").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHonoonobumeran = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 13.0F, 800).setUnlocalizedName("dqm.itemHonoonobumeran").setTextureName("dqr:Honoonobumeran").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKoorinobumeran = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 15.0F, 1200).setUnlocalizedName("dqm.itemKoorinobumeran").setTextureName("dqr:Koorinobumeran").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKuresentoejji = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 17.0F, 1500).setUnlocalizedName("dqm.itemKuresentoejji").setTextureName("dqr:Kuresentoejji").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMeteoejji = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 19.0F, 2000).setUnlocalizedName("dqm.itemMeteoejji").setTextureName("dqr:Meteoejji").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHaipanova = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 22.0F, 10000).setUnlocalizedName("dqm.itemHaipanova").setTextureName("dqr:Haipanova").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHaipanova2 = new DqmItemThrowing((DQR.dqmMaterial.DqmThrow) , 22.0F, 10000).setUnlocalizedName("dqm.itemHaipanova2").setTextureName("dqr:Haipanova2").setCreativeTab(DQR.tabs.DqmTabWeapon);

		//GameRegistry.registerItem(itemWeapon, "ItemWeapon");
		DQWeapons.itemTetunosoroban = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSoroban) , 8.0F, 750).setUnlocalizedName("dqm.itemTetunosoroban").setTextureName("dqr:Tetunosoroban").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemMahounosoroban = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSoroban) , 20.0F, 3000).setUnlocalizedName("dqm.itemMahounosoroban").setTextureName("dqr:Mahounosoroban").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSeiginosoroban = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSoroban) , 32.0F, 10000).setUnlocalizedName("dqm.itemSeiginosoroban").setTextureName("dqr:Seiginosoroban").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSeiginosoroban2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmSoroban) , 32.0F, 10000).setUnlocalizedName("dqm.itemSeiginosoroban2").setTextureName("dqr:Seiginosoroban").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQWeapons.itemHanenoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 4.0F, 200).setUnlocalizedName("dqm.itemHanenoougi").setTextureName("dqr:Hanenoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTetunoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 5.0F, 400).setUnlocalizedName("dqm.itemTetunoougi").setTextureName("dqr:Tetunoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemBattlefan = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 6.0F, 500).setUnlocalizedName("dqm.itemBattlefan").setTextureName("dqr:Battlefan").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemReppuunoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 8.0F, 750).setUnlocalizedName("dqm.itemReppuunoougi").setTextureName("dqr:Reppuunoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemKamenoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 10.0F, 1000).setUnlocalizedName("dqm.itemKamenoougi").setTextureName("dqr:Kamenoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTorinoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 11.0F, 1500).setUnlocalizedName("dqm.itemTorinoougi").setTextureName("dqr:Torinoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemNekonoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 11.0F, 1500).setUnlocalizedName("dqm.itemNekonoougi").setTextureName("dqr:Nekonoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHebinoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 14.0F, 2000).setUnlocalizedName("dqm.itemHebinoougi").setTextureName("dqr:Hebinoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemHosinoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 18.0F, 5000).setUnlocalizedName("dqm.itemHosinoougi").setTextureName("dqr:Hosinoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTukinoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 20.0F, 6000).setUnlocalizedName("dqm.itemTukinoougi").setTextureName("dqr:Tukinoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemTaiyounoougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 22.0F, 6500).setUnlocalizedName("dqm.itemTaiyounoougi").setTextureName("dqr:Taiyounoougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSaisyuuougi = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 25.0F, 10000).setUnlocalizedName("dqm.itemSaisyuuougi").setTextureName("dqr:Saisyuuougi").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQWeapons.itemSaisyuuougi2 = new DqmItemWeaponBase((DQR.dqmMaterial.DqmOugi) , 25.0F, 10000).setUnlocalizedName("dqm.itemSaisyuuougi2").setTextureName("dqr:Saisyuuougi").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQMagicTools.itemMagicToolFarm1 = new DqmItemMGTFarm1().setCreativeTab(DQR.tabs.DqmTabMagic).setMaxDamage(10000).setMaxStackSize(1).setUnlocalizedName("dqm.itemMagicToolFarm1").setTextureName("dqr:MagicToolFarm1");
		DQMagicTools.itemMagicToolFarm2 = new DqmItemMGTFarm2().setCreativeTab(DQR.tabs.DqmTabMagic).setMaxDamage(10000).setMaxStackSize(1).setUnlocalizedName("dqm.itemMagicToolFarm2").setTextureName("dqr:MagicToolFarm2");

		DQMiscs.itemAtkEndora = new DqmItemFarmerDiary().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemAtkEndora").setTextureName("dqr:AtkEndora");
		DQMiscs.itemDyeWhite2 =  new DqmItemDyeWhite2().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDyeWhite2").setTextureName("dye_powder_white");

		DQMiscs.ItemMahounoTutu01 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.mahounoTutu_1").setTextureName("dqr:mahounoTutu_1");
		DQMiscs.ItemMahounoTutu02 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.mahounoTutu_3").setTextureName("dqr:mahounoTutu_3");
		DQMiscs.ItemMahounoTutu03 = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.mahounoTutu_5").setTextureName("dqr:mahounoTutu_5");
		DQMiscs.ItemMahounoTutu11 = new DqmItemMahounoTutu().setUnlocalizedName("dqm.mahounoTutu_2").setTextureName("dqr:mahounoTutu_2");
		DQMiscs.ItemMahounoTutu12 = new DqmItemMahounoTutu().setUnlocalizedName("dqm.mahounoTutu_4").setTextureName("dqr:mahounoTutu_4");
		DQMiscs.ItemMahounoTutu13 = new DqmItemMahounoTutu().setUnlocalizedName("dqm.mahounoTutu_6").setTextureName("dqr:mahounoTutu_6");

		DQMiscs.ItemMahounoTutu01B = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.mahounoTutu_1B").setTextureName("dqr:mahounoTutu_1B");
		DQMiscs.ItemMahounoTutu02B = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.mahounoTutu_3B").setTextureName("dqr:mahounoTutu_3B");
		DQMiscs.ItemMahounoTutu03B = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.mahounoTutu_5B").setTextureName("dqr:mahounoTutu_5B");

		DQMonsters.itemMonsterSuraimu = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterSuraimu").setTextureName("dqr:FigSuraimu");

		//肉
		DQMiscs.itemNiku1 = new DqmItemThrowBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemNiku1").setTextureName("dqr:Niku1");
		DQMiscs.itemNiku2 = new DqmItemThrowBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemNiku2").setTextureName("dqr:Niku2");
		DQMiscs.itemNiku3 = new DqmItemThrowBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemNiku3").setTextureName("dqr:Niku3");
		DQMiscs.itemNiku4 = new DqmItemThrowBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemNiku4").setTextureName("dqr:Niku4");

		DQMagicTools.itemPetSuisyou = new DqmItemPetSuisyou().setCreativeTab(DQR.tabs.DqmTabMagic).setMaxStackSize(1).setUnlocalizedName("dqm.itemPetSuisyou").setTextureName("dqr:PetSuisyou");

		//スキルエンブレム
		//DQSkillWs.itemPetSuisyou = new DqmItemPetSuisyou().setCreativeTab(DQR.tabs.DqmTabMagic).setMaxStackSize(1).setUnlocalizedName("dqm.itemPetSuisyou").setTextureName("dqr:PetSuisyou");
		DQSkills.itemSkillW_20 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_20").setTextureName("dqr:SkillW_20");
		DQSkills.itemSkillW_21 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_21").setTextureName("dqr:SkillW_21");
		DQSkills.itemSkillW_30 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_30").setTextureName("dqr:SkillW_30");
		DQSkills.itemSkillW_31 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_31").setTextureName("dqr:SkillW_31");
		DQSkills.itemSkillW_40 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_40").setTextureName("dqr:SkillW_40");
		DQSkills.itemSkillW_41 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_41").setTextureName("dqr:SkillW_41");
		DQSkills.itemSkillW_50 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_50").setTextureName("dqr:SkillW_50");
		DQSkills.itemSkillW_51 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_51").setTextureName("dqr:SkillW_51");
		DQSkills.itemSkillW_60 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_60").setTextureName("dqr:SkillW_60");
		DQSkills.itemSkillW_61 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_61").setTextureName("dqr:SkillW_61");
		DQSkills.itemSkillW_70 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_70").setTextureName("dqr:SkillW_70");
		DQSkills.itemSkillW_71 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_71").setTextureName("dqr:SkillW_71");
		DQSkills.itemSkillW_80 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_80").setTextureName("dqr:SkillW_80");
		DQSkills.itemSkillW_81 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_81").setTextureName("dqr:SkillW_81");
		DQSkills.itemSkillW_90 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_90").setTextureName("dqr:SkillW_90");
		DQSkills.itemSkillW_91 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_91").setTextureName("dqr:SkillW_91");
		DQSkills.itemSkillW_100 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_100").setTextureName("dqr:SkillW_100");
		DQSkills.itemSkillW_101 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_101").setTextureName("dqr:SkillW_101");
		DQSkills.itemSkillW_110 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_110").setTextureName("dqr:SkillW_110");
		DQSkills.itemSkillW_111 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_111").setTextureName("dqr:SkillW_111");
		DQSkills.itemSkillW_120 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_120").setTextureName("dqr:SkillW_120");
		DQSkills.itemSkillW_121 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_121").setTextureName("dqr:SkillW_121");
		DQSkills.itemSkillW_130 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_130").setTextureName("dqr:SkillW_130");
		DQSkills.itemSkillW_131 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_131").setTextureName("dqr:SkillW_131");
		DQSkills.itemSkillW_240 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_240").setTextureName("dqr:SkillW_240");
		DQSkills.itemSkillW_241 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_241").setTextureName("dqr:SkillW_241");
		DQSkills.itemSkillW_250 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_250").setTextureName("dqr:SkillW_250");
		DQSkills.itemSkillW_251 = new DqmItemSkillWBase().setMaxStackSize(1).setUnlocalizedName("itemSkillW_251").setTextureName("dqr:SkillW_251");

		DQMiscs.itemOokinaFukuro = new DqmItemFukuro().setMaxStackSize(1).setCreativeTab(DQR.tabs.DqmTabBackPack).setUnlocalizedName("dqm.itemFukuro").setTextureName("dqr:Fukuro");
		DQMiscs.itemOokinaFukuroR = new DqmItemFukuro().setMaxStackSize(1).setCreativeTab(DQR.tabs.DqmTabBackPack).setUnlocalizedName("dqm.itemFukuroR").setTextureName("dqr:FukuroR");
		DQMiscs.itemOokinaFukuroG = new DqmItemFukuro().setMaxStackSize(1).setCreativeTab(DQR.tabs.DqmTabBackPack).setUnlocalizedName("dqm.itemFukuroG").setTextureName("dqr:FukuroG");
		DQMiscs.itemOokinaFukuroB = new DqmItemFukuro().setMaxStackSize(1).setCreativeTab(DQR.tabs.DqmTabBackPack).setUnlocalizedName("dqm.itemFukuroB").setTextureName("dqr:FukuroB");
		DQMiscs.itemOokinaFukuroY = new DqmItemFukuro().setMaxStackSize(1).setCreativeTab(DQR.tabs.DqmTabBackPack).setUnlocalizedName("dqm.itemFukuroY").setTextureName("dqr:FukuroY");

		DQMagicTools.itemMagicToolBreak1 = new DqmItemMGTBreak1().setCreativeTab(DQR.tabs.DqmTabMagic).setMaxDamage(10000).setMaxStackSize(1).setUnlocalizedName("dqm.itemMagicToolBreak1").setTextureName("dqr:MagicToolBreak1");
		DQMagicTools.itemMagicToolBreak2 = new DqmItemMGTBreak2().setCreativeTab(DQR.tabs.DqmTabMagic).setMaxDamage(10000).setMaxStackSize(1).setUnlocalizedName("dqm.itemMagicToolBreak2").setTextureName("dqr:MagicToolBreak2");

		DQMagicTools.itemMagicToolSet = new DqmItemMGTSet().setCreativeTab(DQR.tabs.DqmTabMagic).setMaxDamage(10000).setMaxStackSize(1).setUnlocalizedName("dqm.itemMagicToolSet").setTextureName("dqr:MagicToolSet");


		DQMagics.itemBreathF1 = new DqmItemMagicDragonF((DQR.dqmMaterial.DqmMagicDragon), 1.0F, 2000, EnumDqmMagic.Hinoiki).setUnlocalizedName("dqm.itemBreathF1").setTextureName("dqr:BreathF1").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBreathF2 = new DqmItemMagicDragonF((DQR.dqmMaterial.DqmMagicDragon), 5.0F, 2000, EnumDqmMagic.Kaeniki).setUnlocalizedName("dqm.itemBreathF2").setTextureName("dqr:BreathF2").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBreathF3 = new DqmItemMagicDragonF((DQR.dqmMaterial.DqmMagicDragon), 10.0F, 2000, EnumDqmMagic.HagesiiHonoo).setUnlocalizedName("dqm.itemBreathF3").setTextureName("dqr:BreathF3").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBreathF4 = new DqmItemMagicDragonF((DQR.dqmMaterial.DqmMagicDragon), 15.0F, 2000, EnumDqmMagic.Syakunetu).setUnlocalizedName("dqm.itemBreathF4").setTextureName("dqr:BreathF4").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBreathF5 = new DqmItemMagicDragonF((DQR.dqmMaterial.DqmMagicDragon), 25.0F, 2000, EnumDqmMagic.RengokuHonoo).setUnlocalizedName("dqm.itemBreathF5").setTextureName("dqr:BreathF5").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMagics.itemBreathS1 = new DqmItemMagicDragonS((DQR.dqmMaterial.DqmMagicDragon), 1.0F, 2000, EnumDqmMagic.Tumetaiiki).setUnlocalizedName("dqm.itemBreathS1").setTextureName("dqr:BreathS1").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBreathS2 = new DqmItemMagicDragonS((DQR.dqmMaterial.DqmMagicDragon), 7.5F, 2000, EnumDqmMagic.Koorinoiki).setUnlocalizedName("dqm.itemBreathS2").setTextureName("dqr:BreathS2").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBreathS3 = new DqmItemMagicDragonS((DQR.dqmMaterial.DqmMagicDragon), 12.0F, 2000, EnumDqmMagic.Kogoeruhubuki).setUnlocalizedName("dqm.itemBreathS3").setTextureName("dqr:BreathS3").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBreathS4 = new DqmItemMagicDragonS((DQR.dqmMaterial.DqmMagicDragon), 18.0F, 2000, EnumDqmMagic.Kagayakuiki).setUnlocalizedName("dqm.itemBreathS4").setTextureName("dqr:BreathS4").setCreativeTab(DQR.tabs.DqmTabMagic);
		DQMagics.itemBreathS5 = new DqmItemMagicDragonS((DQR.dqmMaterial.DqmMagicDragon), 30.0F, 2000, EnumDqmMagic.Zettaireido).setUnlocalizedName("dqm.itemBreathS5").setTextureName("dqr:BreathS5").setCreativeTab(DQR.tabs.DqmTabMagic);

		DQMiscs.itemDragonObuB = new DqmItemMiscBase().setCreativeTab(DQR.tabs.DqmTabMisc).setUnlocalizedName("dqm.itemDragonObuB").setTextureName("dqr:Breath0");

		DQInventorySlots.itemSlotKubikazari = new Item().setUnlocalizedName("dqm.itemSlotKubikazari").setTextureName("dqr:slot_Kubikazari");
		DQInventorySlots.itemSlotPiasu = new Item().setUnlocalizedName("dqm.itemSlotPiasu").setTextureName("dqr:slot_Piasu").setCreativeTab(DQR.tabs.DqmTabMisc);
		DQInventorySlots.itemSlotShield = new Item().setUnlocalizedName("dqm.itemSlotShield").setTextureName("dqr:slot_Shield").setCreativeTab(DQR.tabs.DqmTabMisc);
		DQInventorySlots.itemSlotSonota = new Item().setUnlocalizedName("dqm.itemSlotSonota").setTextureName("dqr:slot_Sonota").setCreativeTab(DQR.tabs.DqmTabMisc);
		DQInventorySlots.itemSlotUdewa = new Item().setUnlocalizedName("dqm.itemSlotUdewa").setTextureName("dqr:slot_Udewa").setCreativeTab(DQR.tabs.DqmTabMisc);
		DQInventorySlots.itemSlotYubiwa = new Item().setUnlocalizedName("dqm.itemSlotYubiwa").setTextureName("dqr:slot_Yubiwa").setCreativeTab(DQR.tabs.DqmTabMisc);
		DQInventorySlots.itemSlotFukuro = new Item().setUnlocalizedName("dqm.itemSlotFukuro").setTextureName("dqr:slot_Fukuro").setCreativeTab(DQR.tabs.DqmTabMisc);

		DQMonsters.itemMonsterAkuma = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterAkuma").setTextureName("dqr:FigAkuma");
		DQMonsters.itemMonsterBeast = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterBeast").setTextureName("dqr:FigBeast");
		DQMonsters.itemMonsterBussitu = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterBussitu").setTextureName("dqr:FigBussitu");
		DQMonsters.itemMonsterDragon = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterDragon").setTextureName("dqr:FigDragon");
		DQMonsters.itemMonsterMetaru = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterMetaru").setTextureName("dqr:FigMetal");
		DQMonsters.itemMonsterSizen = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterSizen").setTextureName("dqr:FigSizen");
		DQMonsters.itemMonsterTokusyu = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterTokusyu").setTextureName("dqr:FigTokusyu");
		DQMonsters.itemMonsterUndead = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterUndead").setTextureName("dqr:FigUndead");
		DQMonsters.itemMonsterUnknown = new DqmItemMonster().setUnlocalizedName("dqm.itemMonsterUnknown").setTextureName("dqr:FigUnknown");

		DQBuilders.itemBuilderCasino1 = new DqmItemBuilderCasino(EnumDqmBuilder.CASINO).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderCasino1").setMaxStackSize(1).setTextureName("dqr:Builder_Casino1W");
		DQBuilders.itemBuilderCasino2 = new DqmItemBuilderCasino(EnumDqmBuilder.CASINO).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderCasino2").setMaxStackSize(1).setTextureName("dqr:Builder_Casino2W");
		DQBuilders.itemBuilderCasino3 = new DqmItemBuilderCasino(EnumDqmBuilder.CASINO).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderCasino3").setMaxStackSize(1).setTextureName("dqr:Builder_Casino3W");
		DQBuilders.itemBuilderCasino4 = new DqmItemBuilderCasino(EnumDqmBuilder.CASINO).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderCasino4").setMaxStackSize(1).setTextureName("dqr:Builder_Casino4W");
		DQBuilders.itemBuilderCasino5 = new DqmItemBuilderCasino(EnumDqmBuilder.CASINO).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderCasino5").setMaxStackSize(1).setTextureName("dqr:Builder_Casino5W");

		DQMagicTools.itemDqrFishRod_Diamond = (DqmItemFishingRod)new DqmItemFishingRod().setMaxStrain(80).setStrength(0.08).setEnchantability(5).setMaxDamage(256).setUnlocalizedName("dqm.itemTurizao_Diamond").setTextureName("dqr:Turizao_Diamond").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQMagicTools.itemDqrFishRod_Oriharukon = (DqmItemFishingRod)new DqmItemFishingRod().setMaxStrain(80).setStrength(0.08).setEnchantability(5).setMaxDamage(500).setUnlocalizedName("dqm.itemTurizao_Oriharukon").setTextureName("dqr:Turizao_Oriharukon").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQMagicTools.itemDqrFishRod_Roto = (DqmItemFishingRod)new DqmItemFishingRod().setMaxStrain(80).setStrength(0.08).setEnchantability(5).setMaxDamage(1000).setUnlocalizedName("dqm.itemTurizao_Roto").setTextureName("dqr:Turizao_Roto").setCreativeTab(DQR.tabs.DqmTabWeapon);
		DQMagicTools.itemDqrFishRod_Densetu = (DqmItemFishingRod)new DqmItemFishingRod().setMaxStrain(80).setStrength(0.08).setEnchantability(5).setMaxDamage(2000).setUnlocalizedName("dqm.itemTurizao_Densetu").setTextureName("dqr:Turizao_Sinken").setCreativeTab(DQR.tabs.DqmTabWeapon);
		//DQMagicTools.itemDqrFishRod = new ItemFishingRod().setMaxDamage(100).setUnlocalizedName("wooden_fishing_rod").setTextureName("jaff:hooked_fishing_rod").setCreativeTab(DQR.tabs.DqmTabWeapon);

		DQInventorySlots.itemSlotPetYoroi = new Item().setUnlocalizedName("dqm.itemSlotPetYoroi").setTextureName("dqr:slot_PetYoroi").setCreativeTab(DQR.tabs.DqmTabMisc);
		DQInventorySlots.itemSlotPetBuki = new Item().setUnlocalizedName("dqm.itemSlotPetBuki").setTextureName("dqr:slot_PetBuki").setCreativeTab(DQR.tabs.DqmTabMisc);

		DQBuilders.itemBuilderKaikosyo = new Item().setUnlocalizedName("dqm.Kaikosyo").setTextureName("dqr:Builder_Shop_KaikoW").setCreativeTab(DQR.tabs.DqmTabBuilder);

		DQSkills.itemSkillJ_HP = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_HP").setTextureName("dqr:Inotinokinomi");
		DQSkills.itemSkillJ_MP = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_MP").setTextureName("dqr:Fusiginakinomi");
		DQSkills.itemSkillJ_ATK = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_ATK").setTextureName("dqr:Rotonoturugi");
		DQSkills.itemSkillJ_MAG = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_MAG").setTextureName("dqr:Gigadein");
		DQSkills.itemSkillJ_DEF = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_DEF").setTextureName("dqr:Mamorinotane");
		DQSkills.itemSkillJ_STR = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_STR").setTextureName("dqr:Tikaranotane");
		DQSkills.itemSkillJ_INT = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_INT").setTextureName("dqr:MaryokunotaneI");
		DQSkills.itemSkillJ_MISS = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_MISS").setTextureName("dqr:Dragonwing");
		DQSkills.itemSkillJ_CRI = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_CRI").setTextureName("dqr:Kyodainakiba");
		DQSkills.itemSkillJ_AGI = new DqmItemSkillJBase().setMaxStackSize(1).setUnlocalizedName("itemSkillJ_AGI").setTextureName("dqr:Subayasanotane");

		DQMagics.itemJSkillBook = new DqmItemSkillBookBase().setCreativeTab(DQR.tabs.DqmTabMagic).setUnlocalizedName("dqm.JSkillBook").setMaxStackSize(1).setTextureName("dqr:Skillbook");
		DQMagics.itemJSkillBookR = new DqmItemSkillBookBase().setCreativeTab(DQR.tabs.DqmTabMagic).setUnlocalizedName("dqm.JSkillBookR").setMaxStackSize(1).setTextureName("dqr:SkillbookR");
		DQMagics.itemJSkillBookB = new DqmItemSkillBookBase().setCreativeTab(DQR.tabs.DqmTabMagic).setUnlocalizedName("dqm.JSkillBookB").setMaxStackSize(1).setTextureName("dqr:SkillbookB");
		DQMagics.itemJSkillBookG = new DqmItemSkillBookBase().setCreativeTab(DQR.tabs.DqmTabMagic).setUnlocalizedName("dqm.JSkillBookG").setMaxStackSize(1).setTextureName("dqr:SkillbookG");
		DQMagics.itemJSkillBookY = new DqmItemSkillBookBase().setCreativeTab(DQR.tabs.DqmTabMagic).setUnlocalizedName("dqm.JSkillBookY").setMaxStackSize(1).setTextureName("dqr:SkillbookY");
	}
}
