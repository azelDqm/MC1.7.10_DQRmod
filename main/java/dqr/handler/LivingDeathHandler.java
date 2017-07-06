package dqr.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.gui.subEquip.InventorySubEquip;


public class LivingDeathHandler {

	@SubscribeEvent(priority=EventPriority.HIGHEST)
	public void onLivingDeathEventEvent(LivingDeathEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer && DQR.addons.tconstIsEnable == 0)
		{
			EntityPlayer ep = (EntityPlayer)event.entityLiving;
	        if (!ep.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory")) {
	            //this.getCustomPlayerData(event.entityPlayer).getEquipmentStats().inventory.dropAllItems(event.entityPlayer);
	        	InventorySubEquip inventory = new InventorySubEquip(ep);
	        	inventory.openInventory();
	        	inventory.dropAllItems(ep);
	        	inventory.markDirty();
	        	inventory.closeInventory();
	        }
	    }
	}
	/*
	@SubscribeEvent
	public void onLivingDeathEventEvent(LivingDeathEvent event)
	{
		//System.out.println("TEST1");
		if(event.entityLiving instanceof DqmPetBase)
		{
			//System.out.println("TEST2");
			event.setCanceled(true);
		}
	}
	*/
}
