package dqr.handler;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.potion.DQPotionMinus;
import dqr.playerData.ExtendedPlayerProperties;

public class RarihoEventHandler {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoLivingSetAttackTarget(LivingSetAttackTargetEvent event) {
		/*
		if(DQR.func.isBind(event.entityLiving))
		{
			if(event.target != null)
			{
				event.
				//System.out.println("TAG1:" + event.target.getCommandSenderName());
			}
			//System.out.println("TAG2:" + event.entity.getCommandSenderName());
			//System.out.println("TAG2:" + event.entityLiving.getCommandSenderName());
			//event.setCanceled(true);
		}
		*/
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoLivingUpdate(LivingUpdateEvent event) {
    	if(event.entityLiving instanceof EntityPlayer)
    	{
    		PotionEffect pe;
    		EntityPlayer ep = (EntityPlayer)event.entityLiving;

    		if(DQR.func.isBind(ep))
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
	    					//if(!ep.onGround && ep.worldObj.isAirBlock((int)locOld[0], (int)locOld[1] - 1, (int)locOld[2]))
	    					boolean groundFlg = false;

	    					for(int cntX = -1; cntX <= 1; cntX++)
	    					{
	    						for(int cntZ = -1; cntZ <= 1; cntZ++)
	    						{
	    							if(!(ep.worldObj.isAirBlock((int)locOld[0]+cntX, (int)locOld[1], (int)locOld[2]+cntZ)))
	    							{
	    								groundFlg = true;
	    							}
	    						}
	    					}
	    					if(!ep.onGround && !groundFlg)
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
    	/*
    	else if(event.entityLiving instanceof EntityLivingBase && !(event.entityLiving instanceof DqmMobBase))
    	{

    		if(DQR.func.isBind(event.entityLiving))
    		{
    			event.entityLiving.moveForward = 0;
    			event.entityLiving.moveStrafing = 0;
    			//event.entityLiving.randomYawVelocity = 0;
    			event.entityLiving.setJumping(false);

    			//event.setCanceled(true);
    		}

    	}
    	*/
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void checkRarihoCancel(LivingHurtEvent event)
    {
		PotionEffect pe = null;

		pe = event.entityLiving.getActivePotionEffect(DQPotionMinus.debuffRariho);
		if(pe != null && pe.getDuration() > DQR.conf.rarihoFreeDuration)
		{
			if(event.source.getEntity() != null)
			{
				Random rand = new Random();
				if(rand.nextInt(3) == 0)
				{
					event.entityLiving.removePotionEffect(DQPotionMinus.debuffRariho.id);
				}
			}
		}
    }

	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoAttackUpdate(AttackEntityEvent event)
	{
		EntityPlayer ep = event.entityPlayer;

		if(DQR.func.isBind(ep))
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
    		if(DQR.func.isBind(ep))
			{
				event.setCanceled(true);
			}
    	}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoPlayerInteract(PlayerInteractEvent event)
	{
		EntityPlayer ep = event.entityPlayer;
		if(DQR.func.isBind(ep))
		{
			event.setCanceled(true);
		}
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onRarihoLivingJumpEvent(LivingEvent.LivingJumpEvent event) {
    	if(event.entityLiving instanceof EntityPlayer)
    	{
    		EntityPlayer ep = (EntityPlayer)event.entityLiving;

    		if(DQR.func.isBind(ep))
    		{
    		}
    	}
	}
}
