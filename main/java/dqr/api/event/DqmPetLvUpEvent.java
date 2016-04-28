package dqr.api.event;

import net.minecraft.entity.passive.EntityTameable;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

/**
 * Playerの職業レベルアップ時に走る処理。本来のステータス計算＆回復処理後に呼ばれる
 * なお、そもそもレベルアップ処理はサーバー側でしか走らないので注意。
 * キャンセル可。
 * */
@Cancelable
public class DqmPetLvUpEvent extends Event{

	public EntityTameable pet;
	public final int PlayerJob;
	public final int JobLv;

	public DqmPetLvUpEvent (EntityTameable pet, int job, int lv)
	{
		this.setCanceled(false);
		this.pet = pet;
		this.PlayerJob = job;
		this.JobLv = lv;
	}

}
