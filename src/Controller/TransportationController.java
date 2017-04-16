package Controller;

import Controller.Controller;
import Model.Abilities.Ability;
import Model.Abilities.MovementAbility;
import Model.Transportation.Transportation;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/15/2017.
 */
public class TransportationController implements Controller {
    Transportation currentTransportation;
    ArrayList<MovementAbility> currentAbilities;
    Controller prevController;
    int currentAbilitySelected=0;
    int currentSubAbilitySelected=0;


public TransportationController(Controller prevController){
    this.prevController=prevController;
}
    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed=='q'){
            currentAbilitySelected=0;
        }
        if(keyPressed=='w'){
            currentAbilitySelected=1;
        }
        if(keyPressed=='e'){
            currentAbilitySelected=2;
        }
        if(keyPressed>=0 && keyPressed<currentAbilities.size()){
          currentAbilitySelected=keyPressed;
        }

    }

    @Override
    public Controller nextController() {
        currentAbilities.get(currentAbilitySelected).execute();
        return previousController();
    }

    @Override
    public Controller previousController() {
        return prevController;
    }

    @Override
    public void print() {
    if(currentAbilities.size()>0) {
        currentAbilities.get(currentAbilitySelected);
    }
    }
    public void setCurrentTransportation(Transportation transportation){
        currentTransportation=transportation;
    }
    public void setCurrentAbilities(){currentAbilities=currentTransportation.getMovementSet();}
}
