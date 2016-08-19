package dqr.entity.petEntity.petTensei;

import net.minecraft.world.World;
import dqr.api.enums.EnumDqmPet;
import dqr.entity.petEntity.DqmPetBase;

public class DqmPetBaseTensei extends DqmPetBase {
	public DqmPetBaseTensei(World world, EnumDqmPet Type)
	{
		//this(world);
		super(world, Type);
		this.isImmuneToFire = true;
	}
}