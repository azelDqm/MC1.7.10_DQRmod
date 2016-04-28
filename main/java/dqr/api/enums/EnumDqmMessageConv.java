package dqr.api.enums;

public enum EnumDqmMessageConv {
	MonsterName(0, "!revMob.", ".boMver!"),
	JobName(1, "!revJob.", ".boJver!");


	private int id;
	private String startS;
	private String endS;
	private int startLength;
	private int endLength;

	private EnumDqmMessageConv(int id, String startS, String endS)
	{
		this.id = id;
		this.startS = startS;
		this.endS = endS;
		this.startLength = this.startS.length();
		this.endLength = this.endS.length();
	}

	public int getId()
	{
		return this.id;
	}

	public String getStartS()
	{
		return this.startS;
	}

	public String getEndS()
	{
		return this.endS;
	}

	public int getStartLength()
	{
		return this.startLength;
	}

	public int getEndLength()
	{
		return this.endLength;
	}

}
