package dqr.api.enums;

public enum EnumDqmNpcTalk {
	SYURIYA(0, "Syuriya"),
	KAITORI(1, "Kaitori"),
	BANK(2, "Bank"),
	BUKIYA(3, "Bukiya"),
	FARMBOOK(4, "FarmBook"),
	SINKAN(5, "SINKAN"),
	MEDALKING(6, "MedalKing");

	private int id;
	private String name;
	private EnumDqmNpcTalk(int id, String name)
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
