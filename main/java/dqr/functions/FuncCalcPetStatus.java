package dqr.functions;

import java.util.Map;
import java.util.UUID;

import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.MinecraftForge;

import com.google.common.collect.Maps;

import dqr.DQR;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumStat;
import dqr.api.event.DqrArmorSetEvent;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.entity.petEntity.DqmPetBase;
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
		pe = pet.getActivePotionEffect(Potion.damageBoost);
		if(pe != null)
		{
			atk = atk + ((atk * ((pe.getAmplifier() + 1) * 130)) / 100);
		}

		//System.out.println("ATK" + atk);
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
		//ここでセット効果チェック
		getArmorSetEffect(ep, armorSet);
		int[] defArray = ExtendedPlayerProperties.get(ep).getArrayDEFA();
		for(int cnt = 0; cnt < defArray.length; cnt++)
		{
			def = def + defArray[cnt];
		}
		*/

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
			def = def +  (def * ((pe.getAmplifier() + 1) / 2));
		}
		//ルカニ計算
		pe = pet.getActivePotionEffect(DQPotionMinus.debuffRukani);
		if(pe != null)
		{
			def = def +  (def * ((pe.getAmplifier() + 1) / 2));
		}

		return def;
	}

	public int getArmorSetEffect(EntityPlayer ep, ArmorMaterial[] armors)
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

		ArmorMaterial[] enableSet = new  ArmorMaterial[4];
		int enableSetCnt = 0;


		if(chkMaterial(DQR.dqmMaterial.armorSeija, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSeija;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSeija, ep.inventory.armorInventory);

		}
		if(chkMaterial(DQR.dqmMaterial.armorDansa, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorDansa;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorDansa, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorOdoriko, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorOdoriko;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorOdoriko, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorStar, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorStar;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorStar, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorPurinsesu, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorPurinsesu;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorPurinsesu, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorKawa, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKawa;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKawa, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRoresia, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRoresia;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRoresia, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorYuusya, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorYuusya;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorYuusya, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorTenkuu, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorTenkuu;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorTenkuu, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorHagane, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorHagane;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorHagane, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRaian, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRaian;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRaian, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSensi, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSensi;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSensi, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorPlatina, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorPlatina;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorPlatina, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorMisuriru, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorMisuriru;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorMisuriru, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRyuukisi, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRyuukisi;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRyuukisi, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorMetal, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorMetal;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorMetal, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSinwa, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSinwa;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSinwa, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRadadomu, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRadadomu;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRadadomu, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorRoto, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorRoto;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorRoto, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorOld, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorOld;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorOld, ep.inventory.armorInventory);
		}

		if(chkMaterial(DQR.dqmMaterial.armorKeikogi, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKeikogi;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKeikogi, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorKenpou, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKenpou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKenpou, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorBudou, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorBudou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorBudou, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorBuou, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorBuou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorBuou, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorBusin, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorBusin;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorBusin, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorKenja, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKenja;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKenja, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorMahou, armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorMahou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorMahou, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorKinu ,armors, 2))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorKinu;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorKinu, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorDaimadou,armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorDaimadou;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorDaimadou, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSatori,armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSatori;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSatori, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSeija,armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSeija;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSeija, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSinkan,armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSinkan;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSinkan, ep.inventory.armorInventory);
		}
		/*
		if(chkMaterial(DQR.dqmMaterial.armorMadousi,armors, 4))
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
		if(chkMaterial(DQR.dqmMaterial.armorGuran,armors, 4))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorGuran;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorGuran, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorBani,armors, 3))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorBani;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorBani, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorSlime,armors, 2))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorSlime;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorSlime, ep.inventory.armorInventory);
		}
		if(chkMaterial(DQR.dqmMaterial.armorAbunai,armors, 2))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorAbunai;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorAbunai, ep.inventory.armorInventory);
		}

		if(chkMaterial(DQR.dqmMaterial.armorTabibito,armors, 2))
		{
			enableSet[enableSetCnt] = DQR.dqmMaterial.armorTabibito;
			enableSetCnt = enableSetCnt + 1;
			setEffect = DQR.armorSetEffect.getArmorSetEffect(DQR.dqmMaterial.armorTabibito, ep.inventory.armorInventory);
		}

		//外部からの干渉用
		DqrArmorSetEvent event = new DqrArmorSetEvent(ep, setEffect, armors, enableSet, enableSetCnt);
		MinecraftForge.EVENT_BUS.post(event);


		ExtendedPlayerProperties.get(ep).setArrayHP(EnumStat.armorSet.getId(), setEffect[4]);
		ExtendedPlayerProperties.get(ep).setArrayMP(EnumStat.armorSet.getId(), setEffect[5]);
		ExtendedPlayerProperties.get(ep).setArrayATK(EnumStat.armorSet.getId(), setEffect[1]);
		ExtendedPlayerProperties.get(ep).setArrayMAG(EnumStat.armorSet.getId(), setEffect[3]);
		ExtendedPlayerProperties.get(ep).setArrayDEF(EnumStat.armorSet.getId(), setEffect[2]);

		/*
		for(int cnt = 0; cnt < enableSetCnt; cnt++)
		{
			for(int cnt2 = 0; cnt < 4; cnt++)
			{
				if(ep.inventory.armorInventory[cnt2].getItem() instanceof DqmItemArmorBase)
				{
					DqmItemArmorBase equip = (DqmItemArmorBase)ep.inventory.armorInventory[cnt2].getItem();
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
}
