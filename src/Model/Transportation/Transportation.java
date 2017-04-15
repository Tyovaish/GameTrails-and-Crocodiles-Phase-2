package Model.Transportation;

import Model.Abilities.*;
import Model.Movement.MovementManager;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public abstract class Transportation {
    MovementManager movementManager;
  ArrayList<MovementAbility> movementAbilities;
  ArrayList<PickUpResourceAbility> pickUpResourceAbilities;
  ArrayList<DropUpResourceAbility> dropUpResourceAbilities;
  ArrayList<ProduceStructureAbility> produceStructureAbilities;
  CarryResourceAbility carryResourceAbility;




 public void getMovementAbilities(){
        movementAbilities=movementManager.getMovementAbilities(this);
 }
 public void getDropResourceAbilities(){

 }
 public void getPickUpResourceAbilities(){

 }

  public void getAbilities(){
     getMovementAbilities();
     getPickUpResourceAbilities();
     getDropResourceAbilities();


     ArrayList<ArrayList<Ability>> listOfAbilities;

  }
  public void useAbility(Ability ability){
      ability.execute();
  }
}
