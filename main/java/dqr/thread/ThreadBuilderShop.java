package dqr.thread;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Blocks.DQBlocks;
import dqr.api.Blocks.DQDecorates;
import dqr.api.Items.DQBuilders;
import dqr.entity.npcEntity.npc.DqmEntityNPCBank;
import dqr.entity.npcEntity.npc.DqmEntityNPCBukiya;
import dqr.entity.npcEntity.npc.DqmEntityNPCKaitoriya;
import dqr.entity.npcEntity.npc.DqmEntityNPCSyuuri;

public class ThreadBuilderShop extends Thread{

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

	public ThreadBuilderShop(World par1, int size, int height, int under, ItemStack ist)
	{
		this.par3World = par1;
    	this.size = size;
    	this.height = height;
    	this.under = under;
    	this.ist = ist;
	}

	public void run()
	{

		NBTTagCompound nbt = this.ist.getTagCompound();

		EntityTameable npc = null;
		Block kanban = null;

		this.xxx = nbt.getInteger("settingX");
		this.zzz = nbt.getInteger("settingZ");
		this.yMain = nbt.getInteger("settingY");
		this.Hougaku = nbt.getInteger("settingFace");
        switch(this.Hougaku)
        {
        	case 1: xxx = xxx - 4; break;
        	case 2: zzz = zzz - 4; break;
        	case 3: xxx = xxx + 4; break;
        	case 0: zzz = zzz + 4; break;
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

			for (int x = -6; x <= 6; ++x)
	        {
	            for (int z = -6; z <= 6; ++z)
	            {
	                for (int y = -1; y <= 6 ; ++y)
	                {
	                	if(par3World.getBlock(xxx + x, yyy + y + takasa, zzz + z) == DQBlocks.DqmBlockBuilderFrame)
	    	        		par3World.setBlock(xxx + x, yyy + y + takasa, zzz + z, Blocks.air, 0, 2);
	                }
	            }
	        }
		}



        //土
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
			for (int x = -5; x <= 5; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -5; z <= 5; ++z)
	            {
	                for (int y = -1; y <= -1 ; ++y)
	                {
	                	par3World.setBlock(xxx + x, yyy + y + takasa, zzz + z, topBlock, 0, 2);
	                }
	            }
	        }
		}


        int byVal = 1;
        int metaV1 = 0;
        int metaV2 = 6;
        int metaV3 = 6;
        //壁
        System.out.println("TEST" + this.Hougaku);

        if(ist != null)
        {
        	if(ist.getItem() == DQBuilders.itemBuilderShopBank)
        	{
        		npc = new DqmEntityNPCBank(par3World);
        		kanban = DQDecorates.DqmBlockBank;
        	}else if(ist.getItem() == DQBuilders.itemBuilderShopBukiya)
        	{
        		npc = new DqmEntityNPCBukiya(par3World);
        		kanban = DQDecorates.DqmBlockBukiya;
        	}else if(ist.getItem() == DQBuilders.itemBuilderShopKaitoriya)
        	{
        		npc = new DqmEntityNPCKaitoriya(par3World);
        		kanban = DQDecorates.DqmBlockDouguya;
        	}else if(ist.getItem() == DQBuilders.itemBuilderShopSyuuriya)
        	{
        		npc = new DqmEntityNPCSyuuri(par3World);
        		kanban = DQDecorates.DqmBlockSyuuriya;
        	}
        }

        if(this.Hougaku == 0 || this.Hougaku == 2)
        {
        	if(this.Hougaku == 2){
        		byVal = -1;
        		metaV1 = 2;
        		metaV2 = 7;
        	}


	        for (int x = -3; x <= 3; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int z = -4; z <= 4; ++z)
	            {
	                for (int y = -1; y <= 5; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * 1), Blocks.stonebrick, 0, 2);
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
	            for (int z = -3; z <= 3; ++z)
	            {
	                for (int y = -1; y <= -1; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * 1), Blocks.brick_block, 0, 2);
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
	            for (int z = -3; z <= 3; ++z)
	            {
	                for (int y = 0; y <= 5; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * 1), Blocks.air, 0, 2);
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
	            for (int z = -4; z <= 4; ++z)
	            {
	                par3World.setBlock(xxx + x, yyy + 5 + takasa, zzz + (z * 1), Blocks.stone_slab, 0, 2);
	            }
	        }

	        par3World.setBlock(xxx - 3, yyy + 2 + takasa, zzz - 1, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 2 + takasa, zzz - 2, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 2 + takasa, zzz  + 1, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx - 3, yyy + 2 + takasa, zzz + 2, Blocks.glass_pane, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        par3World.setBlock(xxx + 3, yyy + 2 + takasa, zzz - 1, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 2 + takasa, zzz - 2, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 2 + takasa, zzz  + 1, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx + 3, yyy + 2 + takasa, zzz + 2, Blocks.glass_pane, 0, 2);

	        par3World.setBlock(xxx, yyy + takasa, zzz - (4 * byVal), Blocks.air, 0, 2);
	        par3World.setBlock(xxx, yyy + 1 + takasa, zzz - (4 * byVal), Blocks.air, 0, 2);

	        par3World.setBlock(xxx - 2, yyy + 1 + takasa, zzz - (5 * byVal), kanban, metaV1, 2);
	        par3World.setBlock(xxx + 2, yyy + 1 + takasa, zzz - (5 * byVal), kanban, metaV1, 2);

	        for (int x = -2; x <= 2; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				par3World.setBlock(xxx + x, yyy + takasa, zzz, Blocks.oak_stairs, metaV2, 2);
	        }

	        par3World.setBlock(xxx + 2, yyy + 0 + takasa, zzz - (1 * byVal), DQDecorates.DqmBlockTaimatu2, metaV1, 2);
	        par3World.setBlock(xxx + 1, yyy + 0 + takasa, zzz - (1 * byVal), DQDecorates.DqmBlockIsu, metaV1, 2);
	        par3World.setBlock(xxx - 1, yyy + 0 + takasa, zzz - (1 * byVal), DQDecorates.DqmBlockIsu, metaV1, 2);
	        par3World.setBlock(xxx - 2, yyy + 0 + takasa, zzz - (1 * byVal), DQDecorates.DqmBlockTaimatu2, metaV1, 2);
			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        //par3World.setBlock(xxx - (1 * byVal), yyy + 2 + takasa, zzz, DQDecorates.DqmBlockTaimatu2, metaV1, 2);
	        par3World.setBlock(xxx, yyy + takasa, zzz + (3 * byVal), DQDecorates.DqmBlockHondana, this.Hougaku, 2);

	        par3World.setBlock(xxx + (2 * byVal), yyy + takasa, zzz + (3 * byVal), DQDecorates.DqmBlockTaru, 0, 2);
	        par3World.setBlock(xxx + (-2 * byVal), yyy + takasa, zzz + (3 * byVal), DQDecorates.DqmBlockTubo2, 0, 2);
	        par3World.setBlock(xxx + (-2 * byVal), yyy + takasa, zzz + (2 * byVal), DQDecorates.DqmBlockTubo2, 0, 2);
	        par3World.setBlock(xxx + (-2 * byVal), yyy + takasa, zzz + (1 * byVal), DQDecorates.DqmBlockMaki, 1, 2);

	        par3World.setBlock(xxx + (-1 * byVal), yyy + 1 + takasa, zzz, DQDecorates.DqmBlockHepaitosu, 0, 2);

	        //par3World.setBlock(xxx, yyy + takasa, zzz + (1 * byVal), DQDecorates.DqmBlockMaki, 1, 2);
	        if(npc != null)
	        {
	        	npc.setLocationAndAngles((double)xxx + 0.5D, (double)yyy + takasa, (double)zzz + 0.5D + (1 * byVal), 0.0F, 0.0F);
	        	par3World.spawnEntityInWorld(npc);
	        }
        }if(this.Hougaku == 1 || this.Hougaku == 3)
        {
        	if(this.Hougaku == 1){
        		byVal = -1;
        		metaV1 = 1;
        		metaV2 = 5;
        		metaV3 = 1;
        	}else
        	{
        		byVal = 1;
        		metaV1 = 3;
        		metaV2 = 4;
        		metaV3 = 3;
        	}


	        for (int z = -3; z <= 3; ++z)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	            for (int x = -4; x <= 4; ++x)
	            {
	                for (int y = -1; y <= 5; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * 1), Blocks.stonebrick, 0, 2);
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
	            for (int x = -3; x <= 3; ++x)
	            {
	                for (int y = -1; y <= -1; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * 1), Blocks.brick_block, 0, 2);
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
	            for (int x = -3; x <= 3; ++x)
	            {
	                for (int y = 0; y <= 5; ++y)
	                {
	                    par3World.setBlock(xxx + x, yyy + y + takasa, zzz + (z * 1), Blocks.air, 0, 2);
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
	            for (int x = -4; x <= 4; ++x)
	            {
	                par3World.setBlock(xxx + x, yyy + 5 + takasa, zzz + (z * 1), Blocks.stone_slab, 0, 2);
	            }
	        }

	        par3World.setBlock(xxx - 1, yyy + 2 + takasa, zzz - 3, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx - 2, yyy + 2 + takasa, zzz - 3, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 2 + takasa, zzz  - 3, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx + 2, yyy + 2 + takasa, zzz - 3, Blocks.glass_pane, 0, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

	        par3World.setBlock(xxx - 1, yyy + 2 + takasa, zzz + 3, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx - 2, yyy + 2 + takasa, zzz + 3, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx + 1, yyy + 2 + takasa, zzz + 3, Blocks.glass_pane, 0, 2);
	        par3World.setBlock(xxx + 2, yyy + 2 + takasa, zzz + 3, Blocks.glass_pane, 0, 2);

	        par3World.setBlock(xxx - (4 * byVal), yyy + takasa, zzz, Blocks.air, 0, 2);
	        par3World.setBlock(xxx - (4 * byVal), yyy + 1 + takasa, zzz, Blocks.air, 0, 2);

	        par3World.setBlock(xxx - (5 * byVal), yyy + 1 + takasa, zzz + 2, kanban, metaV1, 2);
	        par3World.setBlock(xxx - (5 * byVal), yyy + 1 + takasa, zzz - 2, kanban, metaV1, 2);

	        for (int x = -2; x <= 2; ++x)
	        {
				try {
					this.sleep(DQR.conf.cfg_build_sleep);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				par3World.setBlock(xxx, yyy + takasa, zzz + x, Blocks.oak_stairs, metaV2, 2);
	        }

	        /*
	        par3World.setBlock(xxx + 2, yyy + 0 + takasa, zzz - (1 * byVal), DQDecorates.DqmBlockTaimatu2, metaV1, 2);
	        par3World.setBlock(xxx + 1, yyy + 0 + takasa, zzz - (1 * byVal), DQDecorates.DqmBlockIsu, metaV1, 2);
	        par3World.setBlock(xxx - 1, yyy + 0 + takasa, zzz - (1 * byVal), DQDecorates.DqmBlockIsu, metaV1, 2);
	        par3World.setBlock(xxx - 2, yyy + 0 + takasa, zzz - (1 * byVal), DQDecorates.DqmBlockTaimatu2, metaV1, 2);
	        */
	        par3World.setBlock(xxx - (1 * byVal), yyy + 0 + takasa, zzz + 2, DQDecorates.DqmBlockTaimatu2, metaV1, 2);
	        par3World.setBlock(xxx - (1 * byVal), yyy + 0 + takasa, zzz + 1, DQDecorates.DqmBlockIsu, metaV1, 2);
	        par3World.setBlock(xxx - (1 * byVal), yyy + 0 + takasa, zzz - 1, DQDecorates.DqmBlockIsu, metaV1, 2);
	        par3World.setBlock(xxx - (1 * byVal), yyy + 0 + takasa, zzz - 2, DQDecorates.DqmBlockTaimatu2, metaV1, 2);

			try {
				this.sleep(DQR.conf.cfg_build_sleep);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	        //par3World.setBlock(xxx - (1 * byVal), yyy + 2 + takasa, zzz, DQDecorates.DqmBlockTaimatu2, metaV1, 2);


			/*
	        par3World.setBlock(xxx, yyy + takasa, zzz + (3 * byVal), DQDecorates.DqmBlockHondana, this.Hougaku, 2);

	        par3World.setBlock(xxx + (2 * byVal), yyy + takasa, zzz + (3 * byVal), DQDecorates.DqmBlockTaru, 0, 2);
	        par3World.setBlock(xxx + (-2 * byVal), yyy + takasa, zzz + (3 * byVal), DQDecorates.DqmBlockTubo2, 0, 2);
	        par3World.setBlock(xxx + (-2 * byVal), yyy + takasa, zzz + (2 * byVal), DQDecorates.DqmBlockTubo2, 0, 2);
	        par3World.setBlock(xxx + (-2 * byVal), yyy + takasa, zzz + (1 * byVal), DQDecorates.DqmBlockMaki, 1, 2);

	        par3World.setBlock(xxx + (-1 * byVal), yyy + 1 + takasa, zzz, DQDecorates.DqmBlockHepaitosu, 0, 2);
	        */
	        par3World.setBlock(xxx + (3 * byVal), yyy + takasa, zzz, DQDecorates.DqmBlockHondana, metaV3, 2);

	        par3World.setBlock(xxx + (3 * byVal), yyy + takasa, zzz + (-2 * byVal), DQDecorates.DqmBlockTaru, 0, 2);
	        par3World.setBlock(xxx + (3 * byVal), yyy + takasa, zzz + (2 * byVal), DQDecorates.DqmBlockTubo2, 0, 2);
	        par3World.setBlock(xxx + (2 * byVal), yyy + takasa, zzz + (2 * byVal), DQDecorates.DqmBlockTubo2, 0, 2);
	        par3World.setBlock(xxx + (1 * byVal), yyy + takasa, zzz + (2 * byVal), DQDecorates.DqmBlockMaki, 2, 2);

	        par3World.setBlock(xxx, yyy + 1 + takasa, zzz + (-1 * byVal), DQDecorates.DqmBlockHepaitosu, 0, 2);

	        if(npc != null)
	        {
	        	npc.setLocationAndAngles((double)xxx+ (1 * byVal) + 0.5D, (double)yyy + takasa, (double)zzz + 0.5D, 0.0F, 0.0F);
	        	par3World.spawnEntityInWorld(npc);
	        }
        }



	}
}
