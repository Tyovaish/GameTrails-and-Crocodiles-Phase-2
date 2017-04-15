package Model.Movement;

import Model.Abilities.MovementAbility;
import Model.Map.Map;
import Model.Transportation.Donkey;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class MovementManager {
    Map map;
   TransportationManager transportationManager;
    MovementManager(Map map, TransportationManager transportationManager){
        this.map=map;
        this.transportationManager=transportationManager;
    }

    public ArrayList<MovementAbility> getMovementAbilities(Donkey donkey) {
    return null;
    }
}
