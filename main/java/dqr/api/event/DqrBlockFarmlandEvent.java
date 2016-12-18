package dqr.api.event;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.Cancelable;
import cpw.mods.fml.common.eventhandler.Event;

@Cancelable
public class DqrBlockFarmlandEvent extends Event{
	public final World world;
	public final Block block;
	public final int par2;
	public final int par3;
	public final int par4;

	public DqrBlockFarmlandEvent (World par1, int par2, int par3, int par4, Block par5)
	{
		this.setCanceled(false);
		this.world = par1;
		this.block = par5;
		this.par2 = par2;
		this.par3 = par3;
		this.par4 = par4;
	}
}
