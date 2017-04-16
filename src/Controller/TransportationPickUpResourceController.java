package Controller;

import Model.Abilities.MovementAbility;
import Model.Abilities.PickUpResourceAbility;
import Model.Transportation.Transportation;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/16/2017.
 */
public class TransportationPickUpResourceController extends TransportationController{
    Transportation currentTransportation;
    ArrayList<PickUpResourceAbility> pickUpResourceAbilities;
    Controller prevController;
    int currentResourcePickUpAbility;

    TransportationPickUpResourceController(Controller prevController ){
        this.prevController=prevController;
    }
    @Override
    public void getKeyPress(int keyPressed) {
        print();
        if(keyPressed>=0 && keyPressed<pickUpResourceAbilities.size()){
            currentResourcePickUpAbility=keyPressed;
        }
    }

    @Override
    public Controller nextController() {
        if(!pickUpResourceAbilities.isEmpty()) {
            pickUpResourceAbilities.get(currentResourcePickUpAbility).execute();
        }
        return prevController;
    }

    @Override
    public Controller previousController() {
        return prevController;
    }

    @Override
    public void print() {
        System.out.println("In Pick Up Resource Controller");

    }
    public void setCurrentTransportation(Transportation transportation){
        currentTransportation=transportation;
        pickUpResourceAbilities=transportation.getPickUpResourceSet();
    }
    public String printType(){
        return "Pick Up Resource Controller";
    }
}
