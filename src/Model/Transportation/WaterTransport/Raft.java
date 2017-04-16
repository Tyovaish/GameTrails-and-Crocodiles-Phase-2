package Model.Transportation.WaterTransport;

import Model.Movement.MovementManager;
import Model.Transportation.Transportation;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Raft extends WaterTransport {
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