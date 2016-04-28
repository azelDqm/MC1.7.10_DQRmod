package dqr.enums;

import dqr.api.enums.EnumDqmJob;

public class DqmEnumGetter {

	public DqmEnumGetter(){}

    public EnumDqmJob getJobFromId(int par1)
    {
    	EnumDqmJob[] data = EnumDqmJob.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getId() == par1)
    		{
    			return data[cnt];
    		}
    	}

    	return EnumDqmJob.Asobinin;
    }
}
