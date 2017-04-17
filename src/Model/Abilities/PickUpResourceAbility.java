package Model.Abilities;

import Model.Map.Tile.Tile;
import Model.Resource.Resource;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;

/**
 * Created by Trevor on 4/15/2017.
 */
public class PickUpResourceAbility implements Ability {
    ResourceBag resourceBag;
    Tile tile;
    Resource resourceToPickUp;
    public PickUpResourceAbility(ResourceBag resourceBag, Tile tile, Resource resourceToPickUp){
        this.resourceBag=resourceBag;
        this.tile = tile;
        this.resourceToPickUp=resourceToPickUp;
    }
    @Override
    public void execute() {
        ResourceEnum rEnum = resourceToPickUp.getType();
        tile.removeResource(rEnum);
        resourceBag.addResource(resourceToPickUp);
    }

    @Override
    public String print() {
        System.out.println("Pick Up Resource: "+resourceToPickUp.getType());
        return resourceToPickUp.getResourceType();
    }
}
