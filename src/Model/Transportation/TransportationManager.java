package Model.Transportation;

import Model.Location.TransportationLocation;
import Model.Transportation.Transportation;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TransportationManager {
    ArrayList<Transportation> transportationList;
    HashMap<Transportation,TransportationLocation> transportationLocations;
    TransportationManager(){
        transportationList=new ArrayList<Transportation>();
        transportationLocations=new HashMap<Transportation,TransportationLocation>();
    }
    public ArrayList<Transportation> getTransportationList() {
                return transportationList;
    }

    public TransportationLocation getTransportationLocation(Transportation transportation){
        return transportationLocations.get(transportation);
    }


}
