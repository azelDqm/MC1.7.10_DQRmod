package dqr.packetMessage;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.ExtendedPlayerProperties5;
import dqr.playerData.ExtendedPlayerProperties6;

public class MessageServerDataSendHandler implements IMessageHandler<MessageServerDataSend, IMessage>{

	@Override
	public IMessage onMessage(MessageServerDataSend message, MessageContext ctx) {


		EntityPlayerMP p = ctx.getServerHandler().playerEntity;

		NBTTagCompound nbt = message.getData();
		int flg = message.flg;

		//p.openGui(DQR.instance, i, p.worldObj, (int)p.posX, (int)p.posY, (int)p.posZ);
		//System.out.println("TESTTEST : " + nbt.func_150296_c().size() + " / " + flg);
		DQR.func.debugString("JobSkillDebug : A");

		if(flg == 2)
		{
			ExtendedPlayerProperties6.get(p).setNBTPlayerPetList(nbt);
			//DQR.petFunc.removePetdata(p, nbt.getString("uuid"));

			//NBTTagCompound playerPet = ExtendedPlayerProperties3.get(p).getNBTPlayerPetList();
	    	//Set tags = playerPet.func_150296_c();
	    	//System.out.println("TEST_PACKET : " + p.worldObj.isRemote + " / " + tags.size());
		}else if(flg == 3)
		{
			if(nbt != null)
			{
		    	NBTTagCompound checkData = (NBTTagCompound)nbt.getTag("DqmPlayerData3");
		    	//DQR.func.debugString(checkData.getString("playerUUID") + "/" + checkData.getString("playerName") + " / " + player.getCommandSenderName());

		    	if(p != null && checkData != null && checkData.getString("playerName").equalsIgnoreCase(p.getCommandSenderName()))
		    	{
		    		ExtendedPlayerProperties3.get(p).loadNBTData(nbt);
		    	}
			}
		}else if(flg == 5)
		{
			DQR.func.debugString("JobSkillDebug : B");
			if(nbt != null)
			{
				DQR.func.debugString("JobSkillDebug : C");
		    	NBTTagCompound checkData = (NBTTagCompound)nbt.getTag("DqmPlayerData5");
		    	//DQR.func.debugString(checkData.getString("playerUUID") + "/" + checkData.getString("playerName") + " / " + player.getCommandSenderName());

		    	DQR.func.debugString("JobSkillDebug1 : " + checkData.getString("playerName"));
		    	DQR.func.debugString("JobSkillDebug2 : " + p.getCommandSenderName());

		    	if(p != null && checkData != null && checkData.getString("playerName").equalsIgnoreCase(p.getCommandSenderName()))
		    	{
		    		DQR.func.debugString("JobSkillDebug : D");
		    		ExtendedPlayerProperties5.get(p).loadNBTData(nbt);
		    	}
			}
		}
		return null;

	}
}