package dqr.items.interfaceBase;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.api.enums.EnumDqmSubEquipType;

public interface ISubEquip{

    boolean canTakeStack(EnumDqmSubEquipType equipment, ItemStack stack, EntityPlayer player);

    boolean isItemValid(EnumDqmSubEquipType equipment, ItemStack stack);

    void onUpdate(EnumDqmSubEquipType equipment, ItemStack stack, World world, Entity player, int slot);

    boolean canDrop(EnumDqmSubEquipType equipment, ItemStack stack, EntityPlayer player);

    boolean isDamageable2();

    EnumDqmSubEquipType getSubEquipType();
}
