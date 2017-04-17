package Model.Livestock;

import Model.Location.Location;
import Model.Transportation.Transportation;

/**
 * Created by Larry on 4/17/2017.
 */
public class Goose extends Livestock {
    public Location location;
    private String livestockType = "goose";

    public void attemptReproduction(Goose goose){
        //check if goose is in the same Location as another Goose and nothing else
    }


    /*public void followTransportation(Transportation transportation){
        if(transportation.getLocation == this.location){
            //ask transportation player if it wants it to follow
            //move with transportation
        }
    }*/

}

