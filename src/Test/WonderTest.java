package Test;

import Model.Wonder.Wonder;
import Model.Wonder.WonderRow;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class WonderTest {
    public static void main(String[] args) {
        // Initialize wonder
        Wonder wonder = new Wonder();
        boolean check;

        // Check first brick
        System.out.printf("Checking first brick...\n");
        check = wonder.checkBrickInZone(0, 0, 0);
        System.out.printf("First brick = %b\n", check);

        // Add brick and check again
        System.out.printf("Adding brick to wonder...\n");
        wonder.addBrick();
        check = wonder.checkBrickInZone(0, 0, 0);
        System.out.printf("First brick = %b\n", check);
        check = wonder.checkBrickInZone(0, 0, 1);
        System.out.printf("Second brick = %b\n", check);

        // Completing first row in wonder.
        System.out.printf("Completing first row and checking...\n");
        wonder.addBrick();
        wonder.addBrick();
        wonder.addBrick();
        check = wonder.checkBrickInZone(0, 0, 0);
        System.out.printf("First brick = %b\n", check);
        check = wonder.checkBrickInZone(0, 0, 1);
        System.out.printf("Second brick = %b\n", check);
        check = wonder.checkBrickInZone(0, 0, 2);
        System.out.printf("Third brick = %b\n", check);
        check = wonder.checkBrickInZone(0, 0, 3);
        System.out.printf("Fourth brick = %b\n", check);
        check = wonder.checkBrickInZone(0, 1, 0);
        System.out.printf("First brick in next row = %b\n", check);

        // Check if row is complete
        System.out.printf("Checking row completion...\n");
        WonderRow[] zone = wonder.getZone(0);
        check = zone[0].isComplete();
        System.out.printf("Row complete = %b\n", check);

        // Add a brick to the next row
        System.out.printf("Adding brick to next row...\n");
        wonder.addBrick();
        check = wonder.checkBrickInZone(0, 0, 0);
        System.out.printf("First brick = %b\n", check);
        check = wonder.checkBrickInZone(0, 0, 1);
        System.out.printf("Second brick = %b\n", check);
        check = wonder.checkBrickInZone(0, 0, 2);
        System.out.printf("Third brick = %b\n", check);
        check = wonder.checkBrickInZone(0, 0, 3);
        System.out.printf("Fourth brick = %b\n", check);
        check = wonder.checkBrickInZone(0, 1, 0);
        System.out.printf("First brick in next row = %b\n", check);

        // Check zone completion
        System.out.printf("Checking zone completion...\n");
        zone = wonder.getZone(0);
        check = wonder.zoneComplete(zone);
        System.out.printf("Initial zone completion = %b\n", check);
        // Row 2 complete
        wonder.addBrick();
        wonder.addBrick();
        wonder.addBrick();
        // Row 3 complete
        wonder.addBrick();
        wonder.addBrick();
        wonder.addBrick();
        wonder.addBrick();
        // Extra brick just cuz
        wonder.addBrick();
        check = wonder.zoneComplete(zone);
        System.out.printf("Zone completion = %b\n", check);



        return;
    }
}