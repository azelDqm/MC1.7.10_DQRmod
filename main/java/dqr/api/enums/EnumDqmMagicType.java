package dqr.api.enums;

public enum EnumDqmMagicType {
	Rura(0, "Rura"),
	RuraY(1, "RuraY"),
	RuraR(2, "RuraR"),
	RuraG(3, "RuraG"),
	RuraB(4, "RuraB"),
	Zaki(5, "Zaki"),
	Gira(6, "Gira"),
	Bagi(7, "Bagi"),
	Mera(8, "Mera"),
	Dein(9, "Dein"),
	Doruma(10, "Doruma"),
	Io(11, "Io"),
	Hyado(12, "Hyado"),
	Hoimi(13, "Hoimi"),
	Mahoimi(14, "Mahoimi"),
	Honoo(15, "Honoo"),
	Fubuki(16, "Fubuki");


    private final int id;      //威力(攻撃力・回復量)
    private final String name;   //飛距離tick

    private EnumDqmMagicType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){return this.id;}
    public String getName(){return this.name();}

}
