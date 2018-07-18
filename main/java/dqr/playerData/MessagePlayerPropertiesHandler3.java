package dqr.playerData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;

public class MessagePlayerPropertiesHandler3 implements IMessageHandler<MessagePlayerProperties3, IMessage> {

    @Override
    public IMessage onMessage(MessagePlayerProperties3 message, MessageContext ctx) {
        //Client側にIExtendedEntityPropertiesを渡す。
        //ExtendedPlayerProperties3.get(DQR.proxy.getEntityPlayerInstance()).loadNBTData(message.data);
    	NBTTagCompound getData = message.data;
    	if(getData != null)
    	{
        	EntityPlayer player = DQR.proxy.getEntityPlayerInstance();
	    	NBTTagCompound checkData = (NBTTagCompound)getData.getTag("DqmPlayerData3");
	    	//DQR.func.debugString(checkData.getString("playerUUID") + "/" + checkData.getString("playerName") + " / " + player.getCommandSenderName());

	    	if(player != null && checkData != null && checkData.getString("playerName").equalsIgnoreCase(player.getCommandSenderName()))
	    	{
	    		ExtendedPlayerProperties3.get(player).loadNBTData(getData);
	    	}
    	}
        //REPLYは送らないので、nullを返す。
        return null;
    }
}
