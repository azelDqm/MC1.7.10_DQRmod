package dqr.dataTable;

import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.Blocks.DQDecorates;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQArmors;
import dqr.api.Items.DQBuilders;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQWeapons;

public class FuncCasinoCoinItems {

	public static final Map<Item, Integer> medalWeapon = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalArmor = new LinkedHashMap<>();
	//public static final Map<Item, Integer> medalMagic = new LinkedHashMap<>();
	//public static final Map<Item, Integer> medalMagic2 = new LinkedHashMap<>();
	//public static final Map<Item, Integer> medalJobchange = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalItem = new LinkedHashMap<>();
	//public static final Map<Item, Integer> medalMedal = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalAccessory = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalBuilder= new LinkedHashMap<>();
	public static final Map<Item, Integer> medalDecorate= new LinkedHashMap<>();
	public static final Map<Item, Integer> medalDecorateDaiza = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalDecorateHasira = new LinkedHashMap<>();
	public FuncCasinoCoinItems()
	{
		//武器

		//(3)
		medalWeapon.put(DQWeapons.itemKisekinoturugi, 80000);
		medalWeapon.put(DQWeapons.itemHayabusanoturugi, 100000);
		medalWeapon.put(DQWeapons.itemMetarukingnoturugi, 150000);

		//(14)
		medalWeapon.put(DQWeapons.itemGinganoturugi, 500000);
		medalWeapon.put(DQWeapons.itemMetarukingnoyari, 500000);
		medalWeapon.put(DQWeapons.itemToririondaga, 500000);
		medalWeapon.put(DQWeapons.itemNyoraikon, 500000);
		medalWeapon.put(DQWeapons.itemSinryuunotume, 500000);
		medalWeapon.put(DQWeapons.itemKobusi3, 500000);
		medalWeapon.put(DQWeapons.itemHakainotekkyuu, 500000);
		medalWeapon.put(DQWeapons.itemGodakkusu, 500000);
		medalWeapon.put(DQWeapons.itemTyouguringamunomuti, 500000);
		medalWeapon.put(DQWeapons.itemSefiramunoyumi, 500000);
		medalWeapon.put(DQWeapons.itemHaipanova, 500000);
		medalWeapon.put(DQWeapons.itemSeiginosoroban, 500000);
		medalWeapon.put(DQWeapons.itemSaisyuuougi, 500000);
		medalWeapon.put(DQWeapons.itemSinken, 500000);


		//防具
		//22
		medalArmor.put(DQArmors.itemArakuremasuku , 1000);
		medalArmor.put(DQArmors.itemUsamimibando , 1500);
		medalArmor.put(DQArmors.itemNekomimibando , 1500);
		medalArmor.put(DQArmors.itemBanisutu , 1500);
		medalArmor.put(DQArmors.itemAmitaitu , 1500);
		medalArmor.put(DQArmors.itemHaihiru , 1500);
		medalArmor.put(DQArmors.itemFantomumasuku , 10000);

		medalArmor.put(DQArmors.itemAbunaimizugiue , 20000);
		medalArmor.put(DQArmors.itemAbunaimizugisita , 20000);

		medalArmor.put(DQArmors.itemSabitayoroi , 50000);
		medalArmor.put(DQArmors.itemSiawasenobousi , 25000);
		medalArmor.put(DQArmors.itemSiawasenokutu , 25000);
		medalArmor.put(DQArmors.itemMetarukingnokabuto , 50000);
		medalArmor.put(DQArmors.itemMetarukingnoyoroi , 50000);
		medalArmor.put(DQArmors.itemMetarukingnokote , 50000);
		medalArmor.put(DQArmors.itemMetarukingnokutu , 50000);
		medalArmor.put(DQArmors.itemMizunohagoromo , 75000);

		//13
		medalAccessory.put(DQAccessories.itemKirapiasu2 , 10000);
		medalAccessory.put(DQAccessories.itemGouketunoudewa , 50000);
		medalAccessory.put(DQAccessories.itemMamorinoudewa , 50000);
		medalAccessory.put(DQAccessories.itemTensinopiasu , 75000);
		medalAccessory.put(DQAccessories.itemHosizoranokubikazari , 75000);
		medalAccessory.put(DQAccessories.itemIyasinoudewa , 60000);
		medalAccessory.put(DQAccessories.itemMegaminoyubiwa , 75000);
		medalAccessory.put(DQAccessories.itemMegaminotate , 200000);
		medalAccessory.put(DQAccessories.itemMetarukingnotate , 50000);

		medalAccessory.put(DQAccessories.itemSuparing , 400000);
		medalAccessory.put(DQAccessories.itemSosararing , 300000);
		medalAccessory.put(DQAccessories.itemHadokunoring , 200000);
		medalAccessory.put(DQAccessories.itemHagennoring , 200000);
		medalAccessory.put(DQAccessories.itemMangetunoring , 200000);
		medalAccessory.put(DQAccessories.itemRiseinoring , 200000);


		//魔法1
		/*
		medalMagic.put(DQMagics.itemBegiragon , 500);
		medalMagic.put(DQMagics.itemBagikurosu , 500);
		medalMagic.put(DQMagics.itemIonazun , 500);
		medalMagic.put(DQMagics.itemMahyado , 500);
		medalMagic.put(DQMagics.itemMerazoma , 500);
		medalMagic.put(DQMagics.itemDorumoa , 500);
		medalMagic.put(DQMagics.itemZaraki , 550);
		medalMagic.put(DQMagics.itemGiragureido , 750);
		medalMagic.put(DQMagics.itemBagimutyo , 750);
		medalMagic.put(DQMagics.itemIogurande , 750);
		medalMagic.put(DQMagics.itemMahyadodesu , 750);
		medalMagic.put(DQMagics.itemMeragaia , 750);
		medalMagic.put(DQMagics.itemZarakima , 900);
		medalMagic.put(DQMagics.itemDorumadon , 1000);
		medalMagic.put(DQMagics.itemGigadein , 1000);
		medalMagic.put(DQMagics.itemMinadein , 1500);
		medalMagic.put(DQMagics.itemBigban , 2000);
		medalMagic.put(DQMagics.itemMadante , 3000);
	*/


		//魔法2
		/*
		medalMagic2.put(DQMagics.itemRura , 75);
		medalMagic2.put(DQMagics.itemRuraR , 80);
		medalMagic2.put(DQMagics.itemRuraG , 80);
		medalMagic2.put(DQMagics.itemRuraB , 80);
		medalMagic2.put(DQMagics.itemRuraY , 80);
		medalMagic2.put(DQMagics.itemRura2 , 75);
		medalMagic2.put(DQMagics.itemRuraR2 , 80);
		medalMagic2.put(DQMagics.itemRuraG2 , 80);
		medalMagic2.put(DQMagics.itemRuraB2 , 80);
		medalMagic2.put(DQMagics.itemRuraY2 , 80);

		medalMagic2.put(DQMagics.itemKiari , 75);
		medalMagic2.put(DQMagics.itemBehoma , 500);
		medalMagic2.put(DQMagics.itemBehomara , 750);
		medalMagic2.put(DQMagics.itemBehomazun , 1000);
		medalMagic2.put(DQMagics.itemMahoizun , 1000);
		medalMagic2.put(DQMagics.itemBaikiruto , 200);
		medalMagic2.put(DQMagics.itemSukara , 200);
		medalMagic2.put(DQMagics.itemPiora , 200);
		medalMagic2.put(DQMagics.itemManusa , 150);
		medalMagic2.put(DQMagics.itemBomie , 200);

		medalMagic2.put(DQMagics.itemRukani , 200);
		medalMagic2.put(DQMagics.itemBaha , 200);
		medalMagic2.put(DQMagics.itemRariho , 250);
		medalMagic2.put(DQMagics.itemMahoton , 300);
		*/

		//転職
		/*
		medalJobchange.put(DQEmblems.itemEmbCivilian , 100);
		medalJobchange.put(DQEmblems.itemEmbWarrior , 100);
		medalJobchange.put(DQEmblems.itemEmbFighter , 100);
		medalJobchange.put(DQEmblems.itemEmbMagician , 100);
		medalJobchange.put(DQEmblems.itemEmbPriest , 100);
		medalJobchange.put(DQEmblems.itemEmbThief , 100);
		medalJobchange.put(DQEmblems.itemEmbMerchant , 100);

		medalJobchange.put(DQEmblems.itemEmbDancer , 700);
		medalJobchange.put(DQEmblems.itemEmbPirate , 700);
		medalJobchange.put(DQEmblems.itemEmbBattleMaster , 700);
		medalJobchange.put(DQEmblems.itemEmbSage , 700);
		medalJobchange.put(DQEmblems.itemEmbPaladin , 700);
		medalJobchange.put(DQEmblems.itemEmbMagickKnight , 700);
		medalJobchange.put(DQEmblems.itemEmbRanger , 700);

		medalJobchange.put(DQEmblems.itemEmbMonsterTamer , 1500);
		medalJobchange.put(DQEmblems.itemEmbSuperStar , 1500);
		medalJobchange.put(DQEmblems.itemEmbGodHnad , 1500);
		medalJobchange.put(DQEmblems.itemEmbHero , 3000);
		medalJobchange.put(DQEmblems.itemEmbHaguremetal , 3000);
		medalJobchange.put(DQEmblems.itemEmbDragon , 3000);
		*/


		//道具
		medalItem.put(DQMiscs.itemKimeranotubasa , 100);

		medalItem.put(DQMiscs.itemDouka , 55);
		medalItem.put(DQMiscs.itemGinka , 165);
		medalItem.put(DQMiscs.itemKinka , 330);

		medalItem.put(DQIngots.itemTaiyounoisi , 300);
		medalItem.put(DQIngots.itemHikarinoisi , 300);
		medalItem.put(DQIngots.itemMisriru , 300);
		medalItem.put(DQIngots.itemOriharukon , 750);

		medalItem.put(DQMiscs.itemMetaloubu , 1600);
		medalItem.put(DQMiscs.itemMetaru , 200);
		medalItem.put(DQMiscs.itemKinkai , 200);
		medalItem.put(DQMiscs.itemNijiirononunokire , 400);
		medalItem.put(DQMiscs.itemDoragonnonamida , 300);
		medalItem.put(DQMiscs.itemRyuunonamida , 400);
		medalItem.put(DQMiscs.itemNiku4 , 750);
		medalItem.put(DQMiscs.itemKingdaiya , 777);

		medalItem.put(DQMiscs.itemGenmaseki , 1750);
		medalItem.put(DQMiscs.itemGenmasekiB , 1000000);
		medalItem.put(DQMiscs.itemGenmasekiG , 1000000);
		//medalItem.put(Item.getItemFromBlock(DQDecorates.DqmBlockRotomon) , 750000);


		medalBuilder.put(DQBuilders.itemBuilderDama , 2000);
		medalBuilder.put(DQBuilders.itemBuilderDamaS , 2000);
		medalBuilder.put(DQBuilders.itemBuilderDamaW , 2000);
		medalBuilder.put(DQBuilders.itemBuilderCasino1 , 1000);
		medalBuilder.put(DQBuilders.itemBuilderCasino2 , 1000);
		medalBuilder.put(DQBuilders.itemBuilderCasino3 , 1000);
		medalBuilder.put(DQBuilders.itemBuilderCasino4 , 1000);

		medalBuilder.put(DQBuilders.itemBuilderShopSyuuriya , 1500);
		medalBuilder.put(DQBuilders.itemBuilderShopBank , 1500);
		medalBuilder.put(DQBuilders.itemBuilderShopKaitoriya , 1500);
		medalBuilder.put(DQBuilders.itemBuilderShopBukiya , 1500);

		medalBuilder.put(DQBuilders.itemBuilderSekizouDarkRamia , 500000);
		medalBuilder.put(DQBuilders.itemBuilderSekizouDesupisaro1 , 500000);
		medalBuilder.put(DQBuilders.itemBuilderSekizouEsterk , 500000);
		medalBuilder.put(DQBuilders.itemBuilderSekizouMasterdoragon , 500000);
		medalBuilder.put(DQBuilders.itemBuilderSekizouRyuuou , 500000);
		medalBuilder.put(DQBuilders.itemBuilderSekizouZoma , 500000);
		//メダル
		/*
		medalMedal.put(DQMiscs.itemLittlemedal , 1);
		medalMedal.put(DQMiscs.itemLittlemedal5 , 5);
		medalMedal.put(DQMiscs.itemLittlemedal10 , 10);
		medalMedal.put(DQMiscs.itemLittlemedal50 , 50);
		medalMedal.put(DQMiscs.itemLittlemedal100 , 100);
		medalMedal.put(DQMiscs.itemLittlemedal500 , 500);
		medalMedal.put(DQMiscs.itemLittlemedal1000 , 1000);
		*/

		//装飾品
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockTubo) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockTubokku) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockSword) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockTue) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockSikabane) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockHepaitosu) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockTaimatu) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockTaimatu2) , 400);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockTaru) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockJuujika) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockJuujika2) , 400);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockKagaribidai) , 200);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiiisizukue) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockIdooke) , 250);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockOke) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockIdo) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiitukue) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockMaki) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockKinoisi) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockTiisaitukue) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockHondana) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockTokusyutaimatu) , 600);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockEntotuS) , 150);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockEntotu) , 200);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockEntotuN) , 200);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockEntotuO) , 300);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockEntotuG) , 5000);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockYadoya) , 300);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockDouguya) , 300);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockBouguya) , 300);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockBukiya) , 300);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockDqmbed) , 500);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockDqmbed2) , 1000);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockDqmbed3) , 1200);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockCasinoSlot1) , 1000);
		medalDecorate.put(Item.getItemFromBlock(DQDecorates.DqmBlockCasinoAbg1) , 1000);


		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockHasira) , 30);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockHasiranaka) , 30);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockHasiraue) , 30);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockHasiraNB) , 40);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockHasiranakaNB) , 40);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockHasiraueNB) , 40);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockHasiraQ) , 50);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockHasiranakaQ) , 50);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockHasiraueQ) , 50);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasirasita) , 50);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasiranaka) , 50);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasiraue) , 50);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasirasitaS) , 60);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasiranakaS) , 60);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasiraueS) , 60);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasirasitaNB) , 70);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasiranakaNB) , 70);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasiraueNB) , 70);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasirasitaQ) , 80);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasiranakaQ) , 80);
		medalDecorateHasira.put(Item.getItemFromBlock(DQDecorates.DqmBlockOokiihasiraueQ) , 80);

		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaW) , 20);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaWG) , 20);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaS) , 25);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaSG) , 25);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaB) , 30);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaBG) , 30);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaN) , 35);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaNG) , 35);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaI) , 150);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaIG) , 150);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaO) , 300);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaOG) , 300);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaQ) , 350);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaQG) , 350);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaL) , 350);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaLG) , 350);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaR) , 400);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaRG) , 400);

		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaG) , 700);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaGG) , 700);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaE) , 1500);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaEG) , 1500);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaD) , 2000);
		medalDecorateDaiza.put(Item.getItemFromBlock(DQDecorates.DqmBlockDaizaDG) , 2000);

	}

	public int getMedalValue(ItemStack par1)
	{

		Item itm = par1.getItem();
		if(medalWeapon.containsKey(itm))
		{
			return medalWeapon.get(itm);
		}

		if(medalArmor.containsKey(itm))
		{
			return medalArmor.get(itm);
		}

		/*
		if(medalMagic.containsKey(itm))
		{
			return medalMagic.get(itm);
		}

		if(medalMagic2.containsKey(itm))
		{
			return medalMagic2.get(itm);
		}

		if(medalJobchange.containsKey(itm))
		{
			return medalJobchange.get(itm);
		}
		*/

		if(medalItem.containsKey(itm))
		{
			return medalItem.get(itm);
		}

		/*
		if(medalMedal.containsKey(itm))
		{
			return medalMedal.get(itm);
		}
		*/

		if(medalAccessory.containsKey(itm))
		{
			return medalAccessory.get(itm);
		}

		if(medalBuilder.containsKey(itm))
		{
			return medalBuilder.get(itm);
		}



		if(medalDecorate.containsKey(itm))
		{
			return medalDecorate.get(itm);
		}

		if(medalDecorateDaiza.containsKey(itm))
		{
			return medalDecorateDaiza.get(itm);
		}

		if(medalDecorateHasira.containsKey(itm))
		{
			return medalDecorateHasira.get(itm);
		}
		return -1;
	}
}


