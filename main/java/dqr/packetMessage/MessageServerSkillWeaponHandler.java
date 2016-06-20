package dqr.packetMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;
import dqr.api.enums.EnumDqmSkillW;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;

public class MessageServerSkillWeaponHandler implements IMessageHandler<MessageServerSkillWeapon, IMessage> {

    @Override//IMessageHandlerのメソッド
    public IMessage onMessage(MessageServerSkillWeapon message, MessageContext ctx) {
        //クライアントへ送った際に、EntityPlayerインスタンスはこのように取れる。
        //EntityPlayer player = DQR.proxy.getEntityPlayerInstance();
    	EntityPlayer ep = ctx.getServerHandler().playerEntity;

        int pat = message.data;
        int pat2 = message.data2;
        int pat3 = message.data3;

        EnumDqmSkillW skillW =  DQR.enumGetter.getSkillW(pat, pat2);

        if(skillW != null)
        {
        	if(pat3 == 1)
        	{
        		int perm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(pat, pat2);
        		if(perm == 1 && ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(pat) != pat2)
        		{
        			//int setSkill =  ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(pat);
        			ExtendedPlayerProperties3.get(ep).setWeaponSkillSet(pat, pat2);
        			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
        		}

        	}else
        	{
	        	int needWP = skillW.getPOINT();
	        	int nowWP = ExtendedPlayerProperties.get(ep).getJukurenWP(pat);
	        	int needLv = skillW.getNeedLv();
	        	int nowLv = ExtendedPlayerProperties.get(ep).getJukurenLv(pat);

	        	//System.out.println("？？？？:" + needWP + "/" + nowWP );
	        	if(needLv <= nowLv || DQR.debug == 1)
	        	{
		        	if(needWP <= nowWP || DQR.debug == 1)
		        	{
		        		String skillName = StatCollector.translateToLocal("dqm.skill." + skillW.getName() + ".name");
		        		ep.addChatMessage(new ChatComponentTranslation("msg.Dama3.messages.20.txt" ,new Object[] {skillName}));
		        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.levelup", 1.0F, 0.9F);
		        		ExtendedPlayerProperties.get(ep).setJukurenWP(pat, nowWP - needWP);
		        		ExtendedPlayerProperties3.get(ep).setWeaponSkillPermission(pat, pat2, 1);
		        		((ExtendedPlayerProperties)(ep.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME))).loadProxyData((EntityPlayer)ep);
		        		((ExtendedPlayerProperties3)(ep.getExtendedProperties(ExtendedPlayerProperties3.EXT_PROP_NAME))).loadProxyData((EntityPlayer)ep);
		        	}else
		        	{
		        		ep.addChatMessage(new ChatComponentTranslation("msg.Dama3.messages.40.txt" ,new Object[] {}));
		        	}
	        	}else
	        	{
	        		ep.addChatMessage(new ChatComponentTranslation("msg.Dama3.messages.42.txt" ,new Object[] {}));
	        	}
        	}
        }
        //System.out.println("PACKET:" + pat + " / " + pat2);
        /*
        //System.out.println(entityPlayer.getDisplayName() + ":" + pat);
        ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN.getId(), 20);

        if(ExtendedPlayerProperties.get(ep).getTabidachiFlg() != 100 ||
           ExtendedPlayerProperties.get(ep).getJobLv(0) < 50 ||
           pat != EnumDqmJob.Kenja.getId())
        {
	        if(ExtendedPlayerProperties3.get(ep).getJobPermission(pat) == 0)
	        {
	        	ep.addChatMessage(new ChatComponentTranslation("msg.Dama1.messages.24.txt" ,new Object[] {}));
	        	ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        	return null;
	        }

	        if(!DQR.jobChangeTable.getCheckJobChange(ep, pat))
	        {
	        	ep.addChatMessage(new ChatComponentTranslation("msg.Dama1.messages.25.txt" ,new Object[] {}));
	        	ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        	return null;
	        }
        }
		ep.worldObj.playSoundAtEntity(ep, "dqr:player.tensyoku", 1.0F, 1.0F);
        ExtendedPlayerProperties.get(ep).setJob(pat);
        ((ExtendedPlayerProperties)(ep.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME))).loadProxyData((EntityPlayer)ep);

        ep.addChatMessage(new ChatComponentTranslation("msg.Dama1.messages.22.txt" ,new Object[] {EnumDqmMessageConv.JobName.getStartS() + pat + EnumDqmMessageConv.JobName.getEndS()}));
        ep.addChatMessage(new ChatComponentTranslation("msg.Dama1.messages.23.txt" ,new Object[] {}));

*/
        //サーバーへ送った際に、EntityPlayerインスタンス（EntityPlayerMPインスタンス）はこのように取れる。
        //EntityPlayer entityPlayer = ctx.getServerHandler().playerEntity;
        //Do something.


        return null;//本来は返答用IMessageインスタンスを返すのだが、旧来のパケットの使い方をするなら必要ない。
    }
}
