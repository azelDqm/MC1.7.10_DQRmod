package dqr;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import dqr.api.DQOreDictionary;
import dqr.api.enums.EnumDqmGetter;
import dqr.blocks.BlockTileEntityRegister;
import dqr.blocks.DqBlock;
import dqr.blocks.DqBlockObj;
import dqr.blocks.DqItemBlock;
import dqr.blocks.DqmBlockRenderType;
import dqr.creativeTabs.DqmCreativeTabs;
import dqr.dataTable.FuncArmorSetTable;
import dqr.dataTable.FuncBiomeBlockTable;
import dqr.dataTable.FuncBukiyaPriceTable;
import dqr.dataTable.FuncExpTable;
import dqr.dataTable.FuncItemRandom;
import dqr.dataTable.FuncJobChangeLvTable;
import dqr.dataTable.FuncKaitoriPriceTable;
import dqr.dataTable.FuncMGFarmSeedTable;
import dqr.dataTable.FuncMagicLvTable;
import dqr.dataTable.FuncMedalkingItems;
import dqr.dataTable.FuncMobRandom;
import dqr.dataTable.FuncSyuuriPriceTable;
import dqr.dataTable.FuncWeaponAptitude;
import dqr.entity.npcEntity.NPCRegister;
import dqr.entity.villagerEntity.DqmVillager;
import dqr.enums.DqmDamageSource;
import dqr.enums.DqmEnumCreatureType;
import dqr.enums.DqmEnumToolMaterial;
import dqr.functions.FuncAddGrowthBlock;
import dqr.functions.FuncBugFix;
import dqr.functions.FuncCalcDamage;
import dqr.functions.FuncCalcMobParam;
import dqr.functions.FuncCalcPetStatus;
import dqr.functions.FuncCalcPlayerStatus;
import dqr.functions.FuncCheckBed;
import dqr.functions.FuncCheckCanSpawn;
import dqr.functions.FuncCheckMutation;
import dqr.functions.FuncCommon;
import dqr.functions.FuncDamageMessage;
import dqr.functions.FuncEnchantExtension;
import dqr.functions.FuncEntityRenderExtension;
import dqr.functions.FuncPetOperation;
import dqr.gui.GuiHandler;
import dqr.handler.ChunkEventHandler;
import dqr.handler.CraftingEventHandler;
import dqr.handler.DamagetHandler;
import dqr.handler.EntityEventHandler;
import dqr.handler.LivingDeathHandler;
import dqr.handler.LivingDropHandler;
import dqr.handler.LivingEndoraHandler;
import dqr.handler.LivingEventHandler;
import dqr.handler.MagicEventHandler;
import dqr.handler.PlayerEventHandler;
import dqr.handler.RarihoEventHandler;
import dqr.handler.WorldHandler;
import dqr.items.DqItem;
import dqr.items.DqmItemRecipe;
import dqr.items.DqmItemRecipeBuilder;
import dqr.items.DqmItemRecipeMagic;
import dqr.keyHandler.ClientKeyBindCore;
import dqr.playerData.PlayerDataHandler;
import dqr.potion.DqmPotion;
import dqr.world.DqmStructureRegister;
import dqr.world.DqmVillageRegister;

<<<<<<< HEAD
@Mod(modid = "DQMIIINext", name = "DQRespect", version = "0.8.9", useMetadata = true, dependencies = "after:PotionExtension;after:SextiarySector")
=======
@Mod(modid = "DQMIIINext", name = "DQRespect", version = "0.8.6", useMetadata = true, dependencies = "after:PotionExtension;after:SextiarySector")
>>>>>>> parent of 2aede75... ver0.8.7.8
public class DQR {

	@SidedProxy(clientSide = "dqr.ClientProxy", serverSide = "dqr.CommonProxy")
	public static CommonProxy proxy;

	@Instance("DQMIIINext")
	public static DQR instance;
	public static String modID = "DQMIIINext";
	public static int debug = 1;

	public static FuncCalcMobParam funcMob;
	public static DQRconfigs conf;

	public static FuncCalcPlayerStatus calcPlayerStatus;
	public static FuncCalcPetStatus calcPetStatus;
	public static FuncAddGrowthBlock growth;
	public static FuncDamageMessage damMessage;
	public static FuncCalcDamage calcDamage;
	public static FuncEnchantExtension enchaHook;
	public static FuncCheckCanSpawn checkCanSpawn;
	public static FuncCheckBed checkBed;
	public static FuncBiomeBlockTable BiomeBlock;
	public static FuncCommon func;

	public static FuncExpTable exp;
	public static FuncArmorSetTable armorSetEffect;
	// public static FuncColorTable color;
	public static FuncSyuuriPriceTable syuuriPrice;
	public static FuncKaitoriPriceTable kaitoriPrice;
	public static FuncBukiyaPriceTable bukiyaPrice;
	// public static FuncJobNameTable job;
	public static FuncMagicLvTable magicTable;
	public static FuncJobChangeLvTable jobChangeTable;
	public static FuncMGFarmSeedTable MGSeedTable;
	public static FuncCheckMutation mutationTable;
	public static FuncWeaponAptitude aptitudeTable;
	public static FuncBugFix bugFix;
	public static FuncPetOperation petFunc;

	public static DqmBlockRenderType blockRenderType;
	public static DqmDamageSource damageSource;
	public static DqmEnumToolMaterial dqmMaterial;
	public static DqmEnumCreatureType dqmCreatureType;

	public static EnumDqmGetter enumGetter;

	public static ClientKeyBindCore CLKeyBind;
	public static DqmCreativeTabs tabs;

	/*
	 * public static DqmBlockDecorate decorateBlocks; public static DqmBlockOre
	 * ores; public static DqmBlockSeed seedBlocks; public static
	 * DqmBlockStandard blocks;
	 */
	/*
	 * public static DqmItemWeapons weapons; public static DqmItemArmors armors;
	 * public static DqmItemMiscs miscs; public static DqmItemIngots ingots;
	 * public static DqmItemSeeds seeds; public static DqmItemAccessories accs;
	 * public static DqmItemMagics magics; public static DqmItemEmblem emblem;
	 * public static DqmItemBuilder builder;
	 */

	public static FuncMobRandom randomMob;
	public static FuncItemRandom randomItem;
	public static FuncMedalkingItems medalItem;

	public static String[] dqmLog;

	public static DqmPotion potion;
	public static DqmVillager villager;

	public static FuncEntityRenderExtension entityRenderHook = null;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		PacketHandler.init();
		conf = new DQRconfigs();

		dqmLog = new String[8];
		damageSource = new DqmDamageSource();
		dqmMaterial = new DqmEnumToolMaterial();
		dqmCreatureType = new DqmEnumCreatureType();
		tabs = new DqmCreativeTabs();

		potion = new DqmPotion(conf.PotionIDidx);

		blockRenderType = new DqmBlockRenderType ();

		// ブロック追加
		new BlockTileEntityRegister();
		new DqBlock();
		new DqBlockObj();
		// アイテム追加
		new DqItem();

		new DqItemBlock();

		// アイテム・ブロック登録
		new DqrItemRegister();

		// 鉱石辞書追加
		new DQOreDictionary();
		/*
		 * blocks = new DqmBlockStandard(); decorateBlocks = new
		 * DqmBlockDecorate(); ores = new DqmBlockOre(); seedBlocks = new
		 * DqmBlockSeed();
		 */
		/*
		 * miscs = new DqmItemMiscs(); weapons = new DqmItemWeapons(); armors =
		 * new DqmItemArmors(); accs = new DqmItemAccessories(); ingots = new
		 * DqmItemIngots(); seeds = new DqmItemSeeds(); magics = new
		 * DqmItemMagics(); emblem = new DqmItemEmblem(); builder = new
		 * DqmItemBuilder();
		 */

		for (int cnt = 0; cnt < 8; cnt++) {
			dqmLog[cnt] = "";
		}

		new DqmVillageRegister();
		new NPCRegister();

		proxy.registersItemRender();
		// villager = new DqmVillager();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		instance = this;
		proxy.registers();

		enumGetter = new EnumDqmGetter();
		funcMob = new FuncCalcMobParam();
		calcPlayerStatus = new FuncCalcPlayerStatus();
		calcPetStatus = new FuncCalcPetStatus();
		growth = new FuncAddGrowthBlock();
		exp = new FuncExpTable();
		damMessage = new FuncDamageMessage();


		calcDamage = new FuncCalcDamage();
		armorSetEffect = new FuncArmorSetTable();
		enchaHook = new FuncEnchantExtension();
		checkCanSpawn = new FuncCheckCanSpawn();

		// color = new FuncColorTable();
		// job = new FuncJobNameTable();
		syuuriPrice = new FuncSyuuriPriceTable();
		kaitoriPrice = new FuncKaitoriPriceTable();
		bukiyaPrice = new FuncBukiyaPriceTable();
		magicTable = new FuncMagicLvTable();
		aptitudeTable = new FuncWeaponAptitude();
		jobChangeTable = new FuncJobChangeLvTable();
		MGSeedTable = new FuncMGFarmSeedTable();
		mutationTable = new FuncCheckMutation();
		checkBed = new FuncCheckBed();
		bugFix = new FuncBugFix();
		BiomeBlock = new FuncBiomeBlockTable();
		func = new FuncCommon();
		petFunc = new FuncPetOperation();

		randomMob = new FuncMobRandom();
		randomItem = new FuncItemRandom();
		medalItem = new FuncMedalkingItems();

		/*
		 * EntityRegistry.registerModEntity(EntityMeleeSkeleton.class,
		 * "MeleeSkeleton", 0, this, 250, 1, false);
		 * EntityRegistry.addSpawn(EntityMeleeSkeleton.class, 20, 1, 4,
		 * EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.plains});
		 * if(FMLCommonHandler.instance().getSide() == Side.CLIENT) {
		 * RenderingRegistry
		 * .registerEntityRenderingHandler(EntityMeleeSkeleton.class, new
		 * RenderMeleeSkeleton()); }
		 */
		new DqmItemRecipe();
		new DqmItemRecipeMagic();
		new DqmItemRecipeBuilder();
		MinecraftForge.EVENT_BUS.register(new PlayerDataHandler());
		MinecraftForge.EVENT_BUS.register(new DamagetHandler());
		MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
		MinecraftForge.EVENT_BUS.register(new LivingDropHandler());
		MinecraftForge.EVENT_BUS.register(new LivingEndoraHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
		MinecraftForge.EVENT_BUS.register(new RarihoEventHandler());
		MinecraftForge.EVENT_BUS.register(new MagicEventHandler());
		MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
		MinecraftForge.EVENT_BUS.register(new ChunkEventHandler());
		MinecraftForge.EVENT_BUS.register(new LivingDeathHandler());


//		MinecraftForge.EVENT_BUS.register(new DeathInventoryHandler());

		//MinecraftForge.EVENT_BUS.register(new RenderPlayerHandler());

		FMLCommonHandler.instance().bus().register(new PlayerDataHandler());
		FMLCommonHandler.instance().bus().register(new CraftingEventHandler());

		new DqrFieldGenRegister();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		new DqmStructureRegister();
		MinecraftForge.EVENT_BUS.register(new WorldHandler());

		// new DqmVillager();

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.registerGUI();
	}

}
