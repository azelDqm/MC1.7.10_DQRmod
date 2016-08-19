package dqr.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import dqr.DQR;


public class DqrComParty extends CommandBase {
	@Override
	public String getCommandName() {
		return "dqrpt";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		//System.out.println("test" + var1.getCommandSenderName());

		//World hoge = var1.getEntityWorld();
		//hoge.getWorldInfo().setSpawnPosition(p_76081_1_, p_76081_2_, p_76081_3_);

		EntityPlayer ep = (EntityPlayer)var1;

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
        		}
        	}
        }else if(var2[0].equalsIgnoreCase("leave"))
        {
        	if(var2.length >= 2)
        	{
        		DQR.partyManager.removePartyMember(ep);
        	}
        }

	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return "mpg.commands.mpg.usage";
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
    		 return getListOfStringsMatchingLastWord(p_71516_2_, new String[] {"send", "add", "remove", "set", "list"});
    	}else if(p_71516_2_.length == 2)
    	{
    		return getListOfStringsMatchingLastWord(p_71516_2_, MinecraftServer.getServer().getAllUsernames());
    	}
    	*/

    	return null;
    }
}
