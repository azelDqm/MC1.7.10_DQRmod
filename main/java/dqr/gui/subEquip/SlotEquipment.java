package dqr.gui.subEquip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dqr.api.Items.DQInventorySlots;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.items.interfaceBase.ISubEquip;

public class SlotEquipment extends Slot {

    private EnumDqmSubEquipType equipment;
    private IInventory invData;

    public SlotEquipment(EnumDqmSubEquipType type, IInventory p_i1824_1_, int p_i1824_2_, int x, int y) {
        super(p_i1824_1_, p_i1824_2_, x, y);
        equipment = type;
        invData = p_i1824_1_;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {

    	//System.out.println("TAKE1");
    	if(this.equipment.getId() == EnumDqmSubEquipType.Piasu.getId())
    	{
    		for(int cnt = 0; cnt < 2; cnt++)
    		{
    			if(invData.getStackInSlot(cnt) != null && invData.getStackInSlot(cnt).getItem() == stack.getItem())
    			{
    				return false;
    			}
    		}
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.Sonota.getId())
    	{
    		for(int cnt = 9; cnt < 11; cnt++)
    		{
    			if(invData.getStackInSlot(cnt) != null && invData.getStackInSlot(cnt).getItem() == stack.getItem())
    			{
    				return false;
    			}
    		}
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.Udewa.getId())
    	{
    		for(int cnt = 3; cnt < 5; cnt++)
    		{
    			if(invData.getStackInSlot(cnt) != null && invData.getStackInSlot(cnt).getItem() == stack.getItem())
    			{
    				return false;
    			}
    		}
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.Yubiwa.getId())
    	{
    		for(int cnt = 5; cnt < 9; cnt++)
    		{
    			if(invData.getStackInSlot(cnt) != null && invData.getStackInSlot(cnt).getItem() == stack.getItem())
    			{
    				return false;
    			}
    		}
    	}

        return stack.getItem() instanceof ISubEquip && ((ISubEquip) stack.getItem()).isItemValid(this.equipment, stack);
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {
    	//System.out.println("TAKE2");
        return this.getStack() != null && ((ISubEquip) this.getStack().getItem()).canTakeStack(equipment, this.getStack(), player);
    }

    @Override
    public int getSlotStackLimit() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getBackgroundIconIndex() {
    	//DQIngots.itemBakudanisi.getIconIndex(p_77650_1_)

    	if(this.equipment.getId() == EnumDqmSubEquipType.Fukuro.getId())
    	{
    		return DQInventorySlots.itemSlotFukuro.getIconFromDamage(0);
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.Kubikazari.getId())
    	{
    		return DQInventorySlots.itemSlotKubikazari.getIconFromDamage(0);
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.Piasu.getId())
    	{
    		return DQInventorySlots.itemSlotPiasu.getIconFromDamage(0);
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.Shield.getId())
    	{
    		return DQInventorySlots.itemSlotShield.getIconFromDamage(0);
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.Sonota.getId())
    	{
    		return DQInventorySlots.itemSlotSonota.getIconFromDamage(0);
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.Udewa.getId())
    	{
    		return DQInventorySlots.itemSlotUdewa.getIconFromDamage(0);
    	}else if(this.equipment.getId() == EnumDqmSubEquipType.Yubiwa.getId())
    	{
    		return DQInventorySlots.itemSlotYubiwa.getIconFromDamage(0);
    	}

    	return null;
        //return equipment.getIcon();
    }
}
