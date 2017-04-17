package Model.Structure.PrimaryProducer;

import Model.Map.Tile.Features.Rock;
import Model.Resource.PrimaryResource.Stone;
import Model.Resource.Resource;
import Model.Structure.StructureEnum;

import java.util.ArrayList;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Quarry extends PrimaryProducer {
    public Quarry() {
        super();
        setPrimaryProducer(true);
        setProductionFeature(new Rock());
        setType(StructureEnum.QUARRY);
    }

    public ArrayList<Resource> produce(){
        output.clear();
        output.add(new Stone());
        return output;
    }
}
