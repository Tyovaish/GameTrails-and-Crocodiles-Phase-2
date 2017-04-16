package Model.Map.Tile;

import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.Resource;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.ResourceHolder;
import Model.Structure.PrimaryProducer.PrimaryProducer;
import Model.Structure.Structure;
import Model.Structure.StructureBuilder;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Tile implements ResourceHolder{
    public static int SIZE = 6;
    FeatureType feature;
    ArrayList<TileZone> containedTileZone;
    ArrayList<Integer> riverEdges;
    TileOrientation orientation;
    ResourceBag resourceBag;

    boolean hasStructure;
    Structure structure;

    public Tile(){
        containedTileZone=new ArrayList<TileZone>();
        resourceBag = new ResourceBag(-1);
        hasStructure = false;
        riverEdges=new ArrayList<Integer>();
    }

    public Structure getStructure() { return structure; }
    public void addStructure(Structure structure) { this.structure = structure; hasStructure = true; }
    public void removeStructure() { this.structure = null; hasStructure = false; }
    public boolean hasStructure() { return hasStructure; }

    public ResourceBag getResourceBag() { return resourceBag; }

    // ResourceHolder
    public void addResource(Resource resource){ resourceBag.addResource(resource); }
    public Resource removeResource(ResourceEnum resource){ return resourceBag.removeResource(resource); }
    public void giveMaterial(StructureBuilder builder, ResourceEnum resource){
        Resource material = removeResource(resource);
        if (material != null) builder.addMaterial(material);
        else System.out.printf("Material not found in Tile bag!\n");
    }

    public void produce(){
        if (canProduce()){
            Resource resource = structure.produce();
            if (resource != null) addResource(resource);
        }
    }
    public boolean canProduce(){
        if (feature == null) return false;
        if (hasStructure){
            FeatureType productionFeature = structure.getProductionFeature();
            if (structure.isPrimaryProducer() && productionFeature != null){
                return (feature.getType() == productionFeature.getType());
            }
            return true;
        }
        return false;
    }

    // Phases
    public void productionPhase(){ if (canProduce()) produce(); }

    public void setTileZones(ArrayList<Integer> riverEdges) {
        TileZone temp = new TileZone();
        for (int i = 0; i < 2 * Tile.SIZE; i++) {
            if (riverEdges.contains(i / 2)) {
                temp.insertPartOfEdge(i);
                containedTileZone.add(temp);
                temp = new TileZone();
                i++;
            }
            temp.insertPartOfEdge(i);
        }
        containedTileZone.add(temp);
    }
    public ArrayList<Integer> getRiverEdges() {
        return riverEdges;
    }

    public void setRiverEdges(ArrayList<Integer> riverEdges) {
        this.riverEdges = riverEdges;
    }
    public TileOrientation getOrientation() {
        return orientation;
    }

    public void setOrientation(TileOrientation orientation) {
        this.orientation = orientation;
    }
    public ArrayList<TileZone> getConnectedTileZones(){return this.containedTileZone;}
    public FeatureType getFeature() {
        return feature;
    }
    public void mergeTileZone(int tileZoneNumber,TileZone tileZone){
        for(int i=0;i<containedTileZone.size();i++){
            if(containedTileZone.get(i).containsTileZoneNumber(tileZoneNumber)){
                containedTileZone.get(i).mergeTileZone(tileZone);
            }
        }
    }
    public TileZone getTileZone(int tileZoneNumber){
        for(int i=0;i<containedTileZone.size();i++){
            if(containedTileZone.get(i).containsTileZoneNumber(tileZoneNumber)){
                return containedTileZone.get(i);
            }
        }
        return null;
    }

    public void setFeature(FeatureType feature) {
        this.feature = feature;
    }
    public boolean checkIfTileZoneContainsIn(TileZone tileZone){
        return containedTileZone.contains(tileZone);
    }
}