package dqr.blocks.base;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.api.Blocks.DQOres;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMiscs;

public class DqmBlockOreBase extends BlockOre {

	public DqmBlockOreBase(){
		super();
	}

	@Override
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
		if(this == DQOres.BlockOreBakudanisi)
		{
			return DQIngots.itemBakudanisi;
		}else if(this == DQOres.BlockOreHosinokakera)
		{
			return DQIngots.itemHosinokakera;
		}else if(this == DQOres.BlockOreMigakizuna)
		{
			return DQIngots.itemMigakizuna;
		}else if(this == DQOres.BlockOreLittlemedal)
		{
			return DQMiscs.itemLittlemedal;
		}else
		{
			return Item.getItemFromBlock(this);
		}
    }

    public int quantityDropped(int meta, int fortune, Random random)
    {

		if(this == DQOres.BlockOreBakudanisi)
		{
			//return random.nextInt(2) + 1;
			if(fortune > 0)
			{
				return random.nextInt(2) + 1 + random.nextInt(fortune);
			}else
			{
				return random.nextInt(2) + 1;
			}
		}else if(this == DQOres.BlockOreHosinokakera)
		{
			//return random.nextInt(3) + 1;
			if(fortune > 0)
			{
				return random.nextInt(3) + 1 + random.nextInt(fortune);
			}else
			{
				return random.nextInt(3) + 1;
			}
		}else if(this == DQOres.BlockOreMigakizuna)
		{
			//return random.nextInt(4) + 1;
			if(fortune > 0)
			{
				return random.nextInt(4) + 1 + random.nextInt(fortune);
			}else
			{
				return random.nextInt(4) + 1;
			}
		}else if(this == DQOres.BlockOreLittlemedal)
		{
			if(fortune > 0)
			{
				return 2 + random.nextInt(fortune + ((fortune + 1) / 2));
			}else
			{
				return 2;
			}
		}else
		{
			return 1;
		}
        //return quantityDroppedWithBonus(fortune, random);
    }
    /*
	@Override
    public int quantityDropped(Random p_149745_1_)
    {
		Random rand = new Random();

		if(this == DQOres.BlockOreBakudanisi)
		{
			return rand.nextInt(2) + 1;
		}else if(this == DQOres.BlockOreHosinokakera)
		{
			return rand.nextInt(3) + 1;
		}else if(this == DQOres.BlockOreMigakizuna)
		{
			return rand.nextInt(4) + 1;
		}else if(this == DQOres.BlockOreLittlemedal)
		{
			return 0;
		}else
		{
			return 1;
		}
    }
	*/
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return Blocks.stone.getBlockTextureFromSide(0);
    }

	public IIcon getTexture()
	{
		return this.blockIcon;
	}

	public int getRenderType()
	{
		return DQR.blockRenderType.renderOreBlockID;
	}

}
