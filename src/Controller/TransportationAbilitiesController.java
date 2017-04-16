package Controller;

import Controller.Controller;
import Model.Abilities.Ability;
import Model.Abilities.MovementAbility;
import Model.Transportation.Transportation;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/15/2017.
 */
public class TransportationAbilitiesController extends Controller {
    Transportation currentTransportation;
    ArrayList<TransportationController> controllerList;
    Controller prevController;
    int currentControllerSelected;


    public TransportationAbilitiesController(Controller prevController){
        currentControllerSelected=0;
        this.prevController=prevController;
        controllerList=new ArrayList<TransportationController>();
        controllerList.add(new TransportationMovementController(this));
        controllerList.add(new TransportationPickUpResourceController(this));
        controllerList.add(new TransportationDropResourceController(this));
}
    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0 && keyPressed<controllerList.size()){
          currentControllerSelected=keyPressed;
        }
        System.out.println("Current Controller:"+controllerList.get(currentControllerSelected).printType());
    }

    @Override
    public Controller nextController() {
        controllerList.get(currentControllerSelected).setCurrentTransportation(currentTransportation);
        return controllerList.get(currentControllerSelected);
    }

    @Override
    public Controller previousController() {
        return prevController;
    }

    @Override
    public String print() {
    for(int i=0;i<controllerList.size();i++) {
        return controllerList.get(i).printType();
    }
        return "";
    }
    public void setCurrentTransportation(Transportation transportation){
        currentTransportation=transportation;
    }
}
