package dqr.items.magic;

import net.minecraft.entity.Entity;
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
import dqr.entity.magicEntity.magic.MagicEntityZaki;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicZaki extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";

    public DqmItemMagicZaki(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
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

			if(epMP < this.getEnumMagic().getMP() && DQR.debug == 0)
			{
				DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
				return par1ItemStack;
			}else
			{
				ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
			}

    		par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);


    		MagicEntityZaki[] magic = null;

			if(this == DQMagics.itemZaki)
			{
				magic = new MagicEntityZaki[1];
				magic[0] = new MagicEntityZaki(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
			}else if(this == DQMagics.itemZaraki)
			{
				magic = new MagicEntityZaki[3];
    			for(int cnt = 0;cnt < 3; cnt++)
    			{
    				magic[cnt] = new MagicEntityZaki(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (45.0F * cnt)), 0.0F);
    			}
			}else if(this == DQMagics.itemZarakima)
			{
				magic = new MagicEntityZaki[3];
    			for(int cnt = 0;cnt < 3; cnt++)
    			{
    				magic[cnt] = new MagicEntityZaki(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-45.0F + (45.0F * cnt)), 0.0F);
    				magic[cnt].setBoxHit(3);
    			}

			}

        	//magic = new MagicEntityZaki(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F,   0.0F, 0.0F);

    		if(magic != null)
    		{
    			//int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

    			for(int cnt = 0; cnt < magic.length; cnt ++ )
    			{
					magic[cnt].setDamage(0);
					magic[cnt].setRate(this.getEnumMagic().getRate());
					//magic.setPotionEffect(new PotionEffect(this.pot.id, this.getEnumMagic().getAttack(), 0));
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

		        	if (!par2World.isRemote)
		        	{
		        		par2World.spawnEntityInWorld(magic[cnt]);

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


}
