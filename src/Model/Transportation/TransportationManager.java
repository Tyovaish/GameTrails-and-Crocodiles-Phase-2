package Model.Transportation;

import Model.Location.TransportationLocation;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Trevor on 4/14/2017.
 */
public class TransportationManager {
   private ArrayList<Transportation> transportationList;
    private HashMap<Transportation,TransportationLocation> transportationLocations;

    public TransportationManager(){
        transportationList=new ArrayList<Transportation>();
        transportationLocations=new HashMap<Transportation,TransportationLocation>();
    }

    public void addTransportation(Transportation transportation,TransportationLocation transportationLocation){
        transportationList.add(transportation);
        transportationLocations.put(transportation,transportationLocation);
    }
    public ArrayList<Transportation> getTransportationList() {
                return transportationList;
    }

    public TransportationLocation getTransportationLocation(Transportation transportation){
        return transportationLocations.get(transportation);
    }


}
