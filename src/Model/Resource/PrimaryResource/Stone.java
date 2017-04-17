package Model.Resource.PrimaryResource;

import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceVisitor;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Stone extends PrimaryResource{
    public Stone() { setType(ResourceEnum.STONE); }

    @Override
    public void acceptVisitor(ResourceVisitor resourceVisitor) {

    }
}
