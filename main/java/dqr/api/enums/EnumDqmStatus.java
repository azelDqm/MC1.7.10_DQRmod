package dqr.api.enums;

import net.minecraft.item.Item;
import dqr.api.Items.DQSkills;

public enum EnumDqmStatus {

	LV(0, "LV", null),
	EXP(1, "EXP", null),
	SP(2, "SP", null),
	JukurenLv(3, "JukurenLv", null),
	JukurenExp(4, "JukurenExp", null),
	WP(5, "WP", null),
	HP(6, "HP", DQSkills.itemSkillJ_HP),
	MP(7, "MP", DQSkills.itemSkillJ_MP),
	ATK(8, "ATK", DQSkills.itemSkillJ_ATK),
	DEF(9, "DEF", DQSkills.itemSkillJ_DEF),
	MAG(10, "MAG", DQSkills.itemSkillJ_MAG),
	STR(11, "STR", DQSkills.itemSkillJ_STR),
	AGI(12, "AGI", DQSkills.itemSkillJ_AGI),
	INT(13, "INT", DQSkills.itemSkillJ_INT),
	CRI(14, "CRI", DQSkills.itemSkillJ_CRI),
	MISS(15, "MISS", DQSkills.itemSkillJ_MISS),
	GOLD(16, "GOLD", null),
	;

	private final int id;
	private final String name;
	private final Item symbolItem;

    private EnumDqmStatus(int id, String name, Item symbolItem)
    {
    	this.id = id;
    	this.name = name;
    	this.symbolItem = symbolItem;
    }

    public int getId()
    {
    	return this.id;
    }

    public String getName()
    {
    	return this.name;
    }

    public Item getSymbolItem()
    {
    	return this.symbolItem;
    }
}
