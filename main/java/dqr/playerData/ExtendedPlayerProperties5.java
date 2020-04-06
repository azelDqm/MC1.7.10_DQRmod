package dqr.playerData;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import dqr.PacketHandler;

public class ExtendedPlayerProperties5 implements IExtendedEntityProperties{

	public final static String EXT_PROP_NAME = "DqmPlayerData5";
    private String playerName = null;
    private String playerUUID = null;

	private int[][] fixJobSkillSet = new int[32][9];
	private int[][] fixJobSkillSet2 = new int[32][9];
	private int[][] fixJobSPSkillSet = new int[32][36];
	private int[] fixJobSp = new int[32];

	private NBTTagCompound fixJobSPSkillCT = new NBTTagCompound();
	//private NBTTagCompound fixJobSPSkillDuration = new NBTTagCompound();
	private NBTTagCompound dqrPotionEffects =  new NBTTagCompound();
	/**
	 * "id"
	 * "idx"
	 * "type"
	 * "duration"
	 * "isDebuff"
	 * "amplifier"
	 */

    private static String getSaveKey(EntityPlayer player) {
        return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
    }

    public static void register(EntityPlayer player) {
        player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayerProperties5());
    }

    public static ExtendedPlayerProperties5 get(EntityPlayer player) {
        return (ExtendedPlayerProperties5)player.getExtendedProperties(EXT_PROP_NAME);
    }

    public void loadProxyData(EntityPlayer player) {
        ExtendedPlayerProperties5 playerData = ExtendedPlayerProperties5.get(player);
        NBTTagCompound savedData = PlayerDataHandler.getEntityData(getSaveKey(player));
        if (savedData != null) { playerData.loadNBTData(savedData); }
        PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties5(player), (EntityPlayerMP)player);
    }

	@Override
	public void init(Entity entity, World world) {}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = new NBTTagCompound();

		//DQR.func.debugString("EPP5_Test : 1");
		//nbt.setTag("partyMemberData", partyMemberData);

        if(this.playerName != null)
        {
        	nbt.setString("playerName", this.playerName);
        }

        if(this.playerUUID != null)
        {
        	nbt.setString("playerUUID", this.playerUUID);
        }


        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("JobSp_" + cnt, fixJobSp[cnt]);
        }



        for(int job = 0; job < fixJobSkillSet.length; job++)
        {
        	for(int idx = 0; idx < fixJobSkillSet[job].length; idx++)
        	{
        		nbt.setInteger("jobSkillSet_" + job + "_" + idx, fixJobSkillSet[job][idx]);
        	}
        }

        for(int job = 0; job < fixJobSkillSet2.length; job++)
        {
        	for(int idx = 0; idx < fixJobSkillSet2[job].length; idx++)
        	{
        		nbt.setInteger("jobSkillSet2_" + job + "_" + idx, fixJobSkillSet2[job][idx]);
        	}
        }

        for(int job = 0; job < fixJobSPSkillSet.length; job++)
        {
        	for(int idx = 0; idx < fixJobSPSkillSet[job].length; idx++)
        	{
        		nbt.setInteger("jobSPSkillSet_" + job + "_" + idx, fixJobSPSkillSet[job][idx]);
        	}
        }



        nbt.setTag("jobSPSkillCT", fixJobSPSkillCT);
        nbt.setTag("dqrPotionEffects", dqrPotionEffects);

        /*
        for(int job = 0; job < jobSPSkillCT.length; job++)
        {
        	for(int idx = 0; idx < jobSPSkillCT[job].length; idx++)
        	{
        		nbt.setLong("jobSPSkillCT_" + job + "_" + idx, jobSPSkillCT[job][idx]);
        	}
        }
        */
		compound.setTag(EXT_PROP_NAME, nbt);
		//DQR.func.debugString("EPP5_Test : 2");
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		// TODO 自動生成されたメソッド・スタブ
		//DQR.func.debugString("EPP5_Test : 3");
		if(compound == null)
		{
			//System.out.println("packet lost");
			return;
		}
		NBTTagCompound nbt = (NBTTagCompound)compound.getTag(EXT_PROP_NAME);

		if(nbt == null)
		{
			//System.out.println("packet lost");
			return;
		}
		//DQR.func.debugString("EPP5_Test : 4");
		/*
        if(nbt.getCompoundTag("partyMemberData") != null)
        {
        	partyMemberData = (NBTTagCompound)nbt.getCompoundTag("partyMemberData");
        }else
        {
        	partyMemberData = new NBTTagCompound();
        }
        */

        this.playerName = nbt.getString("playerName");
        this.playerUUID = nbt.getString("playerUUID");

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	fixJobSp[cnt] = nbt.getInteger("JobSp_" + cnt);
        }

        for(int job = 0; job < fixJobSkillSet.length; job++)
        {
        	for(int idx = 0; idx < fixJobSkillSet[job].length; idx++)
        	{
        		fixJobSkillSet[job][idx] = nbt.getInteger("jobSkillSet_" + job + "_" + idx);
        	}
        }

        for(int job = 0; job < fixJobSkillSet2.length; job++)
        {
        	for(int idx = 0; idx < fixJobSkillSet2[job].length; idx++)
        	{
        		fixJobSkillSet2[job][idx] = nbt.getInteger("jobSkillSet2_" + job + "_" + idx);
        	}
        }

        for(int job = 0; job < fixJobSPSkillSet.length; job++)
        {
        	for(int idx = 0; idx < fixJobSPSkillSet[job].length; idx++)
        	{
        		fixJobSPSkillSet[job][idx] = nbt.getInteger("jobSPSkillSet_" + job + "_" + idx);
        	}
        }


        /*

    	if(nbt.hasKey("jobSPSkillCT"))
    	{
    		nbt.removeTag("jobSPSkillCT");
    	}

    	if(nbt.hasKey("jobSPSkillDuration"))
    	{
    		nbt.removeTag("jobSPSkillDuration");
    	}
    	*/

    	fixJobSPSkillCT = nbt.getCompoundTag("jobSPSkillCT");
    	dqrPotionEffects = nbt.getCompoundTag("dqrPotionEffects");
    	//nbt.setTag("jobSPSkillCT", fixJobSPSkillCT);
        //nbt.setTag("jobSPSkillDuration", fixJobSPSkillDuration);

    	/*
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
        */
    	//DQR.func.debugString("EPP5_Test : 5");
	}


	/*
    public void setPartyMemberData(NBTTagCompound par1) {
    	if(par1 != null)
    	{
    		this.partyMemberData = new NBTTagCompound();
    		this.partyMemberData = par1;
    		//System.out.println(par1.func_150296_c().size());
    	}else
    	{
    		this.partyMemberData = new NBTTagCompound();
    	}
    }
    public NBTTagCompound getPartyMemberData() {
        return this.partyMemberData;
    }
    */

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

    public int[][] getJobSkillSetA() {
    	if(fixJobSkillSet == null) fixJobSkillSet = new int[32][9];
        return fixJobSkillSet;
    }
    public void setJobSkillSetA(int[][] par1) {
    	if(fixJobSkillSet == null) fixJobSkillSet = new int[32][9];
        this.fixJobSkillSet = par1;
    }
    public int[] getJobSkillSetA2(int job) {
    	if(fixJobSkillSet == null) fixJobSkillSet = new int[32][9];
        return fixJobSkillSet[job];
    }
    public void setJobSkillSetA2(int[] par1, int job) {
    	if(fixJobSkillSet == null) fixJobSkillSet = new int[32][9];
        this.fixJobSkillSet[job] = par1;
    }

    public int getJobSkillSet(int job, int idx) {
    	if(fixJobSkillSet == null) fixJobSkillSet = new int[32][9];
        return fixJobSkillSet[job][idx];
    }
    public void setJobSkillSet(int job, int idx, int par1) {
    	if(fixJobSkillSet == null) fixJobSkillSet = new int[32][9];
        this.fixJobSkillSet[job][idx] = par1;
    }


    public int[][] getJobSkillSet2A() {
    	if(fixJobSkillSet2 == null) fixJobSkillSet2 = new int[32][9];
        return fixJobSkillSet2;
    }
    public void setJobSkillSet2A(int[][] par1) {
    	if(fixJobSkillSet2 == null) fixJobSkillSet2 = new int[32][9];
        this.fixJobSkillSet2 = par1;
    }
    public int[] getJobSkillSet2A2(int job) {
    	if(fixJobSkillSet2 == null) fixJobSkillSet2 = new int[32][9];
        return fixJobSkillSet2[job];
    }
    public void setJobSkillSet2A2(int[] par1, int job) {
    	if(fixJobSkillSet2 == null) fixJobSkillSet2 = new int[32][9];
        this.fixJobSkillSet2[job] = par1;
    }

    public int getJobSkillSet2(int job, int idx) {
    	if(fixJobSkillSet2 == null) fixJobSkillSet2 = new int[32][9];
        return fixJobSkillSet2[job][idx];
    }
    public void setJobSkillSet2(int job, int idx, int par1) {
    	if(fixJobSkillSet2 == null) fixJobSkillSet2 = new int[32][9];
        this.fixJobSkillSet2[job][idx] = par1;
    }


    public int[][] getJobSPSkillSetA() {
    	if(fixJobSPSkillSet == null) fixJobSPSkillSet = new int[32][9];
        return fixJobSPSkillSet;
    }
    public void setJobSPSkillSetA(int[][] par1) {
    	if(fixJobSPSkillSet == null) fixJobSPSkillSet = new int[32][9];
        this.fixJobSPSkillSet = par1;
    }
    public int[] getJobSPSkillSetA2(int job) {
    	if(fixJobSPSkillSet == null) fixJobSPSkillSet = new int[32][9];
        return fixJobSPSkillSet[job];
    }
    public void setJobSPSkillSetA2(int[] par1, int job) {
    	if(fixJobSPSkillSet == null) fixJobSPSkillSet = new int[32][9];
        this.fixJobSPSkillSet[job] = par1;
    }

    public int getJobSPSkillSet(int job, int idx) {
    	if(fixJobSPSkillSet == null) fixJobSPSkillSet = new int[32][9];
        return fixJobSPSkillSet[job][idx];
    }
    public void setJobSPSkillSet(int job, int idx, int par1) {
    	if(fixJobSPSkillSet == null) fixJobSPSkillSet = new int[32][9];
        this.fixJobSPSkillSet[job][idx] = par1;
    }



    public NBTTagCompound getJobSPSkillCTSet() {
    	if(fixJobSPSkillCT == null){fixJobSPSkillCT = new NBTTagCompound();}
        return fixJobSPSkillCT;
    }
    public void setJobSPSkillCTSet(NBTTagCompound par1) {
    	if(par1 != null)
    	{
    		this.fixJobSPSkillCT = par1;
    	}else
    	{
    		this.fixJobSPSkillCT = new NBTTagCompound();
    	}
    }

    public long getJobSPSkillCT(int job, int idx) {
        return fixJobSPSkillCT.getLong("jobSPSkillCT" + "_" + job  + "_" + idx);
    }
    public void setJobSPSkillCT(int job, int idx, long par1) {
        this.fixJobSPSkillCT.setLong("jobSPSkillCT" + "_" + job  + "_" + idx, par1);
    }

    public NBTTagCompound getDqrPotionEffectsSet() {
    	if(dqrPotionEffects == null){dqrPotionEffects = new NBTTagCompound();}
        return dqrPotionEffects;
    }
    public void setDqrPotionEffectsSet(NBTTagCompound par1) {
    	if(par1 != null)
    	{
    		this.dqrPotionEffects = par1;
    	}else
    	{
    		this.dqrPotionEffects = new NBTTagCompound();
    	}
    }
    public void removeDqrPotionEffects(String key) {
    	this.dqrPotionEffects.removeTag(key);
    }


    public long getJobSPSkillDuration(int job, int idx, long nowTime) {
        //return fixJobSPSkillDuration.getLong("jobSPSkillDuration" + "_" + job  + "_" + idx);
    	NBTTagCompound nbt = this.dqrPotionEffects.getCompoundTag("JSkill" + "_" + job  + "_" + idx);
    	if(nbt != null && nbt.hasKey("duration"))
    	{
    		long duration = nbt.getLong("duration") - nowTime;

    		if(duration > 0)
    		{
    			return duration;
    		}else
    		{
    			return 0L;
    		}

    	}else
    	{
    		return 0L;
    	}
    }
    public void setJobSPSkillDuration(int job, int idx, long par1) {
    	NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setInteger("id", 0);
    	nbt.setInteger("idx", 0);
    	nbt.setInteger("type", 0);
    	nbt.setLong("duration", par1);
    	nbt.setInteger("isDebuff", 0);
    	nbt.setInteger("amplifier", 0);

    	this.dqrPotionEffects.setTag("JSkill" + "_" + job  + "_" + idx, nbt);
        //this.fixJobSPSkillDuration.setLong("jobSPSkillDuration" + "_" + job  + "_" + idx, par1);
    }
    public void setDebuffDuration(int job, int idx, long par1) {
    	NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setInteger("id", 0);
    	nbt.setInteger("idx", 0);
    	nbt.setInteger("type", 0);
    	nbt.setLong("duration", par1);
    	nbt.setInteger("isDebuff", 1);
    	nbt.setInteger("amplifier", 0);

    	this.dqrPotionEffects.setTag("JSkill" + "_" + job  + "_" + idx, nbt);
        //this.fixJobSPSkillDuration.setLong("jobSPSkillDuration" + "_" + job  + "_" + idx, par1);
    }

    public void setDqrPotionEffects(String key, NBTTagCompound nbt)
    {
    	this.dqrPotionEffects.setTag(key, nbt);
    }

    public NBTTagCompound getDqrPotionEffects(String key)
    {
    	return (NBTTagCompound)this.dqrPotionEffects.getTag(key);
    }

    public void refreshDqrPotionEffects(long wt)
    {
    	Set nbtSet = this.dqrPotionEffects.func_150296_c();

    	Iterator ite = nbtSet.iterator();
    	List<String> lst = new ArrayList<String>();
    	while(ite.hasNext())
    	{
    		Object obj = ite.next();
    		if(obj instanceof String)
    		{
    			NBTTagCompound nbt = this.dqrPotionEffects.getCompoundTag((String)obj);
    			if(nbt != null)
    			{
    				if(nbt.hasKey("duration"))
    				{
	        			long fixTime = nbt.getLong("duration");
	        			if(fixTime < wt)
	        			{
	        				lst.add((String)obj);
	        				//this.jobSPSkillDuration.removeTag((String)obj);
	        			}
    				}else
    				{
    					lst.add((String)obj);
    				}
    			}

    			//String name = (String)obj;
    			//System.out.println("TEST : " + name);
    		}
    	}

    	for(int cnt = 0; cnt < lst.size(); cnt++)
    	{
    		this.dqrPotionEffects.removeTag(lst.get(cnt));
    	}
    }




    public int[] getJobSpA() {
    	if(fixJobSp == null) fixJobSp = new int[32];
        return fixJobSp;
    }
    public void setJobSpA(int[] par1) {
    	if(fixJobSp == null) fixJobSp = new int[32];
        this.fixJobSp = par1;
    }
    public int getJobSp(int par1) {
    	if(fixJobSp == null) fixJobSp = new int[32];
        return fixJobSp[par1];
    }
    public void setJobSp(int par1, int par2) {
    	if(fixJobSp == null) fixJobSp = new int[32];
        this.fixJobSp[par1] = par2;
    }
    public void incJobSp(int job, int param) {
    	if(fixJobSp == null) fixJobSp = new int[32];
    	this.fixJobSp[job] = this.fixJobSp[job] + param;
    }
    public void decJobSp(int job, int param) {
    	if(fixJobSp == null) fixJobSp = new int[32];
    	this.fixJobSp[job] = this.fixJobSp[job] - param;
    }
}
