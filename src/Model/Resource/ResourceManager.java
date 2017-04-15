package Model.Resource;

import Model.Location.ResourceLocation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Trevor on 4/15/2017.
 */
public class ResourceManager {
    ArrayList<Resource> resourceList;
    HashMap<Resource,ResourceLocation> resourceLocationList;
    ResourceManager(){
        resourceList=new ArrayList<Resource>();

    }
}
