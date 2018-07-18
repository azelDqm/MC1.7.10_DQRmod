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

public class EntityPetAIMagicHoimi extends EntityAIBase
{
    private DqmPetBase field_151500_b;
    private World field_151501_c;
    int field_151502_a;
    private static final String __OBFID = "CL_00001582";
    private EnumDqmMagic enumMagic;
    private Potion pot;
    private EntityLivingBase taget;
    private int field_75318_f;

    public EntityPetAIMagicHoimi(DqmPetBase p_i45314_1_, EnumDqmMagic enumMagic, Potion pot)
    {
        this.field_151500_b = p_i45314_1_;
        this.field_151501_c = p_i45314_1_.worldObj;
        this.enumMagic = enumMagic;
        this.pot = pot;
        this.setMutexBits(3);
    }

    /**b
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {

        if(!this.field_151500_b.worldObj.isRemote)
        {

            if(enumMagic == null || this.field_151500_b.getMP() < enumMagic.getMP())
            {
            	return false;
            }

            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];

            long setTime = worldserver.getWorldTime();

            //if(DQR.debug == 4) System.out.println("shouldExecute(Time) : " + this.field_151500_b.skillCoolTime + "(" + (this.parentEntity.skillCoolTime + 5) +  ") / " + setTime );
            //if(DQR.debug == 4) System.out.println("shouldExecute(Time)");
            if(this.field_151500_b.skillCoolTimeHeal + DQR.func.xRandom(this.field_151500_b.skillCoolTimeHealMin, this.field_151500_b.skillCoolTimeHealMax) < setTime)
            {

		    	if(DQR.debug == 4){System.out.println("shouldExecute 1");}
		    	if(this.field_151500_b.getMaxHealth() > this.field_151500_b.getHealth())
		    	{
		    		this.taget = this.field_151500_b;
		    		return true;
		    	}

		    	EntityPlayer owner = null;

		    	if(this.field_151500_b.getOwner() != null && this.field_151500_b.getOwner() instanceof EntityPlayer)
		    	{
		    		owner = (EntityPlayer)this.field_151500_b.getOwner();
		    	}

		    	List list = field_151501_c.getEntitiesWithinAABBExcludingEntity(field_151500_b,
		    			field_151500_b.boundingBox.addCoord(field_151500_b.motionX, field_151500_b.motionY, field_151500_b.motionZ).expand(10.0D, 5.0D, 10.0D));

		    	if(DQR.debug == 4){System.out.println("shouldExecute A : " + this.field_151500_b.ownerUUID);}

		        if (list != null && !list.isEmpty())
		        {
		        	for (int n = 0 ; n < list.size() ; n++)
		        	{
		        		Entity target = (Entity)list.get(n);

		        		if(target instanceof EntityPlayer)
		        		{
		        			EntityPlayer entityplayer = (EntityPlayer)target;

		        			if(owner != null && (entityplayer.capabilities.disableDamage || !owner.canAttackPlayer(entityplayer)))
	                        {
	                        	//PvPが許可されていないと当たらない
		        				this.taget = (EntityLivingBase)target;
	                        }else if(owner != null && target == owner)
	                        {
	                        	this.taget = (EntityLivingBase)target;
	                        }
		        		}else if(target instanceof DqmPetBase)
		        		{
	                    	if(owner != null && !(DQR.func.canAttackPetMonster((DqmPetBase)target, owner)))
	                    	{
	                    		this.taget = (EntityLivingBase)target;
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

		        		if(this.taget != null)
		        		{
		        			if(this.taget.getHealth() < this.taget.getMaxHealth())
		        			{
		        				if(!(this.taget instanceof DqmPetBase) || this.taget.getHealth() > 0.5F)
		        				{
		        					return true;
		        				}
		        			}else
		        			{
		        				this.taget = null;
		        			}
		        		}

		        		/*
		        		if(target instanceof EntityPlayer)
		        		{
		        			if(DQR.debug == 4){System.out.println("shouldExecute B : " + target.getUniqueID().toString());}
		        			if(this.field_151500_b.ownerUUID.equalsIgnoreCase(((EntityPlayer)target).getUniqueID().toString()))
		        			{
		        				if(DQR.debug == 4){System.out.println("shouldExecute C : " + ((EntityLivingBase) target).getHealth() + " / " + ((EntityLivingBase) target).getMaxHealth() * (this.field_151500_b.healUseLine / 100));}
			        			if(((EntityLivingBase) target).getHealth() < ((EntityLivingBase) target).getMaxHealth() * (this.field_151500_b.healUseLine / 100.0f))
			        			{
			        				this.taget = (EntityLivingBase)target;
			        	    		if(DQR.debug == 4){System.out.println("shouldExecute 2 : " + target.getCommandSenderName());}
			        				return true;
			        			}
		        			}
		        		}else if(target instanceof DqmPetBase)
		        		{
		        			DqmPetBase pet = (DqmPetBase)target;
		        			if(DQR.debug == 4){System.out.println("shouldExecute B2 : " + target.getUniqueID().toString());}
		        			if(!pet.isDead && this.field_151500_b.ownerUUID.equalsIgnoreCase(pet.ownerUUID))
		        			{
		        				if(DQR.debug == 4){System.out.println("shouldExecute C2 : " + ((EntityLivingBase) target).getHealth() + " / " + ((EntityLivingBase) target).getMaxHealth() * (this.field_151500_b.healUseLine / 100));}
			        			if(((EntityLivingBase) target).getHealth() < ((EntityLivingBase) target).getMaxHealth() * (this.field_151500_b.healUseLine / 100.0f))
			        			{
			        				this.taget = (EntityLivingBase)target;
			        	    		if(DQR.debug == 4){System.out.println("shouldExecute 3 : " + target.getCommandSenderName());}
			        				return true;
			        			}
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
        this.taget = null;
        this.field_75318_f = 0;
    }


    /**
     * Updates the task
     */
    public void updateTask()
    {

    	if(DQR.debug == 4){System.out.println("updateTask");}

    	if(field_151500_b == null || this.taget == null)
    	{
    		return;
    	}

    	if(DQR.debug == 4){System.out.println("updateTask2");}

    	int tag = this.field_151500_b == this.taget? 1 : 0;

        double d0 = this.field_151500_b.getDistanceSq(this.taget.posX, this.taget.boundingBox.minY, this.taget.posZ);
        boolean flag = this.field_151500_b.getEntitySenses().canSee(this.taget);


    	field_151500_b.attackEntityWithHoimi(this.field_151500_b, 0, this.enumMagic, tag, this.taget);
        this.field_151500_b.getNavigator().clearPathEntity();
        this.taget = null;

        if(!this.field_151500_b.worldObj.isRemote)
        {
            WorldServer worldserver = MinecraftServer.getServer().worldServers[0];

            long setTime = worldserver.getWorldTime();


            this.field_151500_b.skillCoolTimeHeal = setTime;
        }

    }
}
