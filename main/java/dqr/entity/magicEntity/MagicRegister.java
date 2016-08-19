package dqr.entity.magicEntity;

import cpw.mods.fml.common.registry.EntityRegistry;
import dqr.DQR;
import dqr.entity.magicEntity.magic.MagicEntity;
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

public class MagicRegister {

	private int idxID = DQR.conf.MagicIDidx;

	public MagicRegister()
	{
		//EntityRegistry.registerModEntity(EntityVillagerHead.class, "villagerCannon.villagerHead", 9990, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntity.class, "villagerCannon.villagerHead2", idxID - 1, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityMera.class, "dqm.MagicEntityMera", idxID, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityMerami.class, "dqm.MagicEntityMerami", idxID + 1, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityMerazoma.class, "dqm.MagicEntityMerazoma", idxID + 2, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityMeragaia.class, "dqm.MagicEntityMeragaia", idxID + 3, DQR.instance, 128, 5, true);

		EntityRegistry.registerModEntity(MagicEntityGira.class, "dqm.MagicEntityGira", idxID + 4, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityBegirama.class, "dqm.MagicEntityBegirama", idxID + 5, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityBegiragon.class, "dqm.MagicEntityBegiragon", idxID + 6, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityGiragureido.class, "dqm.MagicEntityGiragureido", idxID + 7, DQR.instance, 128, 5, true);

		EntityRegistry.registerModEntity(MagicEntityHyado.class, "dqm.MagicEntityHyado", idxID + 8, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityIo.class, "dqm.MagicEntityIo", idxID + 9, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityBagi.class, "dqm.MagicEntityBagi", idxID + 10, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityHoimi.class, "dqm.MagicEntityHoimi", idxID + 11, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityBuff.class, "dqm.MagicEntityBuff", idxID + 12, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityDebuff.class, "dqm.MagicEntityDebuff", idxID + 13, DQR.instance, 128, 5, true);

		EntityRegistry.registerModEntity(MagicEntityMahoimi.class, "dqm.MagicEntityMahoimi", idxID + 14, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityRaidein.class, "dqm.MagicEntityRaidein", idxID + 15, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityZaki.class, "dqm.MagicEntityZaki", idxID + 16, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityDoruma.class, "dqm.MagicEntityDoruma", idxID + 17, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityKiari.class, "dqm.MagicEntityKiari", idxID + 18, DQR.instance, 128, 5, true);

		EntityRegistry.registerModEntity(MagicEntityBuffDummy.class, "dqm.MagicEntityBuffDummy", idxID + 19, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityHoimiDummy.class, "dqm.MagicEntityHoimiDummy", idxID + 20, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityMahoimiDummy.class, "dqm.MagicEntityMahoimiDummy", idxID + 21, DQR.instance, 128, 5, true);


		EntityRegistry.registerModEntity(MagicEntityMeraB.class, "dqm.MagicEntityMeraB", idxID + 22, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityMeramiB.class, "dqm.MagicEntityMeramiB", idxID + 23, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityMerazomaB.class, "dqm.MagicEntityMerazomaB", idxID + 24, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityMeragaiaB.class, "dqm.MagicEntityMeragaiaB", idxID + 25, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(MagicEntityHyadoB.class, "dqm.MagicEntityHyadoB", idxID + 26, DQR.instance, 128, 5, true);

		EntityRegistry.registerModEntity(MagicEntityBasiRura.class, "dqm.MagicEntityBasiRura", idxID + 27, DQR.instance, 128, 5, true);

	}
}
