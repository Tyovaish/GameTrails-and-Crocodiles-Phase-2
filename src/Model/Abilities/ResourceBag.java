package Model.Abilities;

import Model.Location.ResourceLocation;
import Model.Location.TransportationLocation;
import Model.Resource.Resource;
import Model.Resource.ResourceManager;
import Model.Transportation.Transportation;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/15/2017.
 */
public class ResourceBag {
    ResourceManager resourceManager;
    ArrayList<Resource> resourceBag;
    public void addResource(Resource resource){
        resourceBag.add(resource);
    }
    public void removeResource(Resource resource){
        resourceBag.remove(resource);
    }
    public void carry(TransportationLocation transportationLocation){
        for(int i=0;i<resourceBag.size();i++){
            ResourceLocation locationToChange=resourceManager.getResourceLocation(resourceBag.get(i));
            locationToChange.setX(transportationLocation.getX());
            locationToChange.setY(transportationLocation.getY());
            locationToChange.setTileZone(transportationLocation.getTileZone());
        }
    }

}
