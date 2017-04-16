package Test;

import Model.Map.Map;
import Model.Map.Tile.Features.Mountain;
import Model.Map.Tile.Tile;
import Model.Map.Tile.TileZone;
import Model.Resource.PrimaryResource.Gold;
import Model.Resource.PrimaryResource.Iron;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.ResourceBag;
import Model.Structure.PrimaryProducer.Mine;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class MineTest {
    public static void main(String[] args) {
        // Initialize game map
        Map gameMap = new Map();

        // Initialize a tile
        Tile tile = new Tile();
        ArrayList<Integer> rivers = new ArrayList<>();
        tile.setTileZones(rivers);
        tile.setFeature(new Mountain());
        TileZone zone = tile.getTileZone(0);

        // Add mine to tile
        Mine mine = new Mine();
        tile.addStructure(mine);
        checkOreCounter(mine);

        // Verify mine production
        System.out.printf("Verifying mine production...\n");
        tile.produce();
        checkOreCounter(mine);
        checkIron(tile);
        checkGold(tile);

        // Check randomness of mine production
        System.out.printf("Verifying mine production randomness...\n");
        tile.produce();
        tile.produce();
        tile.produce();
        tile.produce();
        tile.produce();
        checkOreCounter(mine);
        checkIron(tile);
        checkGold(tile);

        // Verify mine cannot produce if ore counter <= 0
        System.out.printf("Verifying mine production ceases when ore counter reaches 0...\n");
        mine.setOreCounter(0);
        tile.produce();
        checkOreCounter(mine);
        checkIron(tile);
        checkGold(tile);


    }
    public static void checkOreCounter(Mine mine){
        System.out.printf("Ore Counter = %d\n", mine.getOreCounter());
    }
    public static void checkIron(Tile tile){
        ResourceBag bag = tile.getResourceBag();
        Queue<Iron> irons = bag.getIrons();
        if (irons.isEmpty()) System.out.printf("No iron in Tile bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Iron in Tile bag! Counter = %d\n", bag.getCounter());
    }
    public static void checkGold(Tile tile){
        ResourceBag bag = tile.getResourceBag();
        Queue<Gold> golds = bag.getGolds();
        if (golds.isEmpty()) System.out.printf("No gold in Tile bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Gold in Tile bag! Counter = %d\n", bag.getCounter());
    }
}