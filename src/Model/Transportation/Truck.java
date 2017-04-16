package Model.Transportation;

import Model.Movement.MovementManager;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Truck extends Transportation {
    String transportationType="truck";

    public Truck(MovementManager movementManager) {
        super(movementManager);
        setBagSize(6);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {
        movementAbilities=movementManager.getMovementAbilities(this);
    }
}
