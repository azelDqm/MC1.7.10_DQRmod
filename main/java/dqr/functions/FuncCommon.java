package dqr.functions;

import java.util.Random;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQSeeds;
import dqr.api.enums.EnumDqmJob;
import dqr.api.event.DqmLvUpEvent;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityBagi;
import dqr.entity.magicEntity.magic.MagicEntityBegiragon;
import dqr.entity.magicEntity.magic.MagicEntityBegirama;
import dqr.entity.magicEntity.magic.MagicEntityDoruma;
import dqr.entity.magicEntity.magic.MagicEntityGira;
import dqr.entity.magicEntity.magic.MagicEntityGiragureido;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.entity.magicEntity.magic.MagicEntityIo;
import dqr.entity.magicEntity.magic.MagicEntityMera;
import dqr.entity.magicEntity.magic.MagicEntityMeragaia;
import dqr.entity.magicEntity.magic.MagicEntityMerami;
import dqr.entity.magicEntity.magic.MagicEntityMerazoma;
import dqr.entity.magicEntity.magic.MagicEntityRaidein;
import dqr.entity.magicEntity.magic.MagicEntityZaki;
import dqr.entity.mobEntity.DqmMobBase;
import dqr.entity.petEntity.DqmPetBase;
import dqr.items.base.DqmItemFoodSeedBase;
import dqr.packetMessage.MessageClientSound;
import dqr.playerData.ExtendedPlayerProperties;

public class FuncCommon {

	public FuncCommon(){}

	public boolean hasChatKey(String key)
	{
		ChatComponentTranslation checker = new ChatComponentTranslation(key, new Object[] {0});
		//System.out.println("TEST:" + checker.getUnformattedText() + "/" + checker.getUnformattedTextForChat() + "/" + checker.getFormattedText() + "/" + key);
		return !key.equalsIgnoreCase(checker.getUnformattedText());
	}

	public void setKnockBack(EntityLivingBase par1, int lv, Entity par2, boolean par3)
	{
		if(par3 && par2 != null && par2 instanceof EntityLivingBase)
		{
			lv += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)par2, (EntityLivingBase)par2);
		}

        par1.motionX *= 0.6D;
        par1.motionZ *= 0.6D;
		par1.addVelocity((double)(-MathHelper.sin(par2.rotationYaw * (float)Math.PI / 180.0F) * (float)lv * 0.5F), 0.1D, (double)(MathHelper.cos(par2.rotationYaw * (float)Math.PI / 180.0F) * (float)lv * 0.5F));
        //par1.setPositionAndUpdate(par1.prevPosX, par1.prevPosY + 0.5D, par1.prevPosZ);
        //par1.set
	}

	public int getMikawasi(EntityLivingBase par1)
	{
		int ret = 0;

		if(par1 instanceof DqmPetBase)
		{
			ret = ((DqmPetBase)par1).getMikawasi();
		}else if(par1 instanceof DqmMobBase)
		{
			ret = ((DqmMobBase)par1).DqmMobMikawasi;
		}else if(par1 instanceof EntityPlayer)
		{
			ret = ExtendedPlayerProperties.get((EntityPlayer)par1).getMikawasi();
		}

		return ret;
	}

	public boolean isBind(EntityLivingBase par1)
	{

    	PotionEffect pe = null;
		pe = par1.getActivePotionEffect(DQPotionMinus.debuffStop);
		if(pe != null && pe.getDuration() > 0)
		{
			//System.out.println("Rariho:" + pe.getDuration());
			return true;
		}

		pe = par1.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && par1.worldObj.isRemote && pe.getDuration() > 0)
		if(pe != null && pe.getDuration() > DQR.conf.rarihoFreeDuration)
		{
			//System.out.println("Rariho:" + pe.getDuration());
			return true;
		}
		return false;
	}

	public boolean isPlayer(Entity par1)
	{
		return (par1 instanceof EntityPlayer);
	}

	public int xRandom(int min, int max)
	{
		Random rand = new Random();
		return rand.nextInt(max - min + 1) + min;
	}

	public boolean equalBlockArray(Block[] par1, Block[] par2)
	{
		if(par1.length != par2.length)
		{
			return false;
		}

		for(int cnt = 0; cnt < par1.length; cnt++)
		{
			if(par1[cnt] != par2[cnt])
			{
				return false;
			}
		}

		return true;
	}

	public boolean equalIntArray(int[] par1, int[] par2)
	{
		if(par1.length != par2.length)
		{
			return false;
		}

		for(int cnt = 0; cnt < par1.length; cnt++)
		{
			if(par1[cnt] != par2[cnt])
			{
				return false;
			}
		}

		return true;
	}

	public void debugString(String par1)
	{
		this.debugString(par1, null, 1);
		/*
		if(DQR.debug != 0)
		{
			System.out.println(par1);
		}
		*/
	}

	public void debugString(String par1, Class par2)
	{
		this.debugString(par1, par2, 1);
		/*
		if(DQR.debug != 0)
		{
			System.out.println(par2.getName() + "/" + par1);
		}
		*/
	}

	public void debugString(String par1, Class par2, int debugNo)
	{
		try
		{
			if(DQR.debug == debugNo)
			{
				if(par2 != null)
				{
					System.out.println(par2.getName() + "/" + par1);
				}else
				{
					System.out.println(par1);
				}
			}
		}catch(Exception e)
		{

		}
	}

	/**
	 *  @param world
	 *  @param PosX
	 *  @param PosZ
	 *  @param startY
	 *  @param endY
	 */
	public int getHeightValue2(World world, int par1, int par2, int par3, int par4)
	{
		int retY = -1;
		int mem = -1;


		if(par3 < par4)
		{
			//System.out.println("loop1");
			for(int cnt = par3; cnt <= par4; cnt++)
			{
				if(mem == -1)
				{
					if(world.getBlock(par1, cnt, par2) != Blocks.air)
					{
						mem = 0;
					}
				}else
				{
					if(world.getBlock(par1, cnt, par2) == Blocks.air)
					{
						if(retY == -1)
						{
							retY = cnt;
							mem = 1;
						}else
						{
							return retY;
						}
					}else
					{
						mem = -1;
						retY = -1;
					}
				}
			}
		}else
		{
			//System.out.println("loop2");
			for(int cnt = par3; cnt >= par4; cnt--)
			{
				if(mem == -1)
				{
					//System.out.println("test" + cnt);
					if(world.getBlock(par1, cnt, par2) == Blocks.air)
					{
						mem = 0;
					}
				}else
				{
					if(world.getBlock(par1, cnt, par2) == Blocks.air)
					{
						//System.out.println("test" + cnt);
						mem = 1;
					}else
					{
						if(mem == 1)
						{
							return cnt + 1;
						}else
						{
							mem = -1;
						}
					}
				}
			}
		}


		return -1;
	}

	public double[] serchAirLocation(EntityLivingBase par1, double posX, double posY, double posZ)
	{
		double[] retLocation = new double[3];

		retLocation[0] = posX + 0.5D;
		retLocation[1] = posY + 1.0D;
		retLocation[2] = posZ + 0.5D;

		int locX = (int)(posX + 0.5D);
		int locY = (int)(posY + 1.0D);
		int locZ = (int)(posZ + 0.5D);

		if(par1.worldObj.isAirBlock(locX, locY, locZ) && par1.worldObj.isAirBlock(locX, locY + 1, locZ))
		{
			retLocation[0] = locX;
			retLocation[1] = locY;
			retLocation[2] = locZ;
		}else
		{
			for(int cntY = 0; cntY <= 1; cntY++)
			{
				for(int cntX = -1; cntX <= 1; cntX++)
				{
					for(int cntZ = -1; cntZ <= 1; cntZ++)
					{
						if(par1.worldObj.isAirBlock(locX + cntX, locY + cntY, locZ + cntZ) && par1.worldObj.isAirBlock(locX + cntX, locY + 1 + cntY, locZ + cntZ))
						{
							retLocation[0] = locX + cntX;
							retLocation[1] = locY + cntY;
							retLocation[2] = locZ + cntZ;
						}
					}
				}
			}
		}

		return retLocation;
	}

	public void forceCastMobMagic(EntityLivingBase par1, MagicEntity par2, String sound, int damageRate)
	{
		MagicEntity magic = null;
		if(par2 instanceof MagicEntityBagi)
		{
			magic = new MagicEntityBagi(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityBegiragon)
		{
			magic = new MagicEntityBegiragon(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityBegirama)
		{
			magic = new MagicEntityBegirama(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityDoruma)
		{
			new MagicEntityDoruma(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityGira)
		{
			magic = new MagicEntityGira(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityGiragureido)
		{
			magic = new MagicEntityGiragureido(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityHyado)
		{
			magic = new MagicEntityHyado(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityIo)
		{
			magic = new MagicEntityIo(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityMera)
		{
			magic = new MagicEntityMera(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityMeragaia)
		{
			magic = new MagicEntityMeragaia(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityMerami)
		{
			magic = new MagicEntityMerami(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityMerazoma)
		{
			magic = new MagicEntityMerazoma(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}else if(par2 instanceof MagicEntityRaidein)
		{
			magic = new MagicEntityRaidein(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, ((MagicEntityRaidein)par2).getLightningCnt());
		}else if(par2 instanceof MagicEntityZaki)
		{
			magic = new MagicEntityZaki(par1.worldObj, par1, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
		}

		magic.shootingEntity = par1;

		magic.setDamage(par2.getDamage() * damageRate);
		//System.out.println(par2.getDamage());
		if(sound != null)
		{
			par1.worldObj.playSoundAtEntity(par1, sound, 1.0F, 1.0F);
		}
		par1.worldObj.spawnEntityInWorld(magic);
	}

	public boolean canAttackPetMonster(DqmPetBase pet, EntityPlayer attacker)
	{
		//System.out.println("TEST3");
		if(pet.getOwner() != null && pet.getOwner() instanceof EntityPlayer)
		{
			//System.out.println("TEST4");
			if(!attacker.canAttackPlayer((EntityPlayer)pet.getOwner()) || attacker == (EntityPlayer)pet.getOwner() ||
					attacker.getUniqueID().toString().equalsIgnoreCase(pet.getOwner().getUniqueID().toString()))
			{
				//System.out.println("TEST5");
				return false;
			}
		}else
		{
			//System.out.println("TEST6");
			if(!pet.worldObj.isRemote)
			{
				//System.out.println("TEST7");
				MinecraftServer minecraftserver = MinecraftServer.getServer();
				if(!minecraftserver.isPVPEnabled() && DQR.conf.offlinePlayerPetAttack == 0)
				{
					//System.out.println("TEST8");
					return false;
				}
			}
		}


		return true;
	}

	public boolean isNoChestAround(World world, int posX, int posY, int posZ)
	{
		if(world.getBlock(posX + 1, posY, posZ) == Blocks.chest) return false;
		if(world.getBlock(posX - 1, posY, posZ) == Blocks.chest) return false;
		if(world.getBlock(posX, posY, posZ + 1) == Blocks.chest) return false;
		if(world.getBlock(posX, posY, posZ - 1) == Blocks.chest) return false;
		return true;
	}

	public float getFace(EntityLivingBase par1, boolean par2)
	{
		float ret = 0;

		float param = par1.rotationYaw;

		if(par2)
		{
			if(param >= -23 && param < 22)
			{
				ret = 0.0f;
			}else if(param >= 22 && param < 67)
			{
				ret = 0.5f;
			}else if(param >= 67 && param < 112)
			{
				ret = 1.0f;
			}else if(param >= 112 && param < 157)
			{
				ret = 1.5f;
			}else if(param >= 157 && param < 202)
			{
				ret = 2.0f;
			}else if(param >= 202 && param < 247)
			{
				ret = 2.5f;
			}else if(param >= 247 && param < 292)
			{
				ret = 3.0f;
			}else if(param >= 292 && param < 337)
			{
				ret = 3.5f;
			}else if(param >= 337)
			{
				ret = 0;
			}else if(param < -23 && param >= -68)
			{
				ret = 3.5f;
			}else if(param < -68 && param >= -113)
			{
				ret = 3.0f;
			}else if(param < -113 && param >= -158)
			{
				ret = 2.5f;
			}else if(param < -158 && param >= -203)
			{
				ret = 2.0f;
			}else if(param < -203 && param >= -248)
			{
				ret = 1.5f;
			}else if(param < -248 && param >= -293)
			{
				ret = 1.0f;
			}else if(param < -293 && param >= -338)
			{
				ret = 0.5f;
			}else if(param < -338)
			{
				ret = 0.0f;
			}
		}else
		{
			if(param >= -45 && param < 45)
			{
				ret = 0.0f;
			}else if(param >= 45 && param < 135)
			{
				ret = 1.0f;
			}else if(param >= 135 && param < 225)
			{
				ret = 2.0f;
			}else if(param >= 225 && param < 315)
			{
				ret = 3.0f;
			}else if(param >= 315)
			{
				ret = 0.0f;
			}else if(param < -45 && param >= -135)
			{
				ret = 3.0f;
			}else if(param < -135 && param >= -225)
			{
				ret = 2.0f;
			}else if(param < -225 && param >= -315)
			{
				ret = 1.0f;
			}else if(param < 315)
			{
				ret = 0.0f;
			}
		}



		return ret;
	}

	public boolean setBlockAndCheck(World world, int p_147465_1_, int p_147465_2_, int p_147465_3_, Block p_147465_4_, int p_147465_5_, int p_147465_6_)
	{
		boolean ret = false;
		float blockHardness = world.getBlock(p_147465_1_, p_147465_2_, p_147465_3_).getBlockHardness(world, p_147465_1_, p_147465_2_, p_147465_3_);
		if(blockHardness > -1.0f)
		{
			ret = world.setBlock(p_147465_1_, p_147465_2_, p_147465_3_, p_147465_4_, p_147465_5_, p_147465_6_);
		}

		return ret;
	}

	public EntityPlayerMP getPlayerFromUUID(UUID par1)
	{
		EntityPlayerMP entityplayermp;
		MinecraftServer minecraftserver = MinecraftServer.getServer();

        for (int i = 0; i < minecraftserver.getConfigurationManager().playerEntityList.size(); ++i)
        {
            entityplayermp = (EntityPlayerMP)minecraftserver.getConfigurationManager().playerEntityList.get(i);

            if (entityplayermp.getUniqueID().equals(par1))
            {
                return entityplayermp;
            }
        }

        return null;
	}

	public EntityPlayerMP getPlayerFromName(String name)
	{
		MinecraftServer minecraftserver = MinecraftServer.getServer();
		return minecraftserver.getConfigurationManager().func_152612_a(name);
	}

	public void lvUpProcessMain(EntityPlayer ep)
	{
		//System.out.println("DEBUG111111111111111");
		boolean flg = true;
		int epJob = ExtendedPlayerProperties.get(ep).getJob();
		int epLv = ExtendedPlayerProperties.get(ep).getJobLv(epJob);
		int epEXP = ExtendedPlayerProperties.get(ep).getJobExp(epJob);

		if((epLv >= 100 && DQR.conf.recalcLvStatus1 == 1) || DQR.debug == 12)
		{
			epLv = 0;
			ExtendedPlayerProperties.get(ep).setJobLv(ExtendedPlayerProperties.get(ep).getJob(), 0);
			ExtendedPlayerProperties.get(ep).setJobHP(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobMP(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobTikara(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobKasikosa(epJob, 0);
		}

		//バージョン管理 再計算
		int stVer = ExtendedPlayerProperties.get(ep).getJobStatusVersion();

		if(stVer < DQR.jobStatusVersion)
		{
			ExtendedPlayerProperties.get(ep).setJobHP(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobMP(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobTikara(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobKasikosa(epJob, 0);

			for(int cntJ = 0; cntJ < 32; cntJ++)
			{
				for(int cnt = 0; cnt <= ExtendedPlayerProperties.get(ep).getJobLv(cntJ); cnt++)
				{
					lvUpStatusUp(cnt, ep, cntJ, false);
				}
			}
			ExtendedPlayerProperties.get(ep).setJobStatusVersion(DQR.jobStatusVersion);
		}

		for (int i = 0; i < 100; i++)
		{
			//System.out.println("DEBUG2222222222");
			flg = true;
			//System.out.println("DEBUG" + "/" + epLv + "/" + epEXP);
			if(epLv < 99 && epEXP >= DQR.exp.getNextExp(epLv))
			{
				epLv = epLv + 1;
				ExtendedPlayerProperties.get(ep).setJobLv(ExtendedPlayerProperties.get(ep).getJob(), epLv);
				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.lvUp.txt",new Object[] {epLv}));
				lvUpStatusUp(epLv, ep);
				lvUpRefresh(ep);

				ep.worldObj.playSoundAtEntity(ep, "dqr:player.levelup", 1.0F, 1.0F);
				PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)0), (EntityPlayerMP)ep);

				flg = false;

				//外部からの干渉用
				DqmLvUpEvent event = new DqmLvUpEvent(ep,
													  ExtendedPlayerProperties.get(ep).getJob(),
													  epLv);
				event.setCanceled(false);
				MinecraftForge.EVENT_BUS.post(event);

				if (event.isCanceled())
				{
					//System.out.println("STOP1");
					break;
				}
			}

			if(flg)
			{
				//System.out.println("STOP2");
				break;
			}
		}
	}

	public void lvUpStatusUp(int lv, EntityPlayer ep)
	{
		this.lvUpStatusUp(lv, ep, ExtendedPlayerProperties.get(ep).getJob(), true);
	}

	public void lvUpStatusUp(int lv, EntityPlayer ep, int jobLv, boolean setMaxStatus)
	{
		Random rand = new Random();
		int epJob = jobLv;

		//HP
		float plusHpVal = 0.0F;
		int plusMpVal = 0;
		int plusTikaraVal = 0;
		int plusKasikosaVal = 0;

		EnumDqmJob jobEnum = DQR.enumGetter.getJobFromId(epJob);

		plusHpVal = jobEnum.getHpAbs() + rand.nextInt(jobEnum.getHpRan());
		plusMpVal = jobEnum.getMpAbs() + rand.nextInt(jobEnum.getMpRan());

		if(jobEnum.getTikaraAbs() != 0)
		{
			int randNum = rand.nextInt(99);
			//System.out.println("LvUP TEST 1 : (" + lv + ") " + jobEnum.getTikaraAbs() + " : " + jobEnum.getTikaraRan() + "[" + randNum  + "]");

			plusTikaraVal = (lv % jobEnum.getTikaraAbs() == 0 ? 1 : 0) + (randNum <  jobEnum.getTikaraRan() ? 1 : 0);
		}else
		{
			int randNum = rand.nextInt(99);
			plusTikaraVal = randNum <  jobEnum.getTikaraRan() ? 1 : 0;
		}


		if(jobEnum.getKasikosaAbs() != 0)
		{
			plusKasikosaVal = (lv % jobEnum.getKasikosaAbs() == 0 ? 1 : 0) + (rand.nextInt(99) <  jobEnum.getKasikosaRan() ? 1 : 0);
		}else
		{
			plusKasikosaVal = rand.nextInt(99) <  jobEnum.getKasikosaRan() ? 1 : 0;
		}

		//DQR.func.debugString("Job:" + plusHpVal + "/" + plusMpVal + "/" + plusTikaraVal + "/" + plusKasikosaVal);
		ExtendedPlayerProperties.get(ep).setJobHP(epJob, ExtendedPlayerProperties.get(ep).getJobHP(epJob) + plusHpVal);
		ExtendedPlayerProperties.get(ep).setJobMP(epJob, ExtendedPlayerProperties.get(ep).getJobMP(epJob) + plusMpVal);
		ExtendedPlayerProperties.get(ep).setJobTikara(epJob, ExtendedPlayerProperties.get(ep).getJobTikara(epJob) + plusTikaraVal);
		ExtendedPlayerProperties.get(ep).setJobKasikosa(epJob, ExtendedPlayerProperties.get(ep).getJobKasikosa(epJob) + plusKasikosaVal);

		if(setMaxStatus)
		{
			ExtendedPlayerProperties.get(ep).setMaxHP(DQR.calcPlayerStatus.calcHP(ep));
			ExtendedPlayerProperties.get(ep).setMaxMP(DQR.calcPlayerStatus.calcMP(ep));

			ep.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ExtendedPlayerProperties.get(ep).getMaxHP());
		}
	}


	public void doAddChatMessageFix(Entity ep, ChatComponentTranslation chat)
	{
		if(ep != null && ep instanceof EntityPlayer)
		{
			EntityPlayer epr = (EntityPlayer)ep;
			if(!epr.getCommandSenderName().equalsIgnoreCase("[Minecraft]"))
			{
				epr.addChatMessage(chat);
			}
		}
	}

	public void lvUpRefresh(EntityPlayer ep)
	{
		ExtendedPlayerProperties.get(ep).setHP(ExtendedPlayerProperties.get(ep).getMaxHP());
		ep.setHealth(ep.getMaxHealth());
		ExtendedPlayerProperties.get(ep).setMP(ExtendedPlayerProperties.get(ep).getMaxMP());
		//ep.getFoodStats().setFoodLevel(20);
		ep.getFoodStats().addStats(20, 0.6F);
	}

	public void doFoodEaten(EntityLivingBase ep, DqmItemFoodSeedBase item)
	{
		Random rand = new Random();
		float healHP = 0.0F;

		if(item.getMinHP() > -1 || item.getMaxHP() > -1)
		{
			healHP = item.getMinHP() + rand.nextInt(item.getMaxHP() + 1);
		}

		if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemBannouyaku.getUnlocalizedName()))
		{
			//ep.setHealth(30.0F + (float)rand.nextInt(10));
			ep.removePotionEffect(DQPotionMinus.potionPoison.id);
			ep.removePotionEffect(DQPotionMinus.potionPoisonX.id);
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemJouyakusou.getUnlocalizedName()))
		{
			//healHP = 40.0F + (float)rand.nextInt(10);
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTokuyakusou.getUnlocalizedName()))
		{
			//healHP = 70.0F + (float)rand.nextInt(20);
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemYakusou.getUnlocalizedName()))
		{
			//healHP = 8.0F + (float)rand.nextInt(5);
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemYakusou2.getUnlocalizedName()))
		{
			//healHP = 35.0F + (float)rand.nextInt(20);
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemYakusou3.getUnlocalizedName()))
		{
			//healHP = 60.0F + (float)rand.nextInt(40);
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemDokukesisou.getUnlocalizedName()))
		{
			//healHP = (float)rand.nextInt(5);
			ep.removePotionEffect(DQPotionMinus.potionPoison.id);
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionDokukesisou.id, 200, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemDokukesisou2.getUnlocalizedName()))
		{
			//healHP = 10.0F + (float)rand.nextInt(10);
			ep.removePotionEffect(DQPotionMinus.potionPoison.id);
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionDokukesisou.id, 300, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemDokukesisou3.getUnlocalizedName()))
		{
			ep.removePotionEffect(DQPotionMinus.potionPoison.id);
			ep.removePotionEffect(DQPotionMinus.potionPoisonX.id);
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionDokukesisou.id, 400, 1));
			//healHP = 20.0F + (float)rand.nextInt(10);
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTikaranotane.getUnlocalizedName()))
		{
			//System.out.println("DEBUGLINE:" + item.getUnlocalizedName());
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionTikaranotane.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTikaranotane2.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionTikaranotane.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTikaranotane3.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionTikaranotane.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMamorinotane.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMamorinotane.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMamorinotane2.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMamorinotane.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMamorinotane3.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMamorinotane.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemSubayasanotane.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemSubayasanotane2.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemSubayasanotane3.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemHonoonomi.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionHonoonomi.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemHonoonomi2.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionHonoonomi.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemHonoonomi3.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionHonoonomi.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionIyasinomi.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi2.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionIyasinomi.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi3.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionIyasinomi.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMahounomi.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI2.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMahounomi.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI3.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMahounomi.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMaryokunotaneI.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMaryokunotane.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMaryokunotaneI2.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMaryokunotane.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMaryokunotaneI3.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionMaryokunotane.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionOugonnomi.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon2.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionOugonnomi.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon3.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionOugonnomi.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon4.getUnlocalizedName()))
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.potionOugonnomi.id, 600, 3));
		}


		ep.heal(healHP);
		/*
		if(healHP + ep.getHealth() > ep.getMaxHealth())
		{
			ep.setHealth(ep.getMaxHealth());
		}else
		{
			ep.setHealth(ep.getHealth() + healHP);
		}
		*/
	}
}
