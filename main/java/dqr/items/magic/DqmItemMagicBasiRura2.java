package dqr.items.magic;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmWeaponMode;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.magicEntity.magic.MagicEntityBasiRura;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicBasiRura2 extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";
    public DqmItemMagicBasiRura2(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);
    }

    @Override
    public void onUpdate(ItemStack var1, World var2, Entity var3, int par4, boolean par5)
    {

    	if(var1.getItemDamage() < 0)
    	{

    	}else if(var1.getItemDamage() > 0)
    	{
    		var1.setItemDamage(var1.getItemDamage() - 1);
    	}

    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		PotionEffect pe;
		Random rand = new Random();
		pe = par3EntityPlayer.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.mahoton.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		if(par3EntityPlayer.isSneaking())
    	{
			if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
			{
    			if(!par2World.isRemote)
    			{
    				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
    			}
				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
			}else
			{
    			if(!par2World.isRemote)
    			{
    				ExtendedPlayerProperties.get(par3EntityPlayer).setBasiRura(this.getEnumMagic().getType(), par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, par3EntityPlayer.dimension, 1);
        	        par3EntityPlayer.addChatMessage(new ChatComponentTranslation("dqm.iteminfo.kimeraLoc.2.txt",new Object[] {par3EntityPlayer.dimension,
        	        		Math.floor(par3EntityPlayer.posX),
        	        		Math.floor(par3EntityPlayer.posY),
        	        		Math.floor(par3EntityPlayer.posZ)}));
    			}
    	        par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mira", 0.9F, 0.9F);
			}
    	}else
    	{
	    	if(par1ItemStack.getItemDamage() == 0 || DQR.debug > 0)
	    	{
	    		if(!par2World.isRemote)
	    		{
		    		int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

		    		if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
		    		{
						par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
						par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

						return par1ItemStack;
		    		}

					if(epMP < this.getEnumMagic().getMP() && DQR.debug == 0)
					{
						par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
						par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
						return par1ItemStack;
					}else
					{
						ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
					}



		    		int epLevel = ExtendedPlayerProperties.get(par3EntityPlayer).getJobLv(EnumDqmJob.Mahoutukai.getId());
		    		int epLevel2 = ExtendedPlayerProperties.get(par3EntityPlayer).getJobLv(EnumDqmJob.Kenja.getId());
		    		int setLevel = -1;
		    		int mode = ExtendedPlayerProperties.get(par3EntityPlayer).getWeaponMode(EnumDqmWeaponMode.WEAPONMODE_BASIRURA.getId());

		    		if(epLevel2 >= 60 || epLevel >= 60 || DQR.debug != 0)
		    		{
		    			setLevel = 3;
		    		}else if(epLevel2 >= 50 || epLevel >= 50)
		    		{
		    			setLevel = 2;
		    		}else if(epLevel2 >= 40 || epLevel >= 40)
		    		{
		    			setLevel = 1;
		    		}else if(epLevel2 >= 30 || epLevel >= 25)
		    		{
		    			setLevel = 0;
		    		}else
		    		{
						par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
						par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

						return par1ItemStack;
		    		}


		    		Random rand_jukuren = new Random();
					if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
					{

						int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
						ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
					}

		    		//座標取得
					int teleX = 0;
					int teleY = 0;
					int teleZ = 0;

					int rangeMax = 1000;
					int rangeMin = 10;

					if(mode == 0)
					{
						//ランダムテレポート
						teleX = (int)par3EntityPlayer.posX + rand.nextInt(rangeMax) + rangeMin;
						teleZ = (int)par3EntityPlayer.posZ + rand.nextInt(rangeMax) + rangeMin;
						teleY = DQR.func.getHeightValue2(par3EntityPlayer.worldObj, teleX, teleZ, 150,10);
					}else
					{
						//位置指定テレポート
		    	        if(ExtendedPlayerProperties.get(par3EntityPlayer).getBasiRuraEnable(this.getEnumMagic().getType()) == 0)
		    	        {
	        				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoPos0.txt",new Object[] {}));
	        				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoPos1.txt",new Object[] {}));
	        				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	        				return par1ItemStack;
		    	        }else if(ExtendedPlayerProperties.get(par3EntityPlayer).getBasiRuraDim(this.getEnumMagic().getType()) != par3EntityPlayer.dimension)
		    	        {
	        				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoDim.txt",new Object[] {}));
	        				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	        				return par1ItemStack;
		    	        }

		    	        //ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());

		    	        teleX = (int)ExtendedPlayerProperties.get(par3EntityPlayer).getBasiRuraX(this.getEnumMagic().getType());
		    	        teleY = (int)ExtendedPlayerProperties.get(par3EntityPlayer).getBasiRuraY(this.getEnumMagic().getType());
		    	        teleZ = (int)ExtendedPlayerProperties.get(par3EntityPlayer).getBasiRuraZ(this.getEnumMagic().getType());


		    	        /*
						DqrWorldData wd = (DqrWorldData)par2World.loadItemData(DqrWorldData.class, DQR.modID);

				        if (wd == null)
				        {
				        	wd = new DqrWorldData(DQR.modID);
				        }

				        if(wd.getBasiRuraEnable(this.getEnumMagic().getType()) == 0)
				        {
							par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoPos0.txt",new Object[] {}));
							par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoPos1.txt",new Object[] {}));
							par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
							return par1ItemStack;
				        }else if(wd.getBasiRuraDim(this.getEnumMagic().getType()) != par3EntityPlayer.dimension)
				        {
							par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.ruraNoDim.txt",new Object[] {}));
							par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
							return par1ItemStack;
				        }
				        */

					}

		        	MagicEntityBasiRura magic = null;

		        	magic = new MagicEntityBasiRura(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);


		    		if(magic != null)
		    		{
		    			//int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

						magic.setDamage(0);
						magic.setLevel(setLevel);
			        	magic.setRate(this.getEnumMagic().getRate());
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
			        	par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);
			        }
	    		}

	    	}else
	    	{
	    		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noct.txt",new Object[] {}));
	    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    	}
    	}

        return par1ItemStack;
    }

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	if(ExtendedPlayerProperties.get(p_77624_2_).getBasiRuraEnable(this.getEnumMagic().getType()) != 0)
    	{
	    	int setDim = (int)ExtendedPlayerProperties.get(p_77624_2_).getBasiRuraDim(this.getEnumMagic().getType());
	        double setX = Math.floor(ExtendedPlayerProperties.get(p_77624_2_).getBasiRuraX(this.getEnumMagic().getType()));
	        double setY = Math.floor(ExtendedPlayerProperties.get(p_77624_2_).getBasiRuraY(this.getEnumMagic().getType()));
	        double setZ = Math.floor(ExtendedPlayerProperties.get(p_77624_2_).getBasiRuraZ(this.getEnumMagic().getType()));
	    	p_77624_3_.add(EnumColor.Gold.getChatColor() + I18n.format("dqm.iteminfo.kimeraLoc.1.txt", new Object[]{setDim, setX, setY, setZ}));
    	}

    	p_77624_3_.add("");
    	String message = I18n.format("dqm.magicinfo.basirura.txt", new Object[]{});
    	String[] addLine = message.split("＄");
    	for(int cnt = 0; cnt < addLine.length; cnt++)
    	{
    		p_77624_3_.add(addLine[cnt]);
    	}
    }
}
