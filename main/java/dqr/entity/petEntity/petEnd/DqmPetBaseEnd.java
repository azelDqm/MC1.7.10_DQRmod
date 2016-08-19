package dqr.entity.petEntity.petEnd;

import net.minecraft.world.World;
import dqr.api.enums.EnumDqmPet;
import dqr.entity.petEntity.DqmPetBase;

public class DqmPetBaseEnd extends DqmPetBase {
	public DqmPetBaseEnd(World world, EnumDqmPet Type)
	{
		//this(world);
		super(world, Type);
		this.isImmuneToFire = true;
	}
}