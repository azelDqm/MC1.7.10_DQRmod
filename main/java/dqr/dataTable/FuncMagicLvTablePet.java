package dqr.dataTable;

import dqr.api.enums.EnumDqmMobAI;
import dqr.api.enums.EnumDqmPet;
import dqr.entity.petEntity.DqmPetBase;

public class FuncMagicLvTablePet {

	public static int[] dummyNull = {-1};
	public static int[] JUMP = {0};
	public static int[] HONOO = {3, 15, 29, 55, 92};
	public static int[] HUBUKI = {5, 18, 34, 63, 93};
	public static int[] POISON = {0};
	public static int[] GIRA = {9, 23, 35, 63};
	public static int[] MERA = {3, 15, 25, 49};
	public static int[] IO = {12, 27, 38, 67};
	public static int[] RAIDEIN = {13, 27, 50};
	public static int[] BAGI = {11, 22, 38, 63};
	public static int[] DORUMA = {14, 26, 38, 68};
	public static int[] HYADO = {5, 18, 31, 58};
	public static int[] HOIMI = {8, 18, 32};
	public static int[] ZAKI = {24, 59, 60};
	public static int[] BAIKIRUTO = {35};
	public static int[] SUKARA = {18};
	public static int[] BAHA = {22};
	public static int[] PIORA = {13};
	public static int[] MAGICBARIA = {28};
	public static int[] MAHOKANTA = {38};
	public static int[] BOMIE = {17};

	public static int[] RARIHO = {11};
	public static int[] MANUSA = {9};
	public static int[] MAHOTON = {18};
	public static int[] RUKANI = {25};
	public static int[] MEDAPANI = {32};
	public static int[] HENATOSU = {42};
	public static int[] DIVAINSUPERU = {20};
	public static int[] RUKANAN = {34};
	public static int[] RARIHOMA = {34};
	public static int[] BOMIOSU = {32};
	public static int[] SUKURUTO = {35};
	public static int[] PIORIMU = {29};
	public static int[] BEHOMARA = {35, 54};
	public static int[] MAHOIMI = {12, 32, 56};
	public static int[] POISONX = {0};
	public static int[] TELEPORT = {0};
	public static int[] MEGANTE = {0};
	public static int[] ARROW = {0};
	public static int[] HEAVYFIRE = {0};
	public static int[] AVOID = {0};


	public FuncMagicLvTablePet(){}

	public int magicCastGrade(DqmPetBase pet, EnumDqmMobAI ai)
	{
		int ret = -1;
		int[] boxData = null;

		//test = dummyNull;
		if(ai == EnumDqmMobAI.NONE){boxData = this.dummyNull;}
		else if(ai == EnumDqmMobAI.JUMP){boxData = this.JUMP;}
		else if(ai == EnumDqmMobAI.HONOO){boxData = this.HONOO;}
		else if(ai == EnumDqmMobAI.HUBUKI){boxData = this.HUBUKI;}
		else if(ai == EnumDqmMobAI.POISON){boxData = this.POISON;}
		else if(ai == EnumDqmMobAI.GIRA){boxData = this.GIRA;}
		else if(ai == EnumDqmMobAI.MERA){boxData = this.MERA;}
		else if(ai == EnumDqmMobAI.IO){boxData = this.IO;}
		else if(ai == EnumDqmMobAI.RAIDEIN){boxData = this.RAIDEIN;}
		else if(ai == EnumDqmMobAI.BAGI){boxData = this.BAGI;}
		else if(ai == EnumDqmMobAI.DORUMA){boxData = this.DORUMA;}
		else if(ai == EnumDqmMobAI.HYADO){boxData = this.HYADO;}
		else if(ai == EnumDqmMobAI.HOIMI){boxData = this.HOIMI;}
		else if(ai == EnumDqmMobAI.ZAKI){boxData = this.ZAKI;}
		else if(ai == EnumDqmMobAI.BAIKIRUTO){boxData = this.BAIKIRUTO;}
		else if(ai == EnumDqmMobAI.SUKARA){boxData = this.SUKARA;}
		else if(ai == EnumDqmMobAI.BAHA){boxData = this.BAHA;}
		else if(ai == EnumDqmMobAI.PIORA){boxData = this.PIORA;}
		else if(ai == EnumDqmMobAI.MAGICBARIA){boxData = this.MAGICBARIA;}
		else if(ai == EnumDqmMobAI.MAHOKANTA){boxData = this.MAHOKANTA;}
		else if(ai == EnumDqmMobAI.BOMIE){boxData = this.BOMIE;}
		else if(ai == EnumDqmMobAI.RARIHO){boxData = this.RARIHO;}
		else if(ai == EnumDqmMobAI.MANUSA){boxData = this.MANUSA;}
		else if(ai == EnumDqmMobAI.MAHOTON){boxData = this.MAHOTON;}
		else if(ai == EnumDqmMobAI.RUKANI){boxData = this.RUKANI;}
		else if(ai == EnumDqmMobAI.MEDAPANI){boxData = this.MEDAPANI;}
		else if(ai == EnumDqmMobAI.HENATOSU){boxData = this.HENATOSU;}
		else if(ai == EnumDqmMobAI.DIVAINSUPERU){boxData = this.DIVAINSUPERU;}
		else if(ai == EnumDqmMobAI.RUKANAN){boxData = this.RUKANAN;}
		else if(ai == EnumDqmMobAI.RARIHOMA){boxData = this.RARIHOMA;}
		else if(ai == EnumDqmMobAI.BOMIOSU){boxData = this.BOMIOSU;}
		else if(ai == EnumDqmMobAI.SUKURUTO){boxData = this.SUKURUTO;}
		else if(ai == EnumDqmMobAI.PIORIMU){boxData = this.PIORIMU;}
		else if(ai == EnumDqmMobAI.BEHOMARA){boxData = this.BEHOMARA;}
		else if(ai == EnumDqmMobAI.MAHOIMI){boxData = this.MAHOIMI;}
		else if(ai == EnumDqmMobAI.POISONX){boxData = this.POISONX;}
		else if(ai == EnumDqmMobAI.TELEPORT){boxData = this.TELEPORT;}
		else if(ai == EnumDqmMobAI.MEGANTE){boxData = this.MEGANTE;}
		else if(ai == EnumDqmMobAI.ARROW){boxData = this.ARROW;}
		else if(ai == EnumDqmMobAI.HEAVYFIRE){boxData = this.HEAVYFIRE;}
		else if(ai == EnumDqmMobAI.AVOID){boxData = this.AVOID;}
		else{return -1;}

		int petLv = pet.getJobLv(pet.getJob());
		int magicSetGrade = pet.getArrayAISets(ai.getId());
		int magicSetMaster = pet.getArrayAIMaster(ai.getId());
        EnumDqmPet petType = pet.type;
        int fixLv = 99 - petType.MaxLv;

        /*
		if(magicSetGrade != 0)
		{
			int[] jobLvA = pet.getJobLvA();
			for(int cnt2 = 0; cnt2 < jobLvA.length; cnt2++)
			{
				DQR.func.debugString("TEST_Q : [" + cnt2 + "]" + jobLvA[cnt2]);
			}
		}
		*/
		//DQR.func.debugString("TEST3 : " + petLv + " / " + magicSetGrade, this.getClass());
		for(int cnt = magicSetGrade - 1; cnt >= 0; cnt--)
		{
			if(boxData.length >= cnt + 1)
			{
				//DQR.func.debugString("TEST5 : [" + cnt + "]" + boxData[cnt] + " : " +  petLv);
				if(boxData[cnt] <= petLv + fixLv || magicSetMaster >= cnt)
				{
					return (cnt + 1);
				}
			}
		}

		return ret;
	}


	public int magicCastGradeFromID(DqmPetBase pet, int ai)
	{
		int ret = -1;
		int[] boxData = null;

		//test = dummyNull;
		if(ai == EnumDqmMobAI.NONE.getId()){boxData = this.dummyNull;}
		else if(ai == EnumDqmMobAI.JUMP.getId()){boxData = this.JUMP;}
		else if(ai == EnumDqmMobAI.HONOO.getId()){boxData = this.HONOO;}
		else if(ai == EnumDqmMobAI.HUBUKI.getId()){boxData = this.HUBUKI;}
		else if(ai == EnumDqmMobAI.POISON.getId()){boxData = this.POISON;}
		else if(ai == EnumDqmMobAI.GIRA.getId()){boxData = this.GIRA;}
		else if(ai == EnumDqmMobAI.MERA.getId()){boxData = this.MERA;}
		else if(ai == EnumDqmMobAI.IO.getId()){boxData = this.IO;}
		else if(ai == EnumDqmMobAI.RAIDEIN.getId()){boxData = this.RAIDEIN;}
		else if(ai == EnumDqmMobAI.BAGI.getId()){boxData = this.BAGI;}
		else if(ai == EnumDqmMobAI.DORUMA.getId()){boxData = this.DORUMA;}
		else if(ai == EnumDqmMobAI.HYADO.getId()){boxData = this.HYADO;}
		else if(ai == EnumDqmMobAI.HOIMI.getId()){boxData = this.HOIMI;}
		else if(ai == EnumDqmMobAI.ZAKI.getId()){boxData = this.ZAKI;}
		else if(ai == EnumDqmMobAI.BAIKIRUTO.getId()){boxData = this.BAIKIRUTO;}
		else if(ai == EnumDqmMobAI.SUKARA.getId()){boxData = this.SUKARA;}
		else if(ai == EnumDqmMobAI.BAHA.getId()){boxData = this.BAHA;}
		else if(ai == EnumDqmMobAI.PIORA.getId()){boxData = this.PIORA;}
		else if(ai == EnumDqmMobAI.MAGICBARIA.getId()){boxData = this.MAGICBARIA;}
		else if(ai == EnumDqmMobAI.MAHOKANTA.getId()){boxData = this.MAHOKANTA;}
		else if(ai == EnumDqmMobAI.BOMIE.getId()){boxData = this.BOMIE;}
		else if(ai == EnumDqmMobAI.RARIHO.getId()){boxData = this.RARIHO;}
		else if(ai == EnumDqmMobAI.MANUSA.getId()){boxData = this.MANUSA;}
		else if(ai == EnumDqmMobAI.MAHOTON.getId()){boxData = this.MAHOTON;}
		else if(ai == EnumDqmMobAI.RUKANI.getId()){boxData = this.RUKANI;}
		else if(ai == EnumDqmMobAI.MEDAPANI.getId()){boxData = this.MEDAPANI;}
		else if(ai == EnumDqmMobAI.HENATOSU.getId()){boxData = this.HENATOSU;}
		else if(ai == EnumDqmMobAI.DIVAINSUPERU.getId()){boxData = this.DIVAINSUPERU;}
		else if(ai == EnumDqmMobAI.RUKANAN.getId()){boxData = this.RUKANAN;}
		else if(ai == EnumDqmMobAI.RARIHOMA.getId()){boxData = this.RARIHOMA;}
		else if(ai == EnumDqmMobAI.BOMIOSU.getId()){boxData = this.BOMIOSU;}
		else if(ai == EnumDqmMobAI.SUKURUTO.getId()){boxData = this.SUKURUTO;}
		else if(ai == EnumDqmMobAI.PIORIMU.getId()){boxData = this.PIORIMU;}
		else if(ai == EnumDqmMobAI.BEHOMARA.getId()){boxData = this.BEHOMARA;}
		else if(ai == EnumDqmMobAI.MAHOIMI.getId()){boxData = this.MAHOIMI;}
		else if(ai == EnumDqmMobAI.POISONX.getId()){boxData = this.POISONX;}
		else if(ai == EnumDqmMobAI.TELEPORT.getId()){boxData = this.TELEPORT;}
		else if(ai == EnumDqmMobAI.MEGANTE.getId()){boxData = this.MEGANTE;}
		else if(ai == EnumDqmMobAI.ARROW.getId()){boxData = this.ARROW;}
		else if(ai == EnumDqmMobAI.HEAVYFIRE.getId()){boxData = this.HEAVYFIRE;}
		else if(ai == EnumDqmMobAI.AVOID.getId()){boxData = this.AVOID;}
		else{return -1;}

		int petLv = pet.getJobLv(pet.getJob());
		int magicSetGrade = pet.getArrayAISets(ai);
		int magicSetMaster = pet.getArrayAIMaster(ai);
        EnumDqmPet petType = pet.type;
        int fixLv = 99 - petType.MaxLv;

        /*
		if(magicSetGrade != 0)
		{
			int[] jobLvA = pet.getJobLvA();
			for(int cnt2 = 0; cnt2 < jobLvA.length; cnt2++)
			{
				DQR.func.debugString("TEST_Q : [" + cnt2 + "]" + jobLvA[cnt2]);
			}
		}
		*/
		//DQR.func.debugString("TEST3 : " + petLv + " / " + magicSetGrade, this.getClass());
		for(int cnt = magicSetGrade - 1; cnt >= 0; cnt--)
		{
			if(boxData.length >= cnt + 1)
			{
				//DQR.func.debugString("TEST5 : [" + cnt + "]" + boxData[cnt] + " : " +  petLv);
				if(boxData[cnt] <= petLv + fixLv || magicSetMaster >= cnt)
				{
					return (cnt + 1);
				}
			}
		}

		return ret;
	}
}


