package Model.Structure.TransportProducer;

import Model.Structure.StructureEnum;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class RaftFactory extends TransportProducer {
    public RaftFactory() {
        setPrimaryProducer(false);
        setType(StructureEnum.RAFTFACTORY);
    }
}
