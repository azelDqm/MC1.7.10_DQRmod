package dqr.api.enums;

public enum EnumDqmWeapon {

	DqmNoHand(0, "DqmNoHand"),
	DqmVanillaS(1, "DqmVanillaS"),
	DqmSword(2, "DqmSword"),
	DqmBraveSword(3, "DqmBraveSword"),
	DqmFist(4, "DqmFist"),
	DqmClaw(5, "DqmClaw"),
	DqmHammer0(6, "DqmHammer0"),
	DqmHammer1(6, "DqmHammer1"),
	DqmHammer2(6, "DqmHammer2"),
	DqmHammer3(6, "DqmHammer3"),
	DqmAxe(7, "DqmAxe"),
	DqmWhip(8, "DqmWhip"),
	DqmLance(9, "DqmLance"),
	DqmKnife(10, "DqmKnife"),
	DqmBow(11, "DqmBow"),
	DqmThrow(12, "DqmThrow"),
	DqmRod(13, "DqmRod"),
	DqmMagicMahouTukai(14, "DqmMagicMahouTukai"),
	DqmMagicSouryo(15, "DqmMagicSouryo"),
	DqmMagicMahouSensi(16, "DqmMagicMahouSensi"),
	DqmMagicKenja(17, "DqmMagicKenja"),
	DqmMagicYuusha(18, "DqmMagicYuusha"),
	DqmMagicETC(19, "DqmMagicETC"),
	DqmMagicParadin(20, "DqmMagicParadin"),
	DqmMagicALL(21, "DqmMagicALL"),
	DqmMagicAsobinin(22, "DqmMagicAsobinin"),
	DqmMagicMamonotukai(23, "DqmMagicMamonotukai"),

	DqmSoroban(24, "DqmSoroban"),
	DqmOugi(25, "DqmOugi"),
	DqmMonsterWeapon(26, "DqmMonsterWeapon"),
	DqmGlobe(27, "DqmGlobe"),
	DqmScythe(28, "DqmScythe");

	private int id;
    private String name;

    private EnumDqmWeapon(int id, String name)
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
