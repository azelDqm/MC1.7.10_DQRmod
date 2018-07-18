package dqr.functions;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import com.google.common.collect.Maps;

import dqr.DQR;
import dqr.api.enums.EnumDqmAccessory;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmWeapon;
import dqr.api.enums.EnumStat;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.petEntity.DqmPetBase;
import dqr.entity.petEntity.InventoryPetInventory;
import dqr.items.base.DqmItemAccessoryBase;
import dqr.items.base.DqmItemArmorBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.playerData.ExtendedPlayerProperties;

public class FuncCalcPetStatus {

	public FuncCalcPetStatus(){}

	public int calcMaryoku(DqmPetBase pet)
	{
		int matk = 0;

		int[] matkArray = pet.getArrayMAGA();
		for(int cnt = 0; cnt < matkArray.length; cnt++)
		{
			matk = matk + matkArray[cnt];
		}

		int kasikosa = pet.getKasikosa();

		matk = matk + (kasikosa / 2);

		/*
		if(ep.getCurrentEquippedItem() != null)
		{
			if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemMagicBase)
			{
				DqmItemMagicBase magicItem = (DqmItemMagicBase)ep.getCurrentEquippedItem().getItem();
				int magDam = magicItem.getEnumMagic().getAttack();
				int resDam = DQR.magicTable.getReasonableDamage(magicItem, ep, magDam);

				matk = matk + resDam;
			}
		}
		*/


		return matk;
	}

	public int calcAttack(DqmPetBase pet)
	{
		//ep.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.16D);
		//System.out.println("DEBUGLINE:" + ep.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).getAttributeValue());

		//素手の場合
		double emptyHandDam = pet.getTikara() / 5.0D;
		int playerJob = pet.getJob();
		int playerWeapon = pet.getWeapon();
		int atk = 1;

		atk = atk + (int)(emptyHandDam + 0.5D);


        if(!pet.worldObj.isRemote)
        {
            if(pet.chestOn)
            {
                InventoryPetInventory inventory = new InventoryPetInventory(pet);
                inventory.openInventory();

            	if(inventory.getStackInSlot(18) != null && inventory.getStackInSlot(18).getItem() instanceof DqmItemWeaponBase)
            	{
    				DqmItemWeaponBase dqmSword = (DqmItemWeaponBase)inventory.getStackInSlot(18).getItem();
    				EnumDqmWeapon enumWeapon = EnumDqmWeapon.valueOf(dqmSword.getMaterial().name());
            		playerWeapon = enumWeapon.getId();

            		//ペットは一旦武器の適正を受けないようにする
            		//int aptitude = DQR.aptitudeTable.getWAptitude(playerJob, playerWeapon);
            		int aptitude = 0;


    		    	int maxDam = dqmSword.getMaxDamage();
    		    	int calDam = maxDam - inventory.getStackInSlot(18).getItemDamage();
    		    	int perDam = calDam * 1000 / maxDam;
    		    	float fixAptitude = 1.0F;

    		    	//DQR.func.debugString("TEST1 : " + atk + " / " + fixAptitude);
    		    	if(aptitude >= 0)
    		    	{
    		    		int jukurenLv = pet.getJukurenLv(playerWeapon);
    		    		if(aptitude > 1)
    		    		{
    		    			perDam = perDam + (50 * jukurenLv);
    		    			atk = atk + jukurenLv;
    		    		}else if(aptitude == 1)
    		    		{
    		    			perDam = perDam + (25 * jukurenLv);
    		    		}else
    		    		{
    		    			perDam = perDam + (jukurenLv * 10);
    		    			atk = atk + jukurenLv;
    		    		}
    		    	}else
    		    	{
    		    		fixAptitude = 0.5F;
    		    	}

    		    	//DQR.func.debugString("TEST2 : " + atk + " / " + fixAptitude + " / " + perDam);
    		    	//DQR.func.debugString("TEST2.5 : " + dqmSword.func_150931_i());

    		    	if(perDam < 900 && dqmSword.getMaterial() != DQR.dqmMaterial.DqmFist)
    		    	{
    		    		atk = atk + (int)(dqmSword.func_150931_i() * fixAptitude *  (perDam + 100) / 1000);
    		    		//DQR.func.debugString("TEST_X");
    		    	}else
    		    	{
    		    		atk = atk + (int)(dqmSword.func_150931_i() * fixAptitude);
    		    		//DQR.func.debugString("TEST_Y");
    		    	}


    		    	//DQR.func.debugString("TEST3 : " + atk);
    		        //Multimap multimap = HashMultimap.create();

    		        //multimap.remove(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CA"), "Weapon modifier", (double)atk, 0));
    		        //multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CA"), "Weapon modifier", (double)atk, 0));
    		        //ep.getAttributeMap().applyAttributeModifiers(multimap);
    				//atk = (int)dqmSword.func_150931_i();

    				//とりあえず力を攻撃力にそのまま加算
    				//atk = atk + pet.getTikara();
    				//DQR.func.debugString("TEST4 : " + atk);
            	}

            }
        }
		/*
		if(pet.getAttributeMap() != null && pet.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage) != null)
		{
			pet.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(emptyHandDam);
			atk = 1 + (int)pet.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).getAttributeValue();
		}
		*/

		/*
		if(ep.getCurrentEquippedItem() != null)
		{

			if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemWeaponBase)
			{
				NBTTagList tag = ep.getCurrentEquippedItem().getEnchantmentTagList();
				if(tag != null)
				{
					//DQR.func.debugString("DEBUG3:" + cnt);
			    	for(int cnt2 = 0; cnt2 < tag.tagCount(); cnt2++)
			    	{
			    		//DQR.func.debugString("DEBUG4:" + cnt2);

			    		NBTTagCompound nbt = tag.getCompoundTagAt(cnt2);
			    		if(nbt != null && nbt.getShort("id") == Enchantment.sharpness.effectId)
			    		{
			    			atk = atk + ((int)(nbt.getShort("lvl")) * 2);
			    		}
			    	}
				}

				DqmItemWeaponBase dqmSword = (DqmItemWeaponBase)ep.getCurrentEquippedItem().getItem();

		    	int maxDam = dqmSword.getMaxDamage();
		    	int calDam = maxDam - ep.getCurrentEquippedItem().getItemDamage();
		    	int perDam = calDam * 1000 / maxDam;
		    	float fixAptitude = 1.0F;

		    	//System.out.println("DEBUGLINE:" + maxDam + "/" + calDam + "/" + perDam);

		    	int aptitude = DQR.aptitudeTable.getWAptitude(playerJob, playerWeapon);

		    	if(aptitude >= 0)
		    	{
		    		int jukurenLv = ExtendedPlayerProperties.get(ep).getJukurenLv(playerWeapon);
		    		if(aptitude > 1)
		    		{
		    			perDam = perDam + (50 * jukurenLv);
		    			atk = atk + jukurenLv;
		    		}else if(aptitude == 1)
		    		{
		    			perDam = perDam + (25 * jukurenLv);
		    		}else
		    		{
		    			perDam = perDam + (jukurenLv * 10);
		    			atk = atk + jukurenLv;
		    		}
		    	}else
		    	{
		    		fixAptitude = 0.5F;
		    	}

		    	if(perDam < 900 && dqmSword.getMaterial() != DQR.dqmMaterial.DqmFist)
		    	{
		    		atk = atk + (int)(dqmSword.func_150931_i() * fixAptitude *  (perDam + 100) / 1000);
		    	}else
		    	{
		    		atk = atk + (int)(dqmSword.func_150931_i());
		    	}

		        //Multimap multimap = HashMultimap.create();

		        //multimap.remove(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CA"), "Weapon modifier", (double)atk, 0));
		        //multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CA"), "Weapon modifier", (double)atk, 0));
		        //ep.getAttributeMap().applyAttributeModifiers(multimap);
				//atk = (int)dqmSword.func_150931_i();

				//とりあえず力を攻撃力にそのまま加算
				atk = atk + ExtendedPlayerProperties.get(ep).getTikara();
			}else if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemBowBase)
			{
				DqmItemBowBase dqmSword = (DqmItemBowBase)ep.getCurrentEquippedItem().getItem();

		    	int maxDam = dqmSword.getMaxDamage();
		    	int calDam = maxDam - ep.getCurrentEquippedItem().getItemDamage();
		    	int perDam = calDam * 1000 / maxDam;
		    	int aptitude = DQR.aptitudeTable.getWAptitude(playerJob, playerWeapon);
		    	float fixAptitude = 1.0F;

		    	if(aptitude >= 0)
		    	{
		    		int jukurenLv = ExtendedPlayerProperties.get(ep).getJukurenLv(playerWeapon);
		    		if(aptitude > 1)
		    		{
		    			perDam = perDam + (50 * jukurenLv);
		    			atk = atk + jukurenLv;
		    		}else if(aptitude == 1)
		    		{
		    			perDam = perDam + (jukurenLv * 25);
		    		}else
		    		{
		    			perDam = perDam + (jukurenLv * 10);
		    			atk = atk + jukurenLv;
		    		}
		    	}else
		    	{
		    		fixAptitude = 0.5F;
		    	}

		    	//System.out.println("DEBUGLINE:" + maxDam + "/" + calDam + "/" + perDam);

		    	atk = atk + (int)(dqmSword.func_150931_i() * fixAptitude * (perDam + 100) / 1000);

		        //Multimap multimap = HashMultimap.create();
		        //multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF"), "Weapon modifier", (double)atk, 0));
		        //ep.getAttributeMap().applyAttributeModifiers(multimap);
		    	//ep.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(emptyHandDam + atk);
				//とりあえず力を攻撃力にそのまま加算
				atk = atk + ExtendedPlayerProperties.get(ep).getTikara();
			}else if(ep.getCurrentEquippedItem().getItem() instanceof ItemSword)
			{
				ItemSword sword = (ItemSword)ep.getCurrentEquippedItem().getItem();
				if(sword.getToolMaterialName().equalsIgnoreCase(ToolMaterial.IRON.toString()))
				{
					//atk = atk + 6;
				}else if(sword.getToolMaterialName().equalsIgnoreCase(ToolMaterial.WOOD.toString()))
				{
					//atk = atk + 4;
				}else if(sword.getToolMaterialName().equalsIgnoreCase(ToolMaterial.STONE.toString()))
				{
					//atk = atk + 5;
				}else if(sword.getToolMaterialName().equalsIgnoreCase(ToolMaterial.EMERALD.toString()))
				{
					//atk = atk + 7;
				}else if(sword.getToolMaterialName().equalsIgnoreCase(ToolMaterial.GOLD.toString()))
				{
					//atk = atk + 4;
				}

				//とりあえず力を攻撃力にそのまま加算
				atk = atk + ExtendedPlayerProperties.get(ep).getTikara();
			}
			//
			//else if(ep.getCurrentEquippedItem().getClass().equals(Block.class))
			//{

			//}
			//
		}
		*/

		int[] AtkArray = pet.getArrayATKA();
		for(int cnt = 0; cnt < AtkArray.length; cnt++)
		{
			atk = atk + AtkArray[cnt];
		}

		//DQR.func.debugString("TEST4 : " + atk);
		//System.out.println("DEBUGLINE:" + ep.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
		//とりあえず力を攻撃力にそのまま加算
		//atk = atk + ExtendedPlayerProperties.get(ep).getTikara();

		PotionEffect pe;

		//バイキルト時2倍
		pe = pet.getActivePotionEffect(DQPotionPlus.buffBaikiruto);
		if(pe != null)
		{
			atk = atk * (pe.getAmplifier() + 1);
		}

		//ヘナトス
		pe = pet.getActivePotionEffect(DQPotionMinus.debuffHenatosu);
		if(pe != null)
		{
			atk = atk / (pe.getAmplifier() + 2);
		}

		/*
		if(pet.getAttributeMap() != null && pet.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage) != null)
		{
			pet.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(emptyHandDam + atk);
		}
		*/

		//ストポ
		if(DQR.conf.bug_damageBoostPotionFix == 0)
		{
			pe = pet.getActivePotionEffect(Potion.damageBoost);
			if(pe != null)
			{
				atk = atk + ((atk * ((pe.getAmplifier() + 1) * 130)) / 100);
			}
		}

		//System.out.println("ATK" + atk);
		//DQR.func.debugString("TEST5 : " + atk);
		return atk;
	}

	public float calcHP(DqmPetBase pet)
	{
		//float HP = 20.0F;
		float HP = pet.type.getHpdef();

		//HP = ExtendedPlayerProperties.get(this.ep).getMaxHP()F;
		//DQR.func.debugString("DEBUG_HP_A : " + HP, this.getClass());

		float[] HPArray = pet.getArrayHPA();
		for(int cnt = 0; cnt < HPArray.length; cnt++)
		{
			HP = HP + HPArray[cnt];
		}

		float[] JobHP = pet.getJobHPA();
		int job = pet.getJob();

		//DQR.func.debugString("DEBUG_HP_B : " + HP, this.getClass());
		for(int cnt = 0; cnt < JobHP.length; cnt++)
		{
			if(cnt == job)
			{
				HP = HP + JobHP[cnt];
			}else
			{
				//HP = HP + (JobHP[cnt] * 0.1F);
				HP = HP + (JobHP[cnt] / ((DQR.conf.DqmDifficulty + 2) * 2));
			}
		}

		//DQR.func.debugString("DEBUG_HP_C : " + HP, this.getClass());
		return HP;
	}

	public int calcMP(DqmPetBase pet)
	{
		int MP = pet.type.getMpdef();

		//HP = ExtendedPlayerProperties.get(this.ep).getMaxHP()F;

		int[] MPArray = pet.getArrayMPA();
		for(int cnt = 0; cnt < MPArray.length; cnt++)
		{
			MP = MP + MPArray[cnt];
		}

		int[] JobMP = pet.getJobMPA();
		int job = pet.getJob();

		for(int cnt = 0; cnt < JobMP.length; cnt++)
		{
			if(cnt == job)
			{
				MP = MP + JobMP[cnt];
			}else
			{
				MP = MP + (JobMP[cnt] / ((DQR.conf.DqmDifficulty + 2) * 2));
				//MP = MP + (JobMP[cnt] / 10);
			}
		}


		return MP;
	}

	public int calcSubayasa(DqmPetBase pet)
	{
		int subayasa;
		UUID subayasaUUID;

		subayasa = 0;

		int[] subayasaArray = pet.getArraySubayasaA();
		for(int cnt = 0; cnt < subayasaArray.length; cnt++)
		{
			//String uid = "91AEAA56-376B-4498-935B-2F7F68" + cnt;
			subayasa = subayasa + subayasaArray[cnt];
			//func_111184_a(SharedMonsterAttributes.movementSpeed, uid, 0.80000000298023224D, 2);
		}

		return subayasa;
	}

	public int calcTikara(DqmPetBase pet)
	{
		int tikara;

		tikara = pet.type.getTikaradef();

		int[] tikaraArray = pet.getArrayTikaraA();
		for(int cnt = 0; cnt < tikaraArray.length; cnt++)
		{
			tikara = tikara + tikaraArray[cnt];
		}

		int[] JobTikara = pet.getJobTikaraA();
		int job = pet.getJob();

		for(int cnt = 0; cnt < JobTikara.length; cnt++)
		{
			//tikara = tikara + JobTikara[cnt];
			if(cnt == job)
			{
				tikara = tikara + JobTikara[cnt];
			}else
			{
				tikara = tikara + (JobTikara[cnt] / 2);
			}
		}

		return tikara;
	}

	public int calcKasikosa(DqmPetBase pet)
	{
		int kasikosa;

		kasikosa = pet.type.getKasikosadef();

		int[] kasikosaArray = pet.getArrayKasikosaA();
		for(int cnt = 0; cnt < kasikosaArray.length; cnt++)
		{
			kasikosa = kasikosa + kasikosaArray[cnt];
		}

		int[] JobKasikosa = pet.getJobKasikosaA();
		int job = pet.getJob();

		for(int cnt = 0; cnt < JobKasikosa.length; cnt++)
		{
			//tikara = tikara + JobTikara[cnt];
			if(cnt == job)
			{
				kasikosa = kasikosa + JobKasikosa[cnt];
			}else
			{
				kasikosa = kasikosa + (JobKasikosa[cnt] / 2);
			}
		}
		/*
		for(int cnt = 0; cnt < JobKasikosa.length; cnt++)
		{
			kasikosa = kasikosa + JobKasikosa[cnt];
		}
		*/

		return kasikosa;
	}

	public int calcDeffence(DqmPetBase pet)
	{
		ItemArmor test;
		int def = 0;
		ArmorMaterial[] armorSet = new ArmorMaterial[4];


		/*
		for(int cnt = 0; cnt < 4; cnt++)
		{
			if(ep.inventory.armorInventory[cnt] != null)
			{
				if(ep.inventory.armorInventory[cnt].getItem() instanceof DqmItemArmorBase)
				{
					DqmItemArmorBase dqmArmor = (DqmItemArmorBase)ep.inventory.armorInventory[cnt].getItem();

					def = def + dqmArmor.getDefPoint();
					armorSet[cnt] = dqmArmor.getArmorMaterial();
				}else if(ep.inventory.armorInventory[cnt].getItem() instanceof ItemArmor)
				{

					ItemArmor armor = (ItemArmor)ep.inventory.armorInventory[cnt].getItem();
					if(armor.getArmorMaterial() == ArmorMaterial.CHAIN)
					{
						def = def + 1;
					}else if(armor.getArmorMaterial() == ArmorMaterial.IRON)
					{
						def = def + 1;
					}else if(armor.getArmorMaterial() == ArmorMaterial.GOLD)
					{
						def = def + 1;
					}else if(armor.getArmorMaterial() == ArmorMaterial.DIAMOND)
					{
						def = def + 2;
					}

					armorSet[cnt] = armor.getArmorMaterial();
				}

				NBTTagList tag = ep.inventory.armorInventory[cnt].getEnchantmentTagList();
				if(tag != null)
				{
					//DQR.func.debugString("DEBUG3:" + cnt);
			    	for(int cnt2 = 0; cnt2 < tag.tagCount(); cnt2++)
			    	{
			    		//DQR.func.debugString("DEBUG4:" + cnt2);

			    		NBTTagCompound nbt = tag.getCompoundTagAt(cnt2);
			    		if(nbt != null && nbt.getShort("id") == Enchantment.protection.effectId)
			    		{
			    			def = def + (int)nbt.getShort("lvl");
			    		}
			    	}
				}
			}


		}
		*/
		//ここでセット効果チェック
        InventoryPetInventory inventory = new InventoryPetInventory(pet);
        inventory.openInventory();

    	if(inventory.getStackInSlot(19) != null && inventory.getStackInSlot(19).getItem() instanceof DqmItemArmorBase)
    	{
    		getArmorSetEffect(pet, inventory.getStackInSlot(19));

			DqmItemArmorBase dqmArmor = (DqmItemArmorBase)inventory.getStackInSlot(19).getItem();
			def = def + dqmArmor.getDefPoint();
    	}else
    	{
    		pet.setArrayHP(EnumStat.armorSet.getId(), 0);
    		pet.setArrayMP(EnumStat.armorSet.getId(), 0);
    		pet.setArrayATK(EnumStat.armorSet.getId(), 0);
    		pet.setArrayMAG(EnumStat.armorSet.getId(), 0);
    		pet.setArrayDEF(EnumStat.armorSet.getId(), 0);
    	}

		int[] defArray = pet.getArrayDEFA();
		for(int cnt = 0; cnt < defArray.length; cnt++)
		{
			def = def + defArray[cnt];
		}


		int[] mamoriArray = pet.getArrayMamoriA();
		for(int cnt = 0; cnt < mamoriArray.length; cnt++)
		{
			def = def + mamoriArray[cnt];
		}

		//スカラ計算
		PotionEffect pe;
		pe = pet.getActivePotionEffect(DQPotionPlus.buffSukara);
		if(pe != null)
		{
			def = def +  (def * (pe.getAmplifier() + 1) / 2);
		}
		//ルカニ計算
		pe = pet.getActivePotionEffect(DQPotionMinus.debuffRukani);
		if(pe != null)
		{
			def = def +  (def * ((pe.getAmplifier() + 1) / 2));
		}

		return def;
	}

	public int getArmorSetEffect(DqmPetBase pet, ItemStack armor)
	{
		/*
		float upHP = 0.0F;
		int upMP = 0;
		int upATK = 0;
		int upDEF = 0;
		int upMAG = 0;

		int upKasikosa = 0;
		int upMikawasi = 0;
		int upKaisin = 0;
		 */
		int[] setEffect = new int[8];

		DqmItemArmorBase armorBase = (DqmItemArmorBase)armor.getItem();
		ArmorMaterial[] armors = new ArmorMaterial[]{armorBase.getArmorMaterial(), null, null, null};
		ArmorMaterial[] enableSet = new  ArmorMaterial[4];
		int enableSetCnt = 0;

		ItemStack[] armorInventory = new ItemStack[]{armor, null, null, null};


		if(chkMaterial(DQR.dqmMaterial.armorSeija, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSeija;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSeija, armorInventory);

		}
		if(chkMaterial(DQR.dqmMaterial.armorDansa, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorDansa;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorDansa, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorOdoriko, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorOdoriko;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorOdoriko, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorStar, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorStar;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorStar, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorPurinsesu, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorPurinsesu;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorPurinsesu, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorKawa, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKawa;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKawa, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRoresia, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRoresia;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRoresia, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorYuusya, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorYuusya;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorYuusya, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorTenkuu, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorTenkuu;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorTenkuu, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorHagane, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorHagane;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorHagane, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRaian, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRaian;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRaian, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSensi, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSensi;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSensi, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorPlatina, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorPlatina;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorPlatina, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorMisuriru, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorMisuriru;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorMisuriru, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRyuukisi, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRyuukisi;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRyuukisi, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorMetal, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorMetal;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorMetal, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSinwa, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSinwa;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSinwa, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRadadomu, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRadadomu;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRadadomu, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRoto, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRoto;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRoto, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorOld, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorOld;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorOld, armorInventory);
		}

		if(chkMaterial(DQR.dqmMaterial.armorKeikogi, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKeikogi;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKeikogi, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorKenpou, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKenpou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKenpou, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorBudou, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorBudou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorBudou, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorBuou, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorBuou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorBuou, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorBusin, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorBusin;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorBusin, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorKenja, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKenja;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKenja, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorMahou, armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorMahou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorMahou, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorKinu ,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKinu;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKinu, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorDaimadou,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorDaimadou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorDaimadou, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSatori,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSatori;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSatori, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSeija,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSeija;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSeija, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSinkan,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSinkan;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSinkan, armorInventory);
		}
		/*
		if(chkMaterial(DQR.dqmMaterial.armorMadousi,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorMadousi;
			enableSetCnt = enableSetCnt + 1;
			upATK = 0;
			upDEF = 0;
			upMAG = 0;
			upHP = 0.0F;
			upMP = 0;
		}
		*/
		if(chkMaterial(DQR.dqmMaterial.armorGuran,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorGuran;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorGuran, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorBani,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorBani;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorBani, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSlime,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSlime;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSlime, armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorAbunai,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorAbunai;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorAbunai, armorInventory);
		}

		if(chkMaterial(DQR.dqmMaterial.armorTabibito,armors, 1))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorTabibito;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorTabibito, armorInventory);
		}

		//外部からの干渉用
		/*
		DqrArmorSetEvent event = new DqrArmorSetEvent(ep, setEffect, armors, enableSet, enableSetCnt);
		MinecraftForge.EVENT_BUS.post(event);
		*/


		pet.setArrayHP(EnumStat.armorSet.getId(), setEffect[4]);
		pet.setArrayMP(EnumStat.armorSet.getId(), setEffect[5]);
		pet.setArrayATK(EnumStat.armorSet.getId(), setEffect[1]);
		pet.setArrayMAG(EnumStat.armorSet.getId(), setEffect[3]);
		pet.setArrayDEF(EnumStat.armorSet.getId(), setEffect[2]);

		//DQR.func.debugString("TEST_R : " + setEffect[1] + " / " + setEffect[2] + " / " + setEffect[3] + " / " + setEffect[4] + " / " + setEffect[5] + " / ");
		/*
		for(int cnt = 0; cnt < enableSetCnt; cnt++)
		{
			for(int cnt2 = 0; cnt < 4; cnt++)
			{
				if(armorInventory[cnt2].getItem() instanceof DqmItemArmorBase)
				{
					DqmItemArmorBase equip = (DqmItemArmorBase)armorInventory[cnt2].getItem();
					if(equip.getArmorMaterial() == enableSet[cnt])
					{
						equip.setSetEffectEnable(true);
					}
				}
			}
		}
		*/


		//みかわしの服
		//うろこの鎧
		//炎の鎧
		//ミラー鎧
		//刃の鎧
		//神秘の鎧
		//ドラゴンメイル
		//幸せの靴
		//幸せの帽子
		//ドラゴンローブ
		//不思議なボレロ
		//セフィラムローブ
		//オベロンの靴
		//素敵なサボ
		//水の羽衣
		//魔道士のサンダル
		//木の帽子
		//ファントムマスク
		//あらくれマスク
		//レザーマント

		return 0;
	}

	public boolean chkMaterial(ArmorMaterial target, ArmorMaterial[] armors, int need)
	{
		int matchCnt = 0;

		for(int cnt = 0; cnt < 4; cnt++)
		{
			if(armors[cnt] == target)
			{
				matchCnt = matchCnt + 1;
			}
		}

		return matchCnt >= need;
	}

    public void func_111184_a(IAttribute p_111184_1_, String p_111184_2_, double p_111184_3_, int p_111184_5_)
    {
    	Map field_111188_I = Maps.newHashMap();
        AttributeModifier attributemodifier = new AttributeModifier(UUID.fromString(p_111184_2_), p_111184_2_, p_111184_3_, p_111184_5_);
        field_111188_I.put(p_111184_1_, attributemodifier);
    }

    public int calcShoninGold(int par1, EntityPlayer ep)
    {
    	int gold = par1;
    	if(ExtendedPlayerProperties.get(ep).getJob() == EnumDqmJob.Syounin.getId())
    	{
    		gold = gold * 3 / 4;
    	}
    	return gold;

    }



    public void calcAccessory(DqmPetBase ep)
    {
    	Random rand = new Random();
    	int ATK = 0;
    	int MAG = 0;
    	int DEF = 0;
    	int STR = 0;
    	int INT = 0;
    	int HP = 0;
    	int MP = 0;
    	int MISS = 0;
    	int CRI = 0;

    	/*
    	InventorySubEquip equipment = new InventorySubEquip(ep);
        equipment.openInventory();

        for(int cnt = 0; cnt < equipment.getSizeInventory(); cnt++)
        {
        	if(equipment.getStackInSlot(cnt) != null && DQR.enumGetter.getAccessoryParam(equipment.getStackInSlot(cnt).getItem()) != null)
        	{
        		EnumDqmAccessory accParam = DQR.enumGetter.getAccessoryParam(equipment.getStackInSlot(cnt).getItem());

        		ATK = ATK + accParam.getATK();
        		MAG = MAG + accParam.getMAG();
        		DEF = DEF + accParam.getDEF();
        		STR = STR + accParam.getSTR();
        		INT = INT + accParam.getINT();
        		HP = HP + accParam.getHP();
        		MP = MP + accParam.getMP();
        		MISS = MISS + accParam.getMISS();
        		CRI = CRI + accParam.getCRI();

        	}
        }
        */

        if(ep.chestOn)
        {
            InventoryPetInventory inventory = new InventoryPetInventory(ep);
            inventory.openInventory();

        	if(inventory.getStackInSlot(20) != null && inventory.getStackInSlot(20).getItem() instanceof DqmItemAccessoryBase)
        	{
        		EnumDqmAccessory accParam = DQR.enumGetter.getAccessoryParam(inventory.getStackInSlot(20).getItem());

        		ATK = ATK + accParam.getATK();
        		MAG = MAG + accParam.getMAG();
        		DEF = DEF + accParam.getDEF();
        		STR = STR + accParam.getSTR();
        		INT = INT + accParam.getINT();
        		HP = HP + accParam.getHP();
        		MP = MP + accParam.getMP();
        		MISS = MISS + accParam.getMISS();
        		CRI = CRI + accParam.getCRI();
        	}
        }

        ep.setArrayATK(EnumStat.accessory.getId(), ATK);
        ep.setArrayMAG(EnumStat.accessory.getId(), MAG);
        ep.setArrayDEF(EnumStat.accessory.getId(), DEF);
        ep.setArrayTikara(EnumStat.accessory.getId(), STR);
        ep.setArrayKasikosa(EnumStat.accessory.getId(), INT);
        ep.setArrayHP(EnumStat.accessory.getId(), HP);
        ep.setArrayMP(EnumStat.accessory.getId(), MP);
        ep.setArrayMikawasi(EnumStat.accessory.getId(), MISS);
        ep.setArrayKaisinritu(EnumStat.accessory.getId(), CRI);

        //アクセサリエフェクト
        int hoshihuri = -1;
        int hpRegeneration = -1;
        int mpRegeneration = -1;

        //ハラヘラズ・ハラモチの指輪
        /*
		FoodStats foodstats = ep.getFoodStats();
		if(ExtendedPlayerProperties.get(ep).getPreFoodLevel() == -1)
		{
			ExtendedPlayerProperties.get(ep).setPreFoodLevel(foodstats.getFoodLevel());
		}else
		{
			if(ExtendedPlayerProperties.get(ep).getPreFoodLevel() > foodstats.getFoodLevel())
			{
				if(equipment.hasYubiwa2(DQAccessories.itemHaraherazuYubiwa) != -1 ||
				   (equipment.hasYubiwa2(DQAccessories.itemHaramotiYubiwa) != -1 && rand.nextInt(2) == 0))
				{
						//foodstats.setFoodLevel(ExtendedPlayerProperties.get(ep).getPreFoodLevel());
					foodstats.addStats(ExtendedPlayerProperties.get(ep).getPreFoodLevel(), 0);
					//System.out.println("TEST1");
				}
				//System.out.println("TEST2");
			}
			ExtendedPlayerProperties.get(ep).setPreFoodLevel(foodstats.getFoodLevel());
		}
		*/

		//星降りピアス
        /*
		if(equipment.hasPiasu2(DQAccessories.itemHosifurupiasu) != -1)
		{
			hoshihuri = hoshihuri + DQR.conf.hoshihuri1;
		}
		if(equipment.hasPiasu2(DQAccessories.itemHosifurupiasu2) != -1)
		{
			hoshihuri = hoshihuri + DQR.conf.hoshihuri2;
		}

		//星降る腕輪
		if(equipment.hasUdewa2(DQAccessories.itemHosifuru) != -1)
		{
			hoshihuri = hoshihuri + 3;
		}
		*/

		//癒しの腕輪
		/*
		if(equipment.hasUdewa(DQAccessories.itemIyasinoudewa) != -1)
		{
			hpRegeneration = hpRegeneration + 1;
		}
		*/

		//疾風指輪
        /*
		if(equipment.hasYubiwa2(DQAccessories.itemHayatenoring) != -1)
		{
			hoshihuri = hoshihuri + 2;
		}
		*/
		/*
		//命の指輪
		if(equipment.hasYubiwa(DQAccessories.itemInotinoyubiwa))
		{
			hpRegeneration = hpRegeneration + 2;
		}
		*/

        /*
		if(equipment.hasYubiwa2(DQAccessories.itemHagennoring) != -1)
		{
			ep.removePotionEffect(DQPotionMinus.debuffManusa.id);
			//ep.removePotionEffect(Potion.confusion.id);
		}
		if(equipment.hasYubiwa2(DQAccessories.itemHagennoring2) != -1)
		{
			ep.removePotionEffect(DQPotionMinus.debuffManusa.id);
			ep.removePotionEffect(DQPotionMinus.debuffRariho.id);
			ep.removePotionEffect(Potion.confusion.id);
		}
		if(equipment.hasYubiwa2(DQAccessories.itemHadokunoring) != -1)
		{
			ep.removePotionEffect(DQPotionMinus.potionPoison.id);
			ep.removePotionEffect(Potion.poison.id);
		}
		if(equipment.hasYubiwa2(DQAccessories.itemHadokunoring2) != -1)
		{
			ep.removePotionEffect(DQPotionMinus.potionPoisonX.id);
			ep.removePotionEffect(DQPotionMinus.potionPoison.id);
			ep.removePotionEffect(Potion.poison.id);
		}
		if(equipment.hasYubiwa2(DQAccessories.itemMangetunoring) != -1)
		{
			ep.removePotionEffect(Potion.moveSlowdown.id);
			ep.removePotionEffect(DQPotionMinus.debuffBomie.id);
		}
		if(equipment.hasYubiwa2(DQAccessories.itemMangetunoring2) != -1)
		{
			ep.removePotionEffect(Potion.moveSlowdown.id);
			ep.removePotionEffect(DQPotionMinus.debuffBomie.id);
			ep.removePotionEffect(DQPotionMinus.debuffMahoton.id);
		}
		if(equipment.hasYubiwa2(DQAccessories.itemRiseinoring) != -1)
		{
			ep.removePotionEffect(Potion.confusion.id);
			//ep.removePotionEffect(DQPotionMinus.debuffBomie.id);
		}
		if(equipment.hasYubiwa2(DQAccessories.itemRiseinoring2) != -1)
		{
			ep.removePotionEffect(Potion.confusion.id);
			ep.removePotionEffect(DQPotionMinus.debuffMedapani.id);
		}

		if(hpRegeneration >= 0)
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.buffHPRegeneration.id, 200, hpRegeneration));
		}else
		{
			ep.removePotionEffect(DQPotionPlus.buffHPRegeneration.id);
		}

		if(mpRegeneration >= 0)
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.buffMPRegeneration.id, 200, mpRegeneration));
		}else
		{
			ep.removePotionEffect(DQPotionPlus.buffMPRegeneration.id);
		}

		if(hoshihuri >= 0)
		{
			ep.addPotionEffect(new PotionEffect(DQPotionPlus.buffHoshihuru.id, 200, hoshihuri));
		}else
		{
			ep.removePotionEffect(DQPotionPlus.buffHoshihuru.id);
		}
		equipment.markDirty();
		equipment.closeInventory();
		*/
    }
}
