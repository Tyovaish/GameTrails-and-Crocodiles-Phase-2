package Model.Transportation;

import Model.Movement.MovementManager;
import Model.Resource.ResourceBag;
import Model.Transportation.Transportation;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Donkey extends Transportation {
    String transportationType="donkey";

    public Donkey() {
        super();
        setBagSize(2);
        initResourceBag();
        setType(TransportationEnum.DONKEY);
    }

    public Donkey(ResourceBag resourceBag) {
        super(resourceBag);
    }
}
