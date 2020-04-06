package dqr.api.enums;

public enum EnumDqmFuncPacketCode {
	SyncWKimera(1, "SyncWKimera"),
	SyncWRura(2, "SyncWRura"),
	SyncWBasirura(3, "SyncWBasirura"),
	SyncCKimera(4, "SyncCKimera"),
	SyncCRura(5, "SyncCRura"),
	SyncCBasirura(6, "SyncCBasirura"),
	SyncWRuraSin(7, "SyncWRuraSin"),
	SyncCRuraSin(8, "SyncCRuraSin"),
	CasinoCoinPlus(9, "CasinoCoinPlus"),
	CasinoCoinMinus(10, "CasinoCoinMinus"),
	MPchange(11, "MPchange");

    private final int id;      //威力(攻撃力・回復量)
    private final String name;   //飛距離tick

    private EnumDqmFuncPacketCode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){return this.id;}
    public String getName(){return this.name();}

}
