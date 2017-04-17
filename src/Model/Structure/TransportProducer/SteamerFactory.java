package Model.Structure.TransportProducer;

import Model.Structure.StructureEnum;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class SteamerFactory extends TransportProducer {
    public SteamerFactory() {
        setPrimaryProducer(false);
        setType(StructureEnum.STEAMERFACTORY);
    }
}
