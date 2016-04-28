package dqr.handler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import scala.util.Random;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.api.enums.EnumDqmEndoraParam;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.items.base.DqmItemBowBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DamagetHandler {

	Random rand = new Random();

	@SubscribeEvent
	public void onLivingHurtEvent(LivingHurtEvent event) {

		int varDifficulty = DQR.conf.DqmEndoraDifficulty == -1 ? DQR.conf.DqmDifficulty : DQR.conf.DqmEndoraDifficulty;
		EnumDqmEndoraParam enumEndora = DQR.enumGetter.getEndoraParam(varDifficulty);


		if(event.source.getEntity() != null){
			if(event.source.getEntity() instanceof EntityDragon)
			{

				if(varDifficulty > 6)
				{
					event.ammount = event.ammount * (enumEndora.getAttack() + (10 * (varDifficulty - 6)));
				}else
				{
					event.ammount = event.ammount * enumEndora.getAttack();
				}
			}else if(event.source.getEntity() instanceof EntityWither)
			{
				event.ammount = event.ammount * 50;
			}else if(event.source.getEntity() instanceof EntityPlayer)
			{
				event.ammount = ExtendedPlayerProperties.get((EntityPlayer)event.source.getEntity()).getKougeki();
			}
		}

		if(event.source.isExplosion() && !(event.source.getEntity() instanceof EntityWither))
		{
			event.ammount = event.ammount * 5;
		}

		//エンドラの理不尽な防御力
		if(event.entityLiving instanceof EntityDragon)
		{
			event.ammount = event.ammount / enumEndora.getDeffence();
 		}


		//エンドラの理不尽な防御力2
		if(event.entityLiving instanceof EntityDragon)
		{
			for(int damCnt = 0; damCnt < 10; damCnt++)
			{
				if(event.ammount > 500)
				{
					event.ammount = event.ammount / 10;
				}else
				{
					break;
				}
			}
 		}

		//ウィザーのちょっと嫌な防御力
		if(event.entityLiving instanceof EntityWither)
		{
			event.ammount = event.ammount / 5;
 		}

		//ダメージ乱数
		int randomDam = (int)(event.ammount / 2);
		if(randomDam > 0)
		{
			event.ammount = (event.ammount * 3 / 4) + (rand.nextInt(randomDam));
		}

		boolean criticalFlg = false;
		if(event.source.getEntity() != null && event.source.getEntity() instanceof EntityLivingBase)
		{
			if(event.source.getEntity() instanceof DqmMobBase)
			{
				event.source.setDamageBypassesArmor();

				DqmMobBase mob = (DqmMobBase)event.source.getEntity();

				int criticalVal = mob.DqmMobKaisin;
				if(rand.nextInt(500) < criticalVal + 1)
				{
					criticalFlg = true;
					event.ammount = event.ammount * (rand.nextInt(mob.DqmMobKaisinMax) + mob.DqmMobKaisinMin);
				}
			}else if(event.source.getEntity() instanceof EntityPlayer)
			{
				EntityPlayer epr = (EntityPlayer)event.source.getEntity();
				int criticalVal = ExtendedPlayerProperties.get(epr).getKaisinritu() + 1;

				if(rand.nextInt(200) < criticalVal &&
						(epr.getHeldItem() != null || (epr.getHeldItem() != null && (epr.getHeldItem().getItem() instanceof DqmItemWeaponBase || epr.getHeldItem().getItem() instanceof DqmItemBowBase))
						)
				  )
				{
					event.source.setDamageBypassesArmor();
					event.ammount = event.ammount
									* (rand.nextInt(ExtendedPlayerProperties.get(epr).getKaisinMax())
							        + ExtendedPlayerProperties.get(epr).getKaisinMin());
					if(!epr.worldObj.isRemote && event.entityLiving != null)
					{
						epr.addChatMessage(new ChatComponentTranslation("msg.epCritical.txt",new Object[] { event.entityLiving.getCommandSenderName(), (int)event.ammount}));
					}
					epr.worldObj.playSoundAtEntity(epr, "dqr:player.kaisin", 0.3F, 1.0F);
				}

				if(!(event.entityLiving instanceof DqmMobBase))
				{
					if(!epr.worldObj.isRemote)
					{
						float dam = DQR.calcDamage.getDummyDamage(event.ammount, event.entityLiving, event.source);

						if (DQR.conf.damageDigits == 1)
						{
							epr.addChatMessage(new ChatComponentTranslation("msg.toDamage2.txt",new Object[] {event.entityLiving.getCommandSenderName(), dam}));
						}else
						{
							epr.addChatMessage(new ChatComponentTranslation("msg.toDamage.txt",new Object[] {event.entityLiving.getCommandSenderName(), (int)dam}));
						}
						//epr.addChatMessage(new ChatComponentTranslation("msg.toDamage.txt",new Object[] {event.entityLiving.getCommandSenderName(), dam}));
					}
				}
			}

			if(event.entityLiving instanceof EntityPlayer)
			{
				EntityPlayer ep = (EntityPlayer)event.entityLiving;

				ep.inventory.damageArmor(event.ammount);

				if(!ep.worldObj.isRemote && criticalFlg)
				{
					ep.addChatMessage(new ChatComponentTranslation("msg.mobCritical.txt",new Object[] { event.source.getEntity().getCommandSenderName(), (int)event.ammount}));
				}
				if (DQR.debug == 0)
				{
					event.source.setDamageBypassesArmor();
				}

				int bougyoryoku;
				if(criticalFlg)
				{
					bougyoryoku = 0;
				}else
				{
					bougyoryoku = ExtendedPlayerProperties.get(ep).getBougyo();
				}

				event.ammount = event.ammount - bougyoryoku;

				if(!ep.worldObj.isRemote && event.ammount <= 0.0F)
				{
					ep.worldObj.playSoundAtEntity(ep, "dqr:player.miss", 1.0F, 1.0F);
				}
			}else if(event.entityLiving instanceof DqmMobBase)
			{

			}

		}

		/*
		if(event.entityLiving instanceof EntityPlayer)
		{
			EntityPlayer ep = (EntityPlayer)event.entityLiving;

			if(event.source.getEntity() != null)
			{
				if(!ep.worldObj.isRemote)
				{
					ep.addChatMessage(new ChatComponentTranslation("msg.fromDamage.txt",new Object[] { event.source.getEntity().getCommandSenderName(), (int)event.ammount}));
				}
			}
		}
		*/
		//EntityPlayer thePlayer = event.entityPlayer;


	}


}
