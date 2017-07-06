package dqr.items.base;

import java.text.NumberFormat;
import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import dqr.DQR;
import dqr.api.Items.DQAccessories;
import dqr.api.enums.EnumColor;
import dqr.api.enums.EnumDqmAccessory;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.items.interfaceBase.ISubEquip;

public class DqmItemAccessoryBase extends Item implements ISubEquip{

	public EnumDqmSubEquipType type;

	public DqmItemAccessoryBase(EnumDqmSubEquipType equipment)
	{
		this.type = equipment;
		this.setMaxStackSize(1);
		this.setMaxDamage(3000);
	}

	@Override
	public boolean canTakeStack(EnumDqmSubEquipType equipment, ItemStack stack,
			EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ
		return equipment.getId() == type.getId();
	}

	@Override
	public boolean isItemValid(EnumDqmSubEquipType equipment, ItemStack stack) {
		// TODO 自動生成されたメソッド・スタブ
		return equipment.getId() == type.getId();
	}

	@Override
	public void onUpdate(EnumDqmSubEquipType equipment, ItemStack stack,
			World world, Entity player, int slot) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public boolean canDrop(EnumDqmSubEquipType equipment, ItemStack stack,
			EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public EnumDqmSubEquipType getSubEquipType() {
		// TODO 自動生成されたメソッド・スタブ
		return type;
	}

    @Override
	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
    	//p_77624_3_.add(I18n.format("dqm.magicinfo.noimplemented"));
    	super.addInformation(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);

    	if(DQR.enumGetter.getAccessoryParam(this) != null)
    	{
    		EnumDqmAccessory accParam = DQR.enumGetter.getAccessoryParam(this);
    		if(accParam.getHP() > 0) p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.setEffect.HP", new Object[]{accParam.getHP()}));
    		if(accParam.getMP() > 0) p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.setEffect.MP", new Object[]{accParam.getMP()}));
    		if(accParam.getATK() > 0) p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.setEffect.ATK", new Object[]{accParam.getATK()}));
    		if(accParam.getMAG() > 0) p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.setEffect.MAG", new Object[]{accParam.getMAG()}));
    		if(accParam.getDEF() > 0) p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.setEffect.DEF", new Object[]{accParam.getDEF()}));
    		if(accParam.getSTR() > 0) p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.setEffect.STR", new Object[]{accParam.getSTR()}));
    		if(accParam.getINT() > 0) p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.setEffect.INT", new Object[]{accParam.getINT()}));
    		if(accParam.getMISS() > 0) p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.setEffect.MISS", new Object[]{accParam.getMISS()}));
    		if(accParam.getCRI() > 0) p_77624_3_.add(EnumColor.White.getChatColor() + I18n.format("dqm.iteminfo.setEffect.CRI", new Object[]{accParam.getCRI()}));

    		if(accParam.getPOT())
    		{
    			p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.accessory.base.txt", new Object[]{}));

    			for(int cnt = 0; cnt < accParam.getInfoLine(); cnt++)
    			{
    				p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.accessory." + accParam.getItemName() + "." + cnt + ".txt", new Object[]{}));
    			}
    		}

    		if(DQR.addons.ss2IsLoad)
    		{
    			if(this == DQAccessories.itemSuraimupiasu){p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.accessory." + accParam.getItemName() + ".ss2.txt", new Object[]{}));}
    			if(this == DQAccessories.itemHaramotiYubiwa){p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.accessory." + accParam.getItemName() + ".ss2.txt", new Object[]{}));}
    			if(this == DQAccessories.itemHaraherazuYubiwa){p_77624_3_.add(EnumColor.Aqua.getChatColor() + I18n.format("dqm.iteminfo.accessory." + accParam.getItemName() + ".ss2.txt", new Object[]{}));}
    		}
    	}

    	NBTTagCompound nbt = p_77624_1_.getTagCompound();
    	if(nbt != null)
    	{
    		NumberFormat nfNum = NumberFormat.getNumberInstance();
    		int medalVal = nbt.getInteger("medalking");
    		//System.out.println("TEST:" + medalVal);
    		if(medalVal > 0)
    		{

        		String medalValue = I18n.format("msg.medalking.item.txt", new Object[]{medalVal});

    			p_77624_3_.add(medalValue);
    		}

    		int coinVal = nbt.getInteger("casinocoin");
    		//System.out.println("TEST:" + medalVal);
    		if(coinVal > 0)
    		{

        		String medalValue = I18n.format("msg.casinocoin.item.txt", new Object[]{nfNum.format(coinVal)});

    			p_77624_3_.add(medalValue);
    		}
    	}
    }

	@Override
	public boolean isDamageable2() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}
}
