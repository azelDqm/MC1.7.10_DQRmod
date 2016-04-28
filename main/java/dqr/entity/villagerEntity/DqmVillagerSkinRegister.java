package dqr.entity.villagerEntity;

import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.common.registry.VillagerRegistry;
import dqr.DQR;

public class DqmVillagerSkinRegister {

	public DqmVillagerSkinRegister()
	{
		VillagerRegistry.instance().registerVillagerSkin(DQR.villager.vlgBukiyaID, new ResourceLocation("dqr:textures/entity/villager/VillagerBukiya.png"));
	}
}
