package dqr.playerData;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import dqr.PacketHandler;
import dqr.blocks.chest.tileEntity.DqmTileEntityEnderChest;

public class ExtendedPlayerProperties2 implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "DqmPlayerData2";
	private int[] farmRecipe = new int[32];
    private int[] bugFixFlg = new int[8];
    private String playerName = null;
    private String playerUUID = null;

    //private SubEquipmentStats equipment;
    private boolean fukuroOpen = false;

    //以下MagicTool用パラメータ
    private NBTTagCompound SeedsNBTTagCompound = new NBTTagCompound();
    private int Tool1mode = 0;
    private int Tool2mode = 0;
    private int ToolArea = 0;

    private int SeedSetMode = 0;

    private int itemUseFlg = 0;
    private String selectSeed = "";

    private String selectSeed1 = "";
    private String selectSeed2 = "";
    private String selectSeed3 = "";
    private String selectSeed4 = "";

    private int ToolBreak1mode = 0;
    private int ToolBreak2mode = 0;
    private int ToolBreak1Area = 0;
    private int ToolBreak2Area = 0;
    private int BreakBlockMode = 0;
    private int BlockSetMode = 0;
    private int BlockSetArea = 0;

    private String selectSetBlock = "";
    private int selectSetBlockMeta = 0;

    private NBTTagList enderChestTagList1 = new NBTTagList();
    private NBTTagList enderChestTagList2 = new NBTTagList();
    private NBTTagList enderChestTagList3 = new NBTTagList();
    private NBTTagList enderChestTagList4 = new NBTTagList();
    private NBTTagList enderChestTagList5 = new NBTTagList();
    private int setlectEnderChestID = 0;
    private DqmTileEntityEnderChest enderChestEntity = null;

    private NBTTagList SubEquips = new NBTTagList();

    private NBTTagCompound ToolSetInBlocks = new NBTTagCompound();

    private static String getSaveKey(EntityPlayer player) {
        return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
    }

    public static void register(EntityPlayer player) {
        player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayerProperties2());
    }

    public static ExtendedPlayerProperties2 get(EntityPlayer player) {
        return (ExtendedPlayerProperties2)player.getExtendedProperties(EXT_PROP_NAME);
    }

    public void loadProxyData(EntityPlayer player) {
        ExtendedPlayerProperties2 playerData = ExtendedPlayerProperties2.get(player);
        NBTTagCompound savedData = PlayerDataHandler.getEntityData(getSaveKey(player));
        if (savedData != null) { playerData.loadNBTData(savedData); }
        PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties2(player), (EntityPlayerMP)player);
    }

	@Override
	public void init(Entity entity, World world) {}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
        NBTTagCompound nbt = new NBTTagCompound();

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("farmRecipe_" + cnt, farmRecipe[cnt]);
        }
        for(int cnt = 0; cnt < 8; cnt++)
        {
        	nbt.setInteger("bugFixFlg_" + cnt, bugFixFlg[cnt]);
        }

        nbt.setTag("SeedsNBTTag", this.SeedsNBTTagCompound);

        nbt.setInteger("Tool1mode", Tool1mode);
        nbt.setInteger("Tool2mode", Tool2mode);
        nbt.setInteger("ToolArea", ToolArea);

        nbt.setInteger("SeedSetMode", SeedSetMode);
        nbt.setString("selectSeed", selectSeed);

        nbt.setString("selectSeed1", selectSeed1);
        nbt.setString("selectSeed2", selectSeed2);
        nbt.setString("selectSeed3", selectSeed3);
        nbt.setString("selectSeed4", selectSeed4);

        nbt.setInteger("ToolBreak1mode", ToolBreak1mode);
        nbt.setInteger("ToolBreak2mode", ToolBreak2mode);
        nbt.setInteger("ToolBreak1Area", ToolBreak1Area);
        nbt.setInteger("ToolBreak2Area", ToolBreak2Area);
        nbt.setInteger("BreakBlockMode", BreakBlockMode);

        if(this.playerName != null)
        {
        	nbt.setString("playerName", this.playerName);
        }

        if(this.playerUUID != null)
        {
        	nbt.setString("playerUUID", this.playerUUID);
        }

        nbt.setTag("enderChestTagList1", enderChestTagList1);
        nbt.setTag("enderChestTagList2", enderChestTagList2);
        nbt.setTag("enderChestTagList3", enderChestTagList3);
        nbt.setTag("enderChestTagList4", enderChestTagList4);
        nbt.setTag("enderChestTagList5", enderChestTagList5);

        nbt.setTag("SubEquips", SubEquips);

        nbt.setTag("ToolSetInBlocks", this.ToolSetInBlocks);

        nbt.setInteger("SelectSetBlockMeta", selectSetBlockMeta);
        nbt.setString("SelectSetBlock", selectSetBlock);
        nbt.setInteger("BlockSetMode", BlockSetMode);
        nbt.setInteger("BlockSetArea", BlockSetArea);

        /*
        if(this.equipment == null)
        {
        	this.equipment = new SubEquipmentStats();
        }
        this.equipment.writeNBT(compound);
        */

        compound.setTag(EXT_PROP_NAME, nbt);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		// TODO 自動生成されたメソッド・スタブ
		NBTTagCompound nbt = (NBTTagCompound)compound.getTag(EXT_PROP_NAME);

		if(farmRecipe == null)
		{
			farmRecipe = new int[32];
		}
		if(bugFixFlg == null)
		{
			bugFixFlg = new int[8];
		}

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	farmRecipe[cnt] = nbt.getInteger("farmRecipe_" + cnt);
        }
        for(int cnt = 0; cnt < 8; cnt++)
        {
        	bugFixFlg[cnt] = nbt.getInteger("bugFixFlg_" + cnt);
        }

        this.playerName = nbt.getString("playerName");
        this.playerUUID = nbt.getString("playerUUID");

        this.SeedsNBTTagCompound = nbt.getCompoundTag("SeedsNBTTag");
        Tool1mode = nbt.getInteger("Tool1mode");
        Tool2mode = nbt.getInteger("Tool2mode");
        ToolArea = nbt.getInteger("ToolArea");
        selectSeed = nbt.getString("selectSeed");

        SeedSetMode = nbt.getInteger("SeedSetMode");

        selectSeed1 = nbt.getString("selectSeed1");
        selectSeed2 = nbt.getString("selectSeed2");
        selectSeed3 = nbt.getString("selectSeed3");
        selectSeed4 = nbt.getString("selectSeed4");


        ToolBreak1mode = nbt.getInteger("ToolBreak1mode");
        ToolBreak2mode = nbt.getInteger("ToolBreak2mode");
        ToolBreak1Area = nbt.getInteger("ToolBreak1Area");
        ToolBreak2Area = nbt.getInteger("ToolBreak2Area");
        BreakBlockMode = nbt.getInteger("BreakBlockMode");

        if(nbt.getTag("enderChestTagList1") != null)
        {
        	enderChestTagList1 = (NBTTagList)nbt.getTag("enderChestTagList1");
        }else
        {
        	enderChestTagList1 = new NBTTagList();
        }

        if(nbt.getTag("enderChestTagList2") != null)
        {
        	enderChestTagList2 = (NBTTagList)nbt.getTag("enderChestTagList2");
        }else
        {
        	enderChestTagList2 = new NBTTagList();
        }

        if(nbt.getTag("enderChestTagList3") != null)
        {
        	enderChestTagList3 = (NBTTagList)nbt.getTag("enderChestTagList3");
        }else
        {
        	enderChestTagList3 = new NBTTagList();
        }

        if(nbt.getTag("enderChestTagList4") != null)
        {
        	enderChestTagList4 = (NBTTagList)nbt.getTag("enderChestTagList4");
        }else
        {
        	enderChestTagList4 = new NBTTagList();
        }

        if(nbt.getTag("enderChestTagList5") != null)
        {
        	enderChestTagList5 = (NBTTagList)nbt.getTag("enderChestTagList5");
        }else
        {
        	enderChestTagList5 = new NBTTagList();
        }

        if(nbt.getTag("ToolSetInBlocks") != null)
        {
        	ToolSetInBlocks = nbt.getCompoundTag("ToolSetInBlocks");
        }else
        {
        	ToolSetInBlocks = new NBTTagCompound();
        }

        if(nbt.getTag("SubEquips") != null)
        {
        	SubEquips = (NBTTagList)nbt.getTag("SubEquips");
        }else
        {
        	SubEquips = new NBTTagList();
        }

        selectSetBlockMeta = nbt.getInteger("SelectSetBlockMeta");
        selectSetBlock = nbt.getString("SelectSetBlock");
        BlockSetMode = nbt.getInteger("BlockSetMode");
        BlockSetArea = nbt.getInteger("BlockSetArea");

        /*
        if(this.equipment == null)
        {
        	this.equipment = new SubEquipmentStats();
        }
        this.equipment.writeNBT(compound);
        */
	}

    public int[] getFarmRecipeA() {
    	if(farmRecipe == null) farmRecipe = new int[32];
        return farmRecipe;
    }
    public void setFarmRecipeA(int[] par1) {
    	if(farmRecipe == null) farmRecipe = new int[32];
        this.farmRecipe = par1;
    }
    public int getFarmRecipe(int par1) {
    	if(farmRecipe == null) farmRecipe = new int[32];
        return farmRecipe[par1];
    }
    public void setFarmRecipe(int par1, int par2) {
    	if(farmRecipe == null) farmRecipe = new int[32];
        this.farmRecipe[par1] = par2;
    }

    public void setBugFixFlg(int par1, int par2) {
    	if(bugFixFlg == null) bugFixFlg = new int[8];
        this.bugFixFlg[par1] = par2;
    }
    public int getBugFixFlg(int par1) {
    	if(bugFixFlg == null) bugFixFlg = new int[8];
        return bugFixFlg[par1];
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

    public NBTTagCompound getSeedsNBTTagCompound() {
        return SeedsNBTTagCompound;
    }

    public void setSeedNBTTagCompound(NBTTagCompound par1NBTTagCompound) {
        this.SeedsNBTTagCompound = par1NBTTagCompound;
    }

    public int getSeedVal(String par1)
    {
    	return this.SeedsNBTTagCompound.getInteger(par1);
    }

    public void setSeedVal(String par1, int par2)
    {
    	this.SeedsNBTTagCompound.setInteger(par1, par2);
    }

    public void setTool2mode(int par1) {
        this.Tool2mode = par1;
    }
    public int getTool2mode() {
        return Tool2mode;
    }

    public void setTool1mode(int par1) {
        this.Tool1mode = par1;
    }
    public int getTool1mode() {
        return Tool1mode;
    }

    public void setToolArea(int par1) {
        this.ToolArea = par1;
    }
    public int getToolArea() {
        return ToolArea;
    }

    public void setSeedSetMode(int par1) {
        this.SeedSetMode = par1;
    }
    public int getSeedSetMode() {
        return SeedSetMode;
    }

    public int getItemUseFlg()
    {
    	return itemUseFlg;
    }

    public void setItemUseFlg(int par1)
    {
    	itemUseFlg = par1;
    }

    public String getSelectSeed1()
    {
    	return selectSeed1;
    }

    public void setSelectSeed1(String par1)
    {
    	selectSeed1 = par1;
    }

    public String getSelectSeed2()
    {
    	return selectSeed2;
    }

    public void setSelectSeed2(String par1)
    {
    	selectSeed2 = par1;
    }

    public String getSelectSeed3()
    {
    	return selectSeed3;
    }

    public void setSelectSeed3(String par1)
    {
    	selectSeed3 = par1;
    }

    public String getSelectSeed4()
    {
    	return selectSeed4;
    }

    public void setSelectSeed4(String par1)
    {
    	selectSeed4 = par1;
    }

    public String getSelectSeed()
    {
    	return selectSeed;
    }

    public void setSelectSeed(String par1)
    {
    	selectSeed = par1;
    }

    //エンダーチェスト系
    public void setSetlectEnderChestID(int par1) {
        this.setlectEnderChestID = par1;
    }
    public int getSetlectEnderChestID() {
        return setlectEnderChestID;
    }

    public void setSubEquips(NBTTagList par1)
    {

    		this.SubEquips = par1;
    }

    public NBTTagList getSubEquips()
    {

    		return this.SubEquips;
    }

    public void setEnderChestTagList(NBTTagList par1, int id) {
    	switch(id)
    	{
    		case 1: this.enderChestTagList1 = par1; break;
    		case 2: this.enderChestTagList2 = par1; break;
    		case 3: this.enderChestTagList3 = par1; break;
    		case 4: this.enderChestTagList4 = par1; break;
    		case 5: this.enderChestTagList5 = par1; break;
    	}
        //this.enderChestTagList1 = par1;
    }
    public NBTTagList getEnderChestTagList(int id) {
    	switch(id)
    	{
    		case 1: return enderChestTagList1;
    		case 2: return enderChestTagList2;
    		case 3: return enderChestTagList3;
    		case 4: return enderChestTagList4;
    		case 5: return enderChestTagList5;
    	}
        return null;
    }

    public DqmTileEntityEnderChest getEnderChestEntity()
    {
    	return this.enderChestEntity;
    }

    public void setEnderChestEntity(DqmTileEntityEnderChest par1)
    {
    	this.enderChestEntity = par1;
    }

    public void setToolBreak1mode(int par1)
    {
    	ToolBreak1mode  = par1;
    }

    public int getToolBreak1mode()
    {
    	return ToolBreak1mode ;
    }

    public void setToolBreak2mode(int par1)
    {
    	ToolBreak2mode = par1;
    }

    public int getToolBreak2mode()
    {
    	return ToolBreak2mode;
    }

    public void setToolBreak1Area(int par1)
    {
    	ToolBreak1Area = par1;
    }

    public int getToolBreak1Area()
    {
    	return ToolBreak1Area ;
    }

    public void setToolBreak2Area(int par1)
    {
    	ToolBreak2Area = par1;
    }

    public int getToolBreak2Area()
    {
    	return ToolBreak2Area ;
    }

    public void setBreakBlockMode(int par1)
    {
    	BreakBlockMode = par1;
    }

    public int getBreakBlockMode()
    {
    	return BreakBlockMode ;
    }

    public void setToolSetInBlocks(NBTTagCompound par1)
    {
    	ToolSetInBlocks = par1;
    }

    public NBTTagCompound getToolSetInBlocks()
    {
    	return ToolSetInBlocks ;
    }

    public void setSelectSetBlock(String par1)
    {
    	selectSetBlock = par1;
    }

    public String getSelectSetBlock()
    {
    	return selectSetBlock ;
    }

    public void setSelectSetBlockMeta(int par1)
    {
    	selectSetBlockMeta = par1;
    }

    public int getSelectSetBlockMeta()
    {
    	return selectSetBlockMeta;
    }


    public void setBlockSetMode(int par1)
    {
    	BlockSetMode = par1;
    }

    public int getBlockSetMode()
    {
    	return BlockSetMode ;
    }

    public void setBlockSetArea(int par1)
    {
    	BlockSetArea = par1;
    }

    public int getBlockSetArea()
    {
    	return BlockSetArea;
    }

    public void setFukuroOpen(boolean par1)
    {
    	fukuroOpen = par1;
    }

    public boolean getFukuroOpen()
    {
    	return fukuroOpen;
    }
    /*
    public SubEquipmentStats getEquipmentStats() {
        return equipment;
    }

    public void setEquipmentStats(SubEquipmentStats e) {
        this.equipment = e;
    }
    */
}
