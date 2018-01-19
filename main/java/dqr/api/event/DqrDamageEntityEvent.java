package dqr.api.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.common.eventhandler.Event;

public class DqrDamageEntityEvent extends Event{
	/**
	 * EntityLivingBaseがダメージを受ける時に呼ばれるイベントハンドラ。
	 * メインとなるLivingHurtEvent内の各所に設置
	 * 使用時は、damagerをEntityPlayer や DqmMobBaseでinstanceofすると良いかも？
	 * DQRモンスターは、この処理の後に更にダメージ計算があるため、別イベントが準備してあります。
	 *
	 * Args.
	 * damagePhase    : イベントの発生するタイミング
	 *  1.LivingHurtEventに入った直後
	 *  2.ダメージ増減バフ(バイキルト,ルカニ等 の増減を加味した後)
	 *  3.Playerの弓矢・投擲武器のスキルダメージ エンドラの防御力や攻撃力加味後
	 *  4.ダメージのゆらぎ(乱数)加算後
	 *  5.モンスターの攻撃がミスとなった場合(missFlgがtrueのままの場合、ここで処理がキャンセルされる)
	 *  6.プレイヤーの攻撃がミスとなった場合(missFlgがtrueのままの場合、ここで処理がキャンセルされる)
	 *  7.その他の攻撃がミスとなった場合(missFlgがtrueのままの場合、ここで処理がキャンセルされる)
	 *    ミスじゃない場合は、Phase5-7は経由しない。
	 *  8.ミス/会心/耐性/即死ダメージ等の加味後(プレイヤー以外は、このPhaseが最後)
	 *  9.プレイヤーの防御力を減算したダメージ
	 * source         : 攻撃ダメージソース
	 * damage         : 与えるであろうダメージ量
	 * baseDamage     : 各種ダメージ増減前の初期値
	 * preDamage      : ダメージのゆらぎ(乱数)加算直前の値
	 *
	 * Return.
	 *  retDamage     : ダメージの戻り値(初期値として現在のダメージ値がセットされる)
	 *  retMissFlg    : Phase5-7 でのみ使用。falseにすると、ミスを無効にできる。
	 *
	*/

	public int damagePhase;
	public EntityLivingBase damager;
	public DamageSource source;
	public float damage;
	public float baseDamage;
	public float preDamage;
	public float retDamage;
	public boolean retMissFlg;

	public DqrDamageEntityEvent (int damagePhase, EntityLivingBase damager, DamageSource source, float damage, float baseDamage, float preDamage)
	{
		this.damagePhase = damagePhase;
		this.damager = damager;
		this.source = source;
		this.damage = damage;
		this.baseDamage = baseDamage;
		this.preDamage = preDamage;
		this.retDamage = this.damage;
		this.retMissFlg = true;
	}

}
