package dqr.api.event;

import net.minecraft.client.renderer.EntityRenderer;
import cpw.mods.fml.common.eventhandler.Event;

public class DqmEntityRenderEvent extends Event{
	public final EntityRenderer entityRender;
	public final float renderPartialTicks;

	public DqmEntityRenderEvent (EntityRenderer entityRender, float renderPartialTicks)
	{
		this.entityRender = entityRender;
		this.renderPartialTicks = renderPartialTicks;
	}
}
