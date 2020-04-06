package dqr.playerData;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.entity.npcEntity.npc.DqmEntityNPCBukiya;
import dqr.entity.petEntity.DqmPetBase;

public class ExtendedPlayerProperties3 implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "DqmPlayerData3";
	public final static int SKILL_MAX_COUNTER = 20;
	//public static EntityPlayer thePlayer = null;
	private int[] jobPermission = new int[32];
	private NBTTagCompound NBTPlayerPetList = new NBTTagCompound();
	private int petCount;

	private int dataVersion3 = 0; //職業特技データ移行フラグ
	private int dataVersion4 = 0; //ペットデータ移行フラグ
    private String playerName = null;
    private String playerUUID = null;

	//配合用ペットデータ
	private NBTTagCompound haigouPet1 = null;
	private NBTTagCompound haigouPet2 = null;

	private int deadCheckFlg = 0;
	//private NBTTagCompound NBTWeaponSkillPermission = new NBTTagCompound();
	//private int[] skillPermission = new int[10];
	private int[][] weaponSkillPermission = new int[64][SKILL_MAX_COUNTER];
	private int[] weaponSkillSet = new int[64];


	private int[][] jobSkillSet = new int[32][9];
	private int[][] jobSkillSet2 = new int[32][9];
	private int[][] jobSPSkillSet = new int[32][36];
	private int[] JobSp = new int[32];


	//private long[][] jobSPSkillCT = new long[32][36];
	private NBTTagCompound jobSPSkillCT = new NBTTagCompound();
	private NBTTagCompound jobSPSkillDuration = new NBTTagCompound();

	private NBTTagCompound petStatudData = null;
	private DqmPetBase statusPet;
	private DqmEntityNPCBukiya guiNPCBukiya;
	private int guiBukiyaPhase;
	private int guiBukiyaPrice;
	private String statusPetOwner;
	//private DqmPetBase invPet;

	//private NBTTagCompound partyMemberData = new NBTTagCompound();

    private double[] W_RuraX = new double[5];
    private double[] W_RuraY = new double[5];
    private double[] W_RuraZ = new double[5];
    private int[] W_RuraDim = new int[5];
    private int[] W_RuraEnable = new int[5];

    private double[] W_BasiRuraX = new double[5];
    private double[] W_BasiRuraY = new double[5];
    private double[] W_BasiRuraZ = new double[5];
    private int[] W_BasiRuraDim = new int[5];
    private int[] W_BasiRuraEnable = new int[5];

    private double[] W_KimeraX = new double[5];
    private double[] W_KimeraY = new double[5];
    private double[] W_KimeraZ = new double[5];
    private int[] W_KimeraDim = new int[5];
    private int[] W_KimeraEnable = new int[5];

    private int[] C_RuraX = new int[5];
    private int[] C_RuraY = new int[5];
    private int[] C_RuraZ = new int[5];
    private int[] C_RuraDim = new int[5];
    private int[] C_RuraEnable = new int[5];

    private int[] C_BasiRuraX = new int[5];
    private int[] C_BasiRuraY = new int[5];
    private int[] C_BasiRuraZ = new int[5];
    private int[] C_BasiRuraDim = new int[5];
    private int[] C_BasiRuraEnable = new int[5];

    private int[] C_KimeraX = new int[5];
    private int[] C_KimeraY = new int[5];
    private int[] C_KimeraZ = new int[5];
    private int[] C_KimeraDim = new int[5];
    private int[] C_KimeraEnable = new int[5];

    private double[] W_RuraSinX = new double[10];
    private double[] W_RuraSinY = new double[10];
    private double[] W_RuraSinZ = new double[10];
    private int[] W_RuraSinDim = new int[10];
    private int[] W_RuraSinEnable = new int[10];

    private int[] C_RuraSinX = new int[10];
    private int[] C_RuraSinY = new int[10];
    private int[] C_RuraSinZ = new int[10];
    private int[] C_RuraSinDim = new int[10];
    private String[] C_RuraSinName = new String[10];
    private int[] C_RuraSinEnable = new int[10];

    public boolean tooltipInfoFlg = false;
    public boolean tooltipShortRuraSin = false;
    public boolean tooltipShortRuraSin2 = false;
    public boolean tooltipShortRuraSinC = false;
    public boolean tooltipShortSkillBook = false;
    //private

    private int Coin;

    private static String getSaveKey(EntityPlayer player) {
        return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
    }

    public static void register(EntityPlayer player) {
        player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayerProperties3());
    }

    public static ExtendedPlayerProperties3 get(EntityPlayer player) {
        return (ExtendedPlayerProperties3)player.getExtendedProperties(EXT_PROP_NAME);
    }

    public void loadProxyData(EntityPlayer player) {
        ExtendedPlayerProperties3 playerData = ExtendedPlayerProperties3.get(player);
        NBTTagCompound savedData = PlayerDataHandler.getEntityData(getSaveKey(player));
        if (savedData != null) { playerData.loadNBTData(savedData); }
        PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3(player), (EntityPlayerMP)player);
    }

	@Override
	public void init(Entity entity, World world) {}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound nbt = new NBTTagCompound();
        DQR.func.debugString("PlayerDataTest1_saveNBTData");

        if(DQR.bugFixFlg0947_8 == 1)
        {
        	if(dataVersion3 == 0)
        	{
		        for(int cnt = 0; cnt < 32; cnt++)
		        {
		        	if(nbt.hasKey("JobSp_" + cnt)){
		        		nbt.removeTag("JobSp_" + cnt);
		        	}
		        	//nbt.setInteger("JobSp_" + cnt, JobSp[cnt]);
		        }


		        for(int job = 0; job < 32; job++)
		        {
		        	for(int idx = 0; idx < 9; idx++)
		        	{
		        		if(nbt.hasKey("jobSkillSet_" + job + "_" + idx))
		        		{
		        			nbt.removeTag("jobSkillSet_" + job + "_" + idx);
		        		}
		        	}
		        }

		        for(int job = 0; job < 32; job++)
		        {
		        	for(int idx = 0; idx < 9; idx++)
		        	{
		        		if(nbt.hasKey("jobSkillSet2_" + job + "_" + idx))
		        		{
		        			nbt.removeTag("jobSkillSet2_" + job + "_" + idx);
		        		}
		        	}
		        }

		        for(int job = 0; job < 32; job++)
		        {
		        	for(int idx = 0; idx < 36; idx++)
		        	{
		        		if(nbt.hasKey("jobSPSkillSet_" + job + "_" + idx))
		        		{
		        			nbt.removeTag("jobSPSkillSet_" + job + "_" + idx);
		        		}
		        	}
		        }

	        	if(nbt.hasKey("jobSPSkillCT"))
	        	{
	        		nbt.removeTag("jobSPSkillCT");
	        	}
	        	if(nbt.hasKey("jobSPSkillDuration"))
	        	{
	        		nbt.removeTag("jobSPSkillDuration");
	        	}

	            for(int job = 0; job < 32; job++)
	            {
	            	for(int idx = 0; idx < 36; idx++)
	            	{
	            		if(nbt.hasKey("jobSPSkillCT_" + job + "_" + idx))
	            		{
	            			nbt.removeTag("jobSPSkillCT_" + job + "_" + idx);
	            		}
	            	}
	            }
        	}
            dataVersion3 = 1;
        }else
        {
	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	nbt.setInteger("JobSp_" + cnt, JobSp[cnt]);
	        }


	        for(int job = 0; job < jobSkillSet.length; job++)
	        {
	        	for(int idx = 0; idx < jobSkillSet[job].length; idx++)
	        	{
	        		nbt.setInteger("jobSkillSet_" + job + "_" + idx, jobSkillSet[job][idx]);
	        	}
	        }

	        for(int job = 0; job < jobSkillSet2.length; job++)
	        {
	        	for(int idx = 0; idx < jobSkillSet2[job].length; idx++)
	        	{
	        		nbt.setInteger("jobSkillSet2_" + job + "_" + idx, jobSkillSet2[job][idx]);
	        	}
	        }

	        for(int job = 0; job < jobSPSkillSet.length; job++)
	        {
	        	for(int idx = 0; idx < jobSPSkillSet[job].length; idx++)
	        	{
	        		nbt.setInteger("jobSPSkillSet_" + job + "_" + idx, jobSPSkillSet[job][idx]);
	        	}
	        }

            nbt.setTag("jobSPSkillCT", jobSPSkillCT);
            nbt.setTag("jobSPSkillDuration", jobSPSkillDuration);

            /*
            for(int job = 0; job < jobSPSkillCT.length; job++)
            {
            	for(int idx = 0; idx < jobSPSkillCT[job].length; idx++)
            	{
            		nbt.setLong("jobSPSkillCT_" + job + "_" + idx, jobSPSkillCT[job][idx]);
            	}
            }
            */
        }


        /*
        if(DQR.bugFixFlg0947_8 == 1 && dataVersion3 == 0 && thePlayer != null)
        {
        	ExtendedPlayerProperties5.get(thePlayer).
        }else if(DQR.bugFixFlg0947_8 == 1 && dataVersion3 == 1)
        {
        	//dataversionフラグ成立後はここでは何もしない
        }else
        {

        }
        */

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("jobPermission_" + cnt, jobPermission[cnt]);
        }

        if(dataVersion4 == 0)
        {
        	if(nbt.hasKey("NBTPlayerPetList"))
        	{
        		nbt.removeTag("NBTPlayerPetList");
        	}
        	dataVersion4 = 1;
        }
        /*
        if(dataVersion4 == 0)
        {
        	nbt.setTag("NBTPlayerPetList", NBTPlayerPetList);
        }else if(dataVersion4 == 1)
        {
        	if(nbt.hasKey("NBTPlayerPetList"))
        	{
        		nbt.removeTag("NBTPlayerPetList");
        	}
        }
        */

        nbt.setInteger("petCount", petCount);

        //nbt.setTag("NBTWeaponSkillPermission", NBTWeaponSkillPermission);
        for(int cnt = 0; cnt < weaponSkillPermission.length; cnt++)
        {
        	for(int cnt2 = 0; cnt2 < SKILL_MAX_COUNTER; cnt2++)
        	{
        		nbt.setInteger("weaponSkillPermission_" + cnt + "_" + cnt2, weaponSkillPermission[cnt][cnt2]);
        	}
        	//nbt.setInteger("jobPermission_" + cnt, jobPermission[cnt]);
        }

        for(int cnt = 0; cnt < weaponSkillSet.length; cnt++)
        {
        	nbt.setInteger("weaponSkillSet" + cnt, weaponSkillSet[cnt]);
        }



        nbt.setInteger("deadCheckFlg", deadCheckFlg);

        if(haigouPet1 == null)
        {
        	haigouPet1 = new NBTTagCompound();
        }
        nbt.setTag("haigouPet1", haigouPet1);

        if(haigouPet2 == null)
        {
        	haigouPet2 = new NBTTagCompound();
        }
        nbt.setTag("haigouPet2", haigouPet2);

    	for(int cnt = 0; cnt < W_RuraX.length; cnt++)
    	{
    		nbt.setDouble("W_RuraX_" + cnt, this.W_RuraX[cnt]);
    		nbt.setDouble("W_RuraY_" + cnt, this.W_RuraY[cnt]);
    		nbt.setDouble("W_RuraZ_" + cnt, this.W_RuraZ[cnt]);
    		nbt.setInteger("W_RuraDim_" + cnt, this.W_RuraDim[cnt]);
    		nbt.setInteger("W_RuraEnable_" + cnt, this.W_RuraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < W_BasiRuraX.length; cnt++)
    	{
    		nbt.setDouble("W_BasiRuraX_" + cnt, this.W_BasiRuraX[cnt]);
    		nbt.setDouble("W_BasiRuraY_" + cnt, this.W_BasiRuraY[cnt]);
    		nbt.setDouble("W_BasiRuraZ_" + cnt, this.W_BasiRuraZ[cnt]);
    		nbt.setInteger("W_BasiRuraDim_" + cnt, this.W_BasiRuraDim[cnt]);
    		nbt.setInteger("W_BasiRuraEnable_" + cnt, this.W_BasiRuraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < W_KimeraX.length; cnt++)
    	{
    		nbt.setDouble("W_KimeraX_" + cnt, this.W_KimeraX[cnt]);
    		nbt.setDouble("W_KimeraY_" + cnt, this.W_KimeraY[cnt]);
    		nbt.setDouble("W_KimeraZ_" + cnt, this.W_KimeraZ[cnt]);
    		nbt.setInteger("W_KimeraDim_" + cnt, this.W_KimeraDim[cnt]);
    		nbt.setInteger("W_KimeraEnable_" + cnt, this.W_KimeraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < C_RuraX.length; cnt++)
    	{
    		nbt.setInteger("C_RuraX_" + cnt, this.C_RuraX[cnt]);
    		nbt.setInteger("C_RuraY_" + cnt, this.C_RuraY[cnt]);
    		nbt.setInteger("C_RuraZ_" + cnt, this.C_RuraZ[cnt]);
    		nbt.setInteger("C_RuraDim_" + cnt, this.C_RuraDim[cnt]);
    		nbt.setInteger("C_RuraEnable_" + cnt, this.C_RuraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < C_BasiRuraX.length; cnt++)
    	{
    		nbt.setInteger("C_BasiRuraX_" + cnt, this.C_BasiRuraX[cnt]);
    		nbt.setInteger("C_BasiRuraY_" + cnt, this.C_BasiRuraY[cnt]);
    		nbt.setInteger("C_BasiRuraZ_" + cnt, this.C_BasiRuraZ[cnt]);
    		nbt.setInteger("C_BasiRuraDim_" + cnt, this.C_BasiRuraDim[cnt]);
    		nbt.setInteger("C_BasiRuraEnable_" + cnt, this.C_BasiRuraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < C_KimeraX.length; cnt++)
    	{
    		nbt.setInteger("C_KimeraX_" + cnt, this.C_KimeraX[cnt]);
    		nbt.setInteger("C_KimeraY_" + cnt, this.C_KimeraY[cnt]);
    		nbt.setInteger("C_KimeraZ_" + cnt, this.C_KimeraZ[cnt]);
    		nbt.setInteger("C_KimeraDim_" + cnt, this.C_KimeraDim[cnt]);
    		nbt.setInteger("C_KimeraEnable_" + cnt, this.C_KimeraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < C_RuraSinX.length; cnt++)
    	{
    		nbt.setInteger("C_RuraSinX_" + cnt, this.C_RuraSinX[cnt]);
    		nbt.setInteger("C_RuraSinY_" + cnt, this.C_RuraSinY[cnt]);
    		nbt.setInteger("C_RuraSinZ_" + cnt, this.C_RuraSinZ[cnt]);
    		nbt.setInteger("C_RuraSinDim_" + cnt, this.C_RuraSinDim[cnt]);
    		if(this.C_RuraSinName[cnt] == null)
    		{
    			this.C_RuraSinName[cnt] = "";

    		}
    		nbt.setString("C_RuraSinName_" + cnt, this.C_RuraSinName[cnt]);

    		nbt.setInteger("C_RuraSinEnable_" + cnt, this.C_RuraSinEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < W_RuraSinX.length; cnt++)
    	{
    		nbt.setDouble("W_RuraSinX_" + cnt, this.W_RuraSinX[cnt]);
    		nbt.setDouble("W_RuraSinY_" + cnt, this.W_RuraSinY[cnt]);
    		nbt.setDouble("W_RuraSinZ_" + cnt, this.W_RuraSinZ[cnt]);
    		nbt.setInteger("W_RuraSinDim_" + cnt, this.W_RuraSinDim[cnt]);
    		nbt.setInteger("W_RuraSinEnable_" + cnt, this.W_RuraSinEnable[cnt]);
    	}

    	nbt.setInteger("Coin", this.Coin);

        if(this.playerName != null)
        {
        	nbt.setString("playerName", this.playerName);
        }

        if(this.playerUUID != null)
        {
        	nbt.setString("playerUUID", this.playerUUID);
        }

        nbt.setInteger("dataVersion3", this.dataVersion3);
        nbt.setInteger("dataVersion4", this.dataVersion4);

        compound.setTag(EXT_PROP_NAME, nbt);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		// TODO 自動生成されたメソッド・スタブ
		DQR.func.debugString("PlayerDataTest1_loadNBTData");
		if(compound == null)
		{
			//System.out.println("packet lost");
			return;
		}
		NBTTagCompound nbt = (NBTTagCompound)compound.getTag(EXT_PROP_NAME);

		dataVersion3 = nbt.getInteger("dataVersion3");
		dataVersion4 = nbt.getInteger("dataVersion4");

        if(DQR.bugFixFlg0947_8 == 1)
        {
        	if(dataVersion3 == 0)
        	{
		        for(int cnt = 0; cnt < 32; cnt++)
		        {
		        	if(nbt.hasKey("JobSp_" + cnt))
		        	{
		        		nbt.removeTag("JobSp_" + cnt);
		        	}

		        	//JobSp[cnt] = nbt.getInteger("JobSp_" + cnt);
		        }



		        for(int job = 0; job < 32; job++)
		        {
		        	for(int idx = 0; idx < 9; idx++)
		        	{
		        		if(nbt.hasKey("jobSkillSet_" + job + "_" + idx)){
		        			nbt.removeTag("jobSkillSet_" + job + "_" + idx);
		        		}
		        	}
		        }

		        for(int job = 0; job < 32; job++)
		        {
		        	for(int idx = 0; idx < 9; idx++)
		        	{
		        		if(nbt.hasKey("jobSkillSet2_" + job + "_" + idx)){
		        			nbt.removeTag("jobSkillSet2_" + job + "_" + idx);
		        		}
		        	}
		        }

		        for(int job = 0; job < 32; job++)
		        {
		        	for(int idx = 0; idx < 36; idx++)
		        	{
		        		if(nbt.hasKey("jobSPSkillSet_" + job + "_" + idx)){
		        			nbt.removeTag("jobSPSkillSet_" + job + "_" + idx);
		        		}
		        	}
		        }

	        	if(nbt.hasKey("jobSPSkillCT"))
	        	{
	        		nbt.removeTag("jobSPSkillCT");
	        	}

	        	if(nbt.hasKey("jobSPSkillDuration"))
	        	{
	        		nbt.removeTag("jobSPSkillDuration");
	        	}


		        for(int job = 0; job < 32; job++)
		        {
		        	for(int idx = 0; idx < 36; idx++)
		        	{
		            	if(nbt.hasKey("jobSPSkillCT_" + job + "_" + idx))
		            	{
		            		nbt.removeTag("jobSPSkillCT_" + job + "_" + idx);
		            	}
		        	}
		        }

		        dataVersion3 = 1;
        	}
        }else
        {
	        for(int cnt = 0; cnt < 32; cnt++)
	        {
	        	JobSp[cnt] = nbt.getInteger("JobSp_" + cnt);
	        }


	        for(int job = 0; job < jobSkillSet.length; job++)
	        {
	        	for(int idx = 0; idx < jobSkillSet[job].length; idx++)
	        	{
	        		jobSkillSet[job][idx] = nbt.getInteger("jobSkillSet_" + job + "_" + idx);
	        	}
	        }

	        for(int job = 0; job < jobSkillSet2.length; job++)
	        {
	        	for(int idx = 0; idx < jobSkillSet2[job].length; idx++)
	        	{
	        		jobSkillSet2[job][idx] = nbt.getInteger("jobSkillSet2_" + job + "_" + idx);
	        	}
	        }

	        for(int job = 0; job < jobSPSkillSet.length; job++)
	        {
	        	for(int idx = 0; idx < jobSPSkillSet[job].length; idx++)
	        	{
	        		jobSPSkillSet[job][idx] = nbt.getInteger("jobSPSkillSet_" + job + "_" + idx);
	        	}
	        }



	        if(nbt.getTag("jobSPSkillCT") != null && nbt.getTag("jobSPSkillCT") instanceof NBTTagCompound)
	        {
	        	jobSPSkillCT = (NBTTagCompound)nbt.getTag("jobSPSkillCT");
	        }else
	        {
	        	jobSPSkillCT = new NBTTagCompound();
	        }

	        if(nbt.getTag("jobSPSkillDuration") != null && nbt.getTag("jobSPSkillDuration") instanceof NBTTagCompound)
	        {
	        	jobSPSkillDuration = (NBTTagCompound)nbt.getTag("jobSPSkillDuration");
	        }else
	        {
	        	jobSPSkillDuration = new NBTTagCompound();
	        }

	        /*
	        for(int job = 0; job < jobSPSkillCT.length; job++)
	        {
	        	for(int idx = 0; idx < jobSPSkillCT[job].length; idx++)
	        	jobSPSkillCT[job][idx] = nbt.getLong("jobSPSkillCT_" + job + "_" + idx);
	        }
	        */
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	jobPermission[cnt] = nbt.getInteger("jobPermission_" + cnt);
        }

        if(dataVersion4 == 0)
        {
        	NBTPlayerPetList = nbt.getCompoundTag("NBTPlayerPetList");
        }
        petCount = nbt.getInteger("petCount");

        this.playerName = nbt.getString("playerName");
        this.playerUUID = nbt.getString("playerUUID");

        //NBTWeaponSkillPermission = nbt.getCompoundTag("NBTWeaponSkillPermission");
        for(int cnt = 0; cnt < weaponSkillPermission.length; cnt++)
        {
        	for(int cnt2 = 0; cnt2 < SKILL_MAX_COUNTER; cnt2++)
        	{
        		//nbt.setInteger("weaponSkillPermission_" + cnt + "_" + cnt2, weaponSkillPermission[cnt][cnt2]);
        		weaponSkillPermission[cnt][cnt2] = nbt.getInteger("weaponSkillPermission_" + cnt + "_" + cnt2);
        	}
        	//nbt.setInteger("jobPermission_" + cnt, jobPermission[cnt]);
        }

        for(int cnt = 0; cnt < weaponSkillSet.length; cnt++)
        {
        	weaponSkillSet[cnt] = nbt.getInteger("weaponSkillSet" + cnt);
        }


        deadCheckFlg = nbt.getInteger("deadCheckFlg");

        haigouPet1 = nbt.getCompoundTag("haigouPet1");
        if(haigouPet1 == null)
        {
        	haigouPet1 = new NBTTagCompound();
        }

        haigouPet2 = nbt.getCompoundTag("haigouPet2");
        if(haigouPet2 == null)
        {
        	haigouPet2 = new NBTTagCompound();
        }


    	for(int cnt = 0; cnt < W_RuraX.length; cnt++)
    	{
    		W_RuraX[cnt] = nbt.getDouble("W_RuraX_" + cnt);
    		W_RuraY[cnt] = nbt.getDouble("W_RuraY_" + cnt);
    		W_RuraZ[cnt] = nbt.getDouble("W_RuraZ_" + cnt);
    		W_RuraDim[cnt] = nbt.getInteger("W_RuraDim_" + cnt);
    		W_RuraEnable[cnt] = nbt.getInteger("W_RuraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < W_BasiRuraX.length; cnt++)
    	{
    		W_BasiRuraX[cnt] = nbt.getDouble("W_BasiRuraX_" + cnt);
    		W_BasiRuraY[cnt] = nbt.getDouble("W_BasiRuraY_" + cnt);
    		W_BasiRuraZ[cnt] = nbt.getDouble("W_BasiRuraZ_" + cnt);
    		W_BasiRuraDim[cnt] = nbt.getInteger("W_BasiRuraDim_" + cnt);
    		W_BasiRuraEnable[cnt] = nbt.getInteger("W_BasiRuraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < W_KimeraX.length; cnt++)
    	{
    		W_KimeraX[cnt] = nbt.getDouble("W_KimeraX_" + cnt);
    		W_KimeraY[cnt] = nbt.getDouble("W_KimeraY_" + cnt);
    		W_KimeraZ[cnt] = nbt.getDouble("W_KimeraZ_" + cnt);
    		W_KimeraDim[cnt] = nbt.getInteger("W_KimeraDim_" + cnt);
    		W_KimeraEnable[cnt] = nbt.getInteger("W_KimeraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < C_RuraX.length; cnt++)
    	{
    		C_RuraX[cnt] = nbt.getInteger("C_RuraX_" + cnt);
    		C_RuraY[cnt] = nbt.getInteger("C_RuraY_" + cnt);
    		C_RuraZ[cnt] = nbt.getInteger("C_RuraZ_" + cnt);
    		C_RuraDim[cnt] = nbt.getInteger("C_RuraDim_" + cnt);
    		C_RuraEnable[cnt] = nbt.getInteger("C_RuraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < C_BasiRuraX.length; cnt++)
    	{
    		C_BasiRuraX[cnt] = nbt.getInteger("C_BasiRuraX_" + cnt);
    		C_BasiRuraY[cnt] = nbt.getInteger("C_BasiRuraY_" + cnt);
    		C_BasiRuraZ[cnt] = nbt.getInteger("C_BasiRuraZ_" + cnt);
    		C_BasiRuraDim[cnt] = nbt.getInteger("C_BasiRuraDim_" + cnt);
    		C_BasiRuraEnable[cnt] = nbt.getInteger("C_BasiRuraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < C_KimeraX.length; cnt++)
    	{
    		C_KimeraX[cnt] = nbt.getInteger("C_KimeraX_" + cnt);
    		C_KimeraY[cnt] = nbt.getInteger("C_KimeraY_" + cnt);
    		C_KimeraZ[cnt] = nbt.getInteger("C_KimeraZ_" + cnt);
    		C_KimeraDim[cnt] = nbt.getInteger("C_KimeraDim_" + cnt);
    		C_KimeraEnable[cnt] = nbt.getInteger("C_KimeraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < W_RuraSinX.length; cnt++)
    	{
    		W_RuraSinX[cnt] = nbt.getDouble("W_RuraSinX_" + cnt);
    		W_RuraSinY[cnt] = nbt.getDouble("W_RuraSinY_" + cnt);
    		W_RuraSinZ[cnt] = nbt.getDouble("W_RuraSinZ_" + cnt);
    		W_RuraSinDim[cnt] = nbt.getInteger("W_RuraSinDim_" + cnt);
    		W_RuraSinEnable[cnt] = nbt.getInteger("W_RuraSinEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < C_RuraSinX.length; cnt++)
    	{
    		C_RuraSinX[cnt] = nbt.getInteger("C_RuraSinX_" + cnt);
    		C_RuraSinY[cnt] = nbt.getInteger("C_RuraSinY_" + cnt);
    		C_RuraSinZ[cnt] = nbt.getInteger("C_RuraSinZ_" + cnt);
    		C_RuraSinDim[cnt] = nbt.getInteger("C_RuraSinDim_" + cnt);
    		C_RuraSinName[cnt] = nbt.getString("C_RuraSinName_" + cnt);
    		C_RuraSinEnable[cnt] = nbt.getInteger("C_RuraSinEnable_" + cnt);
    	}

    	this.Coin = nbt.getInteger("Coin");

    	//nbt.setInteger("dataVersion3", this.dataVersion3);
        //partyTagList.func_150296_c()
	}

    public int[] getJobPermissionA() {
    	if(jobPermission == null) jobPermission = new int[32];
        return jobPermission;
    }
    public void setjobPermissionA(int[] par1) {
    	if(jobPermission == null) jobPermission = new int[32];
        this.jobPermission = par1;
    }
    public int getJobPermission(int par1) {
    	if(jobPermission == null) jobPermission = new int[32];
        return jobPermission[par1];
    }
    public void setJobPermission(int par1, int par2) {
    	if(jobPermission == null) jobPermission = new int[32];
        this.jobPermission[par1] = par2;
    }

    public int[][] getWeaponSkillPermissionA() {
    	if(weaponSkillPermission == null) weaponSkillPermission = new int[64][];
        return weaponSkillPermission;
    }
    public void setWeaponSkillPermissionA(int[][] par1) {
    	if(weaponSkillPermission == null) weaponSkillPermission = new int[64][];
        this.weaponSkillPermission = par1;
    }

    public int[] getWeaponSkillPermissionC(int par1) {
    	if(weaponSkillPermission == null) weaponSkillPermission = new int[64][];
        return weaponSkillPermission[par1];
    }
    public void setWeaponSkillPermissionC(int par1, int[] par2) {
    	if(weaponSkillPermission == null) weaponSkillPermission = new int[64][];
        this.weaponSkillPermission[par1] = par2;
    }

    public int getWeaponSkillPermission(int par1, int par2) {
    	if(weaponSkillPermission == null) weaponSkillPermission = new int[64][];
    	if(par2 < 0)
    	{
    		return -1;
    	}else
    	{
    		return weaponSkillPermission[par1][par2];
    	}
    }
    public void setWeaponSkillPermission(int par1, int par2, int par3) {
    	if(weaponSkillPermission == null) weaponSkillPermission = new int[64][];
    	//System.out.println("VAL:" + par1 + "/" + par2 + "/" + par3);
    	if(par2 >= 0)
    	{
    		this.weaponSkillPermission[par1][par2] = par3;
    	}
    }

    /*
    public int[] getWeaponSkillPermission(int par1) {
    	if(weaponSkillPermission == null) weaponSkillPermission = new int[64][];
        return weaponSkillPermission[par1];
    }
    public void setJobPermission(int par1, int par2) {
    	if(jobPermission == null) jobPermission = new int[32];
        this.jobPermission[par1] = par2;
    }
    */

    public NBTTagCompound getHaigouPet1() {
        return haigouPet1;
    }

    public void setHaigouPet1(NBTTagCompound nbt) {
        this.haigouPet1 = nbt;
    }

    public NBTTagCompound getHaigouPet2() {
        return haigouPet2;
    }

    public void setHaigouPet2(NBTTagCompound nbt) {
        this.haigouPet2 = nbt;
    }

    public NBTTagCompound getFixNBTPlayerPetList() {
        return NBTPlayerPetList;
    }

    public void setFixNBTPlayerPetList()
    {
    	dataVersion4 = 1;
    }
    /*
    public NBTTagCompound getNBTPlayerPetList() {
        return NBTPlayerPetList;
    }

    public void setNBTPlayerPetList(NBTTagCompound nbt) {
    	//System.out.println("TEST_EPP : ");
        this.NBTPlayerPetList = nbt;
    }
	*/

    public void setPetCount(int par1) {
        this.petCount = par1;
    }
    public int getPetCount() {
        return this.petCount;
    }
    public void plusPetCount(int par1) {
    	this.petCount = this.petCount + par1;
    }
    public void minusPetCount(int par1) {
    	if(this.petCount - par1 > 0)
    	{
    		this.petCount = this.petCount - par1;
    	}else
    	{
    		this.petCount = 0;
    	}
    }

    public int[] getWeaponSkillSetnA() {
    	if(weaponSkillSet == null) weaponSkillSet = new int[64];
        return weaponSkillSet;
    }
    public void setWeaponSkillSetA(int[] par1) {
    	if(weaponSkillSet == null) weaponSkillSet = new int[64];
        this.weaponSkillSet = par1;
    }
    public int getWeaponSkillSet(int par1) {
    	if(weaponSkillSet == null) weaponSkillSet = new int[64];
        return weaponSkillSet[par1];
    }
    public void setWeaponSkillSet(int par1, int par2) {
    	if(weaponSkillSet == null) weaponSkillSet = new int[64];
        this.weaponSkillSet[par1] = par2;
    }

    /*
    public int[][] getJobSkillSetA() {
    	if(jobSkillSet == null) jobSkillSet = new int[32][9];
        return jobSkillSet;
    }
    public void setJobSkillSetA(int[][] par1) {
    	if(jobSkillSet == null) jobSkillSet = new int[32][9];
        this.jobSkillSet = par1;
    }
    public int[] getJobSkillSetA2(int job) {
    	if(jobSkillSet == null) jobSkillSet = new int[32][9];
        return jobSkillSet[job];
    }
    public void setJobSkillSetA2(int[] par1, int job) {
    	if(jobSkillSet == null) jobSkillSet = new int[32][9];
        this.jobSkillSet[job] = par1;
    }

    public int getJobSkillSet(int job, int idx) {
    	if(jobSkillSet == null) jobSkillSet = new int[32][9];
        return jobSkillSet[job][idx];
    }
    public void setJobSkillSet(int job, int idx, int par1) {
    	if(jobSkillSet == null) jobSkillSet = new int[32][9];
        this.jobSkillSet[job][idx] = par1;
    }


    public int[][] getJobSkillSet2A() {
    	if(jobSkillSet2 == null) jobSkillSet2 = new int[32][9];
        return jobSkillSet2;
    }
    public void setJobSkillSet2A(int[][] par1) {
    	if(jobSkillSet2 == null) jobSkillSet2 = new int[32][9];
        this.jobSkillSet2 = par1;
    }
    public int[] getJobSkillSet2A2(int job) {
    	if(jobSkillSet2 == null) jobSkillSet2 = new int[32][9];
        return jobSkillSet2[job];
    }
    public void setJobSkillSet2A2(int[] par1, int job) {
    	if(jobSkillSet2 == null) jobSkillSet2 = new int[32][9];
        this.jobSkillSet2[job] = par1;
    }

    public int getJobSkillSet2(int job, int idx) {
    	if(jobSkillSet2 == null) jobSkillSet2 = new int[32][9];
        return jobSkillSet2[job][idx];
    }
    public void setJobSkillSet2(int job, int idx, int par1) {
    	if(jobSkillSet2 == null) jobSkillSet2 = new int[32][9];
        this.jobSkillSet2[job][idx] = par1;
    }


    public int[][] getJobSPSkillSetA() {
    	if(jobSPSkillSet == null) jobSPSkillSet = new int[32][9];
        return jobSPSkillSet;
    }
    public void setJobSPSkillSetA(int[][] par1) {
    	if(jobSPSkillSet == null) jobSPSkillSet = new int[32][9];
        this.jobSPSkillSet = par1;
    }
    public int[] getJobSPSkillSetA2(int job) {
    	if(jobSPSkillSet == null) jobSPSkillSet = new int[32][9];
        return jobSPSkillSet[job];
    }
    public void setJobSPSkillSetA2(int[] par1, int job) {
    	if(jobSPSkillSet == null) jobSPSkillSet = new int[32][9];
        this.jobSPSkillSet[job] = par1;
    }

    public int getJobSPSkillSet(int job, int idx) {
    	if(jobSPSkillSet == null) jobSPSkillSet = new int[32][9];
        return jobSPSkillSet[job][idx];
    }
    public void setJobSPSkillSet(int job, int idx, int par1) {
    	if(jobSPSkillSet == null) jobSPSkillSet = new int[32][9];
        this.jobSPSkillSet[job][idx] = par1;
    }
    */

    /*

    public NBTTagCompound getJobSPSkillCTSet() {
    	if(jobSPSkillCT == null){jobSPSkillCT = new NBTTagCompound();}
        return jobSPSkillCT;
    }
    public void setJobSPSkillCTSet(NBTTagCompound par1) {
    	if(par1 != null)
    	{
    		this.jobSPSkillCT = par1;
    	}else
    	{
    		this.jobSPSkillCT = new NBTTagCompound();
    	}
    }

    public long getJobSPSkillCT(int job, int idx) {
        return jobSPSkillCT.getLong("jobSPSkillCT" + "_" + job  + "_" + idx);
    }
    public void setJobSPSkillCT(int job, int idx, long par1) {
        this.jobSPSkillCT.setLong("jobSPSkillCT" + "_" + job  + "_" + idx, par1);
    }

    public NBTTagCompound getJobSPSkillDurationSet() {
    	if(jobSPSkillDuration == null){jobSPSkillDuration = new NBTTagCompound();}
        return jobSPSkillDuration;
    }
    public void setJobSPSkillDurationSet(NBTTagCompound par1) {
    	if(par1 != null)
    	{
    		this.jobSPSkillDuration = par1;
    	}else
    	{
    		this.jobSPSkillDuration = new NBTTagCompound();
    	}
    }

    public long getJobSPSkillDuration(int job, int idx) {
        return jobSPSkillDuration.getLong("jobSPSkillDuration" + "_" + job  + "_" + idx);
    }
    public void setJobSPSkillDuration(int job, int idx, long par1) {
        this.jobSPSkillDuration.setLong("jobSPSkillDuration" + "_" + job  + "_" + idx, par1);
    }

    public void refreshJobSPSkillDuration(long wt)
    {
    	Set nbtSet = this.jobSPSkillDuration.func_150296_c();

    	Iterator ite = nbtSet.iterator();
    	List<String> lst = new ArrayList<String>();
    	while(ite.hasNext())
    	{
    		Object obj = ite.next();
    		if(obj instanceof String)
    		{
    			long fixTime = this.jobSPSkillDuration.getLong((String)obj);
    			if(fixTime < wt)
    			{
    				lst.add((String)obj);
    				//this.jobSPSkillDuration.removeTag((String)obj);
    			}
    			//String name = (String)obj;
    			//System.out.println("TEST : " + name);
    		}
    	}

    	for(int cnt = 0; cnt < lst.size(); cnt++)
    	{
    		this.jobSPSkillDuration.removeTag(lst.get(cnt));
    	}
    }
    */

    /*
    public long[][] getJobSPSkillCTA() {
    	if(jobSPSkillCT == null) jobSPSkillCT = new long[32][9];
        return jobSPSkillCT;
    }
    public void setJobSPSkillCTA(long[][] par1) {
    	if(jobSPSkillCT == null) jobSPSkillCT = new long[32][9];
        this.jobSPSkillCT = par1;
    }
    public long[] getJobSPSkillCTA2(int job) {
    	if(jobSPSkillCT == null) jobSPSkillCT = new long[32][9];
        return jobSPSkillCT[job];
    }
    public void setJobSPSkillCTA2(long[] par1, int job) {
    	if(jobSPSkillCT == null) jobSPSkillCT = new long[32][9];
        this.jobSPSkillCT[job] = par1;
    }

    public long getJobSPSkillCT(int job, int idx) {
    	if(jobSPSkillCT == null) jobSPSkillCT = new long[32][9];
        return jobSPSkillCT[job][idx];
    }
    public void setJobSPSkillCT(int job, int idx, long par1) {
    	if(jobSPSkillCT == null) jobSPSkillCT = new long[32][9];
        this.jobSPSkillCT[job][idx] = par1;
    }
    /*
    public NBTTagCompound getNBTWeaponSkillPermission() {
        return NBTWeaponSkillPermission;
    }

    public void setNBTWeaponSkillPermission(NBTTagCompound nbt) {
        this.NBTWeaponSkillPermission = nbt;
    }
    */

    public void setPetStatudData(NBTTagCompound par1) {
        this.petStatudData = par1;
    }
    public NBTTagCompound getPetStatudData() {
        return this.petStatudData;
    }

    public void setStatusPet(DqmPetBase par1) {
        this.statusPet = par1;
    }
    public DqmPetBase getStatusPet() {
        return this.statusPet;
    }

    public void setGuiNPCBukiya(DqmEntityNPCBukiya par1) {
        this.guiNPCBukiya = par1;
    }
    public DqmEntityNPCBukiya getGuiNPCBukiya() {
        return this.guiNPCBukiya;
    }

    public void setStatusPetOwner(String par1) {
        this.statusPetOwner = par1;
    }
    public String getStatusPetOwner() {
        return this.statusPetOwner;
    }


    public void setDeadCheckFlg(int par1) {
        this.deadCheckFlg = par1;
    }
    public int getDeadCheckFlg() {
        return this.deadCheckFlg;
    }
    /*
    public void setInvPet(DqmPetBase par1) {
       //this.invPet = par1;
    	this.statusPet = par1;
    }
    public DqmPetBase getInvPet() {
        //return this.invPet;
    	return this.statusPet;
    }
    */

    public void setW_Rura(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.W_RuraX[par1] = par2;
    	this.W_RuraY[par1] = par3;
    	this.W_RuraZ[par1] = par4;
    	this.W_RuraDim[par1] = par5;
    	this.W_RuraEnable[par1] = par6;
    }

    public void setW_BasiRura(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.W_BasiRuraX[par1] = par2;
    	this.W_BasiRuraY[par1] = par3;
    	this.W_BasiRuraZ[par1] = par4;
    	this.W_BasiRuraDim[par1] = par5;
    	this.W_BasiRuraEnable[par1] = par6;
    }

    public void setW_Kimera(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.W_KimeraX[par1] = par2;
    	this.W_KimeraY[par1] = par3;
    	this.W_KimeraZ[par1] = par4;
    	this.W_KimeraDim[par1] = par5;
    	this.W_KimeraEnable[par1] = par6;
    }


    public double[] getW_Rura(int par1)
    {
    	return new double[]{this.W_RuraX[par1], this.W_RuraY[par1], this.W_RuraZ[par1], this.W_RuraDim[par1]};
    }

    public void setW_RuraXA(double[] par2)
    {
    	this.W_RuraX = par2;
    }
    public void setW_RuraYA(double[] par2)
    {
    	this.W_RuraY = par2;
    }
    public void setW_RuraZA(double[] par2)
    {
    	this.W_RuraZ = par2;
    }
    public void setW_RuraDimA(int[] par2)
    {
    	this.W_RuraDim = par2;
    }
    public void setW_RuraEnableA(int[] par2)
    {
    	this.W_RuraEnable = par2;
    }


    public void setW_BasiRuraXA(double[] par2)
    {
    	this.W_BasiRuraX = par2;
    }
    public void setW_BasiRuraYA(double[] par2)
    {
    	this.W_BasiRuraY = par2;
    }
    public void setW_BasiRuraZA(double[] par2)
    {
    	this.W_BasiRuraZ = par2;
    }
    public void setW_BasiRuraDimA(int[] par2)
    {
    	this.W_BasiRuraDim = par2;
    }
    public void setW_BasiRuraEnableA(int[] par2)
    {
    	this.W_BasiRuraEnable = par2;
    }


    public void setW_KimeraXA(double[] par2)
    {
    	this.W_KimeraX = par2;
    }
    public void setW_KimeraYA(double[] par2)
    {
    	this.W_KimeraY = par2;
    }
    public void setW_KimeraZA(double[] par2)
    {
    	this.W_KimeraZ = par2;
    }
    public void setW_KimeraDimA(int[] par2)
    {
    	this.W_KimeraDim = par2;
    }
    public void setW_KimeraEnableA(int[] par2)
    {
    	this.W_KimeraEnable = par2;
    }

    public double[] getW_RuraXA()
    {
    	return this.W_RuraX;
    }
    public double[] getW_RuraYA()
    {
    	return this.W_RuraY;
    }
    public double[] getW_RuraZA()
    {
    	return this.W_RuraZ;
    }
    public int[] getW_RuraDimA()
    {
    	return this.W_RuraDim;
    }
    public int[] getW_RuraEnableA()
    {
    	return this.W_RuraEnable;
    }

    public double[] getW_BasiRuraXA()
    {
    	return this.W_BasiRuraX;
    }
    public double[] getW_BasiRuraYA()
    {
    	return this.W_BasiRuraY;
    }
    public double[] getW_BasiRuraZA()
    {
    	return this.W_BasiRuraZ;
    }
    public int[] getW_BasiRuraDimA()
    {
    	return this.W_BasiRuraDim;
    }
    public int[] getW_BasiRuraEnableA()
    {
    	return this.W_BasiRuraEnable;
    }

    public double[] getW_KimeraXA()
    {
    	return this.W_KimeraX;
    }
    public double[] getW_KimeraYA()
    {
    	return this.W_KimeraY;
    }
    public double[] getW_KimeraZA()
    {
    	return this.W_KimeraZ;
    }
    public int[] getW_KimeraDimA()
    {
    	return this.W_KimeraDim;
    }
    public int[] getW_KimeraEnableA()
    {
    	return this.W_KimeraEnable;
    }

    public void setW_RuraX(int par1, double par2)
    {
    	this.W_RuraX[par1] = par2;
    }
    public double getW_RuraX(int par1)
    {
    	return this.W_RuraX[par1];
    }

    public void setW_RuraY(int par1, double par2)
    {
    	this.W_RuraY[par1] = par2;
    }
    public double getW_RuraY(int par1)
    {
    	return this.W_RuraY[par1];
    }

    public void setW_RuraZ(int par1, double par2)
    {
    	this.W_RuraZ[par1] = par2;
    }
    public double getW_RuraZ(int par1)
    {
    	return this.W_RuraZ[par1];
    }

    public void setW_RuraDim(int par1, int par2)
    {
    	this.W_RuraDim[par1] = par2;
    }
    public double getW_RuraDim(int par1)
    {
    	return this.W_RuraDim[par1];
    }

    public void setW_RuraEnable(int par1, int par2)
    {
    	this.W_RuraEnable[par1] = par2;
    }
    public double getW_RuraEnable(int par1)
    {
    	return this.W_RuraEnable[par1];
    }

    public double[] getW_Kimera(int par1)
    {
    	return new double[]{this.W_KimeraX[par1], this.W_KimeraY[par1], this.W_KimeraZ[par1], this.W_KimeraDim[par1]};
    }

    public void setW_KimeraX(int par1, double par2)
    {
    	this.W_KimeraX[par1] = par2;
    }
    public double getW_KimeraX(int par1)
    {
    	return this.W_KimeraX[par1];
    }

    public void setW_KimeraY(int par1, double par2)
    {
    	this.W_KimeraY[par1] = par2;
    }
    public double getW_KimeraY(int par1)
    {
    	return this.W_KimeraY[par1];
    }

    public void setW_KimeraZ(int par1, double par2)
    {
    	this.W_KimeraZ[par1] = par2;
    }
    public double getW_KimeraZ(int par1)
    {
    	return this.W_KimeraZ[par1];
    }

    public void setW_KimeraDim(int par1, int par2)
    {
    	this.W_KimeraDim[par1] = par2;
    }
    public double getW_KimeraDim(int par1)
    {
    	return this.W_KimeraDim[par1];
    }

    public void setW_KimeraEnable(int par1, int par2)
    {
    	this.W_KimeraEnable[par1] = par2;
    }
    public double getW_KimeraEnable(int par1)
    {
    	return this.W_KimeraEnable[par1];
    }

    public void setW_BasiRuraX(int par1, double par2)
    {
    	this.W_BasiRuraX[par1] = par2;
    }
    public double getW_BasiRuraX(int par1)
    {
    	return this.W_BasiRuraX[par1];
    }

    public void setW_BasiRuraY(int par1, double par2)
    {
    	this.W_BasiRuraY[par1] = par2;
    }
    public double getW_BasiRuraY(int par1)
    {
    	return this.W_BasiRuraY[par1];
    }

    public void setW_BasiRuraZ(int par1, double par2)
    {
    	this.W_BasiRuraZ[par1] = par2;
    }
    public double getW_BasiRuraZ(int par1)
    {
    	return this.W_BasiRuraZ[par1];
    }

    public void setW_BasiRuraDim(int par1, int par2)
    {
    	this.W_BasiRuraDim[par1] = par2;
    }
    public double getW_BasiRuraDim(int par1)
    {
    	return this.W_BasiRuraDim[par1];
    }

    public void setW_BasiRuraEnable(int par1, int par2)
    {
    	this.W_BasiRuraEnable[par1] = par2;
    }
    public double getW_BasiRuraEnable(int par1)
    {
    	return this.W_BasiRuraEnable[par1];
    }



    ///////////////////////////////////////////////////////////


    public void setC_Rura(int par1, int par2, int par3, int par4, int par5, int par6)
    {
    	this.C_RuraX[par1] = par2;
    	this.C_RuraY[par1] = par3;
    	this.C_RuraZ[par1] = par4;
    	this.C_RuraDim[par1] = par5;
    	this.C_RuraEnable[par1] = par6;
    }

    public void setC_BasiRura(int par1, int par2, int par3, int par4, int par5, int par6)
    {
    	this.C_BasiRuraX[par1] = par2;
    	this.C_BasiRuraY[par1] = par3;
    	this.C_BasiRuraZ[par1] = par4;
    	this.C_BasiRuraDim[par1] = par5;
    	this.C_BasiRuraEnable[par1] = par6;
    }

    public void setC_Kimera(int par1, int par2, int par3, int par4, int par5, int par6)
    {
    	this.C_KimeraX[par1] = par2;
    	this.C_KimeraY[par1] = par3;
    	this.C_KimeraZ[par1] = par4;
    	this.C_KimeraDim[par1] = par5;
    	this.C_KimeraEnable[par1] = par6;
    }


    public int[] getC_Rura(int par1)
    {
    	return new int[]{this.C_RuraX[par1], this.C_RuraY[par1], this.C_RuraZ[par1], this.C_RuraDim[par1]};
    }

    public void setC_RuraXA(int[] par2)
    {
    	this.C_RuraX = par2;
    }
    public void setC_RuraYA(int[] par2)
    {
    	this.C_RuraY = par2;
    }
    public void setC_RuraZA(int[] par2)
    {
    	this.C_RuraZ = par2;
    }
    public void setC_RuraDimA(int[] par2)
    {
    	this.C_RuraDim = par2;
    }
    public void setC_RuraEnableA(int[] par2)
    {
    	this.C_RuraEnable = par2;
    }


    public void setC_BasiRuraXA(int[] par2)
    {
    	this.C_BasiRuraX = par2;
    }
    public void setC_BasiRuraYA(int[] par2)
    {
    	this.C_BasiRuraY = par2;
    }
    public void setC_BasiRuraZA(int[] par2)
    {
    	this.C_BasiRuraZ = par2;
    }
    public void setC_BasiRuraDimA(int[] par2)
    {
    	this.C_BasiRuraDim = par2;
    }
    public void setC_BasiRuraEnableA(int[] par2)
    {
    	this.C_BasiRuraEnable = par2;
    }


    public void setC_KimeraXA(int[] par2)
    {
    	this.C_KimeraX = par2;
    }
    public void setC_KimeraYA(int[] par2)
    {
    	this.C_KimeraY = par2;
    }
    public void setC_KimeraZA(int[] par2)
    {
    	this.C_KimeraZ = par2;
    }
    public void setC_KimeraDimA(int[] par2)
    {
    	this.C_KimeraDim = par2;
    }
    public void setC_KimeraEnableA(int[] par2)
    {
    	this.C_KimeraEnable = par2;
    }

    public int[] getC_RuraXA()
    {
    	return this.C_RuraX;
    }
    public int[] getC_RuraYA()
    {
    	return this.C_RuraY;
    }
    public int[] getC_RuraZA()
    {
    	return this.C_RuraZ;
    }
    public int[] getC_RuraDimA()
    {
    	return this.C_RuraDim;
    }
    public int[] getC_RuraEnableA()
    {
    	return this.C_RuraEnable;
    }

    public int[] getC_BasiRuraXA()
    {
    	return this.C_BasiRuraX;
    }
    public int[] getC_BasiRuraYA()
    {
    	return this.C_BasiRuraY;
    }
    public int[] getC_BasiRuraZA()
    {
    	return this.C_BasiRuraZ;
    }
    public int[] getC_BasiRuraDimA()
    {
    	return this.C_BasiRuraDim;
    }
    public int[] getC_BasiRuraEnableA()
    {
    	return this.C_BasiRuraEnable;
    }

    public int[] getC_KimeraXA()
    {
    	return this.C_KimeraX;
    }
    public int[] getC_KimeraYA()
    {
    	return this.C_KimeraY;
    }
    public int[] getC_KimeraZA()
    {
    	return this.C_KimeraZ;
    }
    public int[] getC_KimeraDimA()
    {
    	return this.C_KimeraDim;
    }
    public int[] getC_KimeraEnableA()
    {
    	return this.C_KimeraEnable;
    }

    public void setC_RuraX(int par1, int par2)
    {
    	this.C_RuraX[par1] = par2;
    }
    public int getC_RuraX(int par1)
    {
    	return this.C_RuraX[par1];
    }

    public void setC_RuraY(int par1, int par2)
    {
    	this.C_RuraY[par1] = par2;
    }
    public int getC_RuraY(int par1)
    {
    	return this.C_RuraY[par1];
    }

    public void setC_RuraZ(int par1, int par2)
    {
    	this.C_RuraZ[par1] = par2;
    }
    public int getC_RuraZ(int par1)
    {
    	return this.C_RuraZ[par1];
    }

    public void setC_RuraDim(int par1, int par2)
    {
    	this.C_RuraDim[par1] = par2;
    }
    public int getC_RuraDim(int par1)
    {
    	return this.C_RuraDim[par1];
    }

    public void setC_RuraEnable(int par1, int par2)
    {
    	this.C_RuraEnable[par1] = par2;
    }
    public int getC_RuraEnable(int par1)
    {
    	return this.C_RuraEnable[par1];
    }

    public int[] getC_Kimera(int par1)
    {
    	return new int[]{this.C_KimeraX[par1], this.C_KimeraY[par1], this.C_KimeraZ[par1], this.C_KimeraDim[par1]};
    }

    public void setC_KimeraX(int par1, int par2)
    {
    	this.C_KimeraX[par1] = par2;
    }
    public int getC_KimeraX(int par1)
    {
    	return this.C_KimeraX[par1];
    }

    public void setC_KimeraY(int par1, int par2)
    {
    	this.C_KimeraY[par1] = par2;
    }
    public int getC_KimeraY(int par1)
    {
    	return this.C_KimeraY[par1];
    }

    public void setC_KimeraZ(int par1, int par2)
    {
    	this.C_KimeraZ[par1] = par2;
    }
    public int getC_KimeraZ(int par1)
    {
    	return this.C_KimeraZ[par1];
    }

    public void setC_KimeraDim(int par1, int par2)
    {
    	this.C_KimeraDim[par1] = par2;
    }
    public int getC_KimeraDim(int par1)
    {
    	return this.C_KimeraDim[par1];
    }

    public void setC_KimeraEnable(int par1, int par2)
    {
    	this.C_KimeraEnable[par1] = par2;
    }
    public int getC_KimeraEnable(int par1)
    {
    	return this.C_KimeraEnable[par1];
    }

    public void setC_BasiRuraX(int par1, int par2)
    {
    	this.C_BasiRuraX[par1] = par2;
    }
    public int getC_BasiRuraX(int par1)
    {
    	return this.C_BasiRuraX[par1];
    }

    public void setC_BasiRuraY(int par1, int par2)
    {
    	this.C_BasiRuraY[par1] = par2;
    }
    public int getC_BasiRuraY(int par1)
    {
    	return this.C_BasiRuraY[par1];
    }

    public void setC_BasiRuraZ(int par1, int par2)
    {
    	this.C_BasiRuraZ[par1] = par2;
    }
    public int getC_BasiRuraZ(int par1)
    {
    	return this.C_BasiRuraZ[par1];
    }

    public void setC_BasiRuraDim(int par1, int par2)
    {
    	this.C_BasiRuraDim[par1] = par2;
    }
    public int getC_BasiRuraDim(int par1)
    {
    	return this.C_BasiRuraDim[par1];
    }

    public void setC_BasiRuraEnable(int par1, int par2)
    {
    	this.C_BasiRuraEnable[par1] = par2;
    }
    public int getC_BasiRuraEnable(int par1)
    {
    	return this.C_BasiRuraEnable[par1];
    }


    /////////////////////

    public void setW_RuraSin(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.W_RuraSinX[par1] = par2;
    	this.W_RuraSinY[par1] = par3;
    	this.W_RuraSinZ[par1] = par4;
    	this.W_RuraSinDim[par1] = par5;
    	this.W_RuraSinEnable[par1] = par6;
    }

    public double[] getW_RuraSin(int par1)
    {
    	return new double[]{this.W_RuraSinX[par1], this.W_RuraSinY[par1], this.W_RuraSinZ[par1], this.W_RuraSinDim[par1]};
    }

    public void setW_RuraSinXA(double[] par2)
    {
    	this.W_RuraSinX = par2;
    }
    public void setW_RuraSinYA(double[] par2)
    {
    	this.W_RuraSinY = par2;
    }
    public void setW_RuraSinZA(double[] par2)
    {
    	this.W_RuraSinZ = par2;
    }
    public void setW_RuraSinDimA(int[] par2)
    {
    	this.W_RuraSinDim = par2;
    }
    public void setW_RuraSinEnableA(int[] par2)
    {
    	this.W_RuraSinEnable = par2;
    }

    public double[] getW_RuraSinXA()
    {
    	return this.W_RuraSinX;
    }
    public double[] getW_RuraSinYA()
    {
    	return this.W_RuraSinY;
    }
    public double[] getW_RuraSinZA()
    {
    	return this.W_RuraSinZ;
    }
    public int[] getW_RuraSinDimA()
    {
    	return this.W_RuraSinDim;
    }
    public int[] getW_RuraSinEnableA()
    {
    	return this.W_RuraSinEnable;
    }


    public void setW_RuraSinX(int par1, double par2)
    {
    	this.W_RuraSinX[par1] = par2;
    }
    public double getW_RuraSinX(int par1)
    {
    	return this.W_RuraSinX[par1];
    }

    public void setW_RuraSinY(int par1, double par2)
    {
    	this.W_RuraSinY[par1] = par2;
    }
    public double getW_RuraSinY(int par1)
    {
    	return this.W_RuraSinY[par1];
    }

    public void setW_RuraSinZ(int par1, double par2)
    {
    	this.W_RuraSinZ[par1] = par2;
    }
    public double getW_RuraSinZ(int par1)
    {
    	return this.W_RuraSinZ[par1];
    }

    public void setW_RuraSinDim(int par1, int par2)
    {
    	this.W_RuraSinDim[par1] = par2;
    }
    public double getW_RuraSinDim(int par1)
    {
    	return this.W_RuraSinDim[par1];
    }

    public void setW_RuraSinEnable(int par1, int par2)
    {
    	this.W_RuraSinEnable[par1] = par2;
    }
    public double getW_RuraSinEnable(int par1)
    {
    	return this.W_RuraSinEnable[par1];
    }


    public void setC_RuraSin(int par1, int par2, int par3, int par4, int par5, int par6)
    {
    	this.C_RuraSinX[par1] = par2;
    	this.C_RuraSinY[par1] = par3;
    	this.C_RuraSinZ[par1] = par4;
    	this.C_RuraSinDim[par1] = par5;
    	this.C_RuraSinEnable[par1] = par6;
    }

    public int[] getC_RuraSin(int par1)
    {
    	return new int[]{this.C_RuraSinX[par1], this.C_RuraSinY[par1], this.C_RuraSinZ[par1], this.C_RuraSinDim[par1]};
    }

    public void setC_RuraSinXA(int[] par2)
    {
    	this.C_RuraSinX = par2;
    }
    public void setC_RuraSinYA(int[] par2)
    {
    	this.C_RuraSinY = par2;
    }
    public void setC_RuraSinZA(int[] par2)
    {
    	this.C_RuraSinZ = par2;
    }
    public void setC_RuraSinDimA(int[] par2)
    {
    	this.C_RuraSinDim = par2;
    }
    public void setC_RuraSinEnableA(int[] par2)
    {
    	this.C_RuraSinEnable = par2;
    }
    public void setC_RuraSinNameA(String[] par2)
    {
    	this.C_RuraSinName = par2;
    }

    public int[] getC_RuraSinXA()
    {
    	return this.C_RuraSinX;
    }
    public int[] getC_RuraSinYA()
    {
    	return this.C_RuraSinY;
    }
    public int[] getC_RuraSinZA()
    {
    	return this.C_RuraSinZ;
    }
    public int[] getC_RuraSinDimA()
    {
    	return this.C_RuraSinDim;
    }
    public int[] getC_RuraSinEnableA()
    {
    	return this.C_RuraSinEnable;
    }
    public String[] getC_RuraSinName()
    {
    	return this.C_RuraSinName;
    }


   public void setC_RuraSinX(int par1, int par2)
    {
    	this.C_RuraSinX[par1] = par2;
    }
    public int getC_RuraSinX(int par1)
    {
    	return this.C_RuraSinX[par1];
    }

    public void setC_RuraSinY(int par1, int par2)
    {
    	this.C_RuraSinY[par1] = par2;
    }
    public int getC_RuraSinY(int par1)
    {
    	return this.C_RuraSinY[par1];
    }

    public void setC_RuraSinZ(int par1, int par2)
    {
    	this.C_RuraSinZ[par1] = par2;
    }
    public int getC_RuraSinZ(int par1)
    {
    	return this.C_RuraSinZ[par1];
    }

    public void setC_RuraSinDim(int par1, int par2)
    {
    	this.C_RuraSinDim[par1] = par2;
    }
    public int getC_RuraSinDim(int par1)
    {
    	return this.C_RuraSinDim[par1];
    }

    public void setC_RuraSinName(int par1, String par2)
    {
    	this.C_RuraSinName[par1] = par2;
    }
    public String getC_RuraSinName(int par1)
    {
    	return this.C_RuraSinName[par1];
    }

    public void setC_RuraSinEnable(int par1, int par2)
    {
    	this.C_RuraSinEnable[par1] = par2;
    }
    public int getC_RuraSinEnable(int par1)
    {
    	return this.C_RuraSinEnable[par1];
    }


    public int getCoin() {
        return Coin;
    }
    public void setCoin(int par1) {
        this.Coin = par1;
    }

    public int getGuiBukiyaPhase(){
    	return this.guiBukiyaPhase;
    }

    public void setGuiBukiyaPhase(int par1){
    	this.guiBukiyaPhase = par1;
    }

    public int getGuiBukiyaPrice(){
    	return this.guiBukiyaPrice;
    }

    public void setGuiBukiyaPrice(int par1){
    	this.guiBukiyaPrice = par1;
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


    /*
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
    public void incJobSp(int job, int param) {
    	if(JobSp == null) JobSp = new int[32];
    	this.JobSp[job] = this.JobSp[job] + param;
    }
    public void decJobSp(int job, int param) {
    	if(JobSp == null) JobSp = new int[32];
    	this.JobSp[job] = this.JobSp[job] - param;
    }
    */
}
