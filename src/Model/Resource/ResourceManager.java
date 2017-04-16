package Model.Resource;

import Model.Location.ResourceLocation;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Trevor on 4/15/2017.
 */
public class ResourceManager {
    ArrayList<Resource> resourceList;
    HashMap<Resource,ResourceLocation> resourceLocationList;
    TransportationManager transportationManager;
    public ResourceManager(TransportationManager transportationManager){
        resourceList=new ArrayList<Resource>();
        resourceLocationList=new HashMap<Resource,ResourceLocation>();
        this.transportationManager=transportationManager;
    }
    public void addResource(Resource resource,ResourceLocation resourceLocation){
        resourceList.add(resource);
        resourceLocationList.put(resource,resourceLocation);
    }
    public ResourceLocation getResourceLocation(Resource resource){
        return resourceLocationList.get(resource);
    }


}
