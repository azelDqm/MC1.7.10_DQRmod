package dqr.entity.petEntity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import dqr.DQR;
import dqr.entity.petEntity.DqmPetBase;

public class EntityAIDeath extends EntityAIBase
{
    private DqmPetBase tagetMob;
    private int field_75318_f;
    private int tickTime = 0;

    public EntityAIDeath(DqmPetBase p_i45314_1_)
    {
    	this.tagetMob = p_i45314_1_;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	return this.tagetMob.getHealth() <= 0.1F;
    }


    /**
     * Resets the task
     */
    public void resetTask(){}

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
    	return this.tagetMob.getHealth() <= 0.1F;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
    	tickTime++;

    	if(tickTime > 20)
    	{
    		if(DQR.conf.offDeadPetSound > 0)
    		{
    			tagetMob.worldObj.playSoundAtEntity(tagetMob, "dqr:player.pi", 0.5F, 1.0F);
    		}
    		tickTime = 0;
    	}
    }
}
