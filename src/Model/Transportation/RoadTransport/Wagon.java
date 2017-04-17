package Model.Transportation.RoadTransport;

import Model.Movement.MovementManager;
import Model.Transportation.RoadTransport.RoadTransport;
import Model.Transportation.TransportationEnum;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Wagon extends RoadTransport {
    String transportationType="wagon";

    public Wagon() {
        super();
        setBagSize(3);
        initResourceBag();
        setType(TransportationEnum.WAGON);
    }
}
