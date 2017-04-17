package Model.Abilities;

import Model.Map.Tile.Tile;
import Model.Resource.Resource;
import Model.Resource.ResourceBag;

/**
 * Created by Trevor on 4/15/2017.
 */
public class DropResourceAbility implements Ability {

    ResourceBag resourceBag;
    Tile tile;
    Resource resourceToDrop;
    public DropResourceAbility(ResourceBag resourceBag, Tile tile, Resource resourceToDrop){
        this.resourceBag=resourceBag;
        this.tile = tile;
        this.resourceToDrop=resourceToDrop;
    }
    @Override
    public void execute() {
        resourceBag.removeResource(resourceToDrop);
        tile.addResource(resourceToDrop);
    }

    @Override
    public String print() {
        return resourceToDrop.getResourceType();
    }
}
