package dqr.api.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;

public class DQPotionEtc {

	public static Potion potionCooltimeNPC;
	public static Potion potionEnableNPC;

	public static Potion buffUminarinotue;
	public static Potion buffCallMagma;
	public static Potion buffMahoizun;

	public static Potion buffMonsterNiku;
	public static Potion buffShinkanoHiseki;

	public boolean hasEffectDQPotionEtc(EntityLivingBase evb)
	{
		if(evb.getActivePotionEffect(this.potionCooltimeNPC) != null && evb.getActivePotionEffect(this.potionCooltimeNPC).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.potionEnableNPC) != null && evb.getActivePotionEffect(this.potionEnableNPC).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(this.buffUminarinotue) != null && evb.getActivePotionEffect(this.buffUminarinotue).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.buffCallMagma) != null && evb.getActivePotionEffect(this.buffCallMagma).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.buffMahoizun) != null && evb.getActivePotionEffect(this.buffMahoizun).getDuration() > 0)
		{
			return true;
		}


		if(evb.getActivePotionEffect(this.buffMonsterNiku) != null && evb.getActivePotionEffect(this.buffMonsterNiku).getDuration() > 0)
		{
			return true;
		}
		if(evb.getActivePotionEffect(this.buffShinkanoHiseki) != null && evb.getActivePotionEffect(this.buffShinkanoHiseki).getDuration() > 0)
		{
			return true;
		}

		return false;
	}
}
