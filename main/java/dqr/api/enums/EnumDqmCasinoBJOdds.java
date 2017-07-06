package dqr.api.enums;

public enum EnumDqmCasinoBJOdds {


	OddsAto6(0, "OddsAto6", 60.0f, "msg.casino.blackjack.info.0.txt"),
	Odds7Cards(1, "Odds7Cards", 10.0f, "msg.casino.blackjack.info.1.txt"),
	Odds6Cards(2, "Odds6Cards", 5.0f, "msg.casino.blackjack.info.2.txt"),
	Odds777(3, "Odds777", 10.0f, "msg.casino.blackjack.info.3.txt"),
	OddsPureBJ(4, "OddsPureBJ", 5.0f, "msg.casino.blackjack.info.4.txt"),
	OddsBlackJack(5, "OddsBlackJack", 2.5f, "msg.casino.blackjack.info.5.txt"),
	OddsWin(6, "OddsWin", 2.0f, "msg.casino.blackjack.info.6.txt"),
	OddsLose(-1, "OddsLose", 0.0f, "msg.casino.blackjack.info.-1.txt"),
	OddsDraw(-2, "OddsDraw", 1.0f, "msg.casino.blackjack.info.-2.txt");

	private int id;
	private String name;
	private float odds;
	private String langKey;

    private EnumDqmCasinoBJOdds(int id, String name, float odds, String langKey)
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
