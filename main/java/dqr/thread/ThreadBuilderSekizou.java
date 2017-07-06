package dqr.thread;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.api.Blocks.DQDecorates;

public class ThreadBuilderSekizou extends Thread{

	private int Hougaku = 0;
	private int yMain = 0;
	private int size = 0;
	private int height = 0;
	private int under = 0;

	private int xxx;
	private int zzz;
	private World par3World;

	//private int mode;
	private ItemStack ist;
	public Random rand = new Random();
	public Block sekizouType;

	public ThreadBuilderSekizou(World par1, int size, int height, int under, ItemStack ist, Block sekizou)
	{
		this.par3World = par1;
    	this.size = size;
    	this.height = height;
    	this.under = under;
    	this.ist = ist;
    	this.sekizouType = sekizou;
    	//this.mode = mode;
	}

	public void run()
	{

		NBTTagCompound nbt = this.ist.getTagCompound();

		this.xxx = nbt.getInteger("settingX");
		this.zzz = nbt.getInteger("settingZ");
		this.yMain = nbt.getInteger("settingY");
		this.Hougaku = nbt.getInteger("settingFace");


        switch(this.Hougaku)
        {
        	//ここ 要微調整
        	case 1: xxx = xxx - (this.size) + 1; break;
        	case 2: zzz = zzz - (this.size) + 1; break;
        	case 3: xxx = xxx + (this.size) - 1; break;
        	case 0: zzz = zzz + (this.size) - 1; break;
        }

        //int takasa = 0;
        int yyy = this.yMain;
        //int yyy = par3World.getHeightValue(xxx, zzz);

		//if(nbt.getInteger("buildReady") == 1)
        if(true)
		{

        	int totalCnt = 0;
        	for (int x = (this.size * -1) - 1; x <= this.size + 1; ++x)
	        {
        		for (int z = (this.size * -1) - 1; z <= this.size + 1; ++z)
        		{
        			for (int y = this.under; y <= this.height + 1; ++y)
        	        {
        				if(par3World.getBlock(xxx + x, yyy + y, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
        				{
        	        		par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
        				}
        				totalCnt++;

        				if(totalCnt  > 500)
        				{
        					try {
        						this.sleep(DQR.conf.cfg_build_sleep);
        						totalCnt = 0;
        					} catch (InterruptedException e) {
        						// TODO 自動生成された catch ブロック
        						e.printStackTrace();
        					}
        				}
        	        }
        		}
	        }

		}


        //int yyy = par3World.getHeightValue(xxx, zzz);


        for (int x = -4; x <= 4; ++x)
        {
            for (int z = -4; z <= 4; ++z)
            {
                for (int y = 0; y <= 10; ++y)
                {
                    par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                }
            }
        }


        for (int x = -2; x <= 2; ++x)
        {
            for (int z = -2; z <= 2; ++z)
            {
                par3World.setBlock(xxx + x, yyy, zzz + z, DQBlocks.DqmBlockToramanaYuka2, 0, 2);
            }
        }

        for (int x = -3; x <= 3; ++x)
        {
            par3World.setBlock(xxx + x, yyy, zzz + 3, Blocks.stone_brick_stairs, 3, 2);
        }

        for (int x = -3; x <= 3; ++x)
        {
            par3World.setBlock(xxx + x, yyy, zzz - 3, Blocks.stone_brick_stairs, 2, 2);
        }

        for (int z = -3; z <= 3; ++z)
        {
            par3World.setBlock(xxx + 3, yyy, zzz + z, Blocks.stone_brick_stairs, 1, 2);
        }

        for (int z = -3; z <= 3; ++z)
        {
            par3World.setBlock(xxx - 3, yyy, zzz + z, Blocks.stone_brick_stairs, 0, 2);
        }
		try {
			this.sleep(DQR.conf.cfg_build_sleep);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        par3World.setBlock(xxx + 2, yyy + 1, zzz + 2, DQDecorates.DqmBlockKagaribidai, 0, 2);
        par3World.setBlock(xxx + 2, yyy + 1, zzz - 2, DQDecorates.DqmBlockKagaribidai, 0, 2);
        par3World.setBlock(xxx - 2, yyy + 1, zzz + 2, DQDecorates.DqmBlockKagaribidai, 0, 2);
        par3World.setBlock(xxx - 2, yyy + 1, zzz - 2, DQDecorates.DqmBlockKagaribidai, 0, 2);

        if(this.sekizouType != null)
        {
        	par3World.setBlock(xxx, yyy + 1, zzz, this.sekizouType, this.Hougaku, 2);
        }


	}
}
