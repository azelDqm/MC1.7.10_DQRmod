package dqr.entity.mobEntity.monsterHell;

import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmMonster;
import dqr.entity.mobEntity.DqmMobBase;

public class DqmMobBaseHell extends DqmMobBase
{
	public DqmMobBaseHell(World world, EnumDqmMonster Type)
	{
		//this(world);
		super(world, Type);
	}

	@Override
    public boolean getCanSpawnHere()
    {

        if(DQR.checkCanSpawn.checkCanSpawnField(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ, boundingBox, this) == false)
        {
        	return false;
        }

        return super.getCanSpawnHere();
    }
}
