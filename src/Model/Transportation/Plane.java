package Model.Transportation;

import Model.Movement.MovementManager;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Plane extends Transportation {
    String transportationType="plane";

    public Plane(MovementManager movementManager) {
        super(movementManager);
        setBagSize(4);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {
        movementAbilities=movementManager.getMovementAbilities(this);
    }
}
