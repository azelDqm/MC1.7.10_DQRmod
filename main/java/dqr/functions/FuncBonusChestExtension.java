package dqr.functions;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGeneratorBonusChest;
import dqr.DQR;
import dqr.api.Items.DQSeeds;

public class FuncBonusChestExtension {

	public FuncBonusChestExtension()
	{

	}

	public Boolean hookGenerate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_, WorldGeneratorBonusChest par1, WeightedRandomChestContent[] par2, int par3)
	{

		if(DQR.conf.bonusChestEnable == 1)
		{
	        Block block;

	        do
	        {
	            block = p_76484_1_.getBlock(p_76484_3_, p_76484_4_, p_76484_5_);
	            if (!block.isAir(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_) && !block.isLeaves(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_)) break;
	            p_76484_4_--;
	        } while (p_76484_4_ > 1);

	        if (p_76484_4_ < 1)
	        {
	        	return Boolean.FALSE;
	        }
	        else
	        {
	            ++p_76484_4_;

	            for (int l = 0; l < 4; ++l)
	            {
	                int i1 = p_76484_3_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
	                int j1 = p_76484_4_ + p_76484_2_.nextInt(3) - p_76484_2_.nextInt(3);
	                int k1 = p_76484_5_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);

	                if (p_76484_1_.isAirBlock(i1, j1, k1) && World.doesBlockHaveSolidTopSurface(p_76484_1_, i1, j1 - 1, k1))
	                {
	                    p_76484_1_.setBlock(i1, j1, k1, Blocks.chest, 0, 2);
	                    TileEntityChest tileentitychest = (TileEntityChest)p_76484_1_.getTileEntity(i1, j1, k1);

	                    if (tileentitychest != null && tileentitychest != null)
	                    {
	                        WeightedRandomChestContent.generateChestContents(p_76484_2_, par2, tileentitychest, par3);
	                        tileentitychest.setInventorySlotContents(6, new ItemStack(Blocks.cobblestone, 1));
	                        tileentitychest.setInventorySlotContents(7, new ItemStack(Blocks.cobblestone, 1));
	                        tileentitychest.setInventorySlotContents(8, new ItemStack(Blocks.cobblestone, 1));
	                        tileentitychest.setInventorySlotContents(15, new ItemStack(Items.stick, 1));
	                        tileentitychest.setInventorySlotContents(16, new ItemStack(Blocks.cobblestone, 1));
	                        tileentitychest.setInventorySlotContents(17, new ItemStack(Items.stick, 1));
	                        tileentitychest.setInventorySlotContents(24, new ItemStack(Blocks.stone_slab, 1));
	                        tileentitychest.setInventorySlotContents(25, new ItemStack(Blocks.stone_slab, 1));
	                        tileentitychest.setInventorySlotContents(26, new ItemStack(Blocks.stone_slab, 1));
	                        tileentitychest.setInventorySlotContents(5, new ItemStack(DQSeeds.itemYakusou, 10));
	                    }

	                    if (p_76484_1_.isAirBlock(i1 - 1, j1, k1) && World.doesBlockHaveSolidTopSurface(p_76484_1_, i1 - 1, j1 - 1, k1))
	                    {
	                        p_76484_1_.setBlock(i1 - 1, j1, k1, Blocks.torch, 0, 2);
	                    }

	                    if (p_76484_1_.isAirBlock(i1 + 1, j1, k1) && World.doesBlockHaveSolidTopSurface(p_76484_1_, i1 - 1, j1 - 1, k1))
	                    {
	                        p_76484_1_.setBlock(i1 + 1, j1, k1, Blocks.torch, 0, 2);
	                    }

	                    if (p_76484_1_.isAirBlock(i1, j1, k1 - 1) && World.doesBlockHaveSolidTopSurface(p_76484_1_, i1 - 1, j1 - 1, k1))
	                    {
	                        p_76484_1_.setBlock(i1, j1, k1 - 1, Blocks.torch, 0, 2);
	                    }

	                    if (p_76484_1_.isAirBlock(i1, j1, k1 + 1) && World.doesBlockHaveSolidTopSurface(p_76484_1_, i1 - 1, j1 - 1, k1))
	                    {
	                        p_76484_1_.setBlock(i1, j1, k1 + 1, Blocks.torch, 0, 2);
	                    }

	                    return Boolean.TRUE;
	                }
	            }

	            return Boolean.FALSE;
	        }
		}else
		{
			return null;
		}
	}
}
