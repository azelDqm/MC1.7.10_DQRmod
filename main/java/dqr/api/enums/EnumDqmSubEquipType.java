package dqr.api.enums;


public enum EnumDqmSubEquipType {

	Kubikazari(0, "Kubikazari"),
	Piasu(1, "Piasu"),
	Shield(2, "Shield"),
	Sonota(3, "Sonota"),
	Udewa(4, "Udewa"),
	Yubiwa(5, "Yubiwa"),
	Fukuro(6, "Fukuro"),
	PWEAPON(7, "PetWeapon"),
	PARMOR(8, "PetArmor"),
	PSHIELD(9, "PetShield");


	private final int id;
	private final String name;

	private EnumDqmSubEquipType(int id, String name)
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

   public static EnumDqmSubEquipType getEquipmentTypeFromSlot(int slot) {

        switch (slot) {

            case 0:
            case 1:
                return Piasu;
            case 2:
                return Kubikazari;

            case 3:
            case 4:
                return Udewa;
            case 5:
            case 6:
            case 7:
            case 8:
                return Yubiwa;
            case 9:
            case 10:
                return Sonota;
            case 11:
                return Shield;
            case 12:
                return Fukuro;
        }
        return null;
    }
}
