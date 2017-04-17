package Model.Transportation;

import Model.Location.Location;
import Model.Movement.MovementManager;
import Model.Resource.ResourceBag;
import Model.Transportation.Transportation;

/**
 * Created by Trevor on 4/14/2017.
 */
public class Donkey extends Transportation {
    private int player;
    String transportationType="donkey";
    public Location location;

    public Donkey() {
        super();
        setBagSize(2);
        initResourceBag();
    }

    public Donkey(ResourceBag resourceBag) {
        super(resourceBag);
    }
    
    public void setPlayer(int player){this.player = player;}

    public int getPlayer(){return this.player;}
}
