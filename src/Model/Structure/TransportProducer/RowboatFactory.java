package Model.Structure.TransportProducer;

import Model.Structure.StructureEnum;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class RowboatFactory extends TransportProducer {
    public RowboatFactory() {
        setPrimaryProducer(false);
        setType(StructureEnum.ROWBOATFACTORY);
    }
}
