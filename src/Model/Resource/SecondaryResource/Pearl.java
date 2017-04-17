package Model.Resource.SecondaryResource;

import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceVisitor;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Pearl extends SecondaryResource {
    public Pearl() { setType(ResourceEnum.PEARL); }

    @Override
    public void acceptVisitor(ResourceVisitor resourceVisitor) {

    }
}
