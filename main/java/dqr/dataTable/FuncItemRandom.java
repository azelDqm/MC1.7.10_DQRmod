package dqr.dataTable;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import dqr.api.Items.DQBuilders;
import dqr.api.Items.DQEmblems;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMagics;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQSeeds;
import dqr.api.Items.DQWeapons;

public class FuncItemRandom {

	Random rand = new Random();

	public FuncItemRandom(){}

	public ItemStack getWeaponRank1(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(27))
		{
			case 0: item = DQWeapons.itemDounoturugi; break;
			case 1: item = DQWeapons.itemHeisinoken; break;
			case 2: item = DQWeapons.itemReipia; break;
			case 3: item = DQWeapons.itemHaganenoturugi; break;
			case 4: item = DQWeapons.itemMonosasizao; break;
			case 5: item = DQWeapons.itemTakenoyari; break;
			case 6: item = DQWeapons.itemTetunoyari; break;
			case 7: item = DQWeapons.itemKirapiasu; break;
			case 8: item = DQWeapons.itemKudamononaifu; break;
			case 9: item = DQWeapons.itemSeinarunaifu; break;
			case 10: item = DQWeapons.itemTenbinbou; break;
			case 11: item = DQWeapons.itemHaganenokon; break;
			case 12: item = DQWeapons.itemIsinotume; break;
			case 13: item = DQWeapons.itemMajuunotume; break;
			case 14: item = DQWeapons.itemTekkoukagi; break;
			case 15: item = DQWeapons.itemKonbou; break;
			case 16: item = DQWeapons.itemJaiantokurabu; break;
			case 17: item = DQWeapons.itemHaganenoono; break;
			case 18: item = DQWeapons.itemKinoono; break;
			case 19: item = DQWeapons.itemKawanomuti; break;
			case 20: item = DQWeapons.itemIbaranomuti; break;
			case 21: item = DQWeapons.itemSyotobou; break;
			case 22: item = DQWeapons.itemKaryuudonoyumi; break;
			case 23: item = DQWeapons.itemBumeran; break;
			case 24: item = DQWeapons.itemBattlefan; break;
			case 25: item = DQWeapons.itemTetunoougi; break;
			case 26: item = DQWeapons.itemHanenoougi; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}


	public ItemStack getWeaponRank2(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(33))
		{
			case 0: item = DQWeapons.itemKoorinoyaiba; break;
			case 1: item = DQWeapons.itemHajanoturugi; break;
			case 2: item = DQWeapons.itemDoragonkira; break;
			case 3: item = DQWeapons.itemSanzokusaberu; break;
			case 4: item = DQWeapons.itemToraidento; break;
			case 5: item = DQWeapons.itemHaganenoyari; break;
			case 6: item = DQWeapons.itemHaruberuto; break;
			case 7: item = DQWeapons.itemDokuganonaifu; break;
			case 8: item = DQWeapons.itemAsasindaga; break;
			case 9: item = DQWeapons.itemReiniroddo; break;
			case 10: item = DQWeapons.itemBusinnokon; break;
			case 11: item = DQWeapons.itemAkumanotume; break;
			case 12: item = DQWeapons.itemDorirunakkuru; break;
			case 13: item = DQWeapons.itemMayokenotume; break;
			case 14: item = DQWeapons.itemKobusi; break;
			case 15: item = DQWeapons.itemWohanma; break;
			case 16: item = DQWeapons.itemOokanaduti; break;
			case 17: item = DQWeapons.itemDaitinokanaduti; break;
			case 18: item = DQWeapons.itemWohanmakai; break;
			case 19: item = DQWeapons.itemTatujinnoono; break;
			case 20: item = DQWeapons.itemMoonakkusu; break;
			case 21: item = DQWeapons.itemKingakkusu; break;
			case 22: item = DQWeapons.itemBatoruribon; break;
			case 23: item = DQWeapons.itemDoragonteiru; break;
			case 24: item = DQWeapons.itemBasutawipu; break;
			case 25: item = DQWeapons.itemKazekirinoyumi; break;
			case 26: item = DQWeapons.itemYuuwakunoyumi; break;
			case 27: item = DQWeapons.itemKeironnoyumi; break;
			case 28: item = DQWeapons.itemYaibanobumeran; break;
			case 29: item = DQWeapons.itemKurosubumeran; break;
			case 30: item = DQWeapons.itemKamenoougi; break;
			case 31: item = DQWeapons.itemReppuunoougi; break;
			case 32: item = DQWeapons.itemTetunosoroban; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}


	public ItemStack getWeaponRank3(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(23))
		{
			case 0: item = DQWeapons.itemInferunosword; break;
			case 1: item = DQWeapons.itemMakenreipia; break;
			case 2: item = DQWeapons.itemInazumanoyari; break;
			case 3: item = DQWeapons.itemHoriransu; break;
			case 4: item = DQWeapons.itemDokubari; break;
			case 5: item = DQWeapons.itemSodobureika; break;
			case 6: item = DQWeapons.itemDaikokubasira; break;
			case 7: item = DQWeapons.itemOriharukonbou; break;
			case 8: item = DQWeapons.itemHonoonotume; break;
			case 9: item = DQWeapons.itemKoorinotume; break;
			case 10: item = DQWeapons.itemOninokanabou; break;
			case 11: item = DQWeapons.itemGigakurassya; break;
			case 12: item = DQWeapons.itemAtorasunokanaduti; break;
			case 13: item = DQWeapons.itemHaounoono; break;
			case 14: item = DQWeapons.itemFubukinoono; break;
			case 15: item = DQWeapons.itemMegaminomuti; break;
			case 16: item = DQWeapons.itemAkumanomuti; break;
			case 17: item = DQWeapons.itemMugennoyumi; break;
			case 18: item = DQWeapons.itemJigokunoyumi; break;
			case 19: item = DQWeapons.itemIgurufeza; break;
			case 20: item = DQWeapons.itemKazenobumeran; break;
			case 21: item = DQWeapons.itemTorinoougi; break;
			case 22: item = DQWeapons.itemNekonoougi; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getWeaponRank4(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(24))
		{
			case 0: item = DQWeapons.itemSabitarotonoturugi; break;
			case 1: item = DQWeapons.itemPapasunoturugi; break;
			case 2: item = DQWeapons.itemPapasunoturuginew; break;
			case 3: item = DQWeapons.itemHayabusanoturugi; break;
			case 4: item = DQWeapons.itemKisekinoturugi; break;
			case 5: item = DQWeapons.itemMinagorosinoken; break;
			case 6: item = DQWeapons.itemMorohanoturugi; break;
			case 7: item = DQWeapons.itemDemonsupia; break;
			case 8: item = DQWeapons.itemGurakosunoyari; break;
			case 9: item = DQWeapons.itemJigokumasou; break;
			case 10: item = DQWeapons.itemGuradiusu; break;
			case 11: item = DQWeapons.itemDoragonroddo; break;
			case 12: item = DQWeapons.itemOowasinotume; break;
			case 13: item = DQWeapons.itemKobusi2; break;
			case 14: item = DQWeapons.itemMajinnokanaduti; break;
			case 15: item = DQWeapons.itemDaitikudaki; break;
			case 16: item = DQWeapons.itemGureitoakusu; break;
			case 17: item = DQWeapons.itemKarubebuto; break;
			case 18: item = DQWeapons.itemBigbougan; break;
			case 19: item = DQWeapons.itemOdinbou; break;
			case 20: item = DQWeapons.itemHonoonobumeran; break;
			case 21: item = DQWeapons.itemKoorinobumeran; break;
			case 22: item = DQWeapons.itemHebinoougi; break;
			case 23: item = DQWeapons.itemHosinoougi; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getWeaponRank5(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(18))
		{
			case 0: item = DQWeapons.itemOujanoturugi; break;
			case 1: item = DQWeapons.itemRotonoturugi; break;
			case 2: item = DQWeapons.itemMakainoturugi; break;
			case 3: item = DQWeapons.itemMetarukingnoturugi; break;
			case 4: item = DQWeapons.itemSuiseinoturugi; break;
			case 5: item = DQWeapons.itemEiyuunoyari; break;
			case 6: item = DQWeapons.itemSaramanda; break;
			case 7: item = DQWeapons.itemRougabou; break;
			case 8: item = DQWeapons.itemDoragonkuro; break;
			case 9: item = DQWeapons.itemHosikudaki; break;
			case 10: item = DQWeapons.itemFunsainooonata; break;
			case 11: item = DQWeapons.itemGuringamunomuti; break;
			case 12: item = DQWeapons.itemDaitensinoyumi; break;
			case 13: item = DQWeapons.itemKuresentoejji; break;
			case 14: item = DQWeapons.itemMeteoejji; break;
			case 15: item = DQWeapons.itemMahounosoroban; break;
			case 16: item = DQWeapons.itemTukinoougi; break;
			case 17: item = DQWeapons.itemTaiyounoougi; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getWeaponRank6(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(12))
		{
			case 0: item = DQWeapons.itemTenkuunoturugi; break;
			case 1: item = DQWeapons.itemGinganoturugi; break;
			case 2: item = DQWeapons.itemMetarukingnoyari; break;
			case 3: item = DQWeapons.itemToririondaga; break;
			case 4: item = DQWeapons.itemNyoraikon; break;
			case 5: item = DQWeapons.itemSinryuunotume; break;
			case 6: item = DQWeapons.itemKobusi3; break;
			case 7: item = DQWeapons.itemHakainotekkyuu; break;
			case 8: item = DQWeapons.itemGodakkusu; break;
			case 9: item = DQWeapons.itemTyouguringamunomuti; break;
			case 10: item = DQWeapons.itemSefiramunoyumi; break;
			case 11: item = DQWeapons.itemHaipanova; break;
			case 12: item = DQWeapons.itemSeiginosoroban; break;
			case 13: item = DQWeapons.itemSaisyuuougi; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getWeaponRank7(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(14))
		{
			case 0: item = DQWeapons.itemSinken; break;
			case 1: item = DQWeapons.itemGinganoturugi2; break;
			case 2: item = DQWeapons.itemMetarukingnoyari2; break;
			case 3: item = DQWeapons.itemToririondaga2; break;
			case 4: item = DQWeapons.itemNyoraikon2; break;
			case 5: item = DQWeapons.itemSinryuunotume2; break;
			case 6: item = DQWeapons.itemKobusi32; break;
			case 7: item = DQWeapons.itemHakainotekkyuu2; break;
			case 8: item = DQWeapons.itemGodakkusu2; break;
			case 9: item = DQWeapons.itemTyouguringamunomuti2; break;
			case 10: item = DQWeapons.itemSefiramunoyumi2; break;
			case 11: item = DQWeapons.itemHaipanova2; break;
			case 12: item = DQWeapons.itemSaisyuuougi2; break;
			case 13: item = DQWeapons.itemSeiginosoroban2; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getMagicRank1(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(7))
		{
			case 0:item = DQMagics.itemMera; break;
			case 1:item = DQMagics.itemGira; break;
			case 2:item = DQMagics.itemHyado; break;
			case 3:item = DQMagics.itemIo; break;
			case 4:item = DQMagics.itemBagi; break;
			case 5:item = DQMagics.itemHoimi; break;
			case 6:item = DQMagics.itemKiari; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}

	}

	public ItemStack getMagicRank2(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(12))
		{
			case 0:item = DQMagics.itemMerami; break;
			case 1:item = DQMagics.itemBegirama; break;
			case 2:item = DQMagics.itemHyadaruko; break;
			case 3:item = DQMagics.itemIora; break;
			case 4:item = DQMagics.itemBagima; break;
			case 5:item = DQMagics.itemBehoimi; break;
			case 6:item = DQMagics.itemRura; break;
			case 7:item = DQMagics.itemMahoimi; break;
			case 8:item = DQMagics.itemDoruma; break;
			case 9:item = DQMagics.itemRemira; break;
			case 10:item = DQMagics.itemCallCloud; break;
			case 11:item = DQMagics.itemHikarinotue; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}

	}

	public ItemStack getMagicRank3(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(12))
		{
			case 0:item = DQMagics.itemRuraC; break;
			case 1:item = DQMagics.itemRuraR; break;
			case 2:item = DQMagics.itemRuraG; break;
			case 3:item = DQMagics.itemRuraB; break;
			case 4:item = DQMagics.itemRuraY; break;
			case 5:item = DQMagics.itemSukara; break;
			case 6:item = DQMagics.itemBaha; break;
			case 7:item = DQMagics.itemPiora; break;
			case 8:item = DQMagics.itemManusa; break;
			case 9:item = DQMagics.itemMahoton; break;
			case 10:item = DQMagics.itemUminarinotue; break;
			case 11:item = DQMagics.itemRaidein; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getMagicRank4(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(23))
		{
			case 0:item = DQMagics.itemBaikiruto; break;
			case 1:item = DQMagics.itemMerazoma; break;
			case 2:item = DQMagics.itemBegiragon; break;
			case 3:item = DQMagics.itemMahyado; break;
			case 4:item = DQMagics.itemIonazun; break;
			case 5:item = DQMagics.itemBagikurosu; break;
			case 6:item = DQMagics.itemBehoma; break;
			case 7:item = DQMagics.itemRuraRC; break;
			case 8:item = DQMagics.itemRuraGC; break;
			case 9:item = DQMagics.itemRuraBC; break;
			case 10:item = DQMagics.itemRuraYC; break;
			case 11:item = DQMagics.itemMagicbaria; break;
			case 12:item = DQMagics.itemMahokanta; break;
			case 13:item = DQMagics.itemFubaha; break;
			case 14:item = DQMagics.itemBomie; break;
			case 15:item = DQMagics.itemRariho; break;
			case 16:item = DQMagics.itemRukani; break;
			case 17:item = DQMagics.itemMedapani; break;
			case 18:item = DQMagics.itemDivainsuperu; break;
			case 19:item = DQMagics.itemCallMagma; break;
			case 20:item = DQMagics.itemMahoriku; break;
			case 21:item = DQMagics.itemZaki; break;
			case 22:item = DQMagics.itemDorukuma; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}


	public ItemStack getMagicRank5(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(10))
		{
			case 0:item = DQMagics.itemGigadein; break;
			case 1:item = DQMagics.itemSukuruto; break;
			case 2:item = DQMagics.itemPiorimu; break;
			case 3:item = DQMagics.itemHenatosu; break;
			case 4:item = DQMagics.itemRukanan; break;
			case 5:item = DQMagics.itemRarihoma; break;
			case 6:item = DQMagics.itemBomiosu; break;
			case 7:item = DQMagics.itemBehomara; break;
			case 8:item = DQMagics.itemZaraki; break;
			case 9:item = DQMagics.itemDorumoa; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getMagicRank6(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(5))
		{
			case 0:item = DQMagics.itemBehomazun; break;
			case 1:item = DQMagics.itemMahoizun; break;
			case 2:item = DQMagics.itemMinadein; break;
			case 3:item = DQMagics.itemZarakima; break;
			case 4:item = DQMagics.itemDorumadon; break;
			case 5:item = DQMagics.itemMeragaia; break;
			case 6:item = DQMagics.itemGiragureido; break;
			case 7:item = DQMagics.itemMahyadodesu; break;
			case 8:item = DQMagics.itemBagimutyo; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getMagicRankETC(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(14))
		{
			case 0:item = DQMagics.itemZaoraru; break;
			case 1:item = DQMagics.itemZaoriku; break;
			case 2:item = DQMagics.itemHaigou; break;
			case 3:item = DQMagics.itemHaigou2; break;
			case 4:item = DQMagics.itemParupunte; break;
			case 5:item = DQMagics.itemRurasin; break;
			case 6:item = DQMagics.itemRurasin2; break;
			case 7:item = DQMagics.itemMahouken1; break;
			case 8:item = DQMagics.itemMahouken2; break;
			case 9:item = DQMagics.itemMahouken3; break;
			case 10:item = DQMagics.itemMahouken4; break;
			case 11:item = DQMagics.itemMahouken5; break;
			case 12:item = DQMagics.itemMahouken6; break;
			case 13:item = DQMagics.itemMahouken7; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getEmblemRank1(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(9))
		{
			case 0: item = DQEmblems.itemEmbCivilian; break;
			case 1: item = DQEmblems.itemEmbWarrior; break;
			case 2: item = DQEmblems.itemEmbFighter; break;
			case 3: item = DQEmblems.itemEmbMagician; break;
			case 4: item = DQEmblems.itemEmbPriest; break;
			case 5: item = DQEmblems.itemEmbMerchant; break;
			case 6: item = DQEmblems.itemEmbThief; break;
			case 7: item = DQEmblems.itemEmbFunanori; break;
			case 8: item = DQEmblems.itemEmbHituzikai; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}

	}

	public ItemStack getEmblemRank2(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(8))
		{
			case 0: item = DQEmblems.itemEmbBattleMaster; break;
			case 1: item = DQEmblems.itemEmbSage; break;
			case 2: item = DQEmblems.itemEmbPaladin; break;
			case 3: item = DQEmblems.itemEmbMagickKnight; break;
			case 4: item = DQEmblems.itemEmbRanger; break;
			case 5: item = DQEmblems.itemEmbDancer; break;
			case 6: item = DQEmblems.itemEmbPirate; break;
			case 7: item = DQEmblems.itemEmbMonsterTamer; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}

	}

	public ItemStack getEmblemRank3(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(5))
		{
			case 0: item = DQEmblems.itemEmbHero; break;
			case 1: item = DQEmblems.itemEmbDougutukai; break;
			case 2: item = DQEmblems.itemEmbTentiraimeishi; break;
			case 3: item = DQEmblems.itemEmbSuperStar; break;
			case 4: item = DQEmblems.itemEmbGodHnad; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getEmblemRankX(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(4))
		{
			case 0: item = DQEmblems.itemEmbHaguremetal; break;
			case 1: item = DQEmblems.itemEmbDragon; break;
			case 2: item = DQEmblems.itemEmbLegend; break;
			case 3: item = DQEmblems.itemEmbMasterDragon; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getIngotRank1(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(3))
		{
			case 0:item = DQIngots.itemMigakizuna; break;
			case 1:item = DQIngots.itemTekkouseki; break;
			case 2:item = DQIngots.itemYougansekinokakera; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getIngotRank2(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(5))
		{
			case 0:item = DQIngots.itemHosinokakera; break;
			case 1:item = DQIngots.itemInotinoisi; break;
			case 2:item = DQIngots.itemKagaminoisi; break;
			case 3:item = DQIngots.itemKoorinokessyou; break;
			case 4:item = DQIngots.itemMoon; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getIngotRank3(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(4))
		{
			case 0:item = DQIngots.itemBakudanisi; break;
			case 1:item = DQIngots.itemPuratina; break;
			case 2:item = DQIngots.itemRubinogenseki; break;
			case 3:item = DQIngots.itemTokinosuisyou; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getIngotRank4(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(4))
		{
			case 0:item = DQIngots.itemHikarinoisi; break;
			case 1:item = DQIngots.itemMisriru; break;
			case 2:item = DQIngots.itemTaiyounoisi; break;
			case 3:item = DQIngots.itemOriharukon; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getIngotRank5(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(3))
		{
			case 0:item = DQIngots.itemPuratina2; break;
			case 1:item = DQIngots.itemMisriru2; break;
			case 3:item = DQIngots.itemOriharukon2; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getMiscsRank1(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(20))
		{
			case 0: item = DQMiscs.itemAkaisango; break;
			case 1: item = DQMiscs.itemDokudokuhedoro; break;
			case 2: item = DQMiscs.itemGamanoabura; break;
			case 3: item = DQMiscs.itemHonehone; break;
			case 4: item = DQMiscs.itemKimeranotubasa; break;
			case 5: item = DQMiscs.itemKoumorinohane; break;
			case 6: item = DQMiscs.itemMajuunokawa; break;
			case 7: item = DQMiscs.itemMidorinokoke; break;
			case 8: item = DQMiscs.itemNebanebazeri; break;
			case 9: item = DQMiscs.itemNekozuna; break;
			case 10: item = DQMiscs.itemTiisaitamasii; break;
			case 11: item = DQMiscs.itemSiroikaigara; break;
			case 12: item = DQMiscs.itemSuraimuosyarebana; break;
			case 13: item = DQMiscs.itemSuraimuzeri; break;
			case 14: item = DQMiscs.itemTukemonoisi; break;
			case 15: item = DQMiscs.itemTyounohane; break;
			case 16: item = DQMiscs.itemUmanofun; break;
			case 17: item = DQMiscs.itemUsaginosippo; break;
			case 18: item = DQMiscs.itemUsinofun; break;
			case 19: item = DQMiscs.itemYawarakauru; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}


	public ItemStack getMiscsRank2(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(22))
		{
			case 0: item = DQMiscs.itemHananomitu; break;
			case 1: item = DQMiscs.itemHebinonukegara; break;
			case 2: item = DQMiscs.itemMadarakumonoito; break;
			case 3: item = DQMiscs.itemTetunokugi; break;
			case 4: item = DQMiscs.itemDokuganokona; break;
			case 5: item = DQMiscs.itemSeisui; break;
			case 6: item = DQMiscs.itemKimeranotubasaB; break;
			case 7: item = DQMiscs.itemKimeranotubasaG; break;
			case 8: item = DQMiscs.itemKimeranotubasaR; break;
			case 9: item = DQMiscs.itemKimeranotubasaY; break;
			case 10: item = DQMiscs.itemMeijikimeranohane; break;
			case 11: item = DQMiscs.itemRisaikurusuton; break;
			case 12: item = DQMiscs.itemTensinohane; break;
			case 13: item = DQMiscs.itemTogetogenokiba; break;
			case 14: item = DQMiscs.itemUruwasikinoko; break;
			case 15: item = DQMiscs.itemYogoretahoutai; break;
			case 16: item = DQMiscs.itemYorunotobari; break;
			case 17: item = DQMiscs.itemSeijanohai; break;
			case 18: item = DQMiscs.itemKenjanoisi; break;
			case 19: item = DQMiscs.itemPapasunokatami; break;
			case 20: item = DQMiscs.itemSekaijunoha; break;
			case 21: item = DQMiscs.itemSuraimunokanmuri; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}


	public ItemStack getMiscsRank3(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(27))
		{
			case 0: item = DQMiscs.itemMajuunotuno; break;
			case 1: item = DQMiscs.itemBudouekisu; break;
			case 2: item = DQMiscs.itemHaganenoobane; break;
			case 3: item = DQMiscs.itemHyoutyounohane; break;
			case 4: item = DQMiscs.itemJuryokunomoto; break;
			case 5: item = DQMiscs.itemKazekirinohane; break;
			case 6: item = DQMiscs.itemKiyomenomizu; break;
			case 7: item = DQMiscs.itemKyodaihigetokage; break;
			case 8: item = DQMiscs.itemKyodainakiba; break;
			case 9: item = DQMiscs.itemRengokunohane; break;
			case 10: item = DQMiscs.itemAyakasisou; break;
			case 11: item = DQMiscs.itemAyasiikobin; break;
			case 12: item = DQMiscs.itemBekkou; break;
			case 13: item = DQMiscs.itemIkazutinotama; break;
			case 14: item = DQMiscs.itemKimeranotubasa2; break;
			case 15: item = DQMiscs.itemKingdaiya; break;
			case 16: item = DQMiscs.itemKinkai; break;
			case 17: item = DQMiscs.itemMaryokunotuti; break;
			case 18: item = DQMiscs.itemMetaru; break;
			case 19: item = DQMiscs.itemTukinomegumi; break;
			case 20: item = DQMiscs.itemGenmaseki; break;
			case 21: item = DQMiscs.itemSeireiseki; break;
			case 22: item = DQMiscs.itemHepaitosunohidane; break;
			case 23: item = DQMiscs.itemMetaloubu; break;
			case 24: item = DQMiscs.itemTouzokunokagi; break;
			case 25: item = DQMiscs.itemKenjanoseisui; break;
			case 26: item = DQMiscs.itemMahounokagi; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}


	public ItemStack getMiscsRank4(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(8))
		{
			case 0: item = DQMiscs.itemPisaronotamasii; break;
			case 1: item = DQMiscs.itemSeinarusizuku; break;
			case 2: item = DQMiscs.itemDoragonnonamida; break;
			case 3: item = DQMiscs.itemNijiirononunokire; break;
			case 4: item = DQMiscs.itemRyuunohizake; break;
			case 5: item = DQMiscs.itemRyuunonamida; break;
			case 6: item = DQMiscs.itemSinkanohiseki; break;
			case 7: item = DQMiscs.itemUraminohouju; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getMiscsRank5(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(16))
		{
			case 0: item = DQMiscs.itemSaezurinomitu; break;
			case 1: item = DQMiscs.itemAmatuyunoito; break;
			case 2: item = DQMiscs.itemTensinosoma; break;
			case 3: item = DQMiscs.itemToukonekisu; break;
			case 4: item = DQMiscs.itemDragonwing; break;
			case 5: item = DQMiscs.itemBuruoubu; break;
			case 6: item = DQMiscs.itemGenmasekiB; break;
			case 7: item = DQMiscs.itemGenmasekiG; break;
			case 8: item = DQMiscs.itemGurinoubu; break;
			case 9: item = DQMiscs.itemIerooubu; break;
			case 10: item = DQMiscs.itemMysteryEgg; break;
			case 11: item = DQMiscs.itemPaapuruoubu; break;
			case 12: item = DQMiscs.itemRamia; break;
			case 13: item = DQMiscs.itemRedoubu; break;
			case 14: item = DQMiscs.itemRozarinonamida; break;
			case 15: item = DQMiscs.itemSaigonokagi; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getMiscsRank6(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(3))
		{
			case 0: item = DQMiscs.itemSaezurinomitu; break;
			case 1: item = DQMiscs.itemAmatuyunoito; break;
			case 2: item = Item.getItemFromBlock(Blocks.emerald_block); break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getFoodRank1(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(4))
		{
			case 0: item = DQSeeds.itemYakusou; break;
			case 1: item = DQSeeds.itemDokukesisou; break;
			case 2: item = DQSeeds.itemJouyakusou; break;
			case 3: item = DQSeeds.itemBannouyaku; break;

		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getFoodRank2(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(4))
		{
			case 0: item = DQSeeds.itemMamorinotane; break;
			case 1: item = DQSeeds.itemSubayasanotane; break;
			case 2: item = DQSeeds.itemTikaranotane; break;
			case 3: item = DQSeeds.itemTokuyakusou; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getBuilderRank1(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(9))
		{
			case 0: item = DQBuilders.itemBuilderDama1; break;
			case 1: item = DQBuilders.itemBuilderDama2; break;
			case 2: item = DQBuilders.itemBuilderDama3; break;
			case 3: item = DQBuilders.itemBuilderDama4; break;
			case 4: item = DQBuilders.itemBuilderDama5; break;
			case 5: item = DQBuilders.itemBuilderDama6; break;
			case 6: item = DQBuilders.itemBuilderDama7; break;
			case 7: item = DQBuilders.itemBuilderDama8; break;
			case 8: item = DQBuilders.itemBuilderDama9; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getBuilderRank2(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(14))
		{
			case 0: item = DQBuilders.itemBuilderDamaS1; break;
			case 1: item = DQBuilders.itemBuilderDamaS2; break;
			case 2: item = DQBuilders.itemBuilderDamaS3; break;
			case 3: item = DQBuilders.itemBuilderDamaS4; break;
			case 4: item = DQBuilders.itemBuilderDamaS5; break;
			case 5: item = DQBuilders.itemBuilderDamaS6; break;
			case 6: item = DQBuilders.itemBuilderDamaS7; break;
			case 7: item = DQBuilders.itemBuilderDamaS8; break;
			case 8: item = DQBuilders.itemBuilderDamaS9; break;
			case 9: item = DQBuilders.itemBuilderIdoMedal; break;
			case 10: item = DQBuilders.itemBuilderShopSyuuriya; break;
			case 11: item = DQBuilders.itemBuilderShopBank; break;
			case 12: item = DQBuilders.itemBuilderShopKaitoriya; break;
			case 13: item = DQBuilders.itemBuilderShopBukiya; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	public ItemStack getBuilderRank3(int par1, int value)
	{
		if(rand.nextInt(par1) != 0)
		{
			return null;
		}

		Item item = null;


		switch(rand.nextInt(14))
		{
			case 0: item = DQBuilders.itemBuilderDamaW1; break;
			case 1: item = DQBuilders.itemBuilderDamaW2; break;
			case 2: item = DQBuilders.itemBuilderDamaW3; break;
			case 3: item = DQBuilders.itemBuilderDamaW4; break;
			case 4: item = DQBuilders.itemBuilderDamaW5; break;
			case 5: item = DQBuilders.itemBuilderDamaW6; break;
			case 6: item = DQBuilders.itemBuilderDamaW7; break;
			case 7: item = DQBuilders.itemBuilderDamaW8; break;
			case 8: item = DQBuilders.itemBuilderDamaW9; break;
			case 9: item = DQBuilders.itemBuilderIdoMedal; break;
			case 10: item = DQBuilders.itemBuilderShopSyuuriya; break;
			case 11: item = DQBuilders.itemBuilderShopBank; break;
			case 12: item = DQBuilders.itemBuilderShopKaitoriya; break;
			case 13: item = DQBuilders.itemBuilderShopBukiya; break;
		}

		if(item != null)
		{
			return new ItemStack(item, rand.nextInt(value) + 1, 0);
		}else
		{
			return null;
		}
	}

	//スポブロ部屋地上1
    public void generateChestContentsRank1(Random rand, IInventory inv)
    {
    	int looper = 0;
    	int slotNo = 0;


    	//転職系1
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	inv.setInventorySlotContents(slotNo, getEmblemRank1(15, 1));
        }

    	//素材
    	looper = rand.nextInt(6);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getMiscsRank1(1, 4));
        	}
        }

    	//素材2

    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
            	inv.setInventorySlotContents(slotNo, getMiscsRank2(2, 2));
        	}
        }


    	//薬草系
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getFoodRank1(1, 3));
        	}

        }

    	//薬草系2
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getFoodRank2(2, 2));
        	}
        }

    	//鉱石系1
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank1(3, 3));
        	}
        }

    	//鉱石系2
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank2(3, 2));
        	}
        }

        //建築パーツ
        if(rand.nextInt(3) == 0)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getBuilderRank1(1, 1));
        	}
        }
    }

  //スポブロ部屋地上2
    public void generateChestContentsRank2(Random rand, IInventory inv)
    {
    	int looper = 0;
    	int slotNo = 0;

    	//転職系1
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getEmblemRank1(10, 1));
        	}
        }

    	//素材
    	looper = rand.nextInt(4);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getMiscsRank1(1, 4));
        	}
        }

    	//素材2

    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getMiscsRank2(1, 2));
        	}
        }


    	//薬草系
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getFoodRank1(1, 3));
        	}
        }

    	//薬草系2
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getFoodRank2(1, 2));
        	}
        }

    	//鉱石系1
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank1(2, 4));
        	}
        }

    	//鉱石系2
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank2(2, 3));
        	}
        }

    	//鉱石系3
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank3(3, 2));
        	}
        }

        //建築パーツ
    	slotNo = rand.nextInt(inv.getSizeInventory());
    	if(inv.getStackInSlot(slotNo) == null)
    	{
	        switch(rand.nextInt(4))
	        {
	        	case 0: inv.setInventorySlotContents(slotNo, getBuilderRank1(1, 1));break;
	        	case 1: inv.setInventorySlotContents(slotNo, getBuilderRank2(2, 1));break;
	        }
    	}

    }

    //スポブロ部屋ネザー
    public void generateChestContentsRank3(Random rand, IInventory inv)
    {
    	int looper = 0;
    	int slotNo = 0;

    	//転職系1
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getEmblemRank1(10, 1));
        	}
        }

    	//転職系2
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getEmblemRank2(15, 1));
        	}
        }

    	//素材
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
            	inv.setInventorySlotContents(slotNo, getMiscsRank1(1, 3));
        	}
        }

    	//素材2

    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getMiscsRank2(1, 3));
        	}
        }

    	//素材3
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
            	inv.setInventorySlotContents(slotNo, getMiscsRank3(2, 3));
        	}
        }

    	//薬草系
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
            	inv.setInventorySlotContents(slotNo, getFoodRank1(1, 3));
        	}
        }

    	//薬草系2
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getFoodRank2(1, 3));
        	}
        }

    	//鉱石系1
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank1(1, 3));
        	}
        }

    	//鉱石系2
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank1(1, 3));
        	}
        }

    	//鉱石系3
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank1(1, 3));
        	}
        }

    	//鉱石系4
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank4(4, 1));
        	}
        }

        //建築パーツ
    	slotNo = rand.nextInt(inv.getSizeInventory());
    	if(inv.getStackInSlot(slotNo) == null)
    	{
	        switch(rand.nextInt(5))
	        {
	        	case 0: inv.setInventorySlotContents(slotNo, getBuilderRank1(1, 1));break;
	        	case 1: inv.setInventorySlotContents(slotNo, getBuilderRank2(1, 1));break;
	        	case 2: inv.setInventorySlotContents(slotNo, getBuilderRank3(2, 1));break;
	        }
    	}
    }


    //スポブロ部屋エンド
    public void generateChestContentsRank4(Random rand, IInventory inv)
    {
    	int looper = 0;
    	int slotNo = 0;


    	//転職系2
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getEmblemRank2(10, 1));
        	}
        }

    	//転職系3
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getEmblemRank3(20, 1));
        	}
        }

    	//転職系1
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getEmblemRank1(5, 1));
        	}
        }

    	//素材
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getMiscsRank1(1, 4));
        	}
        }

    	//素材2
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
            	inv.setInventorySlotContents(slotNo, getMiscsRank2(1, 4));
        	}
        }

    	//素材3
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getMiscsRank3(2, 3));
        	}
        }

    	//素材4
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getMiscsRank3(3, 2));
        	}
        }

    	//薬草系
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getFoodRank1(1, 3));
        	}
        }

    	//薬草系2
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getFoodRank2(1, 3));
        	}
        }

    	//鉱石系1
    	looper = rand.nextInt(3);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank1(1, 3));
        	}
        }

    	//鉱石系2
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank1(1, 3));
        	}
        }

    	//鉱石系3
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank1(1, 3));
        	}
        }

    	//鉱石系4
    	looper = rand.nextInt(2);
        for (int j = 0; j < looper; ++j)
        {
        	slotNo = rand.nextInt(inv.getSizeInventory());
        	if(inv.getStackInSlot(slotNo) == null)
        	{
        		inv.setInventorySlotContents(slotNo, getIngotRank4(2, 1));
        	}
        }

        //建築パーツ
    	slotNo = rand.nextInt(inv.getSizeInventory());
    	if(inv.getStackInSlot(slotNo) == null)
    	{
	        switch(rand.nextInt(3))
	        {
	        	case 0: inv.setInventorySlotContents(slotNo, getBuilderRank1(1, 1));break;
	        	case 1: inv.setInventorySlotContents(slotNo, getBuilderRank2(1, 1));break;
	        	case 2: inv.setInventorySlotContents(slotNo, getBuilderRank3(1, 1));break;
	        }
    	}


    }
}
