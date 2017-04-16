package Model.Transportation;

import Model.Movement.MovementManager;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Wagon extends Transportation {
    String transportationType="wagon";

    public Wagon(MovementManager movementManager) {
        super(movementManager);
        setBagSize(3);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {
        movementAbilities=movementManager.getMovementAbilities(this);
    }

}
