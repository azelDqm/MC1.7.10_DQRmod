package dqr.command;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import dqr.DQR;
import dqr.api.enums.EnumColor;


public class DqrCom extends CommandBase {
	@Override
	public String getCommandName() {
		return "dqr";
	}

	@Override
	public void processCommand(ICommandSender var1, String[] var2) {
		//System.out.println("test" + var1.getCommandSenderName());

		//World hoge = var1.getEntityWorld();
		//hoge.getWorldInfo().setSpawnPosition(p_76081_1_, p_76081_2_, p_76081_3_);

		EntityPlayer ep = (EntityPlayer)var1;
		boolean flg = false;

        if(var2.length >= 1 && "conf".equalsIgnoreCase(var2[0]))
        {
        	//System.out.println("TEST1");
        	if(var2.length >= 2 && var2[1].equalsIgnoreCase("fishingMode"))
        	{
        		//System.out.println("TEST2");
        		if(var2.length >= 3 && (var2[2].equalsIgnoreCase("0") || var2[2].equalsIgnoreCase("1")))
        		{
        			DQR.conf.setFisshingMode(Integer.parseInt(var2[2]));
        			flg = true;
        			ep.addChatMessage(new ChatComponentTranslation(EnumColor.ITALIC.getChatColor() + EnumColor.Gray.getChatColor() + "FishingMode Changing to " + var2[2], new Object[] {}));
        		}
        	}
        }

        if(!flg)
        {
        	ep.addChatMessage(new ChatComponentTranslation(EnumColor.DarkRed.getChatColor() + "/dqr <conf> <fishMode> [0-1]", new Object[] {}));
        }else
        {

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
    	if(p_71516_2_.length == 1)
    	{
    		 return getListOfStringsMatchingLastWord(p_71516_2_, new String[] {"conf"});
    	}if(p_71516_2_.length == 2)
    	{
    		return getListOfStringsMatchingLastWord(p_71516_2_, new String[] {"fishingMode"});
    	}

    	return null;
    }
}
