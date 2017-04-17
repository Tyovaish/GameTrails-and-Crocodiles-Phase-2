package Model.Structure.TransportProducer;

import Model.Structure.StructureEnum;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class WagonFactory extends TransportProducer {
    public WagonFactory() {
        setPrimaryProducer(false);
        setType(StructureEnum.WAGONFACTORY);
    }
}
