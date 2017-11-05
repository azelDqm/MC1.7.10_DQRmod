package dqr.handler;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.RegistryNamespaced;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.api.event.DqrEntityDragonEvent;

public class EnderDragonHandler {

    @SubscribeEvent
    public void onBlockDestroy(DqrEntityDragonEvent.BlockDestroyEvent event)
    {
    	RegistryNamespaced rn = Block.blockRegistry;
    	int meta = event.dragon.worldObj.getBlockMetadata(event.posX, event.posY, event.posZ);
    	if(rn.getNameForObject(event.block).indexOf("DQMIIINext") > -1)
    	{
    		event.setCanceled(true);
    	}

    	//System.out.println("ENDORA TEST : " + meta + " : " + event.block.getUnlocalizedName() + " : " + Blocks.chest.getUnlocalizedName());
    	if(event.block.getUnlocalizedName().equalsIgnoreCase(Blocks.chest.getUnlocalizedName()) && meta == 12)
    	{
    		//System.out.println("ENDORA TEST2 : cancel");
    		event.setCanceled(true);
    	}

    }
}
