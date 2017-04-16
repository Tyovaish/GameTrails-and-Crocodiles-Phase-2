package Model.Structure.PrimaryProducer;

import Model.Resource.PrimaryResource.Clay;
import Model.Resource.PrimaryResource.Trunk;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class ClayPit extends PrimaryProducer {
    public ClayPit() {}

    @Override
    public Clay produce(){
        return new Clay();
    }
}
