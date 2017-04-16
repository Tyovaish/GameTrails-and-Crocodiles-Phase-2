package Model.Transportation;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Rowboat extends Transportation {
    String transportationType="rowboat";

    public Rowboat() {
        setBagSize(5);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {}

    @Override
    public void getDropResourceAbilities() {}

    @Override
    public void getPickUpResourceAbilities() {}
}
