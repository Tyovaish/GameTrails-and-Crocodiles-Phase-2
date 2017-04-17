package Model.Livestock;

import Model.Abilities.MovementAbility;

import java.util.ArrayList;

/**
 * Created by Larry on 4/17/2017.
 */
public class Livestock {
    ArrayList<MovementAbility> movementAbilities;

    Livestock(){ movementAbilities = new ArrayList<MovementAbility>(); }

    public ArrayList<MovementAbility> getMovementSet(){
        return movementAbilities;
    }

}
