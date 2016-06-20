package dqr.entity.npcEntity;

import cpw.mods.fml.client.registry.RenderingRegistry;
import dqr.entity.npcEntity.npc.DqmEntityNPCBank;
import dqr.entity.npcEntity.npc.DqmEntityNPCBukiya;
import dqr.entity.npcEntity.npc.DqmEntityNPCGuntai;
import dqr.entity.npcEntity.npc.DqmEntityNPCKaitoriya;
import dqr.entity.npcEntity.npc.DqmEntityNPCMedalking;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan2;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan3;
import dqr.entity.npcEntity.npc.DqmEntityNPCSyuuri;
import dqr.entity.npcEntity.render.DqmRenderNPC;
import dqr.entity.npcEntity.render.DqmRenderNPCBiped;


public class NPCRenderingRegister {

	public NPCRenderingRegister()
	{
		//RenderingRegistry.registerEntityRenderingHandler(EntityMeleeSkeleton.class, new RenderMeleeSkeleton());
		RenderingRegistry.registerEntityRenderingHandler(DqmEntityNPCSyuuri.class, new DqmRenderNPC());
		RenderingRegistry.registerEntityRenderingHandler(DqmEntityNPCBank.class, new DqmRenderNPC());
		RenderingRegistry.registerEntityRenderingHandler(DqmEntityNPCKaitoriya.class, new DqmRenderNPC());
		RenderingRegistry.registerEntityRenderingHandler(DqmEntityNPCBukiya.class, new DqmRenderNPC());

		RenderingRegistry.registerEntityRenderingHandler(DqmEntityNPCSinkan.class, new DqmRenderNPCBiped());
		RenderingRegistry.registerEntityRenderingHandler(DqmEntityNPCSinkan2.class, new DqmRenderNPCBiped());
		RenderingRegistry.registerEntityRenderingHandler(DqmEntityNPCSinkan3.class, new DqmRenderNPCBiped());
		RenderingRegistry.registerEntityRenderingHandler(DqmEntityNPCMedalking.class, new DqmRenderNPCBiped());

		RenderingRegistry.registerEntityRenderingHandler(DqmEntityNPCGuntai.class, new DqmRenderNPC());

	}
}
