package dqr.api.enums;

public enum EnumStat {

	job(0),
	seed(1),
	ougon(2),
	armorSet(3),
	buffPiora(4),
	debuffBomie(5),
	accessory(6);

	private int id;
    private EnumStat(int id)
    {
    	this.id = id;
    }

    public int getId()
    {
    	return this.id;
    }
}
