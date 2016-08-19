package dqr.keyHandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.packetMessage.MessageServerGuiId;
import dqr.packetMessage.MessageServerMGToolMode;

public class KeyInputHandler2 {
    @SubscribeEvent
    public void KeyHandlingEvent(KeyInputEvent event) {
    	if (DQR.CLKeyBind.keyMagicToolMode.isPressed()) {
    		//System.out.println("TEST");
    		//System.out.println("TEST:" + DQR.proxy.getEntityPlayerInstance().isSneaking());
    		PacketHandler.INSTANCE.sendToServer(new MessageServerMGToolMode(0));
    	}else if (DQR.CLKeyBind.keyOokinaFukuro.isPressed()) {
    		//System.out.println("TEST");
        	InventorySubEquip subEquip = new InventorySubEquip(DQR.proxy.getEntityPlayerInstance());
        	subEquip.openInventory();

        	if(subEquip != null && subEquip.getStackInSlot(12) != null)
        	{
        		PacketHandler.INSTANCE.sendToServer(new MessageServerGuiId(DQR.conf.GuiID_SubItemBag));
        	}

    	}else if (DQR.CLKeyBind.keyShieldUse.isPressed()) {
    		//System.out.println("TEST");
    		PacketHandler.INSTANCE.sendToServer(new MessageServerMGToolMode(1));
    	}
    }
}
