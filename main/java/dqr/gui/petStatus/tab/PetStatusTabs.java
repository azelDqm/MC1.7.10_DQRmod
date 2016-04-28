package dqr.gui.petStatus.tab;


public class PetStatusTabs {


	public static AbstractTab tabPetInventory;
	public static AbstractTab tabPetStatus;


	public static void initRecipes(){


		tabPetStatus = new InventoryTabPetStatus();
		TabManager.registerTab(tabPetStatus);

		tabPetInventory = new InventoryTabPetInventory();
		TabManager.registerTab(tabPetInventory);
		/*
		tabMedalArmor = new InventoryTabMedalArmor();
		TabManager.registerTab(tabMedalArmor);

		tabMedalMagic = new InventoryTabMedalMagic();
		TabManager.registerTab(tabMedalMagic);

		tabMedalMagic2 = new InventoryTabMedalMagic2();
		TabManager.registerTab(tabMedalMagic2);

		tabMedalJob = new InventoryTabMedalJob();
		TabManager.registerTab(tabMedalJob);

		tabMedalMisc = new InventoryTabMedalMisc();
		TabManager.registerTab(tabMedalMisc);
		*/

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
