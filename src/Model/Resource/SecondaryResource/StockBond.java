package Model.Resource.SecondaryResource;

import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceVisitor;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class StockBond extends SecondaryResource {
    public StockBond() {
        setResourceType("StockBond");
        setType(ResourceEnum.BOND);
    }

    @Override
    public void acceptVisitor(ResourceVisitor resourceVisitor) {

    }
}
