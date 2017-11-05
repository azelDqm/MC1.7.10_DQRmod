package dqr.functions;

import net.minecraft.entity.EntityLiving;
import net.minecraftforge.common.MinecraftForge;
import dqr.api.event.DqrCanDespawnEvent;

public class FuncEntityLivingExtension {

	public FuncEntityLivingExtension(){}

	public int hookCanDespawn(EntityLiving par1)
	{
		//System.out.println("ClassName : " + par1.getClass().getName());

		DqrCanDespawnEvent event = new DqrCanDespawnEvent(par1);
		event.setCanceled(false);
		MinecraftForge.EVENT_BUS.post(event);

		//System.out.println("TEST");

		if(event.isCanceled())
		{
			return -1;
		}else
		{
			return event.getResultCode();
		}

	}
}
