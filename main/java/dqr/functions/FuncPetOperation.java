package dqr.functions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import dqr.DQR;
import dqr.DqrWorldData;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties6;

public class FuncPetOperation {

	public FuncPetOperation(){}

	//ペットが仲間になった場合の登録処理
	public void setNewPetdata(DqmPetBase pet)
	{
		if(!pet.worldObj.isRemote && pet != null && pet.getOwner() != null)
		{
			EntityPlayer ep = (EntityPlayer)pet.getOwner();
			NBTTagCompound playerPet = ExtendedPlayerProperties6.get(ep).getNBTPlayerPetList();

			NBTTagCompound petData = new NBTTagCompound();

			if(pet.getCustomNameTag() != null && !pet.getCustomNameTag().equalsIgnoreCase(""))
			{
				petData.setString("PetName", pet.getCustomNameTag());
			}else
			{
				petData.setString("PetName", pet.getCommandSenderName());
			}

			long petUniqueNum = 0;
			if(pet.getPetUniqueNumber() == 0)
			{
				DqrWorldData wd = (DqrWorldData)ep.worldObj.loadItemData(DqrWorldData.class, DQR.modID);
				if(wd == null)
				{
					wd = new DqrWorldData(DQR.modID);
				}
				petUniqueNum = wd.getNextPetNum();
				wd.markDirty();
				ep.worldObj.setItemData(DQR.modID, wd);
				pet.setPetUniqueNumber(petUniqueNum);
			}else
			{
				petUniqueNum = pet.getPetUniqueNumber();
			}


			petData.setInteger("dimension", pet.dimension);
			petData.setDouble("posX", pet.posX);
			petData.setDouble("posY", pet.posY);
			petData.setDouble("posZ", pet.posZ);
			petData.setString("petRoot", pet.type.PetRoot);
			petData.setBoolean("enable", false);
			petData.setLong("PetUniqueNumber", petUniqueNum);
			//petData.setString("puuid", pet.getUniqueID().toString());

			if(playerPet.hasKey(pet.getUniqueID().toString()))
			{
				playerPet.removeTag(pet.getUniqueID().toString());
			}

			if(playerPet.hasKey(String.valueOf(petUniqueNum)))
			{
				playerPet.removeTag(String.valueOf(petUniqueNum));
			}

			//playerPet.setTag(pet.getUniqueID().toString(), petData);
			//playerPet.setTag(pet.getUniqueID().toString(), petData);

			playerPet.setTag(String.valueOf(petUniqueNum), petData);
			ExtendedPlayerProperties6.get(ep).setNBTPlayerPetList(playerPet);
		}
	}

	public void removePetdata2(EntityPlayer ep, long unum)
	{
		NBTTagCompound playerPet = ExtendedPlayerProperties6.get(ep).getNBTPlayerPetList();
		//System.out.println("TESTXXXX1 : " + playerPet.func_150296_c().size());
		if(unum != 0 && playerPet.hasKey(String.valueOf(unum)))
		{
			playerPet.removeTag(String.valueOf(unum));
			ExtendedPlayerProperties6.get(ep).setNBTPlayerPetList(playerPet);

			//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
		}

		if(unum != 0 && playerPet.hasKey(String.valueOf(unum + "L")))
		{
			playerPet.removeTag(String.valueOf(unum + "L"));
			ExtendedPlayerProperties6.get(ep).setNBTPlayerPetList(playerPet);

			//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
		}
	}

	public void removePetdata(EntityPlayer ep, String uuid)
	{
		NBTTagCompound playerPet = ExtendedPlayerProperties6.get(ep).getNBTPlayerPetList();
		//System.out.println("TESTXXXX1 : " + playerPet.func_150296_c().size());
		if(playerPet.hasKey(uuid))
		{
			playerPet.removeTag(uuid);
			ExtendedPlayerProperties6.get(ep).setNBTPlayerPetList(playerPet);

			//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
		}

		if(playerPet.hasKey(uuid + "L"))
		{
			playerPet.removeTag(uuid + "L");
			ExtendedPlayerProperties6.get(ep).setNBTPlayerPetList(playerPet);

			//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)ep), (EntityPlayerMP)ep);
		}
		/*
		if(!ep.worldObj.isRemote)
		{
			PacketHandler.INSTANCE.sendTo(new MessageClientDataSend(playerPet , 2), (EntityPlayerMP)ep);
			System.out.println("TESTXXXX2 : " + playerPet.func_150296_c().size());
		}else
		{
			PacketHandler.INSTANCE.sendToServer(new MessageServerDataSend(playerPet, 2));
			System.out.println("TESTXXXX3 : " + playerPet.func_150296_c().size());
		}
		*/

	}

	public void clearPetdata(EntityPlayer ep)
	{
		NBTTagCompound  playerPet = new NBTTagCompound();
		ExtendedPlayerProperties6.get(ep).setNBTPlayerPetList(playerPet);

	}

	public void setUnloadPet(DqmPetBase pet)
	{
		//System.out.println("UnloadPet!!!!");
		if(!pet.worldObj.isRemote && pet != null && pet.getOwner() != null)
		{
			//System.out.println("UnloadPet!!!!");
			EntityPlayer ep = (EntityPlayer)pet.getOwner();
			NBTTagCompound playerPet = ExtendedPlayerProperties6.get(ep).getNBTPlayerPetList();

			NBTTagCompound petData = new NBTTagCompound();

			if(pet.getCustomNameTag() != null && !pet.getCustomNameTag().equalsIgnoreCase(""))
			{
				petData.setString("PetName", pet.getCustomNameTag());
			}else
			{
				petData.setString("PetName", pet.getCommandSenderName());
			}

			long petUniqueNum = 0;
			if(pet.getPetUniqueNumber() == 0)
			{
				DqrWorldData wd = (DqrWorldData)pet.worldObj.loadItemData(DqrWorldData.class, DQR.modID);
				if(wd == null)
				{
					wd = new DqrWorldData(DQR.modID);
				}
				petUniqueNum = wd.getNextPetNum();
				wd.markDirty();
				pet.worldObj.setItemData(DQR.modID, wd);
				pet.setPetUniqueNumber(petUniqueNum);
			}else
			{
				petUniqueNum = pet.getPetUniqueNumber();
			}

			petData.setInteger("dimension", pet.dimension);
			petData.setDouble("posX", pet.posX);
			petData.setDouble("posY", pet.posY);
			petData.setDouble("posZ", pet.posZ);
			petData.setString("petRoot", pet.type.PetRoot);
			petData.setBoolean("enable", true);
			petData.setLong("PetUniqueNumber", petUniqueNum);
			//petData.setString("puuid", pet.getUniqueID().toString());

			//DQR.func.debugString("TEST_Pet 2 : " + pet.getUniqueID().toString());
			/*
			Object[] keys = playerPet.func_150296_c().toArray();
			for(int cnt = 0; cnt < keys.length; cnt++)
			{
				DQR.func.debugString("TEST_Pet 1 : " + (String)keys[cnt]);
			}
			*/

			if(playerPet.hasKey(pet.getUniqueID().toString()))
			{
				playerPet.removeTag(pet.getUniqueID().toString());
			}

			if(playerPet.hasKey(String.valueOf(petUniqueNum)))
			{
				playerPet.removeTag(String.valueOf(petUniqueNum));
			}
			playerPet.setTag(String.valueOf(petUniqueNum), petData);
			ExtendedPlayerProperties6.get(ep).setNBTPlayerPetList(playerPet);


		}

	}

}
