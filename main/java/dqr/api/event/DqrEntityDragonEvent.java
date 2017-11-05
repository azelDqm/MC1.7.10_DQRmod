package dqr.api.event;

import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

@Cancelable
public class DqrEntityDragonEvent extends Event{

	private boolean canceled = false;
	public DqrEntityDragonEvent (){}


	public static class BlockDestroyEvent extends DqrEntityDragonEvent
	{
		public EntityDragon dragon;
		public Block block;
		public int posX = -1;
		public int posY = -1;
		public int posZ = -1;

		/*
		public BlockDestroyEvent(EntityDragon dragon, Block var13)
		{
			this.block = var13;
			this.dragon = dragon;
		}
		*/

		public BlockDestroyEvent(EntityDragon dragon, Block var13, int posX, int posY, int posZ)
		{
			this.block = var13;
			this.dragon = dragon;
			this.posX = posX;
			this.posZ = posZ;
			this.posY = posY;
		}
	}


	public static class CreateEnderPortalEvent extends DqrEntityDragonEvent {

		public boolean result = true;
		public EntityDragon dragon;
		public int posX;
		public int posZ;

		public CreateEnderPortalEvent(EntityDragon dragon, int p_70975_1_, int p_70975_2_)
		{
			this.dragon = dragon;
			this.posX = p_70975_1_;
			this.posZ = p_70975_2_;
		}

		public boolean getCreateResult()
		{
			return this.result;
		}
	}

	/*
	public void setCanceled(boolean var1)
	{
		this.canceled = var1;
	}

	public boolean isCanceled()
	{
		return this.canceled;
	}
	*/
}
