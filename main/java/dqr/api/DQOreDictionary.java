package dqr.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import dqr.api.Blocks.DQOres;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMiscs;

public class DQOreDictionary {

	public DQOreDictionary()
	{
		OreDictionary.registerOre("oreBakudanisi", new ItemStack(DQOres.BlockOreBakudanisi, 1, 0));
		OreDictionary.registerOre("ingotBakudanisi", new ItemStack(DQIngots.itemBakudanisi, 1, 0));

		OreDictionary.registerOre("oreHikarinoisi", new ItemStack(DQOres.BlockOreHikarinoisi, 1, 0));
		OreDictionary.registerOre("ingotHikarinoisi", new ItemStack(DQIngots.itemHikarinoisi, 1, 0));

		OreDictionary.registerOre("oreStardust", new ItemStack(DQOres.BlockOreHosinokakera, 1, 0));
		OreDictionary.registerOre("ingotStardust", new ItemStack(DQIngots.itemHosinokakera, 1, 0));

		OreDictionary.registerOre("oreLifeStone", new ItemStack(DQOres.BlockOreInotinoisi, 1, 0));
		OreDictionary.registerOre("ingotLifeStone", new ItemStack(DQIngots.itemInotinoisi, 1, 0));

		OreDictionary.registerOre("oreMirror", new ItemStack(DQOres.BlockOreKagaminoisi, 1, 0));
		OreDictionary.registerOre("ingotMirror", new ItemStack(DQIngots.itemKagaminoisi, 1, 0));

		OreDictionary.registerOre("oreIcepowder", new ItemStack(DQOres.BlockOreKoorinokessyou, 1, 0));
		OreDictionary.registerOre("ingotIcepowder", new ItemStack(DQIngots.itemKoorinokessyou, 1, 0));

		OreDictionary.registerOre("oreLittlemedal", new ItemStack(DQOres.BlockOreLittlemedal, 1, 0));
		OreDictionary.registerOre("ingotLittlemedalr", new ItemStack(DQMiscs.itemLittlemedal, 1, 0));

		OreDictionary.registerOre("oreMetaru", new ItemStack(DQOres.BlockOreMetaru, 1, 0));
		OreDictionary.registerOre("ingotMetaru", new ItemStack(DQMiscs.itemMetaru, 1, 0));

		OreDictionary.registerOre("orePolishingsand", new ItemStack(DQOres.BlockOreMigakizuna, 1, 0));
		OreDictionary.registerOre("ingotPolishingsand", new ItemStack(DQIngots.itemMigakizuna, 1, 0));

		OreDictionary.registerOre("oreMythril", new ItemStack(DQOres.BlockOreMisuriru, 1, 0));
		OreDictionary.registerOre("ingotMythril", new ItemStack(DQIngots.itemMisriru, 1, 0));

		OreDictionary.registerOre("oreMoonstone", new ItemStack(DQOres.BlockOreMoon, 1, 0));
		OreDictionary.registerOre("ingotMoonstone", new ItemStack(DQIngots.itemMoon, 1, 0));

		OreDictionary.registerOre("orePlatinum", new ItemStack(DQOres.BlockOrePuratina, 1, 0));
		OreDictionary.registerOre("ingotPlatinum", new ItemStack(DQIngots.itemPuratina, 1, 0));

		OreDictionary.registerOre("oreRuby", new ItemStack(DQOres.BlockOreRubi, 1, 0));
		OreDictionary.registerOre("ingotRuby", new ItemStack(DQIngots.itemRubinogenseki, 1, 0));

		OreDictionary.registerOre("oreSunstone", new ItemStack(DQOres.BlockOreTaiyounoisi, 1, 0));
		OreDictionary.registerOre("ingotSunstone", new ItemStack(DQIngots.itemTaiyounoisi, 1, 0));

		OreDictionary.registerOre("oreSteel", new ItemStack(DQOres.BlockOreTekkouseki, 1, 0));
		OreDictionary.registerOre("ingotSteel", new ItemStack(DQIngots.itemTekkouseki, 1, 0));

		OreDictionary.registerOre("oreTimestone", new ItemStack(DQOres.BlockOreTokinosuisyou, 1, 0));
		OreDictionary.registerOre("ingotTimestone", new ItemStack(DQIngots.itemTokinosuisyou, 1, 0));

		OreDictionary.registerOre("oreMagmastone", new ItemStack(DQOres.BlockOreYougansekinokakera, 1, 0));
		OreDictionary.registerOre("ingotMagmastone", new ItemStack(DQIngots.itemYougansekinokakera, 1, 0));

		OreDictionary.registerOre("ingotOrichalcum　", new ItemStack(DQIngots.itemOriharukon, 1, 0));
	}

}
