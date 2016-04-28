package dqr.api.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

/**
 * Playerの職業レベルアップ時に走る処理。本来のステータス計算＆回復処理後に呼ばれる
 * なお、そもそもレベルアップ処理はサーバー側でしか走らないので注意。
 * キャンセル可。
 * */
@Cancelable
public class DqmLvUpEvent extends Event{

	public EntityPlayer player;
	public final int PlayerJob;
	public final int JobLv;

	public DqmLvUpEvent (EntityPlayer ep, int job, int lv)
	{
		this.setCanceled(false);
		this.player = ep;
		this.PlayerJob = job;
		this.JobLv = lv;
	}

}
