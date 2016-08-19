package dqr.items.Subequip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.api.potion.DQPotionPlus;
import dqr.items.base.DqmItemAccessoryBase;
import dqr.playerData.ExtendedPlayerProperties;

public class DqmItemTikaranotate extends DqmItemAccessoryBase{

	public DqmItemTikaranotate(EnumDqmSubEquipType equipment) {
		super(equipment);
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

		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

		/*
		int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
				        / par1ItemStack.getMaxDamage() * this.getEnumMagic().getAttack() / 100;
		attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);
		*/
		int matk = ExtendedPlayerProperties.get(par3EntityPlayer).getMaryoku();
		int attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, 65);
		attackDam = 65;
		//magic.setDamage(attackDam);

		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

		if(par3EntityPlayer.isPotionActive(DQPotionPlus.buffMahokanta))
		{
			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mahokanta", 1.0F, 1.0F);
		}else
		{
        	if(par3EntityPlayer.getHealth() + attackDam > par3EntityPlayer.getMaxHealth())
        	{
        		par3EntityPlayer.setHealth(par3EntityPlayer.getMaxHealth());
        	}else
        	{
        		par3EntityPlayer.setHealth(par3EntityPlayer.getHealth() + (float)attackDam);
        	}

			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.hoimi", 1.0F, 1.0F);
		}

		par1ItemStack.damageItem(this.getMaxDamage() / 20, par3EntityPlayer);

        return par1ItemStack;
    }
}
