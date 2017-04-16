package Model.Transportation;

import Model.Abilities.*;
import Model.Location.Location;
import Model.Movement.MovementManager;
import Model.Resource.Resource;
import Model.Resource.ResourceBag;
import Model.Resource.ResourceEnum;
import Model.ResourceHolder;
import Model.Structure.StructureBuilder;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

/**
 * Created by Trevor on 4/14/2017.
 */
public abstract class Transportation implements ResourceHolder{
    protected MovementManager movementManager;
    protected ArrayList<MovementAbility> movementAbilities;
    protected ArrayList<PickUpResourceAbility> pickUpResourceAbilities;
    protected ArrayList<DropResourceAbility> dropResourceAbilities;
    protected ArrayList<ProduceStructureAbility> produceStructureAbilities;

    protected ResourceBag resourceBag;
    protected int bagSize;

    public Transportation(MovementManager movementManager){
    this.movementManager=movementManager;
    movementAbilities=new ArrayList<MovementAbility>();
    pickUpResourceAbilities=new ArrayList<PickUpResourceAbility>();
    dropResourceAbilities=new ArrayList<DropResourceAbility>();
    produceStructureAbilities=new ArrayList<ProduceStructureAbility>();

}


 public ResourceBag getResourceBag() { return resourceBag; }
 public void initResourceBag() { resourceBag = new ResourceBag(bagSize); }
 public int getBagSize() { return bagSize; }
 public void setBagSize(int bagSize) { this.bagSize = bagSize; }

 public  abstract void getMovementAbilities();
 private void getDropResourceAbilities(){
     dropResourceAbilities=new ArrayList<DropResourceAbility>();
     for(int i=0;i<resourceBag.getResourceList().size();i++){
         System.out.println("Current Resource In Bag To Drop: "+resourceBag.getResourceList().get(i));
         dropResourceAbilities.add(new DropResourceAbility(this.resourceBag,resourceBag.getResourceList().get(i)));
     }
 }
 private void getPickUpResourceAbilities(){

 }

 public ArrayList<MovementAbility> getMovementSet(){
     getMovementAbilities();
     return movementAbilities;
  }

  public ArrayList<PickUpResourceAbility> getPickUpResourceSet(){
      getPickUpResourceAbilities();
      return pickUpResourceAbilities;
 }
  public ArrayList<DropResourceAbility> getDropResourceSet(){
      getDropResourceAbilities();
      return dropResourceAbilities;
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
      else System.out.printf("Material not found in Transport bag!\n");
  }
  public String getType(){
      return "donkey";
  }
}
