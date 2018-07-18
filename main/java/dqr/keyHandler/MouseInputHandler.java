package dqr.keyHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MouseHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.MouseInputEvent;
import dqr.DQR;

public class MouseInputHandler {

    @SubscribeEvent
    public void KeyHandlingEvent(MouseInputEvent event) {
    	//event.
    	MouseHelper mh = Minecraft.getMinecraft().mouseHelper;


    	System.out.println("TEST " + mh.deltaX + " / " + mh.deltaY);

    	if(DQR.conf.guiPositionMode != 1)
    	{
    		mh.grabMouseCursor();
    	}else
    	{
    		mh.ungrabMouseCursor();
    		mh.mouseXYChange();
    	}
    }
}
