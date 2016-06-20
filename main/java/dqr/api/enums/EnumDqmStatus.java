package dqr.api.enums;

public enum EnumDqmStatus {

	LV(0, "LV"),
	EXP(1, "EXP"),
	SP(2, "SP"),
	JukurenLv(3, "JukurenLv"),
	JukurenExp(4, "JukurenExp"),
	WP(5, "WP"),
	HP(6, "HP"),
	MP(7, "MP"),
	ATK(8, "ATK"),
	DEF(9, "DEF"),
	MAG(10, "MAG"),
	STR(11, "STR"),
	AGI(12, "AGI"),
	INT(13, "INT"),
	CRI(14, "CRI"),
	MISS(15, "MISS"),
	;

	private final int id;
	private final String name;

    private EnumDqmStatus(int id, String name)
    {
    	this.id = id;
    	this.name = name;
    }

    public int getId()
    {
    	return this.id;
    }

    public String getName()
    {
    	return this.name;
    }
}
