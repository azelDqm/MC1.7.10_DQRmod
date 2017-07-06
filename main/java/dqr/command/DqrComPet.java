package dqr.command;

import java.util.List;
import java.util.Set;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import dqr.DQR;
import dqr.api.enums.EnumColor;
import dqr.playerData.ExtendedPlayerProperties3;


public class DqrComPet extends CommandBase {
	@Override
	public String getCommandName() {
		return "dqrpet";
	}

    public int getRequiredPermissionLevel()
    {
        return 0;
    }

    /**
     * Returns true if the given command sender is allowed to use this command.
     */
    public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_)
    {
        return true;
    }

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		//System.out.println("test" + var1.getCommandSenderName());

		//World hoge = var1.getEntityWorld();
		//hoge.getWorldInfo().setSpawnPosition(p_76081_1_, p_76081_2_, p_76081_3_);

		EntityPlayer ep = (EntityPlayer)var1;

		if(!ep.worldObj.isRemote)
		{
			if(var2.length > 0)
			{
				if(var2[0].equalsIgnoreCase("refresh"))
				{
					NBTTagCompound nbt = ExtendedPlayerProperties3.get(ep).getNBTPlayerPetList();
					if(nbt != null)
					{
				    	Set tags = nbt.func_150296_c();
				    	Object[] tagArray = tags.toArray();
				    	int setCount = 0;
				    	//System.out.println("test2 : " + tags.size());

				    	String preUUID = "";
				        for(int cnt = 0; cnt < tagArray.length; cnt++)
				        {
			        		try
			        		{

			        			NBTTagCompound petData = nbt.getCompoundTag((String)tagArray[cnt]);
			        			//System.out.println("TEST1 : " + (String)tagArray[cnt]);
			        			if(petData != null)
			        			{
			        				//System.out.println("TEST2 : " + nbt.getString("PetName"));
			        				String uid = (String)tagArray[cnt];

			        	    		int locX = petData.getInteger("posX");
			        				int locY = petData.getInteger("posY");
			        				int locZ = petData.getInteger("posZ");
			        				int locDim = petData.getInteger("dimension");


			        				//System.out.println("TEST : " + locX + "/" + locY  + "/" + locZ);
			        				if(locX == 0 && locY == 0 && locZ == 0 && locDim == 0 || preUUID.equalsIgnoreCase(uid))
			        				{
			        					ExtendedPlayerProperties3.get(ep).minusPetCount(1);
			        		        	DQR.petFunc.removePetdata(ep, uid);
			        		        	ep.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petCommand.s0",new Object[] {petData.getString("PetName")}));
			        		        	setCount++;
			        		        	//flg = true;
			        				}
			        				preUUID = uid;
			        			}
			        		}catch(Exception e)
			        		{

			        		}
				        	//items[cnt].
				        }

					}
				}else if(var2[0].equalsIgnoreCase("clear"))
				{
					DQR.petFunc.clearPetdata(ep);
					ep.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petCommand.s1",new Object[] {}));

				}
			}else
	        {
	        	ep.addChatMessage(new ChatComponentTranslation(EnumColor.DarkRed.getChatColor() + "/dqrpet refresh|clear", new Object[] {}));
	        }
		}
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return "dqr.commands.dqrpt.usage";
	}

    /**
     * Adds the strings available in this command to the given list of tab completion options.
     */
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_)
    {
    	//System.out.println("test2" + p_71516_2_.length);

    	/*
    	if(p_71516_2_.length == 1)
    	{
    		 return getListOfStringsMatchingLastWord(p_71516_2_, new String[] {"create", "add", "kick", "leave", "change"});
    	}else if(p_71516_2_.length == 2)
    	{
    		if(p_71516_2_[0].equalsIgnoreCase("kick"))
    		{

    			int size = 0;
    			if(MinecraftServer.getServer().getAllUsernames() != null)
    			{
    				size = MinecraftServer.getServer().getAllUsernames().length;
    			}

    			String[] names = new String[size + 2];

    			for(int cnt = 0; cnt < size; cnt++)
    			{
    				names[cnt] = MinecraftServer.getServer().getAllUsernames()[cnt];
    			}

    			names[size] = "$pet";
    			names[size + 1] = "$pets";
    			return getListOfStringsMatchingLastWord(p_71516_2_, names);
    		}else if(p_71516_2_[0].equalsIgnoreCase("add") || p_71516_2_[0].equalsIgnoreCase("change"))
        	{
        		return getListOfStringsMatchingLastWord(p_71516_2_, MinecraftServer.getServer().getAllUsernames());
        	}
    	}
    	*/


    	return null;
    }
}
