package Model.Resource;

import Model.Location.Location;
import Model.Location.ResourceLocation;
import Model.Map.Tile.Tile;
import Model.Map.Tile.TileZone;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;
import com.sun.org.apache.regexp.internal.RE;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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

    public ArrayList<Resource> getResourceAtTileZone(TileZone tileZone){
        ArrayList<Resource> resourcesOnTileZone=new ArrayList<>();
        Set<Resource> resourceSet=resourceLocationList.keySet();
        for(Resource resource:resourceSet){
          if(resourceLocationList.get(resource).getTileZone()==tileZone){
              resourcesOnTileZone.add(resource);
          }
        }
        return resourcesOnTileZone;
    }

    public ArrayList<Resource> getResourceAtTile(Location location){
        ArrayList<Resource> resourcesOnTile=new ArrayList<Resource>();
        Set<Resource> resourceSet=resourceLocationList.keySet();
        for(Resource resource:resourceSet){
            if(resourceLocationList.get(resource).equals(location.getX(),location.getY())){
                resourcesOnTile.add(resource);
            }
        }
        return resourcesOnTile;

    }


}
