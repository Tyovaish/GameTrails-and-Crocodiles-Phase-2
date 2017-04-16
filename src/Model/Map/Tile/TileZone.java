package Model.Map.Tile;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TileZone {
    ArrayList<Integer> tileParts;
    private ArrayList<TileZone> connectedTileZones;
    public TileZone(){
        tileParts=new ArrayList<Integer>();
        connectedTileZones=new ArrayList<TileZone>();
    }
    public void mergeTileZone(TileZone tileZone){
        if(!connectedTileZones.contains(tileZone)) {
            System.out.println("Add new TileZone!");
            connectedTileZones.add(tileZone);
            tileZone.addTileZone(this);
        }
        System.out.println(connectedTileZones.size());
    }
    public void removeConnectedTileZone(TileZone tileZone){
        connectedTileZones.remove(tileZone);
    }
    public void addTileZone(TileZone tileZone){connectedTileZones.add(tileZone);}
    public void insertPartOfEdge(int edgeNumber){
        System.out.println(edgeNumber);
        tileParts.add(edgeNumber);
    }
   public ArrayList<TileZone> getConnectedTileZones(){
        return connectedTileZones;
    }

    public void print(){
        for(int i=0;i<tileParts.size();i++){
            System.out.print(tileParts.get(i)+",");
        }
        System.out.println();
    }
    public boolean containsTileZoneNumber(int tileZoneNumber){

        for(int i=0;i<tileParts.size();i++){
            if(tileParts.get(i)==tileZoneNumber){
                return true;
            }
        }
        return false;
    }
    public void rotate(int rotation){
        for(int i=0;i<tileParts.size();i++){
            int temp=tileParts.get(i);
            temp=(temp+rotation)%12;
            tileParts.remove(tileParts.get(i));
            tileParts.add(temp);
        }
    }
}
