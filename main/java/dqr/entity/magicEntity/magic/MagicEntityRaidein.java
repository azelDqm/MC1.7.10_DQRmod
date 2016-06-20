package dqr.entity.magicEntity.magic;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.potion.DQPotionPlus;

/*
 * 発射されるエンティティのクラス。
 * */
public class MagicEntityRaidein extends MagicEntity implements IProjectile{

    /* 地中判定に使うもの */
    protected int xTile = -1;
    protected int yTile = -1;
    protected int zTile = -1;
    protected Block inTile;
    protected int inData;
    protected boolean inGround;

    /* この弾を撃ったエンティティ */
    public Entity shootingEntity;

    /* 地中・空中にいる時間 */
    protected int ticksInGround;
    protected int ticksInAir;

    //追加パラメータ
    protected int maxTicksRange = 40;
    protected boolean PenetrateEntity = false;

    /* ダメージの大きさ */
    protected double damage = 0.0D;

    private int lightningCnt = 0;

    /* ノックバックの大きさ */
    protected int knockbackStrength = 1;

    protected boolean worldFlg = false;

    public MagicEntityRaidein(World par1World)
    {
        super(par1World);
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
        this.damage = 0.0D;
    }

    /** 発射する弾を生成・初期パラメータの定義をする。
     * @param par1World :このワールド
     * @param par2EntityLivingBase :弾源となるエンティティ。このModの場合、弾を撃ったプレイヤーがここに入る
     * @param speed :弾の速度計算に使われる値
     * @param speed2 :弾の速度計算に使われる値2
     * @param adjustX :プレイヤーから見て水平方向に、発射する弾をずらす(複数発射するときなどに使用する)
     * @param adjustZ :プレイヤーから見て前後方向に弾をずらす
     * @param adjustY :プレイヤーから見て上下方向に弾をずらす*/
    public MagicEntityRaidein(World par1World, EntityLivingBase par2EntityLivingBase, float speed, float speed2,
         float adjustX, float adjustZ, float adjustY, float fixX, float fixZ, int lightningCnt)
    {
    	super(par1World);
    	this.lightningCnt = lightningCnt;
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = par2EntityLivingBase;
        this.yOffset = 0.0F;
        this.setSize(0.5F, 0.5F);

        //初期状態での向きの決定
        this.setLocationAndAngles(par2EntityLivingBase.posX, par2EntityLivingBase.posY +
            (double)par2EntityLivingBase.getEyeHeight(), par2EntityLivingBase.posZ,
            par2EntityLivingBase.rotationYaw + fixX, par2EntityLivingBase.rotationPitch + fixZ);

        //位置の調整
        this.posX += -(double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
        		- (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
        this.posY += 0.05000000149011612D + adjustY;
        this.posZ += (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * (1.0F + adjustZ))
        		- (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * adjustX);
        this.setPosition(this.posX, this.posY, this.posZ);

        //初速度
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) *
                           MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) *
                           MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, speed * 1.5F, speed2);
    }

    /*dataWatcherを利用したサーバ・クライアント間の同期処理だと思う*/
    protected void entityInit()
    {
    	this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    /*
     * IProjectileで実装が必要なメソッド。
     * ディスペンサーによる発射メソッドなどで使用されている。
     */
    public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8)
    {
        float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= (double)f2;
        par3 /= (double)f2;
        par5 /= (double)f2;
        par1 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
        par3 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
        par5 += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)par8;
        par1 *= (double)par7;
        par3 *= (double)par7;
        par5 *= (double)par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)f3) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

    @SideOnly(Side.CLIENT)
    /*
     * Sets the position and rotation. Only difference from the other one is no bounding on the rotation. Args: posX,
     * posY, posZ, yaw, pitch
     */
    public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9)
    {
        this.setPosition(par1, par3, par5);
        this.setRotation(par7, par8);
    }

    @SideOnly(Side.CLIENT)
    /*
     * Sets the velocity to the args. Args: x, y, z
     * 速度の処理。クライアント・サーバ間での同期処理にて利用されている。
     */
    public void setVelocity(double par1, double par3, double par5)
    {
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(par3, (double)f) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    /*
     * Tick毎に呼ばれる更新処理。
     * 速度の更新、衝突判定などをここで行う。
     */
    public void onUpdate()
    {
        super.onUpdate();

        //エンダークリスタルが近くにあったら消滅
        if(this.isDoSetDead(this, shootingEntity))
        {
        	this.setDead();
        }

        //直前のパラメータと新パラメータを一致させているところ。
        //また、速度に応じてエンティティの向きを調整し、常に進行方向に前面が向くようにしている。
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f) * 180.0D / Math.PI);
        }

        //激突したブロックを確認している
        Block i = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
        boolean air = this.worldObj.isAirBlock(xTile, yTile, zTile);

        //空気じゃないブロックに当たった&ブロック貫通エンティティでない時
        if (i != null && i.getMaterial() != Material.air && !this.isPenetrateBlock())
        {
            i.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
            AxisAlignedBB axisalignedbb = i.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);

            //当たり判定に接触しているかどうか
            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
            {
                this.inGround = true;
            }
        }

        //空気じゃないブロックに当たった
        if (this.inGround)
        {
            Block j = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
            int k = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);

            /* 前のTickに確認した埋まりブロックのIDとメタを照合している。違ったら埋まり状態を解除、一致したら埋まり状態を継続。
            /* 埋まり状態2tick継続でこのエンティティを消す
             */
            if (j == this.inTile && k == this.inData)
            {
            	++this.ticksInGround;
            	//ブロック貫通の場合、20tick（1秒間）はブロック中にあっても消えないようになる。
            	int limit = this.isPenetrateBlock() ? 20 : 2;

                if (this.ticksInGround > limit)
                {
                	double lbPosX = this.posX;
                	double lbPosY = this.posY;
                	double lbPosZ = this.posZ;

                	if(worldFlg == true && DQR.conf.magicEpDein != 0)
                	{
	                	for(int xCnt = this.lightningCnt * -1; xCnt <= this.lightningCnt; xCnt++)
	                	{
	                    	for(int zCnt = this.lightningCnt * -1; zCnt <= this.lightningCnt; zCnt++)
	                    	{
	                    		EntityLightningBolt lb = null;
	                    		lb = new EntityLightningBolt(this.worldObj, lbPosX + xCnt, lbPosY, lbPosZ + zCnt);
	                    		this.worldObj.addWeatherEffect(lb);
	                    		this.worldObj.spawnEntityInWorld(lb);
	                    	}
	                	}
                	}
                    this.setDead();
                }
            }
            else//埋まり状態の解除処理
            {
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.1F);
                this.motionY *= (double)(this.rand.nextFloat() * 0.1F);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.1F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }
        else//埋まってない時。速度の更新。
        {
            ++this.ticksInAir;

            if(this.maxTicksRange < this.ticksInAir)
            {
            	this.setDead();
            }
            //ブロックとの衝突判定
            Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY +
                             this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec3, vec31, false, true, false);
            vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY +
                        this.motionY, this.posZ + this.motionZ);

            //ブロック貫通がONの場合、ブロック衝突判定をスキップ
            if (this.isPenetrateBlock())
            {
            	movingobjectposition = null;
            }

            //ブロックに当たった
            if (movingobjectposition != null)
            {
                vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord,
                            movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
            }

            //Entityとの衝突判定。
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
                            this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            int l;
            float f1;
            boolean isVillager = false;
            ArrayList<MovingObjectPosition> entityList = new ArrayList<MovingObjectPosition>();

            //1ブロック分の範囲内にいるエンティティ全てに対して繰り返す
            for (l = 0; l < list.size(); ++l)
            {
                Entity entity1 = (Entity)list.get(l);
                Entity entity = null;

                //発射物自身or発射後5tick以外だとすりぬける
                if (entity1.canBeCollidedWith() && entity1 != this.shootingEntity)
                {
                    f1 = 0.3F;
                    AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double)f1, (double)f1, (double)f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);

                    if (movingobjectposition1 != null)
                    {
                        double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

                        if (d1 < d0 || d0 == 0.0D)
                        {
                        	//arrowと異なり、あたったEntityすべてをリストに入れる
                            entityList.add(new MovingObjectPosition(entity1));
                            d0 = d1;
                        }
                    }
                }
            }

            /* 当たったエンティティそれそれについての判定部分。
             * ここで特定の種類のエンティティに当たらないようにできる。*/
            if (entityList != null && !entityList.isEmpty())
            {
            	for (int n = 0 ; n < entityList.size() ; n++)
            	{
            		Entity target = entityList.get(n).entityHit;

            		if(this.shootingEntity instanceof EntityPlayer || this.shootingEntity instanceof EntityTameable)
            		{
	            		if (target instanceof EntityPlayer)
	                    {
	                    	//プレイヤーに当たった時
	                    	EntityPlayer entityplayer = (EntityPlayer)target;

	                        if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer &&
	                               !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer))
	                        {
	                        	//PvPが許可されていないと当たらない
	                            entityList.remove(n);
	                        }
	                        else if (entityplayer == this.shootingEntity)
	                        {
	                        	//対象が撃った本人の場合も当たらない
	                        	entityList.remove(n);
	                        }
	                    }
	                    else if (target instanceof EntityTameable ||
	                                 target instanceof EntityHorse)
	                    {
	                    	//事故防止の為、EntityTameable（犬や猫などのペット）、馬にも当たらないようにする
	                    	entityList.remove(n);
	                    }
            		}else
            		{
            			if(target == this.shootingEntity)
            			{
            				entityList.remove(n);
            			}
            		}
            	}
            }

            float f2;
            float f3;

            //当たったあとの処理
            //まずはリストから
            if (entityList != null && !entityList.isEmpty())
            {
            	for (MovingObjectPosition target : entityList)
            	{
            		if (target != null && target.entityHit != null)
            		{
            			//衝突時の弾の速度を計算
                        f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY +
                                this.motionZ * this.motionZ);
                        //速度が大きいほど、ダメージも大きくなる
                        //int i1 = MathHelper.ceiling_double_int((double)f2 * this.damage);
                        //0~2程度の乱数値を上乗せ
                        //i1 += this.rand.nextInt(3);
                        int i1 = MathHelper.ceiling_double_int(this.damage);
                        DamageSource damagesource = null;

                        //別メソッドでダメージソースを確認
                        damagesource = this.thisDamageSource(this.shootingEntity);

                        //バニラ矢と同様、このエンティティが燃えているなら対象に着火することも出来る
                        if (this.isBurning() && !(target.entityHit instanceof EntityEnderman))
                        {
                            target.entityHit.setFire(5);
                        }

                        /*
                        if (target.entityHit instanceof EntityVillager)
                        {
                        	//対象が村人だった場合の処理
                        	EntityVillager villager = (EntityVillager) target.entityHit;
                        	//ダメージに相当する量の回復効果をもたらす
                        	villager.heal((float)i1);
                        	//ただしノックバックは有る
                        	if (this.knockbackStrength > 0)
                            {
                                f3 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

                                if (f3 > 0.0F)
                                {
                                    target.entityHit.addVelocity(this.motionX *
                                        (double)this.knockbackStrength * 0.6000000238418579D / (double)f3, 0.1D, this.motionZ *
                                        (double)this.knockbackStrength * 0.6000000238418579D / (double)f3);
                                }
                            }
                            else
                            {
                            	target.entityHit.hurtResistantTime = 0;
                            }
                        }
                        else */if (target.entityHit instanceof IProjectile)
                        {
                        	//対象が矢などの飛翔Entityの場合、打ち消すことが出来る
                        	target.entityHit.setDead();
                        }
                        else
                        {
                        	PotionEffect pe = null;

                    		if(target.entityHit instanceof EntityLiving)
                    		{
                    			EntityLiving elv2 = (EntityLiving)target.entityHit;
                    			pe = elv2.getActivePotionEffect(DQPotionPlus.buffMahokanta);
                    		}

                    		if(pe != null && this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase)
                    		{
                            	EntityLiving elv = (EntityLiving)this.shootingEntity;
                            	//村人以外なら、ダメージを与える処理を呼ぶ
                            	if (elv.attackEntityFrom(damagesource, (float)i1))
                                {
                            		//ダメージを与えることに成功したら以下の処理を行う
                                    if (elv instanceof EntityLivingBase)
                                    {
                                        //EntityLivingBase entitylivingbase = (EntityLivingBase)target.entityHit;

                                        //ノックバック
                                        if (this.knockbackStrength > 0)
                                        {
                                            f3 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

                                            if (f3 > 0.0F)
                                            {
                                            	elv.addVelocity(this.motionX *
                                                    (double)this.knockbackStrength * 0.6000000238418579D / (double)f3, 0.1D, this.motionZ *
                                                    (double)this.knockbackStrength * 0.6000000238418579D / (double)f3);
                                            }
                                        }
                                        else
                                        {
                                        	elv.hurtResistantTime = 0;
                                        }


                                        //マルチプレイ時に、両者がプレイヤーだった時のパケット送信処理
                                        if (this.shootingEntity != null && target.entityHit != this.shootingEntity &&
                                                target.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP)
                                        {
                                            ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
                                        }
                                    }

                                    //ここでヒット時の効果音がなる
                                    this.playSound("ambient.weather.thunder", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

                                    //当たったあと、弾を消去する。エンティティ貫通がONの弾種はそのまま残す。
                                    if (!(elv instanceof EntityEnderman) && !this.isPenetrateEntity())
                                    {
                                    	double lbPosX = elv.posX;
                                    	double lbPosY = elv.posY;
                                    	double lbPosZ = elv.posZ;

                                    	if(worldFlg == true && DQR.conf.magicEpDein != 0)
                                    	{
	                                    	for(int xCnt = this.lightningCnt * -1; xCnt <= this.lightningCnt; xCnt++)
	                                    	{
	                                        	for(int zCnt = this.lightningCnt * -1; zCnt <= this.lightningCnt; zCnt++)
	                                        	{
	    	                                		EntityLightningBolt lb = null;
	    	                                		lb = new EntityLightningBolt(this.worldObj, lbPosX + xCnt, lbPosY, lbPosZ + zCnt);
	    	                                		this.worldObj.addWeatherEffect(lb);
	    	                                		this.worldObj.spawnEntityInWorld(lb);
	                                        	}
	                                    	}
                                    	}
                                    	//this.onStruckByLightning(lb);
                                        this.setDead();
                                        break;
                                    }
                                }
                    		}else
                    		{
	                        	//村人以外なら、ダメージを与える処理を呼ぶ
	                        	if (target.entityHit.attackEntityFrom(damagesource, (float)i1))
	                            {
	                        		//ダメージを与えることに成功したら以下の処理を行う
	                                if (target.entityHit instanceof EntityLivingBase)
	                                {
	                                    EntityLivingBase entitylivingbase = (EntityLivingBase)target.entityHit;

	                                    //ノックバック
	                                    if (this.knockbackStrength > 0)
	                                    {
	                                        f3 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);

	                                        if (f3 > 0.0F)
	                                        {
	                                            target.entityHit.addVelocity(this.motionX *
	                                                (double)this.knockbackStrength * 0.6000000238418579D / (double)f3, 0.1D, this.motionZ *
	                                                (double)this.knockbackStrength * 0.6000000238418579D / (double)f3);
	                                        }
	                                    }
	                                    else
	                                    {
	                                    	target.entityHit.hurtResistantTime = 0;
	                                    }

	                                    //Thornのエンチャント効果で反撃を受ける
	                                    if (this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase)
	                                    {
	                                        EnchantmentHelper.func_151384_a(entitylivingbase, this.shootingEntity);
	                                        EnchantmentHelper.func_151385_b((EntityLivingBase)this.shootingEntity, entitylivingbase);
	                                    }

	                                    //マルチプレイ時に、両者がプレイヤーだった時のパケット送信処理
	                                    if (this.shootingEntity != null && target.entityHit != this.shootingEntity &&
	                                            target.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP)
	                                    {
	                                        ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
	                                    }
	                                }

	                                //ここでヒット時の効果音がなる
	                                this.playSound("ambient.weather.thunder", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));

	                                //当たったあと、弾を消去する。エンティティ貫通がONの弾種はそのまま残す。
	                                if (!(target.entityHit instanceof EntityEnderman) && !this.isPenetrateEntity())
	                                {
	                                	double lbPosX = this.posX;
	                                	double lbPosY = this.posY;
	                                	double lbPosZ = this.posZ;

	                                	if(worldFlg == true && DQR.conf.magicEpDein != 0)
	                                	{
		                                	for(int xCnt = this.lightningCnt * -1; xCnt <= this.lightningCnt; xCnt++)
		                                	{
		                                    	for(int zCnt = this.lightningCnt * -1; zCnt <= this.lightningCnt; zCnt++)
		                                    	{
			                                		EntityLightningBolt lb = null;
			                                		lb = new EntityLightningBolt(this.worldObj, lbPosX + xCnt, lbPosY, lbPosZ + zCnt);
			                                		this.worldObj.addWeatherEffect(lb);
			                                		this.worldObj.spawnEntityInWorld(lb);
		                                    	}
		                                	}
	                                	}
	                                	//this.onStruckByLightning(lb);
	                                    this.setDead();
	                                    break;
	                                }
	                            }
                    		}
                        }
            		}
            	}
            }

            if (movingobjectposition != null)//blockのみ
            {
                if (!this.isPenetrateBlock())  //エンティティには当たってない。ブロックに当たった。
                {
                    this.xTile = movingobjectposition.blockX;
                    this.yTile = movingobjectposition.blockY;
                    this.zTile = movingobjectposition.blockZ;
                    this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
                    this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                    this.motionX = (double)((float)(movingobjectposition.hitVec.xCoord - this.posX));
                    this.motionY = (double)((float)(movingobjectposition.hitVec.yCoord - this.posY));
                    this.motionZ = (double)((float)(movingobjectposition.hitVec.zCoord - this.posZ));
                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY +
                             this.motionZ * this.motionZ);
                    this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
                    this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
                    this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
                    //this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    //this.playSound("dqr:mob.fire", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;

                    if (this.inTile != null)
                    {
                        this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
                    }
                }
            }

            if (this.isPenetrateBlock())
            {
                for (int n = 0; n < 4; ++n)
                {
                    this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)n / 4.0D, this.posY + this.motionY * (double)n / 4.0D, this.posZ + this.motionZ * (double)n / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }

            //改めてポジションに速度を加算。向きも更新。
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f2) * 180.0D / Math.PI);

            while ( this.rotationPitch - this.prevRotationPitch < -180.0F)
            {
            	this.prevRotationPitch -= 360.0F;
            }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
            {
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F)
            {
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
            {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;

            //徐々に減速する
            //float f4 = 0.99F;
            float f4 = 1.0F;

            //重力落下
            //落下速度は別メソッドで設定している。デフォルトでは0.0F。
            f1 = this.fallSpeed();

            //水中に有る
            if (this.isInWater())
            {
            	//泡パーティクルが出る
                for (int j1 = 0; j1 < 4; ++j1)
                {
                    f3 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f3, this.posY - this.motionY *
                         (double)f3, this.posZ - this.motionZ * (double)f3, this.motionX, this.motionY, this.motionZ);
                }

                //減速も大きくなる
                f4 = 0.8F;
            }

            this.motionX *= (double)f4;
            this.motionY *= (double)f4;
            this.motionZ *= (double)f4;
            this.motionY -= (double)f1;

            //一定以上遅くなったら消える
            if (this.worldObj.isRemote && this.motionX * this.motionX + this.motionZ * this.motionZ < 0.001D)
            {
            	this.setDead();
            }


            this.setPosition(this.posX, this.posY, this.posZ);
            this.func_145775_I();
        }
    }

    /*
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setShort("xTile", (short)this.xTile);
        par1NBTTagCompound.setShort("yTile", (short)this.yTile);
        par1NBTTagCompound.setShort("zTile", (short)this.zTile);
        par1NBTTagCompound.setByte("inTile", (byte)(byte)Block.getIdFromBlock(this.inTile));
        par1NBTTagCompound.setByte("inData", (byte)this.inData);
        par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        par1NBTTagCompound.setDouble("damage", this.damage);
    }

    /*
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        this.xTile = par1NBTTagCompound.getShort("xTile");
        this.yTile = par1NBTTagCompound.getShort("yTile");
        this.zTile = par1NBTTagCompound.getShort("zTile");
        this.inTile = Block.getBlockById(par1NBTTagCompound.getByte("inTile") & 255);
        this.inData = par1NBTTagCompound.getByte("inData") & 255;
        this.inGround = par1NBTTagCompound.getByte("inGround") == 1;

        if (par1NBTTagCompound.hasKey("damage"))
        {
            this.damage = par1NBTTagCompound.getDouble("damage");
        }
    }

    /*
     * プレイヤーと衝突した時のメソッド。今回は何もしない
     */
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {

    }

    /*
     * ブロックに対し、上を歩いたかという判定の対象になるか、というEntityクラスのメソッド。
     * 耕地を荒らしたりするのに使う。
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    public void setDamage(double par1)
    {
        this.damage = par1;
    }

    public double getDamage()
    {
        return this.damage;
    }

    public void setKnockbackStrength(int par1)
    {
        this.knockbackStrength = par1;
    }

    public boolean canAttackWithItem()
    {
        return false;
    }

    //クリティカル処理。パーティクル発生のため、クライアントとの同期が必要。
    public void setIsCritical(boolean p_70243_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (p_70243_1_)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
        }
    }

    /** 以下、当MOD用のパラメータ定義部分*/

    /* 落下速度 */
    public float fallSpeed()
    {
    	return this.fallSpeed;
    }

    /* ダメージソースのタイプ */
    public DamageSource thisDamageSource(Entity entity)
    {
        //発射元のEntityがnullだった場合の対策を含む。
    	return entity != null ? EntityDamageSource.causeIndirectMagicDamage(entity, this) : DamageSource.magic;
    }

    /* ブロック貫通 */
    public boolean isPenetrateBlock()
    {
    	byte b0 = this.dataWatcher.getWatchableObjectByte(16);
    	return (b0 & 1) != 0;
    }

    /* エンティティ貫通 */
    public boolean isPenetrateEntity()
    {
    	return this.PenetrateEntity;
    }

    public void setPenetrateEntity(boolean par1)
    {
    	this.PenetrateEntity = par1;
    }

    public void setMaxTicksRange(int par1)
    {
    	this.maxTicksRange = par1;
    }

    public void setWorldFlg(boolean par1)
    {
    	this.worldFlg = par1;
    }
}
