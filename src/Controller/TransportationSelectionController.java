package Controller;

import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TransportationSelectionController extends Controller{
    TransportationManager transportationManager;
    Transportation currentTransportation;
    TransportationAbilitiesController TransportationAbilitiesController;
    Controller nextController;
    Controller prevController;

    public TransportationSelectionController(TransportationManager transportationManager,Controller previousController){
        this.transportationManager=transportationManager;
        this.prevController=previousController;
        this.TransportationAbilitiesController=new TransportationAbilitiesController(transportationManager,this);
        nextController=this.TransportationAbilitiesController;
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
    TransportationAbilitiesController.setCurrentTransportation(currentTransportation);
    return nextController;
    }

    @Override
    public Controller previousController() {
        currentTransportation=transportationManager.getTransportationList().get(0);
        return prevController;
    }

    @Override
    public String print() {
        String output = "Select Transportation";
        return output;
    }
}
