package Model.Structure;

/**
 * Created by khariollivierre on 4/15/17.
 */
public enum StructureEnum {
    CLAYPIT ("claypit"),
    MINE ("mine"),
    OILRIG ("oilrig"),
    QUARRY ("quarry"),
    WOODCUTTER ("woodcutter"),
    COALBURNER ("coalburner"),
    MINT ("mint"),
    PAPERMILL ("papermill"),
    SAWMILL ("sawmill"),
    EXCHANGE ("stockexchange"),
    STONEFACTORY ("stonefactory"),
    RAFTFACTORY ("raftfactory"),
    ROWBOATFACTORY ("rowboatfactory"),
    STEAMERFACTORY ("steamerfactory"),
    TRUCKFACTORY ("truckfactory"),
    WAGONFACTORY ("wagonfactory");

    private String structName;

    StructureEnum(String structName) { this.structName = structName; }
    public String getStructName() { return structName; }
}
