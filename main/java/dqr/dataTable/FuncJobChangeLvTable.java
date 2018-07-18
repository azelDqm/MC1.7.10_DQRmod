package dqr.dataTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import dqr.DQR;
import dqr.api.Items.DQEmblems;
import dqr.api.enums.EnumDqmJob;
import dqr.playerData.ExtendedPlayerProperties;

public class FuncJobChangeLvTable {


	public static int[] Asobinin = {0, 0, 0, 0, 0, 0, 0, 0,
							        0, 0, 0, 0, 0, 0, 0, 0,
							        0, 0, 0, 0, 0, 0, 0, 0,
							        0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Sensi = {0, 0, 0, 0, 0, 0, 0, 0,
								 0, 0, 0, 0, 0, 0, 0, 0,
								 0, 0, 0, 0, 0, 0, 0, 0,
								 0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Budouka = {0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] BattleMaster = {0, 0, 0, 0, 0, 0, 0, 0,
										0, 0, 0, 0, 0, 0, 0, 0,
										0, 0, 0, 0, 0, 0, 0, 0,
										0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Mahoutukai = {0, 0, 0, 0, 0, 0, 0, 0,
									  0, 0, 0, 0, 0, 0, 0, 0,
									  0, 0, 0, 0, 0, 0, 0, 0,
									  0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Souryo = {0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Kenja = {0, 0, 0, 0, 0, 0, 0, 0,
								 0, 0, 0, 0, 0, 0, 0, 0,
								 0, 0, 0, 0, 0, 0, 0, 0,
								 0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Yusha = {0, 0, 0, 0, 0, 0, 0, 0,
								 0, 0, 0, 0, 0, 0, 0, 0,
								 0, 0, 0, 0, 0, 0, 0, 0,
								 0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Paladin = {0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Mahousensi = {0, 0, 0, 0, 0, 0, 0, 0,
									  0, 0, 0, 0, 0, 0, 0, 0,
									  0, 0, 0, 0, 0, 0, 0, 0,
									  0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Ranger = {0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Mamonotukai = {0, 0, 0, 0, 0, 0, 0, 0,
									   0, 0, 0, 0, 0, 0, 0, 0,
									   0, 0, 0, 0, 0, 0, 0, 0,
									   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] SuperStar = {0, 0, 0, 0, 0, 0, 0, 0,
									 0, 0, 0, 0, 0, 0, 0, 0,
									 0, 0, 0, 0, 0, 0, 0, 0,
									 0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Haguremetal = {0, 0, 0, 0, 0, 0, 0, 0,
									   0, 0, 0, 0, 0, 0, 0, 0,
									   0, 0, 0, 0, 0, 0, 0, 0,
									   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Shounin = {0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Touzoku = {0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Godhand = {0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Dragon = {0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0,
								  0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Densetu = {0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Odoriko = {0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Kaizoku = {0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0,
								   0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] MasterDragon = {0, 0, 0, 0, 0, 0, 0, 0,
										0, 0, 0, 0, 0, 0, 0, 0,
										0, 0, 0, 0, 0, 0, 0, 0,
										0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Hituzikai =
		{0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Funanori =
		{0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Dougutukai =
		{0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0};

	public static int[] Tentiraimeishi =
		{0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0,
		0, 0, 0, 0, 0, 0, 0, 0};

	public FuncJobChangeLvTable()
	{
		if(DQR.conf.bug_jobChangeTableVersion == 1)
		{
			this.BattleMaster[EnumDqmJob.Senshi.getId()] = 30;
			this.BattleMaster[EnumDqmJob.Budouka.getId()] = 30;

			this.Kenja[EnumDqmJob.Mahoutukai.getId()] = 30;
			this.Kenja[EnumDqmJob.Souryo.getId()] = 30;

			this.Yusha[EnumDqmJob.GodHand.getId()] = 50;
			this.Yusha[EnumDqmJob.Kenja.getId()] = 50;
			this.Yusha[EnumDqmJob.Ranger.getId()] = 50;
			this.Yusha[EnumDqmJob.SuperStar.getId()] = 50;

			this.Paladin[EnumDqmJob.Budouka.getId()] = 30;
			this.Paladin[EnumDqmJob.Souryo.getId()] = 30;

			this.Mahousensi[EnumDqmJob.Senshi.getId()] = 30;
			this.Mahousensi[EnumDqmJob.Mahoutukai.getId()] = 30;

			this.Ranger[EnumDqmJob.Touzoku.getId()] = 30;
			this.Ranger[EnumDqmJob.Syounin.getId()] = 30;

			this.Mamonotukai[EnumDqmJob.Asobinin.getId()] = 30;
			this.Mamonotukai[EnumDqmJob.Syounin.getId()] = 30;

			this.SuperStar[EnumDqmJob.Odoriko.getId()] = 50;

			this.Godhand[EnumDqmJob.BattleMaster.getId()] = 50;
			this.Godhand[EnumDqmJob.Paladin.getId()] = 50;
			this.Godhand[EnumDqmJob.MahouSenshi.getId()] = 50;

			this.Odoriko[EnumDqmJob.Asobinin.getId()] = 20;

			this.Kaizoku[EnumDqmJob.Touzoku.getId()] = 30;
			this.Kaizoku[EnumDqmJob.Budouka.getId()] = 30;

			this.Dragon[EnumDqmJob.Mamonotukai.getId()] = 75;
			this.Haguremetal[EnumDqmJob.Mamonotukai.getId()] = 75;

			this.Hituzikai[EnumDqmJob.Yuusha.getId()] = 50;
			this.Funanori[EnumDqmJob.Yuusha.getId()] = 50;
			this.Dougutukai[EnumDqmJob.Yuusha.getId()] = 50;
			this.Tentiraimeishi[EnumDqmJob.Yuusha.getId()] = 50;
		}else
		{
			this.Odoriko[EnumDqmJob.Asobinin.getId()] = 20;

			this.Kaizoku[EnumDqmJob.Touzoku.getId()] = 30;
			this.Kaizoku[EnumDqmJob.Funanori.getId()] = 30;

			this.BattleMaster[EnumDqmJob.Senshi.getId()] = 30;
			this.BattleMaster[EnumDqmJob.Budouka.getId()] = 30;

			this.Kenja[EnumDqmJob.Mahoutukai.getId()] = 30;
			this.Kenja[EnumDqmJob.Souryo.getId()] = 30;

			this.Paladin[EnumDqmJob.Budouka.getId()] = 30;
			this.Paladin[EnumDqmJob.Souryo.getId()] = 30;

			this.Mahousensi[EnumDqmJob.Senshi.getId()] = 30;
			this.Mahousensi[EnumDqmJob.Mahoutukai.getId()] = 30;

			this.Ranger[EnumDqmJob.Touzoku.getId()] = 30;
			this.Ranger[EnumDqmJob.Hituzikai.getId()] = 30;

			this.Mamonotukai[EnumDqmJob.Asobinin.getId()] = 30;
			this.Mamonotukai[EnumDqmJob.Hituzikai.getId()] = 30;

			this.SuperStar[EnumDqmJob.Odoriko.getId()] = 50;
			this.SuperStar[EnumDqmJob.Syounin.getId()] = 50;

			this.Dragon[EnumDqmJob.Mamonotukai.getId()] = 75;
			this.Haguremetal[EnumDqmJob.Mamonotukai.getId()] = 75;

			this.Godhand[EnumDqmJob.BattleMaster.getId()] = 50;
			this.Godhand[EnumDqmJob.Paladin.getId()] = 50;
			//this.Godhand[EnumDqmJob.MahouSenshi.getId()] = 50;

			this.Dougutukai[EnumDqmJob.Ranger.getId()] = 50;
			this.Dougutukai[EnumDqmJob.Kaizoku.getId()] = 50;
			this.Dougutukai[EnumDqmJob.Syounin.getId()] = 50;

			this.Tentiraimeishi[EnumDqmJob.Kenja.getId()] = 50;
			this.Tentiraimeishi[EnumDqmJob.MahouSenshi.getId()] = 50;

			this.Yusha[EnumDqmJob.GodHand.getId()] = 50;
			this.Yusha[EnumDqmJob.Tentiraimeishi.getId()] = 50;
			this.Yusha[EnumDqmJob.Dougutukai.getId()] = 50;
			this.Yusha[EnumDqmJob.SuperStar.getId()] = 50;
		}
	}

    public int[] getJobChangeTable(Item itm)
    {

    	int[] lvTable = null;

	    if(itm == DQEmblems.itemEmbCivilian || itm ==DQEmblems.itemDamaCivilian){
	    	lvTable = this.Asobinin;
	    }else if(itm == DQEmblems.itemEmbWarrior || itm ==DQEmblems.itemDamaWarrior){
	    	lvTable = this.Sensi;
	    }else if(itm == DQEmblems.itemEmbFighter || itm ==DQEmblems.itemDamaFighter){
	    	lvTable = this.Budouka;
	    }else if(itm == DQEmblems.itemEmbBattleMaster || itm ==DQEmblems.itemDamaBattleMaster){
	    	lvTable = this.BattleMaster;
	    }else if(itm == DQEmblems.itemEmbMagician || itm ==DQEmblems.itemDamaMagician){
	    	lvTable = this.Mahoutukai;
	    }else if(itm == DQEmblems.itemEmbPriest || itm ==DQEmblems.itemDamaPriest){
	    	lvTable = this.Souryo;
	    }else if(itm == DQEmblems.itemEmbSage || itm ==DQEmblems.itemDamaSage){
	    	lvTable = this.Kenja;
	    }else if(itm == DQEmblems.itemEmbHero || itm ==DQEmblems.itemDamaHero){
	    	lvTable = this.Yusha;
	    }else if(itm == DQEmblems.itemEmbPaladin || itm ==DQEmblems.itemDamaPaladin){
	    	lvTable = this.Paladin;
	    }else if(itm == DQEmblems.itemEmbMagickKnight || itm ==DQEmblems.itemDamaMagickKnight){
	    	lvTable = this.Mahousensi;
	    }else if(itm == DQEmblems.itemEmbRanger || itm ==DQEmblems.itemDamaRanger){
	    	lvTable = this.Ranger;
	    }else if(itm == DQEmblems.itemEmbMonsterTamer || itm ==DQEmblems.itemDamaMonsterTamer){
	    	lvTable = this.Mamonotukai;
	    }else if(itm == DQEmblems.itemEmbSuperStar || itm ==DQEmblems.itemDamaSuperStar){
	    	lvTable = this.SuperStar;
	    }else if(itm == DQEmblems.itemEmbHaguremetal || itm ==DQEmblems.itemDamaHaguremetal){
	    	lvTable = this.Haguremetal;
	    }else if(itm == DQEmblems.itemEmbMerchant || itm ==DQEmblems.itemDamaMerchant){
	    	lvTable = this.Shounin;
	    }else if(itm == DQEmblems.itemEmbThief || itm ==DQEmblems.itemDamaThief){
	    	lvTable = this.Touzoku;
	    }else if(itm == DQEmblems.itemEmbGodHnad || itm ==DQEmblems.itemDamaGodHnad){
	    	lvTable = this.Godhand;
	    }else if(itm == DQEmblems.itemEmbDragon || itm ==DQEmblems.itemDamaDragon){
	    	lvTable = this.Dragon;
	    }else if(itm == DQEmblems.itemEmbLegend || itm ==DQEmblems.itemDamaLegend){
	    	lvTable = this.Densetu;
	    }else if(itm == DQEmblems.itemEmbDancer || itm ==DQEmblems.itemDamaDancer){
	    	lvTable = this.Odoriko;
	    }else if(itm == DQEmblems.itemEmbPirate || itm ==DQEmblems.itemDamaPirate){
	    	lvTable = this.Kaizoku;
	    }else if(itm == DQEmblems.itemEmbMasterDragon || itm ==DQEmblems.itemDamaMasterDragon){
	    	lvTable = this.MasterDragon;
	    }else if(itm == DQEmblems.itemEmbHituzikai || itm ==DQEmblems.itemDamaHituzikai){
	    	lvTable = this.Hituzikai;
	    }else if(itm == DQEmblems.itemEmbFunanori || itm ==DQEmblems.itemDamaFunanori){
	    	lvTable = this.Funanori;
	    }else if(itm == DQEmblems.itemEmbDougutukai || itm ==DQEmblems.itemDamaDougutukai){
	    	lvTable = this.Dougutukai;
	    }else if(itm == DQEmblems.itemEmbTentiraimeishi || itm ==DQEmblems.itemDamaTentiraimeishi){
	    	lvTable = this.Tentiraimeishi;
	    }

    	return lvTable;
    }

    public boolean getCheckJobChange(EntityPlayer ep, int par1)
    {

    	int[] epJobs = ExtendedPlayerProperties.get(ep).getJobLvA();
    	int[] lvTable = null;

	    if(par1 == EnumDqmJob.Asobinin.getId()){
	    	lvTable = this.Asobinin;
	    }else if(par1 == EnumDqmJob.Senshi.getId()){
	    	lvTable = this.Sensi;
	    }else if(par1 == EnumDqmJob.Budouka.getId()){
	    	lvTable = this.Budouka;
	    }else if(par1 == EnumDqmJob.BattleMaster.getId()){
	    	lvTable = this.BattleMaster;
	    }else if(par1 == EnumDqmJob.Mahoutukai.getId()){
	    	lvTable = this.Mahoutukai;
	    }else if(par1 == EnumDqmJob.Souryo.getId()){
	    	lvTable = this.Souryo;
	    }else if(par1 == EnumDqmJob.Kenja.getId()){
	    	lvTable = this.Kenja;
	    }else if(par1 == EnumDqmJob.Yuusha.getId()){
	    	lvTable = this.Yusha;
	    }else if(par1 == EnumDqmJob.Paladin.getId()){
	    	lvTable = this.Paladin;
	    }else if(par1 == EnumDqmJob.MahouSenshi.getId()){
	    	lvTable = this.Mahousensi;
	    }else if(par1 == EnumDqmJob.Ranger.getId()){
	    	lvTable = this.Ranger;
	    }else if(par1 == EnumDqmJob.Mamonotukai.getId()){
	    	lvTable = this.Mamonotukai;
	    }else if(par1 == EnumDqmJob.SuperStar.getId()){
	    	lvTable = this.SuperStar;
	    }else if(par1 == EnumDqmJob.Haguremetal.getId()){
	    	lvTable = this.Haguremetal;
	    }else if(par1 == EnumDqmJob.Syounin.getId()){
	    	lvTable = this.Shounin;
	    }else if(par1 == EnumDqmJob.Touzoku.getId()){
	    	lvTable = this.Touzoku;
	    }else if(par1 == EnumDqmJob.GodHand.getId()){
	    	lvTable = this.Godhand;
	    }else if(par1 == EnumDqmJob.Dragon.getId()){
	    	lvTable = this.Dragon;
	    }else if(par1 == EnumDqmJob.Densetsu.getId()){
	    	lvTable = this.Densetu;
	    }else if(par1 == EnumDqmJob.Odoriko.getId()){
	    	lvTable = this.Odoriko;
	    }else if(par1 == EnumDqmJob.Kaizoku.getId()){
	    	lvTable = this.Kaizoku;
	    }else if(par1 == EnumDqmJob.MASTERDRAGON.getId())
	    {
	    	lvTable = this.MasterDragon;
	    }else if(par1 == EnumDqmJob.Hituzikai.getId())
	    {
	    	lvTable = this.Hituzikai;
	    }else if(par1 == EnumDqmJob.Funanori.getId())
	    {
	    	lvTable = this.Funanori;
	    }else if(par1 == EnumDqmJob.Dougutukai.getId())
	    {
	    	lvTable = this.Dougutukai;
	    }else if(par1 == EnumDqmJob.Tentiraimeishi.getId())
	    {
	    	lvTable = this.Tentiraimeishi;
	    }

	    for(int cnt = 0; cnt < lvTable.length; cnt++)
	    {
	    	if(epJobs[cnt] < lvTable[cnt])
	    	{
	    		return false;
	    	}
	    }

    	return true;
    }
}
