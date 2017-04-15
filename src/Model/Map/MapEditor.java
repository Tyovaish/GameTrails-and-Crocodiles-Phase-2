package Model;

/**
 * Created by Trevor on 4/14/2017.
 */
public class MapEditor {
    Map map;
    MapEditor(Map map){
        this.map=map;
    }
    public void insertTile(Location location,Tile tile){
        map.insertTile(location,tile);
    }
}
