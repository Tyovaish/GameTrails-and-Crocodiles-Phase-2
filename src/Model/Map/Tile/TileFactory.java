package Model.Map.Tile;



import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TileFactory {
    static public Tile createTile(String featureType, int rotation, ArrayList<Integer> riverEdges){
        Tile tileToBeInserted=new Tile();
        switch(featureType){
            case "pasture": tileToBeInserted.setFeature(new Pasture());
        }
        TileOrientation orientation=new TileOrientation();
        orientation.setNumberOfRotations(rotation);
        tileToBeInserted.setOrientation(orientation);
        tileToBeInserted.setRiverEdges(riverEdges);
        tileToBeInserted.setTileZones(riverEdges);
        return tileToBeInserted;
    }
}
