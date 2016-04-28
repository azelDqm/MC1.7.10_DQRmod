package dqr.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.api.potion.DQPotionMinus;
import dqr.playerData.ExtendedPlayerProperties;

public class RarihoEventHandler {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoLivingUpdate(LivingUpdateEvent event) {
    	if(event.entityLiving instanceof EntityPlayer)
    	{
    		PotionEffect pe;
    		EntityPlayer ep = (EntityPlayer)event.entityLiving;

    		pe = ep.getActivePotionEffect(DQPotionMinus.debuffRariho);
    		if(pe != null)
    		{
    			double[] loc = new double[4];
    			double[] locOld;
    			loc[0] = ep.posX;
    			loc[1] = ep.posY;
    			loc[2] = ep.posZ;


    			locOld = ExtendedPlayerProperties.get(ep).getRarihoLoc();
    			if(locOld[3] == 1)
    			{
	    			for(int cnt = 0; cnt < 3; cnt++)
	    			{
	    				if(loc[cnt] != locOld[cnt])
	    				{
	    					//ep.fallDistance
	    					//ep.setPositionAndUpdate(locOld[0], locOld[1], locOld[2]);
	    					if(!ep.onGround && ep.worldObj.isAirBlock((int)locOld[0], (int)locOld[1] - 1, (int)locOld[2]))
	    					{
	    						ep.setPositionAndUpdate(locOld[0], MathHelper.floor_double(ep.posY - 0.2000000029802322D - ep.yOffset), locOld[2]);
	    					}else
	    					{
	    						ep.setPositionAndUpdate(locOld[0], locOld[1], locOld[2]);
	    					}
	    					return;
	    				}
	    			}
    			}

    		}
    	}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoAttackUpdate(AttackEntityEvent event)
	{
		EntityPlayer ep = event.entityPlayer;
    	PotionEffect pe;

		pe = ep.getActivePotionEffect(DQPotionMinus.debuffRariho);
		if(pe != null)
		{
			event.setCanceled(true);
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoEntityInteract(EntityInteractEvent event)
	{
    	if(event.entityLiving instanceof EntityPlayer)
    	{
    		EntityPlayer ep = event.entityPlayer;
    		PotionEffect pe;

			pe = ep.getActivePotionEffect(DQPotionMinus.debuffRariho);
			if(pe != null)
			{
				event.setCanceled(true);
			}
    	}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoPlayerInteract(PlayerInteractEvent event)
	{
		EntityPlayer ep = event.entityPlayer;
    	PotionEffect pe;

		pe = ep.getActivePotionEffect(DQPotionMinus.debuffRariho);
		if(pe != null)
		{
			event.setCanceled(true);
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoLivingJumpEvent(LivingEvent.LivingJumpEvent event) {
    	if(event.entityLiving instanceof EntityPlayer)
    	{
    		PotionEffect pe;
    		EntityPlayer ep = (EntityPlayer)event.entityLiving;

    		pe = ep.getActivePotionEffect(DQPotionMinus.debuffRariho);
    		if(pe != null)
    		{
    		}
    	}
	}
}
