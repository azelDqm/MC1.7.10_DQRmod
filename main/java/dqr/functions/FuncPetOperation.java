package dqr.functions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties3;

public class FuncPetOperation {

	public FuncPetOperation(){}

	//ペットが仲間になった場合の登録処理
	public void setNewPetdata(DqmPetBase pet)
	{
		if(pet != null && pet.getOwner() != null)
		{
			EntityPlayer ep = (EntityPlayer)pet.getOwner();
			NBTTagCompound playerPet = ExtendedPlayerProperties3.get(ep).getNBTPlayerPetList();

			NBTTagCompound petData = new NBTTagCompound();

			if(pet.getCustomNameTag() != null && !pet.getCustomNameTag().equalsIgnoreCase(""))
			{
				petData.setString("PetName", pet.getCustomNameTag());
			}else
			{
				petData.setString("PetName", pet.getCommandSenderName());
			}

			petData.setInteger("dimension", pet.dimension);
			petData.setDouble("posX", pet.posX);
			petData.setDouble("posY", pet.posY);
			petData.setDouble("posZ", pet.posZ);
			petData.setString("petRoot", pet.type.PetRoot);
			petData.setBoolean("enable", false);

			if(playerPet.hasKey(pet.getUniqueID().toString()))
			{
				playerPet.removeTag(pet.getUniqueID().toString());
			}

			playerPet.setTag(pet.getUniqueID().toString(), petData);
			ExtendedPlayerProperties3.get(ep).setNBTPlayerPetList(playerPet);
		}
	}

	public void removePetdata(EntityPlayer ep, String uuid)
	{
		NBTTagCompound playerPet = ExtendedPlayerProperties3.get(ep).getNBTPlayerPetList();
		if(playerPet.hasKey(uuid))
		{
			playerPet.removeTag(uuid);
			ExtendedPlayerProperties3.get(ep).setNBTPlayerPetList(playerPet);
		}
	}

	public void clearPetdata(EntityPlayer ep)
	{
		NBTTagCompound  playerPet = new NBTTagCompound();
		ExtendedPlayerProperties3.get(ep).setNBTPlayerPetList(playerPet);

	}

	public void setUnloadPet(DqmPetBase pet)
	{
		//System.out.println("UnloadPet!!!!");
		if(pet != null && pet.getOwner() != null)
		{
			//System.out.println("UnloadPet!!!!");
			EntityPlayer ep = (EntityPlayer)pet.getOwner();
			NBTTagCompound playerPet = ExtendedPlayerProperties3.get(ep).getNBTPlayerPetList();

			NBTTagCompound petData = new NBTTagCompound();

			if(pet.getCustomNameTag() != null && !pet.getCustomNameTag().equalsIgnoreCase(""))
			{
				petData.setString("PetName", pet.getCustomNameTag());
			}else
			{
				petData.setString("PetName", pet.getCommandSenderName());
			}

			petData.setInteger("dimension", pet.dimension);
			petData.setDouble("posX", pet.posX);
			petData.setDouble("posY", pet.posY);
			petData.setDouble("posZ", pet.posZ);
			petData.setString("petRoot", pet.type.PetRoot);
			petData.setBoolean("enable", true);

			if(playerPet.hasKey(pet.getUniqueID().toString()))
			{
				playerPet.removeTag(pet.getUniqueID().toString());
			}
			playerPet.setTag(pet.getUniqueID().toString(), petData);
			ExtendedPlayerProperties3.get(ep).setNBTPlayerPetList(playerPet);


		}

	}

}
