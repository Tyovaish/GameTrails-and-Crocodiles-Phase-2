package Model.Transportation;

import Model.Abilities.*;
import Model.Movement.MovementManager;
import Model.Resource.Resource;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.ResourceHolder;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public abstract class Transportation implements ResourceHolder{
    MovementManager movementManager;
  ArrayList<MovementAbility> movementAbilities;
  ArrayList<PickUpResourceAbility> pickUpResourceAbilities;
  ArrayList<DropUpResourceAbility> dropUpResourceAbilities;
  ArrayList<ProduceStructureAbility> produceStructureAbilities;
  CarryResourceAbility carryResourceAbility;

  ResourceBag resourceBag;
  int bagSize;

 public abstract void getMovementAbilities();
 public abstract void getDropResourceAbilities();
 public abstract void getPickUpResourceAbilities();
 public void addMovementAbilities(ArrayList<MovementAbility> movementAbilities){
     this.movementAbilities=movementAbilities;
 }

 public ResourceBag getResourceBag() { return resourceBag; }
 public void initResourceBag() { resourceBag = new ResourceBag(bagSize); }
 public int getBagSize() { return bagSize; }
 public void setBagSize(int bagSize) { this.bagSize = bagSize; }

    public void getAbilities(){
    getMovementAbilities();
     ArrayList<ArrayList<MovementAbility>> listOfAbilities=new ArrayList<>();
     listOfAbilities.add(movementAbilities);

  }
  public void useAbility(Ability ability){
      ability.execute();
  }

  // ResourceHolder
  public void addResource(Resource resource){ resourceBag.addResource(resource); }
  public Resource removeResource(ResourceEnum resource){ return resourceBag.removeResource(resource); }
}
