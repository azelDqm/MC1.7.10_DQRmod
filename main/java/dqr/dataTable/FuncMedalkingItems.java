package dqr.dataTable;

import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.Blocks.DQDecorates;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQArmors;
import dqr.api.Items.DQBuilders;
import dqr.api.Items.DQEmblems;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMagics;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQWeapons;

public class FuncMedalkingItems {

	public static final Map<Item, Integer> medalWeapon = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalArmor = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalMagic = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalMagic2 = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalJobchange = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalItem = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalMedal = new LinkedHashMap<>();
	public static final Map<Item, Integer> medalAccessory = new LinkedHashMap<>();

	public FuncMedalkingItems()
	{
		//武器

		//(17)
		medalWeapon.put(DQWeapons.itemKisekinoturugi, 100);
		medalWeapon.put(DQWeapons.itemHayabusanoturugi, 100);
		medalWeapon.put(DQWeapons.itemSabitarotonoturugi, 300);
		medalWeapon.put(DQWeapons.itemOujanoturugi, 500);
		medalWeapon.put(DQWeapons.itemMakainoturugi, 500);
		medalWeapon.put(DQWeapons.itemMetarukingnoturugi, 500);
		medalWeapon.put(DQWeapons.itemSuiseinoturugi, 500);
		medalWeapon.put(DQWeapons.itemEiyuunoyari, 500);
		medalWeapon.put(DQWeapons.itemSaramanda, 500);
		medalWeapon.put(DQWeapons.itemRougabou, 500);
		medalWeapon.put(DQWeapons.itemDoragonkuro, 500);
		medalWeapon.put(DQWeapons.itemHosikudaki, 500);
		medalWeapon.put(DQWeapons.itemFunsainooonata, 500);
		medalWeapon.put(DQWeapons.itemGuringamunomuti, 500);
		medalWeapon.put(DQWeapons.itemDaitensinoyumi, 500);
		medalWeapon.put(DQWeapons.itemKuresentoejji, 500);
		medalWeapon.put(DQWeapons.itemMeteoejji, 500);

		//(13)
		medalWeapon.put(DQWeapons.itemTenkuunoturugi, 1000);
		medalWeapon.put(DQWeapons.itemGinganoturugi, 1000);
		medalWeapon.put(DQWeapons.itemMetarukingnoyari, 1000);
		medalWeapon.put(DQWeapons.itemToririondaga, 1000);
		medalWeapon.put(DQWeapons.itemNyoraikon, 1000);
		medalWeapon.put(DQWeapons.itemSinryuunotume, 1000);
		medalWeapon.put(DQWeapons.itemKobusi3, 1000);
		medalWeapon.put(DQWeapons.itemHakainotekkyuu, 1000);
		medalWeapon.put(DQWeapons.itemGodakkusu, 1000);
		medalWeapon.put(DQWeapons.itemTyouguringamunomuti, 1000);
		medalWeapon.put(DQWeapons.itemSefiramunoyumi, 1000);
		medalWeapon.put(DQWeapons.itemHaipanova, 1000);
		medalWeapon.put(DQWeapons.itemSeiginosoroban, 1000);
		medalWeapon.put(DQWeapons.itemSaisyuuougi, 1000);
		medalWeapon.put(DQWeapons.itemSinken, 3000);


		//防具
		//22
		medalArmor.put(DQArmors.itemSuraimunokanmuriK , 50);
		medalArmor.put(DQArmors.itemArakuremasuku , 50);
		medalArmor.put(DQArmors.itemUsamimibando , 50);
		medalArmor.put(DQArmors.itemNekomimibando , 50);
		medalArmor.put(DQArmors.itemBanisutu , 50);
		medalArmor.put(DQArmors.itemAmitaitu , 50);
		medalArmor.put(DQArmors.itemHaihiru , 50);
		medalArmor.put(DQArmors.itemFantomumasuku , 100);
		medalArmor.put(DQArmors.itemKenjanobousi , 100);
		medalArmor.put(DQArmors.itemKenjanoroubu , 100);
		medalArmor.put(DQArmors.itemKenjanotebukuro , 100);
		medalArmor.put(DQArmors.itemKenjanokutu , 100);
		medalArmor.put(DQArmors.itemAbunaimizugiue , 150);
		medalArmor.put(DQArmors.itemAbunaimizugisita , 150);
		medalArmor.put(DQArmors.itemSabitayoroi , 250);
		medalArmor.put(DQArmors.itemSiawasenobousi , 250);
		medalArmor.put(DQArmors.itemSiawasenokutu , 250);
		medalArmor.put(DQArmors.itemMetarukingnokabuto , 250);
		medalArmor.put(DQArmors.itemMetarukingnoyoroi , 250);
		medalArmor.put(DQArmors.itemMetarukingnokote , 250);
		medalArmor.put(DQArmors.itemMetarukingnokutu , 250);
		medalArmor.put(DQArmors.itemTenkuunoyoroi , 500);

		//13
		medalAccessory.put(DQAccessories.itemSeidounotate , 50);
		medalAccessory.put(DQAccessories.itemMayokenoseiin , 50);
		medalAccessory.put(DQAccessories.itemKirapiasu2 , 75);
		medalAccessory.put(DQAccessories.itemHosifuru , 75);
		medalAccessory.put(DQAccessories.itemInotinoyubiwa , 75);
		medalAccessory.put(DQAccessories.itemHayatenoring , 75);
		medalAccessory.put(DQAccessories.itemMahounopiasu , 100);
		medalAccessory.put(DQAccessories.itemTikaranorubi , 100);
		medalAccessory.put(DQAccessories.itemMamorinorubi , 100);
		medalAccessory.put(DQAccessories.itemGouketunoudewa , 200);
		medalAccessory.put(DQAccessories.itemMamorinoudewa , 200);
		medalAccessory.put(DQAccessories.itemKataminokubikazari , 200);
		medalAccessory.put(DQAccessories.itemFurubitaring , 300);
		medalAccessory.put(DQAccessories.itemRakkipendanto , 300);
		medalAccessory.put(DQAccessories.itemHosizoranokubikazari, 750);
		medalAccessory.put(DQAccessories.itemSuparing , 1000);
		medalAccessory.put(DQAccessories.itemSosararing , 1000);


		//魔法1
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



		//魔法2
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

		//転職
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


		//道具
		medalItem.put(DQMiscs.itemKimeranotubasa , 3);
		medalItem.put(Item.getItemFromBlock(DQDecorates.DqmBlockDqmbed) , 5);
		medalItem.put(DQIngots.itemTaiyounoisi , 5);
		medalItem.put(DQIngots.itemHikarinoisi , 5);
		medalItem.put(DQIngots.itemMisriru , 5);
		medalItem.put(DQIngots.itemOriharukon , 15);
		medalItem.put(DQBuilders.itemBuilderDama , 500);
		medalItem.put(DQBuilders.itemBuilderDamaS , 500);
		medalItem.put(DQBuilders.itemBuilderDamaW , 500);

		//メダル
		medalMedal.put(DQMiscs.itemLittlemedal , 1);
		medalMedal.put(DQMiscs.itemLittlemedal5 , 5);
		medalMedal.put(DQMiscs.itemLittlemedal10 , 10);
		medalMedal.put(DQMiscs.itemLittlemedal50 , 50);
		medalMedal.put(DQMiscs.itemLittlemedal100 , 100);
		medalMedal.put(DQMiscs.itemLittlemedal500 , 500);
		medalMedal.put(DQMiscs.itemLittlemedal1000 , 1000);
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

		if(medalItem.containsKey(itm))
		{
			return medalItem.get(itm);
		}

		if(medalMedal.containsKey(itm))
		{
			return medalMedal.get(itm);
		}

		if(medalAccessory.containsKey(itm))
		{
			return medalAccessory.get(itm);
		}
		return -1;
	}
}


