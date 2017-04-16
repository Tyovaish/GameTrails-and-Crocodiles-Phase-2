package Controller;

import Controller.Controller;
import Model.Abilities.Ability;
import Model.Transportation.Transportation;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/15/2017.
 */
public class TransportationController implements Controller {
    Transportation currentTransportation;
    ArrayList<ArrayList<Ability>> currentAbilities;
    Controller prevController;
    int currentAbilitySelected=0;
    int currentSubAbilitySelected=0;


    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0 && keyPressed<currentAbilities.size()){
          currentSubAbilitySelected=keyPressed;
        } else if(keyPressed=='l'){
            currentSubAbilitySelected--;
            if(currentSubAbilitySelected<0){
                currentSubAbilitySelected=currentAbilities.get(currentAbilitySelected).size()-1;
            }
        } else if(keyPressed=='r'){
            currentSubAbilitySelected++;
            if(currentSubAbilitySelected>currentAbilities.get(currentAbilitySelected).size()){
                currentSubAbilitySelected=0;
            }
        }
    }

    @Override
    public Controller nextController() {
        return this;
    }

    @Override
    public Controller previousController() {
        return prevController;
    }

    @Override
    public void print() {
        currentAbilities.get(currentAbilitySelected).get(currentSubAbilitySelected);
    }
}
