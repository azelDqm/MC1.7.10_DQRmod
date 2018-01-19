package dqr.entity.mobEntity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.WorldServer;
import dqr.DQR;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmMagicType;
import dqr.entity.mobEntity.DqmMobBase;

public class EntityAIMagicAttack4 extends EntityAIBase
{
	private final DqmMobBase entityHost;
	private final DqmMobBase parentEntity;
	public int attackTimer;
    public double entityMoveSpeed;
    private int field_75318_f;
    public int field_96561_g;
    public int maxRangedAttackTime;
    public float field_96562_i;
    public float field_82642_h;
    public EnumDqmMagic enumMagic;

    public final DqmMobBase rangedAttackEntityHost;
    public EntityLivingBase attackTarget;

    private int rangedAttackTime;

    public EntityAIMagicAttack4(DqmMobBase ghast)
    {
    	entityHost = ghast;
        this.parentEntity = ghast;
        this.rangedAttackEntityHost = ghast;
    }

    public EntityAIMagicAttack4(DqmMobBase p_i1649_1_, double p_i1649_2_, int p_i1649_4_, float p_i1649_5_)
    {
        this(p_i1649_1_, p_i1649_2_, p_i1649_4_, p_i1649_4_, p_i1649_5_, null);
    }

    public EntityAIMagicAttack4(DqmMobBase p_i1649_1_, double p_i1649_2_, int p_i1649_4_, float p_i1649_5_, EnumDqmMagic enumMagic)
    {
        this(p_i1649_1_, p_i1649_2_, p_i1649_4_, p_i1649_4_, p_i1649_5_, enumMagic);
    }

    public EntityAIMagicAttack4(DqmMobBase p_i1650_1_, double p_i1650_2_, int p_i1650_4_, int p_i1650_5_, float p_i1650_6_, EnumDqmMagic enumMagic)
    {
        //this.rangedAttackTime = -1;

        if (!(p_i1650_1_ instanceof EntityLivingBase))
        {
            throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
        }
        else
        {
        	this.rangedAttackEntityHost = p_i1650_1_;
            this.parentEntity = p_i1650_1_;
            this.entityHost = p_i1650_1_;
            this.entityMoveSpeed = p_i1650_2_;
            this.field_96561_g = p_i1650_4_;
            this.maxRangedAttackTime = p_i1650_5_;
            this.field_96562_i = p_i1650_6_;
            this.field_82642_h = p_i1650_6_ * p_i1650_6_;
            this.enumMagic = enumMagic;
            this.setMutexBits(3);
        }
    }
    /** The entity the AI instance has been applied to */
    //private final EntityLiving entityHost;
    /** The entity (as a RangedAttackMob) the AI instance has been applied to. */
	/*
    private final IRangedAttackMob rangedAttackEntityHost;
    private EntityLivingBase attackTarget;
    */
    /**
     * A decrementing tick that spawns a ranged attack once this value reaches 0. It is then set back to the
     * maxRangedAttackTime.
     */
	/*
    private int rangedAttackTime;
    private double entityMoveSpeed;
    private int field_75318_f;
    private int field_96561_g;
    */
    /** The maximum time the AI has to wait before peforming another ranged attack. */
	/*
    private int maxRangedAttackTime;
    private float field_96562_i;
    private float field_82642_h;
    private static final String __OBFID = "CL_00001609";
    */


	/*
    public EntityAIMagicAttack4(IRangedAttackMob p_i1649_1_, double p_i1649_2_, int p_i1649_4_, float p_i1649_5_)
    {
        this(p_i1649_1_, p_i1649_2_, p_i1649_4_, p_i1649_4_, p_i1649_5_);
    }

    public EntityAIMagicAttack4(IRangedAttackMob p_i1650_1_, double p_i1650_2_, int p_i1650_4_, int p_i1650_5_, float p_i1650_6_)
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
            this.setMutexBits(3);
        }
    }
    */

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {

    	//if(DQR.debug == 4) System.out.println("shouldExecute");
        EntityLivingBase entitylivingbase = this.parentEntity.getAttackTarget();

    	//System.out.println("TEST_AI_shouldExecute : " +  this.parentEntity.skillCoolTime);

        //System.out.println("testYYY");
        if (entitylivingbase == null)
        {
        	//System.out.println("test11");
        	//this.parentEntity.setTarget(null);
        	this.attackTarget = null;
            return false;
        }
        else
        {
            this.attackTarget = entitylivingbase;


            if(!this.parentEntity.worldObj.isRemote)
            {
	            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];

	            long setTime = worldserver.getWorldTime();
	            //System.out.println("TEST_AI_shouldExecute 2 : " + setTime);
	            //if(DQR.debug != 0) System.out.println("shouldExecute(Time) : " + this.parentEntity.skillCoolTime + "(" + (this.parentEntity.skillCoolTime + 5) +  ") / " + setTime );
	            if(this.parentEntity.skillCoolTime + DQR.func.xRandom(this.parentEntity.skillCoolTimeMin, this.parentEntity.skillCoolTimeMax) < setTime)
	            {
	            	return true;
	            }
            }
        }

        return false;
        //return this.parentEntity.getAttackTarget() != null;
    }

    public void startExecuting()
    {

    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    /*
    public boolean continueExecuting()
    {
        return this.shouldExecute() || !this.entityHost.getNavigator().noPath();
    }
    */

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.attackTarget = null;
        this.field_75318_f = 0;
        //this.rangedAttackTime = -1;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        double d0 = this.entityHost.getDistanceSq(this.attackTarget.posX, this.attackTarget.boundingBox.minY, this.attackTarget.posZ);
        boolean flag = this.entityHost.getEntitySenses().canSee(this.attackTarget);

        //System.out.println("TEST 2 " + this.attackTarget.posX + " / " + this.attackTarget.boundingBox.minY + " / " + this.attackTarget.posZ);
        if (flag)
        {
            ++this.field_75318_f;
        }
        else
        {
            this.field_75318_f = 0;
        }

        //if (d0 <= (double)this.field_82642_h && this.field_75318_f >= 20)
        //if (d0 <= 1024D && this.field_75318_f >= 20)
        if (d0 <= 4096D)
        {
            this.entityHost.getNavigator().clearPathEntity();
        }
        else
        {
            this.entityHost.getNavigator().tryMoveToEntityLiving(this.attackTarget, this.entityMoveSpeed);
        }

        this.entityHost.getLookHelper().setLookPositionWithEntity(this.attackTarget, 30.0F, 30.0F);
        float f;

        /*
        if (--this.rangedAttackTime == 0)
        {
        */

        //System.out.println("TEST 1 " + d0 + " / " + (double)this.field_82642_h + " / " + !flag);
        if (d0 > 4096D || !flag)
        {
            return;
        }

        //System.out.println("TEST 3 ");
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

        //System.out.println("TEST_AI :" + this.enumMagic.getType());
        //this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, f1);
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

        if(!this.parentEntity.worldObj.isRemote)
        {
            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];

            long setTime = worldserver.getWorldTime();


            this.parentEntity.skillCoolTime = setTime;
        }
            //this.rangedAttackTime = MathHelper.floor_float(f * (float)(this.maxRangedAttackTime - this.field_96561_g) + (float)this.field_96561_g);
            /*
        }
        else if (this.rangedAttackTime < 0)
        {
            f = MathHelper.sqrt_double(d0) / this.field_96562_i;
            this.rangedAttackTime = MathHelper.floor_float(f * (float)(this.maxRangedAttackTime - this.field_96561_g) + (float)this.field_96561_g);
        }
        	*/
    }
}