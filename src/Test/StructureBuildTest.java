package Test;

import Model.Location.Location;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Map.Tile.TileZone;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.SecondaryResource.Board;
import Model.Structure.PrimaryProducer.ClayPit;
import Model.Structure.PrimaryProducer.PrimaryProducer;
import Model.Structure.PrimaryProducer.Woodcutter;
import Model.Structure.Structure;
import Model.Structure.StructureBuilder;
import Model.Structure.StructureEnum;
import Model.Transportation.Donkey;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class StructureBuildTest {
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
        TransportationManager transManager = new TransportationManager(gameMap);

        // Initialize locations
        Location location = new Location(0, 0);
        TransportationLocation transLocation = new TransportationLocation(0, 0, zone);

        // Add tile to map and transport to transportation manager
        gameMap.insertTile(location, tile);
        transManager.addTransportation(donkey, transLocation);

        // Create Structure builder
        StructureBuilder structureBuilder = new StructureBuilder(transManager);
        Board board = new Board();


        // Attempt to create woodcutter with no materials on donkey
        System.out.println("Attempting to create woodcutter with no materials on donkey...");
        structureBuilder.build(donkey, StructureEnum.WOODCUTTER);
        checkStructure(tile);

        // Add materials and try to create woodcutter again
        System.out.println("Adding materials and trying to create woodcutter again...");
        donkey.addResource(board);
        checkBoards(tile);
        checkBoards(donkey);
        structureBuilder.build(donkey, StructureEnum.WOODCUTTER);
        checkStructure(tile);

        // Verify resources were removed from bags
        System.out.println("Verifying materials were removed...");
        checkBoards(tile);
        checkBoards(donkey);

        // Verify that woodcutter is producing
        System.out.println("Verifying that woodcutter is producing...");
        tile.produce();
        checkTrunks(tile);

        // Try to build another woodcutter after using the resources
        System.out.println("Trying to build another woodcutter after using the resources...");
        tile.removeStructure();
        structureBuilder.build(donkey, StructureEnum.WOODCUTTER);
        checkStructure(tile);

        // Attempt to build Clay Pit without resources
        System.out.println("Attempting to create clay pit with no materials...");
        tile.removeStructure();
        structureBuilder.build(donkey, StructureEnum.CLAYPIT);
        checkStructure(tile);

        // Add resources to transport and tile
        tile.addResource(board);
        tile.addResource(board);
        donkey.addResource(board);
        checkBoards(tile);
        checkBoards(donkey);

        // Attempt to build clay pit with resources
        System.out.println("Attempting to create clay pit with materials...");
        tile.removeStructure();
        structureBuilder.build(donkey, StructureEnum.CLAYPIT);
        checkStructure(tile);

        // Verify resources were removed from bags
        System.out.println("Verifying materials were removed...");
        checkBoards(tile);
        checkBoards(donkey);

        return;
    }

    public static void checkTrunks(Transportation transportation){
        ResourceBag bag = transportation.getResourceBag();
        Queue<Trunk> trunks = bag.getTrunks();
        if (trunks.isEmpty()) System.out.printf("No trunks in Transportation bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Trunks in Transportation bag! Counter = %d\n", bag.getCounter());
    }
    public static void checkTrunks(Tile tile){
        ResourceBag bag = tile.getResourceBag();
        Queue<Trunk> trunks = bag.getTrunks();
        if (trunks.isEmpty()) System.out.printf("No trunks in Tile bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Trunks in Tile bag! Counter = %d\n", bag.getCounter());
    }
    public static void checkBoards(Transportation transportation){
        ResourceBag bag = transportation.getResourceBag();
        Queue<Board> boards = bag.getBoards();
        if (boards.isEmpty()) System.out.printf("No boards in Transportation bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Boards in Transportation bag! Counter = %d\n", bag.getCounter());
    }
    public static void checkBoards(Tile tile){
        ResourceBag bag = tile.getResourceBag();
        Queue<Board> boards = bag.getBoards();
        if (boards.isEmpty()) System.out.printf("No boards in Tile bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Boards in Tile bag! Counter = %d\n", bag.getCounter());
    }
    public static void checkStructure(Tile tile) {
        if (tile.getStructure() == null) System.out.printf("Tile does not have structure.\n");
        else System.out.printf("Tile has structure.\n");
    }
}