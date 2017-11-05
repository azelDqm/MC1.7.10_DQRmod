package dqr.entity.mobEntity.monsterMetaru;

import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmMonster;
import dqr.entity.mobEntity.DqmMobBase;

public class DqmMobBaseMetaru extends DqmMobBase
{
	public DqmMobBaseMetaru(World world, EnumDqmMonster Type)
	{
		//this(world);
		super(world, Type);
		//System.out.println("DEBUG1" + Type.getMobClassName());
		this.isImmuneToFire = true;
	}

    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
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

    @Override
    protected boolean canDespawn()
    {

    	return DQR.conf.canDespawnMetal == 1;
        //return true;
    }
}
