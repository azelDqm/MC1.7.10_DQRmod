package dqr.items.magic;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQMagics;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.potion.DQPotionEtc;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.magicEntity.magic.MagicEntityBuff;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicBuff extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";
    private Potion pot;
    public DqmItemMagicBuff(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4, Potion pot)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);
    	this.pot = pot;
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

    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	this.onItemRightClick(p_77648_1_, p_77648_3_, p_77648_2_);
    	//System.out.println("USE");
    	return false;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
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

    	if(par1ItemStack.getItemDamage() == 0)
    	{

    		int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

    		if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
    		{
				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

				return par1ItemStack;
    		}

    		if(this != DQMagics.itemUminarinotue && this != DQMagics.itemCallMagma)
    		{
				if(epMP < this.getEnumMagic().getMP() && DQR.debug == 0)
				{
					DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
					return par1ItemStack;
				}else
				{
					ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
				}
    		}

    		par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);


			if(this == DQMagics.itemSukuruto || this == DQMagics.itemFubaha ||this == DQMagics.itemPiorimu)
			{
	    		Random rand_jukuren = new Random();
				if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
				{

					int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
					ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
				}

				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
				if(par3EntityPlayer.isPotionActive(DQPotionPlus.buffMahokanta))
				{
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mahokanta", 1.0F, 1.0F);
				}else
				{
					DQR.func.addPotionEffect2(par3EntityPlayer, new PotionEffect(this.pot.id, this.getEnumMagic().getAttack(), 0));
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.up", 1.0F, 1.0F);
				}

	            List list = par2World.getEntitiesWithinAABBExcludingEntity(par3EntityPlayer,
	            		par3EntityPlayer.boundingBox.addCoord(par3EntityPlayer.motionX, par3EntityPlayer.motionY, par3EntityPlayer.motionZ).expand(10.0D, 5.0D, 10.0D));

	            if (list != null && !list.isEmpty())
	            {
	            	for (int n = 0 ; n < list.size() ; n++)
	            	{
	            		Entity target = (Entity)list.get(n);

	            		if(target instanceof EntityPlayer || target instanceof EntityTameable || target instanceof EntityHorse)
	            		{

	    					if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
	    					{

	    						int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
	    						ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
	    					}

	            			EntityLivingBase elb = (EntityLivingBase)target;
	            			if(elb.isPotionActive(DQPotionPlus.buffMahokanta))
	            			{
	            				DQR.func.addPotionEffect2(par3EntityPlayer, new PotionEffect(this.pot.id, this.getEnumMagic().getAttack(), 0));

	            				elb.worldObj.playSoundAtEntity(elb, "dqr:player.mahokanta", 1.0F, 1.0F);
	            				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.up", 1.0F, 1.0F);
	            			}else
	            			{
	            				DQR.func.addPotionEffect2(elb, new PotionEffect(this.pot.id, this.getEnumMagic().getAttack(), 0));
	            				elb.worldObj.playSoundAtEntity(elb, "dqr:player.up", 1.0F, 1.0F);
	            			}
	            		}
	            	}
	            }

	            return par1ItemStack;
			}else if((this != DQMagics.itemUminarinotue && this != DQMagics.itemCallMagma) && par3EntityPlayer.isSneaking())
	    	{
	    		Random rand_jukuren = new Random();
				if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
				{

					int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
					ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
				}

	        	MagicEntityBuff magic = null;

	        	magic = new MagicEntityBuff(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);


	    		if(magic != null)
	    		{
	    			//int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

    				magic.setDamage(0);
    				magic.setPotionEffect(new PotionEffect(this.pot.id, this.getEnumMagic().getAttack(), 1));

    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

    	        	if (!par2World.isRemote)
    	        	{
    	        		par2World.spawnEntityInWorld(magic);

    	        	}
    	        }
	    	}else if(this == DQMagics.itemUminarinotue && par3EntityPlayer.isPotionActive(DQPotionEtc.buffUminarinotue))
	    	{
	    			par3EntityPlayer.removePotionEffect(DQPotionEtc.buffUminarinotue.getId());
	    			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
	    	}else if(this == DQMagics.itemCallMagma && par3EntityPlayer.isPotionActive(DQPotionEtc.buffCallMagma))
	    	{
	    		par3EntityPlayer.removePotionEffect(DQPotionEtc.buffCallMagma.getId());
	    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
	    	}else
	    	{

	    		if(this == DQMagics.itemUminarinotue || this == DQMagics.itemCallMagma)
	    		{
					if(epMP < this.getEnumMagic().getMP() && DQR.debug == 0)
					{
						DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
						par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
						return par1ItemStack;
					}else
					{
						ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
					}
	    		}



				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
	    		if(par3EntityPlayer.isPotionActive(DQPotionPlus.buffMahokanta))
	    		{
	    			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mahokanta", 1.0F, 1.0F);
	    		}else
	    		{
		    		Random rand_jukuren = new Random();
					if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
					{

						int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
						ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
					}

	    			int fixTime = 0;
	    			if(this == DQMagics.itemRemira)
	    			{
	    				pe = par3EntityPlayer.getActivePotionEffect(Potion.nightVision);
	    				if(pe != null)
	    				{
	    					fixTime = pe.getDuration();
	    				}
	    			}
	    			DQR.func.addPotionEffect2(par3EntityPlayer, new PotionEffect(this.pot.id, fixTime + this.getEnumMagic().getAttack(), 1));
	    			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.up", 1.0F, 1.0F);
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

    	if(this != DQMagics.itemSukuruto && this != DQMagics.itemFubaha && this != DQMagics.itemPiorimu &&
    	   this != DQMagics.itemUminarinotue && this != DQMagics.itemCallMagma)
    	{
	    	p_77624_3_.add("");
	    	String message = I18n.format("dqm.magicinfo.buff.txt", new Object[]{});
	    	String[] addLine = message.split("＄");
	    	for(int cnt = 0; cnt < addLine.length; cnt++)
	    	{
	    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + addLine[cnt]);
	    	}
    	}
    }
}
