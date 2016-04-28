package dqr.entity.mobEntity.ai;

import java.util.Random;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmMagicType;
import dqr.entity.mobEntity.DqmMobBase;

public class EntityAIMagicAttack extends EntityAIBase
{
    /** The entity the AI instance has been applied to */
    private final EntityLiving entityHost;
    /** The entity (as a RangedAttackMob) the AI instance has been applied to. */
    private final DqmMobBase rangedAttackEntityHost;
    private EntityLivingBase attackTarget;
    /**
     * A decrementing tick that spawns a ranged attack once this value reaches 0. It is then set back to the
     * maxRangedAttackTime.
     */
    private int rangedAttackTime;
    private double entityMoveSpeed;
    private int field_75318_f;
    private int field_96561_g;
    /** The maximum time the AI has to wait before peforming another ranged attack. */
    private int maxRangedAttackTime;
    private float field_96562_i;
    private float field_82642_h;
    private static final String __OBFID = "CL_00001609";
    private boolean continueFlg = true;
    private EnumDqmMagic enumMagic;


    public EntityAIMagicAttack(DqmMobBase p_i1649_1_, double p_i1649_2_, int p_i1649_4_, float p_i1649_5_)
    {
        this(p_i1649_1_, p_i1649_2_, p_i1649_4_, p_i1649_4_, p_i1649_5_, null);
    }

    public EntityAIMagicAttack(DqmMobBase p_i1649_1_, double p_i1649_2_, int p_i1649_4_, float p_i1649_5_, EnumDqmMagic enumMagic)
    {
        this(p_i1649_1_, p_i1649_2_, p_i1649_4_, p_i1649_4_, p_i1649_5_, enumMagic);
    }

    public EntityAIMagicAttack(DqmMobBase p_i1650_1_, double p_i1650_2_, int p_i1650_4_, int p_i1650_5_, float p_i1650_6_, EnumDqmMagic enumMagic)
    {
        this.rangedAttackTime = -1;

        if (!(p_i1650_1_ instanceof EntityLivingBase))
        {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }
        else
        {
            this.rangedAttackEntityHost = p_i1650_1_;
            this.entityHost = (EntityLiving)p_i1650_1_;
            this.entityMoveSpeed = p_i1650_2_;
            this.field_96561_g = p_i1650_4_;
            this.maxRangedAttackTime = p_i1650_5_;
            this.field_96562_i = p_i1650_6_;
            this.field_82642_h = p_i1650_6_ * p_i1650_6_;
            this.enumMagic = enumMagic;
            this.setMutexBits(3);
        }
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.entityHost.getAttackTarget();

        //System.out.println("testYYY");
        if (entitylivingbase == null)
        {
            return false;
        }
        else
        {
            this.attackTarget = entitylivingbase;
            return true;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	//boolean flg = this.shouldExecute() || !this.entityHost.getNavigator().noPath();

    	Random rand = new Random();

    	if(rand.nextInt(10) != 0)
    	{
    		return false;
    	}else
    	{
    		return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
    	}
    	//System.out.println("testYYY2");
    	//if(!this.continueFlg)
    	//{
    	//	flg = false;
    	//	this.continueFlg = true;
    	//}
    	//System.out.println("testYYY3");
        //return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
    	//return flg;
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.attackTarget = null;
        this.field_75318_f = 0;
        this.rangedAttackTime = -1;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
    	//System.out.println("DEBUG2");
        double d0 = this.entityHost.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
        boolean flag = this.entityHost.getEntitySenses().canSee(this.attackTarget);

        //System.out.println("testXXX");

        if (flag)
        {
            ++this.field_75318_f;
        }
        else
        {
            this.field_75318_f = 0;
        }

        //System.out.println("testXXX2");
        if (d0 <= (double)this.field_82642_h && this.field_75318_f >= 20)
        {
            this.entityHost.getNavigator().clearPathEntity();
        }
        else
        {
            this.entityHost.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
        }

        //System.out.println("testXXX3");
        this.entityHost.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30.0F, 30.0F);
        float f;

        //System.out.println("testXXX4");
        //if (--this.rangedAttackTime == 0)
        if(true)
        {
            if (d0 > (double)this.field_82642_h || !flag)
            {
                return;
            }

            //System.out.println("testXXX5");
            f = MathHelper.sqrt_double(d0) / this.field_96562_i;
            float f1 = f;

            if (f < 0.1F)
            {
                f1 = 0.1F;
            }

            if (f1 > 1.0F)
            {
                f1 = 1.0F;
            }

            //System.out.println("testXXX6");

            if(this.enumMagic.getType() == EnumDqmMagicType.Bagi.getId())
            {
            	this.rangedAttackEntityHost.attackEntityWithBagi(this.attackTarget, f1, this.enumMagic);
            }else if(this.enumMagic.getType() == EnumDqmMagicType.Doruma.getId())
            {
            	this.rangedAttackEntityHost.attackEntityWithDoruma(this.attackTarget, f1, this.enumMagic);
            }else if(this.enumMagic.getType() == EnumDqmMagicType.Gira.getId())
            {
            	this.rangedAttackEntityHost.attackEntityWithGira(this.attackTarget, f1, this.enumMagic);
            }else if(this.enumMagic.getType() == EnumDqmMagicType.Hyado.getId())
            {
            	this.rangedAttackEntityHost.attackEntityWithHyado(this.attackTarget, f1, this.enumMagic);
            }else if(this.enumMagic.getType() == EnumDqmMagicType.Io.getId())
            {
            	this.rangedAttackEntityHost.attackEntityWithIo(this.attackTarget, f1, this.enumMagic);
            }else if(this.enumMagic.getType() == EnumDqmMagicType.Mera.getId())
            {
            	this.rangedAttackEntityHost.attackEntityWithMera(this.attackTarget, f1, this.enumMagic);
            }else if(this.enumMagic.getType() == EnumDqmMagicType.Dein.getId())
            {
            	this.rangedAttackEntityHost.attackEntityWithRaidein(this.attackTarget, f1, this.enumMagic);
            }else if(this.enumMagic.getType() == EnumDqmMagicType.Zaki.getId())
            {
            	this.rangedAttackEntityHost.attackEntityWithZaki(this.attackTarget, f1, this.enumMagic);
            }else if(this.enumMagic.getType() == EnumDqmMagicType.Honoo.getId())
            {
            	//System.out.println("test2");
            	this.rangedAttackEntityHost.attackEntityWithHonoo(this.attackTarget, f1, this.enumMagic);
            }else if(this.enumMagic.getType() == EnumDqmMagicType.Fubuki.getId())
            {
            	this.rangedAttackEntityHost.attackEntityWithFubuki(this.attackTarget, f1, this.enumMagic);
            }
            //this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, f1);
            this.rangedAttackTime = MathHelper.floor_float(f * (float)(this.maxRangedAttackTime - this.field_96561_g) + (float)this.field_96561_g);

            Random rand = new Random();
            if (rand.nextInt(5) == 0)
            {
            	continueFlg = true;
            }else
            {
            	continueFlg = false;
            }
        }
        /*
        else if (this.rangedAttackTime < 0)
        {
            f = MathHelper.sqrt_double(d0) / this.field_96562_i;
            this.rangedAttackTime = MathHelper.floor_float(f * (float)(this.maxRangedAttackTime - this.field_96561_g) + (float)this.field_96561_g);
        }
        */
    }
}
