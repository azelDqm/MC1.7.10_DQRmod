package dqr.items.base;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import dqr.DQR;
import dqr.api.event.DqrMagicCoolTimeEvent;

public class DqmItemMagicToolBase  extends Item{

    @Override
    public void onUpdate(ItemStack var1, World var2, Entity var3, int par4, boolean par5)
    {
		DqrMagicCoolTimeEvent event = new DqrMagicCoolTimeEvent.preCoolTimeDecrease(var1, var2, var3, par4, par5, null);
		event.setCanceled(false);
		MinecraftForge.EVENT_BUS.post(event);

		if(event.isCanceled())
		{
			return;
		}

    	if(var1.getItemDamage() < 0)
    	{

    	}else if(var1.getItemDamage() > 0)
    	{
    		int lastItemDamage = var1.getItemDamage();
    		int fixItemDamage = 0;

    		if(DQR.conf.bug_magicCoolTimeFix == 0)
	    	{
        		fixItemDamage = 5;
        		DqrMagicCoolTimeEvent.calcCoolTimeDecrease event2 = new DqrMagicCoolTimeEvent.calcCoolTimeDecrease(var1, var2, var3, par4, par5, null, fixItemDamage);
    			event.setCanceled(false);
    			MinecraftForge.EVENT_BUS.post(event2);

    			fixItemDamage = event2.getFixDamage();

	    		if(var1.getItemDamage() - fixItemDamage > 0)
	    		{
	    			var1.setItemDamage(var1.getItemDamage() - fixItemDamage);
	    		}else
	    		{
	    			var1.setItemDamage(0);
	    		}
	    	}else
	    	{
	    		if(var2.getWorldTime() % 5 == 0)
	    		{
	        		fixItemDamage = 2;
	        		DqrMagicCoolTimeEvent.calcCoolTimeDecrease event2 = new DqrMagicCoolTimeEvent.calcCoolTimeDecrease(var1, var2, var3, par4, par5, null, fixItemDamage);
	    			event.setCanceled(false);
	    			MinecraftForge.EVENT_BUS.post(event2);

	    			fixItemDamage = event2.getFixDamage();

		    		if(var1.getItemDamage() - fixItemDamage <= 0)
		    		{
		    			var1.setItemDamage(0);
		    		}else
		    		{
		    			var1.setItemDamage(var1.getItemDamage() - fixItemDamage);
		    		}
	    		}
	    	}

    	}

    }
}








