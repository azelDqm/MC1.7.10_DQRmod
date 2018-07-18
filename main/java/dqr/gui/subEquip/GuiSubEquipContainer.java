package dqr.gui.subEquip;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
//import shift.sextiarysector.api.equipment.EquipmentType;
//import shift.sextiarysector.api.equipment.IEquipment;
//import shift.sextiarysector.player.EntityPlayerManager;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.items.interfaceBase.ISubEquip;
import dqr.playerData.ExtendedPlayerProperties2;

public class GuiSubEquipContainer extends Container {

    public InventorySubEquip equipment;
    private EntityPlayer player;

    public GuiSubEquipContainer(InventoryPlayer par1InventoryPlayer, EntityPlayer p_i1819_3_) {
        //this.equipment = par2TileEntityFurnace;
        this.player = p_i1819_3_;
        //this.equipment = ExtendedPlayerProperties2.get(p_i1819_3_).getSubEquips();
        this.equipment = new InventorySubEquip(p_i1819_3_);
        this.equipment.openInventory();
        /*
        int c = 0 ;
        for(int i = 0;i<5;i++){

        	for(int j =0;j<4;j++){
        		this.addSlotToContainer(new Slot(this.equipment,c, 80 + i * 18, 8 + j * 18));
        		c++;
        	}

        }*/

        //バニラ

        int i;

        //0 装備欄
        /*
        for (i = 0; i < 4; ++i) {
            final int k = i;
            this.addSlotToContainer(new Slot(par1InventoryPlayer, par1InventoryPlayer.getSizeInventory() - 1 - i, 8, 8 + i * 18) {
                private static final String __OBFID = "CL_00001755";

                // *
                // * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1
                // * in the case of armor slots)
                // *
                @Override
                public int getSlotStackLimit() {
                    return 1;
                }

                // **
                // * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
                // *
                @Override
                public boolean isItemValid(ItemStack p_75214_1_) {
                    if (p_75214_1_ == null) return false;
                    return p_75214_1_.getItem().isValidArmor(p_75214_1_, k, player);
                }

                // **
                // * Returns the icon index on items.png that is used as background image of the slot.
                // *
                @Override
                @SideOnly(Side.CLIENT)
                public IIcon getBackgroundIconIndex() {
                    return ItemArmor.func_94602_b(k);
                }
            });
        }
         */

        //4 ホットバー
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }

        //13 メインインベントリ
        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        //40
        /*
        this.addSlotToContainer(new SlotEquipment(EquipmentType.DecorationHelmet, this.equipment, 0, 80 + 0 * 18, 8 + 0 * 18) {

            @Override
            public int getSlotStackLimit() {
                return 1;
            }

            @Override
            public boolean isItemValid(ItemStack p_75214_1_) {
                if (p_75214_1_ == null) return false;
                return p_75214_1_.getItem().isValidArmor(p_75214_1_, 0, player);
            }

            @Override
            public boolean canTakeStack(EntityPlayer player) {
                return true;
            }

        });

        this.addSlotToContainer(new SlotEquipment(EquipmentType.DecorationPlate, this.equipment, 1, 80 + 0 * 18, 8 + 1 * 18) {

            @Override
            public int getSlotStackLimit() {
                return 1;
            }

            @Override
            public boolean isItemValid(ItemStack p_75214_1_) {
                if (p_75214_1_ == null) return false;
                return p_75214_1_.getItem().isValidArmor(p_75214_1_, 1, player);
            }

            @Override
            public boolean canTakeStack(EntityPlayer player) {
                return true;
            }

        });
        this.addSlotToContainer(new SlotEquipment(EquipmentType.DecorationLegs, this.equipment, 2, 80 + 0 * 18, 8 + 2 * 18) {

            @Override
            public int getSlotStackLimit() {
                return 1;
            }

            @Override
            public boolean isItemValid(ItemStack p_75214_1_) {
                if (p_75214_1_ == null) return false;
                return p_75214_1_.getItem().isValidArmor(p_75214_1_, 2, player);
            }

            @Override
            public boolean canTakeStack(EntityPlayer player) {
                return true;
            }

        });
        this.addSlotToContainer(new SlotEquipment(EquipmentType.DecorationBoots, this.equipment, 3, 80 + 0 * 18, 8 + 3 * 18) {

            @Override
            public int getSlotStackLimit() {
                return 1;
            }

            @Override
            public boolean isItemValid(ItemStack p_75214_1_) {
                if (p_75214_1_ == null) return false;
                return p_75214_1_.getItem().isValidArmor(p_75214_1_, 3, player);
            }

            @Override
            public boolean canTakeStack(EntityPlayer player) {
                return true;
            }

        });
		*/
        //this.addSlotToContainer(new SlotEquipment(EquipmentType.Necklace, this.equipment, 4, 80 + 1 * 18, 8 + 0 * 18));
        //this.addSlotToContainer(new Slot(this.equipment,0, 80 + 0 * 18, 8 + 0 * 18));

        //this.addSlotToContainer(new SlotEquipment(EquipmentType.Ring, this.equipment, 5, 80 + 1 * 18, 8 + 1 * 18));
        //this.addSlotToContainer(new SlotEquipment(EquipmentType.Ring, this.equipment, 6, 80 + 1 * 18, 8 + 2 * 18));
        //this.addSlotToContainer(new SlotEquipment(EquipmentType.Ring, this.equipment, 7, 80 + 1 * 18, 8 + 3 * 18));

        //イヤリング
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Piasu, this.equipment, 0, 91, 8));
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Piasu, this.equipment, 1, 127, 8));

        //ネックレス
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Kubikazari, this.equipment, 2, 109, 26));

        //腕輪
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Udewa, this.equipment, 3, 72, 26));
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Udewa, this.equipment, 4, 147, 26));

        //指輪
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Yubiwa, this.equipment, 5, 63, 44));
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Yubiwa, this.equipment, 6, 80, 44));
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Yubiwa, this.equipment, 7, 137, 44));
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Yubiwa, this.equipment, 8, 155, 44));

        //その他
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Sonota, this.equipment, 9, 100, 44));
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Sonota, this.equipment, 10, 118, 44));

        //盾
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Shield, this.equipment, 11, 90, 62));

        //袋
        this.addSlotToContainer(new SlotEquipment(EnumDqmSubEquipType.Fukuro, this.equipment, 12, 129, 62));

        /*
        this.addSlotToContainer(new SlotEquipment(EquipmentType.Other, this.equipment, 17, 80 + 4 * 18, 8 + 1 * 18));
        this.addSlotToContainer(new SlotEquipment(EquipmentType.Other, this.equipment, 18, 80 + 4 * 18, 8 + 2 * 18));
        this.addSlotToContainer(new SlotEquipment(EquipmentType.Other, this.equipment, 19, 80 + 4 * 18, 8 + 3 * 18));
		*/
        //60

    }

    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_) {
        return true;
    }

    /*
    public ItemStack slotClick(int p_75144_1_, int p_75144_2_, int p_75144_3_, EntityPlayer p_75144_4_)
    {
    	return super.slotClick(p_75144_1_, p_75144_2_, p_75144_3_, p_75144_4_);
    }*/

    @Override
    public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);

        //System.out.println("TEST:" + p_82846_2_);
        System.out.println("TEST1:" + p_82846_1_.getCommandSenderName());

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            System.out.println("TEST2");
            if (!(36 <= p_82846_2_ && p_82846_2_ <= 48)){
            	if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EnumDqmSubEquipType.Piasu, itemstack)) {

                    if (this.checkSameItem(itemstack1, 36, 38) || !this.mergeItemStack(itemstack1, 36, 38, false)) {
                    	//System.out.println("LINE1");
                    	//移動不可の場合

                    	return null;
                    }
                    //System.out.println("LINE2" + (itemstack == null));
                }else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EnumDqmSubEquipType.Kubikazari, itemstack)) {

                    if (this.checkSameItem(itemstack1, 38, 39) || !this.mergeItemStack(itemstack1, 38, 39, false)) {
                        return null;
                    }

                }else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EnumDqmSubEquipType.Shield, itemstack)) {
                	System.out.println("TEST3");
                    if (this.checkSameItem(itemstack1, 47, 48) || !this.mergeItemStack(itemstack1, 47, 48, false)) {
                    	System.out.println("TEST4");
                        return null;
                    }

                }else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EnumDqmSubEquipType.Sonota, itemstack)) {

                    if (this.checkSameItem(itemstack1, 45, 47) || !this.mergeItemStack(itemstack1, 45, 47, false)) {
                        return null;
                    }

                }else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EnumDqmSubEquipType.Udewa, itemstack)) {

                    if (this.checkSameItem(itemstack1, 39, 41) || !this.mergeItemStack(itemstack1, 39, 41, false)) {
                        return null;
                    }

                }else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EnumDqmSubEquipType.Yubiwa, itemstack)) {

                    if (this.checkSameItem(itemstack1, 41, 45) || !this.mergeItemStack(itemstack1, 41, 45, false)) {
                        return null;
                    }

                }else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EnumDqmSubEquipType.Fukuro, itemstack)) {

                    if (this.checkSameItem(itemstack1, 48, 49) || !this.mergeItemStack(itemstack1, 48, 49, false)) {
                        return null;
                    }

                }
            	//System.out.println("TEST:R");
/*
                if (itemstack.getItem() instanceof ItemArmor && !((Slot) this.inventorySlots.get(0 + ((ItemArmor) itemstack.getItem()).armorType)).getHasStack()) {
                    int j = 0 + ((ItemArmor) itemstack.getItem()).armorType;

                    if (!this.mergeItemStack(itemstack1, j, j + 1, false)) {
                        return null;
                    }
                } else if (itemstack.getItem() instanceof ItemArmor && !((Slot) this.inventorySlots.get(40 + ((ItemArmor) itemstack.getItem()).armorType)).getHasStack()) {
                    int j = 40 + ((ItemArmor) itemstack.getItem()).armorType;

                    if (!this.mergeItemStack(itemstack1, j, j + 1, false)) {
                        return null;
                    }
                } else
                */
            	/*
                if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EquipmentType.Face, itemstack)) {

                    if (!this.mergeItemStack(itemstack1, 44, 45, false)) {
                        return null;
                    }

                } else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EquipmentType.Bag, itemstack)) {

                    if (!this.mergeItemStack(itemstack1, 45, 46, false)) {
                        return null;
                    }

                } else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EquipmentType.Hand, itemstack)) {

                    if (!this.mergeItemStack(itemstack1, 46, 47, false)) {
                        return null;
                    }

                } else if (itemstack.getItem() instanceof ISubEqui alid(EquipmentType.Belt, itemstack)) {

                    if (!this.mergeItemStack(itemstack1, 47, 48, false)) {
                        return null;
                    }

                } else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EquipmentType.Unit, itemstack)) {

                    if (!this.mergeItemStack(itemstack1, 48, 56, false)) {
                        return null;
                    }

                } else if (itemstack.getItem() instanceof ISubEquip && ((ISubEquip) itemstack.getItem()).isItemValid(EquipmentType.Other, itemstack)) {

                    if (!this.mergeItemStack(itemstack1, 56, 60, false)) {
                        return null;
                    }

                } else if (p_82846_2_ >= 4 && p_82846_2_ < 13) {
                    if (!this.mergeItemStack(itemstack1, 13, 40, false)) {
                        return null;
                    }
                } else if (p_82846_2_ >= 13 && p_82846_2_ < 40 && !this.mergeItemStack(itemstack1, 4, 13, false)) {
                    return null;
                }
                */

            }else{
            	if (!this.mergeItemStack(itemstack1, 0, 36, false)) {
            		//System.out.println("TEST:X");
            		return null;
            	}else
            	{
            		//System.out.println("TEST:Y");
            	}

            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(p_82846_1_, itemstack1);
        }

        return itemstack;
    }

    @Override
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
    	//System.out.println("test");
    	//System.out.println("CODE2");
    	ExtendedPlayerProperties2.get(p_75134_1_).setFukuroOpen(false);

        super.onContainerClosed(p_75134_1_);
        this.equipment.closeInventory();
    }
    /*
    public void onContainerClosed(EntityPlayer p_75134_1_)
    {
        super.onContainerClosed(p_75134_1_);
        ExtendedPlayerProperties2.get(p_75134_1_).getEquipmentStats().onUpdate(p_75134_1_);
        this.equipment.closeInventory();
    }
    */

    public boolean checkSameItem(ItemStack ist, int slotS, int slotE)
    {
    	for(int cnt = slotS; cnt < slotE; cnt++)
    	{
            Slot slot = (Slot) this.inventorySlots.get(cnt);

            if (slot != null && slot.getHasStack()) {
	    		if(slot.getStack().getItem() == ist.getItem())
	    		{
	    			return true;
	    		}
            }
    	}

    	return false;
    }
}
