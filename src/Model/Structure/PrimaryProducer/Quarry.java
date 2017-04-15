package Model.Structure.PrimaryProducer;

import Model.Resource.PrimaryResource.Stone;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Quarry extends PrimaryProducer {

    @Override
    public Stone produce(){
        return new Stone();
    }
}
