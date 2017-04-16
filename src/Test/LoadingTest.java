package Test;

import Model.Location.Location;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Map.Tile.TileZone;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Transportation.Donkey;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by khariollivierre on 4/15/17.
 */
/*
public class LoadingTest {
    public static void main(String[] args) {
        // Initialize game map
        Map gameMap = new Map();

        // Initialize a tile
        Tile tile = new Tile();
        ArrayList<Integer> rivers = new ArrayList<>();
        tile.setTileZones(rivers);
        TileZone zone = tile.getTileZone(0);

        // Initialize transporter and transportation manager
        Donkey donkey = new Donkey();
        TransportationManager manager = new TransportationManager(gameMap);

        // Initialize locations
        Location location = new Location(0, 0);
        TransportationLocation transLocation = new TransportationLocation(0, 0, zone);

        // Add tile to map and transport to transportation manager
        gameMap.insertTile(location, tile);
        manager.addTransportation(donkey, transLocation);

        // Add a resource to the tile
        tile.addResource(new Trunk());

        // Starting state of tile/transporter
        System.out.printf("Starting state of tile/transporter...\n");
        checkTrunks(tile);
        checkTrunks(donkey);

        // Attempt to load a resource not on the tile
        System.out.printf("Attempting to load resource that is not on the tile...\n");
        manager.load(donkey, ResourceEnum.BOARD);

        // Attempt to load a resource that is on the tile
        System.out.printf("Attempting to load resource that is on the tile...\n");
        manager.load(donkey, ResourceEnum.TRUNK);

        // Check if resource was loaded onto the transporter
        System.out.printf("Current state of tile/transporter...\n");
        checkTrunks(tile);
        checkTrunks(donkey);

        // Attempt to unload a resource that is not on transporter
        System.out.printf("Attempting to unload resource that is not on the transporter...\n");
        manager.unload(donkey, ResourceEnum.BOARD);

        // Attempt to unload a resource that is on transporter
        System.out.printf("Attempting to unload resource that is on the transporter...\n");
        manager.unload(donkey, ResourceEnum.TRUNK);

        // Check if resource was unloaded from the transporter
        System.out.printf("Current state of tile/transporter...\n");
        checkTrunks(tile);
        checkTrunks(donkey);

        return;
    }
    public static void checkTrunks(Tile tile){
        ResourceBag bag = tile.getResourceBag();
        Queue<Trunk> trunks = bag.getTrunks();
        if (trunks.isEmpty()) System.out.printf("No trunks in Tile bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Trunks in Tile bag! Counter = %d\n", bag.getCounter());
    }
    public static void checkTrunks(Transportation transportation){
        ResourceBag bag = transportation.getResourceBag();
        Queue<Trunk> trunks = bag.getTrunks();
        if (trunks.isEmpty()) System.out.printf("No trunks in Transportation bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Trunks in Transportation bag! Counter = %d\n", bag.getCounter());
    }
}
*/