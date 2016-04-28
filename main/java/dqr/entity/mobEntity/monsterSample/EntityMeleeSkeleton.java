package dqr.entity.mobEntity.monsterSample;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityMeleeSkeleton extends EntityMob
{
	public EntityMeleeSkeleton(World world)
	{
		super(world);

		/*
		 * タスクにAIを追加する.
		 * 引数は(優先度, AIクラスのインスタンス)
		 */

		/*
		 * 近接攻撃を行うAIを追加する.
		 * EntityAIAttackOnCollideの引数のうち, 末尾2つは(攻撃距離, ずっと追い続けるかどうか)
		 */
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.2D, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));

		/*
		 * うろうろ移動するAIの追加
		 */
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));

		/*
		 * 見回すAIの追加
		 */
		this.tasks.addTask(4, new EntityAILookIdle(this));

		/*
		 * ターゲットタスクにAIを追加する.
		 */

		/*
		 * 攻撃されたら反撃するAIを追加する.
		 * EntityAIHurtByTargetの第二引数は反撃時に周りのMobに助けを求めるかどうか
		 */
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));

		/*
		 * 周囲に特定のEntityがいる場合, ターゲッティングするAI.
		 * EntityAINearestAttackableTargetの最後の引数は視界で遮るかどうか.
		 * trueだとブロックに囲われた(ガラスブロックでも)村人はターゲットにならない.
		 * falseだとどんなブロックに囲まれていようとターゲットにする(ゾンビと同じ).
		 */
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, true));
	}

	/*
	 * AIを使うかどうか.
	 * 今回は使うのでtrueを返している.
	 */
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	/*
	 * このEntityに性質を付与する.
	 * 今回は移動速度を変更.
	 */
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}

	/*
	 * このMobが生きてるときの音のファイルパスを返す.
	 */
	@Override
	protected String getLivingSound()
	{
		return "mob.skeleton.say";
	}

	/*
	 * このMobがダメージを受けたときの音のファイルパスを返す.
	 */
	@Override
	protected String getHurtSound()
	{
		return "mob.skeleton.hurt";
	}

	/*
	 * このMobが倒されたときの音のファイルパスを返す.
	 */
	@Override
	protected String getDeathSound()
	{
		return "mob.skeleton.death";
	}

	/*
	 * このMobが動いているときの音のファイルパスを返す.
	 * 引数のblockはMobの下にあるBlock.
	 */
	@Override
	protected void func_145780_a(int x, int y, int z, Block block)
	{
		this.playSound("mob.skeleton.step", 0.15F, 1.0F);
	}

	/*
	 * Mobの属性を返す.
	 * 今回はUNDEADにしているので, エンチャントのSmiteが有効.
	 */
	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	/*
	 * このMobの通常ドロップのアイテムを返すメソッド.
	 */
	@Override
	protected Item getDropItem()
	{
		return Items.bone;
	}

}
