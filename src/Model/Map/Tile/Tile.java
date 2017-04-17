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
    public String getStructureName() { return structure.getName(); }

    public ResourceBag getResourceBag() { return resourceBag; }

    public void addResources(ArrayList<Resource> resources){
        for (Resource resource : resources){
            if (resource == null) return;
            else addResource(resource);
        }
    }

    // ResourceHolder
    public void addResource(Resource resource){
        resource.setOnGround(true);
        resourceBag.addResource(resource);
    }
    public Resource removeResource(ResourceEnum resource){ return resourceBag.removeResource(resource); }
    public void giveMaterial(StructureBuilder builder, ResourceEnum resource){
        Resource material = removeResource(resource);
        if (material != null) builder.addMaterial(material);
        else System.out.printf("Material not found in Tile bag!\n");
    }


    public void produce(){
        if (canProduce()){
            ArrayList<Resource> resources = (ArrayList<Resource>) structure.produce();
            if (!resources.isEmpty())
                addResources(resources);
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

    public void setTileZones(ArrayList<Integer> riverEdges) {
            if(riverEdges.size()==0){
                TileZone tileZone=new TileZone();
                for(int i=0;i<2*Tile.SIZE;i++){
                    tileZone.insertPartOfEdge(i);
                }
                containedTileZone.add(tileZone);
            }
            if(riverEdges.size()==1){
                TileZone tileZone=new TileZone();
                for(int i=0;i<2*Tile.SIZE;i++){
                    tileZone.insertPartOfEdge(i);
                }
                containedTileZone.add(tileZone);
            }
            if(riverEdges.size()==2){
                TileZone tileZone1=new TileZone();
                TileZone tileZone2=new TileZone();
                tileZone1.insertPartOfEdge(1);
                tileZone1.insertPartOfEdge(2);
                tileZone1.insertPartOfEdge(3);
                tileZone1.insertPartOfEdge(4);
               for(int i=5;i<2*Tile.SIZE;i++){
                   tileZone2.insertPartOfEdge(i);
               }
                tileZone2.insertPartOfEdge(0);
                tileZone1.rotate(orientation.getNumberOfRotations());
                tileZone2.rotate(orientation.getNumberOfRotations());
                containedTileZone.add(tileZone1);
                containedTileZone.add(tileZone2);
            }
            if(riverEdges.size()==3){
                TileZone tileZone1=new TileZone();
                TileZone tileZone2=new TileZone();
                TileZone tileZone3=new TileZone();

                tileZone1.insertPartOfEdge(11);
                tileZone1.insertPartOfEdge(0);
                tileZone1.insertPartOfEdge(1);
                tileZone1.insertPartOfEdge(2);
                tileZone2.insertPartOfEdge(3);
                tileZone2.insertPartOfEdge(4);
                tileZone2.insertPartOfEdge(5);
                tileZone2.insertPartOfEdge(6);
                tileZone3.insertPartOfEdge(7);
                tileZone3.insertPartOfEdge(8);
                tileZone3.insertPartOfEdge(9);
                tileZone3.insertPartOfEdge(10);
                tileZone1.rotate(orientation.getNumberOfRotations());
                tileZone2.rotate(orientation.getNumberOfRotations());
                tileZone3.rotate(orientation.getNumberOfRotations());
                containedTileZone.add(tileZone1);
                containedTileZone.add(tileZone2);
                containedTileZone.add(tileZone3);
            }
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
    public ArrayList<TileZone> getContainedTileZone(){return this.containedTileZone;}
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
    public void print(){

       for(int i=0;i<containedTileZone.size();i++){
           containedTileZone.get(i).print();
       }
    }
}