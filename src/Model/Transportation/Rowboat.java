package Model.Transportation;

import Model.Movement.MovementManager;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Rowboat extends Transportation {
    String transportationType="rowboat";

    public Rowboat(MovementManager movementManager) {
        super(movementManager);
        setBagSize(5);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {
        movementAbilities=movementManager.getMovementAbilities(this);
    }
}
