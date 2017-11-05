package dqr.api.enums;

public enum EnumDqmEndoraParam {
	EndoraLv0(0, 200.0F, 1, 0, 0, 1, 1111, 1000, false),
	EndoraLv1(1, 300.0F, 10, 0.05F, 1, 1, 5555, 3333, false),
	EndoraLv2(2, 400.0F, 25, 0.1F, 1, 5, 11111, 11111, true),
	EndoraLv3(3, 500.0F, 50, 0.25F, 1, 10, 55555, 55555,  true),
	EndoraLv4(4, 700.0F, 60, 0.5F, 1, 10, 77777, 77777,  true),
	EndoraLv5(5, 800.0F, 70, 1.0F, 2, 15, 99999, 99999, true),
	EndoraLv6(6, 1000.0F,100, 1.5F, 2, 20, 12121, 12121, true)
	;

	private final int id;
	private final float MaxHP;
	private final int Attack;
	private final float Regene;
	private final int AttackPat;
	private final int Deffence;
	private final int Exp;
	private final int Gold;
	private final boolean UseKiseki;

	private EnumDqmEndoraParam(int id, float MaxHP, int Attack, float Regene, int AttackPat, int Deffence, int Exp, int Gold, boolean UseKiseki)
	{
		this.id = id;
		this.MaxHP = MaxHP;
		this.Attack = Attack;
		this.Regene = Regene;
		this.AttackPat = AttackPat;
		this.Deffence = Deffence;
		this.Exp = Exp;
		this.Gold = Gold;
		this.UseKiseki = UseKiseki;
	}

	public int getId()
	{
		return this.id;
	}

	public float getMaxHP()
	{
		return this.MaxHP;
	}

	public int getAttack()
	{
		return this.Attack;
	}

	public float getRegene()
	{
		return this.Regene;
	}

	public int getAttackPat()
	{
		return this.AttackPat;
	}

	public int getDeffence()
	{
		return this.Deffence;
	}

	public boolean getUseKiseki()
	{
		return this.UseKiseki;
	}

	public int getGold()
	{
		return this.Gold;
	}
	public int getExpi()
	{
		return this.Exp;
	}

}

