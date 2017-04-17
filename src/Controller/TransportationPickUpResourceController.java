package Controller;

import Model.Abilities.MovementAbility;
import Model.Abilities.PickUpResourceAbility;
import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/16/2017.
 */
public class TransportationPickUpResourceController extends TransportationController{

    Transportation currentTransportation;
    TransportationManager transportationManager;
    Controller prevController;
    int currentResourcePickUpAbility;

    TransportationPickUpResourceController(TransportationManager transportationManager, Controller prevController ){
        this.prevController=prevController;
        this.transportationManager=transportationManager;
    }

    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0 && keyPressed<currentTransportation.getPickUpResourceSet().size()){
            currentResourcePickUpAbility=keyPressed;
        }
    }

    @Override
    public Controller nextController() {
        if(!currentTransportation.getPickUpResourceSet().isEmpty()) {
           currentTransportation.getPickUpResourceSet().get(currentResourcePickUpAbility).execute();
        }
        return this;
    }

    @Override
    public Controller previousController() {
        return prevController;
    }

    @Override
    public String print() {
        for(int i=0;i<currentTransportation.getPickUpResourceSet().size();i++){
           currentTransportation.getPickUpResourceSet().get(i).print();
        }
        return "";
    }
    public void setCurrentTransportation(Transportation transportation){
        currentTransportation=transportation;
        transportationManager.setPickUpResourceAbilities(currentTransportation);
    }
    public String printType(){
        return "Pick Up Resource Controller";
    }
}
