package Model.Map.Tile;

import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.Resource;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.ResourceHolder;
import Model.Structure.Structure;

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
        resourceBag = new ResourceBag();
        hasStructure = false;
    }

    public Structure getStructure() { return structure; }
    public void addStructure(Structure structure) { this.structure = structure; hasStructure = true; }
    public void removeStructure() { this.structure = null; hasStructure = false; }
    public boolean hasStructure() { return hasStructure; }

    public ResourceBag getResourceBag() { return resourceBag; }

    // ResourceHolder
    public void addResource(Resource resource){ resourceBag.addResource(resource); }
    public Resource removeResource(ResourceEnum resource){ return resourceBag.removeResource(resource); }

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

    public FeatureType getFeature() {
        return feature;
    }

    public void setFeature(FeatureType feature) {
        this.feature = feature;
    }

}