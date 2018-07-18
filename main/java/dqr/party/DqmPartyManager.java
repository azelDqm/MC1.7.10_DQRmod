package dqr.party;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.MessagePlayerProperties3;
import dqr.thread.NoThreadProcess;
import dqr.thread.ThreadLvUp;
import dqr.thread.ThreadLvUpPet;

public class DqmPartyManager {

	//キーはメンバー名：値がリーダー名
	//private static Map<Entity, String> partySet = new HashMap();
	private static Map<Object, String> partySet = new HashMap();
	private static Map<String, Integer> expShareRate = new HashMap();

	public DqmPartyManager(){}

	//パーティー作成
	public boolean createParty(Entity ep)
	{
		//System.out.println("TEST_LINE_A1");
		if(!partySet.containsValue(ep.getCommandSenderName()))
		{
			//System.out.println("TEST_LINE_A2");
			partySet.put(ep.getCommandSenderName(), ep.getCommandSenderName());
			expShareRate.put(ep.getCommandSenderName(), 0);
			DQR.func.doAddChatMessageFix((EntityPlayer)ep, new ChatComponentTranslation("msg.party.create.txt",new Object[] {}));

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
			if(er != null)
			{
				this.addPartyMember(ep, er);
				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.party.join.txt",new Object[] {ep.getCommandSenderName()}));
			}else
			{
				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.party.noplayer.txt",new Object[] {}));
			}

		}
	}

	//メンバー追加(追加メンバーはEntity型)
	/**
	 *
	 * Playerの場合は値はString型(CommandSenderName)で登録される。
	 * PetMonsterの場合は、値はEntity型で登録される。
	 *
	 * @param ep リーダー(EntityPlayer)
	 * @param newMember 追加するメンバー(Entity)
	 *
	 */
	public void addPartyMember(Entity ep, Entity newMember)
	{

		//tbwertbqweb
		//System.out.println("TEST_LINE1");
		if(DQR.debug == 8)System.out.println("PT_DEBUG2:");
		if(!this.hasParty(newMember))
		{
			boolean flg = true;

			//tgvpeqtmiebw
			if(!(partySet.containsKey(ep.getCommandSenderName())))
			{
				if(DQR.debug == 8)System.out.println("PT_DEBUG2-2:");
				//System.out.println("TEST_LINE2");
				//リーダー指定プレイヤーがkeyに存在しない倍は、PTを作成する。
				flg = createParty(ep);
			}

			if(flg)
			{
				if(DQR.debug == 8)System.out.println("PT_DEBUG2-3:");
				//System.out.println("TEST_LINE3");
				this.sendPartyMessage(newMember, "msg.party.join2.txt", new Object[] {newMember.getCommandSenderName()});
				if(newMember instanceof DqmPetBase)
				{
					partySet.put(newMember, ep.getCommandSenderName());
				}else if(newMember instanceof EntityPlayer)
				{
					partySet.put(newMember.getCommandSenderName(), ep.getCommandSenderName());
				}
			}
		}else
		{
			if(ep instanceof EntityPlayer)
			{
				DQR.func.doAddChatMessageFix((EntityPlayer)ep, new ChatComponentTranslation("msg.party.hasparty.txt",new Object[] {newMember.getCommandSenderName()}));
			}
		}
	}


	/**
	 * パーティーリーダーの変更
	 * 実際は、オーバーロードクラスで処理を行う
	 *
	 * @param newLeader 新リーダーのCommandSenderName
	 * @param oldLeader 旧リーダーのEntityPlayerインスタンス
	 * @return
	 */
	public boolean changePartyLeader(String newLeader, Entity oldLeader)
	{
		boolean ret = false;
		if(newLeader == null || oldLeader == null) return ret;

		if(!oldLeader.worldObj.isRemote)
		{
			MinecraftServer minecraftserver = MinecraftServer.getServer();
			Entity er = minecraftserver.getConfigurationManager().func_152612_a(newLeader);

			if(er != null)
			{
				this.changePartyLeader(er, oldLeader);
			}else
			{
				DQR.func.doAddChatMessageFix((EntityPlayer)oldLeader, new ChatComponentTranslation("msg.party.noplayer.txt",new Object[] {}));
			}
		}

		return ret;
	}

	/**
	 *
	 * @param newLeader 新リーダーのEntityPlayerインスタンス
	 * @param oldLeader 旧リーダーのEntityPlayerインスタンス
	 * @return
	 */
	public boolean changePartyLeader(Entity newLeader, Entity oldLeader)
	{
		boolean ret = false;
        //if(newLeader == null || oldLeader == null) return ret;

		Iterator iterator = partySet.keySet().iterator();

        while (iterator.hasNext())
        {
        	Object s = iterator.next();
        	MinecraftServer minecraftserver = MinecraftServer.getServer();
        	Entity er = minecraftserver.getConfigurationManager().func_152612_a(partySet.get(s));
        	if(er != null && er.getCommandSenderName().equalsIgnoreCase(oldLeader.getCommandSenderName()))
        	{
        		partySet.put(s, newLeader.getCommandSenderName());

        		ret = true;
        	}
        }

		if(ret)
		{
			int shareRate = 0;
			if(oldLeader != null && expShareRate.containsKey(oldLeader.getCommandSenderName()))
			{
				shareRate = expShareRate.get(oldLeader.getCommandSenderName());
				expShareRate.remove(oldLeader.getCommandSenderName());
			}
			expShareRate.put(newLeader.getCommandSenderName(), shareRate);


			//System.out.println("TEST_LINE_A3");
			ThreadDqmPartyProc threadParty = new ThreadDqmPartyProc(newLeader);
			threadParty.start();

			this.sendPartyMessage(newLeader, "msg.party.changeleader.txt", new Object[] {newLeader.getCommandSenderName()});
		}

		return ret;
	}

	/**
	 * パーティーリーダーになれる人を探す
	 * @param oldLeader 旧パーティーリーダー
	 * @return
	 */
	public boolean changePartyLeaderForce(Entity oldLeader)
	{
    	Entity newLeader = null;

        Iterator iterator2 = partySet.keySet().iterator();

        while (iterator2.hasNext())
        {
        	//Entity s = (Entity)iterator2.next();
        	Object s = iterator2.next();
        	if(s instanceof String)
        	{
        		EntityPlayer ep = DQR.func.getPlayerFromName((String)s);
        		if(ep != null && oldLeader != null)
        		{
        			if(!(ep.getCommandSenderName().equalsIgnoreCase(oldLeader.getCommandSenderName())))
        			{
        				return this.changePartyLeader(ep, oldLeader);
        			}
        		}
        	}

        }

        return false;
	}

	/**
	 * パーティーからの除名。除名者がリーダーだった場合は、リーダー変更
	 * @param par1 パーティーから除名するEntity(Plyaer / Pet)
	 * @return
	 */
	public boolean removePartyMember(Entity par1)
	{
		boolean ret = false;
		boolean leaderFlg = this.isPartyLeader(par1);

		List removeKeys = new ArrayList();

        Iterator iterator = partySet.keySet().iterator();


        while (iterator.hasNext())
        {
        	Entity s = null;
        	Object o = iterator.next();
        	if(o instanceof DqmPetBase)
        	{
        		s = (Entity)o;
        	}else if(o instanceof String)
        	{
        		s = DQR.func.getPlayerFromName((String)o);
        	}


        	if(s.getUniqueID().toString().equalsIgnoreCase(par1.getUniqueID().toString()))
        	{
        		leaderFlg = this.isPartyLeader(s);
        		ret = true;
        		//partySet.remove(s);
        		removeKeys.add(o);
        	}
        }

        /*
        if(partySet.containsKey(par1))
        {
        	removeKeys.add(par1);
        	//partySet.remove(par1);
        	ret = true;

        }
        */


        for(int cnt = 0; cnt < removeKeys.size(); cnt++)
        {
        	partySet.remove(removeKeys.get(cnt));
        	if(par1 instanceof EntityPlayer)
        	{
        		ExtendedPlayerProperties3.get((EntityPlayer)par1).setPartyMemberData(null);
            	if(!par1.worldObj.isRemote)
            	{
            		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)par1), (EntityPlayerMP)par1);
            	}
        		EntityPlayer ep = (EntityPlayer)par1;
        		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.party.leave.txt",new Object[] {}));
        	}
        }

        if(leaderFlg)
        {

            //リーダーになれるEntityがいない場合PT解散
        	if(!changePartyLeaderForce(par1))
        	{
        		this.closeParty(par1);
        	}
        	return true;
        }

        return ret;
	}

	//
	/**
	 * パーティーから除名
	 * @param par1 除名するメンバー名
	 * @param ep パーティーリーダーのEntity
	 * @return
	 */
	public boolean kickPartyMember(String par1, EntityPlayer ep)
	{
        Iterator iterator = partySet.keySet().iterator();

        while (iterator.hasNext())
        {
        	//TableのKeyの1要素
            //Object s = (Entity)iterator.next();
        	Object o = iterator.next();

            if(o instanceof String && ((String)o).equalsIgnoreCase(par1))
            {
                //除名するPlaerEntityを取得
            	MinecraftServer minecraftserver = MinecraftServer.getServer();
                Entity er = minecraftserver.getConfigurationManager().func_152612_a((String)o);

                partySet.remove(o);
                ExtendedPlayerProperties3.get((EntityPlayer)er).setPartyMemberData(null);
            	if(!ep.worldObj.isRemote)
            	{
            		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)er), (EntityPlayerMP)er);
            	}

            	return true;
            }

            /*
             * 旧処理。リーダーチェックしてたけど必要だっけ？
            if(er != null && er.getCommandSenderName().equalsIgnoreCase(par1) && partySet.get(er) != null &&
            		partySet.get(er).equalsIgnoreCase(ep.getCommandSenderName()))
            {
            	partySet.remove();
            	if(s instanceof EntityPlayer)
            	{
            		ExtendedPlayerProperties3.get((EntityPlayer)er).setPartyMemberData(null);
                	if(!ep.worldObj.isRemote)
                	{
                		PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)er), (EntityPlayerMP)s);
                	}
            		((EntityPlayer)er).addChatMessage(new ChatComponentTranslation("msg.party.leave.txt",new Object[] {}));


            		//ExtendedPlayerProperties3.get((EntityPlayer)s).setPartyMemberData(null);
                	//if(!ep.worldObj.isRemote)
                	//{
                	//	PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)s), (EntityPlayerMP)s);
                	//}

            	}


            	return true;
            }
            */
        }


		return false;
	}

	/**
	 * パーティからのペットの除名
	 *
	 * @param ep ペットを除名したいパーティーのリーダー
	 * @param all 全ペット除名するかどうか。trueの場合全ペット、falseの場合1匹目のみ除名
	 * @return
	 */
	public boolean kickPartyPet(EntityPlayer ep, boolean all)
	{
        Iterator iterator = partySet.keySet().iterator();
        List removeKeys = new ArrayList();
        boolean removeFlg = false;

        while (iterator.hasNext())
        {
        	Object o = iterator.next();
        	if(o instanceof DqmPetBase)
        	{
	            Entity s = (Entity)o;
	            //System.out.println("NAME" + partySet.get(s).getCommandSenderName() + " / " + ep.getCommandSenderName());
	            //System.out.println("NAME" + s.getCommandSenderName() + " / " + s.getClass().getName());
	            if(partySet.get(o) != null &&
	            	partySet.get(o).equalsIgnoreCase(ep.getCommandSenderName()))
	            {
	            	removeFlg = true;
	            	if(!all)
	            	{
	            		partySet.remove(o);
	            		return true;
	            	}else
	            	{
	            		removeKeys.add(o);
	            	}
	            }
        	}
        }

        for(int cnt = 0; cnt < removeKeys.size(); cnt++)
        {
        	partySet.remove(removeKeys.get(cnt));
        }

		return removeFlg;
	}

	/**
	 * ペット指定でパーティからの除名
	 *
	 * @param ep パーティリーダーのインスタンス
	 * @param pet 除名したいペットモンスターのインスタンス
	 * @return
	 */
	public boolean kickPartyPet(EntityPlayer ep, DqmPetBase pet)
	{

        boolean removeFlg = false;

        if(pet instanceof DqmPetBase && partySet.get(pet) != null &&
        		partySet.get(pet).equalsIgnoreCase(ep.getCommandSenderName()))
        {
        	partySet.remove(pet);

        	removeFlg = true;
        }

		return removeFlg;
	}

	/**
	 * パーティー解散。VALUEがリーダーの名前だった場合に、Tableから削除。
	 * @param ep リーダーのEntityPlayerインスタンス
	 */
	public void closeParty(Entity ep)
	{
        Iterator iterator = partySet.keySet().iterator();
        List removeKeys = new ArrayList();
        String readerName = getPartyLeaderFromMember(ep);
        while (iterator.hasNext())
        {
        	Object o = iterator.next();

        	 if(o != null && partySet.get(o) != null && ep != null && partySet.get(o).equalsIgnoreCase(ep.getCommandSenderName()))
        	 {
        		 //partySet.remove(s);
        		 removeKeys.add(o);

        	 }
        }


        for(int cnt = 0; cnt < removeKeys.size(); cnt++)
        {
        	partySet.remove(removeKeys.get(cnt));
			if(removeKeys.get(cnt) instanceof String)
			{
				String keyX = (String)removeKeys.get(cnt);
				MinecraftServer minecraftserver = MinecraftServer.getServer();
				Entity er = minecraftserver.getConfigurationManager().func_152612_a(keyX);

				if(er != null)
				{
					ExtendedPlayerProperties3.get((EntityPlayer)er).setPartyMemberData(null);

					if(!ep.worldObj.isRemote)
					{
						PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3((EntityPlayer)er), (EntityPlayerMP)er);
					}
				}
			}
        }

        expShareRate.remove(readerName);

	}

	/**
	 * 指定プレイヤーがPTリーダーかの確認
	 * @param ep 確認したいプレイヤー
	 * @return
	 */
	public boolean isPartyLeader(Entity ep)
	{
		return partySet.containsValue(ep.getCommandSenderName());
		//return partySet.get(ep).getCommandSenderName().equalsIgnoreCase(ep.getCommandSenderName());
	}

	//リーダー名からパーティを取得
	/**
	 * 指定したプレイヤーがリーダーのメンバーを集めてテーブルを作成
	 * @param ep リーダーのEntity
	 * @return
	 */
	public HashMap getPartyFromLeader(Entity ep)
	{
		//if(DQR.debug == 8)System.out.println("PT_DEBUG3:");
		HashMap dataMap = new HashMap();

        Iterator iterator = partySet.keySet().iterator();
        int dataNum = 0;

        while (iterator.hasNext())
        {
        	Object o = iterator.next();
        	Entity s = null;
        	Entity epx = (Entity)ep;

        	if(o instanceof String)
        	{
				MinecraftServer minecraftserver = MinecraftServer.getServer();
				s = minecraftserver.getConfigurationManager().func_152612_a((String)o);
        	}else if(o instanceof DqmPetBase)
        	{
        		s = (Entity)o;
        	}


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
            //if(partySet.get(s).getCommandSenderName().equalsIgnoreCase(epx.getCommandSenderName()))
            if(partySet.get(o).equalsIgnoreCase(epx.getCommandSenderName()))
            {
            	dataMap.put((Entity)s, (Entity)epx);
            }
        }

		return dataMap;
	}

	/**
	 * リーダー名からパーティを取得する
	 * @param ep リーダー名
	 * @return
	 */
	public HashMap<Entity, EntityPlayer> getPartyFromLeader2(String ep)
	{
		HashMap<Entity, EntityPlayer> dataMap = new HashMap();

        Iterator iterator = partySet.keySet().iterator();
        int dataNum = 0;

        while (iterator.hasNext())
        {
            Object s = iterator.next();
            MinecraftServer minecraftserver = MinecraftServer.getServer();
            if(partySet.get(s).equalsIgnoreCase(ep))
            {
            	EntityPlayer readerP = minecraftserver.getConfigurationManager().func_152612_a(ep);
            	if(s instanceof DqmPetBase)
            	{
            		dataMap.put((Entity)s, readerP);
            	}else if(s instanceof String)
            	{
    				dataMap.put(minecraftserver.getConfigurationManager().func_152612_a((String)s), readerP);
            	}
            }
        }

		return dataMap;
	}

	/**
	 * PTメンバーから、リーダー名を取得
	 * @param ep Player型 String型(プレイヤ名) Petインスタンスどれでも可
	 * @return
	 */
	public String getPartyLeaderFromMember(Object ep)
	{
		String ret = null;

		if(ep instanceof EntityPlayer)
		{
			if(partySet.containsKey(((EntityPlayer) ep).getCommandSenderName()))
			{
				ret = partySet.get(((EntityPlayer) ep).getCommandSenderName());
			}
		}else
		{


			/*
			if(DQR.debug == 9)
			{
				Object[] test = partySet.keySet().toArray();
				if(ep instanceof DqmPetBase)
				{
					DqmPetBase pet2 = (DqmPetBase)ep;
					System.out.println("PT_DEBUG2 : " + pet2.getCommandSenderName() + " / " + pet2.getUniqueID().toString());
				}

				for(int cnt = 0; cnt < test.length; cnt++)
				{
					System.out.println("PT_DEBUG3A : " + test[cnt].getClass().getName());
					if(test[cnt] instanceof DqmPetBase)
					{
						DqmPetBase pet1 = (DqmPetBase)test[cnt];
						System.out.println("PT_DEBUG3B : " + pet1.getCommandSenderName() + " / " + pet1.getUniqueID().toString());


					}

					String objx = partySet.get(test[cnt]);
					System.out.println("PT_DEBUG3C : " + objx);
				}
			}
			*/


			if(partySet.containsKey(ep))
			{
				ret = partySet.get(ep);
			}

			if(ret == null || ret.isEmpty())
			{
				DqmPetBase pet2 = null;
				if(ep instanceof DqmPetBase)
				{
					pet2 = (DqmPetBase)ep;
				}

				Object[] keySets = partySet.keySet().toArray();
				for(int cnt = 0; cnt < keySets.length; cnt++)
				{
					//System.out.println("PT_DEBUG3A : " + test[cnt].getClass().getName());
					if(keySets[cnt] instanceof DqmPetBase)
					{
						DqmPetBase pet1 = (DqmPetBase)keySets[cnt];
						//System.out.println("PT_DEBUG3B : " + pet1.getCommandSenderName() + " / " + pet1.getUniqueID().toString());
						if(pet1.getUniqueID().toString().equalsIgnoreCase(pet2.getUniqueID().toString()))
						{
							ret = partySet.get(keySets[cnt]);
							break;
						}
					}

					//String objx = partySet.get(test[cnt]);
					//System.out.println("PT_DEBUG3C : " + objx);
				}
			}
		}

		return ret;
	}

	/**
	 * 対象EntityがPTに所属してるか確認
	 * @param target
	 * @return
	 */
	public boolean hasParty(Entity target)
	{
		if(DQR.debug == 8)System.out.println("PT_DEBUG1-1:");
		Iterator iterator = partySet.keySet().iterator();
        Entity s = null;
        while (iterator.hasNext())
        {
        	Object obj = iterator.next();
        	if(obj instanceof DqmPetBase)
        	{
        		s = (DqmPetBase)obj;

        	}else if(obj instanceof String)
        	{
        		s = DQR.func.getPlayerFromName((String)obj);
        	}

        	//if(DQR.debug == 8 && s != null)System.out.println("PT_DEBUG1 : " +
        	if(s != null && s.getUniqueID().toString().equalsIgnoreCase(target.getUniqueID().toString()))
        	{
        		if(DQR.debug == 8)System.out.println("PT_DEBUG1-2:");
        		return true;
        	}
        	//Entity s = (Entity)iterator.next();
        	//System.out.println("CODE:" + s.getUniqueID().toString() + " / " + target.getUniqueID().toString());


        }

        if(DQR.debug == 8)System.out.println("PT_DEBUG1-3:");
        return false;
		//return partySet.containsKey(target);
	}

	/**
	 * パーティー全体にメッセージを送信する
	 * @param reader リーダーのEntity型
	 * @param keys 送信するメッセージ内容
	 * @param obj 送信メッセージのテキスト置き換え内容
	 */
	public void sendPartyMessage(Entity reader, String keys, Object[] obj)
	{
		this.sendPartyMessage(reader, keys, obj, true, true);
	}

	/**
	 * パーティー全体にメッセージを送信する
	 * @param reader リーダーのEntity型
	 * @param keys 送信するメッセージ内容
	 * @param obj 送信メッセージのテキスト置き換え内容
	 * @param addReader リーダーにも送信するかどうか
	 * @param doSound メッセージサウンド pi をいれるかどうか
	 */
	public void sendPartyMessage(Entity reader, String keys, Object[] obj, boolean addReader, boolean doSound)
	{
		Iterator iterator = partySet.keySet().iterator();
		MinecraftServer minecraftserver = MinecraftServer.getServer();

        while (iterator.hasNext())
        {
        	Object o = iterator.next();
        	//Entity s = (Entity)iterator.next();
        	//パーティーリーダー取得
          	Entity er = minecraftserver.getConfigurationManager().func_152612_a(partySet.get(o));

          	if(er != null && reader != null)
          	{
	        	 if(er.getCommandSenderName().equalsIgnoreCase(reader.getCommandSenderName()) && !addReader){
	        	 }else
	        	 {
	        		 if(o instanceof String)
	        		 {
	        			 //EntityPlayer er2 = minecraftserver.getConfigurationManager().func_152612_a(s.getCommandSenderName());
	        			 EntityPlayer er2 = minecraftserver.getConfigurationManager().func_152612_a((String)o);
	        			 if(er2 != null)
	        			 {
	        				 DQR.func.doAddChatMessageFix(er2, new ChatComponentTranslation(keys, obj));
	        				 if(doSound)
	        				 {
	        					 er2.worldObj.playSoundAtEntity(er2, "dqr:player.pi", 1.0F, 1.0F);
	        				 }
	        			 }
	        		 }
	        	 }
          	}
        }
	}

	/**
	 * 経験値共有率の変更
	 * @param ent パーティーリーダのEntityインスタンス
	 */
	public void doChangeShareRate(EntityPlayer ent)
	{
		this.doChangeShareRate(ent, -1);
	}

	/**
	 * 経験値共有率の変更
	 * @param ent パーティーリーダのEntityインスタンス
	 * @param setParam 何％にするか。-1の場合はconfigの次の値
	 */
	public void doChangeShareRate(EntityPlayer ent, int setParam)
	{
		int shareRate = expShareRate.get(ent.getCommandSenderName());

		int setVal = 0;
		if(setParam != -1)
		{
			setVal = setParam;
			expShareRate.put(ent.getCommandSenderName(), setVal);
		}else
		{
			if(DQR.conf.partyExpShareRate.length > 0)
			{
				if(shareRate == 0)
				{
					setVal = DQR.conf.partyExpShareRate[0];
					expShareRate.put(ent.getCommandSenderName(), DQR.conf.partyExpShareRate[0]);
				}else
				{

					for(int cnt = 0; cnt < DQR.conf.partyExpShareRate.length; cnt++)
					{
						if(DQR.conf.partyExpShareRate[cnt] == shareRate)
						{
							if(cnt == (DQR.conf.partyExpShareRate.length - 1))
							{
								setVal = 0;
							}else
							{
								setVal = DQR.conf.partyExpShareRate[cnt + 1];
							}
						}
					}

					expShareRate.put(ent.getCommandSenderName(), setVal);
				}
			}else
			{
				setVal = 0;
				expShareRate.put(ent.getCommandSenderName(), 0);
			}
		}

		if(!ent.worldObj.isRemote)
		{
			if(setVal == 0)
			{
				//ent.addChatMessage(new ChatComponentTranslation("msg.shinziru.shareRate.0.txt", new Object[]{}));
				//ent.worldObj.playSoundAtEntity(ent, "dqr:player.pi", 1.0F, 1.0F);
				this.sendPartyMessage(ent, "msg.shinziru.shareRate.0.txt", new Object[]{}, true, true);
			}else
			{
				//ent.addChatMessage(new ChatComponentTranslation("msg.shinziru.shareRate.1.txt", new Object[]{setVal}));
				//ent.worldObj.playSoundAtEntity(ent, "dqr:player.pi", 1.0F, 1.0F);
				this.sendPartyMessage(ent, "msg.shinziru.shareRate.1.txt", new Object[]{setVal}, true, true);
			}
		}
	}

	/**
	 * 経験値分配処理
	 * @param ent 敵を倒したEntity
	 * @param par1 獲得経験値
	 */
	public void doExpShare(Entity ent, int par1)
	{
		String readerName = this.getPartyLeaderFromMember(ent);

		if(DQR.debug == 9)System.out.println("PT_DEBUG5-1C : " + readerName);
		if(DQR.debug == 8)System.out.println("PT_DEBUG4-:");
		int memberCnt = partySet.size();
		float shareRate = 0.0f;
		if(readerName != null && expShareRate != null)
		{
			if(expShareRate.get(readerName) != null)
			{
				shareRate = (float)(expShareRate.get(readerName));
			}else
			{
				expShareRate.put(readerName, 0);
			}

		}

		if(DQR.debug == 8)System.out.println("PT_DEBUG4-: " + shareRate);

		if(((float)par1 * (shareRate / 100.0f)) / memberCnt < 1.0f || readerName == null)
		{
			if(DQR.debug == 8)System.out.println("PT_DEBUG4-1:");
			//獲得した経験値を分配して1未満になる場合は、倒したプレイヤの総取り
			if(ent instanceof EntityPlayer)
			{
				if(DQR.debug == 8)System.out.println("PT_DEBUG4-1A:");
				par1 = par1 + ExtendedPlayerProperties.get((EntityPlayer)ent).getJobExp(ExtendedPlayerProperties.get((EntityPlayer)ent).getJob());
	            ExtendedPlayerProperties.get((EntityPlayer)ent).setJobExp(ExtendedPlayerProperties.get((EntityPlayer)ent).getJob(), par1);

	            if(DQR.conf.cfg_NoThreadUse == 1)
	            {
	            	ThreadLvUp lvup = new ThreadLvUp((EntityPlayer)ent);
	            	lvup.start();
	            }else
	            {
	            	NoThreadProcess proc = new NoThreadProcess();
	            	proc.doLevelUp((EntityPlayer)ent);
	            }
			}else if(ent instanceof DqmPetBase)
			{
				if(DQR.debug == 8)System.out.println("PT_DEBUG4-1B:");
				DqmPetBase pet = (DqmPetBase)ent;
				/*
				 * 以前は、ペットが獲得した経験値のうち5%をPlayerへ付与してた名残
	            if(pet.getOwner() != null && pet.getOwner() instanceof EntityPlayer)
	            {
	            	EntityPlayer ep = (EntityPlayer)pet.getOwner();
	            	int tmpExpVal = 0;
	            	if(par1 * 0.05F < 1)
	            	{
	            		 tmpExpVal = 1 + ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());

	            	}else
	            	{
	            		tmpExpVal = (int)(par1 * 0.05F) + ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());
	            	}

            		ExtendedPlayerProperties.get(ep).setJobExp(ExtendedPlayerProperties.get(ep).getJob(), tmpExpVal);
    	            //ThreadLvUp lvup = new ThreadLvUp(ep);
    	            //lvup.start();
    	            if(DQR.conf.cfg_NoThreadUse == 1)
    	            {
    	            	ThreadLvUp lvup = new ThreadLvUp(ep);
    	            	lvup.start();
    	            }else
    	            {
    	            	NoThreadProcess proc = new NoThreadProcess();
    	            	proc.doLevelUp(ep);
    	            }
	            }
	            */

	            par1 = par1 + pet.getJobExp(pet.getJob());
	            //DQR.func.debugString("doExp5:" + getExpVal);
	            pet.setJobExp(pet.getJob(), par1);
	            //ThreadLvUpPet lvup = new ThreadLvUpPet(pet);
	            //lvup.start();

	            if(DQR.conf.cfg_NoThreadUse == 1)
	            {
		            ThreadLvUpPet lvup = new ThreadLvUpPet(pet);
		            lvup.start();
	            }else
	            {
	            	NoThreadProcess proc = new NoThreadProcess();
	            	proc.doLevelUpPet(pet);
	            }
			}
		}else
		{
			if(DQR.debug == 8)System.out.println("PT_DEBUG4-2:");
			//まずは倒した当事者への経験値付与
			if(ent instanceof EntityPlayer)
			{
				if(DQR.debug == 8)System.out.println("PT_DEBUG4-2A:");
				float baseExp = (par1  * ((100.0f - shareRate) / 100.0f)) + ExtendedPlayerProperties.get((EntityPlayer)ent).getJobExp(ExtendedPlayerProperties.get((EntityPlayer)ent).getJob());
	            ExtendedPlayerProperties.get((EntityPlayer)ent).setJobExp(ExtendedPlayerProperties.get((EntityPlayer)ent).getJob(), (int)baseExp);

	            if(DQR.conf.cfg_NoThreadUse == 1)
	            {
	            	ThreadLvUp lvup = new ThreadLvUp((EntityPlayer)ent);
	            	lvup.start();
	            }else
	            {
	            	NoThreadProcess proc = new NoThreadProcess();
	            	proc.doLevelUp((EntityPlayer)ent);
	            }
			}else if(ent instanceof DqmPetBase)
			{
				if(DQR.debug == 8)System.out.println("PT_DEBUG4-2B:");
				float baseExp = par1  * ((100.0f - shareRate) / 100.0f);
				DqmPetBase pet = (DqmPetBase)ent;
            	/*
	            if(pet.getOwner() != null && pet.getOwner() instanceof EntityPlayer)
	            {

	            	EntityPlayer ep = (EntityPlayer)pet.getOwner();
	            	int tmpExpVal = 0;
	            	if(baseExp * 0.05F < 1)
	            	{
	            		 tmpExpVal = 1 + ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());

	            	}else
	            	{
	            		tmpExpVal = (int)(baseExp * 0.05F) + ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());
	            	}

            		ExtendedPlayerProperties.get(ep).setJobExp(ExtendedPlayerProperties.get(ep).getJob(), tmpExpVal);

    	            //ThreadLvUp lvup = new ThreadLvUp(ep);
    	            //lvup.start();
    	            if(DQR.conf.cfg_NoThreadUse == 1)
    	            {
    	            	ThreadLvUp lvup = new ThreadLvUp(ep);
    	            	lvup.start();
    	            }else
    	            {
    	            	NoThreadProcess proc = new NoThreadProcess();
    	            	proc.doLevelUp(ep);
    	            }
	            }

            	*/
	            baseExp = baseExp + (float)pet.getJobExp(pet.getJob());
	            //DQR.func.debugString("doExp5:" + getExpVal);
	            pet.setJobExp(pet.getJob(), (int)baseExp);
	            //ThreadLvUpPet lvup = new ThreadLvUpPet(pet);
	            //lvup.start();

	            if(DQR.conf.cfg_NoThreadUse == 1)
	            {
		            ThreadLvUpPet lvup = new ThreadLvUpPet(pet);
		            lvup.start();
	            }else
	            {
	            	NoThreadProcess proc = new NoThreadProcess();
	            	proc.doLevelUpPet(pet);
	            }
			}

			//経験値分配処理コア
			HashMap partySetS = this.getPartyFromLeader2(readerName);
			int shareExp = (int)((float)par1 * (shareRate / 100.0f)) / memberCnt;

			Iterator iterator = partySetS.keySet().iterator();
			MinecraftServer minecraftserver = MinecraftServer.getServer();
			if(DQR.debug == 8)System.out.println("PT_DEBUG4-2C:");
			if(DQR.debug == 9)System.out.println("PT_DEBUG5-1A : " + shareExp + " / " + readerName);

	        while (iterator.hasNext())
	        {
	        	//Entity s = (Entity)iterator.next();
	        	Object o = iterator.next();

	        	//if(DQR.debug == 9)System.out.println("PT_DEBUG5-1B : " + o.getClass().getName());
	        	if(o instanceof EntityPlayer)
	        	{
	        		if(DQR.debug == 8)System.out.println("PT_DEBUG4-2D:");
	        		EntityPlayer tagE = (EntityPlayer)o;
					int expVal = shareExp + ExtendedPlayerProperties.get(tagE).getJobExp(ExtendedPlayerProperties.get(tagE).getJob());
		            ExtendedPlayerProperties.get(tagE).setJobExp(ExtendedPlayerProperties.get(tagE).getJob(), expVal);

		            if(DQR.conf.cfg_NoThreadUse == 1)
		            {
		            	if(DQR.debug == 9)System.out.println("PT_DEBUG4-1D:");
		            	ThreadLvUp lvup = new ThreadLvUp(tagE);
		            	lvup.start();
		            }else
		            {
		            	if(DQR.debug == 9)System.out.println("PT_DEBUG4-2D:");
		            	NoThreadProcess proc = new NoThreadProcess();
		            	proc.doLevelUp(tagE);
		            }
	        	}else if(o instanceof DqmPetBase)
	        	{
	        		if(DQR.debug == 8)System.out.println("PT_DEBUG4-2E:");
	        		DqmPetBase tagP = (DqmPetBase)o;
		            if(tagP.getOwner() != null && tagP.getOwner() instanceof EntityPlayer)
		            {
		            	EntityPlayer ep = (EntityPlayer)tagP.getOwner();
		            	int tmpExpVal = 0;
		            	if(shareExp * 0.05F < 1)
		            	{
		            		 tmpExpVal = 1 + ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());

		            	}else
		            	{
		            		tmpExpVal = (int)(shareExp * 0.05F) + ExtendedPlayerProperties.get(ep).getJobExp(ExtendedPlayerProperties.get(ep).getJob());
		            	}

	            		ExtendedPlayerProperties.get(ep).setJobExp(ExtendedPlayerProperties.get(ep).getJob(), tmpExpVal);
	    	            //ThreadLvUp lvup = new ThreadLvUp(ep);
	    	            //lvup.start();
	    	            if(DQR.conf.cfg_NoThreadUse == 1)
	    	            {
	    	            	ThreadLvUp lvup = new ThreadLvUp(ep);
	    	            	lvup.start();
	    	            }else
	    	            {
	    	            	NoThreadProcess proc = new NoThreadProcess();
	    	            	proc.doLevelUp(ep);
	    	            }
		            }

		            int expVal = shareExp + tagP.getJobExp(tagP.getJob());
		            //DQR.func.debugString("doExp5:" + getExpVal);
		            tagP.setJobExp(tagP.getJob(), expVal);
		            //ThreadLvUpPet lvup = new ThreadLvUpPet(pet);
		            //lvup.start();

		            if(DQR.conf.cfg_NoThreadUse == 1)
		            {
			            ThreadLvUpPet lvup = new ThreadLvUpPet(tagP);
			            lvup.start();
		            }else
		            {
		            	NoThreadProcess proc = new NoThreadProcess();
		            	proc.doLevelUpPet(tagP);
		            }
	        	}
	        }
		}
	}
}
