package dqr.api.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

/**
 * Playerの熟練レベルアップ時に走る処理。本来のステータス計算＆回復処理後に呼ばれる
 * なお、そもそもレベルアップ処理はサーバー側でしか走らないので注意。
 * キャンセル可。
 * */
@Cancelable
public class DqmJukurenUpEvent extends Event{

	public EntityPlayer player;
	public final int WeaponType;
	public final int JobLv;

	public DqmJukurenUpEvent (EntityPlayer ep, int type, int lv)
	{
		this.setCanceled(false);
		this.player = ep;
		this.WeaponType = type;
		this.JobLv = lv;
	}

}
