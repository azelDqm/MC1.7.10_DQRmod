package dqr.addons.tConstruct;

import java.lang.ref.WeakReference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class FuncDropItemsHook {
	public FuncDropItemsHook(){}

	public boolean hookTConstDropItemHook(Object val, ItemStack[] val2)
	{

		try
		{
			if(val != null && val instanceof WeakReference)
			{
				WeakReference<EntityPlayer> epTemp = (WeakReference<EntityPlayer>)val;
				if(epTemp != null && epTemp.get() instanceof EntityPlayer && val2 != null)
				{
					EntityPlayer ep = epTemp.get();
				    for (int i = 0; i < val2.length; i++) {
				        if (val2[i] != null)
				        {
				          ep.func_146097_a(val2[i], true, false);
				          val2[i] = null;
				        }
				      }
				}
			}
		}catch(Exception e)
		{
			System.out.println("TconDropErro!! : " + e.getMessage());
			e.printStackTrace();
		}

		return true;
	}
}
