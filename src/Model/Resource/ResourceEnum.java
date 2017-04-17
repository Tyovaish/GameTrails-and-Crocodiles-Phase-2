package Model.Resource;

/**
 * Created by khariollivierre on 4/15/17.
 */
public enum ResourceEnum {
    CLAY ("clay"),
    FUEL ("fuel"),
    GOLD ("gold"),
    IRON ("iron"),
    STONE ("stone"),
    TRUNK ("trunk"),
    BOARD ("board"),
    COIN ("coin"),
    MARBLE ("marble"),
    PAPER ("paper"),
    PEARL ("pearl"),
    BOND ("stockbond");

    private String name;

    ResourceEnum(String name) { this.name = name; }
    public String getName() { return name; }
}
