package Model.Transportation.WaterTransport;

import Model.Movement.MovementManager;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationEnum;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Raft extends WaterTransport {
    String transportationType="raft";

    public Raft() {
        super();
        setBagSize(3);
        initResourceBag();
        setType(TransportationEnum.RAFT);
    }
}
