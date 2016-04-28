package dqr.api.enums;

public enum EnumDqmMGToolMode {
	MGFARM1_HOE(0, "ModeHoe"),
	MGFARM1_PLANT(1, "ModePlant"),
	MGFARM1_HARVEST(2, "ModeHarvest"),
	MGFARM1_STORE(3, "ModeStore"),

	MGFARM2_HOE(0, "ModeHoe"),
	MGFARM2_PLANT1(11, "ModePlant1"),
	MGFARM2_PLANT2(12, "ModePlant2"),
	MGFARM2_PLANT3(13, "ModePlant3"),
	MGFARM2_PLANT4(14, "ModePlantETC"),
	MGFARM2_HARVEST(2, "ModeHarvest"),
	MGFARM2_STORE(3, "ModeStore"),

	MGBREAK_BREAK(0, "ModeBreak"),
	MGBREAK_DELETE(1, "ModeDelete");



	private int id;
	private String name;

	private EnumDqmMGToolMode(int id, String name)
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
