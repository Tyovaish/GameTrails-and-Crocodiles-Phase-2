package Test;

import Model.Map.Tile.TileZone;

/**
 * Created by Trevor on 4/16/2017.
 */
public class TileZoneTest {
    public static void main(String args[]) {
        TileZone tileZone1 = new TileZone();
        TileZone tileZone2 = new TileZone();
        tileZone1.mergeTileZone(tileZone2);
    }

}
