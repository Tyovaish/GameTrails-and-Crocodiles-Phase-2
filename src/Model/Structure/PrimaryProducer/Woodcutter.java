package Model.Structure.PrimaryProducer;

import Model.Map.Tile.Features.Woods;
import Model.Resource.PrimaryResource.Trunk;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Woodcutter extends PrimaryProducer {
    public Woodcutter() {
        setPrimaryProducer(true);
        setProductionFeature(new Woods());
    }

    @Override
    public Trunk produce(){ return new Trunk(); }
}
