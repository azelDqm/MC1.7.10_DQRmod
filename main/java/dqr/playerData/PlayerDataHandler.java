package dqr.playerData;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import dqr.DQR;
import dqr.PacketHandler;

public class PlayerDataHandler {

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<>();
	private static final Map<String, NBTTagCompound> extendedEntityData2 = new HashMap<>();
	private static final Map<String, NBTTagCompound> extendedEntityData3 = new HashMap<>();
	private static final Map<String, NBTTagCompound> extendedEntityData4 = new HashMap<>();
	private static final Map<String, NBTTagCompound> extendedEntityData5 = new HashMap<>();
	private static final Map<String, NBTTagCompound> extendedEntityData6 = new HashMap<>();

	@SubscribeEvent
    /*IExtendedEntityPropertiesを登録する処理を呼び出す*/
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            ExtendedPlayerProperties.register((EntityPlayer)event.entity);
            ExtendedPlayerProperties2.register((EntityPlayer)event.entity);
            ExtendedPlayerProperties3.register((EntityPlayer)event.entity);
            ExtendedPlayerProperties4.register((EntityPlayer)event.entity);
            ExtendedPlayerProperties5.register((EntityPlayer)event.entity);
            ExtendedPlayerProperties6.register((EntityPlayer)event.entity);
        }
    }

    @SubscribeEvent
    /*死亡時に呼ばれるイベント。ここで、IExtendedEntityPropertiesを保存する処理を呼び出す*/
    public void onLivingDeathEvent(LivingDeathEvent event)  {
        if (event.entityLiving instanceof EntityPlayer && !event.entity.worldObj.isRemote) {
        	//System.out.println("DDDDDD");
            NBTTagCompound playerData = new NBTTagCompound();
            NBTTagCompound playerData2 = new NBTTagCompound();
            NBTTagCompound playerData3 = new NBTTagCompound();
            NBTTagCompound playerData4 = new NBTTagCompound();
            NBTTagCompound playerData5 = new NBTTagCompound();
            NBTTagCompound playerData6 = new NBTTagCompound();

	            (event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME)).saveNBTData(playerData);
	            (event.entity.getExtendedProperties(ExtendedPlayerProperties2.EXT_PROP_NAME)).saveNBTData(playerData2);
	            (event.entity.getExtendedProperties(ExtendedPlayerProperties3.EXT_PROP_NAME)).saveNBTData(playerData3);
	            (event.entity.getExtendedProperties(ExtendedPlayerProperties4.EXT_PROP_NAME)).saveNBTData(playerData4);
	            (event.entity.getExtendedProperties(ExtendedPlayerProperties5.EXT_PROP_NAME)).saveNBTData(playerData5);
	            (event.entity.getExtendedProperties(ExtendedPlayerProperties6.EXT_PROP_NAME)).saveNBTData(playerData6);

            storeEntityData(event.entity.getCommandSenderName(), playerData, playerData2, playerData3, playerData4, playerData5, playerData6);
        }
    }

    @SubscribeEvent
    /*ワールドに入った時に呼ばれるイベント。ここでIExtendedEntityPropertiesを読み込む処理を呼び出す*/
    public void onEntityJoinWorld(EntityJoinWorldEvent event)  {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
        	EntityPlayer ep = (EntityPlayer)event.entity;

           	ExtendedPlayerProperties.get(ep).setPlayerName(ep.getCommandSenderName());
        	ExtendedPlayerProperties.get(ep).setPlayerUUID(ep.getUniqueID().toString());
           	ExtendedPlayerProperties2.get(ep).setPlayerName(ep.getCommandSenderName());
        	ExtendedPlayerProperties2.get(ep).setPlayerUUID(ep.getUniqueID().toString());
           	ExtendedPlayerProperties3.get(ep).setPlayerName(ep.getCommandSenderName());
        	ExtendedPlayerProperties3.get(ep).setPlayerUUID(ep.getUniqueID().toString());
        	//ExtendedPlayerProperties3.get(ep).setPartyMemberData(null);
           	ExtendedPlayerProperties4.get(ep).setPlayerName(ep.getCommandSenderName());
        	ExtendedPlayerProperties4.get(ep).setPlayerUUID(ep.getUniqueID().toString());
        	ExtendedPlayerProperties4.get(ep).setPartyMemberData(null);
           	ExtendedPlayerProperties5.get(ep).setPlayerName(ep.getCommandSenderName());
        	ExtendedPlayerProperties5.get(ep).setPlayerUUID(ep.getUniqueID().toString());
           	ExtendedPlayerProperties6.get(ep).setPlayerName(ep.getCommandSenderName());
        	ExtendedPlayerProperties6.get(ep).setPlayerUUID(ep.getUniqueID().toString());


            if(DQR.conf.dqrHardcore != 1)
            {
	        	 if(!ep.isDead && ep.getHealth() > 0)
	        	{
	                    NBTTagCompound playerData = getEntityData(event.entity.getCommandSenderName());
	                    if (playerData != null) {
	                        (event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME)).loadNBTData(playerData);
	                    }
	                    NBTTagCompound playerData2 = getEntityData2(event.entity.getCommandSenderName());
	                    if (playerData != null) {
	                        (event.entity.getExtendedProperties(ExtendedPlayerProperties2.EXT_PROP_NAME)).loadNBTData(playerData2);
	                    }
	                    NBTTagCompound playerData3 = getEntityData3(event.entity.getCommandSenderName());
	                    if (playerData != null) {
	                        (event.entity.getExtendedProperties(ExtendedPlayerProperties3.EXT_PROP_NAME)).loadNBTData(playerData3);
	                    }
	                    NBTTagCompound playerData4 = getEntityData4(event.entity.getCommandSenderName());
	                    if (playerData != null) {
	                        (event.entity.getExtendedProperties(ExtendedPlayerProperties4.EXT_PROP_NAME)).loadNBTData(playerData4);
	                    }
	                    NBTTagCompound playerData5 = getEntityData5(event.entity.getCommandSenderName());
	                    if (playerData != null) {
	                        (event.entity.getExtendedProperties(ExtendedPlayerProperties5.EXT_PROP_NAME)).loadNBTData(playerData5);
	                    }
	                    NBTTagCompound playerData6 = getEntityData6(event.entity.getCommandSenderName());
	                    if (playerData != null) {
	                        (event.entity.getExtendedProperties(ExtendedPlayerProperties6.EXT_PROP_NAME)).loadNBTData(playerData6);
	                    }
	                    ((ExtendedPlayerProperties)(event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);
	                    ((ExtendedPlayerProperties2)(event.entity.getExtendedProperties(ExtendedPlayerProperties2.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);
	                    ((ExtendedPlayerProperties3)(event.entity.getExtendedProperties(ExtendedPlayerProperties3.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);
	                    ((ExtendedPlayerProperties4)(event.entity.getExtendedProperties(ExtendedPlayerProperties4.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);
	                    ((ExtendedPlayerProperties5)(event.entity.getExtendedProperties(ExtendedPlayerProperties5.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);
	                    ((ExtendedPlayerProperties6)(event.entity.getExtendedProperties(ExtendedPlayerProperties6.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);

	        	}else
	        	{
	        		//System.out.println("DDDD");
	                NBTTagCompound playerData = new NBTTagCompound();
	                NBTTagCompound playerData2 = new NBTTagCompound();
	                NBTTagCompound playerData3 = new NBTTagCompound();
	                NBTTagCompound playerData4 = new NBTTagCompound();
	                NBTTagCompound playerData5 = new NBTTagCompound();
	                NBTTagCompound playerData6 = new NBTTagCompound();
	                (event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME)).saveNBTData(playerData);
	                (event.entity.getExtendedProperties(ExtendedPlayerProperties2.EXT_PROP_NAME)).saveNBTData(playerData2);
	                (event.entity.getExtendedProperties(ExtendedPlayerProperties3.EXT_PROP_NAME)).saveNBTData(playerData3);
	                (event.entity.getExtendedProperties(ExtendedPlayerProperties4.EXT_PROP_NAME)).saveNBTData(playerData4);
	                (event.entity.getExtendedProperties(ExtendedPlayerProperties5.EXT_PROP_NAME)).saveNBTData(playerData5);
	                (event.entity.getExtendedProperties(ExtendedPlayerProperties6.EXT_PROP_NAME)).saveNBTData(playerData6);
	                storeEntityData(event.entity.getCommandSenderName(), playerData, playerData2, playerData3, playerData4, playerData5, playerData6);                //(event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME)).loadNBTData(playerData);
	                //((ExtendedPlayerProperties)(event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);
	        	}
            }else
            {
            	if(ep != null)
            	{
            		if(ExtendedPlayerProperties.get(ep).getHardcoreInfo() == 0)
            		{
            			//ep.addChatComponentMessage("TEST");
            			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.hardcore.messages.1.txt",new Object[] {}));
            			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.hardcore.messages.2.txt",new Object[] {}));
            			ExtendedPlayerProperties.get(ep).setHardcoreInfo(1);
            		}
            	}
            }

            if(DQR.conf.cfgEasyMode == 1 && DQR.easyMode == 1 && ExtendedPlayerProperties.get(ep).getEasyModeInfo() == 0)
            {
            	DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.easymode.messages.txt",new Object[] {}));
            	ExtendedPlayerProperties.get(ep).setEasyModeInfo(1);
            	ExtendedPlayerProperties.get(ep).setEasyModeInfo2(1);
            }

            if(DQR.conf.dqrHardcore != 0 || DQR.conf.dqrHardcorePet != 0 || DQR.conf.dqrHardcorePet2 != 0)
            {
   	        	if(!ep.isDead && ep.getHealth() > 0)
 	        	{
   	        		if(ExtendedPlayerProperties.get(ep).getBirthFlag() == 0)
   	        		{
   	        			DQR.func.debugString("Line1Line1Line1Line1Line1Line1Line1Line1Line1Line1Line1Line1");
   	        			ExtendedPlayerProperties.get(ep).setBirthFlag(1);
   	        			ExtendedPlayerProperties.get(ep).setBirthTime(ep.worldObj.getWorldTime());
   	        		}else
   	        		{
   	        			DQR.func.debugString("Line2Line2Line2Line2Line2Line2Line2Line2Line2Line2Line2Line2");
   	        		}
   	        		 //DQR.func.debugString("Line1Line1Line1Line1Line1Line1Line1Line1Line1Line1Line1Line1");
            	}
            }


        	//ExtendedPlayerProperties3.get(ep).setPartyMemberData(null);
        	//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3(ep), (EntityPlayerMP)ep);
        }
    }

    @SubscribeEvent
    /*リスポーン時に呼ばれるイベント。Serverとの同期を取る*/
    public void respawnEvent(PlayerEvent.PlayerRespawnEvent event) {
        if (!event.player.worldObj.isRemote) {
        	//System.out.println("BBBBBB");pnbb b
        	//DQR.calcPlayerStatus.calcHP(event.player);
        	//event.player.setHealth(event.player.getMaxHealth());
			ExtendedPlayerProperties.get(event.player).setMaxHP(DQR.calcPlayerStatus.calcHP(event.player));
			event.player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ExtendedPlayerProperties.get(event.player).getMaxHP());
			event.player.setHealth(event.player.getMaxHealth());

            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties2(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties4(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties5(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties6(event.player), (EntityPlayerMP)event.player);
        }
    }

    @SubscribeEvent
    /*Dimensionを移動した時に呼ばれるイベント。Serverとの同期を取る*/
    public void changedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.player.worldObj.isRemote) {
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties2(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties4(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties5(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties6(event.player), (EntityPlayerMP)event.player);
        }
    }

    /*PlayerのIExtendedEntityPropertiesをMapに保存*/
    public static void storeEntityData(String name, NBTTagCompound compound, NBTTagCompound compound2, NBTTagCompound compound3, NBTTagCompound compound4, NBTTagCompound compound5, NBTTagCompound compound6) {
    	//System.out.println("TEST1:" + extendedEntityData.size());
        extendedEntityData.put(name, compound);
        extendedEntityData2.put(name, compound2);
        extendedEntityData3.put(name, compound3);
        extendedEntityData4.put(name, compound4);
        extendedEntityData5.put(name, compound5);
        extendedEntityData6.put(name, compound6);
    }

    /*PlayerのIExtendedEntityPropertiesをMapから読み込み*/
    public static NBTTagCompound getEntityData(String name) {
    	//System.out.println("TEST3:" + extendedEntityData.size());
        return extendedEntityData.remove(name);
    	//return extendedEntityData.get(name);
    }
    public static NBTTagCompound getEntityData2(String name) {
    	//System.out.println("TEST3:" + extendedEntityData.size());
        return extendedEntityData2.remove(name);
    	//return extendedEntityData.get(name);
    }
    public static NBTTagCompound getEntityData3(String name) {
    	//System.out.println("TEST3:" + extendedEntityData.size());
        return extendedEntityData3.remove(name);
    	//return extendedEntityData.get(name);
    }

    public static NBTTagCompound getEntityData4(String name) {
    	//System.out.println("TEST3:" + extendedEntityData.size());
        return extendedEntityData4.remove(name);
    	//return extendedEntityData.get(name);
    }

    public static NBTTagCompound getEntityData5(String name) {
    	//System.out.println("TEST3:" + extendedEntityData.size());
        return extendedEntityData5.remove(name);
    	//return extendedEntityData.get(name);
    }

    public static NBTTagCompound getEntityData6(String name) {
    	//System.out.println("TEST3:" + extendedEntityData.size());
        return extendedEntityData6.remove(name);
    	//return extendedEntityData.get(name);
    }
}
