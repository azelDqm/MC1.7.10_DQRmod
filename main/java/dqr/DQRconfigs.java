package dqr;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraftforge.common.config.Configuration;

import org.apache.commons.lang3.math.NumberUtils;

import dqr.api.enums.EnumDqmMagic;

public class DQRconfigs {

	public static int DqmDifficulty = 3;
	public static int DqmEndoraDifficulty = -1;

	public static int VanillaMobSpawn = 10;
	public static int DqmMobSpawn = 120;

    public static int guiPositionMode = 0;
    public static int guiPositionTarget = 0; //(0:無し 1:HP/MP 2:STATUS 3:Armor 4:Log)
    public static int guiPositionSpeed = 1;

	public static int CLGuiVis1 = 1;
	public static int CLGuiPos1 = 5;
	public static int CLGuiPos1X = 0;
	public static int CLGuiPos1Y = 0;
	public static int CLGuiCrisis = 15;
	public static int CLGuiVis2 = 1;
	public static int CLGuiPos2 = 1;
	public static int CLGuiPos2X = 0;
	public static int CLGuiPos2Y = 0;
	public static int CLGuiArmorVis = 1;
	public static int CLGuiArmorPos = 8;
	public static int CLGuiArmorPosX = 0;
	public static int CLGuiArmorPosY = 0;
	public static int CLGuiLogVis = 1;
	public static int CLGuiLogPos = 6;
	public static int CLGuiLogPosX = 0;
	public static int CLGuiLogPosY = 0;

	public static int CLGuiSubpointsVis = 1;
	public static int CLGuiSubpointsPos = 10;
	public static int CLGuiSubpointsPosX = 0;
	public static int CLGuiSubpointsPosY = 0;

	public static int CLGuiBuffBarVis = 1;
	public static int CLGuiBuffBarPos = 6;
	public static int CLGuiBuffBarPosX = 0;
	public static int CLGuiBuffBarPosY = 0;

	public static int GuiID_FarmBook = 0;
	public static int GuiID_JobChange = 1;
	public static int GuiID_MKWeapon = 2;
	public static int GuiID_MKArmor = 3;
	public static int GuiID_MKMagic = 4;
	public static int GuiID_MKMagic2 = 5;
	public static int GuiID_MKJob = 6;
	public static int GuiID_MKMisc = 7;
	public static int GuiID_MKMedal = 8;
	public static int GuiID_PetBook = 9;
	public static int GuiID_SkillWeapon = 10;
	public static int GuiID_PetStatus = 11;
	public static int GuiID_PetInventory = 12;
	public static int GuiID_DqrEnderchest = 13;
	public static int GuiID_ItemBag = 14;
	public static int GuiID_SubEquip = 20;

	public static int CLGuiLogWindowOff = 1;

	public static int PotionIDidx = 40;
	public static int MonsterIDidx = 1000;
	public static int PetMonsterIDidx = 3000;
	public static int NPCIDidx = 2000;
	//public int mce2NPCBankMPId = 5001;
	public static int MagicIDidx = 2500;
	public static int ThrowingIDidx = 2600;

	public static int RuraC_IGF = 1;
	public static int[] RuraC_X = {0, 0, 0, 0, 0};
	public static int[] RuraC_Y = {0, 0, 0, 0, 0};
	public static int[] RuraC_Z = {0, 0, 0, 0, 0};
	public static int[] RuraC_Dim = {0, 0, 0, 0, 0};

	public static int KimeraC_IGF = 1;
	public static int[] KimeraC_X = {0, 0, 0, 0, 0};
	public static int[] KimeraC_Y = {0, 0, 0, 0, 0};
	public static int[] KimeraC_Z = {0, 0, 0, 0, 0};
	public static int[] KimeraC_Dim = {0, 0, 0, 0, 0};

	public static int SpawnRoomRate1 = 0;
	public static int SpawnRoomRate2 = 0;
	public static int SpawnRoomRate3 = 0;

	public static int[] RanalutaStep;

    public static Configuration cfg_core;
    public static Configuration cfg_gui;
    public static Configuration cfg_id;
    public static Configuration cfg_rura;
    public static Configuration cfg_magic;
    public static Configuration cfg_option;
    public static Configuration cfg_magictool;
    public static Configuration cfg_Structure;


    public static int magicSpMegante = 1;
    public static int magicSpHonoo = 0;
    public static int magicSpFubuki = 0;

    public static int magicEpHyado = 1;
    public static int magicEpIo = 1;
    public static int magicEpMera = 1;
    public static int magicEpBagi = 1;
    public static int magicEpDein = 1;
    public static int magicEpUminari = 1;
    public static int magicEpCallMagma = 1;

    //VillagerID
    public static int AddVillagerID = 10;
    public static int LightSpawnStop = 1;

    public static int recalcLvStatus1 = 1;
    public static int recalcMP1 = 1;

    public static int cfg_gen_Genkotu = 1;
    public static String[] cfg_gen_Genkotu_type = new String[]{"0"};
    public static ArrayList<Integer> cfg_gen_Genkotu_a = new ArrayList<Integer>();

    public static int cfg_gen_Tue = 1;
    public static String[] cfg_gen_Tue_type = new String[]{"0:OVERWORLD", "-1:NETHER", "1:THEEND"};
    public static Map<Integer, String> cfg_gen_Tue_Map = new HashMap<>();

    public static int cfg_gen_Tubo = 1;
    public static String[] cfg_gen_Tubo_type = new String[]{"0:OVERWORLD", "-1:NETHER"};
    public static Map<Integer, String> cfg_gen_Tubo_Map = new HashMap<>();

    public static int cfg_gen_Taru = 1;
    public static String[] cfg_gen_Taru_type = new String[]{"0:OVERWORLD", "-1:NETHER"};
    public static Map<Integer, String> cfg_gen_Taru_Map = new HashMap<>();

    public static int cfg_gen_Sword = 1;
    public static String[] cfg_gen_Sword_type = new String[]{"0:OVERWORLD", "-1:NETHER", "1:THEEND"};
    public static Map<Integer, String> cfg_gen_Sword_Map = new HashMap<>();

    public static int cfg_gen_Sword2 = 1;
    public static String[] cfg_gen_Sword2_type = new String[]{"0:OVERWORLD", "-1:NETHER", "1:THEEND"};
    public static Map<Integer, String> cfg_gen_Sword2_Map = new HashMap<>();

    public static int cfg_gen_Sikabane = 1;
    public static String[] cfg_gen_Sikabane_type = new String[]{"0:OVERWORLD", "-1:NETHER", "1:THEEND"};
    public static Map<Integer, String> cfg_gen_Sikabane_Map = new HashMap<>();

    public static int cfg_gen_Hako = 1;
    public static String[] cfg_gen_Hako_type = new String[]{"0:OVERWORLD", "-1:NETHER"};
    public static Map<Integer, String> cfg_gen_Hako_Map = new HashMap<>();

    public static int cfg_gen_Ido = 1;
    public static String[] cfg_gen_Ido_type = new String[]{"0"};
    public static ArrayList<Integer> cfg_gen_Ido_a = new ArrayList<Integer>();

    public static int cfg_gen_Ido2 = 1;
    public static String[] cfg_gen_Ido2_type = new String[]{"0"};
    public static ArrayList<Integer> cfg_gen_Ido2_a = new ArrayList<Integer>();

    public static int cfg_build_sleep = 250;

    public static int cfg_generateOreDimType = 0;
    public static int[] cfg_generateOreDimId = new int[]{0, -5, -6};
    public static String[] cfg_generateOreDimFolder = new String[]{".", "DIM-5", "DIM-6"};
    public static String[] cfg_generateOreDimName = new String[]{"Overworld", "", ""};
    public static String[] cfg_generateOreBlockName = new String[]{"stone","stone","stone"};
    public static Map<Integer, String> cfg_generateOre = new HashMap<>();
    public static Map<String, String> cfg_generateOreS = new HashMap<>();
    public static Map<String, String> cfg_generateOreN = new HashMap<>();


    public static int cfg_generateOreDimType2 = 0;
    public static int[] cfg_generateOreDimId2 = new int[]{-1, -6};
    public static String[] cfg_generateOreDimFolder2 = new String[]{"DIM-1", "DIM-6"};
    public static String[] cfg_generateOreDimName2 = new String[]{"Nether", ""};
    public static String[] cfg_generateOreBlockName2 = new String[]{"netherrack","stone"};;
    public static Map<Integer, String> cfg_generateOre2 = new HashMap<>();
    public static Map<String, String> cfg_generateOre2S = new HashMap<>();
    public static Map<String, String> cfg_generateOre2N = new HashMap<>();


    public static int cfg_generateOverSpawnDimType = 0;
    public static String[] cfg_generateOverSpawnDimFolder = new String[]{".", "DIM-5"};
    public static int[] cfg_generateOverSpawnDimId = new int[]{0, -5};
    public static Map<Integer, String> cfg_generateOverSpawn = new HashMap<>();
    public static Map<String, String> cfg_generateOverSpawnS = new HashMap<>();


    public static int cfg_generateEndSpawnDimType = 0;
    public static String[] cfg_generateEndSpawnDimFolder = new String[]{"DIM1", "DIM-5", "DIM-6"};
    public static int[] cfg_generateEndSpawnDimId = new int[]{1, -5, -6};
    public static Map<Integer, String> cfg_generateEndSpawn = new HashMap<>();
    public static Map<String, String> cfg_generateEndSpawnS = new HashMap<>();

    public static int cfg_generateNetherSpawnDimType = 0;
    public static String[] cfg_generateNetherSpawnDimFolder = new String[]{"DIM-1", "DIM-5", "DIM-6"};
    public static int[] cfg_generateNetherSpawnDimId = new int[]{-1, -5, -6};
    public static Map<Integer, String> cfg_generateNetherSpawn = new HashMap<>();
    public static Map<String, String> cfg_generateNetherSpawnS = new HashMap<>();

    public static int permBuilder1 = 2;
    public static int permBuilder2 = 2;
    public static int permBuilder3 = 2;
    public static int permBuilder4 = 2;
    public static int needBuilderFrame1 = 1;
    public static int needBuilderFrame2 = 1;
    public static int needBuilderFrame3 = 1;
    public static int needBuilderFrame4 = 1;

    public static float figureMagni = 5;

    public static int MGFarm_enable = 1;
    public static int[] MGFarm_Area_X = new int[]{1, 3, 5, 7, 9, 1, 3, 5, 1, 3, 5};
    public static int[] MGFarm_Area_Y = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    public static int[] MGFarm_Area_Z = new int[]{1, 3, 5, 7, 9, 10, 10, 10, 30, 30, 30};

    public static int MGBreak1_enable = 3;
    public static int MGBreak1_SmoothBreak = 1;
    public static int[] MGBreak1_Area_X = new int[]{1, 3, 5, 7, 9, 1, 3, 3, 1, 3, 1};
    public static int[] MGBreak1_Area_Y = new int[]{1, 3, 5, 7, 9, 3, 3, 3, 3, 3, 1};
    public static int[] MGBreak1_Area_Z = new int[]{1, 3, 5, 7, 9, 3, 5, 10, 20, 30, 100};

    public static int MGBreak2_enable = 3;
    public static int MGBreak2_SmoothBreak = 1;
    public static int[] MGBreak2_Area_X = new int[]{1, 3, 5, 7, 9, 1, 3, 3, 1, 3, 1};
    public static int[] MGBreak2_Area_Y = new int[]{1, 3, 5, 7, 9, 3, 3, 3, 3, 3, 1};
    public static int[] MGBreak2_Area_Z = new int[]{1, 3, 5, 7, 9, 3, 5, 10, 20, 30, 100};

    public static int MGSet_enable = 1;
    public static int[] MGSet_Area_X = new int[]{1, 3, 3, 5, 5, 9, 11, 13, 15, 17, 1};
    public static int[] MGSet_Area_Y = new int[]{1, 3, 3, 5, 10, 9, 11, 13, 15, 17, 1};
    public static int[] MGSet_Area_Z = new int[]{1, 3, 10, 5, 5, 9, 11, 13, 15, 17, 100};

    public static int MGSet_rejectTileEntity = 1;
    public static String[] cfg_MGSetRejectBlocks = new String[]
    		{
    			"minecraft:netherrack",
    			"minecraft:end_stone"
    		};

    public static int[] cfg_biomeBlock_biomeId = new int[]{8, 9, 113, 114, 115, 116, 117};
    public static String[] cfg_biomeBlock_blockName = new String[]
    		{
    			"minecraft:netherrack",
    			"minecraft:end_stone",
    			"minecraft:netherrack",
    			"minecraft:netherrack",
    			"minecraft:netherrack",
    			"minecraft:netherrack",
    			"minecraft:netherrack"
    		};

    public static String[] MGFarm_addSeeds = new String[]
    		{
		    	"SextiarySector:IronPlate",
				"SextiarySector:BlockTurnip",
				"SextiarySector:BlockShiitake",
				"SextiarySector:BlockCucumber",
				"SextiarySector:BlockRice",
				"SextiarySector:BlockOnion",
				"SextiarySector:BlockTomato",
				"SextiarySector:BlockCorn",
				"SextiarySector:BlockEggplant",
				"SextiarySector:BlockSweetPotato",
				"SextiarySector:BlockGreenPepper",
				"SextiarySector:BlockRadish",
				"mod_ecru_MapleTree:tomatoSeed",
				"mod_ecru_MapleTree:eggplantSeed",
				"mod_ecru_MapleTree:onionSeed",
				"mod_ecru_MapleTree:AzukiBeans",
				"mod_ecru_MapleTree:cabbageSeeds",
				"mod_ecru_MapleTree:SunFlowerSeed",
				"mod_ecru_MapleTree:japaneseRadishSeeds",
				"DCsAppleMilk:defeatedcrow.seedMint"
    		};
    public static String[] MGFarm_addPlantMeta = new String[]
    		{
		    	"SextiarySector:BlockTurnip/3",
		    	"SextiarySector:BlockShiitake/3",
		    	"SextiarySector:BlockCucumber/3",
		    	"SextiarySector:BlockRice/3",
		    	"SextiarySector:BlockOnion/3",
		    	"SextiarySector:BlockTomato/3",
		    	"SextiarySector:BlockCorn/3",
		    	"SextiarySector:BlockEggplant/3",
		    	"SextiarySector:BlockSweetPotato/3",
		    	"SextiarySector:BlockGreenPepper/3",
		    	"SextiarySector:BlockRadish/3",
		    	"mod_ecru_MapleTree:ecru_BlockTomato/7",
		    	"mod_ecru_MapleTree:ecru_BlockEggplant/7",
		    	"mod_ecru_MapleTree:ecru_BlockOnion/7",
		    	"mod_ecru_MapleTree:ecru_BlockCropsAzuki/7",
		    	"mod_ecru_MapleTree:ecru_BlockCropsCabbag/7",
		    	"mod_ecru_MapleTree:ecru_BlockCropsJapaneseRadish/7",
		    	"DCsAppleMilk:defeatedcrow.cropMint/3"
    		};


    public static int CuttingWoodRadius = 5;
    public static int CuttingLeaveRadius = 5;
    public static int CuttingWoodHeight = 25;
    public static int CuttingLeaveHeight = 25;
    public static int CuttingWoodUnder = 1;
    public static int CuttingLeaveUnder = 1;

    public static int CuttingSmoothBreak = 1;

    public static String[] CuttingWood = new String[]
    		{
		    	"mod_ecru_MapleTree:ecru_BlockMapleWood",
		    	"mod_ecru_MapleTree:ecru_BlockMapleWoodSyrup",
		    	"mod_ecru_MapleTree:PersimmonWood",
		    	"mod_ecru_MapleTree:AllspiceWood",
		    	"mod_ecru_MapleTree:CloveWood",
		    	"mod_ecru_MapleTree:CinnamonWood",
		    	"mod_ecru_MapleTree:Star_aniseWood",
		    	"mod_ecru_MapleTree:NutmegWood",
		    	"DCsAppleMilk:defeatedcrow.logYuzu",
		    	"BambooMod:sakuraLog",
		    	"BiomesOPlenty:logs1",
		    	"BiomesOPlenty:logs2",
		    	"BiomesOPlenty:logs3",
		    	"BiomesOPlenty:logs4"
    		};

    public static String[] CuttingLeave = new String[]
    		{
		    	"BiomesOPlenty:appleLeaves",
		    	"BiomesOPlenty:persimmonLeaves",
		    	"BiomesOPlenty:leaves1",
		    	"BiomesOPlenty:leaves2",
		    	"BiomesOPlenty:leaves3",
		    	"BiomesOPlenty:leaves4",
		    	"BiomesOPlenty:colorizedLeaves1",
		    	"BiomesOPlenty:colorizedLeaves2",
		    	"mod_ecru_MapleTree:ecru_BlockMapleLeaves",
		    	"mod_ecru_MapleTree:PersimmonLeaves",
		    	"mod_ecru_MapleTree:AllSpiceLeaves",
		    	"mod_ecru_MapleTree:CloveLeaves",
		    	"mod_ecru_MapleTree:CinnamonLeaves",
		    	"mod_ecru_MapleTree:Star_aniseLeaves",
		    	"mod_ecru_MapleTree:NutmegLeaves",
		    	"BambooMod:sakuraLeaves",
		    	"DCsAppleMilk:defeatedcrow.leavesYuzu"
    		};

    public static int petLimit = 20;
    public static int petLimitPlayer = 0;
    public static double petChanceFix = 1.0;

    public static int petPermGivePlantFoods = 1;
    public static int petPermGiveETCFoods = 1;
    public static int petPermGiveExpItems = 1;
    public static int petPermRevive = 1;
    public static int petPermUseMagicRoll = 2;
    public static int petPermUseEraser = 2;
    public static int petPermRewriteOwner = 2;
    public static int petPermPetSitting = 2;
    public static int petPermOpenInventory = 0;

    public static int permUseBakudanisi = 2;
    public static int permUseShinkanoHiseki = 2;

    public static int damageDigits = 0;

    public static int offDeadPetSound = 0;
    public static int offMobNotEnoughMP = 0;

    public static String cfgVersion = "1.0.0";
    public static boolean readFlg1 = false;

    public DQRconfigs()
	{
        cfg_core = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext_Core.cfg"));
        cfg_gui = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext/DQMIIINext_GUI.cfg"));
        cfg_rura = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext/DQMIIINext_Rura.cfg"));
        cfg_magic = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext/DQMIIINext_Magic.cfg"));
        cfg_id = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext/DQMIIINext_ID.cfg"));
        cfg_option = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext/DQMIIINext_Option.cfg"));
        cfg_magictool = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext/DQMIIINext_MagicTool.cfg"));
        cfg_Structure = new Configuration(new File(DQR.proxy.getDir(), "config/DQMIIINext/DQMIIINext_Structure.cfg"));
        //cfg_Dim = new Configuration(new File(DQR.proxy.getDir(), "config/DQRⅢNext/DQRⅢNext_Dimension.cfg"));

        getConfigCore(cfg_core);
        getConfigGui(cfg_gui);
        getConfigId(cfg_id);
        getConfigRura(cfg_rura);
        getConfigMagic(cfg_magic);
        getConfigOption(cfg_option);
        getConfigMagicTool(cfg_magictool);
        getConfigStructure(cfg_Structure);

	}

	public void getConfigStructure(Configuration config)
	{
		config.load();

		config.setCategoryComment("World gen objects", "this setting is object generate at field settings.");

		cfg_gen_Genkotu = config.get("World gen objects","generate GENKOTUDAKE", cfg_gen_Genkotu , "0:disable 1:enable").getInt();
		cfg_gen_Genkotu_type = config.get("World gen objects","generate GENKOTUDAKE_Prop", cfg_gen_Genkotu_type , "Generate dimensionID").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Genkotu_type.length; cnt++)
		{
			if(NumberUtils.isNumber(cfg_gen_Genkotu_type[cnt]))
			{
				cfg_gen_Genkotu_a.add(Integer.parseInt(cfg_gen_Genkotu_type[cnt]));
			}
		}
		//nbrtbjru

		cfg_gen_Tue = config.get("World gen objects","generate TUEobject", cfg_gen_Tue , "0:disable 1:enable").getInt();
		cfg_gen_Tue_type = config.get("World gen objects","generate TUEobject_Prop", cfg_gen_Tue_type , "Generate dimension and Type set( <dimensionID>:<TYPE> ). type is'OVERWORLD','NETHER','THEEND'").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Tue_type.length; cnt++)
		{
			String[] divType = cfg_gen_Tue_type[cnt].replace(" ", "").split(":");

			if(NumberUtils.isNumber(divType[0]) && divType.length > 1)
			{
				cfg_gen_Tue_Map.put(Integer.parseInt(divType[0]), divType[1]);
			}
		}

		cfg_gen_Tubo = config.get("World gen objects","generate TUBOobject", cfg_gen_Tubo , "0:disable 1:enable").getInt();
		cfg_gen_Tubo_type = config.get("World gen objects","generate TUBOobject_Prop", cfg_gen_Tubo_type , "Generate dimension and Type set( <dimensionID>:<TYPE> ). type is'OVERWORLD','NETHER','THEEND'").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Tubo_type.length; cnt++)
		{
			String[] divType = cfg_gen_Tubo_type[cnt].replace(" ", "").split(":");

			if(NumberUtils.isNumber(divType[0]) && divType.length > 1)
			{
				cfg_gen_Tubo_Map.put(Integer.parseInt(divType[0]), divType[1]);
			}
		}

		cfg_gen_Taru = config.get("World gen objects","generate TARUobject", cfg_gen_Taru , "0:disable 1:enable").getInt();
		cfg_gen_Taru_type = config.get("World gen objects","generate TARUobject_Prop", cfg_gen_Taru_type , "Generate dimension and Type set( <dimensionID>:<TYPE> ). type is'OVERWORLD','NETHER','THEEND'").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Taru_type.length; cnt++)
		{
			String[] divType = cfg_gen_Taru_type[cnt].replace(" ", "").split(":");

			if(NumberUtils.isNumber(divType[0]) && divType.length > 1)
			{
				cfg_gen_Taru_Map.put(Integer.parseInt(divType[0]), divType[1]);
			}
		}

		cfg_gen_Sword = config.get("World gen objects","generate SWORDobject", cfg_gen_Sword , "0:disable 1:enable").getInt();
		cfg_gen_Sword_type = config.get("World gen objects","generate SWORDobject_Prop", cfg_gen_Tubo_type , "Generate dimension and Type set( <dimensionID>:<TYPE> ). type is'OVERWORLD','NETHER','THEEND'").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Sword_type.length; cnt++)
		{
			String[] divType = cfg_gen_Sword_type[cnt].replace(" ", "").split(":");

			if(NumberUtils.isNumber(divType[0]) && divType.length > 1)
			{
				cfg_gen_Sword_Map.put(Integer.parseInt(divType[0]), divType[1]);
			}
		}

		cfg_gen_Sword2 = config.get("World gen objects","generate SWORD2object", cfg_gen_Sword2 , "0:disable 1:enable").getInt();
		cfg_gen_Sword2_type = config.get("World gen objects","generate SWORD2object_Prop", cfg_gen_Sword2_type , "Generate dimension and Type set( <dimensionID>:<TYPE> ). type is'OVERWORLD','NETHER','THEEND'").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Sword2_type.length; cnt++)
		{
			String[] divType = cfg_gen_Sword2_type[cnt].replace(" ", "").split(":");

			if(NumberUtils.isNumber(divType[0]) && divType.length > 1)
			{
				cfg_gen_Sword2_Map.put(Integer.parseInt(divType[0]), divType[1]);
			}
		}

		cfg_gen_Sikabane = config.get("World gen objects","generate SIKABANEobject", cfg_gen_Sikabane , "0:disable 1:enable").getInt();
		cfg_gen_Sikabane_type = config.get("World gen objects","generate SIKABANEobject_Prop", cfg_gen_Sikabane_type , "Generate dimension and Type set( <dimensionID>:<TYPE> ). type is'OVERWORLD','NETHER','THEEND'").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Sikabane_type.length; cnt++)
		{
			String[] divType = cfg_gen_Sikabane_type[cnt].replace(" ", "").split(":");

			if(NumberUtils.isNumber(divType[0]) && divType.length > 1)
			{
				cfg_gen_Sikabane_Map.put(Integer.parseInt(divType[0]), divType[1]);
			}
		}

		cfg_gen_Hako = config.get("World gen objects","generate HAKOobject", cfg_gen_Hako , "0:disable 1:enable").getInt();
		cfg_gen_Hako_type = config.get("World gen objects","generate HAKOobject_Prop", cfg_gen_Hako_type , "Generate dimension and Type set( <dimensionID>:<TYPE> ). type is'OVERWORLD','NETHER','THEEND'").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Hako_type.length; cnt++)
		{
			String[] divType = cfg_gen_Hako_type[cnt].replace(" ", "").split(":");

			if(NumberUtils.isNumber(divType[0]) && divType.length > 1)
			{
				cfg_gen_Hako_Map.put(Integer.parseInt(divType[0]), divType[1]);
			}
		}

		cfg_gen_Ido = config.get("World gen objects","generate IDOobject", cfg_gen_Ido , "0:disable 1:enable").getInt();
		cfg_gen_Ido_type = config.get("World gen objects","generate IDOobject_Prop", cfg_gen_Ido_type , "Generate dimensionID").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Ido_type.length; cnt++)
		{
			if(NumberUtils.isNumber(cfg_gen_Ido_type[cnt]))
			{
				cfg_gen_Ido_a.add(Integer.parseInt(cfg_gen_Ido_type[cnt]));
			}
		}

		cfg_gen_Ido2 = config.get("World gen objects","generate HOME of MEDAL KING and entrance", cfg_gen_Ido2 , "0:disable 1:enable").getInt();
		cfg_gen_Ido2_type = config.get("World gen objects","generate HOME of MEDAL KING and entrance_Prop", cfg_gen_Ido2_type , "Generate dimensionID").getStringList();
		for(int cnt = 0; cnt < cfg_gen_Ido2_type.length; cnt++)
		{
			if(NumberUtils.isNumber(cfg_gen_Ido2_type[cnt]))
			{
				cfg_gen_Ido2_a.add(Integer.parseInt(cfg_gen_Ido2_type[cnt]));
			}
		}
		config.save();

		//config.setCategoryComment("MagicTool_Farm settings", "");
	}

	public void getConfigMagicTool(Configuration config)
	{
		config.load();
		config.setCategoryComment("MagicTool_Farm settings", "");
		MGFarm_enable = config.get("MagicTool_Farm settings","item enable", MGFarm_enable , "0:disable 1:enable").getInt();
		MGFarm_Area_X = config.get("MagicTool_Farm settings","Function area X", MGFarm_Area_X , "Any function area X pattern").getIntList();
		MGFarm_Area_Y = config.get("MagicTool_Farm settings","Function area Y", MGFarm_Area_Y , "Any function area Y pattern").getIntList();
		MGFarm_Area_Z = config.get("MagicTool_Farm settings","Function area Z", MGFarm_Area_Z , "Any function area Z pattern").getIntList();

		MGFarm_addSeeds  = config.get("MagicTool_Farm settings","Add seeds", MGFarm_addSeeds , "add seeds (write format  modName:itemname(1line 1item)   ex.  DQMIIINext:ItemOugonSeed2)").getStringList();
		MGFarm_addPlantMeta  = config.get("MagicTool_Farm settings","set max meta for plants", MGFarm_addPlantMeta , "set max meta value for MagicTool_Farm2 (write format  modName:blockName/maxmeta(1line 1item)   ex.  DQMIIINext:blockOugonSeed2/7)").getStringList();

		config.setCategoryComment("MagicTool_Break1 settings", "");
		MGBreak1_enable = config.get("MagicTool_Break1 settings","item enable", MGBreak1_enable , "0:disable 1:BreakOnly 2:DeleteOnly 3:Both").getInt();
		MGBreak1_SmoothBreak = config.get("MagicTool_Break1 settings","Smooth break", MGBreak1_SmoothBreak , "0:disable 1:enable").getInt();
		MGBreak1_Area_X = config.get("MagicTool_Break1 settings","Function area X", MGBreak1_Area_X , "Any function area X pattern").getIntList();
		MGBreak1_Area_Y = config.get("MagicTool_Break1 settings","Function area Y", MGBreak1_Area_Y , "Any function area Y pattern").getIntList();
		MGBreak1_Area_Z = config.get("MagicTool_Break1 settings","Function area Z", MGBreak1_Area_Z , "Any function area Z pattern").getIntList();

		config.setCategoryComment("MagicTool_Break2 settings", "");
		MGBreak2_enable = config.get("MagicTool_Break2 settings","item enable", MGBreak2_enable , "0:disable 1:BreakOnly 2:DeleteOnly 3:Both").getInt();
		MGBreak2_SmoothBreak = config.get("MagicTool_Break2 settings","Smooth break", MGBreak2_SmoothBreak , "0:disable 1:enable").getInt();
		MGBreak2_Area_X = config.get("MagicTool_Break2 settings","Function area X", MGBreak2_Area_X , "Any function area X pattern").getIntList();
		MGBreak2_Area_Y = config.get("MagicTool_Break2 settings","Function area Y", MGBreak2_Area_Y , "Any function area Y pattern").getIntList();
		MGBreak2_Area_Z = config.get("MagicTool_Break2 settings","Function area Z", MGBreak2_Area_Z , "Any function area Z pattern").getIntList();

		config.setCategoryComment("MagicTool_Set settings", "");
		MGSet_enable = config.get("MagicTool_Set settings","item enable", MGSet_enable , "0:disable 1:enable").getInt();
		MGSet_Area_X = config.get("MagicTool_Set settings","Function area X", MGSet_Area_X , "Any function area X pattern").getIntList();
		MGSet_Area_Y = config.get("MagicTool_Set settings","Function area Y", MGSet_Area_Y , "Any function area Y pattern").getIntList();
		MGSet_Area_Z = config.get("MagicTool_Set settings","Function area Z", MGSet_Area_Z , "Any function area Z pattern").getIntList();

		config.setCategoryComment("Destruction of woods settings for DqrAxe", "");
		CuttingWood  = config.get("Destruction of woods settings for DqrAxe","Add woods", CuttingWood , "add woods (write format  modName:woodblockname(1line 1item)   ex.  hogehoget:hogelog1)").getStringList();
		CuttingLeave  = config.get("Destruction of woods settings for DqrAxe","Add leaves", CuttingLeave , "add leaves (write format  modName:leaveblockname(1line 1item)   ex.  hogehoget:hogeleave1)").getStringList();

		CuttingWoodRadius = config.get("Destruction of woods settings for DqrAxe","Radius setting of Scanning woods", CuttingWoodRadius).getInt();
		CuttingLeaveRadius = config.get("Destruction of woods settings for DqrAxe","Radius setting of Scanning leaves", CuttingLeaveRadius).getInt();

		CuttingWoodHeight = config.get("Destruction of woods settings for DqrAxe","Height setting of Scanning woods", CuttingWoodHeight).getInt();
		CuttingLeaveHeight = config.get("Destruction of woods settings for DqrAxe","Height setting of Scanning leaves", CuttingLeaveHeight).getInt();

		CuttingWoodUnder = config.get("Destruction of woods settings for DqrAxe","Plant roots(under) setting of Scanning woods", CuttingWoodUnder).getInt();
		CuttingLeaveUnder = config.get("Destruction of woods settings for DqrAxe","Plant roots(under) setting of Scanning leaves", CuttingLeaveUnder).getInt();

		CuttingSmoothBreak = config.get("Destruction of woods settings for DqrAxe","Smooth break", CuttingSmoothBreak , "0:disable 1:enable").getInt();
		config.save();
	}

	public void getConfigOption(Configuration config)
	{
		config.load();

		config.setCategoryComment("Silent settings", "this setting is stop the sound");
		offDeadPetSound = config.get("Silent settings","Dead pet sound(0:sound OFF 1:sound ON)", offDeadPetSound).getInt();
		offMobNotEnoughMP = config.get("Silent settings","monster miss magic sound (0:sound OFF 1:sound ON)", offMobNotEnoughMP).getInt();

		config.setCategoryComment("Monstar taming limit settings", "this setting is Max number of taming pets");
		petLimit = config.get("Monstar taming limit settings","Max number of taming pets limit", petLimit).getInt();
		petLimitPlayer = config.get("Monstar taming limit settings","Limit players", petLimitPlayer, "limit target Players (0:prohibit 1:limit without OP 2:limit for all players)").getInt();
		petChanceFix = config.get("Monstar taming limit settings","Taming chance Modifier", petChanceFix, "Taming chance minus magnification(0.0:Taming disable or 1.0-unlimited  [DefaultChance% / value])").getDouble();

		config.setCategoryComment("Monstar taming permission settings", "this setting is permissions of taming pets operation");
		petPermGivePlantFoods = config.get("Monstar taming permission settings","Give plant foods (0:allow only owner 1:allow for all player 2:allow owner and OP)", petPermGivePlantFoods).getInt();
		petPermGiveETCFoods = config.get("Monstar taming permission settings","Give ETC foods (0:allow only owner 1:allow for all player 2:allow owner and OP)", petPermGiveETCFoods).getInt();
		petPermGiveExpItems = config.get("Monstar taming permission settings","Give Exp items (0:allow only owner 1:allow for all player 2:allow owner and OP)", petPermGiveExpItems).getInt();
		petPermRevive = config.get("Monstar taming permission settings","Petrevive (0:allow only owner 1:allow for all player 2:allow owner and OP)", petPermRevive).getInt();
		petPermUseEraser = config.get("Monstar taming permission settings","Use eraser items (0:allow only owner 1:allow for all player 2:allow owner and OP)", petPermUseEraser).getInt();
		petPermRewriteOwner = config.get("Monstar taming permission settings","pet owner rewrite when pet wake (0:allow only owner 1:allow for all player 2:allow owner and OP)", petPermRewriteOwner).getInt();
		petPermUseMagicRoll = config.get("Monstar taming permission settings","Use magic roll item(0:allow only owner 1:allow for all player 2:allow owner and OP)", petPermUseMagicRoll).getInt();
		petPermPetSitting = config.get("Monstar taming permission settings","Pet sitting (0:allow only owner 1:allow for all player 2:allow owner and OP)", petPermPetSitting).getInt();
		petPermOpenInventory = config.get("Monstar taming permission settings","Pet inventorty open (0:allow only owner 2:allow owner and OP)", petPermOpenInventory).getInt();

		config.setCategoryComment("Item use permission", "this setting is Item using permission");
		permBuilder1 = config.get("Item use permission","BuilderDama", permBuilder1, "allow use BuilderDama (0:prohibit 1:allow only OP 2:allow for all player)").getInt();
		permBuilder2 = config.get("Item use permission","BuilderDamaS", permBuilder2, "allow use BuilderDamaS (0:prohibit 1:allow only OP 2:allow for all player)").getInt();
		permBuilder3 = config.get("Item use permission","BuilderDamaW", permBuilder3, "allow use BuilderDamaW (0:prohibit 1:allow only OP 2:allow for all player)").getInt();
		permBuilder4 = config.get("Item use permission","BuilderIdoMedal", permBuilder4, "allow use BuilderIdoMedal (0:prohibit 1:allow only OP 2:allow for all player)").getInt();

		permUseBakudanisi = config.get("Item use permission","Bakudanisi", permUseBakudanisi, "allow use Bakudanisi (0:prohibit 1:allow only OP 2:allow for all player)").getInt();
		permUseShinkanoHiseki = config.get("Item use permission","ShinkanoHiseki", permUseShinkanoHiseki, "allow use ShinkanoHiseki (0:prohibit 1:allow only OP 2:allow for all player)").getInt();

		needBuilderFrame1 = config.get("BuilderDama use condition","BuilderDama", needBuilderFrame1, "Use BuilderDama required builder frame(0:false 1:true)").getInt();
		needBuilderFrame2 = config.get("BuilderDama use condition","BuilderDamaS", needBuilderFrame2, "Use BuilderDamaS required builder frame(0:false 1:true)").getInt();
		needBuilderFrame3 = config.get("BuilderDama use condition","BuilderDamaW", needBuilderFrame3, "Use BuilderDamaW required builder frame(0:false 1:true)").getInt();
		needBuilderFrame4 = config.get("BuilderDama use condition","BuilderIdoMedal", needBuilderFrame4, "Use BuilderIdoMedal required builder frame(0:false 1:true)").getInt();

		config.setCategoryComment("Model render size", "this setting is Model render magnification");
		figureMagni = (float)(config.get("Model render size","figure size", 3, "figure size = objSize / thisVal").getInt());
		config.save();
	}

	public void getConfigCore(Configuration config)
	{
		config.load();

		cfgVersion = config.get("_Configure version", "version", cfgVersion).getString();
		if(cfgVersion.equalsIgnoreCase("1.0.0"))
		{
			cfgVersion = "1.1.0";
			readFlg1 = true;
			config.get("_Configure version", "version", cfgVersion).set(cfgVersion);
		}

		config.setCategoryComment("Core Settings", "this setting is Game main settings");
		DqmDifficulty = config.get("Core Settings","Difficulty", DqmDifficulty ,"0:UltraEasy 1:VeryEasy 2:Easy 3:Normal 4:Hard 5:VeryHard 6:UltraHard").getInt();
		DqmEndoraDifficulty = config.get("Core Settings","EndoraDifficulty", DqmEndoraDifficulty ,"set difficulty for EnderDragon(0-6). if set -1 then same as Core Settings.Difficulty").getInt();
		cfg_build_sleep = config.get("Core Settings","Build waiting time", cfg_build_sleep ,"setting interval time(msec) for feature building").getInt();

		config.setCategoryComment("SpawnerRoomGenerateRate", "this setting is SpawnerRoom generate Rating Val ");
		SpawnRoomRate1 = config.get("SpawnerRoomGenerateRate","Overworld value", SpawnRoomRate1 ,"default = 1 / (512) - 0[settingVal]").getInt();
		SpawnRoomRate2 = config.get("SpawnerRoomGenerateRate","Nether value", SpawnRoomRate2 ,"default = 1 / (256) - 0[settingVal]").getInt();
		SpawnRoomRate3 = config.get("SpawnerRoomGenerateRate","End value", SpawnRoomRate3 ,"default = 1 / (128) - 0[settingVal]").getInt();

		config.setCategoryComment("Monster Spawn", "this setting is monster spawn rate settings");
		VanillaMobSpawn = config.get("Monster Spawn","Vanilla Monsters", VanillaMobSpawn ).getInt();
		DqmMobSpawn = config.get("Monster Spawn","DQR Monsters", DqmMobSpawn).getInt();
		LightSpawnStop = config.get("Monster Spawn","Stop spawn cause Light", LightSpawnStop , "0:disable 1:enable").getInt();


		config.setCategoryComment("Monster magicSpecialEffect Settings", "this setting is monster magic with effect enables");
		magicSpMegante = config.get("Monster magicSpecialEffect Settings","Megante with world break", magicSpMegante , "0:disable 1:enable").getInt();
		magicSpHonoo = config.get("Monster magicSpecialEffect Settings","Frame with set fire", magicSpHonoo , "0:disable 1:enable").getInt();
		magicSpFubuki = config.get("Monster magicSpecialEffect Settings","Blizzard with frozing water", magicSpFubuki , "0:disable 1:enable").getInt();

		config.setCategoryComment("Player magicSpecialEffect Settings", "this setting is player magic with effect enables");
		magicEpHyado = config.get("Player magicSpecialEffect Settings","Hyado with frozing water", magicEpHyado , "0:disable 1:enable").getInt();
		magicEpIo = config.get("Player magicSpecialEffect Settings","Io with world break", magicEpIo , "0:disable 1:enable").getInt();
		magicEpMera = config.get("Player magicSpecialEffect Settings","Mera with set fire", magicEpMera , "0:disable 1:enable").getInt();
		magicEpBagi = config.get("Player magicSpecialEffect Settings","Bagi with leaves break", magicEpBagi , "0:disable 1:enable").getInt();
		magicEpDein = config.get("Player magicSpecialEffect Settings","Dein with thunder", magicEpDein , "0:disable 1:enable").getInt();
		magicEpCallMagma = config.get("Player magicSpecialEffect Settings","Call magma with water blocking", magicEpCallMagma , "0:disable 1:enable").getInt();
		magicEpUminari = config.get("Player magicSpecialEffect Settings","Uminari with magma blocking", magicEpUminari , "0:disable 1:enable").getInt();

		config.setCategoryComment("Status recaluc", "this setting is status recaluculations cause bug");
		recalcLvStatus1 = config.get("Status recaluc","cause over Lv99", recalcLvStatus1 , "0:disable 1:enable").getInt();
		recalcMP1 = config.get("Status recaluc","cause MP reset bug v0.8.0", recalcMP1 , "0:disable 1:enable").getInt();



		config.setCategoryComment("Biome base blocks", "this setting is Blockname for BiomeId. BiomeID and Blockname to PAIR");
		cfg_biomeBlock_biomeId = config.get("Biome base blocks","BiomeID", cfg_biomeBlock_biomeId).getIntList();
		cfg_biomeBlock_blockName = config.get("Biome base blocks1","BlockName", cfg_biomeBlock_blockName).getStringList();


		config.setCategoryComment("World gen Ores1", "this setting is generate normal ores. (DimensionID or WorldFolderName) and Blockname have to PAIR");
		cfg_generateOreDimType = config.get("World gen Ores1","DimensionGetType", cfg_generateOreDimType, "Dimension get type (0:DimensionID 1:WorldFolderName 2:DimensionName)").getInt();
		cfg_generateOreDimFolder = config.get("World gen Ores1","WorldFolderName", cfg_generateOreDimFolder, "This setting use DimensionGetType=1").getStringList();
		cfg_generateOreDimName = config.get("World gen Ores1","WorldDimensionName", cfg_generateOreDimName, "This setting use DimensionGetType=2").getStringList();
		cfg_generateOreDimId = config.get("World gen Ores1","DimensionID", cfg_generateOreDimId, "This setting use DimensionGetType=0").getIntList();
		cfg_generateOreBlockName = config.get("World gen Ores1","BlockName", cfg_generateOreBlockName ).getStringList();

		if(cfg_generateOreDimType == 0)
		{
			for(int cnt = 0; cnt < cfg_generateOreDimId.length; cnt++)
			{
				if(cfg_generateOreBlockName != null &&
				   cfg_generateOreBlockName.length >= cnt &&
				   cfg_generateOreBlockName[cnt] != null &&
				   !cfg_generateOreBlockName[cnt].equalsIgnoreCase(""))
				{
					cfg_generateOre.put(cfg_generateOreDimId[cnt], cfg_generateOreBlockName[cnt]);
				}else
				{
					cfg_generateOre.put(cfg_generateOreDimId[cnt], "stone");
				}
			}
		}else if(cfg_generateOreDimType == 1)
		{
			for(int cnt = 0; cnt < cfg_generateOreDimFolder.length; cnt++)
			{
				String folderName = cfg_generateOreDimFolder[cnt].equalsIgnoreCase(".") ? null : cfg_generateOreDimFolder[cnt];

				if(cfg_generateOreBlockName != null &&
				   cfg_generateOreBlockName.length >= cnt &&
				   cfg_generateOreBlockName[cnt] != null &&
				   !cfg_generateOreBlockName[cnt].equalsIgnoreCase(""))
				{
					cfg_generateOreS.put(folderName, cfg_generateOreBlockName[cnt]);
				}else
				{
					cfg_generateOreS.put(folderName, "stone");
				}
			}
		}else if(cfg_generateOreDimType == 2)
		{
			for(int cnt = 0; cnt < cfg_generateOreDimName.length; cnt++)
			{
				String DimName = cfg_generateOreDimName[cnt].equalsIgnoreCase(".") ? null : cfg_generateOreDimName[cnt];

				if(cfg_generateOreBlockName != null &&
				   cfg_generateOreBlockName.length >= cnt &&
				   cfg_generateOreBlockName[cnt] != null &&
				   !cfg_generateOreBlockName[cnt].equalsIgnoreCase(""))
				{
					cfg_generateOreS.put(DimName, cfg_generateOreBlockName[cnt]);
				}else
				{
					cfg_generateOreS.put(DimName, "stone");
				}
			}
		}

		config.setCategoryComment("World gen Ores2", "this setting is generate HighClass ores. (DimensionID or WorldFolderName) and Blockname have to PAIR");
		cfg_generateOreDimType2 = config.get("World gen Ores2","DimensionGetType", cfg_generateOreDimType2, "Dimension get type (0:DimensionID 1:WorldFolderName 2:DimensionName)").getInt();
		cfg_generateOreDimFolder2 = config.get("World gen Ores2","WorldFolderName", cfg_generateOreDimFolder2, "This setting use DimensionGetType=1").getStringList();
		cfg_generateOreDimName2 = config.get("World gen Ores2","WorldDimensionName", cfg_generateOreDimName2, "This setting use DimensionGetType=2").getStringList();
		cfg_generateOreDimId2 = config.get("World gen Ores2","DimensionID", cfg_generateOreDimId2, "This setting use DimensionGetType=0").getIntList();
		cfg_generateOreBlockName2 = config.get("World gen Ores2","BlockName", cfg_generateOreBlockName2 ).getStringList();

		if(cfg_generateOreDimType2 == 0)
		{
			for(int cnt = 0; cnt < cfg_generateOreDimId2.length; cnt++)
			{
				if(cfg_generateOreBlockName2 != null &&
				   cfg_generateOreBlockName2.length >= cnt &&
				   cfg_generateOreBlockName2[cnt] != null &&
				   !cfg_generateOreBlockName2[cnt].equalsIgnoreCase(""))
				{
					cfg_generateOre2.put(cfg_generateOreDimId2[cnt], cfg_generateOreBlockName2[cnt]);
				}else
				{
					cfg_generateOre2.put(cfg_generateOreDimId2[cnt], "stone");
				}
			}
		}else if(cfg_generateOreDimType2 == 1)
		{
			for(int cnt = 0; cnt < cfg_generateOreDimFolder2.length; cnt++)
			{
				String folderName = cfg_generateOreDimFolder2[cnt].equalsIgnoreCase(".") ? null : cfg_generateOreDimFolder2[cnt];

				if(cfg_generateOreBlockName2 != null &&
				   cfg_generateOreBlockName2.length >= cnt &&
				   cfg_generateOreBlockName2[cnt] != null &&
				   !cfg_generateOreBlockName2[cnt].equalsIgnoreCase(""))
				{

					cfg_generateOre2S.put(folderName, cfg_generateOreBlockName2[cnt]);
				}else
				{
					cfg_generateOre2S.put(folderName, "stone");
				}
			}
		}else if(cfg_generateOreDimType2 == 2)
		{
			for(int cnt = 0; cnt < cfg_generateOreDimName2.length; cnt++)
			{
				String dimName = cfg_generateOreDimName2[cnt].equalsIgnoreCase(".") ? null : cfg_generateOreDimName2[cnt];

				if(cfg_generateOreBlockName2 != null &&
				   cfg_generateOreBlockName2.length >= cnt &&
				   cfg_generateOreBlockName2[cnt] != null &&
				   !cfg_generateOreBlockName2[cnt].equalsIgnoreCase(""))
				{

					cfg_generateOre2S.put(dimName, cfg_generateOreBlockName2[cnt]);
				}else
				{
					cfg_generateOre2S.put(dimName, "stone");
				}
			}
		}

		config.setCategoryComment("World gen SpawnerRoom Overworld", "this setting is generate Overworld monster Spawner room. DimensionID and Blockname have to PAIR");
		cfg_generateOverSpawnDimType = config.get("World gen SpawnerRoom Overworld","DimensionGetType", cfg_generateOverSpawnDimType, "Dimension get type (0:DimensionID 1:WorldFolderName)").getInt();
		cfg_generateOverSpawnDimFolder = config.get("World gen SpawnerRoom Overworld", "WorldFolderName", cfg_generateOverSpawnDimFolder, "This setting use DimensionGetType=1").getStringList();
		cfg_generateOverSpawnDimId = config.get("World gen SpawnerRoom Overworld","DimensionID", cfg_generateOverSpawnDimId, "This setting use DimensionGetType=0").getIntList();
		//cfg_generateOverSpawnBlockName = config.get("World gen SpawnerRoom Overworld","BlockName", cfg_generateOreBlockName2).getStringList();
		if(cfg_generateOverSpawnDimType == 0)
		{
			for(int cnt = 0; cnt < cfg_generateOverSpawnDimId.length; cnt++)
			{
				/*
				if(cfg_generateOverSpawnBlockName != null &&
				   cfg_generateOverSpawnBlockName.length >= cnt &&
				   cfg_generateOverSpawnBlockName[cnt] != null &&
				   cfg_generateOverSpawnBlockName[cnt].equalsIgnoreCase(""))
				{
					cfg_generateOverSpawn.put(cfg_generateOverSpawnDimId[cnt], cfg_generateOverSpawnBlockName[cnt]);
				}else
				{
					cfg_generateOverSpawn.put(cfg_generateOverSpawnDimId[cnt], "stone");
				}
				*/
				cfg_generateOverSpawn.put(cfg_generateOverSpawnDimId[cnt], "stone");
			}
		}else if(cfg_generateOverSpawnDimType == 1)
		{
			for(int cnt = 0; cnt < cfg_generateOverSpawnDimFolder.length; cnt++)
			{
				String folderName = cfg_generateOverSpawnDimFolder[cnt].equalsIgnoreCase(".") ? null : cfg_generateOverSpawnDimFolder[cnt];
				cfg_generateOverSpawnS.put(folderName, "stone");
			}
		}

		config.setCategoryComment("World gen SpawnerRoom Netherworld", "this setting is generate Netherworld monster Spawner room. DimensionID and Blockname have to PAIR");
		cfg_generateNetherSpawnDimType = config.get("World gen SpawnerRoom Netherworld","DimensionGetType", cfg_generateNetherSpawnDimType, "Dimension get type (0:DimensionID 1:WorldFolderName)").getInt();
		cfg_generateNetherSpawnDimFolder = config.get("World gen SpawnerRoom Netherworld", "WorldFolderName", cfg_generateNetherSpawnDimFolder, "This setting use DimensionGetType=1").getStringList();
		cfg_generateNetherSpawnDimId = config.get("World gen SpawnerRoom Netherworld","DimensionID", cfg_generateNetherSpawnDimId, "This setting use DimensionGetType=0").getIntList();
		//cfg_generateNetherSpawnBlockName = config.get("World gen SpawnerRoom Netherworld","BlockName", cfg_generateOreBlockName2).getStringList();
		if(cfg_generateNetherSpawnDimType == 0)
		{
			for(int cnt = 0; cnt < cfg_generateNetherSpawnDimId.length; cnt++)
			{
				/*
				if(cfg_generateNetherSpawnBlockName != null &&
				   cfg_generateNetherSpawnBlockName.length >= cnt &&
				   cfg_generateNetherSpawnBlockName[cnt] != null &&
				   cfg_generateNetherSpawnBlockName[cnt].equalsIgnoreCase(""))
				{
					cfg_generateNetherSpawn.put(cfg_generateNetherSpawnDimId[cnt], cfg_generateNetherSpawnBlockName[cnt]);
				}else
				{
					cfg_generateNetherSpawn.put(cfg_generateNetherSpawnDimId[cnt], "stone");
				}
				*/
				cfg_generateNetherSpawn.put(cfg_generateNetherSpawnDimId[cnt], "stone");
			}
		}else if(cfg_generateNetherSpawnDimType == 1)
		{
			for(int cnt = 0; cnt < cfg_generateNetherSpawnDimFolder.length; cnt++)
			{
				String folderName = cfg_generateNetherSpawnDimFolder[cnt].equalsIgnoreCase(".") ? null : cfg_generateNetherSpawnDimFolder[cnt];
				cfg_generateNetherSpawnS.put(folderName, "netherrack");
			}
		}

		config.setCategoryComment("World gen SpawnerRoom Endworld", "this setting is generate Endworld monster Spawner room. DimensionID and Blockname have to PAIR");
		cfg_generateEndSpawnDimType = config.get("World gen SpawnerRoom Endworld","DimensionGetType", cfg_generateEndSpawnDimType, "Dimension get type (0:DimensionID 1:WorldFolderName)").getInt();
		cfg_generateEndSpawnDimFolder = config.get("World gen SpawnerRoom Endworld", "WorldFolderName", cfg_generateEndSpawnDimFolder, "This setting use DimensionGetType=1").getStringList();
		cfg_generateEndSpawnDimId = config.get("World gen SpawnerRoom Endworld","DimensionID", cfg_generateEndSpawnDimId, "This setting use DimensionGetType=0").getIntList();
		//cfg_generateEndSpawnBlockName = config.get("World gen SpawnerRoom Endworld","BlockName", cfg_generateOreBlockName2).getStringList();
		if(cfg_generateEndSpawnDimType == 0)
		{
			for(int cnt = 0; cnt < cfg_generateEndSpawnDimId.length; cnt++)
			{
				/*
				if(cfg_generateEndSpawnBlockName != null &&
				   cfg_generateEndSpawnBlockName.length >= cnt &&
				   cfg_generateEndSpawnBlockName[cnt] != null &&
				   cfg_generateEndSpawnBlockName[cnt].equalsIgnoreCase(""))
				{
					cfg_generateEndSpawn.put(cfg_generateEndSpawnDimId[cnt], cfg_generateEndSpawnBlockName[cnt]);
				}else
				{
					cfg_generateEndSpawn.put(cfg_generateEndSpawnDimId[cnt], "stone");
				}
				*/
				cfg_generateEndSpawn.put(cfg_generateEndSpawnDimId[cnt], "stone");
			}
		}else if(cfg_generateEndSpawnDimType == 1)
		{
			for(int cnt = 0; cnt < cfg_generateEndSpawnDimFolder.length; cnt++)
			{
				String folderName = cfg_generateEndSpawnDimFolder[cnt].equalsIgnoreCase(".") ? null : cfg_generateEndSpawnDimFolder[cnt];
				cfg_generateEndSpawnS.put(folderName, "end_stone");
			}
		}

		config.save();

		config.setCategoryComment("World gen objects", "this setting is object generate at field settings");
		cfg_gen_Genkotu = config.get("World gen objects","generate GENKOTUDAKE", cfg_gen_Genkotu , "0:disable 1:enable").getInt();
		cfg_gen_Tue = config.get("World gen objects","generate TUE object", cfg_gen_Tue , "0:disable 1:enable").getInt();
		cfg_gen_Tubo = config.get("World gen objects","generate TUBO object", cfg_gen_Tubo , "0:disable 1:enable").getInt();
		cfg_gen_Taru = config.get("World gen objects","generate TARU object", cfg_gen_Taru , "0:disable 1:enable").getInt();
		cfg_gen_Sword = config.get("World gen objects","generate SWORD object", cfg_gen_Sword , "0:disable 1:enable").getInt();
		cfg_gen_Sword2 = config.get("World gen objects","generate SWORD2 object", cfg_gen_Sword2 , "0:disable 1:enable").getInt();
		cfg_gen_Sikabane = config.get("World gen objects","generate SIKABANE object", cfg_gen_Sikabane , "0:disable 1:enable").getInt();
		cfg_gen_Hako = config.get("World gen objects","generate HAKO object", cfg_gen_Hako , "0:disable 1:enable").getInt();
		cfg_gen_Ido = config.get("World gen objects","generate IDO object", cfg_gen_Ido , "0:disable 1:enable").getInt();
		cfg_gen_Ido2 = config.get("World gen objects","generate HOME of MEDAL KING and entrance", cfg_gen_Ido2 , "0:disable 1:enable").getInt();

	}

	public void getConfigGui(Configuration config)
	{
		config.load();
		config.setCategoryComment("HP/MP PlayerDataGUI", "HP/MP PlayerDataGUI settings");
		CLGuiVis1 = config.get("HP/MP PlayerDataGUI","GUI Visible", CLGuiVis1 ,"0=false 1=true").getInt();
		CLGuiPos1 = config.get("HP/MP PlayerDataGUI","GUI BasePosition", CLGuiPos1 ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").getInt();
		CLGuiPos1X = config.get("HP/MP PlayerDataGUI","GUI Position fix X", CLGuiPos1X, "GUI position fix pixels from GUI BasePosition").getInt();
		CLGuiPos1Y = config.get("HP/MP PlayerDataGUI","GUI Position fix Y", CLGuiPos1Y, "GUI position fix pixels from GUI BasePosition").getInt();
		CLGuiCrisis = config.get("HP/MP PlayerDataGUI","HP CRISIS PERCENT", CLGuiCrisis, "Setting HP Percent for HP CRISIS COLOR").getInt();

		config.setCategoryComment("PlayerStatusGUI", "PlayerStatusGUI settings");
		CLGuiVis2 = config.get("PlayerStatusGUI","GUI Visible", CLGuiVis2 ,"0=false 1=true").getInt();
		CLGuiPos2 = config.get("PlayerStatusGUI","GUI BasePosition", CLGuiPos2 ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").getInt();
		CLGuiPos2X = config.get("PlayerStatusGUI","GUI Position fix X", CLGuiPos2X, "GUI position fix pixels from GUI BasePosition").getInt();
		CLGuiPos2Y = config.get("PlayerStatusGUI","GUI Position fix Y", CLGuiPos2Y, "GUI position fix pixels from GUI BasePosition").getInt();

		config.setCategoryComment("ArmorStatusGUI", "ArmorStatusGUI settings");
		CLGuiArmorVis = config.get("ArmorStatusGUI","GUI Visible", CLGuiArmorVis ,"0=false 1=true").getInt();
		CLGuiArmorPos = config.get("ArmorStatusGUI","GUI BasePosition", CLGuiArmorPos ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").getInt();
		CLGuiArmorPosX = config.get("ArmorStatusGUI","GUI Position fix X", CLGuiArmorPosX, "GUI position fix pixels from GUI BasePosition").getInt();
		CLGuiArmorPosY = config.get("ArmorStatusGUI","GUI Position fix Y", CLGuiArmorPosY, "GUI position fix pixels from GUI BasePosition").getInt();

		config.setCategoryComment("GamePlayLogGUI", "PlayLogGUI settings");
		CLGuiLogVis = config.get("GamePlayLogGUI","GUI Visible", CLGuiLogVis ,"0=false 1=true").getInt();
		CLGuiLogPos = config.get("GamePlayLogGUI","GUI BasePosition", CLGuiLogPos ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").getInt();
		CLGuiLogPosX = config.get("GamePlayLogGUI","GUI Position fix X", CLGuiLogPosX, "GUI position fix pixels from GUI BasePosition").getInt();
		CLGuiLogPosY = config.get("GamePlayLogGUI","GUI Position fix Y", CLGuiLogPosY, "GUI position fix pixels from GUI BasePosition").getInt();
		CLGuiLogWindowOff = config.get("GamePlayLogGUI","Output function for Non display", CLGuiLogWindowOff, "0:to this gUI 1:to Vanilla chat gui 2:no output").getInt();
		damageDigits = config.get("GamePlayLogGUI","Decimal digits for damage", damageDigits, "decimal digits 0:XXX damage  1:XXX.XXX damage").getInt();

		config.setCategoryComment("GamePlaySubpointsGUI", "PlaySubpointsGUI settings");
		CLGuiSubpointsVis = config.get("GamePlaySubpointsGUI","GUI Visible", CLGuiSubpointsVis ,"0=false 1=true").getInt();
		CLGuiSubpointsPos = config.get("GamePlaySubpointsGUI","GUI BasePosition", CLGuiSubpointsPos ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").getInt();
		CLGuiSubpointsPosX = config.get("GamePlaySubpointsGUI","GUI Position fix X", CLGuiSubpointsPosX, "GUI position fix pixels from GUI BasePosition").getInt();
		CLGuiSubpointsPosY = config.get("GamePlaySubpointsGUI","GUI Position fix Y", CLGuiSubpointsPosY, "GUI position fix pixels from GUI BasePosition").getInt();

		config.setCategoryComment("GamePlayPotionEffectTimeGUI", "PotionEffectTimeGUI settings");
		CLGuiBuffBarVis = config.get("GamePlayPotionEffectTimeGUI","GUI Visible", CLGuiBuffBarVis ,"0=false 1=true").getInt();
		CLGuiBuffBarPos = config.get("GamePlayPotionEffectTimeGUI","GUI BasePosition", CLGuiBuffBarPos ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").getInt();
		CLGuiBuffBarPosX = config.get("GamePlayPotionEffectTimeGUI","GUI Position fix X", CLGuiBuffBarPosX, "GUI position fix pixels from GUI BasePosition").getInt();
		CLGuiBuffBarPosY = config.get("GamePlayPotionEffectTimeGUI","GUI Position fix Y", CLGuiBuffBarPosY, "GUI position fix pixels from GUI BasePosition").getInt();


		config.save();
	}

	public void getConfigId(Configuration config)
	{
		config.load();
		config.setCategoryComment("PotionID", "PotionEffectID settings");
		PotionIDidx = config.get("PotionID","PotionID index", PotionIDidx ,"Potion idx use from this setVal to +30").getInt();

		config.setCategoryComment("EntityID", "this setting is Entity ID index");
		MonsterIDidx = config.get("EntityID","MobEntityID", MonsterIDidx ,"DQR monsterEntity ID index use from this setVal to + 500").getInt();
		PetMonsterIDidx = config.get("EntityID","PetMobEntityID", PetMonsterIDidx ,"DQR PetmonsterEntity ID index use from this setVal to + 500").getInt();
		NPCIDidx = config.get("EntityID","NPCID", NPCIDidx ,"DQR NPCEntity ID index use from this setVal to + 50").getInt();
		MagicIDidx =  config.get("EntityID","MagicEntityID", MagicIDidx ,"DQR MagicEntity ID index use from this setVal to + 50").getInt();
		ThrowingIDidx =  config.get("EntityID","ThrowingEntityID", ThrowingIDidx ,"DQR ThrowingEntity ID index use from this setVal to + 50").getInt();

		config.setCategoryComment("GUI ID", "GUI ID settings");
		GuiID_FarmBook =  config.get("GUI ID","FarmBookGUI", GuiID_FarmBook).getInt();
		GuiID_JobChange =  config.get("GUI ID","JobChangeGUI", GuiID_JobChange).getInt();
		GuiID_MKWeapon =  config.get("GUI ID","MedalKingGUI(Weapon)", GuiID_MKWeapon).getInt();
		GuiID_MKArmor =  config.get("GUI ID","MedalKingGUI(Armor)", GuiID_MKArmor).getInt();
		GuiID_MKMagic =  config.get("GUI ID","MedalKingGUI(Magic)", GuiID_MKMagic).getInt();
		GuiID_MKMagic2 =  config.get("GUI ID","MedalKingGUI(Magic2)", GuiID_MKMagic2).getInt();
		GuiID_MKJob =  config.get("GUI ID","MedalKingGUI(Job)", GuiID_MKJob).getInt();
		GuiID_MKMisc =  config.get("GUI ID","MedalKingGUI(Misc)", GuiID_MKMisc).getInt();
		GuiID_MKMedal =  config.get("GUI ID","MedalKingGUI(Medal)", GuiID_MKMedal).getInt();
		GuiID_PetBook =  config.get("GUI ID","PetBook", GuiID_PetBook).getInt();
		GuiID_SkillWeapon =  config.get("GUI ID","SkillWeapon", GuiID_SkillWeapon).getInt();
		GuiID_PetStatus =  config.get("GUI ID","PetStatus", GuiID_PetStatus).getInt();
		GuiID_PetInventory =  config.get("GUI ID","PetInventory", GuiID_PetInventory).getInt();
		GuiID_DqrEnderchest =  config.get("GUI ID","DQR EnderChest", GuiID_DqrEnderchest).getInt();
		GuiID_ItemBag =  config.get("GUI ID","ItemBag", GuiID_ItemBag).getInt();
		GuiID_SubEquip =  config.get("GUI ID","MainInventory SubEquip", GuiID_SubEquip).getInt();
		config.save();

	}

	public void getConfigRura(Configuration config)
	{
		config.load();

		config.setCategoryComment("RuraC Main", "RuraC Main settings");
		RuraC_IGF = config.get("RuraC Main","RuraC_InGameFix", RuraC_IGF, "allow in game cordinates fix (0:prohibit 1:allow only OP 2:allow for all player)").getInt();

		config.setCategoryComment("RuraC(white) Coordinates", "RuraC Cordinates settings");
		RuraC_X[EnumDqmMagic.RuraC.getType()] = config.get("RuraC(white) Coordinates","RuraC_X", RuraC_X[EnumDqmMagic.RuraC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraC.getType()] = config.get("RuraC(white) Coordinates","RuraC_Y", RuraC_Y[EnumDqmMagic.RuraC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraC.getType()] = config.get("RuraC(white) Coordinates","RuraC_Z", RuraC_Z[EnumDqmMagic.RuraC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraC.getType()] = config.get("RuraC(white) Coordinates","RuraC_Dim", RuraC_Dim[EnumDqmMagic.RuraC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.setCategoryComment("RuraC(Red) Coordinates", "RuraC(Red) Cordinates settings");
		RuraC_X[EnumDqmMagic.RuraRC.getType()] = config.get("RuraC(Red) Coordinates","RuraCRed_X", RuraC_X[EnumDqmMagic.RuraRC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraRC.getType()] = config.get("RuraC(Red) Coordinates","RuraCRed_Y", RuraC_Y[EnumDqmMagic.RuraRC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraRC.getType()] = config.get("RuraC(Red) Coordinates","RuraCRed_Z", RuraC_Z[EnumDqmMagic.RuraRC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraRC.getType()] = config.get("RuraC(Red) Coordinates","RuraCRed_Dim", RuraC_Dim[EnumDqmMagic.RuraRC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.setCategoryComment("RuraC(Green) Coordinates", "RuraC(Green) Cordinates settings");
		RuraC_X[EnumDqmMagic.RuraGC.getType()] = config.get("RuraC(Green) Coordinates","RuraCGreen_X", RuraC_X[EnumDqmMagic.RuraGC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraGC.getType()] = config.get("RuraC(Green) Coordinates","RuraCGreen_Y", RuraC_Y[EnumDqmMagic.RuraGC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraGC.getType()] = config.get("RuraC(Green) Coordinates","RuraCGreen_Z", RuraC_Z[EnumDqmMagic.RuraGC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraGC.getType()] = config.get("RuraC(Green) Coordinates","RuraCGreen_Dim", RuraC_Dim[EnumDqmMagic.RuraGC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.setCategoryComment("RuraC(Blue) Coordinates", "RuraC(Blue) Cordinates settings");
		RuraC_X[EnumDqmMagic.RuraBC.getType()] = config.get("RuraC(Blue) Coordinates","RuraCBlue_X", RuraC_X[EnumDqmMagic.RuraBC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraBC.getType()] = config.get("RuraC(Blue) Coordinates","RuraCBlue_Y", RuraC_Y[EnumDqmMagic.RuraBC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraBC.getType()] = config.get("RuraC(Blue) Coordinates","RuraCBlue_Z", RuraC_Z[EnumDqmMagic.RuraBC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraBC.getType()] = config.get("RuraC(Blue) Coordinates","RuraCBlue_Dim", RuraC_Dim[EnumDqmMagic.RuraBC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.setCategoryComment("RuraC(Yellow) Coordinates", "RuraC(Yellow) Cordinates settings");
		RuraC_X[EnumDqmMagic.RuraYC.getType()] = config.get("RuraC(Yellow) Coordinates","RuraCYellow_X", RuraC_X[EnumDqmMagic.RuraYC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraYC.getType()] = config.get("RuraC(Yellow) Coordinates","RuraCYellow_Y", RuraC_Y[EnumDqmMagic.RuraYC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraYC.getType()] = config.get("RuraC(Yellow) Coordinates","RuraCYellow_Z", RuraC_Z[EnumDqmMagic.RuraYC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraYC.getType()] = config.get("RuraC(Yellow) Coordinates","RuraCYellow_Dim", RuraC_Dim[EnumDqmMagic.RuraYC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.setCategoryComment("KimeraC Main", "KimeraC Main settings");
		KimeraC_IGF = config.get("KimeraC Main","KimeraC_InGameFix", KimeraC_IGF, "allow in game cordinates fix (0:prohibit 1:allow only OP 2:allow for all player)").getInt();

		config.setCategoryComment("KimeraC(white) Coordinates", "KimeraC Cordinates settings");
		KimeraC_X[EnumDqmMagic.RuraC.getType()] = config.get("KimeraC(white) Coordinates","KimeraC_X", KimeraC_X[EnumDqmMagic.RuraC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraC.getType()] = config.get("KimeraC(white) Coordinates","KimeraC_Y", KimeraC_Y[EnumDqmMagic.RuraC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraC.getType()] = config.get("KimeraC(white) Coordinates","KimeraC_Z", KimeraC_Z[EnumDqmMagic.RuraC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraC.getType()] = config.get("KimeraC(white) Coordinates","KimeraC_Dim", KimeraC_Dim[EnumDqmMagic.RuraC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.setCategoryComment("KimeraC(Red) Coordinates", "KimeraC(Red) Cordinates settings");
		KimeraC_X[EnumDqmMagic.RuraRC.getType()] = config.get("KimeraC(Red) Coordinates","KimeraCRed_X", KimeraC_X[EnumDqmMagic.RuraRC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraRC.getType()] = config.get("KimeraC(Red) Coordinates","KimeraCRed_Y", KimeraC_Y[EnumDqmMagic.RuraRC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraRC.getType()] = config.get("KimeraC(Red) Coordinates","KimeraCRed_Z", KimeraC_Z[EnumDqmMagic.RuraRC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraRC.getType()] = config.get("KimeraC(Red) Coordinates","KimeraCRed_Dim", KimeraC_Dim[EnumDqmMagic.RuraRC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.setCategoryComment("KimeraC(Green) Coordinates", "KimeraC(Green) Cordinates settings");
		KimeraC_X[EnumDqmMagic.RuraGC.getType()] = config.get("KimeraC(Green) Coordinates","KimeraCGreen_X", KimeraC_X[EnumDqmMagic.RuraGC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraGC.getType()] = config.get("KimeraC(Green) Coordinates","KimeraCGreen_Y", KimeraC_Y[EnumDqmMagic.RuraGC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraGC.getType()] = config.get("KimeraC(Green) Coordinates","KimeraCGreen_Z", KimeraC_Z[EnumDqmMagic.RuraGC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraGC.getType()] = config.get("KimeraC(Green) Coordinates","KimeraCGreen_Dim", KimeraC_Dim[EnumDqmMagic.RuraGC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.setCategoryComment("KimeraC(Blue) Coordinates", "KimeraC(Blue) Cordinates settings");
		KimeraC_X[EnumDqmMagic.RuraBC.getType()] = config.get("KimeraC(Blue) Coordinates","KimeraCBlue_X", KimeraC_X[EnumDqmMagic.RuraBC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraBC.getType()] = config.get("KimeraC(Blue) Coordinates","KimeraCBlue_Y", KimeraC_Y[EnumDqmMagic.RuraBC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraBC.getType()] = config.get("KimeraC(Blue) Coordinates","KimeraCBlue_Z", KimeraC_Z[EnumDqmMagic.RuraBC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraBC.getType()] = config.get("KimeraC(Blue) Coordinates","KimeraCBlue_Dim", KimeraC_Dim[EnumDqmMagic.RuraBC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.setCategoryComment("KimeraC(Yellow) Coordinates", "KimeraC(Yellow) Cordinates settings");
		KimeraC_X[EnumDqmMagic.RuraYC.getType()] = config.get("KimeraC(Yellow) Coordinates","KimeraCYellow_X", KimeraC_X[EnumDqmMagic.RuraYC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraYC.getType()] = config.get("KimeraC(Yellow) Coordinates","KimeraCYellow_Y", KimeraC_Y[EnumDqmMagic.RuraYC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraYC.getType()] = config.get("KimeraC(Yellow) Coordinates","KimeraCYellow_Z", KimeraC_Z[EnumDqmMagic.RuraYC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraYC.getType()] = config.get("KimeraC(Yellow) Coordinates","KimeraCYellow_Dim", KimeraC_Dim[EnumDqmMagic.RuraYC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		config.save();
	}

	public void getConfigMagic(Configuration config)
	{
		config.load();
		config.setCategoryComment("MagicRanaluta", "Ranaluta setp hours settings");

		int[] dummy ={4,8,12,16,20,24};
		RanalutaStep = config.get("MagicRanaluta","Step hours", dummy, "setting setep hours pattern. separate a new line").getIntList();

		config.save();
	}

	public void setCLGuiPos1(int par1, int par2, int par3)
	{
		cfg_gui.load();
		cfg_gui.get("HP/MP PlayerDataGUI","GUI BasePosition", CLGuiPos1 ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").set(par1);
		cfg_gui.get("HP/MP PlayerDataGUI","GUI Position fix X", CLGuiPos1X, "GUI position fix pixels from GUI BasePosition").set(par2);
		cfg_gui.get("HP/MP PlayerDataGUI","GUI Position fix Y", CLGuiPos1Y, "GUI position fix pixels from GUI BasePosition").set(par3);
		cfg_gui.save();
	}

	public void setCLGuiPos2(int par1, int par2, int par3)
	{
		cfg_gui.load();
		cfg_gui.get("PlayerStatusGUI","GUI BasePosition", CLGuiPos2 ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").set(par1);
		cfg_gui.get("PlayerStatusGUI","GUI Position fix X", CLGuiPos2X, "GUI position fix pixels from GUI BasePosition").set(par2);
		cfg_gui.get("PlayerStatusGUI","GUI Position fix Y", CLGuiPos2Y, "GUI position fix pixels from GUI BasePosition").set(par3);
		cfg_gui.save();
	}

	public void setCLGuiArmorPos(int par1, int par2, int par3)
	{
		cfg_gui.load();
		cfg_gui.get("ArmorStatusGUI","GUI BasePosition", CLGuiArmorPos ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").set(par1);
		cfg_gui.get("ArmorStatusGUI","GUI Position fix X", CLGuiArmorPosX, "GUI position fix pixels from GUI BasePosition").set(par2);
		cfg_gui.get("ArmorStatusGUI","GUI Position fix Y", CLGuiArmorPosY, "GUI position fix pixels from GUI BasePosition").set(par3);
		cfg_gui.save();
	}

	public void setCLGuiLogPos(int par1, int par2, int par3)
	{
		cfg_gui.load();
		cfg_gui.get("GamePlayLogGUI","GUI BasePosition", CLGuiLogPos ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").set(par1);
		cfg_gui.get("GamePlayLogGUI","GUI Position fix X", CLGuiLogPosX, "GUI position fix pixels from GUI BasePosition").set(par2);
		cfg_gui.get("GamePlayLogGUI","GUI Position fix Y", CLGuiLogPosY, "GUI position fix pixels from GUI BasePosition").set(par3);
		cfg_gui.save();
	}

	public void setCLGuiSubpointsPos(int par1, int par2, int par3)
	{
		cfg_gui.load();
		cfg_gui.get("GamePlaySubpointsGUI","GUI BasePosition", CLGuiSubpointsPos ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").set(par1);
		cfg_gui.get("GamePlaySubpointsGUI","GUI Position fix X", CLGuiSubpointsPosX, "GUI position fix pixels from GUI BasePosition").set(par2);
		cfg_gui.get("GamePlaySubpointsGUI","GUI Position fix Y", CLGuiSubpointsPosY, "GUI position fix pixels from GUI BasePosition").set(par3);
		cfg_gui.save();
	}

	public void setCLGuiBuffBarPos(int par1, int par2, int par3)
	{
		cfg_gui.load();
		cfg_gui.get("GamePlayPotionEffectTimeGUI","GUI BasePosition", CLGuiBuffBarPos ,"1=LeftTop, 2, 3=LeftMiddle, 4, 5=LeftBottom, 6=RightTop, 7, 8=RightMiddle, 9, 10=RightBottom, 11,CenterTop, 12, 13=CenterMiddle, 14, 15=CenterBottom").set(par1);
		cfg_gui.get("GamePlayPotionEffectTimeGUI","GUI Position fix X", CLGuiBuffBarPosX, "GUI position fix pixels from GUI BasePosition").set(par2);
		cfg_gui.get("GamePlayPotionEffectTimeGUI","GUI Position fix Y", CLGuiBuffBarPosY, "GUI position fix pixels from GUI BasePosition").set(par3);
		cfg_gui.save();
	}

	public void setRuraCoordinates(EnumDqmMagic type, int x, int y, int z, int dim)
	{
		cfg_rura.load();
		if(type == EnumDqmMagic.RuraC)
		{
			cfg_rura.setCategoryComment("RuraC(white) Coordinates", "RuraC Cordinates settings");
			cfg_rura.get("RuraC(white) Coordinates","RuraC_X", RuraC_X[EnumDqmMagic.RuraC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("RuraC(white) Coordinates","RuraC_Y", RuraC_Y[EnumDqmMagic.RuraC.getType()] ,"jump to posY setting").set(y);
			cfg_rura.get("RuraC(white) Coordinates","RuraC_Z", RuraC_Z[EnumDqmMagic.RuraC.getType()] ,"jump to posZ setting").set(z);
			cfg_rura.get("RuraC(white) Coordinates","RuraC_Dim", RuraC_Dim[EnumDqmMagic.RuraC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);
		}else if(type == EnumDqmMagic.RuraRC)
		{
			cfg_rura.setCategoryComment("RuraC(Red) Coordinates", "RuraC(Red) Cordinates settings");
			cfg_rura.get("RuraC(Red) Coordinates","RuraCRed_X", RuraC_X[EnumDqmMagic.RuraRC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("RuraC(Red) Coordinates","RuraCRed_Y", RuraC_Y[EnumDqmMagic.RuraRC.getType()] ,"jump to posY setting").set(y);
			cfg_rura.get("RuraC(Red) Coordinates","RuraCRed_Z", RuraC_Z[EnumDqmMagic.RuraRC.getType()],"jump to posZ setting").set(z);
			cfg_rura.get("RuraC(Red) Coordinates","RuraCRed_Dim", RuraC_Dim[EnumDqmMagic.RuraRC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);

		}else if(type == EnumDqmMagic.RuraGC)
		{
			cfg_rura.setCategoryComment("RuraC(Green) Coordinates", "RuraC(Green) Cordinates settings");
			cfg_rura.get("RuraC(Green) Coordinates","RuraCGreen_X", RuraC_X[EnumDqmMagic.RuraGC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("RuraC(Green) Coordinates","RuraCGreen_Y", RuraC_Y[EnumDqmMagic.RuraGC.getType()] ,"jump to posY setting").set(y);
			cfg_rura.get("RuraC(Green) Coordinates","RuraCGreen_Z", RuraC_Z[EnumDqmMagic.RuraGC.getType()] ,"jump to posZ setting").set(z);
			cfg_rura.get("RuraC(Green) Coordinates","RuraCGreen_Dim", RuraC_Dim[EnumDqmMagic.RuraGC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);

		}else if(type == EnumDqmMagic.RuraBC)
		{
			cfg_rura.setCategoryComment("RuraC(Blue) Coordinates", "RuraC(Blue) Cordinates settings");
			cfg_rura.get("RuraC(Blue) Coordinates","RuraCBlue_X", RuraC_X[EnumDqmMagic.RuraBC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("RuraC(Blue) Coordinates","RuraCBlue_Y", RuraC_Y[EnumDqmMagic.RuraBC.getType()], "jump to posY setting").set(y);
			cfg_rura.get("RuraC(Blue) Coordinates","RuraCBlue_Z", RuraC_Z[EnumDqmMagic.RuraBC.getType()], "jump to posZ setting").set(z);
			cfg_rura.get("RuraC(Blue) Coordinates","RuraCBlue_Dim", RuraC_Dim[EnumDqmMagic.RuraBC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);

		}else if(type == EnumDqmMagic.RuraYC)
		{
			cfg_rura.setCategoryComment("RuraC(Yellow) Coordinates", "RuraC(Yellow) Cordinates settings");
			cfg_rura.get("RuraC(Yellow) Coordinates","RuraCYellow_X", RuraC_X[EnumDqmMagic.RuraYC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("RuraC(Yellow) Coordinates","RuraCYellow_Y", RuraC_Y[EnumDqmMagic.RuraYC.getType()], "jump to posY setting").set(y);
			cfg_rura.get("RuraC(Yellow) Coordinates","RuraCYellow_Z", RuraC_Z[EnumDqmMagic.RuraYC.getType()], "jump to posZ setting").set(z);
			cfg_rura.get("RuraC(Yellow) Coordinates","RuraCYellow_Dim", RuraC_Dim[EnumDqmMagic.RuraYC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);

		}
		cfg_rura.save();

		cfg_rura.load();
		RuraC_X[EnumDqmMagic.RuraC.getType()] = cfg_rura.get("RuraC(white) Coordinates","RuraC_X", RuraC_X[EnumDqmMagic.RuraC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraC.getType()] = cfg_rura.get("RuraC(white) Coordinates","RuraC_Y", RuraC_Y[EnumDqmMagic.RuraC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraC.getType()] = cfg_rura.get("RuraC(white) Coordinates","RuraC_Z", RuraC_Z[EnumDqmMagic.RuraC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraC.getType()] = cfg_rura.get("RuraC(white) Coordinates","RuraC_Dim", RuraC_Dim[EnumDqmMagic.RuraC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		RuraC_X[EnumDqmMagic.RuraRC.getType()] = cfg_rura.get("RuraC(Red) Coordinates","RuraCRed_X", RuraC_X[EnumDqmMagic.RuraRC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraRC.getType()] = cfg_rura.get("RuraC(Red) Coordinates","RuraCRed_Y", RuraC_Y[EnumDqmMagic.RuraRC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraRC.getType()] = cfg_rura.get("RuraC(Red) Coordinates","RuraCRed_Z", RuraC_Z[EnumDqmMagic.RuraRC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraRC.getType()] = cfg_rura.get("RuraC(Red) Coordinates","RuraCRed_Dim", RuraC_Dim[EnumDqmMagic.RuraRC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		RuraC_X[EnumDqmMagic.RuraGC.getType()] = cfg_rura.get("RuraC(Green) Coordinates","RuraCGreen_X", RuraC_X[EnumDqmMagic.RuraGC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraGC.getType()] = cfg_rura.get("RuraC(Green) Coordinates","RuraCGreen_Y", RuraC_Y[EnumDqmMagic.RuraGC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraGC.getType()] = cfg_rura.get("RuraC(Green) Coordinates","RuraCGreen_Z", RuraC_Z[EnumDqmMagic.RuraGC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraGC.getType()] = cfg_rura.get("RuraC(Green) Coordinates","RuraCGreen_Dim", RuraC_Dim[EnumDqmMagic.RuraGC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		RuraC_X[EnumDqmMagic.RuraBC.getType()] = cfg_rura.get("RuraC(Blue) Coordinates","RuraCBlue_X", RuraC_X[EnumDqmMagic.RuraBC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraBC.getType()] = cfg_rura.get("RuraC(Blue) Coordinates","RuraCBlue_Y", RuraC_Y[EnumDqmMagic.RuraBC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraBC.getType()] = cfg_rura.get("RuraC(Blue) Coordinates","RuraCBlue_Z", RuraC_Z[EnumDqmMagic.RuraBC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraBC.getType()] = cfg_rura.get("RuraC(Blue) Coordinates","RuraCBlue_Dim", RuraC_Dim[EnumDqmMagic.RuraBC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		RuraC_X[EnumDqmMagic.RuraYC.getType()] = cfg_rura.get("RuraC(Yellow) Coordinates","RuraCYellow_X", RuraC_X[EnumDqmMagic.RuraYC.getType()], "jump to posX setting").getInt();
		RuraC_Y[EnumDqmMagic.RuraYC.getType()] = cfg_rura.get("RuraC(Yellow) Coordinates","RuraCYellow_Y", RuraC_Y[EnumDqmMagic.RuraYC.getType()] ,"jump to posY setting").getInt();
		RuraC_Z[EnumDqmMagic.RuraYC.getType()] = cfg_rura.get("RuraC(Yellow) Coordinates","RuraCYellow_Z", RuraC_Z[EnumDqmMagic.RuraYC.getType()] ,"jump to posZ setting").getInt();
		RuraC_Dim[EnumDqmMagic.RuraYC.getType()] = cfg_rura.get("RuraC(Yellow) Coordinates","RuraCYellow_Dim", RuraC_Dim[EnumDqmMagic.RuraYC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

	}

	public void setKimeraCoordinates(EnumDqmMagic type, int x, int y, int z, int dim)
	{
		cfg_rura.load();
		if(type == EnumDqmMagic.RuraC)
		{
			cfg_rura.setCategoryComment("KimeraC(white) Coordinates", "KimeraC Cordinates settings");
			cfg_rura.get("KimeraC(white) Coordinates","KimeraC_X", KimeraC_X[EnumDqmMagic.RuraC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("KimeraC(white) Coordinates","KimeraC_Y", KimeraC_Y[EnumDqmMagic.RuraC.getType()] ,"jump to posY setting").set(y);
			cfg_rura.get("KimeraC(white) Coordinates","KimeraC_Z", KimeraC_Z[EnumDqmMagic.RuraC.getType()] ,"jump to posZ setting").set(z);
			cfg_rura.get("KimeraC(white) Coordinates","KimeraC_Dim", KimeraC_Dim[EnumDqmMagic.RuraC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);
		}else if(type == EnumDqmMagic.RuraRC)
		{
			cfg_rura.setCategoryComment("KimeraC(Red) Coordinates", "KimeraC(Red) Cordinates settings");
			cfg_rura.get("KimeraC(Red) Coordinates","KimeraCRed_X", KimeraC_X[EnumDqmMagic.RuraRC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("KimeraC(Red) Coordinates","KimeraCRed_Y", KimeraC_Y[EnumDqmMagic.RuraRC.getType()] ,"jump to posY setting").set(y);
			cfg_rura.get("KimeraC(Red) Coordinates","KimeraCRed_Z", KimeraC_Z[EnumDqmMagic.RuraRC.getType()],"jump to posZ setting").set(z);
			cfg_rura.get("KimeraC(Red) Coordinates","KimeraCRed_Dim", KimeraC_Dim[EnumDqmMagic.RuraRC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);

		}else if(type == EnumDqmMagic.RuraGC)
		{
			cfg_rura.setCategoryComment("KimeraC(Green) Coordinates", "KimeraC(Green) Cordinates settings");
			cfg_rura.get("KimeraC(Green) Coordinates","KimeraCGreen_X", KimeraC_X[EnumDqmMagic.RuraGC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("KimeraC(Green) Coordinates","KimeraCGreen_Y", KimeraC_Y[EnumDqmMagic.RuraGC.getType()] ,"jump to posY setting").set(y);
			cfg_rura.get("KimeraC(Green) Coordinates","KimeraCGreen_Z", KimeraC_Z[EnumDqmMagic.RuraGC.getType()] ,"jump to posZ setting").set(z);
			cfg_rura.get("KimeraC(Green) Coordinates","KimeraCGreen_Dim", KimeraC_Dim[EnumDqmMagic.RuraGC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);

		}else if(type == EnumDqmMagic.RuraBC)
		{
			cfg_rura.setCategoryComment("KimeraC(Blue) Coordinates", "KimeraC(Blue) Cordinates settings");
			cfg_rura.get("KimeraC(Blue) Coordinates","KimeraCBlue_X", KimeraC_X[EnumDqmMagic.RuraBC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("KimeraC(Blue) Coordinates","KimeraCBlue_Y", KimeraC_Y[EnumDqmMagic.RuraBC.getType()], "jump to posY setting").set(y);
			cfg_rura.get("KimeraC(Blue) Coordinates","KimeraCBlue_Z", KimeraC_Z[EnumDqmMagic.RuraBC.getType()], "jump to posZ setting").set(z);
			cfg_rura.get("KimeraC(Blue) Coordinates","KimeraCBlue_Dim", KimeraC_Dim[EnumDqmMagic.RuraBC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);

		}else if(type == EnumDqmMagic.RuraYC)
		{
			cfg_rura.setCategoryComment("KimeraC(Yellow) Coordinates", "KimeraC(Yellow) Cordinates settings");
			cfg_rura.get("KimeraC(Yellow) Coordinates","KimeraCYellow_X", KimeraC_X[EnumDqmMagic.RuraYC.getType()], "jump to posX setting").set(x);
			cfg_rura.get("KimeraC(Yellow) Coordinates","KimeraCYellow_Y", KimeraC_Y[EnumDqmMagic.RuraYC.getType()], "jump to posY setting").set(y);
			cfg_rura.get("KimeraC(Yellow) Coordinates","KimeraCYellow_Z", KimeraC_Z[EnumDqmMagic.RuraYC.getType()], "jump to posZ setting").set(z);
			cfg_rura.get("KimeraC(Yellow) Coordinates","KimeraCYellow_Dim", KimeraC_Dim[EnumDqmMagic.RuraYC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").set(dim);

		}
		cfg_rura.save();

		cfg_rura.load();
		KimeraC_X[EnumDqmMagic.RuraC.getType()] = cfg_rura.get("KimeraC(white) Coordinates","KimeraC_X", KimeraC_X[EnumDqmMagic.RuraC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraC.getType()] = cfg_rura.get("KimeraC(white) Coordinates","KimeraC_Y", KimeraC_Y[EnumDqmMagic.RuraC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraC.getType()] = cfg_rura.get("KimeraC(white) Coordinates","KimeraC_Z", KimeraC_Z[EnumDqmMagic.RuraC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraC.getType()] = cfg_rura.get("KimeraC(white) Coordinates","KimeraC_Dim", KimeraC_Dim[EnumDqmMagic.RuraC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		KimeraC_X[EnumDqmMagic.RuraRC.getType()] = cfg_rura.get("KimeraC(Red) Coordinates","KimeraCRed_X", KimeraC_X[EnumDqmMagic.RuraRC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraRC.getType()] = cfg_rura.get("KimeraC(Red) Coordinates","KimeraCRed_Y", KimeraC_Y[EnumDqmMagic.RuraRC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraRC.getType()] = cfg_rura.get("KimeraC(Red) Coordinates","KimeraCRed_Z", KimeraC_Z[EnumDqmMagic.RuraRC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraRC.getType()] = cfg_rura.get("KimeraC(Red) Coordinates","KimeraCRed_Dim", KimeraC_Dim[EnumDqmMagic.RuraRC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		KimeraC_X[EnumDqmMagic.RuraGC.getType()] = cfg_rura.get("KimeraC(Green) Coordinates","KimeraCGreen_X", KimeraC_X[EnumDqmMagic.RuraGC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraGC.getType()] = cfg_rura.get("KimeraC(Green) Coordinates","KimeraCGreen_Y", KimeraC_Y[EnumDqmMagic.RuraGC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraGC.getType()] = cfg_rura.get("KimeraC(Green) Coordinates","KimeraCGreen_Z", KimeraC_Z[EnumDqmMagic.RuraGC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraGC.getType()] = cfg_rura.get("KimeraC(Green) Coordinates","KimeraCGreen_Dim", KimeraC_Dim[EnumDqmMagic.RuraGC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		KimeraC_X[EnumDqmMagic.RuraBC.getType()] = cfg_rura.get("KimeraC(Blue) Coordinates","KimeraCBlue_X", KimeraC_X[EnumDqmMagic.RuraBC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraBC.getType()] = cfg_rura.get("KimeraC(Blue) Coordinates","KimeraCBlue_Y", KimeraC_Y[EnumDqmMagic.RuraBC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraBC.getType()] = cfg_rura.get("KimeraC(Blue) Coordinates","KimeraCBlue_Z", KimeraC_Z[EnumDqmMagic.RuraBC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraBC.getType()] = cfg_rura.get("KimeraC(Blue) Coordinates","KimeraCBlue_Dim", KimeraC_Dim[EnumDqmMagic.RuraBC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

		KimeraC_X[EnumDqmMagic.RuraYC.getType()] = cfg_rura.get("KimeraC(Yellow) Coordinates","KimeraCYellow_X", KimeraC_X[EnumDqmMagic.RuraYC.getType()], "jump to posX setting").getInt();
		KimeraC_Y[EnumDqmMagic.RuraYC.getType()] = cfg_rura.get("KimeraC(Yellow) Coordinates","KimeraCYellow_Y", KimeraC_Y[EnumDqmMagic.RuraYC.getType()] ,"jump to posY setting").getInt();
		KimeraC_Z[EnumDqmMagic.RuraYC.getType()] = cfg_rura.get("KimeraC(Yellow) Coordinates","KimeraCYellow_Z", KimeraC_Z[EnumDqmMagic.RuraYC.getType()] ,"jump to posZ setting").getInt();
		KimeraC_Dim[EnumDqmMagic.RuraYC.getType()] = cfg_rura.get("KimeraC(Yellow) Coordinates","KimeraCYellow_Dim", KimeraC_Dim[EnumDqmMagic.RuraYC.getType()] ,"only use dimension setting. You can use this magic at this setting Dimension").getInt();

	}
}


