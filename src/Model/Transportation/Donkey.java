package Model.Transportation;

import Model.Resource.ResourceBag;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Donkey extends Transportation {
    String transportationType="donkey";

    public Donkey() {
        setBagSize(2);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {
        movementManager.getMovementAbilities(this);
    }

    @Override
    public void getDropResourceAbilities() {

    }

    @Override
    public void getPickUpResourceAbilities() {

    }

}
