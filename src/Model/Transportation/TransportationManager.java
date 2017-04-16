package Model.Transportation;

import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.Transportation.Transportation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TransportationManager {
    ArrayList<Transportation> transportationList;
    HashMap<Transportation,TransportationLocation> transportationLocations;
    Map gameMap;

    public TransportationManager(Map gameMap){
        transportationList=new ArrayList<Transportation>();
        transportationLocations=new HashMap<Transportation,TransportationLocation>();
        this.gameMap = gameMap;
    }
    public void addTransportation(Transportation transportation,TransportationLocation transportationLocation){
        transportationList.add(transportation);
        transportationLocations.put(transportation,transportationLocation);
    }
    public ArrayList<Transportation> getTransportationList() {
                return transportationList;
    }

    public TransportationLocation getTransportationLocation(Transportation transportation){
        return transportationLocations.get(transportation);
    }

    public Tile getTileOfTransporter(Transportation transportation){
        TransportationLocation location = getTransportationLocation(transportation);
        return gameMap.getTileAt(location.getX(), location.getY());
    }

    public void load(Transportation transportation, ResourceEnum resource){
        TransportationLocation location = getTransportationLocation(transportation);
        Tile tile = gameMap.getTileAt(location.getX(), location.getY());
        Resource resourceToLoad = tile.removeResource(resource);
        if (resourceToLoad != null) transportation.addResource(resourceToLoad);
        else System.out.printf("Resource not found on tile!\n");
    }
    public void unload(Transportation transportation, ResourceEnum resource){
        TransportationLocation location = getTransportationLocation(transportation);
        Tile tile = gameMap.getTileAt(location.getX(), location.getY());
        Resource resourceToUnload = transportation.removeResource(resource);
        if (resourceToUnload != null) tile.addResource(resourceToUnload);
        else System.out.printf("Resource not found on transporter!\n");
    }
}
