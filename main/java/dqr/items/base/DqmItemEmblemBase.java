package dqr.items.base;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.DQR;
import dqr.api.enums.EnumDqmJob;

public class DqmItemEmblemBase extends Item{

	private EnumDqmJob itemJob;

	public DqmItemEmblemBase(EnumDqmJob par1)
	{
		this.itemJob = par1;
	}

	public EnumDqmJob getJobEnum()
	{
		return this.itemJob;
	}

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {


    	int[] needLvTable = DQR.jobChangeTable.getJobChangeTable(this);
    	String needLv = "";

    	if(needLvTable != null)
    	{
    		for(int cnt = 0; cnt < needLvTable.length; cnt++)
    		{
    			if(needLvTable[cnt] > 0)
    			{
    				String jobName = I18n.format("gui.job." +cnt);

    				if(needLvTable[cnt] < 100)
    				{
    					if(needLv != "")
    					{
    						needLv = needLv + "& ";
    					}
    					needLv = needLv + jobName + "(Lv." + needLvTable[cnt] + ") ";
    				}
    			}
    		}

    		if(needLv == "")
    		{
    			String noLv = I18n.format("dqm.magicinfo.needNo", new Object[]{});
    			p_77624_3_.add(I18n.format("dqm.magicinfo.needLv", new Object[]{noLv}));
    		}else
    		{
    			p_77624_3_.add(I18n.format("dqm.magicinfo.needLv", new Object[]{needLv}));
    		}
    	}

    	NBTTagCompound nbt = p_77624_1_.getTagCompound();
    	if(nbt != null)
    	{
    		int medalVal = nbt.getInteger("medalking");
    		//System.out.println("TEST:" + medalVal);
    		if(medalVal > 0)
    		{

        		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

    			p_77624_3_.add(medalValue);
    		}
    	}
    }
}
