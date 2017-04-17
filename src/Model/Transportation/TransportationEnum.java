package Model.Transportation;

/**
 * Created by khariollivierre on 4/17/17.
 */
public enum TransportationEnum {
    DONKEY ("donkey"),
    TRUCK ("truck"),
    WAGON ("wagon"),
    RAFT ("raft"),
    ROWBOAT ("rowboat"),
    STEAMER ("steamer"),
    PLANE ("plane");

    private String name;

    TransportationEnum(String name) { this.name = name; }
    public String getName() { return name; }
}
