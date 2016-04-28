package dqr.api.enums;

public enum EnumStatKasikosa {

	job(0),
	seed(1),
	ougon(2),
	armorSet(3);

	private int id;
    private EnumStatKasikosa(int id)
    {
    	this.id = id;
    }

    public int getId()
    {
    	return this.id;
    }
}
