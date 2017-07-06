package dqr.api.enums;

public enum EnumDqmCasinoPKOdds {


	OddsRSF(0, "OddsRSF", 250.0f, "msg.casino.poker.info.0.txt"),
	Odds5Cards(1, "Odds5Cards", 100.0f, "msg.casino.poker.info.1.txt"),
	OddsSFlash(2, "OddsSFlash", 20.0f, "msg.casino.poker.info.2.txt"),
	Odds4Cards(3, "Odds4Cards", 10.0f, "msg.casino.poker.info.3.txt"),
	OddsFullHouse(4, "OddsFullHouse", 8.0f, "msg.casino.poker.info.4.txt"),
	OddsFlush(5, "OddsFlush", 5.0f, "msg.casino.poker.info.5.txt"),
	OddsStraight(6, "OddsStraight", 4.0f, "msg.casino.poker.info.6.txt"),
	Odds3Cards(7, "Odds3Cards", 2.0f, "msg.casino.poker.info.7.txt"),
	OddsTwoPair(8, "OddsTwoPair", 1.0f, "msg.casino.poker.info.8.txt"),
	OddsOnePair(9, "OddsOnePair", 0.5f, "msg.casino.poker.info.9.txt"),
	OddsLose(-1, "OddsLose", 0.0f, "msg.casino.poker.info.-1.txt");

	private int id;
	private String name;
	private float odds;
	private String langKey;

    private EnumDqmCasinoPKOdds(int id, String name, float odds, String langKey)
    {
    	this.id = id;
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
