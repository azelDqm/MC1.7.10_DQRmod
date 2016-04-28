package dqr.entity.throwingEntity.throwItem;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ThrowItemEntity extends EntityThrowable
{
    private static final String __OBFID = "CL_00001724";

    public ThrowItemEntity(World p_i1779_1_)
    {
        super(p_i1779_1_);
    }

    public ThrowItemEntity(World p_i1780_1_, EntityLivingBase p_i1780_2_)
    {
        super(p_i1780_1_, p_i1780_2_);
    }

    public ThrowItemEntity(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_)
    {
        super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {

    }
}