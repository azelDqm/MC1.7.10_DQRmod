package dqr.api.enums;

public enum EnumDqmCasinoSLOdds {


	BIG1(1, 1, "SGeneral", 100.0f, "msg.casino.slot.info.0.txt"),
	BIG2(2, 1, "Metakin", 100.0f, "msg.casino.slot.info.1.txt"),
	REGULAR(3, 2, "Hagumeta", 25.0f, "msg.casino.slot.info.2.txt"),
	CHERRY(4, 0, "SBesu", 2.0f, "msg.casino.slot.info.3.txt"),
	REPLAY(5, 5, "HoimiS", 1.0f, "msg.casino.slot.info.4.txt"),
	BELL(6, 6, "SKnight", 8.0f, "msg.casino.slot.info.5.txt"),
	SUIKA(7, 7, "GoldenS", 15.0f, "msg.casino.slot.info.6.txt"),
	CHERRY2(10, 10, "SBesu2", 2.0f, "msg.casino.slot.info.7.txt"),
	CHERRY4(11, 11, "SBesu4", 4.0f, "msg.casino.slot.info.8.txt");

	private int id;
	private int flgCode;
	private String name;
	private float odds;
	private String langKey;

    private EnumDqmCasinoSLOdds(int id, int flgCode, String name, float odds, String langKey)
    {
    	this.id = id;
    	this.flgCode = flgCode;
    	this.name = name;
    	this.odds = odds;
    	this.langKey = langKey;
    	//this.chatColor = chatColor;
    }

    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public float getOdds(){return this.odds;}
    public String getLangKey(){return this.langKey;}
}
