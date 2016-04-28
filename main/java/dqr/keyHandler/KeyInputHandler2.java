package dqr.keyHandler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.packetMessage.MessageServerMGToolMode;

public class KeyInputHandler2 {
    @SubscribeEvent
    public void KeyHandlingEvent(KeyInputEvent event) {
    	if (DQR.CLKeyBind.keyMagicToolMode.isPressed()) {
    		//System.out.println("TEST");
    		PacketHandler.INSTANCE.sendToServer(new MessageServerMGToolMode(0));
    	}
    }
}
