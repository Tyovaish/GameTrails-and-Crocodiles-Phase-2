package Model.Structure.PrimaryProducer;

import Model.Resource.PrimaryResource.Trunk;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Woodcutter extends PrimaryProducer {

    @Override
    public Trunk produce(){ return new Trunk(); }
}
