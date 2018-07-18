package dqr.items.Subequip;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQAccessories;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.items.base.DqmItemAccessoryBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemUsingAccessories extends DqmItemAccessoryBase{

	public DqmItemUsingAccessories(EnumDqmSubEquipType equipment)
	{
		super(equipment);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(DQR.func.isBind(par3EntityPlayer) && par3EntityPlayer.worldObj.isRemote)
		{
	  		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.rariho.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);

			return par1ItemStack;
		}

		if(par1ItemStack.getItemDamage() + (this.getMaxDamage() / 20) > this.getMaxDamage())
		{
	  		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.subequipUse.noDamage.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    		//System.out.println("wk2 :");
			return par1ItemStack;
		}else if(par1ItemStack.getItemDamage() >= (this.getMaxDamage() / 10 * 9))
		{
	  		DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.subequipUse.noDamage.txt",new Object[] {}));
    		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
    		//System.out.println("wk3 :");
			return par1ItemStack;
		}

		Random rand = new Random();

		if(this == DQAccessories.itemInotinoyubiwa && !par3EntityPlayer.isSneaking())
		{
	    	if(par3EntityPlayer.getHealth() + 50 > par3EntityPlayer.getMaxHealth())
	    	{
	    		par3EntityPlayer.setHealth(par3EntityPlayer.getMaxHealth());
	    	}else
	    	{
	    		par3EntityPlayer.heal(50.0F);
	    	}
		}else if(this == DQAccessories.itemInorinoyubiwa && !par3EntityPlayer.isSneaking())
		{
			int playerMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();
			int playerMaxMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMaxMP();

			if(50 + playerMP > playerMaxMP)
			{
				ExtendedPlayerProperties.get(par3EntityPlayer).setMP(playerMaxMP);
			}else
			{
				ExtendedPlayerProperties.get(par3EntityPlayer).setMP(50 + playerMP);
			}
		}

		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.hoimi", 1.0F, 1.0F);

		if(rand.nextInt(10) == 0)
		{
			par1ItemStack.stackSize--;
		}


		return par1ItemStack;
	}
}
