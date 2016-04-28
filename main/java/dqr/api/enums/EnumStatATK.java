package dqr.api.enums;

public enum EnumStatATK {

	job(0),
	seed(1),
	ougon(2),
	armorSet(3);

	private int id;
    private EnumStatATK(int id)
    {
    	this.id = id;
    }

    public int getId()
    {
    	return this.id;
    }
}
