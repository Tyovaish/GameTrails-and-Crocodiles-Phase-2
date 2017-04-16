package Model.Transportation.RoadTransport;

import Model.Movement.MovementManager;
import Model.Transportation.RoadTransport.RoadTransport;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Truck extends RoadTransport{
    String transportationType="truck";

    public Truck(MovementManager movementManager) {
        super(movementManager);
        setBagSize(3);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {
        movementAbilities=movementManager.getMovementAbilities(this);
    }
}
