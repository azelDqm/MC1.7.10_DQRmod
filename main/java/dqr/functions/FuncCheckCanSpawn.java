package dqr.functions;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.entity.mobEntity.DqmMobBase;

public class FuncCheckCanSpawn {

	public FuncCheckCanSpawn(){}


    public boolean checkCanSpawnField(World world, int par1, int par2, int par3, AxisAlignedBB boundingBox, DqmMobBase mob)
    {
    	//boolean retResult;
    	Block targetBid;
    	int piraCnt;


    	Block getBid = world.getBlock(par1, par2 - 1, par3);

    	/*
    	if (getBid == 2 || getBid == 3 || getBid == 12 || getBid == 78)
    	{
    		if ((DayNight == "night" || DayNight == "nighbtM") && world.isDaytime())
        	{
        		return false;
        	}
    	}
    	*/

    	/*
    	if(getBid != 18 && getBid != 31 && getBid != 98)
    	{
	    	if ((DayNight == "day" || DayNight == "dayM") && !world.isDaytime())
	    	{
	    		return false;
	    	}
    	}
    	*/

    	//メタル系用
    	/*
		if ((DayNight == "nightM" || DayNight == "dayM" || DayNight == "Metaru") && (world.getBlockId(par1, par2 + 1, par3) != 0))
    	{
    		return false;
    	}
    	*/


    	//if((world.isAirBlock(par1, par2, par3) && FieldBlockIDTb.containsKey(world.getBlockId(par1, par2 - 1, par3))) || world.getBlockId(par1, par2, par3) == 78)
    	if(world.isAirBlock(par1, par2, par3))
    	{

    		if (DQR.conf.LightSpawnStop > 0)
    		{
            	piraCnt = 7;
    			for(int iY = 0;iY <= 7; iY ++)
	    		{
	        		for(int iZ = 0 - piraCnt;iZ < piraCnt; iZ ++)
	        		{
	            		for(int iX = 0 - piraCnt;iX < piraCnt; iX ++)
	            		{
	            			//if(!this.isLighting(world, par1 + iX, par2 + iY, par3 + iZ))
	            			//{
	            			//	break;
	            			//}

	            			targetBid = world.getBlock(par1 + iX, par2 + iY, par3 + iZ);
	            			if(targetBid.getLightValue() > 15 - piraCnt && targetBid.getMaterial() != Material.lava)
	            			{
	            				return false;
	            			}
	            		}
	        		}
					piraCnt = piraCnt - 1;
	    		}

            	piraCnt = 7;
    			for(int iY = 0;iY >= -7; iY --)
	    		{
	        		for(int iZ = 0 - piraCnt;iZ < piraCnt; iZ ++)
	        		{
	            		for(int iX = 0 - piraCnt;iX < piraCnt; iX ++)
	            		{
	            			//if(!this.isLighting(world, par1 + iX, par2 + iY, par3 + iZ))
	            			//{
	            			//	break;
	            			//}

	            			targetBid = world.getBlock(par1 + iX, par2 + iY, par3 + iZ);
	            			if(targetBid.getLightValue() > 15 - piraCnt && targetBid.getMaterial() != Material.lava)
	            			{
	            				return false;
	            			}
	            		}
	        		}
					piraCnt = piraCnt - 1;
	    		}
    		}

        	return true;
    	}

    	return false;
    }


}
