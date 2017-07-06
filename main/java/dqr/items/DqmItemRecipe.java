package dqr.items;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import dqr.api.Blocks.DQBlocks;
import dqr.api.Blocks.DQChests;
import dqr.api.Blocks.DQDecorates;
import dqr.api.Blocks.DQMobFigures;
import dqr.api.Blocks.DQMobObjects;
import dqr.api.Blocks.DQOres;
import dqr.api.Blocks.DQPlants;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQArmors;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMagicTools;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQSeeds;
import dqr.api.Items.DQWeapons;

public class DqmItemRecipe {

	public DqmItemRecipe()
	{
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.ender_chest, 1), new Object[] {new ItemStack(Blocks.chest, 1), new ItemStack(Items.ender_pearl, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemKuresentoejji, 1), new Object[] {new ItemStack(DQWeapons.itemKazenobumeran, 1), new ItemStack(DQMiscs.itemNage, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemHaipanova, 1), new Object[] {new ItemStack(DQWeapons.itemKuresentoejji, 1), new ItemStack(DQMiscs.itemNage, 1), new ItemStack(DQMiscs.itemDensetu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemJigokunoyumi, 1), new Object[] {new ItemStack(DQWeapons.itemYuuwakunoyumi, 1), new ItemStack(DQMiscs.itemYumiNage, 1), new ItemStack(DQMiscs.itemMaJu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemKeironnoyumi, 1), new Object[] {new ItemStack(DQWeapons.itemSefiramunoyumi, 1), new ItemStack(DQMiscs.itemYumiNage, 1), new ItemStack(DQMiscs.itemMahou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemSuiseinoturugi, 1), new Object[] {new ItemStack(DQWeapons.itemOujanoturugi, 1), new ItemStack(DQMiscs.itemKenTanken, 1), new ItemStack(DQMiscs.itemDensetu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemMakainoturugi, 1), new Object[] {new ItemStack(DQWeapons.itemGinganoturugi, 1), new ItemStack(DQMiscs.itemKenTanken, 1), new ItemStack(DQMiscs.itemHakai, 1), new ItemStack(DQMiscs.itemMaJu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemSaramanda, 1), new Object[] {new ItemStack(DQWeapons.itemSodobureika, 1), new ItemStack(DQMiscs.itemTanken, 1), new ItemStack(DQMiscs.itemHonooRyuu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemMinagorosinoken, 1), new Object[] {new ItemStack(DQWeapons.itemHeisinoken, 1), new ItemStack(DQMiscs.itemKenTanken, 1), new ItemStack(DQMiscs.itemMaJu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemMorohanoturugi, 1), new Object[] {new ItemStack(DQWeapons.itemHeisinoken, 1), new ItemStack(DQMiscs.itemKenTanken, 1), new ItemStack(DQMiscs.itemHakai, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemSinken, 1), new Object[] {new ItemStack(DQWeapons.itemPapasunoturugi, 1), new ItemStack(DQMiscs.itemKenTanken, 1), new ItemStack(DQMiscs.itemDensetu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemTenkuunoturugi, 1), new Object[] {new ItemStack(DQWeapons.itemRotonoturugi, 1), new ItemStack(DQMiscs.itemKenTanken, 1), new ItemStack(DQMiscs.itemDensetu, 1), new ItemStack(DQMiscs.itemTenkuu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemDemonsupia, 1), new Object[] {new ItemStack(DQWeapons.itemToraidento, 1), new ItemStack(DQMiscs.itemYariMutiTume, 1), new ItemStack(DQMiscs.itemMaJu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemJigokumasou, 1), new Object[] {new ItemStack(DQWeapons.itemMetarukingnoyari, 1), new ItemStack(DQMiscs.itemYariMutiTume, 1), new ItemStack(DQMiscs.itemHonooRyuu, 1), new ItemStack(DQMiscs.itemMaJu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemDoragonkuro, 1), new Object[] {new ItemStack(DQWeapons.itemAkumanotume, 1), new ItemStack(DQMiscs.itemTume, 1), new ItemStack(DQMiscs.itemHonooRyuu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemMegaminomuti, 1), new Object[] {new ItemStack(DQWeapons.itemDoragonteiru, 1), new ItemStack(DQMiscs.itemMuti, 1), new ItemStack(DQMiscs.itemMahou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemInazumanoyari, 1), new Object[] {new ItemStack(DQWeapons.itemToraidento, 1), new ItemStack(DQMiscs.itemYariMutiTume, 1), new ItemStack(DQMiscs.itemMahou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemEiyuunoyari, 1), new Object[] {new ItemStack(DQWeapons.itemToraidento, 1), new ItemStack(DQMiscs.itemYariMutiTume, 1), new ItemStack(DQMiscs.itemMahou, 1), new ItemStack(DQMiscs.itemDensetu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemMetarukingnoyari, 1), new Object[] {new ItemStack(DQWeapons.itemInazumanoyari, 1), new ItemStack(DQMiscs.itemYariMutiTume, 1), new ItemStack(DQMiscs.itemKooriMetaru, 1), new ItemStack(DQMiscs.itemDensetu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemTyouguringamunomuti, 1), new Object[] {new ItemStack(DQWeapons.itemGuringamunomuti, 1), new ItemStack(DQMiscs.itemMuti, 1), new ItemStack(DQMiscs.itemHakai, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemSinryuunotume, 1), new Object[] {new ItemStack(DQWeapons.itemDoragonkuro, 1), new ItemStack(DQMiscs.itemTume, 1), new ItemStack(DQMiscs.itemHonooRyuu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemHosikudaki, 1), new Object[] {new ItemStack(DQWeapons.itemOninokanabou, 1), new ItemStack(DQMiscs.itemTuti, 1), new ItemStack(DQMiscs.itemHakai, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemDaitinokanaduti, 1), new Object[] {new ItemStack(DQWeapons.itemDaitikudaki, 1), new ItemStack(DQMiscs.itemTuti, 1), new ItemStack(DQMiscs.itemHakai, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemHakainotekkyuu, 1), new Object[] {new ItemStack(DQWeapons.itemTyouguringamunomuti, 1), new ItemStack(DQMiscs.itemTuti, 1), new ItemStack(DQMiscs.itemHakai, 1), new ItemStack(DQMiscs.itemDensetu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemDoragonroddo, 1), new Object[] {new ItemStack(DQIngots.itemOriharukon, 1), new ItemStack(DQMiscs.itemKon, 1), new ItemStack(DQMiscs.itemHonooRyuu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemFunsainooonata, 1), new Object[] {new ItemStack(DQWeapons.itemGureitoakusu, 1), new ItemStack(DQMiscs.itemOnoTutiKon, 1), new ItemStack(DQMiscs.itemHakai, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemNyoraikon, 1), new Object[] {new ItemStack(DQWeapons.itemDoragonroddo, 1), new ItemStack(DQMiscs.itemKon, 1), new ItemStack(DQMiscs.itemMahou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQArmors.itemTenkuunoyoroi, 1), new Object[] {new ItemStack(DQArmors.itemRotonoyoroi, 1), new ItemStack(DQMiscs.itemBougu, 1), new ItemStack(DQMiscs.itemDensetu, 1), new ItemStack(DQMiscs.itemTenkuu, 1)});
        //GameRegistry.addShapelessRecipe(new ItemStack(DQArmors.itemTenkuunotate, 1), new Object[] {new ItemStack(Rotonotate, 1), new ItemStack(DQMiscs.itemBougu, 1), new ItemStack(DQMiscs.itemDensetu, 1), new ItemStack(DQMiscs.itemTenkuu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemTaiyounoisi2, 1), new Object[] {new ItemStack(DQIngots.itemTaiyounoisi, 1), new ItemStack(DQIngots.itemTaiyounoisi, 1), new ItemStack(DQIngots.itemTokinosuisyou, 1), new ItemStack(DQIngots.itemRubinogenseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemPuratina2, 1), new Object[] {new ItemStack(DQIngots.itemPuratina, 1), new ItemStack(DQIngots.itemPuratina, 1), new ItemStack(DQIngots.itemKagaminoisi, 1), new ItemStack(DQIngots.itemKagaminoisi, 1), new ItemStack(DQIngots.itemMoon, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemMisriru2, 1), new Object[] {new ItemStack(DQIngots.itemMisriru, 1), new ItemStack(DQIngots.itemMisriru, 1), new ItemStack(DQIngots.itemInotinoisi, 1), new ItemStack(DQIngots.itemInotinoisi, 1), new ItemStack(DQMiscs.itemKingdaiya, 1), new ItemStack(DQMiscs.itemKingdaiya, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemOriharukon2, 1), new Object[] {new ItemStack(DQIngots.itemOriharukon, 1), new ItemStack(DQIngots.itemOriharukon, 1), new ItemStack(DQMiscs.itemDoragonnonamida, 1), new ItemStack(DQMiscs.itemDoragonnonamida, 1), new ItemStack(DQMiscs.itemGenmaseki, 1), new ItemStack(DQMiscs.itemGenmaseki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemLittlemedal5, 1), new Object[] {new ItemStack(DQMiscs.itemLittlemedal, 1), new ItemStack(DQMiscs.itemLittlemedal, 1), new ItemStack(DQMiscs.itemLittlemedal, 1), new ItemStack(DQMiscs.itemLittlemedal, 1), new ItemStack(DQMiscs.itemLittlemedal, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemLittlemedal10, 1), new Object[] {new ItemStack(DQMiscs.itemLittlemedal5, 1), new ItemStack(DQMiscs.itemLittlemedal5, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemLittlemedal50, 1), new Object[] {new ItemStack(DQMiscs.itemLittlemedal10, 1), new ItemStack(DQMiscs.itemLittlemedal10, 1), new ItemStack(DQMiscs.itemLittlemedal10, 1), new ItemStack(DQMiscs.itemLittlemedal10, 1), new ItemStack(DQMiscs.itemLittlemedal10, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemLittlemedal100, 1), new Object[] {new ItemStack(DQMiscs.itemLittlemedal50, 1), new ItemStack(DQMiscs.itemLittlemedal50, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemAsasindaga , 1), new Object[] {new ItemStack(DQWeapons.itemDokubari, 1), new ItemStack(DQWeapons.itemSeinarunaifu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemOriharukon , 1), new Object[] {new ItemStack(DQIngots.itemMisriru, 1), new ItemStack(DQIngots.itemPuratina, 1), new ItemStack(DQIngots.itemTaiyounoisi, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKingdaiya , 1), new Object[] {new ItemStack(Items.diamond, 1), new ItemStack(Items.diamond, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa2 , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasaC , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa, 1), new ItemStack(DQMiscs.itemMetaru, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasaR, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasaB, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasaG, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasaY, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemRisaikurusuton , 1), new Object[] {new ItemStack(DQMiscs.itemTukemonoisi, 1), new ItemStack(DQMiscs.itemTukemonoisi, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasaR , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa, 1), new ItemStack(DQMiscs.itemAkaisango, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasaB , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasaG , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasaY , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa, 1), new ItemStack(DQMiscs.itemHananomitu, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa2R , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa2, 1), new ItemStack(DQMiscs.itemAkaisango, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa2B , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa2, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa2G , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa2, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa2Y , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasa2, 1), new ItemStack(DQMiscs.itemHananomitu, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiao , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiUe, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiao , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiSita, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiao , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiao , 1), new Object[] {new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(DQMiscs.itemSuraimuzeri, 1), new ItemStack(Blocks.torch, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusidaidai , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQIngots.itemTaiyounoisi, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusihai , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemKoumorinohane, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusisiro , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiaka , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemAkaisango, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikuro , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemAyakasisou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusitya , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQBlocks.DqmBlockGenkotu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikoimidori , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemKyodaihigetokage, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusimurasaki , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemJuryokunomoto, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikiiro , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemHananomitu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusimidori , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusipink , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemUsaginosippo, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiusuao , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQIngots.itemKoorinokessyou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikon , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiao, 1), new ItemStack(DQMiscs.itemYorunotobari, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusidaidai , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusidaidai2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusihai , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusihai2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusisiro , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusisiro2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiaka , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiaka2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikuro , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusikuro2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusitya , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusitya2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikoimidori , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusikoimidori2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusimurasaki , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusimurasaki2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikiiro , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusikiiro2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusimidori , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusimidori2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusipink , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusipink2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiusuao , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiusuao2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikon , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusikon2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusidaidai2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusidaidai, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusihai2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusihai, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusisiro2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusisiro, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiaka2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiaka, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikuro2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusikuro, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusitya2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusitya, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikoimidori2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusikoimidori, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusimurasaki2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusimurasaki, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikiiro2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusikiiro, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusimidori2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusimidori, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusipink2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusipink, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiusuao2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusiusuao, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockYajirusikon2 , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockYajirusikon, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaBG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaB, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaDG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaD, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaEG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaE, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaGG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaG, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaIG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaI, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaLG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaL, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaNG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaN, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaOG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaO, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaQG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaQ, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaRG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaR, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaSG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaS, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaWG, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDaizaW, 1), new ItemStack(Blocks.glass, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaB, 1), new Object[] {new ItemStack(Blocks.brick_block, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaD, 1), new Object[] {new ItemStack(Blocks.diamond_block, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaE, 1), new Object[] {new ItemStack(Blocks.emerald_block, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaG, 1), new Object[] {new ItemStack(Blocks.gold_block, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaI, 1), new Object[] {new ItemStack(Blocks.iron_block, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaL, 1), new Object[] {new ItemStack(Blocks.lapis_block, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaN, 1), new Object[] {new ItemStack(Blocks.nether_brick, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaO, 1), new Object[] {new ItemStack(Blocks.obsidian, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaQ, 1), new Object[] {new ItemStack(Blocks.quartz_block, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaR, 1), new Object[] {new ItemStack(Blocks.redstone_block, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaS, 1), new Object[] {new ItemStack(Blocks.stone, 1), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDaizaW, 1), new Object[] {new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(DQMiscs.itemRisaikurusuton, 1)});

        //GameRegistry.addShapelessRecipe(new ItemStack(Wakanai, 8), new Object[] {new ItemStack(Toumei, 1)});

        /*
        GameRegistry.addShapelessRecipe(new ItemStack(Toumei , 1), new Object[]
                {
                    new ItemStack(Blocks.glass, 1)
                });
        */
        GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot , 1), new Object[]
                                        {
                                            new ItemStack(DQMiscs.itemNekozuna, 1), new ItemStack(DQIngots.itemKagaminoisi, 1)
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond , 2), new Object[]
                                        {
                                            new ItemStack(DQMiscs.itemKingdaiya, 1), new ItemStack(DQMiscs.itemKingdaiya, 1)
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot , 4), new Object[]
                                        {
                                            new ItemStack(DQMiscs.itemKingdaiya, 1)
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemTensinohane , 1), new Object[]
                                        {
                                            new ItemStack(DQMiscs.itemSeijanohai, 1), new ItemStack(DQMiscs.itemMeijikimeranohane, 1)
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKiyomenomizu , 1), new Object[]
                                        {
                                            new ItemStack(Items.water_bucket, 1), new ItemStack(DQMiscs.itemSeijanohai, 1)
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(DQSeeds.itemBannouyaku , 1), new Object[]
                                        {
                                            new ItemStack(DQSeeds.itemYakusou, 1), new ItemStack(DQSeeds.itemDokukesisou, 1)
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasa , 1), new Object[]
                                        {
                                            new ItemStack(DQMiscs.itemKazekirinohane, 1), new ItemStack(DQMiscs.itemKoumorinohane, 1), new ItemStack(DQMiscs.itemTyounohane, 1)
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(DQSeeds.itemJouyakusou , 2), new Object[]
                                        {
                                            new ItemStack(DQSeeds.itemYakusou, 1), new ItemStack(DQSeeds.itemYakusou, 1), new ItemStack(DQSeeds.itemYakusou, 1),
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(DQSeeds.itemTokuyakusou , 2), new Object[]
                                        {
                                            new ItemStack(DQSeeds.itemJouyakusou, 1), new ItemStack(DQSeeds.itemJouyakusou, 1), new ItemStack(DQSeeds.itemJouyakusou, 1),
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemSekaijunoha , 1), new Object[]
                                        {
                                            new ItemStack(DQMiscs.itemSuraimuosyarebana, 1), new ItemStack(DQMiscs.itemHananomitu, 1), new ItemStack(DQSeeds.itemTokuyakusou, 1), new ItemStack(DQSeeds.itemYakusou3, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1)
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemTukinomegumi , 1), new Object[]
                                        {
                                            new ItemStack(DQIngots.itemMoon, 1), new ItemStack(DQMiscs.itemSeinarusizuku, 1),
                                        });
        GameRegistry.addShapelessRecipe(new ItemStack(DQAccessories.itemKirapiasu2, 1), new Object[] {new ItemStack(DQWeapons.itemKirapiasu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQWeapons.itemKirapiasu, 1), new Object[] {new ItemStack(DQAccessories.itemKirapiasu2, 1)});



        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosifurupiasu , 1), new Object[]
                               {
                                   "CBC",
                                   "ADA",
                                   "CBC",
                                   'A', DQAccessories.itemHosifuru, 'B', DQAccessories.itemHayatenoring, 'C', DQAccessories.itemGinnoyubiwa, 'D', DQAccessories.itemTensinopiasu
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosifurupiasu2 , 1), new Object[]
                               {
                                   "CBC",
                                   "ADA",
                                   "CBC",
                                   'A', DQMiscs.itemGenmasekiB, 'B', DQMiscs.itemGenmasekiG, 'C', DQAccessories.itemHosifurupiasu, 'D', DQAccessories.itemTensinopiasu
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosizoranokubikazari2 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQAccessories.itemTikaranorubi, 'B', DQAccessories.itemMamorinorubi, 'C', DQAccessories.itemHosizoranokubikazari, 'D', DQAccessories.itemHosinokubikazari, 'E', DQAccessories.itemHosizoranokubikazari
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosizoranokubikazari3 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQAccessories.itemSeijukunokubikazari, 'B', DQAccessories.itemKataminokubikazari, 'C', DQAccessories.itemSinigaminokubikazari, 'D', DQAccessories.itemFurubitaring, 'E', DQAccessories.itemHosizoranokubikazari2
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosizoranokubikazari4 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQMiscs.itemGenmasekiB, 'B', DQMiscs.itemGenmasekiG, 'C', DQAccessories.itemHosizoranokubikazari, 'D', DQAccessories.itemHosizoranokubikazari2, 'E', DQAccessories.itemHosizoranokubikazari3
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemIkarinotatu2 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQAccessories.itemRyuunouroko, 'B', DQAccessories.itemSuraimupiasu, 'C', DQAccessories.itemRoiyarubajjji, 'D', DQAccessories.itemAkumanotatu, 'E', DQAccessories.itemIkarinotatu
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemIkarinotatu3 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQAccessories.itemInotinoyubiwa, 'B', DQAccessories.itemMayokenoseiin, 'C', DQAccessories.itemRakkipendanto, 'D', DQAccessories.itemIkarinotatu, 'E', DQAccessories.itemIkarinotatu2
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemIkarinotatu4 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQMiscs.itemGenmasekiB, 'B', DQMiscs.itemGenmasekiG, 'C', DQAccessories.itemMegaminoyubiwa, 'D', DQAccessories.itemIkarinotatu2, 'E', DQAccessories.itemIkarinotatu3
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemGouketunoudewa2 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQAccessories.itemTikaranoyubiwa, 'B', DQAccessories.itemTikaranorubi, 'C', DQAccessories.itemAkumanotatu, 'D', DQAccessories.itemIkarinotatu, 'E', DQAccessories.itemGouketunoudewa
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemGouketunoudewa3 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQAccessories.itemAkumanopiasu, 'B', DQAccessories.itemKirapiasu2, 'C', DQAccessories.itemIkarinotatu2, 'D', DQAccessories.itemGouketunoudewa, 'E', DQAccessories.itemGouketunoudewa2
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemGouketunoudewa4 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQMiscs.itemGenmasekiB, 'B', DQMiscs.itemGenmasekiG, 'C', DQAccessories.itemIkarinotatu3, 'D', DQAccessories.itemGouketunoudewa2, 'E', DQAccessories.itemGouketunoudewa3
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMamorinoudewa2 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQAccessories.itemBerupiasu, 'B', DQAccessories.itemMamorinorubi, 'C', DQAccessories.itemInorinoyubiwa, 'D', DQAccessories.itemInotinoyubiwa, 'E', DQAccessories.itemMamorinoudewa
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMamorinoudewa3 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQAccessories.itemIyasinoudewa, 'B', DQAccessories.itemSingonnojuzu, 'C', DQAccessories.itemMahounopiasu, 'D', DQAccessories.itemMamorinoudewa, 'E', DQAccessories.itemMamorinoudewa2
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMamorinoudewa4 , 1), new Object[]
                               {
                                   "DBC",
                                   "AEA",
                                   "CBD",
                                   'A', DQMiscs.itemGenmasekiB, 'B', DQMiscs.itemGenmasekiG, 'C', DQAccessories.itemIkarinotatu2, 'D', DQAccessories.itemHosizoranokubikazari2, 'E', DQAccessories.itemMamorinoudewa3
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHadokunoring2 , 1), new Object[]
                               {
                                   "DAC",
                                   "AEA",
                                   "CAD",
                                   'A', DQAccessories.itemHadokunoring, 'C', DQAccessories.itemSosararing, 'D', DQAccessories.itemMayokenoseiin, 'E', DQAccessories.itemSuparing
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHagennoring2 , 1), new Object[]
                               {
                                   "DAC",
                                   "AEA",
                                   "CAD",
                                   'A', DQAccessories.itemHagennoring, 'C', DQAccessories.itemSosararing, 'D', DQAccessories.itemMegaminoyubiwa, 'E', DQAccessories.itemSuparing
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMangetunoring2 , 1), new Object[]
                               {
                                   "DAC",
                                   "AEA",
                                   "CAD",
                                   'A', DQAccessories.itemMangetunoring, 'C', DQAccessories.itemSosararing, 'D', DQAccessories.itemSeijukunokubikazari, 'E', DQAccessories.itemSuparing
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemRiseinoring2 , 1), new Object[]
                               {
                                   "DAC",
                                   "AEA",
                                   "CAD",
                                   'A', DQAccessories.itemRiseinoring, 'C', DQAccessories.itemSosararing, 'D', DQAccessories.itemMahounopiasu, 'E', DQAccessories.itemSuparing
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemGinganoturugi2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemGinganoturugi, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemNyoraikon2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemNyoraikon, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKobusi32, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemKobusi3, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSinryuunotume2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemSinryuunotume, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHakainotekkyuu2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemHakainotekkyuu, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemGodakkusu2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemGodakkusu, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTyouguringamunomuti2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemTyouguringamunomuti, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSinken2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemSinken, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMetarukingnoyari2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemMetarukingnoyari, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemToririondaga2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemToririondaga, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHaipanova2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemHaipanova, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSefiramunoyumi2, 1), new Object[]
                               {
                                   "CCC",
                                   "BAB",
                                   "DDD",
                                   'A', DQWeapons.itemSefiramunoyumi, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSeijanokakarotto, 1), new Object[]
                               {
                                   "BBB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemSekaijunoha, 'B', DQMiscs.itemKyodaihigetokage, 'V', DQMiscs.itemHaganenoobane, 'W', DQMiscs.itemMajuunokawa, 'Z', DQMiscs.itemMidorinokoke
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSeijanohoui, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BWB",
                                   'A', DQMiscs.itemSekaijunoha, 'B', DQMiscs.itemKyodaihigetokage, 'V', DQMiscs.itemHaganenoobane, 'W', DQMiscs.itemMajuunokawa, 'Z', DQMiscs.itemMidorinokoke
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSeijanotaitu, 1), new Object[]
                               {
                                   "BZB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemSekaijunoha, 'B', DQMiscs.itemKyodaihigetokage, 'V', DQMiscs.itemHaganenoobane, 'W', DQMiscs.itemMajuunokawa, 'Z', DQMiscs.itemMidorinokoke
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSeijanobutu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemSekaijunoha, 'B', DQMiscs.itemKyodaihigetokage, 'V', DQMiscs.itemHaganenoobane, 'W', DQMiscs.itemMajuunokawa, 'Z', DQMiscs.itemMidorinokoke
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemDansanohanekazaribando, 1), new Object[]
                               {
                                   "ZAZ",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemKazekirinohane, 'B', DQMiscs.itemSuraimuosyarebana, 'V', DQMiscs.itemUsaginosippo, 'W', DQMiscs.itemYawarakauru, 'Z', DQMiscs.itemYogoretahoutai
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemDansanosyatu, 1), new Object[]
                               {
                                   "VVV",
                                   "BBB",
                                   "WWW",
                                   'A', DQMiscs.itemKazekirinohane, 'B', DQMiscs.itemSuraimuosyarebana, 'V', DQMiscs.itemUsaginosippo, 'W', DQMiscs.itemYawarakauru, 'Z', DQMiscs.itemYogoretahoutai
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemDansanozubon, 1), new Object[]
                               {
                                   "VBV",
                                   "VBV",
                                   "VBV",
                                   'A', DQMiscs.itemKazekirinohane, 'B', DQMiscs.itemSuraimuosyarebana, 'V', DQMiscs.itemUsaginosippo, 'W', DQMiscs.itemYawarakauru, 'Z', DQMiscs.itemYogoretahoutai
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemDansanobutu, 1), new Object[]
                               {
                                   "ZZZ",
                                   "AAA",
                                   "ZZZ",
                                   'A', DQMiscs.itemKazekirinohane, 'B', DQMiscs.itemSuraimuosyarebana, 'V', DQMiscs.itemUsaginosippo, 'W', DQMiscs.itemYawarakauru, 'Z', DQMiscs.itemYogoretahoutai
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemPurinsesutexiara, 1), new Object[]
                               {
                                   "AAA",
                                   "ABA",
                                   "AAA",
                                   'A', DQMiscs.itemKinka, 'B', DQMiscs.itemBuruoubu, 'V', DQMiscs.itemTensinohane, 'W', DQMiscs.itemYawarakauru, 'Z', DQMiscs.itemYorunotobari
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemPurinsesurobu, 1), new Object[]
                               {
                                   "BWB",
                                   "WAW",
                                   "VVV",
                                   'A', DQMiscs.itemIerooubu, 'B', DQMiscs.itemSeinarusizuku, 'V', DQMiscs.itemNijiirononunokire, 'W', DQMiscs.itemAmatuyunoito, 'Z', DQMiscs.itemYorunotobari
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemPurinsesugurobu, 1), new Object[]
                               {
                                   "VVV",
                                   "BAB",
                                   "ZZZ",
                                   'A', DQMiscs.itemIerooubu, 'B', DQMiscs.itemSeinarusizuku, 'V', DQMiscs.itemNijiirononunokire, 'W', DQMiscs.itemAmatuyunoito, 'Z', DQMiscs.itemTensinohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemPurinsesuhiru, 1), new Object[]
                               {
                                   "ZZZ",
                                   "BAB",
                                   "ZZZ",
                                   'A', DQMiscs.itemBuruoubu, 'B', DQMiscs.itemSeinarusizuku, 'V', DQMiscs.itemNijiirononunokire, 'W', DQMiscs.itemAmatuyunoito, 'Z', DQMiscs.itemTensinohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemOdorikonokamikazari, 1), new Object[]
                               {
                                   "AAA",
                                   "AAA",
                                   "BBB",
                                   'A', DQMiscs.itemKinkai, 'B', DQMiscs.itemSuraimuosyarebana, 'V', DQMiscs.itemTensinohane, 'W', DQMiscs.itemYawarakauru, 'Z', DQMiscs.itemYorunotobari
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemOdorikonofuku, 1), new Object[]
                               {
                                   "WWW",
                                   "BVB",
                                   "BBB",
                                   'A', DQMiscs.itemKinkai, 'B', DQMiscs.itemSuraimuosyarebana, 'V', DQMiscs.itemTensinohane, 'W', DQMiscs.itemYawarakauru, 'Z', DQMiscs.itemYorunotobari
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemOdorikononisokkusu, 1), new Object[]
                               {
                                   "ZZZ",
                                   "ZZZ",
                                   "WWW",
                                   'A', DQMiscs.itemKinkai, 'B', DQMiscs.itemSuraimuosyarebana, 'V', DQMiscs.itemTensinohane, 'W', DQMiscs.itemYawarakauru, 'Z', DQMiscs.itemYorunotobari
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemOdorikonomyuru, 1), new Object[]
                               {
                                   "WWW",
                                   "VAV",
                                   "WWW",
                                   'A', DQMiscs.itemKinkai, 'B', DQMiscs.itemSuraimuosyarebana, 'V', DQMiscs.itemTensinohane, 'W', DQMiscs.itemYawarakauru, 'Z', DQMiscs.itemYorunotobari
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemStarhatto, 1), new Object[]
                               {
                                   "BBB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemRedoubu, 'B', DQIngots.itemRubinogenseki, 'V', DQMiscs.itemGenmaseki, 'W', DQMiscs.itemToukonekisu, 'Z', DQMiscs.itemAkaisango
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemStarnasutu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BWB",
                                   'A', DQMiscs.itemRedoubu, 'B', DQIngots.itemRubinogenseki, 'V', DQMiscs.itemGenmaseki, 'W', DQMiscs.itemToukonekisu, 'Z', DQMiscs.itemAkaisango
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemStarzubon, 1), new Object[]
                               {
                                   "BZB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemRedoubu, 'B', DQIngots.itemRubinogenseki, 'V', DQMiscs.itemGenmaseki, 'W', DQMiscs.itemToukonekisu, 'Z', DQMiscs.itemAkaisango
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemStarbutu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemRedoubu, 'B', DQIngots.itemRubinogenseki, 'V', DQMiscs.itemGenmaseki, 'W', DQMiscs.itemToukonekisu, 'Z', DQMiscs.itemAkaisango
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBusinnobandana, 1), new Object[]
                               {
                                   "BBB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemGurinoubu, 'B', DQMiscs.itemNijiirononunokire, 'V', DQMiscs.itemToukonekisu, 'W', DQMiscs.itemSeinarusizuku, 'Z', DQMiscs.itemIkazutinotama
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBusinnobudougi, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BWB",
                                   'A', DQMiscs.itemGurinoubu, 'B', DQMiscs.itemNijiirononunokire, 'V', DQMiscs.itemToukonekisu, 'W', DQMiscs.itemSeinarusizuku, 'Z', DQMiscs.itemIkazutinotama
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBusinrisuto, 1), new Object[]
                               {
                                   "BZB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemGurinoubu, 'B', DQMiscs.itemNijiirononunokire, 'V', DQMiscs.itemToukonekisu, 'W', DQMiscs.itemSeinarusizuku, 'Z', DQMiscs.itemIkazutinotama
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBusinnobutu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemGurinoubu, 'B', DQMiscs.itemNijiirononunokire, 'V', DQMiscs.itemToukonekisu, 'W', DQMiscs.itemSeinarusizuku, 'Z', DQMiscs.itemIkazutinotama
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBuounohatigane, 1), new Object[]
                               {
                                   "BBB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemDoragonnonamida, 'B', DQMiscs.itemSeireiseki, 'V', DQMiscs.itemHaganenoobane, 'W', DQMiscs.itemTukinomegumi, 'Z', DQMiscs.itemKyodaihigetokage
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBuounosutu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BWB",
                                   'A', DQMiscs.itemDoragonnonamida, 'B', DQMiscs.itemSeireiseki, 'V', DQMiscs.itemHaganenoobane, 'W', DQMiscs.itemTukinomegumi, 'Z', DQMiscs.itemKyodaihigetokage
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBuounoudeate, 1), new Object[]
                               {
                                   "BZB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemDoragonnonamida, 'B', DQMiscs.itemSeireiseki, 'V', DQMiscs.itemHaganenoobane, 'W', DQMiscs.itemTukinomegumi, 'Z', DQMiscs.itemKyodaihigetokage
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBuounokutu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemDoragonnonamida, 'B', DQMiscs.itemSeireiseki, 'V', DQMiscs.itemHaganenoobane, 'W', DQMiscs.itemTukinomegumi, 'Z', DQMiscs.itemKyodaihigetokage
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBudoubandana, 1), new Object[]
                               {
                                   "BBB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemBudouekisu, 'B', DQMiscs.itemRengokunohane, 'V', DQMiscs.itemSuraimuosyarebana, 'W', DQMiscs.itemYogoretahoutai, 'Z', DQMiscs.itemYawarakauru
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBudougi, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BWB",
                                   'A', DQMiscs.itemBudouekisu, 'B', DQMiscs.itemRengokunohane, 'V', DQMiscs.itemSuraimuosyarebana, 'W', DQMiscs.itemYogoretahoutai, 'Z', DQMiscs.itemYawarakauru
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBudougirisuto, 1), new Object[]
                               {
                                   "BZB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemBudouekisu, 'B', DQMiscs.itemRengokunohane, 'V', DQMiscs.itemSuraimuosyarebana, 'W', DQMiscs.itemYogoretahoutai, 'Z', DQMiscs.itemYawarakauru
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBudounokutu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemBudouekisu, 'B', DQMiscs.itemRengokunohane, 'V', DQMiscs.itemSuraimuosyarebana, 'W', DQMiscs.itemYogoretahoutai, 'Z', DQMiscs.itemYawarakauru
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSinkannobousi, 1), new Object[]
                               {
                                   "BBB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemAmatuyunoito, 'B', DQMiscs.itemDoragonnonamida, 'V', DQMiscs.itemHananomitu, 'W', DQMiscs.itemSeijanohai, 'Z', DQMiscs.itemTukinomegumi
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSinkannobutu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BWB",
                                   'A', DQMiscs.itemAmatuyunoito, 'B', DQMiscs.itemDoragonnonamida, 'V', DQMiscs.itemHananomitu, 'W', DQMiscs.itemSeijanohai, 'Z', DQMiscs.itemTukinomegumi
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSinkannoepuron, 1), new Object[]
                               {
                                   "BZB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemAmatuyunoito, 'B', DQMiscs.itemDoragonnonamida, 'V', DQMiscs.itemHananomitu, 'W', DQMiscs.itemSeijanohai, 'Z', DQMiscs.itemTukinomegumi
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSinkannogurobu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemAmatuyunoito, 'B', DQMiscs.itemDoragonnonamida, 'V', DQMiscs.itemHananomitu, 'W', DQMiscs.itemSeijanohai, 'Z', DQMiscs.itemTukinomegumi
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenpouginobando, 1), new Object[]
                               {
                                   "BBB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemHyoutyounohane, 'B', DQMiscs.itemKazekirinohane, 'V', DQMiscs.itemKoumorinohane, 'W', DQMiscs.itemMajuunokawa, 'Z', DQMiscs.itemMeijikimeranohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenpougiue, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BWB",
                                   'A', DQMiscs.itemHyoutyounohane, 'B', DQMiscs.itemKazekirinohane, 'V', DQMiscs.itemKoumorinohane, 'W', DQMiscs.itemMajuunokawa, 'Z', DQMiscs.itemMeijikimeranohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenpougirisuto, 1), new Object[]
                               {
                                   "BZB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemHyoutyounohane, 'B', DQMiscs.itemKazekirinohane, 'V', DQMiscs.itemKoumorinohane, 'W', DQMiscs.itemMajuunokawa, 'Z', DQMiscs.itemMeijikimeranohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenpouginokutu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemHyoutyounohane, 'B', DQMiscs.itemKazekirinohane, 'V', DQMiscs.itemKoumorinohane, 'W', DQMiscs.itemMajuunokawa, 'Z', DQMiscs.itemMeijikimeranohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemDaimadounobousi, 1), new Object[]
                               {
                                   "BBB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemGurinoubu, 'B', DQMiscs.itemNijiirononunokire, 'V', DQMiscs.itemTensinosoma, 'W', DQMiscs.itemIkazutinotama, 'Z', DQMiscs.itemGenmaseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemDaimadounorobu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BWB",
                                   'A', DQMiscs.itemGurinoubu, 'B', DQMiscs.itemNijiirononunokire, 'V', DQMiscs.itemTensinosoma, 'W', DQMiscs.itemIkazutinotama, 'Z', DQMiscs.itemGenmaseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemDaimadougurobu, 1), new Object[]
                               {
                                   "BZB",
                                   "VAV",
                                   "BZB",
                                   'A', DQMiscs.itemGurinoubu, 'B', DQMiscs.itemNijiirononunokire, 'V', DQMiscs.itemTensinosoma, 'W', DQMiscs.itemIkazutinotama, 'Z', DQMiscs.itemGenmaseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemDaimadounosyuzu, 1), new Object[]
                               {
                                   "BWB",
                                   "VAV",
                                   "BBB",
                                   'A', DQMiscs.itemGurinoubu, 'B', DQMiscs.itemNijiirononunokire, 'V', DQMiscs.itemTensinosoma, 'W', DQMiscs.itemIkazutinotama, 'Z', DQMiscs.itemGenmaseki
                               });

        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSatorinokanmuri, 1), new Object[]
                               {
                                   " V ",
                                   "VWV",
                                   "VVV",
                                   'V', DQMiscs.itemKinkai, 'W', DQIngots.itemRubinogenseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSatorinowanpisu, 1), new Object[]
                               {
                                   "VZV",
                                   "WZW",
                                   "VZV",
                                   'V', DQMiscs.itemHaganenoobane, 'W', DQMiscs.itemTukinomegumi, 'Z', DQMiscs.itemNijiirononunokire
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSatorinotebukuro, 1), new Object[]
                               {
                                   "VZV",
                                   "WZW",
                                   "VZV",
                                   'V', DQMiscs.itemMadarakumonoito, 'W', DQMiscs.itemTukinomegumi, 'Z', DQMiscs.itemNijiirononunokire
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSatorinokutu, 1), new Object[]
                               {
                                   "VZV",
                                   "WZW",
                                   "VVV",
                                   'V', DQMiscs.itemMadarakumonoito, 'W', DQMiscs.itemTukinomegumi, 'Z', DQMiscs.itemNijiirononunokire
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemBerupiasu, 1), new Object[]
                               {
                                   "ZWZ",
                                   "WVW",
                                   "ZWZ",
                                   'V', DQMiscs.itemSeisui, 'W', DQIngots.itemKagaminoisi, 'Z', DQIngots.itemTokinosuisyou
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosinopiasu, 1), new Object[]
                               {
                                   "VWV",
                                   "WZW",
                                   "VWV",
                                   'V', DQIngots.itemHosinokakera, 'W', DQIngots.itemMoon, 'Z', DQMiscs.itemKinka
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemKinnopiasu, 1), new Object[]
                               {
                                   "WWW",
                                   "WZW",
                                   "WWW",
                                   'W', DQMiscs.itemKinkai, 'Z', DQIngots.itemRubinogenseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosinokubikazari, 1), new Object[]
                               {
                                   "WWW",
                                   "WZW",
                                   "ZVZ",
                                   'V', DQAccessories.itemHosinopiasu, 'W', DQMiscs.itemMetaru, 'Z', DQMiscs.itemGinka
                               });
/*
        GameRegistry.addRecipe(new ItemStack(Torihazusi, 1), new Object[]
                               {
                                   "VVV",
                                   "WWW",
                                   "ZZZ",
                                   'V', DQMiscs.itemHebinonukegara, 'W', DQMiscs.itemTetunokugi, 'Z', DQMiscs.itemMajuunokawa
                               });
        GameRegistry.addRecipe(new ItemStack(Magicbook2, 1), new Object[]
                               {
                                   "WZW",
                                   "ZVZ",
                                   "WZW",
                                   'V', Magicbook, 'W', DQMiscs.itemDoragonnonamida, 'Z', DQIngots.itemKoorinokessyou
                               });
*/
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKobusi3, 1), new Object[]
                               {
                                   "VVV",
                                   "VVV",
                                   "VVV",
                                   'V', DQWeapons.itemKobusi2
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKobusi2, 1), new Object[]
                               {
                                   "VVV",
                                   "VVV",
                                   "VVV",
                                   'V', DQWeapons.itemKobusi
                               });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKobusi, 1), new Object[]
                               {
                                   "VVV",
                                   "VVV",
                                   "VVV",
                                   'V', DQBlocks.DqmBlockGenkotu
                               });
/*
        GameRegistry.addRecipe(new ItemStack(Syokikanokusuri, 1), new Object[]
                               {
                                   "WZW",
                                   "ZVZ",
                                   "WZW",
                                   'V', DQMiscs.itemAyasiikobin, 'W', DQMiscs.itemDokuganokona, 'Z', DQMiscs.itemDokudokuhedoro
                               });
*/
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemReipia, 1), new Object[]
                               {
                                   "ZZW",
                                   "ZWZ",
                                   "VZZ",
                                   'V', DQMiscs.itemKinkai, 'W', DQIngots.itemTekkouseki, 'Z', DQMiscs.itemTetunokugi
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMakenreipia, 1), new Object[]
                               {
                                   "ZZW",
                                   "ZVZ",
                                   "WZZ",
                                   'V', DQWeapons.itemReipia, 'W', DQMiscs.itemUraminohouju, 'Z', DQMiscs.itemJuryokunomoto
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemDoragonkira, 1), new Object[]
                               {
                                   "AAZ",
                                   "WVA",
                                   "BWA",
                                   'V', DQWeapons.itemHaganenoturugi, 'W', DQMiscs.itemKyodaihigetokage, 'Z', DQMiscs.itemDoragonnonamida, 'A', DQMiscs.itemMidorinokoke, 'B', DQIngots.itemRubinogenseki
                               });
/*ver1.20ADD->
        GameRegistry.addRecipe(new ItemStack(DQSeeds.itemOugon4 , 1), new Object[]
                               {
                                   "SYT",
                                   "XZX",
                                   "UYW",
                                   'S', DQMiscs.itemRedoubu, 'T', DQMiscs.itemBuruoubu, 'U', DQMiscs.itemIerooubu,
                                   'W', DQMiscs.itemPaapuruoubu, 'X', DQSeeds.itemMahounomiI3, 'Y', DQSeeds.itemMaryokunotaneI3, 'Z', DQSeeds.itemOugon3,
                               });
ver1.20ADD-<*/
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemKawanotate, 1), new Object[]
                               {
                                   "VVV",
                                   "VVV",
                                   "VVV",
                                   'V', DQMiscs.itemMajuunokawa
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemSuraimutorei, 1), new Object[]
                               {
                                   "ZWZ",
                                   "WVW",
                                   "ZWZ",
                                   'V', DQAccessories.itemKawanotate, 'W', DQMiscs.itemSuraimuzeri, 'Z', DQMiscs.itemNebanebazeri
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHonoonotate, 1), new Object[]
                               {
                                   "ZWZ",
                                   "WVW",
                                   "ZWZ",
                                   'V', DQAccessories.itemHaganenotate, 'W', DQIngots.itemTaiyounoisi, 'Z', DQIngots.itemYougansekinokakera
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemKoorinotate, 1), new Object[]
                               {
                                   "ZWZ",
                                   "WVW",
                                   "ZWZ",
                                   'V', DQAccessories.itemHaganenotate, 'W', DQIngots.itemPuratina, 'Z', DQIngots.itemKoorinokessyou
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemFuujinnnotate, 1), new Object[]
                               {
                                   "ZAZ",
                                   "WVW",
                                   "ZWZ",
                                   'V', DQAccessories.itemOogasirudo, 'W', DQMiscs.itemHaganenoobane, 'Z', DQMiscs.itemIkazutinotama, 'A', DQMiscs.itemGurinoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemTikaranotate, 1), new Object[]
                               {
                                   "ZAZ",
                                   "WVW",
                                   "ZAZ",
                                   'V', DQAccessories.itemFuujinnnotate, 'W', DQMiscs.itemKenjanoisi, 'Z', DQMiscs.itemTensinosoma, 'A', DQMiscs.itemIerooubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHajanoturugi, 1), new Object[]
                               {
                                   "ZWZ",
                                   "WVW",
                                   "ZWZ",
                                   'V', DQWeapons.itemHaganenoturugi, 'W', DQIngots.itemPuratina, 'Z', DQMiscs.itemSeijanohai
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemIgurufeza , 1), new Object[]
                               {
                                   "XZX",
                                   "ZWZ",
                                   "XZX",
                                   'W', DQWeapons.itemYaibanobumeran, 'X', DQMiscs.itemKazekirinohane, 'Z', DQMiscs.itemKyodainakiba
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKurosubumeran , 1), new Object[]
                               {
                                   "XWX",
                                   "WWW",
                                   "XWX",
                                   'W', DQIngots.itemYougansekinokakera, 'X', DQIngots.itemTekkouseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBigbougan , 1), new Object[]
                               {
                                   "XZX",
                                   "ZWZ",
                                   "XZX",
                                   'W', DQWeapons.itemMugennoyumi, 'X', DQIngots.itemOriharukon, 'Z', DQMiscs.itemHaganenoobane
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMugennoyumi , 1), new Object[]
                               {
                                   "XZX",
                                   "ZWZ",
                                   "XZX",
                                   'W', DQWeapons.itemKaryuudonoyumi, 'X', DQMiscs.itemKyodaihigetokage, 'Z', DQMiscs.itemMeijikimeranohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKaryuudonoyumi , 1), new Object[]
                               {
                                   "XZX",
                                   "ZWZ",
                                   "XZX",
                                   'W', DQWeapons.itemSyotobou, 'X', DQMiscs.itemKoumorinohane, 'Z', DQMiscs.itemTyounohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemGuradiusu , 1), new Object[]
                               {
                                   "XZX",
                                   "ZWZ",
                                   "XZX",
                                   'W', DQWeapons.itemAsasindaga, 'X', DQMiscs.itemSeijanohai, 'Z', DQIngots.itemMisriru
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKarubebuto , 1), new Object[]
                               {
                                   "XZX",
                                   "ZWZ",
                                   "XZX",
                                   'W', DQWeapons.itemAkumanomuti, 'X', DQMiscs.itemSeijanohai, 'Z', DQIngots.itemMisriru
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemAkumanomuti , 1), new Object[]
                               {
                                   " X ",
                                   "XWX",
                                   " X ",
                                   'W', DQWeapons.itemBatoruribon, 'X', DQMiscs.itemUraminohouju
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBasutawipu , 1), new Object[]
                               {
                                   "XZX",
                                   "ZWZ",
                                   "XZX",
                                   'W', DQWeapons.itemBatoruribon, 'X', DQMiscs.itemTetunokugi, 'Z', DQMiscs.itemYogoretahoutai
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBatoruribon , 1), new Object[]
                               {
                                   " X ",
                                   "XWX",
                                   " X ",
                                   'W', DQWeapons.itemKawanomuti, 'X', DQIngots.itemTekkouseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemRougabou , 1), new Object[]
                               {
                                   "XXX",
                                   "XWX",
                                   "XXX",
                                   'W', DQWeapons.itemDaikokubasira, 'X', DQMiscs.itemTogetogenokiba
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemDaikokubasira , 1), new Object[]
                               {
                                   "XXX",
                                   "XWX",
                                   "XXX",
                                   'W', DQWeapons.itemHaganenokon, 'X', DQIngots.itemYougansekinokakera
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMoonakkusu , 1), new Object[]
                               {
                                   " X ",
                                   "XWX",
                                   " X ",
                                   'W', DQWeapons.itemTatujinnoono, 'X', DQIngots.itemMoon
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKingakkusu , 1), new Object[]
                               {
                                   " X ",
                                   "XWX",
                                   " X ",
                                   'W', DQWeapons.itemTatujinnoono, 'X', DQIngots.itemPuratina
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTatujinnoono , 1), new Object[]
                               {
                                   " X ",
                                   "XWX",
                                   " X ",
                                   'W', DQWeapons.itemHaganenoono, 'X', DQIngots.itemYougansekinokakera
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemOowasinotume , 1), new Object[]
                               {
                                   "XXX",
                                   "XWX",
                                   "XXX",
                                   'W', DQWeapons.itemMayokenotume, 'X', DQMiscs.itemHaganenoobane
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMayokenotume , 1), new Object[]
                               {
                                   "XXX",
                                   "XWX",
                                   "XXX",
                                   'W', DQWeapons.itemMajuunotume, 'X', DQMiscs.itemSeijanohai
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemWohanmakai , 1), new Object[]
                               {
                                   "XXX",
                                   "XWX",
                                   "XXX",
                                   'W', DQWeapons.itemWohanma, 'X', DQMiscs.itemBekkou
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemToraidento , 1), new Object[]
                               {
                                   " WX",
                                   " ZW",
                                   "Z  ",
                                   'W', DQMiscs.itemMajuunotuno, 'X', DQMiscs.itemKyodainakiba, 'Z', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHaganenoyari , 1), new Object[]
                               {
                                   " BB",
                                   " AB",
                                   "B  ",
                                   'A', DQWeapons.itemToraidento, 'B', DQIngots.itemTekkouseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHaruberuto , 1), new Object[]
                               {
                                   "  B",
                                   " A ",
                                   "   ",
                                   'A', DQWeapons.itemToraidento, 'B', DQWeapons.itemHaganenoono
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHoriransu , 1), new Object[]
                               {
                                   " BC",
                                   " AB",
                                   "B  ",
                                   'A', DQWeapons.itemHaganenoyari, 'B', DQMiscs.itemMetaru, 'C', DQMiscs.itemSeinarusizuku
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemGurakosunoyari , 1), new Object[]
                               {
                                   " CB",
                                   " AC",
                                   "C  ",
                                   'A', DQWeapons.itemToraidento, 'B', DQMiscs.itemBuruoubu, 'C', DQIngots.itemMisriru
                               });

        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMikawasinofuku , 1), new Object[]
                               {
                                   "BBB",
                                   "AAA",
                                   "BBB",
                                   'A', DQMiscs.itemAmatuyunoito, 'B', DQMiscs.itemMidorinokoke
                               });

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockDqmbed2 , 1), new Object[]
                               {
                                   "BAB",
                                   "   ",
                                   "   ",
                                   'A', DQDecorates.DqmBlockDqmbed, 'B', DQIngots.itemTaiyounoisi
                               });

        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKeikogi , 1), new Object[]
                               {
                                   "A A",
                                   "AAA",
                                   "AAA",
                                   'A', DQMiscs.itemRengokunohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKeikogisita , 1), new Object[]
                               {
                                   "AAA",
                                   "A A",
                                   "A A",
                                   'A', DQMiscs.itemRengokunohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKeikoginobandana , 1), new Object[]
                               {
                                   "AAA",
                                   "AAA",
                                   "   ",
                                   'A', DQMiscs.itemYorunotobari
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKeikoginokutu , 1), new Object[]
                               {
                                   "A A",
                                   "A A",
                                   "   ",
                                   'A', DQMiscs.itemYorunotobari
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemTabibitonofuku , 1), new Object[]
                               {
                                   "A A",
                                   "AAA",
                                   "AAA",
                                   'A', DQMiscs.itemTyounohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemTabibitonotebukuro , 1), new Object[]
                               {
                                   "AAA",
                                   "A A",
                                   "A A",
                                   'A', DQMiscs.itemTyounohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRezamanto , 1), new Object[]
                               {
                                   "AAA",
                                   "BBB",
                                   "AAA",
                                   'A', DQMiscs.itemMajuunokawa, 'B', DQMiscs.itemMadarakumonoito
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSyotobou , 1), new Object[]
                               {
                                   "AAA",
                                   "B A",
                                   "BBA",
                                   'A', Items.stick, 'B', Items.string
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHowaitosirudo , 1), new Object[]
                               {
                                   "BAB",
                                   "ABA",
                                   "BAB",
                                   'A', DQMiscs.itemMetaru, 'B', DQMiscs.itemKinkai
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMahounotate , 1), new Object[]
                               {
                                   "BBB",
                                   "BAB",
                                   "BBB",
                                   'A', DQAccessories.itemHowaitosirudo, 'B', DQMiscs.itemUraminohouju
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMikagaminotate , 1), new Object[]
                               {
                                   "CBC",
                                   "BAB",
                                   "CBC",
                                   'A', DQAccessories.itemPuratinasirudo, 'B', DQMiscs.itemSeinarusizuku, 'C', DQIngots.itemKagaminoisi
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemPuratinasirudo , 1), new Object[]
                               {
                                   "BBB",
                                   "BAB",
                                   "BBB",
                                   'A', DQAccessories.itemMahounotate, 'B', DQIngots.itemPuratina2
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemKawanotate , 1), new Object[]
                               {
                                   "AAA",
                                   "AAA",
                                   "AAA",
                                   'A', Items.leather
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMetarukingnotate , 1), new Object[]
                               {
                                   "AAA",
                                   "ABA",
                                   "AAA",
                                   'A', DQMiscs.itemMetaloubu, 'B', DQAccessories.itemMikagaminotate
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMonosasizao , 1), new Object[]
                               {
                                   "  B",
                                   " B ",
                                   "B  ",
                                   'B', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTenbinbou , 1), new Object[]
                               {
                                   "  A",
                                   " A ",
                                   "A  ",
                                   'A', new ItemStack(Blocks.cobblestone, 1, 0)
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKawanomuti , 1), new Object[]
                               {
                                   " A ",
                                   "A A",
                                   " A ",
                                   'A', Items.leather
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKawanomuti , 1), new Object[]
                               {
                                   " A ",
                                   "A A",
                                   " A ",
                                   'A', DQMiscs.itemMajuunokawa
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKudamononaifu , 1), new Object[]
                               {
                                   "   ",
                                   " B ",
                                   "A  ",
                                   'A', Items.stick, 'B', Items.iron_ingot
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemIsinotume , 1), new Object[]
                               {
                                   "AAA",
                                   "BBB",
                                   "   ",
                                   'A', Blocks.cobblestone, 'B', Items.leather
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemIsinotume , 1), new Object[]
                               {
                                   "AAA",
                                   "BBB",
                                   "   ",
                                   'A', Blocks.cobblestone, 'B', DQMiscs.itemMajuunokawa
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTakenoyari , 1), new Object[]
                               {
                                   "  A",
                                   " B ",
                                   "B  ",
                                   'A', Blocks.cobblestone, 'B', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemJaiantokurabu , 1), new Object[]
                               {
                                   "AAA",
                                   "AAA",
                                   " A ",
                                   'A', Blocks.cobblestone
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKinobousi , 1), new Object[]
                               {
                                   "AAA",
                                   "AAA",
                                   "A A",
                                   'A', Blocks.planks
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBsword1 , 1), new Object[]
                               {
                                   "AAB",
                                   "   ",
                                   "   ",
                                   'A', Blocks.planks, 'B', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBsword2 , 1), new Object[]
                               {
                                   "AAB",
                                   "   ",
                                   "   ",
                                   'A', Blocks.cobblestone, 'B', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBsword3 , 1), new Object[]
                               {
                                   "AAB",
                                   "   ",
                                   "   ",
                                   'A', Items.iron_ingot, 'B', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBsword4 , 1), new Object[]
                               {
                                   "AAB",
                                   "   ",
                                   "   ",
                                   'A', Items.gold_ingot, 'B', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBsword5 , 1), new Object[]
                               {
                                   "AAB",
                                   "   ",
                                   "   ",
                                   'A', Items.diamond, 'B', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemGureitoakusu , 1), new Object[]
                               {
                                   "BCB",
                                   "CAC",
                                   "BCB",
                                   'A', DQWeapons.itemHaounoono, 'B', DQMiscs.itemMetaru, 'C', DQMiscs.itemRyuunohizake
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSensinokabuto , 1), new Object[]
                               {
                                   "BBB",
                                   "BBB",
                                   "AAA",
                                   'A', DQIngots.itemTaiyounoisi, 'B', DQIngots.itemKagaminoisi
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSensinoyoroi , 1), new Object[]
                               {
                                   "BBB",
                                   "CAC",
                                   "CCC",
                                   'A', DQIngots.itemTaiyounoisi, 'B', DQIngots.itemKagaminoisi, 'C', DQIngots.itemRubinogenseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSensinogurobu , 1), new Object[]
                               {
                                   "BBB",
                                   "AAA",
                                   "CCC",
                                   'A', DQIngots.itemTaiyounoisi, 'B', DQMiscs.itemHebinonukegara, 'C', DQMiscs.itemKyodaihigetokage
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSensinobutu , 1), new Object[]
                               {
                                   "BAC",
                                   "BAC",
                                   "BAC",
                                   'A', DQIngots.itemTaiyounoisi, 'B', DQMiscs.itemHebinonukegara, 'C', DQMiscs.itemKyodaihigetokage
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemPuratinaheddo , 1), new Object[]
                               {
                                   "AAA",
                                   "ABA",
                                   "BBB",
                                   'A', DQIngots.itemPuratina, 'B', DQIngots.itemMoon
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemPuratinameiru , 1), new Object[]
                               {
                                   "ABA",
                                   "AAA",
                                   "BAB",
                                   'A', DQIngots.itemPuratina, 'B', DQIngots.itemMoon
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemPuratinagantoretto , 1), new Object[]
                               {
                                   "AAA",
                                   "ABA",
                                   "ABA",
                                   'A', DQIngots.itemPuratina, 'B', DQIngots.itemMoon
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemPuratinaguribu , 1), new Object[]
                               {
                                   "ABA",
                                   "ABA",
                                   "BBB",
                                   'A', DQIngots.itemPuratina, 'B', DQIngots.itemMoon
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMisuriruherumu , 1), new Object[]
                               {
                                   "AAA",
                                   "ABA",
                                   "BBB",
                                   'A', DQIngots.itemMisriru, 'B', DQMiscs.itemKingdaiya
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMisurirumeiru , 1), new Object[]
                               {
                                   "AAA",
                                   "CBC",
                                   "ACA",
                                   'A', DQIngots.itemMisriru, 'B', DQMiscs.itemKingdaiya, 'C', DQIngots.itemRubinogenseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMisuritugantoretto , 1), new Object[]
                               {
                                   "AAA",
                                   "ABA",
                                   "ABA",
                                   'A', DQIngots.itemMisriru, 'B', DQMiscs.itemKingdaiya
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMisuriruguribu , 1), new Object[]
                               {
                                   "ABA",
                                   "ABA",
                                   "BBB",
                                   'A', DQIngots.itemMisriru, 'B', DQMiscs.itemKingdaiya
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRyuukisinokabuto , 1), new Object[]
                               {
                                   "ABA",
                                   "AAA",
                                   "CCC",
                                   'A', DQIngots.itemOriharukon, 'B', DQIngots.itemMoon, 'C', DQMiscs.itemSeireiseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRyuukisinoyoroi , 1), new Object[]
                               {
                                   "ACA",
                                   "ABA",
                                   "BCB",
                                   'A', DQIngots.itemOriharukon, 'B', DQIngots.itemMoon, 'C', DQMiscs.itemSeireiseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRyuukisinokote , 1), new Object[]
                               {
                                   "ACA",
                                   "BBB",
                                   "ACA",
                                   'A', DQIngots.itemOriharukon, 'B', DQIngots.itemMoon, 'C', DQMiscs.itemSeireiseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRyuukisinobutu , 1), new Object[]
                               {
                                   "ACA",
                                   "ACA",
                                   "BBB",
                                   'A', DQIngots.itemOriharukon, 'B', DQIngots.itemMoon, 'C', DQMiscs.itemSeireiseki
                               });
        /*
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemSuparing , 1), new Object[]
                               {
                                   "AAA",
                                   "AAA",
                                   "A  ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTenkuunoturugi , 1), new Object[]
                               {
                                   "AAA",
                                   " AA",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemTenkuunoyoroi , 1), new Object[]
                               {
                                   "AAA",
                                   "   ",
                                   "AA ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
                               */
/*
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemTenkuunotate , 1), new Object[]
                               {
                                   "AAA",
                                   "A  ",
                                   "A  ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
*/
        /*
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemFurubitaring , 1), new Object[]
                               {
                                   "AAA",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSiawasenobousi , 1), new Object[]
                               {
                                   "ABA",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal50
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSiawasenokutu , 1), new Object[]
                               {
                                   "AAB",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal50
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemGouketunoudewa , 1), new Object[]
                               {
                                   "AA ",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMamorinoudewa , 1), new Object[]
                               {
                                   " A ",
                                   " A ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHosikudaki , 1), new Object[]
                               {
                                   "AB ",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal50
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMetarukingnoyari , 1), new Object[]
                               {
                                   "BAB",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemGodakkusu , 1), new Object[]
                               {
                                   "ABC",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTyouguringamunomuti , 1), new Object[]
                               {
                                   "AB ",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMetarukingnoturugi , 1), new Object[]
                               {
                                   "A  ",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMetarukingnokabuto , 1), new Object[]
                               {
                                   " A ",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMetarukingnoyoroi , 1), new Object[]
                               {
                                   "   ",
                                   "A  ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMetarukingnokote , 1), new Object[]
                               {
                                   "   ",
                                   "   ",
                                   "A  ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMetarukingnokutu , 1), new Object[]
                               {
                                   "   ",
                                   "   ",
                                   " A ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSinryuunotume , 1), new Object[]
                               {
                                   "ABB",
                                   "BBC",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemEiyuunoyari , 1), new Object[]
                               {
                                   "ABB",
                                   "BC ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemOdinbou , 1), new Object[]
                               {
                                   "ABB",
                                   "B C",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemNyoraikon , 1), new Object[]
                               {
                                   "ABB",
                                   " B ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemAbunaimizugiue , 1), new Object[]
                               {
                                   "ABB",
                                   "CDD",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5, 'D', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemAbunaimizugisita , 1), new Object[]
                               {
                                   "ADD",
                                   "CBB",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5, 'D', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemToririondaga , 1), new Object[]
                               {
                                   "ABB",
                                   "C  ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenjanobousi , 1), new Object[]
                               {
                                   "ABB",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenjanoroubu , 1), new Object[]
                               {
                                   "BAB",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenjanotebukuro , 1), new Object[]
                               {
                                   "BB ",
                                   "A  ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenjanokutu , 1), new Object[]
                               {
                                   "AB ",
                                   "B  ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemTikaranorubi , 1), new Object[]
                               {
                                   "ABC",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMamorinorubi , 1), new Object[]
                               {
                                   "BAC",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKirapiasu , 1), new Object[]
                               {
                                   "CB ",
                                   "A  ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10, 'C', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKisekinoturugi , 1), new Object[]
                               {
                                   "BA ",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSefiramunoyumi , 1), new Object[]
                               {
                                   "   ",
                                   "BA ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100, 'B', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemOogasirudo , 1), new Object[]
                               {
                                   "AB ",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemArakuremasuku , 1), new Object[]
                               {
                                   "A  ",
                                   "B  ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50, 'B', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosifuru , 1), new Object[]
                               {
                                   "   ",
                                   "   ",
                                   " A ",
                                   'A', DQMiscs.itemLittlemedal50
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemInotinoyubiwa , 1), new Object[]
                               {
                                   "AAA",
                                   "AAB",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSuraimunokanmuriK , 1), new Object[]
                               {
                                   "AAA",
                                   "AB ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHayabusanoturugi , 1), new Object[]
                               {
                                   "AAA",
                                   "A B",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSodobureika , 1), new Object[]
                               {
                                   "AAA",
                                   "A  ",
                                   "B  ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemInazumanoyari , 1), new Object[]
                               {
                                   "AAA",
                                   "   ",
                                   "A  ",
                                   'A', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHayatenoring , 1), new Object[]
                               {
                                   "AAA",
                                   "B  ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemFantomumasuku , 1), new Object[]
                               {
                                   "AAA",
                                   "BCC",
                                   "CC ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5, 'C', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMayokenoseiin , 1), new Object[]
                               {
                                   "AAA",
                                   " B ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemUsamimibando , 1), new Object[]
                               {
                                   "AAA",
                                   "BBB",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemBanisutu , 1), new Object[]
                               {
                                   "AAB",
                                   "BBA",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemAmitaitu , 1), new Object[]
                               {
                                   "ABA",
                                   "BBA",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemHaihiru , 1), new Object[]
                               {
                                   "ABA",
                                   "BAB",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemNekomimibando , 1), new Object[]
                               {
                                   "BBB",
                                   "AAA",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemInferunosword , 1), new Object[]
                               {
                                   "AAB",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKoorinoyaiba , 1), new Object[]
                               {
                                   "AB ",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10, 'B', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemKimeranotubasa , 1), new Object[]
                               {
                                   "AAA",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemLittlemedal , 5), new Object[]
                               {
                                   "   ",
                                   " A ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal5
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemLittlemedal5 , 2), new Object[]
                               {
                                   "   ",
                                   " A ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal10
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemLittlemedal10 , 5), new Object[]
                               {
                                   "   ",
                                   " A ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal50
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemLittlemedal50 , 2), new Object[]
                               {
                                   "   ",
                                   " A ",
                                   "   ",
                                   'A', DQMiscs.itemLittlemedal100
                               });
                               */
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSuraimuhead , 1), new Object[]
                               {
                                   "AAA",
                                   "ABA",
                                   "   ",
                                   'A', DQMiscs.itemSuraimuzeri, 'B', DQMiscs.itemMajuunokawa
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                               {
                                   " B ",
                                   "BAB",
                                   " B ",
                                   'A', Blocks.diamond_block, 'B', Blocks.iron_block
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemRedoubu , 1), new Object[]
                               {
                                   "BBB",
                                   "BAB",
                                   "BBB",
                                   'A', DQMiscs.itemMetaloubu, 'B', Blocks.redstone_block
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemBuruoubu , 1), new Object[]
                               {
                                   " B ",
                                   "BAB",
                                   " B ",
                                   'A', DQMiscs.itemMetaloubu, 'B', Blocks.lapis_block
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemGurinoubu , 1), new Object[]
                               {
                                   " B ",
                                   "BAB",
                                   " B ",
                                   'A', DQMiscs.itemMetaloubu, 'B', Blocks.emerald_block
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemPaapuruoubu , 1), new Object[]
                               {
                                   "BBB",
                                   "BAB",
                                   "BBB",
                                   'A', DQMiscs.itemMetaloubu, 'B', Blocks.quartz_block
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemIerooubu , 1), new Object[]
                               {
                                   " B ",
                                   "BAB",
                                   " B ",
                                   'A', DQMiscs.itemMetaloubu, 'B', Blocks.gold_block
                               });
        GameRegistry.addRecipe(new ItemStack(DQIngots.itemInotinoisi , 1), new Object[]
                               {
                                   "AA ",
                                   "   ",
                                   "   ",
                                   'A', DQMiscs.itemGenmaseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQIngots.itemTaiyounoisi , 1), new Object[]
                               {
                                   " A ",
                                   " A ",
                                   "   ",
                                   'A', DQMiscs.itemGenmaseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemKinkai , 1), new Object[]
                               {
                                   "   ",
                                   "AA ",
                                   "   ",
                                   'A', DQMiscs.itemGenmaseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQIngots.itemPuratina , 1), new Object[]
                               {
                                   "   ",
                                   "   ",
                                   "AA ",
                                   'A', DQMiscs.itemGenmaseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQIngots.itemMisriru , 1), new Object[]
                               {
                                   "   ",
                                   " A ",
                                   " A ",
                                   'A', DQMiscs.itemGenmaseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQIngots.itemTokinosuisyou , 1), new Object[]
                               {
                                   " A ",
                                   "   ",
                                   " A ",
                                   'A', DQMiscs.itemGenmaseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemSosararing , 1), new Object[]
                               {
                                   "STU",
                                   "ZAZ",
                                   "VWX",
                                   'A', DQAccessories.itemFurubitaring, 'S', DQMiscs.itemRedoubu, 'T', DQMiscs.itemBuruoubu, 'U', DQMiscs.itemIerooubu, 'V', DQMiscs.itemGurinoubu,
                                   'W', DQMiscs.itemPaapuruoubu, 'X', DQMiscs.itemMetaloubu, 'Y', DQAccessories.itemMamorinoudewa, 'Z', DQMiscs.itemZoma
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemAkumanotatu , 1), new Object[]
                               {
                                   "AAA",
                                   "BBB",
                                   "AAA",
                                   'A', DQMiscs.itemUraminohouju, 'B', DQMiscs.itemRyuunohizake
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHaganenotate , 1), new Object[]
                               {
                                   "BAB",
                                   "AAA",
                                   "BAB",
                                   'A', DQIngots.itemTekkouseki, 'B', DQMiscs.itemKinkai
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemUrokonotate , 1), new Object[]
                               {
                                   "BAB",
                                   "ACA",
                                   "BAB",
                                   'A', DQMiscs.itemMajuunokawa, 'B', DQMiscs.itemHebinonukegara, 'C', DQMiscs.itemDokudokuhedoro
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemOogasirudo , 1), new Object[]
                               {
                                   "BAB",
                                   "ACA",
                                   "BAB",
                                   'A', DQMiscs.itemKyodaihigetokage, 'B', DQMiscs.itemMetaru, 'C', DQMiscs.itemGurinoubu
                               });

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockDqmbed , 1), new Object[]
                               {
                                   "AAA",
                                   "BBB",
                                   "AAA",
                                   'A', DQMiscs.itemUsaginosippo, 'B', DQMiscs.itemYawarakauru
                               });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSinken , 1), new Object[]
                               {
                                   "AAB",
                                   "DEB",
                                   "DCC",
                                   'A', DQMiscs.itemEsterk, 'B', DQMiscs.itemZoma, 'C', DQMiscs.itemDarkRamia,
                                   'D', DQMiscs.itemSuraimujeneraru, 'E', DQMiscs.itemBazuzu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRaiannokabuto , 1), new Object[]
                               {
                                   "XXX",
                                   "X X",
                                   "   ",
                                   'X', DQIngots.itemRubinogenseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRaiannoyoroi , 1), new Object[]
                               {
                                   "X X",
                                   "XXX",
                                   "XXX",
                                   'X', DQIngots.itemRubinogenseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRaiannogurobu , 1), new Object[]
                               {
                                   "XXX",
                                   "X X",
                                   "X X",
                                   'X', DQIngots.itemRubinogenseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRaiannobutu , 1), new Object[]
                               {
                                   "   ",
                                   "X X",
                                   "X X",
                                   'X', DQIngots.itemRubinogenseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRadatomukabuto , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "AAA",
                                   'X', DQIngots.itemOriharukon2, 'A', DQMiscs.itemDoragonnonamida, 'O', DQMiscs.itemRedoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRadatomunoyoroi , 1), new Object[]
                               {
                                   "XAX",
                                   "XOX",
                                   "XXX",
                                   'X', DQIngots.itemOriharukon2, 'A', DQMiscs.itemDoragonnonamida, 'O', DQMiscs.itemRedoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRadatomugurobu , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "XAX",
                                   'X', DQIngots.itemOriharukon2, 'A', DQMiscs.itemDoragonnonamida, 'O', DQMiscs.itemRedoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRadatomubutu , 1), new Object[]
                               {
                                   "AAA",
                                   "XOX",
                                   "XAX",
                                   'X', DQIngots.itemOriharukon2, 'A', DQMiscs.itemDoragonnonamida, 'O', DQMiscs.itemRedoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRoresiametto , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "AAA",
                                   'X', DQMiscs.itemNijiirononunokire, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemBuruoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRoresianofuku , 1), new Object[]
                               {
                                   "XAX",
                                   "XOX",
                                   "XXX",
                                   'X', DQMiscs.itemNijiirononunokire, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemBuruoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRoresiagurobu , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "XAX",
                                   'X', DQMiscs.itemNijiirononunokire, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemBuruoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRoresiabutu , 1), new Object[]
                               {
                                   "AAA",
                                   "XOX",
                                   "XAX",
                                   'X', DQMiscs.itemNijiirononunokire, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemBuruoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemYuusyanokanmuri , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "AAA",
                                   'X', DQMiscs.itemHaganenoobane, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemIerooubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemYuusyanofuku , 1), new Object[]
                               {
                                   "XAX",
                                   "XOX",
                                   "XXX",
                                   'X', DQMiscs.itemHaganenoobane, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemIerooubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemYusyanogurobu , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "X X",
                                   'X', DQMiscs.itemHaganenoobane, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemIerooubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemYuusyanobutu , 1), new Object[]
                               {
                                   "AAA",
                                   "XOX",
                                   "XAX",
                                   'X', DQMiscs.itemHaganenoobane, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemIerooubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemTenkuunokabuto , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "AAA",
                                   'X', DQMiscs.itemTensinohane, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemGurinoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemTenkuunofuku , 1), new Object[]
                               {
                                   "XAX",
                                   "XOX",
                                   "XXX",
                                   'X', DQMiscs.itemTensinohane, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemGurinoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemTenkuunogurobu , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "XAX",
                                   'X', DQMiscs.itemTensinohane, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemGurinoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemTenkuunobutu , 1), new Object[]
                               {
                                   "AAA",
                                   "XOX",
                                   "XAX",
                                   'X', DQMiscs.itemTensinohane, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemGurinoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemGurantaban , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "AAA",
                                   'X', DQMiscs.itemUraminohouju, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemPaapuruoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemGuranbaniarobu , 1), new Object[]
                               {
                                   "XAX",
                                   "XOX",
                                   "XXX",
                                   'X', DQMiscs.itemUraminohouju, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemPaapuruoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemGuranbaniarisuto , 1), new Object[]
                               {
                                   "XXX",
                                   "XOX",
                                   "XAX",
                                   'X', DQMiscs.itemUraminohouju, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemPaapuruoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemGuranbanianokutu , 1), new Object[]
                               {
                                   "AAA",
                                   "XOX",
                                   "XAX",
                                   'X', DQMiscs.itemUraminohouju, 'A', DQMiscs.itemAmatuyunoito, 'O', DQMiscs.itemPaapuruoubu
                               });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemIbaranomuti , 1), new Object[]
                               {
                                   "XXX",
                                   "YYY",
                                   "ZZZ",
                                   'X', DQMiscs.itemTogetogenokiba, 'Y', DQMiscs.itemMajuunotuno, 'Z', DQMiscs.itemMajuunokawa
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemGuringamunomuti , 1), new Object[]
                               {
                                   "XYX",
                                   "XZX",
                                   "VVV",
                                   'V', DQMiscs.itemToukonekisu, 'X', DQMiscs.itemAmatuyunoito, 'Y', DQMiscs.itemGurinoubu, 'Z', DQWeapons.itemDoragonteiru
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemDoragonteiru , 1), new Object[]
                               {
                                   "VXV",
                                   "XZX",
                                   "YXY",
                                   'V', DQMiscs.itemDoragonnonamida, 'X', DQMiscs.itemKyodaihigetokage, 'Y', DQMiscs.itemHaganenoobane, 'Z', DQWeapons.itemIbaranomuti
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKoorinotume , 1), new Object[]
                               {
                                   "VZV",
                                   "VXV",
                                   "ZYZ",
                                   'V', DQIngots.itemMisriru, 'X', DQWeapons.itemAkumanotume, 'Y', DQMiscs.itemDoragonnonamida, 'Z', DQMiscs.itemHyoutyounohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHonoonotume , 1), new Object[]
                               {
                                   "VYV",
                                   "XZX",
                                   "VYV",
                                   'V', DQIngots.itemPuratina, 'X', DQSeeds.itemHonoonomi, 'Y', DQMiscs.itemRyuunohizake, 'Z', DQWeapons.itemMajuunotume
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemDaitikudaki , 1), new Object[]
                               {
                                   "VXV",
                                   "XYX",
                                   "VXV",
                                   'V', DQIngots.itemBakudanisi, 'X', DQMiscs.itemUraminohouju, 'Y', DQWeapons.itemOninokanabou
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemReiniroddo , 1), new Object[]
                               {
                                   "VVV",
                                   "XZX",
                                   "YYY",
                                   'V', DQIngots.itemMisriru, 'X', DQIngots.itemKoorinokessyou, 'Y', DQIngots.itemPuratina, 'Z', DQWeapons.itemHaganenokon
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemFubukinoono , 1), new Object[]
                               {
                                   "VYV",
                                   "XZX",
                                   "YXY",
                                   'V', DQIngots.itemMisriru, 'X', DQIngots.itemOriharukon, 'Y', DQMiscs.itemHyoutyounohane, 'Z', DQWeapons.itemHaounoono
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKoorinobumeran , 1), new Object[]
                               {
                                   "YVY",
                                   "VXV",
                                   "YVY",
                                   'V', DQIngots.itemPuratina, 'X', DQWeapons.itemKazenobumeran, 'Y', DQMiscs.itemHyoutyounohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMayokenoseiin , 1), new Object[]
                               {
                                   "VXV",
                                   "YAY",
                                   "BXB",
                                   'V', DQIngots.itemYougansekinokakera, 'X', DQMiscs.itemSeinarusizuku, 'Y', DQIngots.itemTaiyounoisi, 'A', DQAccessories.itemGoldring, 'B', DQIngots.itemTokinosuisyou
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemNijiirononunokire , 1), new Object[]
                               {
                                   "ABC",
                                   "DEF",
                                   "GHI",
                                   'A', DQMiscs.itemYogoretahoutai, 'B', DQMiscs.itemHebinonukegara, 'C', DQMiscs.itemHaganenoobane,
                                   'D', DQMiscs.itemAyakasisou, 'E', DQMiscs.itemYorunotobari, 'F', DQMiscs.itemMidorinokoke,
                                   'G', DQMiscs.itemJuryokunomoto, 'H', DQMiscs.itemSuraimuosyarebana, 'I', DQMiscs.itemAkaisango
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenjanobousi , 1), new Object[]
                               {
                                   "VXV",
                                   "VYV",
                                   "ZZZ",
                                   'V', DQMiscs.itemHaganenoobane, 'X', DQMiscs.itemSaezurinomitu, 'Y', DQMiscs.itemUraminohouju, 'Z', DQMiscs.itemAmatuyunoito
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenjanoroubu , 1), new Object[]
                               {
                                   "VYV",
                                   "XWX",
                                   "ZZZ",
                                   'W', DQMiscs.itemGurinoubu, 'V', DQMiscs.itemHaganenoobane, 'X', DQMiscs.itemHyoutyounohane, 'Y', DQMiscs.itemNijiirononunokire, 'Z', DQMiscs.itemAmatuyunoito
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenjanotebukuro , 1), new Object[]
                               {
                                   "XYX",
                                   "XZX",
                                   "XZX",
                                   'X', DQMiscs.itemNijiirononunokire, 'Y', DQMiscs.itemGenmaseki, 'Z', DQMiscs.itemAmatuyunoito
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKenjanokutu , 1), new Object[]
                               {
                                   "VXV",
                                   "YXY",
                                   "YXY",
                                   'V', DQMiscs.itemHaganenoobane, 'X', DQMiscs.itemNijiirononunokire, 'Y', DQMiscs.itemTensinohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMahounobousi , 1), new Object[]
                               {
                                   "VZV",
                                   "VYV",
                                   "XXX",
                                   'V', DQMiscs.itemTukinomegumi, 'X', DQMiscs.itemRengokunohane, 'Y', DQMiscs.itemTensinosoma, 'Z', DQMiscs.itemRyuunonamida
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMahounohoui , 1), new Object[]
                               {
                                   "XVX",
                                   "YZY",
                                   "XVX",
                                   'V', DQMiscs.itemTukinomegumi, 'X', DQMiscs.itemRengokunohane, 'Y', DQMiscs.itemUraminohouju, 'Z', DQMiscs.itemRedoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMahounotebukuro , 1), new Object[]
                               {
                                   "VXV",
                                   "YZY",
                                   "YXY",
                                   'V', DQMiscs.itemAkaisango, 'X', DQMiscs.itemJuryokunomoto, 'Y', DQMiscs.itemUsaginosippo, 'Z', DQMiscs.itemMaryokunotuti
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMahounokutu , 1), new Object[]
                               {
                                   "YXY",
                                   "YZY",
                                   "VXV",
                                   'V', DQMiscs.itemAkaisango, 'X', DQMiscs.itemJuryokunomoto, 'Y', DQMiscs.itemSuraimuosyarebana, 'Z', DQMiscs.itemMaryokunotuti
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSakuretto , 1), new Object[]
                               {
                                   "X X",
                                   "XYX",
                                   "ZZZ",
                                   'X', DQMiscs.itemKoumorinohane, 'Y', DQMiscs.itemBekkou, 'Z', DQMiscs.itemHebinonukegara
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKinunoroubu , 1), new Object[]
                               {
                                   "XYX",
                                   "ZZZ",
                                   "XYX",
                                   'X', DQMiscs.itemYawarakauru, 'Y', DQMiscs.itemSiroikaigara, 'Z', DQMiscs.itemKazekirinohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKinunotebukuro , 1), new Object[]
                               {
                                   "XYX",
                                   "XYX",
                                   "X X",
                                   'X', DQMiscs.itemYawarakauru, 'Y', DQMiscs.itemYogoretahoutai
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSandaru , 1), new Object[]
                               {
                                   "XXX",
                                   "Y Y",
                                   "Y Y",
                                   'X', DQMiscs.itemMadarakumonoito, 'Y', DQMiscs.itemMajuunokawa
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaru , 1), new Object[]
                               {
                                   "XXX",
                                   "XXX",
                                   "XXX",
                                   'X', DQMiscs.itemRisaikurusuton
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBumeran , 1), new Object[]
                               {
                                   "XXX",
                                   "X  ",
                                   "X  ",
                                   'X', DQIngots.itemTekkouseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemYaibanobumeran , 1), new Object[]
                               {
                                   "XYZ",
                                   "Y  ",
                                   "Z  ",
                                   'X', DQWeapons.itemBumeran, 'Y', DQMiscs.itemTogetogenokiba, 'Z', DQMiscs.itemMajuunotuno
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKazenobumeran , 1), new Object[]
                               {
                                   "VYV",
                                   "ZXZ",
                                   "YVY",
                                   'V', DQMiscs.itemHaganenoobane, 'X', DQWeapons.itemYaibanobumeran, 'Y', DQMiscs.itemHyoutyounohane, 'Z', DQMiscs.itemKazekirinohane
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHonoonobumeran , 1), new Object[]
                               {
                                   "ZYZ",
                                   "YXY",
                                   "ZYZ",
                                   'X', DQWeapons.itemKazenobumeran, 'Y', DQIngots.itemTaiyounoisi, 'Z', DQSeeds.itemHonoonomi3
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMamorinoudewa , 1), new Object[]
                               {
                                   "XYX",
                                   "YZY",
                                   "XYX",
                                   'X', DQAccessories.itemMamorinorubi, 'Y', DQMiscs.itemMetaru, 'Z', DQAccessories.itemGinnoyubiwa
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemSuparing , 1), new Object[]
                               {
                                   "STU",
                                   "YZA",
                                   "VWX",
                                   'A', DQAccessories.itemGouketunoudewa, 'S', DQMiscs.itemRedoubu, 'T', DQMiscs.itemBuruoubu, 'U', DQMiscs.itemIerooubu, 'V', DQMiscs.itemGurinoubu,
                                   'W', DQMiscs.itemPaapuruoubu, 'X', DQMiscs.itemMetaloubu, 'Y', DQAccessories.itemMamorinoudewa, 'Z', DQAccessories.itemHosifuru
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemGinnoyubiwa , 1), new Object[]
                               {
                                   " Y ",
                                   "YZY",
                                   " Y ",
                                   'Y', DQIngots.itemMigakizuna, 'Z', DQAccessories.itemGoldring
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemInotinoyubiwa , 1), new Object[]
                               {
                                   " Y ",
                                   "YZY",
                                   " Y ",
                                   'Y', DQIngots.itemInotinoisi, 'Z', DQAccessories.itemGinnoyubiwa
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemAyasiikobin , 1), new Object[]
                               {
                                   " Z ",
                                   "ZYZ",
                                   " Z ",
                                   'Y', DQMiscs.itemSeisui, 'Z', DQMiscs.itemAyakasisou
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemSeisui , 1), new Object[]
                               {
                                   " Y ",
                                   "YZY",
                                   " Y ",
                                   'Y', DQSeeds.itemYakusou, 'Z', DQMiscs.itemKiyomenomizu
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemYuuwakunoyumi , 1), new Object[]
                               {
                                   "XYY",
                                   "Y Z",
                                   "YZZ",
                                   'X', DQMiscs.itemAyakasisou, 'Y', DQMiscs.itemAyasiikobin, 'Z', DQMiscs.itemAmatuyunoito
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHaganenoono , 1), new Object[]
                               {
                                   "XYY",
                                   " ZY",
                                   " Z ",
                                   'X', DQMiscs.itemTukemonoisi, 'Y', DQIngots.itemTekkouseki, 'Z', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHaganenokon , 1), new Object[]
                               {
                                   " YY",
                                   " ZY",
                                   "Z  ",
                                   'Y', DQIngots.itemTekkouseki, 'Z', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKonbou , 1), new Object[]
                               {
                                   "  Y",
                                   " Z ",
                                   "Z  ",
                                   'Y', DQIngots.itemTekkouseki, 'Z', Items.stick
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemDokubari , 1), new Object[]
                               {
                                   " YY",
                                   "ZXY",
                                   "XZ ",
                                   'X', DQMiscs.itemTetunokugi, 'Y', DQMiscs.itemDokudokuhedoro, 'Z', DQMiscs.itemDokuganokona
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemOriharukonbou , 1), new Object[]
                               {
                                   " YY",
                                   " YY",
                                   "Z  ",
                                   'Y', DQIngots.itemOriharukon, 'Z', DQIngots.itemTekkouseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemWohanma , 1), new Object[]
                               {
                                   " ZZ",
                                   " ZZ",
                                   "Z  ",
                                   'Z', DQIngots.itemTekkouseki
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSinpinoyoroi , 1), new Object[]
                               {
                                   "VWV",
                                   "AXA",
                                   "YZY",
                                   'V', DQMiscs.itemDoragonnonamida, 'W', DQMiscs.itemTensinosoma, 'A', DQSeeds.itemIyasinomi3, 'X', DQAccessories.itemInotinoyubiwa, 'Y', DQMiscs.itemHyoutyounohane, 'Z', DQMiscs.itemSeinarusizuku
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemTensinosoma , 1), new Object[]
                               {
                                   " Y ",
                                   "YZY",
                                   " Y ",
                                   'Y', DQMiscs.itemTensinohane, 'Z', DQMiscs.itemHananomitu
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemHyoutyounohane , 1), new Object[]
                               {
                                   " Z ",
                                   "ZYZ",
                                   " Z ",
                                   'Y', DQMiscs.itemHaganenoobane, 'Z', DQIngots.itemKoorinokessyou
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHaounoono , 1), new Object[]
                               {
                                   "YZY",
                                   "ZXZ",
                                   "YZY",
                                   'X', DQWeapons.itemHaganenoono, 'Y', DQMiscs.itemBekkou, 'Z', DQMiscs.itemYorunotobari
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemUrokonoyoroi , 1), new Object[]
                               {
                                   "YZY",
                                   "XXX",
                                   "XXX",
                                   'X', DQMiscs.itemMajuunokawa, 'Y', DQMiscs.itemDokudokuhedoro, 'Z', DQMiscs.itemDokuganokona
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMajinnokanaduti , 1), new Object[]
                               {
                                   " ZZ",
                                   "XZZ",
                                   "YX ",
                                   'X', DQMiscs.itemToukonekisu, 'Y', DQIngots.itemMisriru, 'Z', DQMiscs.itemUraminohouju
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemUraminohouju , 1), new Object[]
                               {
                                   " X ",
                                   "XZX",
                                   "YXY",
                                   'X', DQMiscs.itemJuryokunomoto, 'Y', DQMiscs.itemMaryokunotuti, 'Z', DQMiscs.itemRyuunonamida
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemSeinarusizuku , 1), new Object[]
                               {
                                   " X ",
                                   "XYX",
                                   "ZZZ",
                                   'X', DQMiscs.itemSeisui, 'Y', DQMiscs.itemDoragonnonamida, 'Z', DQMiscs.itemGamanoabura
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemRyuunohizake , 1), new Object[]
                               {
                                   " X ",
                                   "YZY",
                                   " Y ",
                                   'X', DQSeeds.itemTikaranotane3, 'Y', DQMiscs.itemKiyomenomizu, 'Z', DQSeeds.itemHonoonomi3
                               });

        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemToukonekisu , 1), new Object[]
                               {
                                   "YXY",
                                   "YZY",
                                   "YXY",
                                   'X', DQMiscs.itemSaezurinomitu, 'Y', DQBlocks.DqmBlockGenkotu, 'Z', DQMiscs.itemBudouekisu
                               });

        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemSaezurinomitu , 1), new Object[]
                               {
                                   "ZYZ",
                                   "YXY",
                                   "ZYZ",
                                   'X', DQMiscs.itemHananomitu, 'Y', DQMiscs.itemUmanofun, 'Z', DQMiscs.itemUsinofun
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemBuruoubu, 1), new Object[]
                               {
                                   "VVV",
                                   "VWV",
                                   "VVV",
                                   'V', DQMiscs.itemAmatuyunoito, 'W', DQMiscs.itemMetaloubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemIerooubu, 1), new Object[]
                               {
                                   "VVV",
                                   "VWV",
                                   "VVV",
                                   'V', DQIngots.itemMoon, 'W', DQMiscs.itemMetaloubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemGurinoubu, 1), new Object[]
                               {
                                   "VVV",
                                   "VWV",
                                   "VVV",
                                   'V', DQMiscs.itemIkazutinotama, 'W', DQMiscs.itemMetaloubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemPaapuruoubu, 1), new Object[]
                               {
                                   "VVV",
                                   "VWV",
                                   "VVV",
                                   'V', DQIngots.itemInotinoisi, 'W', DQMiscs.itemMetaloubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemRamia , 1), new Object[]
                               {
                                   "STU",
                                   "ZYZ",
                                   "VWX",
                                   'S', DQMiscs.itemRedoubu, 'T', DQMiscs.itemBuruoubu, 'U', DQMiscs.itemIerooubu, 'V', DQMiscs.itemGurinoubu,
                                   'W', DQMiscs.itemPaapuruoubu, 'X', DQMiscs.itemMetaloubu, 'Y', DQIngots.itemHikarinoisi, 'Z', DQMiscs.itemMysteryEgg,
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMajuunotume , 1), new Object[]
                               {
                                   " VV",
                                   "WWV",
                                   "WW ",
                                   'V', DQMiscs.itemMajuunotuno, 'W', DQMiscs.itemMajuunokawa
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemAkumanotume , 1), new Object[]
                               {
                                   " VV",
                                   "WWV",
                                   "WW ",
                                   'V', DQMiscs.itemKyodainakiba, 'W', DQMiscs.itemYawarakauru
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemOokanaduti , 1), new Object[]
                               {
                                   " VV",
                                   "WVV",
                                   "XW ",
                                   'V', DQMiscs.itemMetaru, 'W', DQIngots.itemBakudanisi, 'X', DQMiscs.itemKyodainakiba
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemOninokanabou , 1), new Object[]
                               {
                                   "WWW",
                                   "WVW",
                                   "WWW",
                                   'V', DQWeapons.itemOokanaduti, 'W', DQMiscs.itemTogetogenokiba
                               });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSeinarunaifu , 1), new Object[]
                               {
                                   " VW",
                                   "VWV",
                                   "XV ",
                                   'V', DQMiscs.itemSeijanohai, 'W', DQIngots.itemTekkouseki, 'X', DQIngots.itemInotinoisi
                               });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemYaibanobumeran , 1), new Object[]
                               {
                                   "WVV",
                                   "V  ",
                                   "V  ",
                                   'V', DQMiscs.itemTogetogenokiba, 'W', DQIngots.itemMisriru
                               });
        /*
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemRakkipendanto , 1), new Object[]
                               {
                                   "WXZ",
                                   "XYX",
                                   "VXW",
                                   'V', DQMiscs.itemLittlemedal10, 'W', DQIngots.itemHikarinoisi, 'X', DQMiscs.itemAmatuyunoito, 'Y', DQMiscs.itemSeireiseki, 'Z', DQMiscs.itemBuruoubu,
                               });
                               */
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemMamorinorubi , 1), new Object[]
                               {
                                   "WXA",
                                   "ZVZ",
                                   "YXW",
                                   'A', DQMiscs.itemPaapuruoubu, 'V', DQIngots.itemRubinogenseki, 'W', DQMiscs.itemKinkai, 'X', DQSeeds.itemMamorinotane3, 'Y', DQIngots.itemHikarinoisi, 'Z', DQIngots.itemTaiyounoisi,
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemGouketunoudewa , 1), new Object[]
                               {
                                   "WYW",
                                   "AXZ",
                                   "WBW",
                                   'W', DQAccessories.itemTikaranorubi, 'X', DQAccessories.itemGoldburesuretto, 'Y', DQMiscs.itemIerooubu, 'Z', DQMiscs.itemGurinoubu, 'A', DQMiscs.itemBuruoubu, 'B', DQMiscs.itemPaapuruoubu
                               });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemTikaranorubi , 1), new Object[]
                               {
                                   "UZW",
                                   "XVZ",
                                   "YXU",
                                   'U', DQIngots.itemTaiyounoisi, 'V', DQIngots.itemRubinogenseki, 'W', DQMiscs.itemRedoubu, 'X', DQSeeds.itemTikaranotane3, 'Y', DQIngots.itemHikarinoisi, 'Z', DQMiscs.itemToukonekisu,
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemHonoonoyoroi , 1), new Object[]
                               {
                                   "WXW",
                                   "ZYZ",
                                   "WXW",
                                   'W', DQIngots.itemTaiyounoisi, 'X', DQIngots.itemYougansekinokakera, 'Y', DQMiscs.itemRedoubu, 'Z', DQMiscs.itemRengokunohane,
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMirayoroi , 1), new Object[]
                               {
                                   "WXW",
                                   "XYX",
                                   "WXW",
                                   'W', DQIngots.itemKagaminoisi, 'X', DQIngots.itemOriharukon, 'Y', DQMiscs.itemMetaloubu,
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemDoragonmeiru , 1), new Object[]
                               {
                                   "WXW",
                                   "YVY",
                                   "ZXZ",
                                   'V', DQMiscs.itemRyuunonamida, 'W', DQMiscs.itemTogetogenokiba, 'X', DQMiscs.itemMidorinokoke, 'Y', DQMiscs.itemMajuunokawa, 'Z', DQMiscs.itemHonehone,
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemYaibanoyoroi , 1), new Object[]
                               {
                                   "WXW",
                                   "YZY",
                                   "VYV",
                                   'V', DQMiscs.itemMajuunotuno, 'W', DQMiscs.itemKyodainakiba, 'X', DQMiscs.itemMajuunokawa, 'Y', DQMiscs.itemTogetogenokiba, 'Z', DQMiscs.itemIkazutinotama,
                               });
/*
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKisekinoturugi , 1), new Object[]
                               {
                                   "WXX",
                                   "XYX",
                                   "ZXW",
                                   'W', DQIngots.itemTaiyounoisi, 'X', DQIngots.itemInotinoisi, 'Y', DQMiscs.itemKenjanoisi, 'Z', DQMiscs.itemMetarukingnotuka
                               });
*/
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemPapasunoturuginew , 1), new Object[]
                               {
                                   "XZX",
                                   "ZYZ",
                                   "WZX",
                                   'W', DQWeapons.itemPapasunoturugi, 'X', DQIngots.itemMigakizuna, 'Y', DQIngots.itemHikarinoisi, 'Z', DQIngots.itemKagaminoisi,
                               });
/*
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemOujanoturugi , 1), new Object[]
                               {
                                   "VWZ",
                                   "WXW",
                                   "YWV",
                                   'V', DQMiscs.itemIerooubu, 'W', DQIngots.itemOriharukon, 'X', DQIngots.itemTaiyounoisi2, 'Y', DQMiscs.itemSeireiseki, 'Z', DQMiscs.itemMetarukingnoha,
                               });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHayabusanoturugi , 1), new Object[]
                               {
                                   "WXW",
                                   "YZX",
                                   "WYW",
                                   'W', DQMiscs.itemLittlemedal5, 'X', DQAccessories.itemHayatenoring, 'Y', DQMiscs.itemKinkai, 'Z', DQWeapons.itemHaganenoturugi,
                               });
*/
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSefiramunoyumi , 1), new Object[]
                               {
                                   "WWX",
                                   "WYZ",
                                   "XZZ",
                                   'W', DQIngots.itemOriharukon, 'X', DQMiscs.itemRedoubu, 'Y', DQWeapons.itemOdinbou, 'Z', DQMiscs.itemAmatuyunoito,
                               });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemKenjanoisi , 1), new Object[]
                               {
                                   " WW",
                                   " WW",
                                   "X  ",
                                   'W', DQIngots.itemInotinoisi, 'X', DQMiscs.itemKinkai,
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKawanobousi , 1), new Object[]
                               {
                                   "WWW",
                                   "W W",
                                   //"W W",
                                   'W', DQMiscs.itemMajuunokawa,
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKawanoyoroi , 1), new Object[]
                               {
                                   "W W",
                                   "WWW",
                                   "WWW",
                                   'W', DQMiscs.itemMajuunokawa,
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKawanokote , 1), new Object[]
                               {
                                   "WWW",
                                   "W W",
                                   "W W",
                                   'W', DQMiscs.itemMajuunokawa,
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemKawanokutu , 1), new Object[]
                               {
                                   "W W",
                                   "W W",
                                   "   ",
                                   'W', DQMiscs.itemMajuunokawa,
                               });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSuraimunofuku , 1), new Object[]
                               {
                                   "WWW",
                                   "WXW",
                                   "WWW",
                                   'W', DQMiscs.itemSuraimuzeri, 'X', DQMiscs.itemMajuunokawa,
                               });
        //Swoed
        /*
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemRotonoturugi , 1), new Object[]
                               {
                                   " WX",
                                   "WYW",
                                   "ZW ",
                                   'W', DQIngots.itemHikarinoisi, 'X', Rotonoha, 'Y', DQMiscs.itemKenjanoseisui, 'Z', Rotonotuka,
                               });
                               */
/*
        GameRegistry.addRecipe(new ItemStack(Rotonotuka , 1),
                               new Object[] { "X  ", "ZY ", "XZX",
                                              'X', DQMiscs.itemKinkai,
                                              'Y', DQMiscs.itemRedoubu,
                                              'Z', DQIngots.itemTokinosuisyou,
                                            });
        GameRegistry.addRecipe(new ItemStack(Rotonoha , 1),
                               new Object[] { " YX", "YXY", "XY ",
                                              'X', DQIngots.itemMisriru,
                                              'Y', DQIngots.itemOriharukon,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetarukingnotuka , 1),
                               new Object[] { "X  ", "ZY ", "XZX",
                                              'X', DQMiscs.itemMetaru,
                                              'Y', DQMiscs.itemMetaloubu,
                                              'Z', DQMiscs.itemLittlemedal5,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetarukingnoha , 1),
                               new Object[] { " YX", "YXY", "XY ",
                                              'X', DQMiscs.itemMetaru,
                                              'Y', DQIngots.itemMisriru,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetarukingnoturugi , 1),
                               new Object[] { " WX", "WYW", "ZW ",
                                              'W', DQMiscs.itemLittlemedal5,
                                              'X', DQMiscs.itemMetarukingnoha,
                                              'Y', DQMiscs.itemKenjanoseisui,
                                              'Z', DQMiscs.itemMetarukingnotuka,
                                            });
*/
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemGinganoturugi , 1),
                               new Object[] { "YYX", "YWY", "ZYY",
                                              'X', DQWeapons.itemMetarukingnoturugi,
                                              'Y', DQIngots.itemHikarinoisi,
                                              'Z', DQWeapons.itemRotonoturugi,
                                              'W', DQMiscs.itemSinkanohiseki,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKoorinoyaiba , 1),
                               new Object[] { "XZX", "ZXZ", "YZX",
                                              'X', DQIngots.itemKoorinokessyou,
                                              'Y', DQIngots.itemTokinosuisyou,
                                              'Z', DQMiscs.itemMajuunotuno,
                                            });
/*
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemInferunoswordnoha , 1),
                               new Object[] { " XY", "XYX", "YX ",
                                              'X', DQIngots.itemYougansekinokakera,
                                              'Y', DQIngots.itemOriharukon,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemInferunoswordnotuka , 1),
                               new Object[] { "XX ", "XYX", "WXX",
                                              'W', DQMiscs.itemKinkai,
                                              'X', DQIngots.itemYougansekinokakera,
                                              'Y', DQIngots.itemOriharukon,
                                              'Y', DQMiscs.itemSeireiseki,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemInferunosword , 1),
                               new Object[] { " WX", "WZW", "YW ",
                                              'W', DQIngots.itemYougansekinokakera,
                                              'X', DQWeapons.itemInferunoswordnoha,
                                              'Y', DQWeapons.itemInferunoswordnotuka,
                                              'Z', DQMiscs.itemKenjanoseisui,
                                            });
*/
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHaganenoturugi , 1),
                               new Object[] { "  X", "YX ", "ZY ",
                                              'X', DQIngots.itemTekkouseki,
                                              'Y', Items.iron_ingot,
                                              'Z', DQMiscs.itemKinkai,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHeisinoken , 1),
                               new Object[] { "  X", " X ", "Y  ",
                                              'X', DQIngots.itemTekkouseki,
                                              'Y', Items.stick,
                                            });
        //item
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemRedoubu , 1),
                               new Object[] { "XXX", "XYX", "XXX",
                                              'X', DQIngots.itemTaiyounoisi,
                                              'Y', DQMiscs.itemMetaloubu,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemKinkai , 1),
                               new Object[] { " X ", "XXX",
                                              'X', Items.gold_ingot,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemKenjanoseisui , 1),
                               new Object[] { "XXX", "YZY", "YYY",
                                              'X', DQMiscs.itemSuraimuzeri,
                                              'Y', Blocks.glass,
                                              'Z', Items.water_bucket,
                                            });
        /*
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemSabitatate , 1),
                               new Object[] { "XXX", "XXX", "XXX",
                                              'X', DQMiscs.itemLittlemedal5
                                            });
                                            */
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemAmatuyunoito , 1),
                               new Object[] { "ZXZ", "XYX", "ZXZ",
                                              'X', DQMiscs.itemMadarakumonoito,
                                              'Y', DQIngots.itemTokinosuisyou,
                                              'Z', DQMiscs.itemSuraimuzeri,
                                            });
        //bow
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKazekirinoyumi , 1),
                               new Object[] { "ZXX", "XWY", "XYY",
                                              'X', DQMiscs.itemKazekirinohane,
                                              'Y', DQMiscs.itemAmatuyunoito,
                                              'Z', DQMiscs.itemSeireiseki,
                                              'W', Items.bow,
                                            });
        GameRegistry.addRecipe(new ItemStack(Items.arrow , 16),
                               new Object[] { "  Z", " Y ", "X  ",
                                              'X', DQMiscs.itemKazekirinohane,
                                              'Y', Items.stick,
                                              'Z', Items.flint,
                                            });
        GameRegistry.addRecipe(new ItemStack(Items.arrow , 16),
                               new Object[] { "  Z", " Y ", "X  ",
                                              'X', DQMiscs.itemRengokunohane,
                                              'Y', Items.stick,
                                              'Z', Items.flint,
                                            });
        GameRegistry.addRecipe(new ItemStack(Items.arrow , 32),
                               new Object[] { "  Z", " Y ", "X  ",
                                              'X', DQMiscs.itemHaganenoobane,
                                              'Y', Items.stick,
                                              'Z', Items.flint,
                                            });
        GameRegistry.addRecipe(new ItemStack(Items.arrow , 32),
                               new Object[] { "  Z", " Y ", "X  ",
                                              'X', DQMiscs.itemMeijikimeranohane,
                                              'Y', Items.stick,
                                              'Z', Items.flint,
                                            });
        //akuse
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemGoldburesuretto , 1),
                               new Object[] { "XXX", "X X", "XXX",
                                              'X', DQMiscs.itemKinkai,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemGoldring , 1),
                               new Object[] { " X ", "X X", " X ",
                                              'X', DQMiscs.itemKinkai,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHosifuru , 1),
                               new Object[] { "ZWZ", "YXY", "VWV",
                                              'V', DQSeeds.itemSubayasanotane3,
                                              'W', DQMiscs.itemSeireiseki,
                                              'X', DQAccessories.itemGoldburesuretto,
                                              'Y', DQMiscs.itemKazekirinohane,
                                              'Z', DQIngots.itemHosinokakera,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemSeireiseki , 1),
                               new Object[] { " X ", "YZY", " X ",
                                              'X', DQIngots.itemKoorinokessyou,
                                              'Y', DQIngots.itemYougansekinokakera,
                                              'Z', DQIngots.itemPuratina,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemHayatenoring , 1),
                               new Object[] { "ZWZ", "YXY", "VWV",
                                              'V', DQSeeds.itemSubayasanotane2,
                                              'W', DQIngots.itemTokinosuisyou,
                                              'X', DQAccessories.itemGoldring,
                                              'Y', DQMiscs.itemMetaru,
                                              'Z', DQMiscs.itemKazekirinohane,
                                            });
        //Armor item
        GameRegistry.addRecipe(new ItemStack(DQIngots.itemMigakizuna , 1),
                               new Object[] { "XXX", "XYX", "XXX",
                                              'X', Blocks.sand,
                                              'Y', DQMiscs.itemSeijanohai,
                                            });
        /*GameRegistry.addRecipe(new ItemStack(DQIngots.itemHikarinoisi ,1),
        		new Object[]{ " X ","XYX"," X ",
        	'X',DQIngots.itemTokinosuisyou,
        	'Y',DQMiscs.itemSinkanohiseki,
        });*/
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemSinkanohiseki , 1),
                               new Object[] { "YYY", "YXY", "YYY",
                                              'X', DQMiscs.itemMetaloubu,
                                              'Y', DQIngots.itemYougansekinokakera,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQIngots.itemTekkouseki , 1),
                               new Object[] { "YYY", "XXX", "YYY",
                                              'X', Items.iron_ingot,
                                              'Y', DQIngots.itemYougansekinokakera,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1),
                               new Object[] { "XXX", "XYX", "XXX",
                                              'X', DQMiscs.itemMetaru,
                                              'Y', DQMiscs.itemSeireiseki,
                                            });
        //Armor
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemRotonoturugi , 1),
                               new Object[] { "ZYZ", "ZXZ", "ZYZ",
                                              'X', DQWeapons.itemSabitarotonoturugi,
                                              'Y', DQIngots.itemHikarinoisi,
                                              'Z', DQIngots.itemMigakizuna,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRotonokabuto , 1),
                               new Object[] { "ZYZ", "ZXZ", "ZYZ",
                                              'X', DQArmors.itemSabitakabuto,
                                              'Y', DQIngots.itemHikarinoisi,
                                              'Z', DQIngots.itemMigakizuna,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRotonoyoroi , 1),
                               new Object[] { "ZYZ", "ZXZ", "ZYZ",
                                              'X', DQArmors.itemSabitayoroi,
                                              'Y', DQIngots.itemHikarinoisi,
                                              'Z', DQIngots.itemMigakizuna,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRotonokote , 1),
                               new Object[] { "ZYZ", "ZXZ", "ZYZ",
                                              'X', DQArmors.itemSabitakote,
                                              'Y', DQIngots.itemHikarinoisi,
                                              'Z', DQIngots.itemMigakizuna,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemRotonokutu , 1),
                               new Object[] { "ZYZ", "ZXZ", "ZYZ",
                                              'X', DQArmors.itemSabitakutu,
                                              'Y', DQIngots.itemHikarinoisi,
                                              'Z', DQIngots.itemMigakizuna,
                                            });
/*
        GameRegistry.addRecipe(new ItemStack(Rotonotate , 1),
                               new Object[] { "ZYZ", "ZXZ", "ZYZ",
                                              'X', Sabitatate,
                                              'Y', DQIngots.itemHikarinoisi,
                                              'Z', DQIngots.itemMigakizuna,
                                            });
*/
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemHaganenokabuto , 1),
                               new Object[] { "YZY", "XXX", "XWX",
                                              'W', DQMiscs.itemKinkai,
                                              'X', DQIngots.itemTekkouseki,
                                              'Y', Items.redstone,
                                              'Z', DQMiscs.itemKazekirinohane,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemHaganenoyoroi , 1),
                               new Object[] { "XYX", "XXX", "XYX",
                                              'X', DQIngots.itemTekkouseki,
                                              'Y', DQMiscs.itemKinkai,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemHaganenokote , 1),
                               new Object[] { "XYX", "XYX", "XYX",
                                              'X', DQIngots.itemTekkouseki,
                                              'Y', DQMiscs.itemKinkai,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemHaganenokutu , 1),
                               new Object[] { "XYX", "X X", "Y Y",
                                              'X', DQIngots.itemTekkouseki,
                                              'Y', DQMiscs.itemKinkai,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMetarukingnokabuto , 1),
                               new Object[] { "XZX", "XYX", "XYX",
                                              'X', DQMiscs.itemMetaloubu,
                                              'Y', DQIngots.itemOriharukon,
                                              'Z', DQMiscs.itemSuraimunokanmuri,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMetarukingnoyoroi , 1),
                               new Object[] { "XYX", "XZX", "XYX",
                                              'X', DQMiscs.itemMetaloubu,
                                              'Y', DQIngots.itemOriharukon,
                                              'Z', DQMiscs.itemSuraimunokanmuri,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMetarukingnokote , 1),
                               new Object[] { "XZX", "YXY", "YXY",
                                              'X', DQMiscs.itemMetaloubu,
                                              'Y', DQIngots.itemOriharukon,
                                              'Z', DQMiscs.itemSuraimunokanmuri,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMetarukingnokutu , 1),
                               new Object[] { "XYX", "XZX", "Y Y",
                                              'X', DQMiscs.itemMetaloubu,
                                              'Y', DQIngots.itemOriharukon,
                                              'Z', DQMiscs.itemSuraimunokanmuri,
                                            });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockTueK , 1), new Object[]
                {
                    "AAA",
                    "  A",
                    " A ",
                    'A', Items.stick
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockSikabaneK , 1), new Object[]
                {
                    "AAA",
                    "AAA",
                    "AAA",
                    'A', DQMiscs.itemHonehone
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiihasiranaka , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.cobblestone, 'B', DQDecorates.DqmBlockHasiranaka
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiihasiraue , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.cobblestone, 'B', DQDecorates.DqmBlockHasiraue
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiihasirasita , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.cobblestone, 'B', DQDecorates.DqmBlockHasira
                });


        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiihasiranakaNB , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.nether_brick, 'B', DQDecorates.DqmBlockHasiranakaNB
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiihasiraueNB , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.nether_brick, 'B', DQDecorates.DqmBlockHasiraueNB
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiihasirasitaNB , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.nether_brick, 'B', DQDecorates.DqmBlockHasiraNB
                });




        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiihasiranakaQ , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.quartz_block, 'B', DQDecorates.DqmBlockHasiranakaQ
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiihasiraueQ , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.quartz_block, 'B', DQDecorates.DqmBlockHasiraueQ
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiihasirasitaQ , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.quartz_block, 'B', DQDecorates.DqmBlockHasiraQ
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiiisizukue , 1), new Object[]
                {
                    "AAA",
                    "AAA",
                    " A ",
                    'A', Blocks.stonebrick
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockEntotu , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.brick_block, 'B', DQIngots.itemYougansekinokakera
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockEntotuS , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.cobblestone, 'B', DQIngots.itemYougansekinokakera
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockEntotuG , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.gold_block, 'B', DQIngots.itemYougansekinokakera
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockEntotuN , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.nether_brick, 'B', DQIngots.itemYougansekinokakera
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockEntotuO , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.obsidian, 'B', DQIngots.itemYougansekinokakera
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHondana , 1), new Object[]
                {
                    "AAA",
                    "AAA",
                    "AAA",
                    'A', Blocks.bookshelf
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockMaki , 1), new Object[]
                {
                    "A  ",
                    "AA ",
                    "AAA",
                    'A', Items.stick
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockBukiya , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.planks, 'B', DQWeapons.itemHeisinoken
                });
        /*
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockDouguya , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.planks, 'B', Fukuro
                });

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockBouguya , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.planks, 'B', Haganenotate
                });
*/
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockYadoya , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.planks, 'B', DQDecorates.DqmBlockDqmbed
                });

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockTokusyutaimatu , 1), new Object[]
                {
                    " B ",
                    "BCB",
                    "BAB",
                    'A', Blocks.gold_block, 'B', Blocks.torch, 'C', DQIngots.itemHosinokakera
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockTiisaitukue , 1), new Object[]
                {
                    "AAA",
                    "AAA",
                    "BBB",
                    'A', Blocks.planks, 'B', Items.stick
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOokiitukue , 1), new Object[]
                {
                    "AAA",
                    "BBB",
                    "AAA",
                    'A', Blocks.planks, 'B', DQDecorates.DqmBlockTiisaitukue
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockOke , 1), new Object[]
                {
                    "BBB",
                    "A A",
                    "AAA",
                    'A', Blocks.planks, 'B', Items.stick
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockIdo , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.stonebrick, 'B', Items.water_bucket
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockIdooke , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "ACA",
                    'A', Blocks.stonebrick, 'B', DQDecorates.DqmBlockOke, 'C', DQDecorates.DqmBlockIdo
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockKinoisi , 1), new Object[]
                {
                    "BBB",
                    "AAA",
                    "B B",
                    'A', Blocks.planks, 'B', Items.stick
                });
/*
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockSZukkinya , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.blockGold, 'B', ZukkinyaOb
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockSBatorurex , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.blockGold, 'B', BatorurexOb
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockSBoureikensi , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.blockGold, 'B', BoureikensiOb
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockSGoremu , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.blockGold, 'B', GodraidaOb
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockSKirapan , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.blockGold, 'B', KirapanOb
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockSSura , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.blockGold, 'B', SuraimuOb
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockSSuraimunaito , 1), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', Blocks.blockGold, 'B', SuraimunaitoOb
                });

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHakoK , 1), new Object[]
                {
                    "A A",
                    " A ",
                    "A A",
                    'A', Blocks.planks
                });
*/
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockTuboK , 1), new Object[]
                {
                    " A ",
                    "AAA",
                    "AAA",
                    'A', Blocks.clay
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockTaruK , 1), new Object[]
                {
                    "AAA",
                    "BBB",
                    "AAA",
                    'A', Blocks.planks, 'B', Items.iron_ingot
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHasiranaka , 1), new Object[]
                {
                    " A ",
                    " A ",
                    " A ",
                    'A', Blocks.stone
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHasiraue , 1), new Object[]
                {
                    "AAA",
                    " A ",
                    " A ",
                    'A', Blocks.stone
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHasira , 1), new Object[]
                {
                    " A ",
                    " A ",
                    "AAA",
                    'A', Blocks.stone
                });


        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHasiranakaNB , 1), new Object[]
                {
                    " A ",
                    " A ",
                    " A ",
                    'A', Blocks.nether_brick
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHasiraueNB , 1), new Object[]
                {
                    "AAA",
                    " A ",
                    " A ",
                    'A', Blocks.nether_brick
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHasiraNB , 1), new Object[]
                {
                    " A ",
                    " A ",
                    "AAA",
                    'A', Blocks.nether_brick
                });



        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHasiranakaQ , 1), new Object[]
                {
                    " A ",
                    " A ",
                    " A ",
                    'A', Blocks.quartz_block
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHasiraueQ , 1), new Object[]
                {
                    "AAA",
                    " A ",
                    " A ",
                    'A', Blocks.quartz_block
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockHasiraQ , 1), new Object[]
                {
                    " A ",
                    " A ",
                    "AAA",
                    'A', Blocks.quartz_block
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockJuujika2 , 1), new Object[]
                {
                    " A ",
                    "AAA",
                    " A ",
                    'A', Blocks.stone
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockJuujika , 1), new Object[]
                {
                    " A ",
                    "AAA",
                    " A ",
                    'A', Items.gold_ingot
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockJuujika , 4), new Object[]
                {
                    " A ",
                    "AAA",
                    " A ",
                    'A', DQMiscs.itemKinkai
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockIsu , 1), new Object[]
                {
                    " B ",
                    "CCC",
                    "AAA",
                    'A', Items.stick, 'B', Items.iron_ingot, 'C', Blocks.planks
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockIsu , 1), new Object[]
                {
                    " B ",
                    "CCC",
                    "AAA",
                    'A', Items.stick, 'B', DQIngots.itemTekkouseki, 'C', Blocks.planks
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockTaimatu , 4), new Object[]
                {
                    "BBB",
                    "A A",
                    " A ",
                    'A', Items.iron_ingot, 'B', Blocks.torch
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockTaimatu , 4), new Object[]
                {
                    "BBB",
                    "A A",
                    " A ",
                    'A', DQIngots.itemTekkouseki, 'B', Blocks.torch
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockTaimatu2 , 2), new Object[]
                {
                    " B ",
                    " A ",
                    "AAA",
                    'A', Items.gold_ingot, 'B', Blocks.torch
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockTaimatu2 , 8), new Object[]
                {
                    " B ",
                    " A ",
                    "AAA",
                    'A', DQMiscs.itemKinkai, 'B', Blocks.torch
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiUe , 1), new Object[]
                {
                    "A  ",
                    "   ",
                    "   ",
                    'A', DQDecorates.DqmBlockYajirusiao
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiSita , 1), new Object[]
                {
                    "   ",
                    "A  ",
                    "   ",
                    'A', DQDecorates.DqmBlockYajirusiao
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiao2 , 1), new Object[]
                {
                    " A ",
                    "   ",
                    "   ",
                    'A', DQDecorates.DqmBlockYajirusiao
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiMaru , 1), new Object[]
                {
                    " A ",
                    "ABA",
                    " A ",
                    'A', Blocks.planks, 'B', DQMiscs.itemSuraimuzeri
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockYajirusiBatu , 1), new Object[]
                {
                    "A A",
                    " B ",
                    "A A",
                    'A', Blocks.planks, 'B', DQMiscs.itemSuraimuzeri
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockKen , 1), new Object[]
                {
                    " A ",
                    "ABA",
                    " A ",
                    'A', Items.stone_sword, 'B', DQMiscs.itemRisaikurusuton
                });
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockKen2 , 1), new Object[]
                {
                    " A ",
                    "ABA",
                    " A ",
                    'A', Items.golden_sword, 'B', DQMiscs.itemRisaikurusuton
                });
        /*
        GameRegistry.addRecipe(new ItemStack(Dqmbed2 , 1), new Object[]
                {
                    "BAB",
                    "   ",
                    "   ",
                    'A', Dqmbed, 'B', Taiyounoisi
                });
        GameRegistry.addRecipe(new ItemStack(Dqmbed , 1), new Object[]
               {
                   "AAA",
                   "BBB",
                   "AAA",
                   'A', Usaginosippo, 'B', Yawarakauru
               });
        */
        //GameRegistry.addSmelting(DQMiscs.itemLittlemedal5, new ItemStack(DQIngots.itemOriharukon , 1), 1);
        GameRegistry.addSmelting(Blocks.obsidian, new ItemStack(DQIngots.itemYougansekinokakera , 1), 1);
        GameRegistry.addSmelting(DQIngots.itemYougansekinokakera, new ItemStack(DQMiscs.itemSeijanohai , 1), 1);
        GameRegistry.addSmelting(DQMiscs.itemKazekirinohane, new ItemStack(DQMiscs.itemRengokunohane , 1), 1);
        GameRegistry.addSmelting(DQIngots.itemInotinoisi, new ItemStack(DQIngots.itemTaiyounoisi , 1), 1);
        GameRegistry.addSmelting(DQIngots.itemOriharukon, new ItemStack(DQIngots.itemInotinoisi , 1), 1);
        GameRegistry.addSmelting(DQWeapons.itemPapasunoturugi, new ItemStack(DQMiscs.itemPapasunokatami , 1), 1);
        //GameRegistry.addSmelting(DQOres.BlockOreTekkouseki, new ItemStack(DQIngots.itemTekkouseki , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreTaiyounoisi, new ItemStack(DQIngots.itemTaiyounoisi , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreTekkouseki, new ItemStack(DQIngots.itemTekkouseki , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreYougansekinokakera, new ItemStack(DQIngots.itemYougansekinokakera , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreKagaminoisi, new ItemStack(DQIngots.itemKagaminoisi , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreMisuriru, new ItemStack(DQIngots.itemMisriru , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOrePuratina, new ItemStack(DQIngots.itemPuratina , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreMetaru, new ItemStack(DQMiscs.itemMetaru , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreRubi, new ItemStack(DQIngots.itemRubinogenseki , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreMoon, new ItemStack(DQIngots.itemMoon , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreHikarinoisi, new ItemStack(DQIngots.itemHikarinoisi , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreTokinosuisyou, new ItemStack(DQIngots.itemTokinosuisyou , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreLittlemedal, new ItemStack(DQMiscs.itemLittlemedal , 2), 1);
        GameRegistry.addSmelting(DQOres.BlockOreKoorinokessyou, new ItemStack(DQIngots.itemKoorinokessyou , 1), 1);
        GameRegistry.addSmelting(DQOres.BlockOreInotinoisi, new ItemStack(DQIngots.itemInotinoisi , 1), 1);

        GameRegistry.addSmelting(DQOres.BlockOreBakudanisi, new ItemStack(DQIngots.itemBakudanisi , 2), 1);
        GameRegistry.addSmelting(DQOres.BlockOreHosinokakera, new ItemStack(DQIngots.itemHosinokakera , 3), 1);
        GameRegistry.addSmelting(DQOres.BlockOreMigakizuna, new ItemStack(DQIngots.itemMigakizuna , 4), 1);

        GameRegistry.addSmelting(Items.leather , new ItemStack(DQMiscs.itemMajuunokawa, 1), 0F) ;
        GameRegistry.addSmelting(new ItemStack(DQIngots.itemTaiyounoisi2, 1) , new ItemStack(DQIngots.itemTaiyounoisi, 2), 0F) ;
        GameRegistry.addSmelting(new ItemStack(DQIngots.itemMisriru2, 1) , new ItemStack(DQIngots.itemMisriru, 2), 0F) ;
        GameRegistry.addSmelting(new ItemStack(DQIngots.itemOriharukon2, 1) , new ItemStack(DQIngots.itemOriharukon, 2), 0F) ;
        GameRegistry.addSmelting(new ItemStack(DQIngots.itemPuratina2, 1) , new ItemStack(DQIngots.itemPuratina, 2), 0F) ;


        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemPisaronotamasii , 1), new Object[] {"XXX", "XYX", "XXX", 'Y', DQMiscs.itemSinkanohiseki, 'X', DQMiscs.itemTiisaitamasii});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemNiku4, 1), new Object[] {new ItemStack(DQMiscs.itemNiku3, 1), new ItemStack(DQIngots.itemTaiyounoisi, 1), new ItemStack(DQIngots.itemTaiyounoisi, 1)});
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemYawarakauru , 1), new Object[] {"   ", " XX", " XX", 'X', new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMadarakumonoito , 1), new Object[] {"XXX", "XYX", "XXX", 'Y', Items.gold_nugget, 'X', Items.string});
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemUsaginosippo , 1), new Object[] {"XY ", "YX ", "  Z", 'X', new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE) , 'Y', Items.string, 'Z', new ItemStack(Blocks.double_plant, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemUsaginosippo , 1), new Object[] {"XY ", "YX ", "  Z", 'X', new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE) , 'Y', Items.string, 'Z', new ItemStack(Blocks.red_flower, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemUsaginosippo , 1), new Object[] {"XY ", "YX ", "  Z", 'X', new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE) , 'Y', Items.string, 'Z', new ItemStack(Blocks.yellow_flower, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSinpannokabuto , 1), new Object[]
                {
                    "ABC",
                    " X ",
                    "DEF",
                    'A', DQArmors.itemRotonokabuto, 'B', DQArmors.itemRadatomukabuto, 'C', DQArmors.itemRoresiametto, 'D', DQArmors.itemYuusyanokanmuri,
                    'E', DQArmors.itemTenkuunokabuto, 'F', DQArmors.itemGurantaban, 'X', DQDecorates.DqmBlockRotomon
                });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemSinwanoyoroi , 1), new Object[]
                {
                    "ABC",
                    " X ",
                    "DEF",
                    'A', DQArmors.itemRotonoyoroi, 'B', DQArmors.itemRadatomunoyoroi, 'C', DQArmors.itemRoresianofuku, 'D', DQArmors.itemYuusyanofuku,
                    'E', DQArmors.itemTenkuunofuku, 'F', DQArmors.itemGuranbaniarobu, 'X', DQDecorates.DqmBlockRotomon
                });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemAmaterasunokote , 1), new Object[]
                {
                    "ABC",
                    " X ",
                    "DEF",
                    'A', DQArmors.itemRotonokote, 'B', DQArmors.itemRadatomugurobu, 'C', DQArmors.itemRoresiagurobu, 'D', DQArmors.itemYusyanogurobu,
                    'E', DQArmors.itemTenkuunogurobu, 'F', DQArmors.itemGuranbaniarisuto, 'X', DQDecorates.DqmBlockRotomon
                });
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemTenteinobutu , 1), new Object[]
                {
                    "ABC",
                    " X ",
                    "DEF",
                    'A', DQArmors.itemRotonokutu, 'B', DQArmors.itemRadatomubutu, 'C', DQArmors.itemRoresiabutu, 'D', DQArmors.itemYuusyanobutu,
                    'E', DQArmors.itemTenkuunobutu, 'F', DQArmors.itemGuranbanianokutu, 'X', DQDecorates.DqmBlockRotomon
                });

        /*
        GameRegistry.addRecipe(new ItemStack(DQArmors.itemMegaminotate , 1), new Object[]
                {
                    "ABA",
                    "CDC",
                    "EFG",
                    'A', DQMiscs.itemTensinosoma, 'B', DQArmors.itemBuruoubu, 'C', DQArmors.itemTensinohane, 'D', DQArmors.itemMikagaminotate,
                    'E', DQArmors.itemTenkuu, 'F', DQArmors.itemSeireiseki, 'G', DQArmors.itemBougu
                });

        GameRegistry.addRecipe(new ItemStack(DQArmors.itemUroborosunotate , 1), new Object[]
                {
                    "ABC",
                    "DEF",
                    "GHI",
                    'A', DQArmors.itemBougu, 'B', DQArmors.itemTenkuunotate, 'C', DQArmors.itemHakai, 'D', DQArmors.itemMegaminotate,
                    'E', DQArmors.itemRotomon, 'F', DQArmors.itemMetarukingnotate, 'G', DQArmors.itemMaJu, 'H', DQArmors.itemRotonotate, 'I', DQArmors.itemDensetu
                });

        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori0 , 1), new Object[]
                {
                    " C ",
                    "BAB",
                    " C ",
                    'A', DQMiscs.itemSinkanohiseki, 'B', DQIngots.itemMoon, 'C', DQMiscs.itemGenmaseki
                });
*/
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori0 , 1), new Object[]
                {
                    " C ",
                    "BAB",
                    " C ",
                    'A', Blocks.lapis_block, 'B', DQIngots.itemMoon, 'C', Items.redstone
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori1 , 1), new Object[]
                {
	                " C ",
	                "BAB",
	                " C ",
                    'A', DQMiscs.itemMegaminoinori0, 'B', DQIngots.itemKagaminoisi, 'C', DQIngots.itemRubinogenseki
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori2 , 1), new Object[]
                {
	                " B ",
	                "BAB",
	                " B ",
                    'A', DQMiscs.itemMegaminoinori1, 'B', DQIngots.itemPuratina
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori3 , 1), new Object[]
                {
	                " C ",
	                "BAB",
	                " C ",
                    'A', DQMiscs.itemMegaminoinori2, 'B', DQMiscs.itemBekkou, 'C', DQIngots.itemTaiyounoisi
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori4 , 1), new Object[]
                {
	                " C ",
	                "BAB",
	                " C ",
                    'A', DQMiscs.itemMegaminoinori3, 'B', DQMiscs.itemDoragonnonamida, 'C', DQIngots.itemMisriru
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori5 , 1), new Object[]
                {
	                " C ",
	                "BAB",
	                " C ",
                    'A', DQMiscs.itemMegaminoinori4, 'B', DQMiscs.itemRyuunonamida, 'C', DQIngots.itemOriharukon
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori6 , 1), new Object[]
                {
	                " C ",
	                "BAB",
	                " C ",
                    'A', DQMiscs.itemMegaminoinori5, 'B', DQMiscs.itemKingdaiya, 'C', DQIngots.itemPuratina2
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori7 , 1), new Object[]
                {
	                " C ",
	                "BAB",
	                " C ",
                    'A', DQMiscs.itemMegaminoinori6, 'B', DQMiscs.itemSeireiseki, 'C', DQIngots.itemTaiyounoisi2
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori8 , 1), new Object[]
                {
	                " C ",
	                "BAB",
	                " C ",
                    'A', DQMiscs.itemMegaminoinori7, 'B', DQMiscs.itemMetaru, 'C', DQIngots.itemMisriru2
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori9 , 1), new Object[]
                {
	                " C ",
	                "BAB",
	                " C ",
                    'A', DQMiscs.itemMegaminoinori8, 'B', DQIngots.itemHikarinoisi, 'C', DQIngots.itemOriharukon2
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori10 , 1), new Object[]
                {
	                "BCD",
	                " A ",
	                "EFG",
                    'A', DQMiscs.itemMegaminoinori9, 'B', DQMiscs.itemMetaloubu, 'C', DQMiscs.itemRedoubu, 'D', DQMiscs.itemBuruoubu,
                    'E', DQMiscs.itemIerooubu, 'F', DQMiscs.itemGurinoubu, 'G', DQMiscs.itemPaapuruoubu
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMegaminoinori10 , 1), new Object[]
                {
	                "ABC",
	                "DEF",
	                "GHI",
	                'A', DQMiscs.itemMegaminoinori1, 'B', DQMiscs.itemMegaminoinori2, 'C', DQMiscs.itemMegaminoinori3, 'D', DQMiscs.itemMegaminoinori4,
                    'E', DQMiscs.itemMegaminoinori5, 'F', DQMiscs.itemMegaminoinori6, 'G', DQMiscs.itemMegaminoinori7, 'H', DQMiscs.itemMegaminoinori8, 'I', DQMiscs.itemMegaminoinori9
                });
    	//レッドオーブ
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    "AAA",
                    "AXA",
                    "AAA",
                    'A', DQMiscs.itemSiroikaigara, 'X', DQMiscs.itemRedoubu
                });
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    " A ",
                    "AXA",
                    " A ",
                    'A', Items.iron_ingot, 'X', DQMiscs.itemRedoubu
                });

    	//ブルーオーブ
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    "AAA",
                    "AXA",
                    "AAA",
                    'A', DQMiscs.itemSiroikaigara, 'X', DQMiscs.itemBuruoubu
                });
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    " A ",
                    "AXA",
                    " A ",
                    'A', Items.iron_ingot, 'X', DQMiscs.itemBuruoubu
                });

    	//パープルオーブ
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    "AAA",
                    "AXA",
                    "AAA",
                    'A', DQMiscs.itemSiroikaigara, 'X', DQMiscs.itemPaapuruoubu
                });
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    " A ",
                    "AXA",
                    " A ",
                    'A', Items.iron_ingot, 'X', DQMiscs.itemPaapuruoubu
                });

    	//イエローオーブ
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    "AAA",
                    "AXA",
                    "AAA",
                    'A', DQMiscs.itemSiroikaigara, 'X', DQMiscs.itemIerooubu
                });
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    " A ",
                    "AXA",
                    " A ",
                    'A', Items.iron_ingot, 'X', DQMiscs.itemIerooubu
                });

    	//グリーンオーブ
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    "AAA",
                    "AXA",
                    "AAA",
                    'A', DQMiscs.itemSiroikaigara, 'X', DQMiscs.itemGurinoubu
                });
    	GameRegistry.addRecipe(new ItemStack(DQMiscs.itemMetaloubu , 1), new Object[]
                {
                    " A ",
                    "AXA",
                    " A ",
                    'A', Items.iron_ingot, 'X', DQMiscs.itemGurinoubu
                });
    	GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockMinidama , 1), new Object[]
                {
                    "AAA",
                    "BAB",
                    "CCC",
                    'A', Blocks.cobblestone, 'B', Items.stick, 'C', Blocks.stone_slab
                });
        //GameRegistry.addShapelessRecipe(new ItemStack(Block.cloth, 4 , 0), new Object[] {new ItemStack(DQArmors.itemYawarakauru, 1), new ItemStack(fixItemShears, 1, 32767)});

        GameRegistry.addSmelting(DQSeeds.itemYakusou, new ItemStack(DQSeeds.itemYakusouSeed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemYakusou2, new ItemStack(DQSeeds.itemYakusouSeed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemYakusou3, new ItemStack(DQSeeds.itemYakusouSeed3 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemDokukesisou, new ItemStack(DQSeeds.itemDokukesisouSeed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemDokukesisou2, new ItemStack(DQSeeds.itemDokukesisouSeed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemDokukesisou3, new ItemStack(DQSeeds.itemDokukesisouSeed3 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemMamorinotane, new ItemStack(DQSeeds.itemMamoriSeed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemMamorinotane2, new ItemStack(DQSeeds.itemMamoriSeed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemMamorinotane3, new ItemStack(DQSeeds.itemMamoriSeed3 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemTikaranotane, new ItemStack(DQSeeds.itemTikaraSeed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemTikaranotane2, new ItemStack(DQSeeds.itemTikaraSeed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemTikaranotane3, new ItemStack(DQSeeds.itemTikaraSeed3 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemSubayasanotane, new ItemStack(DQSeeds.itemSubayasaSeed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemSubayasanotane2, new ItemStack(DQSeeds.itemSubayasaSeed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemSubayasanotane3, new ItemStack(DQSeeds.itemSubayasaSeed3 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemOugon, new ItemStack(DQSeeds.itemOugonSeed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemOugon2, new ItemStack(DQSeeds.itemOugonSeed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemOugon3, new ItemStack(DQSeeds.itemOugonSeed3 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemHonoonomi, new ItemStack(DQSeeds.itemHonooSeed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemHonoonomi2, new ItemStack(DQSeeds.itemHonooSeed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemHonoonomi3, new ItemStack(DQSeeds.itemHonooSeed3 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemIyasinomi, new ItemStack(DQSeeds.itemIyasiSeed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemIyasinomi2, new ItemStack(DQSeeds.itemIyasiSeed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemIyasinomi3, new ItemStack(DQSeeds.itemIyasiSeed3 , 1), 1);
        GameRegistry.addSmelting(DQMiscs.itemTetunokugi, new ItemStack(Items.iron_ingot , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemMahounomiI, new ItemStack(DQSeeds.itemMahounomiseed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemMahounomiI2, new ItemStack(DQSeeds.itemMahounomiseed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemMahounomiI3, new ItemStack(DQSeeds.itemMahounomiseed3 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemMaryokunotaneI, new ItemStack(DQSeeds.itemMaryokunotaneseed , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemMaryokunotaneI2, new ItemStack(DQSeeds.itemMaryokunotaneseed2 , 1), 1);
        GameRegistry.addSmelting(DQSeeds.itemMaryokunotaneI3, new ItemStack(DQSeeds.itemMaryokunotaneseed3 , 1), 1);


        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 0), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemBakudanisi});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 1), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemHikarinoisi});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 2), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemHosinokakera});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 3), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemInotinoisi});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 4), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemKagaminoisi});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 5), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemKoorinokessyou});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 6), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemMigakizuna});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 7), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemMisriru});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 8), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemMoon});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 9), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemOriharukon});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 10), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemPuratina});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 11), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemRubinogenseki});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 12), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemTaiyounoisi});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 13), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemTekkouseki});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 14), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemTokinosuisyou});
        GameRegistry.addRecipe(new ItemStack(DQOres.DqmOreBlocks, 1, 15), new Object[] {"XXX", "XXX", "XXX", 'X', DQIngots.itemYougansekinokakera});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemBakudanisi, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 0)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemHikarinoisi, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemHosinokakera, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 2)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemInotinoisi, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 3)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemKagaminoisi, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 4)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemKoorinokessyou, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 5)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemMigakizuna, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 6)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemMisriru, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 7)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemMoon, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 8)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemOriharukon, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 9)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemPuratina, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 10)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemRubinogenseki, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 11)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemTaiyounoisi, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 12)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemTekkouseki, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 13)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemTokinosuisyou, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 14)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQIngots.itemYougansekinokakera, 9), new Object[] {new ItemStack(DQOres.DqmOreBlocks, 1, 15)});


        GameRegistry.addRecipe(new ItemStack(DQPlants.BlockHoujyouDirt , 1),
        		new Object[] {"XZX",
        					  "XYX",
        					  "XXX",
        					  'Y', Blocks.dirt, 'X', Items.rotten_flesh, 'Z', new ItemStack(Items.wooden_hoe, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addRecipe(new ItemStack(DQPlants.BlockHoujyouDirt , 1),
        		new Object[] {"XZX",
        					  "XYX",
        					  "XXX",
        					  'Y', Blocks.dirt, 'X', Items.rotten_flesh, 'Z', new ItemStack(Items.stone_hoe, 1, OreDictionary.WILDCARD_VALUE)});


        GameRegistry.addRecipe(new ItemStack(DQPlants.BlockHoujyouDirt , 1),
        		new Object[] {"XZX",
        					  "XYX",
        					  "XXX",
        					  'Y', Blocks.dirt, 'X', Items.rotten_flesh, 'Z', new ItemStack(Items.iron_hoe, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addRecipe(new ItemStack(DQPlants.BlockHoujyouDirt , 1),
        		new Object[] {"XZX",
        					  "XYX",
        					  "XXX",
        					  'Y', Blocks.dirt, 'X', Items.rotten_flesh, 'Z', new ItemStack(Items.golden_hoe, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addRecipe(new ItemStack(DQPlants.BlockHoujyouDirt , 1),
        		new Object[] {"XZX",
        					  "XYX",
        					  "XXX",
        					  'Y', Blocks.dirt, 'X', Items.rotten_flesh, 'Z', new ItemStack(Items.diamond_hoe, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemUsaginosippo , 1), new Object[] {"XY ", "YX ", "  Z", 'X', new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE) , 'Y', Items.string, 'Z', Blocks.red_flower});

        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUmanofun, 1), new ItemStack(Items.wooden_hoe, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUsinofun, 1), new ItemStack(Items.wooden_hoe, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUmanofun, 1), new ItemStack(Items.stone_hoe, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUsinofun, 1), new ItemStack(Items.stone_hoe, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUmanofun, 1), new ItemStack(Items.iron_hoe, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUsinofun, 1), new ItemStack(Items.iron_hoe, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUmanofun, 1), new ItemStack(Items.golden_hoe, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUsinofun, 1), new ItemStack(Items.golden_hoe, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUmanofun, 1), new ItemStack(Items.diamond_hoe, 1, OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQPlants.BlockHoujyouDirt, 1), new Object[] {new ItemStack(Blocks.dirt, 1), new ItemStack(DQMiscs.itemUsinofun, 1), new ItemStack(Items.diamond_hoe, 1, OreDictionary.WILDCARD_VALUE)});

        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockFarmBookShelf , 1), new Object[] {" A ", "BCD", "E F", 'A', DQSeeds.itemSubayasanotane, 'B', DQSeeds.itemTikaranotane, 'C', Blocks.bookshelf, 'D', DQSeeds.itemMamorinotane, 'E', DQSeeds.itemYakusou, 'F', DQSeeds.itemDokukesisou});
        GameRegistry.addRecipe(new ItemStack(DQDecorates.DqmBlockFarmBookShelf , 1), new Object[] {" A ", "BCD", "E F", 'A', DQSeeds.itemSubayasaSeed, 'B', DQSeeds.itemTikaraSeed, 'C', Blocks.bookshelf, 'D', DQSeeds.itemMamoriSeed, 'E', DQSeeds.itemYakusouSeed, 'F', DQSeeds.itemDokukesisouSeed});

        GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4), new Object[] {new ItemStack(Blocks.wool, 1,  OreDictionary.WILDCARD_VALUE), new ItemStack(Items.shears, 1,  OreDictionary.WILDCARD_VALUE)});
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.wool, 4, 0), new Object[] {new ItemStack(DQMiscs.itemYawarakauru, 1), new ItemStack(Items.shears, 1,  OreDictionary.WILDCARD_VALUE)});

        //GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDqmbed3, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDqmbed2, 1), new ItemStack(Blocks.bed, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockDqmbed3, 1), new Object[] {new ItemStack(DQDecorates.DqmBlockDqmbed2, 1), new ItemStack(Items.bed, 1), new ItemStack(Blocks.lapis_block, 1)});

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTetunosoroban , 1),
        		new Object[] {"XYX",
        					  "XYX",
        					  " X ",
        					  'Y', Items.stick, 'X', DQIngots.itemTekkouseki});

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemMahounosoroban , 1),
        		new Object[] {"XVX",
        					  "XYX",
        					  " Z ",
        					  'Y', DQSeeds.itemMaryokunotaneI3, 'V', DQSeeds.itemMahounomiI3,  'X', DQIngots.itemMisriru, 'Z', DQWeapons.itemTetunosoroban});

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSeiginosoroban , 1),
        		new Object[] {"XVX",
        					  "XYX",
        					  "AZA",
        					  'A', DQMiscs.itemSorobanR,'Y', DQSeeds.itemOugon4, 'V', DQIngots.itemOriharukon,  'X', DQMiscs.itemIerooubu, 'Z', DQWeapons.itemMahounosoroban});

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSeiginosoroban2, 1), new Object[]
                {
                    "CCC",
                    "BAB",
                    "DDD",
                    'A', DQWeapons.itemSeiginosoroban, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                });


        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHanenoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "B C",
                    'B', Items.stick, 'C', Items.feather
                });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTetunoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "B C",
                    'B', Items.stick, 'C', Items.iron_ingot
                });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemBattlefan, 1), new Object[]
                {
                    "CCC",
                    " AC",
                    "B C",
                    'A',DQWeapons.itemTetunoougi ,'B', Items.stick, 'C', DQIngots.itemTekkouseki
                });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemReppuunoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "A C",
                    'A',DQAccessories.itemHayatenoring ,'B', DQWeapons.itemHanenoougi, 'C', DQMiscs.itemKazekirinohane
                });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemKamenoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "A C",
                    'A',DQMiscs.itemBekkou ,'B', DQWeapons.itemBattlefan, 'C', DQMiscs.itemYorunotobari
                });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemNekonoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "A C",
                    'A',DQMiscs.itemNekozuna ,'B', DQWeapons.itemBattlefan, 'C', DQMiscs.itemSiroikaigara
                });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTorinoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "A C",
                    'A',DQMiscs.itemKazekirinohane ,'B', DQWeapons.itemBattlefan, 'C', DQMiscs.itemAkaisango
                });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHebinoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "A C",
                    'A',DQMiscs.itemKyodaihigetokage ,'B', DQWeapons.itemBattlefan, 'C', DQMiscs.itemHebinonukegara
                });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemHosinoougi, 1), new Object[]
                {
                    "AED",
                    " BE",
                    "E C",
                    'A',DQWeapons.itemKamenoougi ,'B', DQWeapons.itemNekonoougi,
                    'C', DQWeapons.itemTorinoougi, 'D', DQWeapons.itemHebinoougi,
                    'E', DQIngots.itemHosinokakera
                });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTukinoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "A C",
                    'A',DQAccessories.itemMangetunoring ,'B', DQWeapons.itemHosinoougi, 'C', DQIngots.itemMoon
                });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTukinoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "A C",
                    'A',DQOres.BlockOreMoon ,'B', DQWeapons.itemHosinoougi, 'C', DQIngots.itemMoon
                });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemTaiyounoougi, 1), new Object[]
                {
                    "CCC",
                    " BC",
                    "A C",
                    'A',DQOres.BlockOreTaiyounoisi ,'B', DQWeapons.itemTukinoougi, 'C', DQIngots.itemTaiyounoisi
                });
        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSaisyuuougi, 1), new Object[]
                {
                    "CCC",
                    "DBC",
                    "ADC",
                    'A',DQIngots.itemOriharukon2 ,'B', DQWeapons.itemTaiyounoougi, 'C', DQMiscs.itemGurinoubu, 'D', DQMiscs.itemOugiR
                });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemSaisyuuougi2, 1), new Object[]
                {
                    "CCC",
                    "BAB",
                    "DDD",
                    'A', DQWeapons.itemSaisyuuougi, 'B', DQMiscs.itemGenmaseki, 'C', DQMiscs.itemGenmasekiB, 'D', DQMiscs.itemGenmasekiG
                });

        GameRegistry.addRecipe(new ItemStack(DQWeapons.itemToririondaga, 1), new Object[]
                {
                    "A A",
                    " C ",
                    "B A",
                    'A', DQWeapons.itemSaramanda, 'B', DQMiscs.itemMaJu, 'C', DQMiscs.itemRedoubu
                });

        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockKowareru5 , 16), new Object[] {new ItemStack(DQIngots.itemMigakizuna, 1), new ItemStack(Blocks.lapis_block, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockKowareru6 , 16), new Object[] {new ItemStack(DQIngots.itemMigakizuna, 1), new ItemStack(Blocks.gold_block, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockKowareru7 , 16), new Object[] {new ItemStack(DQIngots.itemMigakizuna, 1), new ItemStack(Blocks.diamond_block, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockKowareru8 , 16), new Object[] {new ItemStack(DQIngots.itemMigakizuna, 1), new ItemStack(Blocks.redstone_block, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockKowareru9 , 16), new Object[] {new ItemStack(DQIngots.itemMigakizuna, 1), new ItemStack(Blocks.emerald_block, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemHepaitosunohidane , 1), new Object[] {new ItemStack(DQDecorates.DqmBlockHepaitosu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQDecorates.DqmBlockHepaitosu , 1), new Object[] {new ItemStack(DQMiscs.itemHepaitosunohidane, 1)});

        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemDyeWhite2, 4), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMiscs.itemHonehone, 'B', DQMiscs.itemUmanofun
                });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemDyeWhite2, 4), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', DQMiscs.itemHonehone, 'B', DQMiscs.itemUsinofun
                });

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasaCR , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasaC, 1), new ItemStack(Blocks.redstone_block, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasaCB , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasaC, 1), new ItemStack(Blocks.lapis_block, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasaCG , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasaC, 1), new ItemStack(Blocks.emerald_block, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemKimeranotubasaCY , 1), new Object[] {new ItemStack(DQMiscs.itemKimeranotubasaC, 1), new ItemStack(Blocks.gold_block, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemLittlemedal1000 , 1), new Object[] {new ItemStack(DQMiscs.itemLittlemedal500, 1), new ItemStack(DQMiscs.itemLittlemedal500, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemLittlemedal500 , 2), new Object[] {new ItemStack(DQMiscs.itemLittlemedal1000, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemLittlemedal500, 1), new Object[] {new ItemStack(DQMiscs.itemLittlemedal100, 1), new ItemStack(DQMiscs.itemLittlemedal100, 1), new ItemStack(DQMiscs.itemLittlemedal100, 1), new ItemStack(DQMiscs.itemLittlemedal100, 1), new ItemStack(DQMiscs.itemLittlemedal100, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemLittlemedal100 , 5), new Object[] {new ItemStack(DQMiscs.itemLittlemedal500, 1)});

        GameRegistry.addRecipe(new ItemStack(DQMiscs.ItemMahounoTutu01, 1), new Object[]
        {
            " A ",
            "BCB",
            " D ",
            'A', DQIngots.itemHosinokakera, 'B', Items.ender_pearl, 'C', DQIngots.itemTaiyounoisi,'D', DQIngots.itemMoon
        });

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.ItemMahounoTutu01, 1), new Object[] {new ItemStack(DQMiscs.ItemMahounoTutu01B, 1), new ItemStack(Items.ender_pearl, 1)});

        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemSinkanohiseki, 1), new Object[]
        {
            " A ",
            "ABA",
            " A ",
            'A', DQIngots.itemHikarinoisi, 'B', DQMiscs.itemMegaminoinori0
        });

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemNiku1, 1), new Object[] {new ItemStack(Items.bone, 1), new ItemStack(Items.cooked_beef, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemNiku1, 1), new Object[] {new ItemStack(DQMiscs.itemHonehone, 1), new ItemStack(Items.cooked_beef, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemNiku1, 1), new Object[] {new ItemStack(Items.bone, 1), new ItemStack(Items.cooked_chicken, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemNiku1, 1), new Object[] {new ItemStack(DQMiscs.itemHonehone, 1), new ItemStack(Items.cooked_chicken, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemNiku1, 1), new Object[] {new ItemStack(Items.bone, 1), new ItemStack(Items.cooked_porkchop, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemNiku1, 1), new Object[] {new ItemStack(DQMiscs.itemHonehone, 1), new ItemStack(Items.cooked_porkchop, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemNiku2, 1), new Object[] {new ItemStack(DQMiscs.itemNiku1, 1), new ItemStack(DQMiscs.itemAyakasisou, 1), new ItemStack(DQMiscs.itemAyakasisou, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemNiku3, 1), new Object[] {new ItemStack(DQMiscs.itemNiku2, 1), new ItemStack(DQMiscs.itemUruwasikinoko, 1), new ItemStack(DQMiscs.itemUruwasikinoko, 1)});

        GameRegistry.addRecipe(new ItemStack(DQMagicTools.itemPetSuisyou, 1), new Object[]
        {
            "AAA",
            "ABA",
            "AAA",
            'A', Blocks.glass, 'B', DQMiscs.itemNiku4
        });

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemOokinaFukuroR, 1), new Object[] {new ItemStack(DQMiscs.itemOokinaFukuro, 1), new ItemStack(DQMiscs.itemAkaisango, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemOokinaFukuroG, 1), new Object[] {new ItemStack(DQMiscs.itemOokinaFukuro, 1), new ItemStack(DQMiscs.itemMidorinokoke, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemOokinaFukuroB, 1), new Object[] {new ItemStack(DQMiscs.itemOokinaFukuro, 1), new ItemStack(DQMiscs.itemSuraimuzeri, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemOokinaFukuroY, 1), new Object[] {new ItemStack(DQMiscs.itemOokinaFukuro, 1), new ItemStack(DQMiscs.itemHananomitu, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemOokinaFukuro, 1), new Object[] {new ItemStack(DQMiscs.itemOokinaFukuroR, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemOokinaFukuro, 1), new Object[] {new ItemStack(DQMiscs.itemOokinaFukuroG, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemOokinaFukuro, 1), new Object[] {new ItemStack(DQMiscs.itemOokinaFukuroB, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQMiscs.itemOokinaFukuro, 1), new Object[] {new ItemStack(DQMiscs.itemOokinaFukuroY, 1), new ItemStack(DQMiscs.itemSiroikaigara, 1)});

        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemOokinaFukuro , 1), new Object[]
        {
            "AAA",
            "BBB",
            "AAA",
            'A', DQMiscs.itemYawarakauru, 'B', DQMiscs.itemMadarakumonoito
        });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemOokinaFukuro), new Object[]
        {
            "AAA",
            "BBB",
            "AAA",
            'A', DQMiscs.itemYogoretahoutai, 'B', DQMiscs.itemMadarakumonoito
        });

        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest1, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobFigures.BlockFigureSuraimunaito, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest1, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobObjects.BlockObjSuraimunaito, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest2, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobFigures.BlockFigureKirapan, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest2, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobObjects.BlockObjKirapan, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest3, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobFigures.BlockFigureBebisatan, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest3, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobObjects.BlockObjBebisatan, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest4, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobFigures.BlockFigureGoremu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest4, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobObjects.BlockObjGoremu, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest5, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobFigures.BlockFigureGaikotukensi, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQChests.DqmEnderChest5, 1), new Object[] {new ItemStack(Blocks.ender_chest, 1), new ItemStack(DQMobObjects.BlockObjGaikotukensi, 1)});


        GameRegistry.addRecipe(new ItemStack(DQBlocks.DqmBlockN, 4), new Object[]
        {
            "ABA",
            "BCB",
            "ABA",
            'C', Items.ender_pearl, 'A', DQSeeds.itemSubayasanotane, 'B', Blocks.redstone_block
        });

        GameRegistry.addRecipe(new ItemStack(DQBlocks.DqmBlockN2, 4), new Object[]
        {
            "ABA",
            "BCB",
            "ABA",
            'C', Items.ender_eye, 'A', DQSeeds.itemSubayasanotane, 'B', Blocks.redstone_block
        });

        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockS , 1), new Object[] {new ItemStack(DQBlocks.DqmBlockN, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockE , 1), new Object[] {new ItemStack(DQBlocks.DqmBlockS, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockW , 1), new Object[] {new ItemStack(DQBlocks.DqmBlockE, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockN , 1), new Object[] {new ItemStack(DQBlocks.DqmBlockW, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockN2 , 1), new Object[] {new ItemStack(DQBlocks.DqmBlockN, 1), new ItemStack(Items.blaze_powder, 1)});

        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockS2 , 1), new Object[] {new ItemStack(DQBlocks.DqmBlockN2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockE2 , 1), new Object[] {new ItemStack(DQBlocks.DqmBlockS2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockW2 , 1), new Object[] {new ItemStack(DQBlocks.DqmBlockE2, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(DQBlocks.DqmBlockN2 , 1), new Object[] {new ItemStack(DQBlocks.DqmBlockW2, 1)});



        GameRegistry.addRecipe(new ItemStack(DQBlocks.DqmBlockJampBlock), new Object[]
        {
            "BFA",
            "CEC",
            "AFB",
            'E', Blocks.enchanting_table, 'A', DQSeeds.itemSubayasanotane3, 'B', Items.ender_pearl,
            'C', DQMiscs.itemMeijikimeranohane, 'F', Blocks.glass
        });

        GameRegistry.addRecipe(new ItemStack(DQBlocks.DqmBlockJampBlock), new Object[]
        {
            "BFA",
            "CEC",
            "AFB",
            'E', Blocks.enchanting_table, 'A', DQSeeds.itemSubayasanotane3, 'B', Items.ender_pearl,
            'C', DQMiscs.itemMeijikimeranohane, 'F', new ItemStack(Blocks.stained_glass, 1, OreDictionary.WILDCARD_VALUE)
        });


        GameRegistry.addRecipe(new ItemStack(DQBlocks.DqmBlockJampBlock2), new Object[]
        {
            "BFA",
            "CEC",
            "AFB",
            'E', Blocks.netherrack, 'A', DQSeeds.itemSubayasanotane, 'B', Items.ender_pearl,
            'C', DQMiscs.itemKazekirinohane, 'F', Blocks.glass
        });

        GameRegistry.addRecipe(new ItemStack(DQBlocks.DqmBlockJampBlock2), new Object[]
        {
            "BFA",
            "CEC",
            "AFB",
            'E', Blocks.netherrack, 'A', DQSeeds.itemSubayasanotane, 'B', Items.ender_pearl,
            'C', DQMiscs.itemKazekirinohane, 'F', new ItemStack(Blocks.stained_glass, 1, OreDictionary.WILDCARD_VALUE)
        });

        GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 4), new Object[] {new ItemStack(DQMiscs.itemKinkai, 1)});


        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemDragonObuB), new Object[]
        {
            "ADA",
            "BEB",
            "CFC",
            'A', DQIngots.itemOriharukon2, 'B', DQIngots.itemMisriru2, 'C', DQIngots.itemPuratina2,
            'D', DQMiscs.itemRyuunonamida, 'E', DQMiscs.itemPisaronotamasii, 'F', DQMiscs.itemDoragonnonamida,
        });

        GameRegistry.addRecipe(new ItemStack(DQAccessories.itemAccCanceler), new Object[]
        {
            " A ",
            "AAA",
            " A ",
            'A', DQIngots.itemMigakizuna
        });

        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemShinjirukokoro), new Object[]
        {
            "ABA",
            "AAA",
            " A ",
            'A', DQIngots.itemHosinokakera, 'B', DQIngots.itemInotinoisi
        });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemShinjirukokoro), new Object[]
        {
            "ABA",
            "AAA",
            " A ",
            'A', DQIngots.itemMoon, 'B', DQIngots.itemInotinoisi
        });

        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemShinjirukokoro), new Object[]
        {
            "ABA",
            "AAA",
            " A ",
            'A', DQIngots.itemHosinokakera, 'B', DQIngots.itemRubinogenseki
        });
        GameRegistry.addRecipe(new ItemStack(DQMiscs.itemShinjirukokoro), new Object[]
        {
            "ABA",
            "AAA",
            " A ",
            'A', DQIngots.itemMoon, 'B', DQIngots.itemRubinogenseki
        });

        GameRegistry.addRecipe(new ItemStack(DQPlants.BlockWaterBlock), new Object[]
        {
            " A ",
            "ABA",
            " A ",
            'A', DQIngots.itemKoorinokessyou, 'B', DQMiscs.itemSuraimuzeri
        });

        GameRegistry.addRecipe(new ItemStack(DQPlants.BlockWaterBlockLight), new Object[]
        {
            " A ",
            "ABA",
            " A ",
            'A', DQIngots.itemHikarinoisi, 'B', DQPlants.BlockWaterBlock
        });


	}
}
