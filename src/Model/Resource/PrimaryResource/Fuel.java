package Model.Resource.PrimaryResource;

import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceVisitor;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Fuel extends PrimaryResource{
    public Fuel() {
        setResourceType("Fuel");
        setType(ResourceEnum.FUEL);
    }

    @Override
    public void acceptVisitor(ResourceVisitor resourceVisitor) {

    }
}
