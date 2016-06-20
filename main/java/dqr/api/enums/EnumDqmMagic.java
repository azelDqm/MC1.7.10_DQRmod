package dqr.api.enums;


public enum EnumDqmMagic {

	Zaoraru(EnumDqmMagicCateg.Rezalect, 0, 20, 500, 0, 0, 50),
	Zaoriku(EnumDqmMagicCateg.Rezalect, 0, 50, 1000, 0, 0, 100),
	Uminarinotue(EnumDqmMagicCateg.ETC, 0, 10, 0, 2100000, 0, 0),
	Hikarinotue(EnumDqmMagicCateg.ETC, 0, 5, 200, 0, 0, 0),
	Remirama(EnumDqmMagicCateg.ETC, 0, 10, 500, 1800, 30, 0),
	Haigou(EnumDqmMagicCateg.ETC, 0, 50, 0, 0, 0, 0),
	Haigou2(EnumDqmMagicCateg.ETC, 0, 100, 0, 0, 0, 0),
	Parupunte(EnumDqmMagicCateg.ETC, 0, 15, 0, 0, 0, 0),
	Gira(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Gira.getId(), 2, 100, 12, 0, 0),
	Begirama(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Gira.getId(), 5, 150, 25, 0, 0),
	Begiragon(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Gira.getId(), 10, 200, 70, 0, 0),
	Giragureido(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Gira.getId(), 18, 300, 100, 0, 0),
	Mera(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Mera.getId(), 2, 100, 10, 0, 0),
	Merami(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Mera.getId(), 5, 150, 55, 0, 0),
	Merazoma(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Mera.getId(), 10, 200, 130, 0, 0),
	Meragaia(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Mera.getId(), 18, 300, 180, 0, 0),
	Io(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Io.getId(), 5, 100, 15, 5, 0),
	Iora(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Io.getId(), 12, 150, 40, 10, 0),
	Ionazun(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Io.getId(), 21, 200, 100, 15, 0),
	Iogurande(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Io.getId(), 38, 300, 120, 30, 0),
	Raidein(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Dein.getId(), 28, 800, 90, 0, 0),
	Gigadein(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Dein.getId(), 56, 1000, 200, 0, 0),
	Minadein(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Dein.getId(), 128, 1200, 500, 0, 0),
	Bagi(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Bagi.getId(), 3, 100, 10, 20, 0),
	Bagima(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Bagi.getId(), 6, 150, 25, 30, 0),
	Bagikurosu(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Bagi.getId(), 12, 200, 65, 30, 0),
	Bagimutyo(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Bagi.getId(), 21, 300, 90, 40, 0),
	Doruma(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Doruma.getId(), 4, 100, 70, 0, 0),
	Dorukuma(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Doruma.getId(), 6, 150, 120, 0, 0),
	Dorumoa(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Doruma.getId(), 10, 200, 180, 0, 0),
	Dorumadon(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Doruma.getId(), 30, 300, 300, 0, 0),
	Hyado(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Hyado.getId(), 3, 100, 15, 0, 0),
	Hyadaruko(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Hyado.getId(), 6, 150, 35, 0, 0),
	Mahyado(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Hyado.getId(), 11, 200, 65, 0, 0),
	Mahyadodesu(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Hyado.getId(), 21, 300, 80, 0, 0),
	MagicTool(EnumDqmMagicCateg.Attack.ETC, 0, 0, 0, 0, 0, 0),
	MagicTool2(EnumDqmMagicCateg.Attack.ETC, 0, 0, 0, 0, 0, 0),
	MagicTool3(EnumDqmMagicCateg.Attack.ETC, 0, 0, 0, 0, 0, 0),
	MagicTool4(EnumDqmMagicCateg.Attack.ETC, 0, 0, 0, 0, 0, 0),
	MagicTool5(EnumDqmMagicCateg.Attack.ETC, 0, 0, 0, 0, 0, 0),
	Rurasin(EnumDqmMagicCateg.Telepo, 0, 8, 0, 0, 0, 0),
	Rurasin2(EnumDqmMagicCateg.Telepo, 0, 8, 0, 0, 0, 0),
	Basirura(EnumDqmMagicCateg.Telepo, 0, 16, 0, 0, 0, 0),
	BasiruraC(EnumDqmMagicCateg.Telepo, 0, 16, 0, 0, 0, 0),
	BasiruraC2(EnumDqmMagicCateg.Telepo, 0, 16, 0, 0, 0, 0),
	Hoimi(EnumDqmMagicCateg.HPheal, EnumDqmMagicType.Hoimi.getId(), 3, 100, 25, 0, 0),
	Behoimi(EnumDqmMagicCateg.HPheal, EnumDqmMagicType.Hoimi.getId(), 5, 200, 65, 0, 0),
	Behoma(EnumDqmMagicCateg.HPheal, EnumDqmMagicType.Hoimi.getId(), 8, 400, 99999, 0, 0),
	Bigban(EnumDqmMagicCateg.Attack, 0, 0, 0, 0, 0, 0),
	Madante(EnumDqmMagicCateg.Attack, 0, 0, 0, 0, 0, 0),
	Zaki(EnumDqmMagicCateg.Death, EnumDqmMagicType.Zaki.getId(), 6, 0, 0, 0, 15),
	Zaraki(EnumDqmMagicCateg.Death, EnumDqmMagicType.Zaki.getId(), 10, 0, 0, 0, 10),
	Zarakima(EnumDqmMagicCateg.Death, EnumDqmMagicType.Zaki.getId(), 20, 0, 0, 0, 5),
	Baikiruto(EnumDqmMagicCateg.PWup, 0, 10, 1200, 300, 30, 0),
	Sukara(EnumDqmMagicCateg.DEFup, 0, 5, 1200, 300, 30, 0),
	Baha(EnumDqmMagicCateg.Resist, 0, 5, 1200, 300, 30, 0),
	Piora(EnumDqmMagicCateg.SPDup, 0, 5, 1200, 300, 30, 0),
	Magicbaria(EnumDqmMagicCateg.ETC, 0, 10, 1200, 300, 30, 0),
	Mahokanta(EnumDqmMagicCateg.ETC, 0, 15, 1200, 300, 30, 0),
	Sukuruto(EnumDqmMagicCateg.DEFup, 0, 5, 1800, 300, 30, 0),
	Fubaha(EnumDqmMagicCateg.Resist, 0, 5, 1800, 300, 30, 0),
	Piorimu(EnumDqmMagicCateg.SPDup, 0, 5, 1800, 300, 30, 0),
	Bomie(EnumDqmMagicCateg.SPDdown, 0, 3, 1200, 300, 30, 90),
	Rariho(EnumDqmMagicCateg.ETC, 0, 5, 1600, 300, 30, 25),
	Manusa(EnumDqmMagicCateg.ETC, 0, 4, 1600, 300, 30, 30),
	Kiari(EnumDqmMagicCateg.ReStatus, 0, 4, 500, 0, 0, 0),
	Mahoton(EnumDqmMagicCateg.ETC, 0, 8, 1800, 300, 30, 30),
	Rukani(EnumDqmMagicCateg.DEFdown, 0, 9, 1200, 300, 30, 50),
	Medapani(EnumDqmMagicCateg.ETC, 0, 8, 1600, 300, 30, 30),
	Henatosu(EnumDqmMagicCateg.PWdown, 0, 15, 1800, 300, 30, 80),
	Divainsuperu(EnumDqmMagicCateg.ETC, 0, 12, 1800, 300, 30, 80),
	Rukanan(EnumDqmMagicCateg.DEFdown, 0, 14, 1800, 300, 30, 50),
	Rarihoma(EnumDqmMagicCateg.ETC, 0, 20, 1800, 300, 30, 15),
	Bomiosu(EnumDqmMagicCateg.SPDdown, 0, 9, 1800, 300, 30, 80),
	Mahouken1(EnumDqmMagicCateg.ETC, 0, 10, 500, 0, 0, 0),
	Mahouken2(EnumDqmMagicCateg.ETC, 0, 20, 500, 0, 0, 0),
	Mahouken3(EnumDqmMagicCateg.ETC, 0, 30, 500, 0, 0, 0),
	Mahouken4(EnumDqmMagicCateg.ETC, 0, 10, 500, 0, 0, 0),
	Mahouken5(EnumDqmMagicCateg.ETC, 0, 10, 500, 0, 0, 0),
	Mahouken6(EnumDqmMagicCateg.ETC, 0, 10, 500, 0, 0, 0),
	Mahouken7(EnumDqmMagicCateg.ETC, 0, 10, 500, 0, 0, 0),
	CallCloud(EnumDqmMagicCateg.ETC, 0, 10, 100, 0, 0, 0),
	CallMagma(EnumDqmMagicCateg.ETC, 0, 10, 0, 2100000, 0, 0),
	Rura2(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.Rura.getId(), 8, 500, 0, 0, 0),
	RuraR2(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraR.getId(), 8, 500, 0, 0, 0),
	RuraG2(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraG.getId(), 8, 500, 0, 0, 0),
	RuraB2(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraB.getId(), 8, 500, 0, 0, 0),
	RuraY2(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraY.getId(), 8, 500, 0, 0, 0),
	Rura(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.Rura.getId(), 8, 500, 0, 0, 0),
	RuraR(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraR.getId(), 8, 500, 0, 0, 0),
	RuraG(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraG.getId(), 8, 500, 0, 0, 0),
	RuraB(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraB.getId(), 8, 500, 0, 0, 0),
	RuraY(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraY.getId(), 8, 500, 0, 0, 0),
	RuraC(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.Rura.getId(), 8, 500, 0, 0, 0),
	RuraRC(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraR.getId(), 8, 500, 0, 0, 0),
	RuraGC(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraG.getId(), 8, 500, 0, 0, 0),
	RuraBC(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraB.getId(), 8, 500, 0, 0, 0),
	RuraYC(EnumDqmMagicCateg.Telepo, EnumDqmMagicType.RuraY.getId(), 8, 500, 0, 0, 0),
	Behomara(EnumDqmMagicCateg.HPheal, EnumDqmMagicType.Hoimi.getId(), 16, 1000, 100, 0, 0),
	Behomazun(EnumDqmMagicCateg.HPheal, EnumDqmMagicType.Hoimi.getId(), 128, 1900, 99999, 0, 0),
	Mahoimi(EnumDqmMagicCateg.MPheal, EnumDqmMagicType.Mahoimi.getId(), 15, 100, 10, 0, 0),
	Mahoriku(EnumDqmMagicCateg.MPheal, EnumDqmMagicType.Mahoimi.getId(), 40, 500, 30, 0, 0),
	Mahoizun(EnumDqmMagicCateg.MPheal, EnumDqmMagicType.Mahoimi.getId(), 100, 1000, 80, 0, 0),
	Hinoiki(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Honoo.getId(), 0, 1500, 20, 0, 0),
	Kaeniki(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Honoo.getId(), 0, 1500, 50, 0, 0),
	HagesiiHonoo(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Honoo.getId(), 0, 1500, 100, 0, 0),
	Syakunetu(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Honoo.getId(), 0, 1500, 200, 0, 0),
	RengokuHonoo(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Honoo.getId(), 0, 1500, 450, 0, 0),
	Tumetaiiki(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Fubuki.getId(), 0, 1500, 20, 0, 0),
	Koorinoiki(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Fubuki.getId(), 0, 1500, 50, 0, 0),
	Kogoeruhubuki(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Fubuki.getId(), 0, 1500, 100, 0, 0),
	Kagayakuiki(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Fubuki.getId(), 0, 1500, 200, 0, 0),
	Zettaireido(EnumDqmMagicCateg.Attack, EnumDqmMagicType.Fubuki.getId(), 0, 1500, 450, 0, 0)
	;

    private final EnumDqmMagicCateg categ;       //攻撃・回復・補助等
    private final int type;        //属性
    private final int usage;       //使用MP
    private final int durability;  //使用時耐久減少
    private final int damage;      //威力(攻撃力・回復量)
    private final int tickRange;   //飛距離tick
    private final int rate;


    private EnumDqmMagic(EnumDqmMagicCateg categ, int type, int usage, int durability, int damage, int tickRange, int rate) {
        this.categ = categ;
        this.type = type;
        this.usage = usage;
        this.durability = durability;
        this.damage = damage;
        this.tickRange = tickRange;
        this.rate = rate;
    }

    public EnumDqmMagicCateg getCateg(){ return this.categ;}
    public int getType(){ return this.type;}
    public int getMP(){ return this.usage;}
    public int getDamage(){ return this.durability;}
    public int getAttack(){ return this.damage;}
    public int getTickRange(){ return this.tickRange;}
    public int getRate(){ return this.rate;}

}
