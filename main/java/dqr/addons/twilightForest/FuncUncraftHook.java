package dqr.addons.twilightForest;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import dqr.DQR;

public class FuncUncraftHook {

	public FuncUncraftHook(){}

	public IRecipe hookTFUncraft(ItemStack inputStack)
	{


		if (inputStack != null)
		{
			if(DQR.addons.funcUncraft.isRejectUncraftItem(inputStack.getItem()))return null;

			for (Object recipe1 : CraftingManager.getInstance().getRecipeList())
			{
				if(recipe1 instanceof IRecipe)
				{
					IRecipe recipe2 = (IRecipe)recipe1;
					if ((((recipe2 instanceof ShapedRecipes)) || ((recipe2 instanceof ShapedRecipes))) &&
						(recipe2.getRecipeOutput().getItem() == inputStack.getItem()) && (inputStack.stackSize >= recipe2.getRecipeOutput().stackSize) && (
						(!recipe2.getRecipeOutput().getHasSubtypes()) || (recipe2.getRecipeOutput().getItemDamage() == inputStack.getItemDamage())))
					{
						return recipe2;
					}
				}
			}
		}

		return null;
	}
}
