package dqr.api.event;

import net.minecraft.entity.EntityLivingBase;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

@Cancelable
public class DqrCanDespawnEvent extends Event{
	public final EntityLivingBase entityLiving;
	public int resultCode = -1;

	/**
	 *
	 * @result
	 * -1:通常の値を使用
	 *  0:Despawn しない
	 *  1:Despawn する
	 */

	public DqrCanDespawnEvent (EntityLivingBase par1)
	{
		this.entityLiving = par1;
	}

	public void setResultCode(int par1)
	{
		resultCode = par1;
	}

	public int getResultCode()
	{
		return resultCode;
	}
}
