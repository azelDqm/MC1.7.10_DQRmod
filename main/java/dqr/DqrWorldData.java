package dqr;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.WorldSavedData;

public class DqrWorldData extends WorldSavedData
{
	public double[] RuraX = new double[5];
	public double[] RuraY = new double[5];
	public double[] RuraZ = new double[5];
	public int[] RuraDim = new int[5];
	public int[] RuraEnable = new int[5];

	public double[] KimeraX = new double[5];
	public double[] KimeraY = new double[5];
	public double[] KimeraZ = new double[5];
	public int[] KimeraDim = new int[5];
	public int[] KimeraEnable = new int[5];

    private static final String __OBFID = "CL_00000577";

    public DqrWorldData(String p_i2140_1_)
    {
        super(p_i2140_1_);
    }

    /**
     * reads in data from the NBTTagCompound into this MapDataBase
     */
    public void readFromNBT(NBTTagCompound nbt)
    {
    	for(int cnt = 0; cnt < RuraX.length; cnt++)
    	{
    		this.RuraX[cnt] = nbt.getDouble("RuraX_" + cnt);
    		this.RuraY[cnt] = nbt.getDouble("RuraY_" + cnt);
    		this.RuraZ[cnt] = nbt.getDouble("RuraZ_" + cnt);
    		this.RuraDim[cnt] = nbt.getInteger("RuraDim_" + cnt);
    		this.RuraEnable[cnt] = nbt.getInteger("RuraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < KimeraX.length; cnt++)
    	{
    		this.KimeraX[cnt] = nbt.getDouble("KimeraX_" + cnt);
    		this.KimeraY[cnt] = nbt.getDouble("KimeraY_" + cnt);
    		this.KimeraZ[cnt] = nbt.getDouble("KimeraZ_" + cnt);
    		this.KimeraDim[cnt] = nbt.getInteger("KimeraDim_" + cnt);
    		this.KimeraEnable[cnt] = nbt.getInteger("KimeraEnable_" + cnt);
    	}
    }

    /**
     * write data to NBTTagCompound from this MapDataBase, similar to Entities and TileEntities
     */
    public void writeToNBT(NBTTagCompound nbt)
    {
    	for(int cnt = 0; cnt < RuraX.length; cnt++)
    	{
    		nbt.setDouble("RuraX_" + cnt, this.RuraX[cnt]);
    		nbt.setDouble("RuraY_" + cnt, this.RuraY[cnt]);
    		nbt.setDouble("RuraZ_" + cnt, this.RuraZ[cnt]);
    		nbt.setInteger("RuraDim_" + cnt, this.RuraDim[cnt]);
    		nbt.setInteger("RuraEnable_" + cnt, this.RuraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < KimeraX.length; cnt++)
    	{
    		nbt.setDouble("KimeraX_" + cnt, this.KimeraX[cnt]);
    		nbt.setDouble("KimeraY_" + cnt, this.KimeraY[cnt]);
    		nbt.setDouble("KimeraZ_" + cnt, this.KimeraZ[cnt]);
    		nbt.setInteger("KimeraDim_" + cnt, this.KimeraDim[cnt]);
    		nbt.setInteger("KimeraEnable_" + cnt, this.KimeraEnable[cnt]);
    	}
    }

    public void setRura(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.RuraX[par1] = par2;
    	this.RuraY[par1] = par3;
    	this.RuraZ[par1] = par4;
    	this.RuraDim[par1] = par5;
    	this.RuraEnable[par1] = par6;
    }

    public void setKimera(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.KimeraX[par1] = par2;
    	this.KimeraY[par1] = par3;
    	this.KimeraZ[par1] = par4;
    	this.KimeraDim[par1] = par5;
    	this.KimeraEnable[par1] = par6;
    }

    public double[] getRura(int par1)
    {
    	return new double[]{this.RuraX[par1], this.RuraY[par1], this.RuraZ[par1], this.RuraDim[par1]};
    }

    public double[] getKimera(int par1)
    {
    	return new double[]{this.KimeraX[par1], this.KimeraY[par1], this.KimeraZ[par1], this.KimeraDim[par1]};
    }

    public void setRuraX(int par1, double par2)
    {
    	this.RuraX[par1] = par2;
    }
    public double getRuraX(int par1)
    {
    	return this.RuraX[par1];
    }

    public void setRuraY(int par1, double par2)
    {
    	this.RuraY[par1] = par2;
    }
    public double getRuraY(int par1)
    {
    	return this.RuraY[par1];
    }

    public void setRuraZ(int par1, double par2)
    {
    	this.RuraZ[par1] = par2;
    }
    public double getRuraZ(int par1)
    {
    	return this.RuraZ[par1];
    }

    public void setRuraDim(int par1, int par2)
    {
    	this.RuraDim[par1] = par2;
    }
    public double getRuraDim(int par1)
    {
    	return this.RuraDim[par1];
    }

    public void setRuraEnable(int par1, int par2)
    {
    	this.RuraEnable[par1] = par2;
    }
    public double getRuraEnable(int par1)
    {
    	return this.RuraEnable[par1];
    }


    public void setKimeraX(int par1, double par2)
    {
    	this.KimeraX[par1] = par2;
    }
    public double getKimeraX(int par1)
    {
    	return this.KimeraX[par1];
    }

    public void setKimeraY(int par1, double par2)
    {
    	this.KimeraY[par1] = par2;
    }
    public double getKimeraY(int par1)
    {
    	return this.KimeraY[par1];
    }

    public void setKimeraZ(int par1, double par2)
    {
    	this.KimeraZ[par1] = par2;
    }
    public double getKimeraZ(int par1)
    {
    	return this.KimeraZ[par1];
    }

    public void setKimeraDim(int par1, int par2)
    {
    	this.KimeraDim[par1] = par2;
    }
    public double getKimeraDim(int par1)
    {
    	return this.KimeraDim[par1];
    }

    public void setKimeraEnable(int par1, int par2)
    {
    	this.KimeraEnable[par1] = par2;
    }
    public double getKimeraEnable(int par1)
    {
    	return this.KimeraEnable[par1];
    }
}
