package dqr.api.enums;

public enum EnumDqmCasinoCCROdds {


	R111(0, "R111", 5.0f, 1, 1, 9, 15,  ""),
	R666(1, "R666", 3.0f, 2, 2, 24, 15, ""),
	R555(2, "R555", 3.0f, 2, 3, 38, 15, ""),
	R444(3, "R444", 3.0f, 2, 4, 52, 15, ""),
	R333(4, "R333", 3.0f, 2, 5, 66, 15, ""),
	R222(5, "R222", 3.0f, 2, 6, 80, 15, ""),
	R456(6, "R456", 2.0f, 3, 7, 95, 15, ""),
	RAA6(7, "RAA6", 1.0f, 4, 8, 110, 29, ""),
	RAA5(8, "RAA5", 1.0f, 4, 9, 110, 29, ""),
	RAA4(9, "RAA4", 1.0f, 4, 10, 110, 29, ""),
	RAA3(10, "RAA3", 1.0f, 4, 11, 110, 29, ""),
	RAA2(11, "RAA2", 1.0f, 4, 12, 110, 29, ""),
	RAA1(12, "RAA1", 1.0f, 4, 13, 110, 29, ""),
	RABC(13, "RABC", 0.0f, 6, 14, 0, 0, ""),
	R123(14, "R123", -2.0f, 5, 15, 139, 25, "");
	;

	private int id;
	private String name;
	private float odds;
	private int categ;
	private int val;
	private int rateListY;
	private int rateListHeight;
	private String langKey;

    private EnumDqmCasinoCCROdds(int id, String name, float odds, int categ, int val, int rateListY, int rateListHeight, String langKey)
    {
    	this.id = id;
    	this.name = name;
    	this.odds = odds;
    	this.categ = categ;
    	this.val = val;
    	this.rateListY = rateListY;
    	this.rateListHeight = rateListHeight;
    	this.langKey = langKey;
    	//this.chatColor = chatColor;
    }

    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public float getOdds(){return this.odds;}
    public String getLangKey(){return this.langKey;}
    public int getVal(){return this.val;}
    public int getRateListY(){return this.rateListY;}
    public int getRateListHeight(){return this.rateListHeight;}
    public int getCateg(){return this.categ;}
}
