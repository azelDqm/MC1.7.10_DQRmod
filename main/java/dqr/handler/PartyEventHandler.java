package dqr.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import dqr.DQR;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.playerData.ExtendedPlayerProperties;

public class PartyEventHandler {
	@SubscribeEvent
    public void PlayerInteractHandler(EntityInteractEvent event)
	{
		if(event.target != null && event.target instanceof EntityPlayer)
		{
			EntityPlayer targetEp = (EntityPlayer)event.target;
			EntityPlayer ep = event.entityPlayer;

			if(!ep.worldObj.isRemote && ep.inventory.getCurrentItem() != null && ep.inventory.getCurrentItem().getItem() == DQMiscs.itemShinjirukokoro)
			{
				int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_SHINZIRU.getId());

				MinecraftServer minecraftserver = MinecraftServer.getServer();

				if(itemMode == EnumDqmMGToolMode.SHINZIRU_MEMBER_ADD.getId())
				{
					EntityPlayer er2 = minecraftserver.getConfigurationManager().func_152612_a(DQR.partyManager.getPartyLeaderFromMember(ep));
					if(er2 != null)
					{
						DQR.partyManager.addPartyMember(er2, targetEp.getCommandSenderName());
					}else
					{
						DQR.partyManager.addPartyMember(ep, targetEp.getCommandSenderName());
					}
				}else if(itemMode == EnumDqmMGToolMode.SHINZIRU_MEMBER_KICK.getId())
				{
					if(DQR.partyManager.isPartyLeader(ep))
					{
						DQR.partyManager.kickPartyMember(targetEp.getCommandSenderName(), ep);
					}else
	        		{
	        			ep.addChatMessage(new ChatComponentTranslation("msg.shinziru.modeInfo.txt", new Object[] {}));
	        		}
				}
			}
		}
	}

	@SubscribeEvent
    public void PlayerLogoutEvent(PlayerEvent.PlayerLoggedOutEvent e)
	{
		EntityPlayer ep = e.player;

		if(!ep.worldObj.isRemote)
		{
			//System.out.println("TEST_AAAA");
			if(DQR.partyManager.isPartyLeader(ep))
			{
				//System.out.println("TEST_BBBB");
				DQR.partyManager.changePartyLeaderForce(ep);
			}
			//System.out.println("TEST");
		}
	}
}
