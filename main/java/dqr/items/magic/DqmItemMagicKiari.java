package dqr.items.magic;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.magicEntity.magic.MagicEntityKiari;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicKiari extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";
    public DqmItemMagicKiari(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
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

    	if(par1ItemStack.getItemDamage() == 0)
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

    		par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);

    		int epLevel = ExtendedPlayerProperties.get(par3EntityPlayer).getJobLv(EnumDqmJob.Souryo.getId());
    		int setLevel = 0;

    		if(epLevel > 60)
    		{
    			setLevel = 2;
    		}else if(epLevel > 25)
    		{
    			setLevel = 1;
    		}else
    		{
    			setLevel = 0;
    		}

			if(par3EntityPlayer.isSneaking())
	    	{
	        	MagicEntityKiari magic = null;

	        	magic = new MagicEntityKiari(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F);


	    		if(magic != null)
	    		{
	    			//int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

    				magic.setDamage(0);
    				magic.setLevel(setLevel);


    				//magic.setPotionEffect(new PotionEffect(this.pot.id, this.getEnumMagic().getAttack(), 0));
    				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

    	        	if (!par2World.isRemote)
    	        	{
    	        		par2World.spawnEntityInWorld(magic);

    	        	}
    	        		    		}
	    	}else
	    	{

	    		//par3EntityPlayer.addPotionEffect(new PotionEffect(this.pot.id, this.getEnumMagic().getAttack(), 1));

	    		//僧侶レベル取得処理

				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

				if(par3EntityPlayer.isPotionActive(DQPotionPlus.buffMahokanta))
				{
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mahokanta", 1.0F, 1.0F);
				}else
				{
		    		par3EntityPlayer.removePotionEffect(Potion.poison.id);
		    		par3EntityPlayer.removePotionEffect(DQPotionMinus.potionPoison.id);

	            	if(setLevel > 0)
	            	{
	            		par3EntityPlayer.removePotionEffect(Potion.weakness.id);
	            		par3EntityPlayer.removePotionEffect(Potion.moveSlowdown.id);
	            		par3EntityPlayer.removePotionEffect(Potion.digSlowdown.id);
	            		par3EntityPlayer.removePotionEffect(Potion.harm.id);
	            		par3EntityPlayer.removePotionEffect(Potion.confusion.id);
	            		par3EntityPlayer.removePotionEffect(Potion.blindness.id);
	            		par3EntityPlayer.removePotionEffect(Potion.hunger.id);
	            		par3EntityPlayer.removePotionEffect(Potion.wither.id);
	            	}

	            	if(setLevel > 1)
	            	{
	            		par3EntityPlayer.removePotionEffect(DQPotionMinus.potionPoisonX.id);
	            		par3EntityPlayer.removePotionEffect(DQPotionMinus.debuffHenatosu.id);
	            		par3EntityPlayer.removePotionEffect(DQPotionMinus.debuffMedapani.id);
	            		par3EntityPlayer.removePotionEffect(DQPotionMinus.debuffRariho.id);
	            		par3EntityPlayer.removePotionEffect(DQPotionMinus.debuffRukani.id);
	            	}

					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.up", 1.0F, 1.0F);
				}
	    	}
    	}else
    	{
    		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.noct.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    	}

        return par1ItemStack;
    }

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	p_77624_3_.add("");
    	String message = I18n.format("dqm.magicinfo.kiari.txt", new Object[]{});
    	String[] addLine = message.split("＄");
    	for(int cnt = 0; cnt < addLine.length; cnt++)
    	{
    		p_77624_3_.add(addLine[cnt]);
    	}
    }
}
