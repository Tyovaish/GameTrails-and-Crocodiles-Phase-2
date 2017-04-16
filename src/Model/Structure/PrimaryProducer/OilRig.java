package Model.Structure.PrimaryProducer;

import Model.Resource.PrimaryResource.Fuel;
import Model.Resource.PrimaryResource.Trunk;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class OilRig extends PrimaryProducer {
    public OilRig() {}

    @Override
    public Fuel produce(){
        return new Fuel();
    }
}
