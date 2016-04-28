package dqr.entity.throwingEntity.throwItem;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ThrowItemEntitySeisui extends ThrowItemEntity
{
    private static final String __OBFID = "CL_00001724";
    private static EntityPlayer ep;

    public ThrowItemEntitySeisui(World p_i1779_1_)
    {
        super(p_i1779_1_);
    }

    public ThrowItemEntitySeisui(World p_i1780_1_, EntityLivingBase p_i1780_2_)
    {
        super(p_i1780_1_, p_i1780_2_);
        if(p_i1780_2_ instanceof EntityPlayer)
        {
        	ep = (EntityPlayer)p_i1780_2_;
        }
    }

    public ThrowItemEntitySeisui(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_)
    {
        super(p_i1781_1_, p_i1781_2_, p_i1781_4_, p_i1781_6_);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
    	Random itemRand = new Random();

        if (p_70184_1_.entityHit != null)
        {
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.worldObj.isRemote)
        {
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
            		this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.5D, 1.5D, 1.5D));

            this.worldObj.playSoundAtEntity(this, "random.glass", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (list != null && !list.isEmpty())
            {
            	for (int n = 0 ; n < list.size() ; n++)
            	{
            		Entity target = (Entity)list.get(n);

            		if ((target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse ||
            			target instanceof EntityAnimal || target instanceof EntityAgeable) && target instanceof EntityLivingBase)
            		{
            			EntityLivingBase elb = (EntityLivingBase)target;
            			elb.heal(1.0F);
            		}else
            		{
            			if(this.ep != null)
            			{
            				target.attackEntityFrom(DamageSource.causePlayerDamage(this.ep), 1.5F);
            			}
            		}
            	}
            }
        }


        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}