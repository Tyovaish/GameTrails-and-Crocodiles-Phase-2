package Model.Structure;


import Model.Location.Location;
import Model.Location.StructureLocation;
import Model.Map.Tile.FeatureType;

import java.util.HashMap;

/**
 * Created by Trevor on 4/17/2017.
 */
public class StructureManager {
    HashMap<Structure,StructureLocation> structureLocationList;
    public StructureManager(){
        structureLocationList=new HashMap<Structure,StructureLocation>();
    }
    public void addStructure(Structure structure,StructureLocation structureLocation){
        structureLocationList.put(structure,structureLocation);
    }
    //public void getStructurePossible(Woods )
    public void getStructurePossible(FeatureType featureType){

    }
}
