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
import dqr.api.enums.EnumDqmMagic;
import dqr.api.enums.EnumDqmSubEquipType;
import dqr.items.interfaceBase.ISubEquip;

public class DqmItemFukuroBase extends Item implements ISubEquip{
    private EnumDqmMagic enumMagic;

	public DqmItemFukuroBase()
	{
		super();
	}

    public DqmItemFukuroBase(EnumDqmMagic par4)
    {
    	super();
        this.enumMagic = par4;
    }

    public EnumDqmMagic getEnumMagic()
    {
    	return this.enumMagic;
    }

	 public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {

 		String caution = I18n.format("dqm.iteminfo.fukuro.caution.txt", new Object[]{});
		p_77624_3_.add(caution);
		p_77624_3_.add("");

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
	public boolean canTakeStack(EnumDqmSubEquipType equipment, ItemStack stack,
			EntityPlayer player) {
		// TODO 自動生成されたメソッド・スタブ
		return equipment.getId() == EnumDqmSubEquipType.Fukuro.getId();
	}

	@Override
	public boolean isItemValid(EnumDqmSubEquipType equipment, ItemStack stack) {
		// TODO 自動生成されたメソッド・スタブ
		return equipment.getId() == EnumDqmSubEquipType.Fukuro.getId();
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
		return EnumDqmSubEquipType.Fukuro;
	}

	@Override
	public boolean isDamageable2() {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
}
