package dqr.handler;

import java.util.Random;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.Items.DQArmors;
import dqr.api.enums.EnumDqmFishingCateg;
import dqr.api.enums.EnumDqmFishingRate;
import dqr.api.event.DqrEntityFishHookEvent;

public class FishHookHandler {

	@SubscribeEvent
	public void onEntityFishHookEvent3(DqrEntityFishHookEvent.hookDqrFunc_146033_f event)
	{
		//System.out.println("Fishing!!!!!!!!!2222");

		ItemStack setItem = getRandomItem(event.rodType);
		event.setHitItem(setItem);

	}

	@SubscribeEvent
	public void onEntityFishHookEvent(DqrEntityFishHookEvent.hookGetRandomFishable event)
	{
		if(DQR.conf.fishingMode == 1)
		{
			ItemStack setItem = getRandomItem(Items.fishing_rod);
			event.setHitItem(setItem);
		}
	}

	@SubscribeEvent
	public void onEntityFishHookEvent2(DqrEntityFishHookEvent.hookFunc_146033_f event)
	{
		if(DQR.conf.fishingMode == 2)
		{
			ItemStack setItem = getRandomItem(event.rodType);
			event.setHitItem(setItem);
		}
	}

	public ItemStack getRandomItem(Item par1)
	{
		ItemStack setItem = null;
		Random rand = new Random();
		EnumDqmFishingCateg fishCateg = DQR.enumGetter.getFishingCategFromRandom(par1);

		if(fishCateg != null && fishCateg != EnumDqmFishingCateg.VANILLA_FISH)
		{
			EnumDqmFishingRate fishRate = DQR.enumGetter.getFishingRateFromRodType(par1);

			if(rand.nextInt(600) != 0)
			{
				if(fishCateg == EnumDqmFishingCateg.DQWEAPON)
				{
					int val2 = rand.nextInt(fishRate.getWeaponTotal());
					if(val2 < fishRate.getWeapon1())
					{
						setItem = DQR.randomItem.getWeaponRank1(1, 1);
					}else if(val2 < fishRate.getWeapon2())
					{
						setItem = DQR.randomItem.getWeaponRank2(1, 1);
					}else if(val2 < fishRate.getWeapon3())
					{
						setItem = DQR.randomItem.getWeaponRank3(1, 1);
					}else if(val2 < fishRate.getWeapon4())
					{
						setItem = DQR.randomItem.getWeaponRank4(1, 1);
					}else if(val2 < fishRate.getWeapon5())
					{
						setItem = DQR.randomItem.getWeaponRank5(1, 1);
					}else if(val2 < fishRate.getWeapon6())
					{
						setItem = DQR.randomItem.getWeaponRank6(1, 1);
					}else if(val2 < fishRate.getWeapon7())
					{
						setItem = DQR.randomItem.getWeaponRank7(1, 1);
					}
				}else if(fishCateg == EnumDqmFishingCateg.DQMAGIC)
				{
					int val2 = rand.nextInt(fishRate.getMagicTotal());
					if(val2 < fishRate.getMagic1())
					{
						setItem = DQR.randomItem.getMagicRank1(1, 1);
					}else if(val2 < fishRate.getMagic2())
					{
						setItem = DQR.randomItem.getMagicRank2(1, 1);
					}else if(val2 < fishRate.getMagic3())
					{
						setItem = DQR.randomItem.getMagicRank3(1, 1);
					}else if(val2 < fishRate.getMagic4())
					{
						setItem = DQR.randomItem.getMagicRank4(1, 1);
					}else if(val2 < fishRate.getMagic5())
					{
						setItem = DQR.randomItem.getMagicRankETC(1, 1);
					}else if(val2 < fishRate.getMagic6())
					{
						setItem = DQR.randomItem.getMagicRank5(1, 1);
					}else if(val2 < fishRate.getMagic7())
					{
						setItem = DQR.randomItem.getMagicRank6(1, 1);
					}
				}else if(fishCateg == EnumDqmFishingCateg.DQEMB)
				{
					int val2 = rand.nextInt(fishRate.getEmbTotal());
					if(val2 < fishRate.getEmb1())
					{
						setItem = DQR.randomItem.getEmblemRank1(1, 1);
					}else if(val2 < fishRate.getEmb2())
					{
						setItem = DQR.randomItem.getEmblemRank2(1, 1);
					}else if(val2 < fishRate.getEmb3())
					{
						setItem = DQR.randomItem.getEmblemRank3(1, 1);
					}else if(val2 < fishRate.getEmb4())
					{
						setItem = DQR.randomItem.getEmblemRankX(1, 1);
					}
				}else if(fishCateg == EnumDqmFishingCateg.DQORE)
				{
					int val2 = rand.nextInt(fishRate.getOreTotal());
					if(val2 < fishRate.getOre1())
					{
						setItem = DQR.randomItem.getIngotRank1(1, 1);
					}else if(val2 < fishRate.getOre2())
					{
						setItem = DQR.randomItem.getIngotRank2(1, 1);
					}else if(val2 < fishRate.getOre3())
					{
						setItem = DQR.randomItem.getIngotRank3(1, 1);
					}else if(val2 < fishRate.getOre4())
					{
						setItem = DQR.randomItem.getIngotRank4(1, 1);
					}else if(val2 < fishRate.getOre5())
					{
						setItem = DQR.randomItem.getIngotRank5(1, 1);
					}
				}else if(fishCateg == EnumDqmFishingCateg.DQMISC)
				{
					int val2 = rand.nextInt(fishRate.getMiscTotal());
					if(val2 < fishRate.getMisc1())
					{
						Random rand3 = new Random();
						Random rand4 = new Random();
						if(rand3.nextInt(10) == 0)
						{
							int val3 = rand4.nextInt(4);
							if(val3 == 0)
							{
								setItem = DQR.randomItem.getBuilderRank2(1, 1);
							}else
							{
								setItem = DQR.randomItem.getBuilderRank1(1, 1);
							}
						}else
						{
							setItem = DQR.randomItem.getMiscsRank1(1, 1);
						}
						//setItem = DQR.randomItem.getMiscsRank1(1, 1);
					}else if(val2 < fishRate.getMisc2())
					{
						//setItem = DQR.randomItem.getMiscsRank2(1, 1);
						Random rand3 = new Random();
						Random rand4 = new Random();
						if(rand3.nextInt(6) == 0)
						{
							int val3 = rand4.nextInt(4);
							if(val3 == 0)
							{
								setItem = DQR.randomItem.getBuilderRank3(1, 1);
							}else if(val3 == 1)
							{
								setItem = DQR.randomItem.getBuilderRank2(1, 1);
							}else
							{
								setItem = DQR.randomItem.getBuilderRank1(1, 1);
							}
						}else
						{
							setItem = DQR.randomItem.getMiscsRank2(1, 1);
						}

					}else if(val2 < fishRate.getMisc3())
					{
						setItem = DQR.randomItem.getMiscsRank3(1, 1);
					}else if(val2 < fishRate.getMisc4())
					{
						setItem = DQR.randomItem.getMiscsRank4(1, 1);
					}else if(val2 < fishRate.getMisc5())
					{
						setItem = DQR.randomItem.getMiscsRank5(1, 1);
					}else if(val2 < fishRate.getMisc6())
					{
						setItem = DQR.randomItem.getMiscsRank6(1, 1);
					}
				}
			}else
			{
				setItem = new ItemStack(DQArmors.itemSabitayoroi,1, 0);
			}
		}

		return setItem;
	}
}
