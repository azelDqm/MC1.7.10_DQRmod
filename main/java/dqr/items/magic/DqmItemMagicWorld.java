package dqr.items.magic;

import java.util.List;
import java.util.Random;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import dqr.DQR;
import dqr.api.Items.DQMagics;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmMagicMode;
import dqr.api.potion.DQPotionMinus;
import dqr.items.base.DqmItemMagicBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemMagicWorld extends DqmItemMagicBase{
    private static final String __OBFID = "CL_00000072";

    private final int CLEAR = 0;
    private final int RAIN = 1;
    private final int THUNDER = 2;

    public DqmItemMagicWorld(Item.ToolMaterial p_i45356_1_, float attackDam, int maxDamage, EnumDqmMagic par4)
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
    @Override
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

		int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

		if(!DQR.magicTable.magicEnable(par3EntityPlayer, this) && DQR.debug == 0)
		{
			DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.noLv.txt",new Object[] {}));
			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		if(par3EntityPlayer.isSneaking())
		{

			if(this == DQMagics.itemCallCloud)
			{
				if(!par3EntityPlayer.worldObj.isRemote)
				{
					//DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));

					int mode = ExtendedPlayerProperties.get(par3EntityPlayer).getMagicMode(EnumDqmMagicMode.CallCloud.getMode());
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

					if(mode == CLEAR)
					{
						DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.callcloud.rain",new Object[] {par1ItemStack.getDisplayName()}));
						ExtendedPlayerProperties.get(par3EntityPlayer).setMagicMode(EnumDqmMagicMode.CallCloud.getMode(),RAIN);
					}else if(mode == RAIN)
					{
						DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.callcloud.thunder",new Object[] {par1ItemStack.getDisplayName()}));
						ExtendedPlayerProperties.get(par3EntityPlayer).setMagicMode(EnumDqmMagicMode.CallCloud.getMode(),THUNDER);
					}else if(mode == THUNDER)
					{
						DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.callcloud.clear",new Object[] {par1ItemStack.getDisplayName()}));
						ExtendedPlayerProperties.get(par3EntityPlayer).setMagicMode(EnumDqmMagicMode.CallCloud.getMode(),CLEAR);
					}
				}

			}else if(this == DQMagics.itemHikarinotue)
			{

				if(!par3EntityPlayer.worldObj.isRemote)
				{
					int mode = ExtendedPlayerProperties.get(par3EntityPlayer).getMagicMode(EnumDqmMagicMode.Hikarinotue.getMode());
					par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

					if(mode < DQR.conf.RanalutaStep.length - 1)
					{
						mode = mode + 1;

						DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.ranaluta",new Object[] {par1ItemStack.getDisplayName(), DQR.conf.RanalutaStep[mode]}));
						ExtendedPlayerProperties.get(par3EntityPlayer).setMagicMode(EnumDqmMagicMode.Hikarinotue.getMode(),mode);
					}else
					{
						mode = 0;
						DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.ranaluta",new Object[] {par1ItemStack.getDisplayName(), DQR.conf.RanalutaStep[mode]}));
						ExtendedPlayerProperties.get(par3EntityPlayer).setMagicMode(EnumDqmMagicMode.Hikarinotue.getMode(),mode);
					}
				}
			}

		}else
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

			par1ItemStack.damageItem(this.getEnumMagic().getDamage(), par3EntityPlayer);

			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

			Random rand_jukuren = new Random();
			if(DQR.magicTable.getMAptitude(this, par3EntityPlayer) > 0 && rand_jukuren.nextInt(5) == 0)
			{

				int getJukurenExp = 1 + ExtendedPlayerProperties.get(par3EntityPlayer).getJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon());
				ExtendedPlayerProperties.get(par3EntityPlayer).setJukurenExp(ExtendedPlayerProperties.get(par3EntityPlayer).getWeapon(), getJukurenExp);
			}

			if(this == DQMagics.itemCallCloud && (!par3EntityPlayer.worldObj.isRemote))
			{
				int mode = ExtendedPlayerProperties.get(par3EntityPlayer).getMagicMode(EnumDqmMagicMode.CallCloud.getMode());
				int var3 = (300 + (new Random()).nextInt(600)) * 20;
	            WorldServer var4 = MinecraftServer.getServer().worldServers[0];
	            WorldInfo var5 = var4.getWorldInfo();

				if(mode == CLEAR)
				{
	                var5.setRainTime(0);
	                var5.setThunderTime(0);
	                var5.setRaining(false);
	                var5.setThundering(false);
				}else if(mode == RAIN)
				{
	                var5.setRainTime(var3);
	                var5.setRaining(true);
	                var5.setThundering(false);
				}else
				{
	                var5.setRainTime(var3);
	                var5.setThunderTime(var3);
	                var5.setRaining(true);
	                var5.setThundering(true);
				}
			}else if(this == DQMagics.itemHikarinotue)
			{

				int mode = DQR.conf.RanalutaStep[ExtendedPlayerProperties.get(par3EntityPlayer).getMagicMode(EnumDqmMagicMode.Hikarinotue.getMode())];

				//System.out.println("DEBUG : " + mode);
				//System.out.println("DEBUG : " + ExtendedPlayerProperties.get(par3EntityPlayer).getMagicMode(EnumDqmMagicMode.Hikarinotue.getMode()));

				if(!par3EntityPlayer.worldObj.isRemote)
				{
			        for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j)
			        {
			            WorldServer worldserver = MinecraftServer.getServer().worldServers[j];

			            long setTime = worldserver.getWorldTime();
			            worldserver.setWorldTime(setTime + (long)(mode * 1000));
			            /*
						long setTime = worldserver.getWorldTime() % 24000;
			            if(setTime + (long)(mode * 1000) >= 24000)
			            {
			            	worldserver.setWorldTime(setTime + (long)(mode * 1000) - 24000);
			            }else
			            {
			            	worldserver.setWorldTime(setTime + (long)(mode * 1000));
			            	//System.out.println("DEBUG : " + worldserver.getWorldTime());
			            }
			            */
			        }
				}
			}
		}

    	return par1ItemStack;
    }

    @Override
  	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	if(this == DQMagics.itemHikarinotue)
    	{
	    	p_77624_3_.add("");
	    	String message = I18n.format("dqm.magicinfo.hikarinotue.txt", new Object[]{});
	    	String[] addLine = message.split("＄");
	    	for(int cnt = 0; cnt < addLine.length; cnt++)
	    	{
	    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + addLine[cnt]);
	    	}
    	}else if(this == DQMagics.itemCallCloud)
		{
	    	p_77624_3_.add("");
	    	String message = I18n.format("dqm.magicinfo.callcloud.txt", new Object[]{});
	    	String[] addLine = message.split("＄");
	    	for(int cnt = 0; cnt < addLine.length; cnt++)
	    	{
	    		p_77624_3_.add(EnumColor.Aqua.getChatColor() + addLine[cnt]);
	    	}
		}
    }
}
