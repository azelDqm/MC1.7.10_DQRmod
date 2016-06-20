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
import dqr.entity.magicEntity.magic.MagicEntity;
import dqr.entity.magicEntity.magic.MagicEntityHyadoB;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicDragonS extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";

    public DqmItemMagicDragonS(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
    {
    	super(p_i45356_1_, attackDam, maxDamage, par4);


    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {

		PotionEffect pe;
		/*
		pe = par3EntityPlayer.getActivePotionEffect(DQPotionMinus.debuffMahoton);
		if(pe != null && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.mahoton.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}
		*/

		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		par3EntityPlayer.addChatMessage(new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

    	//if(par1ItemStack.getMaxDamage() * 90 / 100 > par1ItemStack.getItemDamage())
		if(true)
    	{
    		MagicEntity[] magic = null;
        	/*
        	int minusMP = 0;
        	int minusDam = 0;
        	int needLvM = 0;
        	int needLvK = 0;
        	int hitCnt = 0;
        	*/

    		int sneakFlg = par3EntityPlayer.isSneaking()? 1 : 0;

    		if(par1ItemStack.getItem() == DQMagics.itemBreathS1)
    		{

    			magic = new MagicEntityHyadoB[1];
    			magic[0] = new MagicEntityHyadoB(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    			((MagicEntityHyadoB) magic[0]).setWorldFlg(0);
    			//magic[0].setMaxTicksRange(this.getEnumMagic().getTickRange());

    			/*
    	   		minusMP = 5;
    	   		minusDam = 100;
    	   		needLvM = 12;
    	   		needLvK = 15;
    	   		*/

    		}else if(par1ItemStack.getItem() == DQMagics.itemBreathS2)
    		{
    			magic = new MagicEntityHyadoB[3];
    			for(int cnt = 0;cnt < 3; cnt++)
    			{
    				magic[cnt] = new MagicEntityHyadoB(par2World, par3EntityPlayer, 1.5F, 1.0F, (float)(-1 + cnt), 0.0F, 0.0F);
    				((MagicEntityHyadoB) magic[cnt]).setWorldFlg(1);
    				//magic[cnt].setMaxTicksRange(this.getEnumMagic().getTickRange());
    				//((MagicEntityMeramiB) magic[cnt]).setWorldFlg(DQR.conf.magicSpHonoo == 1 && rand.nextInt(10) == 0);
    			}


    			/*
    	   		minusMP = 12;
    	   		minusDam = 150;
    	   		needLvM = 27;
    	   		needLvK = 27;
    	   		*/

    		}else if(par1ItemStack.getItem() == DQMagics.itemBreathS3)
    		{
    			magic = new MagicEntityHyadoB[7];
    			for(int cnt = 0;cnt < 7; cnt++)
    			{
    				magic[cnt] = new MagicEntityHyadoB(par2World, par3EntityPlayer, 1.5F, 1.0F, (float)(-2 + cnt), 0.0F, 0.0F);
    				((MagicEntityHyadoB) magic[cnt]).setWorldFlg(2);
    				//magic[cnt].setMaxTicksRange(this.getEnumMagic().getTickRange());
    			}

    			/*
    	   		minusMP = 21;
    	   		minusDam = 200;
    	   		needLvM = 42;
    	   		needLvK = 38;
    	   		*/

    		}else if(par1ItemStack.getItem() == DQMagics.itemBreathS4)
    		{
    			magic = new MagicEntityHyadoB[16];
    			for(int cnt = 0;cnt < 16; cnt++)
    			{
    				magic[cnt] = new MagicEntityHyadoB(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
    				((MagicEntityHyadoB) magic[cnt]).setWorldFlg(3);
    				//magic[cnt].setMaxTicksRange(this.getEnumMagic().getTickRange());
    			}
    			/*
    	   		minusMP = 38;
    	   		minusDam = 300;
    	   		needLvM = 72;
    	   		needLvK = 67;
    	   		*/

    		}else if(par1ItemStack.getItem() == DQMagics.itemBreathS5)
    		{
    			magic = new MagicEntityHyadoB[32];
    			for(int cnt = 0;cnt < 32; cnt++)
    			{
    				magic[cnt] = new MagicEntityHyadoB(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (11.25F * cnt)), 0.0F);
    				((MagicEntityHyadoB) magic[cnt]).setWorldFlg(4);
    				//magic[cnt].setMaxTicksRange(this.getEnumMagic().getTickRange());
    			}
    			/*
    			magic = new MagicEntityIo[16];
    			for(int cnt = 0;cnt < 16; cnt++)
    			{
    				magic[cnt] = new MagicEntityIo(par2World, par3EntityPlayer, 1.5F, 1.0F, 0.0F, 0.0F, 0.0F, (float)(-157.5F + (22.5F * cnt)), 0.0F);
    				magic[cnt].setMaxTicksRange(this.getEnumMagic().getTickRange());
    			}
    			*/
    			/*
    	   		minusMP = 38;
    	   		minusDam = 300;
    	   		needLvM = 72;
    	   		needLvK = 67;
    	   		*/

    		}

    		/*
        	minusMP = 0;
        	minusDam = 0;
        	needLvM = 0;
        	needLvK = 0;
        	hitCnt = 0;
        	*/

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

	    				if(this.getEnumMagic().getDamage() + par1ItemStack.getItemDamage() < par1ItemStack.getMaxDamage() )
	    				{
	    					par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);
	    				}else
	    				{
	    					par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
	    				}

	    				//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);
	    				//ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.getEnumMagic().getMP());
    	        		for(int cnt = 0; cnt < magic.length; cnt++)
    	        		{
		    				magic[cnt].setDamage(attackDam);
		    	        	if (!par2World.isRemote)
		    	        	{

		    	        		//((MagicEntityMeragaiaB) magic[cnt]).setWorldFlg(par3EntityPlayer.isSneaking());
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
