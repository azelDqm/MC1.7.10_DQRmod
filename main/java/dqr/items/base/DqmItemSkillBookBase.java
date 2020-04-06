package dqr.items.base;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.api.enums.EnumDqmStatus;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.ExtendedPlayerProperties5;
import dqr.playerData.MessagePlayerProperties5;

public class DqmItemSkillBookBase extends Item{



    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {

    	if(!world.isRemote)
    	{
    		if(player.isSneaking())
    		{
    			if(!player.worldObj.isRemote)
    			{
    				PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties5((EntityPlayer)player), (EntityPlayerMP)player);
    			}
    			player.openGui(DQR.instance, DQR.conf.GuiID_Skillbook, world, (int)player.posX, (int)player.posY, (int)player.posZ);
    		}else
    		{
    			NBTTagCompound nbt2 = itemStack.getTagCompound();
    			if(nbt2 != null)
    	    	{
    				int selectedNo = -1;
    				if(nbt2.hasKey("selectedNo"))
    	    		{
    	    			selectedNo = nbt2.getInteger("selectedNo");
    	    		}else
    	    		{
    	    			selectedNo = 0;
    	    		}

    				if(nbt2.hasKey("skill" + selectedNo + "_job") && nbt2.hasKey("skill" + selectedNo + "_idx") &&
    						nbt2.getInteger("skill" + selectedNo + "_job") > -1 && nbt2.getInteger("skill" + selectedNo + "_idx") > -1)
    				{
    					EnumDqmSkillJ skill2 = DQR.enumGetter.getSkillJ(nbt2.getInteger("skill" + selectedNo + "_job"), nbt2.getInteger("skill" + selectedNo + "_idx"));

    					if(skill2 != null)
    					{
    						//習得しているかチェック
    						if(ExtendedPlayerProperties5.get(player).getJobSPSkillSet(skill2.getJob(), skill2.getIdx()) == 0)
    						{
    							DQR.func.debugString("SkillCheck1 : " + this.getClass() + " : " + 14);
    							DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.jskill.notselected.txt",new Object[] {}));
    							player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
    							return itemStack;
    						}

    						//職業チェック
    						if(ExtendedPlayerProperties.get(player).getJob() != skill2.getJob() &&
    							ExtendedPlayerProperties5.get(player).getJobSPSkillSet(skill2.getJob(), skill2.getIdx()) != 2)
    						{
    							DQR.func.debugString("SkillCheck2 : " + this.getClass() + " : " + 14);
    							DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.jskill.notmatchjob.txt",new Object[] {}));
    							player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
    							return itemStack;
    						}

    						//CoolTimeチェック
    						if(ExtendedPlayerProperties5.get(player).getJobSPSkillCT(skill2.getJob(), skill2.getIdx()) >= world.getWorldTime() && DQR.debug == 0)
    						{
    							DQR.func.debugString("SkillCheck3 : " + this.getClass() + " : " + 14);
    							DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.jskill.coolingtime.txt",new Object[] {}));
    							player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
    							return itemStack;
    						}

    						//消費ポイントチェック
    						if(skill2.getNeedpt_Cat() == EnumDqmStatus.HP.getId())
    						{
    							if(player.getHealth() <= skill2.getNeedpt_Val())
    							{
    								DQR.func.debugString("SkillCheck4 : " + this.getClass() + " : " + 14);
        							DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.jskill.coolingtime.txt",new Object[] {}));
        							player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        							return itemStack;
    							}else
    							{
    								player.setHealth(player.getHealth() - skill2.getNeedpt_Val());
    							}
    						}else if(skill2.getNeedpt_Cat() == EnumDqmStatus.MP.getId())
    						{
    							if(ExtendedPlayerProperties.get(player).getMP() <= skill2.getNeedpt_Val())
    							{
    								DQR.func.debugString("SkillCheck5 : " + this.getClass() + " : " + 14);
        							DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.jskill.coolingtime.txt",new Object[] {}));
        							player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        							return itemStack;
    							}else
    							{
    								ExtendedPlayerProperties.get(player).setMP(ExtendedPlayerProperties.get(player).getMP() - skill2.getNeedpt_Val());
    							}
    						}else if(skill2.getNeedpt_Cat() == EnumDqmStatus.GOLD.getId())
    						{
    							if(ExtendedPlayerProperties.get(player).getGold() <= skill2.getNeedpt_Val())
    							{
    								DQR.func.debugString("SkillCheck6 : " + this.getClass() + " : " + 14);
        							DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation("msg.jskill.coolingtime.txt",new Object[] {}));
        							player.worldObj.playSoundAtEntity(player, "dqr:player.pi", 1.0F, 1.0F);
        							return itemStack;
    							}else
    							{
    								ExtendedPlayerProperties.get(player).setGold(ExtendedPlayerProperties.get(player).getGold() - skill2.getNeedpt_Val());
    							}
    						}

    						//CoolTimeセット
    						if(skill2.getCooltime() > 0)
    						{
    							ExtendedPlayerProperties5.get(player).setJobSPSkillCT(skill2.getJob(), skill2.getIdx(), world.getWorldTime() + (skill2.getCooltime() * 20));
    			    			if(!player.worldObj.isRemote)
    			    			{
    			    				PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties5((EntityPlayer)player), (EntityPlayerMP)player);
    			    			}
    						}
    						//DQR.func.doAddChatMessageFix(player, new ChatComponentTranslation(skill2.name()));

    						switch(skill2.getJob())
    						{
    							case 0: DQR.jobSkillSP.doSkillJobSP0(skill2.getJob(), skill2.getIdx(), player, skill2); break;
    						}
    						/*
    						String skillName = I18n.format("dqm.skill.JSkill_" + skill2.getJob() + "_" + skill2.getIdx() + ".name");
    						p_77624_3_.add(I18n.format("dqm.iteminfo.skillbook.4.txt", new Object[]{bookCnt + 1, skillName}));

    						if(ExtendedPlayerProperties3.get(p_77624_2_).tooltipShortSkillBook)
    						{
    							String skillInfo = I18n.format("dqm.skill.JSkill_" + skill2.getJob() + "_" + skill2.getIdx() + ".info");
    							p_77624_3_.add(I18n.format("dqm.iteminfo.skillbook.5.txt", new Object[]{skillInfo}));
    						}
    						*/

    					}

    				}
    	    	}
    		}
    	}

    	//DQR.func.debugString("TEST : ItemRightClick + " + world.isRemote);
    	return itemStack;
    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
    {
    	GameSettings settings = Minecraft.getMinecraft().gameSettings;//Minecraft.getMinecraft().gameSettings;

    	//DQR.func.debugString("TEST : " + settings.keyBindUseItem.getKeyCode() );

    	p_77624_3_.add(I18n.format("dqm.iteminfo.skillbook.6.txt", new Object[]{DQR.func.getKeyDisplayString(settings.keyBindSneak.getKeyCode()), DQR.func.getKeyDisplayString(settings.keyBindUseItem.getKeyCode())}));
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
