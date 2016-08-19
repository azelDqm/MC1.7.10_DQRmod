package dqr.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import dqr.DQR;
import dqr.api.Items.DQMiscs;

public class PartyEventHandler {
	@SubscribeEvent
    public void PlayerInteractHandler(EntityInteractEvent event)
	{
		if(event.target != null && event.target instanceof EntityPlayer)
		{
			EntityPlayer targetEp = (EntityPlayer)event.target;
			EntityPlayer ep = event.entityPlayer;

			if(ep.inventory.getCurrentItem() != null && ep.inventory.getCurrentItem().getItem() == DQMiscs.itemShinjirukokoro)
			{
				if(DQR.partyManager.getPartyLeaderFromMember(ep) != null)
				{
					DQR.partyManager.addPartyMember(DQR.partyManager.getPartyLeaderFromMember(ep), targetEp);
				}else
				{
					DQR.partyManager.addPartyMember(ep, targetEp);
				}
			}
		}
	}

	@SubscribeEvent
    public void PlayerLogoutEvent(PlayerEvent.PlayerLoggedOutEvent e)
	{
		EntityPlayer ep = e.player;
		if(DQR.partyManager.isPartyLeader(ep))
		{
			DQR.partyManager.changePartyLeaderForce(ep);
		}
		//System.out.println("TEST");
	}
}
