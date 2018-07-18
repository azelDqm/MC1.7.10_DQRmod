package dqr.functions;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.petEntity.DqmPetBase;

public class FuncCheckBed {


	public FuncCheckBed(){}

	public boolean checkMob(World par1, int par2, int par3, int par4, EntityPlayer ep)
	{

        double d0 = 8.0D;
        double d1 = 5.0D;
        List list = par1.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getBoundingBox((double)par2 - d0, (double)par3 - d1, (double)par4 - d0, (double)par2 + d0, (double)par3 + d1, (double)par4 + d0));

        if (!list.isEmpty())
        {
            return false;
        }

        list = par1.getEntitiesWithinAABB(DqmMobBase.class, AxisAlignedBB.getBoundingBox((double)par2 - d0, (double)par3 - d1, (double)par4 - d0, (double)par2 + d0, (double)par3 + d1, (double)par4 + d0));

        if (!list.isEmpty())
        {
            return false;
        }

		return true;
	}

	public boolean healPet(World par1, int par2, int par3, int par4, EntityPlayer ep)
	{

        double d0 = 8.0D;
        double d1 = 5.0D;
        List list = par1.getEntitiesWithinAABB(DqmPetBase.class, AxisAlignedBB.getBoundingBox((double)par2 - d0, (double)par3 - d1, (double)par4 - d0, (double)par2 + d0, (double)par3 + d1, (double)par4 + d0));

        if (list.isEmpty())
        {
            return false;
        }

        Iterator it = list.iterator();

		while(it.hasNext())
		{
			Entity ent = (Entity)it.next();
			if(ent instanceof DqmPetBase)
			{
				DqmPetBase pet = (DqmPetBase)ent;
				if(pet.ownerUUID != null && ep != null && pet.ownerUUID.equalsIgnoreCase(ep.getUniqueID().toString()) && pet.getHealth() > 0.5f)
				{
					pet.heal(pet.getMaxHealth());
					pet.setMP(pet.getMaxMP());
				}
			}
		}
		return true;
	}
}
