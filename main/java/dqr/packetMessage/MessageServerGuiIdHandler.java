package dqr.packetMessage;

import net.minecraft.entity.player.EntityPlayerMP;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;

public class MessageServerGuiIdHandler implements IMessageHandler<MessageServerGuiId, IMessage>{

	@Override
	public IMessage onMessage(MessageServerGuiId message, MessageContext ctx) {


		EntityPlayerMP p = ctx.getServerHandler().playerEntity;

		int i = message.getData().getInteger("gui");

		p.openGui(DQR.instance, i, p.worldObj, (int)p.posX, (int)p.posY, (int)p.posZ);

		return null;

	}
}
