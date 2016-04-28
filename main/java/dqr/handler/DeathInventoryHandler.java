package dqr.handler;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class DeathInventoryHandler {

	//public InventoryPlayer inventory = new InventoryPlayer(this);
	private static final Map<String, InventoryPlayer> keepInveontoryMap = new HashMap<>();

    @SubscribeEvent
    //死亡時に呼ばれるイベント。ここで、IExtendedEntityPropertiesを保存する処理を呼び出す
    public void onLivingDeathEvent(LivingDeathEvent event)
    {
    	if(event.entityLiving instanceof EntityPlayer)
    	{
        	System.out.println("debug1");

    		EntityPlayer ep = (EntityPlayer)event.entityLiving;
    		InventoryPlayer inv = new InventoryPlayer(ep);

    		for(int cnt = 0; cnt < ep.inventory.getSizeInventory(); cnt++)
    		{
    			//対象アイテムが矢だった場合のみ死亡時消滅＆リスポ時復帰するパティーン
    			//ここのアイテムを変えるなり、戻り値booleanのメソッド作って対象アイテム指定すると良いかも。
    			if(ep.inventory.getStackInSlot(cnt) != null &&
    			   ep.inventory.getStackInSlot(cnt).getItem() != null &&
    			   ep.inventory.getStackInSlot(cnt).getItem() == Items.arrow)
    			{
    				inv.setInventorySlotContents(cnt, ep.inventory.getStackInSlot(cnt));
    				ep.inventory.setInventorySlotContents(cnt, null);
    			}
    		}

    		System.out.println("debug2");
    		keepInveontoryMap.put(ep.getCommandSenderName(), inv);
    	}
    }

    @SubscribeEvent
    //リスポーン時に呼ばれるイベント。Serverとの同期を取る
    public void respawnEvent(PlayerEvent.PlayerRespawnEvent event)
    {
    	//System.out.println("debug3");
    	if(keepInveontoryMap.containsKey(event.player.getCommandSenderName()))
    	{
    		System.out.println("debug4");
    		InventoryPlayer invRev = keepInveontoryMap.get(event.player.getCommandSenderName());

    		for(int cnt = 0; cnt < invRev.getSizeInventory(); cnt++)
    		{
    			event.player.inventory.setInventorySlotContents(cnt, invRev.getStackInSlot(cnt));
    			//inv.setInventorySlotContents(cnt, ep.inventory.getStackInSlot(cnt));
    		}
    	}

    }

    @SubscribeEvent
    /*ワールドに入った時に呼ばれるイベント。ここでIExtendedEntityPropertiesを読み込む処理を呼び出す*/
    public void onEntityJoinWorld(EntityJoinWorldEvent event)  {
        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
        	//System.out.println("debug5");
        	EntityPlayer ep = (EntityPlayer)event.entity;
        	if(keepInveontoryMap.containsKey(ep.getCommandSenderName()))
        	{
        		System.out.println("debug4");
        		InventoryPlayer invRev = keepInveontoryMap.get(ep.getCommandSenderName());

        		for(int cnt = 0; cnt < invRev.getSizeInventory(); cnt++)
        		{
        			ep.inventory.setInventorySlotContents(cnt, invRev.getStackInSlot(cnt));
        			//inv.setInventorySlotContents(cnt, ep.inventory.getStackInSlot(cnt));
        		}
        	}
        }
    }
}
