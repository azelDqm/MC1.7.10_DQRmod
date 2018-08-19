package dqr.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import dqr.DQR;
import dqr.gui.casino.GuiCasinoBBGContainer;
import dqr.gui.casino.GuiCasinoBBGGuiContainer;
import dqr.gui.casino.GuiCasinoBJContainer;
import dqr.gui.casino.GuiCasinoBJGuiContainer;
import dqr.gui.casino.GuiCasinoCCRContainer;
import dqr.gui.casino.GuiCasinoCCRGuiContainer;
import dqr.gui.casino.GuiCasinoPKContainer;
import dqr.gui.casino.GuiCasinoPKGuiContainer;
import dqr.gui.casino.GuiCasinoSLContainer;
import dqr.gui.casino.GuiCasinoSLGuiContainer;
import dqr.gui.casinoExchange.GuiCasinoExchangeContainer;
import dqr.gui.casinoExchange.GuiCasinoExchangeGuiAccessory;
import dqr.gui.casinoExchange.GuiCasinoExchangeGuiArmor;
import dqr.gui.casinoExchange.GuiCasinoExchangeGuiBuilder;
import dqr.gui.casinoExchange.GuiCasinoExchangeGuiDecorate;
import dqr.gui.casinoExchange.GuiCasinoExchangeGuiDecorateD;
import dqr.gui.casinoExchange.GuiCasinoExchangeGuiDecorateH;
import dqr.gui.casinoExchange.GuiCasinoExchangeGuiMagic;
import dqr.gui.casinoExchange.GuiCasinoExchangeGuiMisc;
import dqr.gui.casinoExchange.GuiCasinoExchangeGuiWeapon;
import dqr.gui.dama.GuiJobChangeContainer;
import dqr.gui.dama.GuiJobChangeGuiContainer;
import dqr.gui.dama.GuiSkillJobContainer;
import dqr.gui.dama.GuiSkillJobGuiContainer;
import dqr.gui.dama.GuiSkillWeaponContainer;
import dqr.gui.dama.GuiSkillWeaponGuiContainer;
import dqr.gui.debug.GuiDebugContainer;
import dqr.gui.debug.GuiDebugGuiContainer;
import dqr.gui.dqrEnderChest.GuiDqrEnderChestContainer;
import dqr.gui.dqrEnderChest.GuiDqrEnderChestGuiContainer;
import dqr.gui.dqrShop.GuiDqrShopContainer;
import dqr.gui.dqrShop.GuiDqrShopGuiContainer;
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
import dqr.gui.skillBook.GuiSkillbookContainer;
import dqr.gui.skillBook.GuiSkillbookGuiContainer;
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
        }else if (ID == DQR.conf.GuiID_CSBlackJack){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiCasinoBJContainer( player);
        }else if (ID == DQR.conf.GuiID_CSPoker){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiCasinoPKContainer(player);
        }else if (ID == DQR.conf.GuiID_CSSlot){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiCasinoSLContainer(player);
        }else if (ID == 999){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiDebugContainer(player);
        }else if (ID == DQR.conf.GuiID_CEWeapon) {
	        return new GuiCasinoExchangeContainer(player.inventory, DQR.conf.GuiID_CEWeapon);
	    }else if (ID == DQR.conf.GuiID_CEArmor) {
	        return new GuiCasinoExchangeContainer(player.inventory, DQR.conf.GuiID_CEArmor);
	    }else if (ID == DQR.conf.GuiID_CEMagic) {
	        return new GuiCasinoExchangeContainer(player.inventory, DQR.conf.GuiID_CEMagic);
	    }else if (ID == DQR.conf.GuiID_CEMisc) {
	        return new GuiCasinoExchangeContainer(player.inventory, DQR.conf.GuiID_CEMisc);
	    }else if (ID == DQR.conf.GuiID_CEAccessory) {
	        return new GuiCasinoExchangeContainer(player.inventory, DQR.conf.GuiID_CEAccessory);
	    }else if (ID == DQR.conf.GuiID_CEBuilder) {
	        return new GuiCasinoExchangeContainer(player.inventory, DQR.conf.GuiID_CEBuilder);
	    }else if (ID == DQR.conf.GuiID_CEDecorate) {
	        return new GuiCasinoExchangeContainer(player.inventory, DQR.conf.GuiID_CEDecorate);
	    }else if (ID == DQR.conf.GuiID_CEDecorateD) {
	        return new GuiCasinoExchangeContainer(player.inventory, DQR.conf.GuiID_CEDecorateD);
	    }else if (ID == DQR.conf.GuiID_CEDecorateH) {
	        return new GuiCasinoExchangeContainer(player.inventory, DQR.conf.GuiID_CEDecorateH);
	    }else if (ID == DQR.conf.GuiID_CSBBGame){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiCasinoBBGContainer(player);
        }else if (ID == DQR.conf.GuiID_ItemShop){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiDqrShopContainer(player);
        }else if (ID == DQR.conf.GuiID_CSCCR){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiCasinoCCRContainer(player);
        }else if (ID == DQR.conf.GuiID_SkillJob){
        	return new GuiSkillJobContainer(player);
        }else if (ID == DQR.conf.GuiID_Skillbook){
        	return new GuiSkillbookContainer(player);
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
        }else if (ID == DQR.conf.GuiID_CSBlackJack){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiCasinoBJGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_CSPoker){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiCasinoPKGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_CSSlot){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiCasinoSLGuiContainer(player);
        }else if (ID == 999){
        	//ExtendedPlayerProperties2.get(player).setFukuroOpen(true);
        	return new GuiDebugGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_CEWeapon) {
            return new GuiCasinoExchangeGuiWeapon(player);
        }else if (ID == DQR.conf.GuiID_CEArmor) {
            return new GuiCasinoExchangeGuiArmor(player);
        }else if (ID == DQR.conf.GuiID_CEMagic) {
            return new GuiCasinoExchangeGuiMagic(player);
        }else if (ID == DQR.conf.GuiID_CEMisc) {
            return new GuiCasinoExchangeGuiMisc(player);
        }else if (ID == DQR.conf.GuiID_CEAccessory) {
            return new GuiCasinoExchangeGuiAccessory(player);
        }else if (ID == DQR.conf.GuiID_CEBuilder) {
            return new GuiCasinoExchangeGuiBuilder(player);
        }else if (ID == DQR.conf.GuiID_CEDecorate) {
            return new GuiCasinoExchangeGuiDecorate(player);
        }else if (ID == DQR.conf.GuiID_CEDecorateD) {
            return new GuiCasinoExchangeGuiDecorateD(player);
        }else if (ID == DQR.conf.GuiID_CEDecorateH) {
            return new GuiCasinoExchangeGuiDecorateH(player);
        }else if (ID == DQR.conf.GuiID_CSBBGame){
        	return new GuiCasinoBBGGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_ItemShop){
        	return new GuiDqrShopGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_CSCCR){
        	return new GuiCasinoCCRGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_SkillJob) {
            return new GuiSkillJobGuiContainer(player);
        }else if (ID == DQR.conf.GuiID_Skillbook) {
            return new GuiSkillbookGuiContainer(player);
        }

        return null;
    }

}
