package dqr.entity.npcEntity;

import cpw.mods.fml.common.registry.EntityRegistry;
import dqr.DQR;
import dqr.entity.npcEntity.npc.DqmEntityNPCBank;
import dqr.entity.npcEntity.npc.DqmEntityNPCBukiya;
import dqr.entity.npcEntity.npc.DqmEntityNPCKaitoriya;
import dqr.entity.npcEntity.npc.DqmEntityNPCMedalking;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan2;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan3;
import dqr.entity.npcEntity.npc.DqmEntityNPCSyuuri;


public class NPCRegister {

	private int idxID = DQR.conf.NPCIDidx;

	public NPCRegister()
	{
		//EntityRegistry.registerModEntity(EntityMeleeSkeleton.class, "MeleeSkeleton", 0, DQR.instance, 250, 1, false);
		//EntityRegistry.registerModEntity(DqmEntitySura.class, "Suraimu", idxID + 8000, DQR.instance, 250, 1, false);
		//EntityRegistry.registerModEntity(DqmEntityKingsura.class, "Kingsura", idxID + 8001, DQR.instance, 250, 1, false);


		EntityRegistry.registerModEntity(DqmEntityNPCSyuuri.class, "NPCSyuuri", idxID + 0, DQR.instance, 250, 1, false);
		EntityRegistry.registerModEntity(DqmEntityNPCBukiya.class, "NPCBukiya", idxID + 1, DQR.instance, 250, 1, false);
		EntityRegistry.registerModEntity(DqmEntityNPCKaitoriya.class, "NPCKaitoriya", idxID + 2, DQR.instance, 250, 1, false);
		EntityRegistry.registerModEntity(DqmEntityNPCBank.class, "NPCBank", idxID + 3, DQR.instance, 250, 1, false);

		EntityRegistry.registerModEntity(DqmEntityNPCSinkan.class, "NPCSinkan", idxID + 4, DQR.instance, 250, 1, false);
		EntityRegistry.registerModEntity(DqmEntityNPCSinkan2.class, "NPCSinkan2", idxID + 5, DQR.instance, 250, 1, false);
		EntityRegistry.registerModEntity(DqmEntityNPCSinkan3.class, "NPCSinkan3", idxID + 6, DQR.instance, 250, 1, false);
		EntityRegistry.registerModEntity(DqmEntityNPCMedalking.class, "NPCMedalking", idxID + 7, DQR.instance, 250, 1, false);

	}
}
