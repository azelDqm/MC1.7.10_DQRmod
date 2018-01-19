package dqr.entity.magicEntity;

import cpw.mods.fml.client.registry.RenderingRegistry;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityArrow;
import dqr.entity.magicEntity.magic.MagicEntityBagi;
import dqr.entity.magicEntity.magic.MagicEntityBasiRura;
import dqr.entity.magicEntity.magic.MagicEntityBegiragon;
import dqr.entity.magicEntity.magic.MagicEntityBegirama;
import dqr.entity.magicEntity.magic.MagicEntityBuff;
import dqr.entity.magicEntity.magic.MagicEntityDebuff;
import dqr.entity.magicEntity.magic.MagicEntityDoruma;
import dqr.entity.magicEntity.magic.MagicEntityGira;
import dqr.entity.magicEntity.magic.MagicEntityGiragureido;
import dqr.entity.magicEntity.magic.MagicEntityHoimi;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.entity.magicEntity.magic.MagicEntityHyadoB;
import dqr.entity.magicEntity.magic.MagicEntityIo;
import dqr.entity.magicEntity.magic.MagicEntityKiari;
import dqr.entity.magicEntity.magic.MagicEntityMahoimi;
import dqr.entity.magicEntity.magic.MagicEntityMera;
import dqr.entity.magicEntity.magic.MagicEntityMeraB;
import dqr.entity.magicEntity.magic.MagicEntityMeragaia;
import dqr.entity.magicEntity.magic.MagicEntityMeragaiaB;
import dqr.entity.magicEntity.magic.MagicEntityMerami;
import dqr.entity.magicEntity.magic.MagicEntityMeramiB;
import dqr.entity.magicEntity.magic.MagicEntityMerazoma;
import dqr.entity.magicEntity.magic.MagicEntityMerazomaB;
import dqr.entity.magicEntity.magic.MagicEntityRaidein;
import dqr.entity.magicEntity.magic.MagicEntityZaki;
import dqr.entity.magicEntity.magicDummy.MagicEntityBuffDummy;
import dqr.entity.magicEntity.magicDummy.MagicEntityHoimiDummy;
import dqr.entity.magicEntity.magicDummy.MagicEntityMahoimiDummy;
import dqr.entity.magicEntity.model.MagicEntityModel1;
import dqr.entity.magicEntity.model.MagicEntityModel2;
import dqr.entity.magicEntity.model.MagicEntityModel3;
import dqr.entity.magicEntity.render.MagicEntityRender;
import dqr.entity.magicEntity.render.MagicRenderArrow;
import dqr.entity.magicEntity.render.MagicRenderBagi;
import dqr.entity.magicEntity.render.MagicRenderBegiragon;
import dqr.entity.magicEntity.render.MagicRenderBegirama;
import dqr.entity.magicEntity.render.MagicRenderBuff;
import dqr.entity.magicEntity.render.MagicRenderBuffDummy;
import dqr.entity.magicEntity.render.MagicRenderDebuff;
import dqr.entity.magicEntity.render.MagicRenderDoruma;
import dqr.entity.magicEntity.render.MagicRenderGira;
import dqr.entity.magicEntity.render.MagicRenderGiragureido;
import dqr.entity.magicEntity.render.MagicRenderHoimi;
import dqr.entity.magicEntity.render.MagicRenderHyado;
import dqr.entity.magicEntity.render.MagicRenderHyadoB;
import dqr.entity.magicEntity.render.MagicRenderIo;
import dqr.entity.magicEntity.render.MagicRenderKiari;
import dqr.entity.magicEntity.render.MagicRenderMahoimi;
import dqr.entity.magicEntity.render.MagicRenderMera;
import dqr.entity.magicEntity.render.MagicRenderMeraB;
import dqr.entity.magicEntity.render.MagicRenderMeragaia;
import dqr.entity.magicEntity.render.MagicRenderMeragaiaB;
import dqr.entity.magicEntity.render.MagicRenderMerami;
import dqr.entity.magicEntity.render.MagicRenderMeramiB;
import dqr.entity.magicEntity.render.MagicRenderMerazoma;
import dqr.entity.magicEntity.render.MagicRenderMerazomaB;
import dqr.entity.magicEntity.render.MagicRenderRaidein;
import dqr.entity.magicEntity.render.MagicRenderZaki;
import dqr.entity.throwingEntity.render.ThrowingRenderBumeran;

public class MagicRenderingRegister {

	public MagicRenderingRegister()
	{
		//RenderingRegistry.registerEntityRenderingHandler(EntityVillagerHead.class, new EntityHeadRenderer(new VillagerHeadModel()));
		//MinecraftForgeClient.registerItemRenderer(DQR.magic.bulletSource, new ItemForceRenderer());

		RenderingRegistry.registerEntityRenderingHandler(MagicEntity.class, new MagicEntityRender(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMera.class, new MagicRenderMera(new MagicEntityModel2()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMerami.class, new MagicRenderMerami(new MagicEntityModel2()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMerazoma.class, new MagicRenderMerazoma(new MagicEntityModel3()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMeragaia.class, new MagicRenderMeragaia(new MagicEntityModel3()));

		RenderingRegistry.registerEntityRenderingHandler(MagicEntityGira.class, new MagicRenderGira(new MagicEntityModel2()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityBegirama.class, new MagicRenderBegirama(new MagicEntityModel2()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityBegiragon.class, new MagicRenderBegiragon(new MagicEntityModel3()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityGiragureido.class, new MagicRenderGiragureido(new MagicEntityModel3()));

		RenderingRegistry.registerEntityRenderingHandler(MagicEntityHyado.class, new MagicRenderHyado(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityIo.class, new MagicRenderIo(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityBagi.class, new MagicRenderBagi(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityHoimi.class, new MagicRenderHoimi(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityBuff.class, new MagicRenderBuff(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityDebuff.class, new MagicRenderDebuff(new MagicEntityModel1()));

		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMahoimi.class, new MagicRenderMahoimi(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityRaidein.class, new MagicRenderRaidein(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityZaki.class, new MagicRenderZaki(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityDoruma.class, new MagicRenderDoruma(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityKiari.class, new MagicRenderKiari(new MagicEntityModel1()));

		RenderingRegistry.registerEntityRenderingHandler(MagicEntityHoimiDummy.class, new MagicRenderHoimi(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMahoimiDummy.class, new MagicRenderMahoimi(new MagicEntityModel1()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityBuffDummy.class, new MagicRenderBuffDummy(new MagicEntityModel1()));



		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMeraB.class, new MagicRenderMeraB(new MagicEntityModel2()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMeramiB.class, new MagicRenderMeramiB(new MagicEntityModel2()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMerazomaB.class, new MagicRenderMerazomaB(new MagicEntityModel3()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityMeragaiaB.class, new MagicRenderMeragaiaB(new MagicEntityModel3()));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityHyadoB.class, new MagicRenderHyadoB(new MagicEntityModel1()));

		RenderingRegistry.registerEntityRenderingHandler(MagicEntityBasiRura.class, new ThrowingRenderBumeran(19));
		RenderingRegistry.registerEntityRenderingHandler(MagicEntityArrow.class, new MagicRenderArrow());
	}
}
