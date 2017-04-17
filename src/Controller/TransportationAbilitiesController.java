package Controller;

import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/15/2017.
 */
public class TransportationAbilitiesController extends Controller {
    Transportation currentTransportation;
    ArrayList<TransportationController> controllerList;
    Controller prevController;
    int currentControllerSelected;
    
    public TransportationAbilitiesController(TransportationManager transportationManager, Controller prevController){
        currentControllerSelected=0;
        this.prevController=prevController;
        controllerList=new ArrayList<TransportationController>();
        controllerList.add(new TransportationMovementController(transportationManager,this));
        controllerList.add(new TransportationPickUpResourceController(transportationManager,this));
        controllerList.add(new TransportationDropResourceController(transportationManager,this));
        controllerList.add(new TransportationPrimaryProducerBuilder(transportationManager,this));
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
    if(currentControllerSelected==0){
        return "Movement Controller";
    } else if(currentControllerSelected==1){
        return "Pick Up Resource";
    } else if(currentControllerSelected==2){
        return "Drop Off Resource";
    }
    return "None selected";
    }
    public void setCurrentTransportation(Transportation transportation){
        currentTransportation=transportation;
    }
}
