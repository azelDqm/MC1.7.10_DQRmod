package dqr.packetMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.RegistryNamespaced;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import dqr.DQR;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQMagicTools;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.items.base.DqmItemBowBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.items.magic.DqmItemMagicBasiRura;
import dqr.items.magic.DqmItemMagicBasiRura2;
import dqr.items.magic.DqmItemMagicBasiRuraC;
import dqr.items.magic.DqmItemMagicRura;
import dqr.items.magic.DqmItemMagicRura2;
import dqr.items.magic.DqmItemMagicRuraC;
import dqr.items.miscs.DqmItemKimera;
import dqr.items.miscs.DqmItemKimera2;
import dqr.items.miscs.DqmItemKimeraC;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties2;

public class MessageServerMGToolModeHandler implements IMessageHandler<MessageServerMGToolMode, IMessage> {

    @Override//IMessageHandlerのメソッド
    public IMessage onMessage(MessageServerMGToolMode message, MessageContext ctx) {
        //クライアントへ送った際に、EntityPlayerインスタンスはこのように取れる。
        //EntityPlayer player = DQR.proxy.getEntityPlayerInstance();
    	EntityPlayer ep = ctx.getServerHandler().playerEntity;

        int pat = message.data;

        ItemStack its = ep.inventory.getCurrentItem();

        if(pat == 0)
        {
	        if(its != null)
	        {
	        	if(its.getItem() == DQMagicTools.itemMagicToolFarm1)
	        	{
	        		int mode = ExtendedPlayerProperties2.get(ep).getTool1mode();
	        		String seedMode = "";

	        		if(mode == EnumDqmMGToolMode.MGFARM1_HOE.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool1mode(EnumDqmMGToolMode.MGFARM1_PLANT.getId());

	        		}else if(mode == EnumDqmMGToolMode.MGFARM1_PLANT.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool1mode(EnumDqmMGToolMode.MGFARM1_HARVEST.getId());
	        		}else if(mode == EnumDqmMGToolMode.MGFARM1_HARVEST.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool1mode(EnumDqmMGToolMode.MGFARM1_STORE.getId());
	        		}else if(mode == EnumDqmMGToolMode.MGFARM1_STORE.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool1mode(EnumDqmMGToolMode.MGFARM1_HOE.getId());
	        		}else
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool1mode(EnumDqmMGToolMode.MGFARM1_HOE.getId());
	        		}

	        		ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.mode." + ExtendedPlayerProperties2.get(ep).getTool1mode() + ".txt"));
	        		if(ExtendedPlayerProperties2.get(ep).getTool1mode() == EnumDqmMGToolMode.MGFARM1_PLANT.getId())
	        		{
	        			RegistryNamespaced rn = Item.itemRegistry;
	        			String selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed();
	        			if(selectSeed == null || selectSeed.equalsIgnoreCase(""))
	        			{
	        				selectSeed = "DQMIIINext:ItemYakusouSeed";
	        				ExtendedPlayerProperties2.get(ep).setSelectSeed(selectSeed);
	        			}
	        			ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
	        			int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);
	        			ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.2.txt", new Object[] {iStack.getDisplayName(), val}));
	        		}
	        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

	        	}else if(its.getItem() == DQMagicTools.itemMagicToolFarm2)
	        	{
	        		int mode = ExtendedPlayerProperties2.get(ep).getTool2mode();
	        		String selectSeed = "";

	        		if(mode == EnumDqmMGToolMode.MGFARM2_HOE.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool2mode(EnumDqmMGToolMode.MGFARM2_PLANT1.getId());

	        			RegistryNamespaced rn = Item.itemRegistry;
	        			selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed1();
	        			if(selectSeed == null || selectSeed.equalsIgnoreCase(""))
	        			{
	        				selectSeed = "DQMIIINext:ItemYakusouSeed";
	        				ExtendedPlayerProperties2.get(ep).setSelectSeed1(selectSeed);
	        			}
	        			//ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
	        			//int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);
	        			//ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.2.txt", new Object[] {iStack.getDisplayName(), val}));

	        		}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT1.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool2mode(EnumDqmMGToolMode.MGFARM2_PLANT2.getId());

	        			RegistryNamespaced rn = Item.itemRegistry;
	        			selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed2();
	        			if(selectSeed == null || selectSeed.equalsIgnoreCase(""))
	        			{
	        				selectSeed = "DQMIIINext:ItemYakusouSeed2";
	        				ExtendedPlayerProperties2.get(ep).setSelectSeed2(selectSeed);
	        			}
	        			//ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
	        			//int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);
	        			//ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.2.txt", new Object[] {iStack.getDisplayName(), val}));

	        		}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT2.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool2mode(EnumDqmMGToolMode.MGFARM2_PLANT3.getId());

	           			RegistryNamespaced rn = Item.itemRegistry;
	        			selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed3();
	        			if(selectSeed == null || selectSeed.equalsIgnoreCase(""))
	        			{
	        				selectSeed = "DQMIIINext:ItemYakusouSeed3";
	        				ExtendedPlayerProperties2.get(ep).setSelectSeed3(selectSeed);
	        			}
	        			//ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
	        			//int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);
	        			//ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.2.txt", new Object[] {iStack.getDisplayName(), val}));
	        		}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT3.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool2mode(EnumDqmMGToolMode.MGFARM2_PLANT4.getId());

	           			RegistryNamespaced rn = Item.itemRegistry;
	        			selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed4();
	        			if(selectSeed == null || selectSeed.equalsIgnoreCase(""))
	        			{
	        				selectSeed = "minecraft:wheat_seeds";
	        				ExtendedPlayerProperties2.get(ep).setSelectSeed4(selectSeed);
	        			}
	        			//ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
	        			//int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);
	        			//ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.2.txt", new Object[] {iStack.getDisplayName(), val}));
	        		}else if(mode == EnumDqmMGToolMode.MGFARM2_PLANT4.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool2mode(EnumDqmMGToolMode.MGFARM2_HARVEST.getId());
	        		}else if(mode == EnumDqmMGToolMode.MGFARM2_HARVEST.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool2mode(EnumDqmMGToolMode.MGFARM2_STORE.getId());
	        		}else if(mode == EnumDqmMGToolMode.MGFARM2_STORE.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool2mode(EnumDqmMGToolMode.MGFARM2_HOE.getId());
	        		}else
	        		{
	        			ExtendedPlayerProperties2.get(ep).setTool2mode(EnumDqmMGToolMode.MGFARM2_HOE.getId());
	        		}

	        		ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.mode." + ExtendedPlayerProperties2.get(ep).getTool2mode() + ".txt"));

	        		if((mode == EnumDqmMGToolMode.MGFARM2_PLANT1.getId() ||
	        		    mode == EnumDqmMGToolMode.MGFARM2_PLANT2.getId() ||
	        		    mode == EnumDqmMGToolMode.MGFARM2_PLANT3.getId() ||
	        		    mode == EnumDqmMGToolMode.MGFARM2_HOE.getId()) &&
	        		    !selectSeed.equalsIgnoreCase(""))
	        		{
	        			RegistryNamespaced rn = Item.itemRegistry;
	          			ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
	        			int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);
	        			ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.2.txt", new Object[] {iStack.getDisplayName(), val}));

	        		}

	        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        	}else if(its.getItem() instanceof DqmItemMagicBasiRura ||
	       			 its.getItem() instanceof DqmItemMagicBasiRura2 ||
	       			 its.getItem() instanceof DqmItemMagicBasiRuraC ||
	       			 its.getItem() == DQAccessories.itemFuujinnnotate)
	        	{
	        		//バシルーラの制御切り替え
	        		int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_BASIRURA.getId());

	        		int setIdx = 0;
	        		itemMode = itemMode + 1;

	        		if(itemMode == EnumDqmMGToolMode.BASIRURAMODE10.getId())
	        		{
	        			setIdx = EnumDqmMGToolMode.BASIRURAMODE10.getId();
	        		}else
	        		{
	        			setIdx = EnumDqmMGToolMode.BASIRURAMODE0.getId();
	        		}

	        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        		ep.addChatMessage(new ChatComponentTranslation("msg.basirura.modeInfo." + setIdx + ".txt", new Object[] {}));
	        		ExtendedPlayerProperties.get(ep).setWeaponMode(EnumDqmWeaponMode.WEAPONMODE_BASIRURA.getId(), setIdx);
	        	}else if(DQR.conf.partyEnable != 0 && its.getItem() == DQMiscs.itemShinjirukokoro)
		        {
	        		int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_SHINZIRU.getId());

	        		int setIdx = 0;
	        		//itemMode = itemMode + 1;

	        		if(itemMode == EnumDqmMGToolMode.SHINZIRU_MEMBER_ADD.getId())
	        		{
	        			setIdx = EnumDqmMGToolMode.SHINZIRU_MEMBER_KICK.getId();
	        		}else if(itemMode == EnumDqmMGToolMode.SHINZIRU_MEMBER_KICK.getId())
	        		{
	        			setIdx = EnumDqmMGToolMode.SHINZIRU_PET_KICK.getId();
	        		}else if(itemMode == EnumDqmMGToolMode.SHINZIRU_PET_KICK.getId())
	        		{
	        			setIdx = EnumDqmMGToolMode.SHINZIRU_LEAVE.getId();
	        		}else if(itemMode == EnumDqmMGToolMode.SHINZIRU_LEAVE.getId())
	        		{
	        			setIdx = EnumDqmMGToolMode.SHINZIRU_CLOSE.getId();
	        		}else
	        		{
	        			setIdx = EnumDqmMGToolMode.SHINZIRU_MEMBER_ADD.getId();
	        		}


	        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);

        			if(!ep.worldObj.isRemote)
        			{
        				ep.addChatMessage(new ChatComponentTranslation("msg.shinziru.modeInfo." + setIdx + ".0.txt", new Object[] {}));
        				ep.addChatMessage(new ChatComponentTranslation("msg.shinziru.modeInfo." + setIdx + ".1.txt", new Object[] {}));
        			}
	        		ExtendedPlayerProperties.get(ep).setWeaponMode(EnumDqmWeaponMode.WEAPONMODE_SHINZIRU.getId(), setIdx);
		        		//信じるこころ
	        		/*
		        		int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_BASIRURA.getId());

		        		int setIdx = 0;
		        		itemMode = itemMode + 1;

		        		if(itemMode == EnumDqmMGToolMode.BASIRURAMODE10.getId())
		        		{
		        			setIdx = EnumDqmMGToolMode.BASIRURAMODE10.getId();
		        		}else
		        		{
		        			setIdx = EnumDqmMGToolMode.BASIRURAMODE0.getId();
		        		}

		        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		        		ep.addChatMessage(new ChatComponentTranslation("msg.basirura.modeInfo." + setIdx + ".txt", new Object[] {}));
		        		ExtendedPlayerProperties.get(ep).setWeaponMode(EnumDqmWeaponMode.WEAPONMODE_BASIRURA.getId(), setIdx);
		        		*/
		        }else if(its.getItem() instanceof DqmItemMagicRura ||
	        			 its.getItem() instanceof DqmItemMagicRura2 ||
	        			 its.getItem() instanceof DqmItemMagicRuraC)
	        	{
	        		//ルーラの制御切り替え

	        		int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_RURA.getId());
	        		int jobLvMag = ExtendedPlayerProperties.get(ep).getJobLv(EnumDqmJob.Mahoutukai.getId());
	        		int jobLvSag = ExtendedPlayerProperties.get(ep).getJobLv(EnumDqmJob.Kenja.getId());
	        		int setIdx = 0;
	        		itemMode = itemMode + 1;

	        		if(itemMode == EnumDqmMGToolMode.RURAMODE10.getId())
	        		{
	        			setIdx = EnumDqmMGToolMode.RURAMODE10.getId();
	        		}else
	        		{
	        			setIdx = EnumDqmMGToolMode.RURAMODE0.getId();
	        		}

	        		/*
	        		}else if(itemMode == EnumDqmMGToolMode.RURAMODE25.getId())
	        		{
	        			if(jobLvMag >= 25 || jobLvSag >= 25)
	        			{
	        				setIdx = EnumDqmMGToolMode.RURAMODE25.getId();
	        			}else
	        			{
	        				setIdx = EnumDqmMGToolMode.RURAMODE0.getId();
	        			}
	        		}else if(itemMode == EnumDqmMGToolMode.RURAMODE40.getId())
	        		{
	        			if(jobLvMag >= 40 || jobLvSag >= 40)
	        			{
	        				setIdx = EnumDqmMGToolMode.RURAMODE40.getId();
	        			}else
	        			{
	        				setIdx = EnumDqmMGToolMode.RURAMODE0.getId();
	        			}
	        		}else
	        		{
	        			setIdx = EnumDqmMGToolMode.RURAMODE0.getId();
	        		}
	        		*/

	        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        		ep.addChatMessage(new ChatComponentTranslation("msg.rura.modeInfo." + setIdx + ".txt", new Object[] {}));
	        		ExtendedPlayerProperties.get(ep).setWeaponMode(EnumDqmWeaponMode.WEAPONMODE_RURA.getId(), setIdx);
	        	}else if(its.getItem() instanceof DqmItemKimera ||
	       			 its.getItem() instanceof DqmItemKimera2 ||
	       			 its.getItem() instanceof DqmItemKimeraC)
		       	{
		       		//キメラの制御切り替え

		       		int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_KIMERA.getId());
		       		int setIdx = 0;
		       		itemMode = itemMode + 1;

		       		if(itemMode == EnumDqmMGToolMode.RURAMODE10.getId())
		       		{
		       			setIdx = EnumDqmMGToolMode.RURAMODE10.getId();
		       		}else
		       		{
		       			setIdx = EnumDqmMGToolMode.RURAMODE0.getId();
		       		}
		       			/*
		       		}else if(itemMode == EnumDqmMGToolMode.RURAMODE25.getId())
		       		{
		       			if(jobLvMag >= 25 || jobLvSag >= 25)
		       			{
		       				setIdx = EnumDqmMGToolMode.RURAMODE25.getId();
		       			}else
		       			{
		       				setIdx = EnumDqmMGToolMode.RURAMODE0.getId();
		       			}
		       		}else if(itemMode == EnumDqmMGToolMode.RURAMODE40.getId())
		       		{
		       			if(jobLvMag >= 40 || jobLvSag >= 40)
		       			{
		       				setIdx = EnumDqmMGToolMode.RURAMODE40.getId();
		       			}else
		       			{
		       				setIdx = EnumDqmMGToolMode.RURAMODE0.getId();
		       			}
		       		}else
		       		{
		       			setIdx = EnumDqmMGToolMode.RURAMODE0.getId();
		       		}
		       		*/

		       		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
		       		ep.addChatMessage(new ChatComponentTranslation("msg.rura.modeInfo." + setIdx + ".txt", new Object[] {}));
		       		ExtendedPlayerProperties.get(ep).setWeaponMode(EnumDqmWeaponMode.WEAPONMODE_KIMERA.getId(), setIdx);
		       	}else if(its.getItem() instanceof DqmItemBowBase)
		       	{
	    			int idx = 0;
	    			DqmItemBowBase weapon = (DqmItemBowBase) its.getItem();

	    			if(DQR.spUseItems.specialUseItems.containsKey(weapon) && ep.isSneaking())
	    			{
	    				idx = EnumDqmWeaponMode.WEAPONMODE_ITEMUSEBOW.getId();
	    				int itemMode2 = ExtendedPlayerProperties.get(ep).getWeaponMode(idx);
		    			if(itemMode2 == 1)
		    			{
		    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, 0);
		    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon3.modeInfo.0.txt", new Object[] {}));
		    			}else
		    			{
		    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, itemMode2 + 1);
		    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon3.modeInfo." + (itemMode2 + 1) +".txt", new Object[] {}));
		    			}
		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	    				return null;
	    			}
		       	}
	        	else if(its.getItem() instanceof DqmItemWeaponBase)
	        	{
	        		DqmItemWeaponBase weapon = (DqmItemWeaponBase) its.getItem();

	        		//System.out.println("TEST" + ep.isSneaking());

	    			int idx = 0;

	    			if(DQR.spUseItems.specialUseItems.containsKey(weapon) && ep.isSneaking())
	    			{
	    				idx = EnumDqmWeaponMode.WEAPONMODE_ITEMUSE.getId();
	    				int itemMode2 = ExtendedPlayerProperties.get(ep).getWeaponMode(idx);
		    			if(itemMode2 == 1)
		    			{
		    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, 0);
		    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon2.modeInfo.0.txt", new Object[] {}));
		    			}else
		    			{
		    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, itemMode2 + 1);
		    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon2.modeInfo." + (itemMode2 + 1) +".txt", new Object[] {}));
		    			}
		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	    				return null;
	    			}

	    			if(weapon.getMaterial() == DQR.dqmMaterial.DqmAxe || weapon == DQWeapons.itemHaruberuto)
	    			{
	    				idx = EnumDqmWeaponMode.WEAPONMODE_AXE.getId();
	    			}else if(weapon.getMaterial() == DQR.dqmMaterial.DqmHammer0 || weapon.getMaterial() == DQR.dqmMaterial.DqmHammer1 || weapon.getMaterial() == DQR.dqmMaterial.DqmHammer2 || weapon.getMaterial() == DQR.dqmMaterial.DqmHammer3)
	    			{
	    				idx = EnumDqmWeaponMode.WEAPONMODE_HAMMER.getId();
	    			}else if(weapon.getMaterial() == DQR.dqmMaterial.DqmClaw)
	    			{
	    				idx = EnumDqmWeaponMode.WEAPONMODE_CLAW.getId();
	    			}

	    			if(idx != 0)
	    			{
		    			int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(idx);

		    			if(idx == EnumDqmWeaponMode.WEAPONMODE_AXE.getId())
		    			{
			    			if(itemMode == 2)
			    			{
			    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, -1);
			    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon.modeInfo." + idx + ".-1.txt", new Object[] {}));
			    			}else
			    			{
			    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, itemMode + 1);
			    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon.modeInfo." + idx + "." + (itemMode + 1) +".txt", new Object[] {}));
			    			}
		    			}else
		    			{
			    			if(itemMode == 0)
			    			{
			    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, -1);
			    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon.modeInfo." + idx + ".-1.txt", new Object[] {}));
			    			}else
			    			{
			    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, 0);
			    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon.modeInfo." + idx + ".0.txt", new Object[] {}));
			    			}
		    			}

		    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	    			}
	        	}else if(its.getItem() == DQMagicTools.itemMagicToolSet)
	        	{
	        		int mode = ExtendedPlayerProperties2.get(ep).getBlockSetMode();
	        		//String seedMode = "";

	        		if(mode == EnumDqmMGToolMode.MGSET_SET.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setBlockSetMode(EnumDqmMGToolMode.MGSET_STORE.getId());

	        		}else if(mode == EnumDqmMGToolMode.MGSET_STORE.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setBlockSetMode(EnumDqmMGToolMode.MGSET_SET.getId());
	        		}

	        		ep.addChatMessage(new ChatComponentTranslation("msg.magictool.set.mode." + ExtendedPlayerProperties2.get(ep).getBlockSetMode() + ".txt"));
	        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        	}else if(its.getItem() == DQMagicTools.itemMagicToolBreak1)
	        	{
	        		int mode = ExtendedPlayerProperties2.get(ep).getToolBreak1mode();
	        		//String seedMode = "";

	        		if(mode == EnumDqmMGToolMode.MGBREAK_BREAK.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setToolBreak1mode(EnumDqmMGToolMode.MGBREAK_DELETE.getId());

	        		}else if(mode == EnumDqmMGToolMode.MGBREAK_DELETE.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setToolBreak1mode(EnumDqmMGToolMode.MGBREAK_BREAK.getId());
	        		}

	        		if(DQR.conf.MGBreak1_enable == 1)
	        		{
	        			ExtendedPlayerProperties2.get(ep).setToolBreak1mode(EnumDqmMGToolMode.MGBREAK_BREAK.getId());
	        		}else if(DQR.conf.MGBreak1_enable == 2)
	        		{
	        			ExtendedPlayerProperties2.get(ep).setToolBreak1mode(EnumDqmMGToolMode.MGBREAK_DELETE.getId());
	        		}

	        		ep.addChatMessage(new ChatComponentTranslation("msg.magictool.break.mode." + ExtendedPlayerProperties2.get(ep).getToolBreak1mode() + ".txt"));
	        		/*
	        		if(ExtendedPlayerProperties2.get(ep).getTool1mode() == EnumDqmMGToolMode.MGFARM1_PLANT.getId())
	        		{
	        			RegistryNamespaced rn = Item.itemRegistry;
	        			String selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed();
	        			if(selectSeed == null || selectSeed.equalsIgnoreCase(""))
	        			{
	        				selectSeed = "DQMIIINext:ItemYakusouSeed";
	        				ExtendedPlayerProperties2.get(ep).setSelectSeed(selectSeed);
	        			}
	        			ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
	        			int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);
	        			ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.2.txt", new Object[] {iStack.getDisplayName(), val}));
	        		}
	        		*/
	        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        	}else if(its.getItem() == DQMagicTools.itemMagicToolBreak2)
	        	{
	        		int mode = ExtendedPlayerProperties2.get(ep).getToolBreak2mode();
	        		//String seedMode = "";

	        		if(mode == EnumDqmMGToolMode.MGBREAK_BREAK.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setToolBreak2mode(EnumDqmMGToolMode.MGBREAK_DELETE.getId());

	        		}else if(mode == EnumDqmMGToolMode.MGBREAK_DELETE.getId())
	        		{
	        			ExtendedPlayerProperties2.get(ep).setToolBreak2mode(EnumDqmMGToolMode.MGBREAK_BREAK.getId());
	        		}

	        		if(DQR.conf.MGBreak2_enable == 1)
	        		{
	        			ExtendedPlayerProperties2.get(ep).setToolBreak2mode(EnumDqmMGToolMode.MGBREAK_BREAK.getId());
	        		}else if(DQR.conf.MGBreak2_enable == 2)
	        		{
	        			ExtendedPlayerProperties2.get(ep).setToolBreak2mode(EnumDqmMGToolMode.MGBREAK_DELETE.getId());
	        		}

	        		ep.addChatMessage(new ChatComponentTranslation("msg.magictool.break.mode." + ExtendedPlayerProperties2.get(ep).getToolBreak2mode() + ".txt"));
	        		/*
	        		if(ExtendedPlayerProperties2.get(ep).getTool1mode() == EnumDqmMGToolMode.MGFARM1_PLANT.getId())
	        		{
	        			RegistryNamespaced rn = Item.itemRegistry;
	        			String selectSeed = ExtendedPlayerProperties2.get(ep).getSelectSeed();
	        			if(selectSeed == null || selectSeed.equalsIgnoreCase(""))
	        			{
	        				selectSeed = "DQMIIINext:ItemYakusouSeed";
	        				ExtendedPlayerProperties2.get(ep).setSelectSeed(selectSeed);
	        			}
	        			ItemStack iStack = new ItemStack((Item)rn.getObject(selectSeed), 1);
	        			int val = ExtendedPlayerProperties2.get(ep).getSeedVal(selectSeed);
	        			ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedPlant.2.txt", new Object[] {iStack.getDisplayName(), val}));
	        		}
	        		*/
	        		ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        	}
	        }
        }else if(pat == 1)
        {
        	//InventorySubEquip subEquip = new InventorySubEquip(DQR.proxy.getEntityPlayerInstance());
        	InventorySubEquip subEquip = new InventorySubEquip(ep);
        	subEquip.openInventory();

	    	if(subEquip != null && subEquip.getStackInSlot(11) != null)
	    	{
	    		ItemStack useitem = subEquip.getStackInSlot(11);

	    		ItemStack useitem2 = useitem.getItem().onItemRightClick(useitem, ep.worldObj, ep);
	    		//useitem2.damageItem(100, ep);
	    		subEquip.setInventorySlotContents(11, useitem2);
	    		subEquip.markDirty();
	    		subEquip.closeInventory();
	    		//subEquip.markDirty();
	    		//PacketHandler.INSTANCE.sendTo(new MessagePlayerProperties2(ep), (EntityPlayerMP)ep);

	    		//int epMP = ExtendedPlayerProperties.get(ep).getMP();
	    		//ExtendedPlayerProperties.get(ep).setMP(epMP - 20);
	    	}

        }

        //System.out.println(entityPlayer.getDisplayName() + ":" + pat);
        //ExtendedPlayerProperties.get(ep).setNpcTalk(EnumDqmNpcTalk.SINKAN.getId(), 20);


        /*
        if(ExtendedPlayerProperties.get(ep).getTabidachiFlg() != 100 ||
           ExtendedPlayerProperties.get(ep).getJobLv(0) < 50 ||
           pat != EnumDqmJob.Kenja.getId())
        {
	        if(ExtendedPlayerProperties3.get(ep).getJobPermission(pat) == 0)
	        {
	        	ep.addChatMessage(new ChatComponentTranslation("msg.Dama1.messages.24.txt" ,new Object[] {}));
	        	ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        	return null;
	        }

	        if(!DQR.jobChangeTable.getCheckJobChange(ep, pat))
	        {
	        	ep.addChatMessage(new ChatComponentTranslation("msg.Dama1.messages.25.txt" ,new Object[] {}));
	        	ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
	        	return null;
	        }
        }
		ep.worldObj.playSoundAtEntity(ep, "dqr:player.tensyoku", 1.0F, 1.0F);
        ExtendedPlayerProperties.get(ep).setJob(pat);
        ((ExtendedPlayerProperties)(ep.getExtendedProperties(ExtendedPlayerProperties.EXT_PROP_NAME))).loadProxyData((EntityPlayer)ep);

        ep.addChatMessage(new ChatComponentTranslation("msg.Dama1.messages.22.txt" ,new Object[] {EnumDqmMessageConv.JobName.getStartS() + pat + EnumDqmMessageConv.JobName.getEndS()}));
        ep.addChatMessage(new ChatComponentTranslation("msg.Dama1.messages.23.txt" ,new Object[] {}));
		*/
        //サーバーへ送った際に、EntityPlayerインスタンス（EntityPlayerMPインスタンス）はこのように取れる。
        //EntityPlayer entityPlayer = ctx.getServerHandler().playerEntity;
        //Do something.
        return null;//本来は返答用IMessageインスタンスを返すのだが、旧来のパケットの使い方をするなら必要ない。
    }
}
