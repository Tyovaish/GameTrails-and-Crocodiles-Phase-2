package Model.Map.Tile;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TileZone {
    ArrayList<Integer> tileParts;
    private ArrayList<TileZone> connectedTileZones;
    TileZone(){
        tileParts=new ArrayList<Integer>();
        connectedTileZones=new ArrayList<TileZone>();
    }
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
   public ArrayList<TileZone> getConnectedTileZones(){
        return connectedTileZones;
    }

    public void print(){
        for(int i=0;i<tileParts.size();i++){
            System.out.print(tileParts.get(i)+',');
        }
        System.out.println();
    }
}
