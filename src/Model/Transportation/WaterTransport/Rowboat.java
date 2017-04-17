package Model.Transportation.WaterTransport;

import Model.Movement.MovementManager;
import Model.Transportation.TransportationEnum;
import Model.Transportation.WaterTransport.WaterTransport;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Rowboat extends WaterTransport {
    String transportationType="rowboat";

    public Rowboat() {
        super();
        setBagSize(5);
        initResourceBag();
        setType(TransportationEnum.ROWBOAT);
    }

}
