package dqr.blocks.standard;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.api.Blocks.DQBlocks;
import dqr.blocks.base.DqmBlockSeedBase;

public class DqmGenkotuBlock extends DqmBlockSeedBase
{
    //クラス本体。Blockクラスを継承する

    public DqmGenkotuBlock() //ブロックの基本設定
    {
        super(true); //材質を土に
        this.setStepSound(soundTypeGrass);
    }

    private static int getRandom(int max, int min)
    {
        int ret = (int)Math.floor(Math.random() * (max - min + 1)) + min;
        return ret;
    }
    /*
    public int idDropped(int i, int j,Random random)
    {
        int x = 0;
    	int x3 = x+getRandom(100, -100);

    	if(x3==0){j=mod_Dqm.Littlemedal.shiftedIndex;}
    	if(x3>=1){j=mod_Dqm.Yakusou.shiftedIndex;}
    	if(x3<=-1){j=mod_Dqm.Dokukesisou.shiftedIndex;}
    	//if(x3==0){i=mod_Dqm.Littlemedal.shiftedIndex;}
    	//if(x3==0){i=mod_Dqm.Littlemedal.shiftedIndex;}
    	//if(x3==0){i=mod_Dqm.Littlemedal.shiftedIndex;}

      return wood.blockID;
    }*/
    @Override
    public int getRenderType()
    {
        return 1;
    }

    @Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
    	return new ItemStack(DQBlocks.DqmBlockGenkotu, 1).getItem();
    }
    @Override
    public int quantityDropped(Random random)
    {
        return 1; //idDropedでドロップする数を設定
    }

    @Override
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        Block soil = par1World.getBlock(par2, par3 - 1, par4);
        return (soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this));
    }

    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        boolean sB;
        sB = setNewPlant(par1World, par2, par3, par4, par5Random);
    }

    public boolean setNewPlant(World world, int x, int y, int z, Random  randN)
    {
        int lightValue;

        for (int i = -1; i <= 1; i++)
        {
            for (int k = -1; k <= 1; k++)
            {
                if (world.isAirBlock(x + i, y , z + k))
                {
                    if (world.isAirBlock(x + i, y , z + k))
                    {
                        if (world.getBlock(x + i, y - 1 , z + k) == Blocks.dirt)
                        {
                            //lightValue = getBlockLightValue(world, x + i, y ,z + k);
                            lightValue = world.getBlockLightValue(x + i, y , z + k);

                            //Chunk chunk = world.getChunkFromChunkCoords( x+i >> 4, z+k >> 4);
                            if (lightValue >= 1 && lightValue <= 6 && randN.nextInt(32) == 1)
                            {
                                world.setBlock(x + i, y, z + k, this);
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(this.getTextureName());
    }
}
