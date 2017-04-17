package Model.Location;

import Model.Map.Tile.TileZone;
import Model.Transportation.Transportation;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TransportationLocation extends Location {
    TileZone tileZone;

    public TransportationLocation(int row, int col,TileZone tileZone) {
        super(row, col);
        this.tileZone=tileZone;
    }
    public void setEqualTo(TransportationLocation transportationLocation){
        this.tileZone=transportationLocation.tileZone;
        this.setX(transportationLocation.getX());
        this.setY(transportationLocation.getY());
    }
    public TileZone getTileZone(){
        return tileZone;
    }

    public Location toLocation(){ return new Location(this.getX(), this.getY()); }
}
