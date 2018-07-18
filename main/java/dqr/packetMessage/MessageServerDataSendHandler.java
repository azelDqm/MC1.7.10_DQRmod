package dqr.packetMessage;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.playerData.ExtendedPlayerProperties3;

public class MessageServerDataSendHandler implements IMessageHandler<MessageServerDataSend, IMessage>{

	@Override
	public IMessage onMessage(MessageServerDataSend message, MessageContext ctx) {


		EntityPlayerMP p = ctx.getServerHandler().playerEntity;

		NBTTagCompound nbt = message.getData();
		int flg = message.flg;

		//p.openGui(DQR.instance, i, p.worldObj, (int)p.posX, (int)p.posY, (int)p.posZ);
		//System.out.println("TESTTEST : " + nbt.func_150296_c().size() + " / " + flg);

		if(flg == 2)
		{
			ExtendedPlayerProperties3.get(p).setNBTPlayerPetList(nbt);
			//DQR.petFunc.removePetdata(p, nbt.getString("uuid"));

			//NBTTagCompound playerPet = ExtendedPlayerProperties3.get(p).getNBTPlayerPetList();
	    	//Set tags = playerPet.func_150296_c();
	    	//System.out.println("TEST_PACKET : " + p.worldObj.isRemote + " / " + tags.size());
		}
		return null;

	}
}