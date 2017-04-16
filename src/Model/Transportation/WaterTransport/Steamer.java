package Model.Transportation.WaterTransport;

import Model.Movement.MovementManager;
import Model.Transportation.WaterTransport.WaterTransport;

/**
 * Created by khariollivierre on 4/16/17.
 */
public class Steamer extends WaterTransport {
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
