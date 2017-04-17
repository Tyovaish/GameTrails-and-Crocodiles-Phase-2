package Model.Structure.TransportProducer;

import Model.Structure.StructureEnum;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class TruckFactory extends TransportProducer {
    public TruckFactory() {
        setPrimaryProducer(false);
        setType(StructureEnum.TRUCKFACTORY);
    }
}
