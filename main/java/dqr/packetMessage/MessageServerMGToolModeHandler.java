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
import dqr.api.Items.DQMagicTools;
import dqr.api.enums.EnumDqmMGToolMode;
import dqr.items.base.DqmItemWeaponBase;
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
        	}else if(its.getItem() instanceof DqmItemWeaponBase)
        	{
        		DqmItemWeaponBase weapon = (DqmItemWeaponBase) its.getItem();

    			int idx = 0;
    			if(weapon.getMaterial() == DQR.dqmMaterial.DqmAxe)
    			{
    				idx = 1;
    			}else if(weapon.getMaterial() == DQR.dqmMaterial.DqmHammer0 || weapon.getMaterial() == DQR.dqmMaterial.DqmHammer1 || weapon.getMaterial() == DQR.dqmMaterial.DqmHammer2 || weapon.getMaterial() == DQR.dqmMaterial.DqmHammer3)
    			{
    				idx = 2;
    			}else if(weapon.getMaterial() == DQR.dqmMaterial.DqmClaw)
    			{
    				idx = 3;
    			}

    			if(idx != 0)
    			{
	    			int itemMode = ExtendedPlayerProperties.get(ep).getWeaponMode(idx);

	    			if(itemMode == 0)
	    			{
	    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, -1);
	    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon.modeInfo." + idx + ".-1.txt", new Object[] {}));
	    			}else
	    			{
	    				ExtendedPlayerProperties.get(ep).setWeaponMode(idx, 0);
	    				ep.addChatMessage(new ChatComponentTranslation("msg.weapon.modeInfo." + idx + ".0.txt", new Object[] {}));
	    			}

	    			ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
    			}
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
