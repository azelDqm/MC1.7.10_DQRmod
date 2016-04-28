package dqr.entity.throwingEntity.throwItem;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import dqr.api.Items.DQMiscs;
import dqr.api.potion.DQPotionEtc;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.petEntity.DqmPetBase;

public class ThrowItemEntityNiku extends ThrowItemEntity
{
    private static final String __OBFID = "CL_00001724";
    private static int level = 0;

    public ThrowItemEntityNiku(World p_i1779_1_)
    {
        super(p_i1779_1_);
    }

    public ThrowItemEntityNiku(World p_i1780_1_, EntityLivingBase p_i1780_2_)
    {
        super(p_i1780_1_, p_i1780_2_);
    }

    public ThrowItemEntityNiku(World p_i1780_1_, EntityLivingBase p_i1780_2_, int par3)
    {
        super(p_i1780_1_, p_i1780_2_);
        this.level = par3;
    }

    public ThrowItemEntityNiku(World p_i1781_1_, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_)
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

        	if(p_70184_1_.entityHit instanceof DqmMobBase)
        	{
        		DqmMobBase mob = (DqmMobBase)p_70184_1_.entityHit;

    			mob.addPotionEffect(new PotionEffect(DQPotionEtc.buffMonsterNiku.id, 20 * 30, this.level - 1));
    			flg = false;

        	}else if(p_70184_1_.entityHit instanceof DqmPetBase)
        	{
        		DqmPetBase mob = (DqmPetBase)p_70184_1_.entityHit;

        		int maxHp = (int)mob.getMaxHP();

        		if(mob.getHealth() >= 1.0F)
        		{
        			mob.heal(maxHp / 4 * this.level);
    			//	mob.addPotionEffect(new PotionEffect(DQPotionEtc.buffMonsterNiku.id, 20 * 30, this.level - 1));
        			flg = false;
        		}
        	}
        }


        if (!this.worldObj.isRemote)
        {
        	if(flg)
        	{
        		switch(this.level)
        		{
        			case 1: this.dropItem(DQMiscs.itemNiku1, 1); break;
        			case 2: this.dropItem(DQMiscs.itemNiku2, 1); break;
        			case 3: this.dropItem(DQMiscs.itemNiku3, 1); break;
        			case 4: this.dropItem(DQMiscs.itemNiku4, 1); break;
        			default: this.dropItem(DQMiscs.itemNiku1, 1);
        		}
        		;
        	}

            this.setDead();
        }
    }
}