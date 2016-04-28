package dqr.functions;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraftforge.common.MinecraftForge;
import dqr.api.event.DqmEntityRenderEvent;

public class FuncEntityRenderExtension {

	private Minecraft mc;

	public FuncEntityRenderExtension(Minecraft mc)
	{
		this.mc = mc;

	}

	public void hookOrientCamera(EntityRenderer entityRender, float par1)
	{
		DqmEntityRenderEvent event = new DqmEntityRenderEvent(entityRender, par1);
		MinecraftForge.EVENT_BUS.post(event);
	}
}
