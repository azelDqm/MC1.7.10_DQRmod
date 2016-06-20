package dqr.entity.mobEntity.monsterEtc;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import dqr.DQR;

public class DqmEntityGanseki extends EntityLiving
{
	private EntityPlayer skillUser = null;

	public DqmEntityGanseki(World p_i1595_1_) {
		super(p_i1595_1_);
		this.setAIMoveSpeed(0.0F);
		// TODO 自動生成されたコンストラクター・スタブ
	}

    public boolean isAIEnabled()
    {
        return true;
    }

    public void onUpdate()
    {
    	Boolean hitFlg = false;

    	Random rand = new Random();
    	 List list2 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
    		this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand((double)1, (double)1, (double)1));


		if (list2 != null && !list2.isEmpty())
		{
			for (int n = 0 ; n < list2.size() ; n++)
			{
				Entity target2 = (Entity)list2.get(n);

				if (!DQR.func.isPlayer(target2) && !(target2 instanceof EntityTameable) && !(target2 instanceof EntityHorse) && !(target2 instanceof DqmEntityGanseki))
				{

					float dam = (rand.nextFloat() * 40.0F) + 90.0F;

					//System.out.println("TESTDAM:" + dam);

					if(this.skillUser != null)
					{
						target2.attackEntityFrom(DQR.damageSource.getPlayerSkillDamage(this.skillUser), dam);
					}else
					{
						target2.attackEntityFrom(DamageSource.anvil, dam);
					}

					hitFlg = true;
				}

           	}
		}


    	if(this.onGround || hitFlg || this.isInWater())
    	{
    		this.setDead();
    	}

    	super.onUpdate();

    }

    public void setSkillUser(EntityPlayer par1)
    {
    	this.skillUser = par1;
    }


}