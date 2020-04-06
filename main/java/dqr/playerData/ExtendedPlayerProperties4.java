package dqr.playerData;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import dqr.PacketHandler;

public class ExtendedPlayerProperties4 implements IExtendedEntityProperties{

	public final static String EXT_PROP_NAME = "DqmPlayerDataPT";
	private NBTTagCompound partyMemberData = new NBTTagCompound();
    private String playerName = null;
    private String playerUUID = null;

    private static String getSaveKey(EntityPlayer player) {
        return player.getCommandSenderName() + ":" + EXT_PROP_NAME;
    }

    public static void register(EntityPlayer player) {
        player.registerExtendedProperties(EXT_PROP_NAME, new ExtendedPlayerProperties4());
    }

    public static ExtendedPlayerProperties4 get(EntityPlayer player) {
        return (ExtendedPlayerProperties4)player.getExtendedProperties(EXT_PROP_NAME);
    }

    public void loadProxyData(EntityPlayer player) {
        ExtendedPlayerProperties4 playerData = ExtendedPlayerProperties4.get(player);
        NBTTagCompound savedData = PlayerDataHandler.getEntityData(getSaveKey(player));
        if (savedData != null) { playerData.loadNBTData(savedData); }
        PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties4(player), (EntityPlayerMP)player);
    }

	@Override
	public void init(Entity entity, World world) {}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound nbt = new NBTTagCompound();

		nbt.setTag("partyMemberData", partyMemberData);

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
		// TODO 自動生成されたメソッド・スタブ
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

        if(nbt.getCompoundTag("partyMemberData") != null)
        {
        	partyMemberData = (NBTTagCompound)nbt.getCompoundTag("partyMemberData");
        }else
        {
        	partyMemberData = new NBTTagCompound();
        }

        this.playerName = nbt.getString("playerName");
        this.playerUUID = nbt.getString("playerUUID");
	}


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
}
