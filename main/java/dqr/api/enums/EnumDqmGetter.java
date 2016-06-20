package dqr.api.enums;

import java.util.TreeMap;

public class EnumDqmGetter {

	public EnumDqmGetter(){}

	public EnumDqmEndoraParam getEndoraParam(int id)
	{
		EnumDqmEndoraParam[] endoraParam = EnumDqmEndoraParam.values();
		EnumDqmEndoraParam endoraParamMax = null;

		for(int cnt = 0;cnt < endoraParam.length; cnt++)
		{
			if(endoraParam[cnt].getId() == id)
			{
				return endoraParam[cnt];
			}

			if(endoraParam[cnt].getId() == 6)
			{
				endoraParamMax = endoraParam[cnt];
			}
		}

		return endoraParamMax;
	}

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

    public EnumDqmMonsterResist getMonsterResistFromId(int par1)
    {
    	EnumDqmMonsterResist[] data = EnumDqmMonsterResist.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getId() == par1)
    		{
    			return data[cnt];
    		}
    	}

    	return EnumDqmMonsterResist.SURA;
    }

    public EnumDqmMonsterResist getMonsterResistFromMobname(String par1)
    {
    	EnumDqmMonsterResist[] data = EnumDqmMonsterResist.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getMobname().equalsIgnoreCase(par1))
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }

    public TreeMap getSkillW(int wId)
    {
    	//wId : weaponID

    	TreeMap<Integer, EnumDqmSkillW> ret = new TreeMap<Integer, EnumDqmSkillW>();

    	EnumDqmSkillW[] data = EnumDqmSkillW.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getWeaponId() == wId)
    		{
    			ret.put(data[cnt].getCategCode(), data[cnt]);
    		}
    	}

    	return ret;
    }

    public EnumDqmSkillW getSkillW(int wId, int categId)
    {

    	EnumDqmSkillW[] data = EnumDqmSkillW.values();

    	for(int cnt = 0; cnt < data.length; cnt++)
    	{
    		if(data[cnt].getWeaponId() == wId && data[cnt].getCategCode() == categId)
    		{
    			return data[cnt];
    		}
    	}

    	return null;
    }
}
