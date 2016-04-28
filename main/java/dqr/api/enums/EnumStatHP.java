package dqr.api.enums;

public enum EnumStatHP {

	job(0),
	seed(1),
	ougon(2),
	armorSet(3);

	private int id;
    private EnumStatHP(int id)
    {
    	this.id = id;
    }

    public int getId()
    {
    	return this.id;
    }
}
