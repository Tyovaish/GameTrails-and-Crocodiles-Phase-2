package Model.Map.Tile;

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

    Tile(){
        containedTileZone=new ArrayList<TileZone>();
        riverEdges=new ArrayList<Integer>();
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