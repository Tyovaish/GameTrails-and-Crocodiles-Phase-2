package Model.Transportation;

import Model.Movement.MovementManager;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Raft extends Transportation {
    String transportationType="raft";

    public Raft(MovementManager movementManager) {
        super(movementManager);
        setBagSize(3);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {
        movementAbilities=movementManager.getMovementAbilities(this);
    }
}
