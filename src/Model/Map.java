package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Map {
    HashMap<Location,Tile> map;

    public Tile getTileAt(int x, int y){
        Location location=getLocation(x,y);
        return getTile(location);
    }
    private Location getLocation(int x,int y){
        Set<Location> locationSet=map.keySet();
        Location locationAt= new Location();
        for(Location l:locationSet){
            if(l.equals(x,y)){
                locationAt=l;
            }
        }
        return locationAt;
    }
    private Tile getTile(Location location){
        return map.get(location);
    }
    public void insertTile(Location location,Tile tile){
        map.put(location,tile);
    }
}
