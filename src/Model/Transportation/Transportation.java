package Model.Transportation;

import Model.Abilities.*;
import Model.Movement.MovementManager;
import Model.Resource.Resource;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.ResourceHolder;
import Model.Structure.StructureBuilder;

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

  ResourceBag resourceBag;
  int bagSize;
Transportation(MovementManager movementManager){
    this.movementManager=movementManager;
    movementAbilities=new ArrayList<MovementAbility>();
}


 public ResourceBag getResourceBag() { return resourceBag; }
 public void initResourceBag() { resourceBag = new ResourceBag(bagSize); }
 public int getBagSize() { return bagSize; }
 public void setBagSize(int bagSize) { this.bagSize = bagSize; }

 public  abstract void getMovementAbilities();
 public void addMovementAbilities(ArrayList<MovementAbility> movementAbilities){ this.movementAbilities=movementAbilities; }
 public void getDropResourceAbilities(){}
 public void getPickUpResourceAbilities(){}
  public ArrayList<MovementAbility> getMovementSet(){
     getMovementAbilities();
     return movementAbilities;
  }
  public void useAbility(Ability ability){
      ability.execute();
  }

  // ResourceHolder
  public void addResource(Resource resource){ resourceBag.addResource(resource); }
  public Resource removeResource(ResourceEnum resource){ return resourceBag.removeResource(resource); }
  public void giveMaterial(StructureBuilder builder, ResourceEnum resource){
      Resource material = removeResource(resource);
      if (material != null) builder.addMaterial(material);
      else System.out.printf("Material not found in bag!\n");
  }
  public String getType(){
      return "donkey";
  }
}
