package dqr.items;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import dqr.api.Items.DQBuilders;

public class DqmItemRecipeBuilder {

	public DqmItemRecipeBuilder()
	{

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderDama , 1), new Object[]
                {
                    "ABC",
                    "DEF",
                    "GHI",
                    'A', DQBuilders.itemBuilderDama1, 'B', DQBuilders.itemBuilderDama2, 'C', DQBuilders.itemBuilderDama3,
                    'D', DQBuilders.itemBuilderDama4, 'E', DQBuilders.itemBuilderDama5, 'F', DQBuilders.itemBuilderDama6,
                    'G', DQBuilders.itemBuilderDama7, 'H', DQBuilders.itemBuilderDama8, 'I', DQBuilders.itemBuilderDama9
                });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderDamaS , 1), new Object[]
                {
                    "ABC",
                    "DEF",
                    "GHI",
                    'A', DQBuilders.itemBuilderDamaS1, 'B', DQBuilders.itemBuilderDamaS2, 'C', DQBuilders.itemBuilderDamaS3,
                    'D', DQBuilders.itemBuilderDamaS4, 'E', DQBuilders.itemBuilderDamaS5, 'F', DQBuilders.itemBuilderDamaS6,
                    'G', DQBuilders.itemBuilderDamaS7, 'H', DQBuilders.itemBuilderDamaS8, 'I', DQBuilders.itemBuilderDamaS9
                });

        GameRegistry.addRecipe(new ItemStack(DQBuilders.itemBuilderDamaW , 1), new Object[]
                {
                    "ABC",
                    "DEF",
                    "GHI",
                    'A', DQBuilders.itemBuilderDamaW1, 'B', DQBuilders.itemBuilderDamaW2, 'C', DQBuilders.itemBuilderDamaW3,
                    'D', DQBuilders.itemBuilderDamaW4, 'E', DQBuilders.itemBuilderDamaW5, 'F', DQBuilders.itemBuilderDamaW6,
                    'G', DQBuilders.itemBuilderDamaW7, 'H', DQBuilders.itemBuilderDamaW8, 'I', DQBuilders.itemBuilderDamaW9
                });

	}
}
