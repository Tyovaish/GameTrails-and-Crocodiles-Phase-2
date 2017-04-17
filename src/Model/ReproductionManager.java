package Model;

import Model.Livestock.Goose;
import Model.Resource.ResourceBag;
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
        ResourceBag resourceBag = new ResourceBag(2);
        Donkey babyDonkey = new Donkey(resourceBag);
    }
    public void reproduce(Goose goose){
        Goose babyGoose = new Goose();
    }
}
