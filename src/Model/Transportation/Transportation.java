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




 public abstract void getMovementAbilities();
 public abstract void getDropResourceAbilities();
 public abstract void getPickUpResourceAbilities();
 public void addMovementAbilities(ArrayList<MovementAbility> movementAbilities){
     this.movementAbilities=movementAbilities;
 }


  public void getAbilities(){
    getMovementAbilities();
     ArrayList<ArrayList<MovementAbility>> listOfAbilities=new ArrayList<>();
     listOfAbilities.add(movementAbilities);

  }
  public void useAbility(Ability ability){
      ability.execute();
  }
}
