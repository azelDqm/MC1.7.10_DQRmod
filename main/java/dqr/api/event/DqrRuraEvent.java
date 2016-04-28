package dqr.api.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

/**
 * ルーラ及びキメラの翼使用時に走る処理。本来の近隣Entityテレポート処理後に呼ばれる。
 * 引数は、アイテムを使用したEntityPlayer , 近隣のEntity , 使用したアイテム(キメラの翼やルーラの杖等)
 * ルーラの杖の飛び先の x, y, z
 * なお、第一引数EntityPlayerをOwnnerとする EntityHorse, EntityTameable, DqmPetBaseインスタンスは
 * DQRmod側処理でテレポートさせられる。
 * キャンセル可。
 * */
@Cancelable
public class DqrRuraEvent extends Event{

	public EntityPlayer player;
	public Entity entity;
	public ItemStack itemStack;
	public double posX;
	public double posY;
	public double posZ;

	public DqrRuraEvent (EntityPlayer ep, Entity entity, ItemStack itemStack, double posX, double posY, double posZ)
	{
		this.setCanceled(false);
		this.player = ep;
		this.entity = entity;
		this.itemStack = itemStack;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
	}

}
