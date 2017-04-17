package Model.Structure.SecondaryProducer;

import Model.Resource.Resource;
import Model.Structure.ResourceProducer;
import Model.Structure.Structure;

import java.util.ArrayList;

/**
 * Created by khariollivierre on 4/15/17.
 */
public abstract class SecondaryProducer extends ResourceProducer {
    public SecondaryProducer() { super(); }

    public abstract void addMaterial(Resource resource);

}
