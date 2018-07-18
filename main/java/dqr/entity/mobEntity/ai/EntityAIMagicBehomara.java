package dqr.entity.mobEntity.ai;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import dqr.DQR;
import dqr.api.enums.EnumDqmMagic;
import dqr.entity.mobEntity.DqmMobBase;

public class EntityAIMagicBehomara extends EntityAIBase
{
    private DqmMobBase field_151500_b;
    private World field_151501_c;
    int field_151502_a;
    private static final String __OBFID = "CL_00001582";
    private EnumDqmMagic enumMagic;
    private Potion pot;
    private DqmMobBase tagetMob;
    private int field_75318_f;

    public EntityAIMagicBehomara(DqmMobBase p_i45314_1_, EnumDqmMagic enumMagic, Potion pot)
    {
    	DQR.func.debugString("TEST_Z", this.getClass());
        this.field_151500_b = p_i45314_1_;
        this.field_151501_c = p_i45314_1_.worldObj;
        this.enumMagic = enumMagic;
        this.pot = pot;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {

    	DQR.func.debugString("TEST_A", this.getClass());
        if(!this.field_151500_b.worldObj.isRemote)
        {
        	//DQR.func.debugString("TEST_B", this.getClass());
            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];

            long setTime = worldserver.getWorldTime();

            //if(DQR.debug == 4) System.out.println("shouldExecute(Time) : " + this.field_151500_b.skillCoolTime + "(" + (this.parentEntity.skillCoolTime + 5) +  ") / " + setTime );
            if(this.field_151500_b.skillCoolTimeHeal + DQR.func.xRandom(this.field_151500_b.skillCoolTimeHealMin, this.field_151500_b.skillCoolTimeHealMax) < setTime)
            {
            	//DQR.func.debugString("TEST_C", this.getClass());
		    	if(this.field_151500_b.getMaxHealth() > this.field_151500_b.getHealth())
		    	{
		    		this.tagetMob = this.field_151500_b;
		    		return true;
		    	}

		    	//DQR.func.debugString("TEST_D", this.getClass());
		    	List list = field_151501_c.getEntitiesWithinAABBExcludingEntity(field_151500_b,
		    			field_151500_b.boundingBox.addCoord(field_151500_b.motionX, field_151500_b.motionY, field_151500_b.motionZ).expand(10.0D, 5.0D, 10.0D));

		        if (list != null && !list.isEmpty())
		        {
		        	for (int n = 0 ; n < list.size() ; n++)
		        	{
		        		Entity target = (Entity)list.get(n);

		        		if(target instanceof DqmMobBase)
		        		{
		        			if(((DqmMobBase) target).getHealth() < ((DqmMobBase) target).getMaxHealth())
		        			{
		        				this.tagetMob = (DqmMobBase)target;
		        				return true;
		        			}
		        		}
		        	}
		        }
		        //DQR.func.debugString("TEST_E", this.getClass());
            }
        }

        return false;
    }


    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.field_151502_a = 0;
        this.tagetMob = null;
        this.field_75318_f = 0;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	Random rand = new Random();
    	if(this.tagetMob == null || rand.nextInt(40) != 0)
    	{
    		return false;
    	}else
    	{
    		return true;
    	}

    	//return !(this.tagetMob == null);
        //return false;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
    	//DQR.func.debugString("TEST_F", this.getClass());
    	int tag = this.field_151500_b == this.tagetMob? 1 : 0;

        double d0 = this.field_151500_b.getDistanceSq(this.tagetMob.posX, this.tagetMob.boundingBox.minY, this.tagetMob.posZ);
        boolean flag = this.field_151500_b.getEntitySenses().canSee(this.tagetMob);

        if (flag)
        {
            ++this.field_75318_f;
        }
        else
        {
            this.field_75318_f = 0;
        }

        //DQR.func.debugString("TEST_G", this.getClass());
        //if (d0 <= (double)5.0F && this.field_75318_f >= 20)
        if (this.field_75318_f >= 40)
        {

        }
        else
        {
            this.field_151500_b.getNavigator().tryMoveToEntityLiving(this.tagetMob, 1.25D);
        }

        //DQR.func.debugString("TEST_H", this.getClass());
        if(this.tagetMob != null){
        	this.field_151500_b.getLookHelper().setLookPositionWithEntity(this.tagetMob, 30.0F, 30.0F);
        }

        field_151500_b.attackEntityWithBehomara(this.field_151500_b, 0, this.enumMagic);
        this.tagetMob = null;

        if(!this.field_151500_b.worldObj.isRemote)
        {
            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];

            long setTime = worldserver.getWorldTime();


            this.field_151500_b.skillCoolTimeHeal = setTime;
        }

        DQR.func.debugString("TEST_I", this.getClass());

            //this.rangedAttackEntityHost.attackEntityWithRangedAttack(this.attackTarget, f1);
            //this.rangedAttackTime = MathHelper.floor_float(f * (float)(this.maxRangedAttackTime - this.field_96561_g) + (float)this.field_96561_g);



    	/*
        this.field_151502_a = Math.max(0, this.field_151502_a - 1);

        if (this.field_151502_a == 4)
        {
            int i = MathHelper.floor_double(this.field_151500_b.posX);
            int j = MathHelper.floor_double(this.field_151500_b.posY);
            int k = MathHelper.floor_double(this.field_151500_b.posZ);

            if (this.field_151501_c.getBlock(i, j, k) == Blocks.tallgrass)
            {
                if (this.field_151501_c.getGameRules().getGameRuleBooleanValue("mobGriefing"))
                {
                    this.field_151501_c.func_147480_a(i, j, k, false);
                }

                this.field_151500_b.eatGrassBonus();
            }
            else if (this.field_151501_c.getBlock(i, j - 1, k) == Blocks.grass)
            {
                if (this.field_151501_c.getGameRules().getGameRuleBooleanValue("mobGriefing"))
                {
                    this.field_151501_c.playAuxSFX(2001, i, j - 1, k, Block.getIdFromBlock(Blocks.grass));
                    this.field_151501_c.setBlock(i, j - 1, k, Blocks.dirt, 0, 2);
                }

                this.field_151500_b.eatGrassBonus();
            }
        }
        */
    }
}
