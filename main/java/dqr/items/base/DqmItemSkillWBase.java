package dqr.items.base;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import dqr.api.enums.EnumColor;

public class DqmItemSkillWBase  extends Item{


	public DqmItemSkillWBase()
	{
		super();
		//this.setCreativeTab(DQR.tabs.DqmTabMisc);
	}

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {



		NBTTagCompound nbt = p_77624_1_.getTagCompound();
		if(nbt != null)
		{
			int skill_point= nbt.getInteger("skill_point");
			if(skill_point > 0)
			{
				p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.skill.info.needWP.txt", new Object[]{skill_point}));
			}

			p_77624_3_.add("");

			int skill_Equip= nbt.getInteger("skill_Equip");
			if(skill_Equip != 0)
			{
				p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.skill.info.setSkill." + skill_Equip, new Object[]{}));
			}

			int skill_func= nbt.getInteger("skill_func");
			if(skill_func != -1)
			{
				p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.skill.info.func." + skill_func, new Object[]{}));
			}


			String skill_name = nbt.getString("skill_name");
			String skill_info = I18n.format("dqm.skill." + skill_name + ".info", new Object[]{});
			if(skill_info != null && !skill_info.equalsIgnoreCase("") && !skill_info.equalsIgnoreCase("dqm.skill." + skill_name + ".info"))
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + skill_info);
			}

			int skill_hpup= nbt.getInteger("skill_hpup");
			if(skill_hpup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.hpup.txt", new Object[]{skill_hpup}));
			}

			int skill_mpup= nbt.getInteger("skill_mpup");
			if(skill_mpup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.mpup.txt", new Object[]{skill_mpup}));
			}

			int skill_atkup= nbt.getInteger("skill_atkup");
			if(skill_atkup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.atkup.txt", new Object[]{skill_atkup}));
			}

			int skill_defup= nbt.getInteger("skill_defup");
			if(skill_defup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.defup.txt", new Object[]{skill_defup}));
			}

			int skill_magup= nbt.getInteger("skill_magup");
			if(skill_magup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.magup.txt", new Object[]{skill_magup}));
			}

			int skill_strup= nbt.getInteger("skill_strup");
			if(skill_strup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.strup.txt", new Object[]{skill_strup}));
			}

			int skill_agiup= nbt.getInteger("skill_agiup");
			if(skill_agiup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.agiup.txt", new Object[]{skill_agiup}));
			}

			int skill_intup= nbt.getInteger("skill_intup");
			if(skill_intup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.intup.txt", new Object[]{skill_intup}));
			}

			int skill_critup= nbt.getInteger("skill_critup");
			if(skill_critup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.critup.txt", new Object[]{(skill_critup / 10)}));
			}

			int skill_missup= nbt.getInteger("skill_missup");
			if(skill_missup > 0 )
			{
				p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.skill.info.missup.txt", new Object[]{(skill_missup / 10)}));
			}

			//int medalVal = nbt.getInteger("skillinfo");
			//System.out.println("TEST:" + medalVal);
			/*
			if(medalVal > 0)
			{

	    		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

				p_77624_3_.add(medalValue);
			}
			*/
		}
	 }

}
