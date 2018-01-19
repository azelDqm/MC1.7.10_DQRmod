package dqr.entity.petEntity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import dqr.entity.petEntity.DqmPetBase;

public class EntityPetAIMagicMegante extends EntityAIBase
{
    /** The creeper that is swelling. */
	DqmPetBase swellingCreeper;
    /** The creeper's attack target. This is used for the changing of the creeper's state. */
    EntityLivingBase creeperAttackTarget;
    private static final String __OBFID = "CL_00001614";

    public EntityPetAIMagicMegante(DqmPetBase p_i1655_1_)
    {
        this.swellingCreeper = p_i1655_1_;
        this.setMutexBits(1);
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
        this.swellingCreeper.getNavigator().clearPathEntity();
        this.creeperAttackTarget = this.swellingCreeper.getAttackTarget();
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.creeperAttackTarget = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
    	this.swellingCreeper.setMegante();
    }
}
