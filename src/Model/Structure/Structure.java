package Model.Structure;

import Model.Resource.Resource;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Structure {
    private boolean isPrimaryProducer;

    public boolean isPrimaryProducer() { return isPrimaryProducer; }
    public void setPrimaryProducer(boolean primaryProducer) { isPrimaryProducer = primaryProducer; }

    public Resource produce(){ return null; }
}
