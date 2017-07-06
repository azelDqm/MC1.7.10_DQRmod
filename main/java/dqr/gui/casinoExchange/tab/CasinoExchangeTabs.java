package dqr.gui.casinoExchange.tab;

import dqr.gui.medalKing.tab.AbstractTab;

public class CasinoExchangeTabs {


	public static AbstractTab craft;

	public static AbstractTab rucksack;

	public static AbstractTab creeperShop;

	public static AbstractTab tabCasinoWeapon;
	public static AbstractTab tabCasinoArmor;
	public static AbstractTab tabCasinoMagic;
	public static AbstractTab tabCasinoMisc;
	public static AbstractTab tabCasinoAccessory;
	public static AbstractTab tabCasinoBuilder;
	public static AbstractTab tabCasinoDecorate;
	public static AbstractTab tabCasinoDecorateD;
	public static AbstractTab tabCasinoDecorateH;
	public static void initRecipes(){

		tabCasinoWeapon = new InventoryTabCasinoWeapon();
		TabManager.registerTab(tabCasinoWeapon);

		tabCasinoArmor = new InventoryTabCasinoArmor();
		TabManager.registerTab(tabCasinoArmor);

		/*
		tabCasinoMagic = new InventoryTabCasinoMagic();
		TabManager.registerTab(tabCasinoMagic);
		*/

		tabCasinoAccessory = new InventoryTabCasinoAccessory();
		TabManager.registerTab(tabCasinoAccessory);

		tabCasinoMisc = new InventoryTabCasinoMisc();
		TabManager.registerTab(tabCasinoMisc);

		tabCasinoBuilder = new InventoryTabCasinoBuilder();
		TabManager.registerTab(tabCasinoBuilder);

		tabCasinoDecorate = new InventoryTabCasinoDecorate();
		TabManager.registerTab(tabCasinoDecorate);

		tabCasinoDecorateD = new InventoryTabCasinoDecorateD();
		TabManager.registerTab(tabCasinoDecorateD);

		tabCasinoDecorateH = new InventoryTabCasinoDecorateH();
		TabManager.registerTab(tabCasinoDecorateH);
		/*
		ss = new InventoryTabSS();
		TabManager.registerTab(ss);

		craft = new InventoryTabEquipment(new ItemStack(Items.iron_axe, 1));
		TabManager.registerTab(craft);
		rucksack = new InventoryTabEquipment(new ItemStack(Items.iron_hoe, 1));
		TabManager.registerTab(rucksack);
		*/

		//creeperShop = new InventoryTabEquipment(EquipmentType.Ring, new ItemStack(SSItems.creeperRing));
		//TabManager.registerTab(creeperShop);
		//((ItemShopRing) SSItems.creeperRing).setTab(creeperShop);

	}

}
