package dqr.api.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class DQPotionFunc {


	public boolean hasEffectDQPotionEtc(EntityLivingBase evb)
	{
		if(evb.getActivePotionEffect(DQPotionEtc.potionCooltimeNPC) != null && evb.getActivePotionEffect(DQPotionEtc.potionCooltimeNPC).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionEtc.potionEnableNPC) != null && evb.getActivePotionEffect(DQPotionEtc.potionEnableNPC).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(DQPotionEtc.buffUminarinotue) != null && evb.getActivePotionEffect(DQPotionEtc.buffUminarinotue).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionEtc.buffCallMagma) != null && evb.getActivePotionEffect(DQPotionEtc.buffCallMagma).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionEtc.buffMahoizun) != null && evb.getActivePotionEffect(DQPotionEtc.buffMahoizun).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(DQPotionEtc.buffMonsterNiku) != null && evb.getActivePotionEffect(DQPotionEtc.buffMonsterNiku).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionEtc.buffShinkanoHiseki) != null && evb.getActivePotionEffect(DQPotionEtc.buffShinkanoHiseki).getDuration() > 0)
		{
			return true;
		}

		return false;
	}



	public boolean isDQPotionMinus(Potion par1)
	{
		if(par1 == DQPotionMinus. debuffBomie ||
			par1 == DQPotionMinus. debuffRariho ||
			par1 == DQPotionMinus. debuffManusa ||
			par1 == DQPotionMinus. debuffMahoton ||
			par1 == DQPotionMinus. debuffRukani ||
			par1 == DQPotionMinus. debuffMedapani ||
			par1 == DQPotionMinus. debuffHenatosu ||
			par1 == DQPotionMinus. debuffDivainsuperu ||
			par1 == DQPotionMinus. debuffHeavyFire ||
			par1 == DQPotionMinus. debuffSuffocation ||
			par1 == DQPotionMinus. debuffStop)
		{
			return true;
		}

		return false;
	}

	public boolean isPotionMinus(Potion par1)
	{
		if(par1 == Potion.moveSlowdown ||
			par1 == Potion.digSlowdown ||
			par1 == Potion.harm ||
			par1 == Potion.confusion ||
			par1 == Potion.blindness ||
			par1 == Potion.hunger ||
			par1 == Potion.weakness ||
			par1 == Potion.poison ||
			par1 == Potion.wither)
		{
			return true;
		}

		return false;
	}

	public boolean hasEffectDQPotionMinus(EntityLivingBase evb)
	{
		if(evb.getActivePotionEffect(DQPotionMinus.potionPoison) != null && evb.getActivePotionEffect(DQPotionMinus.potionPoison).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionMinus.potionPoisonX) != null && evb.getActivePotionEffect(DQPotionMinus.potionPoisonX).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(DQPotionMinus.debuffBomie) != null && evb.getActivePotionEffect(DQPotionMinus.debuffBomie).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionMinus.debuffRariho) != null && evb.getActivePotionEffect(DQPotionMinus.debuffRariho).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionMinus.debuffManusa) != null && evb.getActivePotionEffect(DQPotionMinus.debuffManusa).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionMinus.debuffMahoton) != null && evb.getActivePotionEffect(DQPotionMinus.debuffMahoton).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionMinus.debuffRukani) != null && evb.getActivePotionEffect(DQPotionMinus.debuffRukani).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionMinus.debuffMedapani) != null && evb.getActivePotionEffect(DQPotionMinus.debuffMedapani).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionMinus.debuffHenatosu) != null && evb.getActivePotionEffect(DQPotionMinus.debuffHenatosu).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionMinus.debuffDivainsuperu) != null && evb.getActivePotionEffect(DQPotionMinus.debuffDivainsuperu).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(DQPotionMinus.debuffHeavyFire) != null && evb.getActivePotionEffect(DQPotionMinus.debuffHeavyFire).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionMinus.debuffSuffocation) != null && evb.getActivePotionEffect(DQPotionMinus.debuffSuffocation).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(DQPotionMinus.debuffStop) != null && evb.getActivePotionEffect(DQPotionMinus.debuffStop).getDuration() > 0)
		{
			return true;
		}

		return false;
	}


	public boolean hasEffectDQPotionPlus(EntityLivingBase evb)
	{
		if(evb.getActivePotionEffect(DQPotionPlus.potionDokukesisou) != null && evb.getActivePotionEffect(DQPotionPlus.potionDokukesisou).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.potionTikaranotane) != null && evb.getActivePotionEffect(DQPotionPlus.potionTikaranotane).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.potionMamorinotane) != null && evb.getActivePotionEffect(DQPotionPlus.potionMamorinotane).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.potionSubayasanotane) != null && evb.getActivePotionEffect(DQPotionPlus.potionSubayasanotane).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.potionIyasinomi) != null && evb.getActivePotionEffect(DQPotionPlus.potionIyasinomi).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.potionHonoonomi) != null && evb.getActivePotionEffect(DQPotionPlus.potionHonoonomi).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.potionMahounomi) != null && evb.getActivePotionEffect(DQPotionPlus.potionMahounomi).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.potionMaryokunotane) != null && evb.getActivePotionEffect(DQPotionPlus.potionMaryokunotane).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.potionOugonnomi) != null && evb.getActivePotionEffect(DQPotionPlus.potionOugonnomi).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(DQPotionPlus.skillTouzokuSpeed) != null && evb.getActivePotionEffect(DQPotionPlus.skillTouzokuSpeed).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(DQPotionPlus.buffBaikiruto) != null && evb.getActivePotionEffect(DQPotionPlus.buffBaikiruto).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.buffSukara) != null && evb.getActivePotionEffect(DQPotionPlus.buffSukara).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.buffBaha) != null && evb.getActivePotionEffect(DQPotionPlus.buffBaha).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.buffPiora) != null && evb.getActivePotionEffect(DQPotionPlus.buffPiora).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.buffMagicBaria) != null && evb.getActivePotionEffect(DQPotionPlus.buffMagicBaria).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.buffMahokanta) != null && evb.getActivePotionEffect(DQPotionPlus.buffMahokanta).getDuration() > 0)
		{
			return true;
		}

		if(evb.getActivePotionEffect(DQPotionPlus.buffKaihiUp) != null && evb.getActivePotionEffect(DQPotionPlus.buffKaihiUp).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.buffBreathReflect) != null && evb.getActivePotionEffect(DQPotionPlus.buffBreathReflect).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(DQPotionPlus.buffHoshihuru) != null && evb.getActivePotionEffect(DQPotionPlus.buffHoshihuru).getDuration() > 0)
		{
			return true;
		}

		if(evb.getActivePotionEffect(DQPotionPlus.buffHPRegeneration) != null && evb.getActivePotionEffect(DQPotionPlus.buffHPRegeneration).getDuration() > 0)
		{
			return true;
		}

		if(evb.getActivePotionEffect(DQPotionPlus.buffMPRegeneration) != null && evb.getActivePotionEffect(DQPotionPlus.buffMPRegeneration).getDuration() > 0)
		{
			return true;
		}
		return false;
	}
}
