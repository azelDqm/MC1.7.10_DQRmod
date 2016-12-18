package dqr.functions;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import dqr.api.event.DqrBlockFarmlandEvent;

public class FuncFarmlandExtension {

	public FuncFarmlandExtension(){}

	public boolean hookUpdateTick(World par1, int par2, int par3, int par4, Block par5)
	{
		DqrBlockFarmlandEvent event = new DqrBlockFarmlandEvent(par1, par2, par3, par4, par5);
		MinecraftForge.EVENT_BUS.post(event);

		//System.out.println("TEST");

		return event.isCanceled();
	}
}
