package dqr.entity.throwingEntity;

import cpw.mods.fml.common.registry.EntityRegistry;
import dqr.DQR;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntityBakudanisi;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntityNiku;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntitySeisui;
import dqr.entity.throwingEntity.throwItem.ThrowItemEntitySinkanohiseki;
import dqr.entity.throwingEntity.throwing.ThrowingEntityBumeran;
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

public class ThrowingRegister {

	private int idxID = DQR.conf.ThrowingIDidx;

	public ThrowingRegister()
	{
		//EntityRegistry.registerModEntity(EntityVillagerHead.class, "villagerCannon.villagerHead", 9990, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityBumeran.class, "dqr.ThrowingEntityBumeran", idxID , DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityYaibanobumeran.class, "dqr.ThrowingEntityYaibanobumeran", idxID + 1, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityKurosubumeran.class, "dqr.ThrowingEntityKurosubumeran", idxID + 2, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityIgurufeza.class, "dqr.ThrowingEntityIgurufeza", idxID + 3, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityKazenobumeran.class, "dqr.ThrowingEntityKazenobumeran", idxID + 4, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityHonoonobumeran.class, "dqr.ThrowingEntityHonoonobumeran", idxID + 5, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityKoorinobumeran.class, "dqr.ThrowingEntityKoorinobumeran", idxID + 6, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityKuresentoejji.class, "dqr.ThrowingEntityKuresentoejji", idxID + 7, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityMeteoejji.class, "dqr.ThrowingEntityMeteoejji", idxID + 8, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityHaipanova.class, "dqr.ThrowingEntityHaipanova", idxID + 9, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowingEntityHaipanova2.class, "dqr.ThrowingEntityHaipanova2", idxID + 10, DQR.instance, 128, 5, true);
		//EntityRegistry.registerModEntity(MagicEntityMera.class, "dqm.MagicEntityMera", idxID + 1, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowItemEntityBakudanisi.class, "dqr.ThrowItemEntityBakudanisi", idxID + 11, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowItemEntityNiku.class, "dqr.ThrowItemEntityNiku", idxID + 12, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowItemEntitySeisui.class, "dqr.ThrowItemEntitySeisui", idxID + 13, DQR.instance, 128, 5, true);
		EntityRegistry.registerModEntity(ThrowItemEntitySinkanohiseki.class, "dqr.ThrowItemEntitySinkanohiseki", idxID + 14, DQR.instance, 128, 5, true);
<<<<<<< HEAD
		EntityRegistry.registerModEntity(ThrowItemEntityIshitubute.class, "dqr.ThrowItemEntityIshitubute", idxID + 15, DQR.instance, 128, 5, true);

		EntityRegistry.registerModEntity(ThrowItemEntityIshitubute.class, "dqr.DqrArrow", idxID + 16, DQR.instance, 128, 5, true);
=======
>>>>>>> parent of 2aede75... ver0.8.7.8
	}
}
