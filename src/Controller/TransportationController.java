package Model;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/15/2017.
 */
public class TransportationController implements Controller {
    Transportation currentTransportation;
    ArrayList<ArrayList<Ability>> currentAbilities;
    int currentAbility=0;
    int currentSubAbility=0;


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
    public void print() {

    }
}
