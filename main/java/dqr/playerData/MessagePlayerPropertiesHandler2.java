package dqr.playerData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;

public class MessagePlayerPropertiesHandler2 implements IMessageHandler<MessagePlayerProperties2, IMessage> {

    @Override
    public IMessage onMessage(MessagePlayerProperties2 message, MessageContext ctx) {
        //Client側にIExtendedEntityPropertiesを渡す。
        //ExtendedPlayerProperties2.get(DQR.proxy.getEntityPlayerInstance()).loadNBTData(message.data);
    	EntityPlayer player = DQR.proxy.getEntityPlayerInstance();
    	NBTTagCompound getData = message.data;
    	NBTTagCompound checkData = (NBTTagCompound)getData.getTag("DqmPlayerData2");
    	//DQR.func.debugString(checkData.getString("playerUUID") + "/" + checkData.getString("playerName") + " / " + player.getCommandSenderName());

    	if(player != null && checkData != null && checkData.getString("playerName").equalsIgnoreCase(player.getCommandSenderName()))
    	{
    		ExtendedPlayerProperties2.get(player).loadNBTData(getData);
    	}
        //REPLYは送らないので、nullを返す。
        return null;
    }
}
