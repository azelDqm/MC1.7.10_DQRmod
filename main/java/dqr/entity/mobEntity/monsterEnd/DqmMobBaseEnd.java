package dqr.entity.mobEntity.monsterEnd;

import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmMonster;
import dqr.entity.mobEntity.DqmMobBase;

public class DqmMobBaseEnd extends DqmMobBase
{

	public DqmMobBaseEnd(World world, EnumDqmMonster Type)
	{
		//this(world);
		super(world, Type);
		//System.out.println("DEBUG1" + Type.getMobClassName());
		this.isImmuneToFire = true;
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
