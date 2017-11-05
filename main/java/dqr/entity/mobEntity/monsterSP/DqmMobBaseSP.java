package dqr.entity.mobEntity.monsterSP;

import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmMonster;
import dqr.entity.mobEntity.DqmMobBase;

public class DqmMobBaseSP extends DqmMobBase
{
	public DqmMobBaseSP(World world, EnumDqmMonster Type)
	{
		//this(world);
		super(world, Type);
		this.isImmuneToFire = true;
	}

    @Override
    protected boolean canDespawn()
    {

    	return DQR.conf.canDespawnSP == 1;
        //return true;
    }
}
