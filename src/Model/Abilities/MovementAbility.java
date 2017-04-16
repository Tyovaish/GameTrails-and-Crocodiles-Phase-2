package Model.Abilities;

import Model.Movement.MovementManager;
import Model.Location.TransportationLocation;
import Model.Resource.Resource;
import Model.Transportation.Transportation;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class MovementAbility implements Ability {
  ResourceBag resourceBag;
  TransportationLocation currentTransportationLocation;
  TransportationLocation nextTransportationLocation;

  public MovementAbility(TransportationLocation currentTransportationLocation, TransportationLocation nextTransportationLocation,ResourceBag resourceBag){
    this.currentTransportationLocation=currentTransportationLocation;
    this.nextTransportationLocation=nextTransportationLocation;
    this.resourceBag=resourceBag;
  }
  @Override
  public void execute() {
    resourceBag.carry(nextTransportationLocation);
    currentTransportationLocation.setEqualTo(nextTransportationLocation);
  }
  public void setResourceBag(ResourceBag resourceBag){
    this.resourceBag=resourceBag;
  }

  @Override
  public void print() {

  }
}
