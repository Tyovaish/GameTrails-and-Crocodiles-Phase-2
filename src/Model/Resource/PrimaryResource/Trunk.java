package Model.Resource.PrimaryResource;

import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceVisitor;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Trunk extends PrimaryResource{
    public Trunk(){
       setResourceType("Trunk");
        setType(ResourceEnum.TRUNK);
    }

    @Override
    public void acceptVisitor(ResourceVisitor resourceVisitor) {
        resourceVisitor.visit(this);
    }
}
