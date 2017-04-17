package Test;

import Model.Location.Location;
import Model.Location.TransportationLocation;
import Model.Map.Map;
import Model.Map.Tile.Features.Woods;
import Model.Map.Tile.Tile;
import Model.Map.Tile.TileZone;
import Model.Movement.MovementManager;
import Model.Resource.PrimaryResource.Gold;
import Model.Resource.PrimaryResource.Stone;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.SecondaryResource.Board;
import Model.Structure.SecondaryProducer.CoalBurner;
import Model.Structure.SecondaryProducer.Sawmill;
import Model.Structure.StructureBuilder;
import Model.Structure.StructureEnum;
import Model.Transportation.TransportationManager;
import Model.Transportation.WaterTransport.Steamer;

import java.util.ArrayList;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class CoalBurnerTest {
    public static void main(String[] args) {
        // Initialize game map
        Map gameMap = new Map();

        // Initialize a tile
        Tile tile = new Tile();
        ArrayList<Integer> rivers = new ArrayList<>();
        tile.setTileZones(rivers);
        tile.setFeature(new Woods());
        TileZone zone = tile.getTileZone(0);

        // Initialize transporter and transportation manager
        TransportationManager transManager = new TransportationManager(gameMap);
        MovementManager moveManager = new MovementManager(gameMap, transManager);
        Steamer steamer = new Steamer(moveManager);

        // Initialize locations
        Location location = new Location(0, 0);
        TransportationLocation transLocation = new TransportationLocation(0, 0, zone);

        // Add tile to map and transport to transportation manager
        gameMap.insertTile(location, tile);
        transManager.addTransportation(steamer, transLocation);

        // Create Structure builder
        StructureBuilder structureBuilder = new StructureBuilder(transManager);

        // Give Steamer Materials to create a Sawmill
        System.out.println("Giving steamer coal burner materials...");
        steamer.addResource(new Board());
        steamer.addResource(new Board());
        steamer.addResource(new Board());

        // Build coal burner
        System.out.println("Building coal burner...");
        structureBuilder.build(steamer, StructureEnum.COALBURNER);
        CoalBurner burner = (CoalBurner) tile.getStructure();

        // Add production materials to coal burner
        System.out.println("Adding input to coal burner...");
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Board());

        // Attempt to add wrong material to coal burner
        System.out.println("Adding wrong input to coal burner...");
        burner.addMaterial(new Gold());

        // Produce boards from coal burner
        System.out.println("Producing from coal burner...");
        tile.produce();

        // Attempt to produce without proper materials
        System.out.println("Producing without materials...");
        tile.produce();

        // Attempt to add too many resources to sawmill
        System.out.println("Adding too many materials...");
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());
        burner.addMaterial(new Trunk());

        // Produce with excess material
        System.out.println("Producing with excess material...");
        tile.produce();

    }
}
