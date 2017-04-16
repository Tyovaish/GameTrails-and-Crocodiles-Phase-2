package Model.Wonder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Wonder {
    WonderRow[] zone1;
    WonderRow[] zone2;
    WonderRow[] zone3;
    WonderRow[] zone4;
    ArrayList<WonderRow[]> zones;

    public Wonder() {
        zone1 = new WonderRow[3];
        initZone(zone1, 4);
        zone2 = new WonderRow[4];
        initZone(zone2, 5);
        zone3 = new WonderRow[5];
        initZone(zone3, 6);
        zone4 = new WonderRow[3];
        initZone(zone4, 7);

        zones = new ArrayList<>(Arrays.asList(zone1, zone2, zone3, zone4));
    }

    private void initZone(WonderRow[] zone, int size){
        for (int i = 0; i < zone.length; i++) zone[i] = new WonderRow(size);
    }

    public void addBrick(){
        for (WonderRow[] zone : zones){
            if(!zoneComplete(zone)){
                for (WonderRow row : zone){
                    if (!row.isComplete()){
                        row.addBrick();
                        return;
                    }
                }
            }
        }
    }

    public boolean checkBrickInZone(int zoneI, int rowI, int brickI){
        if (zoneI >= 0 && zoneI < 4){
            WonderRow[] zone = zones.get(zoneI);
            if (rowI >= 0 && rowI < zone.length){
                WonderRow row = zone[rowI];
                return row.checkBrick(brickI);
            }
        }
        System.out.printf("Out of bounds");
        return false;
    }

    public boolean zoneComplete(WonderRow[] zone){
        for (WonderRow row : zone){
            if (!row.isComplete()) return false;
        }
        return true;
    }

    public WonderRow[] getZone(int index){
        return zones.get(index);
    }
}
