package dqr.api.enums;


public enum EnumDqmJob {
	Asobinin(0, "gui.job.0", "main.job.0", 5),
	Senshi(1, "gui.job.1", "main.job.1", 5),
	Budouka(2, "gui.job.2", "main.job.2", 6),
	BattleMaster(3, "gui.job.3", "main.job.3", 0),
	Mahoutukai(4, "gui.job.4", "main.job.4", 5),
	Souryo(5, "gui.job.5", "main.job.5", 5),
	Kenja(6, "gui.job.6", "main.job.6", 0),
	Yuusha(7, "gui.job.7", "main.job.7", 0),
	Paladin(8, "gui.job.8", "main.job.8", 0),
	MahouSenshi(9, "gui.job.9", "main.job.9", 0),
	Ranger(10, "gui.job.10", "main.job.10", 0),
	Mamonotukai(11, "gui.job.11", "main.job.11", 0),
	SuperStar(12, "gui.job.12", "main.job.12", 0),
	Haguremetal(13, "gui.job.13", "main.job.13", 0),
	Syounin(14, "gui.job.14", "main.job.14", 6),
	Touzoku(15, "gui.job.15", "main.job.15", 6),
	GodHand(16, "gui.job.16", "main.job.16", 0),
	Dragon(17, "gui.job.17", "main.job.17", 0),
	Densetsu(18, "gui.job.18", "main.job.18", 0),
	Odoriko(19, "gui.job.19", "main.job.19", 0),
	Kaizoku(20, "gui.job.20", "main.job.20", 0),
	MASTERDRAGON(21, "gui.job.21", "main.job.21", 0);

    private final int id;      //威力(攻撃力・回復量)
    private final String name;   //飛距離tick
    private final String shortName;       //使用アイテム
    private final int infoLine;

    private EnumDqmJob(int id, String name, String shortName, int infoLine) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.infoLine = infoLine;
    }

    public int getId(){return this.id;}
    public String getName(){return this.name();}
    public String getShortName(){return this.shortName;}
    public int getInfoLine(){return this.infoLine;}

}
