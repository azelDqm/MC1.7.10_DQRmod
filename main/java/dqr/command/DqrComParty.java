package dqr.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import dqr.DQR;
import dqr.api.enums.EnumColor;


public class DqrComParty extends CommandBase {
	@Override
	public String getCommandName() {
		return "dqrpt";
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
		        if(var2[0].equalsIgnoreCase("create"))
		        {
		        	DQR.partyManager.createParty(ep);
		        	//ThreadDqmPartyProc builderThread = new ThreadDqmPartyProc(ep);
		        	//builderThread.start();
		        }else if(var2[0].equalsIgnoreCase("add"))
		        {
		        	if(var2.length >= 2)
		        	{
		        		DQR.partyManager.addPartyMember(ep, var2[1]);
		        	}else
		        	{
		        		ep.addChatMessage(new ChatComponentTranslation(EnumColor.DarkRed.getChatColor() + "/dqrpt add <PlayerName>", new Object[] {}));
		        	}
		        }else if(var2[0].equalsIgnoreCase("kick"))
		        {
		        	if(var2.length >= 2)
		        	{
		        		//System.out.println("TEST");
		        		if(DQR.partyManager.isPartyLeader(ep))
		        		{
			        		if(var2[1].equalsIgnoreCase("$pet"))
			        		{
			        			DQR.partyManager.kickPartyPet(ep, false);
			        		}else if(var2[1].equalsIgnoreCase("$pets"))
			        		{
			        			DQR.partyManager.kickPartyPet(ep, true);
			        		}else
			        		{
			        			DQR.partyManager.kickPartyMember(var2[1], ep);
			        		}
		        		}else
		        		{
		        			ep.addChatMessage(new ChatComponentTranslation("msg.shinziru.modeInfo.txt", new Object[] {}));
		        		}
		        	}else
		        	{
		        		ep.addChatMessage(new ChatComponentTranslation(EnumColor.DarkRed.getChatColor() + "/dqrpt kick <PlayerName>|$pet|$pets", new Object[] {}));
		        	}
		        }else if(var2[0].equalsIgnoreCase("leave"))
		        {
		        	if(var2.length >= 1)
		        	{
		        		DQR.partyManager.removePartyMember(ep);
		        	}
		        }else if(var2[0].equalsIgnoreCase("close"))
		        {
		        	if(DQR.partyManager.isPartyLeader(ep))
		    		{
		        		DQR.partyManager.closeParty(ep);
		        	}else
		        	{
		        		ep.addChatMessage(new ChatComponentTranslation("msg.shinziru.modeInfo.txt", new Object[] {}));
		        	}
		        }else if(var2[0].equalsIgnoreCase("change"))
		        {
		        	if(var2.length >= 2)
		        	{
		        		//System.out.println("TEST");
		        		if(DQR.partyManager.isPartyLeader(ep))
		        		{
		        			DQR.partyManager.changePartyLeader(var2[1], ep);
		        		}else
			        	{
			        		ep.addChatMessage(new ChatComponentTranslation("msg.shinziru.modeInfo.txt", new Object[] {}));
			        	}
		        	}else
		        	{
		        		ep.addChatMessage(new ChatComponentTranslation(EnumColor.DarkRed.getChatColor() + "/dqrpt change <PlayerName>", new Object[] {}));
		        	}
		        }else
		        {
		        	ep.addChatMessage(new ChatComponentTranslation(EnumColor.DarkRed.getChatColor() + "/dqrpt <add|kick|leave|change>", new Object[] {}));
		        }
			}else
	        {
	        	ep.addChatMessage(new ChatComponentTranslation(EnumColor.DarkRed.getChatColor() + "/dqrpt <add|kick|leave|change>", new Object[] {}));
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


    	return null;
    }
}
