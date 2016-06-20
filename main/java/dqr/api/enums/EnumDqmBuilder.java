package dqr.api.enums;

public enum EnumDqmBuilder {

	DAMA(0, "Dama", 22, 18, -1),
	DAMAS(1, "DamaS", 22, 18, -1),
	DAMAW(2, "DamaW", 22, 18, -1),
	IDOMEDAL(3, "IdoMedal", 6, 2, -36),;

    private final int id;      //威力(攻撃力・回復量)
    private final String name;   //飛距離tick
    private final int mSize;
    private final int mHeight;
    private final int mUnder;

    private EnumDqmBuilder(int id, String name, int mSize, int mHeight,int mUnder) {
        this.id = id;
        this.name = name;
        this.mSize = mSize;
        this.mHeight = mHeight;
        this.mUnder = mUnder;
    }

    public int getId(){return this.id;}
    public String getName(){return this.name();}
    public int getSize(){return this.mSize;}
    public int getHeight(){return this.mHeight;}
    public int getUnder(){return this.mUnder;}

}
