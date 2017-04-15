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
    public ArrayList<Transportation> getTransportationList() {
                return transportationList;
    }


}
