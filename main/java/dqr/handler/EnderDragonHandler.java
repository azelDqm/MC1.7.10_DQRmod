package dqr.handler;

import net.minecraft.block.Block;
import net.minecraft.util.RegistryNamespaced;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.api.event.DqrEntityDragonEvent;

public class EnderDragonHandler {

    @SubscribeEvent
    public void onBlockDestroy(DqrEntityDragonEvent.BlockDestroyEvent event)
    {
    	RegistryNamespaced rn = Block.blockRegistry;
    	if(rn.getNameForObject(event.block).indexOf("DQMIIINext") > -1)
    	{
    		event.setCanceled(true);
    	}
    }
}
