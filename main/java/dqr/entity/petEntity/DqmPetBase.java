package dqr.entity.petEntity;

import java.util.Random;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQMagics;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmPet;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.petEntity.ai.EntityAIDeath;
import dqr.entity.petEntity.ai.EntityAISit2;
import dqr.items.base.DqmItemFoodMiscBase;
import dqr.items.base.DqmItemFoodSeedBase;
import dqr.items.base.DqmItemMagicBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.items.miscs.DqmItemMegaminoInori;
import dqr.packetMessage.MessageClientPetEntityData;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.thread.NoThreadProcess;
import dqr.thread.ThreadLvUpPet;

public class DqmPetBase  extends EntityTameable implements IInvBasic
{
	public boolean chestOn = true;
    private int Job;
    private int[] JobLv = new int[32];
    private int[] JobExp = new int[32];
    private int[] JobSp = new int[32];

    private float[] JobHP = new float[32];
    private int[] JobMP = new int[32];
    private int[] JobTikara = new int[32];
    private int[] JobKasikosa = new int[32];

    private float[] arrayHP = new float[32];
    private int[] arrayMP = new int[32];
    private int[] arrayATK = new int[32];
    private int[] arrayMAG = new int[32];
    private int[] arrayDEF = new int[32];

    private int[] arrayTikara = new int[32];
    private int[] arrayMamori = new int[32];
    private int[] arraySubayasa = new int[32];
    private int[] arrayKasikosa = new int[32];

    private int[] JukurenLv = new int[64];
    private int[] JukurenExp = new int[64];

    private int Kougeki;
    private int Bougyo;
    private int Maryoku;

    private int Tikara;
    private int Mikawasi;
    private int Kasikosa;

    private int Kaisinritu;
    private int KaisinMax = 4;
    private int KaisinMin = 2;

    private int Gold;
    private int Medal;
    private int Coin;
    private int KillCount;
    private int DeathCount;

    private float HP = 20.0F;
    private float MaxHP = 20.0F;
    private int MP;
    private int MaxMP;

    private int weapon;
    private double[] rarihoLoc = new double[4];

    private boolean isChested = true;
    //public DqmPetChest petChest;
    private String field_110286_bQ;

    private boolean combatMode = true;

    private boolean deathSound = true;
    private boolean deathFlg = false;

    public String ownerUUID;
    public String ownerName;
    public EnumDqmPet type;

    private boolean onLevelThread = false;

    private EntityAIOwnerHurtByTarget aiOwnerHurtByTarget =  new EntityAIOwnerHurtByTarget(this);
    private EntityAIOwnerHurtTarget aiOwnerHurtTarget =  new EntityAIOwnerHurtTarget(this);
    //protected EntityAISit2 aiSit = new EntityAISit2(this);
    protected EntityAISit2 aiSit = new EntityAISit2(this);
    protected EntityAIDeath aiDeaht = new EntityAIDeath(this);

    public ItemStack sampleItemStack = new ItemStack(Items.wooden_sword, 1);

	public DqmPetBase(World par1, EnumDqmPet type) {
        super(par1);
        this.type = type;
        this.MaxHP = type.getHpdef();
        this.setSize(0.6F, 1.8F);
        this.getNavigator().setAvoidsWater(true);
        this.sampleItemStack = new ItemStack(Items.wooden_sword, 1);
        this.sampleItemStack.setTagCompound(new NBTTagCompound());
        this.sampleItemStack.getTagCompound().setTag("Items", new NBTTagList());
        //this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySheep.class, 200, false));
        //this.setCombatTasks();

        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.setHealth(10.0F);
        this.setTamed(false);

        if(this.getHealth() > 0.5F && this.isTamed() && !this.isSitting())
        {
        	this.setCombatTasks();
        }else
        {
        	this.tasks.addTask(2, this.aiSit);
        }
	}

	@Override
	public void onInventoryChanged(InventoryBasic p_76316_1_) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

    public boolean isAIEnabled()
    {
        return true;
    }

    public void clearTasks()
    {
//    	//System.out.println("戦闘モードを解除しました");
    	for(int cnt = 0; cnt < this.tasks.taskEntries.size(); cnt++)
    	{
            EntityAITasks.EntityAITaskEntry entityaitaskentry = (EntityAITasks.EntityAITaskEntry)this.tasks.taskEntries.get(cnt);
            EntityAIBase entityaibase1 = entityaitaskentry.action;
    		this.tasks.removeTask(entityaibase1);
    	}

    	this.setAttackTarget((EntityLivingBase)null);
    	this.tasks.addTask(2, this.aiSit);
    }

    public void setCombatTasks()
    {
    	//System.out.println("戦闘モードに切り替えました");
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        //this.tasks.addTask(8, new EntityAIBeg(this, 8.0F));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));

        if(chestOn)
        {
        	//this.initPetChest();
        }
    }

    public void setAttackTarget(EntityLivingBase p_70624_1_)
    {
        super.setAttackTarget(p_70624_1_);

        /*
        if (p_70624_1_ == null)
        {
            this.setAngry(false);
        }
        else if (!this.isTamed())
        {
            this.setAngry(true);
        }
        */
    }

    protected void updateAITick()
    {
        this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, new Float(this.getHealth()));
        this.dataWatcher.addObject(19, new Byte((byte)0));
        this.dataWatcher.addObject(20, new Byte((byte)BlockColored.func_150032_b(1)));
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.wolf.step", 0.15F, 1.0F);
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if(this.getHealth() <= 0.1F && !this.deathFlg)
        {
        	this.clearTasks();
        	this.tasks.addTask(0, aiDeaht);
        	this.deathFlg = true;
        }

        DQR.petFunc.setUnloadPet(this);

        /*
        if (!this.worldObj.isRemote && this.isShaking && !this.field_70928_h && !this.hasPath() && this.onGround)
        {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
            this.worldObj.setEntityState(this, (byte)8);
        }
        */
    }

    //fwetrwe
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (!this.isTamed() || this.isEntityInvulnerable() || (p_70097_1_.getSourceOfDamage() == this.getOwner() && p_70097_2_ > 0.0F) || (this.isTamed() && this.getHealth() <= 0.1F))
        {
            return false;
        }
        else
        {
        	if(p_70097_1_.getSourceOfDamage() instanceof EntityPlayer && this.getOwner() instanceof EntityPlayer)
        	{
        		EntityPlayer ep = (EntityPlayer)p_70097_1_.getSourceOfDamage();
        		EntityPlayer owner = (EntityPlayer)this.getOwner();

        		if(!ep.canAttackPlayer(owner))
        		{
        			return false;
        		}
        	}

            Entity entity = p_70097_1_.getEntity();
            this.aiSit.setSitting(false);

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                p_70097_2_ = (p_70097_2_ + 1.0F) / 2.0F;
            }

            if(this.isTamed() && this.getHealth() - p_70097_2_ <= 0)
            {
            	//System.out.println("Line1");
            	this.clearTasks();
            	this.tasks.addTask(0, aiDeaht);
            	this.deathFlg = true;

            	if(!this.worldObj.isRemote && deathSound)
            	{
            		//this.playSound("dqr:player.dead", 1.0F, 1.0F);
            		this.deathSound = false;
            		////!this.worldObj.playSoundAtEntity(this, "dqr:player.dead", 0.75F, 1.0F);
            	}
            	return this.attackEntityFrom2(p_70097_1_, this.getHealth() - 0.05F);
            }else
            {
            	//System.out.println("Line2");
            	return this.attackEntityFrom2(p_70097_1_, p_70097_2_);
            }
        }
    }

    public boolean attackEntityFrom2(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            this.fleeingTick = 60;

            if (!this.isAIEnabled())
            {
                IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);

                if (iattributeinstance.getModifier(field_110179_h) == null)
                {
                    iattributeinstance.applyModifier(field_110181_i);
                }
            }

            this.entityToAttack = null;
            return this.attackEntityFrom3(p_70097_1_, p_70097_2_);
        }
    }

    public boolean attackEntityFrom3(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (ForgeHooks.onLivingAttack(this, p_70097_1_, p_70097_2_)) return false;
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else if (this.worldObj.isRemote)
        {
            return false;
        }
        else
        {
        	//System.out.println("TESTLine");
            this.entityAge = 0;

            if (this.getHealth() <= 0.1F)
            {
                return false;
            }
            else if(this.getHealth() - p_70097_2_ <= 0.0F)
            {
            	this.setHealth(0.05F);
            	return false;
            }
            else if (p_70097_1_.isFireDamage() && this.isPotionActive(Potion.fireResistance))
            {
                return false;
            }
            else
            {
            	//System.out.println("TESTLine2");
                if ((p_70097_1_ == DamageSource.anvil || p_70097_1_ == DamageSource.fallingBlock) && this.getEquipmentInSlot(4) != null)
                {
                    this.getEquipmentInSlot(4).damageItem((int)(p_70097_2_ * 4.0F + this.rand.nextFloat() * p_70097_2_ * 2.0F), this);
                    p_70097_2_ *= 0.75F;
                }

                this.limbSwingAmount = 1.5F;
                boolean flag = true;

                if ((float)this.hurtResistantTime > (float)this.maxHurtResistantTime / 2.0F)
                {
                    if (p_70097_2_ <= this.lastDamage)
                    {
                        return false;
                    }

                    this.damageEntity2(p_70097_1_, p_70097_2_ - this.lastDamage);
                    this.lastDamage = p_70097_2_;
                    flag = false;
                }
                else
                {
                    this.lastDamage = p_70097_2_;
                    this.prevHealth = this.getHealth();
                    this.hurtResistantTime = this.maxHurtResistantTime;
                    this.damageEntity2(p_70097_1_, p_70097_2_);
                    this.hurtTime = this.maxHurtTime = 10;
                }

                this.attackedAtYaw = 0.0F;
                Entity entity = p_70097_1_.getEntity();

                if (entity != null)
                {
                    if (entity instanceof EntityLivingBase)
                    {
                        this.setRevengeTarget((EntityLivingBase)entity);
                    }

                    if (entity instanceof EntityPlayer)
                    {
                        this.recentlyHit = 100;
                        this.attackingPlayer = (EntityPlayer)entity;
                    }
                    else if (entity instanceof net.minecraft.entity.passive.EntityTameable)
                    {
                        net.minecraft.entity.passive.EntityTameable entitywolf = (net.minecraft.entity.passive.EntityTameable)entity;

                        if (entitywolf.isTamed())
                        {
                            this.recentlyHit = 100;
                            this.attackingPlayer = null;
                        }
                    }
                }

                if (flag)
                {
                    this.worldObj.setEntityState(this, (byte)2);

                    if (p_70097_1_ != DamageSource.drown)
                    {
                        this.setBeenAttacked();
                    }

                    if (entity != null)
                    {
                        double d1 = entity.posX - this.posX;
                        double d0;

                        for (d0 = entity.posZ - this.posZ; d1 * d1 + d0 * d0 < 1.0E-4D; d0 = (Math.random() - Math.random()) * 0.01D)
                        {
                            d1 = (Math.random() - Math.random()) * 0.01D;
                        }

                        this.attackedAtYaw = (float)(Math.atan2(d0, d1) * 180.0D / Math.PI) - this.rotationYaw;
                        this.knockBack(entity, p_70097_2_, d1, d0);
                    }
                    else
                    {
                        this.attackedAtYaw = (float)((int)(Math.random() * 2.0D) * 180);
                    }
                }

                String s;

                if (this.getHealth() <= 0.1F)
                {
                    s = this.getDeathSound();

                    if (flag && s != null)
                    {
                        this.playSound(s, this.getSoundVolume(), this.getSoundPitch());
                    }

                    //this.onDeath(p_70097_1_);
                }
                else
                {
                    s = this.getHurtSound();

                    if (flag && s != null)
                    {
                        this.playSound(s, this.getSoundVolume(), this.getSoundPitch());
                    }
                }

                return true;
            }
        }
    }

    protected String getDeathSound()
    {
        return "dqr:player.dead";
    }

    protected float getSoundPitch()
    {
        return 1.0F;
    }

    protected void damageEntity2(DamageSource p_70665_1_, float p_70665_2_)
    {
        if (!this.isEntityInvulnerable())
        {
            p_70665_2_ = ForgeHooks.onLivingHurt(this, p_70665_1_, p_70665_2_);
            if (p_70665_2_ <= 0) return;
            p_70665_2_ = this.applyArmorCalculations(p_70665_1_, p_70665_2_);
            p_70665_2_ = this.applyPotionDamageCalculations(p_70665_1_, p_70665_2_);



            //ダメージ0の場合にランダムで補正
            if(p_70665_2_ < 0.5F)
            {
            	if(rand.nextInt(5) == 0)
            	{
            		p_70665_2_ = rand.nextFloat() * 2;
            	}
            }

            //耐性計算
            p_70665_2_ = DQR.calcDamage.applyDamageResistMagic(p_70665_2_, this, p_70665_1_);

            float f1 = p_70665_2_;
            p_70665_2_ = Math.max(p_70665_2_ - this.getAbsorptionAmount(), 0.0F);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (f1 - p_70665_2_));

            if (p_70665_2_ != 0.0F)
            {
                float f2 = this.getHealth();
                if(f2 - p_70665_2_ <= 0.1F)
                {
                	p_70665_2_ = f2 - 0.05F;
                }
                this.setHealth(f2 - p_70665_2_);
                this.func_110142_aN().func_94547_a(p_70665_1_, f2, p_70665_2_);
                this.setAbsorptionAmount(this.getAbsorptionAmount() - p_70665_2_);
            }
        }
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

    public void setTamed(boolean p_70903_1_)
    {
//        //System.out.println("TEST1" + this.getHealth());


        if (p_70903_1_)
        {
            //this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        	//System.out.println("CAAAA:" + this.getMaxHP() + " / " + this.getMaxHealth());
        	if(this.getMaxHP() < type.HPDEF)
        	{
        		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(type.HPDEF);
        		this.setMaxHP(type.HPDEF);
        	}else
        	{
        		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
        	}
        	//this.setHealth(this.getMaxHP());
        	this.setHealth(this.getMaxHealth());
        }
        else
        {
            //this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        	if(this.getMaxHP() > 0.0f)
        	{
        		//System.out.println("LINE1");
        		//System.out.println("BAAAA:" + this.getMaxHP() + " / " + this.getMaxHealth());
        		//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
        		//this.setHealth(this.getMaxHP());
            	if(this.getMaxHP() < type.HPDEF)
            	{
            		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(type.HPDEF);
            		this.setMaxHP(type.HPDEF);
            	}else
            	{
            		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
            	}
            	this.setHealth(this.getMaxHP());
        	}else
        	{
        		//System.out.println("AAAAA:" + this.getMaxHP() + " / " + this.getMaxHealth());
        		if(this.getMaxHealth() > 0.0f)
        		{
        			//System.out.println("LINE2");
        			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHealth());
        			this.setHealth(this.getMaxHealth());
        		}else
        		{
        			//System.out.println("LINE3");
        			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        			this.setHealth(10.0f);
        		}
        	}
        }

    	super.setTamed(p_70903_1_);
        //System.out.println("TEST2:" + this.getHealth());
    }


    public boolean interact(EntityPlayer ep)
    {
        ItemStack itemstack = ep.inventory.getCurrentItem();
		String petName;
		if(this.getCustomNameTag() != null && !this.getCustomNameTag().equalsIgnoreCase(""))
		{
			petName = this.getCustomNameTag();
		}else
		{
			petName = this.getCommandSenderName();
		}

		String ownerName = "";
		if(this.getOwner() != null && this.getOwner() instanceof EntityPlayer)
		{
			//System.out.println("TEST1");
			//ownerName = this.getOwner()).getDisplayName();

			if(((EntityPlayer)this.getOwner()).getDisplayName() == null || (((EntityPlayer)this.getOwner()).getDisplayName()).equalsIgnoreCase(""))
			{
				//System.out.println("TEST2");
				ownerName = ((EntityPlayer)this.getOwner()).getCommandSenderName();
			}else
			{
				//System.out.println("TEST3");
				ownerName = ((EntityPlayer)this.getOwner()).getDisplayName();
			}
		}else if(this.getOwner() == null)
		{
			//System.out.println("TEST_NULL");
			ownerName = this.ownerName;
		}

        if (this.isTamed())
        {

        	boolean opFlg = false;

        	if(!ep.worldObj.isRemote)
        	{
        		opFlg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(ep.getGameProfile());
        	}

            if (itemstack != null)
            {

                if (this.isTamed() && this.getHealth() <= 0.1F)
                {
	            	//ザオリク･ザオラル
	                if ((itemstack.getItem() == DQMagics.itemZaoriku || itemstack.getItem() == DQMagics.itemZaoraru) &&
	                    (this.func_152114_e(ep) ||
	                     DQR.conf.petPermRevive == 1 ||
	                     (DQR.conf.petPermRevive == 2 && opFlg)
	                    )
	                   )
	                {

	            		PotionEffect pe;
	            		pe = ep.getActivePotionEffect(DQPotionMinus.debuffMahoton);
	            		if(pe != null && ep.worldObj.isRemote)
	            		{
	            			ep.addChatMessage(new ChatComponentTranslation("msg.magic.mahoton.txt",new Object[] {}));
	            			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

	            			return false;
	            		}
	            		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
	            		//if(pe != null && this.worldObj.isRemote)
	            		if(DQR.func.isBind(this))
	            		{
	            			ep.addChatMessage(new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
	            			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

	            			return false;
	            		}


	                	if(itemstack.getItemDamage() == 0)
	                	{

	                		int epMP = ExtendedPlayerProperties.get(ep).getMP();

	                		if(!DQR.magicTable.magicEnable(ep, itemstack.getItem()) && DQR.debug == 0)
	                		{
	            				ep.addChatMessage(new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
	            				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

	            				return false;
	                		}

	                		DqmItemMagicBase magicItem = (DqmItemMagicBase)itemstack.getItem();

	            			if(epMP < magicItem.getEnumMagic().getMP() && DQR.debug == 0)
	            			{
	            				ep.addChatMessage(new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
	            				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	            				return false;
	            			}else
	            			{
	            				ExtendedPlayerProperties.get(ep).setMP(epMP - magicItem.getEnumMagic().getMP());
	            			}

	                		//par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);
	            			if(magicItem.getEnumMagic().getDamage() + itemstack.getItemDamage() < itemstack.getMaxDamage() )
	            			{
	            				itemstack.damageItem(magicItem.getEnumMagic().getDamage(), ep);
	            			}else
	            			{
	            				itemstack.setItemDamage(itemstack.getMaxDamage() - 1);
	            			}



	                		//par3EntityPlayer.addPotionEffect(new PotionEffect(this.pot.id, this.getEnumMagic().getAttack(), 0));
	            			ep.worldObj.playSoundAtEntity(ep, "dqr:player.jumon", 1.0F, 1.0F);

	            			Random rand = new Random();

	            			if(rand.nextInt(100) > magicItem.getEnumMagic().getRate())
	            			{
	            				return false;
	            			}

	            			this.setHealth(1.0F);
	            			float healRate = (float)(magicItem.getEnumMagic().getRate() / 100);
	                        this.heal(this.getMaxHealth() * healRate);
	                        if(!this.worldObj.isRemote)
	                        {
	                        	this.playSound("dqr:player.tensyoku", 1.0F, 1.0F);
	                        }
	                        deathSound = true;
	                        this.isDead = false;
	                    	this.clearTasks();
	                    	//this.tasks.removeTask(aiDeaht);
	                    	this.setCombatTasks();
	                	}
	                }
                }else
                {


	            	//経験値玉
	            	if (itemstack.getItem() instanceof DqmItemMegaminoInori &&
	            		(this.func_152114_e(ep) ||
	            		 DQR.conf.petPermGiveExpItems == 1 ||
	            		 (DQR.conf.petPermGiveExpItems == 2 && opFlg)
	            		)
	            	   )
	            	{
	                    if (!ep.capabilities.isCreativeMode)
	                    {
	                        --itemstack.stackSize;
	                    }

	                    ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	            		setMetamiExp((DqmItemMegaminoInori)itemstack.getItem());
	            		return true;
	            	}

	            	//魔法の筒
	            	if (itemstack.getItem() == DQMiscs.ItemMahounoTutu01 &&
	            		(this.func_152114_e(ep) ||
	            		 DQR.conf.petPermUseMagicRoll == 1 ||
	            		 (DQR.conf.petPermUseMagicRoll == 2 && opFlg)
	            		)
	            	   )
	            	{
	                    if (!ep.capabilities.isCreativeMode)
	                    {
	                        --itemstack.stackSize;
	                    }

	        			if (!this.worldObj.isRemote)
	        			{
	                        ItemStack tutu = new ItemStack(DQMiscs.ItemMahounoTutu11, 1);
	                        NBTTagCompound nbt = tutu.getTagCompound();

	                    	tutu.setTagCompound(this.makeTutuNBT(nbt));
	                        //nbt = this.getEntityData();
	                        //nbt.setString("PetBaseName", this.getEntityString());

	                        //tutu.setTagCompound(nbt);
	                        //tutu.setStackDisplayName((new ChatComponentTranslation("item.dqm.MahounoTutu2.name",new Object[] { this.getCommandSenderName()})).getFormattedText());

	                    	tutu.setStackDisplayName(tutu.getDisplayName().replace("xxx", this.getCommandSenderName()));
	                        this.worldObj.playSoundAtEntity(this, "DQM_Sound.Rura", 0.8F, 1.5F);
	                    	this.entityDropItem(tutu, 0.0F);

	                    	this.setDead();
	        			}

	            		return true;
	            	}

	            	//配合の杖
	            	if (itemstack.getItem() == DQMagics.itemHaigou &&
	            		(this.func_152114_e(ep) ||
	            		 DQR.conf.petPermUseMonsterMix == 1 ||
	            		 (DQR.conf.petPermUseMonsterMix == 2 && opFlg)
	            		)
	            	   )
	            	{

	        			if (!this.worldObj.isRemote)
	        			{
	        				NBTTagCompound haigouPet1 = ExtendedPlayerProperties3.get(ep).getHaigouPet1();
	        				NBTTagCompound haigouPet2 = ExtendedPlayerProperties3.get(ep).getHaigouPet2();

	        				if(haigouPet1 == null || haigouPet1.hasNoTags())
	        				{
	        					ExtendedPlayerProperties3.get(ep).setHaigouPet1(this.makeTutuNBT(new NBTTagCompound()));
	        					ep.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petHaigou1",new Object[] {this.getCommandSenderName(), this.JobLv[0]}));
	        				}else if(haigouPet2 == null || haigouPet2.hasNoTags())
	        				{
	        					ep.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petHaigou1",new Object[] {haigouPet1.getString("PetName"), haigouPet1.getInteger("JobLv_0")}));
	        					ExtendedPlayerProperties3.get(ep).setHaigouPet2(this.makeTutuNBT(new NBTTagCompound()));
	        					ep.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petHaigou2",new Object[] {this.getCommandSenderName(), this.JobLv[0]}));
	        				}else
	        				{
	        					ep.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petHaigou1",new Object[] {haigouPet1.getString("PetName"), haigouPet1.getInteger("JobLv_0")}));
	        					ep.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.petHaigou2",new Object[] {haigouPet2.getString("PetName"), haigouPet2.getInteger("JobLv_0")}));

	        					//System.out.println("TEST:" + haigouPet1.getString("PetBaseName"));
	        					//System.out.println("TEST2:" + haigouPet2.getString("PetBaseName"));
	        					return true;
	        				}

	        				//System.out.println("TEST:" + haigouPet1.getString("PetBaseName"));
	                        //NBTTagCompound nbt = tutu.getTagCompound();

	                        //nbt = this.getEntityData();
	                        //nbt.setString("PetBaseName", this.getEntityString());

	                        //tutu.setTagCompound(nbt);
	                        //tutu.setStackDisplayName((new ChatComponentTranslation("item.dqm.MahounoTutu2.name",new Object[] { this.getCommandSenderName()})).getFormattedText());

	                        this.worldObj.playSoundAtEntity(this, "dqr:player.haigouin", 0.6F, 3.0F);
	                        if(!ep.worldObj.isRemote)
	                        {
		                        if(chestOn)
		                        {
			                        InventoryPetInventory inventory = new InventoryPetInventory(this);
			                        inventory.openInventory();

			                        for(int cnt = 0; cnt < inventory.getSizeInventory(); cnt++)
			                        {
			                        	if(inventory.getStackInSlot(cnt) != null)
			                        	{
			                        		this.entityDropItem(inventory.getStackInSlot(cnt), 0.0F);
			                        	}
			                        }
		                        }
	                        }
	                    	this.setDead();
	        			}


	            		return true;
	            	}
                }

            	//世界樹の葉
                if (itemstack.getItem() == DQMiscs.itemSekaijunoha &&
                	(this.func_152114_e(ep) ||
                	 DQR.conf.petPermRevive == 1 ||
                	 (DQR.conf.petPermRevive == 2 && opFlg)
                	)
                   )
                {
                    if (this.isTamed() && this.getHealth() <= 0.1F)
                    {
                        if (!ep.capabilities.isCreativeMode)
                        {
                            --itemstack.stackSize;
                        }

                        //this.setHealth(this.getMaxHealth() / 2);
                        this.setHealth(1.0F);
                        this.heal(this.getMaxHealth() / 2);
                        if(!this.worldObj.isRemote)
                        {
                        	this.playSound("dqr:player.tensyoku", 1.0F, 1.0F);
                        }
                        deathSound = true;
                        this.isDead = false;
                    	this.clearTasks();
                    	//this.tasks.removeTask(aiDeaht);
                    	this.setCombatTasks();

                        if (itemstack.stackSize <= 0)
                        {
                            ep.inventory.setInventorySlotContents(ep.inventory.currentItem, (ItemStack)null);
                        }

                        return true;
                    }
                }

              //debug
                if (DQR.conf.partyEnable != 0 && itemstack.getItem() == DQMiscs.itemShinjirukokoro && !this.worldObj.isRemote)
                {
                	//System.out.println("TEST_LINE_R");
    				int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_SHINZIRU.getId());

    				if(itemMode == EnumDqmMGToolMode.SHINZIRU_MEMBER_ADD.getId())
    				{
    					if(DQR.partyManager.getPartyLeaderFromMember(ep) != null)
    					{
    						DQR.partyManager.addPartyMember(DQR.partyManager.getPartyLeaderFromMember(ep), this);
    					}else
    					{
    						DQR.partyManager.addPartyMember(ep, this);
    					}
    				}else if(itemMode == EnumDqmMGToolMode.SHINZIRU_MEMBER_KICK.getId())
    				{
    					if(DQR.partyManager.isPartyLeader(ep))
    					{
    						DQR.partyManager.kickPartyPet(ep, this);
    					}else
    	        		{
    	        			ep.addChatMessage(new ChatComponentTranslation("msg.shinziru.modeInfo.txt", new Object[] {}));
    	        		}
    				}

                	//DQR.partyManager.addPartyMember(ep, this);
                }

                //
            	//聖者の灰
                if (itemstack.getItem() == DQMiscs.itemSeijanohai &&
                    (this.func_152114_e(ep) ||
                     DQR.conf.petPermUseEraser == 1 ||
                     (DQR.conf.petPermUseEraser == 2 && opFlg)
                    )
                   )
                {
                	if(this.func_152114_e(ep) || DQR.debug != 0)
                	{
	                    if (this.isTamed() && this.getHealth() <= 0.1F)
	                    {
	                        if (!ep.capabilities.isCreativeMode)
	                        {
	                            --itemstack.stackSize;
	                        }

	                        if(!this.worldObj.isRemote)
	                        {
	                        	this.playSound("dqr:mob.inoti", 1.0F, 1.0F);
	                        }

	                        //vrtyhuvbjeytg
	                        if(!ep.worldObj.isRemote)
	                        {
		                        if(chestOn)
		                        {
			                        InventoryPetInventory inventory = new InventoryPetInventory(this);
			                        inventory.openInventory();

			                        for(int cnt = 0; cnt < inventory.getSizeInventory(); cnt++)
			                        {
			                        	if(inventory.getStackInSlot(cnt) != null)
			                        	{
			                        		this.entityDropItem(inventory.getStackInSlot(cnt), 0.0F);
			                        	}
			                        }
		                        }
	                        }


	                        this.setDead();
	                    }else
	                    {
	                    	//this.setHealth(0.05F);
	                    	this.attackEntityFrom(DamageSource.magic, this.getHealth() - 0.05F);
	                    	//this.isDead = true;
	                    	/*
	                        if(!this.worldObj.isRemote)
	                        {
	                        	this.playSound("dqr:mob.inoti", 1.0F, 3.0F);
	                            String s = this.getDeathSound();

	                            if (s != null)
	                            {
	                                this.playSound(s, this.getSoundVolume(), this.getSoundPitch());
	                            }
	                        }
	                        */
	                    }
                	}
                }

                if (this.isTamed() && this.getHealth() > 0.1F)
                {
	                //薬草
	                if (itemstack.getItem() instanceof DqmItemFoodSeedBase &&
	                    (this.func_152114_e(ep) ||
	                     DQR.conf.petPermGivePlantFoods == 1 ||
	                     (DQR.conf.petPermGivePlantFoods == 2 && opFlg)
	                    )
	                   )
	                {
	                	DqmItemFoodSeedBase food = (DqmItemFoodSeedBase)itemstack.getItem();
	                	int healHP = 0;

	        			if(food.getMinHP() > -1 || food.getMaxHP() > -1)
	        			{
	        				 healHP = (int)(food.getMinHP() + rand.nextInt(food.getMaxHP() + 1));

	                     	if(this.getHealth() < this.getMaxHealth() && this.getHealth() > 0.1F)
	                    	{
	                            if (!ep.capabilities.isCreativeMode)
	                            {
	                                --itemstack.stackSize;
	                            }
	                    		this.setHealth(this.getHealth() + healHP);

	                        	if(this.getHealth() >= this.getMaxHealth())
	                        	{
	                        		this.setHealth(this.getMaxHealth());
	                        	}

	                        	if(DQR.exp.getNextExpPet(this.getJobLv(this.getJob()), this) <= 0)
	                        	{
		    	        	  		ep.addChatMessage(new ChatComponentTranslation("msg.pet.status1MAX.txt",new Object[] {petName, ownerName,
		    								  this.getJobLv(this.getJob()),
		    								  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJob(), this),
		    								  (int)(this.getHealth()), (int)(this.getMaxHealth()),
		    								  this.getMP(), this.getMaxMP()}));
	                        	}else
	                        	{
		    	        	  		ep.addChatMessage(new ChatComponentTranslation("msg.pet.status1.txt",new Object[] {petName, ownerName,
		    								  this.getJobLv(this.getJob()),
		    								  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJob(), this),
		    								  (int)(this.getHealth()), (int)(this.getMaxHealth()),
		    								  this.getMP(), this.getMaxMP()}));
	                        	}

	    	        	  		ep.addChatMessage(new ChatComponentTranslation("msg.pet.status2.txt",new Object[] {this.getKougeki(),
	    								  this.getBougyo(), this.getTotalArmorValue(),
	    								  this.getMaryoku(),
	    								  this.getTikara(),
	    								  this.getMikawasi(),
	    								  this.getKasikosa()}));

	    	        	  		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

	                        	return true;
	                    	}
	        			}

	                }
	                //その他
	                if (itemstack.getItem() instanceof DqmItemFoodMiscBase &&
	                	(this.func_152114_e(ep) ||
	                	 DQR.conf.petPermGiveETCFoods == 1 ||
	                	 (DQR.conf.petPermGiveETCFoods == 2 && opFlg)
	                	)
	                   )
	                {
	                	DqmItemFoodMiscBase food = (DqmItemFoodMiscBase)itemstack.getItem();
	                	int healHP = 0;

	        			if(food.getMinHP() > -1 || food.getMaxHP() > -1)
	        			{
	        				 healHP = (int)(food.getMinHP() + rand.nextInt(food.getMaxHP() + 1));

	                     	if(this.getHealth() < this.getMaxHealth())
	                    	{
	                            if (!ep.capabilities.isCreativeMode)
	                            {
	                                --itemstack.stackSize;
	                            }
	                    		this.setHealth(this.getHealth() + healHP);

	                        	if(this.getHealth() >= this.getMaxHealth())
	                        	{
	                        		this.setHealth(this.getMaxHealth());
	                        	}
	                        	if(DQR.exp.getNextExpPet(this.getJobLv(this.getJob()), this) <= 0)
	                        	{
		    	        	  		ep.addChatMessage(new ChatComponentTranslation("msg.pet.status1MAX.txt",new Object[] {petName, ownerName,
		    								  this.getJobLv(this.getJob()),
		    								  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJob(), this),
		    								  (int)(this.getHealth()), (int)(this.getMaxHealth()),
		    								  this.getMP(), this.getMaxMP()}));
	                        	}else
	                        	{
		    	        	  		ep.addChatMessage(new ChatComponentTranslation("msg.pet.status1MAX.txt",new Object[] {petName, ownerName,
		    								  this.getJobLv(this.getJob()),
		    								  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJob(), this),
		    								  (int)(this.getHealth()), (int)(this.getMaxHealth()),
		    								  this.getMP(), this.getMaxMP()}));
	                        	}

	    	        	  		ep.addChatMessage(new ChatComponentTranslation("msg.pet.status2.txt",new Object[] {this.getKougeki(),
	    								  this.getBougyo(), this.getTotalArmorValue(),
	    								  this.getMaryoku(),
	    								  this.getTikara(),
	    								  this.getMikawasi(),
	    								  this.getKasikosa()}));

	    	        	  		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

	                        	return true;
	                    	}
	        			}
	                }
                }

                /*
                if(itemstack.getItem() instanceof DqmItemDebugBase)
                {
            		ExtendedPlayerProperties3.get(ep).setStatusPet(this);
            		//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3(ep), (EntityPlayerMP)ep);
            		//this.writeToNBT(this.getEntityData());
            		//ExtendedPlayerProperties3.get(ep).setStatusPet(this);
            		ep.openGui(DQR.instance, DQR.conf.GuiID_PetInventory, this.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ);

                }
                */

                if(itemstack.getItem() instanceof DqmItemWeaponBase)
                {
                	if(!ep.isSneaking())
                	{
	                	if(!ep.worldObj.isRemote)
	                	{
	                		NBTTagCompound petData = new NBTTagCompound();
	                		this.writeEntityToNBT(petData);

	                		if(DQR.conf.petPermOpenInventory == 2)
	                		{
	                			petData.setBoolean("opflg", opFlg);
	                		}else
	                		{
	                			petData.setBoolean("opflg", false);
	                		}
	                		/*
	                        this.writeToNBT(this.getEntityData());
	                		NBTTagCompound petData = this.getEntityData();

	                        if(petData != null)
	                        {
	                        	//System.out.println("TEST1:NOTNULL:" + petData.hasNoTags());
	                	        Object[] type = petData.func_150296_c().toArray();

	                	        for(int cnt = 0; cnt < type.length; cnt++)
	                	        {
	                	            //System.out.println("TEST:" + (String)type[cnt]);
	                	        }
	                        }else
	                        {
	                        	//System.out.println("TEST1:NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
	                        }
							*/
	                		//System.out.println("TEST1:XXXXXXXXXXXXXXXXXXXXXX");


	                		PacketHandler.INSTANCE.sendTo(new MessageClientPetEntityData(petData), (EntityPlayerMP)ep);
	                	}
	            		ExtendedPlayerProperties3.get(ep).setStatusPet(this);
	            		//ExtendedPlayerProperties3.get(ep).setStatusPetOwner(ownerUUID);

	            		//gtw54eg6t45g64
	            		//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties3(ep), (EntityPlayerMP)ep);

	            		//this.writeToNBT(this.getEntityData());
	            		ep.openGui(DQR.instance, DQR.conf.GuiID_PetStatus, this.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ);

                	}else
                	{
                    	if(!ep.worldObj.isRemote)
                    	{
                    		if(DQR.exp.getNextExpPet(this.getJobLv(this.getJob()), this) <= 0)
                    		{
    	        	  		ep.addChatMessage(new ChatComponentTranslation("msg.pet.status1MAX.txt",new Object[] {petName, ownerName,
    	        	  																						  this.getJobLv(this.getJob()),
    	        	  																						  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJobLv(this.getJob()), this),
    	        	  																						  (int)(this.getHealth()), (int)(this.getMaxHealth()),
    	        	  																						  this.getMP(), this.getMaxMP()}));
                    		}else
                    		{
        	        	  		ep.addChatMessage(new ChatComponentTranslation("msg.pet.status1.txt",new Object[] {petName, ownerName,
        	        	  																						   this.getJobLv(this.getJob()),
        	        	  																						   this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJobLv(this.getJob()), this),
        	        	  																						   (int)(this.getHealth()), (int)(this.getMaxHealth()),
        	        	  																						   this.getMP(), this.getMaxMP()}));

                    		}
    	        	  		ep.addChatMessage(new ChatComponentTranslation("msg.pet.status2.txt",new Object[] {this.getKougeki(),
    																										  this.getBougyo(), this.getTotalArmorValue(),
    																										  this.getMaryoku(),
    																										  this.getTikara(),
    																										  this.getMikawasi(),
    																										  this.getKasikosa()}));

    	            		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

                    	}
                	}
                }
                /*
                else if(itemstack.getItem() == DQMiscs.itemAkaisango)
                {
                	//System.out.println("HP:" + this.getHealth());
                }
                */
            }
        /*
                else if (itemstack.getItem() == Items.dye)
                {
                    int i = BlockColored.func_150032_b(itemstack.getItemDamage());


                    if (i != this.getCollarColor())
                    {
                        this.setCollarColor(i);

                        if (!p_70085_1_.capabilities.isCreativeMode && --itemstack.stackSize <= 0)
                        {
                            p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
                        }

                        return true;
                    }
                }

            }
*/
        	if(this.func_152114_e(ep) || DQR.debug != 0 ||
        	   DQR.conf.petPermRewriteOwner == 1 ||
               (DQR.conf.petPermRewriteOwner == 2 && opFlg)
              )
        	{
	            if (ep.isSneaking() && !this.worldObj.isRemote)
	            {
	            	//System.out.println("TEST-1");
	            	if (this.isTamed() && this.getHealth() > 0.1F)
	            	{
		                if(this.isSitting())
		                {
		                	if(!this.ownerName.equalsIgnoreCase(ep.getCommandSenderName()))
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

			                    ExtendedPlayerProperties3.get(ep).plusPetCount(1);

		                	}

		                	DQR.petFunc.setNewPetdata(this);
		                	this.setCombatTasks();
		                	//this.targetTasks.addTask(1, aiOwnerHurtByTarget);
		                	//this.targetTasks.addTask(2, aiOwnerHurtTarget);
		                	//System.out.println("TEST2-1");

		                }else
		                {
		                	this.clearTasks();
		                	this.tasks.addTask(2, this.aiSit);
		                	//this.targetTasks.removeTask(aiOwnerHurtByTarget);
		                	//this.targetTasks.removeTask(aiOwnerHurtTarget);
		                	//System.out.println("TEST2-2");
		                }

		                this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.75F, 1.0F);
		                this.aiSit.setSitting(!this.isSitting());
		                this.isJumping = false;
		                this.setPathToEntity((PathEntity)null);
		                this.setTarget((Entity)null);
		                this.setAttackTarget((EntityLivingBase)null);
	            	}
	                return true;
	            }

	            /*
	            //System.out.println("TEST3");
                this.openGUI(p_70085_1_);
                return true;
                */
        	}else
        	{
        		if(DQR.conf.petPermPetSitting == 1 ||
                  (DQR.conf.petPermPetSitting == 2 && opFlg))
        		{
		            if (ep.isSneaking() && !this.worldObj.isRemote)
		            {
		            	if (this.isTamed() && this.getHealth() > 0.1F)
		            	{
			            	if(!this.isSitting())
			                {
			                	this.clearTasks();
			                	this.tasks.addTask(2, this.aiSit);

				                this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.75F, 1.0F);
				                this.aiSit.setSitting(!this.isSitting());
				                this.isJumping = false;
				                this.setPathToEntity((PathEntity)null);
				                this.setTarget((Entity)null);
				                this.setAttackTarget((EntityLivingBase)null);

				                return true;
			                }
		            	}
		            }
        		}
        	}


        }
        else// if (itemstack != null && itemstack.getItem() == Items.bone)// && !this.isAngry())
        {
        	/*
            if (!p_70085_1_.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }


            if (itemstack.stackSize <= 0)
            {
                p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
            }
			*/
        	if(ep.isSneaking())
        	{
        		if (!this.worldObj.isRemote)
	            {
	        		ep.worldObj.playSoundAtEntity(ep, "dqr:mob.petmob", 1.0F, 0.5F);

	        		this.setDead();
	            }

        	}else
        	{
	            if (!this.worldObj.isRemote)
	            {
	                if (this.rand.nextInt(1) == 0)
	                {
	                	int petCount = ExtendedPlayerProperties3.get(ep).getPetCount();
	                	boolean flg = MinecraftServer.getServer().getConfigurationManager().func_152596_g(ep.getGameProfile());

	                	if(DQR.conf.petLimitPlayer == 0 || petCount < DQR.conf.petLimit || (flg && DQR.conf.petLimitPlayer == 1))
	                	{
		                    this.setTamed(true);
		                    //System.out.println("TEST1" + ep.getCommandSenderName());
		                    //System.out.println("TEST2" + ep.getDisplayName());
		                    this.ownerName = ep.getCommandSenderName();
//System.out.println("TEST1");
		                    String s = PreYggdrasilConverter.func_152719_a(this.ownerName);
		                    this.ownerUUID = s;
		                    //System.out.println("HP????" + type.HPDEF);
		                    this.setMaxHP(type.HPDEF);
		                    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(type.HPDEF);
		                    this.setMaxMP(type.MPDEF);
		                    //this.setJobTikara(this.getJob(), type.TIKARADEF);
		                    //this.setJobKasikosa(this.getJob(), type.KASIKOSADEF);
		                    this.setHealth(this.getMaxHealth());
		                    this.setMP(this.getMaxMP());
		                    //System.out.println("TEST2");
		                    //this.func_110226_cD();
		                    this.setPathToEntity((PathEntity)null);
		                    this.setAttackTarget((EntityLivingBase)null);
		                    this.tasks.addTask(2, this.aiSit);
		                    this.aiSit.setSitting(true);
		                    //this.setHealth(20.0F);
		                    this.func_152115_b(ep.getUniqueID().toString());
		                    this.playTameEffect(true);
		                    this.worldObj.playSoundAtEntity(this, "dqr:player.pet", 1.0F, 1.0F);
		                    this.worldObj.setEntityState(this, (byte)7);
		                    ExtendedPlayerProperties3.get(ep).plusPetCount(1);
		                    DQR.petFunc.setNewPetdata(this);
		                    //this.aiSit.setSitting(true);
		                    //System.out.println("TEST3" + this.isSitting());
	                	}else
	                	{
	            	  		ep.addChatMessage(new ChatComponentTranslation("msg.petTame.maxnumber.txt",new Object[] {}));
	                		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	                	}
	                }
	                else
	                {
	                    this.playTameEffect(false);
	                    this.worldObj.setEntityState(this, (byte)6);
	                }
	            }
        	}

            return true;
        }

        return super.interact(ep);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);

        //System.out.println("TEST3" + this.getHealth());
        if (this.isTamed())
        {
            //this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        	//System.out.println("DAAAA:" + this.getMaxHP() + " / " + this.getMaxHealth());
        	//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
        	if(this.getMaxHP() < type.HPDEF)
        	{
        		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(type.HPDEF);
        		this.setMaxHP(type.HPDEF);
        	}else
        	{
        		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
        	}
        	this.setHealth(this.getMaxHP());
        }
        else
        {
            //this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        	if(this.getMaxHP() > 0)
        	{
        		//System.out.println("EAAAA:" + this.getMaxHP() + " / " + this.getMaxHealth());
        		//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
            	if(this.getMaxHP() < type.HPDEF)
            	{
            		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(type.HPDEF);
            		this.setMaxHP(type.HPDEF);
            	}else
            	{
            		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
            	}
            	this.setHealth(this.getMaxHP());
        	}else
        	{
        		//System.out.println("FAAAA:" + this.getMaxHP() + " / " + this.getMaxHealth());
        		if(this.getMaxHealth() > 0)
        		{
        			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHealth());
        		}else
        		{
        			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        		}
        	}
        	//System.out.println("TEST");
        }
        //System.out.println("TEST4" + this.getHealth());
    }

    public boolean isBreedingItem(ItemStack p_70877_1_)
    {
        return p_70877_1_ == null ? false : (!(p_70877_1_.getItem() instanceof ItemFood) ? false : ((ItemFood)p_70877_1_.getItem()).isWolfsFavoriteMeat());
    }

    public int getMaxSpawnedInChunk()
    {
        return 0;
    }


    public void func_70918_i(boolean p_70918_1_)
    {
    	/*
        if (p_70918_1_)
        {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
        }
        else
        {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
        }
        */
    }


    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal p_70878_1_)
    {
        if (p_70878_1_ == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(p_70878_1_ instanceof EntityWolf))
        {
            return false;
        }
        else
        {
            EntityWolf entitywolf = (EntityWolf)p_70878_1_;
            return !entitywolf.isTamed() ? false : (entitywolf.isSitting() ? false : this.isInLove() && entitywolf.isInLove());
        }
    }

    public boolean func_70922_bv()
    {
    	return true;
        //return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }


    protected boolean canDespawn()
    {
    	boolean flg = false;

    	if(!this.isTamed())
    	{
    		flg = this.ticksExisted > 1200 || this.getHealth() <= 0;
    	}

        return flg;
    }

    public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_)
    {
        if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast))
        {
            if (p_142018_1_ instanceof EntityWolf)
            {
                EntityWolf entitywolf = (EntityWolf)p_142018_1_;

                if (entitywolf.isTamed() && entitywolf.getOwner() == p_142018_2_)
                {
                    return false;
                }
            }

            return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer)p_142018_2_).canAttackPlayer((EntityPlayer)p_142018_1_) ? false : !(p_142018_1_ instanceof EntityHorse) || !((EntityHorse)p_142018_1_).isTame();
        }
        else
        {
            return false;
        }
    }

    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        //super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger("Job", this.Job);
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("JobLv_" + cnt, JobLv[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("JobExp_" + cnt, JobExp[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("JobSp_" + cnt, JobSp[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setFloat("JobHP_" + cnt, JobHP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("JobMP_" + cnt, JobMP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setFloat("JobTikara_" + cnt, JobTikara[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setFloat("JobKasikosa_" + cnt, JobKasikosa[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setFloat("arrayHP_" + cnt, arrayHP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arrayMP_" + cnt, arrayMP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arrayATK_" + cnt, arrayATK[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arrayMAG_" + cnt, arrayMAG[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arrayDEF_" + cnt, arrayDEF[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arrayTikara_" + cnt, arrayTikara[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arrayMamori_" + cnt, arrayMamori[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arraySubayasa_" + cnt, arraySubayasa[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arrayKasikosa_" + cnt, arrayKasikosa[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	p_70014_1_.setInteger("JukurenLv_" + cnt, JukurenLv[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	p_70014_1_.setInteger("JukurenExp_" + cnt, JukurenExp[cnt]);
        }


        p_70014_1_.setInteger("Kougeki", this.Kougeki);
        p_70014_1_.setInteger("Bougyo", this.Bougyo);
        p_70014_1_.setInteger("Maryoku", this.Maryoku);

        p_70014_1_.setInteger("Tikara", this.Tikara);
        p_70014_1_.setInteger("Mikawasi", this.Mikawasi);
        p_70014_1_.setInteger("Kasikosa", this.Kasikosa);

        p_70014_1_.setInteger("Kaisinritu", this.Kaisinritu);
        p_70014_1_.setInteger("KaisinMin", this.KaisinMin);
        p_70014_1_.setInteger("KaisinMax", this.KaisinMax);

        p_70014_1_.setInteger("Gold", this.Gold);
        p_70014_1_.setInteger("Medal", this.Medal);
        p_70014_1_.setInteger("Coin", this.Coin);
        p_70014_1_.setInteger("KillCount", this.KillCount);
        p_70014_1_.setInteger("DeathCount", this.DeathCount);

        //p_70014_1_.setFloat("HP", this.HP);
        p_70014_1_.setFloat("HP", this.HP);
        p_70014_1_.setFloat("MaxHP", this.MaxHP);
        p_70014_1_.setInteger("MP", this.MP);
        p_70014_1_.setInteger("MaxMP", this.MaxMP);

        p_70014_1_.setInteger("weapon", this.weapon);

        for(int cnt = 0; cnt < 4; cnt++)
        {
        	p_70014_1_.setDouble("rarihoLoc_" + cnt, rarihoLoc[cnt]);
        }



        //チェスト
        /*
        if (this.isChested())
        {
            NBTTagList nbttaglist = new NBTTagList();

            for (int i = 2; i < this.horseChest.getSizeInventory(); ++i)
            {
                ItemStack itemstack = this.horseChest.getStackInSlot(i);

                if (itemstack != null)
                {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                    nbttagcompound1.setByte("Slot", (byte)i);
                    itemstack.writeToNBT(nbttagcompound1);
                    nbttaglist.appendTag(nbttagcompound1);
                }
            }

            p_70014_1_.setTag("Items", nbttaglist);
        }

        if (this.horseChest.getStackInSlot(1) != null)
        {
            p_70014_1_.setTag("ArmorItem", this.horseChest.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
        }

        if (this.horseChest.getStackInSlot(0) != null)
        {
            p_70014_1_.setTag("SaddleItem", this.horseChest.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
        }
        */

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

        p_70014_1_.setBoolean("Sitting", this.isSitting());
        p_70014_1_.setBoolean("isTamed", this.isTamed());






        if(chestOn)
        {
        	NBTTagCompound itemNBT = new NBTTagCompound();
        	if(this.sampleItemStack == null)
        	{
                this.sampleItemStack = new ItemStack(Items.wooden_sword, 1);
                this.sampleItemStack.setTagCompound(new NBTTagCompound());
                this.sampleItemStack.getTagCompound().setTag("Items", new NBTTagList());

        	}
        	this.sampleItemStack.writeToNBT(itemNBT);
        	p_70014_1_.setTag("sampleItemStack", itemNBT);
            /*
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 2; i < this.petChest.getSizeInventory(); ++i)
	        {
	            ItemStack itemstack = this.petChest.getStackInSlot(i);

	            if (itemstack != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                itemstack.writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }

	        p_70014_1_.setTag("Items", nbttaglist);
	        */
        }

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

    public String func_152113_b()
    {
        return this.dataWatcher.getWatchableObjectString(17);
    }

    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        //super.readEntityFromNBT(p_70037_1_);

        this.Job = p_70037_1_.getInteger("Job");
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobLv[cnt] = p_70037_1_.getInteger("JobLv_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobExp[cnt] = p_70037_1_.getInteger("JobExp_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobSp[cnt] = p_70037_1_.getInteger("JobSp_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobHP[cnt] = p_70037_1_.getInteger("JobHP_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobMP[cnt] = p_70037_1_.getInteger("JobMP_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobTikara[cnt] = p_70037_1_.getInteger("JobTikara_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	JobKasikosa[cnt] = p_70037_1_.getInteger("JobKasikosa_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayHP[cnt] = p_70037_1_.getFloat("arrayHP_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayMP[cnt] = p_70037_1_.getInteger("arrayMP_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayATK[cnt] = p_70037_1_.getInteger("arrayATK_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayMAG[cnt] = p_70037_1_.getInteger("arrayMAG_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayDEF[cnt] = p_70037_1_.getInteger("arrayDEF_" + cnt);
        }



        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayTikara[cnt] = p_70037_1_.getInteger("arrayTikara_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayMamori[cnt] = p_70037_1_.getInteger("arrayMamori_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arraySubayasa[cnt] = p_70037_1_.getInteger("arraySubayasa_" + cnt);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayKasikosa[cnt] = p_70037_1_.getInteger("arrayKasikosa_" + cnt);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	JukurenLv[cnt] = p_70037_1_.getInteger("JukurenLv_" + cnt);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	JukurenExp[cnt] = p_70037_1_.getInteger("JukurenExp_" + cnt);
        }

        this.Kougeki = p_70037_1_.getInteger("Kougeki");
        this.Bougyo = p_70037_1_.getInteger("Bougyo");
        this.Maryoku = p_70037_1_.getInteger("Maryoku");

        this.Tikara = p_70037_1_.getInteger("Tikara");
        this.Mikawasi = p_70037_1_.getInteger("Mikawasi");
        this.Kasikosa = p_70037_1_.getInteger("Kasikosa");

        this.Kaisinritu = p_70037_1_.getInteger("Kaisinritu");
        this.KaisinMin = p_70037_1_.getInteger("KaisinMin");
        this.KaisinMax = p_70037_1_.getInteger("KaisinMax");

        this.Gold = p_70037_1_.getInteger("Gold");
        this.Medal = p_70037_1_.getInteger("Medal");
        this.Coin = p_70037_1_.getInteger("Coin");
        this.KillCount = p_70037_1_.getInteger("KillCount");
        this.DeathCount = p_70037_1_.getInteger("DeathCount");

        this.HP = p_70037_1_.getFloat("HP");
        this.setHealth(this.HP);
        this.MaxHP = p_70037_1_.getFloat("MaxHP");
        this.MP = p_70037_1_.getInteger("MP");
        this.MaxMP = p_70037_1_.getInteger("MaxMP");
        this.weapon = p_70037_1_.getInteger("weapon");

        for(int cnt = 0; cnt < 4; cnt++)
        {
        	rarihoLoc[cnt] = p_70037_1_.getDouble("rarihoLoc_" + cnt);
        }

        //super.readEntityFromNBT(p_70037_1_);
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
            this.setTamed(true);
        }

        this.aiSit.setSitting(p_70037_1_.getBoolean("Sitting"));
        //this.setSitting(p_70037_1_.getBoolean("Sitting"));
        this.setTamed(p_70037_1_.getBoolean("isTamed"));



        if(chestOn)
        {
        	this.sampleItemStack = ItemStack.loadItemStackFromNBT(p_70037_1_.getCompoundTag("sampleItemStack"));
        	/*
	        NBTTagList nbttaglist = p_70037_1_.getTagList("Items", 10);
	        this.initPetChest();

	        for (int i = 0; i < nbttaglist.tagCount(); ++i)
	        {
	            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	            int j = nbttagcompound1.getByte("Slot") & 255;

	            if (j >= 2 && j < this.petChest.getSizeInventory())
	            {
	                this.petChest.setInventorySlotContents(j, ItemStack.loadItemStackFromNBT(nbttagcompound1));
	            }
	        }
	        */
        }

    }

    public boolean isChested()
    {
    	return this.isChested;
    }

    public int func_110225_cC()
    {
    	return 17;
    }

    /*
    private void func_110226_cD()
    {
        AnimalChest animalchest = this.horseChest;
        this.horseChest = new AnimalChest("HorseChest", this.func_110225_cC());
        this.horseChest.func_110133_a(this.getCommandSenderName());

        if (animalchest != null)
        {
            animalchest.func_110132_b(this);
            int i = Math.min(animalchest.getSizeInventory(), this.horseChest.getSizeInventory());

            for (int j = 0; j < i; ++j)
            {
                ItemStack itemstack = animalchest.getStackInSlot(j);

                if (itemstack != null)
                {
                    this.horseChest.setInventorySlotContents(j, itemstack.copy());
                }
            }

            animalchest = null;
        }

        this.horseChest.func_110134_a(this);
        this.func_110232_cE();
    }

	private void func_110232_cE()
	{

	    if (!this.worldObj.isRemote)
	    {
	        this.setHorseSaddled(this.horseChest.getStackInSlot(0) != null);

	        if (this.func_110259_cr())
	        {
	            this.func_146086_d(this.horseChest.getStackInSlot(1));
	        }
	    }
	}

    public void setHorseSaddled(boolean p_110251_1_)
    {
        this.setHorseWatchableBoolean(4, p_110251_1_);
    }

    private void setHorseWatchableBoolean(int p_110208_1_, boolean p_110208_2_)
    {
        int j = this.dataWatcher.getWatchableObjectInt(16);

        if (p_110208_2_)
        {
            this.dataWatcher.updateObject(16, Integer.valueOf(j | p_110208_1_));
        }
        else
        {
            this.dataWatcher.updateObject(16, Integer.valueOf(j & ~p_110208_1_));
        }

    }
    */

    public boolean func_110259_cr()
    {
        //return this.getHorseType() == 0;
    	return true;
    }

    public void func_146086_d(ItemStack p_146086_1_)
    {
        //this.dataWatcher.updateObject(22, Integer.valueOf(this.getHorseArmorIndex(p_146086_1_)));
        this.func_110230_cF();
    }

    private void func_110230_cF()
    {
        this.field_110286_bQ = null;
    }

    private int getHorseArmorIndex(ItemStack p_110260_1_)
    {
    	return 0;
    	/*
        if (p_110260_1_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_110260_1_.getItem();
            return item == Items.iron_horse_armor ? 1 : (item == Items.golden_horse_armor ? 2 : (item == Items.diamond_horse_armor ? 3 : 0));
        }
        */
    }

    /*
    public void openGUI(EntityPlayer p_110199_1_)
    {
        if (!this.worldObj.isRemote)
        {
        	//System.out.println("TEST2");
            this.horseChest.func_110133_a(this.getCommandSenderName());
            p_110199_1_.displayGUIHorse(new EntityHorse(p_110199_1_.worldObj), this.horseChest);
        }
    }

    public void setChested(boolean p_110207_1_)
    {
        this.setHorseWatchableBoolean(8, p_110207_1_);
    }
    */

    @Override
    public void setDead()
    {
    	EntityPlayer ep = null;
    	if(DQR.partyManager.hasParty(this))
    	{
    		DQR.partyManager.removePartyMember(this);
    	}

    	if(this != null && this.worldObj != null && this.getOwner() != null)
    	{
    		ep = this.worldObj.func_152378_a(this.getOwner().getUniqueID());
    	}

    	if(ep != null)
    	{
    		ExtendedPlayerProperties3.get(ep).minusPetCount(1);
        	DQR.petFunc.removePetdata(ep, this.getUniqueID().toString());
    	}

    	this.isDead = true;
    }




    /*パラメータ設定*/
    public int getJob() {
        return Job;
    }
    public void setJob(int par1) {
        this.Job = par1;
    }

    public int[] getJobLvA() {
    	if(JobLv == null) JobLv = new int[32];
        return JobLv;
    }
    public void setJobLvA(int[] par1) {
    	if(JobLv == null) JobLv = new int[32];
        this.JobLv = par1;
    }
    public int getJobLv(int par1) {
    	if(JobLv == null) JobLv = new int[32];
        return JobLv[par1];
    }
    public void setJobLv(int par1, int par2) {
    	if(JobLv == null) JobLv = new int[32];
        this.JobLv[par1] = par2;
    }

    public int[] getJobExpA() {
    	if(JobExp == null) JobExp = new int[32];
        return JobExp;
    }
    public void setJobExpA(int[] par1) {
    	if(JobExp == null) JobExp = new int[32];
        this.JobExp = par1;
    }
    public int getJobExp(int par1) {
    	if(JobExp == null) JobExp = new int[32];
        return JobExp[par1];
    }
    public void setJobExp(int par1, int par2) {
    	if(JobExp == null) JobExp = new int[32];
        this.JobExp[par1] = par2;
    }

    public int[] getJobSpA() {
    	if(JobSp == null) JobSp = new int[32];
        return JobSp;
    }
    public void setJobSpA(int[] par1) {
    	if(JobSp == null) JobSp = new int[32];
        this.JobSp = par1;
    }
    public int getJobSp(int par1) {
    	if(JobSp == null) JobSp = new int[32];
        return JobSp[par1];
    }
    public void setJobSp(int par1, int par2) {
    	if(JobSp == null) JobSp = new int[32];
        this.JobSp[par1] = par2;
    }

    public float[] getJobHPA() {
    	if(JobHP == null) JobHP = new float[32];
        return JobHP;
    }
    public void setJobHPA(float[] par1) {
    	if(JobHP == null) JobHP = new float[32];
        this.JobHP = par1;
    }
    public float getJobHP(int par1) {
    	if(JobHP == null) JobHP = new float[32];
        return JobHP[par1];
    }
    public void setJobHP(int par1, float par2) {
    	if(JobHP == null) JobHP = new float[32];
        this.JobHP[par1] = par2;
    }

    public int[] getJobTikaraA() {
    	if(JobTikara == null) JobTikara = new int[32];
        return JobTikara;
    }
    public void setJobTikaraA(int[] par1) {
    	if(JobTikara == null) JobTikara = new int[32];
        this.JobTikara = par1;
    }
    public int getJobTikara(int par1) {
    	if(JobTikara == null) JobTikara = new int[32];
        return JobTikara[par1];
    }
    public void setJobTikara(int par1, int par2) {
    	if(JobTikara == null) JobTikara = new int[32];
        this.JobTikara[par1] = par2;
    }

    public int[] getJobKasikosaA() {
    	if(JobKasikosa == null) JobKasikosa = new int[32];
        return JobKasikosa;
    }
    public void setJobKasikosaA(int[] par1) {
    	if(JobKasikosa == null) JobKasikosa = new int[32];
        this.JobKasikosa = par1;
    }
    public int getJobKasikosa(int par1) {
    	if(JobKasikosa == null) JobKasikosa = new int[32];
        return JobKasikosa[par1];
    }
    public void setJobKasikosa(int par1, int par2) {
    	if(JobKasikosa == null) JobKasikosa = new int[32];
        this.JobKasikosa[par1] = par2;
    }

    public float[] getArrayHPA() {
    	if(arrayHP == null) arrayHP = new float[32];
        return arrayHP;
    }
    public void setArrayHPA(float[] par1) {
    	if(arrayHP == null) arrayHP = new float[32];
        this.arrayHP = par1;
    }
    public float getArrayHP(int par1) {
    	if(arrayHP == null) arrayHP = new float[32];
        return arrayHP[par1];
    }
    public void setArrayHP(int par1, float par2) {
    	if(arrayHP == null) arrayHP = new float[32];
        this.arrayHP[par1] = par2;
    }

    public int[] getArrayMPA() {
    	if(arrayMP == null) arrayMP = new int[32];
        return arrayMP;
    }
    public void setArrayMPA(int[] par1) {
    	if(arrayMP == null) arrayMP = new int[32];
        this.arrayMP = par1;
    }
    public int getArrayMP(int par1) {
    	if(arrayMP == null) arrayMP = new int[32];
        return arrayMP[par1];
    }
    public void setArrayMP(int par1, int par2) {
    	if(arrayMP == null) arrayMP = new int[32];
        this.arrayMP[par1] = par2;
    }

    public int[] getArrayATKA() {
    	if(arrayATK == null) arrayATK = new int[32];
        return arrayATK;
    }
    public void setArrayATKA(int[] par1) {
    	if(arrayATK == null) arrayATK = new int[32];
        this.arrayATK = par1;
    }
    public int getArrayATK(int par1) {
    	if(arrayATK == null) arrayATK = new int[32];
        return arrayATK[par1];
    }
    public void setArrayATK(int par1, int par2) {
    	if(arrayATK == null) arrayATK = new int[32];
        this.arrayATK[par1] = par2;
    }

    public int[] getArrayMAGA() {
    	if(arrayMAG == null) arrayMAG = new int[32];
        return arrayMAG;
    }
    public void setArrayMAGA(int[] par1) {
    	if(arrayMAG == null) arrayMAG = new int[32];
        this.arrayMAG = par1;
    }
    public int getArrayMAG(int par1) {
    	if(arrayMAG == null) arrayMAG = new int[32];
        return arrayMAG[par1];
    }
    public void setArrayMAG(int par1, int par2) {
    	if(arrayMAG == null) arrayMAG = new int[32];
        this.arrayMAG[par1] = par2;
    }

    public int[] getArrayDEFA() {
    	if(arrayDEF == null) arrayDEF = new int[32];
        return arrayDEF;
    }
    public void setArrayDEFA(int[] par1) {
    	if(arrayDEF == null) arrayDEF = new int[32];
        this.arrayDEF = par1;
    }
    public int getArrayDEF(int par1) {
    	if(arrayDEF == null) arrayDEF = new int[32];
        return arrayDEF[par1];
    }
    public void setArrayDEF(int par1, int par2) {
    	if(arrayDEF == null) arrayDEF = new int[32];
        this.arrayDEF[par1] = par2;
    }

    public int[] getArrayTikaraA() {
    	if(arrayTikara == null) arrayTikara = new int[32];
        return arrayTikara;
    }
    public void setArrayTikaraA(int[] par1) {
    	if(arrayTikara == null) arrayTikara = new int[32];
        this.arrayTikara = par1;
    }
    public int getArrayTikara(int par1) {
    	if(arrayTikara == null) arrayTikara = new int[32];
        return arrayTikara[par1];
    }
    public void setArrayTikara(int par1, int par2) {
    	if(arrayTikara == null) arrayTikara = new int[32];
        this.arrayTikara[par1] = par2;
    }

    public int[] getArrayMamoriA() {
    	if(arrayMamori == null) arrayMamori = new int[32];
        return arrayMamori;
    }
    public void setArrayMamoriA(int[] par1) {
    	if(arrayMamori == null) arrayMamori = new int[32];
        this.arrayMamori = par1;
    }
    public int getArrayMamori(int par1) {
    	if(arrayMamori == null) arrayMamori = new int[32];
        return arrayMamori[par1];
    }
    public void setArrayMamori(int par1, int par2) {
    	if(arrayMamori == null) arrayMamori = new int[32];
        this.arrayMamori[par1] = par2;
    }

    public int[] getArraySubayasaA() {
    	if(arraySubayasa == null) arraySubayasa = new int[21];
        return arraySubayasa;
    }
    public void setArraySubayasaA(int[] par1) {
    	if(arraySubayasa == null) arraySubayasa = new int[21];
        this.arraySubayasa = par1;
    }
    public int getArraySubayasa(int par1) {
    	if(arraySubayasa == null) arraySubayasa = new int[21];
        return arraySubayasa[par1];
    }
    public void setArraySubayasa(int par1, int par2) {
    	if(arraySubayasa == null) arraySubayasa = new int[32];
        this.arraySubayasa[par1] = par2;
    }

    public int[] getArrayKasikosaA() {
    	if(arrayKasikosa == null) arrayKasikosa = new int[21];
        return arrayKasikosa;
    }
    public void setArrayKasikosaA(int[] par1) {
    	if(arrayKasikosa == null) arrayKasikosa = new int[21];
        this.arrayKasikosa = par1;
    }
    public int getArrayKasikosa(int par1) {
    	if(arrayKasikosa == null) arrayKasikosa = new int[32];
        return arrayKasikosa[par1];
    }
    public void setArrayKasikosa(int par1, int par2) {
    	if(arrayKasikosa == null) arrayKasikosa = new int[32];
        this.arrayKasikosa[par1] = par2;
    }

    public int[] getJobMPA() {
    	if(JobMP == null) JobMP = new int[32];
        return JobMP;
    }
    public void setJobMPA(int[] par1) {
    	if(JobMP == null) JobMP = new int[32];
        this.JobMP = par1;
    }
    public int getJobMP(int par1) {
    	if(JobMP == null) JobMP = new int[32];
        return JobMP[par1];
    }
    public void setJobMP(int par1, int par2) {
    	if(JobMP == null) JobMP = new int[32];
        this.JobMP[par1] = par2;
    }

    public int[] getJukurenLvA() {
    	if(JukurenLv == null) JukurenLv = new int[64];
        return JukurenLv;
    }
    public void setJukurenLvA(int[] par1) {
    	if(JukurenLv == null) JukurenLv = new int[64];
        this.JukurenLv = par1;
    }
    public int getJukurenLv(int par1) {
    	if(JukurenLv == null) JukurenLv = new int[64];
        return JukurenLv[par1];
    }
    public void setJukurenLv(int par1, int par2) {
    	if(JukurenLv == null) JukurenLv = new int[64];
        this.JukurenLv[par1] = par2;
    }

    public int[] getJukurenExpA() {
    	if(JukurenExp == null) JukurenExp = new int[64];
        return JukurenExp;
    }
    public void setJukurenExpA(int[] par1) {
    	if(JukurenExp == null) JukurenExp = new int[64];
        this.JukurenExp = par1;
    }
    public int getJukurenExp(int par1) {
    	if(JukurenExp == null) JukurenExp = new int[64];
        return JukurenExp[par1];
    }
    public void setJukurenExp(int par1, int par2) {
    	if(JukurenExp == null) JukurenExp = new int[64];
        this.JukurenExp[par1] = par2;
    }

    public int getKougeki() {
        return Kougeki;
    }
    public void setKougeki(int par1) {
        this.Kougeki = par1;
    }

    public int getBougyo() {
        return Bougyo;
    }
    public void setBougyo(int par1) {
        this.Bougyo = par1;
    }

    public int getMaryoku() {
        return Maryoku;
    }
    public void setMaryoku(int par1) {
        this.Maryoku = par1;
    }

    public int getTikara() {
        return Tikara;
    }
    public void setTikara(int par1) {
        this.Tikara = par1;
    }

    public int getMikawasi() {
        return Mikawasi;
    }
    public void setMikawasi(int par1) {
        this.Mikawasi = par1;
    }

    public int getKasikosa() {
        return Kasikosa;
    }
    public void setKasikosa(int par1) {
        this.Kasikosa = par1;
    }

    public int getKaisinMin() {
        return KaisinMin;
    }
    public void setKaisinMin(int par1) {
        this.KaisinMin = par1;
    }

    public int getKaisinMax() {
        return KaisinMax;
    }
    public void setKaisinMax(int par1) {
        this.KaisinMax = par1;
    }

    public int getKaisinritu() {
        return Kaisinritu;
    }
    public void setKaisinritu(int par1) {
        this.Kaisinritu = par1;
    }

    public int getGold() {
        return Gold;
    }
    public void setGold(int par1) {
        this.Gold = par1;
    }

    public int getMedal() {
        return Medal;
    }
    public void setMedal(int par1) {
        this.Medal = par1;
    }

    public int getCoin() {
        return Coin;
    }
    public void setCoin(int par1) {
        this.Coin = par1;
    }

    public int getKillCount() {
        return KillCount;
    }
    public void setKillCount(int par1) {
        this.KillCount = par1;
    }

    public int getDeathCount() {
        return DeathCount;
    }
    public void setDeathCount(int par1) {
        this.DeathCount = par1;
    }

    public float getHP() {
        return HP;
    }
    public void setHP(float par1) {
        this.HP = par1;
    }

    public float getMaxHP() {
        return MaxHP;
    }
    public void setMaxHP(float f) {
        this.MaxHP = f;
    }

    public int getMP() {
        return MP;
    }
    public void setMP(int par1) {
        this.MP = par1;
    }

    public int getMaxMP() {
        return MaxMP;
    }
    public void setMaxMP(int par1) {
        this.MaxMP = par1;
    }

    public int getWeapon() {
        return weapon;
    }
    public void setWeapon(int par1) {
        this.weapon = par1;
    }

    public boolean getOnLevelThread() {
        return onLevelThread;
    }
    public void setOnLevelThread(boolean par1) {
        this.onLevelThread = par1;
    }

    public double[] getRarihoLoc() {
        return rarihoLoc;
    }
    public void setRarihoLoc(double[] par1) {
        this.rarihoLoc = par1;
    }

    private NBTTagCompound makeTutuNBT(NBTTagCompound tag1)
    {
    	NBTTagCompound nbt = tag1;

    	if(nbt == null)
    	{
    		nbt = new NBTTagCompound();
    	}

        nbt.setInteger("Job", this.Job);
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("JobLv_" + cnt, JobLv[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("JobExp_" + cnt, JobExp[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("JobSp_" + cnt, JobSp[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setFloat("JobHP_" + cnt, JobHP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("JobMP_" + cnt, JobMP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setFloat("JobTikara_" + cnt, JobTikara[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setFloat("JobKasikosa_" + cnt, JobKasikosa[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setFloat("arrayHP_" + cnt, arrayHP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayMP_" + cnt, arrayMP[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayATK_" + cnt, arrayATK[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayMAG_" + cnt, arrayMAG[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayDEF_" + cnt, arrayDEF[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayTikara_" + cnt, arrayTikara[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayMamori_" + cnt, arrayMamori[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arraySubayasa_" + cnt, arraySubayasa[cnt]);
        }

        for(int cnt = 0; cnt < 32; cnt++)
        {
        	nbt.setInteger("arrayKasikosa_" + cnt, arrayKasikosa[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("JukurenLv_" + cnt, JukurenLv[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("JukurenExp_" + cnt, JukurenExp[cnt]);
        }


        nbt.setInteger("Kougeki", this.Kougeki);
        nbt.setInteger("Bougyo", this.Bougyo);
        nbt.setInteger("Maryoku", this.Maryoku);

        nbt.setInteger("Tikara", this.Tikara);
        nbt.setInteger("Mikawasi", this.Mikawasi);
        nbt.setInteger("Kasikosa", this.Kasikosa);

        nbt.setInteger("Kaisinritu", this.Kaisinritu);
        nbt.setInteger("KaisinMin", this.KaisinMin);
        nbt.setInteger("KaisinMax", this.KaisinMax);

        nbt.setInteger("Gold", this.Gold);
        nbt.setInteger("Medal", this.Medal);
        nbt.setInteger("Coin", this.Coin);
        nbt.setInteger("KillCount", this.KillCount);
        nbt.setInteger("DeathCount", this.DeathCount);

        //nbt.setFloat("HP", this.HP);
        nbt.setFloat("HP", this.HP);
        nbt.setFloat("MaxHP", this.MaxHP);
        nbt.setInteger("MP", this.MP);
        nbt.setInteger("MaxMP", this.MaxMP);

        nbt.setInteger("weapon", this.weapon);

        for(int cnt = 0; cnt < 4; cnt++)
        {
        	nbt.setDouble("rarihoLoc_" + cnt, rarihoLoc[cnt]);
        }

        if (this.func_152113_b() == null)
        {
            nbt.setString("OwnerUUID", "");
        }
        else
        {
            nbt.setString("OwnerUUID", this.func_152113_b());
        }

        if(ownerName != null)
        {
        	nbt.setString("OwnerName", this.ownerName);
        }

        nbt.setBoolean("Sitting", this.isSitting());
        nbt.setBoolean("isTamed", this.isTamed());

        nbt.setBoolean("isTamed", this.isTamed());

        nbt.setString("PetBaseName", this.getEntityString());
        nbt.setString("PetName", this.getCommandSenderName());
        //System.out.println("Name1" + this.getEntityString());

        nbt.setString("PetMobName", this.type.getPetname());
        /*
        if(chestOn)
        {
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 2; i < this.petChest.getSizeInventory(); ++i)
	        {
	            ItemStack itemstack = this.petChest.getStackInSlot(i);

	            if (itemstack != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                itemstack.writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }

	        nbt.setTag("Items", nbttaglist);
        }
        */

        if(chestOn)
        {
        	NBTTagCompound itemNBT = new NBTTagCompound();
        	if(this.sampleItemStack == null)
        	{
                this.sampleItemStack = new ItemStack(Items.wooden_sword, 1);
                this.sampleItemStack.setTagCompound(new NBTTagCompound());
                this.sampleItemStack.getTagCompound().setTag("Items", new NBTTagList());
        	}

        	this.sampleItemStack.writeToNBT(itemNBT);
        	nbt.setTag("sampleItemStack", itemNBT);
            /*
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 2; i < this.petChest.getSizeInventory(); ++i)
	        {
	            ItemStack itemstack = this.petChest.getStackInSlot(i);

	            if (itemstack != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                itemstack.writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }

	        p_70014_1_.setTag("Items", nbttaglist);
	        */
        }

        return nbt;
    }

    public void setSit(boolean par1)
    {
    	this.aiSit.setSitting(par1);
    }

    public void setMetamiExp(DqmItemMegaminoInori par1Item)
    {
    	int getExpVal = 0;

    	if(!this.worldObj.isRemote)
    	{
	        getExpVal = getExpVal + par1Item.getItemExp() + this.getJobExp(this.getJob());
	        //DQR.func.debugString("doExp5:" + getExpVal);
	        this.setJobExp(this.getJob(), getExpVal);
	        //ThreadLvUpPet lvup = new ThreadLvUpPet(this);
	        //lvup.start();
	        if(DQR.conf.cfg_NoThreadUse == 1)
	        {
	            ThreadLvUpPet lvup = new ThreadLvUpPet(this);
	            lvup.start();
	        }else
	        {
	        	NoThreadProcess proc = new NoThreadProcess();
	        	proc.doLevelUpPet(this);
	        }
    	}
    }

    /*
    private void initPetChest()
    {
        DqmPetChest animalchest = this.petChest;
        this.petChest = new DqmPetChest("PetChest", 21);
        this.petChest.func_110133_a(this.getCommandSenderName());

        if (animalchest != null)
        {
            animalchest.func_110132_b(this);
            int i = Math.min(animalchest.getSizeInventory(), this.petChest.getSizeInventory());

            for (int j = 0; j < i; ++j)
            {
                ItemStack itemstack = animalchest.getStackInSlot(j);

                if (itemstack != null)
                {
                    this.petChest.setInventorySlotContents(j, itemstack.copy());
                }
            }

            animalchest = null;
        }

        this.petChest.func_110134_a(this);
        //this.func_110232_cE();
    }
	*/

    public ItemStack getChestItem()
    {
    	return this.sampleItemStack;
    }

    public void setChestItem(ItemStack par1)
    {
    	this.sampleItemStack = par1;
    }
}
