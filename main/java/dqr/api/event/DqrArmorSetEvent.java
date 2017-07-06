package dqr.api.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

/**
 * アーマーセット判定処理の時に呼ばれる。
 * キャンセル不可。
 * */

@Cancelable
@Event.HasResult
public class DqrArmorSetEvent extends Event{

	public EntityPlayer player;
	public int[] status;
	public ArmorMaterial[] equips ;
	public ArmorMaterial[] material ;
	public int enableCnt;

	public static final int ATK   = 1;
	public static final int DEF    = 2;
	public static final int MAG = 3;
	public static final int HP    = 4;
	public static final int MP    = 5;

	public DqrArmorSetEvent (EntityPlayer ep, int[] status, ArmorMaterial[] equips, ArmorMaterial[] material, int enableCnt)
	{
		this.player = ep;
		this.status = status;
		this.equips = equips;
		this.material = material;
		this.enableCnt = enableCnt;

	}

}
