package dqr.entity.petEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
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
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import dqr.DQR;
import dqr.DqrWorldData;
import dqr.PacketHandler;
import dqr.api.Items.DQMagics;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQSeeds;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmMessageConv;
import dqr.api.enums.EnumDqmMobAI;
import dqr.api.enums.EnumDqmMonster;
import dqr.api.enums.EnumDqmMonsterAI;
import dqr.api.enums.EnumDqmMonsterAIrate;
import dqr.api.enums.EnumDqmPet;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityArrow;
import dqr.entity.magicEntity.magic.MagicEntityBagi;
import dqr.entity.magicEntity.magic.MagicEntityBegiragon;
import dqr.entity.magicEntity.magic.MagicEntityBegirama;
import dqr.entity.magicEntity.magic.MagicEntityDebuff;
import dqr.entity.magicEntity.magic.MagicEntityDoruma;
import dqr.entity.magicEntity.magic.MagicEntityGira;
import dqr.entity.magicEntity.magic.MagicEntityGiragureido;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.entity.magicEntity.magic.MagicEntityHyadoB;
import dqr.entity.magicEntity.magic.MagicEntityIo;
import dqr.entity.magicEntity.magic.MagicEntityMera;
import dqr.entity.magicEntity.magic.MagicEntityMeraB;
import dqr.entity.magicEntity.magic.MagicEntityMeragaia;
import dqr.entity.magicEntity.magic.MagicEntityMeragaiaB;
import dqr.entity.magicEntity.magic.MagicEntityMerami;
import dqr.entity.magicEntity.magic.MagicEntityMeramiB;
import dqr.entity.magicEntity.magic.MagicEntityMerazoma;
import dqr.entity.magicEntity.magic.MagicEntityMerazomaB;
import dqr.entity.magicEntity.magic.MagicEntityRaidein;
import dqr.entity.magicEntity.magic.MagicEntityZaki;
import dqr.entity.magicEntity.magicDummy.MagicEntityBuffDummy;
import dqr.entity.magicEntity.magicDummy.MagicEntityHoimiDummy;
import dqr.entity.magicEntity.magicDummy.MagicEntityMahoimiDummy;
import dqr.entity.petEntity.ai.EntityAIDeath;
import dqr.entity.petEntity.ai.EntityAISit2;
import dqr.entity.petEntity.ai.EntityPetAIArrowAttack2;
import dqr.entity.petEntity.ai.EntityPetAIAttackOnCollide2;
import dqr.entity.petEntity.ai.EntityPetAIAttackOnCollideJump;
import dqr.entity.petEntity.ai.EntityPetAIMagicAttack4;
import dqr.entity.petEntity.ai.EntityPetAIMagicBehomara;
import dqr.entity.petEntity.ai.EntityPetAIMagicBuff;
import dqr.entity.petEntity.ai.EntityPetAIMagicDebuff;
import dqr.entity.petEntity.ai.EntityPetAIMagicHoimi;
import dqr.entity.petEntity.ai.EntityPetAIMagicMahoimi;
import dqr.entity.petEntity.ai.EntityPetAIMagicMegante;
import dqr.items.base.DqmItemFoodMiscBase;
import dqr.items.base.DqmItemFoodSeedBase;
import dqr.items.base.DqmItemMagicBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.items.miscs.DqmItemMegaminoInori;
import dqr.items.miscs.DqmItemPetbook;
import dqr.packetMessage.MessageClientPetEntityData;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.ExtendedPlayerProperties6;
import dqr.thread.NoThreadProcess;
import dqr.thread.ThreadLvUpPet;

public class DqmPetBase  extends EntityTameable implements IInvBasic
{
	public boolean chestOn = true;
	private boolean enableAI = true;
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
    private int[] arrayMikawasi = new int[32];

    private int Kasikosa;

    private int Kaisinritu;
    private int KaisinMax = 4;
    private int KaisinMin = 2;
    private int[] arrayKaisinritu = new int[32];

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

	public long skillCoolTime = 0;
	public int skillCoolTimeMin = 10;
	public int skillCoolTimeMax = 15;
	public long skillCoolTimeHeal = 0;
	public int skillCoolTimeHealMin = 60;
	public int skillCoolTimeHealMax = 150;

	public boolean MeganteFlg = false;

	//AI関連パラメータ
	public float healUseLine = 50.0f; //回復AIで回復魔法を使うHP％
	public int meganteUseLine = 15; //回復AIで回復魔法を使うHP％
    private long tamingTime;
    private int[] arrayAILimit = new int[64];
    private int[] arrayAIMaster = new int[64];
    private int[] arrayAISets = new int[64];
    private int[] arrayAIRate = new int[64];
    private int[] arrayAIRateDef = new int[64];
    private int flgAIextended = 0;
    private int flgAIuse = 0;
    private int MeganteCnt = 0;
    protected EntityPetAIMagicMegante aiMegante = new EntityPetAIMagicMegante(this);

    private long petUniqueNumber = 0;

    private NBTTagCompound dqrPotionEffects =  new NBTTagCompound();

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
        //this.tasks.addTask(0, new EntityAISwimming(this));
        this.setHealth(10.0F);
        this.setTamed(false);

        if(this.getHealth() > 0.5F && this.isTamed() && !this.isSitting())
        {
        	this.setCombatTasks();
        }else
        {
        	this.tasks.addTask(2, this.aiSit);
        }
        this.tasks.addTask(0, new EntityAISwimming(this));
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
        return enableAI;
    }

    public void setAIEnabled(boolean par1)
    {
    	enableAI = par1;
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

    	this.tasks.addTask(0, new EntityAISwimming(this));
    	this.setAttackTarget((EntityLivingBase)null);
    	this.tasks.addTask(2, this.aiSit);
    }

    public void setCombatTasks()
    {
    	//this.tasks.addTask(1, new EntityPetAIMagicHoimi(this, EnumDqmMagic.Hoimi, null));
    	//System.out.println("戦闘モードに切り替えました");
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        //this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        //this.tasks.addTask(8, new EntityAIBeg(this, 8.0F));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));


    	if(DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.ARROW) > 0)
    	{
    		//System.out.println("ARROW");
    		this.tasks.addTask(2, new EntityPetAIArrowAttack2(this, 1.2D, this.arrayAIRate[EnumDqmMobAI.ARROW.getId()], this.arrayAISets[EnumDqmMobAI.ARROW.getId()], 20.0F));
    		//this.tasks.addTask(2, new EntityPetAIArrowAttack2(this, 1.2D, 20, 40, 20.0F));
    		//this.tasks.addTask(3, new EntityPetAIArrowAttack2(this, 1.0D, 20, 60, 15.0F));
    		//this.tasks.removeTask(new EntityPetAIAttackOnCollide2(this, EntityPlayer.class, 1.5D, true));
    	}else
    	{
    		//System.out.println("ARROW");
    		this.tasks.addTask(2, new EntityPetAIAttackOnCollide2(this, 1.5D, true));
    		//this.tasks.addTask(1, new EntityPetAIAttackOnCollide2(this, 1.5D, true));
    	}

        if(this.flgAIuse == 0)
        {
	        int param = -1;



	        //this.tasks.addTask(2, new EntityPetAIAttackOnCollide2(this, 1.5D, true));

	        param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.HONOO);
	    	if(param > 0)
			{
	    		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HONOO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hinoiki)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HONOO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Kaeniki)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HONOO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.HagesiiHonoo)); break;
	    			case 4:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HONOO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Syakunetu)); break;
	    			case 5:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HONOO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.RengokuHonoo)); break;
	    		}
			}

	    	param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.JUMP);
	        if (param > 0)
	        {
	        	this.tasks.addTask(2, new EntityPetAIAttackOnCollideJump(this, 1.5D, true));
	        }

	        param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.HUBUKI);
	    	if(param > 0)
			{
	    		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HUBUKI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Tumetaiiki)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HUBUKI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Koorinoiki)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HUBUKI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Kogoeruhubuki)); break;
	    			case 4:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HUBUKI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Kagayakuiki)); break;
	    			case 5:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HUBUKI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zettaireido)); break;
	    		}
			}

	    	param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.GIRA);
	    	if(param > 0)
			{
	    		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.GIRA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Gira)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.GIRA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Begirama)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.GIRA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Begiragon)); break;
	    			case 4:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.GIRA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Giragureido)); break;
	    		}
			}

	    	param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.MERA);
			if(param > 0)
			{
	    		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MERA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mera)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MERA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Merami)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MERA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Merazoma)); break;
	    			case 4:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MERA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Meragaia)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Mera(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mera));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.IO);
			if(param > 0)
			{
		   		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.IO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Io)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.IO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Iora)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.IO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Ionazun)); break;
	    			case 4:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.IO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Iogurande)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Io(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Io));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.RAIDEIN);
			if(param > 0)
			{
		   		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.RAIDEIN.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Raidein)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.RAIDEIN.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Gigadein)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.RAIDEIN.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Minadein)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Raidein(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Raidein));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.BAGI);
			if(param > 0)
			{
		   		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BAGI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagi)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BAGI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagima)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BAGI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagikurosu)); break;
	    			case 4:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BAGI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagimutyo)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Bagi(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Bagi));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.DORUMA);
			if(param > 0)
			{
		   		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.DORUMA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Doruma)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.DORUMA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Dorukuma)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.DORUMA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Dorumoa)); break;
	    			case 4:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.DORUMA.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Dorumadon)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Doruma(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Doruma));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.HYADO);
			if(param > 0)
			{
		   		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HYADO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hyado)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HYADO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hyadaruko)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HYADO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mahyado)); break;
	    			case 4:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HYADO.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mahyadodesu)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Hyado(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hyado));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.HOIMI);
			DQR.func.debugString("TEST1 : " + param, this.getClass());
			DQR.func.debugString("TEST2 : " + this.arrayAIRate[EnumDqmMobAI.HOIMI.getId()], this.getClass());
			if(param > 0)
			{
		   		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HOIMI.getId()], new EntityPetAIMagicHoimi(this, EnumDqmMagic.Hoimi, null)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HOIMI.getId()], new EntityPetAIMagicHoimi(this, EnumDqmMagic.Behoimi, null)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HOIMI.getId()], new EntityPetAIMagicHoimi(this, EnumDqmMagic.Behoma, null)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Hoimi(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Hoimi));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.ZAKI);
			if(param > 0)
			{
				//System.out.println("GetZaki");
		   		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.ZAKI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zaki)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.ZAKI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zaraki)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.ZAKI.getId()], new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zarakima)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Zaki(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Zaki));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.BAIKIRUTO);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BAIKIRUTO.getId()], new EntityPetAIMagicBuff(this, EnumDqmMagic.Baikiruto, DQPotionPlus.buffBaikiruto));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.SUKARA);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.SUKARA.getId()], new EntityPetAIMagicBuff(this, EnumDqmMagic.Sukara, DQPotionPlus.buffSukara));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.BAHA);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BAHA.getId()], new EntityPetAIMagicBuff(this, EnumDqmMagic.Baha, DQPotionPlus.buffBaha));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.PIORA);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.PIORA.getId()], new EntityPetAIMagicBuff(this, EnumDqmMagic.Piora, DQPotionPlus.buffPiora));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.MAGICBARIA);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MAGICBARIA.getId()], new EntityPetAIMagicBuff(this, EnumDqmMagic.Magicbaria, DQPotionPlus.buffMagicBaria));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.MAHOKANTA);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MAHOKANTA.getId()], new EntityPetAIMagicBuff(this, EnumDqmMagic.Mahokanta, DQPotionPlus.buffMahokanta));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.BOMIE);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BOMIE.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Bomie, DQPotionMinus.debuffBomie));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.RARIHO);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.RARIHO.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Rariho, DQPotionMinus.debuffRariho));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.MANUSA);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MANUSA.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Manusa, DQPotionMinus.debuffManusa));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.MAHOTON);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MAHOTON.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Mahoton, DQPotionMinus.debuffMahoton));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.RUKANI);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.RUKANI.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Rukani, DQPotionMinus.debuffRukani));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.MEDAPANI);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MEDAPANI.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Medapani, DQPotionMinus.debuffMedapani));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.HENATOSU);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.HENATOSU.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Henatosu, DQPotionMinus.debuffHenatosu));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.DIVAINSUPERU);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.DIVAINSUPERU.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Divainsuperu, DQPotionMinus.debuffDivainsuperu));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.RUKANAN);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.RUKANAN.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Rukanan, DQPotionMinus.debuffRukani));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.RARIHOMA);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.RARIHOMA.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Rarihoma, DQPotionMinus.debuffRariho));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.BOMIOSU);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BOMIOSU.getId()], new EntityPetAIMagicDebuff(this, EnumDqmMagic.Bomiosu, DQPotionMinus.debuffBomie));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.SUKURUTO);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.SUKURUTO.getId()], new EntityPetAIMagicBuff(this, EnumDqmMagic.Sukuruto, DQPotionPlus.buffSukara));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.PIORIMU);
			if(param > 0)
			{
				this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.PIORIMU.getId()], new EntityPetAIMagicBuff(this, EnumDqmMagic.Piorimu, DQPotionPlus.buffPiora));
			}

			//DQR.func.debugString("TEST??1", this.getClass());
			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.BEHOMARA);
			if(param > 0)
			{
				//DQR.func.debugString("TEST??2 : " + this.mobAI.getBehomara(), this.getClass());
		   		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BEHOMARA.getId()], new EntityPetAIMagicBehomara(this, EnumDqmMagic.Behomara, null)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.BEHOMARA.getId()], new EntityPetAIMagicBehomara(this, EnumDqmMagic.Behomazun, null)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Behomara(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Behomara));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.MAHOIMI);
			if(param > 0)
			{
		   		switch(param)
	    		{
	    			case 1:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MAHOIMI.getId()], new EntityPetAIMagicMahoimi(this, EnumDqmMagic.Mahoimi, null)); break;
	    			case 2:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MAHOIMI.getId()], new EntityPetAIMagicMahoimi(this, EnumDqmMagic.Mahoriku, null)); break;
	    			case 3:this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.MAHOIMI.getId()], new EntityPetAIMagicMahoimi(this, EnumDqmMagic.Mahoizun, null)); break;
	    		}
				//this.tasks.addTask(this.arrayAIRate[EnumDqmMobAI.Mahoimi(), new EntityPetAIMagicAttack4(this, 1.25D, 20, 60, 25.0F, EnumDqmMagic.Mahoimi));
			}
        }

        //this.tasks.addTask(2, new EntityPetAIMagicHoimi(this, EnumDqmMagic.Behoma, null));
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

    public boolean getIsDeath()
    {
    	return this.deathFlg || this.getHealth() <= 0.1F;
    }

    public void onLivingUpdate()
    {
        super.onLivingUpdate();



        /*
        if(this.isTamed() && this.worldObj.getWorldTime() % 40 == 0)
        {
        	attackEntityWithRangedAttack(this, 1.0f);
        }
        */



        if(this.getHealth() <= 0.1F && !this.deathFlg)
        {
        	this.clearTasks();
        	this.tasks.addTask(0, aiDeaht);
        	this.deathFlg = true;
        }

        //System.out.println("TESTTEST_UNLOAD : " + this.getCommandSenderName());
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

        if(DQR.conf.dqrHardcorePet != 0 && this.getOwner() != null && this.getOwner() instanceof EntityPlayer)
        {
        	EntityPlayer owner = (EntityPlayer)this.getOwner();

        	//System.out.println("TIME : " + ExtendedPlayerProperties.get(owner).getBirthTime() +" / "+ tamingTime);
        	if(ExtendedPlayerProperties.get(owner).getBirthTime() > tamingTime && !this.worldObj.isRemote)
        	{
            	EntityPlayer ep = null;
            	if(this != null && this.worldObj != null && this.getOwner() != null)
            	{
            		ep = this.worldObj.func_152378_a(this.getOwner().getUniqueID());
            	}

            	if(ep != null)
            	{
            		ExtendedPlayerProperties3.get(ep).minusPetCount(1);
                	DQR.petFunc.removePetdata(ep, this.getUniqueID().toString());
                	if(this.getPetUniqueNumber() == 0)
        			{
        				DqrWorldData wd = (DqrWorldData)ep.worldObj.loadItemData(DqrWorldData.class, DQR.modID);
        				if(wd == null)
        				{
        					wd = new DqrWorldData(DQR.modID);
        				}
        				this.petUniqueNumber = wd.getNextPetNum();
        				wd.markDirty();
        				ep.worldObj.setItemData(DQR.modID, wd);
        			}
                	DQR.petFunc.removePetdata(ep, String.valueOf(this.petUniqueNumber));
            	}
        		this.setDead(true);
        	}
        }
    }

    //fwetrwe
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (!this.isTamed() || this.isEntityInvulnerable() || (p_70097_1_.getSourceOfDamage() == this.getOwner() && p_70097_2_ > 0.0F) || (this.isTamed() && this.getHealth() <= 0.1F && DQR.conf.dqrHardcorePet2 == 0))
        {
            return false;
        }
        else
        {
            //p_70097_1_.
        	/*
            if(p_70097_1_.getSourceOfDamage() != null)
            {
            	 System.out.println("TEST A : " + p_70097_1_.getSourceOfDamage().getCommandSenderName());
            }
            if( this.getOwner() != null)
            {
            	System.out.println("TEST B : " + this.getOwner().getCommandSenderName());
            }
            if(p_70097_1_.getEntity() != null)
            {
            	System.out.println("TEST C : " +p_70097_1_.getEntity() .getCommandSenderName());
            }
            */

        	if(p_70097_1_.getSourceOfDamage() instanceof EntityPlayer)
        	{
        		//System.out.println("TEST 1 : " + p_70097_1_.getSourceOfDamage().getCommandSenderName() +  " / " + this.getOwner().getCommandSenderName());
        		EntityPlayer ep = (EntityPlayer)p_70097_1_.getSourceOfDamage();

        		if(!DQR.func.canAttackPetMonster(this, ep))
        		{
        			return false;
        		}
        		//EntityPlayer owner = (EntityPlayer)this.getOwner();

        		/*
        		if(!ep.canAttackPlayer(owner))
        		{
        			return false;
        		}
        		*/
        	}


        	if(p_70097_1_.getEntity() instanceof EntityPlayer)
        	{
        		EntityPlayer ep = (EntityPlayer)p_70097_1_.getEntity();

        		if(!DQR.func.canAttackPetMonster(this, ep))
        		{
        			return false;
        		}
        		/*
        		System.out.println("TEST 2 : " + p_70097_1_.getEntity().getCommandSenderName() +  " / " + this.getOwner().getCommandSenderName());
        		EntityPlayer ep = (EntityPlayer)p_70097_1_.getEntity();
        		EntityPlayer owner = (EntityPlayer)this.getOwner();

        		if(!ep.canAttackPlayer(owner))
        		{
        			return false;
        		}
        		*/
        	}


            Entity entity = p_70097_1_.getEntity();
            this.aiSit.setSitting(false);

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                p_70097_2_ = (p_70097_2_ + 1.0F) / 2.0F;
            }

            int ran2 = rand.nextInt(2);

            if(arrayAISets[EnumDqmMobAI.TELEPORT.getId()] > 0)
        	{
	            if (p_70097_1_ != null && ran2 == 0)
	            {
	                teleportRandomly();
	            }
        	}

            if(this.isTamed() && this.getHealth() - p_70097_2_ <= 0 && DQR.conf.dqrHardcorePet2 == 0)
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
            else if(this.getHealth() - p_70097_2_ <= 0.0F && DQR.conf.dqrHardcorePet2 == 0)
            {
            	if(DQR.debug == 3)System.out.println("DEBUG_LINE1");
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
        	//DQR.func.debugString("TESTTESTTESTTESTTESTTESTTEST1");
            p_70665_2_ = ForgeHooks.onLivingHurt(this, p_70665_1_, p_70665_2_);
            if (p_70665_2_ <= 0) return;
            p_70665_2_ = this.applyArmorCalculations(p_70665_1_, p_70665_2_);
            p_70665_2_ = this.applyPotionDamageCalculations(p_70665_1_, p_70665_2_);

            //防御力計算
            p_70665_2_ = p_70665_2_ - this.getBougyo();

            //DQR.func.debugString("TESTTESTTESTTESTTESTTESTTEST2");
            //ダメージ0の場合にランダムで補正
            if(p_70665_2_ < 0.5F)
            {
            	if(rand.nextInt(5) == 0)
            	{
            		p_70665_2_ = rand.nextFloat() * 2;
            	}
            }

            //DQR.func.debugString("TESTTESTTESTTESTTESTTESTTEST3");
            //耐性計算
            DQR.func.debugString("TEST_A : " + p_70665_2_ , null, 3);
            p_70665_2_ = DQR.calcDamage.applyDamageResistMagic(p_70665_2_, this, p_70665_1_);
            DQR.func.debugString("TEST_G : " + p_70665_2_ , null, 3);
            p_70665_2_ = DQR.calcDamage.applyDamageResist(p_70665_2_, this, p_70665_1_);
            DQR.func.debugString("TEST_F : " + p_70665_2_ , null, 3);
            float f1 = p_70665_2_;
            p_70665_2_ = Math.max(p_70665_2_ - this.getAbsorptionAmount(), 0.0F);
            this.setAbsorptionAmount(this.getAbsorptionAmount() - (f1 - p_70665_2_));

            DQR.func.debugString("TEST_B : " + p_70665_2_ , null, 3);
            if (p_70665_2_ != 0.0F)
            {
            	DQR.func.debugString("TEST_C : " + p_70665_2_ , null, 3);
                float f2 = this.getHealth();
                if(f2 - p_70665_2_ <= 0.1F && DQR.conf.dqrHardcorePet2 == 0)
                {
                	p_70665_2_ = f2 - 0.05F;
                }
                DQR.func.debugString("TEST_D : " + p_70665_2_ , null, 3);
                this.setHealth(f2 - p_70665_2_);
                this.func_110142_aN().func_94547_a(p_70665_1_, f2, p_70665_2_);
                this.setAbsorptionAmount(this.getAbsorptionAmount() - p_70665_2_);
                DQR.func.debugString("TEST_E : " + p_70665_2_ , null, 3);
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

		Random rand = new Random();

		int param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.JUMP);
        if (param > 0)
        {
            //if (par2 > 2.0F && par2 < 8.0F && this.rand.nextInt(5) == 0)
        	if (this.rand.nextInt(5) == 0)
            {
                if (this.onGround)
                {
                    double var4 = p_70652_1_.posX - this.posX;
                    double var6 = p_70652_1_.posZ - this.posZ;
                    float var8 = MathHelper.sqrt_double(var4 * var4 + var6 * var6);
                    this.motionX = var4 / (double)var8 * 0.5D * 0.800000011920929D + this.motionX * 0.1D * this.arrayAIRate[EnumDqmMobAI.JUMP.getId()];
                    this.motionZ = var6 / (double)var8 * 0.5D * 0.800000011920929D + this.motionZ * 0.1D *this.arrayAIRate[EnumDqmMobAI.JUMP.getId()];
                    this.motionY = 0.1D * this.arrayAISets[EnumDqmMobAI.JUMP.getId()];
                }
            }
        }

		if(p_70652_1_ != null && p_70652_1_ instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)p_70652_1_;

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.HEAVYFIRE);
			if(param > 0 && !ep.capabilities.isCreativeMode)
			{
				DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionMinus.debuffHeavyFire.id, 60, this.arrayAISets[EnumDqmMobAI.HEAVYFIRE.getId()]));
			}

			param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.POISON);
	        if(param > 0)
	        {
        		if(rand.nextInt(this.arrayAIRate[EnumDqmMobAI.POISON.getId()]) == 0)
        		{
        			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionMinus.potionPoison.id, rand.nextInt(10) + 10, this.arrayAISets[EnumDqmMobAI.POISON.getId()] - 1));
        		}
	        }

	        param = DQR.magicTablePet.magicCastGrade(this, EnumDqmMobAI.POISONX);
	        if(param > 0)
	        {
        		if(rand.nextInt(this.arrayAIRate[EnumDqmMobAI.POISONX.getId()]) == 0)
        		{
        			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionMinus.potionPoisonX.id, rand.nextInt(10) + 10, this.arrayAISets[EnumDqmMobAI.POISONX.getId()]));
        		}
	        }
		}



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
        		//fix1
        		this.setHealth(this.HP);
        		//Debugline1
        		//System.out.println("TEST1");
        	}else
        	{
        		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
        		//fix1
        		this.setHealth(this.HP);
        		//Debugline1
        		//ystem.out.println("TEST2");
        	}
        	//this.setHealth(this.getMaxHP());
        	//if(DQR.debug == 3)System.out.println("DEBUG_LINE2");
        	//this.setHealth(this.getMaxHealth());
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
            		//fix1
            		this.setHealth(this.HP);
            		//Debugline1
            		//System.out.println("TEST3");
            	}else
            	{
            		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
            		//fix1
            		this.setHealth(this.HP);
            		//Debugline1
            		//System.out.println("TEST4");
            	}

            	//if(DQR.debug == 3)System.out.println("DEBUG_LINE3");
            	//this.setHealth(this.getMaxHP());
        	}else
        	{
        		//System.out.println("AAAAA:" + this.getMaxHP() + " / " + this.getMaxHealth());
        		if(this.getMaxHealth() > 0.0f)
        		{
        			//System.out.println("LINE2");
        			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHealth());
        			if(DQR.debug == 3)System.out.println("DEBUG_LINE4");
        			this.setHealth(this.getMaxHealth());

            		//Debugline1
            		//System.out.println("TEST5");
        		}else
        		{
        			//System.out.println("LINE3");
        			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        			if(DQR.debug == 3)System.out.println("DEBUG_LINE5");
        			this.setHealth(10.0f);

            		//Debugline1
            		//System.out.println("TEST6");
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

        	if(this.getOwner() != null && this.getOwner() instanceof EntityPlayer)
        	{
        		NBTTagCompound ownerNBT = ExtendedPlayerProperties6.get((EntityPlayer)this.getOwner()).getNBTPlayerPetList();

        		if(ownerNBT != null && !ownerNBT.hasKey(this.getUniqueID().toString()))
        		{
        			//System.out.println("TESTTEST");
        			ExtendedPlayerProperties3.get((EntityPlayer)this.getOwner()).plusPetCount(1);
                    DQR.petFunc.setNewPetdata(this);
        		}
        	}

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
	            			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magic.mahoton.txt",new Object[] {}));
	            			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

	            			return false;
	            		}
	            		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
	            		//if(pe != null && this.worldObj.isRemote)
	            		if(DQR.func.isBind(this))
	            		{
	            			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
	            			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

	            			return false;
	            		}


	                	if(itemstack.getItemDamage() == 0)
	                	{

	                		int epMP = ExtendedPlayerProperties.get(ep).getMP();

	                		if(!DQR.magicTable.magicEnable(ep, itemstack.getItem()) && DQR.debug == 0)
	                		{
	            				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
	            				ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

	            				return false;
	                		}

	                		DqmItemMagicBase magicItem = (DqmItemMagicBase)itemstack.getItem();

	            			if(epMP < magicItem.getEnumMagic().getMP() && DQR.debug == 0)
	            			{
	            				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
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

		                	this.clearTasks();
		                	this.tasks.addTask(2, this.aiSit);


			                this.aiSit.setSitting(true);
			                this.isJumping = false;
			                this.setPathToEntity((PathEntity)null);
			                this.setTarget((Entity)null);
			                this.setAttackTarget((EntityLivingBase)null);
	                    	//this.setCombatTasks();
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

	            	//経験値玉
	            	if (itemstack.getItem() == DQMiscs.itemDebugItem &&
	            		(this.func_152114_e(ep) ||
	            		 DQR.conf.petPermGiveExpItems == 1 ||
	            		 (DQR.conf.petPermGiveExpItems == 2 && opFlg)
	            		)
	            	   )
	            	{

	                    ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	                    this.setJobExp(this.getJob(), 11708705);
	                    ThreadLvUpPet lvup = new ThreadLvUpPet(this);
	                    	            lvup.start();
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

	                    	EntityPlayer ep2 = null;
	                    	if(this != null && this.worldObj != null && this.getOwner() != null)
	                    	{
	                    		ep2 = this.worldObj.func_152378_a(this.getOwner().getUniqueID());
	                    	}

	                    	if(ep2 != null)
	                    	{
	                    		ExtendedPlayerProperties3.get(ep2).minusPetCount(1);
	                        	DQR.petFunc.removePetdata(ep2, this.getUniqueID().toString());
	                        	if(this.getPetUniqueNumber() == 0)
	                			{
	                				DqrWorldData wd = (DqrWorldData)ep2.worldObj.loadItemData(DqrWorldData.class, DQR.modID);
	                				if(wd == null)
	                				{
	                					wd = new DqrWorldData(DQR.modID);
	                				}
	                				this.petUniqueNumber = wd.getNextPetNum();
	                				wd.markDirty();
	                				ep2.worldObj.setItemData(DQR.modID, wd);
	                			}
	                        	DQR.petFunc.removePetdata(ep2, String.valueOf(this.petUniqueNumber));
	                    	}
	                    	this.setDead(false);
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

	            		if(itemstack.getItemDamage() == 0)
	            		{
	            			itemstack.setItemDamage(20);
		        			if (!this.worldObj.isRemote)
		        			{
		        				NBTTagCompound haigouPet1 = ExtendedPlayerProperties3.get(ep).getHaigouPet1();
		        				NBTTagCompound haigouPet2 = ExtendedPlayerProperties3.get(ep).getHaigouPet2();

		        				if((haigouPet1 == null || haigouPet1.hasNoTags()) && (haigouPet2 == null || !haigouPet2.getString("PetUUID").equalsIgnoreCase(this.getUniqueID().toString())))
		        				{
		        					ExtendedPlayerProperties3.get(ep).setHaigouPet1(this.makeTutuNBT(new NBTTagCompound(), false));
		        					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("dqm.iteminfo.petHaigou1",new Object[] {this.getCommandSenderName(), this.JobLv[0]}));
		        				}else if((haigouPet2 == null || haigouPet2.hasNoTags()) && (haigouPet1 == null || !haigouPet1.getString("PetUUID").equalsIgnoreCase(this.getUniqueID().toString())))
		        				{
		        					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("dqm.iteminfo.petHaigou1",new Object[] {haigouPet1.getString("PetName"), haigouPet1.getInteger("JobLv_0")}));
		        					ExtendedPlayerProperties3.get(ep).setHaigouPet2(this.makeTutuNBT(new NBTTagCompound(), false));
		        					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("dqm.iteminfo.petHaigou2",new Object[] {this.getCommandSenderName(), this.JobLv[0]}));
		        				}else
		        				{
		        					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("dqm.iteminfo.petHaigou1",new Object[] {haigouPet1.getString("PetName"), haigouPet1.getInteger("JobLv_0")}));
		        					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("dqm.iteminfo.petHaigou2",new Object[] {haigouPet2.getString("PetName"), haigouPet2.getInteger("JobLv_0")}));

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
		                        /*
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
		                        */
		                        //ExtendedPlayerProperties3.get(ep).minusPetCount(1);
		                    	EntityPlayer ep2 = null;
		                    	if(this != null && this.worldObj != null && this.getOwner() != null)
		                    	{
		                    		ep2 = this.worldObj.func_152378_a(this.getOwner().getUniqueID());
		                    	}

		                    	if(ep2 != null)
		                    	{
		                    		ExtendedPlayerProperties3.get(ep2).minusPetCount(1);
		                        	DQR.petFunc.removePetdata(ep2, this.getUniqueID().toString());

		                        	if(this.getPetUniqueNumber() == 0)
		                			{
		                				DqrWorldData wd = (DqrWorldData)ep2.worldObj.loadItemData(DqrWorldData.class, DQR.modID);
		                				if(wd == null)
		                				{
		                					wd = new DqrWorldData(DQR.modID);
		                				}
		                				this.petUniqueNumber = wd.getNextPetNum();
		                				wd.markDirty();
		                				ep2.worldObj.setItemData(DQR.modID, wd);
		                			}
		                        	DQR.petFunc.removePetdata(ep2, String.valueOf(this.petUniqueNumber));
		                    	}
		                    	this.setDead(true);
		        			}
	            		}else
	            		{
	                		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.magic.noct.txt",new Object[] {}));
	                		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
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
    					MinecraftServer minecraftserver = MinecraftServer.getServer();
    					EntityPlayer er2 = minecraftserver.getConfigurationManager().func_152612_a(DQR.partyManager.getPartyLeaderFromMember(ep));
    					if(er2 != null)
    					{
    						DQR.partyManager.addPartyMember(er2, this);
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
    	        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shinziru.modeInfo.txt", new Object[] {}));
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
	                    if ((this.isTamed() && this.getHealth() <= 0.1F) || (this.isTamed() && DQR.conf.dqrHardcorePet2 != 0))
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
	                        /*
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
			                        		//inventory.getStackInSlot(cnt) = null;
			                        		inventory.setInventorySlotContents(cnt, null);
			                        		inventory.markDirty();
			                        	}
			                        }
		                        }
	                        }
	                        */


	                    	EntityPlayer ep2 = null;
	                    	if(this != null && this.worldObj != null && this.getOwner() != null)
	                    	{
	                    		ep2 = this.worldObj.func_152378_a(this.getOwner().getUniqueID());
	                    	}

	                    	if(ep2 != null)
	                    	{
	                    		ExtendedPlayerProperties3.get(ep2).minusPetCount(1);
	                        	DQR.petFunc.removePetdata(ep2, this.getUniqueID().toString());

	                        	if(this.getPetUniqueNumber() == 0)
	                			{
	                				DqrWorldData wd = (DqrWorldData)ep2.worldObj.loadItemData(DqrWorldData.class, DQR.modID);
	                				if(wd == null)
	                				{
	                					wd = new DqrWorldData(DQR.modID);
	                				}
	                				this.petUniqueNumber = wd.getNextPetNum();
	                				wd.markDirty();
	                				ep2.worldObj.setItemData(DQR.modID, wd);
	                			}
	                        	DQR.petFunc.removePetdata(ep2, String.valueOf(this.petUniqueNumber));
	                    	}
	                        this.setDead(true);
	                    }else
	                    {
	                    	//this.setHealth(0.05F);
	                    	this.attackEntityFrom(DamageSource.magic.setDamageBypassesArmor(), this.getHealth() - 0.05F);
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
	                	int healMP = 0;
	                	boolean itemUseFlg = false;

	        			if(food.getMinHP() > -1 || food.getMaxHP() > -1)
	        			{
	        				 healHP = (int)(food.getMinHP() + rand.nextInt(food.getMaxHP() + 1));

	                     	if(this.getHealth() < this.getMaxHealth() && this.getHealth() > 0.1F)
	                    	{
	                     		/*
	                            if (!ep.capabilities.isCreativeMode)
	                            {
	                                --itemstack.stackSize;
	                            }
	                            */
	                     		itemUseFlg = true;
	                    		this.setHealth(this.getHealth() + healHP);

	                        	if(this.getHealth() >= this.getMaxHealth())
	                        	{
	                        		this.setHealth(this.getMaxHealth());
	                        	}
	                    	}
	        			}

	        			if(food.getMinMP() > -1 || food.getMaxMP() > -1)
	        			{
	        				 healMP = (int)(food.getMinMP() + rand.nextInt(food.getMaxMP() + 1));

	                     	if(this.MP < this.MaxMP)
	                    	{
	                     		itemUseFlg = true;


	                        	if(this.MP + healMP >= this.MaxMP)
	                        	{
	                        		this.MP = this.MaxMP;
	                        	}else
	                        	{
	                        		this.MP = this.MP + healMP;
	                        	}
	                    	}
	        			}

	        			if(food.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi.getUnlocalizedName()) ||
	        					food.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi2.getUnlocalizedName()) ||
	        					food.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi3.getUnlocalizedName()) ||
	        					food.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI.getUnlocalizedName()) ||
	        					food.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI2.getUnlocalizedName()) ||
	        					food.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI3.getUnlocalizedName()))
	        			{
	        				DQR.func.doFoodEaten(this, food);
	        				itemUseFlg = true;
	        			}

	        			if(itemUseFlg)
	        			{
	                        if (!ep.capabilities.isCreativeMode)
	                        {
	                            --itemstack.stackSize;
	                        }

                        	if(DQR.exp.getNextExpPet(this.getJobLv(this.getJob()), this) <= 0)
                        	{
	    	        	  		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.pet.status1MAX.txt",new Object[] {petName, ownerName,
	    								  this.getJobLv(this.getJob()),
	    								  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJob(), this),
	    								  (int)(this.getHealth()), (int)(this.getMaxHealth()),
	    								  this.getMP(), this.getMaxMP()}));
                        	}else
                        	{
	    	        	  		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.pet.status1.txt",new Object[] {petName, ownerName,
	    								  this.getJobLv(this.getJob()),
	    								  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJob(), this),
	    								  (int)(this.getHealth()), (int)(this.getMaxHealth()),
	    								  this.getMP(), this.getMaxMP()}));
                        	}

    	        	  		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.pet.status2.txt",new Object[] {this.getKougeki(),
    								  this.getBougyo(), this.getTotalArmorValue(),
    								  this.getMaryoku(),
    								  this.getTikara(),
    								  this.getMikawasi(),
    								  this.getKasikosa()}));

    	        	  		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

                        	return true;
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
	                	int healMP = 0;
	                	boolean itemUseFlg = false;

	        			if(food.getMinHP() > -1 || food.getMaxHP() > -1)
	        			{
	        				 healHP = (int)(food.getMinHP() + rand.nextInt(food.getMaxHP() + 1));

	                     	if(this.getHealth() < this.getMaxHealth())
	                    	{
	                     		itemUseFlg = true;
	                    		this.setHealth(this.getHealth() + healHP);

	                        	if(this.getHealth() >= this.getMaxHealth())
	                        	{
	                        		this.setHealth(this.getMaxHealth());
	                        	}

	                    	}
	        			}

	        			if(food.getMinMP() > -1 || food.getMaxMP() > -1)
	        			{
	        				 healMP = (int)(food.getMinMP() + rand.nextInt(food.getMaxMP() + 1));

	                     	if(this.MP < this.MaxMP)
	                    	{
	                     		itemUseFlg = true;
	                        	if(this.MP + healMP >= this.MaxMP)
	                        	{
	                        		this.MP = this.MaxMP;
	                        	}else
	                        	{
	                        		this.MP = this.MP + healMP;
	                        	}
	                    	}
	        			}

	        			if(itemUseFlg)
	        			{
                            if (!ep.capabilities.isCreativeMode)
                            {
                                --itemstack.stackSize;
                            }

                        	if(DQR.exp.getNextExpPet(this.getJobLv(this.getJob()), this) <= 0)
                        	{
	    	        	  		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.pet.status1MAX.txt",new Object[] {petName, ownerName,
	    								  this.getJobLv(this.getJob()),
	    								  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJob(), this),
	    								  (int)(this.getHealth()), (int)(this.getMaxHealth()),
	    								  this.getMP(), this.getMaxMP()}));
                        	}else
                        	{
	    	        	  		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.pet.status1MAX.txt",new Object[] {petName, ownerName,
	    								  this.getJobLv(this.getJob()),
	    								  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJob(), this),
	    								  (int)(this.getHealth()), (int)(this.getMaxHealth()),
	    								  this.getMP(), this.getMaxMP()}));
                        	}

                        	DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.pet.status2.txt",new Object[] {this.getKougeki(),
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
                if(itemstack.getItem() instanceof DqmItemPetbook)
                {
                	if(ep.isSneaking())
                	{
                		if(!this.worldObj.isRemote)
                		{
	                		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	                		if(this.flgAIuse == 0)
	                		{
	                			this.flgAIuse = 1;
	                		}else
	                		{
	                			this.flgAIuse = 0;
	                		}
	                		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("skill.change.info." + this.flgAIuse + ".txt",new Object[] {this.getCommandSenderName()}));
	                		if(!this.isSitting())
	                		{
	                			this.clearTasks();
	                			this.setCombatTasks();
	                		}
                		}
                	}else
                	{
	                	int setCount = 0;
	                	//String makeString = EnumDqmMessageConv.PetSkill.getStartS();
	            		String val = "";
	            		//DQR.func.debugString("TEST1:" + val);
	                	for(int cnt = 1; cnt < this.arrayAILimit.length; cnt++)
	                	{
	                		//DQR.func.debugString("TEST2:" + val);
	                		int flg1 = this.arrayAIMaster[cnt];
	                		int flg2 = this.arrayAILimit[cnt];
	                		//int flg3 = DQR.magicTablePet.magicCastGradeFromID(this, cnt);
	                		EnumDqmMobAI aiEnum = DQR.enumGetter.getDqmMobAI(cnt);


	                		if(flg2 > 0)
	                		{


	                			/*
	                			if(cnt != 1)
	                			{
	                				val = val + ",";
	                			}
	                			*/

	                			//al = val + aiEnum.getId() + ",";

	                			for(int cnt2 = 1; cnt2 <= flg2; cnt2++)
	                			{
	                				String color = "";
	                				if(this.arrayAIMaster[cnt] >= cnt2)
	                				{
	                					color = EnumColor.Yellow.getChatColor();
	                					//val = val + "," + cnt + "," + cnt2 + ",";
	                				}else if(DQR.magicTablePet.magicCastGradeFromID(this, cnt) >= cnt2)
	                				{
	                					color = EnumColor.White.getChatColor();
	                				}else
	                				{
	                					color = EnumColor.Gray.getChatColor();
	                				}
	                				//DQR.func.debugString("TEST3:" + val);
	                				val = val + cnt + "," + cnt2 + "," + color + ",";
	                				setCount = setCount + 1;
	                				//DQR.func.debugString("TEST4:" + val);
	                				if(aiEnum.getGradeFlg() == 0)
	                				{
	                					break;
	                				}
	                			}
	                			//DQR.func.debugString("TEST5:" + val);
	                		}
	                		//System.out.println("CHECK[" + cnt + "] : (" + flg1 + ")(" + flg2 + ")" + val);
	                	}
	                	//DQR.func.debugString("TEST6:" + val);
	                	if(!this.worldObj.isRemote)
	                	{
	                		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		                	if(setCount > 0)
		                	{
		                		String name = null;
		                		if(this.getCustomNameTag().length() > 0)
		                		{
		                			name = this.getCustomNameTag();
		                		}else
		                		{
		                			name = this.getCommandSenderName();
		                		}
		                		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("skill.list." + this.flgAIuse + ".msg",new Object[] {name}));
		                		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation(EnumDqmMessageConv.PetSkill.getStartS() + val + EnumDqmMessageConv.PetSkill.getEndS(),new Object[] {}));
		                	}else
		                	{
		                		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("skill.noskill.name",new Object[] {}));
		                	}
	                	}
                	}

                	return true;
                }

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
    	        	  		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.pet.status1MAX.txt",new Object[] {petName, ownerName,
    	        	  																						  this.getJobLv(this.getJob()),
    	        	  																						  this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJobLv(this.getJob()), this),
    	        	  																						  (int)(this.getHealth()), (int)(this.getMaxHealth()),
    	        	  																						  this.getMP(), this.getMaxMP()}));
                    		}else
                    		{
        	        	  		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.pet.status1.txt",new Object[] {petName, ownerName,
        	        	  																						   this.getJobLv(this.getJob()),
        	        	  																						   this.getJobExp(this.getJob()),DQR.exp.getNextExpPet(this.getJobLv(this.getJob()), this),
        	        	  																						   (int)(this.getHealth()), (int)(this.getMaxHealth()),
        	        	  																						   this.getMP(), this.getMaxMP()}));

                    		}
    	        	  		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.pet.status2.txt",new Object[] {this.getKougeki(),
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


		                        	if(this.getPetUniqueNumber() == 0)
		                			{
		                				DqrWorldData wd = (DqrWorldData)epOwner.worldObj.loadItemData(DqrWorldData.class, DQR.modID);
		                				if(wd == null)
		                				{
		                					wd = new DqrWorldData(DQR.modID);
		                				}
		                				this.petUniqueNumber = wd.getNextPetNum();
		                				wd.markDirty();
		                				epOwner.worldObj.setItemData(DQR.modID, wd);
		                			}
		                        	DQR.petFunc.removePetdata(epOwner, String.valueOf(this.petUniqueNumber));
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

	        		this.setDead(true);
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
		                    this.setTamingTime(this.worldObj.getWorldTime());
		                    //this.setJobTikara(this.getJob(), type.TIKARADEF);
		                    //this.setJobKasikosa(this.getJob(), type.KASIKOSADEF);
		                    this.setAiBox();
		                    this.setHealth(this.getMaxHealth());
		                    if(DQR.debug == 3)System.out.println("DEBUG_LINE6");
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
	            	  		DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.petTame.maxnumber.txt",new Object[] {}));
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

        		//fix1
        		this.setHealth(this.HP);
        		//Debugline1
        		//System.out.println("TEST_A1");
        	}else
        	{
        		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());
        		//Debugline1
        		//System.out.println("TEST_A2");
        		//fix1
        		this.setHealth(this.HP);
        	}
        	if(DQR.debug == 3)System.out.println("DEBUG_LINE7");
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
            		//fix1
            		this.setHealth(this.HP);
            		//Debugline1
            		//System.out.println("TEST_A3");
            	}else
            	{
            		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHP());

            		//Debugline1
            		//System.out.println("TEST_A4");
            		//fix1
            		this.setHealth(this.HP);
            	}
            	if(DQR.debug == 3)System.out.println("DEBUG_LINE8");
            	this.setHealth(this.getMaxHP());

        		//Debugline1
        		//System.out.println("TEST_A5");
        	}else
        	{
        		//System.out.println("FAAAA:" + this.getMaxHP() + " / " + this.getMaxHealth());
        		if(this.getMaxHealth() > 0)
        		{
        			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(this.getMaxHealth());
        			//this.setHealth(this.HP);
            		//fix1
            		this.setHealth(this.HP);
            		//Debugline1
            		//System.out.println("TEST_A6");
        		}else
        		{
        			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
            		//fix1
            		this.setHealth(this.HP);
            		//Debugline1
            		//System.out.println("TEST_A7");
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
        super.writeEntityToNBT(p_70014_1_);
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

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	p_70014_1_.setInteger("arrayAILimit_" + cnt, arrayAILimit[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	p_70014_1_.setInteger("arrayAIMaster_" + cnt, arrayAIMaster[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	p_70014_1_.setInteger("arrayAISets_" + cnt, arrayAISets[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	p_70014_1_.setInteger("arrayAIRate_" + cnt, arrayAIRate[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	p_70014_1_.setInteger("arrayAIRateDef_" + cnt, arrayAIRateDef[cnt]);
        }

        p_70014_1_.setInteger("flgAIextended", this.flgAIextended);
        p_70014_1_.setInteger("flgAIuse", this.flgAIuse);


        p_70014_1_.setLong("tamingTime", this.tamingTime);

        p_70014_1_.setInteger("Kougeki", this.Kougeki);
        p_70014_1_.setInteger("Bougyo", this.Bougyo);
        p_70014_1_.setInteger("Maryoku", this.Maryoku);

        p_70014_1_.setInteger("Tikara", this.Tikara);
        p_70014_1_.setInteger("Mikawasi", this.Mikawasi);
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arrayMikawasi_" + cnt, arrayMikawasi[cnt]);
        }

        p_70014_1_.setInteger("Kasikosa", this.Kasikosa);

        p_70014_1_.setInteger("Kaisinritu", this.Kaisinritu);
        p_70014_1_.setInteger("KaisinMin", this.KaisinMin);
        p_70014_1_.setInteger("KaisinMax", this.KaisinMax);
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	p_70014_1_.setInteger("arrayKaisinritu_" + cnt, arrayKaisinritu[cnt]);
        }

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

        p_70014_1_.setTag("dqrPotionEffects", dqrPotionEffects);

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



        p_70014_1_.setLong("PetUniqueNumber", this.petUniqueNumber);


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
        super.readEntityFromNBT(p_70037_1_);

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

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	arrayAILimit[cnt] = p_70037_1_.getInteger("arrayAILimit_" + cnt);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	arrayAIMaster[cnt] = p_70037_1_.getInteger("arrayAIMaster_" + cnt);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	arrayAISets[cnt] = p_70037_1_.getInteger("arrayAISets_" + cnt);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	arrayAIRate[cnt] = p_70037_1_.getInteger("arrayAIRate_" + cnt);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	arrayAIRateDef[cnt] = p_70037_1_.getInteger("arrayAIRateDef_" + cnt);
        }

        this.flgAIextended = p_70037_1_.getInteger("flgAIextended");
        this.flgAIuse = p_70037_1_.getInteger("flgAIuse");

        this.tamingTime = p_70037_1_.getLong("tamingTime");

        this.Kougeki = p_70037_1_.getInteger("Kougeki");
        this.Bougyo = p_70037_1_.getInteger("Bougyo");
        this.Maryoku = p_70037_1_.getInteger("Maryoku");

        this.Tikara = p_70037_1_.getInteger("Tikara");
        this.Mikawasi = p_70037_1_.getInteger("Mikawasi");
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayMikawasi[cnt] = p_70037_1_.getInteger("arrayMikawasi_" + cnt);
        }

        this.Kasikosa = p_70037_1_.getInteger("Kasikosa");

        this.Kaisinritu = p_70037_1_.getInteger("Kaisinritu");
        this.KaisinMin = p_70037_1_.getInteger("KaisinMin");
        this.KaisinMax = p_70037_1_.getInteger("KaisinMax");
        for(int cnt = 0; cnt < 32; cnt++)
        {
        	arrayKaisinritu[cnt] = p_70037_1_.getInteger("arrayKaisinritu_" + cnt);
        }

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

        this.petUniqueNumber = p_70037_1_.getLong("PetUniqueNumber");
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

        dqrPotionEffects = p_70037_1_.getCompoundTag("dqrPotionEffects");

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

        if(this.flgAIextended == 0)
        {
        	this.setAiBox();
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


    public void setDead(boolean par1)
    {
        if(!this.worldObj.isRemote)
        {
            if(chestOn && par1)
            {
                InventoryPetInventory inventory = new InventoryPetInventory(this);
                inventory.openInventory();

                for(int cnt = 0; cnt < inventory.getSizeInventory(); cnt++)
                {
                	if(inventory.getStackInSlot(cnt) != null)
                	{
                		this.entityDropItem(inventory.getStackInSlot(cnt), 0.0F);
                		//inventory.getStackInSlot(cnt) = null;
                		inventory.setInventorySlotContents(cnt, null);
                		inventory.markDirty();
                	}
                }

                inventory.closeInventory();
            }
        }

    	EntityPlayer ep = null;
    	if(DQR.partyManager.hasParty(this))
    	{
    		DQR.partyManager.removePartyMember(this);
    	}


    	/*
    	EntityPlayer ep = null;
    	if(this != null && this.worldObj != null && this.getOwner() != null)
    	{
    		ep = this.worldObj.func_152378_a(this.getOwner().getUniqueID());
    	}

    	if(ep != null)
    	{
    		ExtendedPlayerProperties3.get(ep).minusPetCount(1);
        	DQR.petFunc.removePetdata(ep, this.getUniqueID().toString());
    	}
    	*/

    	this.isDead = true;
    }

    @Override
    public void setDead()
    {
    	this.setDead(false);
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


    public int[] getArrayAILimitA() {
    	if(arrayAILimit == null) arrayAILimit = new int[64];
        return arrayAILimit;
    }
    public void setArrayAILimitA(int[] par1) {
    	if(arrayAILimit == null) arrayAILimit = new int[64];
        this.arrayAILimit = par1;
    }
    public int getArrayAILimit(int par1) {
    	if(arrayAILimit == null) arrayAILimit = new int[64];
        return arrayAILimit[par1];
    }
    public void setArrayAILimit(int par1, int par2) {
    	if(arrayAILimit == null) arrayAILimit = new int[64];
        this.arrayAILimit[par1] = par2;
    }

    public int[] getArrayAIMasterA() {
    	if(arrayAIMaster == null) arrayAIMaster = new int[64];
        return arrayAIMaster;
    }
    public void setArrayAIMasterA(int[] par1) {
    	if(arrayAIMaster == null) arrayAIMaster = new int[64];
        this.arrayAIMaster = par1;
    }
    public int getArrayAIMaster(int par1) {
    	if(arrayAIMaster == null) arrayAIMaster = new int[64];
        return arrayAIMaster[par1];
    }
    public void setArrayAIMaster(int par1, int par2) {
    	if(arrayAIMaster == null) arrayAIMaster = new int[64];
        this.arrayAIMaster[par1] = par2;
    }

    public int[] getArrayAISetsA() {
    	if(arrayAISets == null) arrayAISets = new int[64];
        return arrayAISets;
    }
    public void setArrayAISetsA(int[] par1) {
    	if(arrayAISets == null) arrayAISets = new int[64];
        this.arrayAISets = par1;
    }
    public int getArrayAISets(int par1) {
    	if(arrayAISets == null) arrayAISets = new int[64];
        return arrayAISets[par1];
    }
    public void setArrayAISets(int par1, int par2) {
    	if(arrayAISets == null) arrayAISets = new int[64];
        this.arrayAISets[par1] = par2;
    }

    public int[] getArrayAIRateA() {
    	if(arrayAIRate == null) arrayAIRate = new int[64];
        return arrayAIRate;
    }
    public void setArrayAIRateA(int[] par1) {
    	if(arrayAIRate == null) arrayAIRate = new int[64];
        this.arrayAIRate = par1;
    }
    public int getArrayAIRate(int par1) {
    	if(arrayAIRate == null) arrayAIRate = new int[64];
        return arrayAIRate[par1];
    }
    public void setArrayAIRate(int par1, int par2) {
    	if(arrayAIRate == null) arrayAIRate = new int[64];
        this.arrayAIRate[par1] = par2;
    }

    public int[] getArrayAIRateDefA() {
    	if(arrayAIRateDef == null) arrayAIRateDef = new int[64];
        return arrayAIRateDef;
    }
    public void setArrayAIRateDefA(int[] par1) {
    	if(arrayAIRateDef == null) arrayAIRateDef = new int[64];
        this.arrayAIRateDef = par1;
    }
    public int getArrayAIRateDef(int par1) {
    	if(arrayAIRateDef == null) arrayAIRateDef = new int[64];
        return arrayAIRateDef[par1];
    }
    public void setArrayAIRateDef(int par1, int par2) {
    	if(arrayAIRateDef == null) arrayAIRateDef = new int[64];
        this.arrayAIRateDef[par1] = par2;
    }

    public int getFlgAIextended() {
        return flgAIextended;
    }

    public void setFlgAIextended(int par1) {
        this.flgAIextended = par1;
    }

    public int getFlgAIuse() {
        return flgAIuse;
    }

    public void setFlgAIuse(int par1) {
        this.flgAIuse = par1;
    }


    public long getTamingTime() {
        return tamingTime;
    }

    public void setTamingTime(long par1) {
        this.tamingTime = par1;
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

    public int[] getArrayMikawasiA() {
    	if(arrayMikawasi == null) arrayMikawasi = new int[32];
        return arrayMikawasi;
    }
    public void setArrayMikawasiA(int[] par1) {
    	if(arrayMikawasi == null) arrayMikawasi = new int[32];
        this.arrayMP = par1;
    }
    public int getArrayMikawasi(int par1) {
    	if(arrayMikawasi == null) arrayMikawasi = new int[32];
        return arrayMikawasi[par1];
    }
    public void setArrayMikawasi(int par1, int par2) {
    	if(arrayMikawasi == null) arrayMikawasi = new int[32];
        this.arrayMikawasi[par1] = par2;
    }

    public int[] getArrayKaisinrituA() {
    	if(arrayKaisinritu == null) arrayKaisinritu = new int[32];
        return arrayKaisinritu;
    }
    public void setArrayKaisinrituA(int[] par1) {
    	if(arrayKaisinritu == null) arrayKaisinritu = new int[32];
        this.arrayMP = par1;
    }
    public int getArrayKaisinritu(int par1) {
    	if(arrayKaisinritu == null) arrayKaisinritu = new int[32];
        return arrayKaisinritu[par1];
    }
    public void setArrayKaisinritu(int par1, int par2) {
    	if(arrayKaisinritu == null) arrayKaisinritu = new int[32];
        this.arrayKaisinritu[par1] = par2;
    }

    public long getPetUniqueNumber()
    {
    	return this.petUniqueNumber;
    }

    public void setPetUniqueNumber(long par1)
    {
    	this.petUniqueNumber = par1;
    }

    private NBTTagCompound makeTutuNBT(NBTTagCompound tag1)
    {
    	return makeTutuNBT(tag1, true);
    }

    private NBTTagCompound makeTutuNBT(NBTTagCompound tag1, boolean par1)
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

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("arrayAILimit_" + cnt, arrayAILimit[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("arrayAIMaster_" + cnt, arrayAIMaster[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("arrayAISets_" + cnt, arrayAISets[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("arrayAIRate_" + cnt, arrayAIRate[cnt]);
        }

        for(int cnt = 0; cnt < 64; cnt++)
        {
        	nbt.setInteger("arrayAIRateDef_" + cnt, arrayAIRateDef[cnt]);
        }

        nbt.setInteger("flgAIextended", this.flgAIextended);
        nbt.setInteger("flgAIuse", this.flgAIuse);


        nbt.setLong("tamingTime", this.tamingTime);

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
        nbt.setLong("PetUniqueNumber", this.petUniqueNumber);
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

        nbt.setString("PetUUID", this.getUniqueID().toString());
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

        if(par1)
        {
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
        }
        nbt.setString("PetCustomName", this.getCustomNameTag());
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








    public void attackEntityWithHoimi(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade, int tag, EntityLivingBase tagMob)
    {

    	if(DQR.debug == 4){System.out.println("attackEntityWithHoimi 4");}
    	if(tag == 1)
    	{
    		if(DQR.debug == 4){System.out.println("attackEntityWithHoimi 1");}
	    	MagicEntity magic = null;
			PotionEffect pe;
			pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
			if(pe != null && !this.worldObj.isRemote)
			{
				return;
			}
			//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
			//if(pe != null && !this.worldObj.isRemote)
			if(DQR.func.isBind(this))
			{
				return;
			}

    		if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);


			if((this.MP >= grade.getMP()|| this.MaxMP == -1) || DQR.debug == 4)
			{
				int attackDam = grade.getAttack();

				this.MP = this.MP -grade.getMP();
				//magic.setDamage(attackDam);


				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

				if(this.isPotionActive(DQPotionPlus.buffMahokanta))
				{
					if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
				}else
				{
					if(this.getHealth() > 0.5F)
					{
		            	if(this.getHealth() + attackDam > this.getMaxHealth())
		            	{
		            		this.setHealth(this.getMaxHealth());
		            	}else
		            	{
		            		//this.setHealth(this.getHealth() + (float)attackDam);
		            		this.heal(attackDam);
		            	}
					}

	            	if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.hoimi", 1.0F, 1.0F);
				}
			}else
			{
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
				return;
			}
    	}else
	    {
    		if(DQR.debug == 4){System.out.println("attackEntityWithHoimi 2");}
	    	MagicEntity magic = null;
			PotionEffect pe;
			pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
			if(pe != null && !this.worldObj.isRemote)
			{
				return;
			}
			//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
			//if(pe != null && !this.worldObj.isRemote)
			if(DQR.func.isBind(this))
			{
				return;
			}

		   	magic = new MagicEntityHoimiDummy(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);


			if(magic != null)
			{


				if((this.MP >= grade.getMP()|| this.MaxMP == -1) || DQR.debug == 4)
				{
					int attackDam = grade.getAttack();

					//magic.setDamage(attackDam);


					if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
					this.MP = this.MP - grade.getMP();
					/*
		        	if (!this.worldObj.isRemote)
		        	{
		        		this.worldObj.spawnEntityInWorld(magic);
		        	}
		        	*/


	        		if(tagMob.isPotionActive(DQPotionPlus.buffMahokanta))
	        		{
	                	if(this.getHealth() + attackDam > this.getMaxHealth())
	                	{
	                		this.setHealth(this.getMaxHealth());
	                	}else
	                	{
	                		//this.setHealth(this.getHealth() + (float)attackDam);
	                		this.heal(attackDam);
	                	}
	                	if(!tagMob.worldObj.isRemote) tagMob.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
	                	this.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        		}else
	        		{
	        			if(tagMob.getHealth() > 0.5F || (tagMob instanceof EntityPlayer && tagMob.getHealth() > 0))
	        			{
		                	if(tagMob.getHealth() + attackDam > tagMob.getMaxHealth())
		                	{
		                		tagMob.setHealth(tagMob.getMaxHealth());
		                	}else
		                	{
		                		//tagMob.setHealth(tagMob.getHealth() + (float)attackDam);
		                		tagMob.heal(attackDam);
		                	}
		                	if(!tagMob.worldObj.isRemote) tagMob.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        			}
	        		}
				}else
				{
					magic = null;
					if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
				}
			}
	    }
    }

    public void attackEntityWithBagi(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
		PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}

		if(DQR.func.isBind(this))
		{
			return;
		}

		MagicEntityBagi[] magic = null;


		if(grade == EnumDqmMagic.Bagi)
		{

			magic = new MagicEntityBagi[3];

			magic[0] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[1] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[2] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt].setMaxTicksRange(grade.getTickRange());
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}

		}else if(grade == EnumDqmMagic.Bagima)
		{
			grade = EnumDqmMagic.Bagima;
			magic = new MagicEntityBagi[3];
			magic[0] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[1] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[2] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt].setMaxTicksRange(grade.getTickRange());
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}
			/*
	   		minusMP = 6;
	   		minusDam = 150;
	   		needLvS = 22;
	   		//needLvK = 18;
			*/
		}else if(grade == EnumDqmMagic.Bagikurosu)
		{
			grade = EnumDqmMagic.Bagikurosu;
			magic = new MagicEntityBagi[5];
			magic[0] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[1] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[2] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[3] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, -22.5F, 0.0F);
			magic[4] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 22.5F, 0.0F);
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt].setMaxTicksRange(grade.getTickRange());
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}

			/*
	   		minusMP = 12;
	   		minusDam = 200;
	   		needLvS = 38;
	   		//needLvK = 31;
			*/
		}else if(grade == EnumDqmMagic.Bagimutyo)
		{
			grade = EnumDqmMagic.Bagimutyo;
			magic = new MagicEntityBagi[5];
			magic[0] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[1] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[2] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[3] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, -1.0F, 0.0F, 0.0F, -22.5F, 0.0F);
			magic[4] = new MagicEntityBagi(p_82196_1_.worldObj, this, 1.5F, 1.0F, 1.0F, 0.0F, 0.0F, 22.5F, 0.0F);
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt].setMaxTicksRange(grade.getTickRange());
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}
			/*
	   		minusMP = 21;
	   		minusDam = 300;
	   		needLvS = 63;
	   		*/
	   		//needLvK = 58;

		}

		if(magic != null)
		{

			if(this.MP >= grade.getMP() || this.MaxMP == -1 || DQR.debug > 0)
			{
				int attackDam = grade.getAttack();

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.MP = this.MP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{
    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;

				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }


    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
    {
		//PotionEffect pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
    	if(DQR.func.isBind(this))
		{
			return;
		}

    	MagicEntityArrow entityarrow = new MagicEntityArrow(this.worldObj, this, 1.5F, 1.0F, 0.0f, 0.0F, 0.0F);

        entityarrow.setDamage(this.Kougeki);
        entityarrow.shootingEntity = this;
        if(this.getOwner() != null)
		{
        	entityarrow.setShootingEntityOwner(this.getOwner());
		}
        /*
        if (i > 0)
        {
            entityarrow.setDamage(entityarrow.getDamage() + (double)i * 0.5D + 0.5D);
        }

        if (j > 0)
        {
            entityarrow.setKnockbackStrength(j);
        }
        */

        /*
        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, this.getHeldItem()) > 0 || this.getSkeletonType() == 1)
        {
            entityarrow.setFire(100);
        }
        */

        if(!this.worldObj.isRemote)
        {
        	this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        	this.worldObj.spawnEntityInWorld(entityarrow);
        }

    }

    public void attackEntityWithDoruma(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
		PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{

			return;
		}



    	MagicEntity[] magic = null;
    	Random rand = new Random();
    	int frame = 0;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/


		if(grade == EnumDqmMagic.Doruma)
		{
			magic = new MagicEntity[5];
			for(int cnt = 1;cnt < 5; cnt++)
			{
				frame = rand.nextInt(180) * 2;
				magic[cnt] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(frame - 180), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}

			/*
	   		minusMP = 5;
	   		minusDam = 100;
	   		needLvM = 12;
	   		needLvK = 15;
	   		*/

		}else if(grade == EnumDqmMagic.Dorukuma)
		{
			magic = new MagicEntity[8];
			for(int cnt = 1;cnt < 8; cnt++)
			{
				frame = rand.nextInt(180) * 2;
				magic[cnt] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(frame - 180), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}

			/*
	   		minusMP = 12;
	   		minusDam = 150;
	   		needLvM = 27;
	   		needLvK = 27;
	   		*/

		}else if(grade == EnumDqmMagic.Dorumoa)
		{
			magic = new MagicEntity[16];
			for(int cnt = 1;cnt < 16; cnt++)
			{
				frame = rand.nextInt(180) * 2;
				magic[cnt] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(frame - 180), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}

			}
			/*
	   		minusMP = 21;
	   		minusDam = 200;
	   		needLvM = 42;
	   		needLvK = 38;
	   		*/

		}else if(grade == EnumDqmMagic.Dorumadon)
		{
			magic = new MagicEntity[32];
			for(int cnt = 1;cnt < 32; cnt++)
			{
				frame = rand.nextInt(180) * 2;
				magic[cnt] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(frame - 180), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}

			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/

		}

		magic[0] = new MagicEntityDoruma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		magic[0].shootingEntity = this;
		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{
			if(this.MP >= grade.getMP() || this.MaxMP == -1)
			{
				int attackDam = grade.getAttack();

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.MP = this.MP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }

    public void attackEntityWithGira(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

    	MagicEntity[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Gira)
		{

			magic = new MagicEntity[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityGira(this.worldObj, this, 1.5F, 1.0F, (float)(-1 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}
			/*
	   		minusMP = 2;
	   		minusDam = 100;
	   		needLvM = 9;
	   		needLvK = 12;
	   		*/

		}else if(grade == EnumDqmMagic.Begirama)
		{
			magic = new MagicEntity[5];
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt] = new MagicEntityBegirama(this.worldObj, this, 1.5F, 1.0F, (float)(-2 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}
			/*
	   		minusMP = 5;
	   		minusDam = 150;
	   		needLvM = 23;
	   		needLvK = 23;
	   		*/

		}else if(grade == EnumDqmMagic.Begiragon)
		{
			magic = new MagicEntity[7];
			for(int cnt = 0;cnt < 7; cnt++)
			{
				magic[cnt] = new MagicEntityBegiragon(this.worldObj, this, 1.5F, 1.0F, (float)(-3 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}
			/*
	   		minusMP = 10;
	   		minusDam = 200;
	   		needLvM = 38;
	   		needLvK = 35;
	   		*/

		}else if(grade == EnumDqmMagic.Giragureido)
		{
			magic = new MagicEntity[9];
			for(int cnt = 0;cnt < 9; cnt++)
			{
				magic[cnt] = new MagicEntityGiragureido(this.worldObj, this, 1.5F, 1.0F, (float)(-4 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}
			/*
	   		minusMP = 18;
	   		minusDam = 300;
	   		needLvM = 67;
	   		needLvK = 63;
	   		*/

		}

		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{

			if(this.MP >= grade.getMP() || this.MaxMP == -1)
			{
				int attackDam = grade.getAttack();

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.MP = this.MP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}

		}
    }


    public void attackEntityWithHyado(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
    	PotionEffect pe;

		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}


    	MagicEntityHyado[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Hyado)
		{
			magic = new MagicEntityHyado[1];
			for(int cnt = 0;cnt < 1; cnt++)
			{
				magic[cnt] = new MagicEntityHyado(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(0);
			}

			/*
	   		minusMP = 3;
	   		minusDam = 100;
	   		needLvM = 5;
	   		needLvK = 8;
	   		*/

		}else if(grade == EnumDqmMagic.Hyadaruko)
		{
			magic = new MagicEntityHyado[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityHyado(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-15.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(1);
			}

			/*
	   		minusMP = 6;
	   		minusDam = 150;
	   		needLvM = 18;
	   		needLvK = 18;
	   		*/

		}else if(grade == EnumDqmMagic.Mahyado)
		{
			magic = new MagicEntityHyado[5];
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt] = new MagicEntityHyado(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-30.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(2);
			}
			/*
	   		minusMP = 11;
	   		minusDam = 200;
	   		needLvM = 34;
	   		needLvK = 31;
	   		*/

		}else if(grade == EnumDqmMagic.Mahyadodesu)
		{
			magic = new MagicEntityHyado[7];
			for(int cnt = 0;cnt < 7; cnt++)
			{
				magic[cnt] = new MagicEntityHyado(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(3);
			}
			/*
	   		minusMP = 21;
	   		minusDam = 300;
	   		needLvM = 63;
	   		needLvK = 58;
	   		*/

		}


		if(magic != null)
		{

			if(this.MP >= grade.getMP()|| this.MaxMP == -1)
			{
				int attackDam = grade.getAttack();

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.MP = this.MP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}

    }


    public void attackEntityWithIo(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		MagicEntityIo[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Io)
		{
			magic = new MagicEntityIo[8];
			for(int cnt = 0;cnt < 8; cnt++)
			{
				magic[cnt] = new MagicEntityIo(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-135.0F + (45.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				magic[cnt].setMaxTicksRange(grade.getTickRange());
			}

			/*
	   		minusMP = 5;
	   		minusDam = 100;
	   		needLvM = 12;
	   		needLvK = 15;
	   		*/

		}else if(grade == EnumDqmMagic.Iora)
		{
			magic = new MagicEntityIo[8];
			for(int cnt = 0;cnt < 8; cnt++)
			{
				magic[cnt] = new MagicEntityIo(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-135.0F + (45.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				magic[cnt].setMaxTicksRange(grade.getTickRange());
			}

			/*
	   		minusMP = 12;
	   		minusDam = 150;
	   		needLvM = 27;
	   		needLvK = 27;
	   		*/

		}else if(grade == EnumDqmMagic.Ionazun)
		{
			magic = new MagicEntityIo[16];
			for(int cnt = 0;cnt < 16; cnt++)
			{
				magic[cnt] = new MagicEntityIo(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				magic[cnt].setMaxTicksRange(grade.getTickRange());
			}
			/*
	   		minusMP = 21;
	   		minusDam = 200;
	   		needLvM = 42;
	   		needLvK = 38;
	   		*/

		}else if(grade == EnumDqmMagic.Iogurande)
		{
			magic = new MagicEntityIo[16];
			for(int cnt = 0;cnt < 16; cnt++)
			{
				magic[cnt] = new MagicEntityIo(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				magic[cnt].setMaxTicksRange(grade.getTickRange());
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/

		}

		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{

			if(this.MP >= grade.getMP()|| this.MaxMP == -1)
			{
				int attackDam = grade.getAttack();


				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.MP = this.MP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		magic[cnt].setWorldFlg(this.isSneaking());
    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }


    public void attackEntityWithMera(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {

    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

    	MagicEntity magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	*/

		if(grade == EnumDqmMagic.Mera)
		{
	   		magic = new MagicEntityMera(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
			magic.shootingEntity = this;
			if(this.getOwner() != null)
			{
				magic.setShootingEntityOwner(this.getOwner());
			}

	   		((MagicEntityMera) magic).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
	   		/*
	   		minusMP = 2;
	   		minusDam = 100;
	   		needLvM = 3;
	   		needLvK = 5;
	   		*/

		}else if(grade == EnumDqmMagic.Merami)
		{
			magic = new MagicEntityMerami(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
			magic.shootingEntity = this;
			if(this.getOwner() != null)
			{
				magic.setShootingEntityOwner(this.getOwner());
			}
			((MagicEntityMerami) magic).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			/*
	   		minusMP = 5;
	   		minusDam = 150;
	   		needLvM = 15;
	   		needLvK = 15;
	   		*/


		}else if(grade == EnumDqmMagic.Merazoma)
		{
			magic = new MagicEntityMerazoma(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
			magic.shootingEntity = this;
			if(this.getOwner() != null)
			{
				magic.setShootingEntityOwner(this.getOwner());
			}
			((MagicEntityMerazoma) magic).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			/*
	   		minusMP = 10;
	   		minusDam = 200;
	   		needLvM = 29;
	   		needLvK = 25;
	   		*/

		}else if(grade == EnumDqmMagic.Meragaia)
		{
			magic = new MagicEntityMeragaia(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
			magic.shootingEntity = this;
			if(this.getOwner() != null)
			{
				magic.setShootingEntityOwner(this.getOwner());
			}
			((MagicEntityMeragaia) magic).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			/*
	   		minusMP = 18;
	   		minusDam = 300;
	   		needLvM = 55;
	   		needLvK = 49;
	   		*/

		}

		if(magic != null)
		{


			if(this.MP >= grade.getMP()|| this.MaxMP == -1)
			{
				int attackDam = grade.getAttack();

				magic.setDamage(attackDam);

				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.MP = this.MP - grade.getMP();
	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic);

	        	}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }


    public void attackEntityWithRaidein(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {

    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

    	MagicEntity[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Raidein)
		{
			magic = new MagicEntity[1];
			for(int cnt = 0;cnt < 1; cnt++)
			{
				magic[cnt] = new MagicEntityRaidein(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}

			/*
	   		minusMP = 3;
	   		minusDam = 100;
	   		needLvM = 5;
	   		needLvK = 8;
	   		*/

		}else if(grade == EnumDqmMagic.Gigadein)
		{
			magic = new MagicEntity[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityRaidein(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (45.0F * cnt)), 0.0F, 1);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}

			/*
	   		minusMP = 6;
	   		minusDam = 150;
	   		needLvM = 18;
	   		needLvK = 18;
	   		*/

		}else if(grade == EnumDqmMagic.Minadein)
		{
			magic = new MagicEntity[5];
			for(int cnt = 0;cnt < 5; cnt++)
			{
				magic[cnt] = new MagicEntityRaidein(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-90.0F + (45.0F * cnt)), 0.0F, 2);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}
			/*
	   		minusMP = 11;
	   		minusDam = 200;
	   		needLvM = 34;
	   		needLvK = 31;
	   		*/

		}


		if(magic != null)
		{

			if(this.MP >= grade.getMP()|| this.MaxMP == -1)
			{
				int attackDam = grade.getAttack();


				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				this.MP = this.MP - grade.getMP();
        		for(int cnt = 0; cnt < magic.length; cnt++)
        		{
    				magic[cnt].setDamage(attackDam);
    	        	if (!this.worldObj.isRemote)
    	        	{

    	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

    	        	}
        		}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}
		}
    }


    public void attackEntityWithZaki(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}



		MagicEntityZaki[] magic = null;

		if(grade == EnumDqmMagic.Zaki)
		{
			magic = new MagicEntityZaki[1];
			magic[0] = new MagicEntityZaki(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[0].shootingEntity = this;
			if(this.getOwner() != null)
			{
				magic[0].setShootingEntityOwner(this.getOwner());
			}
		}else if(grade == EnumDqmMagic.Zaraki)
		{
			magic = new MagicEntityZaki[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityZaki(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (45.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
			}
		}else if(grade == EnumDqmMagic.Zarakima)
		{
			magic = new MagicEntityZaki[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityZaki(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (45.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				magic[cnt].setBoxHit(3);
			}

		}

		//System.out.println("TEST MP : " + this.DqmMobMP + " : " + grade.getMP() + " : " + this.DqmMobMaxMP);
		if(this.MP < grade.getMP() && this.MaxMP != -1)
		{
			if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			return;
		}else
		{
			this.MP = this.MP - grade.getMP();
		}
		//System.out.println("TEST MPX");
    	//magic = new MagicEntityZaki(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F,   0.0F, 0.0F);

		if(magic != null)
		{
			//System.out.println("TEST MPR : " + magic.length);
			//int epMP = ExtendedPlayerProperties.get(this).getMP();

			for(int cnt = 0; cnt < magic.length; cnt ++ )
			{
				magic[cnt].setDamage(0);
				magic[cnt].setRate(grade.getRate());
				//magic[cnt].setRate(90);
				//magic.setPotionEffect(new PotionEffect(this.pot.id, grade.getAttack(), 0));
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic[cnt]);

	        	}
			}
        }
    }


    public void attackEntityWithHonoo(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {

       	PotionEffect pe;

		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		MagicEntity[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Hinoiki)
		{
			magic = new MagicEntityMeraB[1];
			magic[0] = new MagicEntityMeraB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[0].shootingEntity = this;
			if(this.getOwner() != null)
			{
				magic[0].setShootingEntityOwner(this.getOwner());
			}
			((MagicEntityMeraB) magic[0]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			/*
	   		minusMP = 5;
	   		minusDam = 100;
	   		needLvM = 12;
	   		needLvK = 15;
	   		*/

		}else if(grade == EnumDqmMagic.Kaeniki)
		{
			magic = new MagicEntityMeramiB[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityMeramiB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-15.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				((MagicEntityMeramiB) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			}

			/*
	   		minusMP = 12;
	   		minusDam = 150;
	   		needLvM = 27;
	   		needLvK = 27;
	   		*/

		}else if(grade == EnumDqmMagic.HagesiiHonoo)
		{
			magic = new MagicEntityMeramiB[7];
			for(int cnt = 0;cnt < 7; cnt++)
			{
				magic[cnt] = new MagicEntityMeramiB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (15.0F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				((MagicEntityMeramiB) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			}
			/*
	   		minusMP = 21;
	   		minusDam = 200;
	   		needLvM = 42;
	   		needLvK = 38;
	   		*/

		}else if(grade == EnumDqmMagic.Syakunetu)
		{
			magic = new MagicEntityMerazomaB[16];
			for(int cnt = 0;cnt < 16; cnt++)
			{
				magic[cnt] = new MagicEntityMerazomaB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				((MagicEntityMerazomaB) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/

		}else if(grade == EnumDqmMagic.RengokuHonoo)
		{
			magic = new MagicEntityMeragaiaB[32];
			for(int cnt = 0;cnt < 32; cnt++)
			{
				magic[cnt] = new MagicEntityMeragaiaB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (11.25F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				((MagicEntityMeragaiaB) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/
		}

		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{

			int attackDam = grade.getAttack();

			//this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

    		for(int cnt = 0; cnt < magic.length; cnt++)
    		{
				magic[cnt].setDamage(attackDam);
	        	if (!this.worldObj.isRemote)
	        	{
	        		//magic[cnt].setWorldFlg(this.isSneaking());
	        		this.worldObj.spawnEntityInWorld(magic[cnt]);
	        	}
    		}

		}
    }

    public void attackEntityWithFubuki(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
       	PotionEffect pe;

		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		MagicEntityHyadoB[] magic = null;
    	/*
    	int minusMP = 0;
    	int minusDam = 0;
    	int needLvM = 0;
    	int needLvK = 0;
    	int hitCnt = 0;
    	*/

		if(grade == EnumDqmMagic.Tumetaiiki)
		{
			magic = new MagicEntityHyadoB[1];
			magic[0] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			magic[0].shootingEntity = this;
			if(this.getOwner() != null)
			{
				magic[0].setShootingEntityOwner(this.getOwner());
			}
			if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[0].setWorldFlg(0);
			/*
	   		minusMP = 5;
	   		minusDam = 100;
	   		needLvM = 12;
	   		needLvK = 15;
	   		*/

		}else if(grade == EnumDqmMagic.Koorinoiki)
		{
			magic = new MagicEntityHyadoB[3];
			for(int cnt = 0;cnt < 3; cnt++)
			{
				magic[cnt] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, (float)(-1 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(1);
			}

			/*
	   		minusMP = 12;
	   		minusDam = 150;
	   		needLvM = 27;
	   		needLvK = 27;
	   		*/

		}else if(grade == EnumDqmMagic.Kogoeruhubuki)
		{
			magic = new MagicEntityHyadoB[7];
			for(int cnt = 0;cnt < 7; cnt++)
			{
				magic[cnt] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, (float)(-2 + cnt), 0.0F, 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(2);
			}
			/*
	   		minusMP = 21;
	   		minusDam = 200;
	   		needLvM = 42;
	   		needLvK = 38;
	   		*/

		}else if(grade == EnumDqmMagic.Kagayakuiki)
		{
			magic = new MagicEntityHyadoB[16];
			for(int cnt = 0;cnt < 16; cnt++)
			{
				magic[cnt] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(3);
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/

		}else if(grade == EnumDqmMagic.Zettaireido)
		{
			magic = new MagicEntityHyadoB[32];
			for(int cnt = 0;cnt < 32; cnt++)
			{
				magic[cnt] = new MagicEntityHyadoB(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (11.25F * cnt)), 0.0F);
				magic[cnt].shootingEntity = this;
				if(this.getOwner() != null)
				{
					magic[cnt].setShootingEntityOwner(this.getOwner());
				}
				if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(4);
			}
			/*
	   		minusMP = 38;
	   		minusDam = 300;
	   		needLvM = 72;
	   		needLvK = 67;
	   		*/
		}

		/*
    	minusMP = 0;
    	minusDam = 0;
    	needLvM = 0;
    	needLvK = 0;
    	hitCnt = 0;
    	*/

		if(magic != null)
		{

			int attackDam = grade.getAttack();

			//this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

    		for(int cnt = 0; cnt < magic.length; cnt++)
    		{
				magic[cnt].setDamage(attackDam);
	        	if (!this.worldObj.isRemote)
	        	{
	        		//magic[cnt].setWorldFlg(this.isSneaking());
	        		this.worldObj.spawnEntityInWorld(magic[cnt]);
	        	}
    		}

		}
    }


    public void attackEntityWithBehomara(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade)
    {
		PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return ;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		if(this.MP < grade.getMP() &&  this.MaxMP != -1)
		{
			if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			return;
		}else
		{
			this.MP = this.MP - grade.getMP();
		}


		//DQR.func.addPotionEffect2(this, new PotionEffect(this.pot.id, grade.getAttack(), 0));
		if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
		//this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);
		int attackDam = grade.getAttack();

		if(this.isPotionActive(DQPotionPlus.buffMahokanta))
		{
			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
		}else
		{
        	if(this.getHealth() + attackDam > this.getMaxHealth())
        	{
        		this.setHealth(this.getMaxHealth());
        	}else
        	{
        		//this.setHealth(this.getHealth() + (float)attackDam);
        		this.heal(attackDam);
        	}
        	if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.hoimi", 1.0F, 1.0F);
		}

    	EntityPlayer owner = null;

    	if(this.getOwner() != null && this.getOwner() instanceof EntityPlayer)
    	{
    		owner = (EntityPlayer)this.getOwner();
    	}


        List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
        		this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(10.0D, 5.0D, 10.0D));

        if (list != null && !list.isEmpty())
        {
        	for (int n = 0 ; n < list.size() ; n++)
        	{
        		Entity target = (Entity)list.get(n);
        		boolean flg = false;

        		if(target instanceof EntityPlayer)
        		{
        			EntityPlayer entityplayer = (EntityPlayer)target;

        			if(owner != null && (entityplayer.capabilities.disableDamage || !owner.canAttackPlayer(entityplayer)))
                    {
                    	//PvPが許可されていないと当たらない
        				flg = true;
                    }else if(owner != null && target == owner)
                    {
                    	flg = true;
                    }
        		}else if(target instanceof DqmPetBase)
        		{
                	if(owner != null && !(DQR.func.canAttackPetMonster((DqmPetBase)target, owner)))
                	{
                		DqmPetBase tagPet = (DqmPetBase)target;
                		if(tagPet.getHealth() > 0.5F)
                		{
                			flg = true;
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

        		if(flg && target instanceof EntityLivingBase)
        		{
        			attackDam = grade.getAttack();

    				EntityLivingBase elb = (EntityLivingBase)target;

                	PotionEffect pe2 = null;
            		pe2 = elb.getActivePotionEffect(DQPotionPlus.buffMahokanta);

            		if(pe2 != null)
            		{
                    	if(this.getHealth() + attackDam > this.getMaxHealth())
                    	{
                    		this.setHealth(this.getMaxHealth());
                    	}else
                    	{
                    		//this.setHealth(this.getHealth() + (float)attackDam);
                    		this.heal(attackDam);
                    	}
                    	if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
                    	this.worldObj.playSoundAtEntity(this, "dqr:player.hoimi", 1.0F, 1.0F);
            		}
            		else
            		{
            			if(elb.getHealth() > 0)
            			{
	                    	if(elb.getHealth() + attackDam > elb.getMaxHealth())
	                    	{
	                    		elb.setHealth(elb.getMaxHealth());
	                    	}else
	                    	{
	                    		//elb.setHealth(elb.getHealth() + (float)attackDam);
	                    		elb.heal(attackDam);
	                    	}
	                    	if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.hoimi", 1.0F, 1.0F);
            			}
            		}
        		}

        		/*
        		if (target != null && target instanceof EntityLivingBase && !(target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse))
        		{
    				attackDam = grade.getAttack();

    				EntityLivingBase elb = (EntityLivingBase)target;

                	PotionEffect pe2 = null;
            		pe2 = elb.getActivePotionEffect(DQPotionPlus.buffMahokanta);

            		if(pe2 != null)
            		{
                    	if(this.getHealth() + attackDam > this.getMaxHealth())
                    	{
                    		this.setHealth(this.getMaxHealth());
                    	}else
                    	{
                    		this.setHealth(this.getHealth() + (float)attackDam);
                    	}
                    	if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
                    	this.worldObj.playSoundAtEntity(this, "dqr:player.hoimi", 1.0F, 1.0F);
            		}
            		else
            		{
            			if(elb.getHealth() > 0)
            			{
	                    	if(elb.getHealth() + attackDam > elb.getMaxHealth())
	                    	{
	                    		elb.setHealth(elb.getMaxHealth());
	                    	}else
	                    	{
	                    		elb.setHealth(elb.getHealth() + (float)attackDam);
	                    	}
	                    	if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.hoimi", 1.0F, 1.0F);
            			}
            		}
            	}
					*/
        	}
        }
    }


    public void attackEntityWithBuff(EntityLivingBase p_82196_1_, float p_82196_2_, Potion pot, EnumDqmMagic grade, int tag, EntityLivingBase tagMob)
    {
    	PotionEffect pe;

		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}


		if(this.MP < grade.getMP() && this.MaxMP != -1)
		{
			if(!this.worldObj.isRemote && DQR.conf.offMobNotEnoughMP > 0) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			return;
		}else
		{
			this.MP = this.MP - grade.getMP();
		}


		if(grade == EnumDqmMagic.Sukuruto || grade == EnumDqmMagic.Fubaha ||grade == EnumDqmMagic.Piorimu)
		{
			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
			if(this.isPotionActive(DQPotionPlus.buffMahokanta))
			{
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
			}else
			{
				DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 0));
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);
			}

	    	EntityPlayer owner = null;

	    	if(this.getOwner() != null && this.getOwner() instanceof EntityPlayer)
	    	{
	    		owner = (EntityPlayer)this.getOwner();
	    	}

            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
            		this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(10.0D, 5.0D, 10.0D));

            if (list != null && !list.isEmpty())
            {
            	for (int n = 0 ; n < list.size() ; n++)
            	{
            		Entity target = (Entity)list.get(n);

            		boolean flg = false;

            		if(target instanceof EntityPlayer)
            		{
            			EntityPlayer entityplayer = (EntityPlayer)target;

            			if(owner != null && (entityplayer.capabilities.disableDamage || !owner.canAttackPlayer(entityplayer)))
                        {
                        	//PvPが許可されていないと当たらない
            				flg = true;
                        }else if(owner != null && target == owner)
                        {
                        	flg = true;
                        }
            		}else if(target instanceof DqmPetBase)
            		{
                    	if(owner != null && !(DQR.func.canAttackPetMonster((DqmPetBase)target, owner)))
                    	{
                    		flg = true;
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

            		if(flg && target instanceof EntityLivingBase)
            		{
               			EntityLivingBase elb = (EntityLivingBase)target;
            			if(elb.isPotionActive(DQPotionPlus.buffMahokanta))
            			{
            				DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 0));
            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
            				this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);
            			}else
            			{
            				DQR.func.addPotionEffect2(elb, new PotionEffect(pot.id, grade.getAttack(), 0));
            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.up", 1.0F, 1.0F);
            			}
            		}
            		/*
            		if(target != null && target instanceof EntityLivingBase && !(target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse))
            		{
            			EntityLivingBase elb = (EntityLivingBase)target;
            			if(elb.isPotionActive(DQPotionPlus.buffMahokanta))
            			{
            				DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 0));
            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
            				this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);
            			}else
            			{
            				DQR.func..addPotionEffect2(elb, new PotionEffect(pot.id, grade.getAttack(), 0));
            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.up", 1.0F, 1.0F);
            			}
            		}
            		*/
            	}
            }

            return;
		}else if(tag == 0)
    	{
        	MagicEntityBuffDummy magic = null;

        	magic = new MagicEntityBuffDummy(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);

    		if(magic != null)
    		{
    			//int epMP = ExtendedPlayerProperties.get(this).getMP();

				magic.setDamage(0);
				//magic.setPotionEffect(new PotionEffect(pot.id, grade.getAttack(), 1));
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);


				/*
	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic);

	        	}
	        	*/

	        	if(tagMob != null)
	        	{
	        		if(tagMob.isPotionActive(DQPotionPlus.buffMahokanta))
	        		{
	        			if(!tagMob.worldObj.isRemote) tagMob.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
	        			DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 1));
	        			this.playSound("dqr:player.up", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        		}else{
	        			DQR.func.addPotionEffect2(tagMob, new PotionEffect(pot.id, grade.getAttack(), 1));
	        			if(!tagMob.worldObj.isRemote) tagMob.playSound("dqr:player.up", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        		}
	        	}
	        }
    	}else
    	{
    		if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
    		if(this.isPotionActive(DQPotionPlus.buffMahokanta))
    		{
    			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
    		}else
    		{
    			DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 1));
    			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);
    		}
    	}
    }

    public void attackEntityWithDebuff(EntityLivingBase p_82196_1_, float p_82196_2_, Potion pot, EnumDqmMagic grade, EntityLivingBase tagMob)
    {
    	PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}


		if(this.MP < grade.getMP() && this.MaxMP != -1)
		{
			if(!this.worldObj.isRemote && DQR.conf.offMobNotEnoughMP > 0) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.25F, 1.0F);
			return;
		}else
		{
			MP = MP - grade.getMP();
		}


		if(grade == EnumDqmMagic.Rukanan || grade == EnumDqmMagic.Rarihoma ||grade == EnumDqmMagic.Bomiosu ||
		   grade == EnumDqmMagic.Rariho || grade == EnumDqmMagic.Manusa || grade == EnumDqmMagic.Mahoton ||
		   grade == EnumDqmMagic.Medapani || grade == EnumDqmMagic.Divainsuperu)
		{
    		//DQR.func.addPotionEffect2(this, new PotionEffect(this.pot.id, grade.getAttack(), 0));
			if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
			//this.worldObj.playSoundAtEntity(this, "dqr:player.up", 1.0F, 1.0F);

	    	EntityPlayer owner = null;

	    	if(this.getOwner() != null && this.getOwner() instanceof EntityPlayer)
	    	{
	    		owner = (EntityPlayer)this.getOwner();
	    	}


            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
            		this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(10.0D, 5.0D, 10.0D));

            if (list != null && !list.isEmpty())
            {
            	for (int n = 0 ; n < list.size() ; n++)
            	{
            		Entity target = (Entity)list.get(n);
            		boolean flg = false;

            		if(target instanceof EntityPlayer)
            		{
            			EntityPlayer entityplayer = (EntityPlayer)target;

            			if(owner != null && (entityplayer.capabilities.disableDamage || !owner.canAttackPlayer(entityplayer)))
                        {
                        	//PvPが許可されていないと当たらない
                        }else if(owner != null && target == owner)
                        {
                        }else if(entityplayer.capabilities.isCreativeMode)
                        {
                        }else
                        {
                        	flg = true;
                        }
            		}else if(target instanceof DqmPetBase)
            		{
                    	if(owner != null && !(DQR.func.canAttackPetMonster((DqmPetBase)target, owner)))
                    	{
                    	}else
                    	{
                    		flg = true;
                    	}
            		}else if (target instanceof DqmPetBase)
            		{
            			flg = true;
            			/*
            			if(((DqmMobBase) target).getHealth() < ((DqmMobBase) target).getMaxHealth())
            			{
            				this.tagetMob = (DqmMobBase)target;
            				return true;
            			}
            			*/
            		}

            		if(flg && target instanceof EntityLivingBase)
            		{
            			Random rand = new Random();
            			int ratePer = rand.nextInt(100);
            			//System.out.println(grade.getRate() + "/" + ratePer);
            			if(ratePer < grade.getRate())
            			{
	            			EntityLivingBase elb = (EntityLivingBase)target;
	            			if(elb instanceof EntityPlayer && ((EntityPlayer)elb).capabilities.isCreativeMode)
	            			{
	            				//クリエの場合無効
	            				;
	            			}else
	            			{
		            			if(elb.isPotionActive(DQPotionPlus.buffMahokanta))
		            			{
		            				DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 0));
		            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
		            				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.down", 1.0F, 1.0F);
		            			}else
		            			{
		            				DQR.func.addPotionEffect2(elb, new PotionEffect(pot.id, grade.getAttack(), 0));
		            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.down", 1.0F, 1.0F);
		            			}
	            			}
            			}
            		}
            		/*
            		if (target != null && target instanceof EntityLivingBase && target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse)
            		{
            			Random rand = new Random();
            			int ratePer = rand.nextInt(100);
            			//System.out.println(grade.getRate() + "/" + ratePer);
            			if(ratePer < grade.getRate())
            			{
	            			EntityLivingBase elb = (EntityLivingBase)target;
	            			if(elb instanceof EntityPlayer && ((EntityPlayer)elb).capabilities.isCreativeMode)
	            			{
	            				//クリエの場合無効
	            				;
	            			}else
	            			{
		            			if(elb.isPotionActive(DQPotionPlus.buffMahokanta))
		            			{
		            				DQR.func.addPotionEffect2(this, new PotionEffect(pot.id, grade.getAttack(), 0));
		            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
		            				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.down", 1.0F, 1.0F);
		            			}else
		            			{
		            				DQR.func..addPotionEffect2(elb, new PotionEffect(pot.id, grade.getAttack(), 0));
		            				if(!elb.worldObj.isRemote) elb.worldObj.playSoundAtEntity(elb, "dqr:player.down", 1.0F, 1.0F);
		            			}
	            			}
            			}
            		}
            		*/
            	}
            }

            return;
		}else
    	{
			MagicEntityDebuff magic = null;

        	magic = new MagicEntityDebuff(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);

    		if(magic != null)
    		{
    			//int epMP = ExtendedPlayerProperties.get(this).getMP();

				magic.setDamage(0);
				magic.setRate(grade.getRate());
				magic.setPotionEffect(new PotionEffect(pot.id, grade.getAttack(), 1));
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic);

	        	}
	        }
    	}

    }

    public void attackEntityWithMahoimi(EntityLivingBase p_82196_1_, float p_82196_2_, EnumDqmMagic grade, EntityLivingBase tagMob)
    {
		PotionEffect pe;
		pe = this.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && !this.worldObj.isRemote)
		{
			return;
		}
		//pe = this.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && !this.worldObj.isRemote)
		if(DQR.func.isBind(this))
		{
			return;
		}

		MagicEntity magic = null;


	   	//magic = new MagicEntityMahoimi(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
		magic = new MagicEntityMahoimiDummy(this.worldObj, this, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);


		if(magic != null)
		{

			if(this.MP >= grade.getMP()|| this.MaxMP == -1)
			{
				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

				int attackDam = grade.getAttack();
				/*
	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic);
	        	}
	        	*/

	        	this.MP = this.MP - grade.getMP();
	        	if(tagMob.isPotionActive(DQPotionPlus.buffMahokanta))
	        	{
	        		if(!tagMob.worldObj.isRemote) tagMob.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
        			this.MP = this.MP + attackDam;
        			if(!this.worldObj.isRemote) this.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        	}else if(tagMob instanceof EntityPlayer)
				{
					EntityPlayer ep = (EntityPlayer)tagMob;
					if(ExtendedPlayerProperties.get(ep).getMP() + attackDam > ExtendedPlayerProperties.get(ep).getMaxMP())
					{
						ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
					}else
					{
						ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMP() + attackDam);
					}
					if(!this.worldObj.isRemote) this.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
				}else if(tagMob instanceof DqmPetBase)
				{
					DqmPetBase tag = (DqmPetBase)tagMob;
					if(tag.getMP() + attackDam > tag.getMaxMP())
					{
						tag.setMP(tag.getMaxMP());
					}else
					{
						tag.setMP(tag.getMP() + attackDam);
					}
					if(!this.worldObj.isRemote) this.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
				}
			}else
			{
				magic = null;
				if(DQR.conf.offMobNotEnoughMP > 0 && !this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.pi", 0.1F, 1.0F);
			}

			/*
			if(this.DqmMobMP >= grade.getMP()|| this.DqmMobMaxMP == -1)
			{

				//magic.setDamage(attackDam);


				if(!this.worldObj.isRemote) this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);
				DqmMobMP = DqmMobMP - grade.getMP();
	        	if (!this.worldObj.isRemote)
	        	{
	        		this.worldObj.spawnEntityInWorld(magic);

	        	}

	        	if(tagMob.isPotionActive(DQPotionPlus.buffMahokanta))
	        	{
	        		if(!tagMob.worldObj.isRemote) tagMob.worldObj.playSoundAtEntity(this, "dqr:player.mahokanta", 1.0F, 1.0F);
        			this.DqmMobMP = this.DqmMobMP + attackDam;
        			if(!this.worldObj.isRemote) this.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        	}else
	        	{
	        		tagMob.DqmMobMP = tagMob.DqmMobMP + attackDam;
	        		if(!tagMob.worldObj.isRemote) tagMob.playSound("dqr:player.hoimi", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
	        	}
			}else
			{

			}
			*/
		}
    }

    public void setMegante()
    {
    	MeganteFlg = true;
    }

    @Override
    public void onUpdate()
    {

    	/*
    	if(DQR.func.isBind(this))
    	{
    		//System.out.println("BIND?" + this.isClearTasks);
    	}
    	*/

    	/*
    	if(DQR.func.isBind(this))
    	{
    		this.setAttackTarget(null);
    	}

    	if(DQR.func.isBind(this) && !this.isClearTasks)
    	{
    		//System.out.println("BIND!!!");

    		this.clearTasks();
    		this.isClearTasks = true;
    	}else if(!DQR.func.isBind(this) && this.isClearTasks)
    	{
    		//System.out.println("CLEAR0");
    		this.tasks.removeTask(this.aiBind);

    		//if(this.worldObj != null && !this.worldObj.isRemote)
    		//{
    			this.setDefaultTask();
    			this.setCombatTask();
    			this.isClearTasks = false;
    			//System.out.println("CLEAR");
    		//}
    	}
    	*/



    	if(this.getArrayAISets(EnumDqmMobAI.MEGANTE.getId()) > 0)
    	{
	        if (this.isEntityAlive() && !this.worldObj.isRemote)
	        {
	        	if(MeganteFlg)
	        	{

	            	//System.out.println("TEST" + MeganteCnt);
	            	if(MeganteCnt == 0)
	            	{
	            		if(!this.worldObj.isRemote) this.playSound("creeper.primed", 1.0F, 0.5F);
	            	}else if(MeganteCnt > 20)
	            	{
	            		boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
	            		float explodeRadius = (float)(rand.nextInt(this.getArrayAISets(EnumDqmMobAI.MEGANTE.getId()) / 2) + this.getArrayAISets(EnumDqmMobAI.MEGANTE.getId()) / 2);
	            		if(DQR.conf.magicSpMegante == 0)
	            		{
	            			flag = false;
	            		}

	            		if(!this.worldObj.isRemote)
	            		{
		            		//if
		            		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, explodeRadius, false);


		            		//this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)5.0F, flag);
		            		//this.setDead();
		            		this.attackEntityFrom(DamageSource.magic, this.getHealth() - 0.05F);
		            		this.tasks.removeTask(aiMegante);
		            		MeganteCnt = 0;
	            		}
	            		//Block test = this.worldObj.getBlock((int)this.posX, (int)this.posY, (int)this.posZ).;
		        		MeganteCnt++;
	            	}
	        	}else
	        	{
	        		if(this.getHealth() < this.getMaxHealth() * meganteUseLine / 100 && this.getHealth() > 5.0f)
	        		{
	        			this.tasks.addTask(this.getArrayAIRate(EnumDqmMobAI.MEGANTE.getId()), aiMegante);
	        			//this.tasks.addTask(1, new EntityAIMagicMegante(this));
	        		}
	        	}
	        }
    	}

        super.onUpdate();
    }

    public void setAiBox()
    {
    	EnumDqmMonster mobEnum = DQR.enumGetter.getMonsterFromName(this.type.getPetname());
    	EnumDqmMonsterAI mobAI = mobEnum.getMonsterAI();
    	EnumDqmMonsterAIrate mobAIrate = mobEnum.getMonsterAIrate();

    	//DQR.func.debugString("TEST4 : " + mobEnum.getMobName() + " / " + mobAI.getClassName() + " / " + mobAIrate.getClassName(), this.getClass());
    	for(int cnt = 0; cnt < arrayAIRate.length; cnt++)
    	{
    	    arrayAIRate[cnt] = mobAIrate.getParamFromIndex(cnt);
    	    arrayAIRateDef[cnt] = mobAIrate.getParamFromIndex(cnt);

    	    arrayAILimit[cnt] = mobAI.getParamFromIndex(cnt);
    	    arrayAIMaster[cnt] = -1;
    	    arrayAISets[cnt] = mobAI.getParamFromIndex(cnt);

    	    //DQR.func.debugString("TEST5 : [" + cnt + "] " + mobAI.getParamFromIndex(cnt) + " / " + mobAIrate.getParamFromIndex(cnt) , this.getClass());
    	}

    	flgAIextended = 1;
    }


    public boolean teleportRandomly()
    {
        double d0 = this.posX + (this.rand.nextDouble() - 0.5D) * (double)arrayAISets[EnumDqmMobAI.TELEPORT.getId()];
        double d1 = this.posY + (double)(this.rand.nextInt(3));
        double d2 = this.posZ + (this.rand.nextDouble() - 0.5D) * (double)arrayAISets[EnumDqmMobAI.TELEPORT.getId()];
        return this.teleportTo(d0, d1, d2);
    }

    /**
     * Teleport the enderman to another entity
     */
    public boolean teleportToEntity(Entity p_70816_1_)
    {
        Vec3 vec3 = Vec3.createVectorHelper(this.posX - p_70816_1_.posX, this.boundingBox.minY + (double)(this.height / 2.0F) - p_70816_1_.posY + (double)p_70816_1_.getEyeHeight(), this.posZ - p_70816_1_.posZ);
        vec3 = vec3.normalize();
        double d0 = 16.0D;
        double d1 = this.posX + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.xCoord * d0;
        double d2 = this.posY + (double)(this.rand.nextInt(16) - 8) - vec3.yCoord * d0;
        double d3 = this.posZ + (this.rand.nextDouble() - 0.5D) * 8.0D - vec3.zCoord * d0;
        return this.teleportTo(d1, d2, d3);
    }

    /**
     * Teleport the enderman
     */
    public boolean teleportTo(double p_70825_1_, double p_70825_3_, double p_70825_5_)
    {
        EnderTeleportEvent event = new EnderTeleportEvent(this, p_70825_1_, p_70825_3_, p_70825_5_, 0);
        if (MinecraftForge.EVENT_BUS.post(event)){
            return false;
        }
        double d3 = this.posX;
        double d4 = this.posY;
        double d5 = this.posZ;
        this.posX = event.targetX;
        this.posY = event.targetY;
        this.posZ = event.targetZ;
        boolean flag = false;
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.posY);
        int k = MathHelper.floor_double(this.posZ);

        if (this.worldObj.blockExists(i, j, k))
        {
            boolean flag1 = false;

            while (!flag1 && j > 0)
            {
                Block block = this.worldObj.getBlock(i, j - 1, k);

                if (block.getMaterial().blocksMovement())
                {
                    flag1 = true;
                }
                else
                {
                    --this.posY;
                    --j;
                }
            }

            Material bl1 = this.worldObj.getBlock(i, j, k).getMaterial();
            Material bl2 = this.worldObj.getBlock(i, j + 1, k).getMaterial();

            if(bl1 != Material.air && bl1 != Material.carpet && bl1 !=  Material.plants && bl1 != Material.grass)
            {
            	flag1 = false;
            }
            if(bl2 != Material.air && bl2 != Material.carpet && bl2 !=  Material.plants && bl2 != Material.grass)
            {
            	flag1 = false;
            }

            //bl1.get
            if (flag1)
            {
                this.setPosition(this.posX, this.posY, this.posZ);

                if (this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox))
                {
                    flag = true;
                }
            }
        }

        if (!flag)
        {
            this.setPosition(d3, d4, d5);
            return false;
        }
        else
        {
            short short1 = 128;

            for (int l = 0; l < short1; ++l)
            {
                double d6 = (double)l / ((double)short1 - 1.0D);
                float f = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f1 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                float f2 = (this.rand.nextFloat() - 0.5F) * 0.2F;
                double d7 = d3 + (this.posX - d3) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                double d8 = d4 + (this.posY - d4) * d6 + this.rand.nextDouble() * (double)this.height;
                double d9 = d5 + (this.posZ - d5) * d6 + (this.rand.nextDouble() - 0.5D) * (double)this.width * 2.0D;
                this.worldObj.spawnParticle("portal", d7, d8, d9, (double)f, (double)f1, (double)f2);
            }

            if(!this.worldObj.isRemote) this.worldObj.playSoundEffect(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
            if(!this.worldObj.isRemote) this.playSound("mob.endermen.portal", 1.0F, 1.0F);
            return true;
        }
    }




    public NBTTagCompound getDqrPotionEffectsSet() {
    	if(dqrPotionEffects == null){dqrPotionEffects = new NBTTagCompound();}
        return dqrPotionEffects;
    }
    public void setDqrPotionEffectsSet(NBTTagCompound par1) {
    	if(par1 != null)
    	{
    		this.dqrPotionEffects = par1;
    	}else
    	{
    		this.dqrPotionEffects = new NBTTagCompound();
    	}
    }
    public void removeDqrPotionEffects(String key) {
    	this.dqrPotionEffects.removeTag(key);
    }


    public long getJobSPSkillDuration(int job, int idx) {
        //return fixJobSPSkillDuration.getLong("jobSPSkillDuration" + "_" + job  + "_" + idx);
    	NBTTagCompound nbt = this.dqrPotionEffects.getCompoundTag("JSkill" + "_" + job  + "_" + idx);
    	if(nbt != null && nbt.hasKey("duration"))
    	{
    		long duration = nbt.getLong("duration") - this.worldObj.getWorldTime();

    		if(duration > 0)
    		{
    			return duration;
    		}else
    		{
    			return 0L;
    		}

    	}else
    	{
    		return 0L;
    	}
    }
    public void setJobSPSkillDuration(int job, int idx, long par1) {
    	NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setInteger("id", 0);
    	nbt.setInteger("idx", 0);
    	nbt.setInteger("type", 0);
    	nbt.setLong("duration", par1);
    	nbt.setInteger("isDebuff", 0);
    	nbt.setInteger("amplifier", 0);

    	this.dqrPotionEffects.setTag("JSkill" + "_" + job  + "_" + idx, nbt);
        //this.fixJobSPSkillDuration.setLong("jobSPSkillDuration" + "_" + job  + "_" + idx, par1);
    }
    public void setDebuffDuration(int job, int idx, long par1) {
    	NBTTagCompound nbt = new NBTTagCompound();
    	nbt.setInteger("id", 0);
    	nbt.setInteger("idx", 0);
    	nbt.setInteger("type", 0);
    	nbt.setLong("duration", par1);
    	nbt.setInteger("isDebuff", 1);
    	nbt.setInteger("amplifier", 0);

    	this.dqrPotionEffects.setTag("JSkill" + "_" + job  + "_" + idx, nbt);
        //this.fixJobSPSkillDuration.setLong("jobSPSkillDuration" + "_" + job  + "_" + idx, par1);
    }


    public void refreshDqrPotionEffects(long wt)
    {
    	Set nbtSet = this.dqrPotionEffects.func_150296_c();

    	Iterator ite = nbtSet.iterator();
    	List<String> lst = new ArrayList<String>();
    	while(ite.hasNext())
    	{
    		Object obj = ite.next();
    		if(obj instanceof String)
    		{
    			NBTTagCompound nbt = this.dqrPotionEffects.getCompoundTag((String)obj);
    			if(nbt != null)
    			{
    				if(nbt.hasKey("duration"))
    				{
	        			long fixTime = nbt.getLong("duration");
	        			if(fixTime < wt)
	        			{
	        				lst.add((String)obj);
	        				//this.jobSPSkillDuration.removeTag((String)obj);
	        			}
    				}else
    				{
    					lst.add((String)obj);
    				}
    			}

    			//String name = (String)obj;
    			//System.out.println("TEST : " + name);
    		}
    	}

    	for(int cnt = 0; cnt < lst.size(); cnt++)
    	{
    		this.dqrPotionEffects.removeTag(lst.get(cnt));
    	}
    }

    public void setDqrPotionEffects(String key, NBTTagCompound nbt)
    {
    	this.dqrPotionEffects.setTag(key, nbt);
    }

    public NBTTagCompound getDqrPotionEffects(String key)
    {
    	return (NBTTagCompound)this.dqrPotionEffects.getTag(key);
    }
}
