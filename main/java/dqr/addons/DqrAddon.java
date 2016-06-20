package dqr.addons;

import java.io.File;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import dqr.DQR;
import dqr.addons.mceconomy2.ComponentVillageBankMPHouse;
import dqr.addons.mceconomy2.DqrEntityNPCBankMP;
import dqr.addons.mceconomy2.VillageCreationHandleBankMP;

public class DqrAddon {

	public static String bopName = "BiomesOPlenty";
	public static String galactiName = "GalacticraftCore";
	public static String mce2Name = "mceconomy2";
	public static String amt2Name = "BiomesOPlenty";
	public static String ss2Name = "SextiarySector";
	public static String ss2AddName = "DQRmodSS2addon";
	public static String tofuName = "TofuCraft";
	public static boolean bopIsLoad = false;
	public static boolean galactiIsLoad = false;
	public static boolean mce2IsLoad = false;
	public static boolean amt2IsLoad = false;
	public static boolean ss2IsLoad = false;
	public static boolean ss2AddIsLoad = false;
	public static boolean tofuIsLoad = false;

	public static DqrAddonGalacticraft addonGalacticraft;
	public static DqrAddonMCEconomy2 addonMCEconomy2;
	public static DqrAddonBiomesOPlenty addonBiomeOPlenty;

	public static Configuration cfg_addons;

	//MCEconomy2詳細設定
	public int objPriceDay = 10;
	public int objPriceNight = 20;
	public int objPriceNether = 50;
	public int objPriceEnd = 100;
	public int objPriceSP = 500;
	public int objPriceBoss = 1000;
	public int objPriceMetaru = 1000;
	public int mce2NPCBankMPId = 5001;
	public int rateMP = 10000; //1000Gあたりのレート
	
	public int mce2IsEnabled = 0;



	public DqrAddon()
	{
		bopIsLoad = Loader.isModLoaded(bopName);
		galactiIsLoad = Loader.isModLoaded(galactiName);
		amt2IsLoad = Loader.isModLoaded(amt2Name);
		mce2IsLoad = Loader.isModLoaded(mce2Name);
		ss2IsLoad = Loader.isModLoaded(ss2Name);
		ss2AddIsLoad = Loader.isModLoaded(ss2AddName);
		tofuIsLoad = Loader.isModLoaded(tofuName);
	}

	public void setAddons()
	{
		if(bopIsLoad || galactiIsLoad || amt2IsLoad || ss2IsLoad || tofuIsLoad)
		{
			cfg_addons = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext/DQMIIINext_Addons.cfg"));
			cfg_addons.load();
			cfg_addons.setCategoryComment("Addon enabler", "");

			if(DQR.addons.galactiIsLoad)
			{
				int  flg = cfg_addons.get("Addon enabler","addon for Galacticraft", 1 , "0:disable 1:enable").getInt();;
				if(flg > 0)
				{
					System.out.println("adding GalacticraftsAddon");
					addonGalacticraft = new DqrAddonGalacticraft();
					MinecraftForge.EVENT_BUS.register(new DqrAddonGalacticraft());
				}
			}

			if(DQR.addons.mce2IsLoad)
			{
				mce2IsEnabled = cfg_addons.get("Addon enabler","addon for MCEconomy2", 1 , "0:disable 1:enable").getInt();;
				if(mce2IsEnabled > 0)
				{
					System.out.println("adding MCEconomy2Addon");

					cfg_addons.setCategoryComment("Advanced Settings (MCEconomy2Addon)", "this setting is MCEconomy2Addon");
					objPriceDay = cfg_addons.get("Advanced Settings (MCEconomy2Addon)","Object/Figure Price(DayMonster)", objPriceDay ,"Value of monster object and figure MP[MCEconomy2]").getInt();
					objPriceNight = cfg_addons.get("Advanced Settings (MCEconomy2Addon)","Object/Figure Price(NightMonster)", objPriceNight ,"Value of monster object and figure MP[MCEconomy2]").getInt();
					objPriceNether = cfg_addons.get("Advanced Settings (MCEconomy2Addon)","Object/Figure Price(NetherMonster)", objPriceNether ,"Value of monster object and figure MP[MCEconomy2]").getInt();
					objPriceEnd = cfg_addons.get("Advanced Settings (MCEconomy2Addon)","Object/Figure Price(EndMonster)", objPriceEnd ,"Value of monster object and figure MP[MCEconomy2]").getInt();
					objPriceSP = cfg_addons.get("Advanced Settings (MCEconomy2Addon)","Object/Figure Price(SPMonster)", objPriceSP ,"Value of monster object and figure MP[MCEconomy2]").getInt();
					objPriceBoss = cfg_addons.get("Advanced Settings (MCEconomy2Addon)","Object/Figure Price(BossMonster)", objPriceBoss ,"Value of monster object and figure MP[MCEconomy2]").getInt();
					objPriceMetaru = cfg_addons.get("Advanced Settings (MCEconomy2Addon)","Object/Figure Price(RareMonster)", objPriceMetaru ,"Value of monster object and figure MP[MCEconomy2]").getInt();

					rateMP = cfg_addons.get("Advanced Settings (MCEconomy2Addon)","Exchange MP rate", rateMP ,"Value MP = 1000G").getInt();
					mce2NPCBankMPId = cfg_addons.get("Advanced Settings (MCEconomy2Addon)","NPCID", mce2NPCBankMPId ,"DQR NPCEntity ID for BankMP").getInt();

					addonMCEconomy2 = new DqrAddonMCEconomy2();

					EntityRegistry.registerModEntity(DqrEntityNPCBankMP.class, "NPCBankMP", mce2NPCBankMPId, DQR.instance, 250, 1, false);
					DQR.proxy.registerMCEconomy2Addon();

					VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandleBankMP());
					MapGenStructureIO.registerStructure(ComponentVillageBankMPHouse.class, "DQBankMPHouse");
					MapGenStructureIO.func_143031_a(ComponentVillageBankMPHouse.class, "DQBankMPHouse");
					//inecraftForge.EVENT_BUS.register(new DqrAddonSextiarySector2());
				}
			}

			if(!DQR.addons.ss2AddIsLoad && DQR.addons.ss2IsLoad)
			{
				int  flg = cfg_addons.get("Addon enabler","addon for SextiarySector2", 1 , "0:disable 1:enable").getInt();;
				if(flg > 0)
				{
					System.out.println("adding SextiarySector2Addon");
					MinecraftForge.EVENT_BUS.register(new DqrAddonSextiarySector2());
				}
			}

			if(DQR.addons.bopIsLoad)
			{
				int  flg = cfg_addons.get("Addon enabler","addon for BiomeO'Plenty", 1 , "0:disable 1:enable").getInt();;
				if(flg > 0)
				{
					System.out.println("adding BiomeO'PlentyAddon");
					addonBiomeOPlenty = new DqrAddonBiomesOPlenty();
					//MinecraftForge.EVENT_BUS.register(new DqrAddonGalacticraft());
				}
			}
			cfg_addons.save();
		}
	}
}
