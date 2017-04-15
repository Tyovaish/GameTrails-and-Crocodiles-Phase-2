package Model.Map.Tile;
import Model.Map.Tile.Features.*;
import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TileFactory {
    static public Tile createTile(String featureType, int rotation, ArrayList<Integer> riverEdges){
        Tile tileToBeInserted=new Tile();
        switch(featureType){
            case "pasture": {tileToBeInserted.setFeature(new Pasture()); break;}
            case "desert": {tileToBeInserted.setFeature(new Desert()); break;}
            case "mountain": {tileToBeInserted.setFeature(new Mountain()); break;}
            case "sea": {tileToBeInserted.setFeature(new Sea()); break;}
            case "rock": {tileToBeInserted.setFeature(new Rock()); break;}
            case "wood": {tileToBeInserted.setFeature(new Woods()); break;}
        }
        TileOrientation orientation=new TileOrientation();
        orientation.setNumberOfRotations(rotation);
        tileToBeInserted.setOrientation(orientation);
        tileToBeInserted.setRiverEdges(riverEdges);
        tileToBeInserted.setTileZones(riverEdges);
        return tileToBeInserted;
    }
}
