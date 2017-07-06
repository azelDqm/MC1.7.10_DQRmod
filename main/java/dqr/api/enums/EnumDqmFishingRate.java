package dqr.api.enums;

public enum EnumDqmFishingRate {

	/*
	VANILLA_ROD("VANILLA_ROD", 0, 1, 3, 13, 33, 0, 0, 9, 107, 297, 377, 0, 0, 0, 0, 9, 1, 0, 0, 0, 0, 1, 3, 0, 0, 0, 0, 6, 5, 0, 0, 0, 0, 0, 6),
	DIAMOND_ROD("DIAMOND_ROD", 0, 0, 1, 3, 13, 0, 0, 110, 108, 300, 390, 0, 0, 0, 0, 101, 4, 0, 0, 0, 0, 5, 3, 0, 0, 0, 0, 6, 15, 0, 0, 0, 0, 0, 22),
	ORIHARUKON_ROD("ORIHARUKON_ROD", 0, 0, 0, 1, 2, 0, 0, 133, 0, 193, 284, 0, 0, 0, 0, 79, 10, 0, 0, 0, 0, 16, 3, 0, 0, 0, 0, 8, 90, 0, 0, 0, 0, 0, 108),
	ROTO_ROD("ROTO_ROD", 6, 28, 136, 329, 420, 0, 6, 88, 108, 301, 392, 0, 0, 0, 0, 66, 90, 0, 0, 0, 0, 124, 20, 0, 0, 0, 0, 56, 100, 0, 0, 0, 0, 0, 193),
	DENSETU_ROD("DENSETU_ROD", 0, 0, 0, 0, 0, 0, 0, 99, 0, 0, 0, 0, 0, 0, 0, 98, 5, 0, 0, 0, 0, 62, 5, 0, 0, 0, 0, 21, 10, 0, 0, 0, 0, 0, 91);
	*/
	VANILLA_ROD("VANILLA_ROD", 8, 9, 0, 0, 0, 0, 0, 9, 8, 9, 0, 0, 0, 0, 0, 9, 1, 0, 0, 0, 1, 3, 5, 6, 0, 0, 6, 5, 6, 0, 0, 0, 0, 6),
	DIAMOND_ROD("DIAMOND_ROD", 80, 100, 110, 0, 0, 0, 0, 110, 80, 95, 100, 101, 0, 0, 0, 101, 4, 5, 0, 0, 5, 3, 4, 5, 6, 0, 6, 15, 19, 21, 22, 0, 0, 22),
	ORIHARUKON_ROD("ORIHARUKON_ROD", 80, 110, 125, 130, 132, 133, 0, 133, 60, 70, 75, 77, 78, 79, 0, 79, 10, 13, 14, 0, 14, 3, 5, 7, 8, 0, 8, 90, 100, 105, 107, 108, 0, 108),
	ROTO_ROD("ROTO_ROD", 50, 70, 80, 85, 87, 88, 0, 88, 35, 50, 60, 62, 64, 65, 66, 66, 90, 120, 123, 0, 123, 20, 35, 45, 55, 56, 56, 100, 150, 180, 190, 192, 193, 193),
	DENSETU_ROD("DENSETU_ROD", 10, 25, 45, 70, 95, 98, 99, 99, 10, 25, 55, 75, 85, 95, 98, 98, 5, 20, 40, 41, 41, 5, 10, 15, 20, 21, 21, 10, 30, 60, 80, 90, 91, 91);


	private final String RodName;
	private final int Weapon1;
	private final int Weapon2;
	private final int Weapon3;
	private final int Weapon4;
	private final int Weapon5;
	private final int Weapon6;
	private final int Weapon7;
	private final int WeaponTotal;
	private final int Magic1;
	private final int Magic2;
	private final int Magic3;
	private final int Magic4;
	private final int Magic5;
	private final int Magic6;
	private final int Magic7;
	private final int MagicTotal;
	private final int Emb1;
	private final int Emb2;
	private final int Emb3;
	private final int Emb4;
	//private final int EmbX;
	private final int EmbTotal;
	private final int Ore1;
	private final int Ore2;
	private final int Ore3;
	private final int Ore4;
	private final int Ore5;
	private final int OreTotal;
	private final int Misc1;
	private final int Misc2;
	private final int Misc3;
	private final int Misc4;
	private final int Misc5;
	private final int Misc6;
	private final int MiscTotal;

    private EnumDqmFishingRate(String rodName,
    						   int Weapon1, int Weapon2, int Weapon3, int Weapon4, int Weapon5, int Weapon6, int Weapon7, int WeaponTotal,
    						   int Magic1, int Magic2, int Magic3, int Magic4, int Magic5, int Magic6, int Magic7, int MagicTotal,
    						   int Emb1, int Emb2, int Emb3, int Emb4, int EmbTotal,
    						   int Ore1, int Ore2, int Ore3, int Ore4, int Ore5, int OreTotal,
    						   int Misc1, int Misc2, int Misc3, int Misc4, int Misc5, int Misc6, int MiscTotal)
    {
    	this.RodName = rodName;
    	this.Weapon1 = Weapon1;
    	this.Weapon2 = Weapon2;
    	this.Weapon3 = Weapon3;
    	this.Weapon4 = Weapon4;
    	this.Weapon5 = Weapon5;
    	this.Weapon6 = Weapon6;
    	this.Weapon7 = Weapon7;
    	this.WeaponTotal = WeaponTotal;
    	this.Magic1 = Magic1;
    	this.Magic2 = Magic2;
    	this.Magic3 = Magic3;
    	this.Magic4 = Magic4;
    	this.Magic5 = Magic5;
    	this.Magic6 = Magic6;
    	this.Magic7 = Magic7;
    	this.MagicTotal = MagicTotal;
    	this.Emb1 = Emb1;
    	this.Emb2 = Emb2;
    	this.Emb3 = Emb3;
    	this.Emb4 = Emb4;
    	//this.EmbX = EmbX;
    	this.EmbTotal = EmbTotal;
    	this.Ore1 = Ore1;
    	this.Ore2 = Ore2;
    	this.Ore3 = Ore3;
    	this.Ore4 = Ore4;
    	this.Ore5 = Ore5;
    	this.OreTotal = OreTotal;
    	this.Misc1 = Misc1;
    	this.Misc2 = Misc2;
    	this.Misc3 = Misc3;
    	this.Misc4 = Misc4;
    	this.Misc5 = Misc5;
    	this.Misc6 = Misc6;
    	this.MiscTotal = MiscTotal;
    }

    public int getWeapon1(){return this.Weapon1;}
    public int getWeapon2(){return this.Weapon2;}
    public int getWeapon3(){return this.Weapon3;}
    public int getWeapon4(){return this.Weapon4;}
    public int getWeapon5(){return this.Weapon5;}
    public int getWeapon6(){return this.Weapon6;}
    public int getWeapon7(){return this.Weapon7;}
    public int getWeaponTotal(){return this.WeaponTotal;}
    public int getMagic1(){return this.Magic1;}
    public int getMagic2(){return this.Magic2;}
    public int getMagic3(){return this.Magic3;}
    public int getMagic4(){return this.Magic4;}
    public int getMagic5(){return this.Magic5;}
    public int getMagic6(){return this.Magic6;}
    public int getMagic7(){return this.Magic7;}
    public int getMagicTotal(){return this.MagicTotal;}
    public int getEmb1(){return this.Emb1;}
    public int getEmb2(){return this.Emb2;}
    public int getEmb3(){return this.Emb3;}
    public int getEmb4(){return this.Emb4;}
    //public int getEmbX(){return this.EmbX;}
    public int getEmbTotal(){return this.EmbTotal;}
    public int getOre1(){return this.Ore1;}
    public int getOre2(){return this.Ore2;}
    public int getOre3(){return this.Ore3;}
    public int getOre4(){return this.Ore4;}
    public int getOre5(){return this.Ore5;}
    public int getOreTotal(){return this.OreTotal;}
    public int getMisc1(){return this.Misc1;}
    public int getMisc2(){return this.Misc2;}
    public int getMisc3(){return this.Misc3;}
    public int getMisc4(){return this.Misc4;}
    public int getMisc5(){return this.Misc5;}
    public int getMisc6(){return this.Misc6;}
    public int getMiscTotal(){return this.MiscTotal;}

}
