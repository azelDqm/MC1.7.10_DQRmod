package dqr.handler;

import java.util.List;
import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.RegistryNamespaced;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumDqmMessageConv;
import dqr.api.enums.EnumDqmSkillW;
import dqr.api.enums.EnumDqmWeapon;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.petEntity.DqmPetBase;
import dqr.entity.throwingEntity.throwing.ThrowingEntityDqrArrow;
import dqr.items.base.DqmItemWeaponBase;
import dqr.packetMessage.MessageClientCleatSlotItem;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties2;
import dqr.playerData.ExtendedPlayerProperties3;

public class PlayerEventHandler {

    @SubscribeEvent
    public void onPlayerDropsEvent(PlayerDropsEvent event) {}

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event)  {


        if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
        {
        	EntityPlayer ep = (EntityPlayer)event.entity;

        	if(!ep.isDead && ep.getHealth() > 0 && ExtendedPlayerProperties3.get(ep).getDeadCheckFlg() > 0)
        	{
        		//System.out.println("TEST_B");
        		 List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
                 		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ)
                 		  .expand((double)DQR.conf.deadClearWidth, (double)DQR.conf.deadClearHeight, (double)DQR.conf.deadClearWidth));

                 if (list != null && !list.isEmpty())
                 {
                 	for (int n = 0 ; n < list.size() ; n++)
                 	{
                 		Entity target = (Entity)list.get(n);

                 		if (target instanceof DqmMobBase)
                 		{
                 			//System.out.println("TEST_A");
                 			target.setDead();
                 		}
                 	}
                 }

        		//System.out.println("TEST2:" + ep.worldObj + ":" + ep.posX + "/" + ep.posY + "/" + ep.posZ);
                 ExtendedPlayerProperties3.get(ep).setDeadCheckFlg(0);
        	}else
        	{
        		ExtendedPlayerProperties3.get(ep).setDeadCheckFlg(1);
        	}
        }
    }

    public void onLivingDeathEvent(LivingDeathEvent event)  {
        if (event.entityLiving instanceof EntityPlayer && !event.entity.worldObj.isRemote) {
        	EntityPlayer ep = (EntityPlayer)event.entity;

        	ExtendedPlayerProperties3.get(ep).setDeadCheckFlg(1);
        }
    }

	@SubscribeEvent
	public void ArrowLooseEventHandler(ArrowLooseEvent e)
	{
		/*
		//System.out.println("TEST1" + e.);
		if(e.entity instanceof EntityArrow)
		{
			EntityArrow arrow = (EntityArrow)e.entity;
			//System.out.println("Test2:" + arrow.getDamage());
		}
		*/
		Random rand = new Random();
		//System.out.println("今撃った？");
		EntityPlayer ep = e.entityPlayer;

		//entityarrow.rotationYaw = 25.0F;
		//entityarrow2.rotationYaw = -25.0F;


		int weapon = EnumDqmWeapon.DqmBow.getId();
		int weaponSkill = ExtendedPlayerProperties3.get(ep).getWeaponSkillSet(weapon);
		int skillPerm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(weapon, weaponSkill);

		EnumDqmSkillW skillW = DQR.enumGetter.getSkillW(weapon, weaponSkill);

		if(skillW != null && skillW.getFunc() == 1 && skillW.getRATE() > rand.nextInt(100))
		{
			boolean hitFlg = false;
			//ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {}));
			//ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.MonsterName.getEndS()}));

			if(weaponSkill == 6)
			{
				if(!ep.worldObj.isRemote)
				{
					ep.addChatMessage(new ChatComponentTranslation("msg.toSkillHit.txt",new Object[] {EnumDqmMessageConv.SkillName.getStartS() + skillW.getName() + EnumDqmMessageConv.SkillName.getEndS()}));
				}

				float f = (float)e.charge / 20.0F;
	            f = (f * f + f * 2.0F) / 3.0F;

	            if ((double)f < 0.1D)
	            {
	                return;
	            }

	            if (f > 1.0F)
	            {
	                f = 1.0F;
	            }

				if(ep.worldObj.isRemote)
				{
		            if(e.bow.getMaxItemUseDuration() - ep.getItemInUseCount() > 20)
		            {
		            	ExtendedPlayerProperties.get(ep).setMaxItemUserCnt(20);
		            }else
		            {
		            	ExtendedPlayerProperties.get(ep).setMaxItemUserCnt(e.bow.getMaxItemUseDuration() - ep.getItemInUseCount());
		            }
				}
	            //System.out.println("TEST1:" + p_77615_3_.getItemInUseCount());
	            //EntityArrow entityarrow = new EntityArrow(ep.worldObj, ep, f * 2.0F);
				ThrowingEntityDqrArrow entityarrow = new ThrowingEntityDqrArrow(ep.worldObj, ep, f * 2.0F, 1.0F, 0.0F, 0.0F, 0.0F, 22.5F, 0.0F);
				ThrowingEntityDqrArrow entityarrow2 = new ThrowingEntityDqrArrow(ep.worldObj, ep, f * 2.0F, 1.0F, 0.0F, 0.0F, 0.0F, 45.0F, 0.0F);
				ThrowingEntityDqrArrow entityarrow3 = new ThrowingEntityDqrArrow(ep.worldObj, ep, f * 2.0F, 1.0F, 0.0F, 0.0F, 0.0F, -22.5F, 0.0F);
				ThrowingEntityDqrArrow entityarrow4 = new ThrowingEntityDqrArrow(ep.worldObj, ep, f * 2.0F, 1.0F, 0.0F, 0.0F, 0.0F, -45.0F, 0.0F);

	            if(ep != null)
	            {
	            	entityarrow.setDamage(ExtendedPlayerProperties.get(ep).getKougeki() * 1.0F);
	            	entityarrow2.setDamage(ExtendedPlayerProperties.get(ep).getKougeki() * 1.0F);
	            	entityarrow3.setDamage(ExtendedPlayerProperties.get(ep).getKougeki() * 1.0F);
	            	entityarrow4.setDamage(ExtendedPlayerProperties.get(ep).getKougeki() * 1.0F);
	            }
	            if (f == 1.0F)
	            {
	                entityarrow.setIsCritical(true);
	                entityarrow2.setIsCritical(true);
	                entityarrow3.setIsCritical(true);
	                entityarrow4.setIsCritical(true);
	            }

	            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, e.bow);

	            if (k > 0)
	            {
	                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 1.0D + 1.0D);
	                entityarrow2.setDamage(entityarrow2.getDamage() + (double)k * 1.0D + 1.0D);
	                entityarrow3.setDamage(entityarrow3.getDamage() + (double)k * 1.0D + 1.0D);
	                entityarrow4.setDamage(entityarrow4.getDamage() + (double)k * 1.0D + 1.0D);
	            }

	            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, e.bow);

	            if (l > 0)
	            {
	                entityarrow.setKnockbackStrength(l);
	                entityarrow2.setKnockbackStrength(l);
	                entityarrow3.setKnockbackStrength(l);
	                entityarrow4.setKnockbackStrength(l);
	            }

	            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, e.bow) > 0)
	            {
	                entityarrow.setFire(100);
	                entityarrow2.setFire(100);
	                entityarrow3.setFire(100);
	                entityarrow4.setFire(100);
	            }

	        	int maxDam = e.bow.getMaxDamage();
	        	int dam = e.bow.getItemDamage();


	        	if(maxDam * 9 / 10 > dam)
	        	{
	        		e.bow.damageItem(4 - (dam % 4), ep);
	        	}else
	        	{
	        		e.bow.setItemDamage((maxDam * 9 / 10) - 4);
	        			dam = e.bow.getItemDamage();

	        			e.bow.damageItem(4 - (dam % 4), ep);
	        	}

	            //p_77615_1_.damageItem(1, p_77615_3_);
	            if(!ep.worldObj.isRemote)ep.worldObj.playSoundAtEntity(ep, "random.bow", 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);


	            if (!ep.worldObj.isRemote)
	            {
					ep.worldObj.spawnEntityInWorld(entityarrow);
					ep.worldObj.spawnEntityInWorld(entityarrow2);
					ep.worldObj.spawnEntityInWorld(entityarrow3);
					ep.worldObj.spawnEntityInWorld(entityarrow4);
	            }
			}
		}
	}

	@SubscribeEvent
	public void PlayerInteractHandler(PlayerInteractEvent e)
	{
		if(e.action == Action.LEFT_CLICK_BLOCK && e.entityPlayer.capabilities.isCreativeMode
				&& e.entityPlayer.getHeldItem() != null && e.entityPlayer.getHeldItem().getItem() instanceof DqmItemWeaponBase)
		{
			e.setCanceled(true);
		}

		EntityPlayer ep = e.entityPlayer;

		//System.out.println("test1");
		if(e.action == Action.LEFT_CLICK_BLOCK)
		{
			//System.out.println("test2");
			if(ep.getHeldItem() != null && ep.getHeldItem().getItem() == DQWeapons.itemKeironnoyumi)
			{
		    	int itemMode2 = ExtendedPlayerProperties.get(ep).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_ITEMUSEBOW.getId());
		    	float pitch = 1.2F;
				if(itemMode2 == 1)
				{
					//e.setCanceled(true);
					if(DQR.func.isBind(ep) && ep.worldObj.isRemote)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
						ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
						return;
					}

					EnumDqmWeapon enumWeapon = EnumDqmWeapon.DqmBow;

					if(DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
													  enumWeapon.getId(),
													  ep) < 1 && DQR.debug == 0)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.magic.weaponNoAppti.txt",new Object[] {}));
						ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
						return;
					}

					//System.out.println("TEST" + (ep.getHeldItem().getItemDamage()) + "/" + (ep.getHeldItem().getMaxDamage() / 5 * 4 + 1));
					if(ep.getHeldItem().getItemDamage() >= ep.getHeldItem().getMaxDamage() / 5 * 4 + 1)
					{
						ep.addChatMessage(new ChatComponentTranslation("msg.magic.weaponNoEnergy.txt",new Object[] {}));
						ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
						return;
					}
					ep.worldObj.playSoundAtEntity(ep, "dqr:player.jumon", 1.0F, 1.2F);
					int attackDam = 30;


		        	if(ep.getHealth() + attackDam > ep.getMaxHealth())
		        	{
		        		ep.setHealth(ep.getMaxHealth());
		        	}else
		        	{
		        		ep.setHealth(ep.getHealth() + (float)attackDam);
		        	}
		        	ep.worldObj.playSoundAtEntity(ep, "dqr:player.hoimi", 1.0F, 1.0F);




		            List list = ep.worldObj.getEntitiesWithinAABBExcludingEntity(ep,
		            		ep.boundingBox.addCoord(ep.motionX, ep.motionY, ep.motionZ).expand(10.0D, 5.0D, 10.0D));

		            if (list != null && !list.isEmpty())
		            {
		            	for (int n = 0 ; n < list.size() ; n++)
		            	{
		            		Entity target = (Entity)list.get(n);

		            		if (target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse)
		            		{
			    				attackDam = 30;

			    				EntityLivingBase elb = (EntityLivingBase)target;

	                			if(elb instanceof DqmPetBase && elb.getHealth() <= 0.1F)
	                			{
	                				;
	                			}else
	                			{

			                    	if(elb.getHealth() + attackDam > elb.getMaxHealth())
			                    	{
			                    		elb.setHealth(elb.getMaxHealth());
			                    	}else
			                    	{
			                    		elb.setHealth(elb.getHealth() + (float)attackDam);
			                    	}
			                    	elb.worldObj.playSoundAtEntity(elb, "dqr:player.hoimi", 1.0F, 1.0F);
	                			}
		            		}
		            	}
		            }

		            ep.getHeldItem().damageItem(ep.getHeldItem().getItem().getMaxDamage() / 20, ep);

		            //System.out.println("TESTXXX" + ep.getHeldItem().getItemDamage() + "/" + ep.getHeldItem().getMaxDamage());
					if(ep.getHeldItem().getItemDamage() >= ep.getHeldItem().getMaxDamage())
					{
						//System.out.println("TEST?");
						ep.getHeldItem().stackSize--;
						PacketHandler.INSTANCE.sendTo(new MessageClientCleatSlotItem(ep.inventory.currentItem), (EntityPlayerMP)ep);
					}
				}
				//System.out.println("TEST?");
			}
		}

		//農業用マジックツール処理
		if(ep.isSneaking() && ExtendedPlayerProperties2.get(ep).getSeedSetMode() == 1)
		{
			if(e.entityPlayer.inventory.getCurrentItem() != null)
			{
				ItemStack iStack = e.entityPlayer.inventory.getCurrentItem();

				RegistryNamespaced rn = Item.itemRegistry;
				String itemName = rn.getNameForObject(iStack.getItem());

				if(DQR.MGSeedTable.containsKey(itemName))
				{
					if(!ep.worldObj.isRemote)
					{
						int seedVal = ExtendedPlayerProperties2.get(ep).getSeedVal(itemName);
						ExtendedPlayerProperties2.get(ep).setSeedVal(itemName, seedVal + iStack.stackSize);

						ep.addChatMessage(new ChatComponentTranslation("msg.magictool.farm.seedInAct.1.txt", new Object[] {iStack.getDisplayName(), seedVal + iStack.stackSize}));
					}

					ExtendedPlayerProperties2.get(ep).setSelectSeed(itemName);

					if(DQR.MGSeedTable.containsKey2(itemName ,1))
					{
						ExtendedPlayerProperties2.get(ep).setSelectSeed1(itemName);
					}else if(DQR.MGSeedTable.containsKey2(itemName ,2))
					{
						ExtendedPlayerProperties2.get(ep).setSelectSeed2(itemName);
					}else if(DQR.MGSeedTable.containsKey2(itemName ,3))
					{
						ExtendedPlayerProperties2.get(ep).setSelectSeed3(itemName);
					}else if(DQR.MGSeedTable.containsKey2(itemName ,4))
					{
						ExtendedPlayerProperties2.get(ep).setSelectSeed4(itemName);
					}

					if(!ep.worldObj.isRemote) ep.worldObj.playSoundAtEntity(ep, "dqr:player.pi", 1.0F, 1.0F);
					iStack.stackSize = 0;


				}
			}
		}

		//e.entityPlayer.addChatMessage(new ChatComponentTranslation("TEST"));
		//EntityPlayer ep = e.entityPlayer;
		//ep.openGui(DQR.instance, DQR.conf.GuiID_JobChange, ep.worldObj, (int)ep.posX, (int)ep.posY, (int)ep.posZ);
	}
}
