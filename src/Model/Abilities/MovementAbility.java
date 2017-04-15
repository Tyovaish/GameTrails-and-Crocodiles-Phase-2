package Model.Abilities;

import Model.Movement.MovementManager;
import Model.Location.TransportationLocation;
import Model.Transportation.Transportation;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public class MovementAbility implements Ability {
  TransportationLocation currentTransportationLocation;
  TransportationLocation nextTransportationLocation;

  public MovementAbility(TransportationLocation currentTransportationLocation, TransportationLocation nextTransportationLocation){
    this.currentTransportationLocation=currentTransportationLocation;
    this.nextTransportationLocation=nextTransportationLocation;
  }
  @Override
  public void execute() {
      currentTransportationLocation.setEqualTo(nextTransportationLocation);
  }

  @Override
  public void print() {

  }
}
