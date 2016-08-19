package dqr.api.enums;

public enum EnumDqmElement {
	KAMINARI(0, "KAMINARI", "kaminari", "Dein", "§e"),
	HONOO(1, "HONOO", "honoo", "Mera", "§c"),
	KOORI(2, "KOORI", "koori", "Hyado", "§b"),
	KAZE(3, "KAZE", "kaze", "Bagi", "§a"),
	DAITI(4, "DAITI", "daiti", "Dibaria", "§4");

	private final int id;
	private final String name;
	private final String key;
	private final String subType;
	private final String color;

	private EnumDqmElement(int id, String name, String key, String subType, String color) {
		this.id = id;
		this.name = name;
		this.key = key;
		this.subType = subType;
		this.color = color;
	}

	public int getId(){return this.id;}
	public String getName(){return this.name;}
	public String getKey(){return this.key;}
	public String getSubType(){return this.subType;}
	public String getColor(){return this.color;}
}
