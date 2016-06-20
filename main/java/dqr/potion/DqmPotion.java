package dqr.potion;

import net.minecraft.entity.SharedMonsterAttributes;
import dqr.api.potion.DQPotionEtc;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;

public class DqmPotion {

	//現在使用している最大ポーションIDメモ用
	private int tempNum = 43;

	public DqmPotion(int idx)
	{
		DQPotionPlus.potionDokukesisou = new DqmPotionNoEffect(idx, false, 0x66FF33).setIconIndex2(5, 2).setIconIndex(7, 0).setPotionName("dqm.potion.dokukesisou");
		DQPotionPlus.potionTikaranotane = new DqmPotionNoEffect(idx + 1, false, 0xFF9933).setIconIndex2(0, 0).setIconIndex(4, 0).setPotionName("dqm.potion.tikaranotane");
		DQPotionPlus.potionMamorinotane = new DqmPotionNoEffect(idx + 2, false, 0x999999).setIconIndex2(1, 0).setIconIndex(6, 1).setPotionName("dqm.potion.mamorinotane");
		DQPotionPlus.potionSubayasanotane = new DqmPotionNoEffect(idx + 3, false, 0xFFFFFF).setIconIndex2(2, 0).setIconIndex(0, 0).setPotionName("dqm.potion.subayasanotane").func_111184_a(SharedMonsterAttributes.movementSpeed, "91AEAA56-376B-4498-935B-2F7F68070636", 0.20000000298023224D, 2);
		DQPotionPlus.potionIyasinomi = new DqmPotionNoEffect(idx + 4, false, 0xFFFF99).setIconIndex2(3, 0).setIconIndex(7, 0).setPotionName("dqm.potion.iyasinomi");
		DQPotionPlus.potionHonoonomi = new DqmPotionNoEffect(idx + 5, false, 0xFF0000).setIconIndex2(4, 0).setIconIndex(6, 1).setPotionName("dqm.potion.honoonomi");
		DQPotionPlus.potionMahounomi = new DqmPotionNoEffect(idx + 6, false, 0x6633CC).setIconIndex2(6, 3).setIconIndex(7, 0).setPotionName("dqm.potion.mahounomi");
		DQPotionPlus.potionMaryokunotane = new DqmPotionNoEffect(idx + 7, false, 0x6600CC).setIconIndex2(7, 3).setIconIndex(4, 0).setPotionName("dqm.potion.maryokunotane");
		DQPotionPlus.potionOugonnomi = new DqmPotionNoEffect(idx + 8, false, 0xFFD805).setIconIndex2(5, 0).setIconIndex(2, 2).setPotionName("dqm.potion.ougonnomi").func_111184_a(SharedMonsterAttributes.movementSpeed, "91AEAA56-376B-4498-935B-2F7F68070637", 0.20000000298023224D, 2);

		DQPotionMinus.potionPoison = new DqmPotionNoEffect(idx + 9, true, 0x66FF33).setIconIndex2(3, 2).setIconIndex(6, 0).setPotionName("dqm.potion.poison");
		DQPotionMinus.potionPoisonX = new DqmPotionNoEffect(idx + 10, true, 0x66FF33).setIconIndex2(3, 2).setIconIndex(6, 0).setPotionName("dqm.potion.poisonX");
		DQPotionMinus.debuffHeavyFire =  new DqmPotionNoEffect(idx + 37, true, 0xFFFFFF).setIconIndex2(7, 4).setIconIndex(1, 2).setPotionName("dqm.potion.heavyfire");

		DQPotionEtc.potionCooltimeNPC = new DqmPotionNoEffect(idx + 11, false, 0x000000).setIconIndex2(7, 1).setIconIndex(0, 1).setPotionName("dqm.potion.CooltimeNPC");
		DQPotionEtc.potionEnableNPC =  new DqmPotionNoEffect(idx + 12, false, 0xFFFFFF).setIconIndex2(7, 2).setIconIndex(0, 2).setPotionName("dqm.potion.EnableNPC");
		DQPotionPlus.skillTouzokuSpeed = new DqmPotionNoEffect(idx + 13, false, 0xFFFFFF).setIconIndex2(2, 0).setIconIndex(7, 1).setPotionName("dqm.jobSkill.touzokuSpeed").func_111184_a(SharedMonsterAttributes.movementSpeed, "91AEAA56-376B-4498-935B-2F7F68070639", 0.17000000298023224D, 2);

		DQPotionPlus.buffBaikiruto =  new DqmPotionNoEffect(idx + 20, false, 0xFFFFFF).setIconIndex2(6, 0).setIconIndex(4, 0).setPotionName("dqm.potion.baikiruto");
		DQPotionPlus.buffSukara =  new DqmPotionNoEffect(idx + 21, false, 0xFFFFFF).setIconIndex2(7, 0).setIconIndex(7, 1).setPotionName("dqm.potion.sukara");
		DQPotionPlus.buffBaha =  new DqmPotionNoEffect(idx + 22, false, 0xFFFFFF).setIconIndex2(3, 3).setIconIndex(7, 1).setPotionName("dqm.potion.baha");
		DQPotionPlus.buffPiora =  new DqmPotionNoEffect(idx + 23, false, 0xFFFFFF).setIconIndex2(4, 3).setIconIndex(0, 0).setPotionName("dqm.potion.piora").func_111184_a(SharedMonsterAttributes.movementSpeed, "91AEAA56-376B-4498-935B-2F7F68070638", 0.20000000298023224D, 2);;
		DQPotionPlus.buffMagicBaria =  new DqmPotionNoEffect(idx + 24, false, 0xFFFFFF).setIconIndex2(3, 6).setIconIndex(7, 1).setPotionName("dqm.potion.magicbaria");
		DQPotionPlus.buffMahokanta =  new DqmPotionNoEffect(idx + 25, false, 0xFFFFFF).setIconIndex2(2, 6).setIconIndex(7, 1).setPotionName("dqm.potion.mahokanta");

		DQPotionEtc.buffUminarinotue =  new DqmPotionNoEffect(idx + 26, false, 0xFFFFFF).setIconIndex2(5, 4).setIconIndex(7, 1).setPotionName("dqm.potion.uminarinotue");
		DQPotionEtc.buffCallMagma =  new DqmPotionNoEffect(idx + 27, false, 0xFFFFFF).setIconIndex2(6, 5).setIconIndex(7, 1).setPotionName("dqm.potion.callMagma");
		DQPotionEtc.buffMahoizun =  new DqmPotionNoEffect(idx + 36, false, 0xFFFFFF).setIconIndex2(6, 2).setIconIndex(2, 2).setPotionName("dqm.potion.mahoizun");

		DQPotionMinus.debuffBomie =  new DqmPotionNoEffect(idx + 28, true, 0xFFFFFF).setIconIndex2(6, 6).setIconIndex(1, 0).setPotionName("dqm.potion.bomie").func_111184_a(SharedMonsterAttributes.movementSpeed, "7107DE5E-7CE8-4030-940E-514C1F160891", -0.15000000596046448D, 2);;
		DQPotionMinus.debuffRariho =  new DqmPotionNoEffect(idx + 29, true, 0xFFFFFF).setIconIndex2(6, 6).setIconIndex(5, 1).setPotionName("dqm.potion.rariho");
		DQPotionMinus.debuffManusa =  new DqmPotionNoEffect(idx + 30, true, 0xFFFFFF).setIconIndex2(4, 14).setIconIndex(0, 2).setPotionName("dqm.potion.manusa");
		DQPotionMinus.debuffMahoton =  new DqmPotionNoEffect(idx + 31, true, 0xFFFFFF).setIconIndex2(7, 6).setIconIndex(0, 2).setPotionName("dqm.potion.mahoton");
		DQPotionMinus.debuffRukani =  new DqmPotionNoEffect(idx + 32, true, 0xFFFFFF).setIconIndex2(0, 6).setIconIndex(5, 0).setPotionName("dqm.potion.rukani");
		DQPotionMinus.debuffMedapani =  new DqmPotionNoEffect(idx + 33, true, 0xFFFFFF).setIconIndex2(1, 6).setIconIndex(0, 2).setPotionName("dqm.potion.medapani");
		DQPotionMinus.debuffHenatosu =  new DqmPotionNoEffect(idx + 34, true, 0xFFFFFF).setIconIndex2(4, 6).setIconIndex(5, 0).setPotionName("dqm.potion.henatosu");
		DQPotionMinus.debuffDivainsuperu = new DqmPotionNoEffect(idx + 35, true, 0xFFFFFF).setIconIndex2(5, 6).setIconIndex(1, 2).setPotionName("dqm.potion.divainsuperu");

		DQPotionMinus.debuffSuffocation = new DqmPotionNoEffect(idx + 38, true, 0xFFFFFF).setIconIndex2(7, 5).setIconIndex(0, 2).setPotionName("dqm.potion.suffocation");
		DQPotionEtc.buffMonsterNiku = new DqmPotionNoEffect(idx + 39, false, 0xFFAAAA).setIconIndex2(0, 11).setIconIndex(0, 7).setPotionName("dqm.potion.monsterNiku");
		DQPotionEtc.buffShinkanoHiseki = new DqmPotionNoEffect(idx + 40, false, 0x000000).setIconIndex2(1, 11).setIconIndex(1, 7).setPotionName("dqm.potion.shinkanoHiseki");

		DQPotionMinus.debuffStop = new DqmPotionNoEffect(idx + 41, true, 0x000000).setIconIndex2(7, 1).setIconIndex(3, 2).setPotionName("dqm.potion.stop");
		DQPotionPlus.buffKaihiUp = new DqmPotionNoEffect(idx + 42, false, 0x000000).setIconIndex2(3, 1).setIconIndex(0, 0).setPotionName("dqm.potion.kaihiUp");
		DQPotionPlus.buffBreathReflect = new DqmPotionNoEffect(idx + 43, false, 0x000000).setIconIndex2(2, 6).setIconIndex(7, 1).setPotionName("dqm.potion.kaihiUp");
	}
}
