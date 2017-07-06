package dqr.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMagicTools;
import dqr.api.Items.DQMagics;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQSeeds;
import dqr.api.Items.DQWeapons;

public class DqmItemRecipeMagic {

	public DqmItemRecipeMagic()
	{
		/*
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRurasin, 1), new Object[]
                               {
                                   "VVV",
                                   "VWV",
                                   "VVV",
                                   'V', Rura, 'W', DQIngots.itemHikarinoisi
                               });
                               */
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRurasin, 1), new Object[]
                {
                    "BXC",
                    "XAX",
                    "DXE",
                    'X', DQMiscs.itemSeireiseki, 'A', DQMagics.itemRura, 'B', DQMagics.itemRuraR,
                    'C', DQMagics.itemRuraG, 'D', DQMagics.itemRuraB, 'E', DQMagics.itemRuraY
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRurasinC, 1), new Object[]
                {
                    "BXC",
                    "XAX",
                    "DXE",
                    'X', DQMiscs.itemSinkanohiseki, 'A', DQMagics.itemRuraC, 'B', DQMagics.itemRuraRC,
                    'C', DQMagics.itemRuraGC, 'D', DQMagics.itemRuraBC, 'E', DQMagics.itemRuraYC
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRurasin2, 1), new Object[]
                {
                    "BXC",
                    "XAX",
                    "DXE",
                    'X', DQMiscs.itemGenmaseki, 'A', DQMagics.itemRura2, 'B', DQMagics.itemRuraR2,
                    'C', DQMagics.itemRuraG2, 'D', DQMagics.itemRuraB2, 'E', DQMagics.itemRuraY2
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemZaoraru , 1), new Object[]
                               {
                                   "BCB",
                                   "CAC",
                                   "BCB",
                                   'A', DQMagics.itemBehoma, 'B', DQMiscs.itemSekaijunoha, 'C', DQIngots.itemInotinoisi
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemZaoriku , 1), new Object[]
                               {
                                   "BCB",
                                   "CAC",
                                   "BCB",
                                   'A', DQMagics.itemZaoraru, 'B', DQMiscs.itemTensinosoma, 'C', DQIngots.itemHikarinoisi
                               });

		/*
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemParupunte , 1), new Object[]
                               {
                                   "ABC",
                                   "DED",
                                   "FGH",
                                   'A', Baikiruto, 'B', Sukara, 'C', Piora,
                                   'D', DQMiscs.itemUraminohouju, 'E', Raidein, 'F', DQMiscs.itemMera,
                                   'G', Hyado, 'H', Io
                               });
		*/
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHikarinotue , 1), new Object[]
                               {
                                   " WV",
                                   " VW",
                                   "X  ",
                                   'V', DQIngots.itemMoon, 'W', DQIngots.itemTaiyounoisi, 'X', DQMiscs.itemKyodainakiba
                               });

        /*
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRurasin, 1), new Object[]
                               {
                                   "VVV",
                                   "VWV",
                                   "VVV",
                                   'V', Rura, 'W', Hikarinoisi
                               });
	*/

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahouken1 , 1), new Object[]
                               {
                                   "BCB",
                                   "CAC",
                                   "BCB",
                                   'A', DQMiscs.itemMagicbook, 'B', DQMiscs.itemDokudokuhedoro, 'C', DQMiscs.itemDokuganokona
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahouken2 , 1), new Object[]
                               {
                                   "BCB",
                                   "CAC",
                                   "BCB",
                                   'A', DQMagics.itemMahouken1, 'B', DQMiscs.itemJuryokunomoto, 'C', DQMiscs.itemHonehone
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahouken3 , 1), new Object[]
                               {
                                   "BCB",
                                   "CAC",
                                   "BCB",
                                   'A', DQMagics.itemMahouken2, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemUraminohouju
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahouken4 , 1), new Object[]
                               {
                                   "BCB",
                                   "CAC",
                                   "BCB",
                                   'A', DQMiscs.itemMagicbook, 'B', DQMiscs.itemMadarakumonoito, 'C', DQMiscs.itemGamanoabura
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahouken5 , 1), new Object[]
                               {
                                   "BCB",
                                   "CAC",
                                   "BCB",
                                   'A', DQMiscs.itemMagicbook, 'B', DQMiscs.itemRengokunohane, 'C', DQIngots.itemYougansekinokakera
                               });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahouken6 , 1), new Object[]
                                {
                                    "BCB",
                                    "CAC",
                                    "BCB",
                                    'A', DQMiscs.itemMagicbook, 'B', DQIngots.itemMisriru2, 'C', DQMiscs.itemKenjanoseisui
                                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahouken7 , 1), new Object[]
                                {
                                    "BCB",
                                    "CAC",
                                    "BCB",
                                    'A', DQMiscs.itemMagicbook, 'B', DQIngots.itemOriharukon2, 'C', DQMiscs.itemKenjanoisi
                                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRemira , 1), new Object[]
                               {
                                   "BBA",
                                   "BCB",
                                   "CBB",
                                   'A', DQIngots.itemHikarinoisi, 'B', DQIngots.itemTaiyounoisi, 'C', DQMagics.itemHikarinotue
                               });



        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHaigou , 1), new Object[]
                               {
                                   "BBA",
                                   "BCB",
                                   "CBB",
                                   'A', DQMiscs.itemBuruoubu, 'C', DQMiscs.itemMetaru, 'B', DQIngots.itemInotinoisi
                               });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemDoruma , 1), new Object[]
                               {
                                   "BCA",
                                   "BDC",
                                   "DBB",
                                   'A', DQMiscs.itemRyuunohizake, 'B', DQMiscs.itemDokudokuhedoro, 'C', DQMiscs.itemDokuganokona, 'D', DQMiscs.itemTetunokugi
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemDorukuma , 1), new Object[]
                               {
                                   "BCA",
                                   "BDC",
                                   "DBB",
                                   'A', DQMiscs.itemUraminohouju, 'B', DQMiscs.itemYorunotobari, 'C', DQWeapons.itemDokubari, 'D', DQMagics.itemDoruma
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemDorumoa , 1), new Object[]
                               {
                                   "BCA",
                                   "BDC",
                                   "DBB",
                                   'A', DQAccessories.itemAkumanotatu, 'B', DQMiscs.itemHebinonukegara, 'C', DQMiscs.itemTukinomegumi, 'D', DQMagics.itemDorukuma
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemDorumadon , 1), new Object[]
                               {
                                   "BCA",
                                   "BDC",
                                   "DBB",
                                   'A', DQMiscs.itemPaapuruoubu, 'B', DQMiscs.itemUraminohouju, 'C', DQWeapons.itemAsasindaga, 'D', DQMagics.itemDorumoa
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemKiari , 1), new Object[]
                               {
                                   " CA",
                                   "CBC",
                                   "BC ",
                                   'A', DQMiscs.itemTukinomegumi, 'B', Items.stick, 'C', DQSeeds.itemDokukesisou2
                               });
        /*
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMadante , 1), new Object[]
                               {
                                   "AAA",
                                   "AAA",
                                   "AA ",
                                   'A', Littlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBigban , 1), new Object[]
                               {
                                   "AAA",
                                   "A A",
                                   "   ",
                                   'A', Littlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemDorumadon , 1), new Object[]
                               {
                                   "ABC",
                                   "   ",
                                   "   ",
                                   'A', Littlemedal100, 'B', Littlemedal50, 'C', Littlemedal10
                               });.
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMinadein , 1), new Object[]
                               {
                                   "ABB",
                                   "   ",
                                   "   ",
                                   'A', Littlemedal100, 'B', Littlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemDorumoa , 1), new Object[]
                               {
                                   "ABB",
                                   "   ",
                                   " B ",
                                   'A', Littlemedal50, 'B', Littlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemZaki , 1), new Object[]
                               {
                                   "   ",
                                   "AB ",
                                   "   ",
                                   'A', Littlemedal50, 'B', Littlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemGigadein , 1), new Object[]
                               {
                                   "AAA",
                                   "B  ",
                                   "AA ",
                                   'A', Littlemedal10, 'B', Littlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemDorukuma , 1), new Object[]
                               {
                                   "AAA",
                                   "   ",
                                   " A ",
                                   'A', Littlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemDoruma , 1), new Object[]
                               {
                                   "   ",
                                   "   ",
                                   "AA ",
                                   'A', Littlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemKiari , 1), new Object[]
                               {
                                   "A  ",
                                   "A  ",
                                   "   ",
                                   'A', Littlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRaidein , 1), new Object[]
                               {
                                   "ABC",
                                   "CC ",
                                   "   ",
                                   'A', Littlemedal10, 'B', Littlemedal5, 'C', Littlemedal
                               });
                               */
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemZaki , 1), new Object[]
                               {
                                   "DCC",
                                   "DAC",
                                   "BDD",
                                   'A', DQMagics.itemMerami, 'B', DQMagics.itemHyadaruko, 'C', DQMiscs.itemUraminohouju, 'D', DQMiscs.itemDokudokuhedoro
                               });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemZaraki , 1), new Object[]
                {
                    "DCC",
                    "DAC",
                    "BDD",
                    'A', DQMagics.itemMerazoma, 'B', DQMagics.itemMahyado, 'C', DQMiscs.itemUraminohouju, 'D', DQMagics.itemZaki
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemZarakima , 1), new Object[]
                {
                    "DCC",
                    "DAC",
                    "BDD",
                    'A', DQMagics.itemMeragaia, 'B', DQMagics.itemMahyadodesu, 'C', DQMiscs.itemUraminohouju, 'D', DQMagics.itemZaraki
                });
        /*
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemParupunte , 1), new Object[]
                               {
                                   "ABC",
                                   "DED",
                                   "FGH",
                                   'A', Baikiruto, 'B', Sukara, 'C', Piora,
                                   'D', Uraminohouju, 'E', Raidein, 'F', Mera,
                                   'G', Hyado, 'H', Io
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBigban , 1), new Object[]
                               {
                                   "STU",
                                   "YZA",
                                   "VWX",
                                   'A', Minadein, 'S', Redoubu, 'T', Buruoubu, 'U', Ierooubu, 'V', Gurinoubu,
                                   'W', Paapuruoubu, 'X', Metaloubu, 'Y', Meragaia, 'Z', Iogurande
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMadante , 1), new Object[]
                               {
                                   "STU",
                                   "YZY",
                                   "VWX",
                                   'S', Redoubu, 'T', Buruoubu, 'U', Ierooubu, 'V', Gurinoubu,
                                   'W', Paapuruoubu, 'X', Metaloubu, 'Y', Kingdaiya, 'Z', Bigban
                               });
		*/
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRaidein , 1), new Object[]
                               {
                                   " XX",
                                   "ZYX",
                                   "YZ ",
                                   'X', DQMiscs.itemIkazutinotama, 'Y', DQMiscs.itemMetaru, 'Z', DQMiscs.itemSiroikaigara
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemGigadein , 1), new Object[]
                               {
                                   "WXX",
                                   "YZX",
                                   "ZYW",
                                   'W', DQMiscs.itemRyuunonamida, 'X', DQMiscs.itemIkazutinotama, 'Y', DQSeeds.itemSubayasanotane2, 'Z', DQMagics.itemRaidein
                               });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMinadein , 1), new Object[]
                               {
                                   "VXW",
                                   "YZX",
                                   "ZYV",
                                   'V', DQSeeds.itemSubayasanotane3, 'W', DQIngots.itemOriharukon2, 'X', DQMiscs.itemGurinoubu, 'Y', DQSeeds.itemOugon3, 'Z', DQMagics.itemGigadein
                               });
        /*
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHikarinotue , 1), new Object[]
                               {
                                   " WV",
                                   " VW",
                                   "X  ",
                                   'V', DQIngots.itemMoon, 'W', DQIngots.itemTaiyounoisi, 'X', DQMiscs.itemKyodainakiba
                               });
                               */
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemUminarinotue , 1),
                               new Object[] { " ZX", " YZ", "Y  ",
                                              'X', DQMiscs.itemSeireiseki,
                                              'Y', DQIngots.itemTokinosuisyou,
                                              'Z', DQIngots.itemKoorinokessyou,
                                            });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemCallMagma , 1),
                new Object[] { "AAB",
        					   "ACA",
        					   "CAA",
                               'A', Items.lava_bucket,
                               'B', DQIngots.itemTaiyounoisi,
                               'C', DQIngots.itemYougansekinokakera,
                             });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemCallCloud , 1),
                new Object[] { "AAB",
        					   "ACA",
        					   "CAA",
                               'A', new ItemStack(Blocks.ice, 1),
                               'B', DQIngots.itemPuratina,
                               'C', DQMagics.itemUminarinotue,
                             });

        /*
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRurasin2, 1), new Object[] {new ItemStack(DQMagics.itemRurasin, 1), new ItemStack(DQMagics.itemPisaronotamasii, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemBasirura, 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMagics.itemUraminohouju, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemBasiruraC, 1), new Object[] {new ItemStack(DQMagics.itemBasirura, 1), new ItemStack(DQMagics.itemSinkanohiseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemBasiruraC2, 1), new Object[] {new ItemStack(DQMagics.itemBasiruraC, 1), new ItemStack(DQMagics.itemSinkanohiseki, 1)});
        */
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRura2, 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemGenmaseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraR2, 1), new Object[] {new ItemStack(DQMagics.itemRuraR, 1), new ItemStack(DQMiscs.itemGenmaseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraG2, 1), new Object[] {new ItemStack(DQMagics.itemRuraG, 1), new ItemStack(DQMiscs.itemGenmaseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraB2, 1), new Object[] {new ItemStack(DQMagics.itemRuraB, 1), new ItemStack(DQMiscs.itemGenmaseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraY2, 1), new Object[] {new ItemStack(DQMagics.itemRuraY, 1), new ItemStack(DQMiscs.itemGenmaseki, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraC, 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemSinkanohiseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraRC, 1), new Object[] {new ItemStack(DQMagics.itemRuraR, 1), new ItemStack(DQMiscs.itemSinkanohiseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraGC, 1), new Object[] {new ItemStack(DQMagics.itemRuraG, 1), new ItemStack(DQMiscs.itemSinkanohiseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraBC, 1), new Object[] {new ItemStack(DQMagics.itemRuraB, 1), new ItemStack(DQMiscs.itemSinkanohiseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraYC, 1), new Object[] {new ItemStack(DQMagics.itemRuraY, 1), new ItemStack(DQMiscs.itemSinkanohiseki, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRura , 1), new Object[] {new ItemStack(DQMagics.itemRuraR, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRura , 1), new Object[] {new ItemStack(DQMagics.itemRuraB, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRura , 1), new Object[] {new ItemStack(DQMagics.itemRuraG, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRura , 1), new Object[] {new ItemStack(DQMagics.itemRuraY, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRura2 , 1), new Object[] {new ItemStack(DQMagics.itemRuraR2, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRura2 , 1), new Object[] {new ItemStack(DQMagics.itemRuraB2, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRura2 , 1), new Object[] {new ItemStack(DQMagics.itemRuraG2, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRura2 , 1), new Object[] {new ItemStack(DQMagics.itemRuraY2, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraC , 1), new Object[] {new ItemStack(DQMagics.itemRuraRC, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraC , 1), new Object[] {new ItemStack(DQMagics.itemRuraBC, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraC , 1), new Object[] {new ItemStack(DQMagics.itemRuraGC, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraC , 1), new Object[] {new ItemStack(DQMagics.itemRuraYC, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraR , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemAkaisango, 1), new ItemStack(DQMiscs.itemAkaisango, 1), new ItemStack(DQMiscs.itemAkaisango, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraR , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQIngots.itemTaiyounoisi, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraR , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQIngots.itemYougansekinokakera, 1), new ItemStack(DQIngots.itemYougansekinokakera, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraR , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemSuraimuosyarebana, 1), new ItemStack(DQMiscs.itemSuraimuosyarebana, 1), new ItemStack(DQMiscs.itemSuraimuosyarebana, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraG , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemMajuunokawa, 1), new ItemStack(DQMiscs.itemMajuunokawa, 1), new ItemStack(DQMiscs.itemMajuunokawa, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraG , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQSeeds.itemYakusou, 1), new ItemStack(DQSeeds.itemYakusou, 1), new ItemStack(DQSeeds.itemYakusou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraG , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraG , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraB , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraB , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemKazekirinohane, 1), new ItemStack(DQMiscs.itemKazekirinohane, 1), new ItemStack(DQMiscs.itemKazekirinohane, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraB , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemNebanebazeri, 1), new ItemStack(DQMiscs.itemNebanebazeri, 1), new ItemStack(DQMiscs.itemNebanebazeri, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraB , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemDoragonnonamida, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraY , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemGamanoabura, 1), new ItemStack(DQMiscs.itemGamanoabura, 1), new ItemStack(DQMiscs.itemGamanoabura, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraY , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemHananomitu, 1), new ItemStack(DQMiscs.itemHananomitu, 1), new ItemStack(DQMiscs.itemHananomitu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraY , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQIngots.itemMoon, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraY , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemKinkai, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraR2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemAkaisango, 1), new ItemStack(DQMiscs.itemAkaisango, 1), new ItemStack(DQMiscs.itemAkaisango, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraR2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQIngots.itemTaiyounoisi, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraR2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQIngots.itemYougansekinokakera, 1), new ItemStack(DQIngots.itemYougansekinokakera, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraR2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemSuraimuosyarebana, 1), new ItemStack(DQMiscs.itemSuraimuosyarebana, 1), new ItemStack(DQMiscs.itemSuraimuosyarebana, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraG2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemMajuunokawa, 1), new ItemStack(DQMiscs.itemMajuunokawa, 1), new ItemStack(DQMiscs.itemMajuunokawa, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraG2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQSeeds.itemYakusou, 1), new ItemStack(DQSeeds.itemYakusou, 1), new ItemStack(DQSeeds.itemYakusou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraG2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraG2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraB2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraB2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemKazekirinohane, 1), new ItemStack(DQMiscs.itemKazekirinohane, 1), new ItemStack(DQMiscs.itemKazekirinohane, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraB2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemNebanebazeri, 1), new ItemStack(DQMiscs.itemNebanebazeri, 1), new ItemStack(DQMiscs.itemNebanebazeri, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraB2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemDoragonnonamida, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraY2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemGamanoabura, 1), new ItemStack(DQMiscs.itemGamanoabura, 1), new ItemStack(DQMiscs.itemGamanoabura, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraY2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemHananomitu, 1), new ItemStack(DQMiscs.itemHananomitu, 1), new ItemStack(DQMiscs.itemHananomitu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraY2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQIngots.itemMoon, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraY2 , 1), new Object[] {new ItemStack(DQMagics.itemRura2, 1), new ItemStack(DQMiscs.itemKinkai, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraRC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemAkaisango, 1), new ItemStack(DQMiscs.itemAkaisango, 1), new ItemStack(DQMiscs.itemAkaisango, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraRC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQIngots.itemTaiyounoisi, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraRC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQIngots.itemYougansekinokakera, 1), new ItemStack(DQIngots.itemYougansekinokakera, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraRC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemSuraimuosyarebana, 1), new ItemStack(DQMiscs.itemSuraimuosyarebana, 1), new ItemStack(DQMiscs.itemSuraimuosyarebana, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraGC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemMajuunokawa, 1), new ItemStack(DQMiscs.itemMajuunokawa, 1), new ItemStack(DQMiscs.itemMajuunokawa, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraGC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQSeeds.itemYakusou, 1), new ItemStack(DQSeeds.itemYakusou, 1), new ItemStack(DQSeeds.itemYakusou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraGC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraGC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraBC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraBC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemKazekirinohane, 1), new ItemStack(DQMiscs.itemKazekirinohane, 1), new ItemStack(DQMiscs.itemKazekirinohane, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraBC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemNebanebazeri, 1), new ItemStack(DQMiscs.itemNebanebazeri, 1), new ItemStack(DQMiscs.itemNebanebazeri, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraBC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemDoragonnonamida, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraYC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemGamanoabura, 1), new ItemStack(DQMiscs.itemGamanoabura, 1), new ItemStack(DQMiscs.itemGamanoabura, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraYC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemHananomitu, 1), new ItemStack(DQMiscs.itemHananomitu, 1), new ItemStack(DQMiscs.itemHananomitu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraYC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQIngots.itemMoon, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemRuraYC , 1), new Object[] {new ItemStack(DQMagics.itemRuraC, 1), new ItemStack(DQMiscs.itemKinkai, 1)});


        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMagicbook2, 1), new Object[]
                {
                    "WZW",
                    "ZVZ",
                    "WZW",
                    'V', DQMiscs.itemMagicbook, 'W', DQMiscs.itemDoragonnonamida, 'Z',DQIngots.itemKoorinokessyou
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRukani , 1), new Object[]
                {
                    "CBC",
                    "ADA",
                    "CBC",
                    'A', DQMiscs.itemAyasiikobin, 'B', DQMiscs.itemJuryokunomoto, 'C', DQMiscs.itemToukonekisu, 'D',DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMedapani , 1), new Object[]
                {
                    "CBC",
                    "ADA",
                    "CBC",
                    'A', DQMiscs.itemAyasiikobin, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemUruwasikinoko, 'D', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHenatosu , 1), new Object[]
                {
                    "CBC",
                    "ADA",
                    "CBC",
                    'A', DQMiscs.itemRyuunohizake, 'B', DQMiscs.itemUraminohouju, 'C', DQMiscs.itemSeijanohai, 'D', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMagicbaria , 1), new Object[]
                {
                    "CBC",
                    "ADA",
                    "CBC",
                    'A', DQMiscs.itemSeinarusizuku, 'B', DQMiscs.itemSeireiseki, 'C', DQMiscs.itemDoragonnonamida, 'D', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahokanta , 1), new Object[]
                {
                    "CBC",
                    "ADA",
                    "CBC",
                    'A', DQMiscs.itemMahou, 'B', DQMiscs.itemPaapuruoubu, 'C', DQIngots.itemOriharukon2, 'D', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemDivainsuperu , 1), new Object[]
                {
                    "CBC",
                    "ADA",
                    "CBC",
                    'A', DQMiscs.itemNijiirononunokire, 'B', DQIngots.itemMoon, 'C', DQMiscs.itemKiyomenomizu, 'D', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemGira , 1), new Object[]
                {
                    "BCA",
                    "BDC",
                    "DBB",
                    'A', DQIngots.itemTaiyounoisi2, 'B', DQMiscs.itemRengokunohane, 'C', DQIngots.itemYougansekinokakera, 'D', Items.stick
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBegirama , 1), new Object[]
                {
                    "BCA",
                    "BDC",
                    "DBB",
                    'A', DQIngots.itemPuratina2, 'B', DQIngots.itemRubinogenseki, 'C', DQMiscs.itemTukinomegumi, 'D', DQMagics.itemGira
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBegiragon , 1), new Object[]
                {
                    "BCA",
                    "BDC",
                    "DBB",
                    'A', DQIngots.itemMisriru2, 'B', DQMiscs.itemRyuunonamida, 'C', DQMiscs.itemToukonekisu, 'D', DQMagics.itemBegirama
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemGiragureido , 1), new Object[]
                {
                    "BCA",
                    "BDC",
                    "DBB",
                    'A', DQIngots.itemOriharukon2, 'B', DQMiscs.itemRyuunohizake, 'C', DQMiscs.itemRedoubu, 'D', DQMagics.itemBegiragon
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRura , 1), new Object[]
                {
                    "BCA",
                    "BDC",
                    "DBB",
                    'A', DQMiscs.itemSeireiseki, 'B', DQMiscs.itemKazekirinohane, 'C', DQMiscs.itemTensinohane, 'D', Items.stick
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBagi , 1), new Object[]
                {
                    "BCA",
                    "BDC",
                    "DBB",
                    'A', DQMiscs.itemSeireiseki, 'B', DQMiscs.itemKazekirinohane, 'C', DQMiscs.itemKoumorinohane, 'D', Items.stick
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBagima , 1), new Object[]
                {
                    "BCA",
                    "BDC",
                    "DBB",
                    'A', DQIngots.itemMisriru2, 'B', DQMiscs.itemHaganenoobane, 'C', DQMiscs.itemMeijikimeranohane, 'D', DQMagics.itemBagi
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBagikurosu , 1), new Object[]
                {
                    "BCA",
                    "BDC",
                    "DBB",
                    'A', DQMiscs.itemSinkanohiseki, 'B', DQMiscs.itemHyoutyounohane, 'C', DQAccessories.itemHayatenoring, 'D', DQMagics.itemBagima
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBagimutyo , 1), new Object[]
                {
                    "BCA",
                    "BDC",
                    "DBB",
                    'A', DQIngots.itemHikarinoisi, 'B', DQMiscs.itemTensinosoma, 'C', DQAccessories.itemHosifuru, 'D', DQMagics.itemBagikurosu
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahoton , 1), new Object[]
                {
                    " CA",
                    "CBC",
                    "BC ",
                    'A', DQMiscs.itemSeireiseki, 'B', DQMiscs.itemUraminohouju, 'C', DQMiscs.itemTensinosoma
                });
/*
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemGiragureido , 1), new Object[]
                {
                    "ABC",
                    "C  ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal50, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBagimutyo , 1), new Object[]
                {
                    "ABB",
                    "BBC",
                    "CCC",
                    'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemIogurande , 1), new Object[]
                {
                    "ABC",
                    "C  ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahyadodesu , 1), new Object[]
                {
                    "ABB",
                    "BB ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMeragaia , 1), new Object[]
                {
                    "ABB",
                    "B  ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBegiragon , 1), new Object[]
                {
                    "ABB",
                    "CD ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5, 'D', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBagikurosu , 1), new Object[]
                {
                    "ABB",
                    "CC ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahoton , 1), new Object[]
        {
            "ABC",
            "D  ",
            "   ",
            'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5, 'D', DQMiscs.itemLittlemedal
        });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBehoma , 1), new Object[]
        {
            "ABC",
            "CCC",
            "   ",
            'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal
        });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRariho , 1), new Object[]
        {
            "AB ",
            "   ",
            "   ",
            'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10
        });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemIonazun , 1), new Object[]
                {
                    "ABC",
                    "   ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahyado , 1), new Object[]
                {
                    "ABB",
                    "   ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBaikiruto , 1), new Object[]
                {
                    "A  ",
                    "   ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal50
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemSukara , 1), new Object[]
                {
                    " A ",
                    "   ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal50
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemPiora , 1), new Object[]
                {
                    "   ",
                    "A  ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal50
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBaha , 1), new Object[]
                {
                    "   ",
                    "   ",
                    "A  ",
                    'A', DQMiscs.itemLittlemedal50
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRuraR , 1), new Object[]
                {
                    "BAA",
                    "AA ",
                    "CCC",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRuraG , 1), new Object[]
                {
                    "ABA",
                    "AA ",
                    "CCC",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRuraB , 1), new Object[]
                {
                    "AAA",
                    "BA ",
                    "CCC",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRuraY , 1), new Object[]
                {
                    "AAA",
                    "CC ",
                    "ABC",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemManusa , 1), new Object[]
                {
                    "AAA",
                    " B ",
                    " A ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMerazoma , 1), new Object[]
                {
                    "AAA",
                    "A  ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBomie , 1), new Object[]
                {
                    "AAA",
                    " A ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBegirama , 1), new Object[]
        {
            "AAA",
            "BCC",
            " C ",
            'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
        });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBagima , 1), new Object[]
                {
                    "AAA",
                    "BC ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBehoimi , 1), new Object[]
                {
                    "AAA",
                    "BB ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemIora , 1), new Object[]
                {
                    "AAA",
                    "BCC",
                    "C  ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHyadaruko , 1), new Object[]
                {
                    "AAB",
                    "C  ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRura , 1), new Object[]
        {
            "   ",
            "  A",
            "  A",
            'A', DQMiscs.itemLittlemedal10
        });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMerami , 1), new Object[]
                {
                    "AA ",
                    "   ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemGira , 1), new Object[]
                {
                    "CCC",
                    "ABC",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBagi , 1), new Object[]
                {
                    "CCC",
                    "AB ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHoimi , 1), new Object[]
                {
                    "ABC",
                    "   ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemIo , 1), new Object[]
                {
                    "ABB",
                    "BB ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHyado , 1), new Object[]
                {
                    "ABB",
                    "   ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMera , 1), new Object[]
                {
                    "A  ",
                    "   ",
                    "   ",
                    'A', DQMiscs.itemLittlemedal10
                });
*/
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHyado , 1), new Object[]
                {
                    " XY",
                    " ZX",
                    "Z  ",
                    'X', DQIngots.itemKoorinokessyou, 'Y', DQMiscs.itemSeinarusizuku, 'Z', Items.stick
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHyadaruko , 1), new Object[]
                {
                    "XYZ",
                    "XVY",
                    "VXX",
                    'V', DQMagics.itemHyado, 'X', DQMiscs.itemNebanebazeri, 'Y', DQIngots.itemMisriru, 'Z', DQMiscs.itemHyoutyounohane
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahyado , 1), new Object[]
                {
                    "XYZ",
                    "XVY",
                    "VXX",
                    'V', DQMagics.itemHyadaruko, 'X', DQIngots.itemPuratina, 'Y', DQMiscs.itemDoragonnonamida, 'Z', DQMiscs.itemSeireiseki
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahyadodesu , 1), new Object[]
                {
                    "XYZ",
                    "XVY",
                    "VXX",
                    'V', DQMagics.itemMahyado, 'X', DQIngots.itemTokinosuisyou, 'Y', DQMiscs.itemSeireiseki, 'Z', DQMiscs.itemBuruoubu
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBaikiruto , 1), new Object[]
                {
                    "XYX",
                    "XZX",
                    "XYX",
                    'X', DQSeeds.itemTikaranotane3, 'Y', DQMiscs.itemToukonekisu, 'Z', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemSukara , 1), new Object[]
                {
                    "XYX",
                    "XZX",
                    "XYX",
                    'X', DQSeeds.itemMamorinotane3, 'Y', DQMiscs.itemKingdaiya, 'Z', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBaha , 1), new Object[]
                {
                    "XYX",
                    "XZX",
                    "XYX",
                    'X', DQSeeds.itemHonoonomi3, 'Y', DQIngots.itemTaiyounoisi, 'Z', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemPiora , 1), new Object[]
                {
                    "XYX",
                    "XZX",
                    "XYX",
                    'X', DQSeeds.itemSubayasanotane3, 'Y', DQMiscs.itemMeijikimeranohane, 'Z', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBomie , 1), new Object[]
                {
                    "XYX",
                    "XZX",
                    "XYX",
                    'X', DQMiscs.itemKyodaihigetokage, 'Y', DQMiscs.itemGamanoabura, 'Z', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRariho , 1), new Object[]
                {
                    "XYX",
                    "XZX",
                    "XYX",
                    'X', DQMiscs.itemHebinonukegara, 'Y', DQMiscs.itemUraminohouju, 'Z', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemManusa , 1), new Object[]
                {
                    "XYX",
                    "XZX",
                    "XYX",
                    'X', DQMiscs.itemYorunotobari, 'Y', DQMiscs.itemNekozuna, 'Z', DQMiscs.itemMagicbook
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMagicbook , 1), new Object[]
                {
                    "XYV",
                    "XZV",
                    "XYV",
                    'V', DQMiscs.itemUruwasikinoko, 'X', DQIngots.itemMigakizuna, 'Y', DQMiscs.itemSeijanohai, 'Z', DQMiscs.itemNijiirononunokire
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemHoimi , 1), new Object[]
                {
                    "X Y",
                    " XX",
                    "YXX",
                    'X', DQMiscs.itemBekkou, 'Y', DQSeeds.itemYakusou
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBehoimi , 1), new Object[]
                {
                    "X Y",
                    " ZX",
                    "YXX",
                    'X', DQMiscs.itemMetaru, 'Y', DQSeeds.itemYakusou2, 'Z', DQMagics.itemHoimi
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBehoma , 1), new Object[]
                {
                    "X Y",
                    " ZX",
                    "YXX",
                    'X', DQMiscs.itemRyuunonamida, 'Y', DQSeeds.itemYakusou3, 'Z', DQMagics.itemBehoimi
                });



        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBehomara , 1), new Object[]
                {
                    "X Y",
                    " ZX",
                    "YXX",
                    'X', DQMiscs.itemKenjanoisi, 'Y', DQSeeds.itemIyasinomi, 'Z', DQMagics.itemBehoma
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBehomazun , 1), new Object[]
                {
                    "X Y",
                    " ZX",
                    "YXX",
                    'X', DQIngots.itemTaiyounoisi2, 'Y', DQSeeds.itemOugon4, 'Z', DQMagics.itemBehomara
                });


        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahoimi , 1), new Object[]
                {
                    "X Y",
                    " XX",
                    "YXX",
                    'X', DQMiscs.itemBekkou, 'Y', DQSeeds.itemMahounomiI
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahoriku , 1), new Object[]
                {
                    "X Y",
                    " ZX",
                    "YXX",
                    'X', DQMiscs.itemMetaru, 'Y', DQSeeds.itemMahounomiI2, 'Z', DQMagics.itemMahoimi
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMahoizun , 1), new Object[]
                {
                    "X Y",
                    " ZX",
                    "YXX",
                    'X', DQMiscs.itemRyuunonamida, 'Y', DQSeeds.itemMahounomiI3, 'Z', DQMagics.itemMahoriku
                });


        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMera , 1), new Object[]
                {
                    " YX",
                    " ZY",
                    "Z  ",
                    'X', DQSeeds.itemHonoonomi, 'Y', DQMiscs.itemAkaisango, 'Z', Items.stick
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMera , 1), new Object[]
                {
                    " YX",
                    " ZY",
                    "Z  ",
                    'X', Items.lava_bucket, 'Y', DQMiscs.itemAkaisango, 'Z', Items.stick
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMera , 1), new Object[]
                {
                    " YX",
                    " ZY",
                    "Z  ",
                    'X', DQIngots.itemYougansekinokakera, 'Y', DQMiscs.itemAkaisango, 'Z', Items.stick
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMerami , 1), new Object[]
                {
                    "YXX",
                    "YZX",
                    "ZYY",
                    'X', DQSeeds.itemHonoonomi2, 'Y', DQIngots.itemYougansekinokakera, 'Z', DQMagics.itemMera
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMerazoma , 1), new Object[]
                {
                    "YXX",
                    "YZX",
                    "ZYY",
                    'X', DQSeeds.itemHonoonomi3, 'Y', DQMiscs.itemMeijikimeranohane, 'Z', DQMagics.itemMerami
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemMeragaia , 1), new Object[]
                {
                    "WYX",
                    "YZY",
                    "ZYW",
                    'W', DQSeeds.itemOugon3, 'X', DQIngots.itemOriharukon2, 'Y', DQMiscs.itemKyodaihigetokage, 'Z', DQMagics.itemMerazoma
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemIo , 1), new Object[]
                {
                    " YX",
                    " ZY",
                    "Z  ",
                    'X', DQMiscs.itemDoragonnonamida, 'Y', DQIngots.itemBakudanisi, 'Z', DQMiscs.itemBekkou
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemIora , 1), new Object[]
                {
                    "ZYX",
                    "ZWY",
                    "WZZ",
                    'W', DQMagics.itemIo, 'X', DQIngots.itemTaiyounoisi, 'Y', DQSeeds.itemTikaranotane2, 'Z', DQIngots.itemBakudanisi
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemIonazun , 1), new Object[]
                {
                    "ZYX",
                    "ZWY",
                    "WZZ",
                    'W', DQMagics.itemIora, 'X', DQIngots.itemTaiyounoisi, 'Y', DQSeeds.itemTikaranotane3, 'Z', DQMiscs.itemYorunotobari
                });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemIogurande , 1), new Object[]
                {
                    "ZXY",
                    "ZWX",
                    "WZZ",
                    'W', DQMagics.itemIonazun, 'X', DQSeeds.itemOugon3, 'Y', DQIngots.itemOriharukon2, 'Z', DQMiscs.itemUraminohouju
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemSukuruto , 1),
                new Object[] { "ABA",
        					   "BXB",
        					   "ABA",
                               'A', DQSeeds.itemOugon,
                               'B', DQMiscs.itemMagicbook2,
                               'X', DQMagics.itemSukara,
                             });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemFubaha , 1),
                new Object[] { "ABA",
        					   "BXB",
        					   "ABA",
                               'A', DQSeeds.itemOugon,
                               'B', DQMiscs.itemMagicbook2,
                               'X', DQMagics.itemBaha,
                             });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemFubaha , 1),
                new Object[] { "ABA",
        					   "BXB",
        					   "ABA",
                               'A', DQSeeds.itemOugon,
                               'B', DQMiscs.itemMagicbook2,
                               'X', DQMagics.itemBaha,
                             });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemFubaha , 1),
                new Object[] { "ABA",
        					   "BXB",
        					   "ABA",
                               'A', DQSeeds.itemOugon,
                               'B', DQMiscs.itemMagicbook2,
                               'X', DQMagics.itemBaha,
                             });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemPiorimu , 1),
                new Object[] { "ABA",
        					   "BXB",
        					   "ABA",
                               'A', DQSeeds.itemOugon,
                               'B', DQMiscs.itemMagicbook2,
                               'X', DQMagics.itemPiora,
                             });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRukanan , 1),
                new Object[] { "ABA",
        					   "BXB",
        					   "ABA",
                               'A', DQSeeds.itemOugon,
                               'B', DQMiscs.itemMagicbook2,
                               'X', DQMagics.itemRukani,
                             });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemRarihoma , 1),
                new Object[] { "ABA",
        					   "BXB",
        					   "ABA",
                               'A', DQSeeds.itemOugon,
                               'B', DQMiscs.itemMagicbook2,
                               'X', DQMagics.itemRariho,
                             });
        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBomiosu , 1),
                new Object[] { "ABA",
        					   "BXB",
        					   "ABA",
                               'A', DQSeeds.itemOugon,
                               'B', DQMiscs.itemMagicbook2,
                               'X', DQMagics.itemBomie,
                             });

        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemMagicToolFarm1, 1), new Object[]
                {
                    "AAB",
                    "ABV",
                    "BVB",
                    'A', DQMiscs.itemHaganenoobane, 'B', DQMiscs.itemKinkai, 'V', DQMiscs.itemKyodaihigetokage
                });

        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemMagicToolFarm2, 1), new Object[]
                {
                    "AAC",
                    "ABA",
                    "DAA",
                    'A', DQIngots.itemMigakizuna, 'B', DQMagicTools.itemMagicToolFarm1, 'C', DQIngots.itemMisriru, 'D', DQIngots.itemOriharukon
                });

        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemMagicToolFarm1, 1), new Object[]
                {
                    "AAB",
                    "ABV",
                    "BVB",
                    'A', DQMiscs.itemHaganenoobane, 'B', DQMiscs.itemKinkai, 'V', DQMiscs.itemKyodaihigetokage
                });

        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemMagicToolBreak1, 1), new Object[]
                {
                    "ABC",
                    "YZY",
                    "DEF",
                    'A', DQMiscs.itemRedoubu, 'B', DQMiscs.itemBuruoubu, 'C', DQMiscs.itemIerooubu,
                    'D', DQMiscs.itemGurinoubu, 'E', DQMiscs.itemPaapuruoubu, 'F', DQMiscs.itemMetaloubu,
                    'Y', DQIngots.itemHikarinoisi, 'Z', DQMagics.itemIogurande
                });

        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemMagicToolBreak2, 1), new Object[]
                {
		            "ABC",
		            "YZY",
		            "DEF",
		            'A', DQMiscs.itemRedoubu, 'B', DQMiscs.itemBuruoubu, 'C', DQMiscs.itemIerooubu,
		            'D', DQMiscs.itemGurinoubu, 'E', DQMiscs.itemPaapuruoubu, 'F', DQMiscs.itemMetaloubu,
		            'Y', DQIngots.itemOriharukon2, 'Z', DQMagicTools.itemMagicToolBreak1
                });

        GameRegistry.addShapelessRecipe(new ItemStack(DQMagicTools.itemMagicToolSet, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(Blocks.stone, 1), new ItemStack(Blocks.gravel),
        																				 			   new ItemStack(Blocks.sand, 1), new ItemStack(DQMagicTools.itemMagicToolBreak2, 1), new ItemStack(Blocks.netherrack, 1),
        																				 			   new ItemStack(Blocks.soul_sand, 1), new ItemStack(Blocks.end_stone, 1), new ItemStack(Blocks.mycelium, 1)});

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBreathF1, 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMagics.itemMera, 'B', DQMiscs.itemDragonObuB
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBreathF2, 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMagics.itemMerami, 'B', DQMiscs.itemDragonObuB
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBreathF3, 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMagics.itemMerazoma, 'B', DQMiscs.itemDragonObuB
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBreathF4, 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMagics.itemMeragaia, 'B', DQMiscs.itemDragonObuB
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBreathS1, 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMagics.itemHyado, 'B', DQMiscs.itemDragonObuB
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBreathS2, 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMagics.itemHyadaruko, 'B', DQMiscs.itemDragonObuB
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBreathS3, 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMagics.itemMahyado, 'B', DQMiscs.itemDragonObuB
                });

        GameRegistry.addRecipe(new ItemStack(DQMagics.itemBreathS4, 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMagics.itemMahyadodesu, 'B', DQMiscs.itemDragonObuB
                });


        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemBasirura , 1), new Object[] {new ItemStack(DQMagics.itemRura, 1), new ItemStack(DQMiscs.itemUraminohouju, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemBasiruraC , 1), new Object[] {new ItemStack(DQMagics.itemBasirura, 1), new ItemStack(DQIngots.itemOriharukon, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMagics.itemBasiruraC2 , 1), new Object[] {new ItemStack(DQMagics.itemBasirura, 1), new ItemStack(DQMiscs.itemRyuunonamida, 1)});


        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemDqrFishRod_Diamond), new Object[]
        {
            "  A",
            " AB",
            "A B",
            'A', Items.diamond, 'B', Items.string
        });

        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemDqrFishRod_Oriharukon), new Object[]
        {
            "  A",
            " AB",
            "C B",
            'A', DQWeapons.itemOriharukonbou, 'B', Items.string, 'C', DQMagicTools.itemDqrFishRod_Diamond
        });

        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemDqrFishRod_Roto), new Object[]
        {
            "  A",
            " AB",
            "C B",
            'A', DQWeapons.itemRotonoturugi, 'B', DQMiscs.itemAmatuyunoito, 'C', DQMagicTools.itemDqrFishRod_Oriharukon
        });

        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemDqrFishRod_Densetu), new Object[]
        {
            "DDA",
            "DAB",
            "CBB",
            'A', DQWeapons.itemSinken, 'B', DQMiscs.itemGenmasekiB, 'C', DQMagicTools.itemDqrFishRod_Roto, 'D', DQMiscs.itemGenmasekiG
        });
	}
}
