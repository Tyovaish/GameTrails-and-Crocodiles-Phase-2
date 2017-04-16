package Controller;

import Model.Abilities.MovementAbility;
import Model.Transportation.Transportation;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/16/2017.
 */
public class TransportationMovementController extends TransportationController{
    Transportation currentTransportation;
    ArrayList<MovementAbility> movementAbilities;
    Controller prevController;
    int currentMovementAbility;
    TransportationMovementController(Controller prevController ){
        this.prevController=prevController;
    }
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0&& keyPressed<=movementAbilities.size()){
            currentMovementAbility=keyPressed;
        }

    }

    @Override
    public Controller nextController() {
        if(!movementAbilities.isEmpty()){
            movementAbilities.get(currentMovementAbility).execute();
        }
        return previousController();
    }

    @Override
    public Controller previousController() {
        return prevController;
    }

    @Override
    public String print() {
        return printType();
    }

    public void setCurrentTransportation(Transportation transportation){
        currentTransportation=transportation;
        movementAbilities=transportation.getMovementSet();
    }
    public String printType(){
      return "Movement Controller";
    }
}
