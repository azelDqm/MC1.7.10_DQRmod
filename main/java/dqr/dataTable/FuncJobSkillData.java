package dqr.dataTable;

import net.minecraft.entity.player.EntityPlayer;
import dqr.api.enums.EnumDqmStatus;
import dqr.api.enums.EnumStat;
import dqr.playerData.ExtendedPlayerProperties;
import dqr.playerData.ExtendedPlayerProperties5;

public class FuncJobSkillData {

	public static EnumDqmStatus[] jobSkillCateg_Civilian = {EnumDqmStatus.HP, EnumDqmStatus.HP, EnumDqmStatus.MISS, EnumDqmStatus.INT, EnumDqmStatus.MP, EnumDqmStatus.HP, EnumDqmStatus.CRI, EnumDqmStatus.INT, EnumDqmStatus.STR};
	public static EnumDqmStatus[] jobSkillCateg_Warrior = {EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.DEF, EnumDqmStatus.STR, EnumDqmStatus.DEF, EnumDqmStatus.HP, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_Fighter = {EnumDqmStatus.HP, EnumDqmStatus.CRI, EnumDqmStatus.MISS, EnumDqmStatus.STR, EnumDqmStatus.MISS, EnumDqmStatus.CRI, EnumDqmStatus.HP, EnumDqmStatus.ATK, EnumDqmStatus.CRI};
	public static EnumDqmStatus[] jobSkillCateg_Magician = {EnumDqmStatus.MP, EnumDqmStatus.INT, EnumDqmStatus.HP, EnumDqmStatus.INT, EnumDqmStatus.MISS, EnumDqmStatus.INT, EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.MAG};
	public static EnumDqmStatus[] jobSkillCateg_Priest = {EnumDqmStatus.MP, EnumDqmStatus.INT, EnumDqmStatus.HP, EnumDqmStatus.INT, EnumDqmStatus.STR, EnumDqmStatus.INT, EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.MAG};
	public static EnumDqmStatus[] jobSkillCateg_Merchant = {EnumDqmStatus.HP, EnumDqmStatus.INT, EnumDqmStatus.MP, EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.INT, EnumDqmStatus.MISS, EnumDqmStatus.DEF, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_Thief = {EnumDqmStatus.MISS, EnumDqmStatus.HP, EnumDqmStatus.MISS, EnumDqmStatus.STR, EnumDqmStatus.CRI, EnumDqmStatus.MP, EnumDqmStatus.HP, EnumDqmStatus.ATK, EnumDqmStatus.MISS};
	public static EnumDqmStatus[] jobSkillCateg_Shepherd = {EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.DEF, EnumDqmStatus.STR, EnumDqmStatus.INT, EnumDqmStatus.STR, EnumDqmStatus.DEF};
	public static EnumDqmStatus[] jobSkillCateg_Sailor = {EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.DEF, EnumDqmStatus.INT, EnumDqmStatus.MISS, EnumDqmStatus.DEF, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_BattleMaster = {EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.CRI, EnumDqmStatus.MISS, EnumDqmStatus.DEF, EnumDqmStatus.STR, EnumDqmStatus.CRI, EnumDqmStatus.HP, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_Sage = {EnumDqmStatus.HP, EnumDqmStatus.INT, EnumDqmStatus.MP, EnumDqmStatus.INT, EnumDqmStatus.MISS, EnumDqmStatus.INT, EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.MAG};
	public static EnumDqmStatus[] jobSkillCateg_Paladin = {EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.INT, EnumDqmStatus.DEF, EnumDqmStatus.STR, EnumDqmStatus.MP, EnumDqmStatus.HP, EnumDqmStatus.DEF, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_MagickKnight = {EnumDqmStatus.INT, EnumDqmStatus.STR, EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.DEF, EnumDqmStatus.STR, EnumDqmStatus.INT, EnumDqmStatus.MAG, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_Ranger = {EnumDqmStatus.HP, EnumDqmStatus.CRI, EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.HP, EnumDqmStatus.MISS, EnumDqmStatus.CRI, EnumDqmStatus.DEF, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_Dancer = {EnumDqmStatus.HP, EnumDqmStatus.MISS, EnumDqmStatus.MP, EnumDqmStatus.MISS, EnumDqmStatus.HP, EnumDqmStatus.INT, EnumDqmStatus.STR, EnumDqmStatus.ATK, EnumDqmStatus.MISS};
	public static EnumDqmStatus[] jobSkillCateg_Pirate = {EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.DEF, EnumDqmStatus.INT, EnumDqmStatus.MISS, EnumDqmStatus.DEF, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_MonsterTamer = {EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.HP, EnumDqmStatus.MISS, EnumDqmStatus.CRI, EnumDqmStatus.INT, EnumDqmStatus.MP, EnumDqmStatus.HP, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_SuperStar = {EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.MISS, EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.CRI, EnumDqmStatus.MISS, EnumDqmStatus.MAG, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_GodHnad = {EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.CRI, EnumDqmStatus.MISS, EnumDqmStatus.DEF, EnumDqmStatus.STR, EnumDqmStatus.CRI, EnumDqmStatus.HP, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_Summoner = {EnumDqmStatus.HP, EnumDqmStatus.INT, EnumDqmStatus.MP, EnumDqmStatus.INT, EnumDqmStatus.MISS, EnumDqmStatus.INT, EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.MAG};
	public static EnumDqmStatus[] jobSkillCateg_ItemMaster = {EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.STR, EnumDqmStatus.INT, EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.DEF, EnumDqmStatus.DEF, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_Metal = {EnumDqmStatus.MISS, EnumDqmStatus.MP, EnumDqmStatus.CRI, EnumDqmStatus.MP, EnumDqmStatus.DEF, EnumDqmStatus.STR, EnumDqmStatus.MISS, EnumDqmStatus.HP, EnumDqmStatus.MAG};
	public static EnumDqmStatus[] jobSkillCateg_Dragon = {EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.STR, EnumDqmStatus.CRI, EnumDqmStatus.INT, EnumDqmStatus.STR, EnumDqmStatus.ATK, EnumDqmStatus.MAG, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_Hero = {EnumDqmStatus.HP, EnumDqmStatus.STR, EnumDqmStatus.MP, EnumDqmStatus.INT, EnumDqmStatus.MISS, EnumDqmStatus.CRI, EnumDqmStatus.DEF, EnumDqmStatus.MAG, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_Legend = {EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.ATK, EnumDqmStatus.CRI, EnumDqmStatus.MISS, EnumDqmStatus.DEF, EnumDqmStatus.HP, EnumDqmStatus.MAG, EnumDqmStatus.ATK};
	public static EnumDqmStatus[] jobSkillCateg_MasterDragon = {EnumDqmStatus.HP, EnumDqmStatus.MP, EnumDqmStatus.MAG, EnumDqmStatus.CRI, EnumDqmStatus.MISS, EnumDqmStatus.DEF, EnumDqmStatus.MP, EnumDqmStatus.ATK, EnumDqmStatus.MAG};

	public static int[] jobSkillParam_Civilian = {15, 25, 5, 20, 50, 50, 5, 30, 25};
	public static int[] jobSkillParam_Warrior = {10, 5, 20, 10, 3, 15, 7, 40, 5};
	public static int[] jobSkillParam_Fighter = {5, 5, 5, 10, 10, 15, 10, 3, 20};
	public static int[] jobSkillParam_Magician = {20, 5, 20, 15, 3, 20, 30, 50, 5};
	public static int[] jobSkillParam_Priest = {20, 5, 30, 10, 5, 15, 50, 35, 5};
	public static int[] jobSkillParam_Merchant = {10, 5, 10, 30, 10, 10, 5, 5, 2};
	public static int[] jobSkillParam_Thief = {5, 10, 10, 10, 3, 10, 30, 3, 15};
	public static int[] jobSkillParam_Shepherd = {10, 10, 20, 20, 3, 5, 10, 15, 5};
	public static int[] jobSkillParam_Sailor = {10, 5, 15, 10, 3, 10, 5, 5, 3};
	public static int[] jobSkillParam_BattleMaster = {25, 15, 5, 15, 5, 35, 10, 100, 10};
	public static int[] jobSkillParam_Sage = {30, 15, 75, 30, 6, 50, 50, 150, 5};
	public static int[] jobSkillParam_Paladin = {50, 50, 25, 5, 25, 75, 100, 10, 10};
	public static int[] jobSkillParam_MagickKnight = {25, 25, 75, 75, 5, 50, 50, 5, 5};
	public static int[] jobSkillParam_Ranger = {25, 5, 50, 15, 50, 10, 10, 5, 5};
	public static int[] jobSkillParam_Dancer = {30, 10, 50, 20, 70, 25, 15, 3, 30};
	public static int[] jobSkillParam_Pirate = {25, 10, 50, 20, 5, 15, 5, 5, 5};
	public static int[] jobSkillParam_MonsterTamer = {30, 20, 50, 10, 10, 20, 100, 75, 3};
	public static int[] jobSkillParam_SuperStar = {75, 75, 20, 100, 100, 15, 30, 8, 8};
	public static int[] jobSkillParam_GodHnad = {75, 40, 15, 5, 5, 60, 15, 150, 15};
	public static int[] jobSkillParam_Summoner = {50, 40, 100, 50, 5, 60, 75, 200, 15};
	public static int[] jobSkillParam_ItemMaster = {80, 60, 35, 35, 100, 70, 5, 10, 10};
	public static int[] jobSkillParam_Metal = {50, 100, 10, 150, 20, 25, 150, 50, 20};
	public static int[] jobSkillParam_Dragon = {75, 75, 25, 10, 35, 40, 10, 5, 8};
	public static int[] jobSkillParam_Hero = {100, 50, 100, 50, 10, 5, 10, 15, 15};
	public static int[] jobSkillParam_Legend = {150, 150, 10, 70, 50, 15, 200, 15, 25};
	public static int[] jobSkillParam_MasterDragon = {150, 150, 10, 70, 50, 15, 200, 15, 25};

	public static int[] jobSkillParam2_Civilian = {3, 5, 1, 4, 10, 10, 1, 6, 5};
	public static int[] jobSkillParam2_Warrior = {2, 1, 4, 2, 1, 3, 2, 8, 1};
	public static int[] jobSkillParam2_Fighter = {1, 1, 1, 2, 2, 3, 2, 1, 4};
	public static int[] jobSkillParam2_Magician = {4, 1, 4, 3, 1, 4, 6, 10, 1};
	public static int[] jobSkillParam2_Priest = {4, 1, 6, 2, 1, 3, 10, 7, 1};
	public static int[] jobSkillParam2_Merchant = {2, 1, 2, 6, 2, 2, 1, 1, 1};
	public static int[] jobSkillParam2_Thief = {1, 2, 2, 2, 1, 2, 6, 1, 3};
	public static int[] jobSkillParam2_Shepherd = {2, 2, 4, 4, 1, 1, 2, 3, 1};
	public static int[] jobSkillParam2_Sailor = {2, 1, 3, 2, 1, 2, 1, 1, 1};
	public static int[] jobSkillParam2_BattleMaster = {5, 3, 1, 3, 1, 7, 2, 20, 2};
	public static int[] jobSkillParam2_Sage = {6, 3, 15, 6, 2, 10, 10, 30, 1};
	public static int[] jobSkillParam2_Paladin = {10, 10, 5, 1, 5, 15, 20, 2, 2};
	public static int[] jobSkillParam2_MagickKnight = {5, 5, 15, 15, 1, 10, 10, 1, 1};
	public static int[] jobSkillParam2_Ranger = {5, 1, 10, 3, 10, 2, 2, 1, 1};
	public static int[] jobSkillParam2_Dancer = {6, 2, 10, 4, 14, 5, 3, 1, 6};
	public static int[] jobSkillParam2_Pirate = {5, 2, 10, 4, 1, 3, 1, 1, 1};
	public static int[] jobSkillParam2_MonsterTamer = {6, 4, 10, 2, 2, 4, 20, 15, 1};
	public static int[] jobSkillParam2_SuperStar = {15, 15, 4, 20, 20, 3, 6, 2, 2};
	public static int[] jobSkillParam2_GodHnad = {15, 8, 3, 1, 1, 12, 3, 30, 3};
	public static int[] jobSkillParam2_Summoner = {10, 8, 20, 10, 1, 12, 15, 40, 3};
	public static int[] jobSkillParam2_ItemMaster = {16, 12, 7, 7, 20, 14, 1, 2, 2};
	public static int[] jobSkillParam2_Metal = {10, 20, 2, 30, 4, 5, 30, 10, 4};
	public static int[] jobSkillParam2_Dragon = {15, 15, 5, 2, 7, 8, 2, 1, 2};
	public static int[] jobSkillParam2_Hero = {20, 10, 20, 10, 2, 1, 2, 3, 3};
	public static int[] jobSkillParam2_Legend = {30, 30, 2, 14, 10, 3, 40, 3, 5};
	public static int[] jobSkillParam2_MasterDragon = {30, 30, 2, 14, 10, 3, 40, 3, 5};

	public static EnumDqmStatus[] getJobSkillCateg(int par1)
	{
		if(par1 == 0) return jobSkillCateg_Civilian;
		if(par1 == 1) return jobSkillCateg_Warrior;
		if(par1 == 2) return jobSkillCateg_Fighter;
		if(par1 == 4) return jobSkillCateg_Magician;
		if(par1 == 5) return jobSkillCateg_Priest;
		if(par1 == 14) return jobSkillCateg_Merchant;
		if(par1 == 15) return jobSkillCateg_Thief;
		if(par1 == 22) return jobSkillCateg_Shepherd;
		if(par1 == 23) return jobSkillCateg_Sailor;
		if(par1 == 3) return jobSkillCateg_BattleMaster;
		if(par1 == 6) return jobSkillCateg_Sage;
		if(par1 == 8) return jobSkillCateg_Paladin;
		if(par1 == 9) return jobSkillCateg_MagickKnight;
		if(par1 == 10) return jobSkillCateg_Ranger;
		if(par1 == 19) return jobSkillCateg_Dancer;
		if(par1 == 20) return jobSkillCateg_Pirate;
		if(par1 == 11) return jobSkillCateg_MonsterTamer;
		if(par1 == 12) return jobSkillCateg_SuperStar;
		if(par1 == 16) return jobSkillCateg_GodHnad;
		if(par1 == 25) return jobSkillCateg_Summoner;
		if(par1 == 24) return jobSkillCateg_ItemMaster;
		if(par1 == 13) return jobSkillCateg_Metal;
		if(par1 == 17) return jobSkillCateg_Dragon;
		if(par1 == 7) return jobSkillCateg_Hero;
		if(par1 == 18) return jobSkillCateg_Legend;
		if(par1 == 21) return jobSkillCateg_MasterDragon;

		return null;
	}

	public static int[] getJobSkillParam(int par1)
	{
		if(par1 == 0) return jobSkillParam_Civilian;
		if(par1 == 1) return jobSkillParam_Warrior;
		if(par1 == 2) return jobSkillParam_Fighter;
		if(par1 == 4) return jobSkillParam_Magician;
		if(par1 == 5) return jobSkillParam_Priest;
		if(par1 == 14) return jobSkillParam_Merchant;
		if(par1 == 15) return jobSkillParam_Thief;
		if(par1 == 22) return jobSkillParam_Shepherd;
		if(par1 == 23) return jobSkillParam_Sailor;
		if(par1 == 3) return jobSkillParam_BattleMaster;
		if(par1 == 6) return jobSkillParam_Sage;
		if(par1 == 8) return jobSkillParam_Paladin;
		if(par1 == 9) return jobSkillParam_MagickKnight;
		if(par1 == 10) return jobSkillParam_Ranger;
		if(par1 == 19) return jobSkillParam_Dancer;
		if(par1 == 20) return jobSkillParam_Pirate;
		if(par1 == 11) return jobSkillParam_MonsterTamer;
		if(par1 == 12) return jobSkillParam_SuperStar;
		if(par1 == 16) return jobSkillParam_GodHnad;
		if(par1 == 25) return jobSkillParam_Summoner;
		if(par1 == 24) return jobSkillParam_ItemMaster;
		if(par1 == 13) return jobSkillParam_Metal;
		if(par1 == 17) return jobSkillParam_Dragon;
		if(par1 == 7) return jobSkillParam_Hero;
		if(par1 == 18) return jobSkillParam_Legend;
		if(par1 == 21) return jobSkillParam_MasterDragon;

		return null;
	}

	public static int[] getJobSkillParam2(int par1)
	{
		if(par1 == 0) return jobSkillParam2_Civilian;
		if(par1 == 1) return jobSkillParam2_Warrior;
		if(par1 == 2) return jobSkillParam2_Fighter;
		if(par1 == 4) return jobSkillParam2_Magician;
		if(par1 == 5) return jobSkillParam2_Priest;
		if(par1 == 14) return jobSkillParam2_Merchant;
		if(par1 == 15) return jobSkillParam2_Thief;
		if(par1 == 22) return jobSkillParam2_Shepherd;
		if(par1 == 23) return jobSkillParam2_Sailor;
		if(par1 == 3) return jobSkillParam2_BattleMaster;
		if(par1 == 6) return jobSkillParam2_Sage;
		if(par1 == 8) return jobSkillParam2_Paladin;
		if(par1 == 9) return jobSkillParam2_MagickKnight;
		if(par1 == 10) return jobSkillParam2_Ranger;
		if(par1 == 19) return jobSkillParam2_Dancer;
		if(par1 == 20) return jobSkillParam2_Pirate;
		if(par1 == 11) return jobSkillParam2_MonsterTamer;
		if(par1 == 12) return jobSkillParam2_SuperStar;
		if(par1 == 16) return jobSkillParam2_GodHnad;
		if(par1 == 25) return jobSkillParam2_Summoner;
		if(par1 == 24) return jobSkillParam2_ItemMaster;
		if(par1 == 13) return jobSkillParam2_Metal;
		if(par1 == 17) return jobSkillParam2_Dragon;
		if(par1 == 7) return jobSkillParam2_Hero;
		if(par1 == 18) return jobSkillParam2_Legend;
		if(par1 == 21) return jobSkillParam2_MasterDragon;

		return null;
	}

	public static void calcPlayerStatus(EntityPlayer ep)
	{
		//System.out.println("JobGUItest : calcPlayerStatus");
		//その職のみステータス計算
		int jobId = ExtendedPlayerProperties.get(ep).getJob();
		int[] skillSet = ExtendedPlayerProperties5.get(ep).getJobSkillSetA2(jobId);
		EnumDqmStatus[] skillCateg = getJobSkillCateg(jobId);
		int[] skillParam = getJobSkillParam(jobId);

		int[] upParam1 = new int[10];
		if(skillCateg != null && skillCateg.length > 0)
		{
			for(int cnt = 0; cnt < skillCateg.length; cnt++)
			{
				if(skillSet[cnt] == 1)
				{
					upParam1[skillCateg[cnt].getId() - 6] = upParam1[skillCateg[cnt].getId() - 6] + skillParam[cnt];
				}
			}
		}

		ExtendedPlayerProperties.get(ep).setArrayHP(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.HP.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayMP(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.MP.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayATK(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.ATK.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayDEF(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.DEF.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayMAG(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.MAG.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.STR.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.AGI.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.INT.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayKaisinritu(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.CRI.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayMikawasi(EnumStat.jobSkill1.getId(), upParam1[EnumDqmStatus.MISS.getId() - 6]);
	}

	public static void calcPlayerStatus2(EntityPlayer ep)
	{
		//System.out.println("JobGUItest : calcPlayerStatus2");
		int[][] skillSet = ExtendedPlayerProperties5.get(ep).getJobSkillSet2A();
		int[] upParam1 = new int[10];

		for(int job = 0; job < skillSet.length; job++)
		{
			EnumDqmStatus[] skillCateg = getJobSkillCateg(job);
			int[] skillParam = getJobSkillParam2(job);
			for(int idx = 0; idx < skillSet[job].length; idx++)
			{
				if(skillSet[job][idx] == 1 && skillParam != null && skillCateg != null)
				{
					upParam1[skillCateg[idx].getId() - 6] = upParam1[skillCateg[idx].getId() - 6] + skillParam[idx];
				}
			}
		}

		ExtendedPlayerProperties.get(ep).setArrayHP(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.HP.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayMP(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.MP.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayATK(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.ATK.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayDEF(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.DEF.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayMAG(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.MAG.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayTikara(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.STR.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArraySubayasa(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.AGI.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayKasikosa(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.INT.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayKaisinritu(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.CRI.getId() - 6]);
		ExtendedPlayerProperties.get(ep).setArrayMikawasi(EnumStat.jobSkill2.getId(), upParam1[EnumDqmStatus.MISS.getId() - 6]);

	}

	public static int getSkillMaxCount(int jobLv)
	{
		return (jobLv - 5) / 5;
	}

	public static int getSkillMaxCount2(int jobLv)
	{
		if(jobLv < 20)
		{
			return 0;
		}else
		{
			return (jobLv - 15) / 5;
		}
	}

	public static int getNeedSP(int idx)
	{
		if(idx == 0) return 5;
		if(idx == 1) return 10;
		if(idx == 2) return 10;
		if(idx == 3) return 20;
		if(idx == 4) return 20;
		if(idx == 5) return 30;
		if(idx == 6) return 30;
		if(idx == 7) return 35;
		if(idx == 8) return 40;

		return 0;
	}

	public static int getMaxSP(int jobLv)
	{
		if(jobLv == 99)
		{
			return 200;
		}else
		{
			return (jobLv / 5) * 10;
		}
	}

}
