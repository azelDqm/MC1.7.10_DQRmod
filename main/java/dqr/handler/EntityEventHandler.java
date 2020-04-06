package dqr.handler;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmBugFix;
import dqr.gui.itemBag.InventoryItemBag;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.items.base.DqmItemFukuroBase;
import dqr.items.miscs.DqmItemLittlemedal;
import dqr.packetMessage.MessageClientSound;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties2;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.ExtendedPlayerProperties6;

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

        if(DQR.bugFixFlg0947_8 == 1)
        {
	        if (!event.player.worldObj.isRemote && event.player instanceof EntityPlayer)
	        {
	        	EntityPlayer ep = (EntityPlayer)event.player;
	        	if(ExtendedPlayerProperties2.get(ep).getBugFixFlg(EnumDqmBugFix.Fix09478PetDataCopy.getId()) < 1)
	        	{
	        		//t4vqu38tvuqputvutvouu
	        		/*ここで、ペットデータをEPP6にコピー＆旧データを削除*/
	        		/*初回起動時に、ペットデータを取得できてるかの検証後処理追加*/
	        		NBTTagCompound petData = ExtendedPlayerProperties3.get(ep).getFixNBTPlayerPetList();
	        		if(petData == null)
	        		{
	        			petData = new NBTTagCompound();
	        		}
	        		ExtendedPlayerProperties6.get(ep).setNBTPlayerPetList(petData);
	        		ExtendedPlayerProperties3.get(ep).setFixNBTPlayerPetList();

	        		ExtendedPlayerProperties2.get(ep).setBugFixFlg(EnumDqmBugFix.Fix09478PetDataCopy.getId(), 1);
	        	}
	        }
        }
    }

	@SubscribeEvent(priority=EventPriority.LOWEST)
	public void onEntityItemPickupEvent(EntityItemPickupEvent event)
	{
		EntityPlayer ep = event.entityPlayer;

		//System.out.println("TESSSSST");
		if(event.item.getEntityItem() != null && (event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal ||
												  event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal5 ||
												  event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal10 ||
												  event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal50 ||
												  event.item.getEntityItem().getItem() == DQMiscs.itemLittlemedal100
												 ))
		{

			int plusMedal = 0;

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

			return;
		}

		if(event.item.getEntityItem() != null && !(event.item.getEntityItem().getItem() instanceof DqmItemFukuroBase) && !ExtendedPlayerProperties2.get(ep).getFukuroOpen())
		{

			if(this.checkBagIn(event.item.getEntityItem()))
			{
		    	InventorySubEquip subEquip = new InventorySubEquip(ep);
		    	subEquip.openInventory();

		    	if(subEquip != null && subEquip.getStackInSlot(12) != null)
		    	{
		    		ItemStack bag = subEquip.getStackInSlot(12);
		    		InventoryItemBag bagInventory = new InventoryItemBag(ep.inventory, bag);
		    		bagInventory.openInventory();

		    		if(event.item.getEntityItem() != null && bagInventory.addItemStackToInventory(event.item.getEntityItem()))
		    		{
		    			Random rand = new Random();
		    			bagInventory.markDirty();
		        		bagInventory.closeInventory2(subEquip);

		        		if(!ep.worldObj.isRemote) ep.worldObj.playSoundAtEntity(ep, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
		            	//ep.worldObj.playSoundAtEntity(ep, "random.pop", 0.2F, ((rand.nextFloat() - rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
		            	PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)3), (EntityPlayerMP)ep);

		    			event.item.setDead();
		    			event.setCanceled(true);
		    			return;
		    		}
		    		bagInventory.markDirty();
		    		bagInventory.closeInventory2(subEquip);

		    	}
			}
		}

	}

	@SubscribeEvent
	public void onEntityInteractEvent(EntityInteractEvent event)
	{
		/*
		if(DQR.debug > 0 && event.target != null && event.target instanceof DqmPetBase)
		{
			EntityPlayer ep = event.entityPlayer;
			if(ep.isSneaking() && ep.inventory.getCurrentItem() != null && ep.inventory.getCurrentItem().getItem() instanceof DqmItemDebugBase)
			{
				DqmPetBase mob = (DqmPetBase)event.target;
				mob.setPositionAndUpdate(10000.0D, 10.0D, 10000.0D);
			}
		}
		*/

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

	public boolean checkBagIn(ItemStack stack)
	{
		boolean ret = true;

		if(stack != null)
		{
			if(stack.getTagCompound() != null)
			{
				//System.out.println("TEST?????2 : ");
				NBTTagCompound nbt = stack.getTagCompound();

				Set set = nbt.func_150296_c();
				for (Iterator itr = set.iterator(); itr.hasNext();)
				{
					Object obj = itr.next();
					//System.out.println("TEST????? : " + (obj instanceof String));
					if(obj instanceof String && ((String)obj).equalsIgnoreCase("Items"))
					{
						//System.out.println("TEST?????5 : ");
						return false;
					}
				}
				//System.out.println("TEST?????4 : ");
				if(nbt != null && nbt.func_150296_c().size() > DQR.conf.fukuroLimitTagCount && DQR.conf.fukuroLimitTagCount > 0)
				{
					//System.out.println("LINT1");
					return false;
				}


			}


	    	RegistryNamespaced rnb = Block.blockRegistry;
	    	RegistryNamespaced rni = Item.itemRegistry;

//	    	System.out.println("LINT1" + rni.getNameForObject(stack.getItem()));
	    	for(int cnt = 0; cnt < DQR.conf.fukuroRejectItems.length; cnt++)
	    	{
	    		try
	    		{
	    			Block blc = (Block)rnb.getObject(DQR.conf.fukuroRejectItems[cnt].trim().replace(" ", ""));

	    			if(blc != null)
	    			{
	    				if(stack.getItem() == Item.getItemFromBlock(blc))
	    				{
	    					return false;
	    				}
	    			}
	    		}catch (Exception e){}
	    	}

	    	for(int cnt = 0; cnt < DQR.conf.fukuroRejectItems.length; cnt++)
	    	{
	    		try
	    		{
	    			Item itm = (Item)rni.getObject(DQR.conf.fukuroRejectItems[cnt].trim().replace(" ", ""));
	    			//System.out.println("LINT2");
	    			if(itm != null)
	    			{
	    				if(stack.getItem() == itm)
	    				{
	    					//System.out.println("LINT3");
	    					return false;
	    				}
	    			}
	    		}catch (Exception e){}
	    	}
		}

		return ret;

	}
}
