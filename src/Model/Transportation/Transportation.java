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
 public void getDropResourceAbilities(){

 }
 public void getPickUpResourceAbilities(){

 }

  public ArrayList<ArrayList<Ability>> getAbilities(){
    getMovementAbilities();
    ArrayList<ArrayList<Ability>> allAbilities=new ArrayList<ArrayList<Ability>>();
     ArrayList<MovementAbility> movementAbilities=new ArrayList<MovementAbility>();
     allAbilities.get(0).addAll(movementAbilities);
     return allAbilities;
  }
  public void useAbility(Ability ability){
      ability.execute();
  }
}
