package dqr.items.miscs;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import dqr.api.enums.EnumColor;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.items.base.DqmItemMiscBase;

public class DqmItemAccessoryCanceler extends DqmItemMiscBase{

	public DqmItemAccessoryCanceler()
	{
		super();
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{

		par3EntityPlayer.worldObj.playSoundAtEntity(par3EntityPlayer, "dqr:player.pi", 1.0F, 1.0F);
        //this.getCustomPlayerData(event.entityPlayer).getEquipmentStats().inventory.dropAllItems(event.entityPlayer);
        InventorySubEquip inventory = new InventorySubEquip(par3EntityPlayer);
        inventory.openInventory();
        inventory.dropAllItems(par3EntityPlayer);
        inventory.markDirty();
        inventory.closeInventory();

    	return par1ItemStack;

    }

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	for(int cnt = 0; cnt < 5; cnt++)
    	{
    		p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.accessory.AccessoryCanceler." + cnt + ".txt", new Object[]{}));
    	}

    	String message = I18n.format("dqm.iteminfo.accessory.AccessoryCanceler.5.txt", new Object[]{});
    	p_77624_3_.add(EnumColor.Aqua.getChatColor() + message);
    }
}
