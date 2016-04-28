package dqr.enums;

import net.minecraft.util.DamageSource;

public class DqmDamageSource{

	public static DamageSource Critical = (new DamageSource("Critical")).setDamageBypassesArmor();
	public static DamageSource DqmPoison = new DamageSource("Poison");
	public static DamageSource DqmPoisonX = new DamageSource("PoisonX");
	public static DamageSource DqmHeavyFire = new DamageSource("HeavyFire");
	public static DamageSource DqmSuffocation = new DamageSource("Suffocation");
<<<<<<< HEAD
	public static DamageSource DqmPlayerSkill = new EntityDamageSource("PlayerSkill", null);
	public static DamageSource DqmPlayerSkillCri = new EntityDamageSource("PlayerSkillCri", null);
	public static DamageSource DqmPlayerSkillDeath = new EntityDamageSource("PlayerSkillDeath", null);
	public static DamageSource DqmDamageBlock = new DamageSource("DqmDamageBlock");
=======
>>>>>>> parent of 2aede75... ver0.8.7.8

	public DqmDamageSource() {
	}

<<<<<<< HEAD
	public DamageSource getPlayerSkillDamage(Entity ent)
	{
		return new EntityDamageSource("PlayerSkill" , ent);
	}

	public DamageSource getPlayerSkillDamageCri(Entity ent)
	{
		return new EntityDamageSource("PlayerSkillCri" , ent);
	}

	public DamageSource getPlayerSkillDamageDeath(Entity ent)
	{
		return new EntityDamageSource("PlayerSkillDeath" , ent);
	}

	public boolean isDqmSkillDamage(DamageSource par1)
	{
		if(par1.getDamageType().equalsIgnoreCase(this.DqmPlayerSkill.getDamageType()) ||
		   par1.getDamageType().equalsIgnoreCase(this.DqmPlayerSkillCri.getDamageType()) ||
		   par1.getDamageType().equalsIgnoreCase(this.DqmPlayerSkillDeath.getDamageType()))
		{
			return true;
		}

		return false;
	}
=======
>>>>>>> parent of 2aede75... ver0.8.7.8
}
