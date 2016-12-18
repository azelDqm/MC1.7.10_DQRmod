package dqr.api.enums;

public enum EnumDqmMobCateg {

	DUMMY(-1, "DUMMY", "dummy"),
	DAY(0, "DAY", "day"),
	NIGHT(1, "NIGHT", "night"),
	HELL(2, "HELL", "hell"),
	END(3, "END", "end"),
	METARU(4, "METARU", "metaru"),
	SP(5, "SP", "sp"),
	TENSEI(6, "TENSEI", "tensei"),
	BOSS(7, "BOSS", "boss"),
	ETC(99, "ETC", "etc");

	private final int id;
	private final String name;
	private final String key;

	private EnumDqmMobCateg(int id, String name, String key)
	{
		this.id = id;
		this.name = name;
		this.key = key;
	}

	public int getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public String getKey()
	{
		return this.key;
	}

}
