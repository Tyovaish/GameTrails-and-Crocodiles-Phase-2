package Model.Transportation.WaterTransport;

import Model.Movement.MovementManager;
import Model.Transportation.WaterTransport.WaterTransport;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Steamer extends WaterTransport {
    String transportationType="steamer";

    public Steamer() {
        super();
        setBagSize(8);
        initResourceBag();
    }
}
