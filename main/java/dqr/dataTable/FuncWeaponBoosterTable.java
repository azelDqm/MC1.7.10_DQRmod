package dqr.dataTable;

import java.util.LinkedHashMap;
import java.util.Map;

import net.minecraft.item.Item;
import dqr.api.Items.DQWeapons;

public class FuncWeaponBoosterTable {

	public final int DRAGON = 0;
	public final int WATER = 1;
	public final int UNDEAD = 2;
	public final int MACHINE = 3;
	public final int ELEMENT = 4;
	public final int SLIME = 5;
	public final int BUSSHITU = 6;
	public final int PLANT = 7;
	public final int BIRD = 8;
	public final int AKUMA = 9
			;

	public Map<Integer, Float> getBooster(Item handItem)
	{
		Map<Integer, Float> retMap = new LinkedHashMap();

		if(handItem == DQWeapons.itemDoragonkira)
		{
			//ドラゴン特攻
			retMap.put(DRAGON, 1.2F);
		}else if(handItem == DQWeapons.itemToraidento)
		{
			//水棲特攻
			retMap.put(WATER, 1.2F);
		}else if(handItem == DQWeapons.itemHoriransu)
		{
			//アンデッド特攻
			retMap.put(UNDEAD, 1.2F);
		}else if(handItem == DQWeapons.itemDoragonroddo)
		{
			//ドラゴン特攻
			retMap.put(DRAGON, 1.2F);
		}else if(handItem == DQWeapons.itemDoragonkuro)
		{
			//ドラゴン特攻
			retMap.put(DRAGON, 1.2F);
		}else if(handItem == DQWeapons.itemSinryuunotume)
		{
			//ドラゴン特攻
			retMap.put(DRAGON, 1.2F);
		}else if(handItem == DQWeapons.itemSinryuunotume2)
		{
			//ドラゴン特攻
			retMap.put(DRAGON, 1.2F);
		}else if(handItem == DQWeapons.itemDorirunakkuru)
		{
			//マシン特攻
			retMap.put(MACHINE, 1.2F);
		}else if(handItem == DQWeapons.itemMayokenotume)
		{
			//エレメント特攻
			retMap.put(ELEMENT, 1.2F);
		}else if(handItem == DQWeapons.itemAtorasunokanaduti)
		{
			//スライム/物質特攻
			retMap.put(BUSSHITU, 1.2F);
			retMap.put(SLIME, 1.2F);
		}else if(handItem == DQWeapons.itemFunsainooonata)
		{
			//マシン/物質特攻
			retMap.put(BUSSHITU, 1.2F);
			retMap.put(MACHINE, 1.2F);
		}else if(handItem == DQWeapons.itemTatujinnoono)
		{
			//植物特攻
			retMap.put(PLANT, 1.2F);
		}else if(handItem == DQWeapons.itemKaryuudonoyumi)
		{
			//鳥特攻
			retMap.put(BIRD, 1.2F);
		}else if(handItem == DQWeapons.itemDaitensinoyumi)
		{
			//悪魔特攻
			retMap.put(AKUMA, 1.2F);
		}else if(handItem == DQWeapons.itemSefiramunoyumi)
		{
			//悪魔特攻
			retMap.put(AKUMA, 1.2F);
		}else if(handItem == DQWeapons.itemSefiramunoyumi2)
		{
			//悪魔特攻
			retMap.put(AKUMA, 1.2F);
		}

		return retMap;
	}
}
