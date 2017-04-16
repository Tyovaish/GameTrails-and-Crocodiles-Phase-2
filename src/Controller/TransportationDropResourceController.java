package Controller;

import Model.Abilities.DropResourceAbility;
import Model.Transportation.Transportation;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/16/2017.
 */
public class TransportationDropResourceController extends TransportationController{
    Transportation currentTransportation;
    ArrayList<DropResourceAbility> dropResourceAbilities;
    Controller prevController;
    int currentResourceDropAbility;

    TransportationDropResourceController(Controller prevController ){
        this.prevController=prevController;
    }
    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0 && keyPressed<dropResourceAbilities.size()){
            currentResourceDropAbility=keyPressed;
        }
        print();
    }

    @Override
    public Controller nextController() {
        if(!dropResourceAbilities.isEmpty()){
            dropResourceAbilities.get(currentResourceDropAbility).execute();
        }
        return prevController;
    }

    @Override
    public Controller previousController() {
        return prevController;
    }

    @Override
    public String print() {
        for(int i=0;i<dropResourceAbilities.size();i++){

        }
        return "";
    }
    public void setCurrentTransportation(Transportation transportation){
        currentTransportation=transportation;
        dropResourceAbilities=transportation.getDropResourceSet();
    }
    public String  printType(){
       return "Drop Resource Controller";
    }
}
