package Model.Transportation.WaterTransport;

import Model.Movement.MovementManager;
import Model.Transportation.WaterTransport.WaterTransport;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Rowboat extends WaterTransport {
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
