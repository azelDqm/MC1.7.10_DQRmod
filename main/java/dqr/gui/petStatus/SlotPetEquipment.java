package dqr.gui.petStatus;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.api.Items.DQInventorySlots;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.items.base.DqmItemAccessoryBase;
import dqr.items.base.DqmItemArmorBase;
import dqr.items.base.DqmItemWeaponBase;

public class SlotPetEquipment extends Slot {

    private EnumDqmSubEquipType equipment;
    private IInventory invData;

    public SlotPetEquipment(EnumDqmSubEquipType type, IInventory p_i1824_1_, int p_i1824_2_, int x, int y) {
        super(p_i1824_1_, p_i1824_2_, x, y);
        equipment = type;
        invData = p_i1824_1_;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {

    	//System.out.println("TAKE1");
    	/*
    	if(this.equipment.getId() == EnumDqmSubEquipType.PWEAPON.getId())
    	{
			if(invData.getStackInSlot(18) != null && invData.getStackInSlot(18).getItem() == stack.getItem())
			{
				return false;
			}
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.PARMOR.getId())
    	{
    		for(int cnt = 9; cnt < 11; cnt++)
    		{
    			if(invData.getStackInSlot(cnt) != null && invData.getStackInSlot(cnt).getItem() == stack.getItem())
    			{
    				return false;
    			}
    		}
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.PSHIELD.getId())
    	{
    		for(int cnt = 3; cnt < 5; cnt++)
    		{
    			if(invData.getStackInSlot(cnt) != null && invData.getStackInSlot(cnt).getItem() == stack.getItem())
    			{
    				return false;
    			}
    		}
    	}
    	*/

    	//System.out.println("TEST : " + stack.getItem().getUnlocalizedName() + " / " + this.slotNumber);
    	if(this.slotNumber == 54 && stack.getItem() instanceof DqmItemWeaponBase){return true;}
    	if(this.slotNumber == 55 && stack.getItem() instanceof DqmItemArmorBase)
    	{
    		DqmItemArmorBase armor = (DqmItemArmorBase)stack.getItem();
    		if(armor.armorType == 1)
    		{
    			return true;
    		}
    	}

    	if(this.slotNumber == 56 && stack.getItem() instanceof DqmItemAccessoryBase)
    	{
    		DqmItemAccessoryBase item = (DqmItemAccessoryBase)stack.getItem();
    		return item.type == EnumDqmSubEquipType.Shield;
    	}

    	return false;
        //return stack.getItem() instanceof ISubEquip && ((ISubEquip) stack.getItem()).isItemValid(this.equipment, stack);
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {
    	//System.out.println("TAKE2");
        //return this.getStack() != null && ((ISubEquip) this.getStack().getItem()).canTakeStack(equipment, this.getStack(), player);
    	//return false;
    	return true;
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getBackgroundIconIndex() {
    	//DQIngots.itemBakudanisi.getIconIndex(p_77650_1_)

    	if(this.equipment.getId() == EnumDqmSubEquipType.PWEAPON.getId())
    	{
    		return DQInventorySlots.itemSlotPetBuki.getIconFromDamage(0);
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.PSHIELD.getId())
    	{
    		return DQInventorySlots.itemSlotShield.getIconFromDamage(0);
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.PARMOR.getId())
    	{
    		return DQInventorySlots.itemSlotPetYoroi.getIconFromDamage(0);
    	}

    	return null;
        //return equipment.getIcon();
    }
}
