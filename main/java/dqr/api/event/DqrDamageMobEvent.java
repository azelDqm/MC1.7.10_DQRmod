package dqr.api.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.common.eventhandler.Event;
import dqr.entity.mobEntity.DqmMobBase;

/**
 * 敵モンスターがダメージを受ける時に呼ばれるイベントハンドラ。
 *
 * Args.
 * damagePhase    : イベントの発生するタイミング
 *  1.ダメージ処理に入ってすぐの時点(特技ダメージ等が加味されていない)
 *  2.onLivingHurtイベント直前(特技/特殊ダメージ加味後)
 *  3.onLivingHurtイベント直後
 *  4.ドラクエ耐性 弱点攻撃等の倍率加味後
 *  5.実際に与えるダメージ(通常はここだけいじればOK / 固定ダメージは使えない)
 * attacker       : 攻撃してきたEntity
 * mob            : 攻撃された敵モンスター
 * source         : 攻撃ダメージソース
 * skillFlg       : 特技攻撃によるダメージかどうか
 * damage         : ダメージ量
 * absoluteDamage : 固定ダメージ
 *   -> -1.0fの場合は固定ダメージは未使用。
 *   ->  0.0fの場合は確定でミスの場合
 *
 * Return.
 *  初期化時にそれぞれの初期値が設定される。
 *  retDamage         : 通常ダメージの戻り値
 *  retAbsoluteDamage : 固定ダメージの戻り値
 * */
public class DqrDamageMobEvent extends Event{

	public int damagePhase;
	public EntityLivingBase attacker;
	public DqmMobBase mob;
	public DamageSource source;
	public boolean skillFlg;
	public float damage;
	public float absoluteDamage;

	public float retDamage;
	public float retAbsoluteDamage;

	public DqrDamageMobEvent (int damagePhase, EntityLivingBase attacker, DqmMobBase mob, DamageSource source, boolean skillFlg, float damage, float absoluteDamage)
	{
		this.damagePhase = damagePhase;
		this.attacker = attacker;
		this.mob = mob;
		this.skillFlg = skillFlg;
		this.source = source;
		this.damage = damage;
		this.absoluteDamage = absoluteDamage;

		this.retDamage = this.damage;
		this.retAbsoluteDamage = this.absoluteDamage;

	}


}

