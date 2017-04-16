package Test;

import Model.Map.Tile.Tile;
import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Structure.PrimaryProducer.Woodcutter;
import Model.Transportation.Donkey;
import Model.Transportation.Transportation;

import java.util.Queue;

public class ResourceTest {
    public static void main(String[] args) {
        // Tile, Donkey created
        Tile tile = new Tile();
        Donkey donkey = new Donkey();

        // Structure created and added to tile
        Woodcutter woodcutter = new Woodcutter();
        tile.addStructure(woodcutter);
        checkTrunks(tile);

        // Produce trunk from woodcutter and add it to tile
        Trunk trunk1 = woodcutter.produce();
        Trunk trunk2 = woodcutter.produce();
        Trunk trunk3 = woodcutter.produce();
        tile.addResource(trunk1);
        tile.addResource(trunk2);
        tile.addResource(trunk3);
        checkTrunks(tile);
        donkey.addResource(trunk1);
        donkey.addResource(trunk2);
        donkey.addResource(trunk3);
        checkTrunks(donkey);



        // Remove trunk from bag
        tile.removeResource(ResourceEnum.TRUNK);
        checkTrunks(tile);
        tile.removeResource(ResourceEnum.TRUNK);
        tile.removeResource(ResourceEnum.TRUNK);
        tile.removeResource(ResourceEnum.TRUNK);
        checkTrunks(tile);
        donkey.removeResource(ResourceEnum.TRUNK);
        checkTrunks(donkey);
        donkey.removeResource(ResourceEnum.TRUNK);
        donkey.removeResource(ResourceEnum.TRUNK);
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