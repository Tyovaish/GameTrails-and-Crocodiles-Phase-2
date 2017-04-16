package Model.Movement;

import Model.Abilities.MovementAbility;
import Model.Location.Location;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Map.Tile.TileZone;
import Model.Transportation.Donkey;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class MovementManager {
    Map map;
   TransportationManager transportationManager;
    public MovementManager(Map map, TransportationManager transportationManager){
        this.map=map;
        this.transportationManager=transportationManager;
    }

    public ArrayList<MovementAbility> getMovementAbilities(Donkey donkey) {
        map.print();
        TransportationLocation donkeyLocation=transportationManager.getTransportationLocation(donkey);

        TileZone tileZoneToCheck=donkeyLocation.getTileZone();

        ArrayList<TileZone> tileZones=tileZoneToCheck.getConnectedTileZones();

        ArrayList<MovementAbility> movementAbilities=new ArrayList<MovementAbility>();

        Location northTileLocation=donkeyLocation.getNorth();
        Location northEastTileLocation=donkeyLocation.getNorthEast();
        Location southEastTileLocation=donkeyLocation.getSouthEast();
        Location southTileLocation=donkeyLocation.getSouth();
        Location southWestTileLocation=donkeyLocation.getSouthWest();
        Location northWestTileLocation=donkeyLocation.getNorthWest();

        Tile northTile=map.getTileAt(northTileLocation.getX(),northTileLocation.getY());
        if(northTile!=null){
            for(int i=0;i<tileZones.size();i++){
                if(northTile.checkIfTileZoneContainsIn(tileZones.get(i))){
                    movementAbilities.add(new MovementAbility(donkeyLocation,new TransportationLocation(northTileLocation.getX(),northTileLocation.getY(),tileZones.get(i)),donkey.getResourceBag()));
                     northTileLocation.print();
                }
            }
        }

        Tile northEastTile=map.getTileAt(northEastTileLocation.getX(),northEastTileLocation.getY());
        if(northEastTile!=null){
            for(int i=0;i<tileZones.size();i++){
                if(northEastTile.checkIfTileZoneContainsIn(tileZones.get(i))){
                    movementAbilities.add(new MovementAbility(donkeyLocation,new TransportationLocation(northEastTileLocation.getX(),northEastTileLocation.getY(),tileZones.get(i)),donkey.getResourceBag()));
                    northEastTile.print();
                }
            }
        }
        Tile southEastTile=map.getTileAt(southEastTileLocation.getX(),southEastTileLocation.getY());
        if(southEastTile!=null){
            for(int i=0;i<tileZones.size();i++){
                if(southEastTile.checkIfTileZoneContainsIn(tileZones.get(i))){
                    movementAbilities.add(new MovementAbility(donkeyLocation,new TransportationLocation(southEastTileLocation.getX(),southEastTileLocation.getY(),tileZones.get(i)),donkey.getResourceBag()));
                    southEastTileLocation.print();
                }
            }
        }
        Tile southTile=map.getTileAt(southTileLocation.getX(),southTileLocation.getY());
        if(southTile!=null){
            for(int i=0;i<tileZones.size();i++){
                if(southTile.checkIfTileZoneContainsIn(tileZones.get(i))){
                    movementAbilities.add(new MovementAbility(donkeyLocation,new TransportationLocation(southTileLocation.getX(),southTileLocation.getY(),tileZones.get(i)),donkey.getResourceBag()));
                    southTileLocation.print();
                }
            }
        }
        Tile southWestTile=map.getTileAt(southWestTileLocation.getX(),southWestTileLocation.getY());
        if(southWestTile!=null){
            for(int i=0;i<tileZones.size();i++){
                if(southWestTile.checkIfTileZoneContainsIn(tileZones.get(i))){
                    movementAbilities.add(new MovementAbility(donkeyLocation,new TransportationLocation(southWestTileLocation.getX(),southWestTileLocation.getY(),tileZones.get(i)),donkey.getResourceBag()));
                    southWestTileLocation.print();
                }
            }
        }
        Tile northWestTile=map.getTileAt(northWestTileLocation.getX(),northWestTileLocation.getY());
        if(northWestTile!=null){
            for(int i=0;i<tileZones.size();i++){
                if(northWestTile.checkIfTileZoneContainsIn(tileZones.get(i))){
                    movementAbilities.add(new MovementAbility(donkeyLocation,new TransportationLocation(northWestTileLocation.getX(),northWestTileLocation.getY(),tileZones.get(i)),donkey.getResourceBag()));
                    northWestTileLocation.print();
                }
            }
        }
        return movementAbilities;
    }
}
