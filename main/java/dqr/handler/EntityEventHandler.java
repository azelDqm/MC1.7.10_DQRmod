package dqr.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import dqr.DQR;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmBugFix;
import dqr.entity.petEntity.DqmPetBase;
import dqr.items.base.DqmItemDebugBase;
import dqr.items.miscs.DqmItemLittlemedal;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties2;

public class EntityEventHandler {

    @SubscribeEvent
    /*ワールドに入った時に呼ばれるイベント。ここでIExtendedEntityPropertiesを読み込む処理を呼び出す*/
    public void onEntityJoinWorld(PlayerEvent.PlayerRespawnEvent event)
    {
        if (!event.player.worldObj.isRemote && event.player instanceof EntityPlayer)
        {
        	EntityPlayer ep = (EntityPlayer)event.player;
        	if(DQR.conf.recalcMP1 == 1 && ExtendedPlayerProperties2.get(ep).getBugFixFlg(EnumDqmBugFix.Fix080MP.getId()) < 2)
        	{
        		DQR.bugFix.doMpRecalc(ep);
        		ExtendedPlayerProperties2.get(ep).setBugFixFlg(EnumDqmBugFix.Fix080MP.getId(), 2);
        		ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
        	}
        }

        if (!event.player.worldObj.isRemote && event.player instanceof EntityPlayer)
        {
        	EntityPlayer ep = (EntityPlayer)event.player;
        	if(ExtendedPlayerProperties2.get(ep).getBugFixFlg(EnumDqmBugFix.Fix085PET.getId()) < 1)
        	{
        		DQR.bugFix.doPetListReconstruct(ep);
        		ExtendedPlayerProperties2.get(ep).setBugFixFlg(EnumDqmBugFix.Fix085PET.getId(), 1);
        	}
        }

        if (!event.player.worldObj.isRemote && event.player instanceof EntityPlayer)
        {
        	EntityPlayer ep = (EntityPlayer)event.player;
        	if(ExtendedPlayerProperties2.get(ep).getBugFixFlg(EnumDqmBugFix.Fix087SKILLW.getId()) < 1)
        	{
        		DQR.bugFix.doSkillWPRecalc(ep);
        		ExtendedPlayerProperties2.get(ep).setBugFixFlg(EnumDqmBugFix.Fix087SKILLW.getId(), 1);
        	}
        }
    }

	@SubscribeEvent
	public void onEntityItemPickupEvent(EntityItemPickupEvent event)
	{
		//System.out.println("TESSSSST");
		if(event.item.getEntityItem() != null && (event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal ||
												  event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal5 ||
												  event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal10 ||
												  event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal50 ||
												  event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal100
												 ))
		{

			int plusMedal = 0;
			EntityPlayer ep = event.entityPlayer;

			int stackVal = event.item.getEntityItem().stackSize;
			if(event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal)
			{
				plusMedal = 1 * stackVal;
			}else if(event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal5)
			{
				plusMedal = 5 * stackVal;
			}else if(event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal10)
			{
				plusMedal = 10 * stackVal;
			}else if(event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal50)
			{
				plusMedal = 50 * stackVal;
			}else if(event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal100)
			{
				plusMedal = 100 * stackVal;
			}else if(event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal500)
			{
				plusMedal = 500 * stackVal;
			}else if(event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal1000)
			{
				plusMedal = 1000 * stackVal;
			}

			//String sev = !ep.worldObj.isRemote?"Server":"CLIENT";
			//System.out.println("DEBUG" + sev + ":" + plusMedal);
			ExtendedPlayerProperties.get(ep).setMedal(ExtendedPlayerProperties.get(ep).getMedal() + plusMedal);
			//ep.inventory.markDirty();
			if(!ep.worldObj.isRemote) ep.worldObj.playSoundAtEntity(ep, "dqr:player.medal", 0.5F, 1.0F);

			/*
            if (event.item.delayBeforeCanPickup <= 0 && (event.getResult() == Result.ALLOW || ep.inventory.addItemStackToInventory(null)))
            {

                FMLCommonHandler.instance().firePlayerItemPickupEvent(ep, null);
            }*/
            //event.item.getEntityItem().stackSize = 0;
			event.item.setDead();
			ExtendedPlayerProperties.get(ep).loadProxyData(ep);
			//System.out.println("MEDAL" + ExtendedPlayerProperties.get(ep).getMedal());
			//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties(ep), (EntityPlayerMP)ep);
			//event.item.getDataWatcher().setObjectWatched(10);
			//FMLCommonHandler.instance().firePlayerItemPickupEvent(ep, event.item);
			event.setCanceled(true);

		}
	}

	@SubscribeEvent
	public void onEntityInteractEvent(EntityInteractEvent event)
	{
		if(DQR.debug > 0 && event.target != null && event.target instanceof DqmPetBase)
		{
			EntityPlayer ep = event.entityPlayer;
			if(ep.isSneaking() && ep.inventory.getCurrentItem() != null && ep.inventory.getCurrentItem().getItem() instanceof DqmItemDebugBase)
			{
				DqmPetBase mob = (DqmPetBase)event.target;
				mob.setPositionAndUpdate(10000.0D, 10.0D, 10000.0D);
			}
		}

		if(event.target != null && event.target instanceof EntityPlayer)
		{
			EntityPlayer targetEp = (EntityPlayer)event.target;
			EntityPlayer ep = event.entityPlayer;

			if(ep.isSneaking())
			{
				if(ep.inventory.getCurrentItem() != null && ep.inventory.getCurrentItem().getItem() instanceof DqmItemLittlemedal)
				{
					int plusMedal = 0;

					int stackVal = ep.inventory.getCurrentItem().stackSize;
					Item medal = ep.inventory.getCurrentItem().getItem();
					if(medal == DQMiscs.itemLittlemedal)
					{
						plusMedal = 1;
					}else if(medal == DQMiscs.itemLittlemedal5)
					{
						plusMedal = 5;
					}else if(medal == DQMiscs.itemLittlemedal10)
					{
						plusMedal = 10;
					}else if(medal == DQMiscs.itemLittlemedal50)
					{
						plusMedal = 50;
					}else if(medal == DQMiscs.itemLittlemedal100)
					{
						plusMedal = 100;
					}else if(medal == DQMiscs.itemLittlemedal500)
					{
						plusMedal = 500;
					}else if(medal == DQMiscs.itemLittlemedal1000)
					{
						plusMedal = 1000;
					}

					if(!targetEp.worldObj.isRemote) targetEp.worldObj.playSoundAtEntity(targetEp, "dqr:player.medal", 0.5F, 1.0F);

					ExtendedPlayerProperties.get(targetEp).setMedal(ExtendedPlayerProperties.get(targetEp).getMedal() + plusMedal);
					ep.inventory.getCurrentItem().stackSize = ep.inventory.getCurrentItem().stackSize - 1;
				}
			}
		}
	}
}
