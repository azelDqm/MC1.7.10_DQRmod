package dqr.api.enums;

public enum EnumDqmWorldType {
	OVERWORLD(0, "OVERWORLD", 0),
	NETHER(1, "NETHER", -1),
	THEEND(2, "THEEND", 1);

	private int id;
	private String name;
	private int dimID;

	private EnumDqmWorldType(int id, String name, int dimID)
	{
		this.id = id;
		this.name = name;
		this.dimID = dimID;
	}

	public int getId(){return this.id;}
	public String getName(){return this.name;}
}
