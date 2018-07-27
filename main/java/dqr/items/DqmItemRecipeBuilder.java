package dqr.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import dqr.api.Blocks.DQDecorates;
import dqr.api.Items.DQArmors;
import dqr.api.Items.DQBuilders;
import dqr.api.Items.DQMiscs;

public class DqmItemRecipeBuilder {

	public DqmItemRecipeBuilder()
	{

        GameRegistry.addShapedRecipe(new ItemStack(DQBuilders.itemBuilderDama , 1), new Object[]
        {
            "ABC",
            "DEF",
            "GHI",
            'A', DQBuilders.itemBuilderDama1, 'B', DQBuilders.itemBuilderDama2, 'C', DQBuilders.itemBuilderDama3,
            'D', DQBuilders.itemBuilderDama4, 'E', DQBuilders.itemBuilderDama5, 'F', DQBuilders.itemBuilderDama6,
            'G', DQBuilders.itemBuilderDama7, 'H', DQBuilders.itemBuilderDama8, 'I', DQBuilders.itemBuilderDama9
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderDamaS , 1), new Object[]
        {
            "ABC",
            "DEF",
            "GHI",
            'A', DQBuilders.itemBuilderDamaS1, 'B', DQBuilders.itemBuilderDamaS2, 'C', DQBuilders.itemBuilderDamaS3,
            'D', DQBuilders.itemBuilderDamaS4, 'E', DQBuilders.itemBuilderDamaS5, 'F', DQBuilders.itemBuilderDamaS6,
            'G', DQBuilders.itemBuilderDamaS7, 'H', DQBuilders.itemBuilderDamaS8, 'I', DQBuilders.itemBuilderDamaS9
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderDamaW , 1), new Object[]
        {
            "ABC",
            "DEF",
            "GHI",
            'A', DQBuilders.itemBuilderDamaW1, 'B', DQBuilders.itemBuilderDamaW2, 'C', DQBuilders.itemBuilderDamaW3,
            'D', DQBuilders.itemBuilderDamaW4, 'E', DQBuilders.itemBuilderDamaW5, 'F', DQBuilders.itemBuilderDamaW6,
            'G', DQBuilders.itemBuilderDamaW7, 'H', DQBuilders.itemBuilderDamaW8, 'I', DQBuilders.itemBuilderDamaW9
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino1), new Object[]
        {
            " AA",
            "ABA",
            "AAA",
            'A', DQMiscs.itemDouka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino1), new Object[]
        {
            "A  ",
            " B ",
            "   ",
            'A', DQMiscs.itemKinka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino2), new Object[]
        {
            "   ",
            "AB ",
            "   ",
            'A', DQMiscs.itemKinka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino2), new Object[]
        {
            "AAA",
            " BA",
            "AAA",
            'A', DQMiscs.itemDouka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino3), new Object[]
        {
            "   ",
            " B ",
            "A  ",
            'A', DQMiscs.itemKinka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino3), new Object[]
        {
            "AAA",
            "ABA",
            " AA",
            'A', DQMiscs.itemDouka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino4), new Object[]
        {
            " B ",
            " A ",
            " B",
            'A', DQMiscs.itemKinka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino4), new Object[]
        {
            "ABA",
            "AAA",
            "ABA",
            'A', DQMiscs.itemDouka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino5), new Object[]
        {
            "   ",
            " B ",
            " A ",
            'A', DQMiscs.itemKinka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderCasino5), new Object[]
        {
            "AAA",
            "ABA",
            "A A",
            'A', DQMiscs.itemDouka, 'B', Items.paper
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderSekizouZoma), new Object[]
        {
            "EAE",
            "BFC",
            "EDE",
            'A', DQArmors.itemYuusyanokanmuri, 'B', DQArmors.itemYuusyanofuku, 'C', DQArmors.itemYusyanogurobu,
            'D', DQArmors.itemYuusyanobutu, 'E', DQMiscs.itemPisaronotamasii, 'F',DQMiscs.itemAyasiikobin,
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderSekizouRyuuou), new Object[]
        {
            "EAE",
            "BFC",
            "EDE",
            'A', DQArmors.itemRotonokabuto, 'B', DQArmors.itemRotonoyoroi, 'C', DQArmors.itemRotonokote,
            'D', DQArmors.itemRotonokutu, 'E', DQMiscs.itemPisaronotamasii, 'F',DQMiscs.itemAyasiikobin,
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderSekizouDesupisaro1), new Object[]
        {
            "EAE",
            "BFC",
            "EDE",
            'A', DQArmors.itemTenkuunokabuto, 'B', DQArmors.itemTenkuunofuku, 'C', DQArmors.itemTenkuunogurobu,
            'D', DQArmors.itemTenkuunobutu, 'E', DQMiscs.itemPisaronotamasii, 'F',DQMiscs.itemAyasiikobin,
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderSekizouDesupisaro1), new Object[]
        {
            "EAE",
            "BFC",
            "EDE",
            'A', DQArmors.itemTenkuunokabuto, 'B', DQArmors.itemTenkuunoyoroi, 'C', DQArmors.itemTenkuunogurobu,
            'D', DQArmors.itemTenkuunobutu, 'E', DQMiscs.itemPisaronotamasii, 'F',DQMiscs.itemAyasiikobin,
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderSekizouDarkRamia), new Object[]
        {
            "ABC",
            "GHG",
            "DEF",
            'A', DQMiscs.itemRedoubu, 'B', DQMiscs.itemBuruoubu, 'C', DQMiscs.itemIerooubu,
            'D', DQMiscs.itemGurinoubu, 'E', DQMiscs.itemPaapuruoubu, 'F', DQMiscs.itemMetaloubu,
            'G', DQMiscs.itemPisaronotamasii, 'H',DQMiscs.itemAyasiikobin,
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderSekizouEsterk), new Object[]
        {
            "EAE",
            "BFC",
            "EDE",
            'A', DQArmors.itemGurantaban, 'B', DQArmors.itemGuranbaniarobu, 'C', DQArmors.itemGuranbaniarisuto,
            'D', DQArmors.itemGuranbanianokutu, 'E', DQMiscs.itemPisaronotamasii, 'F',DQMiscs.itemAyasiikobin,
        });

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockCasinoSlot1), new Object[]
        {
            " AA",
            "ABA",
            "AAA",
            'A', DQMiscs.itemDouka, 'B', Blocks.iron_block
        });

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockCasinoSlot1), new Object[]
        {
            "A  ",
            " B ",
            "   ",
            'A', DQMiscs.itemKinka, 'B', Blocks.iron_block
        });

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockCasinoAbg1), new Object[]
        {
            " A ",
            " B ",
            "   ",
            'A', DQMiscs.itemKinka, 'B', Blocks.iron_block
        });

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockCasinoAbg1), new Object[]
        {
            "A A",
            "ABA",
            "AAA",
            'A', DQMiscs.itemDouka, 'B', Blocks.iron_block
        });

        GameRegistry.addShapelessRecipe(new ItemStack(DQBuilders.itemBuilderShopBankW, 1), new Object[] {new ItemStack(DQBuilders.itemBuilderShopBank, 1), new ItemStack(DQMiscs.itemIerooubu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBuilders.itemBuilderShopBukiyaW, 1), new Object[] {new ItemStack(DQBuilders.itemBuilderShopBukiya, 1), new ItemStack(DQMiscs.itemIerooubu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBuilders.itemBuilderShopSyuuriyaW, 1), new Object[] {new ItemStack(DQBuilders.itemBuilderShopSyuuriya, 1), new ItemStack(DQMiscs.itemIerooubu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBuilders.itemBuilderShopKaitoriyaW, 1), new Object[] {new ItemStack(DQBuilders.itemBuilderShopKaitoriya, 1), new ItemStack(DQMiscs.itemIerooubu, 1)});

        //GameRegistry.addShapelessRecipe(new ItemStack(DQBuilders.itemBuilderKaikosyo, 1), new Object[] {new ItemStack(Items.paper, 1), new ItemStack(DQMiscs.itemIerooubu, 1)});
        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderKaikosyo, 1), new Object[]
        {
            "AAA",
            "ABA",
            "AAA",
            'A', Items.paper, 'B', DQMiscs.itemIerooubu
        });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderIdoMedalW, 1), new Object[]
                {
                    "ABC",
                    " Z ",
                    "DEF",
                    'A', DQMiscs.itemRedoubu, 'B', DQMiscs.itemBuruoubu, 'C', DQMiscs.itemIerooubu,
                    'D', DQMiscs.itemGurinoubu, 'E', DQMiscs.itemPaapuruoubu, 'F', DQMiscs.itemMetaloubu,
                    'Z', DQBuilders.itemBuilderIdoMedal
                });
	}
}
