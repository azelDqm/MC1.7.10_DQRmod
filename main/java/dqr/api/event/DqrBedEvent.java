package dqr.api.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

@Cancelable
public class DqrBedEvent extends Event{
	public EntityPlayer player;
	public final int BedType;
	public final int timing; //0:最初 1:宿泊開始時 2:チェック後 3:回復後 4:最後
	public int[] param; //0_回復値段

	public DqrBedEvent (EntityPlayer ep, int type, int timing, int[] param)
	{
		this.setCanceled(false);
		this.player = ep;
		this.BedType = type;
		this.timing = timing;
		this.param = param;
	}
}
