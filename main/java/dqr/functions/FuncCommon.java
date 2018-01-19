package dqr.functions;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.potion.DQPotionMinus;
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
		if(DQR.debug != 0)
		{
			System.out.println(par1);
		}
	}

	public void debugString(String par1, Class par2)
	{
		if(DQR.debug != 0)
		{
			System.out.println(par2.getName() + "/" + par1);
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
}
