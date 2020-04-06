package dqr.entity.throwingEntity.throwItem;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQMiscs;
import dqr.api.potion.DQPotionEtc;
import dqr.entity.mobEntity.DqmMobBase;

public class ThrowItemEntitySinkanohiseki extends ThrowItemEntity
{
    private static final String __OBFID = "CL_00001724";

    public ThrowItemEntitySinkanohiseki(World p_i1779_1_)
    {
        super(p_i1779_1_);
    }

    public ThrowItemEntitySinkanohiseki(World p_i1780_1_, EntityLivingBase p_i1780_2_)
    {
        super(p_i1780_1_, p_i1780_2_);
    }

    public ThrowItemEntitySinkanohiseki(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_)
    {
        super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
    	boolean flg = true;

        if (p_70184_1_.entityHit != null)
        {
            //p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        	if(p_70184_1_.entityHit instanceof DqmMobBase)
        	{
        		DqmMobBase mob = (DqmMobBase)p_70184_1_.entityHit;

        		if(mob.TenseiMob != null && !mob.TenseiMob.equalsIgnoreCase(""))
        		{
        			DQR.func.addPotionEffect2(mob, new PotionEffect(DQPotionEtc.buffShinkanoHiseki.id, 20 * 15, 0));

        			flg = false;
        		}
        	}
        }

        /*
        if (!this.worldObj.isRemote && this.rand.nextInt(8) == 0)
        {
            byte b0 = 1;

            if (this.rand.nextInt(32) == 0)
            {
                b0 = 4;
            }

            for (int i = 0; i < b0; ++i)
            {
                EntityChicken entitychicken = new EntityChicken(this.worldObj);
                entitychicken.setGrowingAge(-24000);
                entitychicken.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                this.worldObj.spawnEntityInWorld(entitychicken);
            }
        }
        */


        if (!this.worldObj.isRemote)
        {
        	if(flg)
        	{
        		this.dropItem(DQMiscs.itemSinkanohiseki, 1);
        	}

            this.setDead();
        }
    }
}