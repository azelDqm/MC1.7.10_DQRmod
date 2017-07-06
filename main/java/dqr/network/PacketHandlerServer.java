package dqr.network;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class PacketHandlerServer implements IMessageHandler<CToSMessage,IMessage> {

	//Types of packets

	//(None right now)

	/**
	 * Handles Server Side Packets. Only returns null.
	 */
	@Override
	public IMessage onMessage(CToSMessage packet, MessageContext context)
	{
		//System.out.println("hogehoge_B");
		ByteBuf buff = Unpooled.wrappedBuffer(packet.getData());

		int type = buff.readInt();

		//System.out.println("~~~~~~~~~~~~~~~~~ Server Packet Received! Type: " + type);

		switch(type) {
		default:
			//do nothing.
		}


		return null;
	}
}
