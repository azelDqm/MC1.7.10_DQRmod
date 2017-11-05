package dqr.entity.mobEntity.monsterBoss;

import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmMonster;
import dqr.entity.mobEntity.DqmMobBase;

public class DqmMobBaseBoss extends DqmMobBase
{

	public DqmMobBaseBoss(World world, EnumDqmMonster Type)
	{
		super(world, Type);
		this.isImmuneToFire = true;
	}

    @Override
    protected boolean canDespawn()
    {

    	return DQR.conf.canDespawnBoss == 1;
        //return true;
    }

}
