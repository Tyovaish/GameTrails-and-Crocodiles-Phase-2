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
    int currentAbility=0;
    int currentSubAbility=0;


    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0 && keyPressed<currentAbilities.size()){
          currentAbility=keyPressed;
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
        currentAbilities.get(currentAbility).get(currentSubAbility);
    }
}
