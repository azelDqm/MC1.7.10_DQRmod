package dqr.items;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import dqr.api.Items.DQMiscs;

public class DqmItemRecipeEtc {

	public DqmItemRecipeEtc()
	{
        GameRegistry.addRecipe(new ItemStack(Items.name_tag , 1), new Object[]
                {
                    "AAC",
                    "AEA",
                    "AAA",
                    'A', DQMiscs.itemMajuunokawa, 'E', Items.paper, 'C', Items.string
                });
	}
}
