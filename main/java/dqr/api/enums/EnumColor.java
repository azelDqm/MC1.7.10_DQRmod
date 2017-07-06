package dqr.api.enums;

public enum EnumColor {
    Black("§0"),
    DarkBlue("§1"),
    DarkGreen("§2"),
    DarkAqua("§3"),
    DarkRed("§4"),
    Purple("§5"),
    Gold("§6"),
    Gray("§7"),
    DarkGray("§8"),
    Blue("§9"),
    Green("§a"),
    Aqua("§b"),
    Red("§c"),
    LightPurple("§d"),
    Yellow("§e"),
    White("§f"),
    BOLD("§l"),
    ITALIC("§o");

    private String chatColor;

    private EnumColor(String chatColor)
    {
    	this.chatColor = chatColor;
    }

    public String getChatColor(){return this.chatColor;}
}
