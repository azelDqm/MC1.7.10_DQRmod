package dqr.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import dqr.DQR;
import dqr.gui.dama.GuiJobChangeContainer;
import dqr.gui.dama.GuiJobChangeGuiContainer;
import dqr.gui.dama.GuiSkillWeaponContainer;
import dqr.gui.dama.GuiSkillWeaponGuiContainer;
import dqr.gui.dqrEnderChest.GuiDqrEnderChestContainer;
import dqr.gui.dqrEnderChest.GuiDqrEnderChestGuiContainer;
import dqr.gui.farmBook.GuiFarmBookContainer;
import dqr.gui.farmBook.GuiFarmBookGuiContainer;
import dqr.gui.itemBag.GuiItemBagContainer;
import dqr.gui.itemBag.GuiItemBagGuiContainer;
import dqr.gui.medalKing.GuiMedalkingContainer;
import dqr.gui.medalKing.GuiMedalkingGuiAccessory;
import dqr.gui.medalKing.GuiMedalkingGuiArmor;
import dqr.gui.medalKing.GuiMedalkingGuiJob;
import dqr.gui.medalKing.GuiMedalkingGuiMagic;
import dqr.gui.medalKing.GuiMedalkingGuiMagic2;
import dqr.gui.medalKing.GuiMedalkingGuiMedal;
import dqr.gui.medalKing.GuiMedalkingGuiMisc;
import dqr.gui.medalKing.GuiMedalkingGuiWeapon;
import dqr.gui.petBook.GuiPetBookContainer;
import dqr.gui.petBook.GuiPetBookGuiContainer;
import dqr.gui.petStatus.GuiPetInventoryContainer;
import dqr.gui.petStatus.GuiPetInventoryGuiContainer;
import dqr.gui.petStatus.GuiPetStatusContainer;
import dqr.gui.petStatus.GuiPetStatusGuiContainer;
import dqr.gui.subEquip.GuiSubEquipContainer;
import dqr.gui.subEquip.GuiSubEquipGuiContainer;
import dqr.playerData.ExtendedPlayerProperties2;

public class GuiHandler implements IGuiHandler {

	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == DQR.conf.GuiID_FarmBook) {
            return new GuiFarmBookContainer(player);
        }else if (ID == DQR.conf.GuiID_JobChange) {
            return new GuiJobChangeContainer(player.inventory);
        }else if (ID == DQR.conf.GuiID_MKWeapon) {
            return new GuiMedalkingContainer(player.inventory, DQR.conf.GuiID_MKWeapon);
        }else if (ID == DQR.conf.GuiID_MKArmor) {
            return new GuiMedalkingContainer(player.inventory, DQR.conf.GuiID_MKArmor);
        }else if (ID == DQR.conf.GuiID_MKMagic) {
            return new GuiMedalkingContainer(player.inventory, DQR.conf.GuiID_MKMagic);
        }else if (ID == DQR.conf.GuiID_MKMagic2) {
            return new GuiMedalkingContainer(player.inventory, DQR.conf.GuiID_MKMagic2);
        }else if (ID == DQR.conf.GuiID_MKJob) {
            return new GuiMedalkingContainer(player.inventory, DQR.conf.GuiID_MKJob);
        }else if (ID == DQR.conf.GuiID_MKMisc) {
            return new GuiMedalkingContainer(player.inventory, DQR.conf.GuiID_MKMisc);
        }else if (ID == DQR.conf.GuiID_MKMedal) {
            return new GuiMedalkingContainer(player.inventory, DQR.conf.GuiID_MKMedal);
        }else if (ID == DQR.conf.GuiID_MKAccessory) {
            return new GuiMedalkingContainer(player.inventory, DQR.conf.GuiID_MKAccessory);
        }else if (ID == DQR.conf.GuiID_PetBook) {
            return new GuiPetBookContainer(player);
        }else if (ID == DQR.conf.GuiID_SkillWeapon){
        	return new GuiSkillWeaponContainer(player);
        }else if (ID == DQR.conf.GuiID_PetStatus){
        	return new GuiPetStatusContainer(player);
        }else if (ID == DQR.conf.GuiID_PetInventory){
        	return new GuiPetInventoryContainer(player.inventory);
        }else if (ID == DQR.conf.GuiID_DqrEnderchest){
        	return new GuiDqrEnderChestContainer(player);
        }else if (ID == DQR.conf.GuiID_ItemBag){
        	return new GuiItemBagContainer(player.inventory);
        }else if (ID == DQR.conf.GuiID_SubEquip){
        	ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiSubEquipContainer(player.inventory, player);
        }else if (ID == DQR.conf.GuiID_SubItemBag){
        	ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiItemBagContainer(player.inventory, player);
        }

        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == DQR.conf.GuiID_FarmBook) {
            return new GuiFarmBookGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_JobChange) {
            return new GuiJobChangeGuiContainer(player.inventory);
        }else if (ID == DQR.conf.GuiID_MKWeapon) {
            return new GuiMedalkingGuiWeapon(player);
        }else if (ID == DQR.conf.GuiID_MKArmor) {
            return new GuiMedalkingGuiArmor(player);
        }else if (ID == DQR.conf.GuiID_MKMagic) {
            return new GuiMedalkingGuiMagic(player);
        }else if (ID == DQR.conf.GuiID_MKMagic2) {
            return new GuiMedalkingGuiMagic2(player);
        }else if (ID == DQR.conf.GuiID_MKJob) {
            return new GuiMedalkingGuiJob(player);
        }else if (ID == DQR.conf.GuiID_MKMisc) {
            return new GuiMedalkingGuiMisc(player);
        }else if (ID == DQR.conf.GuiID_MKMedal) {
            return new GuiMedalkingGuiMedal(player);
        }else if (ID == DQR.conf.GuiID_MKAccessory) {
            return new GuiMedalkingGuiAccessory(player);
        }else if (ID == DQR.conf.GuiID_PetBook) {
            return new GuiPetBookGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_SkillWeapon) {
            return new GuiSkillWeaponGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_PetStatus) {
            return new GuiPetStatusGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_PetInventory) {
            return new GuiPetInventoryGuiContainer(player.inventory);
        }else if (ID == DQR.conf.GuiID_DqrEnderchest) {
            return new GuiDqrEnderChestGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_ItemBag) {
            return new GuiItemBagGuiContainer(player.inventory);
        }else if (ID == DQR.conf.GuiID_SubEquip){
        	ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiSubEquipGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_SubItemBag){
        	ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiItemBagGuiContainer(player.inventory, player);
        }


        return null;
    }

}
