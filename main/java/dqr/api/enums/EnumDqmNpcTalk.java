package dqr.api.enums;

public enum EnumDqmNpcTalk {
	SYURIYA(0, "Syuriya"),
	KAITORI(1, "Kaitori"),
	BANK(2, "Bank"),
	BUKIYA(3, "Bukiya"),
	FARMBOOK(4, "FarmBook"),
	SINKAN(5, "SINKAN"),
	MEDALKING(6, "MedalKing"),
	SINKAN3(7, "SINKAN3"),
	BANKMP(8, "BankMP"),
	CASINOBJ(9, "CasinoBJ"),
	CASINOCOIN(10, "CasinoCoin"),
	CASINOPK(11, "CasinoPK"),
	CASINOEXC(12, "CasinoEXC"),
	CASINOCCR(13, "CasinoCCR");

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
