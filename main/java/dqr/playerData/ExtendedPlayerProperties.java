package dqr.playerData;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import dqr.PacketHandler;
import dqr.items.magic.DqmItemMagicRuraSin;
import dqr.items.magic.DqmItemMagicRuraSin2;
import dqr.items.magic.DqmItemMagicRuraSinC;

public class ExtendedPlayerProperties implements IExtendedEntityProperties {
   /* MOD固有の文字列。EntityPlayerに登録時に使用。
   MOD内で複数のIExtendedEntityPropertiesを使う場合は、別の文字列をそれぞれ割り当てること。*/
    public final static String EXT_PROP_NAME = "DqmPlayerData";

    private int TabidachiFlg;
    private int Job;
    private int[] JobLv = new int[32];
    private int[] JobExp = new int[32];
    private int[] JobSp = new int[32];

    //初期化の薬用param
    private float[] JobHP = new float[32];
    private int[] JobMP = new int[32];
    private int[] JobTikara = new int[32];
    private int[] JobKasikosa = new int[32];

    //バフ計算用
  //0:職業補正 1:種系 2:黄金の実 3:装備セット効果
    private float[] arrayHP = new float[32];
    private int[] arrayMP = new int[32];
    private int[] arrayATK = new int[32];
    private int[] arrayMAG = new int[32];
    private int[] arrayDEF = new int[32];

    private int[] arrayTikara = new int[32];
    private int[] arrayMamori = new int[32];
    private int[] arraySubayasa = new int[32];
    private int[] arrayKasikosa = new int[32];

    private int[] JukurenLv = new int[64];
    private int[] JukurenExp = new int[64];
    private int[] JukurenWP = new int[64];

    private int Kougeki;
    private int Bougyo;
    private int Maryoku;

    private int Tikara;
    private int Kasikosa;

    private int Mikawasi;
    private int[] arrayMikawasi = new int[32];

    private int Kaisinritu;
    private int KaisinMax = 4;
    private int KaisinMin = 2;
    private int[] arrayKaisinritu = new int[32];


    private int Gold;
    private int Medal;
    //private int Coin;
    private int KillCount;
    private int DeathCount;

    private float HP = 20.0F;
    private float MaxHP = 20.0F;
    private int MP;
    private int MaxMP;

    private int weapon; //0:素手 1:バニラ剣 2:剣 3:勇者剣 4:拳 5:爪 6:鎚 7:斧 8:鞭 9:槍 10:短剣 11:弓 12:投擲 13:棍
    private int[] weaponMode = new int[64]; //1:斧モード 2:ツルハシモード 3:爪モード

    private double[] RuraSinX = new double[10];
    private double[] RuraSinY = new double[10];
    private double[] RuraSinZ = new double[10];
    private int[] RuraSinDim = new int[10];
    private int[] RuraSinEnable = new int[10];
    private int RuraSinSelect;
    private int RuraSinSelect2;
    private int RuraSinSelectC;

    private double[] RuraX = new double[5];
    private double[] RuraY = new double[5];
    private double[] RuraZ = new double[5];
    private int[] RuraDim = new int[5];
    private int[] RuraEnable = new int[5];

    private double[] BasiRuraX = new double[5];
    private double[] BasiRuraY = new double[5];
    private double[] BasiRuraZ = new double[5];
    private int[] BasiRuraDim = new int[5];
    private int[] BasiRuraEnable = new int[5];

    private double[] KimeraX = new double[5];
    private double[] KimeraY = new double[5];
    private double[] KimeraZ = new double[5];
    private int[] KimeraDim = new int[5];
    private int[] KimeraEnable = new int[5];

    private int[] MagicMode = new int[16];

    //NPC会話履歴
    //0:修理屋 1:買取屋 2:銀行 3:武器屋 4:特技ダーマ
    private int[] npcTalk = new int[32];
    private Item bukiyaItem;

    private double[] rarihoLoc = new double[4];

    private int MaxItemUserCnt = 0;

    private int preFoodLevel = -1;

    private String playerName = null;
    private String playerUUID = null;
    private int hardcoreInfo = 0;
    private long birthTime = 0;
    private int birthFlag = 0;

    private int accBuffStop = 0;
/*
    private int sampleInt = 0;
    private double sampleDouble = 0.0D;
    private boolean sampleBoolean = false;
    private String sampleString = "";
    private ItemStack sampleItemStack = new ItemStack(Items.apple);
    private ItemStack[] sampleItemStacks = new ItemStack[10];
    private NBTTagCompound sampleNBTTagCompound = new NBTTagCompound();
*/
    /*EntityPlayerインスタンスから外部保存時の固有文字列を返す
    *1.7ではusername変数が使えないので、コマンド送信時の名前で代用 */
    private static String getSaveKey(EntityPlayer player) {
        return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
    }

    /*EntityPlayerにIExtendedEntityPropertiesを登録。登録文字列はMOD固有のものを割り当てること*/
    public static void register(EntityPlayer player) {
        player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayerProperties());
    }
    /*IExtendedEntityPropertiesをEntityPlayerインスタンスから取得する*/
    public static ExtendedPlayerProperties get(EntityPlayer player) {
        return (ExtendedPlayerProperties)player.getExtendedProperties(EXT_PROP_NAME);
    }


    @Override
    public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound nbt = new NBTTagCompound();
        if(this.Job >= 32)
        {
        	this.Job = 0;
        }
        nbt.setInteger("Job", this.Job);

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("JobLv_" + cnt, JobLv[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("JobExp_" + cnt, JobExp[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("JobSp_" + cnt, JobSp[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setFloat("JobHP_" + cnt, JobHP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("JobMP_" + cnt, JobMP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setFloat("JobTikara_" + cnt, JobTikara[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setFloat("JobKasikosa_" + cnt, JobKasikosa[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setFloat("arrayHP_" + cnt, arrayHP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayMP_" + cnt, arrayMP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayATK_" + cnt, arrayATK[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayMAG_" + cnt, arrayMAG[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayDEF_" + cnt, arrayDEF[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayTikara_" + cnt, arrayTikara[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayMamori_" + cnt, arrayMamori[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arraySubayasa_" + cnt, arraySubayasa[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayKasikosa_" + cnt, arrayKasikosa[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("JukurenLv_" + cnt, JukurenLv[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("JukurenExp_" + cnt, JukurenExp[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("JukurenWP_" + cnt, JukurenWP[cnt]);
        }

        for(int cnt = 0; cnt < 16; cnt++)
        {
        	nbt.setInteger("MagicMode_" + cnt, MagicMode[cnt]);
        }

    	for(int cnt = 0; cnt < RuraX.length; cnt++)
    	{
    		nbt.setDouble("RuraX_" + cnt, this.RuraX[cnt]);
    		nbt.setDouble("RuraY_" + cnt, this.RuraY[cnt]);
    		nbt.setDouble("RuraZ_" + cnt, this.RuraZ[cnt]);
    		nbt.setInteger("RuraDim_" + cnt, this.RuraDim[cnt]);
    		nbt.setInteger("RuraEnable_" + cnt, this.RuraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < BasiRuraX.length; cnt++)
    	{
    		nbt.setDouble("BasiRuraX_" + cnt, this.BasiRuraX[cnt]);
    		nbt.setDouble("BasiRuraY_" + cnt, this.BasiRuraY[cnt]);
    		nbt.setDouble("BasiRuraZ_" + cnt, this.BasiRuraZ[cnt]);
    		nbt.setInteger("BasiRuraDim_" + cnt, this.BasiRuraDim[cnt]);
    		nbt.setInteger("BasiRuraEnable_" + cnt, this.BasiRuraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < KimeraX.length; cnt++)
    	{
    		nbt.setDouble("KimeraX_" + cnt, this.KimeraX[cnt]);
    		nbt.setDouble("KimeraY_" + cnt, this.KimeraY[cnt]);
    		nbt.setDouble("KimeraZ_" + cnt, this.KimeraZ[cnt]);
    		nbt.setInteger("KimeraDim_" + cnt, this.KimeraDim[cnt]);
    		nbt.setInteger("KimeraEnable_" + cnt, this.KimeraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < RuraSinX.length; cnt++)
    	{
    		nbt.setDouble("RuraSinX_" + cnt, this.RuraSinX[cnt]);
    		nbt.setDouble("RuraSinY_" + cnt, this.RuraSinY[cnt]);
    		nbt.setDouble("RuraSinZ_" + cnt, this.RuraSinZ[cnt]);
    		nbt.setInteger("RuraSinDim_" + cnt, this.RuraSinDim[cnt]);
    		nbt.setInteger("RuraSinEnable_" + cnt, this.RuraSinEnable[cnt]);
    	}
    	nbt.setInteger("RuraSinSelect", this.RuraSinSelect);
    	nbt.setInteger("RuraSinSelect2", this.RuraSinSelect2);
    	nbt.setInteger("RuraSinSelectC", this.RuraSinSelectC);

        /*
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("npcTalk_" + cnt, npcTalk[cnt]);
        }
        */

        nbt.setInteger("TabidachiFlg", this.TabidachiFlg);

        nbt.setInteger("Kougeki", this.Kougeki);
        nbt.setInteger("Bougyo", this.Bougyo);
        nbt.setInteger("Maryoku", this.Maryoku);

        nbt.setInteger("Tikara", this.Tikara);
        nbt.setInteger("Mikawasi", this.Mikawasi);
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayMikawasi_" + cnt, arrayMikawasi[cnt]);
        }

        nbt.setInteger("Kasikosa", this.Kasikosa);

        nbt.setInteger("Kaisinritu", this.Kaisinritu);
        nbt.setInteger("KaisinMin", this.KaisinMin);
        nbt.setInteger("KaisinMax", this.KaisinMax);
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayKaisinritu_" + cnt, arrayKaisinritu[cnt]);
        }

        nbt.setLong("BirthTime", this.birthTime);
        nbt.setInteger("BirthFlag", this.birthFlag);
        nbt.setInteger("Gold", this.Gold);
        nbt.setInteger("Medal", this.Medal);
//        nbt.setInteger("Coin", this.Coin);
        nbt.setInteger("KillCount", this.KillCount);
        nbt.setInteger("DeathCount", this.DeathCount);

        nbt.setFloat("HP", this.HP);
        nbt.setFloat("MaxHP", this.MaxHP);
        nbt.setInteger("MP", this.MP);
        nbt.setInteger("MaxMP", this.MaxMP);

        nbt.setInteger("weapon", this.weapon);

        nbt.setInteger("accBuffStop", this.accBuffStop);

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("weaponMode_" + cnt, weaponMode[cnt]);
        }

        for(int cnt = 0; cnt < 4; cnt++)
        {
        	nbt.setDouble("rarihoLoc_" + cnt, rarihoLoc[cnt]);
        }
        /*
        nbt.setInteger("sampleInt", this.sampleInt);
        nbt.setDouble("sampleDouble", this.sampleDouble);
        nbt.setBoolean("sampleBoolean", this.sampleBoolean);
        nbt.setString("sampleString", this.sampleString);
        nbt.setTag("sampleTag", this.sampleNBTTagCompound);
        //ItemStackの保存
        NBTTagCompound itemNBT = new NBTTagCompound();
        this.sampleItemStack.writeToNBT(itemNBT);
        nbt.setTag("sampleItemStack", itemNBT);
        //ItemStackの配列の保存
        NBTTagList itemsTagList = new NBTTagList();
        for (int i = 0; i < this.sampleItemStacks.length; ++i)
        {
            if (this.sampleItemStacks[i] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)i);
                this.sampleItemStacks[i].writeToNBT(var4);
                itemsTagList.appendTag(var4);
            }
        }
        nbt.setTag("Items", itemsTagList);
         */

        if(this.playerName != null)
        {
        	nbt.setString("playerName", this.playerName);
        }

        if(this.playerUUID != null)
        {
        	nbt.setString("playerUUID", this.playerUUID);
        }
        compound.setTag(EXT_PROP_NAME, nbt);
    }

    @Override
    public void loadNBTData(NBTTagCompound compound) {
        NBTTagCompound nbt = (NBTTagCompound)compound.getTag(EXT_PROP_NAME);


        this.Job = nbt.getInteger("Job");
        if(this.Job >= 32)
        {
        	this.Job = 0;
        }
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobLv[cnt] = nbt.getInteger("JobLv_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobExp[cnt] = nbt.getInteger("JobExp_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobSp[cnt] = nbt.getInteger("JobSp_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobHP[cnt] = nbt.getInteger("JobHP_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobMP[cnt] = nbt.getInteger("JobMP_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobTikara[cnt] = nbt.getInteger("JobTikara_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobKasikosa[cnt] = nbt.getInteger("JobKasikosa_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayHP[cnt] = nbt.getFloat("arrayHP_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayMP[cnt] = nbt.getInteger("arrayMP_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayATK[cnt] = nbt.getInteger("arrayATK_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayMAG[cnt] = nbt.getInteger("arrayMAG_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayDEF[cnt] = nbt.getInteger("arrayDEF_" + cnt);
        }



        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayTikara[cnt] = nbt.getInteger("arrayTikara_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayMamori[cnt] = nbt.getInteger("arrayMamori_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arraySubayasa[cnt] = nbt.getInteger("arraySubayasa_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayKasikosa[cnt] = nbt.getInteger("arrayKasikosa_" + cnt);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	JukurenLv[cnt] = nbt.getInteger("JukurenLv_" + cnt);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	JukurenExp[cnt] = nbt.getInteger("JukurenExp_" + cnt);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	JukurenWP[cnt] = nbt.getInteger("JukurenWP_" + cnt);
        }

        for(int cnt = 0; cnt < 16; cnt++)
        {
        	MagicMode[cnt] = nbt.getInteger("MagicMode_" + cnt);
        }

    	for(int cnt = 0; cnt < RuraX.length; cnt++)
    	{
    		RuraX[cnt] = nbt.getDouble("RuraX_" + cnt);
    		RuraY[cnt] = nbt.getDouble("RuraY_" + cnt);
    		RuraZ[cnt] = nbt.getDouble("RuraZ_" + cnt);
    		RuraDim[cnt] = nbt.getInteger("RuraDim_" + cnt);
    		RuraEnable[cnt] = nbt.getInteger("RuraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < BasiRuraX.length; cnt++)
    	{
    		BasiRuraX[cnt] = nbt.getDouble("BasiRuraX_" + cnt);
    		BasiRuraY[cnt] = nbt.getDouble("BasiRuraY_" + cnt);
    		BasiRuraZ[cnt] = nbt.getDouble("BasiRuraZ_" + cnt);
    		BasiRuraDim[cnt] = nbt.getInteger("BasiRuraDim_" + cnt);
    		BasiRuraEnable[cnt] = nbt.getInteger("BasiRuraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < KimeraX.length; cnt++)
    	{
    		KimeraX[cnt] = nbt.getDouble("KimeraX_" + cnt);
    		KimeraY[cnt] = nbt.getDouble("KimeraY_" + cnt);
    		KimeraZ[cnt] = nbt.getDouble("KimeraZ_" + cnt);
    		KimeraDim[cnt] = nbt.getInteger("KimeraDim_" + cnt);
    		KimeraEnable[cnt] = nbt.getInteger("KimeraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < RuraSinX.length; cnt++)
    	{
    		RuraSinX[cnt] = nbt.getDouble("RuraSinX_" + cnt);
    		RuraSinY[cnt] = nbt.getDouble("RuraSinY_" + cnt);
    		RuraSinZ[cnt] = nbt.getDouble("RuraSinZ_" + cnt);
    		RuraSinDim[cnt] = nbt.getInteger("RuraSinDim_" + cnt);
    		RuraSinEnable[cnt] = nbt.getInteger("RuraSinEnable_" + cnt);
    	}
		RuraSinSelect = nbt.getInteger("RuraSinSelect");
		RuraSinSelect2 = nbt.getInteger("RuraSinSelect2");
		RuraSinSelectC = nbt.getInteger("RuraSinSelectC");
        /*
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	npcTalk[cnt] = nbt.getInteger("npcTalk_" + cnt);
        }
        */

        this.TabidachiFlg = nbt.getInteger("TabidachiFlg");

        this.Kougeki = nbt.getInteger("Kougeki");
        this.Bougyo = nbt.getInteger("Bougyo");
        this.Maryoku = nbt.getInteger("Maryoku");

        this.Tikara = nbt.getInteger("Tikara");
        this.Mikawasi = nbt.getInteger("Mikawasi");
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayMikawasi[cnt] = nbt.getInteger("arrayMikawasi_" + cnt);
        }


        this.Kasikosa = nbt.getInteger("Kasikosa");

        this.Kaisinritu = nbt.getInteger("Kaisinritu");
        this.KaisinMin = nbt.getInteger("KaisinMin");
        this.KaisinMax = nbt.getInteger("KaisinMax");
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayKaisinritu[cnt] = nbt.getInteger("arrayKaisinritu_" + cnt);
        }

        this.birthTime = nbt.getLong("BirthTime");
        this.birthFlag = nbt.getInteger("BirthFlag");
        this.Gold = nbt.getInteger("Gold");
        this.Medal = nbt.getInteger("Medal");
//        this.Coin = nbt.getInteger("Coin");
        this.KillCount = nbt.getInteger("KillCount");
        this.DeathCount = nbt.getInteger("DeathCount");

        this.HP = nbt.getFloat("HP");
        this.MaxHP = nbt.getFloat("MaxHP");
        this.MP = nbt.getInteger("MP");
        this.MaxMP = nbt.getInteger("MaxMP");
        this.weapon = nbt.getInteger("weapon");

        this.accBuffStop = nbt.getInteger("accBuffStop");

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	weaponMode[cnt] = nbt.getInteger("weaponMode_" + cnt);
        }

        for(int cnt = 0; cnt < 4; cnt++)
        {
        	rarihoLoc[cnt] = nbt.getDouble("rarihoLoc_" + cnt);
        }

        this.playerName = nbt.getString("playerName");
        this.playerUUID = nbt.getString("playerUUID");

        /*
        this.sampleInt = nbt.getInteger("sampleInt");
        this.sampleDouble = nbt.getDouble("sampleDouble");
        this.sampleBoolean = nbt.getBoolean("sampleBoolean");
        this.sampleString = nbt.getString("sampleString");
        this.sampleNBTTagCompound = nbt.getCompoundTag("sampleTag");
        //ItemStackの読み込み
        this.sampleItemStack = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("sampleItemStack"));
        //ItemStackの配列の読み込み
        NBTTagList itemsTagList = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
        this.sampleItemStacks = new ItemStack[10];
        for (int i = 0; i < itemsTagList.tagCount(); ++i)
        {
            NBTTagCompound var4 = itemsTagList.getCompoundTagAt(i);
            int slot = var4.getByte("Slot") & 255;

            if (slot >= 0 && slot < this.sampleItemStacks.length)
            {
                this.sampleItemStacks[slot] = ItemStack.loadItemStackFromNBT(var4);
            }
        }
        */
    }

    @Override
    /*初期化メソッド。今のところ使う必要はない。*/
    public void init(Entity entity, World world) {}

    /*ServerのIExtendedEntityPropertiesを読み込んで、Clientに送信するメソッド*/
    public void loadProxyData(EntityPlayer player) {
        ExtendedPlayerProperties playerData = ExtendedPlayerProperties.get(player);
        NBTTagCompound savedData = PlayerDataHandler.getEntityData(getSaveKey(player));
        if (savedData != null) { playerData.loadNBTData(savedData); }
        PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(player), (EntityPlayerMP)player);
    }

    /*以降、各変数のGetterおよびSetter。
    * 使い方としては、EntityPlayerのインスタンスが取得できるメソッド内で、
    * ExtendedPlayerProperties.get(playerインスタンス).setSampleInt(sample)
    * と呼び出す。*/
    public int getTabidachiFlg() {
        return TabidachiFlg;
    }
    public void setTabidachiFlg(int par1) {
        this.TabidachiFlg = par1;
    }

    public int getJob() {
        return Job;
    }
    public void setJob(int par1) {
        this.Job = par1;
    }

    public int[] getJobLvA() {
    	if(JobLv == null) JobLv = new int[32];
        return JobLv;
    }
    public void setJobLvA(int[] par1) {
    	if(JobLv == null) JobLv = new int[32];
        this.JobLv = par1;
    }
    public int getJobLv(int par1) {
    	if(JobLv == null) JobLv = new int[32];
        return JobLv[par1];
    }
    public void setJobLv(int par1, int par2) {
    	if(JobLv == null) JobLv = new int[32];
        this.JobLv[par1] = par2;
    }

    public int[] getJobExpA() {
    	if(JobExp == null) JobExp = new int[32];
        return JobExp;
    }
    public void setJobExpA(int[] par1) {
    	if(JobExp == null) JobExp = new int[32];
        this.JobExp = par1;
    }
    public int getJobExp(int par1) {
    	if(JobExp == null) JobExp = new int[32];
        return JobExp[par1];
    }
    public void setJobExp(int par1, int par2) {
    	if(JobExp == null) JobExp = new int[32];
        this.JobExp[par1] = par2;
    }

    public int[] getJobSpA() {
    	if(JobSp == null) JobSp = new int[32];
        return JobSp;
    }
    public void setJobSpA(int[] par1) {
    	if(JobSp == null) JobSp = new int[32];
        this.JobSp = par1;
    }
    public int getJobSp(int par1) {
    	if(JobSp == null) JobSp = new int[32];
        return JobSp[par1];
    }
    public void setJobSp(int par1, int par2) {
    	if(JobSp == null) JobSp = new int[32];
        this.JobSp[par1] = par2;
    }

    public float[] getJobHPA() {
    	if(JobHP == null) JobHP = new float[32];
        return JobHP;
    }
    public void setJobHPA(float[] par1) {
    	if(JobHP == null) JobHP = new float[32];
        this.JobHP = par1;
    }
    public float getJobHP(int par1) {
    	if(JobHP == null) JobHP = new float[32];
        return JobHP[par1];
    }
    public void setJobHP(int par1, float par2) {
    	if(JobHP == null) JobHP = new float[32];
        this.JobHP[par1] = par2;
    }

    public int[] getJobTikaraA() {
    	if(JobTikara == null) JobTikara = new int[32];
        return JobTikara;
    }
    public void setJobTikaraA(int[] par1) {
    	if(JobTikara == null) JobTikara = new int[32];
        this.JobTikara = par1;
    }
    public int getJobTikara(int par1) {
    	if(JobTikara == null) JobTikara = new int[32];
        return JobTikara[par1];
    }
    public void setJobTikara(int par1, int par2) {
    	if(JobTikara == null) JobTikara = new int[32];
        this.JobTikara[par1] = par2;
    }

    public int[] getJobKasikosaA() {
    	if(JobKasikosa == null) JobKasikosa = new int[32];
        return JobKasikosa;
    }
    public void setJobKasikosaA(int[] par1) {
    	if(JobKasikosa == null) JobKasikosa = new int[32];
        this.JobKasikosa = par1;
    }
    public int getJobKasikosa(int par1) {
    	if(JobKasikosa == null) JobKasikosa = new int[32];
        return JobKasikosa[par1];
    }
    public void setJobKasikosa(int par1, int par2) {
    	if(JobKasikosa == null) JobKasikosa = new int[32];
        this.JobKasikosa[par1] = par2;
    }





    public int[] getArrayMikawasiA() {
    	if(arrayMikawasi == null) arrayMikawasi = new int[32];
        return arrayMikawasi;
    }
    public void setArrayMikawasiA(int[] par1) {
    	if(arrayMikawasi == null) arrayMikawasi = new int[32];
        this.arrayMP = par1;
    }
    public int getArrayMikawasi(int par1) {
    	if(arrayMikawasi == null) arrayMikawasi = new int[32];
        return arrayMikawasi[par1];
    }
    public void setArrayMikawasi(int par1, int par2) {
    	if(arrayMikawasi == null) arrayMikawasi = new int[32];
        this.arrayMikawasi[par1] = par2;
    }


    public int[] getArrayKaisinrituA() {
    	if(arrayKaisinritu == null) arrayKaisinritu = new int[32];
        return arrayKaisinritu;
    }
    public void setArrayKaisinrituA(int[] par1) {
    	if(arrayKaisinritu == null) arrayKaisinritu = new int[32];
        this.arrayMP = par1;
    }
    public int getArrayKaisinritu(int par1) {
    	if(arrayKaisinritu == null) arrayKaisinritu = new int[32];
        return arrayKaisinritu[par1];
    }
    public void setArrayKaisinritu(int par1, int par2) {
    	if(arrayKaisinritu == null) arrayKaisinritu = new int[32];
        this.arrayKaisinritu[par1] = par2;
    }



    public float[] getArrayHPA() {
    	if(arrayHP == null) arrayHP = new float[32];
        return arrayHP;
    }
    public void setArrayHPA(float[] par1) {
    	if(arrayHP == null) arrayHP = new float[32];
        this.arrayHP = par1;
    }
    public float getArrayHP(int par1) {
    	if(arrayHP == null) arrayHP = new float[32];
        return arrayHP[par1];
    }
    public void setArrayHP(int par1, float par2) {
    	if(arrayHP == null) arrayHP = new float[32];
        this.arrayHP[par1] = par2;
    }

    public int[] getArrayMPA() {
    	if(arrayMP == null) arrayMP = new int[32];
        return arrayMP;
    }
    public void setArrayMPA(int[] par1) {
    	if(arrayMP == null) arrayMP = new int[32];
        this.arrayMP = par1;
    }
    public int getArrayMP(int par1) {
    	if(arrayMP == null) arrayMP = new int[32];
        return arrayMP[par1];
    }
    public void setArrayMP(int par1, int par2) {
    	if(arrayMP == null) arrayMP = new int[32];
        this.arrayMP[par1] = par2;
    }

    public int[] getArrayATKA() {
    	if(arrayATK == null) arrayATK = new int[32];
        return arrayATK;
    }
    public void setArrayATKA(int[] par1) {
    	if(arrayATK == null) arrayATK = new int[32];
        this.arrayATK = par1;
    }
    public int getArrayATK(int par1) {
    	if(arrayATK == null) arrayATK = new int[32];
        return arrayATK[par1];
    }
    public void setArrayATK(int par1, int par2) {
    	if(arrayATK == null) arrayATK = new int[32];
        this.arrayATK[par1] = par2;
    }

    public int[] getArrayMAGA() {
    	if(arrayMAG == null) arrayMAG = new int[32];
        return arrayMAG;
    }
    public void setArrayMAGA(int[] par1) {
    	if(arrayMAG == null) arrayMAG = new int[32];
        this.arrayMAG = par1;
    }
    public int getArrayMAG(int par1) {
    	if(arrayMAG == null) arrayMAG = new int[32];
        return arrayMAG[par1];
    }
    public void setArrayMAG(int par1, int par2) {
    	if(arrayMAG == null) arrayMAG = new int[32];
        this.arrayMAG[par1] = par2;
    }

    public int[] getArrayDEFA() {
    	if(arrayDEF == null) arrayDEF = new int[32];
        return arrayDEF;
    }
    public void setArrayDEFA(int[] par1) {
    	if(arrayDEF == null) arrayDEF = new int[32];
        this.arrayDEF = par1;
    }
    public int getArrayDEF(int par1) {
    	if(arrayDEF == null) arrayDEF = new int[32];
        return arrayDEF[par1];
    }
    public void setArrayDEF(int par1, int par2) {
    	if(arrayDEF == null) arrayDEF = new int[32];
        this.arrayDEF[par1] = par2;
    }

    public int[] getArrayTikaraA() {
    	if(arrayTikara == null) arrayTikara = new int[32];
        return arrayTikara;
    }
    public void setArrayTikaraA(int[] par1) {
    	if(arrayTikara == null) arrayTikara = new int[32];
        this.arrayTikara = par1;
    }
    public int getArrayTikara(int par1) {
    	if(arrayTikara == null) arrayTikara = new int[32];
        return arrayTikara[par1];
    }
    public void setArrayTikara(int par1, int par2) {
    	if(arrayTikara == null) arrayTikara = new int[32];
        this.arrayTikara[par1] = par2;
    }

    public int[] getArrayMamoriA() {
    	if(arrayMamori == null) arrayMamori = new int[32];
        return arrayMamori;
    }
    public void setArrayMamoriA(int[] par1) {
    	if(arrayMamori == null) arrayMamori = new int[32];
        this.arrayMamori = par1;
    }
    public int getArrayMamori(int par1) {
    	if(arrayMamori == null) arrayMamori = new int[32];
        return arrayMamori[par1];
    }
    public void setArrayMamori(int par1, int par2) {
    	if(arrayMamori == null) arrayMamori = new int[32];
        this.arrayMamori[par1] = par2;
    }

    public int[] getArraySubayasaA() {
    	if(arraySubayasa == null) arraySubayasa = new int[21];
        return arraySubayasa;
    }
    public void setArraySubayasaA(int[] par1) {
    	if(arraySubayasa == null) arraySubayasa = new int[21];
        this.arraySubayasa = par1;
    }
    public int getArraySubayasa(int par1) {
    	if(arraySubayasa == null) arraySubayasa = new int[21];
        return arraySubayasa[par1];
    }
    public void setArraySubayasa(int par1, int par2) {
    	if(arraySubayasa == null) arraySubayasa = new int[32];
        this.arraySubayasa[par1] = par2;
    }

    public int[] getArrayKasikosaA() {
    	if(arrayKasikosa == null) arrayKasikosa = new int[21];
        return arrayKasikosa;
    }
    public void setArrayKasikosaA(int[] par1) {
    	if(arrayKasikosa == null) arrayKasikosa = new int[21];
        this.arrayKasikosa = par1;
    }
    public int getArrayKasikosa(int par1) {
    	if(arrayKasikosa == null) arrayKasikosa = new int[32];
        return arrayKasikosa[par1];
    }
    public void setArrayKasikosa(int par1, int par2) {
    	if(arrayKasikosa == null) arrayKasikosa = new int[32];
        this.arrayKasikosa[par1] = par2;
    }

    public int[] getJobMPA() {
    	if(JobMP == null) JobMP = new int[32];
        return JobMP;
    }
    public void setJobMPA(int[] par1) {
    	if(JobMP == null) JobMP = new int[32];
        this.JobMP = par1;
    }
    public int getJobMP(int par1) {
    	if(JobMP == null) JobMP = new int[32];
        return JobMP[par1];
    }
    public void setJobMP(int par1, int par2) {
    	if(JobMP == null) JobMP = new int[32];
        this.JobMP[par1] = par2;
    }

    public int[] getJukurenLvA() {
    	if(JukurenLv == null) JukurenLv = new int[64];
        return JukurenLv;
    }
    public void setJukurenLvA(int[] par1) {
    	if(JukurenLv == null) JukurenLv = new int[64];
        this.JukurenLv = par1;
    }
    public int getJukurenLv(int par1) {
    	if(JukurenLv == null) JukurenLv = new int[64];
        return JukurenLv[par1];
    }
    public void setJukurenLv(int par1, int par2) {
    	if(JukurenLv == null) JukurenLv = new int[64];
        this.JukurenLv[par1] = par2;
    }

    public int[] getNpcTalkA() {
    	if(npcTalk == null) npcTalk = new int[32];
        return npcTalk;
    }
    public void setNpcTalkA(int[] par1) {
    	if(npcTalk == null) npcTalk = new int[32];
        this.npcTalk = par1;
    }
    public int getNpcTalk(int par1) {
    	if(npcTalk == null) npcTalk = new int[32];
        return npcTalk[par1];
    }
    public void setNpcTalk(int par1, int par2) {
    	if(npcTalk == null) npcTalk = new int[32];
        this.npcTalk[par1] = par2;
    }

    public int[] getJukurenExpA() {
    	if(JukurenExp == null) JukurenExp = new int[64];
        return JukurenExp;
    }
    public void setJukurenExpA(int[] par1) {
    	if(JukurenExp == null) JukurenExp = new int[64];
        this.JukurenExp = par1;
    }
    public int getJukurenExp(int par1) {
    	if(JukurenExp == null) JukurenExp = new int[64];
        return JukurenExp[par1];
    }
    public void setJukurenExp(int par1, int par2) {
    	if(JukurenExp == null) JukurenExp = new int[64];
        this.JukurenExp[par1] = par2;
    }


    public int[] getJukurenWPA() {
    	if(JukurenWP == null) JukurenWP = new int[64];
        return JukurenWP;
    }
    public void setJukurenWPA(int[] par1) {
    	if(JukurenWP == null) JukurenWP = new int[64];
        this.JukurenWP = par1;
    }
    public int getJukurenWP(int par1) {
    	if(JukurenWP == null) JukurenWP = new int[64];
        //System.out.println("VAL:" +par1 + "/" + JukurenWP[par1]);
        return JukurenWP[par1];

    }
    public void setJukurenWP(int par1, int par2) {
    	if(JukurenWP == null) JukurenWP = new int[64];
        this.JukurenWP[par1] = par2;
        //System.out.println("VAL:" +par1 + "/" + par2);
    }


    public int[] getMagicModeA() {
    	if(MagicMode == null) MagicMode = new int[16];
        return MagicMode;
    }
    public int getMagicMode(int par1) {
    	if(MagicMode == null) MagicMode = new int[16];
        return MagicMode[par1];
    }
    public void setMagicModeA(int[] par1)
    {
    	if(MagicMode == null) MagicMode = new int[16];
    	this.MagicMode = par1;
    }
    public void setMagicMode(int par1, int par2)
    {
    	if(MagicMode == null) MagicMode = new int[16];
        this.MagicMode[par1] = par2;
    }

    public long getBirthTime() {
        return birthTime;
    }
    public void setBirthTime(long par1) {
        this.birthTime = par1;
    }

    public int getBirthFlag() {
        return birthFlag;
    }
    public void setBirthFlag(int par1) {
        this.birthFlag = par1;
    }

    public int getAccBuffStop() {
        return accBuffStop;
    }
    public void setAccBuffStop(int par1) {
        this.accBuffStop = par1;
    }

    public int getKougeki() {
        return Kougeki;
    }
    public void setKougeki(int par1) {
        this.Kougeki = par1;
    }

    public int getBougyo() {
        return Bougyo;
    }
    public void setBougyo(int par1) {
        this.Bougyo = par1;
    }

    public int getMaryoku() {
        return Maryoku;
    }
    public void setMaryoku(int par1) {
        this.Maryoku = par1;
    }

    public int getTikara() {
        return Tikara;
    }
    public void setTikara(int par1) {
        this.Tikara = par1;
    }

    public int getMikawasi() {
        return Mikawasi;
    }
    public void setMikawasi(int par1) {
        this.Mikawasi = par1;
    }

    public int getKasikosa() {
        return Kasikosa;
    }
    public void setKasikosa(int par1) {
        this.Kasikosa = par1;
    }

    public int getKaisinMin() {
        return KaisinMin;
    }
    public void setKaisinMin(int par1) {
        this.KaisinMin = par1;
    }

    public int getKaisinMax() {
        return KaisinMax;
    }
    public void setKaisinMax(int par1) {
        this.KaisinMax = par1;
    }

    public int getKaisinritu() {
        return Kaisinritu;
    }
    public void setKaisinritu(int par1) {
        this.Kaisinritu = par1;
    }

    public int getGold() {
        return Gold;
    }
    public void setGold(int par1) {
        this.Gold = par1;
    }

    public int getMedal() {
        return Medal;
    }
    public void setMedal(int par1) {
        this.Medal = par1;
    }

    /*
    public int getCoin() {
        return Coin;
    }
    public void setCoin(int par1) {
        this.Coin = par1;
    }
    */

    public int getKillCount() {
        return KillCount;
    }
    public void setKillCount(int par1) {
        this.KillCount = par1;
    }

    public int getDeathCount() {
        return DeathCount;
    }
    public void setDeathCount(int par1) {
        this.DeathCount = par1;
    }

    public float getHP() {
        return HP;
    }
    public void setHP(float par1) {
        this.HP = par1;
    }

    public float getMaxHP() {
        return MaxHP;
    }
    public void setMaxHP(float f) {
        this.MaxHP = f;
    }

    public int getMP() {
        return MP;
    }
    public void setMP(int par1) {
        this.MP = par1;
    }

    public int getMaxMP() {
        return MaxMP;
    }
    public void setMaxMP(int par1) {
        this.MaxMP = par1;
    }

    public int getWeapon() {
        return weapon;
    }
    public void setWeapon(int par1) {
        this.weapon = par1;
    }

    public int[] getWeaponModeA() {
    	if(weaponMode == null) weaponMode = new int[32];
        return weaponMode;
    }
    public void setWeaponModeA(int[] par1) {
    	if(weaponMode == null) weaponMode = new int[32];
        this.weaponMode = par1;
    }
    public int getWeaponMode(int par1) {
    	if(weaponMode == null) weaponMode = new int[32];
        return weaponMode[par1];
    }
    public void setWeaponMode(int par1, int par2) {
    	if(weaponMode == null) weaponMode = new int[32];
        this.weaponMode[par1] = par2;
    }

    public Item getBukiyaItem() {
        return bukiyaItem;
    }
    public void setBukiyaItem(Item par1) {
        this.bukiyaItem = par1;
    }


    public void setRura(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.RuraX[par1] = par2;
    	this.RuraY[par1] = par3;
    	this.RuraZ[par1] = par4;
    	this.RuraDim[par1] = par5;
    	this.RuraEnable[par1] = par6;
    }

    public void setRuraSin(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.RuraSinX[par1] = par2;
    	this.RuraSinY[par1] = par3;
    	this.RuraSinZ[par1] = par4;
    	this.RuraSinDim[par1] = par5;
    	this.RuraSinEnable[par1] = par6;
    }

    public void setBasiRura(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.BasiRuraX[par1] = par2;
    	this.BasiRuraY[par1] = par3;
    	this.BasiRuraZ[par1] = par4;
    	this.BasiRuraDim[par1] = par5;
    	this.BasiRuraEnable[par1] = par6;
    }

    public void setKimera(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.KimeraX[par1] = par2;
    	this.KimeraY[par1] = par3;
    	this.KimeraZ[par1] = par4;
    	this.KimeraDim[par1] = par5;
    	this.KimeraEnable[par1] = par6;
    }

    public int getRuraSinSelectX(Item item)
    {
    	if(item instanceof DqmItemMagicRuraSin)
    	{
    		return this.RuraSinSelect;
    	}else if(item instanceof DqmItemMagicRuraSin2)
    	{
    		return this.RuraSinSelect2;
    	}else if(item instanceof DqmItemMagicRuraSinC)
    	{
    		return this.RuraSinSelectC;
    	}

    	return -1;
    }
    public void setRuraSinSelectX(Item item, int par1)
    {
    	if(item instanceof DqmItemMagicRuraSin)
    	{
    		this.RuraSinSelect = par1;
    	}else if(item instanceof DqmItemMagicRuraSin2)
    	{
    		this.RuraSinSelect2 = par1;
    	}else if(item instanceof DqmItemMagicRuraSinC)
    	{
    		this.RuraSinSelectC = par1;
    	}
    }

    public int getRuraSinSelect()
    {
    	return this.RuraSinSelect;
    }
    public void setRuraSinSelect(int par1)
    {
    	this.RuraSinSelect = par1;
    }

    public int getRuraSinSelect2()
    {
    	return this.RuraSinSelect2;
    }
    public void setRuraSinSelect2(int par1)
    {
    	this.RuraSinSelect2 = par1;
    }

    public int getRuraSinSelectC()
    {
    	return this.RuraSinSelectC;
    }
    public void setRuraSinSelectC(int par1)
    {
    	this.RuraSinSelectC = par1;
    }

    public double[] getBasiRura(int par1)
    {
    	return new double[]{this.BasiRuraX[par1], this.BasiRuraY[par1], this.BasiRuraZ[par1], this.BasiRuraDim[par1]};
    }

    public void setBasiRuraX(int par1, double par2)
    {
    	this.BasiRuraX[par1] = par2;
    }
    public double getBasiRuraX(int par1)
    {
    	return this.BasiRuraX[par1];
    }

    public void setBasiRuraY(int par1, double par2)
    {
    	this.BasiRuraY[par1] = par2;
    }
    public double getBasiRuraY(int par1)
    {
    	return this.BasiRuraY[par1];
    }

    public void setBasiRuraZ(int par1, double par2)
    {
    	this.BasiRuraZ[par1] = par2;
    }
    public double getBasiRuraZ(int par1)
    {
    	return this.BasiRuraZ[par1];
    }

    public void setBasiRuraDim(int par1, int par2)
    {
    	this.BasiRuraDim[par1] = par2;
    }
    public double getBasiRuraDim(int par1)
    {
    	return this.BasiRuraDim[par1];
    }

    public void setBasiRuraEnable(int par1, int par2)
    {
    	this.BasiRuraEnable[par1] = par2;
    }
    public double getBasiRuraEnable(int par1)
    {
    	return this.BasiRuraEnable[par1];
    }


    public double[] getRura(int par1)
    {
    	return new double[]{this.RuraX[par1], this.RuraY[par1], this.RuraZ[par1], this.RuraDim[par1]};
    }

    public void setRuraX(int par1, double par2)
    {
    	this.RuraX[par1] = par2;
    }
    public double getRuraX(int par1)
    {
    	return this.RuraX[par1];
    }

    public void setRuraY(int par1, double par2)
    {
    	this.RuraY[par1] = par2;
    }
    public double getRuraY(int par1)
    {
    	return this.RuraY[par1];
    }

    public void setRuraZ(int par1, double par2)
    {
    	this.RuraZ[par1] = par2;
    }
    public double getRuraZ(int par1)
    {
    	return this.RuraZ[par1];
    }

    public void setRuraDim(int par1, int par2)
    {
    	this.RuraDim[par1] = par2;
    }
    public double getRuraDim(int par1)
    {
    	return this.RuraDim[par1];
    }

    public void setRuraEnable(int par1, int par2)
    {
    	this.RuraEnable[par1] = par2;
    }
    public double getRuraEnable(int par1)
    {
    	return this.RuraEnable[par1];
    }


    public double[] getRuraSin(int par1)
    {
    	return new double[]{this.RuraSinX[par1], this.RuraSinY[par1], this.RuraSinZ[par1], this.RuraSinDim[par1]};
    }

    public void setRuraSinX(int par1, double par2)
    {
    	this.RuraSinX[par1] = par2;
    }
    public double getRuraSinX(int par1)
    {
    	return this.RuraSinX[par1];
    }

    public void setRuraSinY(int par1, double par2)
    {
    	this.RuraSinY[par1] = par2;
    }
    public double getRuraSinY(int par1)
    {
    	return this.RuraSinY[par1];
    }

    public void setRuraSinZ(int par1, double par2)
    {
    	this.RuraSinZ[par1] = par2;
    }
    public double getRuraSinZ(int par1)
    {
    	return this.RuraSinZ[par1];
    }

    public void setRuraSinDim(int par1, int par2)
    {
    	this.RuraSinDim[par1] = par2;
    }
    public int getRuraSinDim(int par1)
    {
    	return this.RuraSinDim[par1];
    }

    public void setRuraSinEnable(int par1, int par2)
    {
    	this.RuraSinEnable[par1] = par2;
    }
    public int getRuraSinEnable(int par1)
    {
    	return this.RuraSinEnable[par1];
    }

    public double[] getKimera(int par1)
    {
    	return new double[]{this.KimeraX[par1], this.KimeraY[par1], this.KimeraZ[par1], this.KimeraDim[par1]};
    }

    public void setKimeraX(int par1, double par2)
    {
    	this.KimeraX[par1] = par2;
    }
    public double getKimeraX(int par1)
    {
    	return this.KimeraX[par1];
    }

    public void setKimeraY(int par1, double par2)
    {
    	this.KimeraY[par1] = par2;
    }
    public double getKimeraY(int par1)
    {
    	return this.KimeraY[par1];
    }

    public void setKimeraZ(int par1, double par2)
    {
    	this.KimeraZ[par1] = par2;
    }
    public double getKimeraZ(int par1)
    {
    	return this.KimeraZ[par1];
    }

    public void setKimeraDim(int par1, int par2)
    {
    	this.KimeraDim[par1] = par2;
    }
    public double getKimeraDim(int par1)
    {
    	return this.KimeraDim[par1];
    }

    public void setKimeraEnable(int par1, int par2)
    {
    	this.KimeraEnable[par1] = par2;
    }
    public double getKimeraEnable(int par1)
    {
    	return this.KimeraEnable[par1];
    }

    public double[] getRarihoLoc() {
        return rarihoLoc;
    }
    public void setRarihoLoc(double[] par1) {
        this.rarihoLoc = par1;
    }

    public int getMaxItemUserCnt() {
        return MaxItemUserCnt;
    }
    public void setMaxItemUserCnt(int par1) {
        this.MaxItemUserCnt = par1;
    }

    public int getPreFoodLevel() {
        return preFoodLevel;
    }
    public void setPreFoodLevel(int par1) {
        this.preFoodLevel = par1;
    }

    public String getPlayerName() {
        return this.playerName;
    }
    public void setPlayerName(String par1) {
        this.playerName = par1;
    }

    public String getPlayerUUID() {
        return this.playerUUID;
    }
    public void setPlayerUUID(String par1) {
        this.playerUUID = par1;
    }


    public int getHardcoreInfo() {
        return hardcoreInfo;
    }
    public void setHardcoreInfo(int par1) {
        this.hardcoreInfo = par1;
    }
    /*
    public int getSampleInt() {
        return sampleInt;
    }

    public void setSampleInt(int sampleInt) {
        this.sampleInt = sampleInt;
    }

    public double getSampleDouble() {
        return sampleDouble;
    }

    public void setSampleDouble(double sampleDouble) {
        this.sampleDouble = sampleDouble;
    }

    public boolean isSampleBoolean() {
        return sampleBoolean;
    }

    public void setSampleBoolean(boolean sampleBoolean) {
        this.sampleBoolean = sampleBoolean;
    }

    public String getSampleString() {
        return sampleString;
    }

    public void setSampleString(String sampleString) {
        this.sampleString = sampleString;
    }

    public ItemStack getSampleItemStack() {
        return sampleItemStack;
    }

    public void setSampleItemStack(ItemStack sampleItemStack) {
        this.sampleItemStack = sampleItemStack;
    }

    public ItemStack[] getSampleItemStacks() {
        return sampleItemStacks;
    }

    public void setSampleItemStacks(ItemStack[] sampleItemStacks) {
        this.sampleItemStacks = sampleItemStacks;
    }

    public NBTTagCompound getSampleNBTTagCompound() {
        return sampleNBTTagCompound;
    }

    public void setSampleNBTTagCompound(NBTTagCompound sampleNBTTagCompound) {
        this.sampleNBTTagCompound = sampleNBTTagCompound;
    }
    */
}
