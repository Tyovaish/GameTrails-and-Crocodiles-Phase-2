package Model.Structure.PrimaryProducer;

import Model.Map.Tile.Features.Sea;
import Model.Resource.PrimaryResource.Fuel;
import Model.Resource.Resource;
import Model.Structure.StructureEnum;

import java.util.ArrayList;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class OilRig extends PrimaryProducer {
    public OilRig() {
        super();
        setPrimaryProducer(true);
        setProductionFeature(new Sea());
        setType(StructureEnum.OILRIG);
    }

    public ArrayList<Resource> produce(){
        output.clear();
        output.add(new Fuel());
        return output;
    }
}
