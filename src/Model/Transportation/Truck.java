package Model.Transportation;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Truck extends Transportation {
    String transportationType="truck";

    public Truck() {
        setBagSize(6);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {}

    @Override
    public void getDropResourceAbilities() {}

    @Override
    public void getPickUpResourceAbilities() {}
}
