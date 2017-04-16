package Controller;

import Model.Abilities.MovementAbility;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/16/2017.
 */
public class TransportationMovementController extends TransportationController{
    TransportationManager transportationManager;
    Transportation currentTransportation;
    Controller prevController;
    int currentMovementAbility;


    TransportationMovementController(TransportationManager transportationManager,Controller prevController){
        this.prevController=prevController;
        this.transportationManager=transportationManager;
    }
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0&& keyPressed<=currentTransportation.getMovementSet().size()){
            currentMovementAbility=keyPressed;
        }
    }

    @Override
    public Controller nextController() {
        if(!currentTransportation.getMovementSet().isEmpty()){
            currentTransportation.getMovementSet().get(currentMovementAbility).execute();
        }
        return prevController;
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
            transportationManager.setMovementAbilities(currentTransportation);
    }
    public String printType(){
      return "Movement Controller";
    }
}
