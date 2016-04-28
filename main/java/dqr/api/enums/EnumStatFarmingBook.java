package dqr.api.enums;

public enum EnumStatFarmingBook {

	YAKUSOU2(0),
	YAKUSOU3(1),
	DOKUKESHI2(2),
	DOKUKESHI3(3),
	TIKARA2(4),
	TIKARA3(5),
	MAMORI2(6),
	MAMORI3(7),
	SUBAYASA2(8),
	SUBAYASA3(9),
	IYASHI1(10),
	IYASHI2(11),
	IYASHI3(12),
	HONOO1(13),
	HONOO2(14),
	HONOO3(15),
	MAHOUNOMI1(16),
	MAHOUNOMI2(17),
	MAHOUNOMI3(18),
	MARYOKUNOMI1(19),
	MARYOKUNOMI2(20),
	MARYOKUNOMI3(21),
	OUGON1(22),
	OUGON2(23),
	OUGON3(24),
	OUGON4(25)
	;

	private int id;
    private EnumStatFarmingBook(int id)
    {
    	this.id = id;
    }

    public int getId()
    {
    	return this.id;
    }
}
