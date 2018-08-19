package dqr.items.base;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.api.enums.EnumColor;

public class DqmItemSkillJBase extends Item{

	public DqmItemSkillJBase()
	{
		super();
		//this.setCreativeTab(DQR.tabs.DqmTabMisc);
	}

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {



		NBTTagCompound nbt = p_77624_1_.getTagCompound();


		if(nbt != null)
		{
			if(p_77624_1_.getDisplayName().indexOf("dqm.skill.") > -1)
			{
				p_77624_1_.setStackDisplayName(I18n.format(p_77624_1_.getDisplayName(), new Object[]{nbt.getInteger("statusParam")}));
			}

			p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.skill.JSkill.needSP", new Object[]{nbt.getInteger("needSP")}));

			if(nbt.getInteger("allFlg") == 1)
			{
				p_77624_3_.add(EnumColor.Yellow.getChatColor() + I18n.format("dqm.skill.JSkill.allFlg", new Object[]{}));
			}
		}
	 }
}
