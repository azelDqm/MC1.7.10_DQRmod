package dqr.items.base;

import java.text.NumberFormat;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.api.Items.DQBuilders;
import dqr.api.enums.EnumDqmBuilder;

public class DqmItemBuilderBase extends Item{

	public EnumDqmBuilder buildEnum;

	public DqmItemBuilderBase(EnumDqmBuilder enumBuilder)
	{
		super();
		this.buildEnum = enumBuilder;
	}

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	//p_77624_3_.add(I18n.format("dqm.magicinfo.noimplemented"));
    	if(this == DQBuilders.itemBuilderDama ||
    	   this == DQBuilders.itemBuilderDamaS ||
    	   this == DQBuilders.itemBuilderDamaW)
    	{
	    	p_77624_3_.add("§f" + I18n.format("dqm.iteminfo.builderDama.0.txt"));
	    	p_77624_3_.add("§f" + I18n.format("dqm.iteminfo.builderDama.1.txt"));
	    	p_77624_3_.add("§f" + I18n.format("dqm.iteminfo.builderDama.2.txt"));
	    	p_77624_3_.add("§f" + I18n.format("dqm.iteminfo.builderDama.3.txt"));
	    	p_77624_3_.add("§b" + I18n.format("dqm.iteminfo.builderDama.4.txt"));
	    	p_77624_3_.add("§b" + I18n.format("dqm.iteminfo.builderDama.5.txt"));
    	}

    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	NBTTagCompound nbt = p_77624_1_.getTagCompound();
    	if(nbt != null)
    	{
    		NumberFormat nfNum = NumberFormat.getNumberInstance();
    		int medalVal = nbt.getInteger("medalking");
    		//System.out.println("TEST:" + medalVal);
    		if(medalVal > 0)
    		{

        		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

    			p_77624_3_.add(medalValue);
    		}

    		int coinVal = nbt.getInteger("casinocoin");
    		//System.out.println("TEST:" + medalVal);
    		if(coinVal > 0)
    		{

        		String medalValue = I18n.format("msg.casinocoin.item.txt", new Object[]{nfNum.format(coinVal)});

    			p_77624_3_.add(medalValue);
    		}
    	}


    }
}
