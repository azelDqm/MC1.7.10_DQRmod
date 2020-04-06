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

	public double[] RuraSinX = new double[10];
	public double[] RuraSinY = new double[10];
	public double[] RuraSinZ = new double[10];
	public int[] RuraSinDim = new int[10];
	public int[] RuraSinEnable = new int[10];

	public double[] BasiRuraX = new double[5];
	public double[] BasiRuraY = new double[5];
	public double[] BasiRuraZ = new double[5];
	public int[] BasiRuraDim = new int[5];
	public int[] BasiRuraEnable = new int[5];

	public double[] KimeraX = new double[5];
	public double[] KimeraY = new double[5];
	public double[] KimeraZ = new double[5];
	public int[] KimeraDim = new int[5];
	public int[] KimeraEnable = new int[5];

	private long PetUniqueNum = 0;

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

    	for(int cnt = 0; cnt < RuraSinX.length; cnt++)
    	{
    		this.RuraSinX[cnt] = nbt.getDouble("RuraSinX_" + cnt);
    		this.RuraSinY[cnt] = nbt.getDouble("RuraSinY_" + cnt);
    		this.RuraSinZ[cnt] = nbt.getDouble("RuraSinZ_" + cnt);
    		this.RuraSinDim[cnt] = nbt.getInteger("RuraSinDim_" + cnt);
    		this.RuraSinEnable[cnt] = nbt.getInteger("RuraSinEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < BasiRuraX.length; cnt++)
    	{
    		this.BasiRuraX[cnt] = nbt.getDouble("BasiRuraX_" + cnt);
    		this.BasiRuraY[cnt] = nbt.getDouble("BasiRuraY_" + cnt);
    		this.BasiRuraZ[cnt] = nbt.getDouble("BasiRuraZ_" + cnt);
    		this.BasiRuraDim[cnt] = nbt.getInteger("BasiRuraDim_" + cnt);
    		this.BasiRuraEnable[cnt] = nbt.getInteger("BasiRuraEnable_" + cnt);
    	}

    	for(int cnt = 0; cnt < KimeraX.length; cnt++)
    	{
    		this.KimeraX[cnt] = nbt.getDouble("KimeraX_" + cnt);
    		this.KimeraY[cnt] = nbt.getDouble("KimeraY_" + cnt);
    		this.KimeraZ[cnt] = nbt.getDouble("KimeraZ_" + cnt);
    		this.KimeraDim[cnt] = nbt.getInteger("KimeraDim_" + cnt);
    		this.KimeraEnable[cnt] = nbt.getInteger("KimeraEnable_" + cnt);
    	}

    	this.PetUniqueNum = nbt.getLong("PetUniqueNum");
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

    	for(int cnt = 0; cnt < RuraSinX.length; cnt++)
    	{
    		nbt.setDouble("RuraSinX_" + cnt, this.RuraSinX[cnt]);
    		nbt.setDouble("RuraSinY_" + cnt, this.RuraSinY[cnt]);
    		nbt.setDouble("RuraSinZ_" + cnt, this.RuraSinZ[cnt]);
    		nbt.setInteger("RuraSinDim_" + cnt, this.RuraSinDim[cnt]);
    		nbt.setInteger("RuraSinEnable_" + cnt, this.RuraSinEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < BasiRuraX.length; cnt++)
    	{
    		nbt.setDouble("BasiRuraX_" + cnt, this.BasiRuraX[cnt]);
    		nbt.setDouble("BasiRuraY_" + cnt, this.BasiRuraY[cnt]);
    		nbt.setDouble("BasiRuraZ_" + cnt, this.BasiRuraZ[cnt]);
    		nbt.setInteger("BasiRuraDim_" + cnt, this.BasiRuraDim[cnt]);
    		nbt.setInteger("BasiRuraEnable_" + cnt, this.BasiRuraEnable[cnt]);
    	}

    	for(int cnt = 0; cnt < KimeraX.length; cnt++)
    	{
    		nbt.setDouble("KimeraX_" + cnt, this.KimeraX[cnt]);
    		nbt.setDouble("KimeraY_" + cnt, this.KimeraY[cnt]);
    		nbt.setDouble("KimeraZ_" + cnt, this.KimeraZ[cnt]);
    		nbt.setInteger("KimeraDim_" + cnt, this.KimeraDim[cnt]);
    		nbt.setInteger("KimeraEnable_" + cnt, this.KimeraEnable[cnt]);
    	}

    	nbt.setLong("PetUniqueNum", this.PetUniqueNum);
    }

    public void setRura(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.RuraX[par1] = par2;
    	this.RuraY[par1] = par3;
    	this.RuraZ[par1] = par4;
    	this.RuraDim[par1] = par5;
    	this.RuraEnable[par1] = par6;
    }

    public void setRuraSin(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.RuraSinX[par1] = par2;
    	this.RuraSinY[par1] = par3;
    	this.RuraSinZ[par1] = par4;
    	this.RuraSinDim[par1] = par5;
    	this.RuraSinEnable[par1] = par6;
    }

    public void setBasiRura(int par1, double par2, double par3, double par4, int par5, int par6)
    {
    	this.BasiRuraX[par1] = par2;
    	this.BasiRuraY[par1] = par3;
    	this.BasiRuraZ[par1] = par4;
    	this.BasiRuraDim[par1] = par5;
    	this.BasiRuraEnable[par1] = par6;
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

    public double[] getRuraSin(int par1)
    {
    	return new double[]{this.RuraSinX[par1], this.RuraSinY[par1], this.RuraSinZ[par1], this.RuraSinDim[par1]};
    }

    public double[] getBasiRura(int par1)
    {
    	return new double[]{this.BasiRuraX[par1], this.BasiRuraY[par1], this.BasiRuraZ[par1], this.BasiRuraDim[par1]};
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



    public void setBasiRuraX(int par1, double par2)
    {
    	this.BasiRuraX[par1] = par2;
    }
    public double getBasiRuraX(int par1)
    {
    	return this.BasiRuraX[par1];
    }

    public void setBasiRuraY(int par1, double par2)
    {
    	this.BasiRuraY[par1] = par2;
    }
    public double getBasiRuraY(int par1)
    {
    	return this.BasiRuraY[par1];
    }

    public void setBasiRuraZ(int par1, double par2)
    {
    	this.BasiRuraZ[par1] = par2;
    }
    public double getBasiRuraZ(int par1)
    {
    	return this.BasiRuraZ[par1];
    }

    public void setBasiRuraDim(int par1, int par2)
    {
    	this.BasiRuraDim[par1] = par2;
    }
    public double getBasiRuraDim(int par1)
    {
    	return this.BasiRuraDim[par1];
    }

    public void setBasiRuraEnable(int par1, int par2)
    {
    	this.BasiRuraEnable[par1] = par2;
    }
    public double getBasiRuraEnable(int par1)
    {
    	return this.BasiRuraEnable[par1];
    }


    public void setRuraSinX(int par1, double par2)
    {
    	this.RuraSinX[par1] = par2;
    }
    public double getRuraSinX(int par1)
    {
    	return this.RuraSinX[par1];
    }

    public void setRuraSinY(int par1, double par2)
    {
    	this.RuraSinY[par1] = par2;
    }
    public double getRuraSinY(int par1)
    {
    	return this.RuraSinY[par1];
    }

    public void setRuraSinZ(int par1, double par2)
    {
    	this.RuraSinZ[par1] = par2;
    }
    public double getRuraSinZ(int par1)
    {
    	return this.RuraSinZ[par1];
    }

    public void setRuraSinDim(int par1, int par2)
    {
    	this.RuraSinDim[par1] = par2;
    }
    public int getRuraSinDim(int par1)
    {
    	return this.RuraSinDim[par1];
    }

    public void setRuraSinEnable(int par1, int par2)
    {
    	this.RuraSinEnable[par1] = par2;
    }
    public int getRuraSinEnable(int par1)
    {
    	return this.RuraSinEnable[par1];
    }


    public double[] getRuraXA()
    {
    	return this.RuraX;
    }
    public double[] getRuraYA()
    {
    	return this.RuraY;
    }
    public double[] getRuraZA()
    {
    	return this.RuraZ;
    }
    public int[] getRuraDimA()
    {
    	return this.RuraDim;
    }
    public int[] getRuraEnableA()
    {
    	return this.RuraEnable;
    }

    public double[] getBasiRuraXA()
    {
    	return this.BasiRuraX;
    }
    public double[] getBasiRuraYA()
    {
    	return this.BasiRuraY;
    }
    public double[] getBasiRuraZA()
    {
    	return this.BasiRuraZ;
    }
    public int[] getBasiRuraDimA()
    {
    	return this.BasiRuraDim;
    }
    public int[] getBasiRuraEnableA()
    {
    	return this.BasiRuraEnable;
    }

    public double[] getKimeraXA()
    {
    	return this.KimeraX;
    }
    public double[] getKimeraYA()
    {
    	return this.KimeraY;
    }
    public double[] getKimeraZA()
    {
    	return this.KimeraZ;
    }
    public int[] getKimeraDimA()
    {
    	return this.KimeraDim;
    }
    public int[] getKimeraEnableA()
    {
    	return this.KimeraEnable;
    }


    public double[] getRuraSinXA()
    {
    	return this.RuraSinX;
    }
    public double[] getRuraSinYA()
    {
    	return this.RuraSinY;
    }
    public double[] getRuraSinZA()
    {
    	return this.RuraSinZ;
    }
    public int[] getRuraSinDimA()
    {
    	return this.RuraSinDim;
    }
    public int[] getRuraSinEnableA()
    {
    	return this.RuraSinEnable;
    }

    public long getNextPetNum()
    {
    	this.PetUniqueNum = this.PetUniqueNum + 1;
    	return this.PetUniqueNum;
    }

    public long getCurrentPetNum()
    {
    	return this.PetUniqueNum;
    }

    public void setCurrentPetNum(long par1)
    {
    	this.PetUniqueNum = par1;
    }
}
