package dqr.items.magic;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQMagics;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.magicEntity.magic.MagicEntityRaidein;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicRaidein extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";

    public DqmItemMagicRaidein(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

		PotionEffect pe;
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

    	if(par1ItemStack.getMaxDamage() * 90 / 100 > par1ItemStack.getItemDamage())
    	{

        	MagicEntityRaidein[] magic = null;
        	/*
        	int minusMP = 0;
        	int minusDam = 0;
        	int needLvM = 0;
        	int needLvK = 0;
        	int hitCnt = 0;
        	*/

    		if(par1ItemStack.getItem() == DQMagics.itemRaidein)
    		{
    			magic = new MagicEntityRaidein[1];
    			for(int cnt = 0;cnt < 1; cnt++)
    			{
    				magic[cnt] = new MagicEntityRaidein(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0);
    	    		if(par3EntityPlayer.isSneaking())
    	    		{
    	    			magic[cnt].setWorldFlg(true);
    	    		}
    			}

    			/*
    	   		minusMP = 3;
    	   		minusDam = 100;
    	   		needLvM = 5;
    	   		needLvK = 8;
    	   		*/

    		}else if(par1ItemStack.getItem() == DQMagics.itemGigadein)
    		{
    			magic = new MagicEntityRaidein[3];
    			for(int cnt = 0;cnt < 3; cnt++)
    			{
    				magic[cnt] = new MagicEntityRaidein(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (45.0F * cnt)), 0.0F, 1);
    	    		if(par3EntityPlayer.isSneaking())
    	    		{
    	    			magic[cnt].setWorldFlg(true);
    	    		}
    			}

    			/*
    	   		minusMP = 6;
    	   		minusDam = 150;
    	   		needLvM = 18;
    	   		needLvK = 18;
    	   		*/

    		}else if(par1ItemStack.getItem() == DQMagics.itemMinadein)
    		{
    			magic = new MagicEntityRaidein[5];
    			for(int cnt = 0;cnt < 5; cnt++)
    			{
    				magic[cnt] = new MagicEntityRaidein(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-90.0F + (45.0F * cnt)), 0.0F, 2);
    	    		if(par3EntityPlayer.isSneaking())
    	    		{
    	    			magic[cnt].setWorldFlg(true);
    	    		}
    			}
    			/*
    	   		minusMP = 11;
    	   		minusDam = 200;
    	   		needLvM = 34;
    	   		needLvK = 31;
    	   		*/

    		}

    		if(magic != null)
    		{
    			int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

    			if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
    			{
    				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    			}else
    			{
	    			if(epMP >= this.getEnumMagic().getMP() || DQR.debug > 0)
	    			{
	    				/*
	    				int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
	    						        / par1ItemStack.getMaxDamage() * this.getEnumMagic().getAttack() / 100;
	    				attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);
	    				*/
	    				int matk = ExtendedPlayerProperties.get(par3EntityPlayer).getMaryoku();
	    				int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
						        / par1ItemStack.getMaxDamage() *  matk / 100;
	    				attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);

	    				if(this.getEnumMagic().getDamage() + par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage() )
	    				{
	    					par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);
	    				}else
	    				{
	    					par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
	    				}

	    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
	    				ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
    	        		for(int cnt = 0; cnt < magic.length; cnt++)
    	        		{
		    				magic[cnt].setDamage(attackDam);
		    	        	if (!par2World.isRemote)
		    	        	{

		    	        		par2World.spawnEntityInWorld(magic[cnt]);

		    	        	}
    	        		}
	    			}else
	    			{
	    				magic = null;
	    				par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
	    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    			}
    			}
    		}
    	}else
    	{
    		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noct.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    	}


        return par1ItemStack;
    }

}
