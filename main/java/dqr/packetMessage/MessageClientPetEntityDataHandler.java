package dqr.packetMessage;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties3;

public class MessageClientPetEntityDataHandler implements IMessageHandler<MessageClientPetEntityData, IMessage>{

	@Override
	public IMessage onMessage(MessageClientPetEntityData message, MessageContext ctx) {


		//EntityPlayerMP p = ctx.getServerHandler().playerEntity;
		EntityPlayer player = DQR.proxy.getEntityPlayerInstance();

		ExtendedPlayerProperties3.get(player).setPetStatudData(message.getData());
		//int i = message.getData().getInteger("gui");
		//p.openGui(DQR.instance, i, p.worldObj, (int)p.posX, (int)p.posY, (int)p.posZ);

		//System.out.println("DATAGET");
		/*
        NBTTagCompound petData = ExtendedPlayerProperties3.get(player).getPetStatudData();

        if(petData != null)
        {
	        Object[] type = petData.func_150296_c().toArray();

	        for(int cnt = 0; cnt < type.length; cnt++)
	        {
	            System.out.println("TEST:" + (String)type[cnt]);
	        }
        }
        */
		//player.openGui(DQR.instance, DQR.conf.GuiID_PetStatus, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
		return null;

	}
}
