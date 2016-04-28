package dqr.thread;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import dqr.DQR;
import dqr.playerData.ExtendedPlayerProperties2;

public class ThreadMGFarmHarvest extends Thread{

	private ItemStack par1;
	private EntityPlayer ep;
	private World par3;
	private int par4;
	private int par5;
	private int par6;

	private int par7;

	private float par8;
	private float par9;
	private float par10;

	public ThreadMGFarmHarvest(ItemStack par1ItemStack, EntityPlayer ep, World par3World, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{

		this.par1 = par1ItemStack;
		this.ep = ep;
		this.par3 = par3World;
		this.par4 = p_77648_4_;
		this.par5 = p_77648_5_;
		this.par6 = p_77648_6_;
		this.par7 = p_77648_7_;
		this.par8 = p_77648_8_;
		this.par9 = p_77648_9_;
		this.par10 = p_77648_10_;
	}

	public void run()
	{

		int mode = ExtendedPlayerProperties2.get(this.ep).getTool1mode();
		int area = ExtendedPlayerProperties2.get(this.ep).getToolArea();

		int areaX = DQR.conf.MGFarm_Area_X[area];
		int areaY = DQR.conf.MGFarm_Area_Y[area];
		int areaZ = DQR.conf.MGFarm_Area_Z[area];

		int itemDam = areaX * areaY * areaZ * 10;

		int fixY = par7 == 1? 1 : 0;
		if(par7 == 1 &&
				(par3.isAirBlock(this.par4 + 1, this.par5 + fixY, this.par6) &&
				 par3.isAirBlock(this.par4 - 1, this.par5 + fixY, this.par6) &&
				 par3.isAirBlock(this.par4, this.par5 + fixY, this.par6 + 1) &&
				 par3.isAirBlock(this.par4, this.par5 + fixY, this.par6 - 1)))
			{
				fixY = 0;
			}
		//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
		//System.out.println("test2:" + (areaZ - 1) / 2 * -1 + "/" + (areaZ - 1) / 2);

		//System.out.println("test:" + areaX + "/" + areaY + "/" + areaZ);
		Item hoe = Items.diamond_hoe;

		int l = MathHelper.floor_double((double)(ep.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		//System.out.println("DEBUG" + l);


		if(l == 1)
		{
			//System.out.println("DEBUG;" + areaZ + "/" + areaX);
			for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
			{
				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
				{
					for(int cntZ = 0; (areaZ - 1) * -1 <= cntZ; cntZ--)
					{
						Block targetBlock = par3.getBlock(this.par4 + cntZ, this.par5+ cntY + fixY, this.par6 + cntX);

						if(targetBlock instanceof IPlantable || targetBlock instanceof BlockBush)
						{
							par3.func_147480_a(this.par4 + cntZ, this.par5+ cntY + fixY, this.par6 + cntX, true);
						}
					}
				}
			}
		}else if(l == 2)
		{
			for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
			{
				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
				{
					for(int cntZ = 0; (areaZ - 1) * -1 <= cntZ; cntZ--)
					{
						Block targetBlock = par3.getBlock(this.par4 + cntX, this.par5+ cntY + fixY, this.par6 + cntZ);

						if(targetBlock instanceof IPlantable || targetBlock instanceof BlockBush)
						{
							par3.func_147480_a(this.par4 + cntX, this.par5+ cntY + fixY, this.par6 + cntZ, true);
						}
					}
				}
			}
		}else if(l == 3)
		{
			//System.out.println("DEBUG;" + areaZ + "/" + areaX);
			for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
			{
				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
				{
					for(int cntZ = 0; (areaZ - 1) >= cntZ; cntZ++)
					{
						Block targetBlock = par3.getBlock(this.par4 + cntZ, this.par5+ cntY + fixY, this.par6 + cntX);

						if(targetBlock instanceof IPlantable || targetBlock instanceof BlockBush)
						{
							par3.func_147480_a(this.par4 + cntZ, this.par5+ cntY + fixY, this.par6 + cntX, true);
						}
					}
				}
			}
		}else
		{
			for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
			{
				for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
				{
					for(int cntZ = 0; (areaZ - 1) >= cntZ; cntZ++)
					{
						Block targetBlock = par3.getBlock(this.par4 + cntX, this.par5+ cntY + fixY, this.par6 + cntZ);

						if(targetBlock instanceof IPlantable || targetBlock instanceof BlockBush)
						{
							par3.func_147480_a(this.par4 + cntX, this.par5+ cntY + fixY, this.par6 + cntZ, true);
						}
					}
				}
			}
		}


		/*
		for(int cntY = (areaY - 1) / 2 * -1; (areaY - 1) / 2 >= cntY; cntY++)
		{
			for(int cntX = (areaX - 1) / 2 * -1; (areaX - 1) / 2 >= cntX; cntX++)
			{
				for(int cntZ = (areaZ - 1) / 2 * -1; (areaZ - 1) / 2 >= cntZ; cntZ++)
				{
					hoe.onItemUse(new ItemStack(Items.diamond_hoe, 1), ep, this.par3,
								  this.par4 + cntX, this.par5+ cntY + fixY, this.par6 + cntZ, this.par7,
								  this.par8 + cntX, this.par9 + cntY, this.par10 + cntZ);
				}
			}
		}
		*/

	}

}
