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

	@SubscribeEvent
    /*IExtendedEntityPropertiesを登録する処理を呼び出す*/
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer) {
            ExtendedPlayerProperties.register((EntityPlayer)event.entity);
            ExtendedPlayerProperties2.register((EntityPlayer)event.entity);
            ExtendedPlayerProperties3.register((EntityPlayer)event.entity);
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

	            (event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME)).saveNBTData(playerData);
	            (event.entity.getExtendedProperties(ExtendedPlayerProperties2.EXT_PROP_NAME)).saveNBTData(playerData2);
	            (event.entity.getExtendedProperties(ExtendedPlayerProperties3.EXT_PROP_NAME)).saveNBTData(playerData3);

            storeEntityData(event.entity.getCommandSenderName(), playerData, playerData2, playerData3);
        }
    }

    @SubscribeEvent
    /*ワールドに入った時に呼ばれるイベント。ここでIExtendedEntityPropertiesを読み込む処理を呼び出す*/
    public void onEntityJoinWorld(EntityJoinWorldEvent event)  {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
        	EntityPlayer ep = (EntityPlayer)event.entity;

           	ExtendedPlayerProperties.get(ep).setPlayerName(ep.getCommandSenderName());
        	ExtendedPlayerProperties.get(ep).setPlayerUUID(ep.getUniqueID().toString());
        	ExtendedPlayerProperties2.get(ep).setPlayerName(ep.getDisplayName());
        	ExtendedPlayerProperties3.get(ep).setPartyMemberData(null);
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
	                    ((ExtendedPlayerProperties)(event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);
	                    ((ExtendedPlayerProperties2)(event.entity.getExtendedProperties(ExtendedPlayerProperties2.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);
	                    ((ExtendedPlayerProperties3)(event.entity.getExtendedProperties(ExtendedPlayerProperties3.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);

	        	}else
	        	{
	        		//System.out.println("DDDD");
	                NBTTagCompound playerData = new NBTTagCompound();
	                NBTTagCompound playerData2 = new NBTTagCompound();
	                NBTTagCompound playerData3 = new NBTTagCompound();
	                (event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME)).saveNBTData(playerData);
	                (event.entity.getExtendedProperties(ExtendedPlayerProperties2.EXT_PROP_NAME)).saveNBTData(playerData2);
	                (event.entity.getExtendedProperties(ExtendedPlayerProperties3.EXT_PROP_NAME)).saveNBTData(playerData3);
	                storeEntityData(event.entity.getCommandSenderName(), playerData, playerData2, playerData3);                //(event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME)).loadNBTData(playerData);
	                //((ExtendedPlayerProperties)(event.entity.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME))).loadProxyData((EntityPlayer)event.entity);
	        	}
            }else
            {
            	if(ep != null)
            	{
            		if(ExtendedPlayerProperties.get(ep).getHardcoreInfo() == 0)
            		{
            			//ep.addChatComponentMessage("TEST");
            			ep.addChatMessage(new ChatComponentTranslation("msg.hardcore.messages.1.txt",new Object[] {}));
            			ep.addChatMessage(new ChatComponentTranslation("msg.hardcore.messages.2.txt",new Object[] {}));
            			ExtendedPlayerProperties.get(ep).setHardcoreInfo(1);
            		}
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
        }
    }

    @SubscribeEvent
    /*Dimensionを移動した時に呼ばれるイベント。Serverとの同期を取る*/
    public void changedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        if (!event.player.worldObj.isRemote) {
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties2(event.player), (EntityPlayerMP)event.player);
            PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3(event.player), (EntityPlayerMP)event.player);
        }
    }

    /*PlayerのIExtendedEntityPropertiesをMapに保存*/
    public static void storeEntityData(String name, NBTTagCompound compound, NBTTagCompound compound2, NBTTagCompound compound3) {
    	//System.out.println("TEST1:" + extendedEntityData.size());
        extendedEntityData.put(name, compound);
        extendedEntityData2.put(name, compound2);
        extendedEntityData3.put(name, compound3);
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

}
