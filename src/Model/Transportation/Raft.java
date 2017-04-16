package Model.Transportation;

/**
 * Created by khariollivierre on 4/15/17.
 */
public class Raft extends Transportation{
    String transportationType="raft";

    public Raft() {
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
