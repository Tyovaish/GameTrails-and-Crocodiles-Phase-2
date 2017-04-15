package Model.Map.Tile;

import Model.Resource.ResourceBag;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Tile {
    public static int SIZE = 6;
    FeatureType feature;
    ArrayList<TileZone> containedTileZone;
    ArrayList<Integer> riverEdges;
    TileOrientation orientation;
    ResourceBag resourceBag;

    public Tile(){
        containedTileZone=new ArrayList<TileZone>();
        resourceBag = new ResourceBag();
    }


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