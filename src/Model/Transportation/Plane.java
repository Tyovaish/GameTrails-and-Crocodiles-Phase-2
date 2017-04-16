package Model.Transportation;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Plane extends Transportation{
    String transportationType="plane";

    public Plane() {
        setBagSize(4);
        initResourceBag();
    }

    @Override
    public void getMovementAbilities() {}

    @Override
    public void getDropResourceAbilities() {}

    @Override
    public void getPickUpResourceAbilities() {}
}
