package Model;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TransporationSelectionController implements Controller {
    TransportationManager transportationManager;
    Transportation currentTransportation;
    ArrayList<Controller> controllerList;
    Controller nextController;
    Controller previousController;

    @Override
    public void getKeyPress(int keyPressed) {
        if(keyPressed>=0&&keyPressed<transportationManager.getTransportationList().size()){
            currentTransportation=transportationManager.getTransportationList().get(keyPressed);
        }
    }

    @Override
    public Controller nextController() {return nextController;
    }

    @Override
    public Controller previousController() {
        currentTransportation=transportationManager.getTransportationList().get(0);
        return previousController;
    }

    @Override
    public void print() {

    }
}
