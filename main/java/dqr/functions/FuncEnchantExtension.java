package dqr.functions;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import dqr.DQR;
import dqr.items.base.DqmItemWeaponBase;

public class FuncEnchantExtension {
	public boolean canEnchantItem(Item par1, EnumEnchantmentType par2)
	{
		//System.out.println("DEBUGLINE:********************************************");

		if(par1 instanceof DqmItemWeaponBase)
		{
			String materialName = ((DqmItemWeaponBase) par1).getMaterial().name();

			if(materialName.equalsIgnoreCase(DQR.dqmMaterial.DqmAxe.name()) ||
			   materialName.equalsIgnoreCase(DQR.dqmMaterial.DqmHammer0.name()) ||
			   materialName.equalsIgnoreCase(DQR.dqmMaterial.DqmHammer1.name()) ||
			   materialName.equalsIgnoreCase(DQR.dqmMaterial.DqmHammer2.name()) ||
			   materialName.equalsIgnoreCase(DQR.dqmMaterial.DqmHammer3.name()) ||
			   materialName.equalsIgnoreCase(DQR.dqmMaterial.DqmClaw.name())
			  )
			{
				return par2 == EnumEnchantmentType.all || par2 == EnumEnchantmentType.digger || par2 == EnumEnchantmentType.breakable || par2 == EnumEnchantmentType.weapon;
			}else
			{
				return par2 == EnumEnchantmentType.breakable || par2 == EnumEnchantmentType.weapon || par2 == EnumEnchantmentType.all ;
			}

		}
		return false;
	}
}
