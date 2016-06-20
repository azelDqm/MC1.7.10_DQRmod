package dqr.entity.mobEntity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import dqr.entity.mobEntity.DqmMobBase;

public class EntityAIBind extends EntityAIBase
{
    private DqmMobBase theEntity;
    /** If the EntityTameable is sitting. */
    private boolean isSitting;
    private static final String __OBFID = "CL_00001613";

    public EntityAIBind(DqmMobBase p_i1654_1_)
    {
        this.theEntity = p_i1654_1_;
        this.setMutexBits(5);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return true;
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.theEntity.getNavigator().clearPathEntity();
        //this.theEntity.setSitting(true);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        //this.theEntity.setSitting(false);
    }

}