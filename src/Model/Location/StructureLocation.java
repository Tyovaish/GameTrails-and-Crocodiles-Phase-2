package Model.Location;

import Model.Map.Tile.TileZone;

/**
 * Created by Trevor on 4/17/2017.
 */
public class StructureLocation extends Location {
    TileZone tileZone;

    public StructureLocation(int row, int col, TileZone tileZone) {
        super(row, col);
        this.tileZone=tileZone;
    }
    public void setTileZone(TileZone tileZone){
        this.tileZone=tileZone;
    }
    public TileZone getTileZone(){
        return tileZone;
    }
}
