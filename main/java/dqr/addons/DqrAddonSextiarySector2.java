package dqr.addons;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import shift.sextiarysector.api.SextiarySectorAPI;
import shift.sextiarysector.api.event.PlayerEatenEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.api.Items.DQIngots;
import dqr.api.Items.DQMiscs;
import dqr.api.Items.DQSeeds;
import dqr.api.event.DqmLvUpEvent;
import dqr.api.event.DqrBedEvent;

public class DqrAddonSextiarySector2 {


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
