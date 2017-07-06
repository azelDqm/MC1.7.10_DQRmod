package dqr.api.enums;


public enum EnumDqmFishingCateg {

	VANILLA_FISH(1, "VANILLA_FISH"),
	DQWEAPON(2, "DQWEAPON"),
	DQMAGIC(3, "DQMAGIC"),
	DQEMB(4, "DQEMB"),
	DQORE(5, "DQORE"),
	DQMISC(6, "DQMISC"),
	DQACC(7, "DQACC");

	private final int categId;
	private final String categName;

	private EnumDqmFishingCateg(int id, String name)
	{
		this.categId = id;
		this.categName = name;
	}

}
