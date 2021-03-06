package Model.Location;

import Model.Map.Tile.Tile;
import Model.Map.Tile.TileZone;

/**
 * Created by Trevor on 4/15/2017.
 */
public class ResourceLocation extends Location{
    TileZone tileZone;

    public ResourceLocation(int row, int col, TileZone tileZone) {
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
