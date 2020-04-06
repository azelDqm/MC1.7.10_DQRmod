package dqr.api.enums;

public enum EnumDqmBugFix {
	Fix080MP(0, "ver080_MPresetBug"),
	Fix085PET(1, "ver085_PetListBreakBug"),
	Fix087SKILLW(2, "ver087_SkillWPrecalc"),
	Fix09478PetDataCopy(3, "ver09478_PetDataCopy");

	private int id;
	private final String name;

	private EnumDqmBugFix(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public int getId()
	{
		return this.id;
	}
}
