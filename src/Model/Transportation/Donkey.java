package Model.Transportation;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Donkey extends Transportation {
    String transportationType="donkey";

    @Override
    public void getMovementAbilities() {
        movementAbilities=movementManager.getMovementAbilities(this);
    }

}
