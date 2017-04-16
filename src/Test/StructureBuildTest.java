package Test;

import Model.Resource.PrimaryResource.Trunk;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.Resource.SecondaryResource.Board;
import Model.Structure.PrimaryProducer.PrimaryProducer;
import Model.Structure.PrimaryProducer.Woodcutter;
import Model.Structure.Structure;
import Model.Structure.StructureBuilder;
import Model.Structure.StructureEnum;
import Model.Transportation.Donkey;
import Model.Transportation.Transportation;

import java.util.Queue;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class StructureBuildTest {
    public static void main(String[] args) {
        // Create Structure builder and transportation
        StructureBuilder structureBuilder = new StructureBuilder();
        Donkey donkey = new Donkey();
        Board board = new Board();
        Woodcutter woodcutter;


        // Attempt to create woodcutter with no materials on donkey
        System.out.println("Attempting to create woodcutter with no materials on donkey");
        woodcutter = (Woodcutter)structureBuilder.build(donkey, StructureEnum.WOODCUTTER);
        checkStructure(woodcutter);

        // Add materials and try to create woodcutter again
        System.out.println("Adding materials and trying to create woodcutter again");
        donkey.addResource(board);
        woodcutter = (Woodcutter)structureBuilder.build(donkey, StructureEnum.WOODCUTTER);
        checkStructure(woodcutter);

        // Try to build another woodcutter after using the resources
        System.out.println("Trying to build another woodcutter after using the resources");
        Woodcutter newCutter = (Woodcutter)structureBuilder.build(donkey, StructureEnum.WOODCUTTER);
        checkStructure(newCutter);

        // Verify that woodcutter is producing
        System.out.println("Verifying that woodcutter is producing");
        donkey.addResource(woodcutter.produce());
        checkTrunks(donkey);
    }

    public static void checkTrunks(Transportation transportation){
        ResourceBag bag = transportation.getResourceBag();
        Queue<Trunk> trunks = bag.getTrunks();
        if (trunks.isEmpty()) System.out.printf("No trunks in Transportation bag. Counter = %d\n", bag.getCounter());
        else System.out.printf("Trunks in Transportation bag! Counter = %d\n", bag.getCounter());
    }
    public static void checkStructure(Structure structure) {
        if (structure == null) System.out.printf("Structure is null.\n");
        else System.out.printf("Structure is not null.\n");
    }
}