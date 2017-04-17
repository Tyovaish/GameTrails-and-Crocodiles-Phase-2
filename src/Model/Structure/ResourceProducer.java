package Model.Structure;

import Model.Resource.Resource;

import java.util.ArrayList;

/**
 * Created by khariollivierre on 4/17/17.
 */
public abstract class ResourceProducer extends Structure {
    protected ArrayList<Resource> output;

    public ResourceProducer() { output = new ArrayList<>(); }

    public abstract ArrayList<Resource> produce();
}
