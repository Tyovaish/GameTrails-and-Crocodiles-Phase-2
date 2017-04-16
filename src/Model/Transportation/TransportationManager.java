package Model.Transportation;

import Model.Abilities.DropResourceAbility;
import Model.Abilities.PickUpResourceAbility;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Movement.MovementManager;
import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceManager;
import Model.Transportation.Transportation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TransportationManager {
    MovementManager movementManager;
    ResourceManager resourceManager;

    ArrayList<Transportation> transportationList;
    HashMap<Transportation,TransportationLocation> transportationLocationList;
    Map gameMap;

    public TransportationManager(Map gameMap){
        transportationList=new ArrayList<Transportation>();
        transportationLocationList=new HashMap<Transportation,TransportationLocation>();
        this.gameMap = gameMap;
    }
    TransportationManager(){
        transportationList=new ArrayList<Transportation>();
        transportationLocationList = new HashMap<Transportation, TransportationLocation>();
    }
    public void addTransportation(Transportation transportation,TransportationLocation transportationLocation){
        transportationList.add(transportation);
        transportationLocationList.put(transportation,transportationLocation);
    }
    public ArrayList<Transportation> getTransportationList() {
                return transportationList;
    }

    public TransportationLocation getTransportationLocation(Transportation transportation){
        return transportationLocationList.get(transportation);
    }

    public Tile getTileOfTransporter(Transportation transportation){
        TransportationLocation location = getTransportationLocation(transportation);
        return gameMap.getTileAt(location.getX(), location.getY());
    }

    public void setPickUpResourceAbilities(Transportation transportation){
        ArrayList<Resource> resourcesOnTileZone=resourceManager.getResourceAtTileZone(getTransportationLocation(transportation).getTileZone());
        ArrayList<PickUpResourceAbility> pickUpResourceAbilities=new ArrayList<PickUpResourceAbility>();
                for(int i=0;i<resourcesOnTileZone.size();i++){
                    if(resourcesOnTileZone.get(i).onGround()) {
                        pickUpResourceAbilities.add(new PickUpResourceAbility(transportation.getResourceBag(), resourcesOnTileZone.get(i)));
                        System.out.println("There is a resource on the tile!");
                    }
                }
                transportation.setPickUpResourceAbilities(pickUpResourceAbilities);
    }


    public void setDropResourceAbilities(Transportation transportation){
        ArrayList<DropResourceAbility> dropResourceAbilities=new ArrayList<DropResourceAbility>();
        for(int i=0;i<transportation.getResourceBag().getResourceList().size();i++){
            dropResourceAbilities.add(new DropResourceAbility(transportation.getResourceBag(),transportation.getResourceBag().getResourceList().get(i)));
        }
        transportation.setDropResourceAbilities(dropResourceAbilities);
    }

    public void setMovementAbilities(Transportation transportation){
            transportation.setMovementAbilities(movementManager.getMovementAbilities(transportation));
    }
    public MovementManager getMovementManager() {
        return movementManager;
    }

    public void setMovementManager(MovementManager movementManager) {
        this.movementManager = movementManager;
    }

    public ResourceManager getResourceManager() {
        return resourceManager;
    }

    public void setResourceManager(ResourceManager resourceManager) {
        this.resourceManager = resourceManager;
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
