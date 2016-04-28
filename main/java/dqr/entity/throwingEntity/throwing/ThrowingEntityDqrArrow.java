package dqr.entity.throwingEntity.throwing;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ThrowingEntityDqrArrow extends EntityArrow{

	public ThrowingEntityDqrArrow(World p_i1753_1_) {
		super(p_i1753_1_);
	}

    /** 発射する弾を生成・初期パラメータの定義をする。
     * @param par1World :このワールド
     * @param par2EntityLivingBase :弾源となるエンティティ。このModの場合、弾を撃ったプレイヤーがここに入る
     * @param speed :弾の速度計算に使われる値
     * @param speed2 :弾の速度計算に使われる値2
     * @param adjustX :プレイヤーから見て水平方向に、発射する弾をずらす(複数発射するときなどに使用する)
     * @param adjustZ :プレイヤーから見て前後方向に弾をずらす
     * @param adjustY :プレイヤーから見て上下方向に弾をずらす*/
    public ThrowingEntityDqrArrow(World par1World, EntityLivingBase par2EntityLivingBase, float speed, float speed2,
         float adjustX, float adjustZ, float adjustY, float fixX, float fixZ)
    {
    	super(par1World);
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
}
