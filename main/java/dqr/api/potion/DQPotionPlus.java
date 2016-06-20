package dqr.api.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class DQPotionPlus {

	public static Potion potionDokukesisou;
	public static Potion potionTikaranotane;
	public static Potion potionMamorinotane;
	public static Potion potionSubayasanotane;
	public static Potion potionIyasinomi;
	public static Potion potionHonoonomi;
	public static Potion potionMahounomi;
	public static Potion potionMaryokunotane;
	public static Potion potionOugonnomi;

	public static Potion skillTouzokuSpeed;

	public static Potion buffBaikiruto;
	public static Potion buffSukara;
	public static Potion buffBaha;
	public static Potion buffPiora;
	public static Potion buffMagicBaria;
	public static Potion buffMahokanta;

	public static Potion buffKaihiUp;
	public static Potion buffBreathReflect;

	public boolean hasEffectDQPotionPlus(EntityLivingBase evb)
	{
		if(evb.getActivePotionEffect(this.potionDokukesisou) != null && evb.getActivePotionEffect(this.potionDokukesisou).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionTikaranotane) != null && evb.getActivePotionEffect(this.potionTikaranotane).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionMamorinotane) != null && evb.getActivePotionEffect(this.potionMamorinotane).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionSubayasanotane) != null && evb.getActivePotionEffect(this.potionSubayasanotane).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionIyasinomi) != null && evb.getActivePotionEffect(this.potionIyasinomi).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionHonoonomi) != null && evb.getActivePotionEffect(this.potionHonoonomi).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionMahounomi) != null && evb.getActivePotionEffect(this.potionMahounomi).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionMaryokunotane) != null && evb.getActivePotionEffect(this.potionMaryokunotane).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionOugonnomi) != null && evb.getActivePotionEffect(this.potionOugonnomi).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(this.skillTouzokuSpeed) != null && evb.getActivePotionEffect(this.skillTouzokuSpeed).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(this.buffBaikiruto) != null && evb.getActivePotionEffect(this.buffBaikiruto).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.buffSukara) != null && evb.getActivePotionEffect(this.buffSukara).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.buffBaha) != null && evb.getActivePotionEffect(this.buffBaha).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.buffPiora) != null && evb.getActivePotionEffect(this.buffPiora).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.buffMagicBaria) != null && evb.getActivePotionEffect(this.buffMagicBaria).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.buffMahokanta) != null && evb.getActivePotionEffect(this.buffMahokanta).getDuration() > 0)
		{
			return true;
		}

		if(evb.getActivePotionEffect(this.buffKaihiUp) != null && evb.getActivePotionEffect(this.buffKaihiUp).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.buffBreathReflect) != null && evb.getActivePotionEffect(this.buffBreathReflect).getDuration() > 0)
		{
			return true;
		}
		return false;
	}
}
