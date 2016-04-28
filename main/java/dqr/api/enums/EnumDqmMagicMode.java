package dqr.api.enums;

public enum EnumDqmMagicMode {
	CallCloud(0, "CallCloud"),
	Hikarinotue(1, "Hikarinotue");

	private int mode;
	private String name;

    private EnumDqmMagicMode(int mode, String name) {
    	this.mode = mode;
    	this.name = name;
    }

    public int getMode()
    {
    	return this.mode;
    }
}
