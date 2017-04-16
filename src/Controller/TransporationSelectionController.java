package Controller;

import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TransporationSelectionController implements Controller {
    TransportationManager transportationManager;
    Transportation currentTransportation;
    TransportationController transportationController;
    ArrayList<Controller> controllerList;
    Controller nextController;
    Controller previousController;

    public TransporationSelectionController(TransportationManager transportationManager,Controller previousController){
        this.transportationManager=transportationManager;
        this.previousController=previousController;
        this.transportationController=new TransportationController(this);
        nextController=this.transportationController;
        currentTransportation=transportationManager.getTransportationList().get(0);
    }
    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0&&keyPressed<transportationManager.getTransportationList().size()){
            currentTransportation=transportationManager.getTransportationList().get(keyPressed);
        }
    }

    @Override
    public Controller nextController() {
    transportationController.setCurrentTransportation(currentTransportation);
    transportationController.setCurrentAbilities();
    return nextController;
    }

    @Override
    public Controller previousController() {
        currentTransportation=transportationManager.getTransportationList().get(0);
        return previousController;
    }

    @Override
    public void print() {
        System.out.println("TransportationSelectionController");
        System.out.println(currentTransportation.getType());
    }
}
