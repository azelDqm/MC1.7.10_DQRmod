package dqr.party;

import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.MessagePlayerProperties3;

public class ThreadDqmPartyProc extends Thread{

	private Entity ep;

	public ThreadDqmPartyProc(Entity ep)
	{
		this.ep = ep;
	}

	public void run()
	{

		//int cnt = 0;
		while(true)
		{
			NBTTagCompound mainNBT = new NBTTagCompound();
			int cntPlayer = 0;
			//ep.addChatMessage(new ChatComponentTranslation("TESTTEST" + cnt,new Object[] {}));
			//cnt++;

			HashMap partyMap = DQR.partyManager.getPartyFromLeader(this.ep);
			//System.out.println("TEST:" + partyMap.size());
			//System.out.println("TEST-1" + mainNBT.func_150296_c().size());
			if(partyMap.size() > 0)
			{
				//System.out.println("TEST-3" + partyMap.size());
				//System.out.println("TEST-2" + mainNBT.func_150296_c().size());
				Iterator it = partyMap.keySet().iterator();
				//System.out.println("TEST2?:" + partyMap.keySet().size());
				while(it.hasNext())
				{
					NBTTagCompound sideNBT = new NBTTagCompound();

					Entity key = (Entity)it.next();
					//System.out.println("TEST : " + key.getCommandSenderName());
					if(key instanceof EntityPlayer)
					{
						EntityPlayer xEp = (EntityPlayer)key;
						sideNBT.setInteger("sHP", (int)ExtendedPlayerProperties.get(xEp).getHP());
						sideNBT.setInteger("sMaxHP", (int)ExtendedPlayerProperties.get(xEp).getMaxHP());
						sideNBT.setInteger("sMP", ExtendedPlayerProperties.get(xEp).getMP());
						sideNBT.setInteger("sMaxMP", ExtendedPlayerProperties.get(xEp).getMaxMP());
						sideNBT.setInteger("sJob", ExtendedPlayerProperties.get(xEp).getJob());
						sideNBT.setInteger("sLv",  ExtendedPlayerProperties.get(xEp).getJobLv(ExtendedPlayerProperties.get(xEp).getJob()));

						mainNBT.setTag(key.getCommandSenderName(), sideNBT);
					}else if(key instanceof DqmPetBase)
					{
						DqmPetBase pet = (DqmPetBase)key;
						sideNBT.setInteger("sHP",(int)pet.getHealth());
						sideNBT.setInteger("sMaxHP", (int)pet.getMaxHealth());
						sideNBT.setInteger("sMP", pet.getMP());
						sideNBT.setInteger("sMaxMP", pet.getMaxMP());
						sideNBT.setInteger("sJob", pet.getJob());
						sideNBT.setInteger("sLv",  pet.getJobLv(pet.getJob()));

						mainNBT.setTag(key.getCommandSenderName(), sideNBT);
					}

				}

				Iterator it2 = partyMap.keySet().iterator();

				while(it2.hasNext())
				{
					Entity key = (Entity)it2.next();

					try
					{
						if(key instanceof EntityPlayer)
						{
							cntPlayer++;
							EntityPlayer rEp = (EntityPlayer)key;
							ExtendedPlayerProperties3.get(rEp).setPartyMemberData(mainNBT);
							//System.out.println("TEST1" + mainNBT.func_150296_c().size());
							MinecraftServer minecraftserver = MinecraftServer.getServer();
							if(minecraftserver.getConfigurationManager().playerEntityList.contains(rEp))
							{
								//System.out.println("TEST????");
								PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3(rEp), (EntityPlayerMP)rEp);
							}
						}
					}catch(Exception e){}
				}
			}

			if(cntPlayer <= 0)
			{
				DQR.partyManager.closeParty(this.ep);
				break;
			}
			/*
			if(cnt> 100)
			{
				break;
			}
			*/


			try{
				this.sleep(100L);
			}catch(Exception e)
			{

			}




		}

	}

}
