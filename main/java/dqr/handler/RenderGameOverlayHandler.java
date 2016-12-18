package dqr.handler;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;

public class RenderGameOverlayHandler {

	@SubscribeEvent
	public void onRenderGameOverlayEvent(RenderGameOverlayEvent event)
	{
		if(event.type == ElementType.HEALTH)
		{
			if(DQR.conf.GuiVanillaHUDVis_Health == 0)
			{
				event.setCanceled(true);
			}
		}

		if(event.type == ElementType.ARMOR)
		{
			if(DQR.conf.GuiVanillaHUDVis_Armor == 0)
			{
				event.setCanceled(true);
			}
		}

	}
}
