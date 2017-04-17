package Model;

import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Resource.Resource;
import Model.Resource.ResourceManager;
import Model.Structure.Structure;
import Model.Structure.StructureManager;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

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



}
