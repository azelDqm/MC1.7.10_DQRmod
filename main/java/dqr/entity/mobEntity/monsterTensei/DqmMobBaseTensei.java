package dqr.entity.mobEntity.monsterTensei;

import net.minecraft.world.World;
import dqr.api.enums.EnumDqmMonster;
import dqr.entity.mobEntity.DqmMobBase;

public class DqmMobBaseTensei extends DqmMobBase
{

	public DqmMobBaseTensei(World world, EnumDqmMonster Type)
	{
		//this(world);
		super(world, Type);
		this.isImmuneToFire = true;
	}

	@Override
    public boolean getCanSpawnHere()
    {

		//System.out.println("!!!!!!!!!!!!!!!!!!!" + this.getCommandSenderName());
        return super.getCanSpawnHere();
    }
}
