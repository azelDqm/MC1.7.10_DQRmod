package dqr.functions;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import dqr.DQR;

public class FuncCommon {

	public FuncCommon(){}

	public int xRandom(int min, int max)
	{
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

	public boolean equalBlockArray(Block[] par1, Block[] par2)
	{
		if(par1.length != par2.length)
		{
			return false;
		}

		for(int cnt = 0; cnt < par1.length; cnt++)
		{
			if(par1[cnt] != par2[cnt])
			{
				return false;
			}
		}

		return true;
	}

	public boolean equalIntArray(int[] par1, int[] par2)
	{
		if(par1.length != par2.length)
		{
			return false;
		}

		for(int cnt = 0; cnt < par1.length; cnt++)
		{
			if(par1[cnt] != par2[cnt])
			{
				return false;
			}
		}

		return true;
	}

	public void debugString(String par1)
	{
		if(DQR.debug != 0)
		{
			System.out.println(par1);
		}
	}

	public void debugString(String par1, Class par2)
	{
		if(DQR.debug != 0)
		{
			System.out.println(par2.getName() + "/" + par1);
		}
	}

	/**
	 *  @param world
	 *  @param PosX
	 *  @param PosZ
	 *  @param startY
	 *  @param endY
	 */
	public int getHeightValue2(World world, int par1, int par2, int par3, int par4)
	{
		int retY = -1;
		int mem = -1;


		if(par3 < par4)
		{
			//System.out.println("loop1");
			for(int cnt = par3; cnt <= par4; cnt++)
			{
				if(mem == -1)
				{
					if(world.getBlock(par1, cnt, par2) != Blocks.air)
					{
						mem = 0;
					}
				}else
				{
					if(world.getBlock(par1, cnt, par2) == Blocks.air)
					{
						if(retY == -1)
						{
							retY = cnt;
							mem = 1;
						}else
						{
							return retY;
						}
					}else
					{
						mem = -1;
						retY = -1;
					}
				}
			}
		}else
		{
			//System.out.println("loop2");
			for(int cnt = par3; cnt >= par4; cnt--)
			{
				if(mem == -1)
				{
					//System.out.println("test" + cnt);
					if(world.getBlock(par1, cnt, par2) == Blocks.air)
					{
						mem = 0;
					}
				}else
				{
					if(world.getBlock(par1, cnt, par2) == Blocks.air)
					{
						//System.out.println("test" + cnt);
						mem = 1;
					}else
					{
						if(mem == 1)
						{
							return cnt + 1;
						}else
						{
							mem = -1;
						}
					}
				}
			}
		}


		return -1;
	}
}
