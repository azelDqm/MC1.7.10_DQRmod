package dqr.api.enums;

public enum EnumDqmMagicCateg {

	NONE(0, "none", "dqm.magicinfo.categname.NONE"),
	HPheal(1, "hpheal", "dqm.magicinfo.categname.HPheal"),
	MPheal(2, "mpheal", "dqm.magicinfo.categname.MPheal"),
	PWup(3, "pwup", "dqm.magicinfo.categname.PWup"),
	PWdown(4, "pwdown", "dqm.magicinfo.categname.PWdown"),
	MAGup(5, "magup", "dqm.magicinfo.categname.MAGup"),
	MAGdown(6, "magdown", "dqm.magicinfo.categname.MAGdown"),
	DEFup(7, "defup", "dqm.magicinfo.categname.DEFup"),
	DEFdown(8, "defdown", "dqm.magicinfo.categname.DEFdown"),
	ReStatus(9, "restatus", "dqm.magicinfo.categname.ReStatus"),
	Regene(10, "regene", "dqm.magicinfo.categname.Regene"),
	Rezalect(11, "rezalect", "dqm.magicinfo.categname.Rezalect"),
	Death(12, "death", "dqm.magicinfo.categname.Death"),
	Attack(13, "attack", "dqm.magicinfo.categname.Attack"),
	ETC(14, "etc", "dqm.magicinfo.categname.Etc"),
	Telepo(15, "telepo", "dqm.magicinfo.categname.Telepo"),
	Resist(16, "resist", "dqm.magicinfo.categname.Resist"),
	SPDup(17, "spdup", "dqm.magicinfo.categname.SPDup"),
	SPDdown(18, "spddown", "dqm.magicinfo.categname.SPDdown");

	private final int id;       //攻撃・回復・補助等
	private final String name;     //属性
	private final String lang;     //使用MP

    private EnumDqmMagicCateg(int id, String name, String lang) {
        this.id = id;
        this.name = name;
        this.lang = lang;
    }

    public String getName()
    {
    	return this.name;
    }

    public String getLang()
    {
    	return this.lang;
    }
}
