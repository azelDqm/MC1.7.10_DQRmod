package dqr.functions;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.FoodStats;
import net.minecraftforge.common.MinecraftForge;

import com.google.common.collect.Maps;

import dqr.DQR;
import dqr.api.Items.DQAccessories;
import dqr.api.Items.DQWeapons;
import dqr.api.enums.EnumDqmAccessory;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmSkillJ;
import dqr.api.enums.EnumDqmSkillW;
import dqr.api.enums.EnumDqmStatus;
import dqr.api.enums.EnumStat;
import dqr.api.event.DqrArmorSetEvent;
import dqr.api.potion.DQPotionMinus;
import dqr.api.potion.DQPotionPlus;
import dqr.gui.subEquip.InventorySubEquip;
import dqr.items.base.DqmItemArmorBase;
import dqr.items.base.DqmItemBowBase;
import dqr.items.base.DqmItemMagicBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties3;
import dqr.playerData.ExtendedPlayerProperties5;

public class FuncCalcPlayerStatus {

	public FuncCalcPlayerStatus(){}


	public int calcKaisin(EntityPlayer ep)
	{
		int kaisin = 0;


		int[] kaisinArray = ExtendedPlayerProperties.get(ep).getArrayKaisinrituA();
		for(int cnt = 0; cnt < kaisinArray.length; cnt++)
		{
			kaisin = kaisin + kaisinArray[cnt];
		}

		if(ep.getCurrentEquippedItem() != null)
		{
			//武器スキル
			int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
													  ExtendedPlayerProperties.get(ep).getWeapon(),
													  ep);
			if(apti == 0)
			{
				kaisin = kaisin + (getSwkillWPoint(ep, EnumDqmStatus.CRI.getId()) / 2);
			}else if(apti > 0)
			{
				kaisin = kaisin + getSwkillWPoint(ep, EnumDqmStatus.CRI.getId());
			}
		}

		//勇者剣：全武器で会心+がある場合
		if(ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(3, 4) != 0)
		{
			kaisin = kaisin + 20;
		}

		return kaisin;
	}

	public int calcMikawasi(EntityPlayer ep)
	{
		int Mikawasi = 0;


		int[] MikawasiArray = ExtendedPlayerProperties.get(ep).getArrayMikawasiA();
		for(int cnt = 0; cnt < MikawasiArray.length; cnt++)
		{
			Mikawasi = Mikawasi + MikawasiArray[cnt];
		}

		int[] SubayasaArray = ExtendedPlayerProperties.get(ep).getArraySubayasaA();
		for(int cnt = 0; cnt < SubayasaArray.length; cnt++)
		{
			Mikawasi = Mikawasi + SubayasaArray[cnt];
		}

		if(ep.getCurrentEquippedItem() != null)
		{
			//武器スキル
			int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
													  ExtendedPlayerProperties.get(ep).getWeapon(),
													  ep);
			if(apti == 0)
			{
				Mikawasi = Mikawasi + (getSwkillWPoint(ep, EnumDqmStatus.MISS.getId()) / 2);
			}else if(apti > 0)
			{
				Mikawasi = Mikawasi + getSwkillWPoint(ep, EnumDqmStatus.MISS.getId());
			}
		}


		//職業特技
		//DQR.func.debugString("Line1 : " + ExtendedPlayerProperties5.get(ep).getJobSPSkillSet(EnumDqmJob.Asobinin.getId(), 4));
		if(ExtendedPlayerProperties5.get(ep).getJobSPSkillSet(EnumDqmJob.Asobinin.getId(), 4) != 0)
		{
			//自分を励ます(瀕死時身かわし率 30％)
			int HP = (int)ExtendedPlayerProperties.get(ep).getHP();
			int MaxHP = (int)ExtendedPlayerProperties.get(ep).getMaxHP();
			//DQR.func.debugString("Line2 : " + MaxHP + " : " + HP + " : " + ((HP * 100) / MaxHP));
			if(MaxHP != 0 && (HP * 100) / MaxHP < 15)
			{
				EnumDqmSkillJ skill2 = DQR.enumGetter.getSkillJ(EnumDqmJob.Asobinin.getId(), 4);
				Mikawasi = Mikawasi + skill2.getSValue();
			}
		}
		//DQR.func.debugString("Line3 : " + Mikawasi);
		return Mikawasi;
	}

	public int calcMaryoku(EntityPlayer ep)
	{
		int matk = 0;

		int[] matkArray = ExtendedPlayerProperties.get(ep).getArrayMAGA();
		for(int cnt = 0; cnt < matkArray.length; cnt++)
		{
			matk = matk + matkArray[cnt];
		}

		int kasikosa = ExtendedPlayerProperties.get(ep).getKasikosa();

		matk = matk + (kasikosa / 2);

		if(ep.getCurrentEquippedItem() != null)
		{
			if(ep.getCurrentEquippedItem().getItem() instanceof DqmItemMagicBase)
			{
				DqmItemMagicBase magicItem = (DqmItemMagicBase)ep.getCurrentEquippedItem().getItem();
				int magDam = magicItem.getEnumMagic().getAttack();
				int resDam = DQR.magicTable.getReasonableDamage(magicItem, ep, magDam);

				matk = matk + resDam;
			}

			//武器スキル
			int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
													  ExtendedPlayerProperties.get(ep).getWeapon(),
													  ep);
			if(apti == 0)
			{
				matk = matk + (getSwkillWPoint(ep, EnumDqmStatus.MAG.getId()) / 2);
			}else if(apti > 0)
			{
				matk = matk + getSwkillWPoint(ep, EnumDqmStatus.MAG.getId());
			}
		}



		return matk;
	}

	public int calcAttack(EntityPlayer ep)
	{
		return this.calcAttack(ep, ep.getCurrentEquippedItem());
	}

	public int calcAttack(EntityPlayer ep, ItemStack tagItem)
	{
		//ep.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).setBaseValue(0.16D);
		//System.out.println("DEBUGLINE:" + ep.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).getAttributeValue());

		//素手の場合
		double emptyHandDam = (double)ExtendedPlayerProperties.get(ep).getTikara() / 5.0D;
		int playerJob = ExtendedPlayerProperties.get(ep).getJob();
		int playerWeapon = ExtendedPlayerProperties.get(ep).getWeapon();
		ep.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(emptyHandDam);
		int atk = 1 + (int)ep.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).getAttributeValue();


		if(tagItem != null)
		{

			if(tagItem.getItem() instanceof DqmItemWeaponBase)
			{

				if(ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(3, 7) != 0)
				{
					DqmItemWeaponBase weapon = (DqmItemWeaponBase)tagItem.getItem();
					if(weapon != null && weapon.getMaterial() != null && weapon.getMaterial() != DQR.dqmMaterial.DqmBraveSword)
					{
						atk = atk + 15;
					}
				}

				NBTTagList tag = tagItem.getEnchantmentTagList();
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

				DqmItemWeaponBase dqmSword = (DqmItemWeaponBase)tagItem.getItem();

		    	int maxDam = dqmSword.getMaxDamage();
		    	int calDam = maxDam - tagItem.getItemDamage();
		    	int perDam = calDam * 1000 / maxDam;
		    	float fixAptitude = 1.0F;

		    	//System.out.println("DEBUGLINE:" + maxDam + "/" + calDam + "/" + perDam);

		    	int aptitude = DQR.aptitudeTable.getWAptitude(playerJob, playerWeapon, ep);

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
		    		atk = atk + (int)(dqmSword.func_150931_i() * fixAptitude);
		    	}

				//武器スキル
				int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
														  ExtendedPlayerProperties.get(ep).getWeapon(),
														  ep);
				if(apti == 0)
				{
					atk = atk + (getSwkillWPoint(ep, EnumDqmStatus.ATK.getId()) / 2);
				}else if(apti > 0)
				{
					atk = atk + getSwkillWPoint(ep, EnumDqmStatus.ATK.getId());
				}

		        //Multimap multimap = HashMultimap.create();

		        //multimap.remove(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CA"), "Weapon modifier", (double)atk, 0));
		        //multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CA"), "Weapon modifier", (double)atk, 0));
		        //ep.getAttributeMap().applyAttributeModifiers(multimap);
				//atk = (int)dqmSword.func_150931_i();

				//とりあえず力を攻撃力にそのまま加算
				atk = atk + this.getLegendWeaponDamage(tagItem, ep);
				//atk = atk + ExtendedPlayerProperties.get(ep).getTikara();
			}else if(tagItem.getItem() instanceof DqmItemBowBase)
			{
				DqmItemBowBase dqmSword = (DqmItemBowBase)tagItem.getItem();

				if(ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(3, 7) != 0)
				{
					atk = atk + 15;
				}

		    	int maxDam = dqmSword.getMaxDamage();
		    	int calDam = maxDam - tagItem.getItemDamage();
		    	int perDam = calDam * 1000 / maxDam;
		    	int aptitude = DQR.aptitudeTable.getWAptitude(playerJob, playerWeapon, ep);
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

				NBTTagList tag = tagItem.getEnchantmentTagList();
				if(tag != null)
				{
					//DQR.func.debugString("DEBUG3:" + cnt);
			    	for(int cnt2 = 0; cnt2 < tag.tagCount(); cnt2++)
			    	{
			    		//DQR.func.debugString("DEBUG4:" + cnt2);

			    		NBTTagCompound nbt = tag.getCompoundTagAt(cnt2);
			    		if(nbt != null && nbt.getShort("id") == Enchantment.power.effectId)
			    		{
			    			atk = atk + ((int)(nbt.getShort("lvl")) * 2);
			    		}

			    		if(nbt != null && nbt.getShort("id") == Enchantment.sharpness.effectId)
			    		{
			    			atk = atk + ((int)(nbt.getShort("lvl")) * 2);
			    		}
			    	}
				}

		    	//System.out.println("DEBUGLINE:" + maxDam + "/" + calDam + "/" + perDam);

		    	atk = atk + (int)(dqmSword.func_150931_i() * fixAptitude * (perDam + 100) / 1000);

				//武器スキル
				int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
														  ExtendedPlayerProperties.get(ep).getWeapon(),
														  ep);
				if(apti == 0)
				{
					atk = atk + (getSwkillWPoint(ep, EnumDqmStatus.ATK.getId()) / 2);
				}else if(apti > 0)
				{
					atk = atk + getSwkillWPoint(ep, EnumDqmStatus.ATK.getId());
				}
		        //Multimap multimap = HashMultimap.create();
		        //multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF"), "Weapon modifier", (double)atk, 0));
		        //ep.getAttributeMap().applyAttributeModifiers(multimap);
		    	//ep.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(emptyHandDam + atk);
				//とりあえず力を攻撃力にそのまま加算
				atk = atk + this.getLegendWeaponDamage(tagItem, ep);
				//atk = atk + ExtendedPlayerProperties.get(ep).getTikara();
			}else if(tagItem.getItem() instanceof ItemSword)
			{
				ItemSword sword = (ItemSword)tagItem.getItem();
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

				if(ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(3, 7) != 0)
				{
					atk = atk + 15;
				}

				//武器スキル
				int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
														  ExtendedPlayerProperties.get(ep).getWeapon(),
														  ep);
				if(apti == 0)
				{
					atk = atk + (getSwkillWPoint(ep, EnumDqmStatus.ATK.getId()) / 2);
				}else if(apti > 0)
				{
					atk = atk + getSwkillWPoint(ep, EnumDqmStatus.ATK.getId());
				}

				//とりあえず力を攻撃力にそのまま加算
				//atk = atk + ExtendedPlayerProperties.get(ep).getTikara();
			}
			/*
			else if(tagItem.getClass().equals(Block.class))
			{

			}
			*/
		}

		int[] AtkArray = ExtendedPlayerProperties.get(ep).getArrayATKA();
		for(int cnt = 0; cnt < AtkArray.length; cnt++)
		{
			atk = atk + AtkArray[cnt];
		}
		//System.out.println("DEBUGLINE:" + ep.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue());
		//とりあえず力を攻撃力にそのまま加算
		//atk = atk + ExtendedPlayerProperties.get(ep).getTikara();

		PotionEffect pe;

		//バイキルト時2倍
		pe = ep.getActivePotionEffect(DQPotionPlus.buffBaikiruto);
		if(pe != null)
		{
			//atk = atk * (pe.getAmplifier() + 1);
			//atk = atk +  (atk * (pe.getAmplifier() + 1) / 2);
			float tmpPar = ((float)atk * (float)(pe.getAmplifier() + 1)) / 2;
			atk = atk + (int)tmpPar;
		}

		//ヘナトス
		pe = ep.getActivePotionEffect(DQPotionMinus.debuffHenatosu);
		if(pe != null)
		{
			//atk = atk / (pe.getAmplifier() + 2);
			//atk = atk -  (atk * (pe.getAmplifier() + 1) / 4);
			float tmpPar = ((float)atk * (float)(pe.getAmplifier() + 1)) / 4;
			atk = atk - (int)tmpPar;
		}

		/*
		if(DQR.dqEffect.isEnableEffect(ep, "JSkill" + "_" + EnumDqmJob.Asobinin.getId()  + "_" + 9))
		{
			DQR.func.debugString("############################");
		}
		*/

		//ストポ
		if(DQR.conf.bug_damageBoostPotionFix == 0)
		{
			pe = ep.getActivePotionEffect(Potion.damageBoost);
			if(pe != null)
			{
				//atk = atk + ((atk * ((pe.getAmplifier() + 1) * 130)) / 100);
				float tmpPar = ((float)atk * (float)(pe.getAmplifier() + 1)* 130) / 100;
				DQR.func.debugString("PARA : " + tmpPar + " / " + atk);
				atk = atk + (int)tmpPar;
			}
		}

		//竜の火酒
		if(DQR.dqEffect.isEnableEffect(ep, "item.dqm.itemRyuunohizake.name"))
		{
			atk = atk * 5;
		}

		if(atk < 0)
		{
			atk = 0;
		}
		ep.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).setBaseValue(emptyHandDam + atk);

		return atk + (int)emptyHandDam;
	}

	public float calcHP(EntityPlayer ep)
	{
		float HP = 20.0F;

		//HP = ExtendedPlayerProperties.get(this.ep).getMaxHP()F;
		int jobId =  ExtendedPlayerProperties.get(ep).getJob();

		float[] JobHP = ExtendedPlayerProperties.get(ep).getJobHPA();
		int job = ExtendedPlayerProperties.get(ep).getJob();

		for(int cnt = 0; cnt < JobHP.length; cnt++)
		{
			if(cnt == job)
			{
				HP = HP + JobHP[cnt];
			}else
			{
				//HP = HP + (JobHP[cnt] * 0.1F);
				if(jobId == EnumDqmJob.Haguremetal.getId())
				{
					HP = HP + (JobHP[cnt] / ((DQR.conf.DqmDifficulty + 2) * 3));
				}else
				{
					HP = HP + (JobHP[cnt] / ((DQR.conf.DqmDifficulty + 2) * 2));
				}
			}
		}

		if(jobId == EnumDqmJob.Haguremetal.getId() && HP > 100)
		{
			HP = 100;
		}

		float[] HPArray = ExtendedPlayerProperties.get(ep).getArrayHPA();
		for(int cnt = 0; cnt < HPArray.length; cnt++)
		{
			HP = HP + HPArray[cnt];
		}

		//武器スキル
		int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
												  ExtendedPlayerProperties.get(ep).getWeapon(),
												  ep);
		if(apti == 0)
		{
			HP = HP + (getSwkillWPoint(ep, EnumDqmStatus.HP.getId()) / 2);
		}else if(apti > 0)
		{
			HP = HP + getSwkillWPoint(ep, EnumDqmStatus.HP.getId());
		}

		return HP;
	}

	public int calcMP(EntityPlayer ep)
	{
		int MP = 0;

		//HP = ExtendedPlayerProperties.get(this.ep).getMaxHP()F;

		int[] MPArray = ExtendedPlayerProperties.get(ep).getArrayMPA();
		for(int cnt = 0; cnt < MPArray.length; cnt++)
		{
			MP = MP + MPArray[cnt];
		}

		int[] JobMP = ExtendedPlayerProperties.get(ep).getJobMPA();
		int job = ExtendedPlayerProperties.get(ep).getJob();

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

		//武器スキル
		int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
												  ExtendedPlayerProperties.get(ep).getWeapon(),
												  ep);
		if(apti == 0)
		{
			MP = MP + (getSwkillWPoint(ep, EnumDqmStatus.MP.getId()) / 2);
		}else if(apti > 0)
		{
			MP = MP + getSwkillWPoint(ep, EnumDqmStatus.MP.getId());
		}

		return MP;
	}

	public int calcSubayasa(EntityPlayer ep)
	{
		int subayasa;
		UUID subayasaUUID;

		subayasa = 0;

		int[] subayasaArray = ExtendedPlayerProperties.get(ep).getArraySubayasaA();
		for(int cnt = 0; cnt < subayasaArray.length; cnt++)
		{
			//String uid = "91AEAA56-376B-4498-935B-2F7F68" + cnt;
			subayasa = subayasa + subayasaArray[cnt];
			//func_111184_a(SharedMonsterAttributes.movementSpeed, uid, 0.80000000298023224D, 2);
		}

		//武器スキル
		int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
												  ExtendedPlayerProperties.get(ep).getWeapon(),
												  ep);
		if(apti == 0)
		{
			subayasa = subayasa + (getSwkillWPoint(ep, EnumDqmStatus.AGI.getId()) / 2);
		}else if(apti > 0)
		{
			subayasa = subayasa + getSwkillWPoint(ep, EnumDqmStatus.AGI.getId());
		}

		//ピオリム計算
		PotionEffect pe;
		pe = ep.getActivePotionEffect(DQPotionPlus.buffPiora);
		if(pe != null)
		{
			subayasa = subayasa +  (subayasa * (pe.getAmplifier() + 1) / 2);
		}
		//ボミオス計算
		pe = ep.getActivePotionEffect(DQPotionMinus.debuffBomie);
		if(pe != null)
		{
			float tmpPar = ((float)subayasa * (float)(pe.getAmplifier() + 1)) / 4;
			subayasa = subayasa - (int)tmpPar;
		}

		if(subayasa < 0)
		{
			subayasa = 0;
		}

		return subayasa;
	}

	public int calcTikara(EntityPlayer ep)
	{
		int tikara;

		tikara = 0;

		int[] tikaraArray = ExtendedPlayerProperties.get(ep).getArrayTikaraA();
		for(int cnt = 0; cnt < tikaraArray.length; cnt++)
		{
			tikara = tikara + tikaraArray[cnt];
		}

		int[] JobTikara = ExtendedPlayerProperties.get(ep).getJobTikaraA();
		int job = ExtendedPlayerProperties.get(ep).getJob();

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

		//武器スキル
		int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
												  ExtendedPlayerProperties.get(ep).getWeapon(),
												  ep);
		if(apti == 0)
		{
			tikara = tikara + (getSwkillWPoint(ep, EnumDqmStatus.STR.getId()) / 2);
		}else if(apti > 0)
		{
			tikara = tikara + getSwkillWPoint(ep, EnumDqmStatus.STR.getId());
		}

		return tikara;
	}

	public int calcKasikosa(EntityPlayer ep)
	{
		int kasikosa;

		kasikosa = 0;

		int[] kasikosaArray = ExtendedPlayerProperties.get(ep).getArrayKasikosaA();
		for(int cnt = 0; cnt < kasikosaArray.length; cnt++)
		{
			kasikosa = kasikosa + kasikosaArray[cnt];
		}

		int[] JobKasikosa = ExtendedPlayerProperties.get(ep).getJobKasikosaA();
		int job = ExtendedPlayerProperties.get(ep).getJob();

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

		//武器スキル
		int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
												  ExtendedPlayerProperties.get(ep).getWeapon(),
												  ep);
		if(apti == 0)
		{
			kasikosa = kasikosa + (getSwkillWPoint(ep, EnumDqmStatus.INT.getId()) / 2);
		}else if(apti > 0)
		{
			kasikosa = kasikosa + getSwkillWPoint(ep, EnumDqmStatus.INT.getId());
		}

		return kasikosa;
	}

	public int calcDeffence(EntityPlayer ep)
	{
		ItemArmor test;
		int def = 0;
		ArmorMaterial[] armorSet = new ArmorMaterial[4];


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

		int[] mamoriArray = ExtendedPlayerProperties.get(ep).getArrayMamoriA();
		for(int cnt = 0; cnt < mamoriArray.length; cnt++)
		{
			def = def + mamoriArray[cnt];
		}


		//武器スキル
		int apti = DQR.aptitudeTable.getWAptitude(ExtendedPlayerProperties.get(ep).getJob(),
												  ExtendedPlayerProperties.get(ep).getWeapon(),
												  ep);
		if(apti == 0)
		{
			def = def + (getSwkillWPoint(ep, EnumDqmStatus.DEF.getId()) / 2);
		}else if(apti > 0)
		{
			def = def + getSwkillWPoint(ep, EnumDqmStatus.DEF.getId());
		}

		//スカラ計算
		PotionEffect pe;
		pe = ep.getActivePotionEffect(DQPotionPlus.buffSukara);
		if(pe != null)
		{
			//def = def +  (def * (pe.getAmplifier() + 1) / 2);
			float tmpPar = ((float)def * (float)(pe.getAmplifier() + 1)) / 2;
			def = def + (int)tmpPar;
		}
		//ルカニ計算
		pe = ep.getActivePotionEffect(DQPotionMinus.debuffRukani);
		if(pe != null)
		{
			float tmpPar = ((float)def * (float)(pe.getAmplifier() + 1)) / 4;
			def = def - (int)tmpPar;
		}

		if(def < 0)
		{
			def = 0;
		}

		return def;
	}

	//防具セット効果チェック
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
    	if(par1 > 0)
    	{
    		if(ExtendedPlayerProperties.get(ep).getJob() == EnumDqmJob.Syounin.getId())
    		{
    			gold = gold * 3 / 4;
    		}
    	}
		return gold;
    }

    //武器特技値取得
    public int getSwkillWPoint(EntityPlayer ep, int StatusID)
    {
    	int ret = 0;
    	int weaponID = ExtendedPlayerProperties.get(ep).getWeapon();
    	TreeMap<Integer, EnumDqmSkillW> skillset = DQR.enumGetter.getSkillW(weaponID);
    	int[] skillPerm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermissionC(weaponID);

		for (int key : skillset.keySet())
		{
			if(skillPerm[key] == 1)
			{
				EnumDqmSkillW skillEnum = skillset.get(key);

				ret = ret + skillEnum.getParam(StatusID);
			}
		}

		/*
		//勇者剣：全武器で攻撃+がある場合
		if(ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(3, 7) != 0 && StatusID == EnumDqmStatus.ATK.getId())
		{
			ret = ret + 15;
		}
		*/
    	return ret;
    }

    public void calcAccessory(EntityPlayer ep)
    {
    	int buffFlg = ExtendedPlayerProperties.get(ep).getAccBuffStop();
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

        ExtendedPlayerProperties.get(ep).setArrayATK(EnumStat.accessory.getId(), ATK);
        ExtendedPlayerProperties.get(ep).setArrayMAG(EnumStat.accessory.getId(), MAG);
        ExtendedPlayerProperties.get(ep).setArrayDEF(EnumStat.accessory.getId(), DEF);
        ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.accessory.getId(), STR);
        ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.accessory.getId(), INT);
        ExtendedPlayerProperties.get(ep).setArrayHP(EnumStat.accessory.getId(), HP);
        ExtendedPlayerProperties.get(ep).setArrayMP(EnumStat.accessory.getId(), MP);
        ExtendedPlayerProperties.get(ep).setArrayMikawasi(EnumStat.accessory.getId(), MISS);
        ExtendedPlayerProperties.get(ep).setArrayKaisinritu(EnumStat.accessory.getId(), CRI);

        //アクセサリエフェクト
        int hoshihuri = -1;
        int hpRegeneration = -1;
        int mpRegeneration = -1;

        //ハラヘラズ・ハラモチの指輪
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

		//星降りピアス
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

		//癒しの腕輪
		/*
		if(equipment.hasUdewa(DQAccessories.itemIyasinoudewa) != -1)
		{
			hpRegeneration = hpRegeneration + 1;
		}
		*/

		//疾風指輪
		if(equipment.hasYubiwa2(DQAccessories.itemHayatenoring) != -1)
		{
			hoshihuri = hoshihuri + 2;
		}
		/*
		//命の指輪
		if(equipment.hasYubiwa(DQAccessories.itemInotinoyubiwa))
		{
			hpRegeneration = hpRegeneration + 2;
		}
		*/

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

		if(hpRegeneration >= 0 && buffFlg == 0)
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.buffHPRegeneration.id, 200, hpRegeneration));
		}else
		{
			ep.removePotionEffect(DQPotionPlus.buffHPRegeneration.id);
		}

		if(mpRegeneration >= 0 && buffFlg == 0)
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.buffMPRegeneration.id, 200, mpRegeneration));
		}else
		{
			ep.removePotionEffect(DQPotionPlus.buffMPRegeneration.id);
		}

		if(hoshihuri >= 0 && buffFlg == 0)
		{
			DQR.func.addPotionEffect2(ep, new PotionEffect(DQPotionPlus.buffHoshihuru.id, 200, hoshihuri));
		}else
		{
			ep.removePotionEffect(DQPotionPlus.buffHoshihuru.id);
		}
		equipment.markDirty();
		equipment.closeInventory();
    }

    public int getLegendWeaponDamage(ItemStack par1, EntityPlayer ep)
    {
    	int ret = 0;

    	if(par1 != null)
    	{
    		Item item =  par1.getItem();
    		int jExp = 0;

    		if(item == DQWeapons.itemGinganoturugi2 ||
    		   item == DQWeapons.itemSinken2 ||
    		   item == DQWeapons.itemKobusi32 ||
    		   item == DQWeapons.itemSinryuunotume2||
    		   item == DQWeapons.itemHakainotekkyuu2 ||
    		   item == DQWeapons.itemGodakkusu2 ||
    		   item == DQWeapons.itemTyouguringamunomuti2 ||
    		   item == DQWeapons.itemMetarukingnoyari2 ||
    		   item == DQWeapons.itemToririondaga2 ||
    		   item == DQWeapons.itemSefiramunoyumi2 ||
    		   item == DQWeapons.itemHaipanova2 ||
    		   item == DQWeapons.itemNyoraikon2 ||
    		   item == DQWeapons.itemSeiginosoroban2 ||
    		   item == DQWeapons.itemSaisyuuougi2)
    		{
    			if(DQR.aptitudeTable.getWAptitude(
    					ExtendedPlayerProperties.get(ep).getJob(),
    					ExtendedPlayerProperties.get(ep).getWeapon(),
						ep) > 1)
    			{
    				jExp = ExtendedPlayerProperties.get(ep).getJukurenExp(ExtendedPlayerProperties.get(ep).getWeapon());
    			}

    			ret = jExp / 5000;
    		}
    	}
    	return ret;
    }
}
