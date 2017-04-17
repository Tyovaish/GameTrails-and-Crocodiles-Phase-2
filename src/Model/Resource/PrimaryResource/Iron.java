package Model.Resource.PrimaryResource;

import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceVisitor;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Iron extends PrimaryResource{
    public Iron() {
        setResourceType("Iron");
        setType(ResourceEnum.IRON);
    }

    @Override
    public void acceptVisitor(ResourceVisitor resourceVisitor) {

    }
}
