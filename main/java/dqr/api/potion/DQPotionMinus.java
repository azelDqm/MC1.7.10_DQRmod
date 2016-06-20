package dqr.api.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class DQPotionMinus {
	public static Potion potionPoison;
	public static Potion potionPoisonX;

	public static Potion debuffBomie;
	public static Potion debuffRariho;
	public static Potion debuffManusa;
	public static Potion debuffMahoton;
	public static Potion debuffRukani;
	public static Potion debuffMedapani;
	public static Potion debuffHenatosu;
	public static Potion debuffDivainsuperu;

	public static Potion debuffHeavyFire;
	public static Potion debuffSuffocation;

	public static Potion debuffStop;

	public boolean hasEffectDQPotionMinus(EntityLivingBase evb)
	{
		if(evb.getActivePotionEffect(this.potionPoison) != null && evb.getActivePotionEffect(this.potionPoison).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionPoisonX) != null && evb.getActivePotionEffect(this.potionPoisonX).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(this.debuffBomie) != null && evb.getActivePotionEffect(this.debuffBomie).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.debuffRariho) != null && evb.getActivePotionEffect(this.debuffRariho).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.debuffManusa) != null && evb.getActivePotionEffect(this.debuffManusa).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.debuffMahoton) != null && evb.getActivePotionEffect(this.debuffMahoton).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.debuffRukani) != null && evb.getActivePotionEffect(this.debuffRukani).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.debuffMedapani) != null && evb.getActivePotionEffect(this.debuffMedapani).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.debuffHenatosu) != null && evb.getActivePotionEffect(this.debuffHenatosu).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.debuffDivainsuperu) != null && evb.getActivePotionEffect(this.debuffDivainsuperu).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(this.debuffHeavyFire) != null && evb.getActivePotionEffect(this.debuffHeavyFire).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.debuffSuffocation) != null && evb.getActivePotionEffect(this.debuffSuffocation).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(this.debuffStop) != null && evb.getActivePotionEffect(this.debuffStop).getDuration() > 0)
		{
			return true;
		}

		return false;
	}
}
