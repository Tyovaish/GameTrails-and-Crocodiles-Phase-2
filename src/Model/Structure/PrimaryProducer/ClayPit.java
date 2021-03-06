package Model.Structure.PrimaryProducer;

import Model.Resource.PrimaryResource.Clay;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.Resource;
import Model.Structure.StructureEnum;

import java.util.ArrayList;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class ClayPit extends PrimaryProducer {
    public ClayPit() {
        super();
        setPrimaryProducer(true);
        setProductionFeature(null);
        setType(StructureEnum.CLAYPIT);
    }

    public ArrayList<Resource> produce(){
        output.clear();
        output.add(new Clay());
        return output;
    }
}
