package dqr.addons.twilightForest.coreHook;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;
import dqr.DQR;

public class FuncUncraftHook {

	public FuncUncraftHook(){}

	public IRecipe hookTFUncraft(ItemStack inputStack)
	{

		//if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST 1");
		if (inputStack != null)
		{
			//if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST 2 : " + inputStack.getItem().getUnlocalizedName());
			if(DQR.addons.funcUncraft.isRejectUncraftItem(inputStack.getItem()))return null;

			//if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST 3");
			for (Object recipe1 : CraftingManager.getInstance().getRecipeList())
			{
				//if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST 4");
				if(recipe1 instanceof IRecipe)
				{
					//if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST 5");
					IRecipe recipe2 = (IRecipe)recipe1;
					if ((((recipe2 instanceof ShapedRecipes)) || ((recipe2 instanceof ShapedOreRecipe))) &&
						(recipe2.getRecipeOutput().getItem() == inputStack.getItem()) && (inputStack.stackSize >= recipe2.getRecipeOutput().stackSize) && (
						(!recipe2.getRecipeOutput().getHasSubtypes()) || (recipe2.getRecipeOutput().getItemDamage() == inputStack.getItemDamage())))
					{
						if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST 6 : " + inputStack.getItem().getUnlocalizedName());
						return recipe2;
					}
				}
			}
			//if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST 7 : " + inputStack.getItem().getUnlocalizedName());
		}
		//if(DQR.debug == 2)System.out.println("TF_UNCRAFT_TEST 8");

		return null;
	}
}
