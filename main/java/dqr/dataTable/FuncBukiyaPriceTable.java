package dqr.dataTable;

import net.minecraft.item.Item;
import dqr.api.Items.DQArmors;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQWeapons;

public class FuncBukiyaPriceTable {

	public FuncBukiyaPriceTable(){}

	public static int GoldOverWorld(int randomNum, int isDay)
	{
		if(isDay == 0)
		{
			return GoldDay(randomNum);
		}else
		{
			return GoldNight(randomNum);
		}
	}

	public static Item ItemOverWorld(int randomNum, int isDay)
	{
		if(isDay == 0)
		{
			return ItemDay(randomNum);
		}else
		{
			return ItemNight(randomNum);
		}
	}

    public static int GoldDay(int randomNum)
    {

        if (randomNum == 0)
        {
            return 50 * 2;
        }

        if (randomNum == 1)
        {
            return 100 * 2;
        }

        if (randomNum == 2)
        {
            return 100 * 2;
        }

        if (randomNum == 3)
        {
            return 100 * 2;
        }

        if (randomNum == 4)
        {
            return 100 * 2;
        }

        if (randomNum == 5)
        {
            return 100 * 2;
        }

        if (randomNum == 6)
        {
            return 150 * 2;
        }

        if (randomNum == 7)
        {
            return 150 * 2;
        }

        if (randomNum == 8)
        {
            return 200 * 2;
        }

        if (randomNum == 9)
        {
            return 200 * 2;
        }

        if (randomNum == 10)
        {
            return 200 * 2;
        }

        if (randomNum == 11)
        {
            return 200 * 2;
        }

        if (randomNum == 12)
        {
            return 200 * 2;
        }

        if (randomNum == 13)
        {
            return 200 * 2;
        }

        if (randomNum == 14)
        {
            return 200 * 2;
        }

        if (randomNum == 15)
        {
            return 250 * 2;
        }

        if (randomNum == 16)
        {
            return 250 * 2;
        }

        if (randomNum == 17)
        {
            return 250 * 2;
        }

        if (randomNum == 18)
        {
            return 300 * 2;
        }

        if (randomNum == 19)
        {
            return 300 * 2;
        }

        if (randomNum == 20)
        {
            return 350 * 2;
        }

        if (randomNum == 21)
        {
            return 350 * 2;
        }

        if (randomNum == 22)
        {
            return 350 * 2;
        }

        if (randomNum == 23)
        {
            return 400 * 2;
        }

        if (randomNum == 24)
        {
            return 400 * 2;
        }

        if (randomNum == 25)
        {
            return 450 * 2;
        }

        if (randomNum == 26)
        {
            return 450 * 2;
        }

        if (randomNum == 27)
        {
            return 450 * 2;
        }

        if (randomNum == 28)
        {
            return 500 * 2;
        }

        if (randomNum == 29)
        {
            return 500 * 2;
        }

        if (randomNum == 30)
        {
            return 500 * 2;
        }

        if (randomNum == 31)
        {
            return 500 * 2;
        }

        if (randomNum == 32)
        {
            return 500 * 2;
        }

        if (randomNum == 33)
        {
            return 500 * 2;
        }

        if (randomNum == 34)
        {
            return 550 * 2;
        }

        if (randomNum == 35)
        {
            return 550 * 2;
        }

        if (randomNum == 36)
        {
            return 600 * 2;
        }

        if (randomNum == 37)
        {
            return 650 * 2;
        }

        if (randomNum == 38)
        {
            return 650 * 2;
        }

        if (randomNum == 39)
        {
            return 750 * 2;
        }

        if (randomNum == 40)
        {
            return 750 * 2;
        }

        if (randomNum == 41)
        {
            return 800 * 2;
        }

        if (randomNum == 42)
        {
            return 800 * 2;
        }

        if (randomNum == 43)
        {
            return 800 * 2;
        }

        if (randomNum == 44)
        {
            return 2500 * 2;
        }

        if (randomNum == 45)
        {
            return 800 * 2;
        }

        if (randomNum == 46)
        {
            return 800 * 2;
        }

        if (randomNum == 47)
        {
            return 800 * 2;
        }

        if (randomNum == 48)
        {
            return 800 * 2;
        }

        if (randomNum == 49)
        {
            return 800 * 2;
        }

        if (randomNum == 50)
        {
            return 800 * 2;
        }

        if (randomNum == 51)
        {
            return 850 * 2;
        }

        if (randomNum == 52)
        {
            return 850 * 2;
        }

        if (randomNum == 53)
        {
            return 850 * 2;
        }

        if (randomNum == 54)
        {
            return 1000 * 2;
        }

        if (randomNum == 55)
        {
            return 1000 * 2;
        }

        if (randomNum == 56)
        {
            return 1000 * 2;
        }

        if (randomNum == 57)
        {
            return 1000 * 2;
        }

        if (randomNum == 58)
        {
            return 1000 * 2;
        }

        if (randomNum == 59)
        {
            return 1000 * 2;
        }

        if (randomNum == 60)
        {
            return 1000 * 2;
        }

        if (randomNum == 61)
        {
            return 1000 * 2;
        }

        if (randomNum == 62)
        {
            return 1000 * 2;
        }

        if (randomNum == 63)
        {
            return 1000 * 2;
        }

        if (randomNum == 64)
        {
            return 1000 * 2;
        }

        if (randomNum >= 65 && randomNum <= 70)
        {
            return 5000 * 2;
        }


    	return -1;
    }

    public static Item ItemDay(int randomNum)
    {


        if (randomNum == 0)
        {
            return DQArmors.itemKinobousi;
        }

        if (randomNum == 1)
        {
            return DQWeapons.itemDounoturugi;
        }

        if (randomNum == 2)
        {
            return DQWeapons.itemTenbinbou;
        }

        if (randomNum == 3)
        {
            return DQWeapons.itemKonbou;
        }

        if (randomNum == 4)
        {
            return DQArmors.itemSuraimuhead;
        }

        if (randomNum == 5)
        {
            return DQArmors.itemSuraimunofuku;
        }

        if (randomNum == 6)
        {
            return DQWeapons.itemKawanomuti;
        }

        if (randomNum == 7)
        {
            return DQWeapons.itemMonosasizao;
        }

        if (randomNum == 8)
        {
            return DQWeapons.itemIsinotume;
        }

        if (randomNum == 9)
        {
            return DQWeapons.itemJaiantokurabu;
        }

        if (randomNum == 10)
        {
            return DQWeapons.itemKudamononaifu;
        }

        if (randomNum == 11)
        {
            return DQArmors.itemKawanobousi;
        }

        if (randomNum == 12)
        {
            return DQArmors.itemKawanoyoroi;
        }

        if (randomNum == 13)
        {
            return DQArmors.itemKawanokote;
        }

        if (randomNum == 14)
        {
            return DQArmors.itemKawanokutu;
        }

        if (randomNum == 15)
        {
            return DQWeapons.itemHeisinoken;
        }

        if (randomNum == 16)
        {
            return DQWeapons.itemHaganenoono;
        }

        if (randomNum == 17)
        {
            return DQArmors.itemKeikoginobandana;
        }

        if (randomNum == 18)
        {
            return DQWeapons.itemSyotobou;
        }

        if (randomNum == 19)
        {
            return DQWeapons.itemBumeran;
        }

        if (randomNum == 20)
        {
            return DQWeapons.itemHaganenokon;
        }

        if (randomNum == 21)
        {
            return DQArmors.itemTabibitonofuku;
        }

        if (randomNum == 22)
        {
            return DQArmors.itemTabibitonotebukuro;
        }

        if (randomNum == 23)
        {
            return DQArmors.itemKeikogisita;
        }

        if (randomNum == 24)
        {
            return DQArmors.itemKeikogi;
        }

        if (randomNum == 25)
        {
            return DQWeapons.itemIbaranomuti;
        }

        if (randomNum == 26)
        {
            return DQWeapons.itemTakenoyari;
        }

        if (randomNum == 27)
        {
            return DQArmors.itemRezamanto;
        }

        if (randomNum == 28)
        {
            return DQWeapons.itemReipia;
        }

        if (randomNum == 29)
        {
            return DQWeapons.itemMajuunotume;
        }

        if (randomNum == 30)
        {
            return DQArmors.itemSakuretto;
        }

        if (randomNum == 31)
        {
            return DQArmors.itemKinunoroubu;
        }

        if (randomNum == 32)
        {
            return DQArmors.itemKinunotebukuro;
        }

        if (randomNum == 33)
        {
            return DQArmors.itemSandaru;
        }

        if (randomNum == 34)
        {
            return DQWeapons.itemKinoono;
        }

        if (randomNum == 35)
        {
            return DQArmors.itemUrokonoyoroi;
        }

        if (randomNum == 36)
        {
            return DQWeapons.itemSeinarunaifu;
        }

        if (randomNum == 37)
        {
            return DQWeapons.itemWohanma;
        }

        if (randomNum == 38)
        {
            return DQWeapons.itemKaryuudonoyumi;
        }

        if (randomNum == 39)
        {
            return DQWeapons.itemHaganenoturugi;
        }

        if (randomNum == 40)
        {
            return DQWeapons.itemYaibanobumeran;
        }

        if (randomNum == 41)
        {
            return DQWeapons.itemReiniroddo;
        }

        if (randomNum == 42)
        {
            return DQArmors.itemBudougi;
        }

        if (randomNum == 43)
        {
            return DQArmors.itemBudounokutu;
        }

        if (randomNum == 44)
        {
            return DQArmors.itemBuounoudeate;
        }

        if (randomNum == 45)
        {
            return DQArmors.itemKenpougiue;
        }

        if (randomNum == 46)
        {
            return DQArmors.itemKenpougirisuto;
        }

        if (randomNum == 47)
        {
            return DQArmors.itemHaganenokabuto;
        }

        if (randomNum == 48)
        {
            return DQArmors.itemHaganenoyoroi;
        }

        if (randomNum == 49)
        {
            return DQArmors.itemHaganenokote;
        }

        if (randomNum == 50)
        {
            return DQArmors.itemHaganenokutu;
        }

        if (randomNum == 51)
        {
            return DQWeapons.itemTekkoukagi;
        }

        if (randomNum == 52)
        {
            return DQWeapons.itemBatoruribon;
        }

        if (randomNum == 53)
        {
            return DQWeapons.itemTetunoyari;
        }

        if (randomNum == 54)
        {
            return DQWeapons.itemKoorinoyaiba;
        }

        if (randomNum == 55)
        {
            return DQWeapons.itemMinagorosinoken;
        }

        if (randomNum == 56)
        {
            return DQWeapons.itemOokanaduti;
        }

        if (randomNum == 57)
        {
            return DQWeapons.itemTatujinnoono;
        }

        if (randomNum == 58)
        {
            return DQWeapons.itemDokubari;
        }

        if (randomNum == 59)
        {
            return DQArmors.itemMadousinosandaru;
        }

        if (randomNum == 60)
        {
            return DQArmors.itemBudoubandana;
        }

        if (randomNum == 61)
        {
            return DQArmors.itemRaiannokabuto;
        }

        if (randomNum == 62)
        {
            return DQArmors.itemRaiannoyoroi;
        }

        if (randomNum == 63)
        {
            return DQArmors.itemRaiannogurobu;
        }

        if (randomNum == 64)
        {
            return DQArmors.itemRaiannobutu;
        }

        if (randomNum >= 65 && randomNum <= 70)
        {
            return DQMiscs.itemTouzokunokagi;
        }

        return null;
    }

    public static int GoldNight(int randomNum)
    {


        if (randomNum == 0)
        {
            return 1100 * 2;
        }

        if (randomNum == 1)
        {
            return 1200 * 2;
        }

        if (randomNum == 2)
        {
            return 1200 * 2;
        }

        if (randomNum == 3)
        {
            return 1300 * 2;
        }

        if (randomNum == 4)
        {
            return 1300 * 2;
        }

        if (randomNum == 5)
        {
            return 1500 * 2;
        }

        if (randomNum == 6)
        {
            return 1500 * 2;
        }

        if (randomNum == 7)
        {
            return 1500 * 2;
        }

        if (randomNum == 8)
        {
            return 1500 * 2;
        }

        if (randomNum == 9)
        {
            return 1500 * 2;
        }

        if (randomNum == 10)
        {
            return 1500 * 2;
        }

        if (randomNum == 11)
        {
            return 1800 * 2;
        }

        if (randomNum == 12)
        {
            return 1800 * 2;
        }

        if (randomNum == 13)
        {
            return 1800 * 2;
        }

        if (randomNum == 14)
        {
            return 1800 * 2;
        }

        if (randomNum == 15)
        {
            return 1800 * 2;
        }

        if (randomNum == 16)
        {
            return 1800 * 2;
        }

        if (randomNum == 17)
        {
            return 1800 * 2;
        }

        if (randomNum == 18)
        {
            return 1800 * 2;
        }

        if (randomNum == 19)
        {
            return 2000 * 2;
        }

        if (randomNum == 20)
        {
            return 2000 * 2;
        }

        if (randomNum == 21)
        {
            return 2000 * 2;
        }

        if (randomNum == 22)
        {
            return 2000 * 2;
        }

        if (randomNum == 23)
        {
            return 2000 * 2;
        }

        if (randomNum == 24)
        {
            return 2000 * 2;
        }

        if (randomNum == 25)
        {
            return 2000 * 2;
        }

        if (randomNum == 26)
        {
            return 2000 * 2;
        }

        if (randomNum == 27)
        {
            return 2000 * 2;
        }

        if (randomNum == 28)
        {
            return 2000 * 2;
        }

        if (randomNum == 29)
        {
            return 2200 * 2;
        }

        if (randomNum == 30)
        {
            return 2200 * 2;
        }

        if (randomNum == 31)
        {
            return 2300 * 2;
        }

        if (randomNum == 32)
        {
            return 2300 * 2;
        }

        if (randomNum == 33)
        {
            return 2500 * 2;
        }

        if (randomNum == 34)
        {
            return 2500 * 2;
        }

        if (randomNum == 35)
        {
            return 2500 * 2;
        }

        if (randomNum == 36)
        {
            return 2500 * 2;
        }

        if (randomNum == 37)
        {
            return 2500 * 2;
        }

        if (randomNum == 38)
        {
            return 2500 * 2;
        }

        if (randomNum == 39)
        {
            return 2500 * 2;
        }

        if (randomNum == 40)
        {
            return 2500 * 2;
        }

        if (randomNum == 41)
        {
            return 2500 * 2;
        }

        if (randomNum == 42)
        {
            return 2800 * 2;
        }

        if (randomNum == 43)
        {
            return 2800 * 2;
        }

        if (randomNum == 44)
        {
            return 2800 * 2;
        }

        if (randomNum == 45)
        {
            return 3000 * 2;
        }

        if (randomNum == 46)
        {
            return 3000 * 2;
        }

        if (randomNum == 47)
        {
            return 3000 * 2;
        }

        if (randomNum == 48)
        {
            return 3000 * 2;
        }

        if (randomNum == 49)
        {
            return 3000 * 2;
        }

        if (randomNum == 50)
        {
            return 3000 * 2;
        }

        if (randomNum == 51)
        {
            return 3000 * 2;
        }

        if (randomNum == 52)
        {
            return 3000 * 2;
        }

        if (randomNum == 53)
        {
            return 3000 * 2;
        }

        if (randomNum >= 54 && randomNum <= 59)
        {
            return 5000 * 2;
        }


    	return 0;
    }

    public static Item ItemNight(int randomNum)
    {

        if (randomNum == 0)
        {
            return DQWeapons.itemMorohanoturugi;
        }

        if (randomNum == 1)
        {
            return DQWeapons.itemToraidento;
        }

        if (randomNum == 2)
        {
            return DQWeapons.itemDokuganonaifu;
        }

        if (randomNum == 3)
        {
            return DQWeapons.itemAkumanotume;
        }

        if (randomNum == 4)
        {
            return DQWeapons.itemKurosubumeran;
        }

        if (randomNum == 5)
        {
            return DQWeapons.itemHajanoturugi;
        }

        if (randomNum == 6)
        {
            return DQWeapons.itemBusinnokon;
        }

        if (randomNum == 7)
        {
            return DQWeapons.itemDoragonteiru;
        }

        if (randomNum == 8)
        {
            return DQWeapons.itemHaganenoyari;
        }

        if (randomNum == 9)
        {
            return DQWeapons.itemKazekirinoyumi;
        }

        if (randomNum == 10)
        {
            return DQArmors.itemOberonnokutu;
        }

        if (randomNum == 11)
        {
            return DQWeapons.itemDoragonkira;
        }

        if (randomNum == 12)
        {
            return DQWeapons.itemDaitinokanaduti;
        }

        if (randomNum == 13)
        {
            return DQWeapons.itemMoonakkusu;
        }

        if (randomNum == 14)
        {
            return DQWeapons.itemIgurufeza;
        }

        if (randomNum == 15)
        {
            return DQArmors.itemMahounobousi;
        }

        if (randomNum == 16)
        {
            return DQArmors.itemMahounohoui;
        }

        if (randomNum == 17)
        {
            return DQArmors.itemMahounotebukuro;
        }

        if (randomNum == 18)
        {
            return DQArmors.itemMahounokutu;
        }

        if (randomNum == 19)
        {
            return DQWeapons.itemDorirunakkuru;
        }

        if (randomNum == 20)
        {
            return DQWeapons.itemBasutawipu;
        }

        if (randomNum == 21)
        {
            return DQWeapons.itemAsasindaga;
        }

        if (randomNum == 22)
        {
            return DQWeapons.itemYuuwakunoyumi;
        }


        if (randomNum == 29)
        {
            return DQWeapons.itemSanzokusaberu;
        }

        if (randomNum == 30)
        {
            return DQArmors.itemMikawasinofuku;
        }

        if (randomNum == 31)
        {
            return DQWeapons.itemWohanmakai;
        }

        if (randomNum == 32)
        {
            return DQWeapons.itemHaruberuto;
        }

        if (randomNum == 33)
        {
            return DQWeapons.itemDaikokubasira;
        }

        if (randomNum == 34)
        {
            return DQWeapons.itemMayokenotume;
        }

        if (randomNum == 35)
        {
            return DQWeapons.itemKingakkusu;
        }

        if (randomNum == 36)
        {
            return DQArmors.itemSinkannobousi;
        }

        if (randomNum == 37)
        {
            return DQArmors.itemSinkannoepuron;
        }

        if (randomNum == 38)
        {
            return DQArmors.itemSinkannogurobu;
        }

        if (randomNum == 39)
        {
            return DQArmors.itemSutekinasabo;
        }

        if (randomNum == 40)
        {
            return DQArmors.itemHonoonoyoroi;
        }

        if (randomNum == 41)
        {
            return DQArmors.itemDoragonmeiru;
        }

        if (randomNum == 42)
        {
            return DQWeapons.itemMegaminomuti;
        }

        if (randomNum == 43)
        {
            return DQWeapons.itemKeironnoyumi;
        }

        if (randomNum == 44)
        {
            return DQWeapons.itemKazenobumeran;
        }

        if (randomNum == 45)
        {
            return DQWeapons.itemInferunosword;
        }

        if (randomNum == 46)
        {
            return DQWeapons.itemOriharukonbou;
        }

        if (randomNum == 47)
        {
            return DQWeapons.itemHonoonotume;
        }

        if (randomNum == 48)
        {
            return DQWeapons.itemMajinnokanaduti;
        }

        if (randomNum == 49)
        {
            return DQWeapons.itemInazumanoyari;
        }

        if (randomNum == 50)
        {
            return DQArmors.itemPuratinaheddo;
        }

        if (randomNum == 51)
        {
            return DQArmors.itemPuratinameiru;
        }

        if (randomNum == 52)
        {
            return DQArmors.itemPuratinagantoretto;
        }

        if (randomNum == 53)
        {
            return DQArmors.itemPuratinaguribu;
        }

        if (randomNum >= 54 && randomNum <= 59)
        {
            return DQMiscs.itemTouzokunokagi;
        }

    	return null;
    }

}
