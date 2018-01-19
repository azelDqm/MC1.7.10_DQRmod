package dqr.entity.petEntity.ai;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import dqr.DQR;
import dqr.api.enums.EnumDqmMobAI;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.petEntity.DqmPetBase;

public class EntityPetAINearestTargetHeavyFire extends EntityAITarget
{
    private final Class targetClass;
    private final int targetChance;
    /** Instance of EntityAINearestAttackableTargetSorter. */
    private final EntityPetAINearestTargetHeavyFire.Sorter theNearestAttackableTargetSorter;
    /**
     * This filter is applied to the Entity search.  Only matching entities will be targetted.  (null -> no
     * restrictions)
     */
    private final IEntitySelector targetEntitySelector;
    private EntityLivingBase targetEntity;
    private static final String __OBFID = "CL_00001620";
    private DqmPetBase attacker;

    public EntityPetAINearestTargetHeavyFire(DqmPetBase p_i1663_1_, Class p_i1663_2_, int p_i1663_3_, boolean p_i1663_4_)
    {
        this(p_i1663_1_, p_i1663_2_, p_i1663_3_, p_i1663_4_, false);
    }

    public EntityPetAINearestTargetHeavyFire(DqmPetBase p_i1664_1_, Class p_i1664_2_, int p_i1664_3_, boolean p_i1664_4_, boolean p_i1664_5_)
    {
        this(p_i1664_1_, p_i1664_2_, p_i1664_3_, p_i1664_4_, p_i1664_5_, (IEntitySelector)null);
    }

    public EntityPetAINearestTargetHeavyFire(DqmPetBase p_i1665_1_, Class p_i1665_2_, int p_i1665_3_, boolean p_i1665_4_, boolean p_i1665_5_, final IEntitySelector p_i1665_6_)
    {
        super(p_i1665_1_, p_i1665_4_, p_i1665_5_);
        this.attacker = p_i1665_1_;
        this.targetClass = p_i1665_2_;
        this.targetChance = p_i1665_3_;
        this.theNearestAttackableTargetSorter = new EntityPetAINearestTargetHeavyFire.Sorter(p_i1665_1_);
        this.setMutexBits(1);
        this.targetEntitySelector = new IEntitySelector()
        {
            private static final String __OBFID = "CL_00001621";
            /**
             * Return whether the specified entity is applicable to this filter.
             */
            public boolean isEntityApplicable(Entity p_82704_1_)
            {
                return !(p_82704_1_ instanceof EntityLivingBase) ? false : (p_i1665_6_ != null && !p_i1665_6_.isEntityApplicable(p_82704_1_) ? false : EntityPetAINearestTargetHeavyFire.this.isSuitableTarget((EntityLivingBase)p_82704_1_, false));
            }
        };
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0)
        {
            return false;
        }
        else
        {
            double d0 = this.getTargetDistance();

    		EntityPlayer owner = null;
	    	if(this.attacker.getOwner() != null && this.attacker.getOwner() instanceof EntityPlayer)
	    	{
	    		owner = (EntityPlayer)this.attacker.getOwner();
	    	}


            List list = this.taskOwner.worldObj.selectEntitiesWithinAABB(this.targetClass, this.taskOwner.boundingBox.expand(d0, 4.0D, d0), this.targetEntitySelector);
            Collections.sort(list, this.theNearestAttackableTargetSorter);

            if (list.isEmpty())
            {
                return false;
            }
            else
            {
            	for(int cnt = 0; cnt < list.size(); cnt++)
            	{
        			if(this.attacker.getArrayAISets(EnumDqmMobAI.HEAVYFIRE.getId()) > 0)
        			{
        				Entity target = (Entity)list.get(cnt);


		        		if(target instanceof EntityLivingBase)
		        		{
	        				if(target == this.attacker)
	        				{
	        					//対象が撃った本人の場合も当たらない
	        					//this.tagetMob = (EntityLivingBase)target;
	        				}else if (target instanceof EntityPlayer)
		                    {
		                    	//プレイヤーに当たった時
		                    	EntityPlayer entityplayer = (EntityPlayer)target;

		                        if(owner != null && (entityplayer.capabilities.disableDamage || !owner.canAttackPlayer(entityplayer)))
		                        {
		                        	//PvPが許可されていないと当たらない

		                        }else if(owner != null && target == owner)
		                        {

		                        }else
		                        {
		        					if(!entityplayer.isPotionActive(DQPotionMinus.debuffHeavyFire.id));
		        					{
		        						entityplayer.addPotionEffect(new PotionEffect(DQPotionMinus.debuffHeavyFire.id, 100, this.attacker.getArrayAISets(EnumDqmMobAI.HEAVYFIRE.getId())));
		        					}
		                        	//this.tagetMob = (EntityLivingBase)target;
		                        }
		                    }else if(target instanceof DqmPetBase)
		                    {
		                    	if(owner != null && !(DQR.func.canAttackPetMonster((DqmPetBase)target, owner)))
		                    	{

		                    	}else
		                    	{
		                    		DqmPetBase pet = (DqmPetBase)target;
		                    		//this.tagetMob = (EntityLivingBase)target;
		        					if(!pet.isPotionActive(DQPotionMinus.debuffHeavyFire.id));
		        					{
		        						pet.addPotionEffect(new PotionEffect(DQPotionMinus.debuffHeavyFire.id, 100, this.attacker.getArrayAISets(EnumDqmMobAI.HEAVYFIRE.getId())));
		        					}
		                    	}
		                    }
		                    else if (target instanceof EntityTameable ||
		                                 target instanceof EntityHorse)
		                    {
		                    	//事故防止の為、EntityTameable（犬や猫などのペット）、馬にも当たらないようにする

		                    }else
		                    {
	                    		DqmMobBase pet = (DqmMobBase)target;
	                    		//this.tagetMob = (EntityLivingBase)target;
	        					if(!pet.isPotionActive(DQPotionMinus.debuffHeavyFire.id));
	        					{
	        						pet.addPotionEffect(new PotionEffect(DQPotionMinus.debuffHeavyFire.id, 100, this.attacker.getArrayAISets(EnumDqmMobAI.HEAVYFIRE.getId())));
	        					}
		                    }
		        		}
        				/*
        				if(list.get(cnt) instanceof EntityPlayer)
        				{
        					EntityPlayer ep = (EntityPlayer)list.get(cnt);
        					if(!ep.isPotionActive(DQPotionMinus.debuffHeavyFire.id));
        					{
        						ep.addPotionEffect(new PotionEffect(DQPotionMinus.debuffHeavyFire.id, 100, this.attacker.getArrayAISets(EnumDqmMobAI.HEAVYFIRE.getId())));
        					}
        				}
        				*/
        			}

            	}

                this.targetEntity = (EntityLivingBase)list.get(0);
                return true;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.targetEntity);
        super.startExecuting();
    }

    public static class Sorter implements Comparator
        {
            private final Entity theEntity;
            private static final String __OBFID = "CL_00001622";

            public Sorter(Entity p_i1662_1_)
            {
                this.theEntity = p_i1662_1_;
            }

            public int compare(Entity p_compare_1_, Entity p_compare_2_)
            {
                double d0 = this.theEntity.getDistanceSqToEntity(p_compare_1_);
                double d1 = this.theEntity.getDistanceSqToEntity(p_compare_2_);
                return d0 < d1 ? -1 : (d0 > d1 ? 1 : 0);
            }

            public int compare(Object p_compare_1_, Object p_compare_2_)
            {
                return this.compare((Entity)p_compare_1_, (Entity)p_compare_2_);
            }
        }
}
