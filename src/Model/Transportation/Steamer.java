package Model.Transportation;

import Model.Movement.MovementManager;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Steamer extends Transportation {
    String transportationType="steamer";

    public Steamer(MovementManager movementManager) {
        super(movementManager);
        setBagSize(8);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {
        movementAbilities=movementManager.getMovementAbilities(this);
    }
}
