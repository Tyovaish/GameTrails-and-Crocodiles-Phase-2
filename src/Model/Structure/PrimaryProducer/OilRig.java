package Model.Structure.PrimaryProducer;

import Model.Map.Tile.Features.Sea;
import Model.Resource.PrimaryResource.Fuel;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class OilRig extends PrimaryProducer {
    public OilRig() {
        setPrimaryProducer(true);
        setProductionFeature(new Sea());
    }

    @Override
    public Fuel produce(){
        return new Fuel();
    }
}
