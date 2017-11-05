package dqr.items.Subequip;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.entity.magicEntity.magic.MagicEntityBasiRura;
import dqr.items.base.DqmItemAccessoryBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemFuujinnnotate extends DqmItemAccessoryBase{
	private int magicLv = 0;

	public DqmItemFuujinnnotate(EnumDqmSubEquipType equipment, int lv) {
		super(equipment);
		this.magicLv = lv;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		if(par1ItemStack.getItemDamage() + (this.getMaxDamage() / 20) > this.getMaxDamage())
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.subequipUse.noDamage.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    		//System.out.println("wk2 :");
			return par1ItemStack;
		}else if(par1ItemStack.getItemDamage() >= (this.getMaxDamage() / 10 * 9))
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.subequipUse.noDamage.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    		//System.out.println("wk3 :");
			return par1ItemStack;
		}

		if(par3EntityPlayer.isSneaking())
    	{
			if(!par2World.isRemote)
			{
    			NBTTagCompound wd = par1ItemStack.getTagCompound();

    	        if (wd == null)
    	        {
    	        	wd = new NBTTagCompound();
    	        }


    	        wd.setInteger("teleX", (int)par3EntityPlayer.posX);
    	        wd.setInteger("teleY", (int)par3EntityPlayer.posY);
    	        wd.setInteger("teleZ", (int)par3EntityPlayer.posZ);
    	        wd.setInteger("teleDim", (int)par3EntityPlayer.dimension);

    	        par1ItemStack.setTagCompound(wd);
    	        par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mira", 0.9F, 0.9F);
			}

    	}else
    	{
    		NBTTagCompound wd = par1ItemStack.getTagCompound();
    		Random rand = new Random();

			int teleX;
			int teleY;
			int teleZ;
			int rangeMax = 1000;
			int rangeMin = 10;
			int mode = ExtendedPlayerProperties.get(par3EntityPlayer).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_BASIRURA.getId());

			if(mode == 0)
			{
				//ランダムテレポート
				teleX = (int)par3EntityPlayer.posX + rand.nextInt(rangeMax) + rangeMin;
				teleZ = (int)par3EntityPlayer.posZ + rand.nextInt(rangeMax) + rangeMin;
				teleY = DQR.func.getHeightValue2(par3EntityPlayer.worldObj, teleX, teleZ, 150,10);
			}else
			{
	    		if(wd == null || !wd.hasKey("teleX"))
	    		{
	    			if(!par2World.isRemote)
	    			{
	    				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoPos0.txt",new Object[] {}));
	    				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoPos1.txt",new Object[] {}));
	    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    			}
					return par1ItemStack;
	    		}

	    		if(wd.getInteger("teleDim") != par3EntityPlayer.dimension)
	    		{
	    			if(!par2World.isRemote)
	    			{
						par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoDim.txt",new Object[] {}));
						par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    			}
					return par1ItemStack;
	    		}

				teleX = wd.getInteger("teleX");
				teleY = wd.getInteger("teleY");
				teleZ = wd.getInteger("teleZ");
			}

    		/*
    		int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

			if(epMP < this.useMP && DQR.debug == 0)
			{
				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
				return par1ItemStack;
			}else
			{
				ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.useMP);
			}
			*/

    		if(!par2World.isRemote)
    		{
    			/*
				int teleX = wd.getInteger("teleX");
				int teleY = wd.getInteger("teleY");
				int teleZ = wd.getInteger("teleZ");
				*/
				MagicEntityBasiRura magic = null;

	        	magic = new MagicEntityBasiRura(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);


	    		if(magic != null)
	    		{
	    			//int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

					magic.setDamage(0);
					magic.setLevel(magicLv);
		        	magic.setRate(30);
		        	magic.shootingEntity = par3EntityPlayer;
		        	int[] loc = new int[3];
		        	loc[0] = teleX;
		        	loc[1] = teleY;
		        	loc[2] = teleZ;
		        	magic.setLocation(loc);

					//magic.setPotionEffect(new PotionEffect(this.pot.id, this.getEnumMagic().getAttack(), 0));
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
					//par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);
		        	if (!par2World.isRemote)
		        	{
		        		par2World.spawnEntityInWorld(magic);

		        	}
		        	//par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);
		        }
    		}

    		par1ItemStack.damageItem(this.getMaxDamage() / 20, par3EntityPlayer);
    	}

        return par1ItemStack;
    }
}
