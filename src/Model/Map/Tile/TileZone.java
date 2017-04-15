package Model.Map.Tile;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TileZone {
    ArrayList<Integer> tileParts;
    private ArrayList<TileZone> connectedTileZones;

    public void mergeTileZone(TileZone tileZone){
        if(!connectedTileZones.contains(tileZone)) {
            connectedTileZones.add(tileZone);
        }
    }
    public void removeConnectedTileZone(TileZone tileZone){
        connectedTileZones.remove(tileZone);
    }
    public void insertPartOfEdge(int edgeNumber){
        tileParts.add(edgeNumber);
    }

    public void print(){
        for(int i=0;i<tileParts.size();i++){
            System.out.print(tileParts.get(i)+',');
        }
        System.out.println();
    }
}
