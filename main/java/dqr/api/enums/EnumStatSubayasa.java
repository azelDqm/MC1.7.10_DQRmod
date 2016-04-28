package dqr.api.enums;

public enum EnumStatSubayasa {

	job(0),
	seed(1),
	ougon(2),
	armorSet(3),
	buffPiora(4),
	debuffBomie(5);

	private int id;
    private EnumStatSubayasa(int id)
    {
    	this.id = id;
    }

    public int getId()
    {
    	return this.id;
    }
}
