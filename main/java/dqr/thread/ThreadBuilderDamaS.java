package dqr.thread;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.api.Blocks.DQDecorates;
import dqr.entity.npcEntity.npc.DqmEntityNPCSinkan2;

public class ThreadBuilderDamaS extends Thread{

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

	public ThreadBuilderDamaS(World par1, int size, int height, int under, ItemStack ist, int mode)
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

		NBTTagCompound nbt = this.ist.getTagCompound();


		this.xxx = nbt.getInteger("settingX");
		this.zzz = nbt.getInteger("settingZ");
		this.yMain = nbt.getInteger("settingY");
		this.Hougaku = nbt.getInteger("settingFace");
        switch(this.Hougaku)
        {
        	case 1: xxx = xxx - 24; break;
        	case 2: zzz = zzz - 24; break;
        	case 3: xxx = xxx + 24; break;
        	case 0: zzz = zzz + 24; break;
        }

        int takasa = 0;
        int yyy = this.yMain;
        //int yyy = par3World.getHeightValue(xxx, zzz);

		if(nbt.getInteger("buildReady") == 1)
		{
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

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
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
		}

		Block topBlock;

		int dim =  this.par3World.provider.dimensionId;

		if(dim == -1)
		{
			topBlock = Blocks.netherrack;
		}else if(dim == 1)
		{
			topBlock = Blocks.end_stone;
		}else
		{
			topBlock = this.par3World.getBiomeGenForCoords(this.xxx, this.zzz).topBlock;
		}

		if(topBlock != null)
		{
	        //土
	        for (int x = -24; x <= 24; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -24; z <= 24; ++z)
	            {
	                for (int y = -1; y <= -1 ; ++y)
	                {
	                	par3World.setBlock(xxx + x, yyy + y + takasa, zzz + z, topBlock, 0, 2);
	                }
	            }
	        }
		}
        /*
        for (int x = -22; x <= 22; ++x)
        {
            for (int z = -22; z <= 22; ++z)
            {
                for (int y = -1; y <= -1; ++y)
                {
                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + z, BlockList.DqmDimCloud, 0, 2);
                }
            }
        }
        */
/*
        for (int x = -23; x <= 23; ++x)
        {
            for (int z = -23; z <= 23; ++z)
            {
                for (int y = -2; y <= -2; ++y)
                {
                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Block.grass, 0, 2);
                }
            }
        }

        for (int x = -24; x <= 24; ++x)
        {
            for (int z = -24; z <= 24; ++z)
            {
                for (int y = -3; y <= -3; ++y)
                {
                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Block.grass, 0, 2);
                }
            }
        }
*/
        int byVal = 1;
        int metaV1 = 2;
        int metaV2 = 3;
        int metaV3 = 6;
        //壁
        if(this.Hougaku == 0 || this.Hougaku == 2)
        {
        	//System.out.println("方角:" + this.Hougaku);

        	if(this.Hougaku == 0)
        	{
        		byVal = 1;
        		metaV1 = 2;
        		metaV2 = 3;
        		metaV3 = 6;
        	}else
        	{
        		byVal = -1;
        		metaV1 = 3;
        		metaV2 = 2;
        		metaV3 = 7;
        	}

	        for (int x = -24; x <= 24; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -24; z <= 24; ++z)
	            {
	                for (int y = 0; y <= 18; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -20; x <= 20; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= 20; ++z)
	            {
	                for (int y = 0; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -17; x <= 17; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -17; z <= 17; ++z)
	            {
	                for (int y = 0; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -7; x <= 7; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= -16;++z)
	            {
	                for (int y = 0; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -20; x <= 20; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= 20; ++z)
	            {
	                for (int y = 2; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -11; x <= 11; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= -18; ++z)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -8; x <= 8; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= -18; ++z)
	            {
	                for (int y = 15; y <= 15; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -5; x <= 5; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= -18; ++z)
	            {
	                for (int y = 16; y <= 16; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= -18; ++z)
	            {
	                for (int y = 17; y <= 17; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = 0; x <= 0; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= -18; ++z)
	            {
	                for (int y = 18; y <= 18; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -4; x <= 4; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= -18; ++z)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -20; z <= -18; ++z)
	            {
	                for (int y = 15; y <= 15; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -21; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx - 7, yyy + 0 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -21; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx + 7, yyy + 0 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int x = -21; x <= -7; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 0 + takasa, zzz - (21 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = 7; x <= 21; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 0 + takasa, zzz - (21 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -21; x <= 21; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 0 + takasa, zzz + (21 * byVal), Blocks.stone_brick_stairs, metaV2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -21; z <= 21; ++z)
	        {
	            par3World.setBlock(xxx + 21, yyy + 0 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -21; z <= 21; ++z)
	        {
	            par3World.setBlock(xxx - 21, yyy + 0 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -20; x <= 20; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 13 + takasa, zzz + (20 * byVal), Blocks.stone_brick_stairs, metaV2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -20; z <= 20; ++z)
	        {
	            par3World.setBlock(xxx + 20, yyy + 13 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 20, yyy + 13 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -20; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx + 11, yyy + 14 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 11, yyy + 14 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int z = -20; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx + 8, yyy + 15 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 8, yyy + 15 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int z = -20; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx + 5, yyy + 16 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 5, yyy + 16 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int z = -20; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx + 2, yyy + 17 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 2, yyy + 17 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int z = -20; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx + 1, yyy + 18 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 1, yyy + 18 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int z = -20; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx + 1, yyy + 15 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 4, 2);
	            par3World.setBlock(xxx - 1, yyy + 15 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 5, 2);
	        }

	        for (int z = -20; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx + 4, yyy + 14 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 4, 2);
	            par3World.setBlock(xxx - 4, yyy + 14 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 5, 2);
	        }

	        for (int z = -20; z <= -18; ++z)
	        {
	            par3World.setBlock(xxx + 7, yyy + 13 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 4, 2);
	            par3World.setBlock(xxx - 7, yyy + 13 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 5, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        par3World.setBlock(xxx, yyy + 17 + takasa, zzz - (20 * byVal), DQBlocks.DqmBlockKowareru7, 0, 2);
	        //炎と聖杯
	        par3World.setBlock(xxx + 5, yyy + 0 + takasa, zzz - (21 * byVal), DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx + 5, yyy + 1 + takasa, zzz - (21 * byVal), Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - 5, yyy + 0 + takasa, zzz - (21 * byVal), DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - 5, yyy + 1 + takasa, zzz - (21 * byVal), Blocks.fire, 0, 2);
	        par3World.setBlock(xxx + 5, yyy + 0 + takasa, zzz - (17 * byVal), DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx + 5, yyy + 1 + takasa, zzz - (17 * byVal), Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - 5, yyy + 0 + takasa, zzz - (17 * byVal), DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - 5, yyy + 1 + takasa, zzz - (17 * byVal), Blocks.fire, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 4 + takasa, zzz - (8 * byVal), DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 5 + takasa, zzz - (8 * byVal), Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 4 + takasa, zzz - (8 * byVal), DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 5 + takasa, zzz - (8 * byVal), Blocks.fire, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 4 + takasa, zzz - (3 * byVal), DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 5 + takasa, zzz - (3 * byVal), Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 4 + takasa, zzz - (3 * byVal), DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 5 + takasa, zzz - (3 * byVal), Blocks.fire, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //前柱
	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - 9, yyy + y + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - 9, yyy + 11 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - 9, yyy + 2 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + 9, yyy + y + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + 9, yyy + 11 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + 9, yyy + 2 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - 19, yyy + y + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - 19, yyy + 11 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - 19, yyy + 2 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + 19, yyy + y + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + 19, yyy + 11 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + 19, yyy + 2 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //横柱
	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - 19, yyy + y + takasa, zzz, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - 19, yyy + 11 + takasa, zzz, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - 19, yyy + 2 + takasa, zzz, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - 19, yyy + y + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - 19, yyy + 11 + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - 19, yyy + 2 + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - 19, yyy + y + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - 19, yyy + 11 + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - 19, yyy + 2 + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - 19, yyy + y + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - 19, yyy + 11 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - 19, yyy + 2 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - 19, yyy + y + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - 19, yyy + 11 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - 19, yyy + 2 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //
	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + 19, yyy + y + takasa, zzz, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + 19, yyy + 11 + takasa, zzz, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + 19, yyy + 2 + takasa, zzz, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + 19, yyy + y + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + 19, yyy + 11 + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + 19, yyy + 2 + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + 19, yyy + y + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + 19, yyy + 11 + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + 19, yyy + 2 + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + 19, yyy + y + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + 19, yyy + 11 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + 19, yyy + 2 + takasa, zzz - (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + 19, yyy + y + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + 19, yyy + 11 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + 19, yyy + 2 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //後柱
	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx, yyy + y + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx, yyy + 11 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx, yyy + 2 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - 9, yyy + y + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - 9, yyy + 11 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - 9, yyy + 2 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + 9, yyy + y + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + 9, yyy + 11 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + 9, yyy + 2 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - 19, yyy + y + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - 19, yyy + 11 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - 19, yyy + 2 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + 19, yyy + y + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + 19, yyy + 11 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + 19, yyy + 2 + takasa, zzz + (19 * byVal), DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //床
	        for (int x = -10; x <= 10; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -10; z <= 10; ++z)
	            {
	                for (int y = 3; y <= 3; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -11; x <= 11; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -11; z <= 11; ++z)
	            {
	                for (int y = 2; y <= 2; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -12; x <= 12; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -12; z <= 12; ++z)
	            {
	                for (int y = 1; y <= 1; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -15; x <= 15; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -15; z <= 15; ++z)
	            {
	                for (int y = -1; y <= 0; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -14; x <= 14; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -14; z <= 14; ++z)
	            {
	                for (int y = 0; y <= 0; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.water, 0, 2);
	                }
	            }
	        }

	        for (int x = -13; x <= 13; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -13; z <= 13; ++z)
	            {
	                for (int y = 0; y <= 0; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        //階段
	        par3World.setBlock(xxx + 3, yyy + 3 + takasa, zzz - (11 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 3 + takasa, zzz - (11 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 3 + takasa, zzz - (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 3 + takasa, zzz - (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 2 + takasa, zzz - (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 2 + takasa, zzz - (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 2 + takasa, zzz - (13 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 2 + takasa, zzz - (13 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 1 + takasa, zzz - (13 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 1 + takasa, zzz - (13 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 1 + takasa, zzz - (14 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 1 + takasa, zzz - (14 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 0 + takasa, zzz - (14 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 0 + takasa, zzz - (14 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 0 + takasa, zzz - (15 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 0 + takasa, zzz - (15 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 3, yyy - 1 + takasa, zzz - (15 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 3, yyy - 1 + takasa, zzz - (15 * byVal), Blocks.stonebrick, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -2; x <= 2; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 3 + takasa, zzz - (11 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 2 + takasa, zzz - (12 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 1 + takasa, zzz - (13 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 0 + takasa, zzz - (14 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 0 + takasa, zzz - (15 * byVal), Blocks.air, 2, 2);
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy - 1 + takasa, zzz - (15 * byVal), DQBlocks.DqmBlockKowareru6, 2, 2);
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy - 1 + takasa, zzz - (21 * byVal), DQBlocks.DqmBlockKowareru6, 2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -20; z <= -15; ++z)
	        {
	            par3World.setBlock(xxx + 2, yyy - 1 + takasa, zzz + (z * byVal), DQBlocks.DqmBlockKowareru6, 2, 2);
	            par3World.setBlock(xxx - 2, yyy - 1 + takasa, zzz + (z * byVal), DQBlocks.DqmBlockKowareru6, 2, 2);
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
	            for (int z = -20; z <= -15; ++z)
	            {
	                par3World.setBlock(xxx + x, yyy - 1 + takasa, zzz + (z * byVal), DQBlocks.DqmBlockKowareru5, 11, 2);
	            }
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -21; z <= -16; ++z)
	        {
	            par3World.setBlock(xxx + 3, yyy + 0 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 3, yyy + 0 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //中絨毯
	        for (int x = -1; x <= 1; ++x)
	        {
	            for (int z = -10; z <= -2; ++z)
	            {
	                par3World.setBlock(xxx + x, yyy + 3 + takasa, zzz + (z * byVal), DQBlocks.DqmBlockKowareru5, 11, 2);
	            }
	        }

	        for (int z = -10; z <= -2; ++z)
	        {
	            par3World.setBlock(xxx + 2, yyy + 3 + takasa, zzz + (z * byVal), DQBlocks.DqmBlockKowareru6, 11, 2);
	            par3World.setBlock(xxx - 2, yyy + 3 + takasa, zzz + (z * byVal), DQBlocks.DqmBlockKowareru6, 11, 2);
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 3 + takasa, zzz - (1 * byVal), DQBlocks.DqmBlockKowareru6, 11, 2);
	        }

	        //高台
	        for (int x = -5; x <= 5; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 0; z <= 9; ++z)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.water, 0, 2);
	                }
	            }
	        }

	        for (int x = -4; x <= 4; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= 8; ++z)
	            {
	                for (int y = 4; y <= 5; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -3; x <= 3; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 2; z <= 8; ++z)
	            {
	                for (int y = 6; y <= 7; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 3; z <= 7; ++z)
	            {
	                for (int y = 8; y <= 9; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -6; x <= 6; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -1; z <= -1; ++z)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	                }
	            }
	        }

	        for (int x = -6; x <= 6; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 10; z <= 10; ++z)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, metaV2, 2);
	                }
	            }
	        }

	        for (int x = 6; x <= 6; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -1; z <= 10; ++z)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	                }
	            }
	        }

	        for (int x = -6; x <= -6; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -1; z <= 10; ++z)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	                }
	            }
	        }

	        par3World.setBlock(xxx + 5, yyy + 4 + takasa, zzz + 0,Blocks.stonebrick, 2, 2);
	        par3World.setBlock(xxx - 5, yyy + 4 + takasa, zzz + 0, Blocks.stonebrick, 2, 2);
	        par3World.setBlock(xxx + 2, yyy + 4 + takasa, zzz + 0, Blocks.stonebrick, 2, 2);
	        par3World.setBlock(xxx - 2, yyy + 4 + takasa, zzz + 0, Blocks.stonebrick, 2, 2);

	        for (int x = -1; x <= 1; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 4 + takasa, zzz + 0, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 5 + takasa, zzz + (1 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 6 + takasa, zzz + (2 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 7 + takasa, zzz + (3 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 8 + takasa, zzz + (4 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 4 + takasa, zzz - (1 * byVal), Blocks.air, 2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -1; x <= 1; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= 4; ++z)
	            {
	                for (int y = 9; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= +3; ++z)
	            {
	                for (int y = 8; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= +2; ++z)
	            {
	                for (int y = 7; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        //内柱
	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + 5, yyy + y + takasa, zzz - (8 * byVal), DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + 5, yyy + 9 + takasa, zzz - (8 * byVal), DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + 5, yyy + 4 + takasa, zzz - (8 * byVal), DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - 5, yyy + y + takasa, zzz - (8 * byVal), DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - 5, yyy + 9 + takasa, zzz - (8 * byVal), DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - 5, yyy + 4 + takasa, zzz - (8 * byVal), DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + 5, yyy + y + takasa, zzz - (4 * byVal), DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + 5, yyy + 9 + takasa, zzz - (4 * byVal), DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + 5, yyy + 4 + takasa, zzz - (4 * byVal), DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - 5, yyy + y + takasa, zzz - (4 * byVal), DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - 5, yyy + 9 + takasa, zzz - (4 * byVal), DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - 5, yyy + 4 + takasa, zzz - (4 * byVal), DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 6; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + 5, yyy + y + takasa, zzz, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + 5, yyy + 9 + takasa, zzz, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + 5, yyy + 5 + takasa, zzz, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 6; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - 5, yyy + y + takasa, zzz, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - 5, yyy + 9 + takasa, zzz, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - 5, yyy + 5 + takasa, zzz, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + 9, yyy + y + takasa, zzz, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + 9, yyy + 9 + takasa, zzz, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + 9, yyy + 4 + takasa, zzz, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - 9, yyy + y + takasa, zzz, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - 9, yyy + 9 + takasa, zzz, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - 9, yyy + 4 + takasa, zzz, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + 9, yyy + y + takasa, zzz + (5 * byVal), DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + 9, yyy + 9 + takasa, zzz + (5 * byVal), DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + 9, yyy + 4 + takasa, zzz + (5 * byVal), DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - 9, yyy + y + takasa, zzz + (5 * byVal), DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - 9, yyy + 9 + takasa, zzz + (5 * byVal), DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - 9, yyy + 4 + takasa, zzz + (5 * byVal), DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + 9, yyy + y + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + 9, yyy + 9 + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + 9, yyy + 4 + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - 9, yyy + y + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - 9, yyy + 9 + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - 9, yyy + 4 + takasa, zzz + (9 * byVal), DQDecorates.DqmBlockHasira, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        //屋根後ろ
	        for (int x = -9; x <= 9; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 0; z <= 9; ++z)
	            {
	                for (int y = 10; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -8; x <= 8; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= 8; ++z)
	            {
	                for (int y = 11; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -6; x <= 6; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= 7; ++z)
	            {
	                for (int y = 12; y <= 12; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -4; x <= 4; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= 6; ++z)
	            {
	                for (int y = 13; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= 5; ++z)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = 0; x <= 0; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= 3; ++z)
	            {
	                for (int y = 15; y <= 15; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        //屋根後ろ穴
	        for (int x = -8; x <= 8; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 2; z <= 8; ++z)
	            {
	                for (int y = 10; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -6; x <= 6; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 2; z <= 7; ++z)
	            {
	                for (int y = 11; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -4; x <= 4; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 2; z <= 6; ++z)
	            {
	                for (int y = 12; y <= 12; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -2; x <= 2; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 2; z <= 5; ++z)
	            {
	                for (int y = 13; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = 0; x <= 0; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 2; z <= 3; ++z)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        //屋根前
	        for (int x = -5; x <= 5; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -8; z <= -1; ++z)
	            {
	                for (int y = 10; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -4; x <= 4; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -8; z <= 0; ++z)
	            {
	                for (int y = 11; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -3; x <= 3; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -8; z <= 0; ++z)
	            {
	                for (int y = 12; y <= 12; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -7; z <= 0; ++z)
	            {
	                for (int y = 13; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = 0; x <= 0; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -6; z <= 0; ++z)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -8; z <= -1; ++z)
	        {
	            par3World.setBlock(xxx + 6, yyy + 10 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 6, yyy + 10 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int z = -6; z <= 0; ++z)
	        {
	            par3World.setBlock(xxx + 2, yyy + 13 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 2, yyy + 13 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        par3World.setBlock(xxx + 1, yyy + 13 + takasa, zzz - (7 * byVal), Blocks.stone_brick_stairs, 1, 2);
	        par3World.setBlock(xxx - 1, yyy + 13 + takasa, zzz - (7 * byVal), Blocks.stone_brick_stairs, 0, 2);
	        par3World.setBlock(xxx, yyy + 13 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx + 1, yyy + 13 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx - 1, yyy + 13 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx + 3, yyy + 12 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, 1, 2);
	        par3World.setBlock(xxx - 3, yyy + 12 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, 0, 2);
	        par3World.setBlock(xxx + 5, yyy + 11 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, 1, 2);
	        par3World.setBlock(xxx - 5, yyy + 11 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, 0, 2);
	        par3World.setBlock(xxx, yyy + 14 + takasa, zzz - (7 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx, yyy + 12 + takasa, zzz - (8 * byVal), DQBlocks.DqmBlockKowareru7, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 10 + takasa, zzz - (8 * byVal), Blocks.air, 0, 2);
	        par3World.setBlock(xxx - 1, yyy + 10 + takasa, zzz - (8 * byVal), Blocks.air, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 10 + takasa, zzz - (8 * byVal), Blocks.air, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 10 + takasa, zzz - (8 * byVal), Blocks.air, 0, 2);
	        par3World.setBlock(xxx, yyy + 10 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, metaV3, 2);
	        par3World.setBlock(xxx + 2, yyy + 10 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, metaV3, 2);
	        par3World.setBlock(xxx - 2, yyy + 10 + takasa, zzz - (8 * byVal), Blocks.stone_brick_stairs, metaV3, 2);
	        par3World.setBlock(xxx, yyy + 15 + takasa, zzz, Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx, yyy + 15 + takasa, zzz + (4 * byVal), Blocks.stone_brick_stairs, metaV2, 2);

	        for (int z = 2; z <= 4; ++z)
	        {
	            par3World.setBlock(xxx + 1, yyy + 15 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 1, yyy + 15 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int z = -6; z <= 0; ++z)
	        {
	            par3World.setBlock(xxx + 1, yyy + 14 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 1, yyy + 14 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int x = 6; x <= 10; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 10 + takasa, zzz - (1 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -10; x <= -6; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 10 + takasa, zzz - (1 * byVal), Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -1; z <= 10; ++z)
	        {
	            par3World.setBlock(xxx + 10, yyy + 10 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 1, 2);
	            par3World.setBlock(xxx - 10, yyy + 10 + takasa, zzz + (z * byVal), Blocks.stone_brick_stairs, 0, 2);
	        }

	        for (int x = -10; x <= 10; ++x)
	        {
	            par3World.setBlock(xxx + x, yyy + 10 + takasa, zzz + (10 * byVal), Blocks.stone_brick_stairs, metaV2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //屋根前穴
	        for (int x = -4; x <= 4; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -7; z <= 1; ++z)
	            {
	                for (int y = 10; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -3; x <= 3; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -7; z <= 1; ++z)
	            {
	                for (int y = 11; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int x = -1; x <= 1; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -7; z <= 1; ++z)
	            {
	                for (int y = 12; y <= 12; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //高台椅子
	        par3World.setBlock(xxx, yyy + 9 + takasa, zzz + (6 * byVal), Blocks.air, 0, 2);
	        par3World.setBlock(xxx, yyy + 9 + takasa, zzz + (5 * byVal), Blocks.air, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 9 + takasa, zzz + (5 * byVal), Blocks.air, 0, 2);
	        par3World.setBlock(xxx - 1, yyy + 9 + takasa, zzz + (5 * byVal), Blocks.air, 0, 2);
	        par3World.setBlock(xxx, yyy + 10 + takasa, zzz + (7 * byVal), Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx + 1, yyy + 10 + takasa, zzz + (6 * byVal), Blocks.stone_brick_stairs, 1, 2);
	        par3World.setBlock(xxx - 1, yyy + 10 + takasa, zzz + (6 * byVal), Blocks.stone_brick_stairs, 0, 2);
	        par3World.setBlock(xxx, yyy + 9 + takasa, zzz +(5 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 9 + takasa, zzz + (5 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 1, yyy + 9 + takasa, zzz + (5 * byVal), Blocks.stonebrick, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        /*
	         * NPC召喚処理
	         */
	        DqmEntityNPCSinkan2 entitysilverfish = new DqmEntityNPCSinkan2(par3World);
	        entitysilverfish.setLocationAndAngles(xxx + 0.5F, yyy + 9 + takasa, zzz + (6 * byVal) + 0.5F, 0.0F, 0.0F);
	        par3World.spawnEntityInWorld(entitysilverfish);
	        //裏の隠し扉
	        par3World.setBlock(xxx, yyy + 0 + takasa, zzz + (14 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 0 + takasa, zzz + (14 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 1, yyy + 0 + takasa, zzz + (14 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 1 + takasa, zzz + (13 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 1, yyy + 1 + takasa, zzz + (13 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 2 + takasa, zzz + (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 1, yyy + 2 + takasa, zzz + (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 2, yyy + 2 + takasa, zzz + (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 2, yyy + 2 + takasa, zzz + (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 3 + takasa, zzz + (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 1, yyy + 3 + takasa, zzz + (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 3 + takasa, zzz + (11 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - 1, yyy + 3 + takasa, zzz + (11 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx, yyy + 3 + takasa, zzz + (12 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx, yyy + 3 + takasa, zzz + (11 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx, yyy + 4 + takasa, zzz + (11 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx, yyy + 4 + takasa, zzz + (10 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 4 + takasa, zzz + (11 * byVal), Blocks.stone_brick_stairs, 1, 2);
	        par3World.setBlock(xxx - 1, yyy + 4 + takasa, zzz + (11 * byVal), Blocks.stone_brick_stairs, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 4 + takasa, zzz + (12 * byVal), Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx - 1, yyy + 4 + takasa, zzz + (12 * byVal), Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx, yyy + 4 + takasa, zzz + (12 * byVal), Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx, yyy + 3 + takasa, zzz + (13 * byVal), Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx + 1, yyy + 2 + takasa, zzz + (13 * byVal), Blocks.stone_brick_stairs, 1, 2);
	        par3World.setBlock(xxx - 1, yyy + 2 + takasa, zzz + (13 * byVal), Blocks.stone_brick_stairs, 0, 2);
	        //Block block;
	        //block = DQBlocks.DqmBlockKowareruDoor3;
	        //int i0 = MathHelper.floor_double((double)((180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
	        //placeDoorBlock(par3World, xxx, yyy + 1 + takasa, zzz + 13, i0, block);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = 9; z <= 12; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int y = 1; y <= 2; ++y)
	            {
	                par3World.setBlock(xxx, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	            }
	        }

	        for (int x = -3; x <= 3; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = 1; z <= 8; ++z)
	            {
	                for (int y = 1; y <= 3; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.air, 0, 2);
	                }
	            }
	        }

	        //par3World.setBlock(xxx, yyy + 1, zzz + 4, Block.chest, 0, 2);
	        //DqmWorldChest.Chest4(rand, xxx, yyy + 1, zzz + 4, par3World);
	        //像
	        par3World.setBlock(xxx + 8, yyy + 4 + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockDaizaS, 0, 2);
	        par3World.setBlock(xxx + 8, yyy + 5 + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockSKirapan, 3, 2);
	        par3World.setBlock(xxx - 8, yyy + 4 + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockDaizaS, 0, 2);
	        par3World.setBlock(xxx - 8, yyy + 5 + takasa, zzz - (9 * byVal), DQDecorates.DqmBlockSKirapan, 1, 2);
	        par3World.setBlock(xxx + 7, yyy + 4 + takasa, zzz - (3 * byVal), DQDecorates.DqmBlockDaizaS, 0, 2);
	        par3World.setBlock(xxx + 7, yyy + 5 + takasa, zzz - (3 * byVal), DQDecorates.DqmBlockSKirapan, 3, 2);
	        par3World.setBlock(xxx - 7, yyy + 4 + takasa, zzz - (3 * byVal), DQDecorates.DqmBlockDaizaS, 0, 2);
	        par3World.setBlock(xxx - 7, yyy + 5 + takasa, zzz - (3 * byVal), DQDecorates.DqmBlockSKirapan, 1, 2);
			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
        }else
        {
        	//System.out.println("方角:" + this.Hougaku);

        	if(this.Hougaku == 3)
        	{
        		byVal = 1;
        		//metaV1 = 2;
        		//metaV2 = 3;
        		//metaV3 = 6;
        		metaV1 = 0;
        		metaV2 = 1;
        		metaV3 = 4;
        	}else
        	{
        		byVal = -1;
        		//metaV1 = 3;
        		//metaV2 = 2;
        		//metaV3 = 7;
        		metaV1 = 1;
        		metaV2 = 0;
        		metaV3 = 5;
        	}

	        for (int z = -20; z <= 20; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= 20; ++x)
	            {
	                for (int y = 0; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -17; z <= 17; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -17; x <= 17; ++x)
	            {
	                for (int y = 0; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -7; z <= 7; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= -16;++x)
	            {
	                for (int y = 0; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -20; z <= 20; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= 20; ++x)
	            {
	                for (int y = 2; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -11; z <= 11; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= -18; ++x)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -8; z <= 8; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= -18; ++x)
	            {
	                for (int y = 15; y <= 15; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -5; z <= 5; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= -18; ++x)
	            {
	                for (int y = 16; y <= 16; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= -18; ++x)
	            {
	                for (int y = 17; y <= 17; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = 0; z <= 0; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= -18; ++x)
	            {
	                for (int y = 18; y <= 18; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -4; z <= 4; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= -18; ++x)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -20; x <= -18; ++x)
	            {
	                for (int y = 15; y <= 15; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -21; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 0 + takasa, zzz - 7, Blocks.stone_brick_stairs, 3, 2);
	        }

	        for (int x = -21; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 0 + takasa, zzz + 7, Blocks.stone_brick_stairs, 2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -21; z <= -7; ++z)
	        {
	            par3World.setBlock(xxx - (21 * byVal), yyy + 0 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        for (int z = 7; z <= 21; ++z)
	        {
	            par3World.setBlock(xxx - (21 * byVal), yyy + 0 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }
			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -21; z <= 21; ++z)
	        {
	            par3World.setBlock(xxx + (21 * byVal), yyy + 0 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -21; x <= 21; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 0 + takasa, zzz + 21, Blocks.stone_brick_stairs, 3, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -21; x <= 21; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 0 + takasa, zzz - 21, Blocks.stone_brick_stairs, 2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -20; z <= 20; ++z)
	        {
	            par3World.setBlock(xxx + (20 * byVal), yyy + 13 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -20; x <= 20; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 13 + takasa, zzz + 20, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 13 + takasa, zzz - 20, Blocks.stone_brick_stairs, 2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -20; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 14 + takasa, zzz + 11, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 14 + takasa, zzz - 11, Blocks.stone_brick_stairs, 2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -20; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 15 + takasa, zzz + 8, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 15 + takasa, zzz - 8, Blocks.stone_brick_stairs, 2, 2);
	        }

	        for (int x = -20; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 16 + takasa, zzz + 5, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 16 + takasa, zzz - 5, Blocks.stone_brick_stairs, 2, 2);
	        }

	        for (int x = -20; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 17 + takasa, zzz + 2, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 17 + takasa, zzz - 2, Blocks.stone_brick_stairs, 2, 2);
	        }

	        for (int x = -20; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 18 + takasa, zzz + 1, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 18 + takasa, zzz - 1, Blocks.stone_brick_stairs, 2, 2);
	        }

	        for (int x = -20; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 15 + takasa, zzz + 1, Blocks.stone_brick_stairs, 6, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 15 + takasa, zzz - 1, Blocks.stone_brick_stairs, 7, 2);
	        }

	        for (int x = -20; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 14 + takasa, zzz + 4, Blocks.stone_brick_stairs, 6, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 14 + takasa, zzz - 4, Blocks.stone_brick_stairs, 7, 2);
	        }

	        for (int x = -20; x <= -18; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 13 + takasa, zzz + 7, Blocks.stone_brick_stairs, 6, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 13 + takasa, zzz - 7, Blocks.stone_brick_stairs, 7, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        par3World.setBlock(xxx - (20 * byVal), yyy + 17 + takasa, zzz, DQBlocks.DqmBlockKowareru7, 0, 2);
	        //炎と聖杯
	        par3World.setBlock(xxx - (21 * byVal), yyy + 0 + takasa, zzz + 5, DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - (21 * byVal), yyy + 1 + takasa, zzz + 5, Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - (21 * byVal), yyy + 0 + takasa, zzz - 5, DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - (21 * byVal), yyy + 1 + takasa, zzz - 5, Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - (17 * byVal), yyy + 0 + takasa, zzz + 5, DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - (17 * byVal), yyy + 1 + takasa, zzz + 5, Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - (17 * byVal), yyy + 0 + takasa, zzz - 5, DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - (17 * byVal), yyy + 1 + takasa, zzz - 5, Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 4 + takasa, zzz + 3, DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 5 + takasa, zzz + 3, Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 4 + takasa, zzz - 3, DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 5 + takasa, zzz - 3, Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - (3 * byVal), yyy + 4 + takasa, zzz + 3, DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - (3 * byVal), yyy + 5 + takasa, zzz + 3, Blocks.fire, 0, 2);
	        par3World.setBlock(xxx - (3 * byVal), yyy + 4 + takasa, zzz - 3, DQDecorates.DqmBlockKagaribidai, 0, 2);
	        par3World.setBlock(xxx - (3 * byVal), yyy + 5 + takasa, zzz - 3, Blocks.fire, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //前柱
	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - (19 * byVal), yyy + y + takasa, zzz - 9,DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - (19 * byVal), yyy + 11 + takasa, zzz - 9, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - (19 * byVal), yyy + 2 + takasa, zzz - 9, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - (19 * byVal), yyy + y + takasa, zzz + 9, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - (19 * byVal), yyy + 11 + takasa, zzz + 9, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - (19 * byVal), yyy + 2 + takasa, zzz + 9, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - (19 * byVal), yyy + y + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - (19 * byVal), yyy + 11 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - (19 * byVal), yyy + 2 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - (19 * byVal), yyy + y + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - (19 * byVal), yyy + 11 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - (19 * byVal), yyy + 2 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //横柱
	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx, yyy + y + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx, yyy + 11 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx, yyy + 2 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - (9 * byVal), yyy + y + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - (9 * byVal), yyy + 11 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - (9 * byVal), yyy + 2 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + (9 * byVal), yyy + y + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + (9 * byVal), yyy + 11 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + (9 * byVal), yyy + 2 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - (19 * byVal), yyy + y + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - (19 * byVal), yyy + 11 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - (19 * byVal), yyy + 2 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + (19 * byVal), yyy + y + takasa, zzz - 19 , DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + (19 * byVal), yyy + 11 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + (19 * byVal), yyy + 2 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        //
	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx, yyy + y + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx, yyy + 11 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx, yyy + 2 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - (9 * byVal), yyy + y + takasa, zzz + 19 , DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - (9 * byVal), yyy + 11 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - (9 * byVal), yyy + 2 + takasa, zzz +19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + (9 * byVal), yyy + y + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + (9 * byVal), yyy + 11 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + (9 * byVal), yyy + 2 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx - (19 * byVal), yyy + y + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx - (19 * byVal), yyy + 11 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx - (19 * byVal), yyy + 2 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + (19 * byVal), yyy + y + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + (19 * byVal), yyy + 11 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + (19 * byVal), yyy + 2 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //後柱
	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + (19 * byVal), yyy + y + takasa, zzz, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + (19 * byVal), yyy + 11 + takasa, zzz,  DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + (19 * byVal), yyy + 2 + takasa, zzz,  DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + (19 * byVal), yyy + y + takasa, zzz - 9, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + (19 * byVal), yyy + 11 + takasa, zzz - 9, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + (19 * byVal), yyy + 2 + takasa, zzz - 9, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + (19 * byVal), yyy + y + takasa, zzz + 9, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + (19 * byVal), yyy + 11 + takasa, zzz + 9, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + (19 * byVal), yyy + 2 + takasa, zzz + 9, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + (19 * byVal), yyy + y + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + (19 * byVal), yyy + 11 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + (19 * byVal), yyy + 2 + takasa, zzz - 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

	        for (int y = 3; y <= 10; ++y)
	        {
	            par3World.setBlock(xxx + (19 * byVal), yyy + y + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiranakaS, 0, 2);
	        }

	        par3World.setBlock(xxx + (19 * byVal), yyy + 11 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasiraueS, 0, 2);
	        par3World.setBlock(xxx + (19 * byVal), yyy + 2 + takasa, zzz + 19, DQDecorates.DqmBlockOokiihasirasitaS, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //床
	        for (int z = -10; z <= 10; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -10; x <= 10; ++x)
	            {
	                for (int y = 3; y <= 3; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -11; x <= 11; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -11; z <= 11; ++z)
	            {
	                for (int y = 2; y <= 2; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -12; x <= 12; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -12; z <= 12; ++z)
	            {
	                for (int y = 1; y <= 1; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -15; x <= 15; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -15; z <= 15; ++z)
	            {
	                for (int y = -1; y <= 0; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int x = -14; x <= 14; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -14; z <= 14; ++z)
	            {
	                for (int y = 0; y <= 0; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.water, 0, 2);
	                }
	            }
	        }

	        for (int x = -13; x <= 13; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -13; z <= 13; ++z)
	            {
	                for (int y = 0; y <= 0; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * byVal), Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //階段
	        par3World.setBlock(xxx - (11 * byVal), yyy + 3 + takasa, zzz + 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (11 * byVal), yyy + 3 + takasa, zzz - 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (12 * byVal), yyy + 3 + takasa, zzz + 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (12 * byVal), yyy + 3 + takasa, zzz - 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (12 * byVal), yyy + 2 + takasa, zzz + 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (12 * byVal), yyy + 2 + takasa, zzz - 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (13 * byVal), yyy + 2 + takasa, zzz + 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (13 * byVal), yyy + 2 + takasa, zzz - 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (13 * byVal), yyy + 1 + takasa, zzz + 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (13 * byVal), yyy + 1 + takasa, zzz - 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (14 * byVal), yyy + 1 + takasa, zzz + 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (14 * byVal), yyy + 1 + takasa, zzz - 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (14 * byVal), yyy + 0 + takasa, zzz + 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (14 * byVal), yyy + 0 + takasa, zzz - 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (15 * byVal), yyy + 0 + takasa, zzz + 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (15 * byVal), yyy + 0 + takasa, zzz - 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (15 * byVal), yyy - 1 + takasa, zzz + 3, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx - (15 * byVal), yyy - 1 + takasa, zzz - 3, Blocks.stonebrick, 0, 2);

	        for (int z = -2; z <= 2; ++z)
	        {
	            par3World.setBlock(xxx - (11 * byVal), yyy + 3 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
	            par3World.setBlock(xxx - (12 * byVal), yyy + 2 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
	            par3World.setBlock(xxx - (13 * byVal), yyy + 1 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
	            par3World.setBlock(xxx - (14 * byVal), yyy + 0 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
	            par3World.setBlock(xxx - (15 * byVal), yyy + 0 + takasa, zzz + z, Blocks.air, 2, 2);
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
	            par3World.setBlock(xxx - (15 * byVal), yyy - 1 + takasa, zzz + z, DQBlocks.DqmBlockKowareru6, 2, 2);
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
	            par3World.setBlock(xxx - (21 * byVal), yyy - 1 + takasa, zzz + z, DQBlocks.DqmBlockKowareru6, 2, 2);
	        }

	        for (int x = -20; x <= -15; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy - 1 + takasa, zzz + 2, DQBlocks.DqmBlockKowareru6, 2, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy - 1 + takasa, zzz - 2, DQBlocks.DqmBlockKowareru6, 2, 2);
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
	            for (int x = -20; x <= -15; ++x)
	            {
	                par3World.setBlock(xxx + (x * byVal), yyy - 1 + takasa, zzz + z, DQBlocks.DqmBlockKowareru5, 11, 2);
	            }
	        }

	        for (int x = -21; x <= -16; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 0 + takasa, zzz + 3, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 0 + takasa, zzz - 3, Blocks.stone_brick_stairs, 2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //中絨毯
	        for (int z = -1; z <= 1; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -10; x <= -2; ++x)
	            {
	                par3World.setBlock(xxx + (x * byVal), yyy + 3 + takasa, zzz + (z * byVal), DQBlocks.DqmBlockKowareru5, 11, 2);
	            }
	        }

	        for (int x = -10; x <= -2; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 3 + takasa, zzz + 2, DQBlocks.DqmBlockKowareru6, 11, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 3 + takasa, zzz - 2, DQBlocks.DqmBlockKowareru6, 11, 2);
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
	            par3World.setBlock(xxx - (1 * byVal), yyy + 3 + takasa, zzz + z, DQBlocks.DqmBlockKowareru6, 11, 2);
	        }

	        //高台

	        for (int z = -5; z <= 5; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 0; x <= 9; ++x)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.water, 0, 2);
	                }
	            }
	        }

	        for (int z = -4; z <= 4; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= 8; ++x)
	            {
	                for (int y = 4; y <= 5; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -3; z <= 3; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 2; x <= 8; ++x)
	            {
	                for (int y = 6; y <= 7; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 3; x <= 7; ++x)
	            {
	                for (int y = 8; y <= 9; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -6; z <= 6; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -1; x <= -1; ++x)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	                }
	            }
	        }

	        for (int z = -6; z <= 6; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 10; x <= 10; ++x)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stone_brick_stairs, metaV2, 2);
	                }
	            }
	        }

	        for (int z = 6; z <= 6; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -1; x <= 10; ++x)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stone_brick_stairs, 3, 2);
	                }
	            }
	        }

	        for (int z = -6; z <= -6; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -1; x <= 10; ++x)
	            {
	                for (int y = 4; y <= 4; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stone_brick_stairs, 2, 2);
	                }
	            }
	        }

	        par3World.setBlock(xxx + 0, yyy + 4 + takasa, zzz + 5, Blocks.stonebrick, 2, 2);
	        par3World.setBlock(xxx - 0, yyy + 4 + takasa, zzz - 5, Blocks.stonebrick, 2, 2);
	        par3World.setBlock(xxx + 0, yyy + 4 + takasa, zzz + 2, Blocks.stonebrick, 2, 2);
	        par3World.setBlock(xxx - 0, yyy + 4 + takasa, zzz - 2, Blocks.stonebrick, 2, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -1; z <= 1; ++z)
	        {
	            par3World.setBlock(xxx + 0, yyy + 4 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
	            par3World.setBlock(xxx + (1 * byVal), yyy + 5 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
	            par3World.setBlock(xxx + (2 * byVal), yyy + 6 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
	            par3World.setBlock(xxx + (3 * byVal), yyy + 7 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
	            par3World.setBlock(xxx + (4 * byVal), yyy + 8 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
	            par3World.setBlock(xxx - (1 * byVal), yyy + 4 + takasa, zzz + z, Blocks.air, 2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int z = -1; z <= 1; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= 4; ++x)
	            {
	                for (int y = 9; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= +3; ++x)
	            {
	                for (int y = 8; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= +2; ++x)
	            {
	                for (int y = 7; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //内柱
	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - (8 * byVal), yyy + y + takasa, zzz + 5, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - (8 * byVal), yyy + 9 + takasa, zzz + 5, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 4 + takasa, zzz + 5, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - (8 * byVal), yyy + y + takasa, zzz - 5, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - (8 * byVal), yyy + 9 + takasa, zzz - 5, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 4 + takasa, zzz - 5, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - (4 * byVal), yyy + y + takasa, zzz + 5, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - (4 * byVal), yyy + 9 + takasa, zzz + 5, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - (4 * byVal), yyy + 4 + takasa, zzz + 5, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx - (4 * byVal), yyy + y + takasa, zzz - 5, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx - (4 * byVal), yyy + 9 + takasa, zzz - 5, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx - (4 * byVal), yyy + 4 + takasa, zzz - 5, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 6; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx, yyy + y + takasa, zzz + 5, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx, yyy + 9 + takasa, zzz + 5, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx, yyy + 5 + takasa, zzz + 5, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 6; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx, yyy + y + takasa, zzz - 5, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx, yyy + 9 + takasa, zzz - 5, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx, yyy + 5 + takasa, zzz - 5, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx, yyy + y + takasa, zzz + 9, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx, yyy + 9 + takasa, zzz + 9, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx, yyy + 4 + takasa, zzz + 9, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx, yyy + y + takasa, zzz - 9, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx, yyy + 9 + takasa, zzz - 9, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx, yyy + 4 + takasa, zzz - 9, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + (5 * byVal), yyy + y + takasa, zzz + 9, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + (5 * byVal), yyy + 9 + takasa, zzz + 9, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + (5 * byVal), yyy + 4 + takasa, zzz + 9, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + (5 * byVal), yyy + y + takasa, zzz - 9, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + (5 * byVal), yyy + 9 + takasa, zzz - 9, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + (5 * byVal), yyy + 4 + takasa, zzz - 9, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + (9 * byVal), yyy + y + takasa, zzz + 9, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + (9 * byVal), yyy + 9 + takasa, zzz + 9, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + (9 * byVal), yyy + 4 + takasa, zzz + 9, DQDecorates.DqmBlockHasira, 0, 2);

	        for (int y = 5; y <= 8; ++y)
	        {
	            par3World.setBlock(xxx + (9 * byVal), yyy + y + takasa, zzz - 9, DQDecorates.DqmBlockHasiranaka, 0, 2);
	        }

	        par3World.setBlock(xxx + (9 * byVal), yyy + 9 + takasa, zzz - 9, DQDecorates.DqmBlockHasiraue, 0, 2);
	        par3World.setBlock(xxx + (9 * byVal), yyy + 4 + takasa, zzz - 9, DQDecorates.DqmBlockHasira, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //屋根後ろ
	        for (int z = -9; z <= 9; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 0; x <= 9; ++x)
	            {
	                for (int y = 10; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -8; z <= 8; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= 8; ++x)
	            {
	                for (int y = 11; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -6; z <= 6; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= 7; ++x)
	            {
	                for (int y = 12; y <= 12; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -4; z <= 4; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= 6; ++x)
	            {
	                for (int y = 13; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= 5; ++x)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = 0; z <= 0; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= 3; ++x)
	            {
	                for (int y = 15; y <= 15; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        //屋根後ろ穴
	        for (int z = -8; z <= 8; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 2; x <= 8; ++x)
	            {
	                for (int y = 10; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -6; z <= 6; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 2; x <= 7; ++x)
	            {
	                for (int y = 11; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -4; z <= 4; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 2; x <= 6; ++x)
	            {
	                for (int y = 12; y <= 12; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -2; z <= 2; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 2; x <= 5; ++x)
	            {
	                for (int y = 13; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = 0; z <= 0; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 2; x <= 3; ++x)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        //屋根前
	        for (int z = -5; z <= 5; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -8; x <= -1; ++x)
	            {
	                for (int y = 10; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -4; z <= 4; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -8; x <= 0; ++x)
	            {
	                for (int y = 11; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -3; z <= 3; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -8; x <= 0; ++x)
	            {
	                for (int y = 12; y <= 12; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -7; x <= 0; ++x)
	            {
	                for (int y = 13; y <= 13; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

	        for (int z = 0; z <= 0; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -6; x <= 0; ++x)
	            {
	                for (int y = 14; y <= 14; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.stonebrick, 0, 2);
	                }
	            }
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = -8; x <= -1; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 10 + takasa, zzz + 6, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 10 + takasa, zzz - 6, Blocks.stone_brick_stairs, 2, 2);
	        }

	        for (int x = -6; x <= 0; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 13 + takasa, zzz + 2, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 13 + takasa, zzz - 2, Blocks.stone_brick_stairs, 2, 2);
	        }

	        par3World.setBlock(xxx - (7 * byVal), yyy + 13 + takasa, zzz + 1, Blocks.stone_brick_stairs, 3, 2);
	        par3World.setBlock(xxx - (7 * byVal), yyy + 13 + takasa, zzz - 1, Blocks.stone_brick_stairs, 2, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 13 + takasa, zzz , Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 13 + takasa, zzz + 1, Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 13 + takasa, zzz - 1, Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 12 + takasa, zzz + 3, Blocks.stone_brick_stairs, 3, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 12 + takasa, zzz - 3, Blocks.stone_brick_stairs, 2, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 11 + takasa, zzz + 5, Blocks.stone_brick_stairs, 3, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 11 + takasa, zzz - 5, Blocks.stone_brick_stairs, 2, 2);
	        par3World.setBlock(xxx - (7 * byVal), yyy + 14 + takasa, zzz, Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 12 + takasa, zzz, DQBlocks.DqmBlockKowareru7, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 10 + takasa, zzz + 1, Blocks.air, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 10 + takasa, zzz - 1, Blocks.air, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 10 + takasa, zzz + 3, Blocks.air, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 10 + takasa, zzz - 3, Blocks.air, 0, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 10 + takasa, zzz, Blocks.stone_brick_stairs, metaV3, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 10 + takasa, zzz + 2, Blocks.stone_brick_stairs, metaV3, 2);
	        par3World.setBlock(xxx - (8 * byVal), yyy + 10 + takasa, zzz - 2, Blocks.stone_brick_stairs, metaV3, 2);
	        par3World.setBlock(xxx, yyy + 15 + takasa, zzz, Blocks.stone_brick_stairs, metaV1, 2);
	        par3World.setBlock(xxx + (4 * byVal), yyy + 15 + takasa, zzz, Blocks.stone_brick_stairs, metaV2, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        for (int x = 2; x <= 4; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 15 + takasa, zzz + 1, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 15 + takasa, zzz - 1, Blocks.stone_brick_stairs, 2, 2);
	        }

	        for (int x = -6; x <= 0; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 14 + takasa, zzz + 1, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 14 + takasa, zzz - 1, Blocks.stone_brick_stairs, 2, 2);
	        }

	        for (int z = 6; z <= 10; ++z)
	        {
	            par3World.setBlock(xxx  - (1 * byVal), yyy + 10 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int z = -10; z <= -6; ++z)
	        {
	            par3World.setBlock(xxx - (1 * byVal), yyy + 10 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV1, 2);
	        }

	        for (int x = -1; x <= 10; ++x)
	        {
	            par3World.setBlock(xxx + (x * byVal), yyy + 10 + takasa, zzz + 10, Blocks.stone_brick_stairs, 3, 2);
	            par3World.setBlock(xxx + (x * byVal), yyy + 10 + takasa, zzz - 10, Blocks.stone_brick_stairs, 2, 2);
	        }

	        for (int z = -10; z <= 10; ++z)
	        {
	            par3World.setBlock(xxx + (10 * byVal), yyy + 10 + takasa, zzz + z, Blocks.stone_brick_stairs, metaV2, 2);
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //屋根前穴
	        for (int z = -4; z <= 4; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

	            for (int x = -7; x <= 1; ++x)
	            {
	                for (int y = 10; y <= 10; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -3; z <= 3; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -7; x <= 1; ++x)
	            {
	                for (int y = 11; y <= 11; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        for (int z = -1; z <= 1; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -7; x <= 1; ++x)
	            {
	                for (int y = 12; y <= 12; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        //高台椅子
	        par3World.setBlock(xxx + (6 * byVal), yyy + 9 + takasa, zzz, Blocks.air, 0, 2);
	        par3World.setBlock(xxx + (5 * byVal), yyy + 9 + takasa, zzz, Blocks.air, 0, 2);
	        par3World.setBlock(xxx + (5 * byVal), yyy + 9 + takasa, zzz + 1, Blocks.air, 0, 2);
	        par3World.setBlock(xxx + (5 * byVal), yyy + 9 + takasa, zzz  - 1, Blocks.air, 0, 2);
	        par3World.setBlock(xxx + (7 * byVal), yyy + 10 + takasa, zzz, Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx + (6 * byVal), yyy + 10 + takasa, zzz + 1, Blocks.stone_brick_stairs, 3, 2);
	        par3World.setBlock(xxx + (6 * byVal), yyy + 10 + takasa, zzz - 1, Blocks.stone_brick_stairs, 2, 2);
	        par3World.setBlock(xxx + (5 * byVal), yyy + 9 + takasa, zzz, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (5 * byVal), yyy + 9 + takasa, zzz + 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (5 * byVal), yyy + 9 + takasa, zzz - 1, Blocks.stonebrick, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        /*
	         * NPC設置
	         */
	        DqmEntityNPCSinkan2 entitysilverfish = new DqmEntityNPCSinkan2(par3World);
	        entitysilverfish.setLocationAndAngles(xxx + (6 * byVal) + 0.5F, yyy + 9 + takasa, zzz + 0.5F, 0.0F, 0.0F);
	        par3World.spawnEntityInWorld(entitysilverfish);
	        //裏の隠し扉
	        par3World.setBlock(xxx + (14 * byVal), yyy + 0 + takasa, zzz + (14 * byVal), Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (14 * byVal), yyy + 0 + takasa, zzz + 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (14 * byVal), yyy + 0 + takasa, zzz - 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (13 * byVal), yyy + 1 + takasa, zzz + 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (13 * byVal), yyy + 1 + takasa, zzz - 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 2 + takasa, zzz + 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 2 + takasa, zzz - 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 2 + takasa, zzz + 2, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 2 + takasa, zzz - 2, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 3 + takasa, zzz + 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 3 + takasa, zzz - 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (11 * byVal), yyy + 3 + takasa, zzz + 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (11 * byVal), yyy + 3 + takasa, zzz - 1, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 3 + takasa, zzz, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (11 * byVal), yyy + 3 + takasa, zzz, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (11 * byVal), yyy + 4 + takasa, zzz, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (10 * byVal), yyy + 4 + takasa, zzz, Blocks.stonebrick, 0, 2);
	        par3World.setBlock(xxx + (11 * byVal), yyy + 4 + takasa, zzz + 1, Blocks.stone_brick_stairs, 3, 2);
	        par3World.setBlock(xxx + (11 * byVal), yyy + 4 + takasa, zzz - 1, Blocks.stone_brick_stairs, 2, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 4 + takasa, zzz + 1, Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 4 + takasa, zzz - 1, Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx + (12 * byVal), yyy + 4 + takasa, zzz , Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx + (13 * byVal), yyy + 3 + takasa, zzz, Blocks.stone_brick_stairs, metaV2, 2);
	        par3World.setBlock(xxx + (13 * byVal), yyy + 2 + takasa, zzz + 1, Blocks.stone_brick_stairs, 3, 2);
	        par3World.setBlock(xxx + (13 * byVal), yyy + 2 + takasa, zzz - 1, Blocks.stone_brick_stairs, 2, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        Block block;
	        //block = DQBlocks.DqmBlockKowareruDoor3;
	        //int i0 = MathHelper.floor_double((double)((180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
	        //placeDoorBlock(par3World, xxx, yyy + 1 + takasa, zzz + 13, i0, block);

	        for (int x = 9; x <= 12; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int y = 1; y <= 2; ++y)
	            {
	                par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz, Blocks.air, 0, 2);
	            }
	        }

	        for (int z = -3; z <= 3; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = 1; x <= 8; ++x)
	            {
	                for (int y = 1; y <= 3; ++y)
	                {
	                    par3World.setBlock(xxx + (x * byVal), yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }

	        //par3World.setBlock(xxx, yyy + 1, zzz + 4, Block.chest, 0, 2);
	        //DqmWorldChest.Chest4(rand, xxx, yyy + 1, zzz + 4, par3World);
	        //像
	        par3World.setBlock(xxx - (9 * byVal), yyy + 4 + takasa, zzz + 8, DQDecorates.DqmBlockDaizaS, 0, 2);
	        par3World.setBlock(xxx - (9 * byVal), yyy + 5 + takasa, zzz + 8, DQDecorates.DqmBlockSBoureikensi, 0, 2);
	        par3World.setBlock(xxx - (9 * byVal), yyy + 4 + takasa, zzz - 8, DQDecorates.DqmBlockDaizaS, 0, 2);
	        par3World.setBlock(xxx - (9 * byVal), yyy + 5 + takasa, zzz - 8, DQDecorates.DqmBlockSBoureikensi, 2, 2);
	        par3World.setBlock(xxx - (3 * byVal), yyy + 4 + takasa, zzz + 7, DQDecorates.DqmBlockDaizaS, 0, 2);
	        par3World.setBlock(xxx - (3 * byVal), yyy + 5 + takasa, zzz + 7, DQDecorates.DqmBlockSBoureikensi, 0, 2);
	        par3World.setBlock(xxx - (3 * byVal), yyy + 4 + takasa, zzz - 7, DQDecorates.DqmBlockDaizaS, 0, 2);
	        par3World.setBlock(xxx - (3 * byVal), yyy + 5 + takasa, zzz - 7, DQDecorates.DqmBlockSBoureikensi, 2, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
        }





	}
}
