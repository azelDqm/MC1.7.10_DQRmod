package dqr.functions;

import java.util.Random;

import dqr.DQR;

public class FuncCalcMobParam {

	private Random rand = new Random();

	public FuncCalcMobParam()
	{

	}

	public double getCalcHP(double par1)
	{
		/*
		double ret = par1;
		switch(DQR.conf.DqmDifficulty)
		{
			case 0: ret = par1 / 2; break;
			case 1: ret = par1; break;
			case 2: ret = par1; break;
			case 3: ret = par1 + (par1 / 2); break;
			case 4: ret = par1 * 2; break;
			case 5: ret = par1 * 3; break;
			case 6: ret = par1 * 4; break;
			case 10:  ret = par1 * 10; break;
		}
		*/

		double ret = par1;
		switch(DQR.conf.DqmDifficulty)
		{
			case 0: ret = par1 / 2; break;
			case 1: ret = par1; break;
			case 2: ret = par1; break;
			case 3: ret = par1 + (par1 / 5); break;
			case 4: ret = par1 * 2; break;
			case 5: ret = par1 * 3; break;
			case 6: ret = par1 * 4; break;
			case 10:  ret = par1 * 10; break;
		}
		return ret;
	}

	public double getCalcHP2(double par1)
	{
		double ret = par1;
		switch(DQR.conf.DqmDifficulty)
		{
			case 0: ret = par1 / 2; break;
			case 1: ret = par1 - (par1 / 2); break;
			case 2: ret = par1; break;
			case 3: ret = par1; break;
			case 4: ret = par1 * 2; break;
			case 5: ret = par1 * 3; break;
			case 6: ret = par1 * 4; break;
			case 10:  ret = par1 * 10; break;
		}
		return ret;
	}

	public int getCalcDEF(int par1)
	{
		return par1;
	}

	public int getCalcEXP(int par1)
	{
		//return par1;

		int ret = par1;
		switch(DQR.conf.DqmDifficulty)
		{
			case 0: ret = par1 + (par1 / 2); break;
			case 1: ret = par1; break;
			case 2: ret = (par1 * 3 / 4 ); break;
			case 3: ret = par1; break;
			case 4: ret = par1 + (par1 / 2); break;
			case 5: ret = par1 * 2; break;
			case 6: ret = par1 * 2 + (par1 / 2); break;
			case 10:  ret = par1; break;
		}

		ret = ret <= 0? 1 : ret;
		return ret;
	}

	public int getCalcGOLD(int par1)
	{
		int ret = par1;
		switch(DQR.conf.DqmDifficulty)
		{
			case 0: ret = par1 + (par1 / 2); break;
			case 1: ret = par1; break;
			case 2: ret = (par1 * 3 / 4 ); break;
			case 3: ret = par1; break;
			case 4: ret = par1 + (par1 / 2); break;
			case 5: ret = par1 * 2; break;
			case 6: ret = par1 * 2 +  + (par1 / 2); break;
			case 10:  ret = par1; break;
		}

		ret = ret <= 0? 1 : ret;
		return ret;
	}

	public float getCalcSPEED(float par1)
	{
		//return par1 * 1.5F;
		float ret = par1;

		switch(DQR.conf.DqmDifficulty)
		{
		/*
			case 0: ret = par1 * 0.5F; break;
			case 1: ret = par1 * 0.75F; break;
			case 2: ret = par1; break;
			case 3: ret = par1 * 1.2F; break;
			case 4: ret = par1 * 1.5F; break;
			case 5: ret = par1 * 1.75F; break;
			case 6: ret = par1 * 2.0F; break;
			case 10:  ret = par1 * 3.0F; break;
			*/
			case 0: ret = par1 * 0.25F; break;
			case 1: ret = par1 * 0.5F; break;
			case 2: ret = par1 * 0.75F; break;
			case 3: ret = par1; break;
			case 4: ret = par1 * 1.25F; break;
			case 5: ret = par1 * 1.5F; break;
			case 6: ret = par1 * 2.0F; break;
			case 10:  ret = par1 * 3.0F; break;
		}
		return ret;
	}

	public double getCalcPW(double par1)
	{
		double ret = par1;
		switch(DQR.conf.DqmDifficulty)
		{
			case 0: ret = par1 / 3; break;
			case 1: ret = par1 / 2; break;
			case 2: ret = par1; break;
			case 3: ret = par1; break;
			case 4: ret = par1 * 2; break;
			case 5: ret = par1 * 3; break;
			case 6: ret = par1 * 4; break;
			case 10:  ret = par1 * 10; break;
			default:ret = 0;
		}
		return ret;
	}

	public int getCalcDF(int par1)
	{
		return par1;
	}

	public int getCalcTENSEIsp(int par1)
	{
		return par1;
	}

	public boolean getCalcDROP(int base, int per)
	{

		if(rand.nextInt(base) < per)
		{
			return true;
		}
		return false;
	}
}
