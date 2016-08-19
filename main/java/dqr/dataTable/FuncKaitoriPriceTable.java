package dqr.dataTable;

import net.minecraft.item.ItemStack;
import dqr.DQR;
import dqr.api.Items.DQArmors;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumDqmAccessory;
import dqr.items.interfaceBase.ISubEquip;
public class FuncKaitoriPriceTable
{
	public FuncKaitoriPriceTable(){}

    public static int Gold(ItemStack par1ItemStack)
    {
        //int ID = par1ItemStack;
    	int kaitoriPrice = -1;

        //武器
        if (par1ItemStack.getItem() == DQWeapons.itemHayabusanoturugi)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDounoturugi)
        {
            kaitoriPrice = 100 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHeisinoken)
        {
            kaitoriPrice = 150 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemReipia)
        {
            kaitoriPrice = 200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHaganenoturugi)
        {
            kaitoriPrice = 300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKoorinoyaiba)
        {
            kaitoriPrice = 450 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHajanoturugi)
        {
            kaitoriPrice = 650 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDoragonkira)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSanzokusaberu)
        {
            kaitoriPrice = 1250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemInferunosword)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMakenreipia)
        {
            kaitoriPrice = 1750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKisekinoturugi)
        {
            kaitoriPrice = 2200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMinagorosinoken)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMorohanoturugi)
        {
            kaitoriPrice = 1100 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMakainoturugi)
        {
            kaitoriPrice = 3000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMetarukingnoturugi)
        {
            kaitoriPrice = 5000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSuiseinoturugi)
        {
            kaitoriPrice = 7500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemGinganoturugi)
        {
            kaitoriPrice = 10000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDebugsword)
        {
            kaitoriPrice = 100000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTenbinbou)
        {
            kaitoriPrice = 20 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHaganenokon)
        {
            kaitoriPrice = 250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemReiniroddo)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemBusinnokon)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDaikokubasira)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemOriharukonbou)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDoragonroddo)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemRougabou)
        {
            kaitoriPrice = 4200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemNyoraikon)
        {
            kaitoriPrice = 7500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemIsinotume)
        {
            kaitoriPrice = 50 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMajuunotume)
        {
            kaitoriPrice = 250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTekkoukagi)
        {
            kaitoriPrice = 450 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemAkumanotume)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDorirunakkuru)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMayokenotume)
        {
            kaitoriPrice = 1350 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHonoonotume)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKoorinotume)
        {
            kaitoriPrice = 1600 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemOowasinotume)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDoragonkuro)
        {
            kaitoriPrice = 3800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSinryuunotume)
        {
            kaitoriPrice = 7800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKonbou)
        {
            kaitoriPrice = 10 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemJaiantokurabu)
        {
            kaitoriPrice = 20 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemWohanma)
        {
            kaitoriPrice = 350 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemOokanaduti)
        {
            kaitoriPrice = 600 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDaitinokanaduti)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemWohanmakai)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemOninokanabou)
        {
            kaitoriPrice = 1600 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemGigakurassya)
        {
            kaitoriPrice = 2100 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemAtorasunokanaduti)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMajinnokanaduti)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDaitikudaki)
        {
            kaitoriPrice = 3800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHosikudaki)
        {
            kaitoriPrice = 5500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHakainotekkyuu)
        {
            kaitoriPrice = 10000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHaganenoono)
        {
            kaitoriPrice = 250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKinoono)
        {
            kaitoriPrice = 400 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTatujinnoono)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMoonakkusu)
        {
            kaitoriPrice = 950 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKingakkusu)
        {
            kaitoriPrice = 1250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHaounoono)
        {
            kaitoriPrice = 1600 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMoonakkusu)
        {
            kaitoriPrice = 1800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemFubukinoono)
        {
            kaitoriPrice = 2300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemGureitoakusu)
        {
            kaitoriPrice = 2800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemFunsainooonata)
        {
            kaitoriPrice = 3600 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemGodakkusu)
        {
            kaitoriPrice = 7500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKawanomuti)
        {
            kaitoriPrice = 50 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemIbaranomuti)
        {
            kaitoriPrice = 250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemBatoruribon)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDoragonteiru)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemBasutawipu)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMegaminomuti)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemAkumanomuti)
        {
            kaitoriPrice = 1800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKarubebuto)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemGuringamunomuti)
        {
            kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTyouguringamunomuti)
        {
            kaitoriPrice = 8000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSabitarotonoturugi)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemPapasunoturugi)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemPapasunoturuginew)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemOujanoturugi)
        {
            kaitoriPrice = 2000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemRotonoturugi)
        {
            kaitoriPrice = 8000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTenkuunoturugi)
        {
            kaitoriPrice = 15000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSinken)
        {
            kaitoriPrice = 20000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMonosasizao)
        {
            kaitoriPrice = 20 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTakenoyari)
        {
            kaitoriPrice = 50 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTetunoyari)
        {
            kaitoriPrice = 400 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemToraidento)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHaganenoyari)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHaruberuto)
        {
            kaitoriPrice = 1300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemInazumanoyari)
        {
            kaitoriPrice = 1700 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHoriransu)
        {
            kaitoriPrice = 2000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDemonsupia)
        {
            kaitoriPrice = 2200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemGurakosunoyari)
        {
            kaitoriPrice = 2600 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemJigokumasou)
        {
            kaitoriPrice = 3000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemEiyuunoyari)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMetarukingnoyari)
        {
            kaitoriPrice = 8500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDokubari)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKirapiasu)
        {
            kaitoriPrice = 3000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKudamononaifu)
        {
            kaitoriPrice = 100 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSeinarunaifu)
        {
            kaitoriPrice = 250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDokuganonaifu)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemAsasindaga)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSodobureika)
        {
            kaitoriPrice = 1800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemGuradiusu)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSaramanda)
        {
            kaitoriPrice = 3800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemToririondaga)
        {
            kaitoriPrice = 7000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSyotobou)
        {
            kaitoriPrice = 100 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKaryuudonoyumi)
        {
            kaitoriPrice = 350 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKazekirinoyumi)
        {
            kaitoriPrice = 700 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemYuuwakunoyumi)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKeironnoyumi)
        {
            kaitoriPrice = 1800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMugennoyumi)
        {
            kaitoriPrice = 2300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemJigokunoyumi)
        {
            kaitoriPrice = 3000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemBigbougan)
        {
            kaitoriPrice = 3500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemOdinbou)
        {
            kaitoriPrice = 4300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemDaitensinoyumi)
        {
            kaitoriPrice = 5500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSefiramunoyumi)
        {
            kaitoriPrice = 8000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemBumeran)
        {
            kaitoriPrice = 200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemYaibanobumeran)
        {
            kaitoriPrice = 450 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKurosubumeran)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemIgurufeza)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKazenobumeran)
        {
            kaitoriPrice = 1600 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHonoonobumeran)
        {
            kaitoriPrice = 2000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKoorinobumeran)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKuresentoejji)
        {
            kaitoriPrice = 3500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemMeteoejji)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHaipanova)
        {
            kaitoriPrice = 8000 / 5;
            return kaitoriPrice;
        }

        //防具
        if (par1ItemStack.getItem() == DQArmors.itemKeikoginobandana)
        {
            kaitoriPrice = 250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKeikoginokutu)
        {
            kaitoriPrice = 250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBudougi)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBudougirisuto)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBudounokutu)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBusinnobudougi)
        {
            kaitoriPrice = 3200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBusinrisuto)
        {
            kaitoriPrice = 3200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBusinnobutu)
        {
            kaitoriPrice = 3200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDaimadounobousi)
        {
            kaitoriPrice = 3300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDaimadounorobu)
        {
            kaitoriPrice = 3300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDaimadounosyuzu)
        {
            kaitoriPrice = 3300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDaimadougurobu)
        {
            kaitoriPrice = 3300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDoragonrobu)
        {
            kaitoriPrice = 3800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemFusiginaborero)
        {
            kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKeikogisita)
        {
            kaitoriPrice = 400 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKinobousi)
        {
            kaitoriPrice = 10 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMadousinosandaru)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMikawasinofuku)
        {
            kaitoriPrice = 1300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMizunohagoromo)
        {
            kaitoriPrice = 4800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemOberonnokutu)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBudoubandana)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRezamanto)
        {
            kaitoriPrice = 450 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSatorinotebukuro)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSatorinowanpisu)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSatorinokanmuri)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSatorinokutu)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSefiramurobu)
        {
            kaitoriPrice = 6000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSeijanohoui)
        {
            kaitoriPrice = 1850 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSinkannobousi)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSinkannobutu)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSinkannoepuron)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSinkannogurobu)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSutekinasabo)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemTabibitonofuku)
        {
            kaitoriPrice = 350 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemTabibitonotebukuro)
        {
            kaitoriPrice = 350 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBuounoudeate)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBuounokutu)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBuounohatigane)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBuounosutu)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKeikogi)
        {
            kaitoriPrice = 400 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKenpougiue)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKenpouginobando)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKenpouginokutu)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKenpougirisuto)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBusinnobandana)
        {
            kaitoriPrice = 3200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRotonokabuto)
        {
            kaitoriPrice = 6000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRotonoyoroi)
        {
            kaitoriPrice = 6000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRotonokote)
        {
            kaitoriPrice = 6000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRotonokutu)
        {
            kaitoriPrice = 6000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMetarukingnokabuto)
        {
            kaitoriPrice = 8500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMetarukingnoyoroi)
        {
            kaitoriPrice = 8500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMetarukingnokote)
        {
            kaitoriPrice = 8500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMetarukingnokutu)
        {
            kaitoriPrice = 8500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSabitakabuto)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSabitayoroi)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSabitakote)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSabitakutu)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemHaganenokabuto)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemHaganenoyoroi)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemHaganenokote)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemHaganenokutu)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKawanobousi)
        {
            kaitoriPrice = 200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKawanoyoroi)
        {
            kaitoriPrice = 200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKawanokote)
        {
            kaitoriPrice = 200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKawanokutu)
        {
            kaitoriPrice = 200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemUrokonoyoroi)
        {
            kaitoriPrice = 350 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemHonoonoyoroi)
        {
            kaitoriPrice = 1700 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMirayoroi)
        {
            kaitoriPrice = 2600 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemYaibanoyoroi)
        {
            kaitoriPrice = 1800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSinpinoyoroi)
        {
            kaitoriPrice = 3500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSuraimuhead)
        {
            kaitoriPrice = 100 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSuraimunofuku)
        {
            kaitoriPrice = 100 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDoragonmeiru)
        {
            kaitoriPrice = 1200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKenjanobousi)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKenjanoroubu)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKenjanotebukuro)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKenjanokutu)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSakuretto)
        {
            kaitoriPrice = 300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKinunoroubu)
        {
            kaitoriPrice = 300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemKinunotebukuro)
        {
            kaitoriPrice = 300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSandaru)
        {
            kaitoriPrice = 300 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMahounobousi)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMahounohoui)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMahounotebukuro)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMahounokutu)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRadatomukabuto)
        {
            kaitoriPrice = 5000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRadatomunoyoroi)
        {
            kaitoriPrice = 5000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRadatomugurobu)
        {
            kaitoriPrice = 5000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRadatomubutu)
        {
            kaitoriPrice = 5000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRoresiametto)
        {
            kaitoriPrice = 3500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRoresianofuku)
        {
            kaitoriPrice = 3500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRoresiagurobu)
        {
            kaitoriPrice = 3500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRoresiabutu)
        {
            kaitoriPrice = 3500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemYuusyanokanmuri)
        {
            kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemYuusyanofuku)
        {
            kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemYusyanogurobu)
        {
            kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemYuusyanobutu)
        {
            kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemTenkuunokabuto)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemTenkuunofuku)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemTenkuunogurobu)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemTenkuunobutu)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemGurantaban)
        {
            kaitoriPrice = 3200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemGuranbaniarobu)
        {
            kaitoriPrice = 3200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemGuranbaniarisuto)
        {
            kaitoriPrice = 3200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemGuranbanianokutu)
        {
            kaitoriPrice = 3200 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRaiannokabuto)
        {
            kaitoriPrice = 650 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRaiannoyoroi)
        {
            kaitoriPrice = 650 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRaiannogurobu)
        {
            kaitoriPrice = 650 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRaiannobutu)
        {
            kaitoriPrice = 650 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemTenkuunoyoroi)
        {
            kaitoriPrice = 7000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemNekomimibando)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSuraimunokanmuriK)
        {
            kaitoriPrice = 3500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemFantomumasuku)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemArakuremasuku)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSiawasenobousi)
        {
            kaitoriPrice = 10000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSiawasenokutu)
        {
            kaitoriPrice = 10000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemAbunaimizugiue)
        {
            kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemAbunaimizugisita)
        {
            kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemUsamimibando)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemBanisutu)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemAmitaitu)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemHaihiru)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSensinokabuto)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSensinoyoroi)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSensinogurobu)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSensinobutu)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemPuratinaheddo)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemPuratinameiru)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemPuratinagantoretto)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemPuratinaguribu)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMisuriruherumu)
        {
            kaitoriPrice = 2000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMisurirumeiru)
        {
            kaitoriPrice = 2000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMisuritugantoretto)
        {
            kaitoriPrice = 2000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemMisuriruguribu)
        {
            kaitoriPrice = 2000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRyuukisinokabuto)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRyuukisinoyoroi)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRyuukisinokote)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemRyuukisinobutu)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDansanohanekazaribando)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDansanosyatu)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDansanozubon)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemDansanobutu)
        {
            kaitoriPrice = 800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemOdorikonokamikazari)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemOdorikonofuku)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemOdorikononisokkusu)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemOdorikonomyuru)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemPurinsesutexiara)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemPurinsesurobu)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemPurinsesugurobu)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemPurinsesuhiru)
        {
            kaitoriPrice = 4500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSeijanokakarotto)
        {
            kaitoriPrice = 850 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSeijanohoui)
        {
            kaitoriPrice = 850 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSeijanotaitu)
        {
            kaitoriPrice = 850 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSeijanobutu)
        {
            kaitoriPrice = 850 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemStarhatto)
        {
            kaitoriPrice = 3000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemStarnasutu)
        {
            kaitoriPrice = 3000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemStarzubon)
        {
            kaitoriPrice = 3000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemStarbutu)
        {
            kaitoriPrice = 3000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSinpannokabuto)
        {
            kaitoriPrice = 1 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemSinwanoyoroi)
        {
            kaitoriPrice = 1 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemAmaterasunokote)
        {
            kaitoriPrice = 1 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQArmors.itemTenteinobutu)
        {
            kaitoriPrice = 1 / 5;
            return kaitoriPrice;
        }





        if (par1ItemStack.getItem() == DQWeapons.itemHanenoougi)
        {
            kaitoriPrice = 50 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTetunoougi)
        {
            kaitoriPrice = 150 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemBattlefan)
        {
            kaitoriPrice = 250 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemReppuunoougi)
        {
            kaitoriPrice = 500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKamenoougi)
        {
            kaitoriPrice = 750 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTorinoougi)
        {
            kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemNekonoougi)
        {
            kaitoriPrice = 1500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHebinoougi)
        {
            kaitoriPrice = 1800 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemHosinoougi)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTukinoougi)
        {
            kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTaiyounoougi)
        {
            kaitoriPrice = 6000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemSaisyuuougi)
        {
            kaitoriPrice = 8000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemTetunosoroban)
        {
            kaitoriPrice = 250 / 5;
            return kaitoriPrice;
        }
        if (par1ItemStack.getItem() == DQWeapons.itemMahounosoroban)
        {
            kaitoriPrice = 2500 / 5;
            return kaitoriPrice;
        }
        if (par1ItemStack.getItem() == DQWeapons.itemSeiginosoroban)
        {
            kaitoriPrice = 10000 / 5;
            return kaitoriPrice;
        }
        if (par1ItemStack.getItem() == DQWeapons.itemKobusi)
        {
        	kaitoriPrice = 1000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKobusi2)
        {
        	kaitoriPrice = 4000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKobusi3)
        {
        	kaitoriPrice = 8000 / 5;
            return kaitoriPrice;
        }

        if (par1ItemStack.getItem() == DQWeapons.itemKobusi32)
        {
        	kaitoriPrice = 50000 / 5;
            return kaitoriPrice;
        }

        if(par1ItemStack.getItem() instanceof ISubEquip)
        {
        	EnumDqmAccessory param = DQR.enumGetter.getAccessoryParam(par1ItemStack.getItem());

        	if(param != null)
        	{
        		return (param.getFixPrice() / 5);
        	}
        }

        return kaitoriPrice;
    }
}
