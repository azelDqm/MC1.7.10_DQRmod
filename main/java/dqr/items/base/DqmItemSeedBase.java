package dqr.items.base;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import dqr.DQR;

public class DqmItemSeedBase extends ItemSeeds{

	private Block field_150925_a;
	private Block soilBlockID;

	public DqmItemSeedBase(Block p_i45352_1_, Block p_i45352_2_) {
		super(p_i45352_1_, p_i45352_2_);
		soilBlockID = p_i45352_2_;
		this.field_150925_a = p_i45352_1_;
		// TODO 自動生成されたコンストラクター・スタブ
	}

    @Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	//System.out.println("DEBUGLINE:" + par3World.getBlockMetadata(par4, par5, par6));
        if (!ep.isSneaking())
        {
            if (par7 != 1)
            {
                return false;
            }
            else if (ep.canPlayerEdit(par4, par5, par6, par7, par1ItemStack) && ep.canPlayerEdit(par4, par5 + 1, par6, par7, par1ItemStack))
            {
                Block soil = par3World.getBlock(par4, par5, par6);
                //Block soil = Block.blocksList[i1];

                if (soil != null && (soil.canSustainPlant(par3World, par4, par5, par6, ForgeDirection.UP, this) || DQR.growth.canPlantingBlock(soil)) && par3World.isAirBlock(par4, par5 + 1, par6))
                {
                    par3World.setBlock(par4, par5 + 1, par6, this.field_150925_a);
                    --par1ItemStack.stackSize;
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                return false;
            }
        }

        return false;
    }
}
