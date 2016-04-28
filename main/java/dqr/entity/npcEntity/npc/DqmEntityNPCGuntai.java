package dqr.entity.npcEntity.npc;

import java.util.Random;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.npcEntity.DqmNPCBase;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmEntityNPCGuntai extends DqmNPCBase
{
    private int HP = 9999; //********
    private int Kougeki = 10;
    private int PW = 100; //********
    private int DF = 100; //********
    //private int isDay = 0;
    private int itemRandom = -1;
    private float SP = 0.0F; //********
    private String Name = "スティーブ";//********
    private String NameE = "SteveS";//********
    private boolean Fire = true;//******** true false
    private double movespeed2 = 1.0D;
    protected void fall(float par1) {} //********

    public String ownerUUID;
    public String ownerName;

    @Override
    public void setDead()
    {
        super.setDead();
    }
    @Override
    public void onLivingUpdate()
    {
    	Random rand = new Random();

        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);

        /*
        if (this.worldObj.getBlockId(var1, var2 - 1, var3) == DqmItemList.Shoumetu.blockID)
        {
            this.setDead();
        }
		*/
        //System.out.println("DEBUGLINE:***************************************");

        if(canDespawn())
        {
        	this.setDead();
        }
        //System.out.println("TIME" + this.ticksExisted);
        super.onLivingUpdate();
    }


    @Override
    protected boolean canDespawn()
    {

    	return this.ticksExisted > 300;
        //return true;
    }

    /*
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.movespeed2);
	}
	*/

    public DqmEntityNPCGuntai(World par1World)
    {
        super(par1World);
        setSize(0.8F, 1.5F);
        moveSpeed = SP;
        experienceValue = 0;
        isImmuneToFire = Fire;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        //this.tasks.addTask(2, this.aiSit);
        //this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        //this.tasks.addTask(4, new EntityAIAttackOnCollide(this, this.moveSpeed, true));
        //this.tasks.addTask(5, new EntityAIFollowOwner(this, this.movespeed2, 3.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 0.5D));
        //this.tasks.addTask(7, new EntityAIWander(this, 0.5D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, DqmMobBase.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, DqmMobBase.class, 0.5D, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, DqmMobBase.class, 0, true));
    }

    private int flag2;
    private int flag3;

    private int flag10;
    private int Nedan;
    private int ID;

    /*
    @Override
    protected void dropFewItems(boolean par1, int par2)
    {
        if (rand.nextInt(1) == 0)
        {
            this.dropItem(DqmItemList.Se.itemID, 1);   //1
        }
    }
    */



    @Override
    public int getTotalArmorValue()
    {
        return DF;
    }
    /*
    @Override	public int getAttackStrength(Entity par1Entity)
    {
        return PW;
    }
    */
    @Override
    public boolean isAIEnabled()
    {
        return true;
    }
    @Override
    public int getMaxSpawnedInChunk()
    {
        return 1;
    }

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    public boolean canDespawn_CB()
    {
        return false;
    }

    public boolean attackEntityAsMob(Entity p_70652_1_)
    {
		if(DQR.func.isBind(this))
		{
			return false;
		}

        //int i = this.isTamed() ? 4 : 2;

        return p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.Kougeki);
    }

    public String func_152113_b()
    {
        return this.dataWatcher.getWatchableObjectString(17);
    }

    public void func_152115_b(String p_152115_1_)
    {
        this.dataWatcher.updateObject(17, p_152115_1_);
    }

    public EntityLivingBase getOwner()
    {
        try
        {
            UUID uuid = UUID.fromString(this.func_152113_b());
            return uuid == null ? null : this.worldObj.func_152378_a(uuid);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return null;
        }
    }

    public boolean func_152114_e(EntityLivingBase p_152114_1_)
    {
        return p_152114_1_ == this.getOwner();
    }

    @Override
    public boolean isEntityInvulnerable()
    {
        return true;
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);

        p_70014_1_.setInteger("kougegi", this.Kougeki);

        if (this.func_152113_b() == null)
        {
            p_70014_1_.setString("OwnerUUID", "");
        }
        else
        {
            p_70014_1_.setString("OwnerUUID", this.func_152113_b());
        }

        if(ownerName != null)
        {
        	p_70014_1_.setString("OwnerName", this.ownerName);
        }
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);

        this.Kougeki = p_70037_1_.getInteger("kougegi");
        this.ownerName = p_70037_1_.getString("OwnerName");

        String s = "";


        if (p_70037_1_.hasKey("OwnerUUID", 8))
        {
            s = p_70037_1_.getString("OwnerUUID");
        }
        else
        {
            //String s1 = p_70037_1_.getString("OwnerUUID");
        	String s1 = null;

        	s1 = p_70037_1_.getString("Owner");
            s = PreYggdrasilConverter.func_152719_a(s1);

            if(s == null || s.equalsIgnoreCase("") || s.length() == 0)
            {
            	s1 = p_70037_1_.getString("OwnerName");
            	s = PreYggdrasilConverter.func_152719_a(s1);
            }
        }

        this.ownerUUID = s;



        if (s.length() > 0)
        {
            this.func_152115_b(s);
            //this.setTamed(true);
        }
    }

    public void setKougeki(int par1)
    {
    	this.Kougeki = par1;
    }

    public int getKougeki(int par1)
    {
    	return this.Kougeki;
    }


    public void setOwnner(EntityPlayer ep)
    {
		if(this.getOwner() instanceof EntityPlayer)
		{
			EntityPlayer epOwner = (EntityPlayer)this.getOwner();
			ExtendedPlayerProperties3.get(epOwner).minusPetCount(1);
			DQR.petFunc.removePetdata(epOwner, this.getUniqueID().toString());
		}
		this.ownerName = ep.getCommandSenderName();
		String s = PreYggdrasilConverter.func_152719_a(this.ownerName);
        this.ownerUUID = s;
        this.func_152115_b(ep.getUniqueID().toString());
    }
}
