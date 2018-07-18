package dqr.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import dqr.api.Blocks.DQDecorates;
import dqr.api.Blocks.DQOres;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMagics;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQSeeds;

public class DqmItemRecipeAccessory {

	public DqmItemRecipeAccessory()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(DQAccessories.itemRakkipendanto, 1), new Object[] {new ItemStack(DQAccessories.itemSinigaminokubikazari, 1), new ItemStack(DQMiscs.itemSeijanohai, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(DQAccessories.itemSinigaminokubikazari, 1), new Object[] {new ItemStack(DQAccessories.itemRakkipendanto, 1), new ItemStack(DQMiscs.itemUraminohouju, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(DQAccessories.itemRoiyarubajjji, 1), new Object[] {new ItemStack(DQAccessories.itemRakkipendanto, 1), new ItemStack(DQAccessories.itemMamorinorubi, 1), new ItemStack(DQAccessories.itemTikaranorubi, 1)});
		GameRegistry.addShapelessRecipe(new ItemStack(DQAccessories.itemTenkuunotate, 1), new Object[] {new ItemStack(DQAccessories.itemRotonotate, 1), new ItemStack(DQMiscs.itemBougu, 1), new ItemStack(DQMiscs.itemDensetu, 1), new ItemStack(DQMiscs.itemTenkuu, 1)});


        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemRotonotate , 1),new Object[]
        		{ "ZYZ", "ZXZ", "ZYZ",
                  'X', DQAccessories.itemSabitatate,
                  'Y', DQIngots.itemHikarinoisi,
                  'Z', DQIngots.itemMigakizuna,
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemTensinopiasu , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQSeeds.itemOugon4, 'B', DQAccessories.itemAkumanopiasu
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemSingonnojuzu , 1), new Object[]
                {
                    "AAA",
                    " B ",
                    "CDE",
                    'A', DQMiscs.itemKiyomenomizu, 'B', DQMiscs.itemMegaminoinori0, 'C', DQSeeds.itemMaryokunotaneI,
                    'D', DQSeeds.itemMaryokunotaneI2, 'E', DQSeeds.itemMaryokunotaneI3
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemSeijukunokubikazari , 1), new Object[]
                {
                    "ABA",
                    " C ",
                    'A', DQMiscs.itemGurinoubu, 'B', DQMagics.itemMahoton, 'C', DQAccessories.itemHosinokubikazari
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosizoranokubikazari , 1), new Object[]
                {
                    "ABA",
                    "BCB",
                    "ABA",
                    'A', DQAccessories.itemHosifuru, 'B', DQAccessories.itemHosinokubikazari, 'C', DQAccessories.itemHayatenoring
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemIyasinoudewa , 1), new Object[]
                {
                    "AFB",
                    "DCE",
                    "BFA",
                    'A', DQSeeds.itemIyasinomi3, 'B', DQSeeds.itemOugon4, 'C', DQAccessories.itemGoldburesuretto,
                    'D', DQAccessories.itemInorinoyubiwa, 'E', DQAccessories.itemInotinoyubiwa, 'C', DQSeeds.itemYakusou3,
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHaramotiYubiwa , 1), new Object[]
                {
                    "AAA",
                    "A A",
                    "ABA",
                    'A', Items.bread, 'B', DQAccessories.itemGinnoyubiwa
                });

        for(int cnt = 0; cnt < OreDictionary.getOres("ingotSilver").size(); cnt++)
        {
        	GameRegistry.addRecipe(new ItemStack(DQAccessories.itemGinnoyubiwa , 1), new Object[]
        		{
                    "AAA",
                    "A A",
                    "AAA",
                    'A', OreDictionary.getOres("ingotSilver").get(cnt)
                });
        }

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHaraherazuYubiwa , 1), new Object[]
                {
                    "AAA",
                    "B B",
                    "BBB",
                    'A', new ItemStack(Items.golden_apple, 1, 1), 'B', DQAccessories.itemHaramotiYubiwa
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemTikaranoyubiwa , 1), new Object[]
                {
                    "A B",
                    "CDC",
                    "B A",
                    'A', DQSeeds.itemTikaranotane3, 'B', DQSeeds.itemOugon4,
                    'D', DQAccessories.itemGoldring, 'C', DQMiscs.itemToukonekisu
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemIkarinotatu , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMiscs.itemToukonekisu, 'B', DQAccessories.itemAkumanotatu
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemInorinoyubiwa , 1), new Object[]
                {
                    "AAA",
                    "BCB",
                    "BBB",
                    'A', DQSeeds.itemMahounomiI3, 'B', new ItemStack(DQOres.DqmOreBlocks, 1, 2)
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemFuujinnnotate2 , 1), new Object[]
                {
                    "ABC",
                    "DEF",
                    "GHI",
                    'A', DQMiscs.itemKimeranotubasa2B, 'B', DQMiscs.itemKimeranotubasa2Y,
                    'C', DQMiscs.itemKimeranotubasa2R, 'D', DQMiscs.itemKimeranotubasa2G,
                    'E', DQAccessories.itemFuujinnnotate,
                    'F', DQMiscs.itemKimeranotubasaCG, 'G', DQMiscs.itemKimeranotubasaCR,
                    'H', DQMiscs.itemKimeranotubasaCY, 'I', DQMiscs.itemKimeranotubasaCB
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMegaminotate , 1), new Object[]
                {
                    "ABA",
                    "CDC",
                    "EFG",
                    'A', DQMiscs.itemTensinosoma, 'B', DQMiscs.itemBuruoubu, 'C', DQMiscs.itemTensinohane, 'D', DQAccessories.itemMikagaminotate,
                    'E', DQMiscs.itemTenkuu, 'F', DQMiscs.itemSeireiseki, 'G', DQMiscs.itemBougu
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemUroborosunotate , 1), new Object[]
                {
                    "ABC",
                    "DEF",
                    "GHI",
                    'A', DQMiscs.itemBougu, 'B', DQAccessories.itemTenkuunotate, 'C', DQMiscs.itemHakai, 'D', DQAccessories.itemMegaminotate,
                    'E', Item.getItemFromBlock(DQDecorates.DqmBlockRotomon), 'F', DQAccessories.itemMetarukingnotate, 'G', DQMiscs.itemMaJu, 'H', DQAccessories.itemRotonotate, 'I', DQMiscs.itemDensetu
                });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemFuujinnnotate3 , 1), new Object[]
                {
                    "AAA",
                    "BCB",
                    "DDD",
                    'A', DQMiscs.itemGenmasekiG, 'D', DQMiscs.itemGenmasekiB,
                    'B', DQMiscs.itemGenmaseki, 'C', DQAccessories.itemFuujinnnotate2

                });

        for(int cnt = 0; cnt < OreDictionary.getOres("ingotCopper").size(); cnt++)
        {
        	GameRegistry.addRecipe(new ItemStack(DQAccessories.itemSeidounotate , 1), new Object[]
        		{
                    "ABA",
                    "ABA",
                    " A ",
                    'A', OreDictionary.getOres("ingotCopper").get(cnt), 'B', Items.iron_ingot
                });
        }
	}
}
