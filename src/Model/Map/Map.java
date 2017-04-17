package Model.Map;

import Model.Location.Location;
import Model.Map.Tile.Tile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Map {
    HashMap<Location, Tile> map;
    ArrayList<Tile> tileList;
    public Map(){
        map=new HashMap<Location,Tile>();
        tileList=new ArrayList<Tile>();
    }
    public Tile getTileAt(int x, int y){
        Location location=getLocation(x,y);
        return getTile(location);
    }
    private Location getLocation(int x,int y){
        Set<Location> locationSet=map.keySet();
        Location locationAt= new Location(x,y);
        for(Location l:locationSet){
            if(l.equals(x,y)){
                locationAt=l;
            }
        }
        return locationAt;
    }
    public void print(){
        for(int i=0;i<tileList.size();i++){
            tileList.get(i).print();
        }
    }
    private Tile getTile(Location location){
        return map.get(location);
    }
    public void insertTile(Location location,Tile tile){
        tileList.add(tile);
        map.put(location,tile);
        Location northTileLocation=location.getNorth();
        Location northEastTileLocation=location.getNorthEast();
        Location southEastTileLocation=location.getSouthEast();
        Location southTileLocation=location.getSouth();
        Location southWestTileLocation=location.getSouthWest();
        Location northWestTileLocation=location.getNorthWest();

        Tile northTile=getTileAt(northTileLocation.getX(),northTileLocation.getY());
        if(northTile!=null){
          tile.mergeTileZone(0,northTile.getTileZone(7));
            tile.mergeTileZone(1,northTile.getTileZone(6));
        }
        Tile northEastTile=getTileAt(northEastTileLocation.getX(),northEastTileLocation.getY());
        if(northEastTile!=null){
            tile.mergeTileZone(2,northEastTile.getTileZone(9));
            tile.mergeTileZone(3,northEastTile.getTileZone(8));
        }
        Tile southEastTile=getTileAt(southEastTileLocation.getX(),southEastTileLocation.getY());
        if(southEastTile!=null){
            tile.mergeTileZone(4,southEastTile.getTileZone(11));
            tile.mergeTileZone(5,southEastTile.getTileZone(10));
        }
        Tile southTile=getTileAt(southTileLocation.getX(),southTileLocation.getY());
        if(southTile!=null){
            tile.mergeTileZone(6,southTile.getTileZone(1));
            tile.mergeTileZone(7,southTile.getTileZone(0));
        }
        Tile southWestTile=getTileAt(southWestTileLocation.getX(),southWestTileLocation.getY());
        if(southWestTile!=null){
            tile.mergeTileZone(8,southWestTile.getTileZone(3));
            tile.mergeTileZone(9,southWestTile.getTileZone(2));
        }
        Tile northWestTile=getTileAt(northWestTileLocation.getX(),northWestTileLocation.getY());
        if(northWestTile!=null){
            tile.mergeTileZone(10,northWestTile.getTileZone(5));
            tile.mergeTileZone(11,northWestTile.getTileZone(4));
        }
    }
}
