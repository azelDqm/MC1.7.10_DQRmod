package dqr.packetMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties6;

public class MessageClientDataSendHandler implements IMessageHandler<MessageClientDataSend, IMessage>{

	@Override
	public IMessage onMessage(MessageClientDataSend message, MessageContext ctx) {


		//EntityPlayerMP p = ctx.getServerHandler().playerEntity;
		EntityPlayer player = DQR.proxy.getEntityPlayerInstance();
		NBTTagCompound nbt = message.getData();
		int flg = message.flg;

		if(flg == 2)
		{
			//ExtendedPlayerProperties3.get(player).setPetStatudData(message.getData());
			ExtendedPlayerProperties6.get(player).setNBTPlayerPetList(nbt);
		}


		return null;

	}
}
