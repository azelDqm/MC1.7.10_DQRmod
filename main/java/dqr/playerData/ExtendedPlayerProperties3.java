package dqr.playerData;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import dqr.PacketHandler;
import dqr.entity.petEntity.DqmPetBase;

public class ExtendedPlayerProperties3 implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "DqmPlayerData3";
	public final static int SKILL_MAX_COUNTER = 20;

	private int[] jobPermission = new int[32];
	private NBTTagCompound NBTPlayerPetList = new NBTTagCompound();
	private int petCount;

	//private NBTTagCompound NBTWeaponSkillPermission = new NBTTagCompound();
	//private int[] skillPermission = new int[10];
	private int[][] weaponSkillPermission = new int[64][SKILL_MAX_COUNTER];
	private int[] weaponSkillSet = new int[64];

	private NBTTagCompound petStatudData = null;
	private DqmPetBase statusPet;
	private String statusPetOwner;
	//private DqmPetBase invPet;

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

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("jobPermission_" + cnt, jobPermission[cnt]);
        }

        nbt.setTag("NBTPlayerPetList", NBTPlayerPetList);
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

        compound.setTag(EXT_PROP_NAME, nbt);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		// TODO 自動生成されたメソッド・スタブ
		NBTTagCompound nbt = (NBTTagCompound)compound.getTag(EXT_PROP_NAME);

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	jobPermission[cnt] = nbt.getInteger("jobPermission_" + cnt);
        }

        NBTPlayerPetList = nbt.getCompoundTag("NBTPlayerPetList");
        petCount = nbt.getInteger("petCount");

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
        return weaponSkillPermission[par1][par2];
    }
    public void setWeaponSkillPermission(int par1, int par2, int par3) {
    	if(weaponSkillPermission == null) weaponSkillPermission = new int[64][];
    	//System.out.println("VAL:" + par1 + "/" + par2 + "/" + par3);
        this.weaponSkillPermission[par1][par2] = par3;
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

    public NBTTagCompound getNBTPlayerPetList() {
        return NBTPlayerPetList;
    }

    public void setNBTPlayerPetList(NBTTagCompound nbt) {
        this.NBTPlayerPetList = nbt;
    }

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

    public void setStatusPetOwner(String par1) {
        this.statusPetOwner = par1;
    }
    public String getStatusPetOwner() {
        return this.statusPetOwner;
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
}
