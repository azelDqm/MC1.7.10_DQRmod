package dqr.addons;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import shift.sextiarysector.SSItems;
import shift.sextiarysector.SSPotions;
import shift.sextiarysector.api.SextiarySectorAPI;
import shift.sextiarysector.api.event.PlayerEatenEvent;
import shift.sextiarysector.api.event.player.PlayerMoistureEvent;
import shift.sextiarysector.api.event.player.PlayerStaminaEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dqr.api.Blocks.DQPlants;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQSeeds;
import dqr.api.event.DqmLvUpEvent;
import dqr.api.event.DqrBedEvent;
import dqr.api.event.DqrFarmMGTEvent;
import dqr.entity.petEntity.DqmPetBase;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.playerData.ExtendedPlayerProperties;

public class DqrAddonSextiarySector2 {

	public DqrAddonSextiarySector2()
	{
		//this.addRecipes();
	}

	public void addRecipes(){
        GameRegistry.addRecipe(new ItemStack(DQPlants.BlockWaterBlockLight), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', SSItems.yellowStoneDust, 'B', DQPlants.BlockWaterBlock
                });

        GameRegistry.addRecipe(new ItemStack(DQPlants.BlockWaterBlock), new Object[]
                {
                    "AAA",
                    "ABA",
                    "AAA",
                    'A', SSItems.blueStoneDust, 'B', DQIngots.itemKoorinokessyou
                });
	}
	@SubscribeEvent
    public void onPotionCalc(LivingUpdateEvent event) {
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer pl = (EntityPlayer)event.entityLiving;
			PotionEffect pe = null;

			pe = pl.getActivePotionEffect(SSPotions.hotSprings);
			if(pe != null && pe.getDuration() > 0)
			{
    			if(pl.ticksExisted % 10 == 0)
    			{
	    			int mp = ExtendedPlayerProperties.get(pl).getMP();
	    			if(ExtendedPlayerProperties.get(pl).getMaxMP() > mp)
	    			{
		    			ExtendedPlayerProperties.get(pl).setMP(mp + 1);
	    			}

					if(pl.getHealth() < pl.getMaxHealth())
					{
						pl.heal(1);
					}
    			}
			}
		}else if(event.entityLiving instanceof DqmPetBase)
		{
			DqmPetBase pl = (DqmPetBase)event.entityLiving;
			PotionEffect pe = null;

			pe = pl.getActivePotionEffect(SSPotions.hotSprings);
			if(pe != null && pe.getDuration() > 0)
			{
    			if(pl.ticksExisted % 10 == 0)
    			{
	    			int mp = pl.getMP();
	    			if(pl.getMaxMP() > mp)
	    			{
	    				pl.setMP(mp + 1);
	    			}

					if(pl.getHealth() < pl.getMaxHealth())
					{
						pl.heal(1);
					}
    			}
			}
		}
	}

	@SubscribeEvent
	public void onMoistureExhaustionEvent(PlayerMoistureEvent.Exhaustion event) {

    	InventorySubEquip inventory = new InventorySubEquip(event.entityPlayer);
    	inventory.openInventory();

		if(inventory.hasPiasu(DQAccessories.itemSuraimupiasu) != -1)
		{
			event.setCanceled(true);
			return;
		}


	}
	@SubscribeEvent
	public void onMGTPostPlowEvent(DqrFarmMGTEvent.PostPlow event) {

		if(event.ep.isSneaking())
		{
			Item item = SSItems.diamondScoop;
			item.onItemUse(new ItemStack(item, 1), event.ep, event.ep.worldObj, event.blockX, event.blockY, event.blockZ, event.blockFace, event.float1, event.float2, event.float3);
		}
	}

	@SubscribeEvent
	public void onMoistureExhaustionEvent(PlayerStaminaEvent.Exhaustion event) {
    	InventorySubEquip inventory = new InventorySubEquip(event.entityPlayer);
    	inventory.openInventory();

		if(inventory.hasYubiwa(DQAccessories.itemHaraherazuYubiwa) != -1)
		{
			event.setCanceled(true);
			return;
		}else if(inventory.hasYubiwa(DQAccessories.itemHaramotiYubiwa) != -1)
		{
			Random rand = new Random();
			if(rand.nextInt(2) == 0)
			{
				event.setCanceled(true);
				return;
			}
		}
	}

	@SubscribeEvent
	public void onPlayerEatenEvent(PlayerEatenEvent event) {

		Random rand = new Random();
		ItemStack food = event.food;

		EntityPlayer player = (EntityPlayer) event.entity;

		if (food.getItem() == DQSeeds.itemTokuyakusou)
	    {
	      SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.5F);
	      SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 3.0F);
	    }

		if (food.getItem() == DQSeeds.itemJouyakusou)
	    {
	      SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.5F);
	      SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 3.0F);
	    }

		//薬草
		if (food.getItem() == DQSeeds.itemYakusou) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.5f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 2);
		}

		if (food.getItem() == DQSeeds.itemYakusou2) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.6f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 40, 3);
		}

		if (food.getItem() == DQSeeds.itemYakusou3) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 2, 0.5f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 40, 3);
		}

		//毒消し薬
		if (food.getItem() == DQSeeds.itemDokukesisou) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.4f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 20, 2);
		}

		if (food.getItem() == DQSeeds.itemDokukesisou2) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.4f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 20, 3);
		}

		if (food.getItem() == DQSeeds.itemDokukesisou3) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.4f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 2);
		}

		//力の種
		if (food.getItem() == DQSeeds.itemTikaranotane) {
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 8);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 50, 2);
		}

		if (food.getItem() == DQSeeds.itemTikaranotane2) {
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 12);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 50, 3);
		}

		if (food.getItem() == DQSeeds.itemTikaranotane3) {
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 16);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 60, 4);
		}

		//守りの種
		if (food.getItem() == DQSeeds.itemMamorinotane) {

			SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.2f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 2);
		}

		if (food.getItem() == DQSeeds.itemMamorinotane2) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.3f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 2);
		}

		if (food.getItem() == DQSeeds.itemMamorinotane3) {

			SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.4f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 40, 2);
		}

		//素早さの種
		if (food.getItem() == DQSeeds.itemSubayasanotane) {

			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 8);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 20, 2);
		}

		if (food.getItem() == DQSeeds.itemSubayasanotane2) {

			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 12);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 20, 3);
		}

		if (food.getItem() == DQSeeds.itemSubayasanotane3) {

			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 16);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 3);
		}

		//癒しの実
		if (food.getItem() == DQSeeds.itemIyasinomi) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 4, 0.6f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 2);
		}

		if (food.getItem() == DQSeeds.itemIyasinomi2) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 6, 0.7f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 3);
		}

		if (food.getItem() == DQSeeds.itemIyasinomi3) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 8, 0.8f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 3);
		}

		//炎の実
		if (food.getItem() == DQSeeds.itemHonoonomi) {

			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 16.0f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 20, 2);
		}

		if (food.getItem() == DQSeeds.itemHonoonomi2) {
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 20.0f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 2);
		}

		if (food.getItem() == DQSeeds.itemHonoonomi3) {
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 24.0f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 40, 2);
		}

		//魔法の実
		if (food.getItem() == DQSeeds.itemMahounomiI) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 2, 0.4f);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 8);
		}

		if (food.getItem() == DQSeeds.itemMahounomiI2) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 2, 0.4f);
			//SextiarySectorAPI.playerManager.addStaminaStats(player, 1, 2);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 12);
		}

		if (food.getItem() == DQSeeds.itemMahounomiI3) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 3, 0.5f);
			//SextiarySectorAPI.playerManager.addStaminaStats(player, 2, 2);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 16);
		}

		//魔力の実
		if (food.getItem() == DQSeeds.itemMaryokunotaneI) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 7, 0.7f);
			//SextiarySectorAPI.playerManager.addStaminaStats(player, 2, 2);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 12);
		}

		if (food.getItem() == DQSeeds.itemMaryokunotaneI2) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 7, 0.7f);
			//SextiarySectorAPI.playerManager.addStaminaStats(player, 2, 2);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 16);
		}

		if (food.getItem() == DQSeeds.itemMaryokunotaneI3) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 7, 0.7f);
			//SextiarySectorAPI.playerManager.addStaminaStats(player, 2, 2);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		//黄金の実
		if (food.getItem() == DQSeeds.itemOugon) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 8, 0.4f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 40, 2);
		}

		if (food.getItem() == DQSeeds.itemOugon2) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 12, 0.6f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 50, 3);
		}

		if (food.getItem() == DQSeeds.itemOugon3) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 16, 0.6f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 60, 3);
		}

		if (food.getItem() == DQSeeds.itemOugon4) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
		}




		if (food.getItem() == DQMiscs.itemHebinonukegara) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 16.0f);

			SextiarySectorAPI.playerManager.addStaminaStats(player, 20, 3);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemHananomitu) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 4, 0.4f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemHonehone) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 12.0f);

			SextiarySectorAPI.playerManager.addStaminaStats(player, 15, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemMadarakumonoito) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 4, 0.3f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			SextiarySectorAPI.playerManager.addStaminaStats(player, 10, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemMidorinokoke) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 2, 0.4f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 4);
		}

		if (food.getItem() == DQMiscs.itemNebanebazeri) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 6, 0.5f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 0, 4);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 4);
		}

		if (food.getItem() == DQMiscs.itemNekozuna) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 12.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemSuraimuzeri) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 5, 0.5f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemTyounohane) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 16.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemKazekirinohane) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 1, 0.5f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemKyodaihigetokage) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 6, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 24.0f);

			SextiarySectorAPI.playerManager.addStaminaStats(player, 40, 3);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemTogetogenokiba) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 24.0f);

			SextiarySectorAPI.playerManager.addStaminaStats(player, 30, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemUruwasikinoko) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 8, 0.6f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 8);
		}

		if (food.getItem() == DQMiscs.itemYogoretahoutai) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 16.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemAyasiikobin) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, rand.nextInt(10) + 4, 0.6f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			SextiarySectorAPI.playerManager.addStaminaStats(player, rand.nextInt(40) + 1, 66);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemMaryokunotuti) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 24.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemSeijanohai) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 24.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemAmatuyunoito) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 12, 0.6f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			SextiarySectorAPI.playerManager.addStaminaStats(player, 10, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemTensinosoma) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 10, 0.5f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}

		if (food.getItem() == DQMiscs.itemRyuunohizake) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.7f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			SextiarySectorAPI.playerManager.addStaminaStats(player, 20, 4);
			//SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 20);
		}




		if (food.getItem() == DQMiscs.itemKenjanoseisui) {
			SextiarySectorAPI.playerManager.addMoistureStats(player, 8, 0.6f);
			//SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 18.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 8);
		}

		if (food.getItem() == DQIngots.itemHosinokakera) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 4, 0.6f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 8.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 4);
		}

		if (food.getItem() == DQIngots.itemMigakizuna) {
			//SextiarySectorAPI.playerManager.addMoistureStats(player, 18, 0.8f);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(player, 8.0f);

			//SextiarySectorAPI.playerManager.addStaminaStats(player, 70, 4);
			SextiarySectorAPI.playerManager.addStaminaExhaustion(player, 8);
		}
	}

	@SubscribeEvent
	public void onLevelUpEvent(DqmLvUpEvent event) {
		/*
		int stamina = EntityPlayerManager.getCustomPlayerData(event.player).getStamina().getStaminaLevel();

		if(stamina > 0 && stamina <= 100)
		{
			SextiarySectorAPI.playerManager.addStaminaExhaustion(event.player, stamina);
		}
		*/
		SextiarySectorAPI.playerManager.addStaminaStats(event.player, 100, 4);
	}

	@SubscribeEvent
	public void onDqmBedEvent(DqrBedEvent event) {
		/*
		int stamina = EntityPlayerManager.getCustomPlayerData(event.player).getStamina().getStaminaLevel();

		if(stamina > 0)
		{
			SextiarySectorAPI.playerManager.addStaminaExhaustion(event.player, stamina);
		}
		*/
		if(event.timing == 3)
		{
			SextiarySectorAPI.playerManager.addStaminaStats(event.player, 100, 4);
			SextiarySectorAPI.playerManager.addMoistureExhaustion(event.player, 12.0F);
		}
	}
}
