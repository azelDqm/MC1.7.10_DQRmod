package dqr.entity.petEntity.petHell;

import net.minecraft.world.World;
import dqr.api.enums.EnumDqmPet;
import dqr.entity.petEntity.DqmPetBase;

public class DqmPetBaseHell extends DqmPetBase {
	public DqmPetBaseHell(World world, EnumDqmPet Type)
	{
		//this(world);
		super(world, Type);
		this.isImmuneToFire = true;
	}
}