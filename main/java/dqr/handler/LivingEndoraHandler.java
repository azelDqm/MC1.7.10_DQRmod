package dqr.handler;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQMiscs;
import dqr.api.enums.EnumDqmEndoraParam;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.entity.magicEntity.magic.MagicEntityMera;
import dqr.entity.magicEntity.magic.MagicEntityMeragaia;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.packetMessage.MessageServerBookWrite;

public class LivingEndoraHandler {

	@SubscribeEvent
	public void onDeathDropHookEvent(LivingDeathEvent event)
	{
		Random rand = new Random();

		/*
		if(event.entityLiving.worldObj.isRemote)
		{
			System.out.println("TEST1");
		}else
		{
			System.out.println("TEST2");
		}
		*/

		/*
		if(event.entityLiving.worldObj.isRemote) {
			return;
		}
		*/

		if(event.entityLiving instanceof EntityDragon) {

			if(event.entityLiving.worldObj.isRemote)
			{
				makeBook();
			}

			if(!event.entityLiving.worldObj.isRemote)
			{
				event.entityLiving.dropItem(DQMiscs.itemAtkEndora, 1);
			}
	    	//ItemStack book = new ItemStack(DQMiscs.itemFarmerDiary, 1, 0);
	    	/*
			NBTTagList bookPages;
			bookPages = new NBTTagList();
			int bookTotalPages = 12;

			//Calendar cal = Calendar.getInstance();
			Locale JaLocale = new Locale("ja","JP");
			 Calendar cal = new GregorianCalendar(JaLocale);
			cal.setTime(new Date());

			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DATE);

			System.out.println(month + "月" + day + "日");
			//cal.add(Calendar.DATE, -31);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);
			//event.entityLiving.dropItem(book, 1);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page1.1.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page1.2.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page1.3.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page1.4.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page1.5.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page1.6.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page1.7.txt", new Object[]{})));

			cal.add(Calendar.DATE, 2);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page2.1.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page2.2.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page2.3.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page2.4.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page2.5.txt", new Object[]{})));

			cal.add(Calendar.DATE, 1);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page2.10.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page2.11.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page2.12.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page2.13.txt", new Object[]{})));

			cal.add(Calendar.DATE, 1);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page3.1.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page3.2.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page3.3.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page3.4.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page3.5.txt", new Object[]{})));


			cal.add(Calendar.DATE, 2);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page4.1.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page4.2.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page4.3.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page4.4.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page4.5.txt", new Object[]{})));

			cal.add(Calendar.DATE, 3);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page5.1.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page5.2.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page5.3.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page5.4.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page5.5.txt", new Object[]{})));

			cal.add(Calendar.DATE, 1);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page5.10.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page5.11.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page5.12.txt", new Object[]{})));

			cal.add(Calendar.DATE, 3);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page6.1.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page6.2.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page6.3.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page6.4.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page6.5.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page6.6.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page6.7.txt", new Object[]{})));

			cal.add(Calendar.DATE, 5);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page7.1.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page7.2.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page7.3.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page7.4.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page7.5.txt", new Object[]{})));


			cal.add(Calendar.DATE, 1);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page8.1.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page8.2.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page8.3.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page8.4.txt", new Object[]{})));

			cal.add(Calendar.DATE, 6);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page9.1.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page9.2.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page9.3.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page9.4.txt", new Object[]{}) + "\n" +
					 I18n.format("msg.farmerDiary.page9.5.txt", new Object[]{})));

			cal.add(Calendar.DATE, 3);
			month = cal.get(Calendar.MONTH);
			day = cal.get(Calendar.DATE);

			bookPages.appendTag(
					new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
					 I18n.format("msg.farmerDiary.page10.1.txt", new Object[]{})));


	        String s;

            while (bookPages.tagCount() > 1)
            {
                s = bookPages.getStringTagAt(bookPages.tagCount() - 1);

                if (s.length() != 0)
                {
                    break;
                }

                bookPages.removeTag(bookPages.tagCount() - 1);
            }

            if (book.hasTagCompound())
            {
                NBTTagCompound nbttagcompound = book.getTagCompound();
                nbttagcompound.setTag("pages", bookPages);
            }
            else
            {
            	book.setTagInfo("pages", bookPages);
            }

            s = "MC|BEdit";

            book.setTagInfo("author", new NBTTagString(I18n.format("msg.farmerDiary.author", new Object[]{})));
            book.setTagInfo("title", new NBTTagString(I18n.format("msg.farmerDiary.title", new Object[]{})));
            book.func_150996_a(Items.written_book);
            */
			//event.entityLiving.entityDropItem(book, 0.0F);
		}
	}


	@SubscribeEvent
	public void onEnderdragonKiseki(LivingAttackEvent event)
	{
		Random rand = new Random();

		if(event.source != null &&
		   (event.source.getEntity() instanceof EntityDragon ||
		   event.source.getSourceOfDamage() instanceof EntityDragon))
		{
			int varDifficulty = DQR.conf.DqmEndoraDifficulty == -1 ? DQR.conf.DqmDifficulty : DQR.conf.DqmEndoraDifficulty;

			EnumDqmEndoraParam enumEndora = DQR.enumGetter.getEndoraParam(varDifficulty);

			if(enumEndora.getUseKiseki())
			{
				if(event.entityLiving instanceof DqmMobBase)
				{
					DqmMobBase mob = (DqmMobBase)event.entityLiving;
					if(mob.KakuseiMob != null)
					{
						if(!mob.worldObj.isRemote) mob.worldObj.playSoundAtEntity(mob, "ambient.weather.thunder", 1.0F, 1.0F);

						DqmMobBase tenseiMonster = (DqmMobBase)EntityList.createEntityByName(DQR.modID + "." + mob.KakuseiMob, mob.worldObj);

						if(tenseiMonster != null)
						{
							tenseiMonster.setPosition(mob.posX, mob.posY + 1, mob.posZ);

							if(!mob.worldObj.isRemote)
							{
								mob.setDead();
								mob.worldObj.spawnEntityInWorld(tenseiMonster);
							}
						}
					}
				}
			}
		}
	}


	@SubscribeEvent
	public void onEnderDragonAttack(LivingUpdateEvent event)
	{

		Random rand = new Random();
		if(event.entityLiving instanceof EntityDragon)
		{
			EntityDragon dragon = (EntityDragon)event.entityLiving;
			int varDifficulty = DQR.conf.DqmEndoraDifficulty == -1 ? DQR.conf.DqmDifficulty : DQR.conf.DqmEndoraDifficulty;
			EnumDqmEndoraParam enumEndora = DQR.enumGetter.getEndoraParam(varDifficulty);

			if(dragon.getMaxHealth() < enumEndora.getMaxHP())
			{
				if(varDifficulty > 6)
				{
					dragon.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(enumEndora.getMaxHP() + (250.0F * (varDifficulty - 6)));
				}else
				{
					dragon.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(enumEndora.getMaxHP());
				}
				dragon.setHealth(dragon.getMaxHealth());
			}

			//if(dragon.worldObj.getWorldTime() % 20 == 0 && dragon.getHealth() < dragon.getMaxHealth() && dragon.getHealth() > 50)
			if(dragon.getHealth() < dragon.getMaxHealth() && dragon.getHealth() > 50)
			{
				if(varDifficulty > 6)
				{
					dragon.setHealth(dragon.getHealth() + enumEndora.getRegene() + (1.0F + (varDifficulty - 6)));
				}else
				{
					dragon.setHealth(dragon.getHealth() + enumEndora.getRegene());
				}
			}
			/*
			if(dragon.getHealth() < dragon.getMaxHealth() && dragon.getHealth() > 50)
			{
				if(varDifficulty > 3)
				{
					dragon.setHealth(dragon.getHealth() + 0.5F + (1.0F * (varDifficulty - 3)));
				}else
				{
					if(varDifficulty > 1)
					{
						dragon.setHealth(dragon.getHealth() + 0.5F);
					}
				}
			}
			*/

			if((DQR.conf.DqmDifficulty > 4 || DQR.conf.DqmEndoraDifficulty > 4)&& rand.nextInt(30) < 25)
			{
				MagicEntity[] magic2 = null;
				magic2 = new MagicEntity[5];
				for(int cnt = 0;cnt < 5; cnt++)
				{
					magic2[cnt] = new MagicEntityMera(dragon.worldObj, dragon, 1.5F, 1.0F, (float)(-2 + cnt), 0.0F, 0.0F, 0.0F, -180.0F);
				}

				if(magic2 != null)
				{

					int attackDam = 150;

					if(varDifficulty > 6)
					{
						attackDam = 150 + ((varDifficulty - 6) * 100);
					}
					//this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

		    		for(int cnt = 0; cnt < magic2.length; cnt++)
		    		{
						magic2[cnt].setDamage(attackDam);
						magic2[cnt].setFallSpeed(0.2F);

			        	if (!dragon.worldObj.isRemote)
			        	{
			        		//magic[cnt].setWorldFlg(this.isSneaking());
			        		dragon.worldObj.spawnEntityInWorld(magic2[cnt]);
			        	}
		    		}
				}
			}

			if(varDifficulty > 1)
			{
				if(rand.nextInt(30) == 0 || (varDifficulty > 3 && rand.nextInt(30) < varDifficulty - 3))
				{
					int pat = 0;

					if(varDifficulty > 4)
					{
						pat = rand.nextInt(2);
					}else
					{
						pat = rand.nextInt(5);
					}

					if(pat == 0)
					{
						//煉獄の炎の雨
						MagicEntity[] magic = null;
						magic = new MagicEntityMeragaia[32];
						for(int cnt = 0;cnt < 32; cnt++)
						{
							magic[cnt] = new MagicEntityMeragaia(dragon.worldObj, dragon, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (11.25F * cnt)), 0.0F);
							((MagicEntityMeragaia) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
						}


						if(magic != null)
						{

							int attackDam = 450;

							//this.rangedAttackEntityHost.worldObj.playSoundAtEntity(this.rangedAttackEntityHost, "dqr:player.jumon", 1.0F, 1.0F);

				    		for(int cnt = 0; cnt < magic.length; cnt++)
				    		{
								magic[cnt].setDamage(attackDam);
								magic[cnt].setFallSpeed(0.3F);
					        	if (!dragon.worldObj.isRemote)
					        	{
					        		//magic[cnt].setWorldFlg(this.rangedAttackEntityHost.isSneaking());
					        		dragon.worldObj.spawnEntityInWorld(magic[cnt]);
					        	}
				    		}
						}
					}else if(pat == 1)
					{
						//絶対零度の雨
						MagicEntityHyado[] magic = null;
						magic = new MagicEntityHyado[32];
						for(int cnt = 0;cnt < 32; cnt++)
						{
							magic[cnt] = new MagicEntityHyado(dragon.worldObj, dragon, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (11.25F * cnt)), 0.0F);
							if(rand.nextInt(10) == 0 && DQR.conf.magicSpFubuki == 1)magic[cnt].setWorldFlg(4);
						}


						if(magic != null)
						{

							int attackDam = 450;

							//this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

				    		for(int cnt = 0; cnt < magic.length; cnt++)
				    		{
								magic[cnt].setDamage(attackDam);
								magic[cnt].setFallSpeed(0.3F);
					        	if (!dragon.worldObj.isRemote)
					        	{
					        		//magic[cnt].setWorldFlg(this.isSneaking());
					        		dragon.worldObj.spawnEntityInWorld(magic[cnt]);
					        	}
				    		}

						}
					}else
					{
						//ベギラゴン
						MagicEntity[] magic = null;
						magic = new MagicEntity[7];
						for(int cnt = 0;cnt < 7; cnt++)
						{
							magic[cnt] = new MagicEntityMera(dragon.worldObj, dragon, 1.5F, 1.0F, (float)(-3 + cnt), 0.0F, 0.0F, 0.0F, -180.0F);
						}

						if(magic != null)
						{

							int attackDam = 150;

							//this.worldObj.playSoundAtEntity(this, "dqr:player.jumon", 1.0F, 1.0F);

				    		for(int cnt = 0; cnt < magic.length; cnt++)
				    		{
								magic[cnt].setDamage(attackDam);
								magic[cnt].setFallSpeed(0.2F);

					        	if (!dragon.worldObj.isRemote)
					        	{
					        		//magic[cnt].setWorldFlg(this.isSneaking());
					        		dragon.worldObj.spawnEntityInWorld(magic[cnt]);
					        	}
				    		}

						}
					}
				}
			}
		}
	}


    @SideOnly(Side.CLIENT)
    public void makeBook()
    {
		//System.out.println("TEST2");

    	//ItemStack book = new ItemStack(DQMiscs.itemFarmerDiary, 1, 0);
    	ItemStack book = new ItemStack(Items.written_book, 1, 0);

		NBTTagList bookPages;
		bookPages = new NBTTagList();
		int bookTotalPages = 12;

		Locale JaLocale = new Locale("ja","JP");
		 Calendar cal = new GregorianCalendar(JaLocale);
		cal.setTime(new Date());

		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);

		System.out.println(month + "月" + day + "日");
		//cal.add(Calendar.DATE, -31);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);
		//event.entityLiving.dropItem(book, 1);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page1.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page1.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page1.3.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page1.4.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page1.5.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page1.6.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page1.7.txt", new Object[]{})));

		cal.add(Calendar.DATE, 2);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page2.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page2.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page2.3.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page2.4.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page2.5.txt", new Object[]{})));

		cal.add(Calendar.DATE, 1);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page2.10.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page2.11.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page2.12.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page2.13.txt", new Object[]{})));

		cal.add(Calendar.DATE, 1);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page3.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page3.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page3.3.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page3.4.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page3.5.txt", new Object[]{})));


		cal.add(Calendar.DATE, 2);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page4.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page4.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page4.3.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page4.4.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page4.5.txt", new Object[]{})));

		cal.add(Calendar.DATE, 3);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page5.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page5.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page5.3.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page5.4.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page5.5.txt", new Object[]{})));

		cal.add(Calendar.DATE, 1);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page5.10.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page5.11.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page5.12.txt", new Object[]{})));

		cal.add(Calendar.DATE, 3);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page6.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page6.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page6.3.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page6.4.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page6.5.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page6.6.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page6.7.txt", new Object[]{})));

		cal.add(Calendar.DATE, 5);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page7.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page7.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page7.3.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page7.4.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page7.5.txt", new Object[]{})));


		cal.add(Calendar.DATE, 1);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page8.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page8.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page8.3.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page8.4.txt", new Object[]{})));

		cal.add(Calendar.DATE, 6);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page9.1.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page9.2.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page9.3.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page9.4.txt", new Object[]{}) + "\n" +
				 I18n.format("msg.farmerDiary.page9.5.txt", new Object[]{})));

		cal.add(Calendar.DATE, 3);
		month = cal.get(Calendar.MONTH);
		day = cal.get(Calendar.DATE);

		bookPages.appendTag(
				new NBTTagString(I18n.format("msg.farmerDiary.page.date.txt", new Object[]{month, day}) + "\n" +
				 I18n.format("msg.farmerDiary.page10.1.txt", new Object[]{})));


        String s;

        while (bookPages.tagCount() > 1)
        {
            s = bookPages.getStringTagAt(bookPages.tagCount() - 1);

            if (s.length() != 0)
            {
                break;
            }

            bookPages.removeTag(bookPages.tagCount() - 1);
        }

        if (book.hasTagCompound())
        {
            NBTTagCompound nbttagcompound = book.getTagCompound();
            nbttagcompound.setTag("pages", bookPages);
        }
        else
        {
        	book.setTagInfo("pages", bookPages);
        }

        s = "MC|BEdit";

        book.setTagInfo("author", new NBTTagString(I18n.format("msg.farmerDiary.author", new Object[]{})));
        book.setTagInfo("title", new NBTTagString(I18n.format("msg.farmerDiary.title", new Object[]{})));
        //book.func_150996_a(Items.written_book);

		//event.entityLiving.entityDropItem(book, 0.0F);
        PacketHandler.INSTANCE.sendToServer(new MessageServerBookWrite(book));

    }
}
