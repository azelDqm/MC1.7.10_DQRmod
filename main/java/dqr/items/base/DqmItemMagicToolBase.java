package dqr.items.base;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DqmItemMagicToolBase  extends Item{

    @Override
    public void onUpdate(ItemStack var1, World var2, Entity var3, int par4, boolean par5)
    {

    	if(var1.getItemDamage() < 0)
    	{

    	}else if(var1.getItemDamage() > 0)
    	{
    		if(var1.getItemDamage() - 5 > 0)
    		{
    			var1.setItemDamage(var1.getItemDamage() - 5);
    		}else
    		{
    			var1.setItemDamage(0);
    		}
    	}

    }
}
