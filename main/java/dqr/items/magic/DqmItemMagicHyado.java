package dqr.items.magic;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQMagics;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.potion.DQPotionMinus;
import dqr.entity.magicEntity.magic.MagicEntityHyado;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicHyado extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";

    public DqmItemMagicHyado(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

		PotionEffect pe;
		pe = par3EntityPlayer.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && par3EntityPlayer.worldObj.isRemote)
		{
	  		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.mahoton.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

    	if(par1ItemStack.getMaxDamage() * 90 / 100 > par1ItemStack.getItemDamage())
    	{

        	MagicEntityHyado[] magic = null;
        	/*
        	int minusMP = 0;
        	int minusDam = 0;
        	int needLvM = 0;
        	int needLvK = 0;
        	int hitCnt = 0;
        	*/

    		if(par1ItemStack.getItem() == DQMagics.itemHyado)
    		{
    			magic = new MagicEntityHyado[1];
    			for(int cnt = 0;cnt < 1; cnt++)
    			{
    				magic[cnt] = new MagicEntityHyado(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    				if(par3EntityPlayer.isSneaking())magic[cnt].setWorldFlg(0);
    			}

    			/*
    	   		minusMP = 3;
    	   		minusDam = 100;
    	   		needLvM = 5;
    	   		needLvK = 8;
    	   		*/

    		}else if(par1ItemStack.getItem() == DQMagics.itemHyadaruko)
    		{
    			magic = new MagicEntityHyado[3];
    			for(int cnt = 0;cnt < 3; cnt++)
    			{
    				magic[cnt] = new MagicEntityHyado(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-15.0F + (15.0F * cnt)), 0.0F);
    				if(par3EntityPlayer.isSneaking())magic[cnt].setWorldFlg(1);
    			}

    			/*
    	   		minusMP = 6;
    	   		minusDam = 150;
    	   		needLvM = 18;
    	   		needLvK = 18;
    	   		*/

    		}else if(par1ItemStack.getItem() == DQMagics.itemMahyado)
    		{
    			magic = new MagicEntityHyado[5];
    			for(int cnt = 0;cnt < 5; cnt++)
    			{
    				magic[cnt] = new MagicEntityHyado(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-30.0F + (15.0F * cnt)), 0.0F);
    				if(par3EntityPlayer.isSneaking())magic[cnt].setWorldFlg(2);
    			}
    			/*
    	   		minusMP = 11;
    	   		minusDam = 200;
    	   		needLvM = 34;
    	   		needLvK = 31;
    	   		*/

    		}else if(par1ItemStack.getItem() == DQMagics.itemMahyadodesu)
    		{
    			magic = new MagicEntityHyado[7];
    			for(int cnt = 0;cnt < 7; cnt++)
    			{
    				magic[cnt] = new MagicEntityHyado(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (15.0F * cnt)), 0.0F);
    				if(par3EntityPlayer.isSneaking())magic[cnt].setWorldFlg(3);
    			}
    			/*
    	   		minusMP = 21;
    	   		minusDam = 300;
    	   		needLvM = 63;
    	   		needLvK = 58;
    	   		*/

    		}


    		if(magic != null)
    		{
    			int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

    			if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
    			{
    				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
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
	    				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
	    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
	    			}
    			}
    		}
    	}else
    	{
    		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.noct.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    	}


        return par1ItemStack;
    }

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	p_77624_3_.add("");
    	String message = I18n.format("dqm.magicinfo.hyado.txt", new Object[]{});
    	String[] addLine = message.split("＄");
    	for(int cnt = 0; cnt < addLine.length; cnt++)
    	{
    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + addLine[cnt]);
    	}
    }
}
