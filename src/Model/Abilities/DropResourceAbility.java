package Model.Abilities;

import Model.Resource.Resource;
import Model.Resource.ResourceBag;

/**
 * Created by Trevor on 4/15/2017.
 */
public class DropResourceAbility implements Ability {

    ResourceBag resourceBag;
    Resource resourceToDrop;
    public DropResourceAbility(ResourceBag resourceBag, Resource resourceToDrop){
        this.resourceBag=resourceBag;
        this.resourceToDrop=resourceToDrop;
    }
    @Override
    public void execute() {
        resourceBag.removeResource(resourceToDrop);
    }

    @Override
    public String print() {
        resourceToDrop.getType();
        return "";
    }
}
