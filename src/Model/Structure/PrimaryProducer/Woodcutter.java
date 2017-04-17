package Model.Structure.PrimaryProducer;

import Model.Map.Tile.Features.Woods;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.Resource;
import Model.Structure.StructureEnum;

import java.util.ArrayList;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Woodcutter extends PrimaryProducer {
    public Woodcutter() {
        super();
        setPrimaryProducer(true);
        setProductionFeature(new Woods());
        setType(StructureEnum.WOODCUTTER);
    }

    public ArrayList<Resource> produce(){
        output.clear();
        output.add(new Trunk());
        return output;
    }
}
