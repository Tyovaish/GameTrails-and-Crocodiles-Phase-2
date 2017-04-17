package Model;

import Model.Abilities.DropResourceAbility;
import Model.Abilities.MovementAbility;
import Model.Abilities.PickUpResourceAbility;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Resource.Resource;
import Model.Resource.ResourceManager;
import Model.Structure.Structure;
import Model.Structure.StructureManager;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class ViewObserver {
    TransportationManager transportationManager;
    ResourceManager resourceManager;
    StructureManager structureManager;
    Map map;

    public ViewObserver(Map map,TransportationManager transportationManager, ResourceManager resourceManager,StructureManager structureManager) {
        this.transportationManager = transportationManager;
        this.resourceManager=resourceManager;
        this.structureManager=structureManager;
        this.map=map;
    }

     public Tile getTileAt(int x, int y){
        return map.getTileAt(x,y);
    }
     public boolean getDonkeyAt(int x,int y){
            return transportationManager.donkeyIsOnTile(x,y);
    }
     public ArrayList<PickUpResourceAbility> getResourceList(){
         return transportationManager.getResourceList();
     }
     public ArrayList<DropResourceAbility> getDropList(){
         return transportationManager.getDropList();
     }
     public ArrayList<MovementAbility> getMovementList(){
         return transportationManager.getMovementList();
     }

     public ArrayList<Transportation> getTransportList(){
         return transportationManager.getTransportationList();
     }



}
