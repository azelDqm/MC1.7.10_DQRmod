package dqr.dataTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import dqr.DQR;
import dqr.api.enums.EnumDqmJob;
import dqr.api.enums.EnumDqmWeapon;
import dqr.items.base.DqmItemBowBase;
import dqr.items.base.DqmItemWeaponBase;
import dqr.playerData.ExtendedPlayerProperties3;

public class FuncWeaponAptitude {

    public static int[] WAptitudeNull = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeNoHand = {-1, -1, -1, -1, -1, -1, -1, -1,
										-1, -1, -1, -1, -1, -1, -1, -1,
										-1, -1, -1, -1, -1, -1, -1, -1,
										-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeVanilla = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeSword = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeBraveSword = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeFist = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeClaw = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeDqmHammer = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeAxe = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeWhip = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeLance = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeKnife = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeBow = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeThrow = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeRod = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeSoroban = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeOugi = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeMonster = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeGlobe = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};

    public static int[] WAptitudeScythe  = {-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1,
		-1, -1, -1, -1, -1, -1, -1, -1};


    public FuncWeaponAptitude()
    {
    	for(int cnt = 0; cnt < WAptitudeVanilla.length; cnt++)
    	{
    		WAptitudeVanilla[cnt] = 2;
    	}

    	//遊び人
    	this.WAptitudeWhip[EnumDqmJob.Asobinin.getId()] = 2;
    	this.WAptitudeKnife[EnumDqmJob.Asobinin.getId()] = 1;
    	this.WAptitudeThrow[EnumDqmJob.Asobinin.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Asobinin.getId()] = 0;

    	//戦士
    	this.WAptitudeAxe[EnumDqmJob.Senshi.getId()] = 2;
    	this.WAptitudeSword[EnumDqmJob.Senshi.getId()] = 1;
    	this.WAptitudeDqmHammer[EnumDqmJob.Senshi.getId()] = 1;
    	this.WAptitudeLance[EnumDqmJob.Senshi.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Senshi.getId()] = 0;
    	//武道家
    	this.WAptitudeClaw[EnumDqmJob.Budouka.getId()] = 2;
    	this.WAptitudeKnife[EnumDqmJob.Budouka.getId()] = 1;
    	this.WAptitudeFist[EnumDqmJob.Budouka.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Budouka.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Budouka.getId()] = 1;
    	//バトルマスター
    	this.WAptitudeNoHand[EnumDqmJob.BattleMaster.getId()] = 2;
    	this.WAptitudeFist[EnumDqmJob.BattleMaster.getId()] = 2;
    	this.WAptitudeSword[EnumDqmJob.BattleMaster.getId()] = 1;
    	this.WAptitudeRod[EnumDqmJob.BattleMaster.getId()] = 1;
    	this.WAptitudeClaw[EnumDqmJob.BattleMaster.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.BattleMaster.getId()] = 1;
    	//魔法使い
    	this.WAptitudeRod[EnumDqmJob.Mahoutukai.getId()] = 2;
    	this.WAptitudeWhip[EnumDqmJob.Mahoutukai.getId()] = 1;
    	this.WAptitudeKnife[EnumDqmJob.Mahoutukai.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Mahoutukai.getId()] = 0;
    	//僧侶
    	this.WAptitudeLance[EnumDqmJob.Souryo.getId()] = 2;
    	this.WAptitudeRod[EnumDqmJob.Souryo.getId()] = 1;
    	this.WAptitudeKnife[EnumDqmJob.Souryo.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Souryo.getId()] = 0;
    	//this.WAptitudeBow[EnumDqmJob.Souryo.getId()] = 1;
    	//賢者
    	this.WAptitudeRod[EnumDqmJob.Kenja.getId()] = 2;
    	this.WAptitudeKnife[EnumDqmJob.Kenja.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Kenja.getId()] = 0;

    	//勇者
    	this.WAptitudeSword[EnumDqmJob.Yuusha.getId()] = 2;
    	this.WAptitudeBraveSword[EnumDqmJob.Yuusha.getId()] = 2;
    	this.WAptitudeFist[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeClaw[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeDqmHammer[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeAxe[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeWhip[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeLance[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeKnife[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeBow[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeThrow[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeRod[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeSoroban[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeOugi[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeWhip[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeGlobe[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeScythe[EnumDqmJob.Yuusha.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Yuusha.getId()] = 1;

    	//パラディン
    	this.WAptitudeDqmHammer[EnumDqmJob.Paladin.getId()] = 2;
    	this.WAptitudeLance[EnumDqmJob.Paladin.getId()] = 2;
    	this.WAptitudeScythe[EnumDqmJob.Paladin.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Paladin.getId()] = 0;

    	//魔法戦士
    	this.WAptitudeSword[EnumDqmJob.MahouSenshi.getId()] = 2;
    	this.WAptitudeRod[EnumDqmJob.MahouSenshi.getId()] = 1;
    	this.WAptitudeKnife[EnumDqmJob.MahouSenshi.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.MahouSenshi.getId()] = 0;
    	//レンジャー
    	this.WAptitudeBow[EnumDqmJob.Ranger.getId()] = 2;
    	this.WAptitudeClaw[EnumDqmJob.Ranger.getId()] = 1;
    	this.WAptitudeAxe[EnumDqmJob.Ranger.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Ranger.getId()] = 0;
    	//魔物使い
    	this.WAptitudeWhip[EnumDqmJob.Mamonotukai.getId()] = 2;
    	this.WAptitudeRod[EnumDqmJob.Mamonotukai.getId()] = 1;
    	this.WAptitudeClaw[EnumDqmJob.Mamonotukai.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Mamonotukai.getId()] = 0;
    	//スーパースター
    	this.WAptitudeWhip[EnumDqmJob.SuperStar.getId()] = 2;
    	this.WAptitudeOugi[EnumDqmJob.SuperStar.getId()] = 2;
    	this.WAptitudeKnife[EnumDqmJob.SuperStar.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.SuperStar.getId()] = 0;
    	//はぐれメタル
    	this.WAptitudeMonster[EnumDqmJob.Haguremetal.getId()] = 1;
    	this.WAptitudeWhip[EnumDqmJob.Haguremetal.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Haguremetal.getId()] = 0;
    	//商人
    	this.WAptitudeSoroban[EnumDqmJob.Syounin.getId()] = 2;
    	this.WAptitudeClaw[EnumDqmJob.Syounin.getId()] = 1;
    	this.WAptitudeKnife[EnumDqmJob.Syounin.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Syounin.getId()] = 0;
    	//盗賊
    	this.WAptitudeKnife[EnumDqmJob.Touzoku.getId()] = 2;
    	this.WAptitudeWhip[EnumDqmJob.Touzoku.getId()] = 1;
    	this.WAptitudeBow[EnumDqmJob.Touzoku.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Touzoku.getId()] = 0;
    	//ゴッドハンド
    	this.WAptitudeGlobe[EnumDqmJob.GodHand.getId()] = 2;
    	this.WAptitudeSword[EnumDqmJob.Densetsu.getId()] = 0;
    	//this.WAptitudeBraveSword[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeFist[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeClaw[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeDqmHammer[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeAxe[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeWhip[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeLance[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeKnife[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeBow[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeThrow[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeRod[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeSoroban[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeOugi[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeWhip[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeGlobe[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeScythe[EnumDqmJob.GodHand.getId()] = 0;
    	this.WAptitudeNoHand[EnumDqmJob.GodHand.getId()] = 1;

    	//ドラゴン
    	this.WAptitudeMonster[EnumDqmJob.Dragon.getId()] = 1;
    	this.WAptitudeClaw[EnumDqmJob.Dragon.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Dragon.getId()] = 1;
    	//伝説の勇者
    	this.WAptitudeSword[EnumDqmJob.Densetsu.getId()] = 3;
    	this.WAptitudeBraveSword[EnumDqmJob.Densetsu.getId()] = 3;
    	this.WAptitudeFist[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeClaw[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeDqmHammer[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeAxe[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeWhip[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeLance[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeKnife[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeBow[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeThrow[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeRod[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeSoroban[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeOugi[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeWhip[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeGlobe[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeScythe[EnumDqmJob.Densetsu.getId()] = 2;
    	this.WAptitudeNoHand[EnumDqmJob.Densetsu.getId()] = 1;
    	//踊り子
    	this.WAptitudeOugi[EnumDqmJob.Odoriko.getId()] = 2;
    	this.WAptitudeKnife[EnumDqmJob.Odoriko.getId()] = 1;
    	this.WAptitudeWhip[EnumDqmJob.Odoriko.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Odoriko.getId()] = 0;

    	//海賊
    	this.WAptitudeThrow[EnumDqmJob.Kaizoku.getId()] = 2;
    	this.WAptitudeBow[EnumDqmJob.Kaizoku.getId()] = 1;
    	this.WAptitudeAxe[EnumDqmJob.Kaizoku.getId()] = 1;
    	this.WAptitudeDqmHammer[EnumDqmJob.Kaizoku.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Kaizoku.getId()] = 0;
    	//マスタードラゴン
    	this.WAptitudeMonster[EnumDqmJob.MASTERDRAGON.getId()] = 3;
    	this.WAptitudeNoHand[EnumDqmJob.MASTERDRAGON.getId()] = 0;
    	//羊飼い
    	this.WAptitudeWhip[EnumDqmJob.Hituzikai.getId()] = 2;
    	this.WAptitudeKnife[EnumDqmJob.Hituzikai.getId()] = 1;
    	this.WAptitudeAxe[EnumDqmJob.Hituzikai.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Hituzikai.getId()] = 0;
    	//船乗り
    	this.WAptitudeDqmHammer[EnumDqmJob.Funanori.getId()] = 2;
    	this.WAptitudeBow[EnumDqmJob.Funanori.getId()] = 1;
    	this.WAptitudeLance[EnumDqmJob.Funanori.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Funanori.getId()] = 0;
    	//道具使い
    	this.WAptitudeLance[EnumDqmJob.Dougutukai.getId()] = 2;
    	this.WAptitudeBow[EnumDqmJob.Dougutukai.getId()] = 1;
    	this.WAptitudeSoroban[EnumDqmJob.Dougutukai.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Dougutukai.getId()] = 0;
    	//天地雷鳴士
    	this.WAptitudeScythe[EnumDqmJob.Tentiraimeishi.getId()] = 2;
    	this.WAptitudeRod[EnumDqmJob.Tentiraimeishi.getId()] = 1;
    	this.WAptitudeNoHand[EnumDqmJob.Tentiraimeishi.getId()] = 0;
    }

    public int  getWAptitude(int jobId, int weaponType)
    {
    	return this.getWAptitude(jobId, weaponType, null);
    }

    public int getWAptitude(int jobId, int weaponType, EntityPlayer ep)
    {
    	int[] table = WAptitudeNull;
    	if(weaponType == EnumDqmWeapon.DqmNoHand.getId()){
    		table= WAptitudeNoHand;
    	}else if(weaponType == EnumDqmWeapon.DqmVanillaS.getId()){
    		table= WAptitudeVanilla;
    	}else if(weaponType == EnumDqmWeapon.DqmSword.getId()){
    		table= WAptitudeSword;
    	}else if(weaponType == EnumDqmWeapon.DqmBraveSword.getId()){
    		table= WAptitudeBraveSword;
    	}else if(weaponType == EnumDqmWeapon.DqmFist.getId()){
    		table= WAptitudeFist;
    	}else if(weaponType == EnumDqmWeapon.DqmClaw.getId()){
    		table= WAptitudeClaw;
    	}else if(weaponType == EnumDqmWeapon.DqmHammer0.getId()){
    		table= WAptitudeDqmHammer;
    	}else if(weaponType == EnumDqmWeapon.DqmHammer1.getId()){
    		table= WAptitudeDqmHammer;
    	}else if(weaponType == EnumDqmWeapon.DqmHammer2.getId()){
    		table= WAptitudeDqmHammer;
    	}else if(weaponType == EnumDqmWeapon.DqmHammer3.getId()){
    		table= WAptitudeDqmHammer;
    	}else if(weaponType == EnumDqmWeapon.DqmAxe.getId()){
    		table= WAptitudeAxe;
    	}else if(weaponType == EnumDqmWeapon.DqmWhip.getId()){
    		table= WAptitudeWhip;
    	}else if(weaponType == EnumDqmWeapon.DqmLance.getId()){
    		table= WAptitudeLance;
    	}else if(weaponType == EnumDqmWeapon.DqmKnife.getId()){
    		table= WAptitudeKnife;
    	}else if(weaponType == EnumDqmWeapon.DqmBow.getId()){
    		table= WAptitudeBow;
    	}else if(weaponType == EnumDqmWeapon.DqmThrow.getId()){
    		table= WAptitudeThrow;
    	}else if(weaponType == EnumDqmWeapon.DqmRod.getId()){
    		table= WAptitudeRod;
    	}else if(weaponType == EnumDqmWeapon.DqmSoroban.getId()){
    		table= WAptitudeSoroban;
    	}else if(weaponType == EnumDqmWeapon.DqmOugi.getId()){
    		table= WAptitudeOugi;
    	}else if(weaponType == EnumDqmWeapon.DqmMonsterWeapon.getId()){
    		table= WAptitudeMonster;
    	}else if(weaponType == EnumDqmWeapon.DqmGlobe.getId()){
    		table= WAptitudeGlobe;
    	}else if(weaponType == EnumDqmWeapon.DqmScythe.getId()){
    		table= WAptitudeScythe;
    	}

    	//全職使用可能スキルがある場合
    	int allPerm = 0;
    	if(ep != null)
    	{
    		allPerm = ExtendedPlayerProperties3.get(ep).getWeaponSkillPermission(weaponType, 9);
    	}

    	if(allPerm != 0 && allPerm >  table[jobId])
    	{
    		return allPerm;
    	}else
    	{
    		return table[jobId];
    	}
    }

    public int[] getWAptitudeTable(Item item)
    {

    	if(item instanceof DqmItemBowBase)
    	{
    		return WAptitudeBow;
    	}else if(item instanceof DqmItemWeaponBase)
    	{

    		DqmItemWeaponBase weapon = (DqmItemWeaponBase)item;

    		ToolMaterial material = weapon.getMaterial();

    		//System.out.println(material.toString());

    		if(material == DQR.dqmMaterial.DqmVanillaS)
    		{
    			return WAptitudeVanilla;
    		}else if(material == DQR.dqmMaterial.DqmSword)
    		{
    			return WAptitudeSword;
    		}else if(material == DQR.dqmMaterial.DqmBraveSword)
    		{
    			return WAptitudeBraveSword;
    		}else if(material == DQR.dqmMaterial.DqmRod)
    		{
    			return WAptitudeRod;
    		}else if(material == DQR.dqmMaterial.DqmFist)
    		{
    			return WAptitudeFist;
    		}else if(material == DQR.dqmMaterial.DqmClaw)
    		{
    			return WAptitudeClaw;
    		}else if(material == DQR.dqmMaterial.DqmHammer0)
    		{
    			return WAptitudeDqmHammer;
    		}else if(material == DQR.dqmMaterial.DqmHammer1)
    		{
    			return WAptitudeDqmHammer;
    		}else if(material == DQR.dqmMaterial.DqmHammer2)
    		{
    			return WAptitudeDqmHammer;
    		}else if(material == DQR.dqmMaterial.DqmHammer3)
    		{
    			return WAptitudeDqmHammer;
    		}else if(material == DQR.dqmMaterial.DqmAxe)
    		{
    			return WAptitudeAxe;
    		}else if(material == DQR.dqmMaterial.DqmWhip)
    		{
    			return WAptitudeWhip;
    		}else if(material == DQR.dqmMaterial.DqmLance)
    		{
    			return WAptitudeLance;
    		}else if(material == DQR.dqmMaterial.DqmKnife)
    		{
    			return WAptitudeKnife;
    		}else if(material == DQR.dqmMaterial.DqmThrow)
    		{
    			return WAptitudeThrow;
    		}else if(material == DQR.dqmMaterial.DqmSoroban)
    		{
    			return WAptitudeSoroban;
    		}else if(material == DQR.dqmMaterial.DqmOugi)
    		{
    			return WAptitudeOugi;
    		}else if(material == DQR.dqmMaterial.DqmMonster)
    		{
    			return WAptitudeMonster;
    		}else if(material == DQR.dqmMaterial.DqmGlobe)
    		{
    			return WAptitudeGlobe;
    		}else if(material == DQR.dqmMaterial.DqmScythe)
    		{
    			return WAptitudeScythe;
    		}
    	}

    	return null;
    }
}
