package dqr.gui.subEquip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.items.interfaceBase.ISubEquip;

public class SubEquipmentStats2 {

    public final String NBT_ID = "dqrsubequipment";

    public InventorySubEquip inventory;

    public SubEquipmentStats2() {

        //inventory = new InventorySubEquip();

    }

    public void onUpdate(EntityPlayer entityPlayer) {

        for (int i = 0; i < inventory.getSizeInventory(); i++) {

            if (inventory.getStackInSlot(i) == null) continue;
            if (!(inventory.getStackInSlot(i).getItem() instanceof ISubEquip)) continue;

            ISubEquip e = (ISubEquip) inventory.getStackInSlot(i).getItem();

            e.onUpdate(EnumDqmSubEquipType.getEquipmentTypeFromSlot(i), inventory.getStackInSlot(i), entityPlayer.worldObj, entityPlayer, i);

        }

    }

    public void writeNBT(NBTTagCompound compound) {

        NBTTagCompound nbt = new NBTTagCompound();

        inventory.writeToNBT(nbt);

        compound.setTag(NBT_ID, nbt);

    }

    public void readNBT(NBTTagCompound compound) {

        if (compound.hasKey(NBT_ID)) {
            inventory.readFromNBT(compound.getCompoundTag(NBT_ID));
        }

    }

}
