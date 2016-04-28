package dqr.items.miscs;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.BonemealEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.blocks.base.DqmBlockSeedBase;
import dqr.items.base.DqmItemMiscBase;

public class DqmItemDyeWhite2 extends DqmItemMiscBase{

	public DqmItemDyeWhite2()
	{
		super();
	}

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
        {
            return false;
        }
        else
        {
			if(applyBonemeal(p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_))
			{
			    if (!p_77648_3_.isRemote)
			    {
			        p_77648_3_.playAuxSFX(2005, p_77648_4_, p_77648_5_, p_77648_6_, 0);
			    }

			    return true;
			}

            if (applyBonemeal2(p_77648_1_, p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_))
            {
                if (!p_77648_3_.isRemote)
                {
                    p_77648_3_.playAuxSFX(2005, p_77648_4_, p_77648_5_, p_77648_6_, 0);
                }

                return true;
            }
        }

        return false;
    }

    public static boolean applyBonemeal(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_, EntityPlayer player)
    {
    	Random rand = new Random();

        Block block = p_150919_1_.getBlock(p_150919_2_, p_150919_3_, p_150919_4_);
        int meta = p_150919_1_.getBlockMetadata(p_150919_2_, p_150919_3_, p_150919_4_);

        BonemealEvent event = new BonemealEvent(player, p_150919_1_, block, p_150919_2_, p_150919_3_, p_150919_4_);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            if (!p_150919_1_.isRemote)
            {
                p_150919_0_.stackSize--;
            }
            return true;
        }

        if (block instanceof DqmBlockSeedBase)
        {
        	if(meta < 7)
        	{
	        	DqmBlockSeedBase igrowable = (DqmBlockSeedBase)block;

	            if (!p_150919_1_.isRemote)
	            {
	            	if(rand.nextInt(4) == 0)
	            	{
	            		igrowable.fertilize(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_);
	            	}
	        		--p_150919_0_.stackSize;
	                return true;
	            }
        	}
        }

        return false;
    }

    public static boolean applyBonemeal2(ItemStack p_150919_0_, World p_150919_1_, int p_150919_2_, int p_150919_3_, int p_150919_4_, EntityPlayer player)
    {
        Block block = p_150919_1_.getBlock(p_150919_2_, p_150919_3_, p_150919_4_);

        BonemealEvent event = new BonemealEvent(player, p_150919_1_, block, p_150919_2_, p_150919_3_, p_150919_4_);
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return false;
        }

        if (event.getResult() == Result.ALLOW)
        {
            if (!p_150919_1_.isRemote)
            {
                p_150919_0_.stackSize--;
            }
            return true;
        }

        if (block instanceof IGrowable)
        {
            IGrowable igrowable = (IGrowable)block;

            if (igrowable.func_149851_a(p_150919_1_, p_150919_2_, p_150919_3_, p_150919_4_, p_150919_1_.isRemote))
            {
                if (!p_150919_1_.isRemote)
                {
                    if (igrowable.func_149852_a(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_))
                    {
                        igrowable.func_149853_b(p_150919_1_, p_150919_1_.rand, p_150919_2_, p_150919_3_, p_150919_4_);
                    }

                    --p_150919_0_.stackSize;
                }

                return true;
            }
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack p_77636_1_)
    {
        return true;
    }
}
