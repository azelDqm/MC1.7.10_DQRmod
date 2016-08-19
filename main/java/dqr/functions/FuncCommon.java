package dqr.functions;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.potion.DQPotionMinus;
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
		if(pe != null && pe.getDuration() > 0)
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

}
