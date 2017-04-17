package Model.Resource.SecondaryResource;

import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceVisitor;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Board extends SecondaryResource {
    public Board() {
        setResourceType("Board");
        setType(ResourceEnum.BOARD);
    }

    @Override
    public void acceptVisitor(ResourceVisitor resourceVisitor) {
        resourceVisitor.visit(this);
    }
}
