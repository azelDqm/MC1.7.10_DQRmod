package dqr.party;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import dqr.PacketHandler;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.MessagePlayerProperties3;

public class DqmPartyManager {

	//キーはメンバー名：値がリーダー名
	public static Map<Entity, Entity> partySet = new HashMap();

	public DqmPartyManager(){}

	//パーティー作成
	public boolean createParty(Entity ep)
	{
		//System.out.println("TEST_LINE_A1");
		if(!partySet.containsValue(ep))
		{
			//System.out.println("TEST_LINE_A2");
			partySet.put(ep, ep);

			((EntityPlayer)ep).addChatMessage(new ChatComponentTranslation("msg.party.create.txt",new Object[] {}));

			if(!ep.worldObj.isRemote)
			{
				//System.out.println("TEST_LINE_A3");
				ThreadDqmPartyProc threadParty = new ThreadDqmPartyProc(ep);
				threadParty.start();
			}
			return true;
		}

		return false;
	}

	//メンバー追加(追加メンバーはIDから)
	public void addPartyMember(EntityPlayer ep, String newMember)
	{

		if(!ep.worldObj.isRemote)
		{
			MinecraftServer minecraftserver = MinecraftServer.getServer();
			Entity er = minecraftserver.getConfigurationManager().func_152612_a(newMember);
			//minecraftserver.getConfigurationManager().playerEntityList
			//partySet.put(ep, er);
			this.addPartyMember(ep, er);
			ep.addChatMessage(new ChatComponentTranslation("msg.party.join.txt",new Object[] {ep.getCommandSenderName()}));

		}
	}

	//メンバー追加(追加メンバーはEntity型)
	public void addPartyMember(Entity ep, Entity newMember)
	{

		//System.out.println("TEST_LINE1");

		if(!this.hasParty(newMember))
		{
			boolean flg = true;

			if(!(partySet.containsKey(ep)))
			{
				//System.out.println("TEST_LINE2");
				flg = createParty(ep);
			}

			if(flg)
			{
				//System.out.println("TEST_LINE3");
				this.sendPartyMessage(newMember, "msg.party.join2.txt", new Object[] {newMember.getCommandSenderName()});
				partySet.put(newMember, ep);
			}
		}else
		{
			if(ep instanceof EntityPlayer)
			{
				((EntityPlayer)ep).addChatMessage(new ChatComponentTranslation("msg.party.hasparty.txt",new Object[] {newMember.getCommandSenderName()}));
			}
		}
	}

	public boolean changePartyLeader(Entity newLeader, Entity oldLeader)
	{
		boolean ret = false;
        Iterator iterator = partySet.keySet().iterator();

        while (iterator.hasNext())
        {
        	Entity s = (Entity)iterator.next();
        	if(partySet.get(s).getCommandSenderName().equalsIgnoreCase(oldLeader.getCommandSenderName()))
        	{
        		partySet.put(s, newLeader);

        		ret = true;
        	}
        }

        if(ret)this.sendPartyMessage(newLeader, "msg.party.changeleader.txt", new Object[] {newLeader.getCommandSenderName()});

		return ret;
	}

	//パーティーリーダーになれる人を探す
	public boolean changePartyLeaderForce(Entity oldLeader)
	{
    	Entity newLeader = null;

        Iterator iterator2 = partySet.keySet().iterator();

        while (iterator2.hasNext())
        {
        	Entity s = (Entity)iterator2.next();
        	if(s instanceof EntityPlayer)
        	{
        		return this.changePartyLeader(s, oldLeader);
        	}
        }

        return false;
	}

	//パーティーからの除名
	//除名者がリーダーだった場合は、リーダー変更
	public boolean removePartyMember(Entity par1)
	{
		boolean ret = false;
		boolean leaderFlg = this.isPartyLeader(par1);

        Iterator iterator = partySet.keySet().iterator();

        /*
        while (iterator.hasNext())
        {
        	Entity s = (Entity)iterator.next();
        	if(s.getCommandSenderName().equalsIgnoreCase(par1.getCommandSenderName()))
        	{
        		leaderFlg = this.isPartyLeader(s);
        		ret = true;
        		partySet.remove(s);
        	}
        }
        */

        if(partySet.containsKey(par1))
        {
        	partySet.remove(par1);
        	ret = true;
        	if(par1 instanceof EntityPlayer)
        	{
        		EntityPlayer ep = (EntityPlayer)par1;
        		ep.addChatMessage(new ChatComponentTranslation("msg.party.leave.txt",new Object[] {}));
        	}
        }

        if(leaderFlg)
        {
        	/*
        	Entity newLeader = null;

            Iterator iterator2 = partySet.keySet().iterator();

            while (iterator2.hasNext())
            {
            	Entity s = (Entity)iterator2.next();
            	if(s instanceof EntityPlayer)
            	{
            		if(!this.changePartyLeader(s, par1))
            		{
            			this.closeParty(par1);
            		}
            		return true;
            	}
            }*/

            //リーダーになれるEntityがいない場合PT解散
        	if(!changePartyLeaderForce(par1))
        	{
        		this.closeParty(par1);
        	}
        	return true;
        }

        return ret;
	}

	//パーティーから除名
	public boolean kickPartyMember(String par1, EntityPlayer ep)
	{
        Iterator iterator = partySet.keySet().iterator();

        while (iterator.hasNext())
        {
            Entity s = (Entity)iterator.next();
            if(s.getCommandSenderName().equalsIgnoreCase(par1) &&
            		partySet.get(s).getCommandSenderName().equalsIgnoreCase(ep.getCommandSenderName()))
            {
            	partySet.remove(s);
            	if(s instanceof EntityPlayer)
            	{
            		((EntityPlayer)s).addChatMessage(new ChatComponentTranslation("msg.party.leave.txt",new Object[] {}));
            	}
            	ExtendedPlayerProperties3.get((EntityPlayer)s).setPartyMemberData(null);
            	if(!ep.worldObj.isRemote)
            	{
            		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)s), (EntityPlayerMP)s);
            	}
            	return true;
            }
        }

		return false;
	}

	public boolean kickPartyPet(EntityPlayer ep, boolean all)
	{
        Iterator iterator = partySet.keySet().iterator();
        boolean removeFlg = false;

        while (iterator.hasNext())
        {
            Entity s = (Entity)iterator.next();
            //System.out.println("NAME" + partySet.get(s).getCommandSenderName() + " / " + ep.getCommandSenderName());
            //System.out.println("NAME" + s.getCommandSenderName() + " / " + s.getClass().getName());
            if(s instanceof DqmPetBase &&
            		partySet.get(s).getCommandSenderName().equalsIgnoreCase(ep.getCommandSenderName()))
            {
            	partySet.remove(s);
            	if(s instanceof EntityPlayer)
            	{
            		((EntityPlayer)s).addChatMessage(new ChatComponentTranslation("msg.party.leave.txt",new Object[] {}));
            	}
            	removeFlg = true;
            	if(!all)
            	{
            		return true;
            	}
            }
        }

		return removeFlg;
	}

	public void closeParty(Entity ep)
	{
        Iterator iterator = partySet.keySet().iterator();

        while (iterator.hasNext())
        {
        	 Entity s = (Entity)iterator.next();
        	 if(partySet.get(s).getCommandSenderName().equalsIgnoreCase(ep.getCommandSenderName()))
        	 {
        		 partySet.remove(s);
        	 }
        }
	}

	public boolean isPartyLeader(Entity ep)
	{
		return partySet.containsValue(ep);
		//return partySet.get(ep).getCommandSenderName().equalsIgnoreCase(ep.getCommandSenderName());
	}

	//リーダー名からパーティを取得
	public HashMap getPartyFromLeader(Entity ep)
	{
		HashMap dataMap = new HashMap();

        Iterator iterator = partySet.keySet().iterator();
        int dataNum = 0;

        while (iterator.hasNext())
        {
            Entity s = (Entity)iterator.next();
            Entity epx = (Entity)ep;

            /*
            if(s instanceof EntityPlayerMP)
            {
            	System.out.println("############");
            }

            if(ep instanceof EntityPlayerMP)
            {
            	System.out.println("!!!!!!!!!!!!!!!");
            }
            */
            //System.out.println(s.getCommandSenderName());
            if(partySet.get(s).getCommandSenderName().equalsIgnoreCase(epx.getCommandSenderName()))
            {
            	dataMap.put((Entity)s, (Entity)epx);
            }
        }

		return dataMap;
	}

	public Entity getPartyLeaderFromMember(Entity ep)
	{
		Entity ret = null;

		if(partySet.containsKey(ep))
		{
			ret = partySet.get(ep);
		}

		return ret;
	}

	public boolean hasParty(Entity target)
	{
		return partySet.containsKey(target);
	}

	public void sendPartyMessage(Entity reader, String keys, Object[] obj)
	{
		Iterator iterator = partySet.keySet().iterator();
        while (iterator.hasNext())
        {
        	 Entity s = (Entity)iterator.next();
        	 if(partySet.get(s).getCommandSenderName().equalsIgnoreCase(reader.getCommandSenderName()))
        	 {
        		 if(s instanceof EntityPlayer)
        		 {
        			 ((EntityPlayer)s).addChatMessage(new ChatComponentTranslation(keys,new Object[] {reader.getCommandSenderName()}));
        		 }
        	 }
        }
	}
}