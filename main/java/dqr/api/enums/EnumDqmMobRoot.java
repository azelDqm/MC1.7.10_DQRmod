package dqr.api.enums;

public enum EnumDqmMobRoot {

	UNKNOWN(0, "UNKNOWN", "unknown"),
	AKUMA(1, "AKUMA", "akuma"),
	BEAST(2, "BEAST", "beast"),
	BUSSITU(3, "BUSSITU", "bussitu"),
	DRAGON(4, "DRAGON", "dragon"),
	METARU(5, "METARU", "metaru"),
	SIZEN(6, "SIZEN", "sizen"),
	SURAIMU(7, "SURAIMU", "suraimu"),
	TOKUSYU(8, "TOKUSYU", "tokusyu"),
	UNDEAD(9, "UNDEAD", "undead");

	private final int id;
	private final String name;
	private final String key;

	private EnumDqmMobRoot(int id, String name, String key)
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
