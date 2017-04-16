package Model.Transportation;

import Model.Movement.MovementManager;
import Model.Resource.ResourceBag;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Donkey extends Transportation {
    String transportationType="donkey";

    public Donkey(MovementManager movementManager) {
        super(movementManager);
        setBagSize(2);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {
        movementAbilities=movementManager.getMovementAbilities(this);
    }

}
