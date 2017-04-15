package Test;

import Model.Map.Tile.Tile;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Structure.PrimaryProducer.Woodcutter;

import java.util.Queue;

public class ResourceTest {
    public static void main(String[] args) {
        // Tile created
        Tile tile = new Tile();

        // Structure created and added to tile
        Woodcutter woodcutter = new Woodcutter();
        tile.addStructure(woodcutter);
        checkTrunks(tile);

        // Produce trunk from woodcutter and add it to tile
        Trunk trunk = woodcutter.produce();
        tile.addResource(trunk);
        checkTrunks(tile);

        // Remove trunk from bag
        tile.removeResource(ResourceEnum.TRUNK);
        checkTrunks(tile);

        return;
    }

    public static void checkTrunks(Tile tile){
        ResourceBag bag = tile.getResourceBag();
        Queue<Trunk> trunks = bag.getTrunks();
        if (trunks.isEmpty()) System.out.printf("No trunks in bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Trunks in bag! Counter = %d\n", bag.getCounter());
    }
}