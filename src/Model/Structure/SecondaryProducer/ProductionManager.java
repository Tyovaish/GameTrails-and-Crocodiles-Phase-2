package Model.Structure.SecondaryProducer;

import Model.Location.Location;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Resource.Resource;
import Model.Resource.ResourceEnum;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class ProductionManager {
    Map gameMap;

    public void load(SecondaryProducer producer, ResourceEnum resource){
        Location location = producer.getLocation();
        Tile tile = gameMap.getTileAt(location.getX(), location.getY());
        Resource resourceToLoad = tile.removeResource(resource);
        if (resourceToLoad != null) producer.addMaterial(resourceToLoad);
        else System.out.printf("Resource not found on tile!\n");
    }
}
