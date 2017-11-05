package dqr.addons.twilightForest;

import twilightforest.entity.EntityTFArmoredGiant;
import twilightforest.entity.EntityTFBlockGoblin;
import twilightforest.entity.EntityTFFireBeetle;
import twilightforest.entity.EntityTFGiantMiner;
import twilightforest.entity.EntityTFGoblinKnightLower;
import twilightforest.entity.EntityTFGoblinKnightUpper;
import twilightforest.entity.EntityTFHelmetCrab;
import twilightforest.entity.EntityTFIceExploder;
import twilightforest.entity.EntityTFIceShooter;
import twilightforest.entity.EntityTFKingSpider;
import twilightforest.entity.EntityTFMazeSlime;
import twilightforest.entity.EntityTFMiniGhast;
import twilightforest.entity.EntityTFMinotaur;
import twilightforest.entity.EntityTFPinchBeetle;
import twilightforest.entity.EntityTFSlimeBeetle;
import twilightforest.entity.EntityTFSnowGuardian;
import twilightforest.entity.EntityTFTowerBroodling;
import twilightforest.entity.EntityTFTowerGhast;
import twilightforest.entity.EntityTFTowerGolem;
import twilightforest.entity.EntityTFTowerTermite;
import twilightforest.entity.EntityTFYeti;
import twilightforest.entity.boss.EntityTFHydra;
import twilightforest.entity.boss.EntityTFIceCrystal;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import twilightforest.entity.boss.EntityTFLich;
import twilightforest.entity.boss.EntityTFLichMinion;
import twilightforest.entity.boss.EntityTFMinoshroom;
import twilightforest.entity.boss.EntityTFNaga;
import twilightforest.entity.boss.EntityTFSnowQueen;
import twilightforest.entity.boss.EntityTFUrGhast;
import twilightforest.entity.boss.EntityTFYetiAlpha;

public enum EnumDqrTFMonster {
	TEST(0, "TEST", 0.0F, 0.0F, 15, 1500, 500, "EntityTFNaga", null, false),
	TFNAGA(1, "EntityTFNaga", 300.0F, 300.0F, 15, 1500, 500, "EntityTFNaga", EntityTFNaga.class, true),
	TFLICH(2, "EntityTFLich", 350.0F, 350.0F, 25, 1700, 750, "EntityTFLich", EntityTFLich.class, false),
	TFLICHMINION(3, "EntityTFLichMinion", 50.0F, 50.0F, 15, 20, 4, "EntityTFLichMinion", EntityTFLichMinion.class, false),
	TFMINOSHROOM(4, "EntityTFMinoshroom", 600.0F, 600.0F, 180, 2300, 1000, "EntityTFMinoshroom", EntityTFMinoshroom.class, true),
	TFMINOTAUR(5, "EntityTFMinotaur", 200.0F, 250.0F, 65, 280, 42, "EntityTFMinotaur", EntityTFMinotaur.class, false),
	TFPINCHBEETLE(6, "EntityTFPinchBeetle", 25.0F, 80.0F, 42, 68, 21, "EntityTFPinchBeetle", EntityTFPinchBeetle.class, false),
	TFFIREBEETLE(7, "EntityTFFireBeetle", 25.0F, 50.0F, 21, 28, 7, "EntityTFFireBeetle", EntityTFFireBeetle.class, false),
	TFSLIMEBEETLE(8, "EntityTFSlimeBeetle", 25.0F, 50.0F, -1, 20, 4, "EntityTFSlimeBeetle", EntityTFSlimeBeetle.class, false),

	TFHYDRA(9, "EntityTFHydra", 400.0F, 1000.0F, -1, 3333, 1356, "EntityTFHydra", EntityTFHydra.class, true),
	TFMAZESLIME(10, "EntityTFMazeSlime", 20.0F, -1.0F, 40, 1, 1, "EntityTFMazeSlime", EntityTFMazeSlime.class, false),
	TFKNIGHTPHANTOM(11, "EntityTFKnightPhantom", 100.0F, 500.0F, 88, 1000, 500, "EntityTFKnightPhantom", EntityTFKnightPhantom.class, true),
	TFBLOCKGOBLIN(12, "EntityTFBlockGoblin", 50.0F, 111.0F, 111, 400, 50, "EntityTFBlockGoblin", EntityTFBlockGoblin.class, false),
	TFGOBLINKNIGHTUPPER(13, "EntityTFGoblinKnightUpper", 50.0F, 210.0F, 60, 300, 25, "EntityTFGoblinKnightUpper", EntityTFGoblinKnightUpper.class, false),
	TFGOBLINKNIGHTLOWER(14, "EntityTFGoblinKnightLower", 50.0F, 200.0F, 55, 280, 30, "EntityTFGoblinKnightLower", EntityTFGoblinKnightLower.class, false),
	TFHELMETCRAB(15, "EntityTFHelmetCrab", 50.0F, 123.0F, 40, 300, 43, "EntityTFHelmetCrab", EntityTFHelmetCrab.class, false),
	TFKINGSPIDER(16, "EntityTFKingSpider", 100.0F, 200.0F, 50, 310, 35, "EntityTFKingSpider", EntityTFKingSpider.class, false),

	TFTOWERGOLEM(17, "EntityTFTowerGolem", 100.0F, 400.0F, 80, 850, 121, "EntityTFTowerGolem", EntityTFTowerGolem.class, false),
	TFTOWERBROODLING(18, "EntityTFTowerBroodling", 60.0F, 190.0F, 50, 280, 40, "EntityTFTowerBroodling", EntityTFTowerBroodling.class, false),
	TFTOWERTERMITE(19, "EntityTFTowerTermite", 100.0F, 380.0F, 72, 800, 80, "EntityTFTowerTermite", EntityTFTowerTermite.class, false),
	TFURGHAST(20, "EntityTFUrGhast", 700.0F, 1200.0F, -1, 5000, 1500, "EntityTFUrGhast", EntityTFUrGhast.class, true),
	TFMINIGHAST(21, "EntityTFMiniGhast", 150.0F, 150.0F, -1, 140, 20, "EntityTFMiniGhast", EntityTFMiniGhast.class, false),
	TFTOWERGHAST(22, "EntityTFTowerGhast", 200.0F, 200.0F, -1, 180, 39, "EntityTFTowerGhast", EntityTFTowerGhast.class, false),

	TFYETIALPHA(23, "EntityTFYetiAlpha", 500.0F, 1999.0F, 158, 5000, 5000, "EntityTFYetiAlpha", EntityTFYetiAlpha.class, true),
	TFYETI(24, "EntityTFYeti", 100.0F, 560.0F, 110, 600, 200, "EntityTFYeti", EntityTFYeti.class, false),
	TFSNOWGUARDIAN(25, "EntityTFSnowGuardian", 100.0F, 680.0F, 120, 1000, 250, "EntityTFSnowGuardian", EntityTFSnowGuardian.class, false),
	TFICESHOOTER(26, "EntityTFIceShooter", 100.0F, 270.0F, 70, 1100, 157, "EntityTFIceShooter", EntityTFIceShooter.class, false),
	TFICEEXPLODER(27, "EntityTFIceExploder", 100.0F, 340.0F, 99, 1200, 186, "EntityTFIceExploder", EntityTFIceExploder.class, false),
	TFSNOWQUEEN(28, "EntityTFSnowQueen", 100.0F, 3000.0F, 200, 10000, 2000, "EntityTFSnowQueen", EntityTFSnowQueen.class, true),
	TFICECRYSTAL(29, "EntityTFIceCrystal", 100.0F, 250.0F, 100, 450, 100, "EntityTFIceCrystal", EntityTFIceCrystal.class, false),
	TFARMOREDGIANT(30, "EntityTFArmoredGiant", 1000.0F, 5000.0F, 500, 15000, 1200, "EntityTFArmoredGiant", EntityTFArmoredGiant.class, true),
	TFGIANTMINER(31, "EntityTFGiantMiner", 1000.0F, 5000.0F, 400, 20000, 100, "EntityTFGiantMiner", EntityTFGiantMiner.class, true);


	private final int id;
	private final String name;
	private final float CheckHP;
	private final float MaxHP;
	private final int Attack;
	private final int Exp;
	private final int Gold;
	private final String clsName;
	private final Class cls;
	private final boolean bossFlg;

	private EnumDqrTFMonster(int id, String name, float CheckHP, float MaxHP, int Attack, int Exp, int Gold, String clsName, Class cls, boolean bossFlg)
	{
		this.id = id;
		this.name = name;
		this.CheckHP = CheckHP;
		this.MaxHP = MaxHP;
		this.Attack = Attack;
		this.Exp = Exp;
		this.Gold = Gold;
		this.clsName = clsName;
		this.cls = cls;
		this.bossFlg = bossFlg;
	}

	public int getId(){return this.id;}
	public String getName(){return this.name;}
	public float getCheckhp(){return this.CheckHP;}
	public float getMaxhp(){return this.MaxHP;}
	public int getAttack(){return this.Attack;}
	public int getExp(){return this.Exp;}
	public int getGold(){return this.Gold;}
	public String getClsname(){return this.clsName;}
	public Class getCls(){return this.cls;}
	public boolean getBossflg(){return this.bossFlg;}

}