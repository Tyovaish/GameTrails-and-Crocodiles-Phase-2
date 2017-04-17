package Controller;

import Model.Abilities.DropResourceAbility;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/16/2017.
 */
public class TransportationDropResourceController extends TransportationController{
    TransportationManager transportationManager;
    Transportation currentTransportation;
    Controller prevController;
    int currentResourceDropAbility;

    TransportationDropResourceController(TransportationManager transportationManager,Controller prevController ){
        this.transportationManager=transportationManager;
        this.prevController=prevController;
    }
    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0 && keyPressed<currentTransportation.getDropResourceSet().size()){
            currentResourceDropAbility=keyPressed;
        }
    }

    @Override
    public Controller nextController() {
        if(!currentTransportation.getDropResourceSet().isEmpty()){
            currentTransportation.getDropResourceSet().get(currentResourceDropAbility).execute();
            transportationManager.setDropResourceAbilities(currentTransportation);
        }
        return this;
    }

    @Override
    public Controller previousController() {
        return prevController;
    }

    @Override
    public String print() {

       for(int i=0;i<currentTransportation.getDropResourceSet().size();i++){
           System.out.println(i+": "+currentTransportation.getDropResourceSet().get(i).toString());
       }
       return "Drop Resource";

    }
    public void setCurrentTransportation(Transportation transportation){
        currentTransportation=transportation;
       transportationManager.setDropResourceAbilities(currentTransportation);
    }
    public String  printType(){
       return "Drop Resource Controller";
    }
}
