package Model.Transportation;

import Model.Location.Location;
import Model.Abilities.DropResourceAbility;
import Model.Abilities.MovementAbility;
import Model.Abilities.PickUpResourceAbility;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Movement.MovementManager;
import Model.Resource.Resource;
import Model.Resource.ResourceEnum;
import Model.Resource.ResourceManager;
import Model.Resource.ResourceVisitor;
import Model.Structure.Structure;
import Model.Structure.StructureManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TransportationManager {
    MovementManager movementManager;
    ResourceManager resourceManager;
    StructureManager structureManager;
    ArrayList<MovementAbility> movementList;
    ArrayList<PickUpResourceAbility> pickUpResourceAbilities;

    ArrayList<Transportation> transportationList;
    HashMap<Transportation,TransportationLocation> transportationLocationList;
    ArrayList<DropResourceAbility> dropResourceAbilities;
    Map gameMap;

    public TransportationManager(Map gameMap){
        transportationList=new ArrayList<Transportation>();
        this.movementList=new ArrayList<MovementAbility>();
        transportationLocationList=new HashMap<Transportation,TransportationLocation>();
        this.gameMap = gameMap;
    }
    public TransportationManager(){
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

    public Location getLocation(Transportation transportation){
        return transportationLocationList.get(transportation).toLocation();
    }
       public boolean donkeyIsOnTile(int x,int y){
            for(int i=0;i<transportationList.size();i++){
                 TransportationLocation location=transportationLocationList.get(transportationList.get(i));
                 if(location.getX()==x && location.getY()==y){
                     return true;
                 }
                }
                return false;
        }

    public Tile getTileOfTransporter(Transportation transportation){
        TransportationLocation location = getTransportationLocation(transportation);
        return gameMap.getTileAt(location.getX(), location.getY());
    }

    public void setPickUpResourceAbilities(Transportation transportation){
        ArrayList<Resource> resourcesOnTileZone=resourceManager.getResourceAtTileZone(getTransportationLocation(transportation).getTileZone());
        Tile tile = getTileOfTransporter(transportation);
        pickUpResourceAbilities=new ArrayList<PickUpResourceAbility>();
                for(int i=0;i<resourcesOnTileZone.size();i++){
                    if(resourcesOnTileZone.get(i).onGround()) {
                        pickUpResourceAbilities.add(new PickUpResourceAbility(transportation.getResourceBag(), tile, resourcesOnTileZone.get(i)));
                        System.out.println("There is a resource on the tile!");
                    }
                }
                transportation.setPickUpResourceAbilities(pickUpResourceAbilities);
    }

    public  ArrayList<PickUpResourceAbility> getResourceList(){
        return pickUpResourceAbilities;
    }

    public void setDropResourceAbilities(Transportation transportation){
       dropResourceAbilities=new ArrayList<DropResourceAbility>();
        Tile tile = getTileOfTransporter(transportation);
        for(int i=0;i<transportation.getResourceBag().getResourceList().size();i++){
            dropResourceAbilities.add(new DropResourceAbility(transportation.getResourceBag(), tile, transportation.getResourceBag().getResourceList().get(i)));
        }
        transportation.setDropResourceAbilities(dropResourceAbilities);
    }
    public void setProduceStructureAbilities(Transportation transportation){
        ArrayList<Resource> resourcesInPossesion=resourceManager.getResourceAtTileZone(getTransportationLocation(transportation).getTileZone());
        resourcesInPossesion.addAll(transportation.getResourceBag().getResourceList());
        ResourceVisitor resourceVistor=new ResourceVisitor();
        for(int i=0;i<resourcesInPossesion.size();i++){

        }
    }

    public  ArrayList<DropResourceAbility> getDropList(){
        return dropResourceAbilities;
    }
    public void setMovementAbilities(Transportation transportation){
                transportation.setMovementAbilities(movementManager.getMovementAbilities(transportation));
                movementList = movementManager.getMovementAbilities(transportation);
    }

    public ArrayList<MovementAbility> getMovementList(){
        return movementList;
    }
    public MovementManager getMovementManager() {
        return movementManager;
    }

    public void setMovementManager(MovementManager movementManager) {
        this.movementManager = movementManager;
    }

    public void getStructureManager(StructureManager structureManager){ this.structureManager=structureManager;}

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
