package dqr.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

import net.minecraft.block.Block;
import net.minecraft.client.resources.I18n;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.DQR;
import dqr.PacketHandler;
import dqr.api.Items.DQEmblems;
import dqr.api.Items.DQSeeds;
import dqr.api.enums.EnumDqmJob;
import dqr.api.event.DqmJukurenUpEvent;
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
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.ExtendedPlayerProperties5;
import dqr.potion.DqmPotionEffect;

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
    	boolean flg = false;

		pe = par1.getActivePotionEffect(DQPotionMinus.debuffStop);
		if(pe != null && pe.getDuration() > 0)
		{
			//System.out.println("Rariho:" + pe.getDuration());
			flg = true;
		}

		pe = par1.getActivePotionEffect(DQPotionMinus.debuffRariho);
		//if(pe != null && par1.worldObj.isRemote && pe.getDuration() > 0)
		if(pe != null && pe.getDuration() > DQR.conf.rarihoFreeDuration)
		{
			//System.out.println("Rariho:" + pe.getDuration());
			flg =  true;
		}


		if(par1 instanceof EntityPlayer)
		{
			EntityPlayer ent = (EntityPlayer)par1;

			//遊び人スキル
			if(ExtendedPlayerProperties5.get(ent).getJobSPSkillDuration(EnumDqmJob.Asobinin.getId(), 2, ent.worldObj.getWorldTime()) > 0)
			{
				flg =  true;
			}
		}else if(par1 instanceof DqmPetBase)
		{
			DqmPetBase ent = (DqmPetBase)par1;

			//遊び人スキル
			if(ent.getJobSPSkillDuration(EnumDqmJob.Asobinin.getId(), 2) > 0)
			{
				flg =  true;
			}
		}else if(par1 instanceof DqmMobBase)
		{
			DqmMobBase ent = (DqmMobBase)par1;

			//遊び人スキル
			if(ent.getJobSPSkillDuration(EnumDqmJob.Asobinin.getId(), 2) > 0)
			{
				flg =  true;
			}
		}

		//.func_111184_a(SharedMonsterAttributes.movementSpeed, "91AEAA56-376B-4498-935B-2F7F68070636", 0.20000000298023224D, 2);
		// func_111184_a(IAttribute p_111184_1_, String p_111184_2_, double p_111184_3_, int p_111184_5_)

		AttributeModifier attributemodifier = new AttributeModifier(UUID.fromString("A1AEAA56-376B-4498-935B-2F7F68070636"), "DQR-BIND-SPEED-SET", -10D, 0);
		if(flg)
		{
			//SharedMonsterAttributes.movementSpeed, "91AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2
			//AttributeModifier attributemodifier = new AttributeModifier(UUID.fromString(p_111184_2_), this.getName(), p_111184_3_, p_111184_5_);
			if(par1.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getModifier(UUID.fromString("A1AEAA56-376B-4498-935B-2F7F68070636")) == null)
			{
				par1.getEntityAttribute(SharedMonsterAttributes.movementSpeed).applyModifier(attributemodifier);
			}
		}else
		{
			if(par1.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getModifier(UUID.fromString("A1AEAA56-376B-4498-935B-2F7F68070636")) != null)
			{
				par1.getEntityAttribute(SharedMonsterAttributes.movementSpeed).removeModifier(attributemodifier);
			}
		}

		return flg;
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
		this.debugString(par1, null, -1);
		/*
		if(DQR.debug != 0)
		{
			System.out.println(par1);
		}
		*/
	}

	public void debugString(String par1, Class par2)
	{
		this.debugString(par1, par2, -1);
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
			if(DQR.debug == debugNo || (debugNo == -1 && DQR.debug != 0))
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

	public void jukurenUpProcessMain(EntityPlayer ep)
	{
		this.jukurenUpProcessMain(ep, 0, -1);
	}

	public void jukurenUpProcessMain(EntityPlayer ep, int recalcFlg, int weaponId)
	{
		boolean flg = true;

		int weapon = -1;

		if(weaponId != -1)
		{
			weapon = weaponId;
		}else
		{
			weapon = ExtendedPlayerProperties.get(ep).getWeapon();
		}

		if(recalcFlg > 0)
		{
			ExtendedPlayerProperties.get(ep).setJukurenLv(weapon, 0);
			ExtendedPlayerProperties.get(ep).setJukurenWP(weapon, 0);
			ExtendedPlayerProperties3.get(ep).setWeaponSkillSet(weapon, 0);
			ExtendedPlayerProperties3.get(ep).setWeaponSkillPermissionC(weapon, new int[ExtendedPlayerProperties3.SKILL_MAX_COUNTER]);
			//ExtendedPlayerProperties.get(ep).setJukurenExp(weapon, 0);
		}

		int epLv = ExtendedPlayerProperties.get(ep).getJukurenLv(weapon);
		int epEXP = ExtendedPlayerProperties.get(ep).getJukurenExp(weapon);

		for (int i = 0; i < 20; i++)
		{
			flg = true;
			//System.out.println("DEBUG" + "/" + epLv + "/" + epEXP);
			if(epLv < 10 && epEXP >= DQR.exp.getJukurenNextExp(epLv))
			{
				//String weaponName = I18n.format("gui.weapon." + ExtendedPlayerProperties.get(this.ep).getWeapon());
				epLv = epLv + 1;
				ExtendedPlayerProperties.get(ep).setJukurenLv(weapon, epLv);

				int jukurenWP = ExtendedPlayerProperties.get(ep).getJukurenWP(weapon);

				switch(epLv)
				{
					case 2: jukurenWP = jukurenWP + 15; break;
					case 3: jukurenWP = jukurenWP + 25; break;
					case 4: jukurenWP = jukurenWP + 35; break;
					case 5: jukurenWP = jukurenWP + 45;  break;
					case 6: jukurenWP = jukurenWP + 55; break;
					case 7: jukurenWP = jukurenWP + 65; break;
					case 8: jukurenWP = jukurenWP + 75; break;
					case 9: jukurenWP = jukurenWP + 85; break;
					case 10: jukurenWP = jukurenWP + 100; break;
				}

				ExtendedPlayerProperties.get(ep).setJukurenWP(weapon, jukurenWP);
				//DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.jukurenUp.txt",new Object[] {weaponName, epLv}));
				DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.jukurenUp.txt",new Object[] {
						new ChatComponentTranslation("gui.weapon." + weapon), epLv}));
				ep.worldObj.playSoundAtEntity(ep, "dqr:player.skillup", 1.0F, 1.0F);
				PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)1), (EntityPlayerMP)ep);
				flg = false;

				//外部からの干渉用
				DqmJukurenUpEvent event = new DqmJukurenUpEvent(ep, weapon, epLv);
				event.setCanceled(false);
				MinecraftForge.EVENT_BUS.post(event);

				if (event.isCanceled())
				{
					break;
				}
			}

			if(flg)
			{
				break;
			}
		}
	}

	public void lvUpProcessMain(EntityPlayer ep)
	{
		this.lvUpProcessMain(ep, 0, -1);
	}

	public void lvUpProcessMain(EntityPlayer ep, int recalcFlg, int jobId)
	{
		//System.out.println("DEBUG111111111111111");
		boolean flg = true;
		int epJob = -1;
		int preJob = ExtendedPlayerProperties.get(ep).getJob();

		if(jobId == -1)
		{
			epJob = ExtendedPlayerProperties.get(ep).getJob();
		}else
		{
			epJob = jobId;
		}

		int epLv = ExtendedPlayerProperties.get(ep).getJobLv(epJob);
		int epEXP = ExtendedPlayerProperties.get(ep).getJobExp(epJob);

		if((epLv >= 100 && DQR.conf.recalcLvStatus1 == 1) || DQR.debug == 12|| recalcFlg != 0)
		{
			epLv = 0;
			ExtendedPlayerProperties.get(ep).setJobLv(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobHP(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobMP(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobTikara(epJob, 0);
			ExtendedPlayerProperties.get(ep).setJobKasikosa(epJob, 0);
		}

		//バージョン管理 再計算
		int stVer = ExtendedPlayerProperties.get(ep).getJobStatusVersion();

		if(stVer < DQR.jobStatusVersion)
		{
			for(int cntJ = 0; cntJ < 32; cntJ++)
			{
				ExtendedPlayerProperties.get(ep).setJobHP(cntJ, 0);
				ExtendedPlayerProperties.get(ep).setJobMP(cntJ, 0);
				ExtendedPlayerProperties.get(ep).setJobTikara(cntJ, 0);
				ExtendedPlayerProperties.get(ep).setJobKasikosa(cntJ, 0);

				for(int cnt = 1; cnt <= ExtendedPlayerProperties.get(ep).getJobLv(cntJ); cnt++)
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
				ExtendedPlayerProperties.get(ep).setJobLv(epJob, epLv);

				if(epJob == preJob)
				{
					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.lvUp.txt",new Object[] {epLv}));
				}else
				{
					DQR.func.doAddChatMessageFix(ep, new ChatComponentTranslation("msg.lvUp2." + epJob + ".txt",new Object[] {epLv}));
				}

				lvUpStatusUp(epLv, ep, epJob);
				lvUpRefresh(ep);

				ep.worldObj.playSoundAtEntity(ep, "dqr:player.levelup", 1.0F, 1.0F);
				PacketHandler.INSTANCE.sendTo(new MessageClientSound((byte)0), (EntityPlayerMP)ep);

				flg = false;

				//外部からの干渉用
				DqmLvUpEvent event = new DqmLvUpEvent(ep,
													  epJob,
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

	public void lvUpStatusUp(int lv, EntityPlayer ep, int jobId)
	{
		if(ExtendedPlayerProperties.get(ep).getJob() != jobId)
		{
			this.lvUpStatusUp(lv, ep, jobId, false);
		}else
		{
			this.lvUpStatusUp(lv, ep, jobId, true);
		}
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
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionDokukesisou.id, 200, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemDokukesisou2.getUnlocalizedName()))
		{
			//healHP = 10.0F + (float)rand.nextInt(10);
			ep.removePotionEffect(DQPotionMinus.potionPoison.id);
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionDokukesisou.id, 300, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemDokukesisou3.getUnlocalizedName()))
		{
			ep.removePotionEffect(DQPotionMinus.potionPoison.id);
			ep.removePotionEffect(DQPotionMinus.potionPoisonX.id);
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionDokukesisou.id, 400, 1));
			//healHP = 20.0F + (float)rand.nextInt(10);
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTikaranotane.getUnlocalizedName()))
		{
			//System.out.println("DEBUGLINE:" + item.getUnlocalizedName());
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionTikaranotane.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTikaranotane2.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionTikaranotane.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemTikaranotane3.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionTikaranotane.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMamorinotane.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionMamorinotane.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMamorinotane2.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionMamorinotane.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMamorinotane3.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionMamorinotane.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemSubayasanotane.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemSubayasanotane2.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemSubayasanotane3.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionSubayasanotane.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemHonoonomi.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionHonoonomi.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemHonoonomi2.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionHonoonomi.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemHonoonomi3.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionHonoonomi.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionIyasinomi.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi2.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionIyasinomi.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemIyasinomi3.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionIyasinomi.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionMahounomi.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI2.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionMahounomi.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMahounomiI3.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionMahounomi.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMaryokunotaneI.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionMaryokunotane.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMaryokunotaneI2.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionMaryokunotane.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemMaryokunotaneI3.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionMaryokunotane.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionOugonnomi.id, 600, 0));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon2.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionOugonnomi.id, 1200, 1));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon3.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionOugonnomi.id, 1800, 2));
		}else if(item.getUnlocalizedName().equalsIgnoreCase(DQSeeds.itemOugon4.getUnlocalizedName()))
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.potionOugonnomi.id, 600, 3));
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

	@SideOnly(Side.CLIENT)
    public static String getKeyDisplayString(int p_74298_0_)
    {
        return p_74298_0_ < 0 ? I18n.format("key.mouseButton", new Object[] {Integer.valueOf(p_74298_0_ + 101)}): Keyboard.getKeyName(p_74298_0_);
    }

    public Item getJobSPSkillItemFromJobId(int par1)
    {
    	switch(par1)
    	{
    	case 0: return DQEmblems.itemEmbCivilian;
    	case 1: return DQEmblems.itemEmbWarrior;
    	case 2: return DQEmblems.itemEmbFighter;
    	case 3: return DQEmblems.itemEmbBattleMaster;
    	case 4: return DQEmblems.itemEmbMagician;
    	case 5: return DQEmblems.itemEmbPriest;
    	case 6: return DQEmblems.itemEmbSage;
    	case 7: return DQEmblems.itemEmbHero;
    	case 8: return DQEmblems.itemEmbPaladin;
    	case 9: return DQEmblems.itemEmbMagickKnight;
    	case 10: return DQEmblems.itemEmbRanger;
    	case 11: return DQEmblems.itemEmbMonsterTamer;
    	case 12: return DQEmblems.itemEmbSuperStar;
    	case 13: return DQEmblems.itemEmbHaguremetal;
    	case 14: return DQEmblems.itemEmbMerchant;
    	case 15: return DQEmblems.itemEmbThief;
    	case 16: return DQEmblems.itemEmbGodHnad;
    	case 17: return DQEmblems.itemEmbDragon;
    	case 18: return DQEmblems.itemEmbLegend;
    	case 19: return DQEmblems.itemEmbDancer;
    	case 20: return DQEmblems.itemEmbPirate;
    	case 21: return DQEmblems.itemEmbMasterDragon;
    	case 22: return DQEmblems.itemEmbHituzikai;
    	case 23: return DQEmblems.itemEmbFunanori;
    	case 24: return DQEmblems.itemEmbDougutukai;
    	case 25: return DQEmblems.itemEmbTentiraimeishi;
    	default : return null;
    	}
    }

    /**
     * 指定座標とプレイヤーの間のランダムな空間座標を取得する
     *
     * @param world
     * @param x
     * @param y
     * @param z
     * @param ep
     * @return
     */
    public int[] getSpaceLocationPlayerFront(World world, int x, int y, int z, EntityPlayer ep)
    {
    	int[] ret = {-1, -1, -1};

    	ArrayList<Integer> tableX = new ArrayList();
    	ArrayList<Integer> tableY = new ArrayList();
    	ArrayList<Integer> tableZ = new ArrayList();

    	//指定座標とプレイヤー座標の中心座標を取得する。
    	int centerX = (x + (int)ep.posX) / 2;
    	int centerY = (y + (int)ep.posY) / 2;
    	int centerZ = (z + (int)ep.posZ) / 2;


    	return this.getSpaceLocationRandom(world, centerX, centerY, centerZ, 4, 3);
    }

    public int[] getSpaceLocationRandom(World world, int x, int y, int z, int radiusXZ, int radiusY)
    {
    	int[] ret = {x, y, z};

    	ArrayList<Integer> tableX = new ArrayList();
    	ArrayList<Integer> tableY = new ArrayList();
    	ArrayList<Integer> tableZ = new ArrayList();
    	int[] setX = new int[radiusXZ * 2 + 1];
    	int[] setZ = new int[radiusXZ * 2 + 1];
    	int[] setY = new int[radiusY * 2 + 1];

    	for(int cnt = radiusXZ * -1; cnt <= radiusXZ; cnt++)
    	{
    		tableX.add(cnt);
    		tableZ.add(cnt);
    	}
    	for(int cnt = radiusY * -1; cnt <= radiusY; cnt++)
    	{
    		tableY.add(cnt);
    	}

    	int idxCount = 0;
    	while(tableX.size() > 0)
    	{
    		Random random = new Random();
    		int selectNum = random.nextInt(tableX.size());
    		setX[idxCount] = tableX.get(selectNum);
    		tableX.remove(selectNum);

    		idxCount = idxCount + 1;
    	}

    	idxCount = 0;
    	while(tableY.size() > 0)
    	{
    		Random random = new Random();
    		int selectNum = random.nextInt(tableY.size());
    		setY[idxCount] = tableY.get(selectNum);
    		tableY.remove(selectNum);

    		idxCount = idxCount + 1;
    	}

    	idxCount = 0;
    	while(tableZ.size() > 0)
    	{
    		Random random = new Random();
    		int selectNum = random.nextInt(tableZ.size());
    		setZ[idxCount] = tableZ.get(selectNum);
    		tableZ.remove(selectNum);

    		idxCount = idxCount + 1;
    	}


    	for(int posX = 0; posX < radiusXZ * 2 + 1; posX++)
    	{
    		for(int posY = 0; posY < radiusY * 2 + 1; posY++)
    		{
    			for(int posZ = 0; posZ < radiusXZ * 2 + 1; posZ++)
    			{
    				if(world.isAirBlock(x + setX[posX], y + setY[posY], z + setZ[posZ]) &&
    					world.isAirBlock(x + setX[posX], y + setY[posY] + 1, z + setZ[posZ]))
    				{
    					ret[0] = x + setX[posX];
    					ret[1] = y + setY[posY];
    					ret[2] = z + setZ[posZ];

    					return ret;
    				}
    			}
    		}
    	}
    	return ret;
    }

    public PotionEffect addPotionEffect2(EntityLivingBase elb, PotionEffect potion)
    {
    	PotionEffect retPotion = potion;
    	int potionIdx = DQR.conf.PotionIDidx;
    	if(potion.getPotionID() >= potionIdx && potion.getPotionID() <= potionIdx + DQR.potion.tempNum)
    	{
    		elb.removePotionEffectClient(retPotion.getPotionID());
    		elb.addPotionEffect(new DqmPotionEffect(retPotion));
    	}else
    	{
    		elb.addPotionEffect(retPotion);
    	}

    	return retPotion;
    }

    public boolean removeBadEffectAll(EntityPlayer ep)
    {
    	boolean ret = false;

    	Collection potions = ep.getActivePotionEffects();
		ArrayList<PotionEffect> newPot = new ArrayList();

		for (Iterator it = potions.iterator(); it.hasNext();)
		{
			//System.out.println("TEST???????????????");
			PotionEffect eff = (PotionEffect)(it.next());
			Potion pot = Potion.potionTypes[eff.getPotionID()];
			try{
    			if(DQR.potionFunc.isPotionMinus(pot))
				{
    				newPot.add(eff);
				}else if(DQR.potionFunc.isDQPotionMinus(pot))
				{
					newPot.add(eff);
				}else if(ep.worldObj.isRemote)
				{
					if(pot.isBadEffect())
					{
						newPot.add(eff);
					}
				}
			}
    		catch(Exception e)
			{

			}
		}

		for(int cnt = 0; cnt < newPot.size(); cnt++)
		{
			if(newPot.get(cnt).getDuration() > 40)
			{
				ep.removePotionEffect(newPot.get(cnt).getPotionID());
			}
		}


		ExtendedPlayerProperties5.get(ep).refreshDqrPotionEffects(ep.worldObj.getWorldTime());

		NBTTagCompound dqrPotionSet = ExtendedPlayerProperties5.get(ep).getDqrPotionEffectsSet();
		Object[] keys = dqrPotionSet.func_150296_c().toArray();

		ArrayList<String> delPot = new ArrayList();

		for(int cnt3 = 0; cnt3 < keys.length; cnt3++)
		{
			try{
				String key = (String)keys[cnt3];
				NBTTagCompound nbt = dqrPotionSet.getCompoundTag(key);


				if(nbt.hasKey("isDebuff"))
				{
					if(nbt.getInteger("isDebuff") == 1)
					{
						delPot.add(key);
					}
				}
			}
			catch(Exception e)
			{

			}
		}

		for(int delCnt = 0; delCnt < delPot.size(); delCnt++)
		{
			ExtendedPlayerProperties5.get(ep).removeDqrPotionEffects(delPot.get(delCnt));
		}

		ExtendedPlayerProperties5.get(ep).refreshDqrPotionEffects(ep.worldObj.getWorldTime());

    	return ret;
    }

    /**
     * プレイヤーのホットバーのアイテムの中から最大の火力が出る物を取得し、その攻撃力を返す
     *
     * @param ep プレイヤー
     * @return idx0:アイテムスロット番号 idx1:最大攻撃力
     */
    public int[] getMaxAttackFromInventory(EntityPlayer ep)
    {
    	int[] ret = new int[2];
    	int maxCnt = DQR.conf.DqmDifficulty < 3 ? ep.inventory.mainInventory.length : ep.inventory.getHotbarSize();

    	int tmpDamage = -1;
    	int tmpIdx = -1;
    	int getDam = 0;
    	//ep.inventory.getHotbarSize()
    	for(int cnt = 0; cnt < maxCnt; cnt++)
    	{
    		ItemStack item =ep.inventory.mainInventory[cnt];
    		/*
    		if(item != null)
    		{
    			System.out.println("test : " + item.getDisplayName() + "[" + cnt + "]");
    		}
    		*/
    		getDam = DQR.calcPlayerStatus.calcAttack(ep, item);
    		if(tmpDamage < getDam)
    		{
    			tmpDamage = getDam;
    			tmpIdx = cnt;
    		}
    	}

    	//System.out.println("test : " + tmpDamage + " / " + tmpIdx);
    	ret[1] = tmpDamage;
    	ret[0] = tmpIdx;
    	return ret;
    }

    public ChatComponentTranslation getTransform(String key)
    {
    	return new ChatComponentTranslation(key,new Object[] {});
    }

}
