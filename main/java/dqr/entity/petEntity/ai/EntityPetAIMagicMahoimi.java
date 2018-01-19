package dqr.entity.petEntity.ai;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import dqr.DQR;
import dqr.api.enums.EnumDqmMagic;
import dqr.entity.petEntity.DqmPetBase;
import dqr.playerData.ExtendedPlayerProperties;

public class EntityPetAIMagicMahoimi extends EntityAIBase
{
    private DqmPetBase field_151500_b;
    private World field_151501_c;
    int field_151502_a;
    private static final String __OBFID = "CL_00001582";
    private EnumDqmMagic enumMagic;
    private Potion pot;
    private EntityLivingBase tagetMob;
    private int field_75318_f;

    public EntityPetAIMagicMahoimi(DqmPetBase p_i45314_1_, EnumDqmMagic enumMagic, Potion pot)
    {
        this.field_151500_b = p_i45314_1_;
        this.field_151501_c = p_i45314_1_.worldObj;
        this.enumMagic = enumMagic;
        this.pot = pot;
        this.setMutexBits(3);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	/*
        if (this.field_151500_b.getRNG().nextInt(this.field_151500_b.isChild() ? 50 : 1000) != 0)
        {
            return false;
        }
        else
        {
            int i = MathHelper.floor_double(this.field_151500_b.posX);
            int j = MathHelper.floor_double(this.field_151500_b.posY);
            int k = MathHelper.floor_double(this.field_151500_b.posZ);
            return this.field_151501_c.getBlock(i, j, k) == Blocks.tallgrass && this.field_151501_c.getBlockMetadata(i, j, k) == 1 ? true : this.field_151501_c.getBlock(i, j - 1, k) == Blocks.grass;
        }
        */
        if(!this.field_151500_b.worldObj.isRemote)
        {
            if(enumMagic == null || this.field_151500_b.getMP() < enumMagic.getMP())
            {
            	return false;
            }

            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];

            long setTime = worldserver.getWorldTime();

            //if(DQR.debug == 4) System.out.println("shouldExecute(Time) : " + this.field_151500_b.skillCoolTime + "(" + (this.parentEntity.skillCoolTime + 5) +  ") / " + setTime );
            if(this.field_151500_b.skillCoolTimeHeal + DQR.func.xRandom(this.field_151500_b.skillCoolTimeHealMin, this.field_151500_b.skillCoolTimeHealMax) < setTime)
            {

		    	EntityPlayer owner = null;

		    	if(this.field_151500_b.getOwner() != null && this.field_151500_b.getOwner() instanceof EntityPlayer)
		    	{
		    		owner = (EntityPlayer)this.field_151500_b.getOwner();
		    	}

		    	List list = field_151501_c.getEntitiesWithinAABBExcludingEntity(field_151500_b,
		    			field_151500_b.boundingBox.addCoord(field_151500_b.motionX, field_151500_b.motionY, field_151500_b.motionZ).expand(10.0D, 5.0D, 10.0D));

		        if (list != null && !list.isEmpty())
		        {
		        	for (int n = 0 ; n < list.size() ; n++)
		        	{
		        		Entity target = (Entity)list.get(n);

		        		if(target instanceof EntityPlayer)
		        		{
		        			EntityPlayer entityplayer = (EntityPlayer)target;
		        			EntityPlayer ep = null;
		        			if(owner != null && (entityplayer.capabilities.disableDamage || !owner.canAttackPlayer(entityplayer)))
	                        {
	                        	//PvPが許可されていないと当たらない
		        				//this.tagetMob = (EntityLivingBase)target;
		        				ep = (EntityPlayer)target;
	                        }else if(owner != null && target == owner)
	                        {
	                        	//this.tagetMob = (EntityLivingBase)target;
	                        	ep = (EntityPlayer)target;
	                        }

		        			if(ep != null)
		        			{
			        			if(ExtendedPlayerProperties.get(ep).getMP() < ExtendedPlayerProperties.get(ep).getMaxMP())
			        			{
			        				this.tagetMob = (EntityLivingBase)ep;
			        				return true;
			        			}
		        			}
		        		}else if(target instanceof DqmPetBase)
		        		{
	                    	if(owner != null && !(DQR.func.canAttackPetMonster((DqmPetBase)target, owner)))
	                    	{
	                    		DqmPetBase mob = (DqmPetBase)target;

			        			if(mob.getMP() < mob.getMaxMP())
			        			{
			        				this.tagetMob = (EntityLivingBase)target;
			        				return true;
			        			}
	                    	}
		        		}else
		        		{
		        			/*
		        			if(((DqmMobBase) target).getHealth() < ((DqmMobBase) target).getMaxHealth())
		        			{
		        				this.tagetMob = (DqmMobBase)target;
		        				return true;
		        			}
		        			*/
		        		}

		        		/*
		        		if(target instanceof DqmMobBase && target != this.field_151500_b)
		        		{
		        			DqmMobBase targetMob = (DqmMobBase)target;
		        			if(targetMob.DqmMobMaxMP > targetMob.DqmMobMP)
		        			{
		        				this.tagetMob = (DqmMobBase)target;
		        				return true;
		        			}
		        		}
		        		*/
		        	}
		        }
            }
        }

        return false;
    }


    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.field_151502_a = 0;
        this.tagetMob = null;
        this.field_75318_f = 0;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    /*
    public boolean continueExecuting()
    {
    	Random rand = new Random();
    	if(this.tagetMob == null || rand.nextInt(40) != 0)
    	{
    		return false;
    	}else
    	{
    		return true;
    	}
    }
    */

    /**
     * Updates the task
     */
    public void updateTask()
    {
    	int tag = this.field_151500_b == this.tagetMob? 1 : 0;

        double d0 = this.field_151500_b.getDistanceSq(this.tagetMob.posX, this.tagetMob.boundingBox.minY, this.tagetMob.posZ);
        boolean flag = this.field_151500_b.getEntitySenses().canSee(this.tagetMob);

        if (flag)
        {
            ++this.field_75318_f;
        }
        else
        {
            this.field_75318_f = 0;
        }

        if (this.field_75318_f >= 40)
        {
        	/*
        	field_151500_b.attackEntityWithMahoimi(this.field_151500_b, 0, this.enumMagic, this.tagetMob);
            this.field_151500_b.getNavigator().clearPathEntity();
            this.tagetMob = null;
            */
        }
        else
        {
            this.field_151500_b.getNavigator().tryMoveToEntityLiving(this.tagetMob, 1.25D);
        }

        if(this.tagetMob != null)
        {
        	this.field_151500_b.getLookHelper().setLookPositionWithEntity(this.tagetMob, 30.0F, 30.0F);
        }

    	field_151500_b.attackEntityWithMahoimi(this.field_151500_b, 0, this.enumMagic, this.tagetMob);
        this.field_151500_b.getNavigator().clearPathEntity();
        this.tagetMob = null;

        if(!this.field_151500_b.worldObj.isRemote)
        {
            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];

            long setTime = worldserver.getWorldTime();


            this.field_151500_b.skillCoolTimeHeal = setTime;
        }
    }
}
