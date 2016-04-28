package dqr.entity.villagerEntity.villager;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class DqmVillagerBukiya implements IVillageTradeHandler {

	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) {
		/*
		 * 今回新しく作成した職業用の取引内容を登録します
		 * 既存の職業に取引を追加したりもできます
		 */
		//if(villager.getProfession() == AddTrade.sampleVillagerProfession) {
			/*
			 * エメラルド１個を村人に売って金のリンゴを１個買う取引を登録
			 */
			recipeList.add(new MerchantRecipe( new ItemStack(Items.emerald, 1, 0), Items.golden_apple));

			/*
			 * ブレイズロッド１個を村人に売ってエメラルド２個を買う取引を登録
			 */
			recipeList.add(new MerchantRecipe( new ItemStack(Items.blaze_rod), new ItemStack(Items.emerald, 2, 0)));
		//}
	}
}
