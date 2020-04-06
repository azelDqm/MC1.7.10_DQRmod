package dqr.entity.throwingEntity;

import net.minecraft.client.renderer.entity.RenderArrow;
import cpw.mods.fml.client.registry.RenderingRegistry;
import dqr.entity.throwingEntity.render.ThrowingRenderBumeran;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntityBakudanisi;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntityIshitubute;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntityNiku;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntitySeisui;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntitySinkanohiseki;
import dqr.entity.throwingEntity.throwItem.ThrowJSkillEntityIshinage;
import dqr.entity.throwingEntity.throwing.ThrowingEntityBumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityDqrArrow;
import dqr.entity.throwingEntity.throwing.ThrowingEntityHaipanova;
import dqr.entity.throwingEntity.throwing.ThrowingEntityHaipanova2;
import dqr.entity.throwingEntity.throwing.ThrowingEntityHonoonobumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityIgurufeza;
import dqr.entity.throwingEntity.throwing.ThrowingEntityKazenobumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityKoorinobumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityKuresentoejji;
import dqr.entity.throwingEntity.throwing.ThrowingEntityKurosubumeran;
import dqr.entity.throwingEntity.throwing.ThrowingEntityMeteoejji;
import dqr.entity.throwingEntity.throwing.ThrowingEntityYaibanobumeran;

public class ThrowingRenderingRegister {

	public ThrowingRenderingRegister()
	{
		//RenderingRegistry.registerEntityRenderingHandler(EntityVillagerHead.class, new EntityHeadRenderer(new VillagerHeadModel()));
		//MinecraftForgeClient.registerItemRenderer(DQR.magic.bulletSource, new ItemForceRenderer());

		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityBumeran.class, new ThrowingRenderBumeran(0));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityYaibanobumeran.class, new ThrowingRenderBumeran(1));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityKurosubumeran.class, new ThrowingRenderBumeran(2));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityIgurufeza.class, new ThrowingRenderBumeran(3));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityKazenobumeran.class, new ThrowingRenderBumeran(4));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityHonoonobumeran.class, new ThrowingRenderBumeran(5));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityKoorinobumeran.class, new ThrowingRenderBumeran(6));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityKuresentoejji.class, new ThrowingRenderBumeran(7));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityMeteoejji.class, new ThrowingRenderBumeran(8));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityHaipanova.class, new ThrowingRenderBumeran(9));
		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityHaipanova2.class, new ThrowingRenderBumeran(10));
		//RenderingRegistry.registerEntityRenderingHandler(MagicEntityMera.class, new MagicRenderMera(new MagicEntityModel2()));
		RenderingRegistry.registerEntityRenderingHandler(ThrowItemEntityBakudanisi.class, new ThrowingRenderBumeran(128));
		RenderingRegistry.registerEntityRenderingHandler(ThrowItemEntityNiku.class, new ThrowingRenderBumeran(134));
		RenderingRegistry.registerEntityRenderingHandler(ThrowItemEntitySeisui.class, new ThrowingRenderBumeran(131));
		RenderingRegistry.registerEntityRenderingHandler(ThrowItemEntitySinkanohiseki.class, new ThrowingRenderBumeran(135));
		RenderingRegistry.registerEntityRenderingHandler(ThrowItemEntityIshitubute.class, new ThrowingRenderBumeran(136));

		RenderingRegistry.registerEntityRenderingHandler(ThrowingEntityDqrArrow.class, new RenderArrow());
		RenderingRegistry.registerEntityRenderingHandler(ThrowJSkillEntityIshinage.class, new ThrowingRenderBumeran(136));
	}
}
