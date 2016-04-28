package dqr.thread;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;

public class ThreadBuilderFrame extends Thread{

	private int Hougaku = 0;
	private int yMain = 0;
	private int size = 0;
	private int height = 0;
	private int under = 0;

	private int xxx;
	private int zzz;
	private World par3World;

	private int mode;
	private ItemStack ist;

	public ThreadBuilderFrame(World par1, int size, int height, int under, ItemStack ist, int mode)
	{
		this.par3World = par1;
    	this.size = size;
    	this.height = height;
    	this.under = under;
    	this.ist = ist;
    	this.mode = mode;
	}

	public void run()
	{

		DQR.func.debugString("Root1");
		NBTTagCompound nbt = this.ist.getTagCompound();

		this.xxx = nbt.getInteger("settingX");
		this.zzz = nbt.getInteger("settingZ");
		this.yMain = nbt.getInteger("settingY");
		this.Hougaku = nbt.getInteger("settingFace");

        switch(this.Hougaku)
        {
        	case 1: xxx = xxx - (this.size + 1); break;
        	case 2: zzz = zzz - (this.size + 1); break;
        	case 3: xxx = xxx + (this.size + 1); break;
        	case 0: zzz = zzz + (this.size + 1); break;
        }

        //int yyy = par3World.getHeightValue(xxx, zzz);
        int yyy = this.yMain;
	    //public void generate(Random rand, int par1, int par2, World par3World, IChunkProvider par4IChunkProvider, IChunkProvider par5IChunkProvider)
	    //{
		if(mode == 0)
		{


	        for (int x = (this.size * -1); x <= this.size; ++x)
	        {
	        	if(par3World.isAirBlock(xxx + x, yyy + this.height, zzz + this.size))
	        		par3World.setBlock(xxx + x, yyy + this.height, zzz + this.size, DQBlocks.DqmBlockBuilderFrame, 0, 2);

	        	if(par3World.isAirBlock(xxx + x, yyy + this.height, zzz + (this.size * -1)))
	        		par3World.setBlock(xxx + x, yyy + this.height, zzz + (this.size * -1), DQBlocks.DqmBlockBuilderFrame, 0, 2);

	        	if(par3World.isAirBlock(xxx + x, yyy + under, zzz + this.size))
	        		par3World.setBlock(xxx + x, yyy + under, zzz + this.size, DQBlocks.DqmBlockBuilderFrame, 0, 2);

	        	if(par3World.isAirBlock(xxx + x, yyy + under, zzz + (this.size * -1)))
	        		par3World.setBlock(xxx + x, yyy + under, zzz + (this.size * -1), DQBlocks.DqmBlockBuilderFrame, 0, 2);
	        }

	        for (int z = (this.size * -1); z <= this.size; ++z)
	        {
	        	if(par3World.isAirBlock(xxx + this.size, yyy + this.height, zzz + z))
	        		par3World.setBlock(xxx + this.size, yyy + this.height, zzz + z, DQBlocks.DqmBlockBuilderFrame, 0, 2);

	        	if(par3World.isAirBlock(xxx + (this.size * -1), yyy + this.height, zzz + z))
	        		par3World.setBlock(xxx + (this.size * -1), yyy + this.height, zzz + z, DQBlocks.DqmBlockBuilderFrame, 0, 2);

	        	if(par3World.isAirBlock(xxx + this.size, yyy + under, zzz + z))
	        		par3World.setBlock(xxx + this.size, yyy + under, zzz + z, DQBlocks.DqmBlockBuilderFrame, 0, 2);

	        	if(par3World.isAirBlock(xxx + (this.size * -1), yyy + under, zzz + z))
	        		par3World.setBlock(xxx + (this.size * -1), yyy + under, zzz + z, DQBlocks.DqmBlockBuilderFrame, 0, 2);
	        }

	        for (int y = this.under; y <= this.height; ++y)
	        {
	        	if(par3World.isAirBlock(xxx + this.size, yyy + y, zzz + this.size))
	        		par3World.setBlock(xxx + this.size, yyy + y, zzz + this.size, DQBlocks.DqmBlockBuilderFrame, 0, 2);

	        	if(par3World.isAirBlock(xxx + this.size, yyy + y, zzz + (this.size * -1)))
	        		par3World.setBlock(xxx + this.size, yyy + y, zzz + (this.size * -1), DQBlocks.DqmBlockBuilderFrame, 0, 2);

	        	if(par3World.isAirBlock(xxx + (this.size * -1), yyy + y, zzz + this.size))
	        		par3World.setBlock(xxx + (this.size * -1), yyy + y, zzz + this.size, DQBlocks.DqmBlockBuilderFrame, 0, 2);

	        	if(par3World.isAirBlock(xxx + (this.size * -1), yyy + y, zzz + (this.size * -1)))
	        		par3World.setBlock(xxx + (this.size * -1), yyy + y, zzz + (this.size * -1), DQBlocks.DqmBlockBuilderFrame, 0, 2);
	        }
	    }else
	    {
	    	DQR.func.debugString(this.xxx + "/" + yyy + "/" + this.zzz );
	    	for (int x = (this.size * -1); x <= this.size; ++x)
	        {
	        	if(par3World.getBlock(xxx + x, yyy + this.height, zzz + this.size) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + x, yyy + this.height, zzz + this.size, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + x, yyy + this.height, zzz + (this.size * -1)) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + x, yyy + this.height, zzz + (this.size * -1), Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + x, yyy + under, zzz + this.size) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + x, yyy + under, zzz + this.size, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + x, yyy + under, zzz + (this.size * -1)) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + x, yyy + under, zzz + (this.size * -1), Blocks.air, 0, 2);
	        }

	        for (int z = (this.size * -1); z <= this.size; ++z)
	        {
	        	if(par3World.getBlock(xxx + this.size, yyy + this.height, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + this.size, yyy + this.height, zzz + z, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + (this.size * -1), yyy + this.height, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + (this.size * -1), yyy + this.height, zzz + z, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + this.size, yyy + under, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + this.size, yyy + under, zzz + z, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + (this.size * -1), yyy + under, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + (this.size * -1), yyy + under, zzz + z, Blocks.air, 0, 2);
	        }

	        for (int y = this.under; y <= this.height; ++y)
	        {
	        	if(par3World.getBlock(xxx + this.size, yyy + y, zzz + this.size) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + this.size, yyy + y, zzz + this.size,Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + this.size, yyy + y, zzz + (this.size * -1)) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + this.size, yyy + y, zzz + (this.size * -1), Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + (this.size * -1), yyy + y, zzz + this.size) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + (this.size * -1), yyy + y, zzz + this.size, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + (this.size * -1), yyy + y, zzz + (this.size * -1)) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + (this.size * -1), yyy + y, zzz + (this.size * -1), Blocks.air, 0, 2);
	        }

	        //nbt.setInteger("settingY", 1);
	    }

	}

}
