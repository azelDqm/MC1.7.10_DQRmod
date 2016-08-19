package dqr.enums;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.entity.magicEntity.magic.MagicEntityHyadoB;
import dqr.entity.magicEntity.magic.MagicEntityMera;
import dqr.entity.magicEntity.magic.MagicEntityMeraB;
import dqr.entity.magicEntity.magic.MagicEntityMeragaia;
import dqr.entity.magicEntity.magic.MagicEntityMeragaiaB;
import dqr.entity.magicEntity.magic.MagicEntityMerami;
import dqr.entity.magicEntity.magic.MagicEntityMeramiB;
import dqr.entity.magicEntity.magic.MagicEntityMerazoma;
import dqr.entity.magicEntity.magic.MagicEntityMerazomaB;

public class DqmDamageSource{

	public static DamageSource Critical = (new DamageSource("Critical")).setDamageBypassesArmor();
	public static DamageSource DqmPoison = new DamageSource("Poison");
	public static DamageSource DqmPoisonX = new DamageSource("PoisonX");
	public static DamageSource DqmHeavyFire = new DamageSource("HeavyFire");
	public static DamageSource DqmSuffocation = new DamageSource("Suffocation");
	public static DamageSource DqmPlayerSkill = new EntityDamageSource("PlayerSkill", null);
	public static DamageSource DqmPlayerSkillCri = new EntityDamageSource("PlayerSkillCri", null);
	public static DamageSource DqmPlayerSkillDeath = new EntityDamageSource("PlayerSkillDeath", null);
	public static DamageSource DqmDamageBlock = new DamageSource("DqmDamageBlock");
	public static DamageSource DqmPlayerSpecial = new EntityDamageSource("PlayerSpecial", null);
	public static DamageSource DqmPlayerSpecialCri = new EntityDamageSource("PlayerSpecialCri", null);
	public static DamageSource DqmPlayerSpecialDeath = new EntityDamageSource("PlayerSpecialDeath", null);

	public DqmDamageSource() {
	}

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

	public DamageSource getPlayerSpecialDamage(Entity ent)
	{
		return new EntityDamageSource("PlayerSpecial" , ent);
	}

	public DamageSource getPlayerSpecialDamageCri(Entity ent)
	{
		return new EntityDamageSource("PlayerSpecialCri" , ent);
	}

	public DamageSource getPlayerSpecialDamageDeath(Entity ent)
	{
		return new EntityDamageSource("PlayerSpecialDeath" , ent);
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


	public boolean isDqmSpecialDamage(DamageSource par1)
	{
		if(par1.getDamageType().equalsIgnoreCase(this.DqmPlayerSpecial.getDamageType()) ||
		   par1.getDamageType().equalsIgnoreCase(this.DqmPlayerSpecialCri.getDamageType()) ||
		   par1.getDamageType().equalsIgnoreCase(this.DqmPlayerSpecialDeath.getDamageType()))
		{
			return true;
		}

		return false;
	}

	public boolean isDqmBreathDamage(DamageSource par1)
	{
		if(par1.getEntity() instanceof MagicEntityHyadoB ||
		   par1.getEntity() instanceof MagicEntityMeraB ||
		   par1.getEntity() instanceof MagicEntityMeramiB ||
		   par1.getEntity() instanceof MagicEntityMerazomaB ||
		   par1.getEntity() instanceof MagicEntityMeragaiaB ||
		   par1.getSourceOfDamage() instanceof MagicEntityHyadoB ||
		   par1.getSourceOfDamage() instanceof MagicEntityMeraB ||
		   par1.getSourceOfDamage() instanceof MagicEntityMeramiB ||
		   par1.getSourceOfDamage() instanceof MagicEntityMerazomaB ||
		   par1.getSourceOfDamage() instanceof MagicEntityMeragaiaB)
		{
			return true;
		}

		return false;
	}

	public boolean isDqmIceDamage(DamageSource par1)
	{
		if(par1.getEntity() instanceof MagicEntityMeraB ||
		   par1.getEntity() instanceof MagicEntityMeramiB ||
		   par1.getEntity() instanceof MagicEntityMerazomaB ||
		   par1.getEntity() instanceof MagicEntityMeragaiaB ||
		   par1.getSourceOfDamage() instanceof MagicEntityMeraB ||
		   par1.getSourceOfDamage() instanceof MagicEntityMeramiB ||
		   par1.getSourceOfDamage() instanceof MagicEntityMerazomaB ||
		   par1.getSourceOfDamage() instanceof MagicEntityMeragaiaB ||
		   par1.getEntity() instanceof MagicEntityMera ||
		   par1.getEntity() instanceof MagicEntityMerami ||
		   par1.getEntity() instanceof MagicEntityMerazoma ||
		   par1.getEntity() instanceof MagicEntityMeragaia ||
		   par1.getSourceOfDamage() instanceof MagicEntityMera ||
		   par1.getSourceOfDamage() instanceof MagicEntityMerami ||
		   par1.getSourceOfDamage() instanceof MagicEntityMerazoma ||
		   par1.getSourceOfDamage() instanceof MagicEntityMeragaia)
				{
					return true;
				}

		return false;
	}

	public boolean isDqmFireDamage(DamageSource par1)
	{
		if(par1.getEntity() instanceof MagicEntityHyadoB ||
		   par1.getEntity() instanceof MagicEntityHyado ||
		   par1.getSourceOfDamage() instanceof MagicEntityHyadoB ||
		   par1.getSourceOfDamage() instanceof MagicEntityHyado)
		{
			return true;
		}

		return false;
	}

	public boolean isDqmMagicDamage(DamageSource par1)
	{
		if(par1.getEntity() instanceof MagicEntity ||
		   par1.getSourceOfDamage() instanceof MagicEntity)
		{
			return !this.isDqmBreathDamage(par1);
		}

		return false;
	}
}
