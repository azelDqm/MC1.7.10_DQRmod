package dqr.dataTable;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import dqr.DQR;
import dqr.api.Items.DQArmors;

public class FuncArmorSetTable {

	public static final int COUNT = 0;
	public static final int ATK   = 1;
	public static final int DEF    = 2;
	public static final int MAG = 3;
	public static final int HP    = 4;
	public static final int MP    = 5;

	public FuncArmorSetTable()
	{

	}

	public int[] getArmorSetEffect(ArmorMaterial armor, ItemStack[] itemArmor)
	{
		int[] setEffect = new int[8];
		for(int cnt = 0; cnt < setEffect.length; cnt++)
		{
			setEffect[cnt] = 0;
		}

		if(armor == DQR.dqmMaterial.armorSeija)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 5;
			setEffect[MAG] = 7;
			setEffect[HP] = 5;
			setEffect[MP] = 25;

		}
		if(armor == DQR.dqmMaterial.armorDansa)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 3;
			setEffect[DEF] = 5;
			setEffect[MAG] = 0;
			setEffect[HP] = 10;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorOdoriko)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 7;
			setEffect[MAG] = 3;
			setEffect[HP] = 0;
			setEffect[MP] = 20;
		}
		if(armor == DQR.dqmMaterial.armorStar)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 7;
			setEffect[DEF] = 9;
			setEffect[MAG] = 0;
			setEffect[HP] = 30;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorPurinsesu)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 11;
			setEffect[MAG] = 8;
			setEffect[HP] = 10;
			setEffect[MP] = 50;
		}
		if(armor == DQR.dqmMaterial.armorKawa)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 2;
			setEffect[MAG] = 0;
			setEffect[HP] = 10;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorRoresia)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 5;
			setEffect[DEF] = 10;
			setEffect[MAG] = 0;
			setEffect[HP] = 30;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorYuusya)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 7;
			setEffect[DEF] = 11;
			setEffect[MAG] = 0;
			setEffect[HP] = 40;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorTenkuu)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[DEF] = 12;
			setEffect[MAG] = 0;

			boolean tenkuFlg = false;

			for(int cnt = 0; cnt < itemArmor.length; cnt++)
			{
				if(itemArmor[cnt] != null && itemArmor[cnt].getItem() == DQArmors.itemTenkuunoyoroi)
				{
					tenkuFlg = true;
				}
			}
			if(tenkuFlg)
			{
				setEffect[ATK] = 12;
				setEffect[HP] = 100;
			}else
			{
				setEffect[ATK] = 10;
				setEffect[HP] = 50;
			}
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorHagane)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 4;
			setEffect[MAG] = 0;
			setEffect[HP] = 20;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorRaian)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 3;
			setEffect[DEF] = 5;
			setEffect[MAG] = 0;
			setEffect[HP] = 25;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorSensi)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 5;
			setEffect[DEF] = 6;
			setEffect[MAG] = 0;
			setEffect[HP] = 30;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorPlatina)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 7;
			setEffect[MAG] = 0;
			setEffect[HP] = 50;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorMisuriru)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 8;
			setEffect[DEF] = 8;
			setEffect[MAG] = 0;
			setEffect[HP] = 50;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorRyuukisi)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 7;
			setEffect[DEF] = 9;
			setEffect[MAG] = 0;
			setEffect[HP] = 70;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorMetal)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 10;
			setEffect[DEF] = 15;
			setEffect[MAG] = 0;
			setEffect[HP] = 100;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorSinwa)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 15;
			setEffect[DEF] = 15;
			setEffect[MAG] = 15;
			setEffect[HP] = 150;
			setEffect[MP] = 150;
		}
		if(armor == DQR.dqmMaterial.armorRadadomu)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 12;
			setEffect[DEF] = 12;
			setEffect[MAG] = 0;
			setEffect[HP] = 80;
			setEffect[MP] = 20;
		}
		if(armor == DQR.dqmMaterial.armorRoto)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 15;
			setEffect[DEF] = 13;
			setEffect[MAG] = 0;
			setEffect[HP] = 90;
			setEffect[MP] = 30;
		}
		if(armor == DQR.dqmMaterial.armorOld)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 6;
			setEffect[MAG] = 0;
			setEffect[HP] = 5;
			setEffect[MP] = 0;
		}

		if(armor == DQR.dqmMaterial.armorKeikogi)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 5;
			setEffect[DEF] = 3;
			setEffect[MAG] = 0;
			setEffect[HP] = 20;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorKenpou)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 8;
			setEffect[DEF] = 5;
			setEffect[MAG] = 0;
			setEffect[HP] = 40;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorBudou)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 10;
			setEffect[DEF] = 7;
			setEffect[MAG] = 0;
			setEffect[HP] = 60;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorBuou)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 12;
			setEffect[DEF] = 9;
			setEffect[MAG] = 0;
			setEffect[HP] = 90;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorBusin)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 15;
			setEffect[DEF] = 11;
			setEffect[MAG] = 0;
			setEffect[HP] = 120;
			setEffect[MP] = 0;
		}
		if(armor == DQR.dqmMaterial.armorKenja)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 8;
			setEffect[MAG] = 10;
			setEffect[HP] = 25;
			setEffect[MP] = 30;
		}
		if(armor == DQR.dqmMaterial.armorMahou)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 6;
			setEffect[MAG] = 8;
			setEffect[HP] = 15;
			setEffect[MP] = 20;
		}
		if(armor == DQR.dqmMaterial.armorKinu)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 3;
			setEffect[MAG] = 5;
			setEffect[HP] = 5;
			setEffect[MP] = 15;
		}
		if(armor == DQR.dqmMaterial.armorDaimadou)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 10;
			setEffect[MAG] = 12;
			setEffect[HP] = 30;
			setEffect[MP] = 50;
		}
		if(armor == DQR.dqmMaterial.armorSatori)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 7;
			setEffect[MAG] = 5;
			setEffect[HP] = 15;
			setEffect[MP] = 20;
		}

		if(armor == DQR.dqmMaterial.armorSinkan)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 7;
			setEffect[MAG] = 7;
			setEffect[HP] = 20;
			setEffect[MP] = 30;
		}
		/*
		if(armor == DQR.dqmMaterial.armorMadousi)
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorMadousi;
			enableSetCnt = enableSetCnt + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 0;
			setEffect[MAG] = 0;
			setEffect[HP] = 0;
			setEffect[MP] = 0;
		}
		*/
		if(armor == DQR.dqmMaterial.armorGuran)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 10;
			setEffect[MAG] = 15;
			setEffect[HP] = 50;
			setEffect[MP] = 80;
		}
		if(armor == DQR.dqmMaterial.armorBani)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 10;
			setEffect[MAG] = 15;
			setEffect[HP] = 50;
			setEffect[MP] = 80;
		}
		if(armor == DQR.dqmMaterial.armorSlime)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 1;
			setEffect[DEF] = 2;
			setEffect[MAG] = 1;
			setEffect[HP] = 5;
			setEffect[MP] = 5;
		}
		if(armor == DQR.dqmMaterial.armorAbunai)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 10;
			setEffect[DEF] = 10;
			setEffect[MAG] = 10;
			setEffect[HP] = 100;
			setEffect[MP] = 100;
		}
		if(armor == DQR.dqmMaterial.armorTabibito)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 3;
			setEffect[MAG] = 0;
			setEffect[HP] = 10;
			setEffect[MP] = 0;
		}

		if(armor == ArmorMaterial.CLOTH)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 1;
			setEffect[MAG] = 0;
			setEffect[HP] = 3;
			setEffect[MP] = 0;
		}

		if(armor == ArmorMaterial.CHAIN)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 1;
			setEffect[DEF] = 1;
			setEffect[MAG] = 0;
			setEffect[HP] = 5;
			setEffect[MP] = 0;
		}

		if(armor == ArmorMaterial.IRON)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 2;
			setEffect[MAG] = 0;
			setEffect[HP] = 5;
			setEffect[MP] = 0;
		}

		if(armor == ArmorMaterial.GOLD)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 1;
			setEffect[DEF] = 5;
			setEffect[MAG] = 0;
			setEffect[HP] = 15;
			setEffect[MP] = 0;
		}

		if(armor == ArmorMaterial.DIAMOND)
		{
			setEffect[COUNT] = setEffect[COUNT] + 1;
			setEffect[ATK] = 0;
			setEffect[DEF] = 3;
			setEffect[MAG] = 0;
			setEffect[HP] = 10;
			setEffect[MP] = 0;
		}
		return setEffect;
	}
}
