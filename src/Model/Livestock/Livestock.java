package Model.Livestock;

import Model.Abilities.MovementAbility;

import java.util.ArrayList;

/**
 * Created by Larry on 4/17/2017.
 */
public class Livestock {
    private int player;
    ArrayList<MovementAbility> movementAbilities;

    Livestock(){ movementAbilities = new ArrayList<MovementAbility>(); }

    public ArrayList<MovementAbility> getMovementSet(){
        return movementAbilities;
    }
    
    public void setPlayer(int player){this.player = player;}
    
    public int getPlayer(){return this.player;}

}
