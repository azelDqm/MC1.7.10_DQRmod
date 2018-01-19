package dqr.addons;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import dqr.DQR;
import dqr.addons.mceconomy2.ComponentVillageBankMPHouse;
import dqr.addons.mceconomy2.DqrBlockBankMP;
import dqr.addons.mceconomy2.DqrEntityNPCBankMP;
import dqr.addons.mceconomy2.DqrTileEntityBankMP;
import dqr.addons.mceconomy2.VillageCreationHandleBankMP;
import dqr.addons.tConstruct.FuncDropItemsHook;
import dqr.addons.twilightForest.DqmItemTwilightFigureDummy;
import dqr.addons.twilightForest.FuncMobSpawnChanger;
import dqr.addons.twilightForest.FuncRejectUncraft;
import dqr.addons.twilightForest.SS2drawFixHandler;
import dqr.addons.twilightForest.TwilightForestHandler;
import dqr.addons.twilightForest.coreHook.FuncTFMobHook;
import dqr.addons.twilightForest.coreHook.FuncUncraftHook;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmBuilder;
import dqr.blocks.itemBlock.ItemBlockDecorates;
import dqr.items.builder.DqmItemBuilderNPC;
import dqr.items.builder.DqmItemBuilderShop;

public class DqrAddon {

	public static String bopName = "BiomesOPlenty";
	public static String galactiName = "GalacticraftCore";
	public static String mce2Name = "mceconomy2";
	public static String amt2Name = "BiomesOPlenty";
	public static String ss2Name = "SextiarySector";
	public static String ss2AddName = "DQRmodSS2addon";
	public static String tofuName = "TofuCraft";
	public static String tasogareName = "TwilightForest";
	public static String tconstName = "TConstruct";
	public static boolean bopIsLoad = false;
	public static boolean galactiIsLoad = false;
	public static boolean mce2IsLoad = false;
	public static boolean amt2IsLoad = false;
	public static boolean ss2IsLoad = false;
	public static boolean ss2AddIsLoad = false;
	public static boolean tofuIsLoad = false;
	public static boolean tasogareIsLoad = false;
	public static boolean tconstIsLoad = false;

	public static int bopIsEnable = 0;
	public static int galactiIsEnable = 0;
	public static int mce2IsEnable = 0;
	public static int amt2IsEnable = 0;
	public static int ss2IsEnable = 0;
	public static int ss2AddIsEnable = 0;
	public static int tofuIsEnable = 0;
	public static int tasogareIsEnable = 0;
	public static int tconstIsEnable = 0;

	public static DqrAddonGalacticraft addonGalacticraft;
	public static DqrAddonMCEconomy2 addonMCEconomy2;
	public static DqrAddonBiomesOPlenty addonBiomeOPlenty;
	public static DqrAddonSextiarySector2 addonSextiarySector2;

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

	//public int mce2IsEnabled = 0;

	public Item itemTwilightFigureDummy = null;

	public static FuncRejectUncraft funcUncraft;
	public static FuncUncraftHook funcUncraftHook;
	public static FuncDropItemsHook funcDropItemsHook;
	public static FuncTFMobHook funcTFMobHook;

	public static int tfDifficulty = 3;

	public static String[] rejectUncraft = new String[]
			{
				"DQMIIINext:ItemMegaminoinori0",
				"DQMIIINext:ItemMegaminoinori1",
				"DQMIIINext:ItemMegaminoinori2",
				"DQMIIINext:ItemMegaminoinori3",
				"DQMIIINext:ItemMegaminoinori4",
				"DQMIIINext:ItemMegaminoinori5",
				"DQMIIINext:ItemMegaminoinori6",
				"DQMIIINext:ItemMegaminoinori7",
				"DQMIIINext:ItemMegaminoinori8",
				"DQMIIINext:ItemMegaminoinori9",
				"DQMIIINext:ItemMegaminoinori10",
				"DQMIIINext:ItemSinkanohiseki",
				"DQMIIINext:BlockWaterBlock",
				"DQMIIINext:BlockWaterBlockLight",
				"DQMIIINext:ItemNiku1",
				"DQMIIINext:ItemNiku2",
				"DQMIIINext:ItemNiku3",
				"DQMIIINext:ItemNiku4"
			};

	public static Block DqmBlockBankMP;
	public static ItemBlock itemBlockBankMP;
	public static Item itemBuilderShopBankMP;
	public static Item itemBuilderShopBankMPW;

	public static float tfFallingIceHurtAmount = 100.0f;
	public static int tfFallingIceHurtMax = 999;

	public DqrAddon()
	{
		bopIsLoad = Loader.isModLoaded(bopName);
		galactiIsLoad = Loader.isModLoaded(galactiName);
		amt2IsLoad = Loader.isModLoaded(amt2Name);
		mce2IsLoad = Loader.isModLoaded(mce2Name);
		ss2IsLoad = Loader.isModLoaded(ss2Name);
		ss2AddIsLoad = Loader.isModLoaded(ss2AddName);
		tofuIsLoad = Loader.isModLoaded(tofuName);
		tasogareIsLoad = Loader.isModLoaded(tasogareName);
		tconstIsLoad = Loader.isModLoaded(tconstName);
	}


	public void setAddons()
	{
		if(bopIsLoad || galactiIsLoad || amt2IsLoad || ss2IsLoad || tofuIsLoad || tasogareIsLoad || tconstIsLoad)
		{
			cfg_addons = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext/DQMIIINext_Addons.cfg"));
			cfg_addons.load();
			cfg_addons.setCategoryComment("Addon enabler", "");

			if(DQR.addons.galactiIsLoad)
			{
				galactiIsEnable = cfg_addons.get("Addon enabler","addon for Galacticraft", 1 , "0:disable 1:enable").getInt();;
				if(galactiIsEnable > 0)
				{
					System.out.println("adding GalacticraftsAddon");
					addonGalacticraft = new DqrAddonGalacticraft();
					MinecraftForge.EVENT_BUS.register(new DqrAddonGalacticraft());
				}
			}

			if(DQR.addons.tconstIsLoad)
			{
				tconstIsEnable = cfg_addons.get("Addon enabler","addon for TinkersConstruct", 1 , "0:disable 1:enable").getInt();;
				if(tconstIsEnable > 0)
				{
					funcDropItemsHook = new FuncDropItemsHook();
					System.out.println("adding TinkersConstructAddon");

				}
			}

			if(DQR.addons.mce2IsLoad)
			{
				mce2IsEnable = cfg_addons.get("Addon enabler","addon for MCEconomy2", 1 , "0:disable 1:enable").getInt();;
				if(mce2IsEnable > 0)
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

					DqmBlockBankMP = new DqrBlockBankMP(Material.wood).setmodel("BankMP").setBlockName("dqm.blockBankMP").setStepSound(Block.soundTypeWood).setHardness(0.5f).setCreativeTab(DQR.tabs.DqmTabDecorate).setBlockTextureName("dqr:BankMPB");
					itemBlockBankMP = new ItemBlockDecorates(DqmBlockBankMP);

					itemBuilderShopBankMP = new DqmItemBuilderShop(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBankMP").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_BankMP");
					itemBuilderShopBankMPW = new DqmItemBuilderNPC(EnumDqmBuilder.SHOP).setCreativeTab(DQR.tabs.DqmTabBuilder).setUnlocalizedName("dqm.BuilderShopBankMPW").setMaxStackSize(1).setTextureName("dqr:Builder_Shop_BankMPW");
					GameRegistry.registerItem(itemBuilderShopBankMP, "itemBuilderShopBankMP");
					GameRegistry.registerItem(itemBuilderShopBankMPW, "itemBuilderShopBankMPW");

					GameRegistry.addShapelessRecipe(new ItemStack(itemBuilderShopBankMPW, 1), new Object[] {new ItemStack(itemBuilderShopBankMP, 1), new ItemStack(DQMiscs.itemIerooubu, 1)});



					EntityRegistry.registerModEntity(DqrEntityNPCBankMP.class, "NPCBankMP", mce2NPCBankMPId, DQR.instance, 250, 1, false);
					GameRegistry.registerTileEntity(DqrTileEntityBankMP.class, "dqmTileEntityBankMP");
					GameRegistry.registerBlock(DqmBlockBankMP, itemBlockBankMP.getClass(), "DqmBlockBankMP");
					DQR.proxy.registerMCEconomy2Addon();

					VillagerRegistry.instance().registerVillageCreationHandler(new VillageCreationHandleBankMP());
					MapGenStructureIO.registerStructure(ComponentVillageBankMPHouse.class, "DQBankMPHouse");
					MapGenStructureIO.func_143031_a(ComponentVillageBankMPHouse.class, "DQBankMPHouse");
					//inecraftForge.EVENT_BUS.register(new DqrAddonSextiarySector2());
				}
			}

			if(!DQR.addons.ss2AddIsLoad && DQR.addons.ss2IsLoad)
			{
				ss2IsEnable = cfg_addons.get("Addon enabler","addon for SextiarySector2", 1 , "0:disable 1:enable").getInt();;
				if(ss2IsEnable > 0)
				{
					addonSextiarySector2 = new DqrAddonSextiarySector2();
					addonSextiarySector2.addRecipes();
					System.out.println("adding SextiarySector2Addon");
					MinecraftForge.EVENT_BUS.register(new DqrAddonSextiarySector2());
				}
			}

			//MinecraftForge.EVENT_BUS.register(new SS2drawFixHandler());
			//itemTwilightFigureDummy = new DqmItemTwilightFigureDummy();
			//itemTwilightFigureDummy.setMaxStackSize(1).setUnlocalizedName("dqm.itemTwilightFigureDummy").setTextureName("dqr:TwilightFigureDummy").setCreativeTab(DQR.tabs.DqmTabMisc);
			//GameRegistry.registerItem(itemTwilightFigureDummy, "ItemTwilightFigureDummy");


			if(DQR.addons.tasogareIsLoad)
			{

				cfg_addons.setCategoryComment("Advanced Settings (TwilightForest)", "this setting is TwilightForestAddon");
				rejectUncraft  = cfg_addons.get("Advanced Settings (TwilightForest)","Reject list for TFUncraftingTable", rejectUncraft , "add Items (write format  modName:Itemname(1line 1item)   ex.  hogehoget:hogelog1)").getStringList();
				funcUncraft = new FuncRejectUncraft();
				funcUncraftHook = new FuncUncraftHook();
				funcTFMobHook = new FuncTFMobHook();
				//tfDifficulty = cfg_addons.get("Advanced Settings (TwilightForest)","TwilightForestDifficulty", tfDifficulty , "0:disable 1:enable").getInt();
				new FuncMobSpawnChanger();

				tasogareIsEnable = cfg_addons.get("Addon enabler","addon for TwilightForest", 1 , "0:disable 1:enable").getInt();
				if(tasogareIsEnable > 0)
				{
					tfFallingIceHurtAmount = (float)DQR.funcMob.getCalcPW(100);
					tfFallingIceHurtMax = (int)(DQR.funcMob.getCalcPW(999));

					if(!DQR.addons.ss2AddIsLoad && DQR.addons.ss2IsLoad)
					{
						int flg2 = cfg_addons.get("Addon enabler","addon for SextiarySector2", 1 , "0:disable 1:enable").getInt();
						cfg_addons.setCategoryComment("Advanced Settings (TwilightForest with SextiarySector2)", "this setting is TwilightForestAddon with SextiarySector2");
						int flg3 = cfg_addons.get("Advanced Settings (TwilightForest with SextiarySector2)","Figure miss draw fix", 1 , "0:disable 1:enable").getInt();

						if(flg2 > 0 && flg3 > 0)
						{
							System.out.println("adding TwilightForest with SextiarySector2 Addon");

							itemTwilightFigureDummy = new DqmItemTwilightFigureDummy();
							itemTwilightFigureDummy.setMaxStackSize(1).setUnlocalizedName("dqm.itemTwilightFigureDummy").setTextureName("dqr:TwilightFigureDummy").setCreativeTab(CreativeTabs.tabMisc);//.setCreativeTab(DQR.tabs.DqmTabMisc);
							GameRegistry.registerItem(itemTwilightFigureDummy, "ItemTwilightFigureDummy");
							MinecraftForge.EVENT_BUS.register(new SS2drawFixHandler());
						}
					}

					//黄昏に鉱石追加
					Configuration cfg_tasogare = new Configuration(new File(DQR.proxy.getDir(), "config/TwilightForest.cfg"));
					int tf_dimID = cfg_tasogare.get("dimension","dimensionID", 7, "What ID number to assign to the Twilight Forest dimension.  Change if you are having conflicts with another mod.").getInt();
					String tf_folName = "DIM" + tf_dimID;
					boolean serchFlg = false;
					boolean setchAllFlg = false;
					//System.out.println("TEST 1 ");
					for(int cnt = 0; cnt < DQR.conf.cfg_generateOreDimId3.length ;cnt++)
					{
						//System.out.println("TEST 2 :" + cnt + " / " + DQR.conf.cfg_generateOreDimId2[cnt]);
						if(DQR.conf.cfg_generateOreDimId3[cnt] == tf_dimID)
						{
							serchFlg = true;
							setchAllFlg = true;
						}
					}
					if(serchFlg == false)
					{
						//System.out.println("TEST 3");
						DQR.conf.setOre3Settings(tf_dimID, null, null, null);
					}

					//System.out.println("TEST 1 ");
					serchFlg = false;
					//System.out.println("TEST 4");
					for(int cnt = 0; cnt < DQR.conf.cfg_generateOreDimFolder3.length ;cnt++)
					{
						//System.out.println("TEST 5 :" + cnt + " / " + DQR.conf.cfg_generateOreDimFolder2[cnt] + " / " + tf_folName);
						if(DQR.conf.cfg_generateOreDimFolder3[cnt].equalsIgnoreCase(tf_folName))
						{
							//System.out.println("TEST 2 ");
							serchFlg = true;
							setchAllFlg = true;
						}
					}
					if(serchFlg == false)
					{
						DQR.conf.setOre3Settings(9999, tf_folName, null, null);
					}

					//System.out.println("TEST 3 ");
					serchFlg = false;
					for(int cnt = 0; cnt < DQR.conf.cfg_generateOreDimName3.length ;cnt++)
					{
						if(DQR.conf.cfg_generateOreDimName3[cnt].equalsIgnoreCase("TwilightForest"))
						{
							//System.out.println("TEST 4 ");
							serchFlg = true;
							setchAllFlg = true;
						}
					}
					if(serchFlg == false)
					{
						DQR.conf.setOre3Settings(9999, null, "TwilightForest", null);
					}

					if(!setchAllFlg)
					{
						DQR.conf.setOre3Settings(9999, null, null, "stone");
					}
					//System.out.println("TEST????");
					MinecraftForge.EVENT_BUS.register(new TwilightForestHandler());
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
