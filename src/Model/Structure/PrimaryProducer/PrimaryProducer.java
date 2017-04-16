package Model.Structure.PrimaryProducer;

import Model.Resource.Resource;
import Model.Structure.Structure;

/**
 * Created by khariollivierre on 4/15/17.
 */
public abstract class PrimaryProducer<T> extends Structure {
    public abstract T produce();
}
