package dqr.api.enums;

public enum EnumDqmWeaponMode {
	WEAPONMODE_NONE(0, "WeaponMode_None", "NONE"),
	WEAPONMODE_AXE(1, "WeaponMode_Axe", "AXE"),
	WEAPONMODE_HAMMER(2, "WeaponMode_Hammer", "HAMMER"),
	WEAPONMODE_CLAW(3, "WeaponMode_Claw", "CLAW"),
	WEAPONMODE_RURA(4, "WeaponMode_Rura", "RURA"),
	WEAPONMODE_KIMERA(5, "WeaponMode_Kimera", "KIMERA"),
	WEAPONMODE_BASIRURA(6, "WeaponMode_BasiRura", "BASIRURA"),
	WEAPONMODE_ITEMUSE(7, "WeaponMode_ItemUse", "ItemUse"),
	WEAPONMODE_ITEMUSEBOW(8, "WeaponMode_ItemUseBow", "ItemUseBow"),
	WEAPONMODE_SHINZIRU(9, "WeaponMode_Shinziru", "Shinziru"),
	WEAPONMODE_RURASINMODE(10, "WeaponMode_RuraSinMode", "RURASINMODE"),
	WEAPONMODE_ACCCanceler(11, "WeaponMode_AccCanceler", "ACCCANCELER"),
	WEAPONMODE_PetSuisyou(11, "WeaponMode_PetSuisyou", "PETSUISYOU");;

	private int id;
	private String name;
	private String type;

	private EnumDqmWeaponMode(int id, String name, String type)
	{
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId(){return this.id;}
	public String getName(){return this.name;}
	public String getType(){return this.type;}
}

