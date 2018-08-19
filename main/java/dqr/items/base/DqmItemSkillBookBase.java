package dqr.items.base;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import dqr.DQR;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.playerData.ExtendedPlayerProperties3;

public class DqmItemSkillBookBase extends Item{



    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
    	if(!world.isRemote)
    	{
    		player.openGui(DQR.instance, DQR.conf.GuiID_Skillbook, world, (int)player.posX, (int)player.posY, (int)player.posZ);
    	}
    	return itemStack;
    }



    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
    {
    	GameSettings settings = Minecraft.getMinecraft().gameSettings;//Minecraft.getMinecraft().gameSettings;

    	//DQR.func.debugString("TEST : " + settings.keyBindUseItem.getKeyCode() );


    	p_77624_3_.add(I18n.format("dqm.iteminfo.skillbook.0.txt", new Object[]{DQR.func.getKeyDisplayString(settings.keyBindUseItem.getKeyCode())}));
    	p_77624_3_.add(I18n.format("dqm.iteminfo.skillbook.1.txt", new Object[]{DQR.func.getKeyDisplayString(DQR.CLKeyBind.keyMagicToolMode.getKeyCode())}));
    	p_77624_3_.add(I18n.format("dqm.iteminfo.skillbook.2.txt", new Object[]{DQR.func.getKeyDisplayString(settings.keyBindSneak.getKeyCode()), Keyboard.getKeyName(DQR.CLKeyBind.keyMagicToolMode.getKeyCode())}));
    	p_77624_3_.add("");

    	NBTTagCompound nbt2 = p_77624_1_.getTagCompound();
    	if(nbt2 != null)
    	{

        	if(ExtendedPlayerProperties3.get(p_77624_2_).tooltipInfoFlg == false && settings.isKeyDown(settings.keyBindSneak))
        	{
        		ExtendedPlayerProperties3.get(p_77624_2_).tooltipInfoFlg = true;
        	}else if(ExtendedPlayerProperties3.get(p_77624_2_).tooltipInfoFlg == true && !settings.isKeyDown(settings.keyBindSneak))
        	{
        		ExtendedPlayerProperties3.get(p_77624_2_).tooltipInfoFlg = false;
        		ExtendedPlayerProperties3.get(p_77624_2_).tooltipShortSkillBook = !ExtendedPlayerProperties3.get(p_77624_2_).tooltipShortSkillBook;
        	}


    		int selectedNo = -1;
    		p_77624_3_.add(I18n.format("dqm.iteminfo.skillbook.3.txt", new Object[]{}));
    		if(nbt2.hasKey("selectedNo"))
    		{
    			selectedNo = nbt2.getInteger("selectedNo");
    		}else
    		{
    			selectedNo = 0;
    		}

    		//selectedNo = 2;
    		for(int bookCnt = 0; bookCnt < 5; bookCnt++)
			{
				if(nbt2.hasKey("skill" + bookCnt + "_job") && nbt2.hasKey("skill" + bookCnt + "_idx") &&
						nbt2.getInteger("skill" + bookCnt + "_job") > -1 && nbt2.getInteger("skill" + bookCnt + "_idx") > -1)
				{
					EnumDqmSkillJ skill2 = DQR.enumGetter.getSkillJ(nbt2.getInteger("skill" + bookCnt + "_job"), nbt2.getInteger("skill" + bookCnt + "_idx"));

					if(skill2 != null)
					{
						String selectColor = EnumColor.White.getChatColor();
						if(selectedNo == bookCnt)
						{
							selectColor = EnumColor.Yellow.getChatColor();
						}
						String skillName = I18n.format("dqm.skill.JSkill_" + skill2.getJob() + "_" + skill2.getIdx() + ".name");
						p_77624_3_.add(selectColor + I18n.format("dqm.iteminfo.skillbook.4.txt", new Object[]{bookCnt + 1, skillName}));

						if(ExtendedPlayerProperties3.get(p_77624_2_).tooltipShortSkillBook)
						{
							String skillInfo = I18n.format("dqm.skill.JSkill_" + skill2.getJob() + "_" + skill2.getIdx() + ".info");
							p_77624_3_.add(selectColor + I18n.format("dqm.iteminfo.skillbook.5.txt", new Object[]{skillInfo}));
						}

					}

				}
			}

    		String sneakKey = GameSettings.getKeyDisplayString(settings.keyBindSneak.getKeyCode());
    		if(ExtendedPlayerProperties3.get(p_77624_2_).tooltipShortSkillBook)
    		{
    			p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.skillbookVis.txt", new Object[]{sneakKey}));
    		}else
    		{
    			p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.skillbookHid.txt", new Object[]{sneakKey}));
    		}
    		/*
    		if(!p_77624_2_.worldObj.isRemote)
    		{
    			p_77624_1_.setTagCompound(nbt2);
    		}
    		*/
    	}
    }

}
