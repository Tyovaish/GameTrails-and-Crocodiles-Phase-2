package Model.Abilities;

import Model.Resource.Resource;
import Model.Resource.ResourceBag;

/**
 * Created by Trevor on 4/15/2017.
 */
public class PickUpResourceAbility implements Ability {
    ResourceBag resourceBag;
    Resource resourceToPickUp;
    public PickUpResourceAbility(ResourceBag resourceBag, Resource resourceToPickUp){
        this.resourceBag=resourceBag;
        this.resourceToPickUp=resourceToPickUp;
    }
    @Override
    public void execute() {
        resourceBag.addResource(resourceToPickUp);
    }
    @Override
    public String print() {
        System.out.println("Pick Up Resource: "+resourceToPickUp.getType());
        return resourceToPickUp.getResourceType();
    }
}
