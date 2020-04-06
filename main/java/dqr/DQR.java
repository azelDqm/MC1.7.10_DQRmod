package dqr;

import java.util.ArrayList;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.addons.DqrAddon;
import dqr.api.DQOreDictionary;
import dqr.api.enums.EnumDqmGetter;
import dqr.api.potion.DQPotionFunc;
import dqr.blocks.BlockTileEntityRegister;
import dqr.blocks.DqBlock;
import dqr.blocks.DqBlockObj;
import dqr.blocks.DqItemBlock;
import dqr.blocks.DqmBlockRenderType;
import dqr.command.DqrCom;
import dqr.command.DqrComDebug;
import dqr.command.DqrComDebug2;
import dqr.command.DqrComDqredit;
import dqr.command.DqrComParty;
import dqr.command.DqrComPet;
import dqr.creativeTabs.DqmCreativeTabs;
import dqr.dataTable.FuncArmorSetTable;
import dqr.dataTable.FuncBiomeBlockTable;
import dqr.dataTable.FuncBukiyaPriceTable;
import dqr.dataTable.FuncCasinoCoinItems;
import dqr.dataTable.FuncExpTable;
import dqr.dataTable.FuncItemRandom;
import dqr.dataTable.FuncJobChangeLvTable;
import dqr.dataTable.FuncKaitoriPriceTable;
import dqr.dataTable.FuncMGFarmSeedTable;
import dqr.dataTable.FuncMagicLvTable;
import dqr.dataTable.FuncMagicLvTablePet;
import dqr.dataTable.FuncMedalkingItems;
import dqr.dataTable.FuncMobRandom;
import dqr.dataTable.FuncSpecialUseItemTable;
import dqr.dataTable.FuncSyuuriPriceTable;
import dqr.dataTable.FuncWeaponAptitude;
import dqr.dataTable.FuncWeaponBoosterTable;
import dqr.entity.npcEntity.NPCRegister;
import dqr.entity.villagerEntity.DqmVillager;
import dqr.enums.DqmDamageSource;
import dqr.enums.DqmEnumCreatureType;
import dqr.enums.DqmEnumToolMaterial;
import dqr.functions.FuncAddGrowthBlock;
import dqr.functions.FuncAddWoodBlocks;
import dqr.functions.FuncBonusChestExtension;
import dqr.functions.FuncBugFix;
import dqr.functions.FuncCalcDamage;
import dqr.functions.FuncCalcMobParam;
import dqr.functions.FuncCalcPetStatus;
import dqr.functions.FuncCalcPlayerStatus;
import dqr.functions.FuncCheckBed;
import dqr.functions.FuncCheckCanSpawn;
import dqr.functions.FuncCheckMutation;
import dqr.functions.FuncCommon;
import dqr.functions.FuncDQEffect;
import dqr.functions.FuncDamageMessage;
import dqr.functions.FuncEnchantExtension;
import dqr.functions.FuncEnderDragonExtension;
import dqr.functions.FuncEntityLivingExtension;
import dqr.functions.FuncEntityRenderExtension;
import dqr.functions.FuncFarmlandExtension;
import dqr.functions.FuncFishHookExtension;
import dqr.functions.FuncPetOperation;
import dqr.functions.FuncSkillJobSP;
import dqr.gui.GuiHandler;
import dqr.gui.playerHUD.GuiNewLogger;
import dqr.handler.BagSlotClickHandler;
import dqr.handler.ChestGenHandler;
import dqr.handler.ChunkEventHandler;
import dqr.handler.CraftingEventHandler;
import dqr.handler.DamageHandler;
import dqr.handler.DebugHandler;
import dqr.handler.DqrDamageMobEventHandler;
import dqr.handler.EnderDragonHandler;
import dqr.handler.EntityEventHandler;
import dqr.handler.FishHookHandler;
import dqr.handler.LivingDeathHandler;
import dqr.handler.LivingDropHandler;
import dqr.handler.LivingEndoraHandler;
import dqr.handler.LivingEventHandler;
import dqr.handler.MagicEventHandler;
import dqr.handler.PartyEventHandler;
import dqr.handler.PlayerEventHandler;
import dqr.handler.RarihoEventHandler;
import dqr.handler.WorldEventHandler;
import dqr.handler.WorldHandler;
import dqr.items.DqItem;
import dqr.items.DqmItemRecipe;
import dqr.items.DqmItemRecipeAccessory;
import dqr.items.DqmItemRecipeBuilder;
import dqr.items.DqmItemRecipeEtc;
import dqr.items.DqmItemRecipeMagic;
import dqr.keyHandler.ClientKeyBindCore;
import dqr.modules.DqrChunkLoader;
import dqr.modules.IModule;
import dqr.party.DqmPartyManager;
import dqr.playerData.PlayerDataHandler;
import dqr.potion.DqmPotion;
import dqr.world.DqmStructureRegister;
import dqr.world.DqmVillageRegister;

@Mod(modid = "DQMIIINext", name = "DQRespect", version = "0.9.4.8#1", useMetadata = true, dependencies = "after:PotionExtension")
public class DQR {

	@SidedProxy(clientSide = "dqr.ClientProxy", serverSide = "dqr.CommonProxy")
	public static CommonProxy proxy;

	@Instance("DQMIIINext")
	public static DQR instance;
	public static String modID = "DQMIIINext";
	public static int debug = 0; //12 : Lv 全calc  14 : ???
	public static int easyMode = 0;

	public static int jobStatusVersion = 2;
	public static int bugFixFlg0947_8 = 1;

	public static FuncCalcMobParam funcMob;
	public static DQRconfigs conf;
	public static DQRconfigs2 conf2;

	public static int debugSwitch = 0;
	public static FuncCalcPlayerStatus calcPlayerStatus;
	public static FuncCalcPetStatus calcPetStatus;
	public static FuncAddGrowthBlock growth;
	public static FuncAddWoodBlocks cuttingWood;
	public static FuncDamageMessage damMessage;
	public static FuncCalcDamage calcDamage;
	public static FuncEnchantExtension enchaHook;
	public static FuncBonusChestExtension bonuschestHook;
	public static FuncCheckCanSpawn checkCanSpawn;
	public static FuncCheckBed checkBed;
	public static FuncBiomeBlockTable BiomeBlock;
	public static FuncSpecialUseItemTable spUseItems;
	public static FuncWeaponBoosterTable weaponBooster;

	public static FuncCommon func;
	public static DQPotionFunc potionFunc;
	public static DqmPartyManager partyManager;
	public static FuncDQEffect dqEffect;

	public static DqrAddon addons;

	public static FuncExpTable exp;
	public static FuncArmorSetTable armorSetEffect;
	// public static FuncColorTable color;
	public static FuncSyuuriPriceTable syuuriPrice;
	public static FuncKaitoriPriceTable kaitoriPrice;
	public static FuncBukiyaPriceTable bukiyaPrice;
	// public static FuncJobNameTable job;
	public static FuncMagicLvTable magicTable;
	public static FuncMagicLvTablePet magicTablePet;
	public static FuncJobChangeLvTable jobChangeTable;
	public static FuncMGFarmSeedTable MGSeedTable;
	public static FuncCheckMutation mutationTable;
	public static FuncWeaponAptitude aptitudeTable;
	public static FuncBugFix bugFix;
	public static FuncPetOperation petFunc;
	public static FuncSkillJobSP jobSkillSP;

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
	public static FuncCasinoCoinItems casinoItem;

	public static String[] dqmLog;

	public static DqmPotion potion;
	public static DqmVillager villager;

	public static FuncEntityRenderExtension entityRenderHook = null;
	public static FuncFarmlandExtension farmlandHook;
	public static FuncFishHookExtension fishingHookHook;
	public static FuncEnderDragonExtension enderdragonHook;
	public static FuncEntityLivingExtension entityLivingHook;

	public static final ArrayList<IModule> modules = new ArrayList<IModule>();

	//public static SimpleNetworkWrapper networkWrapper;


	@SideOnly(Side.CLIENT)
	public static GuiNewLogger loglog;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		PacketHandler.init();
		conf = new DQRconfigs();
		conf2 = new DQRconfigs2();

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
		if(conf.DqmOreDictionary == 1)
		{
			new DQOreDictionary();
		}
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

		addons = new DqrAddon();
		modules.add(DqrChunkLoader.getInstance());

		/*
		networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(modID);
		networkWrapper.registerMessage(PacketHandlerServer.class, CToSMessage.class, 0, Side.SERVER);
		networkWrapper.registerMessage(PacketHandlerClient.class, SToCMessage.class, 1, Side.CLIENT);
		*/


        for (IModule m : modules) {
            m.preInit(event);
        }
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
		cuttingWood = new FuncAddWoodBlocks();
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
		magicTablePet = new FuncMagicLvTablePet();
		aptitudeTable = new FuncWeaponAptitude();
		jobChangeTable = new FuncJobChangeLvTable();
		MGSeedTable = new FuncMGFarmSeedTable();
		mutationTable = new FuncCheckMutation();
		checkBed = new FuncCheckBed();
		bugFix = new FuncBugFix();
		BiomeBlock = new FuncBiomeBlockTable();
		spUseItems = new FuncSpecialUseItemTable();
		weaponBooster = new FuncWeaponBoosterTable();
		func = new FuncCommon();
		dqEffect = new FuncDQEffect();
		potionFunc = new DQPotionFunc();
		petFunc = new FuncPetOperation();
		jobSkillSP = new FuncSkillJobSP();

		farmlandHook = new FuncFarmlandExtension();
		fishingHookHook = new FuncFishHookExtension();
		enderdragonHook = new FuncEnderDragonExtension();
		bonuschestHook = new FuncBonusChestExtension();
		entityLivingHook = new FuncEntityLivingExtension();


		if(this.conf.partyEnable != 0)
		{
			partyManager = new DqmPartyManager();
		}

		randomMob = new FuncMobRandom();
		randomItem = new FuncItemRandom();
		medalItem = new FuncMedalkingItems();
		casinoItem = new FuncCasinoCoinItems();

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
		new DqmItemRecipeEtc();
		new DqmItemRecipeAccessory();

		MinecraftForge.EVENT_BUS.register(new PlayerDataHandler());
		MinecraftForge.EVENT_BUS.register(new DamageHandler());
		MinecraftForge.EVENT_BUS.register(new LivingEventHandler());
		MinecraftForge.EVENT_BUS.register(new LivingDropHandler());
		MinecraftForge.EVENT_BUS.register(new LivingEndoraHandler());
		MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
		MinecraftForge.EVENT_BUS.register(new RarihoEventHandler());
		MinecraftForge.EVENT_BUS.register(new MagicEventHandler());
		MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
		MinecraftForge.EVENT_BUS.register(new ChunkEventHandler());
		MinecraftForge.EVENT_BUS.register(new LivingDeathHandler());
		MinecraftForge.EVENT_BUS.register(new WorldEventHandler());
		MinecraftForge.EVENT_BUS.register(new FishHookHandler());
		MinecraftForge.EVENT_BUS.register(new EnderDragonHandler());
		MinecraftForge.EVENT_BUS.register(new BagSlotClickHandler());
		MinecraftForge.EVENT_BUS.register(new ChestGenHandler());
		MinecraftForge.EVENT_BUS.register(new DqrDamageMobEventHandler());
		if(debug != 0)
		{
			MinecraftForge.EVENT_BUS.register(new DebugHandler());
		}

		//MinecraftForge.EVENT_BUS.register(new PartyEventHandler());

//		MinecraftForge.EVENT_BUS.register(new DeathInventoryHandler());

		//MinecraftForge.EVENT_BUS.register(new RenderPlayerHandler());

		FMLCommonHandler.instance().bus().register(new PlayerDataHandler());
		FMLCommonHandler.instance().bus().register(new CraftingEventHandler());

		if(this.conf.partyEnable != 0)
		{
			MinecraftForge.EVENT_BUS.register(new PartyEventHandler());
			FMLCommonHandler.instance().bus().register(new PartyEventHandler());
		}

		new DqrFieldGenRegister();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		new DqmStructureRegister();
		MinecraftForge.EVENT_BUS.register(new WorldHandler());

		// new DqmVillager();

        for (IModule m : modules) {
            m.load(event);
        }
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.registerGUI();

		addons.setAddons();

        for (IModule m : modules) {
            m.postInit(event);
        }
		//Loader.instance().activeModContainer().
	}

	@Mod.EventHandler
	public void setver(FMLServerStartingEvent event)
	{
		//StringTranslate.inject(StringTranslate.class.getResourceAsStream("/assets/dqr/lang/ja_JP.lang"));
		if(debug != 0)
		{
			event.registerServerCommand(new DqrComDebug());
			event.registerServerCommand(new DqrComDebug2());

		}
		if(this.conf.partyEnable != 0)
		{
			event.registerServerCommand(new DqrComParty());
		}

		event.registerServerCommand(new DqrComDqredit());
		event.registerServerCommand(new DqrComPet());
		event.registerServerCommand(new DqrCom());
	}

}
