package Model.Transportation;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Steamer extends Transportation {
    String transportationType="steamer";

    public Steamer() {
        setBagSize(8);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {}

    @Override
    public void getDropResourceAbilities() {}

    @Override
    public void getPickUpResourceAbilities() {}
}
