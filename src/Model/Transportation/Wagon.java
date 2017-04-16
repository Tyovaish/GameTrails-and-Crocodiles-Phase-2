package Model.Transportation;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Wagon extends Transportation {
    String transportationType="wagon";

    public Wagon() {
        setBagSize(3);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {}

    @Override
    public void getDropResourceAbilities() {}

    @Override
    public void getPickUpResourceAbilities() {}
}
