package dqr.api.enums;

public enum EnumDqmMobRoot {

	UNKNOWN(0, "UNKNOWN", "unknown", 2, 3),
	AKUMA(1, "AKUMA", "akuma", 4, 2),
	BEAST(2, "BEAST", "beast", 1, 1),
	BUSSITU(3, "BUSSITU", "bussitu", 2, 1),
	DRAGON(4, "DRAGON", "dragon", 1, 2),
	METARU(5, "METARU", "metaru", 1, 3),
	SIZEN(6, "SIZEN", "sizen", 3, 1),
	SURAIMU(7, "SURAIMU", "suraimu", 4, 1),
	TOKUSYU(8, "TOKUSYU", "tokusyu", 3, 2),
	UNDEAD(9, "UNDEAD", "undead", 2, 2);

	private final int id;
	private final String name;
	private final String key;
	private final int haigouId;
	private final int haigouCateg;

	private EnumDqmMobRoot(int id, String name, String key, int haigouId, int haigouCateg)
	{
		this.id = id;
		this.name = name;
		this.key = key;
		this.haigouId = haigouId;
		this.haigouCateg = haigouCateg;
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

	public int getHaigouId()
	{
		return this.haigouId;
	}

	public int getHaigouCateg()
	{
		return this.haigouCateg;
	}
}
