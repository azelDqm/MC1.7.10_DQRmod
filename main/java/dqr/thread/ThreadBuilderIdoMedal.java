package dqr.thread;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.api.Blocks.DQDecorates;
import dqr.entity.npcEntity.npc.DqmEntityNPCMedalking;

public class ThreadBuilderIdoMedal extends Thread{

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

	public ThreadBuilderIdoMedal(World par1, int size, int height, int under, ItemStack ist)
	{
		this.par3World = par1;
    	this.size = size;
    	this.height = height;
    	this.under = under;
    	this.ist = ist;
    	//this.mode = mode;
	}

	public void run()
	{

		NBTTagCompound nbt = this.ist.getTagCompound();

		this.xxx = nbt.getInteger("settingX");
		this.zzz = nbt.getInteger("settingZ");
		this.yMain = nbt.getInteger("settingY");
		this.Hougaku = nbt.getInteger("settingFace");

		/*
        switch(this.Hougaku)
        {
        	case 1: xxx = xxx - 5; break;
        	case 2: zzz = zzz - 5; break;
        	case 3: xxx = xxx + 5; break;
        	case 0: zzz = zzz + 5; break;
        }
		*/
		/*
        switch(this.Hougaku)
        {
        	case 1: xxx = xxx - (this.size + 1); break;
        	case 2: zzz = zzz - (this.size + 1); break;
        	case 3: xxx = xxx + (this.size + 1); break;
        	case 0: zzz = zzz + (this.size + 1); break;
        }
        */
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
        	/*
	        for (int x = ((this.size + 1) * -1); x <= (this.size + 1); ++x)
	        {
	        	if(par3World.getBlock(xxx + x, yyy + this.height, zzz + this.size + 1) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + x, yyy + this.height, zzz + this.size + 1, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + x, yyy + this.height, zzz + (this.size * -1) - 1) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + x, yyy + this.height, zzz + (this.size * -1 - 1), Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + x, yyy + under, zzz + this.size  + 1) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + x, yyy + under, zzz + this.size + 1, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + x, yyy + under, zzz + (this.size * -1) - 1) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + x, yyy + under, zzz + (this.size * -1) - 1, Blocks.air, 0, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = ((this.size + 1) * -1); z <= (this.size + 1); ++z)
	        {
	        	if(par3World.getBlock(xxx + this.size + 1, yyy + this.height, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + this.size + 1, yyy + this.height, zzz + z, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + (this.size * -1) - 1, yyy + this.height, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + (this.size * -1) - 1, yyy + this.height, zzz + z, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + this.size + 1, yyy + under, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + this.size + 1, yyy + under, zzz + z, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + (this.size * -1) - 1, yyy + under, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + (this.size * -1) - 1, yyy + under, zzz + z, Blocks.air, 0, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			//System.out.println("YYYYY:" + under + "/" + height);
	        for (int y = this.under; y <= this.height; ++y)
	        {
	        	if(par3World.getBlock(xxx + this.size + 1, yyy + y, zzz + this.size + 1) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + this.size + 1, yyy + y, zzz + this.size + 1,Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + this.size + 1, yyy + y, zzz + (this.size * -1) - 1) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + this.size + 1, yyy + y, zzz + (this.size * -1 - 1), Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + (this.size * -1) - 1, yyy + y, zzz + this.size + 1) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + (this.size * -1) - 1, yyy + y, zzz + this.size + 1, Blocks.air, 0, 2);

	        	if(par3World.getBlock(xxx + (this.size * -1) - 1, yyy + y, zzz + (this.size * -1) - 1) == DQBlocks.DqmBlockBuilderFrame)
	        		par3World.setBlock(xxx + (this.size * -1) - 1, yyy + y, zzz + (this.size * -1) - 1, Blocks.air, 0, 2);
	        }
	        */
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
        	/*
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
			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
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
	        */
		}


        //int yyy = par3World.getHeightValue(xxx, zzz);


        for (int x = -1; x <= 1; ++x)
        {
            for (int z = -1; z <= 1; ++z)
            {
                for (int y = 0; y <= 2; ++y)
                {
                    par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                }
            }
        }

        if (rand.nextInt(2) == 0)
        {
            par3World.setBlock(xxx - 1, yyy, zzz, DQDecorates.DqmBlockIdo, 0, 2);
        }
            else
        {
            par3World.setBlock(xxx - 1, yyy, zzz, DQDecorates.DqmBlockIdooke, 0, 2);
        }
		try {
			this.sleep(DQR.conf.cfg_build_sleep);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        for (int y = -32; y <= -1; ++y)
        {
            par3World.setBlock(xxx, yyy + y, zzz, Blocks.air, 0, 2);
        }

        for (int x = -5; x <= 5; ++x)
        {
            for (int z = -5; z <= 5; ++z)
            {
            	if(x != 0 && z != 0)
            	{
            		par3World.setBlock(xxx + x, yyy - 30, zzz + z, DQBlocks.DqmBlockKowareru6, 0, 2);
            	}
            }
        }

        for (int x = -5; x <= 5; ++x)
        {
            for (int z = -5; z <= 5; ++z)
            {
                for (int y = -35; y <= -31; ++y)
                {
                	if(y % 2 == 0)
                	{
                		par3World.setBlock(xxx + x, yyy + y, zzz + z, DQBlocks.DqmBlockKowareru6, 0, 2);
                	}else
                	{
                		par3World.setBlock(xxx + x, yyy + y, zzz + z, DQBlocks.DqmBlockKowareru7, 0, 2);
                	}
                }
            }
        }
		try {
			this.sleep(DQR.conf.cfg_build_sleep);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

        for (int x = -5; x <= 5; ++x)
        {
            for (int z = -5; z <= 5; ++z)
            {
            	par3World.setBlock(xxx + x, yyy - 36, zzz + z, DQBlocks.DqmBlockKowareru9, 0, 2);
            }
        }

        for (int x = -1; x <= 1; ++x)
        {
            for (int y = -36; y <= -33; ++y)
            {
            	if(y == -36)
            	{
            		if(x == 0)
            		{
            			par3World.setBlock(xxx + x, yyy + y, zzz + 5, Blocks.glowstone, 0, 2);
            		}else
            		{
            			par3World.setBlock(xxx + x, yyy + y, zzz + 5, DQBlocks.DqmBlockKowareru9, 0, 2);
            		}
            	}else
            	{
            		par3World.setBlock(xxx + x, yyy + y, zzz + 5, Blocks.air, 0, 2);
                	if(y % 2 == 0)
                	{
                		par3World.setBlock(xxx + x, yyy + y, zzz + 6, DQBlocks.DqmBlockKowareru6, 0, 2);
                	}else
                	{
                		par3World.setBlock(xxx + x, yyy + y, zzz + 6, DQBlocks.DqmBlockKowareru7, 0, 2);
                	}
            	}
            }
        }

        for (int x = -2; x <= 2; ++x)
        {
            for (int z = -2; z <= 2; ++z)
            {
                for (int y = -36; y <= -35; ++y)
                {
                    par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                }
            }
        }
        for (int x = -5; x <= 5; ++x)
        {
            for (int z = -5; z <= 5; ++z)
            {
                for (int y = -37; y <= -37; ++y)
                {
                    par3World.setBlock(xxx + x, yyy + y, zzz + z, DQBlocks.DqmBlockKowareru5, 0, 2);
                }
            }
        }

		try {
			this.sleep(DQR.conf.cfg_build_sleep);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        for (int x = -4; x <= 4; ++x)
        {
            for (int z = -4; z <= 4; ++z)
            {
                for (int y = -35; y <= -31; ++y)
                {
                    par3World.setBlock(xxx + x, yyy + y, zzz + z, Blocks.air, 0, 2);
                }
            }
        }

        //par3World.setBlock(xxx + 5, yyy + y, zzz + 5, Blocks.air, 0, 2);

        par3World.setBlock(xxx + 4, yyy - 35, zzz + 4, DQDecorates.DqmBlockTaimatu2, 0, 2);
        par3World.setBlock(xxx - 4, yyy - 35, zzz + 4, DQDecorates.DqmBlockTaimatu2, 0, 2);
        par3World.setBlock(xxx + 4, yyy - 35, zzz - 4, DQDecorates.DqmBlockTaimatu2, 0, 2);
        par3World.setBlock(xxx - 4, yyy - 35, zzz - 4, DQDecorates.DqmBlockTaimatu2, 0, 2);

        par3World.setBlock(xxx - 1, yyy - 35, zzz + 5, DQDecorates.DqmBlockTaimatu2, 0, 2);
        par3World.setBlock(xxx + 1, yyy - 35, zzz + 5, DQDecorates.DqmBlockTaimatu2, 0, 2);

        par3World.setBlock(xxx + 1, yyy - 36, zzz, Blocks.flowing_water, 0, 2);
        par3World.setBlock(xxx - 1, yyy - 36, zzz, Blocks.flowing_water, 0, 2);
        par3World.setBlock(xxx, yyy - 36, zzz + 1, Blocks.flowing_water, 0, 2);
        par3World.setBlock(xxx, yyy - 36, zzz - 1, Blocks.flowing_water, 0, 2);
        par3World.setBlock(xxx, yyy - 35, zzz - 3, DQBlocks.DqmBlockJampBlock, 0, 2);
		try {
			this.sleep(DQR.conf.cfg_build_sleep);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
        DqmEntityNPCMedalking entitysilverfish = new DqmEntityNPCMedalking(par3World);
        entitysilverfish.setLocationAndAngles(xxx , yyy -34, zzz + 5, 0.0F, 0.0F);
        if(!par3World.isRemote)
        {
        	par3World.spawnEntityInWorld(entitysilverfish);
        }

	}
}
