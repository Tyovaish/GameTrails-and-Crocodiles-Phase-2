package Model.Transportation;

import Model.Movement.MovementManager;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Plane extends Transportation {
    String transportationType="plane";

    public Plane() {
        super();
        setBagSize(4);
        initResourceBag();
        setType(TransportationEnum.PLANE);
    }
}
