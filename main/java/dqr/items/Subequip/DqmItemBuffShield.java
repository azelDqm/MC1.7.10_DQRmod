package dqr.items.Subequip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQAccessories;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.api.potion.DQPotionPlus;
import dqr.items.base.DqmItemAccessoryBase;

public class DqmItemBuffShield extends DqmItemAccessoryBase{

	public DqmItemBuffShield(EnumDqmSubEquipType equipment) {
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
		/*
		NBTTagCompound wd = par1ItemStack.getTagCompound();


		int epMP = ExtendedPlayerProperties.get(par3EntityPlayer).getMP();

		if(epMP < this.useMP && DQR.debug == 0)
		{
			DQR.func.doAddChatMessageFix(par3EntityPlayer, new ChatComponentTranslation("msg.magic.nomp.txt",new Object[] {}));
			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
			return par1ItemStack;
		}else
		{
			ExtendedPlayerProperties.get(par3EntityPlayer).setMP(epMP - this.useMP);
		}
		*/

		//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);



		/*
		int attackDam = (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage())* 100
				        / par1ItemStack.getMaxDamage() * this.getEnumMagic().getAttack() / 100;
		attackDam = DQR.magicTable.getReasonableDamage(this, par3EntityPlayer, attackDam);
		*/
		//int matk = ExtendedPlayerProperties.get(par3EntityPlayer).getMaryoku();
		//int attackDam = 65;

		//magic.setDamage(attackDam);

		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.jumon", 1.0F, 1.0F);

		if(par3EntityPlayer.isPotionActive(DQPotionPlus.buffMahokanta))
		{
			par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.mahokanta", 1.0F, 1.0F);
		}else
		{
			Potion pot = null;

			if(this == DQAccessories.itemTenkuunotate)
			{
				pot = DQPotionPlus.buffMahokanta;
			}else if(this == DQAccessories.itemUroborosunotate)
			{
				pot = DQPotionPlus.buffMagicBaria;
			}

			if(pot != null)
			{
				DQR.func.addPotionEffect2(par3EntityPlayer, new PotionEffect(pot.id, 300, 1));
				par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.up", 1.0F, 1.0F);
			}

			//par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.hoimi", 1.0F, 1.0F);
		}

		par1ItemStack.damageItem(this.getMaxDamage() / 20, par3EntityPlayer);

        return par1ItemStack;
    }
}
