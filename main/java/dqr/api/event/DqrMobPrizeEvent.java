package dqr.api.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

/**
 *
 * ドラクエmod以外のモンスターの経験値＆ゴールドを設定するためのイベント
 *
 */
@Cancelable
public class DqrMobPrizeEvent extends Event {

	public int gold = 0;
	public int exp = 0;
	public EntityLivingBase entityLiving;
	public EntityPlayer entityPlayer;
	public final LivingDeathEvent livingDeathEvent;

	public DqrMobPrizeEvent(EntityLivingBase entityLiving, EntityPlayer ep, LivingDeathEvent event)
	{
		this.entityLiving = entityLiving;
		this.entityPlayer = ep;
		this.livingDeathEvent = event;
	}

	public int getGold()
	{
		return gold;
	}

	public int getExp()
	{
		return exp;
	}

	public void setGold(int par1)
	{
		this.gold = par1;
	}

	public void setExp(int par1)
	{
		this.exp = par1;
	}
}
