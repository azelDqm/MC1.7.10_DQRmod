package dqr.handler;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class RenderGameOverlayHandler {

	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent event)
	{
		if(event.type == ElementType.HEALTH)
		{
			event.setCanceled(true);
		}

		if(event.type == ElementType.ARMOR)
		{
			event.setCanceled(true);
		}

	}
}
