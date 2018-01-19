package dqr.api.enums;

public enum EnumDqmMobAI {

	NONE(0, "None", 0),
	JUMP(1, "Jump", 0),
	HONOO(2, "Honoo", 1),
	HUBUKI(3, "Hubuki", 1),
	POISON(4, "Poison", 0),
	GIRA(5, "Gira", 1),
	MERA(6, "Mera", 1),
	IO(7, "Io", 1),
	RAIDEIN(8, "Raidein", 1),
	BAGI(9, "Bagi", 1),
	DORUMA(10, "Doruma", 1),
	HYADO(11, "Hyado", 1),
	HOIMI(12, "Hoimi", 1),
	ZAKI(13, "Zaki", 1),
	BAIKIRUTO(14, "Baikiruto", 1),
	SUKARA(15, "Sukara", 0),
	BAHA(16, "Baha", 0),
	PIORA(17, "Piora", 0),
	MAGICBARIA(18, "Magicbaria", 0),
	MAHOKANTA(19, "Mahokanta", 0),
	BOMIE(20, "Bomie", 0),
	RARIHO(21, "Rariho", 0),
	MANUSA(22, "Manusa", 0),
	MAHOTON(23, "Mahoton", 0),
	RUKANI(24, "Rukani", 0),
	MEDAPANI(25, "Medapani", 0),
	HENATOSU(26, "Henatosu", 0),
	DIVAINSUPERU(27, "Divainsuperu", 0),
	RUKANAN(28, "Rukanan", 0),
	RARIHOMA(29, "Rarihoma", 0),
	BOMIOSU(30, "Bomiosu", 0),
	SUKURUTO(31, "Sukuruto", 0),
	PIORIMU(32, "Piorimu", 0),
	BEHOMARA(33, "Behomara", 1),
	MAHOIMI(34, "Mahoimi", 1),
	POISONX(35, "PoisonX", 0),
	TELEPORT(36, "Teleport", 0),
	MEGANTE(37, "Megante", 0),
	ARROW(38, "Arrow", 0),
	HEAVYFIRE(39, "HeavyFire", 0),
	AVOID(40, "Avoid", 0);

	private int id;
	private String name;
	private int gradeFlg;

	private EnumDqmMobAI(int id, String name, int gradeFlg)
	{
		this.id = id;
		this.name = name;
		this.gradeFlg = gradeFlg;
	}

	public int getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public int getGradeFlg()
	{
		return this.gradeFlg;
	}
}
