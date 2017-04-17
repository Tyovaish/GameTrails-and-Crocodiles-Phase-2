package Model;

import Model.Livestock.Goose;
import Model.Resource.ResourceManager;
import Model.Transportation.Donkey;
import Model.Transportation.TransportationManager;

/**
 * Created by Larry on 4/17/2017.
 */
public class ReproductionManager {

    private TransportationManager transportationManager;
    private ResourceManager resourceManager;

    public void reproduce(Donkey donkey){
        Donkey babyDonkey = new Donkey();
    }
    public void reproduce(Goose goose){
        Goose babyGoose = new Goose();
        babyGoose.location = goose.location;
        babyGoose.setPlayer(goose.getPlayer());
    }
}
