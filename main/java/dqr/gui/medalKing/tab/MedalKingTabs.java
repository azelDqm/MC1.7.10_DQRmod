package dqr.gui.medalKing.tab;

public class MedalKingTabs {

	public static AbstractTab ss;

	public static AbstractTab craft;

	public static AbstractTab rucksack;

	public static AbstractTab creeperShop;

	public static AbstractTab tabMedalWeapon;
	public static AbstractTab tabMedalArmor;
	public static AbstractTab tabMedalMagic;
	public static AbstractTab tabMedalMagic2;
	public static AbstractTab tabMedalJob;
	public static AbstractTab tabMedalMisc;
	public static AbstractTab tabMedalMedal;
	public static AbstractTab tabMedalAccessory;

	public static void initRecipes(){

		tabMedalMedal = new InventoryTabMedalMedal();
		TabManager.registerTab(tabMedalMedal);

		tabMedalWeapon = new InventoryTabMedalWeapon();
		TabManager.registerTab(tabMedalWeapon);

		tabMedalArmor = new InventoryTabMedalArmor();
		TabManager.registerTab(tabMedalArmor);

		tabMedalMagic = new InventoryTabMedalMagic();
		TabManager.registerTab(tabMedalMagic);

		tabMedalMagic2 = new InventoryTabMedalMagic2();
		TabManager.registerTab(tabMedalMagic2);

		tabMedalJob = new InventoryTabMedalJob();
		TabManager.registerTab(tabMedalJob);

		tabMedalAccessory = new InventoryTabMedalAccessory();
		TabManager.registerTab(tabMedalAccessory);

		tabMedalMisc = new InventoryTabMedalMisc();
		TabManager.registerTab(tabMedalMisc);



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
