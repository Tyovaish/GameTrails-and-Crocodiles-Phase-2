package Model.Transportation.WaterTransport;

import Model.Movement.MovementManager;
import Model.Transportation.Transportation;

/**
 * Created by khariollivierre on 4/16/17.
 */
public abstract class WaterTransport extends Transportation {
    public WaterTransport(MovementManager movementManager) {
        super(movementManager);
    }
}
