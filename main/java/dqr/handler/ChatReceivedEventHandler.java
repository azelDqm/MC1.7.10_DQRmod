package dqr.handler;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMessageConv;
import dqr.api.enums.EnumDqmMobAI;

public class ChatReceivedEventHandler {
	@SubscribeEvent
	public void onClientChatReceivedEvent(ClientChatReceivedEvent event) {

		String chatMessage = "";

		boolean chatComponentType = true;

		//DQR.loglog.printChatMessage(event.message);
		/*
		System.out.println("TEST:" + event.message.getUnformattedText());
		System.out.println("TEST2:" + event.message.getFormattedText());
		System.out.println("TEST3:" + event.message.getUnformattedTextForChat());
		System.out.println("TEST4:" + (event.message instanceof ChatComponentText));
		System.out.println("TEST5:" + (event.message instanceof ChatComponentTranslation));
		*/

		chatComponentType = !(event.message instanceof ChatComponentText);

		//System.out.println("TEST:");
        if (event.message != null)
        {

        	if(event.message.getFormattedText().length() <= 8)
        	{
        		chatMessage = event.message.getFormattedText() + "        ";
        	}else
        	{
        		chatMessage = event.message.getFormattedText();
        	}

        	if(chatMessage.indexOf(EnumDqmMessageConv.PetSkill.getStartS()) >= 0 && chatMessage.indexOf(EnumDqmMessageConv.PetSkill.getEndS()) >= 0)
        	{
        		//System.out.println("TEST1:");
        		String[] splitStr = chatMessage.split(",");
        		String convMessage = "";
        		int maxLoop = (splitStr.length - 2) / 3;

        		for(int cnt = 0; cnt < maxLoop; cnt++)
        		{
        			//System.out.println("TEST2:" + cnt);
        			int aiId = Integer.parseInt(splitStr[cnt * 3 + 1]);
        			EnumDqmMobAI aiEnum = DQR.enumGetter.getDqmMobAI(aiId);

        			if(aiEnum != aiEnum.AVOID)
        			{
	        			if(cnt != 0)
	        			{
	        				convMessage = convMessage + " / ";
	        			}


	        			if(aiEnum.getGradeFlg() == 0)
	        			{
	        				int grade = Integer.parseInt(splitStr[cnt * 3 + 2]);
	        				convMessage = convMessage + splitStr[cnt * 3 + 3] + I18n.format("skill." + aiEnum.getName() + ".name",new Object[] {grade});
	        			}else
	        			{
	        				convMessage = convMessage + splitStr[cnt * 3 + 3] + I18n.format("skill." + aiEnum.getName() + "." + splitStr[cnt * 3 + 2] + ".name",new Object[] {});
	        			}
        			}
        		}

        		//event.message = new ChatComponentText(convMessage);
        		chatMessage = convMessage + "        ";
        	}

        	if(chatMessage.indexOf(EnumDqmMessageConv.MonsterName.getStartS()) >= 0)
        	{
        		int startPos = chatMessage.indexOf(EnumDqmMessageConv.MonsterName.getStartS());
        		int endPos = chatMessage.indexOf(EnumDqmMessageConv.MonsterName.getEndS());

        		if(startPos < endPos)
        		{
        			String mobName = chatMessage.substring(startPos, endPos + EnumDqmMessageConv.MonsterName.getEndLength());
        			//System.out.println(mobName);
        			if(mobName.indexOf("entity.") >= 0) mobName.replace("entity.", "");
        			if(mobName.indexOf(".name") >= 0) mobName.replace(".name", "");

        			String mobNameFix = I18n.format(("entity." + mobName + ".name")
        											 .replace(EnumDqmMessageConv.MonsterName.getStartS(),"")
        											 .replace(EnumDqmMessageConv.MonsterName.getEndS(), "")
        											);
        			chatMessage = chatMessage.replace(mobName, mobNameFix);
        			//System.out.println(mobName + "/" + mobNameFix);
        		}
        	}

        	//特技・スキル名置き換え
        	if(chatMessage.indexOf(EnumDqmMessageConv.SkillName.getStartS()) >= 0)
        	{

        		int startPos = chatMessage.indexOf(EnumDqmMessageConv.SkillName.getStartS());
        		int endPos = chatMessage.indexOf(EnumDqmMessageConv.SkillName.getEndS());
        		//System.out.println(startPos + "/" + endPos);
        		if(startPos < endPos)
        		{
        			String mobName = chatMessage.substring(startPos, endPos + EnumDqmMessageConv.SkillName.getEndLength());
        			String mobNameFix = I18n.format(("dqm.skill." + mobName + ".name")
        											 .replace(EnumDqmMessageConv.SkillName.getStartS(),"")
        											 .replace(EnumDqmMessageConv.SkillName.getEndS(), "")
        											);
        			chatMessage = EnumColor.Yellow.getChatColor() + chatMessage.replace(mobName, mobNameFix);
        			//System.out.println(mobName + "/" + mobNameFix);
        		}
        	}


        	if(chatMessage.indexOf(EnumDqmMessageConv.JobName.getStartS()) >= 0)
        	{
        		int startPos = chatMessage.indexOf(EnumDqmMessageConv.JobName.getStartS());
        		int endPos = chatMessage.indexOf(EnumDqmMessageConv.JobName.getEndS());

        		if(startPos < endPos)
        		{
        			String mobName = chatMessage.substring(startPos, endPos + EnumDqmMessageConv.JobName.getEndLength());
        			//System.out.println(mobName);
        			String mobNameFix = I18n.format(("main.job." + mobName)
        											 .replace(EnumDqmMessageConv.JobName.getStartS(),"")
        											 .replace(EnumDqmMessageConv.JobName.getEndS(), "")
        											);
        			chatMessage = chatMessage.replace(mobName, mobNameFix);
        			//System.out.println(mobName + "/" + mobNameFix);
        		}
        	}


        	if(DQR.conf.CLGuiLogVis == 1 || DQR.conf.CLGuiLogWindowOff == 0)
        	{
	        	if (chatMessage.indexOf("<") == -1 && chatMessage.indexOf(">") == -1 && !(chatMessage.indexOf("!player.") >= 0))
	        	{
	        		//DQR.proxy.SetChatLogMessage(event.message);
	        		//event.setCanceled(true);

	        		//System.out.println("通過B");
	        		/*
	    	    	if (DQR.dqmLog[0] == "")
	    	    	{
	    	    		DQR.dqmLog[0] = chatMessage;
	    	    	}else if (DQR.dqmLog[1] == "")
	    	    	{
	    	    		DQR.dqmLog[1] = chatMessage;
	    	    	}else if (DQR.dqmLog[2] == "")
	    	    	{
	    	    		DQR.dqmLog[2] = chatMessage;
	    	    	}else if (DQR.dqmLog[3] == "")
	    	    	{
	    	    		DQR.dqmLog[3] = chatMessage;
	    	    	}else if (DQR.dqmLog[4] == "")
	    	    	{
	    	    		DQR.dqmLog[4] = chatMessage;
	    	    	}else if (DQR.dqmLog[5] == "")
	    	    	{
	    	    		DQR.dqmLog[5] = chatMessage;
	    	    	}else if (DQR.dqmLog[6] == "")
	    	    	{
	    	    		DQR.dqmLog[6] = chatMessage;
	    	    	}else if (DQR.dqmLog[7] == "")
	    	    	{
	    	    		DQR.dqmLog[7] = chatMessage;
	    	    	}else
	    	    	{
		    			DQR.dqmLog[0] = DQR.dqmLog[1];
		    			DQR.dqmLog[1] = DQR.dqmLog[2];
		    			DQR.dqmLog[2] = DQR.dqmLog[3];
		    			DQR.dqmLog[3] = DQR.dqmLog[4];
		    			DQR.dqmLog[4] = DQR.dqmLog[5];
		    			DQR.dqmLog[5] = DQR.dqmLog[6];
		    			DQR.dqmLog[6] = DQR.dqmLog[7];
		    			DQR.dqmLog[7] = chatMessage;
	    	    	}
	    	    	*/
	        		DQR.loglog.printChatMessage(new ChatComponentTranslation(chatMessage,new Object[] {}));
	    	    	event.setCanceled(true);
	        	}
        	}else if(DQR.conf.CLGuiLogWindowOff == 1)
        	{
        		if(chatComponentType)
        		{
        			event.message = new ChatComponentTranslation(chatMessage.replace("        ",""),new Object[] {});
        		}else
        		{
        			event.message = new ChatComponentText(chatMessage.replace("        ",""));
        		}

        	}

        	if(chatMessage.substring(0, 8).equalsIgnoreCase("!player."))
			{
        		//System.out.println("DEBUGLINE:");
        		if(chatComponentType)
        		{
        			event.message = new ChatComponentTranslation(chatMessage.replace("!player.", ""),new Object[] {});
        		}else
        		{
        			event.message = new ChatComponentText(chatMessage.replace("!player.", ""));
        		}
			}else if(DQR.conf.CLGuiLogWindowOff == 2)
        	{
        		event.setCanceled(true);
        	}

        }
	}
}
