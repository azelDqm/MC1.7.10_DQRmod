package dqr.api.enums;


public enum EnumDqmJob {
	Asobinin(0, "gui.job.0", "main.job.0", 5, 25, 2, 25, 2, 2, 3, 1, 3, "Civilian", "CIV", 0),
	Senshi(1, "gui.job.1", "main.job.1", 5, 6, 5, 0, 2, 3, 4, 0, 3, "Warrior", "WAR", 1),
	Budouka(2, "gui.job.2", "main.job.2", 6, 8, 5, 0, 3, 3, 2, 0, 2, "Fighter", "FIG", 2),
	BattleMaster(3, "gui.job.3", "main.job.3", 0, 5, 12, 0, 1, 4, 4, 1, 2, "BattleMaster", "BaM", 9),
	Mahoutukai(4, "gui.job.4", "main.job.4", 5, 0, 2, 6, 5, 2, 2, 3, 3, "Magician", "MAG", 3),
	Souryo(5, "gui.job.5", "main.job.5", 5, 25, 3, 7, 4, 2, 3, 2, 3, "Priest", "PRI", 4),
	Kenja(6, "gui.job.6", "main.job.6", 0, 17, 6, 4, 13, 3, 3, 3, 3, "Sage", "SAG", 10),
	Yuusha(7, "gui.job.7", "main.job.7", 0, 5, 23, 4, 12, 3, 4, 2, 4, "Hero", "HER", 21),
	Paladin(8, "gui.job.8", "main.job.8", 0, 6, 10, 6, 8, 4, 5, 2, 2, "Paladin", "PAR", 11),
	MahouSenshi(9, "gui.job.9", "main.job.9", 0, 5, 9, 5, 9, 3, 4, 2, 3, "MagickKnight", "MaK", 12),
	Ranger(10, "gui.job.10", "main.job.10", 0, 9, 7, 32, 3, 3, 3, 3, 2, "Ranger", "RAN", 13),
	Mamonotukai(11, "gui.job.11", "main.job.11", 0, 17, 8, 8, 6, 2, 3, 0, 2, "MonsterTamer", "TAM", 16),
	SuperStar(12, "gui.job.12", "main.job.12", 0, 15, 8, 9, 5, 3, 4, 2, 3, "SuperStar", "STA", 17),
	Haguremetal(13, "gui.job.13", "main.job.13", 0, 19, 4, 5, 10, 0, 2, 3, 4, "Metal", "MET", 22),
	Syounin(14, "gui.job.14", "main.job.14", 6, 17, 4, 16, 5, 2, 4, 0, 3, "Merchant", "MER", 5),
	Touzoku(15, "gui.job.15", "main.job.15", 6, 18, 3, 48, 2, 2, 3, 0, 3, "Thief", "THI", 6),
	GodHand(16, "gui.job.16", "main.job.16", 0, 6, 16, 33, 3, 5, 4, 1, 2, "GodHnad", "GHN", 18),
	Dragon(17, "gui.job.17", "main.job.17", 0, 7, 10, 6, 5, 0, 5, 3, 3, "Dragon", "DOR", 23),
	Densetsu(18, "gui.job.18", "main.job.18", 0, 2, 21, 3, 12, 9, 2, 4, 2, "Legend", "LEG", 24),
	Odoriko(19, "gui.job.19", "main.job.19", 0, 13, 5, 11, 5, 1, 4, 2, 4, "Dancer", "DAN", 14),
	Kaizoku(20, "gui.job.20", "main.job.20", 0, 8, 7, 14, 4, 3, 3, 2, 3, "Pirate", "PIR", 15),
	MASTERDRAGON(21, "gui.job.21", "main.job.21", 0, 3, 7, 2, 12, 7, 2, 7, 2, "MasterDragon", "MDR", 25),
	Hituzikai(22, "gui.job.22", "main.job.22", 0, 48, 2, 16, 6, 2, 4, 1, 3, "Shepherd", "SHP", 7),
	Funanori(23, "gui.job.23", "main.job.23", 0, 15, 4, 33, 3, 3, 2, 0, 2, "Sailor", "SAI", 8),
	Dougutukai(24, "gui.job.24", "main.job.24", 0, 21, 4, 7, 7, 2, 3, 2, 2, "ItemMaster", "ItM", 20),
	Tentiraimeishi(25, "gui.job.25", "main.job.25", 0, 17, 9, 4, 10, 3, 5, 4, 3, "Summoner", "SUM", 19);


    private final int id;      //威力(攻撃力・回復量)
    private final String name;   //飛距離tick
    private final String shortName;       //使用アイテム
    private final int infoLine;
    private final int tikaraAbs;
    private final int tikaraRan;
    private final int kasikosaAbs;
    private final int kasikosaRan;
    private final int hpAbs;
    private final int hpRan;
    private final int mpAbs;
    private final int mpRan;
    private final String jobName;
    private final String jobNameS;
    private final int jobOrderId;

    private EnumDqmJob(int id, String name, String shortName, int infoLine, int tikaraAbs, int tikaraRan, int kasikosaAbs, int kasikosaRan,
    		int hpAbs, int hpRan, int mpAbs, int mpRan, String jobName, String jobNameS, int jobOrderId) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.infoLine = infoLine;
        this.tikaraAbs = tikaraAbs;
        this.tikaraRan = tikaraRan;
        this.kasikosaAbs = kasikosaAbs;
        this.kasikosaRan = kasikosaRan;
        this.hpAbs = hpAbs;
        this.hpRan = hpRan;
        this.mpAbs = mpAbs;
        this.mpRan = mpRan;
        this.jobName = jobName;
        this.jobNameS = jobNameS;
        this.jobOrderId = jobOrderId;

    }

    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getShortName(){return this.shortName;}
    public int getInfoLine(){return this.infoLine;}

    public int getTikaraAbs(){return this.tikaraAbs;}
    public int getTikaraRan(){return this.tikaraRan;}
    public int getKasikosaAbs(){return this.kasikosaAbs;}
    public int getKasikosaRan(){return this.kasikosaRan;}
    public int getHpAbs(){return this.hpAbs;}
    public int getHpRan(){return this.hpRan;}
    public int getMpAbs(){return this.mpAbs;}
    public int getMpRan(){return this.mpRan;}

    public String getJobNameS(){return this.jobNameS;}
    public String getJobName(){return this.jobName;}
    public int getJobOrderId(){return this.jobOrderId;}

}
