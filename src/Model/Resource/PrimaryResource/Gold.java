package Model.Resource.PrimaryResource;

import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceVisitor;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Gold extends PrimaryResource{
    public Gold() {
        setResourceType("Gold");
        setType(ResourceEnum.GOLD);
    }

    @Override
    public void acceptVisitor(ResourceVisitor resourceVisitor) {

    }
}
