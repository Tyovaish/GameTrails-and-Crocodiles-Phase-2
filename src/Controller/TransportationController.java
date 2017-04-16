package Controller;

import Model.Transportation.Transportation;

/**
 * Created by Trevor on 4/16/2017.
 */
public abstract class TransportationController extends Controller{
    public abstract void setCurrentTransportation(Transportation transportation);
    public abstract String printType();
}
