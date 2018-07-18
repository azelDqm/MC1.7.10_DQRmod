package dqr.items.miscs;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.items.base.DqmItemMiscBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemShinjirukokoro extends DqmItemMiscBase{

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer ep)
    {
    	if(DQR.conf.partyEnable != 0)
    	{
	    	if(!par2World.isRemote)
	    	{
	    		//System.out.println("TEST");
	    		int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_SHINZIRU.getId());

				if(itemMode == EnumDqmMGToolMode.SHINZIRU_PET_KICK.getId())
				{
					if(DQR.partyManager.isPartyLeader(ep))
	        		{
		        		DQR.partyManager.kickPartyPet(ep, true);
	        		}else
	        		{
	        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shinziru.modeInfo.txt", new Object[] {}));
	        		}
				}else if(itemMode == EnumDqmMGToolMode.SHINZIRU_LEAVE.getId())
				{
		        	DQR.partyManager.removePartyMember(ep);
				}else if(itemMode == EnumDqmMGToolMode.SHINZIRU_CLOSE.getId())
				{
					if(DQR.partyManager.isPartyLeader(ep))
	        		{
						DQR.partyManager.closeParty(ep);
	        		}else
	        		{
	        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shinziru.modeInfo.txt", new Object[] {}));
	        		}
				}else if(itemMode == EnumDqmMGToolMode.SHINZIRU_SHARE.getId())
				{
					if(DQR.partyManager.isPartyLeader(ep))
	        		{
		        		DQR.partyManager.doChangeShareRate(ep);
	        		}else
	        		{
	        			DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.shinziru.modeInfo.txt", new Object[] {}));
	        		}
				}
	    	}
    	}

    	return par1ItemStack;
    }

    @Override
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_)
    {
    	if(DQR.conf.partyEnable != 0)
    	{
    		p_77624_3_.add(EnumColor.Yellow.getChatColor() + I18n.format("dqm.iteminfo.weapon.toolmode.party.txt", new Object[]{}));
    		p_77624_3_.add("");
    	}
    }
}
