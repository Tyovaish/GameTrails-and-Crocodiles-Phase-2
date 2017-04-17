package Model.Resource.SecondaryResource;

import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceVisitor;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Coin extends SecondaryResource {
    public Coin() {
        setResourceType("Coin");
        setType(ResourceEnum.COIN);
    }

    @Override
    public void acceptVisitor(ResourceVisitor resourceVisitor) {

    }
}
