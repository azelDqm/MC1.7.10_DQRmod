package dqr.entity.petEntity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import dqr.entity.petEntity.DqmPetBase;

public class EntityAISit2 extends EntityAIBase
{
    private DqmPetBase theEntity;
    /** If the EntityTameable is sitting. */
    private boolean isSitting;
    private static final String __OBFID = "CL_00001613";

    public EntityAISit2(DqmPetBase p_i1654_1_)
    {
        this.theEntity = p_i1654_1_;
        this.setMutexBits(5);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.theEntity.isTamed())
        {
        	//System.out.println("TEST3-1");
            return false;
        }
        else if (this.theEntity.isInWater())
        {
        	//System.out.println("TEST3-2");
            return false;
        }
        else if (!this.theEntity.onGround)
        {
        	//System.out.println("TEST3-3");
            return false;
        }
        else
        {
            EntityLivingBase entitylivingbase = this.theEntity.getOwner();

            //return entitylivingbase == null ? true : this.isSitting;
        	//System.out.println("TEST3-4:" + this.theEntity.ownerUUID);
        	return  (this.theEntity.ownerUUID.length() == 0 && entitylivingbase == null) ? true : this.isSitting;

            //return true;
            /*
            return entitylivingbase == null ? true :
            		(this.theEntity.getDistanceSqToEntity(entitylivingbase) < 144.0D && entitylivingbase.getAITarget() != null ? false : this.isSitting);
            		*/
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.theEntity.getNavigator().clearPathEntity();
        this.theEntity.setSitting(true);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.theEntity.setSitting(false);
    }

    /**
     * Sets the sitting flag.
     */
    public void setSitting(boolean p_75270_1_)
    {
        this.isSitting = p_75270_1_;
    }
}