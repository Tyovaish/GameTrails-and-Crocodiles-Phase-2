package Controller;

import Model.Transportation.Transportation;
import Model.Transportation.TransportationManager;

/**
 * Created by Trevor on 4/17/2017.
 */
public class TransportationStructureBuilder extends TransportationController {
    TransportationManager transportationManager;
    Controller prevController;
    Transportation currentTransportation;
    public TransportationStructureBuilder(TransportationManager transportationManager, Controller previousController) {
        this.transportationManager=transportationManager;
        prevController=previousController;
    }

    @Override
    public void getKeyPress(int keyPressed) {

    }

    @Override
    public Controller nextController() {
        return null;
    }

    @Override
    public Controller previousController() {
        return null;
    }

    @Override
    public String print() {
        return null;
    }

    @Override
    public void setCurrentTransportation(Transportation transportation) {
        currentTransportation=transportation;

    }

    @Override
    public String printType() {
        return null;
    }
}
