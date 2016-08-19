package dqr.entity.petEntity.petBoss;

import net.minecraft.world.World;
import dqr.api.enums.EnumDqmPet;
import dqr.entity.petEntity.DqmPetBase;

public class DqmPetBaseBoss extends DqmPetBase {

	public DqmPetBaseBoss(World world, EnumDqmPet Type)
	{
		//this(world);
		super(world, Type);
		this.isImmuneToFire = true;
	}
}
