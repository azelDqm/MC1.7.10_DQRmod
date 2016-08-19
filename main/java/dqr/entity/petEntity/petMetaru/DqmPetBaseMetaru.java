package dqr.entity.petEntity.petMetaru;

import net.minecraft.world.World;
import dqr.api.enums.EnumDqmPet;
import dqr.entity.petEntity.DqmPetBase;

public class DqmPetBaseMetaru extends DqmPetBase {
	public DqmPetBaseMetaru(World world, EnumDqmPet Type)
	{
		//this(world);
		super(world, Type);
		this.isImmuneToFire = true;
	}
}