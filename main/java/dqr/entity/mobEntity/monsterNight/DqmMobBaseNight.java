package dqr.entity.mobEntity.monsterNight;

import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmMonster;
import dqr.entity.mobEntity.DqmMobBase;

public class DqmMobBaseNight extends DqmMobBase
{
	public DqmMobBaseNight(World world, EnumDqmMonster Type)
	{
		//this(world);
		super(world, Type);
	}

    public boolean getCanSpawnHere2()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        //return

        if(DQR.checkCanSpawn.checkCanSpawnField(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ, boundingBox, this) == false)
        {
        	return false;
        }

        boolean timeCheck = false;
        if(DQR.conf.bug_mosSpawnTimeCheck == 1)
        {
        	timeCheck = true;
        }

        return this.worldObj.checkNoEntityCollision(this.boundingBox) &&
          	   this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() &&
          	   !this.worldObj.isAnyLiquid(this.boundingBox) &&
          	   (!this.worldObj.isDaytime() || isValidLightLevel2(7) || timeCheck) &&
          	   this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }

	@Override
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        //return

        if(DQR.checkCanSpawn.checkCanSpawnField(this.worldObj, (int)this.posX, (int)this.posY, (int)this.posZ, boundingBox, this) == false)
        {
        	return false;
        }

        boolean timeCheck = false;
        if(DQR.conf.bug_mosSpawnTimeCheck == 1 && this.flgSpawnFromSpawner)
        {
        	timeCheck = true;
        }

        return this.worldObj.checkNoEntityCollision(this.boundingBox) &&
          	   this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() &&
          	   !this.worldObj.isAnyLiquid(this.boundingBox) &&
          	   (!this.worldObj.isDaytime() || isValidLightLevel2(7) || timeCheck) &&
          	   this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL;
    }
}
